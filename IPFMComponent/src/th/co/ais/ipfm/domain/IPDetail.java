package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name="IP_DETAIL", schema="IPFMBK")
public class IPDetail extends MasterDomain implements Serializable , Cloneable {

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
	private String ipType;

	
	
	
	
	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name="IP_ADDRESS")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	@Column(name="IP_VERSION")
	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}
	
	@Column(name="GRP_ID")
	public String getGrpId() {
		return grpId;
	}
	

	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	
	@Column(name="RNG_ID")
	public String getRngId() {
		return rngId;
	}

	public void setRngId(String rngId) {
		this.rngId = rngId;
	}

	@Column(name="IP_STATUS_ID")
	public String getIpStatusId() {
		return ipStatusId;
	}

	public void setIpStatusId(String ipStatusId) {
		this.ipStatusId = ipStatusId;
	}

	@Column(name="IP_STATUS_NAME")
	public String getIpStatusName() {
		return ipStatusName;
	}

	public void setIpStatusName(String ipStatusName) {
		this.ipStatusName = ipStatusName;
	}
	
	@Column(name="COMPANY_ID")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name="LOCATION_ID")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name="LOCATION_NAME")
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Column(name="VIP")
	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	@Column(name="PIORITY")
	public String getPiority() {
		return piority;
	}

	public void setPiority(String piority) {
		this.piority = piority;
	}

	@Column(name="INSTALL_TYPE_ID")
	public String getInstallId() {
		return installId;
	}

	public void setInstallId(String installId) {
		this.installId = installId;
	}

	@Column(name="INSTALL_TYPE_NAME")
	public String getInstallTypeName() {
		return installTypeName;
	}

	public void setInstallTypeName(String installTypeName) {
		this.installTypeName = installTypeName;
	}

	@Column(name="NETWORK_ZONE_ID")
	public String getNetworkZoneId() {
		return networkZoneId;
	}

	public void setNetworkZoneId(String networkZoneId) {
		this.networkZoneId = networkZoneId;
	}

	@Column(name="NETWORK_ZONE_NAME")
	public String getNetworkZoneName() {
		return networkZoneName;
	}

	public void setNetworkZoneName(String networkZoneName) {
		this.networkZoneName = networkZoneName;
	}

	@Column(name="SUBMASK")
	public String getSubmask() {
		return submask;
	}

	public void setSubmask(String submask) {
		this.submask = submask;
	}

	@Column(name="NETWORK")
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@Column(name="GATEWAY")
	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	@Column(name="MAC_ADDRESS")
	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Column(name="HOST_NAME")
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Column(name="SYSTEM_NAME")
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	@Column(name="NETWORK_TYPE")
	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	@Column(name="REQUEST_FROM_TEAM_ID")
	public String getReqestFromTeamId() {
		return reqestFromTeamId;
	}

	public void setReqestFromTeamId(String reqestFromTeamId) {
		this.reqestFromTeamId = reqestFromTeamId;
	}

	@Column(name="REQUEST_FROM_TEAM_NAME")
	public String getRequestFromTeamName() {
		return requestFromTeamName;
	}

	public void setRequestFromTeamName(String requestFromTeamName) {
		this.requestFromTeamName = requestFromTeamName;
	}

	@Column(name="UR_REFER")
	public String getUrRefer() {
		return urRefer;
	}

	public void setUrRefer(String urRefer) {
		this.urRefer = urRefer;
	}

	@Column(name="PROJECT_ID")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name="PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name="PROJECT_MANAGER")
	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}


	@Column(name="EFFDATE")
	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	@Column(name="EXPDATE")
	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Column(name="SYSTEM_OWNER_ID")
	public String getSystemOwnerId() {
		return systemOwnerId;
	}

	public void setSystemOwnerId(String systemOwnerId) {
		this.systemOwnerId = systemOwnerId;
	}

	@Column(name="SYSTEM_OWNER_NAME")
	public String getSystemOwnerName() {
		return systemOwnerName;
	}

	public void setSystemOwnerName(String systemOwnerName) {
		this.systemOwnerName = systemOwnerName;
	}
	
	@Column(name="SYSTEM_OWNER_TEAM_ID")
	public String getSystemOwnerTeamId() {
		return systemOwnerTeamId;
	}

	public void setSystemOwnerTeamId(String systemOwnerTeamId) {
		this.systemOwnerTeamId = systemOwnerTeamId;
	}

	@Column(name="SYSTEM_OWNER_TEAM_NAME")
	public String getSystemOwnerTeamName() {
		return systemOwnerTeamName;
	}

	public void setSystemOwnerTeamName(String systemOwnerTeamName) {
		this.systemOwnerTeamName = systemOwnerTeamName;
	}

	@Column(name="VLAN_ID")
	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}

	@Column(name="DNS_NAME")
	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	@Column(name="FLOOR")
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Column(name="SERVICE_ID")
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name="TIER1_TEAM_ID")
	public String getTier1TeamId() {
		return tier1TeamId;
	}

	public void setTier1TeamId(String tier1TeamId) {
		this.tier1TeamId = tier1TeamId;
	}

	@Column(name="TIER2_TEAM_ID")
	public String getTier2TeamId() {
		return tier2TeamId;
	}

	public void setTier2TeamId(String tier2TeamId) {
		this.tier2TeamId = tier2TeamId;
	}

	@Column(name="TIER3_TEAM_ID")
	public String getTier3TeamId() {
		return tier3TeamId;
	}

	public void setTier3TeamId(String tier3TeamId) {
		this.tier3TeamId = tier3TeamId;
	}

	@Column(name="TIER3_ID")
	public String getTier3Id() {
		return tier3Id;
	}

	public void setTier3Id(String tier3Id) {
		this.tier3Id = tier3Id;
	}

	@Column(name="T1_REMARK")
	public String getT1Remark() {
		return t1Remark;
	}

	public void setT1Remark(String t1Remark) {
		this.t1Remark = t1Remark;
	}

	@Column(name="T2_REMARK")
	public String getT2Remark() {
		return t2Remark;
	}

	public void setT2Remark(String t2Remark) {
		this.t2Remark = t2Remark;
	}

	@Column(name="T3_REMARK")
	public String getT3Remark() {
		return t3Remark;
	}

	public void setT3Remark(String t3Remark) {
		this.t3Remark = t3Remark;
	}

	@Column(name="CREATE_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="CREATE_DATE")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name="UPDATE_BY")
	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	
	@Column(name="UPDATE_DATE")
	public Date getLastUpd() {
		return lastUpd;
	}
	
	public void setLastUpd(Date lastUpd) {
		this.lastUpd = lastUpd;
	}
	
	@Column(name="IP_TYPE")
	public String getIpType() {
		return ipType;
	}

	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	@Override
    public Object clone() throws CloneNotSupportedException
    {
		IPDetail another = (IPDetail) super.clone();
        //? take care of any deep copies to be made here
        return another;
    }
	

}
