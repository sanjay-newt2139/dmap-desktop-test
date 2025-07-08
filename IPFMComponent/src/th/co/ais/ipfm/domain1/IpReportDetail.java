package th.co.ais.ipfm.domain1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IP_REPORT_DETAIL"
)
public class IpReportDetail implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;

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

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrType() {
        return urType;
    }

    public void setUrType(String urType) {
        this.urType = urType;
    }

    public String getUrNo() {
        return urNo;
    }

    public void setUrNo(String urNo) {
        this.urNo = urNo;
    }

    public String getInOverDue() {
        return inOverDue;
    }

    public void setInOverDue(String inOverDue) {
        this.inOverDue = inOverDue;
    }

    public String getInReportStatus() {
        return inReportStatus;
    }

    public void setInReportStatus(String inReportStatus) {
        this.inReportStatus = inReportStatus;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getSubUrType() {
        return subUrType;
    }

    public void setSubUrType(String subUrType) {
        this.subUrType = subUrType;
    }

    public Integer getTotalUr() {
        return totalUr;
    }

    public void setTotalUr(Integer totalUr) {
        this.totalUr = totalUr;
    }
	
	
	  
	  

}
