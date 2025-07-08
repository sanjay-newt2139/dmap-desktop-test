package th.co.ais.ipfm.web.master.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpMasterTableId;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.CommonService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.master.bean.MasterTableBean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class MasterTableAction extends AbstractAction {
	CommonService commonService = (CommonService)JSFServiceFinderUtil.getInstance().getBean("commonService");
	
	public MasterTableBean masterTableBean;
	
	public MasterTableBean getMasterTableBean() {
		return (MasterTableBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("masterTableBean");
	}

	public void setMasterTableBean(MasterTableBean masterTableBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("masterTableBean", masterTableBean);
	}
	
	public String init() {		
		return init(getRequestParameter("programIDParam"));
	}
	
	private List<String> getRefTableList(){
		List<String> refTableList = new ArrayList<String>();
		refTableList.add("COMPANY");
		refTableList.add("HOLIDAY");
		refTableList.add("IP_TYPE");
		refTableList.add("NW_ZONE");
		refTableList.add("LOCATION");
		refTableList.add("LOGO_FILE");
		refTableList.add("NEWS");
		refTableList.add("SERVICE");
		return refTableList;
	}

	@Override
	public String init(String programID) {

		if(commonService!=null){
			try {
				List<SelectItem> refTableList = new ArrayList<SelectItem>();
				List<String> refTableStringList = getRefTableList();
				if(refTableStringList!=null && refTableStringList.size()>0){
					for (String str:refTableStringList) {
					    IPFMRichComboItem cbitem = new IPFMRichComboItem();
					    cbitem.setLabel(str);
					    cbitem.setValue(str);
						refTableList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}		

				List<SelectItem> subGroupList = new ArrayList<SelectItem>();
				MasterTableBean	masterTableBean = new MasterTableBean();
				masterTableBean.setMasterTBL(new  IpMasterTable());
				masterTableBean.setRefTableList(refTableList);
				masterTableBean.setRefKeyList(subGroupList);
				masterTableBean.setDisplayForCreate(false);
				masterTableBean.setDisplayForEdit(false);
				masterTableBean.setDisplayOther(false);
				masterTableBean.setDisplayHolidays(false);
				masterTableBean.setDisplayNews(false);
				masterTableBean.setDisplayService(false);
				masterTableBean.setDisabledForEdit(false);
				setMasterTableBean(masterTableBean);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	 return programID;
	}
	
	public void search(){
		MasterTableBean masterTableBean = getMasterTableBean();		
			try {
				List<IpMasterTable> refKeyList = new ArrayList<IpMasterTable>();
				if(masterTableBean!=null){			
					String refKey = masterTableBean.getRefKeyComboItem().getValue();
					refKeyList = commonService.findMasterTableByRefKey(refKey);
					if(refKeyList.isEmpty()){
						IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0014")));	
					}				
					masterTableBean.setMasterTBLList(refKeyList);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setMasterTableBean(masterTableBean);
	}
	
	public String initAdd(){		
		MasterTableBean masterTableBean = getMasterTableBean();
		masterTableBean.setDisplayForCreate(true);
		masterTableBean.setDisplayForEdit(false);
		masterTableBean.setDisabledForEdit(false);
		return null;
	}
	
	
	public String createMasterTBL(){
		MasterTableBean masterTableBean = getMasterTableBean();
		String refKey = masterTableBean.getRefKeyComboItem().getValue();
		IpMasterTableId id = new IpMasterTableId(); 
		try {
			if(validate()){
				IpMasterTable  masterTBL = masterTableBean.getMasterTBL();
				masterTBL.setActiveStatus("1");
				masterTBL.setRefType("MS");
				masterTBL.setCreatedBy(IPFMWebUtil.getUserId());
				masterTBL.setLastUpdBy(masterTBL.getCreatedBy());

				id.setRefTable(refKey);
				if(refKey.equalsIgnoreCase("HOLIDAY")){
					masterTBL.setHolidayDate(masterTableBean.getMasterTBL().getHolidayDate());
					String keyDate = IPFMDataUtility.toStringEngDateBySimpleFormat(masterTableBean.getMasterTBL().getHolidayDate(),"yyyy-MM-dd").replace("-", "");
					id.setRefKey(keyDate);
				}else if(refKey.equalsIgnoreCase("LOGO_FILE")){
					id.setRefKey(masterTableBean.getRefKeyComboItem().getValue());
				}else if(refKey.equalsIgnoreCase("NEWS")){
					if(masterTableBean.getMasterTBL().getRefDesc().length()<= 1000){
						id.setRefKey(masterTableBean.getMasterTBL().getRefDesc());
					}else{
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("เกิน 1000 ตัวอักษร"));
						return null;
					}
				}else{
					id.setRefKey(masterTableBean.getMasterTBL().getShortDesc());
				}
				masterTBL.setId(id);	
				if(refKey.equalsIgnoreCase("SERVICE")){
					masterTBL.setTcp(masterTableBean.getMasterTBL().getTcp());
					masterTBL.setUdp(masterTableBean.getMasterTBL().getUdp());
					masterTBL.setOther(masterTableBean.getMasterTBL().getOther());
				}
				masterTBL.setOrderData(1);
				
				if (refKey.equalsIgnoreCase("LOCATION")) {
					masterTBL.getId().setRefKey(masterTBL.getId().getRefKey().toUpperCase());
					masterTBL.setShortDesc(masterTBL.getShortDesc().toUpperCase());
				}
				
				masterTBL = commonService.createMasterTBL(masterTBL);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				masterTableBean.setMasterTBL(new IpMasterTable());
				
//				List<IpMasterTable> refKeyList = new ArrayList<IpMasterTable>();
//				refKeyList = commonService.findMasterTableByRefKey(refKey);
//				masterTableBean.setMasterTBLList(refKeyList);
				IPFMComboBoxUtil.reloadComponent();
				setMasterTableBean(masterTableBean);
				search();
			}			
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
		return null;
	}
	

	public String initUpdate(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		if(commonService!=null && rowId!=null){
			try {
				
				IpMasterTable masterTBL = commonService.getMasterTBL(rowId);				
				MasterTableBean masterTableBean = getMasterTableBean();				
				masterTableBean.setMasterTBL(masterTBL);				
				masterTableBean.setDisabledForEdit(true);
				masterTableBean.setDisplayForCreate(false);
				masterTableBean.setDisplayForEdit(true);
				
				setMasterTableBean(masterTableBean);				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return null;
	}
	
	public String updateMasterTBL(){
        MasterTableBean masterTableBean = getMasterTableBean();
		String refKey = masterTableBean.getRefKeyComboItem().getValue();
		IpMasterTableId id = new IpMasterTableId(); 
		try {
			if(validate()){
		        IpMasterTable masterTBL = masterTableBean.getMasterTBL();
		        masterTBL.setRowId(masterTableBean.getRowId());
		        masterTBL.setLastUpdBy(IPFMWebUtil.getUserId());
		        
				id.setRefTable(refKey);
				if(refKey.equalsIgnoreCase("HOLIDAY")){
					masterTBL.setHolidayDate(masterTableBean.getMasterTBL().getHolidayDate());
					String keyDate = IPFMDataUtility.toStringEngDateBySimpleFormat(masterTableBean.getMasterTBL().getHolidayDate(),"yyyy-MM-dd").replace("-", "");
					id.setRefKey(keyDate);
				}else if(refKey.equalsIgnoreCase("LOGO_FILE")){
					id.setRefKey(masterTableBean.getRefKeyComboItem().getValue());
				}else if(refKey.equalsIgnoreCase("NEWS")){
					if(masterTableBean.getMasterTBL().getRefDesc().length()<= 1000){
					id.setRefKey(masterTableBean.getMasterTBL().getRefDesc());
					}else{
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("เกิน 1000 ตัวอักษร"));
						return null;
					}
				}else{
					id.setRefKey(masterTableBean.getMasterTBL().getShortDesc());
				}
				masterTBL.setId(id);	
				if(refKey.equalsIgnoreCase("SERVICE")){
					masterTBL.setTcp(masterTableBean.getMasterTBL().getTcp());
					masterTBL.setUdp(masterTableBean.getMasterTBL().getUdp());
					masterTBL.setOther(masterTableBean.getMasterTBL().getOther());
				}
				masterTBL.setOrderData(1);
				if (refKey.equalsIgnoreCase("LOCATION")) {
					masterTBL.getId().setRefKey(masterTBL.getId().getRefKey().toUpperCase());
					masterTBL.setShortDesc(masterTBL.getShortDesc().toUpperCase());
				}
				commonService.updateMasterTBL(masterTBL);
				masterTableBean.setMasterTBL(new IpMasterTable());
				
//						List<IpMasterTable> refKeyList = new ArrayList<IpMasterTable>();
//						refKeyList = commonService.findMasterTableByRefKey(refKey);
//						masterTableBean.setMasterTBLList(refKeyList);
				
				setMasterTableBean(masterTableBean);
				initAdd();
				IPFMComboBoxUtil.reloadComponent();
				if (refKey.equalsIgnoreCase("NEWS")) changeRefKey();
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				search();
			}
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		} catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}		
		return null;
	}		
	
	public void updateValueBeforeDelete(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		String refTable = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("refTable").toString();
		String shortDesc = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("shortDesc").toString();
		MasterTableBean masterTableBean = getMasterTableBean();
		masterTableBean.setRowId(rowId);
		masterTableBean.setRefTable(refTable);
		if (refTable.equalsIgnoreCase("LOCATION")) shortDesc = shortDesc.toUpperCase();		
		masterTableBean.setRefKey(shortDesc);
		setMasterTableBean(masterTableBean);

	}
	
	public void delete(){
		MasterTableBean masterTableBean = getMasterTableBean();
		if(masterTableBean!=null && masterTableBean.getRowId()!=null && masterTableBean.getRowId().trim().length()>0){
			try {
				List<IpMasterTable> masterTBLList = commonService.deleteAndListMasterTable(masterTableBean.getRowId(), masterTableBean.getRefTable(), masterTableBean.getRefKey(),IPFMWebUtil.getUserId());
				masterTableBean.setMasterTBLList(masterTBLList);
				masterTableBean.setMasterTBL(new IpMasterTable());
				masterTableBean.setDisplayForCreate(true);
				masterTableBean.setDisplayForEdit(false);
				masterTableBean.setDisabledForEdit(false);
				IPFMComboBoxUtil.reloadComponent();
				setMasterTableBean(masterTableBean);
				search();
				
			} catch (IPFMBusinessException e) {
				e.printStackTrace();
				IPFMMessageUtils.addMessageError(e.getMessage());
			} catch (Exception e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0009")));
			}	
		}
	}
	
	public void changeRefKey(){
		MasterTableBean bean = getMasterTableBean();
		String refKey = bean.getRefKeyComboItem().getValue();
		List<IpMasterTable> refKeyList = commonService.findMasterTableByRefKey(refKey);
		bean.setMasterTBLList(refKeyList);
		bean.setMasterTBL(new IpMasterTable());
		
//		bean.getMasterTBL().setRefDesc(null);
//		bean.getMasterTBL().setShortDesc(null);
		
		System.out.println("refKey >>>>> "+refKey);
		if(refKey.equals("HOLIDAY")){
			bean.setDisplayService(false);
			bean.setDisplayOther(false);
			bean.setDisplayHolidays(true);
			bean.setDisplayNews(false);
			bean.setDisplayLogo(false);
			bean.setDisabledForEdit(false);
			bean.setDisplayForCreate(true);	
			bean.setDisplayForEdit(false);
			bean.setDisplayForCreate(true);
		} else if(refKey.equals("NEWS")){
			String news = (String)refKeyList.get(0).getRefDesc();
			bean.getMasterTBL().setRefDesc(news);
			bean.setDisplayService(false);
			bean.setDisplayOther(false);
			bean.setDisplayHolidays(false);
			bean.setDisplayNews(true);
			bean.setDisplayForEdit(true);
			bean.setDisplayForCreate(false);
			bean.setDisplayLogo(false);
		} else if(refKey.equals("LOGO_FILE")){
			bean.setDisplayService(false);
			bean.setDisplayOther(false);
			bean.setDisplayHolidays(false);
			bean.setDisplayNews(false);
			bean.setDisplayForEdit(true);
			bean.setDisplayForCreate(false);
			bean.setDisplayLogo(true);
		} else if(refKey.equals("NW_TYPE")){
			bean.setDisplayService(false);
			bean.setDisplayOther(true);
			bean.setDisplayHolidays(false);
			bean.setDisplayNews(false);
			bean.setDisabledForEdit(false);
			bean.setDisplayLogo(false);
			bean.setDisplayForCreate(true);
			bean.setDisplayForEdit(false);	
		} else if(refKey.equals("SERVICE")){
			bean.setDisplayService(true);
			bean.setDisplayOther(false);
			bean.setDisplayHolidays(false);
			bean.setDisplayNews(false);
			bean.setDisplayLogo(false);
			bean.setDisabledForEdit(false);
			bean.setDisplayForCreate(true);
			bean.setDisplayForEdit(false);
		} else {
			bean.setDisplayService(false);
			bean.setDisplayOther(true);
			bean.setDisplayHolidays(false);
			bean.setDisplayNews(false);
			bean.setDisplayLogo(false);
			bean.setDisabledForEdit(false);
			bean.setDisplayForCreate(true);
			bean.setDisplayForEdit(false);
		}
		setMasterTableBean(bean);
	}
	
	public String cancel(){
		return init();
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get(name);
    }

	@Override
	public boolean validate() {
		boolean flgValid = true;
		MasterTableBean masterTableBean = getMasterTableBean();
		String refKey = masterTableBean.getRefKeyComboItem().getValue();

		if(refKey.equals("COMPANY")||refKey.equals("LOCATION")||refKey.equals("IP_TYPE")||refKey.equals("NW_ZONE")||refKey.equals("SERVICE")){
			if(IPFMUtils.ifBlank(masterTableBean.getMasterTBL().getShortDesc(),"").trim().length()==0) {
				if(masterTableBean.isDisplayService()){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Service Name"));
				}else{
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Display Name"));
				}
				
			}
		}
		if(refKey.equals("HOLIDAY")){
			if(IPFMUtils.ifBlank(masterTableBean.getMasterTBL().getHolidayDate().toString(),"").trim().length()==0) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Date"));
			}
		}			
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}

	
	public void editProperty(ActionEvent event) throws Exception{
			String rowId = getRequestParameter("rowId");
		System.out.println("editProperty rowID : "+rowId);
		IpMasterTable master = commonService.getMasterTBL(rowId);
		MasterTableBean bean = getMasterTableBean();
		bean.setRowId(rowId);
		bean.getMasterTBL().setRowId(rowId);
		bean.getMasterTBL().setShortDesc(master.getShortDesc());
		bean.getMasterTBL().setRefDesc(master.getRefDesc());

		bean.getMasterTBL().setTcp(master.getTcp());
		bean.getMasterTBL().setUdp(master.getUdp());
		bean.getMasterTBL().setOther(master.getOther());
		bean.getMasterTBL().setHolidayDate(master.getHolidayDate());
		
		bean.setRefTable(master.getId().getRefTable());
		
		bean.setDisplayForCreate(false);
		bean.setDisplayForEdit(true);
		bean.setDisabledForEdit(true);
		setMasterTableBean(bean);
	}
	
	public void cancel(ActionEvent event) throws Exception{
		MasterTableBean bean = getMasterTableBean();
		String refKey = bean.getRefKeyComboItem().getValue();
		if (refKey.equalsIgnoreCase("NEWS")) changeRefKey();
		else{
			bean.setMasterTBL(new IpMasterTable());
			bean.setDisplayForCreate(true);
			bean.setDisplayForEdit(false);
			bean.setDisabledForEdit(false);
		}
		setMasterTableBean(bean);
	}
    
	public void listener(UploadEvent event) throws Exception{
		MasterTableBean bean = getMasterTableBean();
	    
        UploadItem item = event.getUploadItem();
        this.attachFileLogo(item);
		setMasterTableBean(bean);
    } 

}
