package th.co.ais.ipfm.web.manage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlSuggestionBox;

import th.co.ais.ipfm.domain1.ExcelErrorMsg;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpvNetworkIp;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class IpLevel3Bean extends IPFMBaseBean {
	private static final long serialVersionUID = 3251774689702918816L;
	private UserSession userSession;
	
	private String ipVersion = "4";
	private String searchIp1 = "";
	private String searchIp2 = "";
	private String searchIp3 = "";
	private String searchIp4 = "";
	private String searchIp5 = "";
	private String searchIp6 = "";
	private String searchMask = "";
	
	private String paramIpVersion = "4";
	private String paramSearchIp1 = "";
	private String paramSearchIp2 = "";
	private String paramSearchIp3 = "";
	private String paramSearchIp4 = "";
	private String paramSearchIp5 = "";
	private String paramSearchIp6 = "";
	private String paramSearchMask = "";
	private boolean searchFlag = false;
	private String ipAddress = "";
	private String userRole = ""; //T1 = TIER1, T2 = TIER2, T3 = TIER3
	private IpInfo ipInfo = new IpInfo();
	private Date expiredDate = new Date();
	private List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
	private List<IpvNetworkIp> networkIpList = new ArrayList<IpvNetworkIp>();
	private List<SelectItem> locationList = new ArrayList<SelectItem>();
	private List<SelectItem> nwTypeList = new ArrayList<SelectItem>();
	private List<SelectItem> networkZoneList = new ArrayList<SelectItem>();
	private List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
	private List<SelectItem> allIpStatusList = new ArrayList<SelectItem>();
	private List<SelectItem> sysOwnerList = new ArrayList<SelectItem>();
	private List<SelectItem> sysOwnerTeamList = new ArrayList<SelectItem>();
	private List<SelectItem> newSysOwnerTeamList = new ArrayList<SelectItem>();
	private List<SelectItem> projectList = new ArrayList<SelectItem>();
	private List<SelectItem> projManagerList = new ArrayList<SelectItem>();
	private List<SelectItem> companyList = new ArrayList<SelectItem>();
	private List<SelectItem> ipTypeList = new ArrayList<SelectItem>();
	private Map<String,String> listNatIP = new HashMap<String, String>();
	
	private IPFMRichComboItem companyComboItem;
	private IPFMRichComboItem ipStatusComboItem;
	private IPFMRichComboItem locationComboItem;			
	private IPFMRichComboItem networkTypeComboItem;
	private IPFMRichComboItem networkZoneComboItem;
	private IPFMRichComboItem sysOwnerComboItem;
	private IPFMRichComboItem sysOwnerTeamComboItem;
	private IPFMRichComboItem projectComboItem;
	private IPFMRichComboItem projManagerComboItem;
	private IPFMRichComboItem ipTypeComboItem;
	private boolean projManagerDisable = false;
	private boolean projNameDisable = false;
	private HtmlDataTable ipInfoDataTable;
			
	private boolean ipStatusEdit = false;
	private boolean companyEdit = false;
	private boolean ipTypeEdit = false;
	private boolean installTypeEdit = false;
	private boolean networkIpEdit = false;
	private boolean gatewayEdit = false;
	private boolean urReferEdit = false;
	private boolean vlanIdEdit = false;
	private boolean networkZoneEdit = false;
	private boolean t3RemarksEdit = false;
	private boolean statusEditAble = false;
	
	
	private boolean ipStatusUpdate = false;
	private boolean companyUpdate = false;
	private boolean dnsNameUpdate = false;
	private boolean networkIpUpdate = false;
	private boolean ipSubmarkUpdate = false;
	private boolean siteLocationUpdate = false;
	private boolean systemNameUpdate = false;
	private boolean systemOwnerNameUpdate =false;
	private boolean dystemOwnerTeamUpdate = false;
	private boolean gatewayUpdate = false;
	private boolean expireUpdate = false;
	
	
	
	
	private String networkIp;
	private String dnsName;
	private String ipSubmask;
	private String hostName;
	private String systemName;
	private String gateway;
	private String systemOwnerName;
	private String natIp;
	private boolean natIpPermission;
	
	private String projManagerId="";
	private String teamId="";
	private HtmlSuggestionBox suggestSystemOwner = new HtmlSuggestionBox();
	private HtmlSuggestionBox suggestSystemOwnerUpdate = new HtmlSuggestionBox();
	private HtmlSuggestionBox suggestProjManager= new HtmlSuggestionBox();
	private String oldIpStatus;
	
	private HtmlSuggestionBox suggestSystemOwnerUpdateInfo = new HtmlSuggestionBox();
	
	private boolean checkBoxIPStatus = false;
	private boolean checkBoxHostName = false;
	private boolean checkBoxCompany = false;
	private boolean checkBoxSystemName = false;
	private boolean checkBoxSystemOwnerName = false;
	private boolean checkBoxDNSName = false;
	private boolean checkBoxNetworkIP = false;
	private boolean checkBoxSiteLocation = false;
	private boolean checkBoxGateway = false;
	private boolean checkBoxExpiredDate = false;
	private boolean checkBoxMask = false;
	private boolean checkBoxVlan = false;
	private boolean checkBoxNat = false;

	private SortColumnBean sortSIP003View = new SortColumnBean();
	private FilterBean filterSIP003View = new FilterBean();
	
	private boolean showWarnDup = false;
	private String msgWarnDup;
	private boolean showSaveBtn = false;
	private boolean showDownloadError = false;
	private boolean showDownloadWarn = false;
	private String resultImportMsg;
	private List<ExcelErrorMsg> errorMsgList = new ArrayList<ExcelErrorMsg>();
	
	//Import
	private String templateType;
	
	private boolean openCheckBoxNatIP;
	
	public boolean isCheckBoxIPStatus() {
		return checkBoxIPStatus;
	}

	public void setCheckBoxIPStatus(boolean checkBoxIPStatus) {
		this.checkBoxIPStatus = checkBoxIPStatus;
	}

	public boolean isCheckBoxHostName() {
		return checkBoxHostName;
	}

	public void setCheckBoxHostName(boolean checkBoxHostName) {
		this.checkBoxHostName = checkBoxHostName;
	}

	public boolean isCheckBoxCompany() {
		return checkBoxCompany;
	}

	public void setCheckBoxCompany(boolean checkBoxCompany) {
		this.checkBoxCompany = checkBoxCompany;
	}

	public boolean isCheckBoxSystemName() {
		return checkBoxSystemName;
	}

	public void setCheckBoxSystemName(boolean checkBoxSystemName) {
		this.checkBoxSystemName = checkBoxSystemName;
	}

	public boolean isCheckBoxSystemOwnerName() {
		return checkBoxSystemOwnerName;
	}

	public void setCheckBoxSystemOwnerName(boolean checkBoxSystemOwnerName) {
		this.checkBoxSystemOwnerName = checkBoxSystemOwnerName;
	}

	public boolean isCheckBoxDNSName() {
		return checkBoxDNSName;
	}

	public void setCheckBoxDNSName(boolean checkBoxDNSName) {
		this.checkBoxDNSName = checkBoxDNSName;
	}

	public boolean isCheckBoxNetworkIP() {
		return checkBoxNetworkIP;
	}

	public void setCheckBoxNetworkIP(boolean checkBoxNetworkIP) {
		this.checkBoxNetworkIP = checkBoxNetworkIP;
	}

	public boolean isCheckBoxSiteLocation() {
		return checkBoxSiteLocation;
	}

	public void setCheckBoxSiteLocation(boolean checkBoxSiteLocation) {
		this.checkBoxSiteLocation = checkBoxSiteLocation;
	}

	public boolean isCheckBoxGateway() {
		return checkBoxGateway;
	}

	public void setCheckBoxGateway(boolean checkBoxGateway) {
		this.checkBoxGateway = checkBoxGateway;
	}

	public boolean isCheckBoxExpiredDate() {
		return checkBoxExpiredDate;
	}

	public void setCheckBoxExpiredDate(boolean checkBoxExpiredDate) {
		this.checkBoxExpiredDate = checkBoxExpiredDate;
	}

	public boolean isCheckBoxMask() {
		return checkBoxMask;
	}

	public void setCheckBoxMask(boolean checkBoxMask) {
		this.checkBoxMask = checkBoxMask;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HtmlSuggestionBox getSuggestSystemOwnerUpdateInfo() {
		return suggestSystemOwnerUpdateInfo;
	}

	public void setSuggestSystemOwnerUpdateInfo(
			HtmlSuggestionBox suggestSystemOwnerUpdateInfo) {
		this.suggestSystemOwnerUpdateInfo = suggestSystemOwnerUpdateInfo;
	}

	public IpLevel3Bean(){
	}
	
	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public List<SelectItem> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}

	public List<IpvNetworkIp> getNetworkIpList() {
		return networkIpList;
	}

	public void setNetworkIpList(List<IpvNetworkIp> networkIpList) {
		this.networkIpList = networkIpList;
	}

	public List<SelectItem> getNwTypeList() {
		return nwTypeList;
	}

	public void setNwTypeList(List<SelectItem> nwTypeList) {
		this.nwTypeList = nwTypeList;
	}

	public List<SelectItem> getIpStatusList() {
		return ipStatusList;
	}

	public void setIpStatusList(List<SelectItem> ipStatusList) {
		this.ipStatusList = ipStatusList;
	}

	public IPFMRichComboItem getIpStatusComboItem() {
		return ipStatusComboItem;
	}

	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) {
		this.ipStatusComboItem = ipStatusComboItem;
	}

	public IPFMRichComboItem getLocationComboItem() {
		return locationComboItem;
	}

	public void setLocationComboItem(IPFMRichComboItem locationComboItem) {
		this.locationComboItem = locationComboItem;
	}

	public IPFMRichComboItem getNetworkTypeComboItem() {
		return networkTypeComboItem;
	}

	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) {
		this.networkTypeComboItem = networkTypeComboItem;
	}

	public List<IpInfo> getIpInfoList() {
		return ipInfoList;
	}

	public void setIpInfoList(List<IpInfo> ipInfoList) {
		this.ipInfoList = ipInfoList;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public IpInfo getIpInfo() {
		return ipInfo;
	}

	public void setIpInfo(IpInfo ipInfo) {
		this.ipInfo = ipInfo;
	}

	public List<SelectItem> getSysOwnerList() {
		return sysOwnerList;
	}

	public void setSysOwnerList(List<SelectItem> sysOwnerList) {
		this.sysOwnerList = sysOwnerList;
	}

	public List<SelectItem> getSysOwnerTeamList() {
		return sysOwnerTeamList;
	}

	public void setSysOwnerTeamList(List<SelectItem> sysOwnerTeamList) {
		this.sysOwnerTeamList = sysOwnerTeamList;
	}

	public List<SelectItem> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<SelectItem> projectList) {
		this.projectList = projectList;
	}

	public List<SelectItem> getProjManagerList() {
		return projManagerList;
	}

	public void setProjManagerList(List<SelectItem> projManagerList) {
		this.projManagerList = projManagerList;
	}

	public IPFMRichComboItem getSysOwnerComboItem() {
		return sysOwnerComboItem;
	}

	public void setSysOwnerComboItem(IPFMRichComboItem sysOwnerComboItem) {
		this.sysOwnerComboItem = sysOwnerComboItem;
	}

	public IPFMRichComboItem getSysOwnerTeamComboItem() {
		return sysOwnerTeamComboItem;
	}

	public void setSysOwnerTeamComboItem(IPFMRichComboItem sysOwnerTeamComboItem) {
		this.sysOwnerTeamComboItem = sysOwnerTeamComboItem;
	}

	public IPFMRichComboItem getProjectComboItem() {
		return projectComboItem;
	}

	public void setProjectComboItem(IPFMRichComboItem projectComboItem) {
		this.projectComboItem = projectComboItem;
	}

	public IPFMRichComboItem getProjManagerComboItem() {
		return projManagerComboItem;
	}

	public void setProjManagerComboItem(IPFMRichComboItem projManagerComboItem) {
		this.projManagerComboItem = projManagerComboItem;
	}

	public boolean isProjManagerDisable() {
		return projManagerDisable;
	}

	public void setProjManagerDisable(boolean projManagerDisable) {
		this.projManagerDisable = projManagerDisable;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public HtmlDataTable getIpInfoDataTable() {
		return ipInfoDataTable;
	}

	public void setIpInfoDataTable(HtmlDataTable ipInfoDataTable) {
		this.ipInfoDataTable = ipInfoDataTable;
	}

	public boolean isProjNameDisable() {
		return projNameDisable;
	}

	public void setProjNameDisable(boolean projNameDisable) {
		this.projNameDisable = projNameDisable;
	}

	public List<SelectItem> getAllIpStatusList() {
		return allIpStatusList;
	}

	public void setAllIpStatusList(List<SelectItem> allIpStatusList) {
		this.allIpStatusList = allIpStatusList;
	}

	public boolean isIpStatusEdit() {
		return ipStatusEdit;
	}

	public void setIpStatusEdit(boolean ipStatusEdit) {
		this.ipStatusEdit = ipStatusEdit;
	}

	public boolean isCompanyEdit() {
		return companyEdit;
	}

	public void setCompanyEdit(boolean companyEdit) {
		this.companyEdit = companyEdit;
	}

	public boolean isIpTypeEdit() {
		return ipTypeEdit;
	}

	public void setIpTypeEdit(boolean ipTypeEdit) {
		this.ipTypeEdit = ipTypeEdit;
	}

	public boolean isInstallTypeEdit() {
		return installTypeEdit;
	}

	public void setInstallTypeEdit(boolean installTypeEdit) {
		this.installTypeEdit = installTypeEdit;
	}

	public boolean isUrReferEdit() {
		return urReferEdit;
	}

	public void setUrReferEdit(boolean urReferEdit) {
		this.urReferEdit = urReferEdit;
	}

	public boolean isVlanIdEdit() {
		return vlanIdEdit;
	}

	public void setVlanIdEdit(boolean vlanIdEdit) {
		this.vlanIdEdit = vlanIdEdit;
	}

	public boolean isNetworkZoneEdit() {
		return networkZoneEdit;
	}

	public void setNetworkZoneEdit(boolean networkZoneEdit) {
		this.networkZoneEdit = networkZoneEdit;
	}

	public boolean isT3RemarksEdit() {
		return t3RemarksEdit;
	}

	public void setT3RemarksEdit(boolean t3RemarksEdit) {
		this.t3RemarksEdit = t3RemarksEdit;
	}

	public boolean isNetworkIpEdit() {
		return networkIpEdit;
	}

	public void setNetworkIpEdit(boolean networkIpEdit) {
		this.networkIpEdit = networkIpEdit;
	}

	public boolean isGatewayEdit() {
		return gatewayEdit;
	}

	public void setGatewayEdit(boolean gatewayEdit) {
		this.gatewayEdit = gatewayEdit;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public IPFMRichComboItem getCompanyComboItem() {
		return companyComboItem;
	}

	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) {
		this.companyComboItem = companyComboItem;
	}

	public List<SelectItem> getIpTypeList() {
		return ipTypeList;
	}

	public void setIpTypeList(List<SelectItem> ipTypeList) {
		this.ipTypeList = ipTypeList;
	}

	public IPFMRichComboItem getIpTypeComboItem() {
		return ipTypeComboItem;
	}

	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) {
		this.ipTypeComboItem = ipTypeComboItem;
	}

	public List<SelectItem> getNetworkZoneList() {
		return networkZoneList;
	}

	public void setNetworkZoneList(List<SelectItem> networkZoneList) {
		this.networkZoneList = networkZoneList;
	}

	public IPFMRichComboItem getNetworkZoneComboItem() {
		return networkZoneComboItem;
	}

	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) {
		this.networkZoneComboItem = networkZoneComboItem;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	public HtmlSuggestionBox getSuggestSystemOwnerUpdate() {
		return suggestSystemOwnerUpdate;
	}

	public void setSuggestSystemOwnerUpdate(
			HtmlSuggestionBox suggestSystemOwnerUpdate) {
		this.suggestSystemOwnerUpdate = suggestSystemOwnerUpdate;
	}

	public HtmlSuggestionBox getSuggestSystemOwner() {
		return suggestSystemOwner;
	}

	public void setSuggestSystemOwner(HtmlSuggestionBox suggestSystemOwner) {
		this.suggestSystemOwner = suggestSystemOwner;
	}

	public HtmlSuggestionBox getSuggestProjManager() {
		return suggestProjManager;
	}

	public void setSuggestProjManager(HtmlSuggestionBox suggestProjManager) {
		this.suggestProjManager = suggestProjManager;
	}

	public String getProjManagerId() {
		return projManagerId;
	}

	public void setProjManagerId(String projManagerId) {
		this.projManagerId = projManagerId;
	}

	public List<SelectItem> getNewSysOwnerTeamList() {
		return newSysOwnerTeamList;
	}

	public void setNewSysOwnerTeamList(List<SelectItem> newSysOwnerTeamList) {
		this.newSysOwnerTeamList = newSysOwnerTeamList;
	}

	public String getOldIpStatus() {
		return oldIpStatus;
	}

	public void setOldIpStatus(String oldIpStatus) {
		this.oldIpStatus = oldIpStatus;
	}

	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}

	public String getSearchIp1() {
		return searchIp1;
	}

	public void setSearchIp1(String searchIp1) {
		this.searchIp1 = searchIp1;
	}

	public String getSearchIp2() {
		return searchIp2;
	}

	public void setSearchIp2(String searchIp2) {
		this.searchIp2 = searchIp2;
	}

	public String getSearchIp3() {
		return searchIp3;
	}

	public void setSearchIp3(String searchIp3) {
		this.searchIp3 = searchIp3;
	}

	public String getSearchIp4() {
		return searchIp4;
	}

	public void setSearchIp4(String searchIp4) {
		this.searchIp4 = searchIp4;
	}

	public String getSearchIp5() {
		return searchIp5;
	}

	public void setSearchIp5(String searchIp5) {
		this.searchIp5 = searchIp5;
	}

	public String getSearchIp6() {
		return searchIp6;
	}

	public void setSearchIp6(String searchIp6) {
		this.searchIp6 = searchIp6;
	}

	public String getSearchMask() {
		return searchMask;
	}

	public void setSearchMask(String searchMask) {
		this.searchMask = searchMask;
	}

	public String getParamIpVersion() {
		return paramIpVersion;
	}

	public void setParamIpVersion(String paramIpVersion) {
		this.paramIpVersion = paramIpVersion;
	}

	public String getParamSearchIp1() {
		return paramSearchIp1;
	}

	public void setParamSearchIp1(String paramSearchIp1) {
		this.paramSearchIp1 = paramSearchIp1;
	}

	public String getParamSearchIp2() {
		return paramSearchIp2;
	}

	public void setParamSearchIp2(String paramSearchIp2) {
		this.paramSearchIp2 = paramSearchIp2;
	}

	public String getParamSearchIp3() {
		return paramSearchIp3;
	}

	public void setParamSearchIp3(String paramSearchIp3) {
		this.paramSearchIp3 = paramSearchIp3;
	}

	public String getParamSearchIp4() {
		return paramSearchIp4;
	}

	public void setParamSearchIp4(String paramSearchIp4) {
		this.paramSearchIp4 = paramSearchIp4;
	}

	public String getParamSearchIp5() {
		return paramSearchIp5;
	}

	public void setParamSearchIp5(String paramSearchIp5) {
		this.paramSearchIp5 = paramSearchIp5;
	}

	public String getParamSearchIp6() {
		return paramSearchIp6;
	}

	public void setParamSearchIp6(String paramSearchIp6) {
		this.paramSearchIp6 = paramSearchIp6;
	}

	public String getParamSearchMask() {
		return paramSearchMask;
	}

	public void setParamSearchMask(String paramSearchMask) {
		this.paramSearchMask = paramSearchMask;
	}

	public boolean isSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag) {
		this.searchFlag = searchFlag;
	}

	public boolean isStatusEditAble() {
		return statusEditAble;
	}

	public void setStatusEditAble(boolean statusEditAble) {
		this.statusEditAble = statusEditAble;
	}

	public String getNetworkIp() {
		return networkIp;
	}

	public void setNetworkIp(String networkIp) {
		this.networkIp = networkIp;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public String getIpSubmask() {
		return ipSubmask;
	}

	public void setIpSubmask(String ipSubmask) {
		this.ipSubmask = ipSubmask;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getSystemOwnerName() {
		return systemOwnerName;
	}

	public void setSystemOwnerName(String systemOwnerName) {
		this.systemOwnerName = systemOwnerName;
	}

	public boolean isIpStatusUpdate() {
		return ipStatusUpdate;
	}

	public void setIpStatusUpdate(boolean ipStatusUpdate) {
		this.ipStatusUpdate = ipStatusUpdate;
	}

	public boolean isCompanyUpdate() {
		return companyUpdate;
	}

	public void setCompanyUpdate(boolean companyUpdate) {
		this.companyUpdate = companyUpdate;
	}

	public boolean isDnsNameUpdate() {
		return dnsNameUpdate;
	}

	public void setDnsNameUpdate(boolean dnsNameUpdate) {
		this.dnsNameUpdate = dnsNameUpdate;
	}

	public boolean isNetworkIpUpdate() {
		return networkIpUpdate;
	}

	public void setNetworkIpUpdate(boolean networkIpUpdate) {
		this.networkIpUpdate = networkIpUpdate;
	}

	public boolean isIpSubmarkUpdate() {
		return ipSubmarkUpdate;
	}

	public void setIpSubmarkUpdate(boolean ipSubmarkUpdate) {
		this.ipSubmarkUpdate = ipSubmarkUpdate;
	}

	public boolean isSiteLocationUpdate() {
		return siteLocationUpdate;
	}

	public void setSiteLocationUpdate(boolean siteLocationUpdate) {
		this.siteLocationUpdate = siteLocationUpdate;
	}

	public boolean isSystemNameUpdate() {
		return systemNameUpdate;
	}

	public void setSystemNameUpdate(boolean systemNameUpdate) {
		this.systemNameUpdate = systemNameUpdate;
	}

	public boolean isSystemOwnerNameUpdate() {
		return systemOwnerNameUpdate;
	}

	public void setSystemOwnerNameUpdate(boolean systemOwnerNameUpdate) {
		this.systemOwnerNameUpdate = systemOwnerNameUpdate;
	}

	public boolean isDystemOwnerTeamUpdate() {
		return dystemOwnerTeamUpdate;
	}

	public void setDystemOwnerTeamUpdate(boolean dystemOwnerTeamUpdate) {
		this.dystemOwnerTeamUpdate = dystemOwnerTeamUpdate;
	}

	public boolean isGatewayUpdate() {
		return gatewayUpdate;
	}

	public void setGatewayUpdate(boolean gatewayUpdate) {
		this.gatewayUpdate = gatewayUpdate;
	}

	public boolean isExpireUpdate() {
		return expireUpdate;
	}

	public void setExpireUpdate(boolean expireUpdate) {
		this.expireUpdate = expireUpdate;
	}

	public void setSortSIP003View(SortColumnBean sortSIP003View) {
		this.sortSIP003View = sortSIP003View;
	}

	public SortColumnBean getSortSIP003View() {
		return sortSIP003View;
	}

	public void setFilterSIP003View(FilterBean filterSIP003View) {
		this.filterSIP003View = filterSIP003View;
	}

	public FilterBean getFilterSIP003View() {
		return filterSIP003View;
	}

	public boolean isCheckBoxVlan() {
		return checkBoxVlan;
	}

	public void setCheckBoxVlan(boolean checkBoxVlan) {
		this.checkBoxVlan = checkBoxVlan;
	}

	public boolean isShowWarnDup() {
		return showWarnDup;
	}

	public void setShowWarnDup(boolean showWarnDup) {
		this.showWarnDup = showWarnDup;
	}

	public String getMsgWarnDup() {
		return msgWarnDup;
	}

	public void setMsgWarnDup(String msgWarnDup) {
		this.msgWarnDup = msgWarnDup;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public boolean isShowSaveBtn() {
		return showSaveBtn;
	}

	public void setShowSaveBtn(boolean showSaveBtn) {
		this.showSaveBtn = showSaveBtn;
	}

	public boolean isShowDownloadError() {
		return showDownloadError;
	}

	public void setShowDownloadError(boolean showDownloadError) {
		this.showDownloadError = showDownloadError;
	}

	public boolean isShowDownloadWarn() {
		return showDownloadWarn;
	}

	public void setShowDownloadWarn(boolean showDownloadWarn) {
		this.showDownloadWarn = showDownloadWarn;
	}

	public String getResultImportMsg() {
		return resultImportMsg;
	}

	public void setResultImportMsg(String resultImportMsg) {
		this.resultImportMsg = resultImportMsg;
	}

	public List<ExcelErrorMsg> getErrorMsgList() {
		return errorMsgList;
	}

	public void setErrorMsgList(List<ExcelErrorMsg> errorMsgList) {
		this.errorMsgList = errorMsgList;
	}

	public String getNatIp() {
		return natIp;
	}

	public void setNatIp(String natIp) {
		this.natIp = natIp;
	}

	public boolean isNatIpPermission() {
		return natIpPermission;
	}

	public void setNatIpPermission(boolean natIpPermission) {
		this.natIpPermission = natIpPermission;
	}

	public boolean isCheckBoxNat() {
		return checkBoxNat;
	}

	public void setCheckBoxNat(boolean checkBoxNat) {
		this.checkBoxNat = checkBoxNat;
	}

	public Map<String, String> getListNatIP() {
		return listNatIP;
	}

	public void setListNatIP(Map<String, String> listNatIP) {
		this.listNatIP = listNatIP;
	}

	public boolean isOpenCheckBoxNatIP() {
		return openCheckBoxNatIP;
	}

	public void setOpenCheckBoxNatIP(boolean openCheckBoxNatIP) {
		this.openCheckBoxNatIP = openCheckBoxNatIP;
	}
	
	
	
}
