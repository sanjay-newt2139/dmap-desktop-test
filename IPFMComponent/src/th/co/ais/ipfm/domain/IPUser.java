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
@Table(name="IP_USER", schema="IPFMBK")
public class IPUser extends MasterDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4336958397136394877L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	/**
	 * 
	 */
	private String userId;
	private String userName;
	private String section;
	private String dept;
	private String email;
	private String position;
	private String mobile;
	private String tel;
	private String groupIdListStr="GRP0000002";
	private String managerIdListStr;
	private String roleIdListStr="RL00000002";
	private String rowId;
	private String userTeamId;
	private Integer version;
	
	private Date effectiveDate;
	private Date expireDate;
	private Date lastLogin;
	
	@Column(name="LAST_LOGIN")
	public Date getLastLogin() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastLogin
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastLogin
		this.lastLogin = lastLogin;
	}

	@Column(name="EFFECTIVE_DATE")
	public Date getEffectiveDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEffectiveDate
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEffectiveDate
		this.effectiveDate = effectiveDate;
	}

	@Column(name="EXPIRE_DATE")
	public Date getExpireDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpireDate
		return expireDate;
	}

	public void setExpireDate(Date expireDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpireDate
		this.expireDate = expireDate;
	}

	@Column(name="USER_ID")
	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}
	
	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}
	
	@Column(name="USER_NAME")
	public String getUserName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserName
		return userName;
	}
	
	public void setUserName(String userName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserName
		this.userName = userName;
	}
	
	@Column(name="SECTION")
	public String getSection() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSection
		return section;
	}
	
	public void setSection(String section) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSection
		this.section = section;
	}
	
	@Column(name="DEPT")
	public String getDept() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDept
		return dept;
	}
	
	public void setDept(String dept) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDept
		this.dept = dept;
	}
	
	@Column(name="EMAIL")
	public String getEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEmail
		return email;
	}
	
	public void setEmail(String email) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEmail
		this.email = email;
	}
	
	@Column(name="POSITION")
	public String getPosition() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPosition
		return position;
	}
	
	public void setPosition(String position) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPosition
		this.position = position;
	}
	
	@Column(name="MOBILE")
	public String getMobile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMobile
		return mobile;
	}
	
	public void setMobile(String mobile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMobile
		this.mobile = mobile;
	}
	
	@Column(name="TEL")
	public String getTel() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTel
		return tel;
	}
	
	public void setTel(String tel) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTel
		this.tel = tel;
	}
	
	@Column(name="USER_GROUP_ID")
	public String getGroupIdListStr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupIdListStr
		return groupIdListStr;
	}
	
	public void setGroupIdListStr(String groupIdListStr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupIdListStr
		this.groupIdListStr = groupIdListStr;
	}
	
	@Column(name="MANAGER_ID_LIST")
	public String getManagerIdListStr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerIdListStr
		return managerIdListStr;
	}
	
	public void setManagerIdListStr(String managerIdListStr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setManagerIdListStr
		this.managerIdListStr = managerIdListStr;
	}
	
	@Column(name="ROLE_ID_LIST")
	public String getRoleIdListStr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleIdListStr
		return roleIdListStr;
	}
	
	public void setRoleIdListStr(String roleIdListStr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleIdListStr
		this.roleIdListStr = roleIdListStr;
	}
	
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
	
	@Column(name="USER_TEAM_ID")
	public String getUserTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserTeamId
		return userTeamId;
	}
	
	public void setUserTeamId(String userTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserTeamId
		this.userTeamId = userTeamId;
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
