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
	
	public boolean isCheckBoxIPStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxIPStatus
		return checkBoxIPStatus;
	}

	public void setCheckBoxIPStatus(boolean checkBoxIPStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxIPStatus
		this.checkBoxIPStatus = checkBoxIPStatus;
	}

	public boolean isCheckBoxHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxHostName
		return checkBoxHostName;
	}

	public void setCheckBoxHostName(boolean checkBoxHostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxHostName
		this.checkBoxHostName = checkBoxHostName;
	}

	public boolean isCheckBoxCompany() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxCompany
		return checkBoxCompany;
	}

	public void setCheckBoxCompany(boolean checkBoxCompany) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxCompany
		this.checkBoxCompany = checkBoxCompany;
	}

	public boolean isCheckBoxSystemName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxSystemName
		return checkBoxSystemName;
	}

	public void setCheckBoxSystemName(boolean checkBoxSystemName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxSystemName
		this.checkBoxSystemName = checkBoxSystemName;
	}

	public boolean isCheckBoxSystemOwnerName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxSystemOwnerName
		return checkBoxSystemOwnerName;
	}

	public void setCheckBoxSystemOwnerName(boolean checkBoxSystemOwnerName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxSystemOwnerName
		this.checkBoxSystemOwnerName = checkBoxSystemOwnerName;
	}

	public boolean isCheckBoxDNSName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxDNSName
		return checkBoxDNSName;
	}

	public void setCheckBoxDNSName(boolean checkBoxDNSName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxDNSName
		this.checkBoxDNSName = checkBoxDNSName;
	}

	public boolean isCheckBoxNetworkIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxNetworkIP
		return checkBoxNetworkIP;
	}

	public void setCheckBoxNetworkIP(boolean checkBoxNetworkIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxNetworkIP
		this.checkBoxNetworkIP = checkBoxNetworkIP;
	}

	public boolean isCheckBoxSiteLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxSiteLocation
		return checkBoxSiteLocation;
	}

	public void setCheckBoxSiteLocation(boolean checkBoxSiteLocation) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxSiteLocation
		this.checkBoxSiteLocation = checkBoxSiteLocation;
	}

	public boolean isCheckBoxGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxGateway
		return checkBoxGateway;
	}

	public void setCheckBoxGateway(boolean checkBoxGateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxGateway
		this.checkBoxGateway = checkBoxGateway;
	}

	public boolean isCheckBoxExpiredDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxExpiredDate
		return checkBoxExpiredDate;
	}

	public void setCheckBoxExpiredDate(boolean checkBoxExpiredDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxExpiredDate
		this.checkBoxExpiredDate = checkBoxExpiredDate;
	}

	public boolean isCheckBoxMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxMask
		return checkBoxMask;
	}

	public void setCheckBoxMask(boolean checkBoxMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxMask
		this.checkBoxMask = checkBoxMask;
	}

	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}

	public HtmlSuggestionBox getSuggestSystemOwnerUpdateInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestSystemOwnerUpdateInfo
		return suggestSystemOwnerUpdateInfo;
	}

	public void setSuggestSystemOwnerUpdateInfo( // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestSystemOwnerUpdateInfo
			HtmlSuggestionBox suggestSystemOwnerUpdateInfo) {
		this.suggestSystemOwnerUpdateInfo = suggestSystemOwnerUpdateInfo;
	}

	public IpLevel3Bean(){
	}
	
	public UserSession getUserSession() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserSession
		return userSession;
	}

	public void setUserSession(UserSession userSession) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserSession
		this.userSession = userSession;
	}

	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpAddress
		this.ipAddress = ipAddress;
	}

	public List<SelectItem> getLocationList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationList
		return locationList;
	}

	public void setLocationList(List<SelectItem> locationList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationList
		this.locationList = locationList;
	}

	public List<IpvNetworkIp> getNetworkIpList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkIpList
		return networkIpList;
	}

	public void setNetworkIpList(List<IpvNetworkIp> networkIpList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkIpList
		this.networkIpList = networkIpList;
	}

	public List<SelectItem> getNwTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwTypeList
		return nwTypeList;
	}

	public void setNwTypeList(List<SelectItem> nwTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwTypeList
		this.nwTypeList = nwTypeList;
	}

	public List<SelectItem> getIpStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusList
		return ipStatusList;
	}

	public void setIpStatusList(List<SelectItem> ipStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusList
		this.ipStatusList = ipStatusList;
	}

	public IPFMRichComboItem getIpStatusComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusComboItem
		return ipStatusComboItem;
	}

	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusComboItem
		this.ipStatusComboItem = ipStatusComboItem;
	}

	public IPFMRichComboItem getLocationComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationComboItem
		return locationComboItem;
	}

	public void setLocationComboItem(IPFMRichComboItem locationComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationComboItem
		this.locationComboItem = locationComboItem;
	}

	public IPFMRichComboItem getNetworkTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkTypeComboItem
		return networkTypeComboItem;
	}

	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeComboItem
		this.networkTypeComboItem = networkTypeComboItem;
	}

	public List<IpInfo> getIpInfoList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfoList
		return ipInfoList;
	}

	public void setIpInfoList(List<IpInfo> ipInfoList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfoList
		this.ipInfoList = ipInfoList;
	}

	public String getUserRole() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserRole
		return userRole;
	}

	public void setUserRole(String userRole) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserRole
		this.userRole = userRole;
	}

	public IpInfo getIpInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfo
		return ipInfo;
	}

	public void setIpInfo(IpInfo ipInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfo
		this.ipInfo = ipInfo;
	}

	public List<SelectItem> getSysOwnerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerList
		return sysOwnerList;
	}

	public void setSysOwnerList(List<SelectItem> sysOwnerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerList
		this.sysOwnerList = sysOwnerList;
	}

	public List<SelectItem> getSysOwnerTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerTeamList
		return sysOwnerTeamList;
	}

	public void setSysOwnerTeamList(List<SelectItem> sysOwnerTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerTeamList
		this.sysOwnerTeamList = sysOwnerTeamList;
	}

	public List<SelectItem> getProjectList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectList
		return projectList;
	}

	public void setProjectList(List<SelectItem> projectList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectList
		this.projectList = projectList;
	}

	public List<SelectItem> getProjManagerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjManagerList
		return projManagerList;
	}

	public void setProjManagerList(List<SelectItem> projManagerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerList
		this.projManagerList = projManagerList;
	}

	public IPFMRichComboItem getSysOwnerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerComboItem
		return sysOwnerComboItem;
	}

	public void setSysOwnerComboItem(IPFMRichComboItem sysOwnerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerComboItem
		this.sysOwnerComboItem = sysOwnerComboItem;
	}

	public IPFMRichComboItem getSysOwnerTeamComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerTeamComboItem
		return sysOwnerTeamComboItem;
	}

	public void setSysOwnerTeamComboItem(IPFMRichComboItem sysOwnerTeamComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerTeamComboItem
		this.sysOwnerTeamComboItem = sysOwnerTeamComboItem;
	}

	public IPFMRichComboItem getProjectComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectComboItem
		return projectComboItem;
	}

	public void setProjectComboItem(IPFMRichComboItem projectComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectComboItem
		this.projectComboItem = projectComboItem;
	}

	public IPFMRichComboItem getProjManagerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjManagerComboItem
		return projManagerComboItem;
	}

	public void setProjManagerComboItem(IPFMRichComboItem projManagerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerComboItem
		this.projManagerComboItem = projManagerComboItem;
	}

	public boolean isProjManagerDisable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isProjManagerDisable
		return projManagerDisable;
	}

	public void setProjManagerDisable(boolean projManagerDisable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerDisable
		this.projManagerDisable = projManagerDisable;
	}

	public Date getExpiredDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpiredDate
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpiredDate
		this.expiredDate = expiredDate;
	}

	public HtmlDataTable getIpInfoDataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfoDataTable
		return ipInfoDataTable;
	}

	public void setIpInfoDataTable(HtmlDataTable ipInfoDataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfoDataTable
		this.ipInfoDataTable = ipInfoDataTable;
	}

	public boolean isProjNameDisable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isProjNameDisable
		return projNameDisable;
	}

	public void setProjNameDisable(boolean projNameDisable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjNameDisable
		this.projNameDisable = projNameDisable;
	}

	public List<SelectItem> getAllIpStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllIpStatusList
		return allIpStatusList;
	}

	public void setAllIpStatusList(List<SelectItem> allIpStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllIpStatusList
		this.allIpStatusList = allIpStatusList;
	}

	public boolean isIpStatusEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpStatusEdit
		return ipStatusEdit;
	}

	public void setIpStatusEdit(boolean ipStatusEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusEdit
		this.ipStatusEdit = ipStatusEdit;
	}

	public boolean isCompanyEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCompanyEdit
		return companyEdit;
	}

	public void setCompanyEdit(boolean companyEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyEdit
		this.companyEdit = companyEdit;
	}

	public boolean isIpTypeEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpTypeEdit
		return ipTypeEdit;
	}

	public void setIpTypeEdit(boolean ipTypeEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeEdit
		this.ipTypeEdit = ipTypeEdit;
	}

	public boolean isInstallTypeEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isInstallTypeEdit
		return installTypeEdit;
	}

	public void setInstallTypeEdit(boolean installTypeEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallTypeEdit
		this.installTypeEdit = installTypeEdit;
	}

	public boolean isUrReferEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isUrReferEdit
		return urReferEdit;
	}

	public void setUrReferEdit(boolean urReferEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrReferEdit
		this.urReferEdit = urReferEdit;
	}

	public boolean isVlanIdEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isVlanIdEdit
		return vlanIdEdit;
	}

	public void setVlanIdEdit(boolean vlanIdEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVlanIdEdit
		this.vlanIdEdit = vlanIdEdit;
	}

	public boolean isNetworkZoneEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isNetworkZoneEdit
		return networkZoneEdit;
	}

	public void setNetworkZoneEdit(boolean networkZoneEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneEdit
		this.networkZoneEdit = networkZoneEdit;
	}

	public boolean isT3RemarksEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isT3RemarksEdit
		return t3RemarksEdit;
	}

	public void setT3RemarksEdit(boolean t3RemarksEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT3RemarksEdit
		this.t3RemarksEdit = t3RemarksEdit;
	}

	public boolean isNetworkIpEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isNetworkIpEdit
		return networkIpEdit;
	}

	public void setNetworkIpEdit(boolean networkIpEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkIpEdit
		this.networkIpEdit = networkIpEdit;
	}

	public boolean isGatewayEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isGatewayEdit
		return gatewayEdit;
	}

	public void setGatewayEdit(boolean gatewayEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGatewayEdit
		this.gatewayEdit = gatewayEdit;
	}

	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}

	public IPFMRichComboItem getCompanyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyComboItem
		return companyComboItem;
	}

	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyComboItem
		this.companyComboItem = companyComboItem;
	}

	public List<SelectItem> getIpTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeList
		return ipTypeList;
	}

	public void setIpTypeList(List<SelectItem> ipTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeList
		this.ipTypeList = ipTypeList;
	}

	public IPFMRichComboItem getIpTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeComboItem
		return ipTypeComboItem;
	}

	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeComboItem
		this.ipTypeComboItem = ipTypeComboItem;
	}

	public List<SelectItem> getNetworkZoneList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneList
		return networkZoneList;
	}

	public void setNetworkZoneList(List<SelectItem> networkZoneList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneList
		this.networkZoneList = networkZoneList;
	}

	public IPFMRichComboItem getNetworkZoneComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneComboItem
		return networkZoneComboItem;
	}

	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneComboItem
		this.networkZoneComboItem = networkZoneComboItem;
	}

	public String getTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamId
		return teamId;
	}

	public void setTeamId(String teamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamId
		this.teamId = teamId;
	}
	
	public HtmlSuggestionBox getSuggestSystemOwnerUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestSystemOwnerUpdate
		return suggestSystemOwnerUpdate;
	}

	public void setSuggestSystemOwnerUpdate( // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestSystemOwnerUpdate
			HtmlSuggestionBox suggestSystemOwnerUpdate) {
		this.suggestSystemOwnerUpdate = suggestSystemOwnerUpdate;
	}

	public HtmlSuggestionBox getSuggestSystemOwner() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestSystemOwner
		return suggestSystemOwner;
	}

	public void setSuggestSystemOwner(HtmlSuggestionBox suggestSystemOwner) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestSystemOwner
		this.suggestSystemOwner = suggestSystemOwner;
	}

	public HtmlSuggestionBox getSuggestProjManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestProjManager
		return suggestProjManager;
	}

	public void setSuggestProjManager(HtmlSuggestionBox suggestProjManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestProjManager
		this.suggestProjManager = suggestProjManager;
	}

	public String getProjManagerId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjManagerId
		return projManagerId;
	}

	public void setProjManagerId(String projManagerId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerId
		this.projManagerId = projManagerId;
	}

	public List<SelectItem> getNewSysOwnerTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNewSysOwnerTeamList
		return newSysOwnerTeamList;
	}

	public void setNewSysOwnerTeamList(List<SelectItem> newSysOwnerTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNewSysOwnerTeamList
		this.newSysOwnerTeamList = newSysOwnerTeamList;
	}

	public String getOldIpStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOldIpStatus
		return oldIpStatus;
	}

	public void setOldIpStatus(String oldIpStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOldIpStatus
		this.oldIpStatus = oldIpStatus;
	}

	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}

	public String getSearchIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp1
		return searchIp1;
	}

	public void setSearchIp1(String searchIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp1
		this.searchIp1 = searchIp1;
	}

	public String getSearchIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp2
		return searchIp2;
	}

	public void setSearchIp2(String searchIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp2
		this.searchIp2 = searchIp2;
	}

	public String getSearchIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp3
		return searchIp3;
	}

	public void setSearchIp3(String searchIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp3
		this.searchIp3 = searchIp3;
	}

	public String getSearchIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp4
		return searchIp4;
	}

	public void setSearchIp4(String searchIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp4
		this.searchIp4 = searchIp4;
	}

	public String getSearchIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp5
		return searchIp5;
	}

	public void setSearchIp5(String searchIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp5
		this.searchIp5 = searchIp5;
	}

	public String getSearchIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp6
		return searchIp6;
	}

	public void setSearchIp6(String searchIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp6
		this.searchIp6 = searchIp6;
	}

	public String getSearchMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchMask
		return searchMask;
	}

	public void setSearchMask(String searchMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchMask
		this.searchMask = searchMask;
	}

	public String getParamIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamIpVersion
		return paramIpVersion;
	}

	public void setParamIpVersion(String paramIpVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamIpVersion
		this.paramIpVersion = paramIpVersion;
	}

	public String getParamSearchIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp1
		return paramSearchIp1;
	}

	public void setParamSearchIp1(String paramSearchIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp1
		this.paramSearchIp1 = paramSearchIp1;
	}

	public String getParamSearchIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp2
		return paramSearchIp2;
	}

	public void setParamSearchIp2(String paramSearchIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp2
		this.paramSearchIp2 = paramSearchIp2;
	}

	public String getParamSearchIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp3
		return paramSearchIp3;
	}

	public void setParamSearchIp3(String paramSearchIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp3
		this.paramSearchIp3 = paramSearchIp3;
	}

	public String getParamSearchIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp4
		return paramSearchIp4;
	}

	public void setParamSearchIp4(String paramSearchIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp4
		this.paramSearchIp4 = paramSearchIp4;
	}

	public String getParamSearchIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp5
		return paramSearchIp5;
	}

	public void setParamSearchIp5(String paramSearchIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp5
		this.paramSearchIp5 = paramSearchIp5;
	}

	public String getParamSearchIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp6
		return paramSearchIp6;
	}

	public void setParamSearchIp6(String paramSearchIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp6
		this.paramSearchIp6 = paramSearchIp6;
	}

	public String getParamSearchMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchMask
		return paramSearchMask;
	}

	public void setParamSearchMask(String paramSearchMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchMask
		this.paramSearchMask = paramSearchMask;
	}

	public boolean isSearchFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSearchFlag
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchFlag
		this.searchFlag = searchFlag;
	}

	public boolean isStatusEditAble() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isStatusEditAble
		return statusEditAble;
	}

	public void setStatusEditAble(boolean statusEditAble) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatusEditAble
		this.statusEditAble = statusEditAble;
	}

	public String getNetworkIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkIp
		return networkIp;
	}

	public void setNetworkIp(String networkIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkIp
		this.networkIp = networkIp;
	}

	public String getDnsName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDnsName
		return dnsName;
	}

	public void setDnsName(String dnsName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDnsName
		this.dnsName = dnsName;
	}

	public String getIpSubmask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpSubmask
		return ipSubmask;
	}

	public void setIpSubmask(String ipSubmask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpSubmask
		this.ipSubmask = ipSubmask;
	}

	public String getHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHostName
		return hostName;
	}

	public void setHostName(String hostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHostName
		this.hostName = hostName;
	}

	public String getSystemName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemName
		return systemName;
	}

	public void setSystemName(String systemName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemName
		this.systemName = systemName;
	}

	public String getGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGateway
		return gateway;
	}

	public void setGateway(String gateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGateway
		this.gateway = gateway;
	}

	public String getSystemOwnerName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerName
		return systemOwnerName;
	}

	public void setSystemOwnerName(String systemOwnerName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerName
		this.systemOwnerName = systemOwnerName;
	}

	public boolean isIpStatusUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpStatusUpdate
		return ipStatusUpdate;
	}

	public void setIpStatusUpdate(boolean ipStatusUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusUpdate
		this.ipStatusUpdate = ipStatusUpdate;
	}

	public boolean isCompanyUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCompanyUpdate
		return companyUpdate;
	}

	public void setCompanyUpdate(boolean companyUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyUpdate
		this.companyUpdate = companyUpdate;
	}

	public boolean isDnsNameUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDnsNameUpdate
		return dnsNameUpdate;
	}

	public void setDnsNameUpdate(boolean dnsNameUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDnsNameUpdate
		this.dnsNameUpdate = dnsNameUpdate;
	}

	public boolean isNetworkIpUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isNetworkIpUpdate
		return networkIpUpdate;
	}

	public void setNetworkIpUpdate(boolean networkIpUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkIpUpdate
		this.networkIpUpdate = networkIpUpdate;
	}

	public boolean isIpSubmarkUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpSubmarkUpdate
		return ipSubmarkUpdate;
	}

	public void setIpSubmarkUpdate(boolean ipSubmarkUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpSubmarkUpdate
		this.ipSubmarkUpdate = ipSubmarkUpdate;
	}

	public boolean isSiteLocationUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSiteLocationUpdate
		return siteLocationUpdate;
	}

	public void setSiteLocationUpdate(boolean siteLocationUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSiteLocationUpdate
		this.siteLocationUpdate = siteLocationUpdate;
	}

	public boolean isSystemNameUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSystemNameUpdate
		return systemNameUpdate;
	}

	public void setSystemNameUpdate(boolean systemNameUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemNameUpdate
		this.systemNameUpdate = systemNameUpdate;
	}

	public boolean isSystemOwnerNameUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSystemOwnerNameUpdate
		return systemOwnerNameUpdate;
	}

	public void setSystemOwnerNameUpdate(boolean systemOwnerNameUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerNameUpdate
		this.systemOwnerNameUpdate = systemOwnerNameUpdate;
	}

	public boolean isDystemOwnerTeamUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDystemOwnerTeamUpdate
		return dystemOwnerTeamUpdate;
	}

	public void setDystemOwnerTeamUpdate(boolean dystemOwnerTeamUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDystemOwnerTeamUpdate
		this.dystemOwnerTeamUpdate = dystemOwnerTeamUpdate;
	}

	public boolean isGatewayUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isGatewayUpdate
		return gatewayUpdate;
	}

	public void setGatewayUpdate(boolean gatewayUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGatewayUpdate
		this.gatewayUpdate = gatewayUpdate;
	}

	public boolean isExpireUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isExpireUpdate
		return expireUpdate;
	}

	public void setExpireUpdate(boolean expireUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpireUpdate
		this.expireUpdate = expireUpdate;
	}

	public void setSortSIP003View(SortColumnBean sortSIP003View) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortSIP003View
		this.sortSIP003View = sortSIP003View;
	}

	public SortColumnBean getSortSIP003View() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortSIP003View
		return sortSIP003View;
	}

	public void setFilterSIP003View(FilterBean filterSIP003View) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterSIP003View
		this.filterSIP003View = filterSIP003View;
	}

	public FilterBean getFilterSIP003View() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterSIP003View
		return filterSIP003View;
	}

	public boolean isCheckBoxVlan() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxVlan
		return checkBoxVlan;
	}

	public void setCheckBoxVlan(boolean checkBoxVlan) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxVlan
		this.checkBoxVlan = checkBoxVlan;
	}

	public boolean isShowWarnDup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isShowWarnDup
		return showWarnDup;
	}

	public void setShowWarnDup(boolean showWarnDup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowWarnDup
		this.showWarnDup = showWarnDup;
	}

	public String getMsgWarnDup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMsgWarnDup
		return msgWarnDup;
	}

	public void setMsgWarnDup(String msgWarnDup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMsgWarnDup
		this.msgWarnDup = msgWarnDup;
	}

	public String getTemplateType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateType
		return templateType;
	}

	public void setTemplateType(String templateType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateType
		this.templateType = templateType;
	}

	public boolean isShowSaveBtn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isShowSaveBtn
		return showSaveBtn;
	}

	public void setShowSaveBtn(boolean showSaveBtn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowSaveBtn
		this.showSaveBtn = showSaveBtn;
	}

	public boolean isShowDownloadError() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isShowDownloadError
		return showDownloadError;
	}

	public void setShowDownloadError(boolean showDownloadError) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowDownloadError
		this.showDownloadError = showDownloadError;
	}

	public boolean isShowDownloadWarn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isShowDownloadWarn
		return showDownloadWarn;
	}

	public void setShowDownloadWarn(boolean showDownloadWarn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowDownloadWarn
		this.showDownloadWarn = showDownloadWarn;
	}

	public String getResultImportMsg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResultImportMsg
		return resultImportMsg;
	}

	public void setResultImportMsg(String resultImportMsg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResultImportMsg
		this.resultImportMsg = resultImportMsg;
	}

	public List<ExcelErrorMsg> getErrorMsgList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMsgList
		return errorMsgList;
	}

	public void setErrorMsgList(List<ExcelErrorMsg> errorMsgList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMsgList
		this.errorMsgList = errorMsgList;
	}

	public String getNatIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNatIp
		return natIp;
	}

	public void setNatIp(String natIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNatIp
		this.natIp = natIp;
	}

	public boolean isNatIpPermission() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isNatIpPermission
		return natIpPermission;
	}

	public void setNatIpPermission(boolean natIpPermission) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNatIpPermission
		this.natIpPermission = natIpPermission;
	}

	public boolean isCheckBoxNat() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxNat
		return checkBoxNat;
	}

	public void setCheckBoxNat(boolean checkBoxNat) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxNat
		this.checkBoxNat = checkBoxNat;
	}

	public Map<String, String> getListNatIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListNatIP
		return listNatIP;
	}

	public void setListNatIP(Map<String, String> listNatIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListNatIP
		this.listNatIP = listNatIP;
	}

	public boolean isOpenCheckBoxNatIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isOpenCheckBoxNatIP
		return openCheckBoxNatIP;
	}

	public void setOpenCheckBoxNatIP(boolean openCheckBoxNatIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOpenCheckBoxNatIP
		this.openCheckBoxNatIP = openCheckBoxNatIP;
	}
	
	
	
}
