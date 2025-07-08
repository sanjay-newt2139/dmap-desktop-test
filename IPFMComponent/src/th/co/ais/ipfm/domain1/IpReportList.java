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
	
	private static final long serialVersionUID = 1L;
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

    public Date getReqDatetime() {
//    	reqDatetime = new Date(IPFMUtils.dateSql2DateString(reqDatetime, IPFMConstant.DATETIME_FORMAT));
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

    public Date getRunAt() {
        return runAt;
    }

    public void setRunAt(Date runAt) {
        this.runAt = runAt;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
	  

}
