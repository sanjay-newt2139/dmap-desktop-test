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
@Table(name="IP_USER_GROUP", schema="IPFMBK")
public class IPUserGroup extends MasterDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4336958397136394877L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	/**
	 * 
	 */
	private String rowId; 
	private Integer version;
	private String userGroupId; 
	private String userGroupName;
	private String isActive;


	
	
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

	@Version
	@Column(name="VERSION")
	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}
	
	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}
	
	@Column(name="USER_GROUP_ID")
	public String getUserGroupId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserGroupId
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserGroupId
		this.userGroupId = userGroupId;
	}
	
	@Column(name="USER_GROUP_NAME")
	public String getUserGroupName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserGroupName
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserGroupName
		this.userGroupName = userGroupName;
	}
	
	@Column(name="IS_ACTIVE")
	public String getIsActive() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsActive
		return isActive;
	}

	public void setIsActive(String isActive) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsActive
		this.isActive = isActive;
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
