package th.co.ais.ipfm.domain1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import th.co.ais.ipfm.domain.MasterDomain;

@Entity
@Table(name="IP_ROLE"
)
public class IpRole extends MasterDomain implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	private String roleId;
	private String roleName;
	private String rowId; 
	private Integer version;
	private Integer priority;
	
//    private String userIdList;
//    private String userNameList;
	
	@Id
	@Column(name="ROLE_ID", unique=true, nullable=false, length=10)
	public String getRoleId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleId
		return roleId;
	}

	public void setRoleId(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleId
		this.roleId = roleId;
	}
	
	@Column(name="ROLE_NAME", length=100)
	public String getRoleName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleName
		return roleName;
	}

	public void setRoleName(String roleName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleName
		this.roleName = roleName;
	}
	@Column(name="ROW_ID", length=50)
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
	@Column(name="PRIORITY")
	public Integer getPriority() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPriority
		return priority;
	}

	public void setPriority(Integer priority) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPriority
		this.priority = priority;
	}
//    @Column(name="USER_ID_LIST")
//    public String getUserIdList() {
//		return userIdList;
//	}
//
//	public void setUserIdList(String userIdList) {
//		this.userIdList = userIdList;
//	}
//	
//	@Column(name="USER_NAME_LIST")
//	public String getUserNameList() {
//		return userNameList;
//	}
//
//	public void setUserNameList(String userNameList) {
//		this.userNameList = userNameList;
//	}
	
}
