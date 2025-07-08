/**
 * 
 */
package th.co.ais.ipfm.web.reports.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.web.bean.FilterBean;

/**
 * @author Administrator
 *
 */
public final class IpReportListBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private List<IpReportList> ipReportList;	
	private int rowPerPage;
	private int maxPage;
	private int maxSearchResult;
	private int fastStepPage;
	private FilterBean filterReport = new FilterBean();
	
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() {
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
	}
	public int getFastStepPage() {
		return fastStepPage;
	}
	public void setFastStepPage(int fastStepPage) {
		this.fastStepPage = fastStepPage;
	}	
	
	public List<IpReportList> getIpReportList() {
		return ipReportList;
	}
	public void setIpReportList(List<IpReportList> ipReportList) {
		this.ipReportList = ipReportList;
	}
	//IP_REPORT_DETAIL	
	private String reportId;
	private Date reqDatetime;
	private String userId;
	private Date startDate;
	private Date endDate;
	private String reportStatus;
	private String reportName;
	private String rowId;
	private String runAt;
	private String errorDesc;
	
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public Date getReqDatetime() {
		return reqDatetime;
	}
	public void setReqDatetime(Date reqDatetime) {
		this.reqDatetime = reqDatetime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getRunAt() {
		return runAt;
	}
	public void setRunAt(String runAt) {
		this.runAt = runAt;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public void setFilterReport(FilterBean filterReport) {
		this.filterReport = filterReport;
	}
	public FilterBean getFilterReport() {
		return filterReport;
	}
	

}
