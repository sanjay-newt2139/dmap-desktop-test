package th.co.ais.ipfm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="IP_GROUP_MEMBER" , schema="IPFMBK")
public class IPGroupMember {
	
	@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private IPGroup groupId;
	
	
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private IPUser userId;
	
	@Column(name="CREATE_BY", length=50)
	private String createBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE", length=10)
	private Date createDate;
	
	@Column(name="UPDATE_BY", length=50)
	private String updateBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE", length=10)
	private Date updateDate;
	
	@Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name="system-uuid", strategy = "uuid")
	 @Column(name="ROW_ID",nullable=false,length=50)
	private String rowId;
	
	@Column(name="VERSION", length=50)
	private Integer version;

	public IPGroup getGroupId() {
		return groupId;
	}

	public void setGroupId(IPGroup groupId) {
		this.groupId = groupId;
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

	public IPUser getUserId() {
		return userId;
	}

	public void setUserId(IPUser userId) {
		this.userId = userId;
	}
	
	
	
}




