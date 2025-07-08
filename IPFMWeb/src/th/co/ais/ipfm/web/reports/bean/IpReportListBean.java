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
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	

	private List<IpReportList> ipReportList;	
	private int rowPerPage;
	private int maxPage;
	private int maxSearchResult;
	private int fastStepPage;
	private FilterBean filterReport = new FilterBean();
	
	public int getRowPerPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage
		return maxPage;
	}
	public void setMaxPage(int maxPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult
		this.maxSearchResult = maxSearchResult;
	}
	public int getFastStepPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage
		return fastStepPage;
	}
	public void setFastStepPage(int fastStepPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage
		this.fastStepPage = fastStepPage;
	}	
	
	public List<IpReportList> getIpReportList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpReportList
		return ipReportList;
	}
	public void setIpReportList(List<IpReportList> ipReportList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpReportList
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
	
	public String getReportId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReportId
		return reportId;
	}
	public void setReportId(String reportId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReportId
		this.reportId = reportId;
	}
	public Date getReqDatetime() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDatetime
		return reqDatetime;
	}
	public void setReqDatetime(Date reqDatetime) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqDatetime
		this.reqDatetime = reqDatetime;
	}
	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}
	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}
	public Date getStartDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStartDate
		return startDate;
	}
	public void setStartDate(Date startDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStartDate
		this.startDate = startDate;
	}
	public Date getEndDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEndDate
		return endDate;
	}
	public void setEndDate(Date endDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEndDate
		this.endDate = endDate;
	}
	public String getReportStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReportStatus
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReportStatus
		this.reportStatus = reportStatus;
	}
	public String getReportName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReportName
		return reportName;
	}
	public void setReportName(String reportName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReportName
		this.reportName = reportName;
	}
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}
	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	public String getRunAt() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRunAt
		return runAt;
	}
	public void setRunAt(String runAt) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRunAt
		this.runAt = runAt;
	}
	public String getErrorDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorDesc
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorDesc
		this.errorDesc = errorDesc;
	}
	public void setFilterReport(FilterBean filterReport) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReport
		this.filterReport = filterReport;
	}
	public FilterBean getFilterReport() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReport
		return filterReport;
	}
	

}
