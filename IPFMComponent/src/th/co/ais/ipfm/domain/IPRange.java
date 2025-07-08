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

	private static final long serialVersionUID = 1L;
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
	public String getIpClass() {
		return ipClass;
	}
	
	public void setIpClass(String ipClass) {
		this.ipClass = ipClass;
	}
	
	@Column(name="RANG_DESC")
	public String getRangeDesc() {
		return rangeDesc;
	}
	
	public void setRangeDesc(String rangeDesc) {
		this.rangeDesc = rangeDesc;
	}
	
	@Column(name="TOTAL_IP")
	public Integer getTotalIP() {
		return totalIP;
	}
	
	public void setTotalIP(Integer totalIP) {
		this.totalIP = totalIP;
	}
	
	@Column(name="TOTAL_ASSIGN_T3")
	public Integer getTotalAssignT3() {
		return totalAssignT3;
	}
	
	public void setTotalAssignT3(Integer totalAssignT3) {
		this.totalAssignT3 = totalAssignT3;
	}
	
	@Column(name="TOTAL_USED")
	public Integer getTotalUsed() {
		return totalUsed;
	}
	
	public void setTotalUsed(Integer totalUsed) {
		this.totalUsed = totalUsed;
	}
	
	@Column(name="TOTAL_RESERVED")
	public Integer getTotalReserved() {
		return totalReserved;
	}
	
	public void setTotalReserved(Integer totalReserved) {
		this.totalReserved = totalReserved;
	}
	
	@Column(name="TIER2_ID")
	public String getTier2Id() {
		return tier2Id;
	}
	
	public void setTier2Id(String tier2Id) {
		this.tier2Id = tier2Id;
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
	
	@Column(name="VLAN_ID")
	public String getvLanId() {
		return vLanId;
	}
	
	public void setvLanId(String vLanId) {
		this.vLanId = vLanId;
	}
	
	@Column(name="DNS_NAME")
	public String getDnsName() {
		return dnsName;
	}
	
	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}
	
	@Column(name="SUBMASK")
	public String getSubMask() {
		return subMask;
	}
	
	public void setSubMask(String subMask) {
		this.subMask = subMask;
	}
	
	@Column(name="NETWORK")
	public String getNetWork() {
		return netWork;
	}
	
	public void setNetWork(String netWork) {
		this.netWork = netWork;
	}
	
	@Column(name="GATEWAY")
	public String getGateWay() {
		return gateWay;
	}
	
	public void setGateWay(String gateWay) {
		this.gateWay = gateWay;
	}
	
	@Column(name="IP_TYPE")
	public String getIpType() {
		return ipType;
	}
	
	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	
	@Column(name="VIP")
	public String getVip() {
		return vip;
	}
	
	public void setVip(String vip) {
		this.vip = vip;
	}
	
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
	
	@Column(name="RANG_ID",nullable=false,length=10)
	public String getRngId() {
		return rngId;
	}
	public void setRngId(String rngId) {
		this.rngId = rngId;
	}
	
	@Column(name="GROUP_ID",nullable=false,length=10)
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	
	@Column(name="IP_VERSION")
	public String getIpVersion() {
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}
	
	@Column(name="RANG_IP_ST")
	public String getRngIpSt() {
		return rngIpSt;
	}
	public void setRngIpSt(String rngIpSt) {
		this.rngIpSt = rngIpSt;
	}
	
	@Column(name="RANG_IP_ED")
	public String getRngIpEd() {
		return rngIpEd;
	}
	public void setRngIpEd(String rngIpEd) {
		this.rngIpEd = rngIpEd;
	}
	
	@Column(name="ST_IP_1")
	public String getStIp1() {
		return stIp1;
	}
	public void setStIp1(String stIp1) {
		this.stIp1 = stIp1;
	}
	
	@Column(name="ST_IP_2")
	public String getStIp2() {
		return stIp2;
	}
	public void setStIp2(String stIp2) {
		this.stIp2 = stIp2;
	}
	
	@Column(name="ST_IP_3")
	public String getStIp3() {
		return stIp3;
	}
	public void setStIp3(String stIp3) {
		this.stIp3 = stIp3;
	}
	
	@Column(name="ST_IP_4")
	public String getStIp4() {
		return stIp4;
	}
	
	public void setStIp4(String stIp4) {
		this.stIp4 = stIp4;
	}
	
	@Column(name="ST_IP_5")
	public String getStIp5() {
		return stIp5;
	}
	public void setStIp5(String stIp5) {
		this.stIp5 = stIp5;
	}
	
	@Column(name="ST_IP_6")
	public String getStIp6() {
		return stIp6;
	}
	public void setStIp6(String stIp6) {
		this.stIp6 = stIp6;
	}
	
	@Column(name="ED_IP_1")
	public String getEdIp1() {
		return edIp1;
	}
	public void setEdIp1(String edIp1) {
		this.edIp1 = edIp1;
	}
	
	@Column(name="ED_IP_2")
	public String getEdIp2() {
		return edIp2;
	}
	public void setEdIp2(String edIp2) {
		this.edIp2 = edIp2;
	}
	
	@Column(name="ED_IP_3")
	public String getEdIp3() {
		return edIp3;
	}
	public void setEdIp3(String edIp3) {
		this.edIp3 = edIp3;
	}
	
	@Column(name="ED_IP_4")
	public String getEdIp4() {
		return edIp4;
	}
	public void setEdIp4(String edIp4) {
		this.edIp4 = edIp4;
	}
	
	@Column(name="ED_IP_5")
	public String getEdIp5() {
		return edIp5;
	}
	public void setEdIp5(String edIp5) {
		this.edIp5 = edIp5;
	}
	
	@Column(name="ED_IP_6")
	public String getEdIp6() {
		return edIp6;
	}
	public void setEdIp6(String edIp6) {
		this.edIp6 = edIp6;
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
	
	@Column(name="ACTIVE_STATUS")
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	@Column(name="EFFECTIVE_DATE")
	public String getEffDate() {
		return effDate;
	}
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	
	@Column(name="EXPIRED_DATE")
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
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
	
	@Column(name="NETWORK_TYPE_ID")
	public String getNetworkTypeId() {
		return networkTypeId;
	}

	public void setNetworkTypeId(String networkTypeId) {
		this.networkTypeId = networkTypeId;
	}

	@Column(name="NETWORK_TYPE_Name")
	public String getNetworkTypeName() {
		return networkTypeName;
	}

	public void setNetworkTypeName(String networkTypeName) {
		this.networkTypeName = networkTypeName;
	}
		
	@Column(name="UR_REFER")
	public String getUrRefer() {
		return urRefer;
	}

	public void setUrRefer(String urRefer) {
		this.urRefer = urRefer;
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
	
	@Transient
	public String getEffDateDisplay() {
		return effDateDisplay;
	}
	
	public void setEffDateDisplay(String effDateDisplay) {
		this.effDateDisplay = effDateDisplay;
	}
	
	@Transient
	public String getExpDateDisplay() {
		return expDateDisplay;
	}
	
	public void setExpDateDisplay(String expDateDisplay) {
		this.expDateDisplay = expDateDisplay;
	}

	@Transient
	public Integer getTotalAvailable() {
	
		return totalAvailable;
	}

	public void setTotalAvailable(Integer totalAvailable) {
		this.totalAvailable = totalAvailable;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAssignToPlanning() {
		return assignToPlanning;
	}

	public void setAssignToPlanning(String assignToPlanning) {
		this.assignToPlanning = assignToPlanning;
	}

	public String getAssignToUser() {
		return assignToUser;
	}

	public void setAssignToUser(String assignToUser) {
		this.assignToUser = assignToUser;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getStrTotalIP() {
		return strTotalIP;
	}

	public void setStrTotalIP(String strTotalIP) {
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
