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
	private static final long serialVersionUID = 3251774689702918816L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
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
	
	
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpAddress
		this.ipAddress = ipAddress;
	}

	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}

	public String getGrpId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpId
		return grpId;
	}

	public void setGrpId(String grpId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpId
		this.grpId = grpId;
	}

	public String getRngId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRngId
		return rngId;
	}

	public void setRngId(String rngId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRngId
		this.rngId = rngId;
	}

	public String getIpStatusId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusId
		return ipStatusId;
	}

	public void setIpStatusId(String ipStatusId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusId
		this.ipStatusId = ipStatusId;
	}

	public String getIpStatusName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusName
		return ipStatusName;
	}

	public void setIpStatusName(String ipStatusName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusName
		this.ipStatusName = ipStatusName;
	}

	public String getCompanyId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyId
		return companyId;
	}

	public void setCompanyId(String companyId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyId
		this.companyId = companyId;
	}

	public String getCompanyName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyName
		return companyName;
	}

	public void setCompanyName(String companyName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyName
		this.companyName = companyName;
	}

	public String getLocationId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationId
		return locationId;
	}

	public void setLocationId(String locationId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationId
		this.locationId = locationId;
	}

	public String getLocationName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationName
		return locationName;
	}

	public void setLocationName(String locationName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationName
		this.locationName = locationName;
	}

	public String getVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVip
		return vip;
	}

	public void setVip(String vip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVip
		this.vip = vip;
	}

	public String getPiority() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPiority
		return piority;
	}

	public void setPiority(String piority) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPiority
		this.piority = piority;
	}

	public String getInstallId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallId
		return installId;
	}

	public void setInstallId(String installId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallId
		this.installId = installId;
	}

	public String getInstallTypeName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallTypeName
		return installTypeName;
	}

	public void setInstallTypeName(String installTypeName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallTypeName
		this.installTypeName = installTypeName;
	}

	public String getNetworkZoneId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneId
		return networkZoneId;
	}

	public void setNetworkZoneId(String networkZoneId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneId
		this.networkZoneId = networkZoneId;
	}

	public String getNetworkZoneName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneName
		return networkZoneName;
	}

	public void setNetworkZoneName(String networkZoneName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneName
		this.networkZoneName = networkZoneName;
	}

	public String getSubmask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubmask
		return submask;
	}

	public void setSubmask(String submask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubmask
		this.submask = submask;
	}

	public String getNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetwork
		return network;
	}

	public void setNetwork(String network) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetwork
		this.network = network;
	}

	public String getGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGateway
		return gateway;
	}

	public void setGateway(String gateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGateway
		this.gateway = gateway;
	}

	public String getMacAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMacAddress
		return macAddress;
	}

	public void setMacAddress(String macAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMacAddress
		this.macAddress = macAddress;
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

	public String getNetworkType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkType
		return networkType;
	}

	public void setNetworkType(String networkType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkType
		this.networkType = networkType;
	}

	public String getReqestFromTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqestFromTeamId
		return reqestFromTeamId;
	}

	public void setReqestFromTeamId(String reqestFromTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqestFromTeamId
		this.reqestFromTeamId = reqestFromTeamId;
	}

	public String getRequestFromTeamName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestFromTeamName
		return requestFromTeamName;
	}

	public void setRequestFromTeamName(String requestFromTeamName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestFromTeamName
		this.requestFromTeamName = requestFromTeamName;
	}

	public String getUrRefer() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrRefer
		return urRefer;
	}

	public void setUrRefer(String urRefer) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrRefer
		this.urRefer = urRefer;
	}

	public String getProjectId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectId
		return projectId;
	}

	public void setProjectId(String projectId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectId
		this.projectId = projectId;
	}

	public String getProjectName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectName
		return projectName;
	}

	public void setProjectName(String projectName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectName
		this.projectName = projectName;
	}

	public String getProjectManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectManager
		return projectManager;
	}

	public void setProjectManager(String projectManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectManager
		this.projectManager = projectManager;
	}


	public String getSystemOwnerId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerId
		return systemOwnerId;
	}

	public void setSystemOwnerId(String systemOwnerId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerId
		this.systemOwnerId = systemOwnerId;
	}

	public String getSystemOwnerName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerName
		return systemOwnerName;
	}

	public void setSystemOwnerName(String systemOwnerName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerName
		this.systemOwnerName = systemOwnerName;
	}

	public String getSystemOwnerTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamId
		return systemOwnerTeamId;
	}

	public void setSystemOwnerTeamId(String systemOwnerTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamId
		this.systemOwnerTeamId = systemOwnerTeamId;
	}

	public String getSystemOwnerTeamName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamName
		return systemOwnerTeamName;
	}

	public void setSystemOwnerTeamName(String systemOwnerTeamName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamName
		this.systemOwnerTeamName = systemOwnerTeamName;
	}

	public String getVlanId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVlanId
		return vlanId;
	}

	public void setVlanId(String vlanId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVlanId
		this.vlanId = vlanId;
	}

	public String getDnsName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDnsName
		return dnsName;
	}

	public void setDnsName(String dnsName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDnsName
		this.dnsName = dnsName;
	}


	public String getFloor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFloor
		return floor;
	}

	public void setFloor(String floor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFloor
		this.floor = floor;
	}

	public String getServiceId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceId
		return serviceId;
	}

	public void setServiceId(String serviceId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServiceId
		this.serviceId = serviceId;
	}

	public String getTier1TeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier1TeamId
		return tier1TeamId;
	}

	public void setTier1TeamId(String tier1TeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier1TeamId
		this.tier1TeamId = tier1TeamId;
	}

	public String getTier2TeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier2TeamId
		return tier2TeamId;
	}

	public void setTier2TeamId(String tier2TeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier2TeamId
		this.tier2TeamId = tier2TeamId;
	}

	public String getTier3TeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier3TeamId
		return tier3TeamId;
	}

	public void setTier3TeamId(String tier3TeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier3TeamId
		this.tier3TeamId = tier3TeamId;
	}

	public String getTier3Id() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier3Id
		return tier3Id;
	}

	public void setTier3Id(String tier3Id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier3Id
		this.tier3Id = tier3Id;
	}

	public String getT1Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT1Remark
		return t1Remark;
	}

	public void setT1Remark(String t1Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT1Remark
		this.t1Remark = t1Remark;
	}

	public String getT2Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT2Remark
		return t2Remark;
	}

	public void setT2Remark(String t2Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT2Remark
		this.t2Remark = t2Remark;
	}

	public String getT3Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT3Remark
		return t3Remark;
	}

	public void setT3Remark(String t3Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT3Remark
		this.t3Remark = t3Remark;
	}

	public String getEffDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffDate
		return effDate;
	}

	public void setEffDate(String effDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffDate
		this.effDate = effDate;
	}

	public String getExpDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpDate
		return expDate;
	}

	public void setExpDate(String expDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpDate
		this.expDate = expDate;
	}
	
	public String getIpType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpType
		return ipType;
	}

	public void setIpType(String ipType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpType
		this.ipType = ipType;
	}

	public String getEffDateFrom() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffDateFrom
		return effDateFrom;
	}

	public void setEffDateFrom(String effDateFrom) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffDateFrom
		this.effDateFrom = effDateFrom;
	}

	public String getEffDateTo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffDateTo
		return effDateTo;
	}

	public void setEffDateTo(String effDateTo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffDateTo
		this.effDateTo = effDateTo;
	}

	public String getExpDateFrom() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpDateFrom
		return expDateFrom;
	}

	public void setExpDateFrom(String expDateFrom) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpDateFrom
		this.expDateFrom = expDateFrom;
	}

	public String getExpDateTo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpDateTo
		return expDateTo;
	}

	public void setExpDateTo(String expDateTo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpDateTo
		this.expDateTo = expDateTo;
	}

	public List<SelectItem> getIpStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusList
		return ipStatusList;
	}

	public void setIpStatusList(List<SelectItem> ipStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusList
		this.ipStatusList = ipStatusList;
	}

	public List<SelectItem> getLocatList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocatList
		return locatList;
	}

	public void setLocatList(List<SelectItem> locatList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocatList
		this.locatList = locatList;
	}
	
	public List<SelectItem> getZoneList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getZoneList
		return zoneList;
	}

	public void setZoneList(List<SelectItem> zoneList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setZoneList
		this.zoneList = zoneList;
	}

	public List<SelectItem> getNwTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwTypeList
		return nwTypeList;
	}

	public void setNwTypeList(List<SelectItem> nwTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwTypeList
		this.nwTypeList = nwTypeList;
	}

	public List<SelectItem> getT2TeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT2TeamList
		return t2TeamList;
	}

	public void setT2TeamList(List<SelectItem> t2TeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT2TeamList
		this.t2TeamList = t2TeamList;
	}

	public IPDetail getIpDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpDetail
		return ipDetail;
	}

	public void setIpDetail(IPDetail ipDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpDetail
		this.ipDetail = ipDetail;
	}

	public List<IPDetail> getIpDetailList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpDetailList
		return ipDetailList;
	}

	public void setIpDetailList(List<IPDetail> ipDetailList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpDetailList
		this.ipDetailList = ipDetailList;
	}

	public String getStIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp1
		return stIp1;
	}

	public void setStIp1(String stIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp1
		this.stIp1 = stIp1;
	}

	public String getStIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp2
		return stIp2;
	}

	public void setStIp2(String stIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp2
		this.stIp2 = stIp2;
	}

	public String getStIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp3
		return stIp3;
	}

	public void setStIp3(String stIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp3
		this.stIp3 = stIp3;
	}

	public String getStIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp4
		return stIp4;
	}

	public void setStIp4(String stIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp4
		this.stIp4 = stIp4;
	}

	public String getStIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp5
		return stIp5;
	}

	public void setStIp5(String stIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp5
		this.stIp5 = stIp5;
	}

	public String getStIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp6
		return stIp6;
	}

	public void setStIp6(String stIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp6
		this.stIp6 = stIp6;
	}

	public String getEdIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp1
		return edIp1;
	}

	public void setEdIp1(String edIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp1
		this.edIp1 = edIp1;
	}

	public String getEdIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp2
		return edIp2;
	}

	public void setEdIp2(String edIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp2
		this.edIp2 = edIp2;
	}

	public String getEdIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp3
		return edIp3;
	}

	public void setEdIp3(String edIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp3
		this.edIp3 = edIp3;
	}

	public String getEdIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp4
		return edIp4;
	}

	public void setEdIp4(String edIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp4
		this.edIp4 = edIp4;
	}

	public String getEdIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp5
		return edIp5;
	}

	public void setEdIp5(String edIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp5
		this.edIp5 = edIp5;
	}

	public String getEdIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp6
		return edIp6;
	}

	public void setEdIp6(String edIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp6
		this.edIp6 = edIp6;
	}

	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}

	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}

	public String getUserName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserName
		return userName;
	}

	public void setUserName(String userName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserName
		this.userName = userName;
	}

	public String getSection() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSection
		return section;
	}

	public void setSection(String section) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSection
		this.section = section;
	}

	public String getDept() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDept
		return dept;
	}

	public void setDept(String dept) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDept
		this.dept = dept;
	}

	public String getEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEmail
		return email;
	}

	public void setEmail(String email) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEmail
		this.email = email;
	}

	public String getPosition() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPosition
		return position;
	}

	public void setPosition(String position) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPosition
		this.position = position;
	}

	public String getMobile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMobile
		return mobile;
	}

	public void setMobile(String mobile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMobile
		this.mobile = mobile;
	}

	public String getTel() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTel
		return tel;
	}

	public void setTel(String tel) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTel
		this.tel = tel;
	}

	public String getGroupIdListStr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupIdListStr
		return groupIdListStr;
	}

	public void setGroupIdListStr(String groupIdListStr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupIdListStr
		this.groupIdListStr = groupIdListStr;
	}

	public String getManagerIdListStr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerIdListStr
		return managerIdListStr;
	}

	public void setManagerIdListStr(String managerIdListStr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setManagerIdListStr
		this.managerIdListStr = managerIdListStr;
	}

	public String getRoleIdListStr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleIdListStr
		return roleIdListStr;
	}

	public void setRoleIdListStr(String roleIdListStr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleIdListStr
		this.roleIdListStr = roleIdListStr;
	}
	
	
	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}
	
	public List<SelectItem> getPriorityList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPriorityList
		return priorityList;
	}

	public void setPriorityList(List<SelectItem> priorityList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPriorityList
		this.priorityList = priorityList;
	}
	
	public List<SelectItem> getInstallTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallTypeList
		return installTypeList;
	}

	public void setInstallTypeList(List<SelectItem> installTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallTypeList
		this.installTypeList = installTypeList;
	}

	public List<SelectItem> getIpTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeList
		return ipTypeList;
	}

	public void setIpTypeList(List<SelectItem> ipTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeList
		this.ipTypeList = ipTypeList;
	}

	public String getUserTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserTeamId
		return userTeamId;
	}

	public void setUserTeamId(String userTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserTeamId
		this.userTeamId = userTeamId;
	}

	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}

	public boolean isDisabledTextRequestFromTeam() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextRequestFromTeam
		return disabledTextRequestFromTeam;
	}

	public void setDisabledTextRequestFromTeam(boolean disabledTextRequestFromTeam) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextRequestFromTeam
		this.disabledTextRequestFromTeam = disabledTextRequestFromTeam;
	}

	public boolean isDisabledTextUrRefer() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextUrRefer
		return disabledTextUrRefer;
	}

	public void setDisabledTextUrRefer(boolean disabledTextUrRefer) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextUrRefer
		this.disabledTextUrRefer = disabledTextUrRefer;
	}

	public boolean isDisabledTextTire1Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextTire1Remark
		return disabledTextTire1Remark;
	}

	public void setDisabledTextTire1Remark(boolean disabledTextTire1Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextTire1Remark
		this.disabledTextTire1Remark = disabledTextTire1Remark;
	}

	public boolean isDisabledTextTire2Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextTire2Remark
		return disabledTextTire2Remark;
	}

	public void setDisabledTextTire2Remark(boolean disabledTextTire2Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextTire2Remark
		this.disabledTextTire2Remark = disabledTextTire2Remark;
	}

	public boolean isDisabledTextTire3Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextTire3Remark
		return disabledTextTire3Remark;
	}

	public void setDisabledTextTire3Remark(boolean disabledTextTire3Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextTire3Remark
		this.disabledTextTire3Remark = disabledTextTire3Remark;
	}

	public boolean isDisabledTextServiceDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextServiceDetail
		return disabledTextServiceDetail;
	}

	public void setDisabledTextServiceDetail(boolean disabledTextServiceDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextServiceDetail
		this.disabledTextServiceDetail = disabledTextServiceDetail;
	}

	public boolean isDisabledTextCompany() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextCompany
		return disabledTextCompany;
	}

	public void setDisabledTextCompany(boolean disabledTextCompany) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextCompany
		this.disabledTextCompany = disabledTextCompany;
	}

	public boolean isDisabledTextLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextLocation
		return disabledTextLocation;
	}

	public void setDisabledTextLocation(boolean disabledTextLocation) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextLocation
		this.disabledTextLocation = disabledTextLocation;
	}

	public boolean isDisabledTextInstallType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextInstallType
		return disabledTextInstallType;
	}

	public void setDisabledTextInstallType(boolean disabledTextInstallType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextInstallType
		this.disabledTextInstallType = disabledTextInstallType;
	}

	public boolean isDisabledTextMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextMask
		return disabledTextMask;
	}

	public void setDisabledTextMask(boolean disabledTextMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextMask
		this.disabledTextMask = disabledTextMask;
	}

	public boolean isDisabledTextEffectiveDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextEffectiveDate
		return disabledTextEffectiveDate;
	}

	public void setDisabledTextEffectiveDate(boolean disabledTextEffectiveDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextEffectiveDate
		this.disabledTextEffectiveDate = disabledTextEffectiveDate;
	}
	
	public boolean isDisabledTextIpBox() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextIpBox
		return disabledTextIpBox;
	}

	public void setDisabledTextIpBox(boolean disabledTextIpBox) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextIpBox
		this.disabledTextIpBox = disabledTextIpBox;
	}

	public boolean isDisabledTextNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextNetwork
		return disabledTextNetwork;
	}

	public void setDisabledTextNetwork(boolean disabledTextNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextNetwork
		this.disabledTextNetwork = disabledTextNetwork;
	}

	public boolean isDisabledTextGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextGateway
		return disabledTextGateway;
	}

	public void setDisabledTextGateway(boolean disabledTextGateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextGateway
		this.disabledTextGateway = disabledTextGateway;
	}

	public boolean isDisabledTextVipIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextVipIp
		return disabledTextVipIp;
	}

	public void setDisabledTextVipIp(boolean disabledTextVipIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextVipIp
		this.disabledTextVipIp = disabledTextVipIp;
	}

	public boolean isDisabledTextVlanId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextVlanId
		return disabledTextVlanId;
	}

	public void setDisabledTextVlanId(boolean disabledTextVlanId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextVlanId
		this.disabledTextVlanId = disabledTextVlanId;
	}

	public boolean isDisabledTextDnsName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextDnsName
		return disabledTextDnsName;
	}

	public void setDisabledTextDnsName(boolean disabledTextDnsName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextDnsName
		this.disabledTextDnsName = disabledTextDnsName;
	}

	public boolean isDisPlaySearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisPlaySearchResult
		return disPlaySearchResult;
	}

	public void setDisPlaySearchResult(boolean disPlaySearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisPlaySearchResult
		this.disPlaySearchResult = disPlaySearchResult;
	}

	public boolean isDisplayForCreate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForCreate
		return displayForCreate;
	}

	public void setDisplayForCreate(boolean displayForCreate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForCreate
		this.displayForCreate = displayForCreate;
	}

	public boolean isDisplayForEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForEdit
		return displayForEdit;
	}

	public void setDisplayForEdit(boolean displayForEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForEdit
		this.displayForEdit = displayForEdit;
	}

	public boolean isDisplayForQueryButton() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForQueryButton
		return displayForQueryButton;
	}

	public void setDisplayForQueryButton(boolean displayForQueryButton) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForQueryButton
		this.displayForQueryButton = displayForQueryButton;
	}

	public boolean isDisabledTextIpSts() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextIpSts
		return disabledTextIpSts;
	}

	public void setDisabledTextIpSts(boolean disabledTextIpSts) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextIpSts
		this.disabledTextIpSts = disabledTextIpSts;
	}

	public boolean isDisabledTextPriority() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextPriority
		return disabledTextPriority;
	}

	public void setDisabledTextPriority(boolean disabledTextPriority) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextPriority
		this.disabledTextPriority = disabledTextPriority;
	}

	public boolean isDisabledTextNetworkZone() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextNetworkZone
		return disabledTextNetworkZone;
	}

	public void setDisabledTextNetworkZone(boolean disabledTextNetworkZone) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextNetworkZone
		this.disabledTextNetworkZone = disabledTextNetworkZone;
	}

	public boolean isDisabledTextMacAdress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextMacAdress
		return disabledTextMacAdress;
	}

	public void setDisabledTextMacAdress(boolean disabledTextMacAdress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextMacAdress
		this.disabledTextMacAdress = disabledTextMacAdress;
	}

	public boolean isDisabledTextHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextHostName
		return disabledTextHostName;
	}

	public void setDisabledTextHostName(boolean disabledTextHostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextHostName
		this.disabledTextHostName = disabledTextHostName;
	}

	public boolean isDisabledTextSystemName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextSystemName
		return disabledTextSystemName;
	}

	public void setDisabledTextSystemName(boolean disabledTextSystemName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextSystemName
		this.disabledTextSystemName = disabledTextSystemName;
	}

	public boolean isDisabledTextNetworkType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextNetworkType
		return disabledTextNetworkType;
	}

	public void setDisabledTextNetworkType(boolean disabledTextNetworkType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextNetworkType
		this.disabledTextNetworkType = disabledTextNetworkType;
	}

	public boolean isDisabledTextIpType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextIpType
		return disabledTextIpType;
	}

	public void setDisabledTextIpType(boolean disabledTextIpType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextIpType
		this.disabledTextIpType = disabledTextIpType;
	}

	public boolean isDisabledTextFloor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextFloor
		return disabledTextFloor;
	}

	public void setDisabledTextFloor(boolean disabledTextFloor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextFloor
		this.disabledTextFloor = disabledTextFloor;
	}

	public boolean isDisabledTextProjectID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextProjectID
		return disabledTextProjectID;
	}

	public void setDisabledTextProjectID(boolean disabledTextProjectID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextProjectID
		this.disabledTextProjectID = disabledTextProjectID;
	}

	public boolean isDisabledTextProjectName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextProjectName
		return disabledTextProjectName;
	}

	public void setDisabledTextProjectName(boolean disabledTextProjectName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextProjectName
		this.disabledTextProjectName = disabledTextProjectName;
	}

	public boolean isDisabledTextProjectManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextProjectManager
		return disabledTextProjectManager;
	}

	public void setDisabledTextProjectManager(boolean disabledTextProjectManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextProjectManager
		this.disabledTextProjectManager = disabledTextProjectManager;
	}

	public boolean isDisabledTextExpireDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextExpireDate
		return disabledTextExpireDate;
	}

	public void setDisabledTextExpireDate(boolean disabledTextExpireDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextExpireDate
		this.disabledTextExpireDate = disabledTextExpireDate;
	}

	public boolean isDisabledTextSystemOwnerID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextSystemOwnerID
		return disabledTextSystemOwnerID;
	}

	public void setDisabledTextSystemOwnerID(boolean disabledTextSystemOwnerID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextSystemOwnerID
		this.disabledTextSystemOwnerID = disabledTextSystemOwnerID;
	}

	public boolean isDisabledTextSystemOwnerName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextSystemOwnerName
		return disabledTextSystemOwnerName;
	}

	public void setDisabledTextSystemOwnerName(boolean disabledTextSystemOwnerName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextSystemOwnerName
		this.disabledTextSystemOwnerName = disabledTextSystemOwnerName;
	}

	public boolean isDisabledTextSystemOwnerTeam() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledTextSystemOwnerTeam
		return disabledTextSystemOwnerTeam;
	}

	public void setDisabledTextSystemOwnerTeam(boolean disabledTextSystemOwnerTeam) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledTextSystemOwnerTeam
		this.disabledTextSystemOwnerTeam = disabledTextSystemOwnerTeam;
	}

	public IPFMRichComboItem getIpStatusComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusComboItem
		return ipStatusComboItem;
	}

	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusComboItem
		this.ipStatusComboItem = ipStatusComboItem;
	}

	public IPFMRichComboItem getCompanyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyComboItem
		return companyComboItem;
	}

	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyComboItem
		this.companyComboItem = companyComboItem;
	}

	public IPFMRichComboItem getLocationComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationComboItem
		return locationComboItem;
	}

	public void setLocationComboItem(IPFMRichComboItem locationComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationComboItem
		this.locationComboItem = locationComboItem;
	}

	public IPFMRichComboItem getPiorityComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPiorityComboItem
		return piorityComboItem;
	}

	public void setPiorityComboItem(IPFMRichComboItem piorityComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPiorityComboItem
		this.piorityComboItem = piorityComboItem;
	}

	public IPFMRichComboItem getInstallComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallComboItem
		return installComboItem;
	}

	public void setInstallComboItem(IPFMRichComboItem installComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallComboItem
		this.installComboItem = installComboItem;
	}

	public IPFMRichComboItem getNetworkZoneComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneComboItem
		return networkZoneComboItem;
	}

	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneComboItem
		this.networkZoneComboItem = networkZoneComboItem;
	}

	public IPFMRichComboItem getNetworkTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkTypeComboItem
		return networkTypeComboItem;
	}

	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeComboItem
		this.networkTypeComboItem = networkTypeComboItem;
	}

	public IPFMRichComboItem getRequestFromTeamComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestFromTeamComboItem
		return requestFromTeamComboItem;
	}

	public void setRequestFromTeamComboItem(IPFMRichComboItem requestFromTeamComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestFromTeamComboItem
		this.requestFromTeamComboItem = requestFromTeamComboItem;
	}

	public IPFMRichComboItem getIpTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeComboItem
		return ipTypeComboItem;
	}

	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeComboItem
		this.ipTypeComboItem = ipTypeComboItem;
	}

	public IPFMRichComboItem getTier2TeamComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier2TeamComboItem
		return tier2TeamComboItem;
	}

	public void setTier2TeamComboItem(IPFMRichComboItem tier2TeamComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier2TeamComboItem
		this.tier2TeamComboItem = tier2TeamComboItem;
	}

	public IPFMRichComboItem getProjectIdComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectIdComboItem
		return projectIdComboItem;
	}

	public void setProjectIdComboItem(IPFMRichComboItem projectIdComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectIdComboItem
		this.projectIdComboItem = projectIdComboItem;
	}

	public List<SelectItem> getRequestFromTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestFromTeamList
		return requestFromTeamList;
	}

	public void setRequestFromTeamList(List<SelectItem> requestFromTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestFromTeamList
		this.requestFromTeamList = requestFromTeamList;
	}

	public List<SelectItem> getProjectIdList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectIdList
		return projectIdList;
	}

	public void setProjectIdList(List<SelectItem> projectIdList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectIdList
		this.projectIdList = projectIdList;
	}

	public IPFMRichComboItem getProjectManagerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectManagerComboItem
		return projectManagerComboItem;
	}

	public void setProjectManagerComboItem(IPFMRichComboItem projectManagerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectManagerComboItem
		this.projectManagerComboItem = projectManagerComboItem;
	}

	public List<SelectItem> getProjectManagerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectManagerList
		return projectManagerList;
	}

	public void setProjectManagerList(List<SelectItem> projectManagerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectManagerList
		this.projectManagerList = projectManagerList;
	}

	public IPFMRichComboItem getSystemOwnerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerComboItem
		return systemOwnerComboItem;
	}

	public void setSystemOwnerComboItem(IPFMRichComboItem systemOwnerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerComboItem
		this.systemOwnerComboItem = systemOwnerComboItem;
	}

	public List<SelectItem> getSystemOwnerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerList
		return SystemOwnerList;
	}

	public void setSystemOwnerList(List<SelectItem> systemOwnerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerList
		SystemOwnerList = systemOwnerList;
	}

	public IPFMRichComboItem getSystemOwnerTeamComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamComboItem
		return systemOwnerTeamComboItem;
	}

	public void setSystemOwnerTeamComboItem( // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamComboItem
			IPFMRichComboItem systemOwnerTeamComboItem) {
		this.systemOwnerTeamComboItem = systemOwnerTeamComboItem;
	}

	public List<SelectItem> getSystemOwnerTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamList
		return SystemOwnerTeamList;
	}

	public void setSystemOwnerTeamList(List<SelectItem> systemOwnerTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamList
		SystemOwnerTeamList = systemOwnerTeamList;
	}

	public IPDetail getPopupIPDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupIPDetail
		return popupIPDetail;
	}

	public void setPopupIPDetail(IPDetail popupIPDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupIPDetail
		this.popupIPDetail = popupIPDetail;
	}

	public void setSortIpUrs001(SortColumnBean sortIpUrs001) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpUrs001
		this.sortIpUrs001 = sortIpUrs001;
	}

	public SortColumnBean getSortIpUrs001() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpUrs001
		return sortIpUrs001;
	}

	public void setFilterIpUrs001(FilterBean filterIpUrs001) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs001
		this.filterIpUrs001 = filterIpUrs001;
	}

	public FilterBean getFilterIpUrs001() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs001
		return filterIpUrs001;
	}

	public void setSortIpUrs003(SortColumnBean sortIpUrs003) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpUrs003
		this.sortIpUrs003 = sortIpUrs003;
	}

	public SortColumnBean getSortIpUrs003() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpUrs003
		return sortIpUrs003;
	}

	public void setFilterIpUrs003(FilterBean filterIpUrs003) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs003
		this.filterIpUrs003 = filterIpUrs003;
	}

	public FilterBean getFilterIpUrs003() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs003
		return filterIpUrs003;
	}

	
}
