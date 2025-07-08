 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "IPRUR001_RESULT4", catalog = "")
/**
DMAP TAG: Query converted but found same: Identifier178
DMAP ConvertedQuery - SELECT i FROM Iprur001Result4 i
**/

@NamedQueries({@NamedQuery(name = "Iprur001Result4.findAll", query = "SELECT i FROM Iprur001Result4 i")})
public class Iprur001Result4 implements Serializable {
    private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
    @EmbeddedId
    protected Iprur001Result4PK iprur001Result4PK;
    @Column(name = "GROUP_NAME", length = 50)
    private String groupName;
    @Column(name = "COMPLETE_INDUE")
    private Integer completeIndue;
    @Column(name = "COMPLETE_OVERDUE")
    private Integer completeOverdue;
    @Column(name = "WAITMAPP_INDUE")
    private Integer waitmappIndue;
    @Column(name = "WAITMAPP_OVERDUE")
    private Integer waitmappOverdue;
    @Column(name = "WAITASSIGN_INDUE")
    private Integer waitassignIndue;
    @Column(name = "WAITASSIGN_OVERDUE")
    private Integer waitassignOverdue;
    @Column(name = "CREATE_BY", length = 20)
    private String createBy;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "UPDATE_BY", length = 20)
    private String updateBy;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "ROW_ID", length = 50)
    private String rowId;
    @Column(name = "VERSION")
    private Long version;
    @Column(name = "USER_NAME", length = 50)
    private String userName;

    public Iprur001Result4() {
    }

    public Iprur001Result4(Iprur001Result4PK iprur001Result4PK) {
        this.iprur001Result4PK = iprur001Result4PK;
    }

    public Iprur001Result4(String reportId, short groupSeq, short dataLevel, String userId) {
        this.iprur001Result4PK = new Iprur001Result4PK(reportId, groupSeq, dataLevel, userId);
    }

    public Iprur001Result4PK getIprur001Result4PK() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIprur001Result4PK
        return iprur001Result4PK;
    }

    public void setIprur001Result4PK(Iprur001Result4PK iprur001Result4PK) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIprur001Result4PK
        this.iprur001Result4PK = iprur001Result4PK;
    }

    public String getGroupName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupName
        return groupName;
    }

    public void setGroupName(String groupName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupName
        this.groupName = groupName;
    }

    public Integer getCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompleteIndue
        return completeIndue;
    }

    public void setCompleteIndue(Integer completeIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompleteIndue
        this.completeIndue = completeIndue;
    }

    public Integer getCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompleteOverdue
        return completeOverdue;
    }

    public void setCompleteOverdue(Integer completeOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompleteOverdue
        this.completeOverdue = completeOverdue;
    }

    public Integer getWaitmappIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWaitmappIndue
        return waitmappIndue;
    }

    public void setWaitmappIndue(Integer waitmappIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWaitmappIndue
        this.waitmappIndue = waitmappIndue;
    }

    public Integer getWaitmappOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWaitmappOverdue
        return waitmappOverdue;
    }

    public void setWaitmappOverdue(Integer waitmappOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWaitmappOverdue
        this.waitmappOverdue = waitmappOverdue;
    }

    public Integer getWaitassignIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWaitassignIndue
        return waitassignIndue;
    }

    public void setWaitassignIndue(Integer waitassignIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWaitassignIndue
        this.waitassignIndue = waitassignIndue;
    }

    public Integer getWaitassignOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWaitassignOverdue
        return waitassignOverdue;
    }

    public void setWaitassignOverdue(Integer waitassignOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWaitassignOverdue
        this.waitassignOverdue = waitassignOverdue;
    }

    public String getCreateBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateBy
        return createBy;
    }

    public void setCreateBy(String createBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateBy
        this.createBy = createBy;
    }

    public Date getCreateDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreateDate
        return createDate;
    }

    public void setCreateDate(Date createDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreateDate
        this.createDate = createDate;
    }

    public String getUpdateBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUpdateBy
        return updateBy;
    }

    public void setUpdateBy(String updateBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUpdateBy
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUpdateDate
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUpdateDate
        this.updateDate = updateDate;
    }

    public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
        return rowId;
    }

    public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
        this.rowId = rowId;
    }

    public Long getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
        return version;
    }

    public void setVersion(Long version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
        this.version = version;
    }

    public String getUserName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserName
        return userName;
    }

    public void setUserName(String userName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserName
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iprur001Result4PK != null ? iprur001Result4PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result4)) {
            return false;
        }
        Iprur001Result4 other = (Iprur001Result4) object;
        if ((this.iprur001Result4PK == null && other.iprur001Result4PK != null) || (this.iprur001Result4PK != null && !this.iprur001Result4PK.equals(other.iprur001Result4PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { // DMAP Comment : Dead Code Detected - The Following Method has no reference toString
        return "th.co.ais.ipfm.domain1.Iprur001Result4[iprur001Result4PK=" + iprur001Result4PK + "]";
    }

}
