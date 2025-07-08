package th.co.ais.ipfm.domain1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name="IP_UR_STATUS" 
    , uniqueConstraints = @UniqueConstraint(columnNames="ROW_ID") 
)
public class IpUrStatus implements java.io.Serializable {
	
	@Column(name="UR_TYPE", length=5)
	private String urType; 
	
	@Column(name="UR_STATUS_ID", length=20)
	private String urStatusId; 
	
	@Column(name="UR_STATUS_NAME", length=100)
	private String urStatusName; 
	
	@Column(name="SUB_UR_STATUS_ID", length=20)
	private String subUrStatusId; 
	
	@Column(name="SUB_UR_STATUS_NAME", length=100)
	private String subUrStatusName; 
	
	@Column(name="ACTIVE")
	private String active;
	
	@Id
	@Column(name="ROW_ID", unique=true, length=50)
    private String rowId;
    
    @Version
    @Column(name="VERSION", precision=10, scale=0)
    private Long version;
    
    @Column(name="CREATE_BY")
	private String createdBy;
	
	@Temporal(TemporalType.DATE)
    @Column(name="CREATE_DATE", length=10)
	private Date created;
	
	@Column(name="UPDATE_BY")
	private String lastUpdBy;
	
	@Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DATE", length=10)
	private Date lastUpd;

	public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
		return urType;
	}

	public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
		this.urType = urType;
	}

	public String getUrStatusId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusId
		return urStatusId;
	}

	public void setUrStatusId(String urStatusId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatusId
		this.urStatusId = urStatusId;
	}

	public String getUrStatusName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusName
		return urStatusName;
	}

	public void setUrStatusName(String urStatusName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatusName
		this.urStatusName = urStatusName;
	}

	public String getSubUrStatusId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrStatusId
		return subUrStatusId;
	}

	public void setSubUrStatusId(String subUrStatusId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrStatusId
		this.subUrStatusId = subUrStatusId;
	}

	public String getSubUrStatusName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrStatusName
		return subUrStatusName;
	}

	public void setSubUrStatusName(String subUrStatusName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrStatusName
		this.subUrStatusName = subUrStatusName;
	}

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public Long getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(Long version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}

	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		return createdBy;
	}

	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		this.createdBy = createdBy;
	}

	public Date getCreated() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreated
		return created;
	}

	public void setCreated(Date created) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreated
		this.created = created;
	}

	public String getLastUpdBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpdBy
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpdBy
		this.lastUpdBy = lastUpdBy;
	}

	public Date getLastUpd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpd
		return lastUpd;
	}

	public void setLastUpd(Date lastUpd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpd
		this.lastUpd = lastUpd;
	}

	public String getActive() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActive
		return active;
	}

	public void setActive(String active) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActive
		this.active = active;
	}

	
}
