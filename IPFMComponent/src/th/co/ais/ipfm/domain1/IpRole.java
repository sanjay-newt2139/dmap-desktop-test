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
	private static final long serialVersionUID = 1L;

	private String roleId;
	private String roleName;
	private String rowId; 
	private Integer version;
	private Integer priority;
	
//    private String userIdList;
//    private String userNameList;
	
	@Id
	@Column(name="ROLE_ID", unique=true, nullable=false, length=10)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	@Column(name="ROLE_NAME", length=100)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name="ROW_ID", length=50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Version
    @Column(name="VERSION")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
	@Column(name="PRIORITY")
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
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
