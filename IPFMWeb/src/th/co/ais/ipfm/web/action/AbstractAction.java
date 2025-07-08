package th.co.ais.ipfm.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.jboss.remoting.transport.coyote.ClientAbortException;
import org.richfaces.component.html.HtmlColumn;
import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.Ordering;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain1.IpNetworkConfig;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrAttachmentId;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IpUrAttachmentService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public abstract class AbstractAction {
	public abstract String init();

	public abstract boolean validate();

	public abstract String init(String programID);

	public static String getRequestParameter(String name) {
		String str = null;
		str = (String) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(name);
		if (str == null || str.trim().length() == 0) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ServletRequest request = (ServletRequest) facesContext
					.getExternalContext().getRequest();
			str = (String) request.getAttribute(name);
		}
		return str;
	}

	public static SortColumnBean getRequestParameterBean(ActionEvent event,String name) {
		return (SortColumnBean) event.getComponent().getAttributes().get(name);
	}

	public static IPFMConfigBean getIPFMConfig() {
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean) JSFServiceFinderUtil
				.getInstance().getBean("ipfmConfigBean");
		return ipfmConfigBean;
	}

	public static void setRequestParameter(String key, String value) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletRequest request = (ServletRequest) facesContext
				.getExternalContext().getRequest();
		request.setAttribute(key, value);
	}

	public void onChangeComboBox(IPFMRichComboItem comboItem) {
		if (comboItem == null) {
			comboItem = new IPFMRichComboItem();
		}
	}

	public void alertErrorMsg(ActionEvent event) {
		String errorMessage = getRequestParameter("errorMessage");
		IPFMMessageUtils.addMessageError(errorMessage);
	}

	public void alertErrorMsg() {
		String errorMessage = getRequestParameter("errorMessage");
		IPFMMessageUtils.addMessageError(errorMessage);
	}

	public String download() {
		try {
			String path = getRequestParameter("path");
			String fileName = getRequestParameter("fileName");
			File file = new File(path, fileName);
			if (!file.isFile())
				IPFMMessageUtils.addMessageError(IPFMDataUtility
						.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
			else
				downloadFile(path, fileName);
		} catch (FileNotFoundException fex) {
			IPFMMessageUtils.addMessageError(fex.getMessage());
		} catch (Exception ex) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}

	public void deleteFile() {

	}

	public void downloadFile(String path, String fileName) throws Exception {
		// Prepare.
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		try {
			while (true) {
				response = (HttpServletResponse) PropertyUtils.getProperty(
						response, "response");
			}

		} catch (NoSuchMethodException e1) {
			// nothing to do
			// we are at org.apache.catalina.connector.ResponseFacade
		} catch (IllegalAccessException e) {
			// e.printStackTrace();
		} catch (InvocationTargetException e) {
			// e.printStackTrace();
		} catch (IllegalStateException e) {

		}
		File file;
		if (path != null && path.trim().length() > 0)
			file = new File(path, fileName);
		else
			file = new File(fileName);
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try {
			// Open file.
			input = new BufferedInputStream(new FileInputStream(file));

			// Init servlet response.
			response.reset();
			response.setContentType("application/octet-stream");
			response.setContentLength((int) file.length());
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ fileName + "\"");
			output = new BufferedOutputStream(response.getOutputStream());

			// Write file contents to response.
			byte[] buffer = new byte[IPFMConstant.DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			// Finalize task.
			output.flush();
		} catch (SocketException e) {

		} catch (ClientAbortException cx) {

		} catch (FileNotFoundException fex) {
			fex.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		} catch (Exception ex) {
			ex.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		} finally {
			// Gently close streams.
			close(output);
			close(input);
		}

		// Inform JSF that it doesn't need to handle response.
		// This is very important, otherwise you will get the following
		// exception in the logs:
		// java.lang.IllegalStateException: Cannot forward after response has
		// been committed.
		facesContext.responseComplete();
	}

	private void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void unsortedAllColumnRichDataTable(HtmlDataTable richDataTable) {
		List richColumnList = richDataTable.getChildren();
		// System.out.println("richColumnList.size() = " +
		// richColumnList.size());
		for (int index = 0; index < richColumnList.size(); index++) {
			Object obj = richColumnList.get(index);
			if (obj.getClass() == HtmlColumn.class) {
				HtmlColumn column = (HtmlColumn) obj;
				column.setSortOrder(Ordering.UNSORTED);
			}
		}
	}

	public void uploadAttachFile(UploadEvent event) {
		try {
			// System.out.println("====== uploadDiagram ======");
			UploadItem item = event.getUploadItem();
			// System.out.println("file = "+item.getFile());
			// System.out.println("fileName = "+item.getFile().getName());
			String yearFolder = IPFMUtils
					.changeDateFormat(IPFMUtils.currentDate("dd/MM/yyyy"),
							"dd/MM/yyyy", "yyyyMM");
			String filename = item.getFileName();
			String urNO = getRequestParameter("urNo");
			String catagory = getRequestParameter("category");
			String description = getRequestParameter("description");
			String userId = getRequestParameter("userId");
			// System.out.println("filename = "+filename);
			// System.out.println("urNO = "+urNO);
			// System.out.println("catagory = "+catagory);
			// System.out.println("description = "+description);
			// System.out.println("userId = "+userId);
			// System.out.println("yearFolder = "+yearFolder);
			attachFile(item, urNO, yearFolder, filename, catagory, description,
					userId);
		} catch (Exception ex) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}

	public void attachFile(UploadItem item, String urNO, String yearFolder,
			String filename, String catagory, String description, String userId)
			throws IOException {
		BufferedOutputStream outputFile = null;
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean) JSFServiceFinderUtil
				.getInstance().getBean("ipfmConfigBean");
		String savePath = ipfmConfigBean.getAttachPath();
		String path = savePath + "/" + yearFolder + "/" + urNO + "/" + catagory;
		String destFile = path + "/" + filename;
		File destFolder = new File(path);
		if (!destFolder.exists())
			destFolder.mkdir();

		if (item.isTempFile()) {
			System.out
					.println("Uploaded file is stored in the temporary folder (depends on OS)");
			System.out.println("TempFile AbsolutePath = "
					+ item.getFile().getAbsolutePath());
			File copyTo = new File(destFile);
			FileUtils.moveFile(item.getFile(), copyTo);
			System.out.println("Move Upload file successful");
		} else {
			System.out.println("Uploaded file is stored in the RAM");
			outputFile = new BufferedOutputStream(new FileOutputStream(path
					+ filename));
			outputFile.write(item.getData());
			outputFile.close();
			outputFile = null;
			System.out.println("Upload file successful");
		}
		IpUrAttachmentService attachmentService = (IpUrAttachmentService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrAttachmentService");
		IpUrAttachment attach = attachmentService.findAttachment(urNO,
				filename, catagory);
		if (attach != null) {
			String deleteStr = attach.getFileLocation() + "/"
					+ attach.getFileName();
			File deleteFile = new File(deleteStr);
			System.out.println("I will Delete >>" + deleteStr);
			if (deleteFile.exists()) {
				if (deleteFile.delete()) {
					System.out.println("Delete >>" + deleteFile.getName());
					try {
						attachmentService.deleteAttachmentFile(attach);
					} catch (IPFMBusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		IpUrAttachment attachFile = new IpUrAttachment();
		IpUrAttachmentId id = new IpUrAttachmentId(urNO, null, catagory);
		attachFile.setId(id);
		attachFile.setDescription(description);
		attachFile.setFileLocation(path);
		attachFile.setFileName(filename);
		attachFile.setCreatedBy(userId);
		attachFile.setLastUpdBy(userId);
		attachmentService.saveAttachFile(attachFile);
	}

	public void attachFileLogo(UploadItem item) throws Exception {
		BufferedOutputStream outputFile = null;
		try {
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean) JSFServiceFinderUtil
					.getInstance().getBean("ipfmConfigBean");
			String savePath = ipfmConfigBean.getAttachPath();
			// String savePath = "C:/TEMP";
			String logoPath = ipfmConfigBean.getLogoPath();
			String logoBackupPath = ipfmConfigBean.getLogoBackupPath();

			String path = savePath + "/" + logoPath;
			String backupPath = savePath + "/" + logoBackupPath;

			String filename = "header_temp"; // header_temp.jpg
			String destFolder = path + "/" + filename + ".jpg";
			String dateBackup = IPFMDataUtility.toStringEngDateBySimpleFormat(
					IPFMDataUtility.getCurrentDate(), "yyyyMMdd");
			String backupFolder = backupPath + "/" + filename + "_"
					+ dateBackup + ".jpg";

			File destFile = new File(path);
			File backupFile = new File(backupPath);

			if (!destFile.exists())
				destFile.mkdir();
			if (!backupFile.exists())
				backupFile.mkdir();

			if (destFile.exists()) {// check backup
				File backUpTo = new File(backupFolder);
				FileUtils.moveFile(destFile, backUpTo);
			}

			if (item.isTempFile()) {
				System.out
						.println("Uploaded file is stored in the temporary folder (depends on OS)");
				System.out.println("TempFile AbsolutePath = "
						+ item.getFile().getAbsolutePath());
				File copyTo = new File(destFolder);
				FileUtils.moveFile(item.getFile(), copyTo);
				System.out.println("Move Upload file successful");
			} else {
				System.out.println("Uploaded file is stored in the RAM");
				outputFile = new BufferedOutputStream(new FileOutputStream(
						destFolder));
				outputFile.write(item.getData());
				outputFile.close();
				outputFile = null;
				System.out.println("Upload file successful");
			}
		} catch (IPFMBusinessException ipfme) {
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		} finally {
			if (item != null && item.isTempFile() && item.getFile().isFile()) {
				item.getFile().delete();
			}
			item = null;
		}
	}

	protected void clearSessionNotUsed() {
		// clear non use session bean
		Map map = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		if (map != null) {
			map.remove("fileAttachAction");
			map.remove("attachFileNWAction");
			map.remove("attachFileAFAction");
			map.remove("notifyProgramID");
			map.remove("HOME");
			map.remove("fromPage");
			map.remove("fileUploadBean");
			map.remove("groupIPBean");
			map.remove("ipLevel1Bean");
			map.remove("ipLevel2Bean");
			map.remove("ipLevel3Bean");
			map.remove("inboxBean");
			map.remove("menuAuthenticationBean");
			map.remove("masterTableBean");
			map.remove("manageDataIPBean");
			map.remove("networkConfigBean");
			map.remove("parameterManageBean");
			map.remove("planningReqIPBean");
			map.remove("rangeIPBean");
			map.remove("rangeIPDataBean");
			map.remove("systemParameterBean");
			map.remove("systemParameterFileUploadBean");
			map.remove("searchIPBean");
			map.remove("searchURBean");
			map.remove("tabControlAction");
			map.remove("teamManageBean");
			map.remove("userProfileBean");
			map.remove("userReqIPBean");
			map.remove("userGroupManageBean");
			map.remove("wfBean");
			map.remove("wfUserBean");
			map.remove("workflowManageBean");
		}

	}

	public String perform(String actionName, String programID) throws Exception {
		String returnPage = null;
		try {
			if (actionName != null) {
				// logger.debug("clear session not use");
				clearSessionNotUsed();
				// logger.debug(actionName);
			} else {
				// logger.debug("NO Action Name!");
			}
			Object o = Class.forName(actionName.trim()).newInstance();
			System.out.println("init to >> [" + programID + "] " + actionName);
			returnPage = ((AbstractAction) o).init(programID);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return returnPage;
	}

	public boolean isRejecMode(ReqNWConfigBean bean) {
		if (bean == null) {
			return false;
		}
		IpUrNwConfig nwCfg = bean.getNetworkConfig();
		if (nwCfg == null) {
			return false;
		} else {
			if (nwCfg.getUrStatusTxt() != null
					&& (nwCfg.getUrStatusTxt().contains("REJECT") || nwCfg
							.getUrStatusTxt().contains("DRAFT"))) {
				return true;
			} else {
				return false;
			}

		}

	}
	
	public SortColumnBean sortColumnChange() {
		
		SortColumnBean sc = new SortColumnBean();
		String sortColumn = getRequestParameter("sortColumn");
		String i = getRequestParameter("sortColumnNo");
		
		if(i.equals("1")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn1(Ordering.DESCENDING.name());
			else  sc.setSortColumn1(Ordering.ASCENDING.name());
		} else if(i.equals("2")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn2(Ordering.DESCENDING.name());
			else  sc.setSortColumn2(Ordering.ASCENDING.name());
		}else if(i.equals("3")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn3(Ordering.DESCENDING.name());
			else  sc.setSortColumn3(Ordering.ASCENDING.name());
		}else if(i.equals("4")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn4(Ordering.DESCENDING.name());
			else  sc.setSortColumn4(Ordering.ASCENDING.name());
		}else if(i.equals("5")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn5(Ordering.DESCENDING.name());
			else  sc.setSortColumn5(Ordering.ASCENDING.name());
		}else if(i.equals("6")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn6(Ordering.DESCENDING.name());
			else  sc.setSortColumn6(Ordering.ASCENDING.name());
		}  else if(i.equals("7")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn7(Ordering.DESCENDING.name());
			else  sc.setSortColumn7(Ordering.ASCENDING.name());
		}  else if(i.equals("8")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn8(Ordering.DESCENDING.name());
			else  sc.setSortColumn8(Ordering.ASCENDING.name());
		}  else if(i.equals("9")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn9(Ordering.DESCENDING.name());
			else  sc.setSortColumn9(Ordering.ASCENDING.name());
		}  else if(i.equals("10")) {
			if((sortColumn!=null) && (sortColumn.equals("ASCENDING"))) 
				sc.setSortColumn10(Ordering.DESCENDING.name());
			else  sc.setSortColumn10(Ordering.ASCENDING.name());
		}  
		return sc;
	}
	
	public void downloadFile(String fileName,byte[] data) throws Exception{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		try {
			while (true) {
				response = (HttpServletResponse) PropertyUtils.getProperty(
						response, "response");
			}

		} catch (NoSuchMethodException e1) {
			// nothing to do
			// we are at org.apache.catalina.connector.ResponseFacade
		} catch (IllegalAccessException e) {
			// e.printStackTrace();
		} catch (InvocationTargetException e) {
			// e.printStackTrace();
		} catch (IllegalStateException e) {

		}
		BufferedOutputStream output = null;
		try {
			if(data != null){
				// Open file.
	//			input = new BufferedInputStream(new FileInputStream(file));
	
				// Init servlet response.
				response.reset();
				response.setContentType("application/octet-stream");
				response.setContentLength((int) data.length);
				response.setHeader("Content-disposition", "attachment; filename=\""+ fileName + "\"");
				output = new BufferedOutputStream(response.getOutputStream());
	
				// Write file contents to response.
				byte[] buffer = new byte[IPFMConstant.DEFAULT_BUFFER_SIZE];
				output.write(data);
				
				// Finalize task.
				output.flush();
			}
		} catch (SocketException e) {

		} catch (ClientAbortException cx) {

		} catch (FileNotFoundException fex) {
			fex.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		} catch (Exception ex) {
			ex.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		} finally {
			// Gently close streams.
			close(output);
		}

		facesContext.responseComplete();	
	}
}
