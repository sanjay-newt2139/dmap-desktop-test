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
@Table(name="IP_GROUP_MEMBER" , schema="IPFMBK")
public class IPGroupMembers extends MasterDomain implements Serializable  {
	
	
	private String  rowId;
	private String  groupId;
	private String  userId;
	private Integer  version;

	
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}
	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	
	@Column(name="GROUP_ID")
	public String getGroupId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupId
		return groupId;
	}
	public void setGroupId(String groupId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupId
		this.groupId = groupId;
	}

	@Column(name="USER_ID")
	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}
	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}
	
	
	@Version
	@Column(name="VERSION")
	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}
	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
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




