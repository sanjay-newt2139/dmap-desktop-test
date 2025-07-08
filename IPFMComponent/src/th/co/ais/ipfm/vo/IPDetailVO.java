package th.co.ais.ipfm.vo;

import java.io.Serializable;
import java.util.List;

import th.co.ais.ipfm.domain.IPDetail;

public class IPDetailVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
	private String rowId;
	private String ipAddress;
	private String ipVersion;
	private String grpId;
	private String rngId;
	private String ipStatusId;
	private String ipStatusName;
	private String companyId;
	private String companyName;
	private String locationId;
	private String locationName;
	private String vip;
	private String piority;  
	private String installId;
	private String installTypeName;
	private String networkZoneId;
	private String networkZoneName;
	private String submask;
	private String network;
	private String gateway;
	private String macAddress;
	private String hostName;
	private String systemName;
	private String networkType;
	private String reqestFromTeamId;
	private String requestFromTeamName;
	private String urRefer;
	private String projectId; 
	private String projectName;
	private String projectManager;
	private String systemOwnerId;
	private String systemOwnerName; 
	private String systemOwnerTeamId;
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
	
	private IPDetail  ipDetail;
	private List<IPDetail> ipDetailList;
	
	
	
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


	

}
