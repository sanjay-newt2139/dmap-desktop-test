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
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

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
	public String getIpClassName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassName
		return ipClassName;
	}

	public void setIpClassName(String ipClassName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassName
		this.ipClassName = ipClassName;
	}
	@Transient
	public String getCompanyName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyName
		return companyName;
	}

	public void setCompanyName(String companyName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyName
		this.companyName = companyName;
	}
	@Transient
	public Integer getTotAVAIL() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotAVAIL
		return totAVAIL;
	}

	public void setTotAVAIL(Integer totAVAIL) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotAVAIL
		this.totAVAIL = totAVAIL;
	}

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowID
		return rowID;
	}

	public void setRowID(String rowID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowID
		this.rowID = rowID;
	}
	
	@Column(name="TOTAL_ASSIGN_T2")
	public Integer getTotalAssignT2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalAssignT2
		return totalAssignT2;
	}

	public void setTotalAssignT2(Integer totalAssignT2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalAssignT2
		this.totalAssignT2 = totalAssignT2;
	}

	@Column(name="TOTAL_ASSIGN_T3")
	public Integer getTotalAssignT3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalAssignT3
		return totalAssignT3;
	}

	public void setTotalAssignT3(Integer totalAssignT3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalAssignT3
		this.totalAssignT3 = totalAssignT3;
	}

	@Column(name="IP_CLASS",nullable=false)
	public String getIpClass() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClass
		return ipClass;
	}

	public void setIpClass(String ipClass) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClass
		this.ipClass = ipClass;
	}

	@Column(name="COMPANY_ID")
	public String getCompanyID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyID
		return companyID;
	}

	public void setCompanyID(String companyID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyID
		this.companyID = companyID;
	}
	
	@Column(name="GROUP_ID", unique=true, nullable=false, length=10)
	public String getGrpID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpID
		return grpID;
	}

	public void setGrpID(String grpID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpID
		this.grpID = grpID;
	}
	
	@Column(name="IP_VERSION",nullable=false)
	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}

	@Column(name="ST_IP_1")
	public String getStIP1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP1
		return stIP1;
	}

	public void setStIP1(String stIP1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP1
		this.stIP1 = stIP1;
	}

	@Column(name="ST_IP_2")
	public String getStIP2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP2
		return stIP2;
	}

	public void setStIP2(String stIP2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP2
		this.stIP2 = stIP2;
	}

	@Column(name="ST_IP_3")
	public String getStIP3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP3
		return stIP3;
	}

	public void setStIP3(String stIP3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP3
		this.stIP3 = stIP3;
	}

	@Column(name="ST_IP_4")
	public String getStIP4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP4
		return stIP4;
	}

	public void setStIP4(String stIP4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP4
		this.stIP4 = stIP4;
	}

	@Column(name="ST_IP_5")
	public String getStIP5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP5
		return stIP5;
	}

	public void setStIP5(String stIP5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP5
		this.stIP5 = stIP5;
	}

	@Column(name="ST_IP_6")
	public String getStIP6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP6
		return stIP6;
	}

	public void setStIP6(String stIP6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP6
		this.stIP6 = stIP6;
	}

	@Column(name="ED_IP_1")
	public String getEdIP1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIP1
		return edIP1;
	}

	public void setEdIP1(String edIP1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIP1
		this.edIP1 = edIP1;
	}

	@Column(name="ED_IP_2")
	public String getEdIP2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIP2
		return edIP2;
	}

	public void setEdIP2(String edIP2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIP2
		this.edIP2 = edIP2;
	}

	@Column(name="ED_IP_3")
	public String getEdIP3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIP3
		return edIP3;
	}

	public void setEdIP3(String edIP3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIP3
		this.edIP3 = edIP3;
	}

	@Column(name="ED_IP_4")
	public String getEdIP4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIP4
		return edIP4;
	}

	public void setEdIP4(String edIP4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIP4
		this.edIP4 = edIP4;
	}

	@Column(name="ED_IP_5")
	public String getEdIP5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIP5
		return edIP5;
	}

	public void setEdIP5(String edIP5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIP5
		this.edIP5 = edIP5;
	}
	
	@Column(name="ED_IP_6")
	public String getEdIP6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEdIP6
		return edIP6;
	}

	public void setEdIP6(String edIP6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEdIP6
		this.edIP6 = edIP6;
	}

	@Column(name="GROUP_IP_ST")
	public String getGrpIPST() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpIPST
		return grpIPST;
	}

	public void setGrpIPST(String grpIPST) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpIPST
		this.grpIPST = grpIPST;
	}
	
	@Column(name="GROUP_DESC")
	public String getGrpDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpDesc
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpDesc
		this.grpDesc = grpDesc;
	}
	@Column(name="TIER1_ID")
	public String getTire1ID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTire1ID
		return tire1ID;
	}

	public void setTire1ID(String tire1id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTire1ID
		tire1ID = tire1id;
	}
	@Column(name="TIER1_TEAM_ID")
	public String getTire1TeamID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTire1TeamID
		return tire1TeamID;
	}

	public void setTire1TeamID(String tire1TeamID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTire1TeamID
		this.tire1TeamID = tire1TeamID;
	}
	
	@Column(name="GROUP_IP_ED")
	public String getGrpIPED() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpIPED
		return grpIPED;
	}

	public void setGrpIPED(String grpIPED) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpIPED
		this.grpIPED = grpIPED;
	}

	@Column(name="VERSION")
	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}

	@Column(name="ACTIVE_STATUS")
	public String getIsActive() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsActive
		return isActive;
	}

	public void setIsActive(String isActive) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsActive
		this.isActive = isActive;
	}
	@Column(name="TOTAL_IP")
	public Integer getTotalIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalIP
		return totalIP;
	}

	public void setTotalIP(Integer totalIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalIP
		this.totalIP = totalIP;
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
	

}
