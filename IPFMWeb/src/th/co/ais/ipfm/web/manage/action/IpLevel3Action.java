package th.co.ais.ipfm.web.manage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.event.UploadEvent;

import th.co.ais.ehr.domain.EmployeeProfileOM;
import th.co.ais.ehr.domain.UserAccount;
import th.co.ais.ehr.service.AuthenDBService;
import th.co.ais.ehr.service.EmployeeProfileService2;
import th.co.ais.ipfm.domain.IPLevel3NatHistory;
import th.co.ais.ipfm.domain.IPMasterValue;
import th.co.ais.ipfm.domain1.ExcelErrorMsg;
import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpInfoTemp;
import th.co.ais.ipfm.domain1.IpLogVerify;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvNetworkIp;
import th.co.ais.ipfm.domain1.Project;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPUserService;
import th.co.ais.ipfm.service.ManagementIpService;
import th.co.ais.ipfm.service.ProjectService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IpLevel3Bean;
import th.co.ais.ipfm.web.util.ExportUtils;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.ImportUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpLevel3Action  extends AbstractAction {
	private static Logger logger = Logger.getLogger(IpLevel3Action.class);
	
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("en","EN"));
	/********************** Bean ***********************/
	public IpLevel3Bean ipLevel3Bean;
	
	public IpLevel3Bean getIpLevel3Bean() {
		return (IpLevel3Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ipLevel3Bean");
	}

	public void setIpLevel3Bean(IpLevel3Bean ipLevel3Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ipLevel3Bean", ipLevel3Bean);
	}
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		ipLevel3Bean = getIpLevel3Bean();		
		if(TablSort.equalsIgnoreCase("IPDataTable1")) {
			ipLevel3Bean.setSortSIP003View(sortColumnChange());	
		}  
		return "";
	}
	
	
	@Override
	public String init(String programID) {
		try{
			IpLevel3Bean ipLevel3Bean = new IpLevel3Bean();
			UserSession userSession = IPFMWebUtil.getUserSession();
			ipLevel3Bean.setUserSession(userSession);
			IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
			List<SelectItem> ipStatusStringList= IPFMComboBoxUtil.getInstance().getIPStatusComboBoxItems();
			List<SelectItem> ipStatusList= new ArrayList<SelectItem>();
			List<SelectItem> projManagerList= new ArrayList<SelectItem>();
			
			ipLevel3Bean.setAllIpStatusList(ipStatusStringList);
			
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			List<IpRoleMember> roleMemberList = managementIpService.findIpRoleMemberByUserId(userSession.getIpUser().getUserId());
			ipLevel3Bean.setUserRole(IPFMConstant.TIER3);
			for(IpRoleMember roleMember : roleMemberList){
				if (roleMember.getRoleId().equalsIgnoreCase("R04")) {
//					ipLevel3Bean.setUserRole(IPFMConstant.TIER2);
					ipLevel3Bean.setUserRole(IPFMConstant.TIER23);
				}
				if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && !roleMember.getRoleId().equalsIgnoreCase("R04") && !roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel3Bean.setUserRole(IPFMConstant.TIER23);
				}
				if (!ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel3Bean.setUserRole(IPFMConstant.TIER1);
				}
				if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2) && roleMember.getRoleId().equalsIgnoreCase("R05")) {
					ipLevel3Bean.setUserRole(IPFMConstant.TIER12);
				}
				if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12) && !roleMember.getRoleId().equalsIgnoreCase("R04") && !roleMember.getRoleId().equalsIgnoreCase("R05") ){
					ipLevel3Bean.setUserRole(IPFMConstant.TIER123);
				}
			}
			
			List<IpUser> projectManagerStringList = ipUserService.getSystemOwnerList();
			if(projectManagerStringList!=null && projectManagerStringList.size()>0){
				for (IpUser str:projectManagerStringList) {
					IPFMRichComboItem cbitem = new IPFMRichComboItem();
					cbitem.setLabel(str.getUserName());
					cbitem.setValue(str.getUserId());
					projManagerList.add(new SelectItem(cbitem, cbitem.getLabel()));
				}
			}
			
			//SystemOwner DropDown	
//			List<IpUser> systemOwnerStringList = ipUserService.getSystemOwnerList();
//			if(systemOwnerStringList!=null && systemOwnerStringList.size()>0){
//				for (IpUser str:systemOwnerStringList) {
//					IPFMRichComboItem cbitem = new IPFMRichComboItem();
//					cbitem.setLabel(str.getUserName());
//					cbitem.setValue(str.getUserId());
//					systemOwnerList.add(new SelectItem(cbitem, cbitem.getLabel()));
//				}
//			}
			
			ipLevel3Bean.setCompanyList(IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems());
			ipLevel3Bean.setIpTypeList(IPFMComboBoxUtil.getInstance().getIPTypeListComboBoxItems());
			ipLevel3Bean.setSysOwnerList(projManagerList);
			ipLevel3Bean.setProjManagerList(projManagerList);
			ipLevel3Bean.setProjectList(getProjectListSelecItem());
			ipLevel3Bean.setLocationList(IPFMComboBoxUtil.getInstance().getLocationComboBoxItems());
			ipLevel3Bean.setNwTypeList(IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems());
			ipLevel3Bean.setNetworkZoneList(IPFMComboBoxUtil.getInstance().getZoneComboBoxItems());
			ipLevel3Bean.setIpStatusList(ipStatusList);
			ipLevel3Bean.setNetworkIpList(getSelectNetworkIpList(ipLevel3Bean.getUserRole()));
			if (ipLevel3Bean.getNetworkIpList().size()>0) {
				ipLevel3Bean.setIpAddress(ipLevel3Bean.getNetworkIpList().get(0).getNetworkIp());
				ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole(), ipLevel3Bean.getIpAddress(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId()));
				if (ipLevel3Bean.getNetworkIpList().size()>getIPFMConfig().getMaxSearchResult()) {
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("Network IP มึ"+ErrorMessageUtil.getMessage("ER0074"),String.valueOf(getIPFMConfig().getMaxSearchResult())));
					ipLevel3Bean.getNetworkIpList().remove(getIPFMConfig().getMaxSearchResult());
				}
			}else{
				ipLevel3Bean.setIpInfoList(new ArrayList<IpInfo>());
			}
			setIpLevel3Bean(ipLevel3Bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		} catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return programID;
	}
	private List<IpvNetworkIp> getSelectNetworkIpSearchList(IpLevel3Bean bean, String userRole) {
		List<IpvNetworkIp> IpvNetworkIpList = new ArrayList<IpvNetworkIp>();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{			
			int maxSearchResult = getIPFMConfig().getMaxSearchResult()+1;
			if (userRole.equalsIgnoreCase(IPFMConstant.TIER1) || userRole.equalsIgnoreCase(IPFMConstant.TIER12) || userRole.equalsIgnoreCase(IPFMConstant.TIER123)) {
				IpvNetworkIpList = managementIpService.searhNetworkIpRangeByTier1(bean.getParamSearchIp1(), bean.getParamSearchIp2(), bean.getParamSearchIp3(), bean.getParamSearchIp4(), bean.getParamSearchMask(),maxSearchResult);
			} else if (userRole.equalsIgnoreCase(IPFMConstant.TIER2) || userRole.equalsIgnoreCase(IPFMConstant.TIER23)) {
				IpvNetworkIpList = managementIpService.searhNetworkIpRangeByTier2(bean.getParamSearchIp1(), bean.getParamSearchIp2(), bean.getParamSearchIp3(), bean.getParamSearchIp4(), bean.getParamSearchMask(),userSession.getIpUser().getTeamId(),userSession.getIpUser().getUserId(),maxSearchResult);
			} else if (userRole.equalsIgnoreCase(IPFMConstant.TIER3)) {
				IpvNetworkIpList = managementIpService.searhNetworkIpRangeByTier3(bean.getParamSearchIp1(), bean.getParamSearchIp2(), bean.getParamSearchIp3(), bean.getParamSearchIp4(), bean.getParamSearchMask(),userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId(),maxSearchResult);
			} 
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return IpvNetworkIpList;
	}
	private List<IpvNetworkIp> getSelectNetworkIpList(String userRole) {
		List<IpvNetworkIp> IpvNetworkIpList = new ArrayList<IpvNetworkIp>();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{			
			int maxSearchResult = getIPFMConfig().getMaxSearchResult()+1;
			if (userRole.equalsIgnoreCase(IPFMConstant.TIER1) || userRole.equalsIgnoreCase(IPFMConstant.TIER12) || userRole.equalsIgnoreCase(IPFMConstant.TIER123)) {
				IpvNetworkIpList = managementIpService.searhNetworkIpByTier1(maxSearchResult);
			} else if (userRole.equalsIgnoreCase(IPFMConstant.TIER2) || userRole.equalsIgnoreCase(IPFMConstant.TIER23)) {
				IpvNetworkIpList = managementIpService.searhNetworkIpByTier2(userSession.getIpUser().getTeamId(),userSession.getIpUser().getUserId(),maxSearchResult);
			} else if (userRole.equalsIgnoreCase(IPFMConstant.TIER3)) {
				IpvNetworkIpList = managementIpService.searhNetworkIpByTier3(userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId(),maxSearchResult);
			} 
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return IpvNetworkIpList;
	}
	public boolean validateSearchIP() {
		boolean flgValid = true;		
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpVersion(),"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}
		if(IPFMUtils.ifBlank(ipLevel3Bean.getSearchIp1(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel3Bean.getSearchIp2(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel3Bean.getSearchIp3(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipLevel3Bean.getSearchIp4(),"").trim().length()==0 ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		}
		if (IPFMUtils.ifBlank(ipLevel3Bean.getSearchMask(),"").trim().length()>0) {
			if (Integer.parseInt(IPFMUtils.ifBlank(ipLevel3Bean.getSearchMask(),"").trim()) < 8 || 
				Integer.parseInt(IPFMUtils.ifBlank(ipLevel3Bean.getSearchMask(),"").trim()) > 32 ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
			}
		}else{
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
		}
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	public String searchNetworkIP(){
		ipLevel3Bean = getIpLevel3Bean();
		try{
			UserSession userSession = IPFMWebUtil.getUserSession();
			if (validateSearchIP()) {
				ipLevel3Bean.setSearchFlag(true);
				ipLevel3Bean.setParamIpVersion(ipLevel3Bean.getIpVersion());
				ipLevel3Bean.setParamSearchIp1(ipLevel3Bean.getSearchIp1());
				ipLevel3Bean.setParamSearchIp2(ipLevel3Bean.getSearchIp2());
				ipLevel3Bean.setParamSearchIp3(ipLevel3Bean.getSearchIp3());
				ipLevel3Bean.setParamSearchIp4(ipLevel3Bean.getSearchIp4());
				ipLevel3Bean.setParamSearchIp5(ipLevel3Bean.getSearchIp5());
				ipLevel3Bean.setParamSearchIp6(ipLevel3Bean.getSearchIp6());
				ipLevel3Bean.setParamSearchMask(ipLevel3Bean.getSearchMask());
				
				ipLevel3Bean.setNetworkIpList(getSelectNetworkIpSearchList(ipLevel3Bean,ipLevel3Bean.getUserRole()));
				if (ipLevel3Bean.getNetworkIpList().size()>0) {
					ipLevel3Bean.setIpAddress(ipLevel3Bean.getNetworkIpList().get(0).getNetworkIp());
					ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole(), ipLevel3Bean.getIpAddress(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId()));
					if (ipLevel3Bean.getNetworkIpList().size()>getIPFMConfig().getMaxSearchResult()) {
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("Network IP มึ"+ErrorMessageUtil.getMessage("ER0074"),String.valueOf(getIPFMConfig().getMaxSearchResult())));
						ipLevel3Bean.getNetworkIpList().remove(getIPFMConfig().getMaxSearchResult());
					}
				}else{
					ipLevel3Bean.setIpInfoList(new ArrayList<IpInfo>());
				}
				unsortedAllColumnRichDataTable(ipLevel3Bean.getIpInfoDataTable());
				ipLevel3Bean.setCheckAll(false);
			}
			setIpLevel3Bean(ipLevel3Bean);
//		}catch (IPFMBusinessException e){
//			e.printStackTrace();
//			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	public void reset() {
		UserSession userSession = IPFMWebUtil.getUserSession();
		ipLevel3Bean = getIpLevel3Bean();
		try{
			ipLevel3Bean.setSearchFlag(false);
			ipLevel3Bean.setIpVersion("4");
			ipLevel3Bean.setSearchIp1("");
			ipLevel3Bean.setSearchIp2("");
			ipLevel3Bean.setSearchIp3("");
			ipLevel3Bean.setSearchIp4("");
			ipLevel3Bean.setSearchIp5("");
			ipLevel3Bean.setSearchIp6("");
			ipLevel3Bean.setSearchMask("");
			ipLevel3Bean.setScrollerPage(1);
			ipLevel3Bean.setParamIpVersion("4");
			ipLevel3Bean.setParamSearchIp2("");
			ipLevel3Bean.setParamSearchIp3("");
			ipLevel3Bean.setParamSearchIp4("");
			ipLevel3Bean.setParamSearchIp5("");
			ipLevel3Bean.setParamSearchIp6("");
			ipLevel3Bean.setParamSearchMask("");
			ipLevel3Bean.setCheckBoxNat(false);
			ipLevel3Bean.setScrollerPage(1);
			ipLevel3Bean.setCheckAll(false);
			ipLevel3Bean.setNetworkIpList(getSelectNetworkIpList(ipLevel3Bean.getUserRole()));
			if (ipLevel3Bean.getNetworkIpList().size()>0) {
				ipLevel3Bean.setIpAddress(ipLevel3Bean.getNetworkIpList().get(0).getNetworkIp());
				ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole(), ipLevel3Bean.getIpAddress(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId()));
				if (ipLevel3Bean.getNetworkIpList().size()>getIPFMConfig().getMaxSearchResult()) {
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("Network IP มึ"+ErrorMessageUtil.getMessage("ER0074"),String.valueOf(getIPFMConfig().getMaxSearchResult())));
					ipLevel3Bean.getNetworkIpList().remove(getIPFMConfig().getMaxSearchResult());
				}
			}else{
				ipLevel3Bean.setIpInfoList(new ArrayList<IpInfo>());
			}
			unsortedAllColumnRichDataTable(ipLevel3Bean.getIpInfoDataTable());
			setIpLevel3Bean(ipLevel3Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	public IpInfo selectRowIpInfo(IpLevel3Bean ipLevel3Bean) throws CloneNotSupportedException{
		ipLevel3Bean.getIpInfoDataTable().setRowIndex(Integer.parseInt(getRequestParameter("rowIndex")));
		IpInfo ipInfo = (IpInfo)((IpInfo)ipLevel3Bean.getIpInfoDataTable().getRowData()).clone();
		return ipInfo;
	}
	
	public void prepareIPStatusList(IpLevel3Bean ipLevel3Bean) throws Exception{
		UserSession userSession = IPFMWebUtil.getUserSession();
		IpInfo ipInfo = ipLevel3Bean.getIpInfo();
		List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
		Date currentDate = IPFMDataUtility.getCurrentDateByPattern();
		for (SelectItem item : ipLevel3Bean.getAllIpStatusList()) {
			IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();			
			if (ipInfo.getSystemOwnerTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId()) 
				|| ipInfo.getSystemOwner().equalsIgnoreCase(userSession.getIpUser().getUserId())) {
				if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
					if (ipInfo.getIpStatus().equalsIgnoreCase("A") && (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
						|| cmb.getValue().equalsIgnoreCase("R")
						|| cmb.getValue().equalsIgnoreCase("U"))) {
						ipStatusList.add(item);
					}else if (ipInfo.getIpStatus().equalsIgnoreCase("R") 
							&& (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
							|| cmb.getValue().equalsIgnoreCase("U") || cmb.getValue().equalsIgnoreCase("T"))) {
							ipStatusList.add(item);
					}else if (ipInfo.getIpStatus().equalsIgnoreCase("U") 
							&& (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
							|| cmb.getValue().equalsIgnoreCase("T"))) {
							ipStatusList.add(item);
					}else if (ipInfo.getIpStatus().equalsIgnoreCase("T") 
							&& (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()))){
						ipStatusList.add(item);						
					}
				}else if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)	
						|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)
						|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)
						|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
					
					if (ipInfo.getIpStatus().equalsIgnoreCase("A") && (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus())
							//|| cmb.getValue().equalsIgnoreCase("P")
							|| cmb.getValue().equalsIgnoreCase("R")
							|| cmb.getValue().equalsIgnoreCase("U"))) {
							ipStatusList.add(item);
					}else if (ipInfo.getIpStatus().equalsIgnoreCase("R") && (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
							|| cmb.getValue().equalsIgnoreCase("U") 
							|| cmb.getValue().equalsIgnoreCase("T"))) {
							ipStatusList.add(item);
					}else if (ipInfo.getIpStatus().equalsIgnoreCase("U") && (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
							|| cmb.getValue().equalsIgnoreCase("T"))) {
							ipStatusList.add(item);
					}else if (ipInfo.getIpStatus().equalsIgnoreCase("T") && (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus())
							//|| cmb.getValue().equalsIgnoreCase("P")
							)){
						ipStatusList.add(item);
					}
				}
			}else{
				if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)	
					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)
					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)
					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
					if (ipInfo.getIpStatus().equalsIgnoreCase("T") || ipInfo.getIpStatus().equalsIgnoreCase("A")) {
						if (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) || cmb.getValue().equalsIgnoreCase("P")){
							ipStatusList.add(item);
						}
					}
				}
			}
			
//			if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)
//				|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
//				if (ipInfo.getSystemOwner().equalsIgnoreCase(userSession.getIpUser().getUserId()) ||
//					ipInfo.getSystemOwnerTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())){
//					if (ipInfo.getIpStatus().equalsIgnoreCase("A") && (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
//						|| cmb.getValue().equalsIgnoreCase("R")
//						|| cmb.getValue().equalsIgnoreCase("U"))) {
//						ipStatusList.add(item);
//					}else if (ipInfo.getIpStatus().equalsIgnoreCase("R") 
//							&& (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
//							|| cmb.getValue().equalsIgnoreCase("U") || cmb.getValue().equalsIgnoreCase("T"))) {
//							ipStatusList.add(item);
//					}else if (ipInfo.getIpStatus().equalsIgnoreCase("U") 
//							&& (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) 
//							|| cmb.getValue().equalsIgnoreCase("T"))) {
//							ipStatusList.add(item);
//					}else if (ipInfo.getIpStatus().equalsIgnoreCase("T") 
//							&& (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()))){
//						ipStatusList.add(item);
//					}
//				}
//			} else if (ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)	
//					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)
//					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)
//					|| ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
//				if (ipInfo.getIpStatus().equalsIgnoreCase("T") || ipInfo.getIpStatus().equalsIgnoreCase("A")) {
//					if (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus()) || cmb.getValue().equalsIgnoreCase("P")){
//						ipStatusList.add(item);
//					}
//				}
//			}
		}
		if (ipStatusList!=null && ipStatusList.size()>1) ipLevel3Bean.setIpStatusEdit(true);
		else ipLevel3Bean.setIpStatusEdit(false);
		ipLevel3Bean.setIpStatusList(ipStatusList);
	}
	public void prepareStatusEdit(IpLevel3Bean bean) throws Exception {
//		bean.setIpStatusEdit(false);
		IpInfo ipInfo = bean.getIpInfo();
		UserSession userSession = IPFMWebUtil.getUserSession();
//		Date currentDate = IPFMDataUtility.getCurrentDateByPattern();
//		if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER1)) {
//			if (ipInfo.getSystemOwner().equalsIgnoreCase(userSession.getIpUser().getUserId())
//				|| ipInfo.getSystemOwnerTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())) {
//				bean.setIpStatusEdit(true);
//			}
//		}else if (bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER12)
//				|| bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER2)
//				|| bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER23)
//				|| bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER123)) {
//			if (ipInfo.getIpStatus().equalsIgnoreCase("T")
//				|| ipInfo.getIpStatus().equalsIgnoreCase("A")) {
//					bean.setIpStatusEdit(true);
//				}
//		}else{
//			bean.setIpStatusEdit(true);
//		}
		
		if (!bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
			bean.setCompanyEdit(true);
			bean.setIpTypeEdit(true);
			bean.setInstallTypeEdit(true);
			bean.setNetworkZoneEdit(true);
			bean.setNetworkIpEdit(true);
			bean.setGatewayEdit(true);
			bean.setUrReferEdit(true);
			bean.setVlanIdEdit(true);
			if (ipInfo.getSystemOwner().equalsIgnoreCase(userSession.getIpUser().getUserId())
					|| ipInfo.getSystemOwnerTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())) { 
				bean.setT3RemarksEdit(true);
			}else{
				bean.setT3RemarksEdit(false);
			}
		}else{
			bean.setCompanyEdit(false);
			bean.setIpTypeEdit(false);
			bean.setInstallTypeEdit(false);
			bean.setNetworkIpEdit(false);
			bean.setGatewayEdit(false);
			bean.setUrReferEdit(false);
			bean.setVlanIdEdit(false);
			bean.setNetworkZoneEdit(false);
			bean.setT3RemarksEdit(true);
		}
	}
	
	public String popupDetail() {
		ipLevel3Bean = getIpLevel3Bean();
		try{
			UserSession userSession = IPFMWebUtil.getUserSession();
			IpInfo ipInfo = selectRowIpInfo(ipLevel3Bean);
			ipLevel3Bean.setOldIpStatus(ipInfo.getIpStatus());
			if (IPFMUtils.ifBlank(ipInfo.getIpStatus(), "").trim().length()==0) ipInfo.setIpStatus("A");
			for(SelectItem item : ipLevel3Bean.getAllIpStatusList()){
				IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
				if (cmb.getValue().equalsIgnoreCase(ipInfo.getIpStatus())) {
					ipLevel3Bean.setIpStatusComboItem(cmb);
					IpMasterTable status = new IpMasterTable();
					status.setShortDesc(cmb.getLabel());
					ipInfo.setStatus(status);
					break;
				}
			}
			
			boolean canUpdateNatip = checkPermissionUpdateNatIP(userSession.getIpUser().getUserId(), ipInfo.getIpAddress());
			ipLevel3Bean.setNatIpPermission(canUpdateNatip);
			ipLevel3Bean.setStatusEditAble(true);
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			List<IpRoleMember> roleMemberList = managementIpService.findIpRoleMemberByUserId(userSession.getIpUser().getUserId());
			for(IpRoleMember roleMember : roleMemberList){
				if (roleMember.getRoleId().equalsIgnoreCase("R04")) {
					if(ipInfo.getSystemOwnerId() != null && !(ipInfo.getSystemOwner().equals(userSession.getIpUser().getUserId()))) {
						ipLevel3Bean.setStatusEditAble(false);
					}
					if(ipInfo.getSystemOwnerTeamId() != null && ipInfo.getSystemOwnerTeamId().equals(userSession.getIpUser().getTeamId())){
						ipLevel3Bean.setStatusEditAble(true);
					}
				}
			}			
			
			List<SelectItem> systemOwnerTeamList = new ArrayList<SelectItem>();
			IPFMRichComboItem userTeam = new IPFMRichComboItem(userSession.getIpUser().getTeamId(),userSession.getIpUser().getTeamName());
			systemOwnerTeamList.add(new SelectItem(userTeam, userSession.getIpUser().getTeamName()));
			if (IPFMUtils.ifBlank(ipInfo.getSystemOwnerTeamId(),"").trim().length()>0 && !ipInfo.getSystemOwnerTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())) {
				IPFMRichComboItem userTeam1 = new IPFMRichComboItem(ipInfo.getSystemOwnerTeamId(),ipInfo.getSystemOwnerTeamName());
				systemOwnerTeamList.add(new SelectItem(userTeam1, ipInfo.getSystemOwnerTeamName()));
			}
			ipLevel3Bean.setSysOwnerTeamList(systemOwnerTeamList);
			ipLevel3Bean.setIpInfo(ipInfo);
			prepareIPStatusList(ipLevel3Bean);
			prepareStatusEdit(ipLevel3Bean);
			ipLevel3Bean.setProjManagerId(ipInfo.getProjectManager());
			for(SelectItem selectItem : ipLevel3Bean.getCompanyList()){
				IPFMRichComboItem cmb = (IPFMRichComboItem)selectItem.getValue();
				if (cmb.getValue().equalsIgnoreCase(ipInfo.getCompanyId())){
					ipLevel3Bean.setCompanyComboItem(new IPFMRichComboItem(ipInfo.getCompanyId(),cmb.getLabel()));
					break;
				}
			}
			
			ipLevel3Bean.setIpTypeComboItem(new IPFMRichComboItem(ipInfo.getIpTypeId(),ipInfo.getIpTypeName()));
			ipLevel3Bean.setProjectComboItem(new IPFMRichComboItem(ipInfo.getProjectId(),ipInfo.getProjectId()));
			if (ipLevel3Bean.getProjectComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getProjectComboItem().getValue(),"").length()>0) {
				ipLevel3Bean.setProjNameDisable(true);
				ipLevel3Bean.setProjManagerDisable(true);
			} else {
				ipLevel3Bean.setProjNameDisable(false);
				ipLevel3Bean.setProjManagerDisable(false);
			}
			ipLevel3Bean.setProjManagerComboItem(new IPFMRichComboItem());
			ipLevel3Bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(ipInfo.getSystemOwnerTeamId(),ipInfo.getSystemOwnerTeamName()));
//			ipLevel3Bean.setSysOwnerComboItem(new IPFMRichComboItem(ipInfo.getSystemOwner(),ipInfo.getSystemOwnerName()));
			ipLevel3Bean.setNetworkTypeComboItem(new IPFMRichComboItem(ipInfo.getNetworkTypeId(),ipInfo.getNetworkTypeName()));
			ipLevel3Bean.setNetworkZoneComboItem(new IPFMRichComboItem(ipInfo.getNetworkZoneId(),ipInfo.getNetworkZoneName()));
			ipLevel3Bean.setLocationComboItem(new IPFMRichComboItem(ipInfo.getLocationId(),ipInfo.getLocationName()));
			
			setIpLevel3Bean(ipLevel3Bean);
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
		ipLevel3Bean = getIpLevel3Bean();
		try{
			if (validatePopUp()) {
				ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
				UserSession userSession = IPFMWebUtil.getUserSession();
				prepareComboBox();
				
				List<IPLevel3NatHistory> natHistory = new ArrayList<IPLevel3NatHistory>();
				if(ipLevel3Bean.getIpInfo() != null && ipLevel3Bean.getIpInfo().getIpAddress() != null){
					IPLevel3NatHistory hisData = managementIpService.validateInsertNatHis(ipLevel3Bean.getIpInfo().getIpAddress(), ipLevel3Bean.getIpInfo().getNatIp(), userSession.getIpUser().getUserId());
					if(hisData != null && hisData.getIpAddress() != null && !(hisData.getIpAddress().trim().equals(""))){
						natHistory.add(hisData);
					}
				}
				
				managementIpService.updateIpInfo(ipLevel3Bean.getOldIpStatus(), ipLevel3Bean.getIpInfo(), userSession.getIpUser().getUserId());
				
				if(natHistory != null && natHistory.size()>0){
					managementIpService.insertNatHistory(natHistory);
				}
				
				if (ipLevel3Bean.isSearchFlag()) {
					ipLevel3Bean.setNetworkIpList(getSelectNetworkIpSearchList(ipLevel3Bean,ipLevel3Bean.getUserRole()));
					if (ipLevel3Bean.getNetworkIpList().size()>0) {
						ipLevel3Bean.setIpAddress(ipLevel3Bean.getNetworkIpList().get(0).getNetworkIp());
						ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole(), ipLevel3Bean.getIpAddress(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId()));
						if (ipLevel3Bean.getNetworkIpList().size()>getIPFMConfig().getMaxSearchResult()) {
//							IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("Network IP มึ"+ErrorMessageUtil.getMessage("ER0074"),String.valueOf(getIPFMConfig().getMaxSearchResult())));
							ipLevel3Bean.getNetworkIpList().remove(getIPFMConfig().getMaxSearchResult());
						}
					}else{
						ipLevel3Bean.setIpInfoList(new ArrayList<IpInfo>());
					}
//					unsortedAllColumnRichDataTable(ipLevel3Bean.getIpInfoDataTable());
				}else{				
					ipLevel3Bean.setNetworkIpList(getSelectNetworkIpList(ipLevel3Bean.getUserRole()));
					if (ipLevel3Bean.getNetworkIpList().size()>getIPFMConfig().getMaxSearchResult()) {
	//					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0074"),String.valueOf(getIPFMConfig().getMaxSearchResult())));
						ipLevel3Bean.getNetworkIpList().remove(getIPFMConfig().getMaxSearchResult());
					}
				}
				ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole()
						,ipLevel3Bean.getIpAddress(),userSession.getIpUser().getTeamId()
						,userSession.getIpUser().getUserId()));
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
			ipLevel3Bean.setCheckAll(false);
			setIpLevel3Bean(ipLevel3Bean);
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
	public boolean validatePopUp() {
		
		boolean flgValid = true;
		
		if (IPFMUtils.ifBlank(ipLevel3Bean.getIpStatusComboItem().getValue(),"").equalsIgnoreCase("P")) {
			return true;
		}
		
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getHostName(),"").trim().length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Host Name"));
		}
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpStatusComboItem().getLabel(),"").length()==0){
			if (IPFMUtils.ifBlank(ipLevel3Bean.getIpStatusComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Status"));
			}
		}else{
			checkIpStatusCombo();
		}
		if (!ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
			if(IPFMUtils.ifBlank(ipLevel3Bean.getCompanyComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
			}
		}
		if(IPFMUtils.ifBlank(ipLevel3Bean.getNetworkTypeComboItem().getLabel(),"").trim().length()==0){
			if(IPFMUtils.ifBlank(ipLevel3Bean.getNetworkTypeComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Type"));
			}
		}else{
			checkNwTypeCombo();
		}
		
		if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwnerName(),"").length()>0 && IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwner(),"").length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), ipLevel3Bean.getIpInfo().getSystemOwnerName()));
		}
		if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwner(),"").length()==0 && IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").length()>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner"));
		}
		if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwner(),"").length()>0 && IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Team "));
		}
		
		
		
//		if(IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerComboItem().getValue(),"").trim().length()==0){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Name"));
//		}
//		if(IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").trim().length()==0){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Team"));
//		}
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getIpSubmask(),"").trim().length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
		}
		if (!ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
			if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getNetworkIp(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network IP"));
			}
		}
		if(ipLevel3Bean.getIpInfo().getExpiredDate() == null) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
		}else if (ipLevel3Bean.getIpInfo().getEffectiveDate().compareTo(ipLevel3Bean.getIpInfo().getExpiredDate())>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
		}else if (ipLevel3Bean.getIpInfo().getExpiredDate().compareTo(ipLevel3Bean.getIpInfo().getIpLevel2().getExpiredDate())>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0072"),"Expire Date"));
		}
		
		if (ipLevel3Bean.getProjectComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getProjectComboItem().getValue(),"").trim().length()==0) {
			if (IPFMUtils.ifBlank(ipLevel3Bean.getProjectComboItem().getLabel(),"").trim().length()>0) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0075"), ipLevel3Bean.getProjectComboItem().getLabel()));
			} 
//			else if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getProjectName(),"").trim().length()>0) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Project ID"));
//			}
		}
		if (ipLevel3Bean.getProjectComboItem()==null || IPFMUtils.ifBlank(ipLevel3Bean.getProjectComboItem().getValue(),"").trim().length()==0) {
			if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getProjectManager(),"").trim().length()>0
				&& IPFMUtils.ifBlank(ipLevel3Bean.getProjManagerId(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), ipLevel3Bean.getIpInfo().getProjectManager()));
			}
		} 
			
//		if (ipLevel3Bean.getProjectComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getProjectComboItem().getValue(),"").trim().length()>0) {
//			if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getProjectName(),"").trim().length()==0) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Project Name"));
//			}else if (!ipLevel3Bean.getProjectComboItem().getValue2().trim().equalsIgnoreCase(ipLevel3Bean.getIpInfo().getProjectName().trim())) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0063"), "Project ID" ,"Project Name"));
//			}
//			if(ipLevel3Bean.getProjManagerComboItem()!=null  && IPFMUtils.ifBlank(ipLevel3Bean.getProjManagerComboItem().getValue(),"").trim().length()>0){
//				ipLevel3Bean.getIpInfo().setProjectManager(IPFMUtils.stringCapitalize2((IPFMUtils.ifBlank(ipLevel3Bean.getProjManagerComboItem().getLabel(),""))));	
//			}
//			if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getProjectManager(),"").trim().length()==0) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Project Manager"));
//			}
//		} else if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getProjectName(),"").trim().length()>0) {
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Project ID"));
//		}
			
		if(IPFMUtils.ifBlank(ipLevel3Bean.getLocationComboItem().getValue(),"").trim().length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Site/Location"));
		}
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getVip(),"").trim().length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "VIP"));
		}
//		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getWyNodeName(),"").trim().length()==0) {
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Watching You Node Name"));
//		}
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getT3Remark(),"").trim().length()>1000) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Remarks"));
		}
		
		if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getNatIp(),"").trim().length()>1000) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "NAT IP"));
		}else if(!IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getNatIp(),"").trim().equals("")){
			String natData = ipLevel3Bean.getIpInfo().getNatIp();
			if(natData != null){
				IPFMDataValidateUtil util = new IPFMDataValidateUtil();
				if(!natData.trim().equals("")){
				String[] nat = natData.split(",");								
					for(String natip : nat){
						if(!util.validateIPFormat(natip)){		
							IPFMMessageUtils.addMessageError("Wrong Format NAT IP");
							break;
						}
					}
				}
			}
		}
		
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	
	public void prepareComboBox() {
		IpInfo ipInfo = ipLevel3Bean.getIpInfo();
		if (ipLevel3Bean.getIpStatusComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getIpStatusComboItem().getValue(),"").trim().length()>0){
			ipInfo.setIpStatus(ipLevel3Bean.getIpStatusComboItem().getValue());
		}
		if (ipLevel3Bean.getCompanyComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getCompanyComboItem().getValue(),"").trim().length()>0){
			ipInfo.setCompanyId(ipLevel3Bean.getCompanyComboItem().getValue());
			ipInfo.setCompanyName(ipLevel3Bean.getCompanyComboItem().getLabel());
		}
		if (ipLevel3Bean.getSysOwnerTeamComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").trim().length()>0){
			ipInfo.setSystemOwnerTeamId(ipLevel3Bean.getSysOwnerTeamComboItem().getValue());
			ipInfo.setSystemOwnerTeamName(ipLevel3Bean.getSysOwnerTeamComboItem().getLabel());
		}
		if (ipLevel3Bean.getNetworkTypeComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getNetworkTypeComboItem().getValue(),"").trim().length()>0){
			ipInfo.setNetworkTypeId(ipLevel3Bean.getNetworkTypeComboItem().getValue());
			ipInfo.setNetworkTypeName(ipLevel3Bean.getNetworkTypeComboItem().getLabel());
		}
		if (ipLevel3Bean.getNetworkZoneComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getNetworkZoneComboItem().getValue(),"").trim().length()>0){
			ipInfo.setNetworkZoneId(ipLevel3Bean.getNetworkZoneComboItem().getValue());
			ipInfo.setNetworkZoneName(ipLevel3Bean.getNetworkZoneComboItem().getLabel());
		}		
		if (ipLevel3Bean.getProjectComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getProjectComboItem().getValue(),"").trim().length()>0){
			ipInfo.setProjectId(ipLevel3Bean.getProjectComboItem().getValue());
			ipInfo.setProjectName(ipLevel3Bean.getProjectComboItem().getValue2());
		}
		if (ipLevel3Bean.getIpTypeComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getIpTypeComboItem().getValue(),"").trim().length()>0){
			ipInfo.setIpTypeId(ipLevel3Bean.getIpTypeComboItem().getValue());
			ipInfo.setIpTypeName(ipLevel3Bean.getIpTypeComboItem().getValue());
		}		
//		if (ipLevel3Bean.getProjManagerComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getProjManagerComboItem().getValue(),"").trim().length()>0){
//			ipInfo.setProjectManager(ipLevel3Bean.getProjManagerComboItem().getLabel());
//		}
		if (ipLevel3Bean.getLocationComboItem()!=null && IPFMUtils.ifBlank(ipLevel3Bean.getLocationComboItem().getValue(),"").trim().length()>0){
			ipInfo.setLocationId(ipLevel3Bean.getLocationComboItem().getValue());
			ipInfo.setLocationName(ipLevel3Bean.getLocationComboItem().getLabel());
		}
		
		if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getInstallTypeId(),"").equalsIgnoreCase("2")){
			ipLevel3Bean.getIpInfo().setInstallTypeName("Permanent");
		}else if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getInstallTypeId(),"").equalsIgnoreCase("1")){
			ipLevel3Bean.getIpInfo().setInstallTypeName("Temporary");
		}
	 }

	
	public void checkAll(){
		ipLevel3Bean = getIpLevel3Bean();
		try{
			if (ipLevel3Bean.getIpInfoDataTable().getRowCount()>0) {
				HtmlDataTable dataTable = ipLevel3Bean.getIpInfoDataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				for (int i=startRow ; i<endRow ; i++) {
					if (i == dataTable.getRowCount()) break;
					dataTable.setRowIndex(i);
					IpInfo ipInfo = (IpInfo) dataTable.getRowData();
					ipInfo.setRowCheck(ipLevel3Bean.isCheckAll());
				}
			}
			setIpLevel3Bean(ipLevel3Bean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}

	public String searchIP() {
		ipLevel3Bean = getIpLevel3Bean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		try {
			HtmlDataTable dataTable = ipLevel3Bean.getDataTable();
			dataTable.setRowIndex(ipLevel3Bean.getSelectRowIndex());
			IpvNetworkIp ipvNetworkIp = (IpvNetworkIp)dataTable.getRowData();
			ipLevel3Bean.setIpAddress(ipvNetworkIp.getNetworkIp());
			ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole(), ipLevel3Bean.getIpAddress(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId()));
			setIpLevel3Bean(ipLevel3Bean);
//		} catch (IPFMBusinessException e) {
//			e.printStackTrace();
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
	public String popupExpireDate(){
		ipLevel3Bean = getIpLevel3Bean();
		boolean haveRole04 = false;
		boolean canUpdateNat = false;
		try{
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");		
			UserSession userSession = IPFMWebUtil.getUserSession();
			
			String user = String.valueOf(userSession.getIpUser().getUserId());
			String userTeam = String.valueOf(userSession.getIpUser().getTeamId());
			
			boolean userLv1 = false;
			boolean userLv2 = false;
			boolean userLv3 = false;
			
			List<IPMasterValue> masterLV = managementIpService.getMasterList("UPDATE_NAT");
			if(masterLV != null && masterLV.size() > 0){
				for(IPMasterValue lvBean : masterLV){
					if(lvBean.getValueName().equalsIgnoreCase("USER_LV1") && lvBean.getValueData().equalsIgnoreCase("Y")){
						userLv1 = true;
					}
					if(lvBean.getValueName().equalsIgnoreCase("USER_LV2") && lvBean.getValueData().equalsIgnoreCase("Y")){
						userLv2 = true;
					}
					if(lvBean.getValueName().equalsIgnoreCase("USER_LV3") && lvBean.getValueData().equalsIgnoreCase("Y")){
						userLv3 = true;
					}
				}
			}
			
			if (ipLevel3Bean.getIpInfoDataTable().getRowCount()>0) {
				HtmlDataTable dataTable = ipLevel3Bean.getIpInfoDataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				int checkCount = 0;
				List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
												
				for (int i=startRow ; i<endRow ; i++) {
					if (i == dataTable.getRowCount()) break;
					dataTable.setRowIndex(i);
					IpInfo ipInfo = (IpInfo) dataTable.getRowData();
					if(!canUpdateNat && ipInfo.isRowCheck()){
						String l1 = String.valueOf(ipInfo.getT1TeamId());
						String l2 = String.valueOf(ipInfo.getT2TeamId());
						String l3 = String.valueOf(ipInfo.getSystemOwnerTeamId());
						String ow = String.valueOf(ipInfo.getSystemOwner());
						
						if(userLv1){
							if(!l1.equals("") && !l1.equalsIgnoreCase("null") && userTeam.equalsIgnoreCase(l1)){
								canUpdateNat = true;
							}
						}
						
						if(userLv2){
							if(!l2.equals("") && !l2.equalsIgnoreCase("null") && userTeam.equalsIgnoreCase(l2)){
								canUpdateNat = true;
							}
						}
						
						if(userLv3){
							if(!l3.equals("") && !l3.equalsIgnoreCase("null") && userTeam.equalsIgnoreCase(l3)){
								canUpdateNat = true;
							}
							
							if(!ow.equals("") && !ow.equalsIgnoreCase("null") && user.equalsIgnoreCase(ow)){
								canUpdateNat = true;
							}
						}
						
					}
					
	                if (ipInfo.isRowCheck()){
	                	checkCount++;
	                	ipInfoList.add(ipInfo);
	                }
				}
				if (checkCount==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0032")));
				}else{
					ipLevel3Bean.setIpInfo(new IpInfo());
					ipLevel3Bean.setCheckBoxCompany(false);
					ipLevel3Bean.setCheckBoxDNSName(false);
					ipLevel3Bean.setCheckBoxExpiredDate(false);
					ipLevel3Bean.setCheckBoxGateway(false);
					ipLevel3Bean.setCheckBoxHostName(false);
					ipLevel3Bean.setCheckBoxIPStatus(false);
					ipLevel3Bean.setCheckBoxMask(false);
					ipLevel3Bean.setCheckBoxNetworkIP(false);
					ipLevel3Bean.setCheckBoxSiteLocation(false);
					ipLevel3Bean.setCheckBoxSystemName(false);
					ipLevel3Bean.setCheckBoxSystemOwnerName(false);
					ipLevel3Bean.setExpiredDate(null);
					ipLevel3Bean.getIpInfo().setExpiredDate(null);
					ipLevel3Bean.getIpInfo().setNetworkIp(null);
					ipLevel3Bean.getIpInfo().setCompanyId(null);
					ipLevel3Bean.getIpInfo().setCompanyName(null);
					ipLevel3Bean.getIpInfo().setGateway(null);
					ipLevel3Bean.setCheckBoxVlan(false);
					ipLevel3Bean.setShowWarnDup(false);
					ipLevel3Bean.setMsgWarnDup("");
					ipLevel3Bean.setOpenCheckBoxNatIP(canUpdateNat);
					ipLevel3Bean.setStatusEditAble(true);
					ipLevel3Bean.setCheckBoxNat(false);
					
					List<IpRoleMember> roleMemberList = managementIpService.findIpRoleMemberByUserId(userSession.getIpUser().getUserId());
					for(IpRoleMember roleMember : roleMemberList){
						if (roleMember.getRoleId().equalsIgnoreCase("R04")) {
							haveRole04 = true;
							break;
						}
					}
					if(haveRole04){
						for(IpInfo ipInfo : ipInfoList){
							if(ipInfo.getSystemOwnerId() != null && !(ipInfo.getSystemOwner().equals(userSession.getIpUser().getUserId()))) {
								if(ipInfo.getSystemOwnerTeamId() != null && !ipInfo.getSystemOwnerTeamId().equals(userSession.getIpUser().getTeamId())){
									ipLevel3Bean.setStatusEditAble(false);
									break;
								}
							}
						}
					}

					
					
					
					ipLevel3Bean.setIpStatusComboItem(null);
					ipLevel3Bean.setCompanyComboItem(null);
					ipLevel3Bean.setLocationComboItem(null);
					ipLevel3Bean.setSysOwnerComboItem(null);
					ipLevel3Bean.setSysOwnerTeamComboItem(null);

					prepareIPStatusListUpdateInfo(ipLevel3Bean, ipInfoList);
					prepareStatusEditUpdateInfo(ipLevel3Bean);
				}
			}
			setIpLevel3Bean(ipLevel3Bean);
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;	
	}
	
	public String updateExpireDate(){
		ipLevel3Bean = getIpLevel3Bean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{
			
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			
			if(ipLevel3Bean.isCheckBoxCompany() || ipLevel3Bean.isCheckBoxDNSName() || ipLevel3Bean.isCheckBoxExpiredDate() ||
					ipLevel3Bean.isCheckBoxGateway() || ipLevel3Bean.isCheckBoxHostName() || ipLevel3Bean.isCheckBoxIPStatus() ||
					ipLevel3Bean.isCheckBoxMask() || ipLevel3Bean.isCheckBoxNetworkIP() || ipLevel3Bean.isCheckBoxSiteLocation() ||
					ipLevel3Bean.isCheckBoxSystemName() || ipLevel3Bean.isCheckBoxSystemOwnerName() || ipLevel3Bean.isCheckBoxVlan() || ipLevel3Bean.isCheckBoxNat()){
				List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
				List<IPLevel3NatHistory> natHistory = new ArrayList<IPLevel3NatHistory>();
				for (IpInfo vIpInfo : ipLevel3Bean.getIpInfoList()) {
					IpInfo nInfo = (IpInfo)vIpInfo.clone();
					if (nInfo.isRowCheck()) {
						if(ipLevel3Bean.isCheckBoxIPStatus()){
							if (ipLevel3Bean.getIpStatusComboItem()!=null && 
									IPFMUtils.ifBlank(ipLevel3Bean.getIpStatusComboItem().getValue(),"").trim().length()>0){
								if(ipLevel3Bean.getIpStatusComboItem().getValue().equalsIgnoreCase("U") 
										&& (nInfo.getHostName()==null || (nInfo.getHostName()!=null && nInfo.getHostName().trim().length()==0))){
									if(!(ipLevel3Bean.isCheckBoxHostName() && ipLevel3Bean.getIpInfo().getHostName()!=null 
											&& ipLevel3Bean.getIpInfo().getHostName().trim().length()>0)){
										IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Host Name"));
									}								
								}
							}else{
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Status"));
							}
							if (IPFMMessageUtils.hasMessages())return null;	
							nInfo.setIpStatusOld(nInfo.getIpStatus());
							nInfo.setIpStatus(ipLevel3Bean.getIpStatusComboItem().getValue());
						}
						
						if(ipLevel3Bean.isCheckBoxHostName()){
							if(!(ipLevel3Bean.getIpInfo().getHostName()!=null 
									&& ipLevel3Bean.getIpInfo().getHostName().trim().length()>0)){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Host Name"));		
							}
							if (IPFMMessageUtils.hasMessages())return null;
							nInfo.setHostName(ipLevel3Bean.getIpInfo().getHostName());
						}
						
						if(ipLevel3Bean.isCheckBoxCompany()){
							if (!ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
								if(IPFMUtils.ifBlank(ipLevel3Bean.getCompanyComboItem().getValue(),"").trim().length()==0){
									IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
								}else{
									nInfo.setCompanyId(ipLevel3Bean.getCompanyComboItem().getValue());
									nInfo.setCompanyName(ipLevel3Bean.getCompanyComboItem().getLabel());
								}
							}
							if (IPFMMessageUtils.hasMessages())return null;
						}
						
						if(ipLevel3Bean.isCheckBoxSystemName()){
							nInfo.setSystemName(ipLevel3Bean.getIpInfo().getSystemName());
						}
						
						if(ipLevel3Bean.isCheckBoxSystemOwnerName()){
							if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwnerName(),"").length()>0 && IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwner(),"").length()==0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), ipLevel3Bean.getIpInfo().getSystemOwnerName()));
							}
							if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwner(),"").length()==0 && IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").length()>0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner"));
							}
							if (IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getSystemOwner(),"").length()>0 && IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").length()==0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Team "));
							}
							if (IPFMUtils.ifBlank(ipLevel3Bean.getSysOwnerTeamComboItem().getValue(),"").trim().length()==0){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Team "));
							}
							if (IPFMMessageUtils.hasMessages())return null;
							nInfo.setSystemOwner(ipLevel3Bean.getIpInfo().getSystemOwner());
							nInfo.setSystemOwnerId(ipLevel3Bean.getIpInfo().getSystemOwnerId());
							nInfo.setSystemOwnerName(ipLevel3Bean.getIpInfo().getSystemOwnerName());
							nInfo.setSystemOwnerTeamId(ipLevel3Bean.getSysOwnerTeamComboItem().getValue());
							nInfo.setSystemOwnerTeamName(ipLevel3Bean.getSysOwnerTeamComboItem().getLabel());
						}
						
						if(ipLevel3Bean.isCheckBoxDNSName()){
							nInfo.setDnsName(ipLevel3Bean.getIpInfo().getDnsName());
						}
						
						if(ipLevel3Bean.isCheckBoxNetworkIP()){
							if (!ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
								if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getNetworkIp(),"").trim().length()==0){
									IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network IP"));
								}
								if (IPFMMessageUtils.hasMessages())return null;
								nInfo.setNetworkIp(ipLevel3Bean.getIpInfo().getNetworkIp());
							}
						}
						
						if(ipLevel3Bean.isCheckBoxSiteLocation()){
							if(IPFMUtils.ifBlank(ipLevel3Bean.getLocationComboItem().getValue(),"").trim().length()==0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Site/Location"));
							}
							if (IPFMMessageUtils.hasMessages())return null;
							nInfo.setLocationId(ipLevel3Bean.getLocationComboItem().getValue());
							nInfo.setLocationName(ipLevel3Bean.getLocationComboItem().getLabel());
						}
						
						if(ipLevel3Bean.isCheckBoxGateway()){
							if (!ipLevel3Bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
								if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getGateway(),"").trim().length()==0){
									IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Gateway"));
								}
								if (IPFMMessageUtils.hasMessages())return null;
								nInfo.setGateway(ipLevel3Bean.getIpInfo().getGateway());
							}
						}
						
						if(ipLevel3Bean.isCheckBoxExpiredDate()){
							if(ipLevel3Bean.getIpInfo().getExpiredDate() == null) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
							}else if (nInfo.getEffectiveDate().compareTo(ipLevel3Bean.getIpInfo().getExpiredDate())>0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
							}else if (ipLevel3Bean.getIpInfo().getExpiredDate().compareTo(nInfo.getIpLevel2().getExpiredDate())>0) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0072"),"Expire Date"));
							}
							if (IPFMMessageUtils.hasMessages())return null;
							nInfo.setExpiredDate(ipLevel3Bean.getIpInfo().getExpiredDate());
						}
						
						if(ipLevel3Bean.isCheckBoxMask()){
							if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getIpSubmask(),"").trim().length()==0){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
							}
							if (IPFMMessageUtils.hasMessages())return null;
							nInfo.setIpSubmask(ipLevel3Bean.getIpInfo().getIpSubmask());
						}
						
						if(ipLevel3Bean.isCheckBoxVlan()){
							if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getVlanId(),"").trim().length()==0){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "VLAN"));
							}
							if (IPFMMessageUtils.hasMessages())return null;
							
							//Check Duplicate Vlan
//							IpInfo ipInfo = new IpInfo();
//							ipInfo.setVlanId(ipLevel3Bean.getIpInfo().getVlanId());
//							if(managementIpService.checkDupVlan(ipInfo)){
//								ipLevel3Bean.setShowWarnDup(true);
//							}else{
//								ipLevel3Bean.setShowWarnDup(false);
//							}
							
							nInfo.setVlanId(ipLevel3Bean.getIpInfo().getVlanId());
							
						}
						
						if(ipLevel3Bean.isCheckBoxNat()){
							
							String natData = ipLevel3Bean.getIpInfo().getNatIp();
							boolean checkNatIP = false;
							if(natData != null){
								IPFMDataValidateUtil util = new IPFMDataValidateUtil();
								if(!natData.trim().equals("")){
									String[] nat = natData.split(",");								
									for(String natip : nat){
										if(!util.validateIPFormat(natip)){		
											checkNatIP = true;
											break;
										}
									}
								}
								
							}
							
							if(checkNatIP){
								IPFMMessageUtils.addMessageError("Wrong Format NAT IP");
								return null;
							}else{
								if(managementIpService.checkPermissionUpdateNatIP(userSession.getIpUser().getUserId(), nInfo.getIpAddress())){
									nInfo.setNatIp(natData.replaceAll(" ", ""));
									
									
									IPLevel3NatHistory hisData = managementIpService.validateInsertNatHis(nInfo.getIpAddress(), nInfo.getNatIp(), userSession.getIpUser().getUserId());
									if(hisData != null && hisData.getIpAddress() != null && !(hisData.getIpAddress().trim().equals(""))){
										natHistory.add(hisData);
									}
								}
							}
							

//							if(IPFMUtils.ifBlank(ipLevel3Bean.getIpInfo().getIpSubmask(),"").trim().length()==0){
//								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
//							}
//							if (IPFMMessageUtils.hasMessages())return null;
//							nInfo.setIpSubmask(ipLevel3Bean.getIpInfo().getIpSubmask());
						}
						
						nInfo.setLastUpdBy(userSession.getIpUser().getUserId());
						nInfo.setLastUpd(null);
						ipInfoList.add(nInfo);
					}
				}

				if(ipInfoList != null && ipInfoList.size()>0) {
					if(ipLevel3Bean.isCheckBoxIPStatus()){
						managementIpService.updateIpInfo(ipInfoList, userSession.getIpUser().getUserId());
					}else{
						managementIpService.updateIpInfoExpireDate(ipInfoList);	
					}
					ipLevel3Bean.setCheckAll(false);
					ipLevel3Bean.setIpInfoList(refreshTable(ipLevel3Bean.getUserRole(), ipLevel3Bean.getIpAddress(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId()));
				}
				
				if(natHistory != null && natHistory.size()>0){
					managementIpService.insertNatHistory(natHistory);
				}
				
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				setIpLevel3Bean(ipLevel3Bean);				
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

	public List<IpInfo> refreshTable(String userRole, String ipAddress, String teamId, String userId){
		List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		try{		
			int maxSearchResult = getIPFMConfig().getMaxSearchResult();
			if (userRole.equalsIgnoreCase(IPFMConstant.TIER1) || userRole.equalsIgnoreCase(IPFMConstant.TIER12) || userRole.equalsIgnoreCase(IPFMConstant.TIER123)) {
				ipInfoList = managementIpService.searchIpManagementLevel3(ipAddress, "", "", "", maxSearchResult);
			} else if (userRole.equalsIgnoreCase(IPFMConstant.TIER2) || userRole.equalsIgnoreCase(IPFMConstant.TIER23)) {
				ipInfoList = managementIpService.searchIpManagementLevel3(ipAddress, teamId, teamId, userId, maxSearchResult);
			} else if (userRole.equalsIgnoreCase(IPFMConstant.TIER3)) {
				ipInfoList = managementIpService.searchIpManagementLevel3(ipAddress, "", teamId, userId, maxSearchResult);
			}
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return ipInfoList;
	}
	
	@Override
	public boolean validate() {
		return false;
	}
	public List<SelectItem> getProjectListSelecItem() throws Exception{
		ProjectService projectService = (ProjectService)JSFServiceFinderUtil.getInstance().getBean("projectService");
		List<SelectItem> projectListSelectItem = new ArrayList<SelectItem>();
		//System.out.println("---- getProjectListSelecItem ----");
		try {
			List<Project> projectList = projectService.getProjectList();
			IPFMRichComboItem cbitem;
			if(projectList!=null && projectList.size()>0){
				for (Project proj:projectList) {
					cbitem = new IPFMRichComboItem();
					cbitem.setLabel(proj.getProjectId());
					cbitem.setValue(proj.getProjectId());
					cbitem.setValue1(proj.getProjectManagerPin());
					cbitem.setValue2(proj.getProjectName());
					projectListSelectItem.add(new SelectItem(cbitem, cbitem.getValue()));
				}
			}
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
//			throw ipfme;
			return new ArrayList<SelectItem>();
		}catch (Exception e) {
			e.printStackTrace();
//			throw e;
			return new ArrayList<SelectItem>();
		}
		return projectListSelectItem;
	}
	
	public String onChangeProject() throws IPFMBusinessException{
		IpLevel3Bean bean = getIpLevel3Bean();
		//System.out.println("--- onChangeProject ---");
		try{
			if (bean.getProjectComboItem()!= null && IPFMUtils.ifBlank(bean.getProjectComboItem().getLabel(),"").trim().length()>0) {
				bean.setProjNameDisable(true);
				bean.setProjManagerDisable(true);
				if (IPFMUtils.ifBlank(bean.getProjectComboItem().getValue(),"").trim().length()==0) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0075"), bean.getProjectComboItem().getLabel()));
					bean.getIpInfo().setProjectName(null);
					bean.setProjManagerId(null);
					bean.getIpInfo().setProjectManager(null);
					bean.setProjManagerComboItem(new IPFMRichComboItem());
					return null;
				}
				bean.getIpInfo().setProjectId(bean.getProjectComboItem().getValue());
				bean.getIpInfo().setProjectName(bean.getProjectComboItem().getValue2());
				if (IPFMUtils.ifBlank(bean.getProjectComboItem().getValue2(),"").trim().length()>0) {
					bean.getIpInfo().setProjectName(bean.getProjectComboItem().getValue2());
				}else{
					bean.getIpInfo().setProjectName(null);
				}
				if (IPFMUtils.ifBlank(bean.getProjectComboItem().getValue1(),"").trim().length()==0) {
					bean.setProjManagerId(null);
					bean.getIpInfo().setProjectManager(null);
					bean.setProjManagerComboItem(new IPFMRichComboItem());
				}else{
					AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
					EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
					UserAccount authUser = authService.getAuthenUserConfig();
					List<EmployeeProfileOM> empList = ehrService.getEmployeeProfileByPIN(authUser, bean.getProjectComboItem().getValue1());
					if (empList!=null && empList.size()>0) {
						EmployeeProfileOM profile = empList.get(0);
						String email = profile.getEMAIL();
						String projectManagerId = email.substring(0,email.indexOf("@"));
						IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
						IpUser ipUser = ipUserService.findIpUserById(projectManagerId);
						if (ipUser==null){
							bean.setProjManagerId(null);
							bean.getIpInfo().setProjectManager(null);
							bean.setProjManagerComboItem(new IPFMRichComboItem());
							return null;
						}
						bean.setProjManagerId(projectManagerId);
						bean.getIpInfo().setProjectManager((IPFMUtils.ifBlank(profile.getENGNAME(),"")+" "+IPFMUtils.ifBlank(profile.getENGSURNAME(),"")).trim());
						bean.setProjManagerComboItem(new IPFMRichComboItem(projectManagerId, bean.getIpInfo().getProjectManager()));
					}else{
						bean.setProjManagerId(null);
						bean.getIpInfo().setProjectManager(null);
						bean.setProjManagerComboItem(new IPFMRichComboItem());
					}
				}
			}else{
				bean.setProjNameDisable(false);
				bean.setProjManagerDisable(false);
				bean.getIpInfo().setProjectId(null);
				bean.getIpInfo().setProjectName(null);
				bean.setProjManagerId(null);
				bean.getIpInfo().setProjectManager(null);
				bean.setProjManagerComboItem(new IPFMRichComboItem());
			}
			setIpLevel3Bean(bean);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	public List<SelectItem> userSuggestion(Object event) throws Exception{
		if (event.toString()==null) return new ArrayList<SelectItem>();
		return getUserListSelectItem(event.toString());
	}
	
	public void suggestManager() {
		IpLevel3Bean bean = getIpLevel3Bean();
		try{
			if (bean.getSuggestProjManager().getRowIndex() < 0){
				bean.setProjManagerComboItem(new IPFMRichComboItem(null,null));
				bean.setProjManagerId("");
			}else{
				SelectItem item = (SelectItem)bean.getSuggestProjManager().getRowData();
				IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
				bean.setProjManagerId(combo.getValue());
				bean.getIpInfo().setProjectManager(combo.getLabel());
			}

			setIpLevel3Bean(bean);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void suggestSysOwnerUpdate() {
		IpLevel3Bean bean = getIpLevel3Bean();
		try{
			if (bean.getSuggestSystemOwnerUpdate().getRowIndex() < 0){
				bean.setSysOwnerTeamList(new ArrayList<SelectItem>());
				bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
				bean.setSystemOwnerName("");		
				bean.setTeamId("");
			}else {
				SelectItem item = (SelectItem)bean.getSuggestSystemOwnerUpdate().getRowData();
				IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
				//bean.getIpInfo().setSystemOwner(combo.getValue());
				//bean.getIpInfo().setSystemOwnerName(combo.getLabel());
				IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
				IpUser ipUser = ipUserService.findIpUserById(combo.getValue());
				if (ipUser==null) {
					AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
					EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
					UserAccount authUser = authService.getAuthenUserConfig();
					List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByEmail(authUser, combo.getValue1());
					bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
					if (userList!=null && userList.size()>0) {
						EmployeeProfileOM profile = userList.get(0);
						profile.setSCCODE(profile.getORGCODE());
						profile.setSCNAME(profile.getORGNAME());
						if (profile.getSCNAME()!=null && profile.getSCNAME().trim().length()>0) {
							bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
						}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
							bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
						}else{
							bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
						}
					}
					UserSession userSession = IPFMWebUtil.getUserSession();
					IPFMRichComboItem userTeam = new IPFMRichComboItem(userSession.getIpUser().getTeamId(),userSession.getIpUser().getTeamName());
					bean.getSysOwnerTeamList().add(new SelectItem(userTeam, userSession.getIpUser().getTeamName()));
					
					ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
					IpTeam ipTeam = managementIpService.findIpTeamById(userSession.getIpUser().getTeamId());
					if (ipTeam!=null){
						bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()));
						bean.setTeamId(ipTeam.getTeamId());
						if (!ipTeam.getTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())) {
							bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()),ipTeam.getTeamName()));
						}
					}
//					else{
//						bean.setTeamId(bean.getIpInfo().getSystemOwnerTeamName());
//						bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()));
//						bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()),bean.getIpInfo().getSystemOwnerTeamName()));
//					}
				}
				else{
					bean.getIpInfo().setSystemOwnerTeamId(ipUser.getTeamId());
					bean.getIpInfo().setSystemOwnerTeamName(ipUser.getTeamName());
					bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamId(),bean.getIpInfo().getSystemOwnerTeamName()));
					bean.getSysOwnerTeamList().add(new SelectItem(bean.getSysOwnerTeamComboItem(), bean.getSysOwnerTeamComboItem().getLabel()));
				}
	//			boolean flag = true;
	//			for(SelectItem selectItem : bean.getSysOwnerTeamList()){
	//				if (bean.getIpInfo().getSystemOwnerTeamName().trim().equalsIgnoreCase(selectItem.getLabel().trim())) {
	//					bean.getIpInfo().setSystemOwnerTeamId(((IPFMRichComboItem)selectItem.getValue()).getValue());
	//					bean.setSysOwnerTeamComboItem((IPFMRichComboItem)selectItem.getValue());
	//					bean.setTeamId(((IPFMRichComboItem)selectItem.getValue()).getValue());
	//					flag = false;
	//					break;
	//				}
	//			}
	//			if (flag) {
	//				bean.setTeamId(bean.getIpInfo().getSystemOwnerTeamName());
	//				bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()));
	//				bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()),bean.getIpInfo().getSystemOwnerTeamName()));
	//			}
			}
			setIpLevel3Bean(bean);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
	
	
	public void suggestSysOwner() {
		IpLevel3Bean bean = getIpLevel3Bean();
		try{
			if (bean.getSuggestSystemOwner().getRowIndex() < 0){
				bean.setSysOwnerTeamList(new ArrayList<SelectItem>());
				bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
				bean.getIpInfo().setSystemOwner("");
				bean.getIpInfo().setSystemOwnerTeamId("");
				bean.getIpInfo().setSystemOwnerTeamName("");			
				bean.setTeamId("");
			}else{
				SelectItem item = (SelectItem)bean.getSuggestSystemOwner().getRowData();
				IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
				bean.getIpInfo().setSystemOwner(combo.getValue());
				bean.getIpInfo().setSystemOwnerName(combo.getLabel());
				IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
				IpUser ipUser = ipUserService.findIpUserById(combo.getValue());
				if (ipUser==null) {
					AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
					EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
					UserAccount authUser = authService.getAuthenUserConfig();
					List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByEmail(authUser, combo.getValue1());
					bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
					if (userList!=null && userList.size()>0) {
						EmployeeProfileOM profile = userList.get(0);
						profile.setSCCODE(profile.getORGCODE());
						profile.setSCNAME(profile.getORGNAME());
						if (profile.getSCNAME()!=null && profile.getSCNAME().trim().length()>0) {
							bean.getIpInfo().setSystemOwnerTeamId(IPFMUtils.ifBlank(profile.getSCNAME(),""));
							bean.getIpInfo().setSystemOwnerTeamName(IPFMUtils.ifBlank(profile.getSCNAME(),""));
						}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
							bean.getIpInfo().setSystemOwnerTeamId(IPFMUtils.ifBlank(profile.getDPNAME(),""));
							bean.getIpInfo().setSystemOwnerTeamName(IPFMUtils.ifBlank(profile.getDPNAME(),""));
						}else{
							bean.getIpInfo().setSystemOwnerTeamId(IPFMUtils.ifBlank("NA",""));
							bean.getIpInfo().setSystemOwnerTeamName("NA");
						}
					}
					UserSession userSession = IPFMWebUtil.getUserSession();
					IPFMRichComboItem userTeam = new IPFMRichComboItem(userSession.getIpUser().getTeamId(),userSession.getIpUser().getTeamName());
					bean.getSysOwnerTeamList().add(new SelectItem(userTeam, userSession.getIpUser().getTeamName()));
					
					ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
					IpTeam ipTeam = managementIpService.findIpTeamById(bean.getIpInfo().getSystemOwnerTeamId());
					if (ipTeam!=null){
						bean.getIpInfo().setSystemOwnerTeamId(ipTeam.getTeamId());
						bean.getIpInfo().setSystemOwnerTeamName(ipTeam.getTeamName());
						bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()));
						bean.setTeamId(ipTeam.getTeamId());
						if (!ipTeam.getTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())) {
							bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()),ipTeam.getTeamName()));
						}
					}else{
						bean.setTeamId(bean.getIpInfo().getSystemOwnerTeamName());
						bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()));
						bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()),bean.getIpInfo().getSystemOwnerTeamName()));
					}
				}else{
					bean.getIpInfo().setSystemOwnerTeamId(ipUser.getTeamId());
					bean.getIpInfo().setSystemOwnerTeamName(ipUser.getTeamName());
					bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamId(),bean.getIpInfo().getSystemOwnerTeamName()));
					bean.getSysOwnerTeamList().add(new SelectItem(bean.getSysOwnerTeamComboItem(), bean.getSysOwnerTeamComboItem().getLabel()));
				}
	//			boolean flag = true;
	//			for(SelectItem selectItem : bean.getSysOwnerTeamList()){
	//				if (bean.getIpInfo().getSystemOwnerTeamName().trim().equalsIgnoreCase(selectItem.getLabel().trim())) {
	//					bean.getIpInfo().setSystemOwnerTeamId(((IPFMRichComboItem)selectItem.getValue()).getValue());
	//					bean.setSysOwnerTeamComboItem((IPFMRichComboItem)selectItem.getValue());
	//					bean.setTeamId(((IPFMRichComboItem)selectItem.getValue()).getValue());
	//					flag = false;
	//					break;
	//				}
	//			}
	//			if (flag) {
	//				bean.setTeamId(bean.getIpInfo().getSystemOwnerTeamName());
	//				bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()));
	//				bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()),bean.getIpInfo().getSystemOwnerTeamName()));
	//			}
			}
			setIpLevel3Bean(bean);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void suggestSysOwnerUpdateInfo() {
		IpLevel3Bean bean = getIpLevel3Bean();
		try{
			if (bean.getSuggestSystemOwnerUpdateInfo().getRowIndex() < 0){
				bean.setSysOwnerTeamList(new ArrayList<SelectItem>());
				bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
				bean.getIpInfo().setSystemOwner("");
				bean.getIpInfo().setSystemOwnerTeamId("");
				bean.getIpInfo().setSystemOwnerTeamName("");			
				bean.setTeamId("");
			}else{
				SelectItem item = (SelectItem)bean.getSuggestSystemOwnerUpdateInfo().getRowData();
				IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
				bean.getIpInfo().setSystemOwner(combo.getValue());
				bean.getIpInfo().setSystemOwnerName(combo.getLabel());
				IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
				IpUser ipUser = ipUserService.findIpUserById(combo.getValue());
				if (ipUser==null) {
					AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
					EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
					UserAccount authUser = authService.getAuthenUserConfig();
					List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByEmail(authUser, combo.getValue1());
					bean.setSysOwnerTeamComboItem(new IPFMRichComboItem());
					if (userList!=null && userList.size()>0) {
						EmployeeProfileOM profile = userList.get(0);
						profile.setSCCODE(profile.getORGCODE());
						profile.setSCNAME(profile.getORGNAME());
						if (profile.getSCNAME()!=null && profile.getSCNAME().trim().length()>0) {
							bean.getIpInfo().setSystemOwnerTeamId(IPFMUtils.ifBlank(profile.getSCNAME(),""));
							bean.getIpInfo().setSystemOwnerTeamName(IPFMUtils.ifBlank(profile.getSCNAME(),""));
						}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
							bean.getIpInfo().setSystemOwnerTeamId(IPFMUtils.ifBlank(profile.getDPNAME(),""));
							bean.getIpInfo().setSystemOwnerTeamName(IPFMUtils.ifBlank(profile.getDPNAME(),""));
						}else{
							bean.getIpInfo().setSystemOwnerTeamId(IPFMUtils.ifBlank("NA",""));
							bean.getIpInfo().setSystemOwnerTeamName("NA");
						}
					}
					UserSession userSession = IPFMWebUtil.getUserSession();
					IPFMRichComboItem userTeam = new IPFMRichComboItem(userSession.getIpUser().getTeamId(),userSession.getIpUser().getTeamName());
					bean.getSysOwnerTeamList().add(new SelectItem(userTeam, userSession.getIpUser().getTeamName()));
					
					ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
					IpTeam ipTeam = managementIpService.findIpTeamById(bean.getIpInfo().getSystemOwnerTeamId());
					if (ipTeam!=null){
						bean.getIpInfo().setSystemOwnerTeamId(ipTeam.getTeamId());
						bean.getIpInfo().setSystemOwnerTeamName(ipTeam.getTeamName());
						bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()));
						bean.setTeamId(ipTeam.getTeamId());
						if (!ipTeam.getTeamId().equalsIgnoreCase(userSession.getIpUser().getTeamId())) {
							bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()),ipTeam.getTeamName()));
						}
					}else{
						bean.setTeamId(bean.getIpInfo().getSystemOwnerTeamName());
						bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()));
						bean.getSysOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamName(),bean.getIpInfo().getSystemOwnerTeamName()),bean.getIpInfo().getSystemOwnerTeamName()));
					}
				}else{
					bean.getIpInfo().setSystemOwnerTeamId(ipUser.getTeamId());
					bean.getIpInfo().setSystemOwnerTeamName(ipUser.getTeamName());
					bean.setSysOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpInfo().getSystemOwnerTeamId(),bean.getIpInfo().getSystemOwnerTeamName()));
					bean.getSysOwnerTeamList().add(new SelectItem(bean.getSysOwnerTeamComboItem(), bean.getSysOwnerTeamComboItem().getLabel()));
				}
			}
			setIpLevel3Bean(bean);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
	
	private List<SelectItem> getUserListSelectItem(String userName) throws Exception{
		AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
		EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
		List<SelectItem> userListSelectItem = new ArrayList<SelectItem>();
		try {
			if (IPFMUtils.ifBlank(userName, "").trim().length()==0) return userListSelectItem;
//			Long startTime = System.currentTimeMillis();
			
			UserAccount authUser = authService.getAuthenUserConfig();
			List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByPrefixEngName(authUser, userName+"%");
			
//			Long endTime = System.currentTimeMillis();
//			System.out.println("call time = "+ new Double((endTime-startTime)/1000D));
			IPFMRichComboItem cbitem;
			String teamName = "";
			if(userList!=null && userList.size()>0){
				int count = 1;
				for (EmployeeProfileOM profile : userList) {
					if (count>getIPFMConfig().getSuggestSize()) break;
					count++;
					cbitem = new IPFMRichComboItem();
					cbitem.setLabel(IPFMUtils.ifBlank(profile.getENFIRSTNAME(),"")+" "+IPFMUtils.ifBlank(profile.getENLASTNAME(),""));
					String email = profile.getEMAIL();
					cbitem.setValue(email.substring(0,email.indexOf("@")));
					profile.setSCCODE(profile.getORGCODE());
					profile.setSCNAME(profile.getORGNAME());
					if (profile.getSCNAME()!=null && profile.getSCNAME().trim().length()>0) {
						teamName = profile.getSCNAME();
					}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
						teamName = profile.getDPNAME();
					}else{
						teamName = "NA";
					}
					cbitem.setValue2(teamName);					
					cbitem.setValue1(email);
					userListSelectItem.add(new SelectItem(cbitem, cbitem.getLabel()==null?"":cbitem.getLabel()));
				}
			}
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			throw ipfme;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userListSelectItem;
	}
	
	public void checkCompanyCombo(){
		ipLevel3Bean = getIpLevel3Bean();
        if((ipLevel3Bean.getCompanyComboItem().getValue()==null) && ipLevel3Bean.getCompanyComboItem().getLabel().trim().length()>0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Company"));
			//ipLevel3Bean.getCompanyComboItem().setLabel("");
		}
	}
	public void checkIpStatusCombo(){
		ipLevel3Bean = getIpLevel3Bean();
        if((ipLevel3Bean.getIpStatusComboItem().getValue()==null) && ipLevel3Bean.getIpStatusComboItem().getLabel().trim().length()>0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "IP Status"));
		}
	}
	
	public void checkIpTypeCombo(){
		ipLevel3Bean = getIpLevel3Bean();
            if((ipLevel3Bean.getIpTypeComboItem().getValue()==null) && ipLevel3Bean.getIpTypeComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "IP Type"));
			}
	}
	public void checkLocationCombo(){
		ipLevel3Bean = getIpLevel3Bean();
            if((ipLevel3Bean.getLocationComboItem().getValue()==null) && ipLevel3Bean.getLocationComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Site/Location"));
			}
	}
	public void checkSystemOwnerTeamCombo(){
		ipLevel3Bean = getIpLevel3Bean();
            if((ipLevel3Bean.getSysOwnerTeamComboItem().getValue()==null) && ipLevel3Bean.getSysOwnerTeamComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "System Owner Team"));
			}
	}
	public void checkNwTypeCombo(){
		ipLevel3Bean = getIpLevel3Bean();
            if((ipLevel3Bean.getNetworkTypeComboItem().getValue()==null) && ipLevel3Bean.getNetworkTypeComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Type"));
			}
	}
	public void checkNwZoneCombo(){
		ipLevel3Bean = getIpLevel3Bean();
            if((ipLevel3Bean.getNetworkZoneComboItem().getValue()==null) && ipLevel3Bean.getNetworkZoneComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Zone"));
			}
	}
	
	public void prepareIPStatusListUpdateInfo(IpLevel3Bean ipLevel3Bean, List<IpInfo> ipInfoList) throws Exception{
		UserSession userSession = IPFMWebUtil.getUserSession();
		List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
		boolean haveStatusAssignToUser = false;
		boolean haveStatusUsed = false;
		boolean haveStatusReserved = false;
		boolean haveStatusTerminated = false;
		boolean haveStatusOther = false;
		
		boolean selectStatusU = false;
		boolean selectStatusR = false;
		boolean selectStatusT = false;
		
		for(IpInfo ipInfo:ipInfoList){
			if(ipInfo.getIpStatus().equalsIgnoreCase("T")){
				haveStatusTerminated = true;
				break;
			}else if(ipInfo.getIpStatus().equalsIgnoreCase("A")){
				haveStatusAssignToUser = true;
				continue;
			}else if(ipInfo.getIpStatus().equalsIgnoreCase("R")){
				haveStatusReserved = true;
				continue;				
			}else if(ipInfo.getIpStatus().equalsIgnoreCase("U")){
				haveStatusUsed = true;
				continue;				
			}else{
				haveStatusOther = true;
				break;
			}
		}
		
		if(haveStatusOther || haveStatusTerminated){
			ipLevel3Bean.setIpStatusEdit(false);
			ipLevel3Bean.setIpStatusList(ipStatusList);
			ipLevel3Bean.setStatusEditAble(false);
		}else{

//			-	A assign to user, r Reserved, u Used, T terminate			
//			-	A and u to u
//			-	A and r to u
//			-	A and u and r to u
			if((haveStatusAssignToUser && haveStatusUsed && haveStatusReserved) || 
					(haveStatusAssignToUser && haveStatusUsed && !haveStatusReserved) ||
					(haveStatusAssignToUser && haveStatusReserved && !haveStatusUsed)){
				selectStatusU = true;
			}else if((haveStatusReserved && !haveStatusAssignToUser && !haveStatusUsed) ||
					(haveStatusUsed && haveStatusReserved && !haveStatusAssignToUser)){
//			-	All r to u, t
//			-	U and r to u, t
				selectStatusU = true;
				selectStatusT = true;
			}else if(haveStatusAssignToUser && !haveStatusUsed && !haveStatusReserved){
//			-	All A to u, r
				selectStatusU = true;
				selectStatusR = true;
			}else if(!haveStatusAssignToUser && haveStatusUsed && !haveStatusReserved){
//			-	All u to t
				selectStatusT = true;
			}

			boolean first = false;
			boolean add = false;
			if(selectStatusR || selectStatusT || selectStatusU){
				for (SelectItem item : ipLevel3Bean.getAllIpStatusList()) {
					IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
					add = false;
					if((cmb.getValue().equalsIgnoreCase("U") && selectStatusU) ||
							(cmb.getValue().equalsIgnoreCase("R") && selectStatusR) ||
							(cmb.getValue().equalsIgnoreCase("T") && selectStatusT)){
						add = true;
					}
					if(add){
						ipStatusList.add(item);	
						if(!first){
							ipLevel3Bean.setIpStatusComboItem(cmb);
							first = true;
						}
					}
				}
				if (ipStatusList!=null && ipStatusList.size()>1){
					ipLevel3Bean.setIpStatusEdit(true);
				}else{
					ipLevel3Bean.setIpStatusEdit(false);
				}
					
				ipLevel3Bean.setIpStatusList(ipStatusList);				
			}else{
				ipLevel3Bean.setIpStatusEdit(false);
				ipLevel3Bean.setIpStatusList(ipStatusList);
				ipLevel3Bean.setStatusEditAble(false);				
			}
		}
	}
	
	public void prepareStatusEditUpdateInfo(IpLevel3Bean bean) throws Exception {
	
		if (!bean.getUserRole().equalsIgnoreCase(IPFMConstant.TIER3)) {
			bean.setCompanyEdit(true);
			bean.setNetworkIpEdit(true);
			bean.setGatewayEdit(true);
		}else{
			bean.setCompanyEdit(false);
			bean.setNetworkIpEdit(false);
			bean.setGatewayEdit(false);
		}
	}	
	
	public String exportIpLevel3() throws Exception{
		logger.debug("===== exportIpLevel3 =====");
		ipLevel3Bean = getIpLevel3Bean();
		try{
			downloadFile("ipLevel3.xlsx",ExportUtils.exportIPLevel3(ipLevel3Bean.getIpInfoList()));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	public void checkDupVlan(){
		logger.debug("===== checkDupVlan =====");
		ipLevel3Bean = getIpLevel3Bean();
		List<IpInfo> ipInfoList;
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		StringBuffer strBuf = new StringBuffer();
		try{
			
			if(StringUtils.isNotEmpty(ipLevel3Bean.getIpInfo().getVlanId())){
				if(StringUtils.isNumeric(ipLevel3Bean.getIpInfo().getVlanId())){
					//Check Duplicate Vlan
					IpInfo ipInfo = new IpInfo();
					ipInfo.setVlanId(ipLevel3Bean.getIpInfo().getVlanId());
					ipInfoList = managementIpService.checkDupVlan(ipInfo); 
					
					if(ipInfoList.size() > 0){
						HashMap subnetMap = new HashMap();
//						ipLevel3Bean.setMsgWarnDup(ipInfoList.get(0).getIpSubmask()+" already use VLAN.");
						strBuf.append("Duplicate VLAN("+ipLevel3Bean.getIpInfo().getVlanId()+") From Network IP : ");
						for(Iterator it=ipInfoList.iterator();it.hasNext();){
							ipInfo = (IpInfo)it.next();
							if(!subnetMap.containsKey(ipInfo.getNetworkIp())){
								strBuf.append(ipInfo.getNetworkIp()+"/"+ipInfo.getSubmask()+", ");
								subnetMap.put(ipInfo.getNetworkIp(), ipInfo.getNetworkIp());
							}
						}
						IPFMMessageUtils.addMessageError(strBuf.toString());
						ipLevel3Bean.setShowWarnDup(true);
					}else{
						ipLevel3Bean.setShowWarnDup(false);
					}
				}else{
					ipLevel3Bean.getIpInfo().setVlanId("");
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0213")));
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String gotoImportUpdte(){
		getIpLevel3Bean().setTemplateType("IPFM");
		getIpLevel3Bean().setShowSaveBtn(false);
		getIpLevel3Bean().setShowDownloadError(false);
		getIpLevel3Bean().setShowDownloadWarn(false);
		return "IPSIP003_IMPORT";
	}
	
	public String backToIpLevel3(){
		return init("IPSIP003");
	}
	
	
	@SuppressWarnings("unchecked")
	public String importExcelUpdate(UploadEvent event) {
		ipLevel3Bean= getIpLevel3Bean();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		HashMap resultMap = null;
		List<IpInfoTemp> ipInfoTempList;
		String result;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try{
			ipLevel3Bean.setShowSaveBtn(false);
			ipLevel3Bean.setShowDownloadError(false);
			ipLevel3Bean.setShowDownloadWarn(false);
			int countError = 0;
			IPFMDataValidateUtil util = new IPFMDataValidateUtil();
			if(StringUtils.equals(ipLevel3Bean.getTemplateType(), "IPFM")){
				resultMap = ImportUtils.importIpLevel3_IPFM(event.getUploadItem(),userSession.getIpUser().getUserId());					
			}else if(StringUtils.equals(ipLevel3Bean.getTemplateType(), "ICTAP")){
				resultMap = ImportUtils.importIpLevel3_ICTAP(event.getUploadItem(),userSession.getIpUser().getUserId());
			}
			if(resultMap != null){
				result = (String)resultMap.get(IPFMConstant.RESULT);
				if(StringUtils.equals(result, IPFMConstant.SUCCESS) ){
					logger.debug("SUCCESS");
					if(resultMap.get(IPFMConstant.IPINFO_LIST) != null){
						ipInfoTempList =  (List<IpInfoTemp>)resultMap.get(IPFMConstant.IPINFO_LIST);
						if(managementIpService.deleteAndInsertIpInfoTemp(ipInfoTempList, userSession.getIpUser().getUserId())){
							resultMap = managementIpService.verifyIpInfoTemp(ipInfoTempList,userSession.getIpUser().getUserId(),ipLevel3Bean.getUserRole());
							Map<String, String> listNatIP = new HashMap<String, String>();
							for(IpInfoTemp tmpIP : ipInfoTempList){
								listNatIP.put(tmpIP.getIpAddress(), tmpIP.getNatIp());
								if(tmpIP.getNatIp() != null && !tmpIP.getNatIp().trim().equals("")){
									String[] nat = tmpIP.getNatIp().split(",");	
									for(String natip : nat){
										if(!util.validateIPFormat(natip)){		
											managementIpService.insertLogVerify(tmpIP.getIpAddress(), "ERROR", "Wrong Format NAT IP", userSession.getIpUser().getUserId());
											countError++;
											 listNatIP = new HashMap<String, String>();
											break;
										}
									}
								}
							}
							ipLevel3Bean.setListNatIP(listNatIP);
						
							if(resultMap != null){
								Integer error = (Integer)resultMap.get("error");
								error = error + countError;
								Integer warn = (Integer)resultMap.get("warn");
								if(error > 0){
									ipLevel3Bean.setShowSaveBtn(false);
									ipLevel3Bean.setShowDownloadError(true);
									ipLevel3Bean.setResultImportMsg(sdf.format(new Date())+" "+userSession.getIpUser().getUserId()+" import VERIFY incomplete ");
								}else if(warn > 0){
									ipLevel3Bean.setResultImportMsg(sdf.format(new Date())+" "+userSession.getIpUser().getUserId()+" import VERIFY complete ");
									ipLevel3Bean.setShowSaveBtn(true);
									ipLevel3Bean.setShowDownloadWarn(true);
								}else{
									ipLevel3Bean.setResultImportMsg(sdf.format(new Date())+" "+userSession.getIpUser().getUserId()+" import VERIFY complete ");
									ipLevel3Bean.setShowSaveBtn(true);
								}
							}
						}else{
							ipLevel3Bean.setShowSaveBtn(false);
							ipLevel3Bean.setShowDownloadError(false);
							ipLevel3Bean.setShowDownloadWarn(false);
							ipLevel3Bean.setResultImportMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0030")));
						}
						
					}
					
				}else{
					ipLevel3Bean.setShowSaveBtn(false);
					ipLevel3Bean.setShowDownloadError(false);
					ipLevel3Bean.setShowDownloadWarn(false);
					ipLevel3Bean.setResultImportMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0030")));
				}
			}
		 }catch (Exception e) {
			e.printStackTrace();
			ipLevel3Bean.setShowSaveBtn(false);
			ipLevel3Bean.setShowDownloadError(false);
			ipLevel3Bean.setShowDownloadWarn(false);
			ipLevel3Bean.setResultImportMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0030")));
		 }
		 return null;
	}
	
	public void addErrorMsg(ExcelErrorMsg excelMsg, String errorMsg){		
		if (excelMsg.getErrorMsg()==null || excelMsg.getErrorMsg().trim().length()==0) {
			excelMsg.setErrorMsg(errorMsg);
		}else{
			excelMsg.setErrorMsg(excelMsg.getErrorMsg() + "<br>" + errorMsg);
		}
	}
	
	public String downloadVerifyImportFile() throws Exception{
		logger.debug("===== downloadVerifyImportFile =====");
		ipLevel3Bean = getIpLevel3Bean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmm");	
		String fileName;
		List<IpLogVerify> ipLogVerifyList;
		StringBuffer fileStr = new StringBuffer("");
		IpLogVerify ipLogVer;
		try{
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			fileName = userSession.getIpUser().getUserId()+"_VERRIFY_"+sdf.format(new Date())+".txt";
			
			ipLogVerifyList = managementIpService.findIpLogVerifyByUsername(userSession.getIpUser().getUserId());
			
			if(ipLogVerifyList != null && ipLogVerifyList.size() > 0){
				for(Iterator it = ipLogVerifyList.iterator();it.hasNext();fileStr.append("\n")){
					ipLogVer = (IpLogVerify)it.next();
//					fileStr.append(ipLogVer.getType()+" ");
//					fileStr.append(ipLogVer.getIpAddress()+" ");
					fileStr.append(ipLogVer.getMsg());
				}
			}
			
			downloadFile(fileName,fileStr.toString().getBytes());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String doSaveImportLv3(){
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			ipLevel3Bean= getIpLevel3Bean();
			managementIpService.saveImportIpLv3(userSession.getIpUser().getUserId());
			List<IPLevel3NatHistory> natHistory = new ArrayList<IPLevel3NatHistory>();
			if(ipLevel3Bean != null && ipLevel3Bean.getListNatIP() != null){
				for (Map.Entry<String, String> entry : ipLevel3Bean.getListNatIP().entrySet())
				{
					String ipData = entry.getKey();
					String natIp = entry.getValue();
					if(ipData != null){
						if(checkPermissionUpdateNatIP(userSession.getIpUser().getUserId(), ipData)){
							IPLevel3NatHistory hisData = managementIpService.validateInsertNatHis(ipData, natIp, userSession.getIpUser().getUserId());
							if(hisData != null && hisData.getIpAddress() != null && !(hisData.getIpAddress().trim().equals(""))){
								natHistory.add(hisData);
							}
							managementIpService.updateNatIP(ipData, natIp);
						}
					}
				}
				
			}
			
			if(natHistory != null && natHistory.size()>0){
				managementIpService.insertNatHistory(natHistory);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return init("IPSIP003");
	}
	
	private boolean checkPermissionUpdateNatIP(String userId,String ip){
		boolean result = false;
		try{
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			result = managementIpService.checkPermissionUpdateNatIP(userId, ip);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}
