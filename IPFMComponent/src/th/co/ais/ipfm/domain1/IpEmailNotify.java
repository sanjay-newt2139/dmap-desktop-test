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
    
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getUrStatus() {
		return urStatus;
	}

	public void setUrStatus(String urStatus) {
		this.urStatus = urStatus;
	}

	public String getEmailLinkStatus() {
		return emailLinkStatus;
	}

	public void setEmailLinkStatus(String emailLinkStatus) {
		this.emailLinkStatus = emailLinkStatus;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	@Override
    public Object clone() throws CloneNotSupportedException{
		IpEmailNotify another = (IpEmailNotify) super.clone();
        return another;
    }


}
