package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import th.co.ais.ipfm.domain.MasterDomain;
@Entity
@Table(name="IP_LOG_VERIFY") 
public class IpLogVerify extends MasterDomain implements Serializable,
		Cloneable {

	private String id;
	private String ipAddress;
	private String type;
	private String msg;
	private String username;
	
	@Id
	@Column(name="ROW_ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="IP")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name="TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="MSG")
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="CREATE_DATE")
	public Date getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public String getCreatedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public Date getLastUpd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public String getLastUpdBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public void setCreated(Date created) {
		// TODO Auto-generated method stub

	}

	@Transient
	public void setCreatedBy(String createdBy) {
		// TODO Auto-generated method stub

	}

	@Transient
	public void setLastUpd(Date lastUpd) {
		// TODO Auto-generated method stub

	}

	@Transient
	public void setLastUpdBy(String lastUpdBy) {
		// TODO Auto-generated method stub

	}

}
