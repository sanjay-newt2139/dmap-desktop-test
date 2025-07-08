package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name="IP_MASTER_TABLE",schema="IPFMBK")
public class MasterTBL extends MasterDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String rowId;
    private Long version;
    private String refTable;
    private String refKey;
    private String refDesc;
    private String shortDesc;
    private String activeStatus;
    private String refType;
    private String other;
    private String udp;
    private String tcp;
		

    @Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="ROW_ID", unique=true, nullable=false, length=50)
    public String getRowId() {
        return this.rowId;
    }
    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    
    @Version
    @Column(name="VERSION", precision=10, scale=0)
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Column(name="REF_TABLE", nullable=false, length=10)
    public String getRefTable() {
        return this.refTable;
    }
    
    public void setRefTable(String refTable) {
        this.refTable = refTable;
    }
    
    @Column(name="REF_KEY", nullable=false, length=30)
    public String getRefKey() {
        return this.refKey;
    }
    
    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }
    
    @Column(name="REF_DESC", length=1000)
    public String getRefDesc() {
        return this.refDesc;
    }
    
    public void setRefDesc(String refDesc) {
        this.refDesc = refDesc;
    }
    
    @Column(name="SHORT_DESC", length=400)
    public String getShortDesc() {
        return this.shortDesc;
    }
    
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
    
    @Column(name="ACTIVE_STATUS", length=1)
    public String getActiveStatus() {
        return this.activeStatus;
    }
    
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
    
    @Column(name="REF_TYPE", length=2)
    public String getRefType() {
        return this.refType;
    }
    
    public void setRefType(String refType) {
        this.refType = refType;
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
	
	@Column(name="OTHER")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	@Column(name="UDP")
	public String getUdp() {
		return udp;
	}

	public void setUdp(String udp) {
		this.udp = udp;
	}
	
	@Column(name="TCP")
	public String getTcp() {
		return tcp;
	}

	public void setTcp(String tcp) {
		this.tcp = tcp;
	}
	
	

}
