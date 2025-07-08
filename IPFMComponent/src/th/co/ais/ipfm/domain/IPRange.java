package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name="IP_RANGE", schema="IPFMBK")
public class IPRange extends MasterDomain implements Serializable {

	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private String rowId;
	private String rngId;
	private String grpId;
	private String ipVersion = "4";
	private String rngIpSt;
	private String rngIpEd;
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
	private String companyId;
	private String companyName;
	private String activeStatus;		
					
	private String effDate;				
	private String expDate;	
	private String locationId;
	private String locationName;
	private String networkZoneId;
	private String networkZoneName;					
	private String networkTypeId;
	private String networkTypeName;
	private String urRefer;
	
	private String ipClass;
	private String rangeDesc;
	private Integer totalIP;
	private Integer totalAssignT3;
	private Integer totalUsed;
	private Integer totalReserved;
	private String tier2Id;
	private String tier1TeamId;
	private String tier2TeamId;
	private String vLanId;
	private String dnsName;
	private String subMask;
	private String netWork;
	private String gateWay;
	private String ipType;
	private String vip;
	private String version;
	
	private String strTotalIP;
	private String assignToPlanning;
	private String assignToUser;
	private String reserved;
	private String used;
	
	//transient
	private String effDateDisplay;
	private String expDateDisplay;
	private Integer totalAvailable;

	@Column(name="IP_CLASS")
	public String getIpClass() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClass
		return ipClass;
	}
	
	public void setIpClass(String ipClass) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClass
		this.ipClass = ipClass;
	}
	
	@Column(name="RANG_DESC")
	public String getRangeDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRangeDesc
		return rangeDesc;
	}
	
	public void setRangeDesc(String rangeDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRangeDesc
		this.rangeDesc = rangeDesc;
	}
	
	@Column(name="TOTAL_IP")
	public Integer getTotalIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalIP
		return totalIP;
	}
	
	public void setTotalIP(Integer totalIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalIP
		this.totalIP = totalIP;
	}
	
	@Column(name="TOTAL_ASSIGN_T3")
	public Integer getTotalAssignT3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalAssignT3
		return totalAssignT3;
	}
	
	public void setTotalAssignT3(Integer totalAssignT3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalAssignT3
		this.totalAssignT3 = totalAssignT3;
	}
	
	@Column(name="TOTAL_USED")
	public Integer getTotalUsed() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalUsed
		return totalUsed;
	}
	
	public void setTotalUsed(Integer totalUsed) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalUsed
		this.totalUsed = totalUsed;
	}
	
	@Column(name="TOTAL_RESERVED")
	public Integer getTotalReserved() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalReserved
		return totalReserved;
	}
	
	public void setTotalReserved(Integer totalReserved) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalReserved
		this.totalReserved = totalReserved;
	}
	
	@Column(name="TIER2_ID")
	public String getTier2Id() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier2Id
		return tier2Id;
	}
	
	public void setTier2Id(String tier2Id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier2Id
		this.tier2Id = tier2Id;
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
	
	@Column(name="VLAN_ID")
	public String getvLanId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getvLanId
		return vLanId;
	}
	
	public void setvLanId(String vLanId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setvLanId
		this.vLanId = vLanId;
	}
	
	@Column(name="DNS_NAME")
	public String getDnsName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDnsName
		return dnsName;
	}
	
	public void setDnsName(String dnsName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDnsName
		this.dnsName = dnsName;
	}
	
	@Column(name="SUBMASK")
	public String getSubMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubMask
		return subMask;
	}
	
	public void setSubMask(String subMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubMask
		this.subMask = subMask;
	}
	
	@Column(name="NETWORK")
	public String getNetWork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetWork
		return netWork;
	}
	
	public void setNetWork(String netWork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetWork
		this.netWork = netWork;
	}
	
	@Column(name="GATEWAY")
	public String getGateWay() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGateWay
		return gateWay;
	}
	
	public void setGateWay(String gateWay) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGateWay
		this.gateWay = gateWay;
	}
	
	@Column(name="IP_TYPE")
	public String getIpType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpType
		return ipType;
	}
	
	public void setIpType(String ipType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpType
		this.ipType = ipType;
	}
	
	@Column(name="VIP")
	public String getVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVip
		return vip;
	}
	
	public void setVip(String vip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVip
		this.vip = vip;
	}
	
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
	
	@Column(name="RANG_ID",nullable=false,length=10)
	public String getRngId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRngId
		return rngId;
	}
	public void setRngId(String rngId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRngId
		this.rngId = rngId;
	}
	
	@Column(name="GROUP_ID",nullable=false,length=10)
	public String getGrpId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpId
		return grpId;
	}
	public void setGrpId(String grpId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpId
		this.grpId = grpId;
	}
	
	@Column(name="IP_VERSION")
	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}
	
	@Column(name="RANG_IP_ST")
	public String getRngIpSt() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRngIpSt
		return rngIpSt;
	}
	public void setRngIpSt(String rngIpSt) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRngIpSt
		this.rngIpSt = rngIpSt;
	}
	
	@Column(name="RANG_IP_ED")
	public String getRngIpEd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRngIpEd
		return rngIpEd;
	}
	public void setRngIpEd(String rngIpEd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRngIpEd
		this.rngIpEd = rngIpEd;
	}
	
	@Column(name="ST_IP_1")
	public String getStIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp1
		return stIp1;
	}
	public void setStIp1(String stIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp1
		this.stIp1 = stIp1;
	}
	
	@Column(name="ST_IP_2")
	public String getStIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp2
		return stIp2;
	}
	public void setStIp2(String stIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp2
		this.stIp2 = stIp2;
	}
	
	@Column(name="ST_IP_3")
	public String getStIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp3
		return stIp3;
	}
	public void setStIp3(String stIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp3
		this.stIp3 = stIp3;
	}
	
	@Column(name="ST_IP_4")
	public String getStIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp4
		return stIp4;
	}
	
	public void setStIp4(String stIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp4
		this.stIp4 = stIp4;
	}
	
	@Column(name="ST_IP_5")
	public String getStIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp5
		return stIp5;
	}
	public void setStIp5(String stIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp5
		this.stIp5 = stIp5;
	}
	
	@Column(name="ST_IP_6")
	public String getStIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIp6
		return stIp6;
	}
	public void setStIp6(String stIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIp6
		this.stIp6 = stIp6;
	}
	
	@Column(name="ED_IP_1")
	public String getEdIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp1
		return edIp1;
	}
	public void setEdIp1(String edIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp1
		this.edIp1 = edIp1;
	}
	
	@Column(name="ED_IP_2")
	public String getEdIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp2
		return edIp2;
	}
	public void setEdIp2(String edIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp2
		this.edIp2 = edIp2;
	}
	
	@Column(name="ED_IP_3")
	public String getEdIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp3
		return edIp3;
	}
	public void setEdIp3(String edIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp3
		this.edIp3 = edIp3;
	}
	
	@Column(name="ED_IP_4")
	public String getEdIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp4
		return edIp4;
	}
	public void setEdIp4(String edIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp4
		this.edIp4 = edIp4;
	}
	
	@Column(name="ED_IP_5")
	public String getEdIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp5
		return edIp5;
	}
	public void setEdIp5(String edIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp5
		this.edIp5 = edIp5;
	}
	
	@Column(name="ED_IP_6")
	public String getEdIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIp6
		return edIp6;
	}
	public void setEdIp6(String edIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIp6
		this.edIp6 = edIp6;
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
	
	@Column(name="ACTIVE_STATUS")
	public String getActiveStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActiveStatus
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActiveStatus
		this.activeStatus = activeStatus;
	}
	
	@Column(name="EFFECTIVE_DATE")
	public String getEffDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffDate
		return effDate;
	}
	public void setEffDate(String effDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffDate
		this.effDate = effDate;
	}
	
	@Column(name="EXPIRED_DATE")
	public String getExpDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpDate
		return expDate;
	}
	public void setExpDate(String expDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpDate
		this.expDate = expDate;
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
	
	@Column(name="NETWORK_TYPE_ID")
	public String getNetworkTypeId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkTypeId
		return networkTypeId;
	}

	public void setNetworkTypeId(String networkTypeId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeId
		this.networkTypeId = networkTypeId;
	}

	@Column(name="NETWORK_TYPE_Name")
	public String getNetworkTypeName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkTypeName
		return networkTypeName;
	}

	public void setNetworkTypeName(String networkTypeName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeName
		this.networkTypeName = networkTypeName;
	}
		
	@Column(name="UR_REFER")
	public String getUrRefer() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrRefer
		return urRefer;
	}

	public void setUrRefer(String urRefer) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrRefer
		this.urRefer = urRefer;
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
	
	@Transient
	public String getEffDateDisplay() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffDateDisplay
		return effDateDisplay;
	}
	
	public void setEffDateDisplay(String effDateDisplay) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffDateDisplay
		this.effDateDisplay = effDateDisplay;
	}
	
	@Transient
	public String getExpDateDisplay() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpDateDisplay
		return expDateDisplay;
	}
	
	public void setExpDateDisplay(String expDateDisplay) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpDateDisplay
		this.expDateDisplay = expDateDisplay;
	}

	@Transient
	public Integer getTotalAvailable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalAvailable
	
		return totalAvailable;
	}

	public void setTotalAvailable(Integer totalAvailable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalAvailable
		this.totalAvailable = totalAvailable;
	}

	public String getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(String version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}

	public String getAssignToPlanning() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignToPlanning
		return assignToPlanning;
	}

	public void setAssignToPlanning(String assignToPlanning) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignToPlanning
		this.assignToPlanning = assignToPlanning;
	}

	public String getAssignToUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignToUser
		return assignToUser;
	}

	public void setAssignToUser(String assignToUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignToUser
		this.assignToUser = assignToUser;
	}

	public String getReserved() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReserved
		return reserved;
	}

	public void setReserved(String reserved) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReserved
		this.reserved = reserved;
	}

	public String getUsed() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUsed
		return used;
	}

	public void setUsed(String used) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUsed
		this.used = used;
	}

	public String getStrTotalIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStrTotalIP
		return strTotalIP;
	}

	public void setStrTotalIP(String strTotalIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStrTotalIP
		this.strTotalIP = strTotalIP;
	}
	
//	public boolean getPopupLockMode(){
//		if (getTotalIP().intValue()==getTotalAvailable().intValue()) {
//			return true;
//		}else{
//			return false;
//		}
//	}
}
