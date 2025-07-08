package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IPV_TODO_PLANNINGREQ")
public class IpvTodoPlanningReq implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "TITLE1", length = 100)
	private String title1;

	@Column(name = "TITLE2", length = 100)
	private String title2;
	
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

	@Column(name = "OLA_DATE")
	private Date olaDate;

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

	public String getColCode() {
		return colCode;
	}

	public void setColCode(String colCode) {
		this.colCode = colCode;
	}

	public Integer getSlaSts() {
		return slaSts;
	}

	public void setSlaSts(Integer slaSts) {
		this.slaSts = slaSts;
	}

	public Integer getOlaSts() {
		return olaSts;
	}

	public void setOlaSts(Integer olaSts) {
		this.olaSts = olaSts;
	}

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getUrType() {
		return urType;
	}

	public void setUrType(String urType) {
		this.urType = urType;
	}

	public String getSubUrNo() {
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) {
		this.subUrNo = subUrNo;
	}

	public String getSubUrType() {
		return subUrType;
	}

	public void setSubUrType(String subUrType) {
		this.subUrType = subUrType;
	}
	public String getSubject01Desc() {
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
	public String getSubject01SubStr(){
		String str = getSubject()==null?"":getSubject();
		if (getSubject()!=null && str.trim().length()>0) 
			if(getSubject().trim().length()>100) str = getSubject().substring(0, 100)+"...";
			else str = getSubject();
		return str;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getActionSeq() {
		return actionSeq;
	}

	public void setActionSeq(String actionSeq) {
		this.actionSeq = actionSeq;
	}

	public String getReqUserId() {
		return reqUserId;
	}

	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}

	public String getReqUser() {
		return reqUser;
	}

	public void setReqUser(String reqUser) {
		this.reqUser = reqUser;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

    public String getActionUserSubstr() {
		String str="";
		if (getActionUserDesc()!=null && getActionUserDesc().trim().length()>0) 
			if(getActionUserDesc().trim().length()>30) str = getActionUserDesc().substring(0, 30)+"...";
			else str = getActionUserDesc();
		return str;
	}
	public String getActionUserDesc() {
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

	public String getActionUserDescDisply() {
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
	
	public String getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(String actionUserId) {
		this.actionUserId = actionUserId;
	}

	public String getActionUser() {
		return actionUser;
	}

	public void setActionUser(String actionUser) {
		this.actionUser = actionUser;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getUrStatus() {
		return urStatus;
	}

	public void setUrStatus(String urStatus) {
		this.urStatus = urStatus;
	}

	public String getActionRemark() {
		return actionRemark;
	}

	public void setActionRemark(String actionRemark) {
		this.actionRemark = actionRemark;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public Date getOlaDate() {
		return olaDate;
	}

	public void setOlaDate(Date olaDate) {
		this.olaDate = olaDate;
	}

	public Date getSlaDate() {
		return slaDate;
	}

	public void setSlaDate(Date slaDate) {
		this.slaDate = slaDate;
	}

	public String getCallFunctionId() {
		return callFunctionId;
	}

	public void setCallFunctionId(String callFunctionId) {
		this.callFunctionId = callFunctionId;
	}

	public String getCallMode() {
		return callMode;
	}

	public void setCallMode(String callMode) {
		this.callMode = callMode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public Date getLastUpd() {
		return lastUpd;
	}

	public void setLastUpd(Date lastUpd) {
		this.lastUpd = lastUpd;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		IpvTodoPlanningReq another = (IpvTodoPlanningReq) super.clone();
		// ? take care of any deep copies to be made here
		return another;
	}

}
