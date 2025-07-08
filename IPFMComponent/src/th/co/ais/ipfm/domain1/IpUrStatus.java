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

	public String getUrType() {
		return urType;
	}

	public void setUrType(String urType) {
		this.urType = urType;
	}

	public String getUrStatusId() {
		return urStatusId;
	}

	public void setUrStatusId(String urStatusId) {
		this.urStatusId = urStatusId;
	}

	public String getUrStatusName() {
		return urStatusName;
	}

	public void setUrStatusName(String urStatusName) {
		this.urStatusName = urStatusName;
	}

	public String getSubUrStatusId() {
		return subUrStatusId;
	}

	public void setSubUrStatusId(String subUrStatusId) {
		this.subUrStatusId = subUrStatusId;
	}

	public String getSubUrStatusName() {
		return subUrStatusName;
	}

	public void setSubUrStatusName(String subUrStatusName) {
		this.subUrStatusName = subUrStatusName;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public Date getLastUpd() {
		return lastUpd;
	}

	public void setLastUpd(Date lastUpd) {
		this.lastUpd = lastUpd;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	
}
