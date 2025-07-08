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
@Table(name = "IPRUR001_RESULT1", catalog = "")
/**
DMAP TAG: Query converted but found same: Identifier64
DMAP ConvertedQuery - SELECT i FROM Iprur001Result1 i
**/

@NamedQueries({@NamedQuery(name = "Iprur001Result1.findAll", query = "SELECT i FROM Iprur001Result1 i")})
public class Iprur001Result1 implements Serializable {
    private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
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

    public Iprur001Result1PK getIprur001Result1PK() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIprur001Result1PK
        return iprur001Result1PK;
    }

    public void setIprur001Result1PK(Iprur001Result1PK iprur001Result1PK) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIprur001Result1PK
        this.iprur001Result1PK = iprur001Result1PK;
    }

    public String getGroupName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupName
        return groupName;
    }

    public void setGroupName(String groupName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupName
        this.groupName = groupName;
    }

    public Integer getAllWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllWaitIndue
        return allWaitIndue;
    }

    public void setAllWaitIndue(Integer allWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllWaitIndue
        this.allWaitIndue = allWaitIndue;
    }

    public Integer getAllWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllWaitOverdue
        return allWaitOverdue;
    }

    public void setAllWaitOverdue(Integer allWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllWaitOverdue
        this.allWaitOverdue = allWaitOverdue;
    }

    public Integer getAllRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllRejectIndue
        return allRejectIndue;
    }

    public void setAllRejectIndue(Integer allRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllRejectIndue
        this.allRejectIndue = allRejectIndue;
    }

    public Integer getAllRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllRejectOverdue
        return allRejectOverdue;
    }

    public void setAllRejectOverdue(Integer allRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllRejectOverdue
        this.allRejectOverdue = allRejectOverdue;
    }

    public Integer getAllCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllCompleteIndue
        return allCompleteIndue;
    }

    public void setAllCompleteIndue(Integer allCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllCompleteIndue
        this.allCompleteIndue = allCompleteIndue;
    }

    public Integer getAllCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllCompleteOverdue
        return allCompleteOverdue;
    }

    public void setAllCompleteOverdue(Integer allCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllCompleteOverdue
        this.allCompleteOverdue = allCompleteOverdue;
    }

    public Integer getFwWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFwWaitIndue
        return fwWaitIndue;
    }

    public void setFwWaitIndue(Integer fwWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFwWaitIndue
        this.fwWaitIndue = fwWaitIndue;
    }

    public Integer getFwWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFwWaitOverdue
        return fwWaitOverdue;
    }

    public void setFwWaitOverdue(Integer fwWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFwWaitOverdue
        this.fwWaitOverdue = fwWaitOverdue;
    }

    public Integer getFwRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFwRejectIndue
        return fwRejectIndue;
    }

    public void setFwRejectIndue(Integer fwRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFwRejectIndue
        this.fwRejectIndue = fwRejectIndue;
    }

    public Integer getFwRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFwRejectOverdue
        return fwRejectOverdue;
    }

    public void setFwRejectOverdue(Integer fwRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFwRejectOverdue
        this.fwRejectOverdue = fwRejectOverdue;
    }

    public Integer getFwCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFwCompleteIndue
        return fwCompleteIndue;
    }

    public void setFwCompleteIndue(Integer fwCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFwCompleteIndue
        this.fwCompleteIndue = fwCompleteIndue;
    }

    public Integer getFwCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFwCompleteOverdue
        return fwCompleteOverdue;
    }

    public void setFwCompleteOverdue(Integer fwCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFwCompleteOverdue
        this.fwCompleteOverdue = fwCompleteOverdue;
    }

    public Integer getAcdnWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcdnWaitIndue
        return acdnWaitIndue;
    }

    public void setAcdnWaitIndue(Integer acdnWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcdnWaitIndue
        this.acdnWaitIndue = acdnWaitIndue;
    }

    public Integer getAcdnWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcdnWaitOverdue
        return acdnWaitOverdue;
    }

    public void setAcdnWaitOverdue(Integer acdnWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcdnWaitOverdue
        this.acdnWaitOverdue = acdnWaitOverdue;
    }

    public Integer getAcdnRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcdnRejectIndue
        return acdnRejectIndue;
    }

    public void setAcdnRejectIndue(Integer acdnRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcdnRejectIndue
        this.acdnRejectIndue = acdnRejectIndue;
    }

    public Integer getAcdnRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcdnRejectOverdue
        return acdnRejectOverdue;
    }

    public void setAcdnRejectOverdue(Integer acdnRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcdnRejectOverdue
        this.acdnRejectOverdue = acdnRejectOverdue;
    }

    public Integer getAcdnCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcdnCompleteIndue
        return acdnCompleteIndue;
    }

    public void setAcdnCompleteIndue(Integer acdnCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcdnCompleteIndue
        this.acdnCompleteIndue = acdnCompleteIndue;
    }

    public Integer getAcdnCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcdnCompleteOverdue
        return acdnCompleteOverdue;
    }

    public void setAcdnCompleteOverdue(Integer acdnCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcdnCompleteOverdue
        this.acdnCompleteOverdue = acdnCompleteOverdue;
    }

    public Integer getAtnpWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAtnpWaitIndue
        return atnpWaitIndue;
    }

    public void setAtnpWaitIndue(Integer atnpWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAtnpWaitIndue
        this.atnpWaitIndue = atnpWaitIndue;
    }

    public Integer getAtnpWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAtnpWaitOverdue
        return atnpWaitOverdue;
    }

    public void setAtnpWaitOverdue(Integer atnpWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAtnpWaitOverdue
        this.atnpWaitOverdue = atnpWaitOverdue;
    }

    public Integer getAtnpRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAtnpRejectIndue
        return atnpRejectIndue;
    }

    public void setAtnpRejectIndue(Integer atnpRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAtnpRejectIndue
        this.atnpRejectIndue = atnpRejectIndue;
    }

    public Integer getAtnpRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAtnpRejectOverdue
        return atnpRejectOverdue;
    }

    public void setAtnpRejectOverdue(Integer atnpRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAtnpRejectOverdue
        this.atnpRejectOverdue = atnpRejectOverdue;
    }

    public Integer getAtnpCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAtnpCompleteIndue
        return atnpCompleteIndue;
    }

    public void setAtnpCompleteIndue(Integer atnpCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAtnpCompleteIndue
        this.atnpCompleteIndue = atnpCompleteIndue;
    }

    public Integer getAtnpCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAtnpCompleteOverdue
        return atnpCompleteOverdue;
    }

    public void setAtnpCompleteOverdue(Integer atnpCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAtnpCompleteOverdue
        this.atnpCompleteOverdue = atnpCompleteOverdue;
    }

    public Integer getPhyWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyWaitIndue
        return phyWaitIndue;
    }

    public void setPhyWaitIndue(Integer phyWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyWaitIndue
        this.phyWaitIndue = phyWaitIndue;
    }

    public Integer getPhyWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyWaitOverdue
        return phyWaitOverdue;
    }

    public void setPhyWaitOverdue(Integer phyWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyWaitOverdue
        this.phyWaitOverdue = phyWaitOverdue;
    }

    public Integer getPhyRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyRejectIndue
        return phyRejectIndue;
    }

    public void setPhyRejectIndue(Integer phyRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyRejectIndue
        this.phyRejectIndue = phyRejectIndue;
    }

    public Integer getPhyRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyRejectOverdue
        return phyRejectOverdue;
    }

    public void setPhyRejectOverdue(Integer phyRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyRejectOverdue
        this.phyRejectOverdue = phyRejectOverdue;
    }

    public Integer getPhyCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyCompleteIndue
        return phyCompleteIndue;
    }

    public void setPhyCompleteIndue(Integer phyCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyCompleteIndue
        this.phyCompleteIndue = phyCompleteIndue;
    }

    public Integer getPhyCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyCompleteOverdue
        return phyCompleteOverdue;
    }

    public void setPhyCompleteOverdue(Integer phyCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyCompleteOverdue
        this.phyCompleteOverdue = phyCompleteOverdue;
    }

    public Integer getIntgWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntgWaitIndue
        return intgWaitIndue;
    }

    public void setIntgWaitIndue(Integer intgWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntgWaitIndue
        this.intgWaitIndue = intgWaitIndue;
    }

    public Integer getIntgWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntgWaitOverdue
        return intgWaitOverdue;
    }

    public void setIntgWaitOverdue(Integer intgWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntgWaitOverdue
        this.intgWaitOverdue = intgWaitOverdue;
    }

    public Integer getIntgRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntgRejectIndue
        return intgRejectIndue;
    }

    public void setIntgRejectIndue(Integer intgRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntgRejectIndue
        this.intgRejectIndue = intgRejectIndue;
    }

    public Integer getIntgRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntgRejectOverdue
        return intgRejectOverdue;
    }

    public void setIntgRejectOverdue(Integer intgRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntgRejectOverdue
        this.intgRejectOverdue = intgRejectOverdue;
    }

    public Integer getIntgCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntgCompleteIndue
        return intgCompleteIndue;
    }

    public void setIntgCompleteIndue(Integer intgCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntgCompleteIndue
        this.intgCompleteIndue = intgCompleteIndue;
    }

    public Integer getIntgCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntgCompleteOverdue
        return intgCompleteOverdue;
    }

    public void setIntgCompleteOverdue(Integer intgCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntgCompleteOverdue
        this.intgCompleteOverdue = intgCompleteOverdue;
    }

    public Integer getRtWaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRtWaitIndue
        return rtWaitIndue;
    }

    public void setRtWaitIndue(Integer rtWaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRtWaitIndue
        this.rtWaitIndue = rtWaitIndue;
    }

    public Integer getRtWaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRtWaitOverdue
        return rtWaitOverdue;
    }

    public void setRtWaitOverdue(Integer rtWaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRtWaitOverdue
        this.rtWaitOverdue = rtWaitOverdue;
    }

    public Integer getRtRejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRtRejectIndue
        return rtRejectIndue;
    }

    public void setRtRejectIndue(Integer rtRejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRtRejectIndue
        this.rtRejectIndue = rtRejectIndue;
    }

    public Integer getRtRejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRtRejectOverdue
        return rtRejectOverdue;
    }

    public void setRtRejectOverdue(Integer rtRejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRtRejectOverdue
        this.rtRejectOverdue = rtRejectOverdue;
    }

    public Integer getRtCompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRtCompleteIndue
        return rtCompleteIndue;
    }

    public void setRtCompleteIndue(Integer rtCompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRtCompleteIndue
        this.rtCompleteIndue = rtCompleteIndue;
    }

    public Integer getRtCompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRtCompleteOverdue
        return rtCompleteOverdue;
    }

    public void setRtCompleteOverdue(Integer rtCompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRtCompleteOverdue
        this.rtCompleteOverdue = rtCompleteOverdue;
    }

    public Integer getF5WaitIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5WaitIndue
        return f5WaitIndue;
    }

    public void setF5WaitIndue(Integer f5WaitIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5WaitIndue
        this.f5WaitIndue = f5WaitIndue;
    }

    public Integer getF5WaitOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5WaitOverdue
        return f5WaitOverdue;
    }

    public void setF5WaitOverdue(Integer f5WaitOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5WaitOverdue
        this.f5WaitOverdue = f5WaitOverdue;
    }

    public Integer getF5RejectIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5RejectIndue
        return f5RejectIndue;
    }

    public void setF5RejectIndue(Integer f5RejectIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5RejectIndue
        this.f5RejectIndue = f5RejectIndue;
    }

    public Integer getF5RejectOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5RejectOverdue
        return f5RejectOverdue;
    }

    public void setF5RejectOverdue(Integer f5RejectOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5RejectOverdue
        this.f5RejectOverdue = f5RejectOverdue;
    }

    public Integer getF5CompleteIndue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5CompleteIndue
        return f5CompleteIndue;
    }

    public void setF5CompleteIndue(Integer f5CompleteIndue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5CompleteIndue
        this.f5CompleteIndue = f5CompleteIndue;
    }

    public Integer getF5CompleteOverdue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5CompleteOverdue
        return f5CompleteOverdue;
    }

    public void setF5CompleteOverdue(Integer f5CompleteOverdue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5CompleteOverdue
        this.f5CompleteOverdue = f5CompleteOverdue;
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
    public String toString() { // DMAP Comment : Dead Code Detected - The Following Method has no reference toString
        return "th.co.ais.ipfm.domain1.Iprur001Result1[iprur001Result1PK=" + iprur001Result1PK + "]";
    }

}
