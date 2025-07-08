package th.co.ais.ipfm.domain1;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.ipfm.domain.MasterDomain;

@Entity
@Table(name="IP_TEAM"
 , uniqueConstraints = @UniqueConstraint(columnNames="ROW_ID") 
)
public class IpTeam  extends MasterDomain implements java.io.Serializable,Cloneable {


  private String teamId;
  private Long version;
  private String teamName;
  private String teamDesc;
  private String tier2Team;
  private String pmRoleId;
  private String activeStatus;
  private String rowId;
  
  private BigDecimal totalMember;

 public IpTeam() {
 }

	
 public IpTeam(String teamId) {
     this.teamId = teamId;
 }
 public IpTeam(String teamId,String teamName) {
     this.teamId = teamId;
     this.teamName = teamName;
 }
 public IpTeam(String teamId, String teamName, String teamDesc, String tier2Team, String pmRoleId, String activeStatus, String createBy, Date createDate, String updateBy, Date updateDate, String rowId) {
    this.teamId = teamId;
    this.teamName = teamName;
    this.teamDesc = teamDesc;
    this.tier2Team = tier2Team;
    this.pmRoleId = pmRoleId;
    this.activeStatus = activeStatus;
    this.rowId = rowId;
 }

	 @Column(name="TEAM_ID", unique=true, nullable=false, length=20)
	 public String getTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamId
	     return this.teamId;
	 }
	 
	 public void setTeamId(String teamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamId
	     this.teamId = teamId;
	 }
	 @Version
	 @Column(name="VERSION", precision=10, scale=0)
	 public Long getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
	     return this.version;
	 }
	 
	 public void setVersion(Long version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
	     this.version = version;
	 }
	 
	 @Column(name="TEAM_NAME", length=50)
	 public String getTeamName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamName
	     return this.teamName;
	 }
	 
	 public void setTeamName(String teamName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamName
	     this.teamName = teamName;
	 }
	 
	 @Column(name="TEAM_DESC", length=1000)
	 public String getTeamDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamDesc
	     return this.teamDesc;
	 }
	 
	 public void setTeamDesc(String teamDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamDesc
	     this.teamDesc = teamDesc;
	 }
	 
	 @Column(name="TIER2_TEAM", length=1)
	 public String getTier2Team() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier2Team
	     return this.tier2Team;
	 }
	 
	 public void setTier2Team(String tier2Team) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTier2Team
	     this.tier2Team = tier2Team;
	 }
	 
	 @Column(name="PM_ROLE_ID", length=5)
	 public String getPmRoleId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPmRoleId
	     return this.pmRoleId;
	 }
	 
	 public void setPmRoleId(String pmRoleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPmRoleId
	     this.pmRoleId = pmRoleId;
	 }
	 
	 @Column(name="ACTIVE_STATUS", length=1)
	 public String getActiveStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActiveStatus
	     return this.activeStatus;
	 }
	 
	 public void setActiveStatus(String activeStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActiveStatus
	     this.activeStatus = activeStatus;
	 }
	 @Id 
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name="system-uuid", strategy = "uuid")
	 @Column(name="ROW_ID", unique=true, length=50)
	 public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
	     return this.rowId;
	 }
	 
	 public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
	     this.rowId = rowId;
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
	public BigDecimal getTotalMember() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalMember
		return totalMember;
	}

	public void setTotalMember(BigDecimal totalMember) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalMember
		this.totalMember = totalMember;
	}

	@Override
    public Object clone() throws CloneNotSupportedException
    {
		IpTeam another = (IpTeam) super.clone();
        return another;
    }
}



