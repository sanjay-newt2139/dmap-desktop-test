package th.co.ais.ipfm.domain1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IP_REPORT_DETAIL"
)
public class IpReportDetail implements java.io.Serializable  {

	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

    @Id
    @Column(name = "REPORT_ID", nullable = false, length = 10)
    private String reportId;
    @Column(name = "USER_ROLE", length = 20)
    private String userRole;
    @Column(name = "USER_ID", length = 20)
    private String userId;
    @Column(name = "UR_TYPE", length = 5)
    private String urType;
    @Column(name = "UR_NO", length = 1000)
    private String urNo;
    @Column(name = "IN_OVER_DUE", length = 1)
    private String inOverDue;
    @Column(name = "IN_REPORT_STATUS", length = 2)
    private String inReportStatus;
    @Column(name = "TOTAL_COUNT")
    private Integer totalCount;
    @Column(name = "SUB_UR_TYPE", length = 5)
    private String subUrType;
    @Column(name = "TOTAL_UR")
    private Integer totalUr;
    
    

    public IpReportDetail() {
    }

    public IpReportDetail(String reportId) {
        this.reportId = reportId;
    }

    public String getReportId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReportId
        return reportId;
    }

    public void setReportId(String reportId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReportId
        this.reportId = reportId;
    }

    public String getUserRole() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserRole
        return userRole;
    }

    public void setUserRole(String userRole) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserRole
        this.userRole = userRole;
    }

    public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
        return userId;
    }

    public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
        this.userId = userId;
    }

    public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
        return urType;
    }

    public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
        this.urType = urType;
    }

    public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
        return urNo;
    }

    public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
        this.urNo = urNo;
    }

    public String getInOverDue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInOverDue
        return inOverDue;
    }

    public void setInOverDue(String inOverDue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInOverDue
        this.inOverDue = inOverDue;
    }

    public String getInReportStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInReportStatus
        return inReportStatus;
    }

    public void setInReportStatus(String inReportStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInReportStatus
        this.inReportStatus = inReportStatus;
    }

    public Integer getTotalCount() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalCount
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalCount
        this.totalCount = totalCount;
    }

    public String getSubUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrType
        return subUrType;
    }

    public void setSubUrType(String subUrType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrType
        this.subUrType = subUrType;
    }

    public Integer getTotalUr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalUr
        return totalUr;
    }

    public void setTotalUr(Integer totalUr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalUr
        this.totalUr = totalUr;
    }
	
	
	  
	  

}
