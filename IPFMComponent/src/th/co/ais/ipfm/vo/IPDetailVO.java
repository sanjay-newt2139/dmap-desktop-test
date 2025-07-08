package th.co.ais.ipfm.vo;

import java.io.Serializable;
import java.util.List;

import th.co.ais.ipfm.domain.IPDetail;

public class IPDetailVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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


	

}
