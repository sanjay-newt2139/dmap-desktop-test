package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "IPV_TODO_REQNC")
public class IpvTodoReqnc implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private Date waitingPm;
	
	@Column(name = "TITLE1", length = 100)
	private String title1;

	@Column(name = "TITLE2_UR", length = 100)
	private String title2Ur;

	@Column(name = "TITLE2_SUB_UR", length = 100)
	private String title2SubUr;

	@Column(name = "COL_CODE")
	private String colCode;

	@Column(name = "SLA_STS")
	private Integer slaSts;

	@Column(name = "OLA_STS")
	private Integer olaSts;

	@Column(name = "UR_NO")
	private String urNo;

	@Column(name = "UR_TYPE")
	private String urType;

	@Column(name = "SUB_UR_NO")
	private String subUrNo;

	@Column(name = "SUB_UR_TYPE")
	private String subUrType;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "ACTION_SEQ")
	private String actionSeq;

	@Column(name = "REQ_USER_ID")
	private String reqUserId;

	@Column(name = "REQ_USER")
	private String reqUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REQ_DATE")
	private Date reqDate;

	@Column(name = "ACTION_USER_ID")
	private String actionUserId;

	@Column(name = "ACTION_USER")
	private String actionUser;

	@Column(name = "ACTION_NAME")
	private String actionName;

	@Column(name = "UR_STATUS")
	private String urStatus;

	@Column(name = "ACTION_REMARK")
	private String actionRemark;

	@Column(name = "USER_REMARK")
	private String userRemark;

	@Temporal(TemporalType.DATE)
	@Column(name = "OLA_DATE")
	private Date olaDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "SLA_DATE")
	private Date slaDate;

	@Column(name = "CALL_FUNCTION_ID")
	private String callFunctionId;

	@Column(name = "CALL_MODE")
	private String callMode;

	@Column(name = "CREATE_USER_NAME")
	private String createUserName;
	
	@Column(name="CREATE_BY")
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
 	@Column(name="CREATE_DATE")
	private Date created;
 	
 	@Column(name="UPDATE_BY")
	private String lastUpdBy;
 	
 	@Temporal(TemporalType.TIMESTAMP)
 	@Column(name="UPDATE_DATE")
	private Date lastUpd;
	
	@Id 
	@Column(name="ROW_ID", unique=true, length=50)
    private String rowId;
	
	public String getTitle1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle1
		return title1;
	}

	public void setTitle1(String title1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle1
		this.title1 = title1;
	}

	public String getTitle2Ur() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle2Ur
		return title2Ur;
	}

	public void setTitle2Ur(String title2Ur) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle2Ur
		this.title2Ur = title2Ur;
	}

	public String getTitle2SubUr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle2SubUr
		return title2SubUr;
	}

	public void setTitle2SubUr(String title2SubUr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle2SubUr
		this.title2SubUr = title2SubUr;
	}

	public String getColCode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getColCode
		return colCode;
	}

	public void setColCode(String colCode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setColCode
		this.colCode = colCode;
	}

	public Integer getSlaSts() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSlaSts
		return slaSts;
	}

	public void setSlaSts(Integer slaSts) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSlaSts
		this.slaSts = slaSts;
	}

	public Integer getOlaSts() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOlaSts
		return olaSts;
	}

	public void setOlaSts(Integer olaSts) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOlaSts
		this.olaSts = olaSts;
	}

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
		return urType;
	}

	public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
		this.urType = urType;
	}

	public String getSubUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrNo
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrNo
		this.subUrNo = subUrNo;
	}

	public String getSubUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrType
		return subUrType;
	}

	public void setSubUrType(String subUrType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrType
		this.subUrType = subUrType;
	}
	
	public String getSubject01Desc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubject01Desc
		String str = getSubject()==null?"":getSubject();
		int j = 1;
		for (int i=100 ; i<str.trim().length() ; i=i+100) {
			if (str.length() > i) {
				str = str.substring(0,i) + "<br>" + str.substring(i);
				j++;
			}else{
				break;
			}
		}
		return str;
	}
	public String getSubject01SubStr(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubject01SubStr
		String str = getSubject()==null?"":getSubject();
		if (getSubject()!=null && str.trim().length()>0) 
			if(getSubject().trim().length()>35) str = getSubject().substring(0,35)+"...";
			else str = getSubject();
		return str;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubject
		this.subject = subject;
	}

	public String getActionSeq() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionSeq
		return actionSeq;
	}

	public void setActionSeq(String actionSeq) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionSeq
		this.actionSeq = actionSeq;
	}

	public String getReqUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqUserId
		return reqUserId;
	}

	public void setReqUserId(String reqUserId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqUserId
		this.reqUserId = reqUserId;
	}

	public String getReqUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqUser
		return reqUser;
	}

	public void setReqUser(String reqUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqUser
		this.reqUser = reqUser;
	}
	public String getReqDateStr(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDateStr
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("en","EN"));
		return dfm.format(getReqDate());
	}
	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqDate
		this.reqDate = reqDate;
	}

	public String getActionUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUserId
		return actionUserId;
	}

	public void setActionUserId(String actionUserId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionUserId
		this.actionUserId = actionUserId;
	}
	public String getActionUserDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUserDesc
		String str="";
		if (actionUser!=null && actionUser.trim().length()>0){
			if (actionUser.lastIndexOf(";")==actionUser.trim().length()-1){
				str = actionUser.substring(0, actionUser.length()-1).replaceAll(";", ", <BR>");
			}else{
				str = actionUser.replaceAll(";", ", <BR>");
			}
		}
		return str;
	}
	
	public String getActionUserDescDisply() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUserDescDisply
		String str="";
		String strDisply="";
		if (actionUser!=null && actionUser.trim().length()>0){
			if (actionUser.lastIndexOf(";")==actionUser.trim().length()-1){
				str = actionUser.substring(0, actionUser.length()-1).replaceAll(";", ",");
			}else{
				str = actionUser.replaceAll(";", ",");
			}
		}
		String strSub[] = str.split(",");
		if(strSub.length>=3){
		 strDisply = strSub[0]+","+strSub[1]+","+strSub[2];
		}else{
			strDisply = str;
		}
		return strDisply;
	}
	
	public String getActionUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUser
		return actionUser;
	}

	public void setActionUser(String actionUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionUser
		this.actionUser = actionUser;
	}

	public String getActionName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionName
		return actionName;
	}

	public void setActionName(String actionName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionName
		this.actionName = actionName;
	}

	public String getUrStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatus
		return urStatus;
	}

	public void setUrStatus(String urStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatus
		this.urStatus = urStatus;
	}

	public String getActionRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionRemark
		return actionRemark;
	}

	public void setActionRemark(String actionRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionRemark
		this.actionRemark = actionRemark;
	}

	public String getUserRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserRemark
		return userRemark;
	}

	public void setUserRemark(String userRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserRemark
		this.userRemark = userRemark;
	}

	public Date getOlaDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOlaDate
		return olaDate;
	}

	public void setOlaDate(Date olaDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOlaDate
		this.olaDate = olaDate;
	}

	public Date getSlaDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSlaDate
		return slaDate;
	}

	public void setSlaDate(Date slaDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSlaDate
		this.slaDate = slaDate;
	}

	public String getCallFunctionId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCallFunctionId
		return callFunctionId;
	}

	public void setCallFunctionId(String callFunctionId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCallFunctionId
		this.callFunctionId = callFunctionId;
	}

	public String getCallMode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCallMode
		return callMode;
	}

	public void setCallMode(String callMode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCallMode
		this.callMode = callMode;
	}

	public String getCreateUserName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateUserName
		return createUserName;
	}

	public void setCreateUserName(String createUserName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateUserName
		this.createUserName = createUserName;
	}

	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		return createdBy;
	}

	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		this.createdBy = createdBy;
	}

	public String getCreatedStr(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedStr
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("en","EN"));
		return dfm.format(getCreated());
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreated
		this.created = created;
	}

	public String getLastUpdBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpdBy
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpdBy
		this.lastUpdBy = lastUpdBy;
	}

	public Date getLastUpd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpd
		return lastUpd;
	}

	public void setLastUpd(Date lastUpd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpd
		this.lastUpd = lastUpd;
	}

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}

	public Date getWaitingPm() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWaitingPm
		return waitingPm;
	}

	public void setWaitingPm(Date waitingPm) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWaitingPm
		this.waitingPm = waitingPm;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		IpvTodoReqnc another = (IpvTodoReqnc) super.clone();
		// ? take care of any deep copies to be made here
		return another;
	}

}
