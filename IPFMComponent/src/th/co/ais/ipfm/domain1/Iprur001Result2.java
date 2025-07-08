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
@NamedQueries({@NamedQuery(name = "Iprur001Result2.findAll", query = "SELECT i FROM Iprur001Result2 i")})
public class Iprur001Result2 implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public Iprur001Result2PK getIprur001Result2PK() {
        return iprur001Result2PK;
    }

    public void setIprur001Result2PK(Iprur001Result2PK iprur001Result2PK) {
        this.iprur001Result2PK = iprur001Result2PK;
    }

    public short getGroupSeq() {
        return groupSeq;
    }

    public void setGroupSeq(short groupSeq) {
        this.groupSeq = groupSeq;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getIndue() {
        return indue;
    }

    public void setIndue(Integer indue) {
        this.indue = indue;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
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
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result2[iprur001Result2PK=" + iprur001Result2PK + "]";
    }

}
