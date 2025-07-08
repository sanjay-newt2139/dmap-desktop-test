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

	

	public List<IPRoleMember> getMemberCollection() {
		return memberCollection;
	}

	public void setMemberCollection(List<IPRoleMember> memberCollection) {
		this.memberCollection = memberCollection;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
}
