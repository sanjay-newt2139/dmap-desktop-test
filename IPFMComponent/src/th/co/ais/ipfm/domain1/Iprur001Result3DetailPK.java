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
public class Iprur001Result3DetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "REPORT_ID", nullable = false, length = 20)
    private String reportId;
    @Basic(optional = false)
    @Column(name = "GROUP_SEQ", nullable = false)
    private short groupSeq;
    @Basic(optional = false)
    @Column(name = "UR_STATUS", nullable = false, length = 1)
    private String urStatus;
    @Basic(optional = false)
    @Column(name = "DUE_STATUS", nullable = false, length = 1)
    private String dueStatus;

    public Iprur001Result3DetailPK() {
    }

    public Iprur001Result3DetailPK(String reportId, short groupSeq, String urStatus, String dueStatus) {
        this.reportId = reportId;
        this.groupSeq = groupSeq;
        this.urStatus = urStatus;
        this.dueStatus = dueStatus;
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

    public String getUrStatus() {
        return urStatus;
    }

    public void setUrStatus(String urStatus) {
        this.urStatus = urStatus;
    }

    public String getDueStatus() {
        return dueStatus;
    }

    public void setDueStatus(String dueStatus) {
        this.dueStatus = dueStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        hash += (int) groupSeq;
        hash += (urStatus != null ? urStatus.hashCode() : 0);
        hash += (dueStatus != null ? dueStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result3DetailPK)) {
            return false;
        }
        Iprur001Result3DetailPK other = (Iprur001Result3DetailPK) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        if (this.groupSeq != other.groupSeq) {
            return false;
        }
        if ((this.urStatus == null && other.urStatus != null) || (this.urStatus != null && !this.urStatus.equals(other.urStatus))) {
            return false;
        }
        if ((this.dueStatus == null && other.dueStatus != null) || (this.dueStatus != null && !this.dueStatus.equals(other.dueStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result3DetailPK[reportId=" + reportId + ", groupSeq=" + groupSeq + ", urStatus=" + urStatus + ", dueStatus=" + dueStatus + "]";
    }

}
