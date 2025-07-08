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
@Table(name = "IPRUR001_RESULT3_DETAIL", catalog = "")
@NamedQueries({@NamedQuery(name = "Iprur001Result3Detail.findAll", query = "SELECT i FROM Iprur001Result3Detail i")})
public class Iprur001Result3Detail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Iprur001Result3DetailPK iprur001Result3DetailPK;
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

    public Iprur001Result3Detail() {
    }

    public Iprur001Result3Detail(Iprur001Result3DetailPK iprur001Result3DetailPK) {
        this.iprur001Result3DetailPK = iprur001Result3DetailPK;
    }

    public Iprur001Result3Detail(String reportId, short groupSeq, String urStatus, String dueStatus) {
        this.iprur001Result3DetailPK = new Iprur001Result3DetailPK(reportId, groupSeq, urStatus, dueStatus);
    }

    public Iprur001Result3DetailPK getIprur001Result3DetailPK() {
        return iprur001Result3DetailPK;
    }

    public void setIprur001Result3DetailPK(Iprur001Result3DetailPK iprur001Result3DetailPK) {
        this.iprur001Result3DetailPK = iprur001Result3DetailPK;
    }

    public String getUrNo() {
        return urNo;
    }

    public void setUrNo(String urNo) {
        this.urNo = urNo;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iprur001Result3DetailPK != null ? iprur001Result3DetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result3Detail)) {
            return false;
        }
        Iprur001Result3Detail other = (Iprur001Result3Detail) object;
        if ((this.iprur001Result3DetailPK == null && other.iprur001Result3DetailPK != null) || (this.iprur001Result3DetailPK != null && !this.iprur001Result3DetailPK.equals(other.iprur001Result3DetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result3Detail[iprur001Result3DetailPK=" + iprur001Result3DetailPK + "]";
    }

}
