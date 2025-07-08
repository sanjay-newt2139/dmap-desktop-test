package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "IPV_WATCH_REQNC")
public class IpvWatchReqnc implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

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

	@Temporal(TemporalType.TIMESTAMP)
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
	
	@Transient
	private int subStrLength = 38;
	@Transient
	private int rowMaxLength = 90; // DMAP Comment : Dead Code Detected - The Following Field has no reference rowMaxLength

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public String getTitle1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle1
		return title1;
	}

	public void setTitle1(String title1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle1
		this.title1 = title1;
	}

	public Integer getSlaSts() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSlaSts
		return slaSts;
	}

	public void setSlaSts(Integer slaSts) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSlaSts
		this.slaSts = slaSts;
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
			if(getSubject().trim().length()>subStrLength) str = getSubject().substring(0, subStrLength)+"...";
			else str = getSubject();
		return str;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubject
		this.subject = subject;
	}

	public String getReqUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqUserId
		return reqUserId;
	}

	public void setReqUserId(String reqUserId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqUserId
		this.reqUserId = reqUserId;
	}

	public Date getReqDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDate
		return reqDate;
	}

	public void setReqDate(Date reqDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqDate
		this.reqDate = reqDate;
	}

	public Date getSlaDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSlaDate
		return slaDate;
	}

	public void setSlaDate(Date slaDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSlaDate
		this.slaDate = slaDate;
	}

	public String getUrStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatus
		return urStatus;
	}

	public void setUrStatus(String urStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatus
		this.urStatus = urStatus;
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

	public String getSubUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrNo
		return subUrNo;
	}

	public void setSubUrNo(String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrNo
		this.subUrNo = subUrNo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		IpvWatchReqnc another = (IpvWatchReqnc) super.clone();
		// ? take care of any deep copies to be made here
		return another;
	}

}
