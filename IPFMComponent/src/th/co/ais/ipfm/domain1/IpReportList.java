package th.co.ais.ipfm.domain1;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="IP_REPORT_LIST"
)
public class IpReportList implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	@Column(name = "REQ_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqDatetime;
    @Column(name = "USER_ID", length = 20)
    private String userId;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "REPORT_STATUS", length = 10)
    private String reportStatus;
    @Column(name = "REPORT_NAME", length = 60)
    private String reportName;
    @Column(name = "ROW_ID", length = 50)
    private String rowId;
    @Column(name = "RUN_AT")
    @Temporal(TemporalType.DATE)
    private Date runAt;
    @Column(name = "ERROR_DESC", length = 1000)
    private String errorDesc;
    @Id
    @Basic(optional = false)
    @Column(name = "REPORT_ID", nullable = false, length = 10)
    private String reportId;

    public IpReportList() {
    }

    public IpReportList(String reportId) {
        this.reportId = reportId;
    }

    public Date getReqDatetime() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDatetime
//    	reqDatetime = new Date(IPFMUtils.dateSql2DateString(reqDatetime, IPFMConstant.DATETIME_FORMAT));
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

    public Date getRunAt() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRunAt
        return runAt;
    }

    public void setRunAt(Date runAt) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRunAt
        this.runAt = runAt;
    }

    public String getErrorDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorDesc
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorDesc
        this.errorDesc = errorDesc;
    }

    public String getReportId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReportId
        return reportId;
    }

    public void setReportId(String reportId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReportId
        this.reportId = reportId;
    }
	  

}
