package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TEMP_INBOX"
    ,schema="IPFMBK"
)
public class TempInbox implements Serializable ,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	@Column(name="TITLE1", length=100)
	private String title1;
	
	@Column(name="TITLE2", length=100)
	private String title2;
	
	@Column(name="TITLE3", length=100)
	private String title3;
	
	@Column(name="OLD_DIFF_DAY")
	private Integer oldDiffDay;
	
	@Column(name="UR_NO", length=30)
	private String urNo;
	
	@Column(name="REQ_SUBJECT", length=100)
	private String reqSubject;
	
	@Column(name="REQ_NAME", length=100)
	private String reqName;
	
	@Column(name="REQ_DATE")
	private Date reqDate;
	
	@Column(name="RECEIVE_DATE")
	private Date receiveDate;
	
	@Column(name="USERID", length=20)
	private String userId;
	
	@Column(name="SEQ", length=255)
	private Integer seq;
	
	@Column(name="SLA_STS")
	private String slaSts;
	
	@Column(name="CREATE_DATE")
	private String createDate;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="REJECT_By")
	private String rejectBy;
	
	@Column(name="REJECT_DATE")
	private String rejectDate;
	
	@Column(name="ACTION_USER")
	private String actionUser;
	
	@Column(name="PLAN_FINISH")
	private String planFinish;
	
	@Column(name="PM_RAISE")
	private String pmRaise;
	
	@Column(name="SUBURNO")
	private String subUrNo;
	
	@Column(name="PMASSIGN")
	private String pmAssign;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false)
	private Integer rowId;
	
	@CollectionOfElements
	private List<TempInbox> title2List = new ArrayList<TempInbox>();
	
	@CollectionOfElements
	private List<TempInbox> title3List = new ArrayList<TempInbox>();
	
	@CollectionOfElements
	private List<TempInbox> detailList = new ArrayList<TempInbox>();
	
	public Integer getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(Integer rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public String getTitle1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle1
		return title1;
	}

	public void setTitle1(String title1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle1
		this.title1 = title1;
	}

	public String getTitle2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle2
		return title2;
	}

	public void setTitle2(String title2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle2
		this.title2 = title2;
	}

	public String getTitle3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle3
		return title3;
	}

	public void setTitle3(String title3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle3
		this.title3 = title3;
	}

	public Integer getOldDiffDay() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOldDiffDay
		return oldDiffDay;
	}

	public void setOldDiffDay(Integer oldDiffDay) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOldDiffDay
		this.oldDiffDay = oldDiffDay;
	}

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getReqSubject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqSubject
		return reqSubject;
	}

	public void setReqSubject(String reqSubject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqSubject
		this.reqSubject = reqSubject;
	}

	public String getReqName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqName
		return reqName;
	}

	public void setReqName(String reqName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqName
		this.reqName = reqName;
	}

	public Date getReqDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDate
		return reqDate;
	}

	public void setReqDate(Date reqDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqDate
		this.reqDate = reqDate;
	}

	public Date getReceiveDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReceiveDate
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReceiveDate
		this.receiveDate = receiveDate;
	}

	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}

	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}

	public Integer getSeq() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSeq
		return seq;
	}

	public void setSeq(Integer seq) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSeq
		this.seq = seq;
	}

	public List<TempInbox> getTitle2List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle2List
		return title2List;
	}

	public void setTitle2List(List<TempInbox> title2List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle2List
		this.title2List = title2List;
	}

	public List<TempInbox> getTitle3List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle3List
		return title3List;
	}

	public void setTitle3List(List<TempInbox> title3List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle3List
		this.title3List = title3List;
	}

	public List<TempInbox> getDetailList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDetailList
		return detailList;
	}

	public void setDetailList(List<TempInbox> detailList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDetailList
		this.detailList = detailList;
	}
	
	public String getSlaSts() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSlaSts
		return slaSts;
	}

	public void setSlaSts(String slaSts) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSlaSts
		this.slaSts = slaSts;
	}

	public String getCreateDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateDate
		return createDate;
	}

	public void setCreateDate(String createDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateDate
		this.createDate = createDate;
	}

	public String getStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatus
		return status;
	}

	public void setStatus(String status) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatus
		this.status = status;
	}

	public String getRejectBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRejectBy
		return rejectBy;
	}

	public void setRejectBy(String rejectBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRejectBy
		this.rejectBy = rejectBy;
	}

	public String getRejectDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRejectDate
		return rejectDate;
	}

	public void setRejectDate(String rejectDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRejectDate
		this.rejectDate = rejectDate;
	}

	public String getPlanFinish() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPlanFinish
		return planFinish;
	}

	public void setPlanFinish(String planFinish) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPlanFinish
		this.planFinish = planFinish;
	}

	public String getActionUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUser
		return actionUser;
	}

	public void setActionUser(String actionUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionUser
		this.actionUser = actionUser;
	}

	public String getPmRaise() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPmRaise
		return pmRaise;
	}

	public void setPmRaise(String pmRaise) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPmRaise
		this.pmRaise = pmRaise;
	}

	public String getSubUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrNo
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrNo
		this.subUrNo = subUrNo;
	}

	public String getPmAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPmAssign
		return pmAssign;
	}

	public void setPmAssign(String pmAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPmAssign
		this.pmAssign = pmAssign;
	}

	public String getRemarks() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRemarks
		return remarks;
	}

	public void setRemarks(String remarks) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRemarks
		this.remarks = remarks;
	}

	@Override
    public Object clone() throws CloneNotSupportedException
    {
		TempInbox another = (TempInbox) super.clone();
        //? take care of any deep copies to be made here
        return another;
    }
	
}





















