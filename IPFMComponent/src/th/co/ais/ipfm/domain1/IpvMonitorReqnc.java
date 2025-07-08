package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IPV_MONITOR_REQNC")
public class IpvMonitorReqnc implements Serializable, Cloneable {
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
	
	@Column(name = "SUB_UR_NO")
	private String subUrNo;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "REQ_DATE")
	private Date reqDate;

	@Column(name = "SLA_DATE")
	private Date slaDate;

	@Column(name = "REQ_USER_ID")
	private String reqUserId;

	@Column(name = "UR_STATUS")
	private String urStatus;

	@Column(name = "UR_TYPE")
	private String urType;
	
	@Column(name = "CALL_FUNCTION_ID")
	private String callFunctionId;

	@Column(name = "CALL_MODE")
	private String callMode;
	
	@Column(name = "ACTION_USER_ID")
	private String actionUserId;
	
	@Column(name = "subUrType")
	private String subUrType;	

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

	public String getReqUserId() {
		return reqUserId;
	}

	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
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

	public String getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(String actionUserId) {
		this.actionUserId = actionUserId;
	}

	public String getSubUrNo() {
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) {
		this.subUrNo = subUrNo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		IpvMonitorReqnc another = (IpvMonitorReqnc) super.clone();
		// ? take care of any deep copies to be made here
		return another;
	}

}
