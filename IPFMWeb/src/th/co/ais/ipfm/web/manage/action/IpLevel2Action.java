package th.co.ais.ipfm.web.manage.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;

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
import th.co.ais.ipfm.web.manage.bean.IpLevel2Bean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpLevel2Action extends AbstractAction {
	
	/********************** Bean IpLevel1Action ***********************/
	public IpLevel2Bean ipLevel2Bean;
	
	public IpLevel2Bean getIpLevel2Bean() {
		return (IpLevel2Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ipLevel2Bean");
	}

	public void setIpLevel2Bean(IpLevel2Bean ipLevel2Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ipLevel2Bean", ipLevel2Bean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		ipLevel2Bean = getIpLevel2Bean();		
		if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			ipLevel2Bean.setSortSIP002View(sortColumnChange());	
		}  
		return "";
	}
	
	
	@Override
	public String init(String programID) {
		ipLevel2Bean = new IpLevel2Bean();
		try{
			UserSession userSession = IPFMWebUtil.getUserSession();
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			List<IpRoleMember> roleMemberList = managementIpService.findIpRoleMemberByUserId(userSession.getIpUser().getUserId());
			List<SelectItem> ipStatusStringList= IPFMComboBoxUtil.getInstance().getIPStatusComboBoxItems();
			List<SelectItem> ipStatusList= new ArrayList<SelectItem>();
			ipLevel2Bean.setUserRole(IPFMConstant.TIER3);
			for(IpRoleMember roleMember : roleMemberList){
				if (roleMember.getRoleId().equalsIgnoreCase("R04")) {
					ipLevel2Bean.setUserRole(IPFMConstant.TIER2);
				}
				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && !roleMember.getRoleId().equalsIgnoreCase("R04") 
						&& !roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel2Bean.setUserRole(IPFMConstant.TIER23);
				}
				if (!ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel2Bean.setUserRole(IPFMConstant.TIER1);
				}
				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel2Bean.setUserRole(IPFMConstant.TIER12);
				}
				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) && !roleMember.getRoleId().equalsIgnoreCase("R04") 
						&& !roleMember.getRoleId().equalsIgnoreCase("R05") ){
					ipLevel2Bean.setUserRole(IPFMConstant.TIER123);
					break;
				}
			}
			
			List<SelectItem> ipTypeList= IPFMComboBoxUtil.getInstance().getIPTypeListComboBoxItems();
			List<SelectItem> networkTypeList= IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems();
			List<SelectItem> networkZoneList= IPFMComboBoxUtil.getInstance().getZoneComboBoxItems();
			List<SelectItem> locationList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
			List<SelectItem> installTypeList = IPFMComboBoxUtil.getInstance().getInstallTypeComboBoxItems();
			List<SelectItem> companyList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
			ipLevel2Bean.setCompanyList(companyList);
			ipLevel2Bean.setLocationList(locationList);
			ipLevel2Bean.setInstallTypeList(installTypeList);
			ipLevel2Bean.setNwTypeList(networkTypeList);
			ipLevel2Bean.setZoneList(networkZoneList);
			ipLevel2Bean.setIpStatusList(ipStatusList);
			ipLevel2Bean.setIpTypeList(ipTypeList);
			ipLevel2Bean.setAllIpStatusList(ipStatusStringList);
			ipLevel2Bean.setCurrentDate(IPFMUtils.changeDateFormat(managementIpService.getSysdate(), "dd/MM/yyyy", "yyyyMMdd"));
			ipLevel2Bean.setIpLevel2List(refreshTable(false));
			setIpLevel2Bean(ipLevel2Bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		} catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return programID;
	}
	
	public void reset() {
		ipLevel2Bean = getIpLevel2Bean();
		try{
			ipLevel2Bean.setSearchFlag(false);
			ipLevel2Bean.setIpVersion("4");
			ipLevel2Bean.setSearchIp1("");
			ipLevel2Bean.setSearchIp2("");
			ipLevel2Bean.setSearchIp3("");
			ipLevel2Bean.setSearchIp4("");
			ipLevel2Bean.setSearchIp5("");
			ipLevel2Bean.setSearchIp6("");
			ipLevel2Bean.setSearchMask("");
			ipLevel2Bean.setScrollerPage(1);
			ipLevel2Bean.setParamIpVersion("4");
			ipLevel2Bean.setParamSearchIp2("");
			ipLevel2Bean.setParamSearchIp3("");
			ipLevel2Bean.setParamSearchIp4("");
			ipLevel2Bean.setParamSearchIp5("");
			ipLevel2Bean.setParamSearchIp6("");
			ipLevel2Bean.setParamSearchMask("");
			ipLevel2Bean.setScrollerPage(1);
			ipLevel2Bean.setCheckAll(false);
			ipLevel2Bean.setNetworkTypeComboItem(null);
			ipLevel2Bean.setNetworkZoneComboItem(null);
			ipLevel2Bean.setInstallTypeComboItem(null);
			ipLevel2Bean.setLocationComboItem(null);
			ipLevel2Bean.setIpLevel2List(refreshTable(ipLevel2Bean.isSearchFlag()));
			unsortedAllColumnRichDataTable(ipLevel2Bean.getIpLevel2DataTable());
			setIpLevel2Bean(ipLevel2Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public void checkAll(){
		ipLevel2Bean = getIpLevel2Bean();
		try{
			if (ipLevel2Bean.getIpLevel2DataTable().getRowCount()>0) {
				HtmlDataTable dataTable = ipLevel2Bean.getIpLevel2DataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				for (int i=startRow ; i<endRow ; i++) {
					if (i == dataTable.getRowCount()) break;
					dataTable.setRowIndex(i);
					IpLevel2 ipLevel2 = (IpLevel2) dataTable.getRowData();
	                ipLevel2.setRowCheck(ipLevel2Bean.isCheckAll());
				}
			}
			setIpLevel2Bean(ipLevel2Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public void searchIP(){
		ipLevel2Bean = getIpLevel2Bean();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		try{
			int maxSearchResult = getIPFMConfig().getMaxSearchResult();
			UserSession userSession = IPFMWebUtil.getUserSession();
			if (validate()) {
				ipLevel2Bean.setSearchFlag(true);
				ipLevel2Bean.setParamIpVersion(ipLevel2Bean.getIpVersion());
				ipLevel2Bean.setParamSearchIp1(ipLevel2Bean.getSearchIp1());
				ipLevel2Bean.setParamSearchIp2(ipLevel2Bean.getSearchIp2());
				ipLevel2Bean.setParamSearchIp3(ipLevel2Bean.getSearchIp3());
				ipLevel2Bean.setParamSearchIp4(ipLevel2Bean.getSearchIp4());
				ipLevel2Bean.setParamSearchIp5(ipLevel2Bean.getSearchIp5());
				ipLevel2Bean.setParamSearchIp6(ipLevel2Bean.getSearchIp6());
				ipLevel2Bean.setParamSearchMask(ipLevel2Bean.getSearchMask());
				
				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
					|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) || ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
					if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(), "").trim().length()==0) {
						ipLevel2Bean.setIpLevel2List(managementIpService.searchIpManagementLevel2(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), "32",maxSearchResult));
					}else{
						ipLevel2Bean.setIpLevel2List(managementIpService.searchIpManagementLevel2(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), ipLevel2Bean.getParamSearchMask(),maxSearchResult));			
					}
				}else if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) || ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)) {
					if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(), "").trim().length()==0) {
						ipLevel2Bean.setIpLevel2List(managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), "32", userSession.getIpUser().getTeamId(),maxSearchResult));
					}else{
						ipLevel2Bean.setIpLevel2List(managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), ipLevel2Bean.getParamSearchMask(),userSession.getIpUser().getTeamId(),maxSearchResult));			
					}
				}
			}
			setIpLevel2Bean(ipLevel2Bean);
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	public void prepareIPStatusList(IpLevel2Bean bean) throws Exception{
		List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
		Date currentDate = IPFMDataUtility.getCurrentDateByPattern();
		for (SelectItem item : bean.getAllIpStatusList()) {
			IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
			if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)) {
				//20101125
				//if (bean.getIpLevel2().getExpiredDate().compareTo(currentDate)<=0 && bean.getIpLevel2().getIpStatus().equalsIgnoreCase("P")) {
				//	if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
				//		|| cmb.getValue().equalsIgnoreCase("N")){
				//		ipStatusList.add(item);
				//	}
				//}
				//20101125
				if (bean.getIpLevel2().getAvailableIp().add(bean.getIpLevel2().getAssignIp().add(bean.getIpLevel2().getTerminateIp())).intValue()==bean.getIpLevel2().getTotalIp().intValue()) {
					if (bean.getIpLevel2().getIpStatus().equalsIgnoreCase("P")){
						if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
								|| cmb.getValue().equalsIgnoreCase("N")){
							ipStatusList.add(item);
						}
					}
				}
			} else if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) || 
					bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23) ) {
				//20101125
				//if (bean.getIpLevel2().getExpiredDate().compareTo(currentDate)<=0){
				//	if (bean.getIpLevel2().getIpStatus().equalsIgnoreCase("A")){
				//		if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
				//			|| cmb.getValue().equalsIgnoreCase("P")
				//			|| cmb.getValue().equalsIgnoreCase("N")){
				//			ipStatusList.add(item);
				//		}
				//	}else if (bean.getIpLevel2().getAvailableIp().add(bean.getIpLevel2().getAssignIp().add(bean.getIpLevel2().getTerminateIp())).intValue()==bean.getIpLevel2().getTerminateIp().intValue()) {
				//		if (cmb.getValue().equalsIgnoreCase("P")
				//			|| cmb.getValue().equalsIgnoreCase("N")){
				//			ipStatusList.add(item);
				//		}
				//	}
				//20101125
				if (bean.getIpLevel2().getAvailableIp().add(bean.getIpLevel2().getAssignIp().add(bean.getIpLevel2().getTerminateIp())).intValue()==bean.getIpLevel2().getTotalIp().intValue()) {
					if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
							|| cmb.getValue().equalsIgnoreCase("P")){
						ipStatusList.add(item);
					}
				}
			} else if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) || bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
				//20101125
				//if (bean.getIpLevel2().getExpiredDate().compareTo(currentDate)<=0){
				//	if (bean.getIpLevel2().getIpStatus().equalsIgnoreCase("P")){
				//		if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
				//			|| cmb.getValue().equalsIgnoreCase("N")){
				//			ipStatusList.add(item);
				//		}
				//	}else if (bean.getIpLevel2().getIpStatus().equalsIgnoreCase("A")){
				//		if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
				//			|| cmb.getValue().equalsIgnoreCase("P")
				//			|| cmb.getValue().equalsIgnoreCase("N")){
				//			ipStatusList.add(item);
				//		}
				//	}else if (bean.getIpLevel2().getAvailableIp().add(bean.getIpLevel2().getAssignIp().add(bean.getIpLevel2().getTerminateIp())).intValue()==bean.getIpLevel2().getTerminateIp().intValue()) {
				//		if (cmb.getValue().equalsIgnoreCase("P")
				//			|| cmb.getValue().equalsIgnoreCase("N")){
				//			ipStatusList.add(item);
				//		}
				//	}
				//20101125
				if (bean.getIpLevel2().getAvailableIp().add(bean.getIpLevel2().getAssignIp().add(bean.getIpLevel2().getTerminateIp())).intValue()==bean.getIpLevel2().getTotalIp().intValue()) {
					if (cmb.getValue().equalsIgnoreCase(bean.getIpLevel2().getIpStatus())
							|| cmb.getValue().equalsIgnoreCase("P")){
						ipStatusList.add(item);
					}
				}
			}
		}
		if (ipStatusList!=null && ipStatusList.size()>1) bean.setIpStatusEdit(true);
		else bean.setIpStatusEdit(false);
		bean.setIpStatusList(ipStatusList);
	}
	
	public void prepareIPStatusListUpdateInfo(IpLevel2Bean bean) throws Exception{
		List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
		Date currentDate = IPFMDataUtility.getCurrentDateByPattern();
		for (SelectItem item : bean.getAllIpStatusList()) {
			IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
			if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)) {
				if (cmb.getValue().equalsIgnoreCase("N")){
					ipStatusList.add(item);
					bean.setIpStatusComboItem(cmb);
					bean.setIpStatusName(cmb.getLabel());
					break;
				}
			} else if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) || 
					bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23) ||
					bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) || 
					bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
				if (cmb.getValue().equalsIgnoreCase("P")){
					ipStatusList.add(item);
					bean.setIpStatusComboItem(cmb);
					bean.setIpStatusName(cmb.getLabel());
					break;
				}
			}
		}
		if (ipStatusList!=null && ipStatusList.size()>1){
			bean.setIpStatusEdit(true);
		}else{
			bean.setIpStatusEdit(false);
		}
		bean.setIpStatusList(ipStatusList);
	}	
	
	public void prepareStatusEdit(IpLevel2Bean bean) throws Exception {
		IpLevel2 ipLevel2 = bean.getIpLevel2();
		UserSession userSesion = IPFMWebUtil.getUserSession();
		//20101125
		//if (ipLevel2.getIpStatus().equalsIgnoreCase("P") 
		//		//|| (ipLevel2.getTotalIp().intValue() == ipLevel2.getTerminateIp().intValue())
		//		) {
		//	bean.setIpStatusEdit(true);
		//	bean.setIpTypeEdit(true);
		//	if (ipLevel2.getT2TeamId().equalsIgnoreCase(userSesion.getIpUser().getTeamId())) {
		//		bean.setNetworkTypeEdit(true);
		//	}
		//}
		//if (ipLevel2.getIpStatus().equalsIgnoreCase("A")) {
		//	if (ipLevel2.getT2TeamId().equalsIgnoreCase(userSesion.getIpUser().getTeamId())) {
		//		bean.setNetworkTypeEdit(true);
		//	}
		//}
		//20101125
		if ((ipLevel2.getIpStatus().equalsIgnoreCase("A")) &&
				((bean.getIpLevel2().getAvailableIp()
						.add(bean.getIpLevel2().getAssignIp()
								.add(bean.getIpLevel2().getTerminateIp())).intValue()
						==bean.getIpLevel2().getTotalIp().intValue())) &&
				((bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) || 
					bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23) ))
				//|| (ipLevel2.getTotalIp().intValue() == ipLevel2.getTerminateIp().intValue())
				) {
			bean.setIpStatusEdit(true);
			bean.setIpTypeEdit(true);
			if (ipLevel2.getT2TeamId().equalsIgnoreCase(userSesion.getIpUser().getTeamId())) {
				bean.setNetworkTypeEdit(true);
			}
		}
	}
	
	public String popupDetail() {
		ipLevel2Bean = getIpLevel2Bean();
		try{
			
			IpLevel2 ipLevel2 = selectRowLevel2(ipLevel2Bean);
			ipLevel2Bean.setIpLevel2(ipLevel2);
			if (IPFMUtils.ifBlank(ipLevel2.getIpStatus(), "").trim().length()==0) ipLevel2.setIpStatus("A");
			for(SelectItem item : ipLevel2Bean.getAllIpStatusList()){
				IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
				if (cmb.getValue().equalsIgnoreCase(ipLevel2.getIpStatus())) {
					ipLevel2Bean.setIpStatusComboItem(cmb);
					ipLevel2Bean.setIpStatusName(cmb.getLabel());
					break;
				}
			}
			ipLevel2Bean.setIpTypeComboItem(new IPFMRichComboItem(ipLevel2.getIpTypeId(),ipLevel2.getIpTypeName()));
			ipLevel2Bean.setNetworkTypeComboItem(new IPFMRichComboItem(ipLevel2.getNetworkTypeId(),ipLevel2.getNetworkTypeName()));
			ipLevel2Bean.setIpTypeComboItem(new IPFMRichComboItem(ipLevel2.getIpTypeId(),ipLevel2.getIpTypeName()));
			ipLevel2Bean.setNetworkZoneComboItem(new IPFMRichComboItem(ipLevel2.getNetworkZoneId(),ipLevel2.getNetworkZoneName()));
			ipLevel2Bean.setLocationComboItem(new IPFMRichComboItem(ipLevel2.getLocationId(),ipLevel2.getLocationName()));
			ipLevel2Bean.setInstallTypeComboItem(new IPFMRichComboItem(ipLevel2.getInstallTypeId(),ipLevel2.getInstallTypeName()));
			prepareStatusEdit(ipLevel2Bean);
			prepareIPStatusList(ipLevel2Bean);
			setIpLevel2Bean(ipLevel2Bean);
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
	public String save(){
//		System.out.println("----- save ------");
		ipLevel2Bean = getIpLevel2Bean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{
			if (validatePopUp()) {
				ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
				if(managementIpService.validateOverExpire(ipLevel2Bean.getIpLevel2().getLevel1Id(),ipLevel2Bean.getIpLevel2().getExpiredDateFormat())){
//					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0083")));
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0072"),"Expire Date"));
					return null;
				}
				
				prepareComboBox();
				ipLevel2Bean.getIpLevel2().setLastUpdBy(userSession.getIpUser().getUserId());
				managementIpService.saveIpLevel2(ipLevel2Bean.getIpLevel2(),userSession.getIpUser().getUserId());
				ipLevel2Bean.setIpLevel2List(refreshTable(ipLevel2Bean.isSearchFlag()));
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
			setIpLevel2Bean(ipLevel2Bean);
//			System.out.println("----- save finish ------");
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
	public String popupExpireDate(){
		ipLevel2Bean = getIpLevel2Bean();
		try{
			if (ipLevel2Bean.getIpLevel2DataTable().getRowCount()>0) {
				HtmlDataTable dataTable = ipLevel2Bean.getIpLevel2DataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				if (endRow==0) endRow = dataTable.getRowCount();
				int checkCount = 0;
				for (int i=startRow ; i<endRow ; i++) {
					if (i == dataTable.getRowCount()) break;
					dataTable.setRowIndex(i);
					IpLevel2 ipLevel2 = (IpLevel2) dataTable.getRowData();
	                if (ipLevel2.isRowCheck() && !ipLevel2.getLevel2Id().equalsIgnoreCase("0")){
	                	checkCount++;
	                }	                	
				}
				if (checkCount==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0032")));
				}else{
					//clear value
					ipLevel2Bean.setExpiredDate(null);
					ipLevel2Bean.setCheckBoxExpiredDate(false);
					ipLevel2Bean.setCheckBoxIPStatus(false);
					ipLevel2Bean.setCheckBoxSystemName(false);
					ipLevel2Bean.setSystemNameUpdateInfo(null);
					ipLevel2Bean.setIpStatusName(null);
					prepareIPStatusListUpdateInfo(ipLevel2Bean);				
				}
			}
			setIpLevel2Bean(ipLevel2Bean);
//		}catch (IPFMBusinessException e){
//			e.printStackTrace();
//			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
	public String updateExpireDate(){
		ipLevel2Bean = getIpLevel2Bean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.US);
		try{
			if(ipLevel2Bean.isCheckBoxExpiredDate() || ipLevel2Bean.isCheckBoxIPStatus() || ipLevel2Bean.isCheckBoxSystemName()){
				ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
				List<IpLevel2> level2List = new ArrayList<IpLevel2>();
				for (IpLevel2 ipLevel2 : ipLevel2Bean.getIpLevel2List()) {
					IpLevel2 lv2 = (IpLevel2)ipLevel2.clone();
					if (lv2.isRowCheck() && !ipLevel2.getLevel2Id().equalsIgnoreCase("0")) {
						if(ipLevel2Bean.isCheckBoxExpiredDate()){
							if(ipLevel2Bean.getExpiredDate() == null) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
							}else if (lv2.getEffectiveDate().compareTo(ipLevel2Bean.getExpiredDate())>0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
							}
							if (ipLevel2Bean.getExpiredDate()!=null && 
									managementIpService.validateOverExpire(lv2.getLevel1Id(), sdf.format(ipLevel2Bean.getExpiredDate()))){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0072"),"Expire Date"));
							}
							if (IPFMMessageUtils.hasMessages()) return null;
							lv2.setExpiredDate(ipLevel2Bean.getExpiredDate());						
						}
						if(ipLevel2Bean.isCheckBoxSystemName()){
							lv2.setSystemName(ipLevel2Bean.getSystemNameUpdateInfo());
						}
						if(ipLevel2Bean.isCheckBoxIPStatus()){
							if(ipLevel2Bean.getIpStatusComboItem()!=null && ipLevel2Bean.getIpStatusComboItem().getValue()!=null){
								lv2.setIpStatusOld(lv2.getIpStatus());
								lv2.setIpStatus(ipLevel2Bean.getIpStatusComboItem().getValue());														
							}else{
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Status"));
								return null;
							}
						}
						lv2.setLastUpdBy(IPFMWebUtil.getUserSession().getIpUser().getUserId());
						level2List.add(lv2);
					}
				}
				if (level2List.size()>0) {
					if(!ipLevel2Bean.isCheckBoxIPStatus()){
						managementIpService.updateIpLevel2ExpireDate(level2List);	
					}else{
						managementIpService.saveIpLevel2(level2List, IPFMWebUtil.getUserSession().getIpUser().getUserId());
					}					
					ipLevel2Bean.setCheckAll(false);
					ipLevel2Bean.setIpLevel2List(refreshTable(ipLevel2Bean.isSearchFlag()));
				}
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				setIpLevel2Bean(ipLevel2Bean);
			}else{
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0203")));
			}
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
	public List<IpLevel2> refreshTable(boolean searchFlag){
		List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{			
			int maxSearchResult = getIPFMConfig().getMaxSearchResult();
			if (searchFlag){
				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
					|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)
					|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
					if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(), "").trim().length()==0) {
						ipLevel2List = managementIpService.searchIpManagementLevel2(ipLevel2Bean.getIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), "32",maxSearchResult);
					}else{
						ipLevel2List = managementIpService.searchIpManagementLevel2(ipLevel2Bean.getIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), ipLevel2Bean.getParamSearchMask(),maxSearchResult);			
					}
				}else if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)
						|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)) {
					if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(), "").trim().length()==0) {
						ipLevel2List = managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), "32", userSession.getIpUser().getTeamId(),maxSearchResult);
					}else{
						ipLevel2List = managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), ipLevel2Bean.getParamSearchMask(),userSession.getIpUser().getTeamId(),maxSearchResult);			
					}
				}
			}else{
				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
						|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)
						|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
					ipLevel2List = managementIpService.searchIpManagementLevel2(ipLevel2Bean.getIpVersion(), "0", "0", "0", "0", "0",maxSearchResult);
//					ipLevel2List = managementIpService.findAllIpLevel2(maxSearchResult);
				}else if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) 
						|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)) {
					ipLevel2List = managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getIpVersion(), "0", "0", "0", "0", "0",userSession.getIpUser().getTeamId(),maxSearchResult);
//					ipLevel2List = managementIpService.findIpLevel2ByTeam(userSession.getIpUser().getTeamId(),maxSearchResult);	
				}
			}
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return ipLevel2List;
	}
	
//	public List<IpLevel2> refreshTable(boolean searchFlag){
//		List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
//		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
//		UserSession userSession = IPFMWebUtil.getUserSession();
//		try{			
//			if (searchFlag){
//				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
//					|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)) {
//					if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(), "").trim().length()==0) {
//						ipLevel2List = managementIpService.searchIpManagementLevel2(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), "32");
//					}else{
//						ipLevel2List = managementIpService.searchIpManagementLevel2(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), ipLevel2Bean.getParamSearchMask());			
//					}
//				}else if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)) {
//					if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(), "").trim().length()==0) {
//						ipLevel2List = managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), "32", userSession.getIpUser().getTeamId());
//					}else{
//						ipLevel2List = managementIpService.searchIpManagementLevel2ByTeam(ipLevel2Bean.getParamIpVersion(), ipLevel2Bean.getParamSearchIp1(), ipLevel2Bean.getParamSearchIp2(), ipLevel2Bean.getParamSearchIp3(), ipLevel2Bean.getParamSearchIp4(), ipLevel2Bean.getParamSearchMask(),userSession.getIpUser().getTeamId());			
//					}
//				}
//			}else{
//				if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
//						|| ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)) {
//					ipLevel2List = managementIpService.findAllIpLevel2();				
//				}else if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)) {
//					ipLevel2List = managementIpService.findIpLevel2ByTeam(userSession.getIpUser().getTeamId());	
//				}
//			}
//		}catch (IPFMBusinessException e){
//			e.printStackTrace();
//			IPFMMessageUtils.addMessageError(e.getMessage());
//		}catch (Exception e) {
//			e.printStackTrace();
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
//		}
//		return ipLevel2List;
//	}
	
	public IpLevel2 selectRowLevel2(IpLevel2Bean ipLevel2Bean) throws CloneNotSupportedException{		
		ipLevel2Bean.getIpLevel2DataTable().setRowIndex(Integer.parseInt(getRequestParameter("rowIndex")));
		IpLevel2 ipLevel2 = (IpLevel2)((IpLevel2)ipLevel2Bean.getIpLevel2DataTable().getRowData()).clone();
		ipLevel2.setIpStatusOld(ipLevel2.getIpStatus());
		return ipLevel2;
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;		
		if(IPFMUtils.ifBlank(ipLevel2Bean.getIpVersion(),"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}
		if(IPFMUtils.ifBlank(ipLevel2Bean.getSearchIp1(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel2Bean.getSearchIp2(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel2Bean.getSearchIp3(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel2Bean.getSearchIp4(),"").trim().length()==0 ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		}
		if (IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(),"").trim().length()>0) {
			if (Integer.parseInt(IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(),"").trim()) < 8 || 
				Integer.parseInt(IPFMUtils.ifBlank(ipLevel2Bean.getSearchMask(),"").trim())>32 ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
			}
		}
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	public boolean validatePopUp() {
		boolean flgValid = true;
		if(IPFMUtils.ifBlank(ipLevel2Bean.getIpStatusComboItem().getValue(),"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Status"));
		}
		if(ipLevel2Bean.getIpLevel2().getExpiredDate() == null) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
		}else if (ipLevel2Bean.getIpLevel2().getEffectiveDate().compareTo(ipLevel2Bean.getIpLevel2().getExpiredDate())>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
		}
		if(IPFMUtils.ifBlank(ipLevel2Bean.getIpLevel2().getT2Remark(),"").trim().length()>1000) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Remark"));
		}
		
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	public void prepareComboBox() {
		IpLevel2 ipLevel2 = ipLevel2Bean.getIpLevel2();
		ipLevel2.setIpStatus(ipLevel2Bean.getIpStatusComboItem().getValue()==null?"":ipLevel2Bean.getIpStatusComboItem().getValue());
		ipLevel2.setIpTypeId(ipLevel2Bean.getIpTypeComboItem().getValue()==null?"":ipLevel2Bean.getIpTypeComboItem().getValue());
		ipLevel2.setIpTypeName(ipLevel2Bean.getIpTypeComboItem().getValue()==null?"":ipLevel2Bean.getIpTypeComboItem().getLabel());
		ipLevel2.setNetworkTypeId(ipLevel2Bean.getNetworkTypeComboItem().getValue()==null?"":ipLevel2Bean.getNetworkTypeComboItem().getValue());
		ipLevel2.setNetworkTypeName(ipLevel2Bean.getNetworkTypeComboItem().getValue()==null?"":ipLevel2Bean.getNetworkTypeComboItem().getLabel());
		ipLevel2.setNetworkZoneId(ipLevel2Bean.getNetworkZoneComboItem().getValue()==null?"":ipLevel2Bean.getNetworkZoneComboItem().getValue());
		ipLevel2.setNetworkZoneName(ipLevel2Bean.getNetworkZoneComboItem().getValue()==null?"":ipLevel2Bean.getNetworkZoneComboItem().getLabel());
		ipLevel2.setLocationId(ipLevel2Bean.getLocationComboItem().getValue()==null?"":ipLevel2Bean.getLocationComboItem().getValue());
		ipLevel2.setLocationName(ipLevel2Bean.getLocationComboItem().getValue()==null?"":ipLevel2Bean.getLocationComboItem().getLabel());
		ipLevel2.setInstallTypeId(ipLevel2Bean.getInstallTypeComboItem().getValue()==null?"":ipLevel2Bean.getInstallTypeComboItem().getValue());
		ipLevel2.setInstallTypeName(ipLevel2Bean.getInstallTypeComboItem().getValue()==null?"":ipLevel2Bean.getInstallTypeComboItem().getLabel());
    }

	public void validateCheckBoxIPStatus(){
		ipLevel2Bean = getIpLevel2Bean();
		BigDecimal sumIP = new BigDecimal(0);
		BigDecimal totalIP = new BigDecimal(0);
		
		try {
			if(ipLevel2Bean.isCheckBoxIPStatus()){
				for (IpLevel2 ipLevel2 : ipLevel2Bean.getIpLevel2List()) {
					if (ipLevel2.isRowCheck() && !ipLevel2.getLevel2Id().equalsIgnoreCase("0")){
						sumIP = ipLevel2.getAvailableIp().add(ipLevel2.getAssignIp()).add(ipLevel2.getTerminateIp());
						if(ipLevel2.getTotalIp().intValue() != sumIP.intValue()){
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0204")));
							break;
						}
						totalIP = totalIP.add(sumIP);
						if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)) {
							if (!ipLevel2.getIpStatus().equalsIgnoreCase("P")){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0206")));
								break;
							}
						} else if (ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) || 
								ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23) ||
								ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) || 
								ipLevel2Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
							if (!ipLevel2.getIpStatus().equalsIgnoreCase("A")){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0207")));
								break;
							}
						} 
					}					
				}
			}
			if(totalIP.intValue()>256){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0205")));
			}
			if(IPFMMessageUtils.hasMessages()){
				ipLevel2Bean.setCheckBoxIPStatus(false);
			}
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
}
