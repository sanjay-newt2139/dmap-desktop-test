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

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public Date getCreateDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateDate
		return createDate;
	}

	public void setCreateDate(Date createDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateDate
		this.createDate = createDate;
	}

	public String getActionName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionName
		return actionName;
	}

	public void setActionName(String actionName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionName
		this.actionName = actionName;
	}

	public String getActionRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionRemark
		return actionRemark;
	}

	public void setActionRemark(String actionRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionRemark
		this.actionRemark = actionRemark;
	}

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getSubUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrNo
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrNo
		this.subUrNo = subUrNo;
	}

	public String getActionUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUser
		return actionUser;
	}

	public void setActionUser(String actionUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionUser
		this.actionUser = actionUser;
	}

	public String getUrStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatus
		return urStatus;
	}

	public void setUrStatus(String urStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatus
		this.urStatus = urStatus;
	}


	
}
