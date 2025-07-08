package th.co.ais.ipfm.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="IP_ROLE"
    ,schema="IPFMBK"
)
public class IPRole {
	@Id
	@Column(name="ROLE_ID", unique=true, nullable=false, length=10)
	private String roleId;
	
	@Column(name="ROLE_NAME", length=100)
	private String roleName;
	
	
	@Column(name="CREATE_BY", length=20)
	private String createBy;  
	
	@Temporal(TemporalType.DATE)
    @Column(name="CREATE_DATE", length=10)
	private Date createDate;
	
	@Column(name="UPDATE_BY", length=20)
	private String updateBy;  
	
	@Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DATE", length=10)
	private Date updateDate;
	
	@Column(name="ROW_ID", length=50)
	private String rowId; 
	
	@Version
    @Column(name="VERSION")
	Integer version;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.LAZY)
	List<IPRoleMember> memberCollection;

	

	public List<IPRoleMember> getMemberCollection() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMemberCollection
		return memberCollection;
	}

	public void setMemberCollection(List<IPRoleMember> memberCollection) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMemberCollection
		this.memberCollection = memberCollection;
	}

	public String getRoleId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleId
		return roleId;
	}

	public void setRoleId(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleId
		this.roleId = roleId;
	}

	public String getRoleName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleName
		return roleName;
	}

	public void setRoleName(String roleName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleName
		this.roleName = roleName;
	}

	public String getCreateBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateBy
		return createBy;
	}

	public void setCreateBy(String createBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateBy
		this.createBy = createBy;
	}

	public Date getCreateDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateDate
		return createDate;
	}

	public void setCreateDate(Date createDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateDate
		this.createDate = createDate;
	}

	public String getUpdateBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUpdateBy
		return updateBy;
	}

	public void setUpdateBy(String updateBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUpdateBy
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUpdateDate
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUpdateDate
		this.updateDate = updateDate;
	}

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}

	
}
