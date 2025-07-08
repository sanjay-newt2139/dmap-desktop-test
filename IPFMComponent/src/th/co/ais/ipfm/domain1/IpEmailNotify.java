package th.co.ais.ipfm.domain1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="IP_EMAIL_NOTIFY"
    , uniqueConstraints = @UniqueConstraint(columnNames="ROW_ID") 
)
public class IpEmailNotify implements java.io.Serializable , Cloneable{
    @Column(name="USER_ID", length=20)
    private String userId;
	
	@Column(name="UR_NO", length=20)
	private String urNo; 
	
	@Column(name="UR_STATUS", length=20)
	private String urStatus; 
	
	@Column(name="EMAIL_LINK_STATUS", length=1)
	private String emailLinkStatus; 
	
	@Column(name="EMAIL_CODE", length=100)
	private String emailCode; 
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="ROW_ID", unique=true, length=50)
	private String rowId;
	
	@Column(name="CREATE_BY")
	private String createdBy;
	
    @Column(name="CREATE_DATE", length=10)
	private Date created;
	
	@Column(name="UPDATE_BY")
	private String lastUpdBy;
	
    @Column(name="UPDATE_DATE", length=10)
	private Date lastUpd;

    @Version
	@Column(name="VERSION")
    private Integer version;
    
	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}
	
	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}
	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}

	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getUrStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatus
		return urStatus;
	}

	public void setUrStatus(String urStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatus
		this.urStatus = urStatus;
	}

	public String getEmailLinkStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEmailLinkStatus
		return emailLinkStatus;
	}

	public void setEmailLinkStatus(String emailLinkStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEmailLinkStatus
		this.emailLinkStatus = emailLinkStatus;
	}

	public String getEmailCode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEmailCode
		return emailCode;
	}

	public void setEmailCode(String emailCode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEmailCode
		this.emailCode = emailCode;
	}

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
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
	@Override
    public Object clone() throws CloneNotSupportedException{
		IpEmailNotify another = (IpEmailNotify) super.clone();
        return another;
    }


}
