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
	private String ipType;

	
	
	
	
	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	
	@Column(name="IP_ADDRESS")
	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpAddress
		this.ipAddress = ipAddress;
	}
	
	@Column(name="IP_VERSION")
	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}
	
	@Column(name="GRP_ID")
	public String getGrpId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpId
		return grpId;
	}
	

	public void setGrpId(String grpId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpId
		this.grpId = grpId;
	}
	
	@Column(name="RNG_ID")
	public String getRngId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRngId
		return rngId;
	}

	public void setRngId(String rngId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRngId
		this.rngId = rngId;
	}

	@Column(name="IP_STATUS_ID")
	public String getIpStatusId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusId
		return ipStatusId;
	}

	public void setIpStatusId(String ipStatusId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusId
		this.ipStatusId = ipStatusId;
	}

	@Column(name="IP_STATUS_NAME")
	public String getIpStatusName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusName
		return ipStatusName;
	}

	public void setIpStatusName(String ipStatusName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusName
		this.ipStatusName = ipStatusName;
	}
	
	@Column(name="COMPANY_ID")
	public String getCompanyId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyId
		return companyId;
	}

	public void setCompanyId(String companyId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyId
		this.companyId = companyId;
	}

	@Column(name="COMPANY_NAME")
	public String getCompanyName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyName
		return companyName;
	}

	public void setCompanyName(String companyName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyName
		this.companyName = companyName;
	}

	@Column(name="LOCATION_ID")
	public String getLocationId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationId
		return locationId;
	}

	public void setLocationId(String locationId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationId
		this.locationId = locationId;
	}

	@Column(name="LOCATION_NAME")
	public String getLocationName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationName
		return locationName;
	}

	public void setLocationName(String locationName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationName
		this.locationName = locationName;
	}

	@Column(name="VIP")
	public String getVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVip
		return vip;
	}

	public void setVip(String vip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVip
		this.vip = vip;
	}

	@Column(name="PIORITY")
	public String getPiority() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPiority
		return piority;
	}

	public void setPiority(String piority) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPiority
		this.piority = piority;
	}

	@Column(name="INSTALL_TYPE_ID")
	public String getInstallId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallId
		return installId;
	}

	public void setInstallId(String installId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallId
		this.installId = installId;
	}

	@Column(name="INSTALL_TYPE_NAME")
	public String getInstallTypeName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallTypeName
		return installTypeName;
	}

	public void setInstallTypeName(String installTypeName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallTypeName
		this.installTypeName = installTypeName;
	}

	@Column(name="NETWORK_ZONE_ID")
	public String getNetworkZoneId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneId
		return networkZoneId;
	}

	public void setNetworkZoneId(String networkZoneId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneId
		this.networkZoneId = networkZoneId;
	}

	@Column(name="NETWORK_ZONE_NAME")
	public String getNetworkZoneName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneName
		return networkZoneName;
	}

	public void setNetworkZoneName(String networkZoneName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneName
		this.networkZoneName = networkZoneName;
	}

	@Column(name="SUBMASK")
	public String getSubmask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubmask
		return submask;
	}

	public void setSubmask(String submask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubmask
		this.submask = submask;
	}

	@Column(name="NETWORK")
	public String getNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetwork
		return network;
	}

	public void setNetwork(String network) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetwork
		this.network = network;
	}

	@Column(name="GATEWAY")
	public String getGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGateway
		return gateway;
	}

	public void setGateway(String gateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGateway
		this.gateway = gateway;
	}

	@Column(name="MAC_ADDRESS")
	public String getMacAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMacAddress
		return macAddress;
	}

	public void setMacAddress(String macAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMacAddress
		this.macAddress = macAddress;
	}

	@Column(name="HOST_NAME")
	public String getHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHostName
		return hostName;
	}

	public void setHostName(String hostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHostName
		this.hostName = hostName;
	}

	@Column(name="SYSTEM_NAME")
	public String getSystemName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemName
		return systemName;
	}

	public void setSystemName(String systemName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemName
		this.systemName = systemName;
	}

	@Column(name="NETWORK_TYPE")
	public String getNetworkType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkType
		return networkType;
	}

	public void setNetworkType(String networkType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkType
		this.networkType = networkType;
	}

	@Column(name="REQUEST_FROM_TEAM_ID")
	public String getReqestFromTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqestFromTeamId
		return reqestFromTeamId;
	}

	public void setReqestFromTeamId(String reqestFromTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqestFromTeamId
		this.reqestFromTeamId = reqestFromTeamId;
	}

	@Column(name="REQUEST_FROM_TEAM_NAME")
	public String getRequestFromTeamName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestFromTeamName
		return requestFromTeamName;
	}

	public void setRequestFromTeamName(String requestFromTeamName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestFromTeamName
		this.requestFromTeamName = requestFromTeamName;
	}

	@Column(name="UR_REFER")
	public String getUrRefer() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrRefer
		return urRefer;
	}

	public void setUrRefer(String urRefer) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrRefer
		this.urRefer = urRefer;
	}

	@Column(name="PROJECT_ID")
	public String getProjectId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectId
		return projectId;
	}

	public void setProjectId(String projectId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectId
		this.projectId = projectId;
	}

	@Column(name="PROJECT_NAME")
	public String getProjectName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectName
		return projectName;
	}

	public void setProjectName(String projectName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectName
		this.projectName = projectName;
	}

	@Column(name="PROJECT_MANAGER")
	public String getProjectManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectManager
		return projectManager;
	}

	public void setProjectManager(String projectManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectManager
		this.projectManager = projectManager;
	}


	@Column(name="EFFDATE")
	public String getEffDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffDate
		return effDate;
	}

	public void setEffDate(String effDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffDate
		this.effDate = effDate;
	}

	@Column(name="EXPDATE")
	public String getExpDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpDate
		return expDate;
	}

	public void setExpDate(String expDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpDate
		this.expDate = expDate;
	}

	@Column(name="SYSTEM_OWNER_ID")
	public String getSystemOwnerId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerId
		return systemOwnerId;
	}

	public void setSystemOwnerId(String systemOwnerId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerId
		this.systemOwnerId = systemOwnerId;
	}

	@Column(name="SYSTEM_OWNER_NAME")
	public String getSystemOwnerName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerName
		return systemOwnerName;
	}

	public void setSystemOwnerName(String systemOwnerName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerName
		this.systemOwnerName = systemOwnerName;
	}
	
	@Column(name="SYSTEM_OWNER_TEAM_ID")
	public String getSystemOwnerTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamId
		return systemOwnerTeamId;
	}

	public void setSystemOwnerTeamId(String systemOwnerTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamId
		this.systemOwnerTeamId = systemOwnerTeamId;
	}

	@Column(name="SYSTEM_OWNER_TEAM_NAME")
	public String getSystemOwnerTeamName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamName
		return systemOwnerTeamName;
	}

	public void setSystemOwnerTeamName(String systemOwnerTeamName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamName
		this.systemOwnerTeamName = systemOwnerTeamName;
	}

	@Column(name="VLAN_ID")
	public String getVlanId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVlanId
		return vlanId;
	}

	public void setVlanId(String vlanId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVlanId
		this.vlanId = vlanId;
	}

	@Column(name="DNS_NAME")
	public String getDnsName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDnsName
		return dnsName;
	}

	public void setDnsName(String dnsName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDnsName
		this.dnsName = dnsName;
	}

	@Column(name="FLOOR")
	public String getFloor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFloor
		return floor;
	}

	public void setFloor(String floor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFloor
		this.floor = floor;
	}

	@Column(name="SERVICE_ID")
	public String getServiceId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceId
		return serviceId;
	}

	public void setServiceId(String serviceId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServiceId
		this.serviceId = serviceId;
	}

	@Column(name="TIER1_TEAM_ID")
	public String getTier1TeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier1TeamId
		return tier1TeamId;
	}

	public void setTier1TeamId(String tier1TeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier1TeamId
		this.tier1TeamId = tier1TeamId;
	}

	@Column(name="TIER2_TEAM_ID")
	public String getTier2TeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier2TeamId
		return tier2TeamId;
	}

	public void setTier2TeamId(String tier2TeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier2TeamId
		this.tier2TeamId = tier2TeamId;
	}

	@Column(name="TIER3_TEAM_ID")
	public String getTier3TeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier3TeamId
		return tier3TeamId;
	}

	public void setTier3TeamId(String tier3TeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier3TeamId
		this.tier3TeamId = tier3TeamId;
	}

	@Column(name="TIER3_ID")
	public String getTier3Id() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier3Id
		return tier3Id;
	}

	public void setTier3Id(String tier3Id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier3Id
		this.tier3Id = tier3Id;
	}

	@Column(name="T1_REMARK")
	public String getT1Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT1Remark
		return t1Remark;
	}

	public void setT1Remark(String t1Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT1Remark
		this.t1Remark = t1Remark;
	}

	@Column(name="T2_REMARK")
	public String getT2Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT2Remark
		return t2Remark;
	}

	public void setT2Remark(String t2Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT2Remark
		this.t2Remark = t2Remark;
	}

	@Column(name="T3_REMARK")
	public String getT3Remark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getT3Remark
		return t3Remark;
	}

	public void setT3Remark(String t3Remark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT3Remark
		this.t3Remark = t3Remark;
	}

	@Column(name="CREATE_BY")
	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		return createdBy;
	}

	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		this.createdBy = createdBy;
	}

	@Column(name="CREATE_DATE")
	public Date getCreated() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreated
		return created;
	}

	public void setCreated(Date created) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreated
		this.created = created;
	}

	@Column(name="UPDATE_BY")
	public String getLastUpdBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpdBy
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpdBy
		this.lastUpdBy = lastUpdBy;
	}
	
	@Column(name="UPDATE_DATE")
	public Date getLastUpd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpd
		return lastUpd;
	}
	
	public void setLastUpd(Date lastUpd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpd
		this.lastUpd = lastUpd;
	}
	
	@Column(name="IP_TYPE")
	public String getIpType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpType
		return ipType;
	}

	public void setIpType(String ipType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpType
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
