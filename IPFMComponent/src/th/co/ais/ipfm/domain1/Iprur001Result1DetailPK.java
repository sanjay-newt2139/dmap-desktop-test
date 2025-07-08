/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.ais.ipfm.domain1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class Iprur001Result1DetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "REPORT_ID", nullable = false, length = 20)
    private String reportId;
    @Basic(optional = false)
    @Column(name = "GROUP_SEQ", nullable = false)
    private short groupSeq;
    @Basic(optional = false)
    @Column(name = "DATA_LEVEL", nullable = false)
    private short dataLevel;
    @Basic(optional = false)
    @Column(name = "DATA_SUBJECT", nullable = false, length = 10)
    private String dataSubject;
    @Basic(optional = false)
    @Column(name = "USER_ID", nullable = false, length = 20)
    private String userId;

    public Iprur001Result1DetailPK() {
    }

    public Iprur001Result1DetailPK(String reportId, short groupSeq, short dataLevel, String dataSubject, String userId) {
        this.reportId = reportId;
        this.groupSeq = groupSeq;
        this.dataLevel = dataLevel;
        this.dataSubject = dataSubject;
        this.userId = userId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public short getGroupSeq() {
        return groupSeq;
    }

    public void setGroupSeq(short groupSeq) {
        this.groupSeq = groupSeq;
    }

    public short getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(short dataLevel) {
        this.dataLevel = dataLevel;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        hash += (int) groupSeq;
        hash += (int) dataLevel;
        hash += (dataSubject != null ? dataSubject.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result1DetailPK)) {
            return false;
        }
        Iprur001Result1DetailPK other = (Iprur001Result1DetailPK) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        if (this.groupSeq != other.groupSeq) {
            return false;
        }
        if (this.dataLevel != other.dataLevel) {
            return false;
        }
        if ((this.dataSubject == null && other.dataSubject != null) || (this.dataSubject != null && !this.dataSubject.equals(other.dataSubject))) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result1DetailPK[reportId=" + reportId + ", groupSeq=" + groupSeq + ", dataLevel=" + dataLevel + ", dataSubject=" + dataSubject + ", userId=" + userId + "]";
    }

}
