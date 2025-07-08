/**
 * 
 */
package th.co.ais.ipfm.web.reports.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public final class IpReportDetailTempBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//IP_REPORT_DETAIL_TEMP
	private String urNo;
	private String subUrNo;
	private String urType;
	private String subUrType;
	private String urStatus;
	private String actionUserId;
	private String actionUserRole;
	private String requesterId;
	private String firstRequestId;
	private Date slaDate;
	private Date olaDate;
	
	public String getUrNo() {
		return urNo;
	}
	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}
	public String getSubUrNo() {
		return subUrNo;
	}
	public void setSubUrNo(String subUrNo) {
		this.subUrNo = subUrNo;
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
	public String getUrStatus() {
		return urStatus;
	}
	public void setUrStatus(String urStatus) {
		this.urStatus = urStatus;
	}
	public String getActionUserId() {
		return actionUserId;
	}
	public void setActionUserId(String actionUserId) {
		this.actionUserId = actionUserId;
	}
	public String getActionUserRole() {
		return actionUserRole;
	}
	public void setActionUserRole(String actionUserRole) {
		this.actionUserRole = actionUserRole;
	}
	public String getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}
	public String getFirstRequestId() {
		return firstRequestId;
	}
	public void setFirstRequestId(String firstRequestId) {
		this.firstRequestId = firstRequestId;
	}
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
	

}
