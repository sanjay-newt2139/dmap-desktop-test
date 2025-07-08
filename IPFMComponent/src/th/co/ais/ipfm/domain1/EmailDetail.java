package th.co.ais.ipfm.domain1;

import java.util.Date;

public class EmailDetail {
	private String email;
	private String userId;
	private String userName;
	private String urNo;
	private String subUrNo;
	private String urType;
	private String urStatus;
	private String urStatusDesc;
	private String subject;
	private String subjectDesc;
	private String bodyDesc;
	private String url;
	private String templateEmail;
	private String deleteStatus;
	private String requestBy;
	private Date requestDate;
	private String nodeId;
	private String createBy;
	private String updateBy;
	
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
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
	public String getUrStatus() {
		return urStatus;
	}
	public void setUrStatus(String urStatus) {
		this.urStatus = urStatus;
	}
	public String getUrStatusDesc() {
		return urStatusDesc;
	}
	public void setUrStatusDesc(String urStatusDesc) {
		this.urStatusDesc = urStatusDesc;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	public String getBodyDesc() {
		return bodyDesc;
	}
	public void setBodyDesc(String bodyDesc) {
		this.bodyDesc = bodyDesc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSubUrNo() {
		return subUrNo;
	}
	public void setSubUrNo(String subUrNo) {
		this.subUrNo = subUrNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTemplateEmail() {
		return templateEmail;
	}
	public void setTemplateEmail(String templateEmail) {
		this.templateEmail = templateEmail;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}
