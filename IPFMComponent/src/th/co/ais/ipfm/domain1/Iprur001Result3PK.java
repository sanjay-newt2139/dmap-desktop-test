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
public class Iprur001Result3PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "REPORT_ID", nullable = false, length = 20)
    private String reportId;
    @Basic(optional = false)
    @Column(name = "GROUP_SEQ", nullable = false)
    private short groupSeq;

    public Iprur001Result3PK() {
    }

    public Iprur001Result3PK(String reportId, short groupSeq) {
        this.reportId = reportId;
        this.groupSeq = groupSeq;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        hash += (int) groupSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result3PK)) {
            return false;
        }
        Iprur001Result3PK other = (Iprur001Result3PK) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        if (this.groupSeq != other.groupSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result3PK[reportId=" + reportId + ", groupSeq=" + groupSeq + "]";
    }

}
