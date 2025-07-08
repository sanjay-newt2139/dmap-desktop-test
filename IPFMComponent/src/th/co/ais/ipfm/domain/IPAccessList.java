package th.co.ais.ipfm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="IP_UR_ACCESS_LIST"
    ,schema="IPFMBK"
)
public class IPAccessList {
	@Column(name="UR_NO", length=255)
	private String urNo;
	
	@Column(name="ITEM_NO", length=255)
	private String itemNo;
	
	@Column(name="REQ_TYPE", length=255)
	private String reqType;
	
	@Column(name="SOURCE_IP", length=255)
	private String sourceIp;
	
	@Column(name="SOURCE_HOST_NAME", length=255)
	private String sourceHostName;
	
	@Column(name="SOURCE_EMAIL", length=255)
	private String sourceEmail;
	
	@Column(name="DEST_IP", length=255)
	private String destIp;
	
	@Column(name="DEST_HOST_NAME", length=255)
	private String destHostName;
	
	@Column(name="DEST_EMAIL", length=255)
	private String destEmail;
	
	@Column(name="SYS_OWNER_REMARK", length=255)
	private String sysOwnerRemark;
	
	@Column(name="IS_IMPACT", length=255)
	private String isImpact;
	
	@Column(name="PM_REMARK", length=255)
	private String pmRemark;
	
	@Column(name="CREATE_BY", length=255)
	private String createBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE", length=10)
	private Date createDate;
	
	@Column(name="UPDATE_BY", length=255)
	private String updateBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE", length=10)
	private Date updateDate;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	private String rowId;
	
	@Column(name="VERSION", length=255)
	private String version;

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getSourceHostName() {
		return sourceHostName;
	}

	public void setSourceHostName(String sourceHostName) {
		this.sourceHostName = sourceHostName;
	}

	public String getSourceEmail() {
		return sourceEmail;
	}

	public void setSourceEmail(String sourceEmail) {
		this.sourceEmail = sourceEmail;
	}

	public String getDestIp() {
		return destIp;
	}

	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}

	public String getDestHostName() {
		return destHostName;
	}

	public void setDestHostName(String destHostName) {
		this.destHostName = destHostName;
	}

	public String getDestEmail() {
		return destEmail;
	}

	public void setDestEmail(String destEmail) {
		this.destEmail = destEmail;
	}

	public String getSysOwnerRemark() {
		return sysOwnerRemark;
	}

	public void setSysOwnerRemark(String sysOwnerRemark) {
		this.sysOwnerRemark = sysOwnerRemark;
	}

	public String getIsImpact() {
		return isImpact;
	}

	public void setIsImpact(String isImpact) {
		this.isImpact = isImpact;
	}

	public String getPmRemark() {
		return pmRemark;
	}

	public void setPmRemark(String pmRemark) {
		this.pmRemark = pmRemark;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
