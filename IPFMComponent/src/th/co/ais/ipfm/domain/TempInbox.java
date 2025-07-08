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
	private static final long serialVersionUID = 1L;

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
	
	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	public Integer getOldDiffDay() {
		return oldDiffDay;
	}

	public void setOldDiffDay(Integer oldDiffDay) {
		this.oldDiffDay = oldDiffDay;
	}

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getReqSubject() {
		return reqSubject;
	}

	public void setReqSubject(String reqSubject) {
		this.reqSubject = reqSubject;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public List<TempInbox> getTitle2List() {
		return title2List;
	}

	public void setTitle2List(List<TempInbox> title2List) {
		this.title2List = title2List;
	}

	public List<TempInbox> getTitle3List() {
		return title3List;
	}

	public void setTitle3List(List<TempInbox> title3List) {
		this.title3List = title3List;
	}

	public List<TempInbox> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<TempInbox> detailList) {
		this.detailList = detailList;
	}
	
	public String getSlaSts() {
		return slaSts;
	}

	public void setSlaSts(String slaSts) {
		this.slaSts = slaSts;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectBy() {
		return rejectBy;
	}

	public void setRejectBy(String rejectBy) {
		this.rejectBy = rejectBy;
	}

	public String getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(String rejectDate) {
		this.rejectDate = rejectDate;
	}

	public String getPlanFinish() {
		return planFinish;
	}

	public void setPlanFinish(String planFinish) {
		this.planFinish = planFinish;
	}

	public String getActionUser() {
		return actionUser;
	}

	public void setActionUser(String actionUser) {
		this.actionUser = actionUser;
	}

	public String getPmRaise() {
		return pmRaise;
	}

	public void setPmRaise(String pmRaise) {
		this.pmRaise = pmRaise;
	}

	public String getSubUrNo() {
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) {
		this.subUrNo = subUrNo;
	}

	public String getPmAssign() {
		return pmAssign;
	}

	public void setPmAssign(String pmAssign) {
		this.pmAssign = pmAssign;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
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





















