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
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
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
    public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
        return this.rowId;
    }
    
    public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
        this.rowId = rowId;
    }
    
    @Version
    @Column(name="VERSION", precision=10, scale=0)
    public Long getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
        return this.version;
    }
    
    public void setVersion(Long version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
        this.version = version;
    }
    
    @Column(name="REF_TABLE", nullable=false, length=10)
    public String getRefTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefTable
        return this.refTable;
    }
    
    public void setRefTable(String refTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefTable
        this.refTable = refTable;
    }
    
    @Column(name="REF_KEY", nullable=false, length=30)
    public String getRefKey() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefKey
        return this.refKey;
    }
    
    public void setRefKey(String refKey) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefKey
        this.refKey = refKey;
    }
    
    @Column(name="REF_DESC", length=1000)
    public String getRefDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefDesc
        return this.refDesc;
    }
    
    public void setRefDesc(String refDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefDesc
        this.refDesc = refDesc;
    }
    
    @Column(name="SHORT_DESC", length=400)
    public String getShortDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShortDesc
        return this.shortDesc;
    }
    
    public void setShortDesc(String shortDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShortDesc
        this.shortDesc = shortDesc;
    }
    
    @Column(name="ACTIVE_STATUS", length=1)
    public String getActiveStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActiveStatus
        return this.activeStatus;
    }
    
    public void setActiveStatus(String activeStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActiveStatus
        this.activeStatus = activeStatus;
    }
    
    @Column(name="REF_TYPE", length=2)
    public String getRefType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefType
        return this.refType;
    }
    
    public void setRefType(String refType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefType
        this.refType = refType;
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
	
	@Column(name="OTHER")
	public String getOther() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOther
		return other;
	}

	public void setOther(String other) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOther
		this.other = other;
	}
	
	@Column(name="UDP")
	public String getUdp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUdp
		return udp;
	}

	public void setUdp(String udp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUdp
		this.udp = udp;
	}
	
	@Column(name="TCP")
	public String getTcp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTcp
		return tcp;
	}

	public void setTcp(String tcp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTcp
		this.tcp = tcp;
	}
	
	

}
