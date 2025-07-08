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
	private static final long serialVersionUID = 4336958397136394877L;
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
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name="EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Column(name="EXPIRE_DATE")
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name="USER_ID")
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="SECTION")
	public String getSection() {
		return section;
	}
	
	public void setSection(String section) {
		this.section = section;
	}
	
	@Column(name="DEPT")
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="POSITION")
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Column(name="MOBILE")
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name="TEL")
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name="USER_GROUP_ID")
	public String getGroupIdListStr() {
		return groupIdListStr;
	}
	
	public void setGroupIdListStr(String groupIdListStr) {
		this.groupIdListStr = groupIdListStr;
	}
	
	@Column(name="MANAGER_ID_LIST")
	public String getManagerIdListStr() {
		return managerIdListStr;
	}
	
	public void setManagerIdListStr(String managerIdListStr) {
		this.managerIdListStr = managerIdListStr;
	}
	
	@Column(name="ROLE_ID_LIST")
	public String getRoleIdListStr() {
		return roleIdListStr;
	}
	
	public void setRoleIdListStr(String roleIdListStr) {
		this.roleIdListStr = roleIdListStr;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowId() {
		return rowId;
	}
	
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name="USER_TEAM_ID")
	public String getUserTeamId() {
		return userTeamId;
	}
	
	public void setUserTeamId(String userTeamId) {
		this.userTeamId = userTeamId;
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

}
