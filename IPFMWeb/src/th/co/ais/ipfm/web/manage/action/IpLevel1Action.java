package th.co.ais.ipfm.web.manage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpLevel2;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.ManagementIpService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IpLevel1Bean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpLevel1Action extends AbstractAction {
	
	/********************** Bean IpLevel1Action ***********************/
	public IpLevel1Bean ipLevel1Bean;
	
	public IpLevel1Bean getIpLevel1Bean() {
		return (IpLevel1Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ipLevel1Bean");
	}

	public void setIpLevel1Bean(IpLevel1Bean ipLevel1Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ipLevel1Bean", ipLevel1Bean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		ipLevel1Bean = getIpLevel1Bean();		
		if(TablSort.equalsIgnoreCase("IPDataTable")) {
			ipLevel1Bean.setSortSIP001View(sortColumnChange());	
		}  
		return "";
	}
	
	@Override
	public String init(String programID) {
		ipLevel1Bean = new IpLevel1Bean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{
			int maxSearchResult = getIPFMConfig().getMaxSearchResult();
			List<SelectItem> ipStatusStringList = IPFMComboBoxUtil.getInstance().getIPStatusComboBoxItems();
			List<SelectItem> ipStatusList= new ArrayList<SelectItem>();
			for (SelectItem item : ipStatusStringList) {
				IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
				if (cmb.getValue().equalsIgnoreCase("P") || cmb.getValue().equalsIgnoreCase("N") ) {
					ipStatusList.add(item);
				}
			}
			ipLevel1Bean.setIpStatusList(ipStatusList);
			ipLevel1Bean.setAllIpStatusList(ipStatusStringList);
			
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			List<IpRoleMember> roleMemberList = managementIpService.findIpRoleMemberByUserId(userSession.getIpUser().getUserId());
			ipLevel1Bean.setUserRole(IPFMConstant.TIER3);
			for(IpRoleMember roleMember : roleMemberList){
				if (roleMember.getRoleId().equalsIgnoreCase("R04")) {
					ipLevel1Bean.setUserRole(IPFMConstant.TIER2);
				}
				if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && !roleMember.getRoleId().equalsIgnoreCase("R04") && !roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel1Bean.setUserRole(IPFMConstant.TIER23);
				}
				if (!ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel1Bean.setUserRole(IPFMConstant.TIER1);
				}
				if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel1Bean.setUserRole(IPFMConstant.TIER12);
				}
				if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) && !roleMember.getRoleId().equalsIgnoreCase("R04") && !roleMember.getRoleId().equalsIgnoreCase("R05") ){
					ipLevel1Bean.setUserRole(IPFMConstant.TIER123);
					break;
				}
			}
			
			if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1) 
				|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) 
				|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
				ipLevel1Bean.setExpiredDateEdit(true);
				ipLevel1Bean.setIpLevel1List(managementIpService.findAllIpLevel1(maxSearchResult));	
			}else{
				ipLevel1Bean.setExpiredDateEdit(false);
				ipLevel1Bean.setIpLevel1List(managementIpService.findIpLevel1ByTeam(userSession.getIpUser().getTeamId(),maxSearchResult));
			}
			
			setIpLevel1Bean(ipLevel1Bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return programID;
	}
	
	public void reset() {
		ipLevel1Bean = getIpLevel1Bean();
		try{
			ipLevel1Bean.setSearchFlag(false);
			ipLevel1Bean.setIpVersion("4");
			ipLevel1Bean.setSearchIp1("");
			ipLevel1Bean.setSearchIp2("");
			ipLevel1Bean.setSearchIp3("");
			ipLevel1Bean.setSearchIp4("");
			ipLevel1Bean.setSearchIp5("");
			ipLevel1Bean.setSearchIp6("");
			ipLevel1Bean.setSearchMask("");
			ipLevel1Bean.setScrollerPage(1);
			ipLevel1Bean.setParamIpVersion("4");
			ipLevel1Bean.setParamSearchIp2("");
			ipLevel1Bean.setParamSearchIp3("");
			ipLevel1Bean.setParamSearchIp4("");
			ipLevel1Bean.setParamSearchIp5("");
			ipLevel1Bean.setParamSearchIp6("");
			ipLevel1Bean.setParamSearchMask("");
			ipLevel1Bean.setScrollerPage(1);
			ipLevel1Bean.setIpLevel1List(refreshTable(ipLevel1Bean.isSearchFlag()));
			unsortedAllColumnRichDataTable(ipLevel1Bean.getIpLevel1DataTable());
			setIpLevel1Bean(ipLevel1Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}

	public IpLevel1 selectRowLevel1(IpLevel1Bean ipLevel1Bean) throws CloneNotSupportedException{		
		ipLevel1Bean.getIpLevel1DataTable().setRowIndex(Integer.parseInt(getRequestParameter("rowIndex")));
		IpLevel1 ipLevel1 = (IpLevel1)((IpLevel1)ipLevel1Bean.getIpLevel1DataTable().getRowData()).clone();
		ipLevel1.setIpStatusOld(ipLevel1.getIpStatus());
		return ipLevel1;
	}
	
	public IpLevel2 selectRowLevel2(IpLevel1Bean ipLevel1Bean) throws CloneNotSupportedException{		
		ipLevel1Bean.getIpLevel2DataTable().setRowIndex(Integer.parseInt(getRequestParameter("rowIndex")));
		IpLevel2 ipLevel2 = (IpLevel2)((IpLevel2)ipLevel1Bean.getIpLevel2DataTable().getRowData()).clone();
		return ipLevel2;
	}
	public void prepareIPStatusList(IpLevel1Bean bean) throws Exception{
		List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
		for (SelectItem item : bean.getAllIpStatusList()) {
			IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
			if (cmb.getValue().equalsIgnoreCase("P") || cmb.getValue().equalsIgnoreCase("N")) {
				ipStatusList.add(item);
			}
		}
		bean.setIpStatusList(ipStatusList);
	}
	public String popupDetail() throws Exception{
		ipLevel1Bean = getIpLevel1Bean();
		try{
			IpLevel1 ipLevel1 = selectRowLevel1(ipLevel1Bean);
			ipLevel1Bean.setIpLevel1(ipLevel1);
			if (IPFMUtils.ifBlank(ipLevel1.getIpStatus(), "").trim().length()==0) ipLevel1.setIpStatus("P");
			for(SelectItem item : ipLevel1Bean.getAllIpStatusList()){
				IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
				if (cmb.getValue().equalsIgnoreCase(ipLevel1.getIpStatus())) {
					ipLevel1Bean.setIpStatusComboItem(cmb);
					ipLevel1Bean.setIpStatusName(cmb.getLabel());
					break;
				}
			}
			prepareEditStatus(ipLevel1Bean);			
			setIpLevel1Bean(ipLevel1Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	private void prepareEditStatus(IpLevel1Bean bean) throws Exception {
		bean.setIpStatusEdit(false); 
		bean.setT1RemarksEdit(false);
		IpLevel1 ipLevel1 = bean.getIpLevel1();
		if (!bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)) {
			
			Date currentDate = IPFMDataUtility.getCurrentDateByPattern();
			//20101125
			//if (ipLevel1.getExpiredDate().compareTo(currentDate)<=0 
			//		&& ipLevel1.getIpStatus().equalsIgnoreCase("P") 
			//		&& ipLevel1.getTotalT2Assign().intValue()==0) {
			//	bean.setIpStatusEdit(true); 
			//}
			if (ipLevel1.getTotalT2Assign().intValue()==0) {
				bean.setIpStatusEdit(true); 
			}
			bean.setT1RemarksEdit(true);
		}
	}

	public String save(){
		ipLevel1Bean = getIpLevel1Bean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{
			if(validatePopUp()){
				ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				if (managementIpService.validateOverExpireLevel1(ipLevel1Bean.getIpLevel1().getLevel1Id(), sdf.format(ipLevel1Bean.getIpLevel1().getExpiredDate()))){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0083")));
					return null;
				}
				ipLevel1Bean.getIpLevel1().setIpStatus(ipLevel1Bean.getIpStatusComboItem().getValue());
				managementIpService.saveIpLevel1(ipLevel1Bean.getIpLevel1(),userSession.getIpUser().getUserId());
				ipLevel1Bean.setIpLevel1List(refreshTable(ipLevel1Bean.isSearchFlag()));
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
			setIpLevel1Bean(ipLevel1Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}

	public void searchIP(){
		ipLevel1Bean = getIpLevel1Bean();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{		
			
			if (validate()) {
				int maxSearchResult = getIPFMConfig().getMaxSearchResult();
				ipLevel1Bean.setSearchFlag(true);
				ipLevel1Bean.setParamIpVersion(ipLevel1Bean.getIpVersion());
				ipLevel1Bean.setParamSearchIp1(ipLevel1Bean.getSearchIp1());
				ipLevel1Bean.setParamSearchIp2(ipLevel1Bean.getSearchIp2());
				ipLevel1Bean.setParamSearchIp3(ipLevel1Bean.getSearchIp3());
				ipLevel1Bean.setParamSearchIp4(ipLevel1Bean.getSearchIp4());
				ipLevel1Bean.setParamSearchIp5(ipLevel1Bean.getSearchIp5());
				ipLevel1Bean.setParamSearchIp6(ipLevel1Bean.getSearchIp6());
				ipLevel1Bean.setParamSearchMask(ipLevel1Bean.getSearchMask());
				
				if (IPFMUtils.ifBlank(ipLevel1Bean.getSearchMask(), "").trim().length()==0) {
					if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1) 
							|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) 
							|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
						ipLevel1Bean.setIpLevel1List(managementIpService.searchIpManagementLevel1(ipLevel1Bean.getParamIpVersion(), ipLevel1Bean.getParamSearchIp1(), ipLevel1Bean.getParamSearchIp2(), ipLevel1Bean.getParamSearchIp3(), ipLevel1Bean.getParamSearchIp4(), "32", maxSearchResult));
					}else{
						ipLevel1Bean.setIpLevel1List(managementIpService.searchIpManagementLevel1ByTeam(ipLevel1Bean.getParamIpVersion(), ipLevel1Bean.getParamSearchIp1(), ipLevel1Bean.getParamSearchIp2(), ipLevel1Bean.getParamSearchIp3(), ipLevel1Bean.getParamSearchIp4(), "32", userSession.getIpUser().getTeamId(), maxSearchResult));
					}
				}else{
					if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1) 
							|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) 
							|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
						ipLevel1Bean.setIpLevel1List(managementIpService.searchIpManagementLevel1(ipLevel1Bean.getParamIpVersion(), ipLevel1Bean.getParamSearchIp1(), ipLevel1Bean.getParamSearchIp2(), ipLevel1Bean.getParamSearchIp3(), ipLevel1Bean.getParamSearchIp4(), ipLevel1Bean.getParamSearchMask(), maxSearchResult));
					}else{
						ipLevel1Bean.setIpLevel1List(managementIpService.searchIpManagementLevel1ByTeam(ipLevel1Bean.getParamIpVersion(), ipLevel1Bean.getParamSearchIp1(), ipLevel1Bean.getParamSearchIp2(), ipLevel1Bean.getParamSearchIp3(), ipLevel1Bean.getParamSearchIp4(), ipLevel1Bean.getParamSearchMask(), userSession.getIpUser().getTeamId(),maxSearchResult));
					}
				}
			}
			setIpLevel1Bean(ipLevel1Bean);
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}
	}
	
	public List<IpLevel1> refreshTable(boolean searchFlag){
		List<IpLevel1> ipLevel1List = new ArrayList<IpLevel1>();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{			
			int maxSearchResult = getIPFMConfig().getMaxSearchResult();
			if (searchFlag){
				ipLevel1List = managementIpService.searchIpManagementLevel1(ipLevel1Bean.getParamIpVersion(), ipLevel1Bean.getParamSearchIp1(), ipLevel1Bean.getParamSearchIp2(), ipLevel1Bean.getParamSearchIp3(), ipLevel1Bean.getParamSearchIp4(), ipLevel1Bean.getParamSearchMask(),maxSearchResult);			
			}else{
				if (ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1) 
						|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) 
						|| ipLevel1Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
					ipLevel1List = managementIpService.findAllIpLevel1(maxSearchResult);				
				}else{
					ipLevel1List = managementIpService.findIpLevel1ByTeam(userSession.getIpUser().getTeamId(),maxSearchResult);	
				}
			}
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}
		return ipLevel1List;
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;		
		if(IPFMUtils.ifBlank(ipLevel1Bean.getIpVersion(),"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}
		if(IPFMUtils.ifBlank(ipLevel1Bean.getSearchIp1(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel1Bean.getSearchIp2(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel1Bean.getSearchIp3(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel1Bean.getSearchIp4(),"").trim().length()==0 ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		}
//		if (IPFMUtils.ifBlank(ipLevel1Bean.getSearchMask(),"").trim().length()==0){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
//		}
		if (IPFMUtils.ifBlank(ipLevel1Bean.getSearchMask(),"").trim().length()>0) {
			if (Integer.parseInt(IPFMUtils.ifBlank(ipLevel1Bean.getSearchMask(),"").trim()) < 8 || 
				Integer.parseInt(IPFMUtils.ifBlank(ipLevel1Bean.getSearchMask(),"").trim())>32 ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
			}
		}
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	public boolean validatePopUp() {
		boolean flgValid = true;		
		if(IPFMUtils.ifBlank(ipLevel1Bean.getIpStatusComboItem().getValue(),"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Status"));
		}else{
			if (IPFMUtils.ifBlank(ipLevel1Bean.getIpStatusComboItem().getValue(),"").equalsIgnoreCase("N")){
				return true;
			}
		}
		if(ipLevel1Bean.getIpLevel1().getExpiredDate() == null) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
		}else if (ipLevel1Bean.getIpLevel1().getEffectiveDate().compareTo(ipLevel1Bean.getIpLevel1().getExpiredDate())>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
		}
		if(IPFMUtils.ifBlank(ipLevel1Bean.getIpLevel1().getT1Remarks(),"").trim().length()>1000) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Remarks"));
		}
		
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}

}
