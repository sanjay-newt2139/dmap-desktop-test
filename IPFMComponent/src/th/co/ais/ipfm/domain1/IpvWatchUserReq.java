package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "IPV_WATCH_USERREQ")
public class IpvWatchUserReq implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROW_ID", unique = true, length = 50)
	private String rowId;

	@Column(name = "TITLE1", length = 100)
	private String title1;

	@Column(name = "SLA_STS")
	private Integer slaSts;

	@Column(name = "UR_NO")
	private String urNo;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "REQ_DATE")
	private Date reqDate;

	@Column(name = "SLA_DATE")
	private Date slaDate;

	@Column(name = "UR_STATUS")
	private String urStatus;

	@Column(name = "ACTION_USER")
	private String actionUser;

	@Column(name = "REQ_USER_ID")
	private String reqUserId;

	@Column(name = "REQ_USER")
	private String reqUser;

	@Column(name = "UR_TYPE")
	private String urType;
	
	@Column(name = "CALL_FUNCTION_ID")
	private String callFunctionId;

	@Column(name = "CALL_MODE")
	private String callMode;
	
	@Transient
	private int subStrLength = 28;
	@Transient
	private int rowMaxLength = 90;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public Integer getSlaSts() {
		return slaSts;
	}

	public void setSlaSts(Integer slaSts) {
		this.slaSts = slaSts;
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
			if(getSubject().trim().length()>subStrLength) str = getSubject().substring(0, subStrLength)+"...";
			else str = getSubject();
		return str;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public Date getSlaDate() {
		return slaDate;
	}

	public void setSlaDate(Date slaDate) {
		this.slaDate = slaDate;
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

	@Override
	public Object clone() throws CloneNotSupportedException {
		IpvWatchUserReq another = (IpvWatchUserReq) super.clone();
		// ? take care of any deep copies to be made here
		return another;
	}

}
