package th.co.ais.ipfm.web.manage.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentDto;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IpSubUrAttachmentService;
import th.co.ais.ipfm.service.IpUrAttachmentService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;


public class AttachFileAction {
	
	private List<IpUrAttachment> listAttach;
	private List<IpSubUrAttachmentDto> listSubAttach;
	private Boolean errorFlag;
	private String errorMsg;
	private String confirmMsg;
	
public ReqNWConfigBean networkConfigBean;
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}


	public AttachFileAction(){
		setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0033")));
		setConfirmMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("CF0001")));
	}

	public void refresh(){
		//AttachFileBean bean = getFileAttachBean();
		String urNo = getRequestParameter("urNo");
		IpUrAttachmentService attachmentService = (IpUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		List<IpUrAttachment> listFile = attachmentService.listFilesByUrNo(urNo); 
		setListAttach(listFile);
		
		List<IpSubUrAttachmentDto> subAttachFile = new ArrayList<IpSubUrAttachmentDto>();
		try{
			IpSubUrAttachmentService ipSubUrAttachmentService = (IpSubUrAttachmentService) JSFServiceFinderUtil.getInstance().getBean("ipSubUrAttachmentService");
			subAttachFile = ipSubUrAttachmentService.getByUrNo(urNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		setListSubAttach(subAttachFile);
		
	}
	
	public void refreshByCategory(){
		String urNo = getRequestParameter("urNo");
		String category = getRequestParameter("category");
		IpUrAttachmentService attachmentService = (IpUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		setListAttach(attachmentService.listFilesByCategory(urNo,category));
	}
	
	public void delete(){
		String urNo = getRequestParameter("urNo");
		String seq = getRequestParameter("seqNo");
		IpUrAttachmentService attachmentService = (IpUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		IpUrAttachment fileAttach = attachmentService.findAttatchment(urNo, seq);
		File fp = new File(fileAttach.getFileLocation()+"/"+fileAttach.getFileName());
		System.out.println("Delete File >> "+fp.getName());
		if(fp.delete())
			try {
				attachmentService.deleteAttachmentFile(fileAttach);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		setListAttach(attachmentService.listFilesByUrNo(urNo));
	}
	
	public void deleteSub(){
		String urNo = getRequestParameter("urNo");
		//String subUrNo = getRequestParameter("subUrNo");
		String fileName = getRequestParameter("fileName");
		String catagory = getRequestParameter("category");
		try{
		IpSubUrAttachmentService attachmentService = (IpSubUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipSubUrAttachmentService");
		IpSubUrAttachment fileAttach = attachmentService.findByFileName(urNo, fileName, catagory);
		if(fileAttach != null && fileAttach.getId() != null && fileAttach.getId().getFileName() != null){
			File fp = new File(fileAttach.getFileLocation()+"/"+fileAttach.getId().getFileName());
			if(fp.delete())
				try {
					attachmentService.deleteIpUrAttachment(urNo, fileAttach.getId().getFileName(), catagory);
				} catch (IPFMBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			setListSubAttach(attachmentService.getByUrNo(urNo));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public void deleteByCategory(){
		String urNo = getRequestParameter("urNo");
		String seq = getRequestParameter("seqNo");
		String category = getRequestParameter("category");
		System.out.println("urNo = "+urNo);
		System.out.println("seq = "+seq);
		System.out.println("category = "+category);
		IpUrAttachmentService attachmentService = (IpUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		IpUrAttachment fileAttach = attachmentService.findAttatchment(urNo, seq);
		File fp = new File(fileAttach.getFileLocation()+"/"+fileAttach.getFileName());
		System.out.println("fileAttach.getFileLocation() = "+fileAttach.getFileLocation());
		System.out.println("fileAttach.getFileName() = "+fileAttach.getFileName());
		System.out.println("Delete File >> "+fp.getName());
		if(fp.delete())
			try {
				attachmentService.deleteAttachmentFile(fileAttach);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		setListAttach(attachmentService.listFilesByCategory(urNo,category));
	}
	
	public String getErrorMsg() {
		//return IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0033"));
		return this.errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get(name);
    }

	public List<IpUrAttachment> getListAttach() {
		return listAttach;
	}

	public void setListAttach(List<IpUrAttachment> listAttach) {
		this.listAttach = listAttach;
	}

	public String getConfirmMsg() {
		return this.confirmMsg;
	}

	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}
	
	public Boolean getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(Boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public void setMessageError(){
		String errNo = getRequestParameter("errNo");
		setErrorFlag(true);
		setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage(errNo)));
	}

	public List<IpSubUrAttachmentDto> getListSubAttach() {
		return listSubAttach;
	}

	public void setListSubAttach(List<IpSubUrAttachmentDto> listSubAttach) {
		this.listSubAttach = listSubAttach;
	}
	
	
	
}
