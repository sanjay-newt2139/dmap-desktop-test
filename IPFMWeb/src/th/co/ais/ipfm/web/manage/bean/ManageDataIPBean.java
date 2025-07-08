package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;



public class ManageDataIPBean extends IPFMBaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3251774689702918816L;
	
	private String rowId;
	private String ipAddress;
	private String ipVersion;
	private String grpId;
	private String rngId;
	private String ipStatusId;
	private String ipStatusName;
	private IPFMRichComboItem ipStatusComboItem;
	private String companyId;
	private String companyName;
	private IPFMRichComboItem companyComboItem;
	private String locationId;
	private String locationName;
	private IPFMRichComboItem locationComboItem;
	private String vip;
	private String piority;  
	private IPFMRichComboItem piorityComboItem;
	private String installId;
	private String installTypeName;
	private IPFMRichComboItem installComboItem;
	private String networkZoneId;
	private String networkZoneName;
	private IPFMRichComboItem networkZoneComboItem;
	private String submask;
	private String network;
	private String gateway;
	private String macAddress;
	private String hostName;
	private String systemName;
	private String networkType;
	private IPFMRichComboItem networkTypeComboItem;
	private String reqestFromTeamId;
	private String requestFromTeamName;
	private IPFMRichComboItem requestFromTeamComboItem;
	private String urRefer;
	private String projectId; 
	private String projectName;
	private IPFMRichComboItem projectIdComboItem;
	private String projectManager;
	private IPFMRichComboItem projectManagerComboItem;
	private String systemOwnerId;
	private String systemOwnerName; 
	private IPFMRichComboItem systemOwnerComboItem;
	private String systemOwnerTeamId;
	private IPFMRichComboItem systemOwnerTeamComboItem;
	private String systemOwnerTeamName;
	private String vlanId; 
	private String dnsName; 
	private String floor;
	private String serviceId;
	private String tier1TeamId; 
	private String tier2TeamId;
	private String tier3TeamId;
	private String tier3Id;
	private String t1Remark; 
	private String t2Remark;
	private String t3Remark;
	private String effDate;
	private String expDate;
	private String ipType;
	private IPFMRichComboItem ipTypeComboItem;
	private IPFMRichComboItem tier2TeamComboItem;
	
	private String effDateFrom;
	private String effDateTo;
	
	private String expDateFrom;
	private String expDateTo;
	
	private String stIp1;
	private String stIp2;
	private String stIp3;
	private String stIp4;
	private String stIp5;
	private String stIp6;
	private String edIp1;
	private String edIp2;
	private String edIp3;
	private String edIp4;
	private String edIp5;
	private String edIp6;
	
	private String userId;
	private String userName;
	private String section;
	private String dept;
	private String email;
	private String position;
	private String mobile;
	private String tel;
	private String groupIdListStr;
	private String managerIdListStr;
	private String roleIdListStr;
	private String userTeamId;
	private Integer version;

	private List<SelectItem> ipStatusList;
	private List<SelectItem> locatList;
	private List<SelectItem> zoneList;
	private List<SelectItem> requestFromTeamList;
	private List<SelectItem> projectIdList;
	private List<SelectItem> projectManagerList;
	private List<SelectItem> SystemOwnerList;
	private List<SelectItem> SystemOwnerTeamList;
	private List<SelectItem> nwTypeList;
	private List<SelectItem> t2TeamList;
	private List<SelectItem> companyList;
	private List<SelectItem> priorityList;
	private List<SelectItem> installTypeList;
	private List<SelectItem> ipTypeList;
	
	private IPDetail  ipDetail;
	private List<IPDetail> ipDetailList;
	
	private IPDetail  popupIPDetail;
	
	private boolean disabledTextIpBox;
	private boolean disabledTextIpSts=true;
	private boolean disabledTextCompany=true;
	private boolean disabledTextLocation=true;
	private boolean disabledTextPriority=true;
	private boolean disabledTextInstallType=true;
	private boolean disabledTextMask=true;
	private boolean disabledTextNetworkZone=true;
	private boolean disabledTextNetwork=true;
	private boolean disabledTextGateway=true;
	private boolean disabledTextMacAdress=true;
	private boolean disabledTextHostName=true;
	private boolean disabledTextSystemName=true;
	private boolean disabledTextNetworkType=true;
	private boolean disabledTextRequestFromTeam=true;
	private boolean disabledTextUrRefer=true;
	private boolean disabledTextVipIp=true;
	private boolean disabledTextVlanId=true;
	private boolean disabledTextDnsName=true;;
	private boolean disabledTextTire1Remark=true;
	private boolean disabledTextTire2Remark=true;
	private boolean disabledTextTire3Remark=true;
	private boolean disabledTextIpType=true;
	private boolean disabledTextFloor=true;
	private boolean disabledTextProjectID=true;
	private boolean disabledTextProjectName=true;
	private boolean disabledTextProjectManager=true;
	private boolean disabledTextEffectiveDate=true;
	private boolean disabledTextExpireDate=true;
	private boolean disabledTextSystemOwnerID=true;
	private boolean disabledTextSystemOwnerName=true;
	private boolean disabledTextSystemOwnerTeam=true;
	private boolean disabledTextServiceDetail=true;
	
	private boolean disPlaySearchResult = false;
	private boolean displayForCreate;
	private boolean displayForEdit;
	private boolean displayForQueryButton;
	
	private SortColumnBean sortIpUrs001 = new SortColumnBean();	
	private FilterBean filterIpUrs001 = new FilterBean();
	
	private SortColumnBean sortIpUrs003 = new SortColumnBean();	
	private FilterBean filterIpUrs003 = new FilterBean();
	
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}

	public String getGrpId() {
		return grpId;
	}

	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	public String getRngId() {
		return rngId;
	}

	public void setRngId(String rngId) {
		this.rngId = rngId;
	}

	public String getIpStatusId() {
		return ipStatusId;
	}

	public void setIpStatusId(String ipStatusId) {
		this.ipStatusId = ipStatusId;
	}

	public String getIpStatusName() {
		return ipStatusName;
	}

	public void setIpStatusName(String ipStatusName) {
		this.ipStatusName = ipStatusName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getPiority() {
		return piority;
	}

	public void setPiority(String piority) {
		this.piority = piority;
	}

	public String getInstallId() {
		return installId;
	}

	public void setInstallId(String installId) {
		this.installId = installId;
	}

	public String getInstallTypeName() {
		return installTypeName;
	}

	public void setInstallTypeName(String installTypeName) {
		this.installTypeName = installTypeName;
	}

	public String getNetworkZoneId() {
		return networkZoneId;
	}

	public void setNetworkZoneId(String networkZoneId) {
		this.networkZoneId = networkZoneId;
	}

	public String getNetworkZoneName() {
		return networkZoneName;
	}

	public void setNetworkZoneName(String networkZoneName) {
		this.networkZoneName = networkZoneName;
	}

	public String getSubmask() {
		return submask;
	}

	public void setSubmask(String submask) {
		this.submask = submask;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
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

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getReqestFromTeamId() {
		return reqestFromTeamId;
	}

	public void setReqestFromTeamId(String reqestFromTeamId) {
		this.reqestFromTeamId = reqestFromTeamId;
	}

	public String getRequestFromTeamName() {
		return requestFromTeamName;
	}

	public void setRequestFromTeamName(String requestFromTeamName) {
		this.requestFromTeamName = requestFromTeamName;
	}

	public String getUrRefer() {
		return urRefer;
	}

	public void setUrRefer(String urRefer) {
		this.urRefer = urRefer;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}


	public String getSystemOwnerId() {
		return systemOwnerId;
	}

	public void setSystemOwnerId(String systemOwnerId) {
		this.systemOwnerId = systemOwnerId;
	}

	public String getSystemOwnerName() {
		return systemOwnerName;
	}

	public void setSystemOwnerName(String systemOwnerName) {
		this.systemOwnerName = systemOwnerName;
	}

	public String getSystemOwnerTeamId() {
		return systemOwnerTeamId;
	}

	public void setSystemOwnerTeamId(String systemOwnerTeamId) {
		this.systemOwnerTeamId = systemOwnerTeamId;
	}

	public String getSystemOwnerTeamName() {
		return systemOwnerTeamName;
	}

	public void setSystemOwnerTeamName(String systemOwnerTeamName) {
		this.systemOwnerTeamName = systemOwnerTeamName;
	}

	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}


	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTier1TeamId() {
		return tier1TeamId;
	}

	public void setTier1TeamId(String tier1TeamId) {
		this.tier1TeamId = tier1TeamId;
	}

	public String getTier2TeamId() {
		return tier2TeamId;
	}

	public void setTier2TeamId(String tier2TeamId) {
		this.tier2TeamId = tier2TeamId;
	}

	public String getTier3TeamId() {
		return tier3TeamId;
	}

	public void setTier3TeamId(String tier3TeamId) {
		this.tier3TeamId = tier3TeamId;
	}

	public String getTier3Id() {
		return tier3Id;
	}

	public void setTier3Id(String tier3Id) {
		this.tier3Id = tier3Id;
	}

	public String getT1Remark() {
		return t1Remark;
	}

	public void setT1Remark(String t1Remark) {
		this.t1Remark = t1Remark;
	}

	public String getT2Remark() {
		return t2Remark;
	}

	public void setT2Remark(String t2Remark) {
		this.t2Remark = t2Remark;
	}

	public String getT3Remark() {
		return t3Remark;
	}

	public void setT3Remark(String t3Remark) {
		this.t3Remark = t3Remark;
	}

	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public String getIpType() {
		return ipType;
	}

	public void setIpType(String ipType) {
		this.ipType = ipType;
	}

	public String getEffDateFrom() {
		return effDateFrom;
	}

	public void setEffDateFrom(String effDateFrom) {
		this.effDateFrom = effDateFrom;
	}

	public String getEffDateTo() {
		return effDateTo;
	}

	public void setEffDateTo(String effDateTo) {
		this.effDateTo = effDateTo;
	}

	public String getExpDateFrom() {
		return expDateFrom;
	}

	public void setExpDateFrom(String expDateFrom) {
		this.expDateFrom = expDateFrom;
	}

	public String getExpDateTo() {
		return expDateTo;
	}

	public void setExpDateTo(String expDateTo) {
		this.expDateTo = expDateTo;
	}

	public List<SelectItem> getIpStatusList() {
		return ipStatusList;
	}

	public void setIpStatusList(List<SelectItem> ipStatusList) {
		this.ipStatusList = ipStatusList;
	}

	public List<SelectItem> getLocatList() {
		return locatList;
	}

	public void setLocatList(List<SelectItem> locatList) {
		this.locatList = locatList;
	}
	
	public List<SelectItem> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}

	public List<SelectItem> getNwTypeList() {
		return nwTypeList;
	}

	public void setNwTypeList(List<SelectItem> nwTypeList) {
		this.nwTypeList = nwTypeList;
	}

	public List<SelectItem> getT2TeamList() {
		return t2TeamList;
	}

	public void setT2TeamList(List<SelectItem> t2TeamList) {
		this.t2TeamList = t2TeamList;
	}

	public IPDetail getIpDetail() {
		return ipDetail;
	}

	public void setIpDetail(IPDetail ipDetail) {
		this.ipDetail = ipDetail;
	}

	public List<IPDetail> getIpDetailList() {
		return ipDetailList;
	}

	public void setIpDetailList(List<IPDetail> ipDetailList) {
		this.ipDetailList = ipDetailList;
	}

	public String getStIp1() {
		return stIp1;
	}

	public void setStIp1(String stIp1) {
		this.stIp1 = stIp1;
	}

	public String getStIp2() {
		return stIp2;
	}

	public void setStIp2(String stIp2) {
		this.stIp2 = stIp2;
	}

	public String getStIp3() {
		return stIp3;
	}

	public void setStIp3(String stIp3) {
		this.stIp3 = stIp3;
	}

	public String getStIp4() {
		return stIp4;
	}

	public void setStIp4(String stIp4) {
		this.stIp4 = stIp4;
	}

	public String getStIp5() {
		return stIp5;
	}

	public void setStIp5(String stIp5) {
		this.stIp5 = stIp5;
	}

	public String getStIp6() {
		return stIp6;
	}

	public void setStIp6(String stIp6) {
		this.stIp6 = stIp6;
	}

	public String getEdIp1() {
		return edIp1;
	}

	public void setEdIp1(String edIp1) {
		this.edIp1 = edIp1;
	}

	public String getEdIp2() {
		return edIp2;
	}

	public void setEdIp2(String edIp2) {
		this.edIp2 = edIp2;
	}

	public String getEdIp3() {
		return edIp3;
	}

	public void setEdIp3(String edIp3) {
		this.edIp3 = edIp3;
	}

	public String getEdIp4() {
		return edIp4;
	}

	public void setEdIp4(String edIp4) {
		this.edIp4 = edIp4;
	}

	public String getEdIp5() {
		return edIp5;
	}

	public void setEdIp5(String edIp5) {
		this.edIp5 = edIp5;
	}

	public String getEdIp6() {
		return edIp6;
	}

	public void setEdIp6(String edIp6) {
		this.edIp6 = edIp6;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGroupIdListStr() {
		return groupIdListStr;
	}

	public void setGroupIdListStr(String groupIdListStr) {
		this.groupIdListStr = groupIdListStr;
	}

	public String getManagerIdListStr() {
		return managerIdListStr;
	}

	public void setManagerIdListStr(String managerIdListStr) {
		this.managerIdListStr = managerIdListStr;
	}

	public String getRoleIdListStr() {
		return roleIdListStr;
	}

	public void setRoleIdListStr(String roleIdListStr) {
		this.roleIdListStr = roleIdListStr;
	}
	
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	
	public List<SelectItem> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(List<SelectItem> priorityList) {
		this.priorityList = priorityList;
	}
	
	public List<SelectItem> getInstallTypeList() {
		return installTypeList;
	}

	public void setInstallTypeList(List<SelectItem> installTypeList) {
		this.installTypeList = installTypeList;
	}

	public List<SelectItem> getIpTypeList() {
		return ipTypeList;
	}

	public void setIpTypeList(List<SelectItem> ipTypeList) {
		this.ipTypeList = ipTypeList;
	}

	public String getUserTeamId() {
		return userTeamId;
	}

	public void setUserTeamId(String userTeamId) {
		this.userTeamId = userTeamId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean isDisabledTextRequestFromTeam() {
		return disabledTextRequestFromTeam;
	}

	public void setDisabledTextRequestFromTeam(boolean disabledTextRequestFromTeam) {
		this.disabledTextRequestFromTeam = disabledTextRequestFromTeam;
	}

	public boolean isDisabledTextUrRefer() {
		return disabledTextUrRefer;
	}

	public void setDisabledTextUrRefer(boolean disabledTextUrRefer) {
		this.disabledTextUrRefer = disabledTextUrRefer;
	}

	public boolean isDisabledTextTire1Remark() {
		return disabledTextTire1Remark;
	}

	public void setDisabledTextTire1Remark(boolean disabledTextTire1Remark) {
		this.disabledTextTire1Remark = disabledTextTire1Remark;
	}

	public boolean isDisabledTextTire2Remark() {
		return disabledTextTire2Remark;
	}

	public void setDisabledTextTire2Remark(boolean disabledTextTire2Remark) {
		this.disabledTextTire2Remark = disabledTextTire2Remark;
	}

	public boolean isDisabledTextTire3Remark() {
		return disabledTextTire3Remark;
	}

	public void setDisabledTextTire3Remark(boolean disabledTextTire3Remark) {
		this.disabledTextTire3Remark = disabledTextTire3Remark;
	}

	public boolean isDisabledTextServiceDetail() {
		return disabledTextServiceDetail;
	}

	public void setDisabledTextServiceDetail(boolean disabledTextServiceDetail) {
		this.disabledTextServiceDetail = disabledTextServiceDetail;
	}

	public boolean isDisabledTextCompany() {
		return disabledTextCompany;
	}

	public void setDisabledTextCompany(boolean disabledTextCompany) {
		this.disabledTextCompany = disabledTextCompany;
	}

	public boolean isDisabledTextLocation() {
		return disabledTextLocation;
	}

	public void setDisabledTextLocation(boolean disabledTextLocation) {
		this.disabledTextLocation = disabledTextLocation;
	}

	public boolean isDisabledTextInstallType() {
		return disabledTextInstallType;
	}

	public void setDisabledTextInstallType(boolean disabledTextInstallType) {
		this.disabledTextInstallType = disabledTextInstallType;
	}

	public boolean isDisabledTextMask() {
		return disabledTextMask;
	}

	public void setDisabledTextMask(boolean disabledTextMask) {
		this.disabledTextMask = disabledTextMask;
	}

	public boolean isDisabledTextEffectiveDate() {
		return disabledTextEffectiveDate;
	}

	public void setDisabledTextEffectiveDate(boolean disabledTextEffectiveDate) {
		this.disabledTextEffectiveDate = disabledTextEffectiveDate;
	}
	
	public boolean isDisabledTextIpBox() {
		return disabledTextIpBox;
	}

	public void setDisabledTextIpBox(boolean disabledTextIpBox) {
		this.disabledTextIpBox = disabledTextIpBox;
	}

	public boolean isDisabledTextNetwork() {
		return disabledTextNetwork;
	}

	public void setDisabledTextNetwork(boolean disabledTextNetwork) {
		this.disabledTextNetwork = disabledTextNetwork;
	}

	public boolean isDisabledTextGateway() {
		return disabledTextGateway;
	}

	public void setDisabledTextGateway(boolean disabledTextGateway) {
		this.disabledTextGateway = disabledTextGateway;
	}

	public boolean isDisabledTextVipIp() {
		return disabledTextVipIp;
	}

	public void setDisabledTextVipIp(boolean disabledTextVipIp) {
		this.disabledTextVipIp = disabledTextVipIp;
	}

	public boolean isDisabledTextVlanId() {
		return disabledTextVlanId;
	}

	public void setDisabledTextVlanId(boolean disabledTextVlanId) {
		this.disabledTextVlanId = disabledTextVlanId;
	}

	public boolean isDisabledTextDnsName() {
		return disabledTextDnsName;
	}

	public void setDisabledTextDnsName(boolean disabledTextDnsName) {
		this.disabledTextDnsName = disabledTextDnsName;
	}

	public boolean isDisPlaySearchResult() {
		return disPlaySearchResult;
	}

	public void setDisPlaySearchResult(boolean disPlaySearchResult) {
		this.disPlaySearchResult = disPlaySearchResult;
	}

	public boolean isDisplayForCreate() {
		return displayForCreate;
	}

	public void setDisplayForCreate(boolean displayForCreate) {
		this.displayForCreate = displayForCreate;
	}

	public boolean isDisplayForEdit() {
		return displayForEdit;
	}

	public void setDisplayForEdit(boolean displayForEdit) {
		this.displayForEdit = displayForEdit;
	}

	public boolean isDisplayForQueryButton() {
		return displayForQueryButton;
	}

	public void setDisplayForQueryButton(boolean displayForQueryButton) {
		this.displayForQueryButton = displayForQueryButton;
	}

	public boolean isDisabledTextIpSts() {
		return disabledTextIpSts;
	}

	public void setDisabledTextIpSts(boolean disabledTextIpSts) {
		this.disabledTextIpSts = disabledTextIpSts;
	}

	public boolean isDisabledTextPriority() {
		return disabledTextPriority;
	}

	public void setDisabledTextPriority(boolean disabledTextPriority) {
		this.disabledTextPriority = disabledTextPriority;
	}

	public boolean isDisabledTextNetworkZone() {
		return disabledTextNetworkZone;
	}

	public void setDisabledTextNetworkZone(boolean disabledTextNetworkZone) {
		this.disabledTextNetworkZone = disabledTextNetworkZone;
	}

	public boolean isDisabledTextMacAdress() {
		return disabledTextMacAdress;
	}

	public void setDisabledTextMacAdress(boolean disabledTextMacAdress) {
		this.disabledTextMacAdress = disabledTextMacAdress;
	}

	public boolean isDisabledTextHostName() {
		return disabledTextHostName;
	}

	public void setDisabledTextHostName(boolean disabledTextHostName) {
		this.disabledTextHostName = disabledTextHostName;
	}

	public boolean isDisabledTextSystemName() {
		return disabledTextSystemName;
	}

	public void setDisabledTextSystemName(boolean disabledTextSystemName) {
		this.disabledTextSystemName = disabledTextSystemName;
	}

	public boolean isDisabledTextNetworkType() {
		return disabledTextNetworkType;
	}

	public void setDisabledTextNetworkType(boolean disabledTextNetworkType) {
		this.disabledTextNetworkType = disabledTextNetworkType;
	}

	public boolean isDisabledTextIpType() {
		return disabledTextIpType;
	}

	public void setDisabledTextIpType(boolean disabledTextIpType) {
		this.disabledTextIpType = disabledTextIpType;
	}

	public boolean isDisabledTextFloor() {
		return disabledTextFloor;
	}

	public void setDisabledTextFloor(boolean disabledTextFloor) {
		this.disabledTextFloor = disabledTextFloor;
	}

	public boolean isDisabledTextProjectID() {
		return disabledTextProjectID;
	}

	public void setDisabledTextProjectID(boolean disabledTextProjectID) {
		this.disabledTextProjectID = disabledTextProjectID;
	}

	public boolean isDisabledTextProjectName() {
		return disabledTextProjectName;
	}

	public void setDisabledTextProjectName(boolean disabledTextProjectName) {
		this.disabledTextProjectName = disabledTextProjectName;
	}

	public boolean isDisabledTextProjectManager() {
		return disabledTextProjectManager;
	}

	public void setDisabledTextProjectManager(boolean disabledTextProjectManager) {
		this.disabledTextProjectManager = disabledTextProjectManager;
	}

	public boolean isDisabledTextExpireDate() {
		return disabledTextExpireDate;
	}

	public void setDisabledTextExpireDate(boolean disabledTextExpireDate) {
		this.disabledTextExpireDate = disabledTextExpireDate;
	}

	public boolean isDisabledTextSystemOwnerID() {
		return disabledTextSystemOwnerID;
	}

	public void setDisabledTextSystemOwnerID(boolean disabledTextSystemOwnerID) {
		this.disabledTextSystemOwnerID = disabledTextSystemOwnerID;
	}

	public boolean isDisabledTextSystemOwnerName() {
		return disabledTextSystemOwnerName;
	}

	public void setDisabledTextSystemOwnerName(boolean disabledTextSystemOwnerName) {
		this.disabledTextSystemOwnerName = disabledTextSystemOwnerName;
	}

	public boolean isDisabledTextSystemOwnerTeam() {
		return disabledTextSystemOwnerTeam;
	}

	public void setDisabledTextSystemOwnerTeam(boolean disabledTextSystemOwnerTeam) {
		this.disabledTextSystemOwnerTeam = disabledTextSystemOwnerTeam;
	}

	public IPFMRichComboItem getIpStatusComboItem() {
		return ipStatusComboItem;
	}

	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) {
		this.ipStatusComboItem = ipStatusComboItem;
	}

	public IPFMRichComboItem getCompanyComboItem() {
		return companyComboItem;
	}

	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) {
		this.companyComboItem = companyComboItem;
	}

	public IPFMRichComboItem getLocationComboItem() {
		return locationComboItem;
	}

	public void setLocationComboItem(IPFMRichComboItem locationComboItem) {
		this.locationComboItem = locationComboItem;
	}

	public IPFMRichComboItem getPiorityComboItem() {
		return piorityComboItem;
	}

	public void setPiorityComboItem(IPFMRichComboItem piorityComboItem) {
		this.piorityComboItem = piorityComboItem;
	}

	public IPFMRichComboItem getInstallComboItem() {
		return installComboItem;
	}

	public void setInstallComboItem(IPFMRichComboItem installComboItem) {
		this.installComboItem = installComboItem;
	}

	public IPFMRichComboItem getNetworkZoneComboItem() {
		return networkZoneComboItem;
	}

	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) {
		this.networkZoneComboItem = networkZoneComboItem;
	}

	public IPFMRichComboItem getNetworkTypeComboItem() {
		return networkTypeComboItem;
	}

	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) {
		this.networkTypeComboItem = networkTypeComboItem;
	}

	public IPFMRichComboItem getRequestFromTeamComboItem() {
		return requestFromTeamComboItem;
	}

	public void setRequestFromTeamComboItem(IPFMRichComboItem requestFromTeamComboItem) {
		this.requestFromTeamComboItem = requestFromTeamComboItem;
	}

	public IPFMRichComboItem getIpTypeComboItem() {
		return ipTypeComboItem;
	}

	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) {
		this.ipTypeComboItem = ipTypeComboItem;
	}

	public IPFMRichComboItem getTier2TeamComboItem() {
		return tier2TeamComboItem;
	}

	public void setTier2TeamComboItem(IPFMRichComboItem tier2TeamComboItem) {
		this.tier2TeamComboItem = tier2TeamComboItem;
	}

	public IPFMRichComboItem getProjectIdComboItem() {
		return projectIdComboItem;
	}

	public void setProjectIdComboItem(IPFMRichComboItem projectIdComboItem) {
		this.projectIdComboItem = projectIdComboItem;
	}

	public List<SelectItem> getRequestFromTeamList() {
		return requestFromTeamList;
	}

	public void setRequestFromTeamList(List<SelectItem> requestFromTeamList) {
		this.requestFromTeamList = requestFromTeamList;
	}

	public List<SelectItem> getProjectIdList() {
		return projectIdList;
	}

	public void setProjectIdList(List<SelectItem> projectIdList) {
		this.projectIdList = projectIdList;
	}

	public IPFMRichComboItem getProjectManagerComboItem() {
		return projectManagerComboItem;
	}

	public void setProjectManagerComboItem(IPFMRichComboItem projectManagerComboItem) {
		this.projectManagerComboItem = projectManagerComboItem;
	}

	public List<SelectItem> getProjectManagerList() {
		return projectManagerList;
	}

	public void setProjectManagerList(List<SelectItem> projectManagerList) {
		this.projectManagerList = projectManagerList;
	}

	public IPFMRichComboItem getSystemOwnerComboItem() {
		return systemOwnerComboItem;
	}

	public void setSystemOwnerComboItem(IPFMRichComboItem systemOwnerComboItem) {
		this.systemOwnerComboItem = systemOwnerComboItem;
	}

	public List<SelectItem> getSystemOwnerList() {
		return SystemOwnerList;
	}

	public void setSystemOwnerList(List<SelectItem> systemOwnerList) {
		SystemOwnerList = systemOwnerList;
	}

	public IPFMRichComboItem getSystemOwnerTeamComboItem() {
		return systemOwnerTeamComboItem;
	}

	public void setSystemOwnerTeamComboItem(
			IPFMRichComboItem systemOwnerTeamComboItem) {
		this.systemOwnerTeamComboItem = systemOwnerTeamComboItem;
	}

	public List<SelectItem> getSystemOwnerTeamList() {
		return SystemOwnerTeamList;
	}

	public void setSystemOwnerTeamList(List<SelectItem> systemOwnerTeamList) {
		SystemOwnerTeamList = systemOwnerTeamList;
	}

	public IPDetail getPopupIPDetail() {
		return popupIPDetail;
	}

	public void setPopupIPDetail(IPDetail popupIPDetail) {
		this.popupIPDetail = popupIPDetail;
	}

	public void setSortIpUrs001(SortColumnBean sortIpUrs001) {
		this.sortIpUrs001 = sortIpUrs001;
	}

	public SortColumnBean getSortIpUrs001() {
		return sortIpUrs001;
	}

	public void setFilterIpUrs001(FilterBean filterIpUrs001) {
		this.filterIpUrs001 = filterIpUrs001;
	}

	public FilterBean getFilterIpUrs001() {
		return filterIpUrs001;
	}

	public void setSortIpUrs003(SortColumnBean sortIpUrs003) {
		this.sortIpUrs003 = sortIpUrs003;
	}

	public SortColumnBean getSortIpUrs003() {
		return sortIpUrs003;
	}

	public void setFilterIpUrs003(FilterBean filterIpUrs003) {
		this.filterIpUrs003 = filterIpUrs003;
	}

	public FilterBean getFilterIpUrs003() {
		return filterIpUrs003;
	}

	
}
