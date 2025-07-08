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
@Table(name = "IPRUR001_RESULT1_DETAIL", catalog = "")
/**
DMAP TAG: Query converted but found same: Identifier107
DMAP ConvertedQuery - SELECT i FROM Iprur001Result1Detail i
**/

@NamedQueries({@NamedQuery(name = "Iprur001Result1Detail.findAll", query = "SELECT i FROM Iprur001Result1Detail i")})
public class Iprur001Result1Detail implements Serializable {
    private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
    @EmbeddedId
    protected Iprur001Result1DetailPK iprur001Result1DetailPK;
    @Column(name = "ACTION_STATUS", length = 1)
    private String actionStatus;
    @Column(name = "DUE_STATUS", length = 1)
    private String dueStatus;
    @Column(name = "UR_NO", length = 30)
    private String urNo;
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

    public Iprur001Result1Detail() {
    }

    public Iprur001Result1Detail(Iprur001Result1DetailPK iprur001Result1DetailPK) {
        this.iprur001Result1DetailPK = iprur001Result1DetailPK;
    }

    public Iprur001Result1Detail(String reportId, short groupSeq, short dataLevel, String dataSubject, String userId) {
        this.iprur001Result1DetailPK = new Iprur001Result1DetailPK(reportId, groupSeq, dataLevel, dataSubject, userId);
    }

    public Iprur001Result1DetailPK getIprur001Result1DetailPK() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIprur001Result1DetailPK
        return iprur001Result1DetailPK;
    }

    public void setIprur001Result1DetailPK(Iprur001Result1DetailPK iprur001Result1DetailPK) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIprur001Result1DetailPK
        this.iprur001Result1DetailPK = iprur001Result1DetailPK;
    }

    public String getActionStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionStatus
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionStatus
        this.actionStatus = actionStatus;
    }

    public String getDueStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDueStatus
        return dueStatus;
    }

    public void setDueStatus(String dueStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDueStatus
        this.dueStatus = dueStatus;
    }

    public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
        return urNo;
    }

    public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
        this.urNo = urNo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iprur001Result1DetailPK != null ? iprur001Result1DetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result1Detail)) {
            return false;
        }
        Iprur001Result1Detail other = (Iprur001Result1Detail) object;
        if ((this.iprur001Result1DetailPK == null && other.iprur001Result1DetailPK != null) || (this.iprur001Result1DetailPK != null && !this.iprur001Result1DetailPK.equals(other.iprur001Result1DetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { // DMAP Comment : Dead Code Detected - The Following Method has no reference toString
        return "th.co.ais.ipfm.domain1.Iprur001Result1Detail[iprur001Result1DetailPK=" + iprur001Result1DetailPK + "]";
    }

}
