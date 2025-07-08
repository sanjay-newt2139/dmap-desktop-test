package th.co.ais.ipfm.domain;

import java.util.Date;

public class IPTodoList {
	private Date slaDate;	
	private Date olaDate;
	private String urNo;
	private String subject;
	private String reqUser;
	private Date reqDate;
	private String prevUser;
	private String prevDate;
	private String actionNameList;
	private String remarks;
	
	public Date getSlaDate() {
		return slaDate;
	}
	public void setSlaDate(Date slaDate) {
		this.slaDate = slaDate;
	}
	public Date getOlaDate() {
		return olaDate;
	}
	public void setOlaDate(Date olaDate) {
		this.olaDate = olaDate;
	}
	public String getUrNo() {
		return urNo;
	}
	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getPrevUser() {
		return prevUser;
	}
	public void setPrevUser(String prevUser) {
		this.prevUser = prevUser;
	}
	public String getPrevDate() {
		return prevDate;
	}
	public void setPrevDate(String prevDate) {
		this.prevDate = prevDate;
	}
	public String getActionNameList() {
		return actionNameList;
	}
	public void setActionNameList(String actionNameList) {
		this.actionNameList = actionNameList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
