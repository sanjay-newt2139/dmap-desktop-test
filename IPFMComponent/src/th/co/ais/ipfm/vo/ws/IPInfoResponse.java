package th.co.ais.ipfm.vo.ws;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IPInfoResponse implements Serializable {

    /**
	 * 
	 */	
	private String ipAddress;
    private Long version;
    private String ipVersion;
    private String ipSubmask;
    private BigDecimal ipv4digit1;
    private BigDecimal ipv4digit2;
    private BigDecimal ipv4digit3;
    private BigDecimal ipv4digit4;
    private BigDecimal ipv6digit1;
    private BigDecimal ipv6digit2;
    private BigDecimal ipv6digit3;
    private BigDecimal ipv6digit4;
    private BigDecimal ipv6digit5;
    private BigDecimal ipv6digit6;
    private String level1Id;
    private String level2Id;
    private String binaryIp;
    private String ipStatus;
    private String status;
    private String companyId;
    private String companyName;
    private String locationId;
    private String locationName;
    private String ipTypeId;
    private String ipTypeName;
    private String vip;
    private String installTypeId;
    private String installTypeName;
    private String networkZoneId;
    private String networkZoneName;
    private String submask;
    private String networkIp;
    private String gateway;
    private String macAddress;
    private String hostName;
    private String systemName;
    private String networkTypeId;
    private String networkTypeName;
    private String t2TeamId;
    private String t2TeamName;
    private String urRefer;
    private String projectId;
    private String projectName;
    private String projectManager;
    private String effectiveDate;
    private String expiredDate;
    private String systemOwnerId;
    private String systemOwner;
    private String systemOwnerName;
    private String systemOwnerTeamId;
    private String systemOwnerTeamName;
    private String vlanId;
    private String dnsName;
    private String t1TeamId;
    private String t1TeamName;
    private String t1Remark;
    private String t2Remark;
    private String t3Remark;
    private String wyNodeName;
    private String rowId;
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getIpVersion() {
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}
	public String getIpSubmask() {
		return ipSubmask;
	}
	public void setIpSubmask(String ipSubmask) {
		this.ipSubmask = ipSubmask;
	}
	public BigDecimal getIpv4digit1() {
		return ipv4digit1;
	}
	public void setIpv4digit1(BigDecimal ipv4digit1) {
		this.ipv4digit1 = ipv4digit1;
	}
	public BigDecimal getIpv4digit2() {
		return ipv4digit2;
	}
	public void setIpv4digit2(BigDecimal ipv4digit2) {
		this.ipv4digit2 = ipv4digit2;
	}
	public BigDecimal getIpv4digit3() {
		return ipv4digit3;
	}
	public void setIpv4digit3(BigDecimal ipv4digit3) {
		this.ipv4digit3 = ipv4digit3;
	}
	public BigDecimal getIpv4digit4() {
		return ipv4digit4;
	}
	public void setIpv4digit4(BigDecimal ipv4digit4) {
		this.ipv4digit4 = ipv4digit4;
	}
	public BigDecimal getIpv6digit1() {
		return ipv6digit1;
	}
	public void setIpv6digit1(BigDecimal ipv6digit1) {
		this.ipv6digit1 = ipv6digit1;
	}
	public BigDecimal getIpv6digit2() {
		return ipv6digit2;
	}
	public void setIpv6digit2(BigDecimal ipv6digit2) {
		this.ipv6digit2 = ipv6digit2;
	}
	public BigDecimal getIpv6digit3() {
		return ipv6digit3;
	}
	public void setIpv6digit3(BigDecimal ipv6digit3) {
		this.ipv6digit3 = ipv6digit3;
	}
	public BigDecimal getIpv6digit4() {
		return ipv6digit4;
	}
	public void setIpv6digit4(BigDecimal ipv6digit4) {
		this.ipv6digit4 = ipv6digit4;
	}
	public BigDecimal getIpv6digit5() {
		return ipv6digit5;
	}
	public void setIpv6digit5(BigDecimal ipv6digit5) {
		this.ipv6digit5 = ipv6digit5;
	}
	public BigDecimal getIpv6digit6() {
		return ipv6digit6;
	}
	public void setIpv6digit6(BigDecimal ipv6digit6) {
		this.ipv6digit6 = ipv6digit6;
	}
	public String getLevel1Id() {
		return level1Id;
	}
	public void setLevel1Id(String level1Id) {
		this.level1Id = level1Id;
	}
	public String getLevel2Id() {
		return level2Id;
	}
	public void setLevel2Id(String level2Id) {
		this.level2Id = level2Id;
	}
	public String getBinaryIp() {
		return binaryIp;
	}
	public void setBinaryIp(String binaryIp) {
		this.binaryIp = binaryIp;
	}
	public String getIpStatus() {
		return ipStatus;
	}
	public void setIpStatus(String ipStatus) {
		this.ipStatus = ipStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getIpTypeId() {
		return ipTypeId;
	}
	public void setIpTypeId(String ipTypeId) {
		this.ipTypeId = ipTypeId;
	}
	public String getIpTypeName() {
		return ipTypeName;
	}
	public void setIpTypeName(String ipTypeName) {
		this.ipTypeName = ipTypeName;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getInstallTypeId() {
		return installTypeId;
	}
	public void setInstallTypeId(String installTypeId) {
		this.installTypeId = installTypeId;
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
	public String getNetworkIp() {
		return networkIp;
	}
	public void setNetworkIp(String networkIp) {
		this.networkIp = networkIp;
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
	public String getNetworkTypeId() {
		return networkTypeId;
	}
	public void setNetworkTypeId(String networkTypeId) {
		this.networkTypeId = networkTypeId;
	}
	public String getNetworkTypeName() {
		return networkTypeName;
	}
	public void setNetworkTypeName(String networkTypeName) {
		this.networkTypeName = networkTypeName;
	}
	public String getT2TeamId() {
		return t2TeamId;
	}
	public void setT2TeamId(String t2TeamId) {
		this.t2TeamId = t2TeamId;
	}
	public String getT2TeamName() {
		return t2TeamName;
	}
	public void setT2TeamName(String t2TeamName) {
		this.t2TeamName = t2TeamName;
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
	public String getSystemOwner() {
		return systemOwner;
	}
	public void setSystemOwner(String systemOwner) {
		this.systemOwner = systemOwner;
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
	public String getT1TeamId() {
		return t1TeamId;
	}
	public void setT1TeamId(String t1TeamId) {
		this.t1TeamId = t1TeamId;
	}
	public String getT1TeamName() {
		return t1TeamName;
	}
	public void setT1TeamName(String t1TeamName) {
		this.t1TeamName = t1TeamName;
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
	public String getWyNodeName() {
		return wyNodeName;
	}
	public void setWyNodeName(String wyNodeName) {
		this.wyNodeName = wyNodeName;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
    
    
}
