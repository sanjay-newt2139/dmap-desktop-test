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
@Table(name = "IPRUR001_RESULT1", catalog = "")
@NamedQueries({@NamedQuery(name = "Iprur001Result1.findAll", query = "SELECT i FROM Iprur001Result1 i")})
public class Iprur001Result1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Iprur001Result1PK iprur001Result1PK;
    @Column(name = "GROUP_NAME", length = 50)
    private String groupName;
    @Column(name = "ALL_WAIT_INDUE")
    private Integer allWaitIndue;
    @Column(name = "ALL_WAIT_OVERDUE")
    private Integer allWaitOverdue;
    @Column(name = "ALL_REJECT_INDUE")
    private Integer allRejectIndue;
    @Column(name = "ALL_REJECT_OVERDUE")
    private Integer allRejectOverdue;
    @Column(name = "ALL_COMPLETE_INDUE")
    private Integer allCompleteIndue;
    @Column(name = "ALL_COMPLETE_OVERDUE")
    private Integer allCompleteOverdue;
    @Column(name = "FW_WAIT_INDUE")
    private Integer fwWaitIndue;
    @Column(name = "FW_WAIT_OVERDUE")
    private Integer fwWaitOverdue;
    @Column(name = "FW_REJECT_INDUE")
    private Integer fwRejectIndue;
    @Column(name = "FW_REJECT_OVERDUE")
    private Integer fwRejectOverdue;
    @Column(name = "FW_COMPLETE_INDUE")
    private Integer fwCompleteIndue;
    @Column(name = "FW_COMPLETE_OVERDUE")
    private Integer fwCompleteOverdue;
    @Column(name = "ACDN_WAIT_INDUE")
    private Integer acdnWaitIndue;
    @Column(name = "ACDN_WAIT_OVERDUE")
    private Integer acdnWaitOverdue;
    @Column(name = "ACDN_REJECT_INDUE")
    private Integer acdnRejectIndue;
    @Column(name = "ACDN_REJECT_OVERDUE")
    private Integer acdnRejectOverdue;
    @Column(name = "ACDN_COMPLETE_INDUE")
    private Integer acdnCompleteIndue;
    @Column(name = "ACDN_COMPLETE_OVERDUE")
    private Integer acdnCompleteOverdue;
    @Column(name = "ATNP_WAIT_INDUE")
    private Integer atnpWaitIndue;
    @Column(name = "ATNP_WAIT_OVERDUE")
    private Integer atnpWaitOverdue;
    @Column(name = "ATNP_REJECT_INDUE")
    private Integer atnpRejectIndue;
    @Column(name = "ATNP_REJECT_OVERDUE")
    private Integer atnpRejectOverdue;
    @Column(name = "ATNP_COMPLETE_INDUE")
    private Integer atnpCompleteIndue;
    @Column(name = "ATNP_COMPLETE_OVERDUE")
    private Integer atnpCompleteOverdue;
    @Column(name = "PHY_WAIT_INDUE")
    private Integer phyWaitIndue;
    @Column(name = "PHY_WAIT_OVERDUE")
    private Integer phyWaitOverdue;
    @Column(name = "PHY_REJECT_INDUE")
    private Integer phyRejectIndue;
    @Column(name = "PHY_REJECT_OVERDUE")
    private Integer phyRejectOverdue;
    @Column(name = "PHY_COMPLETE_INDUE")
    private Integer phyCompleteIndue;
    @Column(name = "PHY_COMPLETE_OVERDUE")
    private Integer phyCompleteOverdue;
    @Column(name = "INTG_WAIT_INDUE")
    private Integer intgWaitIndue;
    @Column(name = "INTG_WAIT_OVERDUE")
    private Integer intgWaitOverdue;
    @Column(name = "INTG_REJECT_INDUE")
    private Integer intgRejectIndue;
    @Column(name = "INTG_REJECT_OVERDUE")
    private Integer intgRejectOverdue;
    @Column(name = "INTG_COMPLETE_INDUE")
    private Integer intgCompleteIndue;
    @Column(name = "INTG_COMPLETE_OVERDUE")
    private Integer intgCompleteOverdue;
    @Column(name = "RT_WAIT_INDUE")
    private Integer rtWaitIndue;
    @Column(name = "RT_WAIT_OVERDUE")
    private Integer rtWaitOverdue;
    @Column(name = "RT_REJECT_INDUE")
    private Integer rtRejectIndue;
    @Column(name = "RT_REJECT_OVERDUE")
    private Integer rtRejectOverdue;
    @Column(name = "RT_COMPLETE_INDUE")
    private Integer rtCompleteIndue;
    @Column(name = "RT_COMPLETE_OVERDUE")
    private Integer rtCompleteOverdue;
    @Column(name = "F5_WAIT_INDUE")
    private Integer f5WaitIndue;
    @Column(name = "F5_WAIT_OVERDUE")
    private Integer f5WaitOverdue;
    @Column(name = "F5_REJECT_INDUE")
    private Integer f5RejectIndue;
    @Column(name = "F5_REJECT_OVERDUE")
    private Integer f5RejectOverdue;
    @Column(name = "F5_COMPLETE_INDUE")
    private Integer f5CompleteIndue;
    @Column(name = "F5_COMPLETE_OVERDUE")
    private Integer f5CompleteOverdue;
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

    public Iprur001Result1() {
    }

    public Iprur001Result1(Iprur001Result1PK iprur001Result1PK) {
        this.iprur001Result1PK = iprur001Result1PK;
    }

    public Iprur001Result1(String reportId, short groupSeq, short dataLevel, String userId) {
        this.iprur001Result1PK = new Iprur001Result1PK(reportId, groupSeq, dataLevel, userId);
    }

    public Iprur001Result1PK getIprur001Result1PK() {
        return iprur001Result1PK;
    }

    public void setIprur001Result1PK(Iprur001Result1PK iprur001Result1PK) {
        this.iprur001Result1PK = iprur001Result1PK;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAllWaitIndue() {
        return allWaitIndue;
    }

    public void setAllWaitIndue(Integer allWaitIndue) {
        this.allWaitIndue = allWaitIndue;
    }

    public Integer getAllWaitOverdue() {
        return allWaitOverdue;
    }

    public void setAllWaitOverdue(Integer allWaitOverdue) {
        this.allWaitOverdue = allWaitOverdue;
    }

    public Integer getAllRejectIndue() {
        return allRejectIndue;
    }

    public void setAllRejectIndue(Integer allRejectIndue) {
        this.allRejectIndue = allRejectIndue;
    }

    public Integer getAllRejectOverdue() {
        return allRejectOverdue;
    }

    public void setAllRejectOverdue(Integer allRejectOverdue) {
        this.allRejectOverdue = allRejectOverdue;
    }

    public Integer getAllCompleteIndue() {
        return allCompleteIndue;
    }

    public void setAllCompleteIndue(Integer allCompleteIndue) {
        this.allCompleteIndue = allCompleteIndue;
    }

    public Integer getAllCompleteOverdue() {
        return allCompleteOverdue;
    }

    public void setAllCompleteOverdue(Integer allCompleteOverdue) {
        this.allCompleteOverdue = allCompleteOverdue;
    }

    public Integer getFwWaitIndue() {
        return fwWaitIndue;
    }

    public void setFwWaitIndue(Integer fwWaitIndue) {
        this.fwWaitIndue = fwWaitIndue;
    }

    public Integer getFwWaitOverdue() {
        return fwWaitOverdue;
    }

    public void setFwWaitOverdue(Integer fwWaitOverdue) {
        this.fwWaitOverdue = fwWaitOverdue;
    }

    public Integer getFwRejectIndue() {
        return fwRejectIndue;
    }

    public void setFwRejectIndue(Integer fwRejectIndue) {
        this.fwRejectIndue = fwRejectIndue;
    }

    public Integer getFwRejectOverdue() {
        return fwRejectOverdue;
    }

    public void setFwRejectOverdue(Integer fwRejectOverdue) {
        this.fwRejectOverdue = fwRejectOverdue;
    }

    public Integer getFwCompleteIndue() {
        return fwCompleteIndue;
    }

    public void setFwCompleteIndue(Integer fwCompleteIndue) {
        this.fwCompleteIndue = fwCompleteIndue;
    }

    public Integer getFwCompleteOverdue() {
        return fwCompleteOverdue;
    }

    public void setFwCompleteOverdue(Integer fwCompleteOverdue) {
        this.fwCompleteOverdue = fwCompleteOverdue;
    }

    public Integer getAcdnWaitIndue() {
        return acdnWaitIndue;
    }

    public void setAcdnWaitIndue(Integer acdnWaitIndue) {
        this.acdnWaitIndue = acdnWaitIndue;
    }

    public Integer getAcdnWaitOverdue() {
        return acdnWaitOverdue;
    }

    public void setAcdnWaitOverdue(Integer acdnWaitOverdue) {
        this.acdnWaitOverdue = acdnWaitOverdue;
    }

    public Integer getAcdnRejectIndue() {
        return acdnRejectIndue;
    }

    public void setAcdnRejectIndue(Integer acdnRejectIndue) {
        this.acdnRejectIndue = acdnRejectIndue;
    }

    public Integer getAcdnRejectOverdue() {
        return acdnRejectOverdue;
    }

    public void setAcdnRejectOverdue(Integer acdnRejectOverdue) {
        this.acdnRejectOverdue = acdnRejectOverdue;
    }

    public Integer getAcdnCompleteIndue() {
        return acdnCompleteIndue;
    }

    public void setAcdnCompleteIndue(Integer acdnCompleteIndue) {
        this.acdnCompleteIndue = acdnCompleteIndue;
    }

    public Integer getAcdnCompleteOverdue() {
        return acdnCompleteOverdue;
    }

    public void setAcdnCompleteOverdue(Integer acdnCompleteOverdue) {
        this.acdnCompleteOverdue = acdnCompleteOverdue;
    }

    public Integer getAtnpWaitIndue() {
        return atnpWaitIndue;
    }

    public void setAtnpWaitIndue(Integer atnpWaitIndue) {
        this.atnpWaitIndue = atnpWaitIndue;
    }

    public Integer getAtnpWaitOverdue() {
        return atnpWaitOverdue;
    }

    public void setAtnpWaitOverdue(Integer atnpWaitOverdue) {
        this.atnpWaitOverdue = atnpWaitOverdue;
    }

    public Integer getAtnpRejectIndue() {
        return atnpRejectIndue;
    }

    public void setAtnpRejectIndue(Integer atnpRejectIndue) {
        this.atnpRejectIndue = atnpRejectIndue;
    }

    public Integer getAtnpRejectOverdue() {
        return atnpRejectOverdue;
    }

    public void setAtnpRejectOverdue(Integer atnpRejectOverdue) {
        this.atnpRejectOverdue = atnpRejectOverdue;
    }

    public Integer getAtnpCompleteIndue() {
        return atnpCompleteIndue;
    }

    public void setAtnpCompleteIndue(Integer atnpCompleteIndue) {
        this.atnpCompleteIndue = atnpCompleteIndue;
    }

    public Integer getAtnpCompleteOverdue() {
        return atnpCompleteOverdue;
    }

    public void setAtnpCompleteOverdue(Integer atnpCompleteOverdue) {
        this.atnpCompleteOverdue = atnpCompleteOverdue;
    }

    public Integer getPhyWaitIndue() {
        return phyWaitIndue;
    }

    public void setPhyWaitIndue(Integer phyWaitIndue) {
        this.phyWaitIndue = phyWaitIndue;
    }

    public Integer getPhyWaitOverdue() {
        return phyWaitOverdue;
    }

    public void setPhyWaitOverdue(Integer phyWaitOverdue) {
        this.phyWaitOverdue = phyWaitOverdue;
    }

    public Integer getPhyRejectIndue() {
        return phyRejectIndue;
    }

    public void setPhyRejectIndue(Integer phyRejectIndue) {
        this.phyRejectIndue = phyRejectIndue;
    }

    public Integer getPhyRejectOverdue() {
        return phyRejectOverdue;
    }

    public void setPhyRejectOverdue(Integer phyRejectOverdue) {
        this.phyRejectOverdue = phyRejectOverdue;
    }

    public Integer getPhyCompleteIndue() {
        return phyCompleteIndue;
    }

    public void setPhyCompleteIndue(Integer phyCompleteIndue) {
        this.phyCompleteIndue = phyCompleteIndue;
    }

    public Integer getPhyCompleteOverdue() {
        return phyCompleteOverdue;
    }

    public void setPhyCompleteOverdue(Integer phyCompleteOverdue) {
        this.phyCompleteOverdue = phyCompleteOverdue;
    }

    public Integer getIntgWaitIndue() {
        return intgWaitIndue;
    }

    public void setIntgWaitIndue(Integer intgWaitIndue) {
        this.intgWaitIndue = intgWaitIndue;
    }

    public Integer getIntgWaitOverdue() {
        return intgWaitOverdue;
    }

    public void setIntgWaitOverdue(Integer intgWaitOverdue) {
        this.intgWaitOverdue = intgWaitOverdue;
    }

    public Integer getIntgRejectIndue() {
        return intgRejectIndue;
    }

    public void setIntgRejectIndue(Integer intgRejectIndue) {
        this.intgRejectIndue = intgRejectIndue;
    }

    public Integer getIntgRejectOverdue() {
        return intgRejectOverdue;
    }

    public void setIntgRejectOverdue(Integer intgRejectOverdue) {
        this.intgRejectOverdue = intgRejectOverdue;
    }

    public Integer getIntgCompleteIndue() {
        return intgCompleteIndue;
    }

    public void setIntgCompleteIndue(Integer intgCompleteIndue) {
        this.intgCompleteIndue = intgCompleteIndue;
    }

    public Integer getIntgCompleteOverdue() {
        return intgCompleteOverdue;
    }

    public void setIntgCompleteOverdue(Integer intgCompleteOverdue) {
        this.intgCompleteOverdue = intgCompleteOverdue;
    }

    public Integer getRtWaitIndue() {
        return rtWaitIndue;
    }

    public void setRtWaitIndue(Integer rtWaitIndue) {
        this.rtWaitIndue = rtWaitIndue;
    }

    public Integer getRtWaitOverdue() {
        return rtWaitOverdue;
    }

    public void setRtWaitOverdue(Integer rtWaitOverdue) {
        this.rtWaitOverdue = rtWaitOverdue;
    }

    public Integer getRtRejectIndue() {
        return rtRejectIndue;
    }

    public void setRtRejectIndue(Integer rtRejectIndue) {
        this.rtRejectIndue = rtRejectIndue;
    }

    public Integer getRtRejectOverdue() {
        return rtRejectOverdue;
    }

    public void setRtRejectOverdue(Integer rtRejectOverdue) {
        this.rtRejectOverdue = rtRejectOverdue;
    }

    public Integer getRtCompleteIndue() {
        return rtCompleteIndue;
    }

    public void setRtCompleteIndue(Integer rtCompleteIndue) {
        this.rtCompleteIndue = rtCompleteIndue;
    }

    public Integer getRtCompleteOverdue() {
        return rtCompleteOverdue;
    }

    public void setRtCompleteOverdue(Integer rtCompleteOverdue) {
        this.rtCompleteOverdue = rtCompleteOverdue;
    }

    public Integer getF5WaitIndue() {
        return f5WaitIndue;
    }

    public void setF5WaitIndue(Integer f5WaitIndue) {
        this.f5WaitIndue = f5WaitIndue;
    }

    public Integer getF5WaitOverdue() {
        return f5WaitOverdue;
    }

    public void setF5WaitOverdue(Integer f5WaitOverdue) {
        this.f5WaitOverdue = f5WaitOverdue;
    }

    public Integer getF5RejectIndue() {
        return f5RejectIndue;
    }

    public void setF5RejectIndue(Integer f5RejectIndue) {
        this.f5RejectIndue = f5RejectIndue;
    }

    public Integer getF5RejectOverdue() {
        return f5RejectOverdue;
    }

    public void setF5RejectOverdue(Integer f5RejectOverdue) {
        this.f5RejectOverdue = f5RejectOverdue;
    }

    public Integer getF5CompleteIndue() {
        return f5CompleteIndue;
    }

    public void setF5CompleteIndue(Integer f5CompleteIndue) {
        this.f5CompleteIndue = f5CompleteIndue;
    }

    public Integer getF5CompleteOverdue() {
        return f5CompleteOverdue;
    }

    public void setF5CompleteOverdue(Integer f5CompleteOverdue) {
        this.f5CompleteOverdue = f5CompleteOverdue;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iprur001Result1PK != null ? iprur001Result1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iprur001Result1)) {
            return false;
        }
        Iprur001Result1 other = (Iprur001Result1) object;
        if ((this.iprur001Result1PK == null && other.iprur001Result1PK != null) || (this.iprur001Result1PK != null && !this.iprur001Result1PK.equals(other.iprur001Result1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "th.co.ais.ipfm.domain1.Iprur001Result1[iprur001Result1PK=" + iprur001Result1PK + "]";
    }

}
