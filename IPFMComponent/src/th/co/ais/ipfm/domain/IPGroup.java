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
@Table(name="IP_GROUP", schema="IPFMBK")
public class IPGroup extends MasterDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	private String rowID;
	private String grpID;
	private String ipVersion;
	private String stIP1;
	private String stIP2;
	private String stIP3;
	private String stIP4;
	private String stIP5;
	private String stIP6;
	private String edIP1;
	private String edIP2;
	private String edIP3;
	private String edIP4;
	private String edIP5;
	private String edIP6;
	
	private String tire1ID;
	private String tire1TeamID;
	private String grpIPST;
	private String grpIPED;
	private String grpDesc;
	private Integer version;
	private String isActive; ///ACTIVE_STATUS
	
	private Integer totalIP;
	private Integer totalAssignT2;
	private Integer totalAssignT3;
	private Integer totAVAIL;
	private String ipClass;
	private String ipClassName;
	private String companyID;
	private String companyName;
	
	@Transient
	public String getIpClassName() {
		return ipClassName;
	}

	public void setIpClassName(String ipClassName) {
		this.ipClassName = ipClassName;
	}
	@Transient
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Transient
	public Integer getTotAVAIL() {
		return totAVAIL;
	}

	public void setTotAVAIL(Integer totAVAIL) {
		this.totAVAIL = totAVAIL;
	}

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}
	
	@Column(name="TOTAL_ASSIGN_T2")
	public Integer getTotalAssignT2() {
		return totalAssignT2;
	}

	public void setTotalAssignT2(Integer totalAssignT2) {
		this.totalAssignT2 = totalAssignT2;
	}

	@Column(name="TOTAL_ASSIGN_T3")
	public Integer getTotalAssignT3() {
		return totalAssignT3;
	}

	public void setTotalAssignT3(Integer totalAssignT3) {
		this.totalAssignT3 = totalAssignT3;
	}

	@Column(name="IP_CLASS",nullable=false)
	public String getIpClass() {
		return ipClass;
	}

	public void setIpClass(String ipClass) {
		this.ipClass = ipClass;
	}

	@Column(name="COMPANY_ID")
	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	
	@Column(name="GROUP_ID", unique=true, nullable=false, length=10)
	public String getGrpID() {
		return grpID;
	}

	public void setGrpID(String grpID) {
		this.grpID = grpID;
	}
	
	@Column(name="IP_VERSION",nullable=false)
	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}

	@Column(name="ST_IP_1")
	public String getStIP1() {
		return stIP1;
	}

	public void setStIP1(String stIP1) {
		this.stIP1 = stIP1;
	}

	@Column(name="ST_IP_2")
	public String getStIP2() {
		return stIP2;
	}

	public void setStIP2(String stIP2) {
		this.stIP2 = stIP2;
	}

	@Column(name="ST_IP_3")
	public String getStIP3() {
		return stIP3;
	}

	public void setStIP3(String stIP3) {
		this.stIP3 = stIP3;
	}

	@Column(name="ST_IP_4")
	public String getStIP4() {
		return stIP4;
	}

	public void setStIP4(String stIP4) {
		this.stIP4 = stIP4;
	}

	@Column(name="ST_IP_5")
	public String getStIP5() {
		return stIP5;
	}

	public void setStIP5(String stIP5) {
		this.stIP5 = stIP5;
	}

	@Column(name="ST_IP_6")
	public String getStIP6() {
		return stIP6;
	}

	public void setStIP6(String stIP6) {
		this.stIP6 = stIP6;
	}

	@Column(name="ED_IP_1")
	public String getEdIP1() {
		return edIP1;
	}

	public void setEdIP1(String edIP1) {
		this.edIP1 = edIP1;
	}

	@Column(name="ED_IP_2")
	public String getEdIP2() {
		return edIP2;
	}

	public void setEdIP2(String edIP2) {
		this.edIP2 = edIP2;
	}

	@Column(name="ED_IP_3")
	public String getEdIP3() {
		return edIP3;
	}

	public void setEdIP3(String edIP3) {
		this.edIP3 = edIP3;
	}

	@Column(name="ED_IP_4")
	public String getEdIP4() {
		return edIP4;
	}

	public void setEdIP4(String edIP4) {
		this.edIP4 = edIP4;
	}

	@Column(name="ED_IP_5")
	public String getEdIP5() {
		return edIP5;
	}

	public void setEdIP5(String edIP5) {
		this.edIP5 = edIP5;
	}
	
	@Column(name="ED_IP_6")
	public String getEdIP6() {
		return edIP6;
	}

	public void setEdIP6(String edIP6) {
		this.edIP6 = edIP6;
	}

	@Column(name="GROUP_IP_ST")
	public String getGrpIPST() {
		return grpIPST;
	}

	public void setGrpIPST(String grpIPST) {
		this.grpIPST = grpIPST;
	}
	
	@Column(name="GROUP_DESC")
	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}
	@Column(name="TIER1_ID")
	public String getTire1ID() {
		return tire1ID;
	}

	public void setTire1ID(String tire1id) {
		tire1ID = tire1id;
	}
	@Column(name="TIER1_TEAM_ID")
	public String getTire1TeamID() {
		return tire1TeamID;
	}

	public void setTire1TeamID(String tire1TeamID) {
		this.tire1TeamID = tire1TeamID;
	}
	
	@Column(name="GROUP_IP_ED")
	public String getGrpIPED() {
		return grpIPED;
	}

	public void setGrpIPED(String grpIPED) {
		this.grpIPED = grpIPED;
	}

	@Column(name="VERSION")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name="ACTIVE_STATUS")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Column(name="TOTAL_IP")
	public Integer getTotalIP() {
		return totalIP;
	}

	public void setTotalIP(Integer totalIP) {
		this.totalIP = totalIP;
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
	

}
