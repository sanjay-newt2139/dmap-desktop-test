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
public class Iprur001Result2PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "REPORT_ID", nullable = false, length = 20)
    private String reportId;
    @Basic(optional = false)
    @Column(name = "VERSION", nullable = false)
    private long version;
    @Basic(optional = false)
    @Column(name = "UR_TYPE", nullable = false, length = 10)
    private String urType;

    public Iprur001Result2PK() {
    }

    public Iprur001Result2PK(String reportId, long version, String urType) {
        this.reportId = reportId;
        this.version = version;
        this.urType = urType;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getUrType() {
        return urType;
    }

    public void setUrType(String urType) {
        this.urType = urType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        hash += (int) version;
        hash += (urType != null ? urType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result2PK)) {
            return false;
        }
        Iprur001Result2PK other = (Iprur001Result2PK) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if ((this.urType == null && other.urType != null) || (this.urType != null && !this.urType.equals(other.urType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result2PK[reportId=" + reportId + ", version=" + version + ", urType=" + urType + "]";
    }

}
