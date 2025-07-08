package th.co.ais.ipfm.web.master.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IIPParameterService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.File;
import th.co.ais.ipfm.web.master.bean.SystemParameterBean;
import th.co.ais.ipfm.web.master.bean.SystemParameterFileUploadBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class SystemParameterAction extends AbstractAction {
	
	/********************** Bean ***********************/
	public SystemParameterBean systemParameterBean;
	public SystemParameterFileUploadBean systemParameterFileUploadBean;
	
	public SystemParameterFileUploadBean getSystemParameterFileUploadBean() {
		return (SystemParameterFileUploadBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("systemParameterFileUploadBean");
	}

	public void setSystemParameterFileUploadBean(
			SystemParameterFileUploadBean systemParameterFileUploadBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("systemParameterFileUploadBean", systemParameterFileUploadBean);
	}

	public SystemParameterBean getSystemParameterBean() {
		return (SystemParameterBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("systemParameterBean");
	}

	public void setSystemParameterBean(SystemParameterBean systemParameterBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("systemParameterBean", systemParameterBean);
	}

	@Override
	public String init(String programID) {
		IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
		if(ipParameterService!=null){
			try {
				List<SelectItem> groupList = new ArrayList<SelectItem>();
				List<String> groupStringList = ipParameterService.getParameterGroupList();
				if(groupStringList!=null && groupStringList.size()>0){
					for (String str:groupStringList) {
						groupList.add(new SelectItem(str,str));
					}
				}
				
				List<SelectItem> subGroupList = new ArrayList<SelectItem>();
				SystemParameterBean	systemParameterBean = new SystemParameterBean();
				systemParameterBean.setGroupList(groupList);
				systemParameterBean.setSubGroupList(subGroupList);
				setSystemParameterBean(systemParameterBean);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return programID;
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		systemParameterBean = getSystemParameterBean();
		if(TablSort.equalsIgnoreCase("systemParameterTable")) {
			systemParameterBean.setSortSys(sortColumnChange());	
		} 
		return "";
	}

	@Override
	public String init() {
		return null;
	}
	public void search(){
		SystemParameterBean systemParameterBean = getSystemParameterBean();
		if(systemParameterBean!=null){
			SearchResult searchResult = null;
			IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");			
			try {
//				ipParameterList = ipParameterService.searchIPParameter(systemParameterBean.getGroup(), systemParameterBean.getSubGroup());
				searchResult = ipParameterService.searchIPParameter(systemParameterBean.getGroup(), systemParameterBean.getSubGroup(), systemParameterBean.getMaxSearchResult());
				systemParameterBean.setIpParameterList(searchResult.getResultList());
				if(searchResult.isOverMaxResultLimit()){
					IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0014")));	
				}
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setSystemParameterBean(systemParameterBean);
		}
	}
	
	public void clear(){
		SystemParameterBean systemParameterBean = getSystemParameterBean();
		List<SelectItem> subGroupList = new ArrayList<SelectItem>();
		systemParameterBean.setSubGroupList(subGroupList);
		systemParameterBean.setGroup(null);
		systemParameterBean.setSubGroup(null);
		systemParameterBean.setIpParameterList(null);
		setSystemParameterBean(systemParameterBean);
	}

	public void clickReImport(){
		clearUploadData();
		//return "system_parameter_import";
	}
	
	public String clickImport(){
		clearUploadData();
		return "system_parameter_import";
	}	
	
	public String clickAdd(){
		IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
		if(ipParameterService!=null){
			try {
				List<SelectItem> groupList = new ArrayList<SelectItem>();
				List<String> groupStringList = ipParameterService.getParameterGroupList();
				if(groupStringList!=null && groupStringList.size()>0){
					for (String str:groupStringList) {
						groupList.add(new SelectItem(str,str));
					}
				}
				
				List<SelectItem> subGroupList = new ArrayList<SelectItem>();
				SystemParameterBean	systemParameterBean = new SystemParameterBean();
				systemParameterBean.setGroupList(groupList);
				systemParameterBean.setSubGroupList(subGroupList);
				systemParameterBean.setGroup(null);
				systemParameterBean.setIpParameter(new IPParameter());
				systemParameterBean.getIpParameter().setBooleanValue("F");
				systemParameterBean.setIpParameterList(null);
				systemParameterBean.setRowId(null);
				systemParameterBean.setSubGroup(null);
				systemParameterBean.setDisabledForEdit(false);
				systemParameterBean.setDisplayForEdit(false);
				systemParameterBean.setDisplayForCreate(true);
				setSystemParameterBean(systemParameterBean);				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return "system_parameter_detail";
	}	
	
	public void updateValueBeforeDelete(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		SystemParameterBean systemParameterBean = getSystemParameterBean();
		systemParameterBean.setRowId(rowId);
		setSystemParameterBean(systemParameterBean);

	}
		
	public void changeGroup(){
		SystemParameterBean systemParameterBean = getSystemParameterBean();
		List<SelectItem> subGroupList = new ArrayList<SelectItem>();		
		if(systemParameterBean!=null){
			if(systemParameterBean.getGroup()!=null && systemParameterBean.getGroup().trim().length()>0){
				IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
				if(ipParameterService!=null){
					try {
						List<String> subGroupStringList = ipParameterService.getParameterSubGroupList(systemParameterBean.getGroup());
						if(subGroupStringList!=null && subGroupStringList.size()>0){
							for(String str:subGroupStringList){
								subGroupList.add(new SelectItem(str,str));
							}
						}
					} catch (IPFMBusinessException e) {
						e.printStackTrace();
					}
				}
			}
			systemParameterBean.setSubGroup(null);
			systemParameterBean.setSubGroupList(subGroupList);
			setSystemParameterBean(systemParameterBean);	
		}
	}
	
	public void checkMaxlength(){
		String maxlength = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("maxlength").toString();
		if(maxlength!=null && maxlength.trim().length()>0){
			SystemParameterBean systemParameterBean = getSystemParameterBean();
			if(systemParameterBean!=null && systemParameterBean.getIpParameter()!=null 
					&& systemParameterBean.getIpParameter().getParameterGroup()!=null
					&& systemParameterBean.getIpParameter().getParameterGroup().trim().length()>Integer.parseInt(maxlength)){
				systemParameterBean.getIpParameter().setParameterGroup(systemParameterBean.getIpParameter().getParameterGroup().substring(0, Integer.parseInt(maxlength)));
				setSystemParameterBean(systemParameterBean);
			}
		}
	}
	
	public void delete(){
		SystemParameterBean systemParameterBean = getSystemParameterBean();
		if(systemParameterBean!=null && systemParameterBean.getRowId()!=null && systemParameterBean.getRowId().trim().length()>0){
			IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
			try {
				List<IPParameter> ipParameterList = ipParameterService.deleteAndReSearchIPParameter(systemParameterBean.getRowId(), systemParameterBean.getGroup(), systemParameterBean.getSubGroup());
				systemParameterBean.setIpParameterList(ipParameterList);
				setSystemParameterBean(systemParameterBean);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String initUpdate(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
		if(ipParameterService!=null && rowId!=null){
			try {
				List<SelectItem> groupList = new ArrayList<SelectItem>();
				List<String> groupStringList = ipParameterService.getParameterGroupList();
				if(groupStringList!=null && groupStringList.size()>0){
					for (String str:groupStringList) {
						groupList.add(new SelectItem(str,str));
					}
				}
				
				List<SelectItem> subGroupList = new ArrayList<SelectItem>();
				SystemParameterBean	systemParameterBean = new SystemParameterBean();
				systemParameterBean.setGroupList(groupList);
				systemParameterBean.setSubGroupList(subGroupList);
				systemParameterBean.setGroup(null);
				IPParameter ipParameter = ipParameterService.getIPParameter(rowId);
				systemParameterBean.setIpParameter(ipParameter);
				systemParameterBean.setIpParameterList(null);
				systemParameterBean.setRowId(rowId);
				systemParameterBean.setSubGroup(null);
				systemParameterBean.setDisabledForEdit(true);
				systemParameterBean.setDisplayForEdit(true);
				systemParameterBean.setDisplayForCreate(false);
				setSystemParameterBean(systemParameterBean);				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return "system_parameter_detail";
	}
	
	public void createSystemParameter(){
		SystemParameterBean systemParameter = getSystemParameterBean(); 
		try {
			if(validate()){
				IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
				IPParameter ipParameter = systemParameter.getIpParameter();
				ipParameter.setCreatedBy(IPFMWebUtil.getUserId());
				ipParameter.setLastUpdBy(ipParameter.getCreatedBy());
				ipParameter = ipParameterService.createIPParameter(ipParameter);
				systemParameter.setIpParameter(ipParameter);
				systemParameter.setDisabledForEdit(true);
				systemParameter.setDisplayForCreate(false);
				systemParameter.setDisplayForEdit(true);
				setSystemParameterBean(systemParameter);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}			
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}

	public void updateSystemParameter(){
		try {
			if(validate()){
				IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
				SystemParameterBean systemParameter = getSystemParameterBean(); 
				IPParameter ipParameter = systemParameter.getIpParameter();
				ipParameter.setLastUpdBy(ipParameter.getCreatedBy());
				ipParameter = ipParameterService.updateIPParameter(ipParameter);
				systemParameter.setIpParameter(ipParameter);
				systemParameter.setDisabledForEdit(true);
				systemParameter.setDisplayForCreate(false);
				systemParameter.setDisplayForEdit(true);
				setSystemParameterBean(systemParameter);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
		} catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}	
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		SystemParameterBean systemParameterBean = getSystemParameterBean();
		if(!(systemParameterBean.getIpParameter().getParameterGroup()!=null && systemParameterBean.getIpParameter().getParameterGroup().trim().length()>0)){
			IPFMMessageUtils.addMessageError("DetailForm:group", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Group"));
			flgValid = false;
		}
		return flgValid;
	}
	
	public String cancel(){
		return init();
	}
	
    public void listener(UploadEvent event) throws Exception{
    	SystemParameterFileUploadBean systemParameterFileUploadBean = getSystemParameterFileUploadBean();
    	UploadItem item = event.getUploadItem();
        if(item!=null && item.getData()!=null){
            File file = new File();
            file.setLength(item.getData().length);
            file.setName(item.getFileName());
            file.setData(item.getData());
            systemParameterFileUploadBean.getFiles().add(file);
            systemParameterFileUploadBean.setUploadsAvailable(systemParameterFileUploadBean.getUploadsAvailable()-1);
        }
        setSystemParameterFileUploadBean(systemParameterFileUploadBean);
    }  
    
    public void paint(OutputStream stream, Object object) throws IOException {
    	SystemParameterFileUploadBean systemParameterFileUploadBean = getSystemParameterFileUploadBean();
    	stream.write(systemParameterFileUploadBean.getFiles().get((Integer)object).getData());
    }
      
    public void clearUploadData() {
    	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("systemParameterFileUploadBean");
    	SystemParameterFileUploadBean systemParameterFileUploadBean = new SystemParameterFileUploadBean();
    	setSystemParameterFileUploadBean(systemParameterFileUploadBean);
    }
    

}
