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
	public String getId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getId
		return id;
	}

	public void setId(String id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setId
		this.id = id;
	}
	
	@Column(name="IP")
	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpAddress
		this.ipAddress = ipAddress;
	}

	@Column(name="TYPE")
	public String getType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getType
		return type;
	}

	public void setType(String type) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setType
		this.type = type;
	}
	
	@Column(name="MSG")
	public String getMsg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMsg
		return msg;
	}

	public void setMsg(String msg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMsg
		this.msg = msg;
	}

	@Column(name="USERNAME")
	public String getUsername() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUsername
		return username;
	}

	public void setUsername(String username) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUsername
		this.username = username;
	}

	@Column(name="CREATE_DATE")
	public Date getCreated() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreated
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public Date getLastUpd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpd
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public String getLastUpdBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpdBy
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public void setCreated(Date created) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreated
		// TODO Auto-generated method stub

	}

	@Transient
	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		// TODO Auto-generated method stub

	}

	@Transient
	public void setLastUpd(Date lastUpd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpd
		// TODO Auto-generated method stub

	}

	@Transient
	public void setLastUpdBy(String lastUpdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpdBy
		// TODO Auto-generated method stub

	}

}
