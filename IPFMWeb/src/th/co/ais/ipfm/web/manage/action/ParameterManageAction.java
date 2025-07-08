package th.co.ais.ipfm.web.manage.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IIPParameterService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.ParameterManageBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class ParameterManageAction extends AbstractAction {
	
	public ParameterManageBean parameterManageBean;
	
	
	public ParameterManageBean getParameterManageBean() {
		return (ParameterManageBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("parameterManageBean");
	}

	public void setParameterManageBean(ParameterManageBean parameterManageBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("parameterManageBean", parameterManageBean);
	}

	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		parameterManageBean = getParameterManageBean();		
		if(TablSort.equalsIgnoreCase("systemParameterTable")) {
			parameterManageBean.setSortIpUrs014(sortColumnChange());	
		}  		
		
		return "";
	}
	
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
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
				ParameterManageBean	parameterManageBean = new ParameterManageBean();
				parameterManageBean.setIpParameter(new IPParameter());
				parameterManageBean.setGroupList(groupList);
				parameterManageBean.setSubGroupList(subGroupList);
				setParameterManageBean(parameterManageBean);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return programID;
	}
	
	
	public void search(){
		ParameterManageBean parameterManageBean = getParameterManageBean();
		if(parameterManageBean!=null){
			SearchResult searchResult = null;
			IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");			
			try {
				searchResult = ipParameterService.searchIPParameter(parameterManageBean.getGroup(), parameterManageBean.getSubGroup(), parameterManageBean.getMaxSearchResult());
				parameterManageBean.setIpParameterList(searchResult.getResultList());
				if(searchResult.isOverMaxResultLimit()){
					IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0014")));	
				}
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setParameterManageBean(parameterManageBean);
		}
	}
	
	public String initAdd(){
		
		ParameterManageBean parameterManageBean = getParameterManageBean();
		parameterManageBean.setDisplayForCreate(true);
		parameterManageBean.setDisplayForEdit(false);
		return "IPURS014_02";
	}
	
	
	public String createSystemParameter(){
		ParameterManageBean parameterManageBean = getParameterManageBean();
		try {
			if(validate()){
				IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
				IPParameter ipParameter = parameterManageBean.getIpParameter();
				ipParameter.setCreatedBy(IPFMWebUtil.getUserId());
				ipParameter.setLastUpdBy(ipParameter.getCreatedBy());
				ipParameter = ipParameterService.createIPParameter(ipParameter);
				parameterManageBean.setIpParameter(ipParameter);
				parameterManageBean.setDisabledForEdit(true);
				parameterManageBean.setDisplayForCreate(false);
				parameterManageBean.setDisplayForEdit(true);
				parameterManageBean.getIpParameter().setParameterGroup(null);
				parameterManageBean.getIpParameter().setParameterSubGroup(null);
				parameterManageBean.getIpParameter().setStringValue(null);
				parameterManageBean.getIpParameter().setNumericValue(null);
				parameterManageBean.getIpParameter().setBooleanValue(null);
				setParameterManageBean(parameterManageBean);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				search();
			}			
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
		return "IPURS014";
	}
	
	public String initUpdate(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");	
		if(ipParameterService!=null && rowId!=null){
			try {
				
				IPParameter ipParameter = ipParameterService.getIPParameter(rowId);
				
				ParameterManageBean parameterManageBean = getParameterManageBean();
				

				parameterManageBean.setIpParameter(ipParameter);
				parameterManageBean.setDisabledForEdit(true);
				parameterManageBean.setDisplayForCreate(false);
				parameterManageBean.setDisplayForEdit(true);
				
				setParameterManageBean(parameterManageBean);				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return "IPURS014_02";
	}
	
	
	
	public String updateIPParameter(){
		try {
			if(validate()){
				IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
				    ParameterManageBean parameterManageBean = getParameterManageBean();
				        IPParameter ipParameter = parameterManageBean.getIpParameter();	
						ipParameter.setCreatedBy(IPFMWebUtil.getUserId());
						ipParameter.setLastUpdBy(ipParameter.getCreatedBy());
	
						ipParameterService.updateIPParameter(ipParameter);

						parameterManageBean.getIpParameter().setParameterGroup(null);
						parameterManageBean.getIpParameter().setParameterSubGroup(null);
						parameterManageBean.getIpParameter().setStringValue(null);
						parameterManageBean.getIpParameter().setNumericValue(null);
						parameterManageBean.getIpParameter().setBooleanValue(null);
						setParameterManageBean(parameterManageBean);
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
						search();
			}
		} catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
		return "IPURS014";
	}	
	
	
	
	public void updateValueBeforeDelete(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		ParameterManageBean parameterManageBean = getParameterManageBean();
		parameterManageBean.setRowId(rowId);
		setParameterManageBean(parameterManageBean);

	}
	
	public void delete(){
		ParameterManageBean parameterManageBean = getParameterManageBean();
		if(parameterManageBean!=null && parameterManageBean.getRowId()!=null && parameterManageBean.getRowId().trim().length()>0){
			IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
			try {
				List<IPParameter> ipParameterList = ipParameterService.deleteAndReSearchIPParameter(parameterManageBean.getRowId(), parameterManageBean.getIpParameter().getParameterGroup(), parameterManageBean.getIpParameter().getParameterSubGroup());
				parameterManageBean.setIpParameterList(ipParameterList);
				setParameterManageBean(parameterManageBean);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void changeGroup(){
		ParameterManageBean parameterManageBean = getParameterManageBean();
		List<SelectItem> subGroupList = new ArrayList<SelectItem>();		
		if(parameterManageBean!=null){
			if(parameterManageBean.getGroup()!=null && parameterManageBean.getGroup().trim().length()>0){
				IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
				if(ipParameterService!=null){
					try {
						List<String> subGroupStringList = ipParameterService.getParameterSubGroupList(parameterManageBean.getGroup());
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
			parameterManageBean.setSubGroup(null);
			parameterManageBean.setSubGroupList(subGroupList);
			setParameterManageBean(parameterManageBean);	
		}
	}
	
	public String cancel(){
		return init();
	}
	
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		ParameterManageBean parameterManageBean = getParameterManageBean();
		if(!(parameterManageBean.getIpParameter().getParameterGroup()!=null && parameterManageBean.getIpParameter().getParameterGroup().trim().length()>0)){
			IPFMMessageUtils.addMessageError("CriteriaForm:group", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Group"));
			flgValid = false;
		}
		if(!(parameterManageBean.getIpParameter().getParameterSubGroup()!=null && parameterManageBean.getIpParameter().getParameterSubGroup().trim().length()>0)){
			IPFMMessageUtils.addMessageError("CriteriaForm:subGroup", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SubGroup"));
			flgValid = false;
		}
		return flgValid;
	}


}
