package th.co.ais.ipfm.domain1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

@Entity
@Table(name="IPV_JOB_ASSIGN"
)
public class IpvJobAssign {
	@Id 
	@Column(name="ROW_ID", unique=true, length=50)
	private String rowId; 
	
	@Temporal(TemporalType.DATE)
    @Column(name="CREATE_DATE", length=10)
	private Date createDate; 
	
	@Column(name="ACTION_NAME", unique=true, length=1000)
	private String actionName;
	
	@Column(name="ACTION_USER", unique=true, length=1000)
	private String actionUser;
	
	@Column(name="ACTION_REMARK", unique=true, length=1000)
	private String actionRemark; 
	
	@Column(name="UR_NO", unique=true, length=30)
	private String urNo; 
	
	@Column(name="SUB_UR_NO", unique=true, length=10)
	private String subUrNo;
	
	@Column(name="UR_STATUS")
	private String urStatus;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionRemark() {
		return actionRemark;
	}

	public void setActionRemark(String actionRemark) {
		this.actionRemark = actionRemark;
	}

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getSubUrNo() {
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) {
		this.subUrNo = subUrNo;
	}

	public String getActionUser() {
		return actionUser;
	}

	public void setActionUser(String actionUser) {
		this.actionUser = actionUser;
	}

	public String getUrStatus() {
		return urStatus;
	}

	public void setUrStatus(String urStatus) {
		this.urStatus = urStatus;
	}


	
}
