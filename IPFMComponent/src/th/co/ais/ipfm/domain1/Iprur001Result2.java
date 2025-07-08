 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "IPRUR001_RESULT2", catalog = "")
/**
DMAP TAG: Query converted but found same: Identifier348
DMAP ConvertedQuery - SELECT i FROM Iprur001Result2 i
**/

@NamedQueries({@NamedQuery(name = "Iprur001Result2.findAll", query = "SELECT i FROM Iprur001Result2 i")})
public class Iprur001Result2 implements Serializable {
    private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
    @EmbeddedId
    protected Iprur001Result2PK iprur001Result2PK;
    @Basic(optional = false)
    @Column(name = "GROUP_SEQ", nullable = false)
    private short groupSeq;
    @Column(name = "GROUP_NAME", length = 50)
    private String groupName;
    @Column(name = "INDUE")
    private Integer indue;
    @Column(name = "OVERDUE")
    private Integer overdue;
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

    public Iprur001Result2() {
    }

    public Iprur001Result2(Iprur001Result2PK iprur001Result2PK) {
        this.iprur001Result2PK = iprur001Result2PK;
    }

    public Iprur001Result2(Iprur001Result2PK iprur001Result2PK, short groupSeq) {
        this.iprur001Result2PK = iprur001Result2PK;
        this.groupSeq = groupSeq;
    }

    public Iprur001Result2(String reportId, long version, String urType) {
        this.iprur001Result2PK = new Iprur001Result2PK(reportId, version, urType);
    }

    public Iprur001Result2PK getIprur001Result2PK() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIprur001Result2PK
        return iprur001Result2PK;
    }

    public void setIprur001Result2PK(Iprur001Result2PK iprur001Result2PK) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIprur001Result2PK
        this.iprur001Result2PK = iprur001Result2PK;
    }

    public short getGroupSeq() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupSeq
        return groupSeq;
    }

    public void setGroupSeq(short groupSeq) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupSeq
        this.groupSeq = groupSeq;
    }

    public String getGroupName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupName
        return groupName;
    }

    public void setGroupName(String groupName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupName
        this.groupName = groupName;
    }

    public Integer getIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIndue
        return indue;
    }

    public void setIndue(Integer indue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIndue
        this.indue = indue;
    }

    public Integer getOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOverdue
        return overdue;
    }

    public void setOverdue(Integer overdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOverdue
        this.overdue = overdue;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iprur001Result2PK != null ? iprur001Result2PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result2)) {
            return false;
        }
        Iprur001Result2 other = (Iprur001Result2) object;
        if ((this.iprur001Result2PK == null && other.iprur001Result2PK != null) || (this.iprur001Result2PK != null && !this.iprur001Result2PK.equals(other.iprur001Result2PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { // DMAP Comment : Dead Code Detected - The Following Method has no reference toString
        return "th.co.ais.ipfm.domain1.Iprur001Result2[iprur001Result2PK=" + iprur001Result2PK + "]";
    }

}
