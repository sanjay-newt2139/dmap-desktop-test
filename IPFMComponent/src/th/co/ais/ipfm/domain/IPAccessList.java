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

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getItemNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getItemNo
		return itemNo;
	}

	public void setItemNo(String itemNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setItemNo
		this.itemNo = itemNo;
	}

	public String getReqType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqType
		return reqType;
	}

	public void setReqType(String reqType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqType
		this.reqType = reqType;
	}

	public String getSourceIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceIp
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceIp
		this.sourceIp = sourceIp;
	}

	public String getSourceHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceHostName
		return sourceHostName;
	}

	public void setSourceHostName(String sourceHostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceHostName
		this.sourceHostName = sourceHostName;
	}

	public String getSourceEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceEmail
		return sourceEmail;
	}

	public void setSourceEmail(String sourceEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceEmail
		this.sourceEmail = sourceEmail;
	}

	public String getDestIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestIp
		return destIp;
	}

	public void setDestIp(String destIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestIp
		this.destIp = destIp;
	}

	public String getDestHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestHostName
		return destHostName;
	}

	public void setDestHostName(String destHostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestHostName
		this.destHostName = destHostName;
	}

	public String getDestEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestEmail
		return destEmail;
	}

	public void setDestEmail(String destEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestEmail
		this.destEmail = destEmail;
	}

	public String getSysOwnerRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerRemark
		return sysOwnerRemark;
	}

	public void setSysOwnerRemark(String sysOwnerRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerRemark
		this.sysOwnerRemark = sysOwnerRemark;
	}

	public String getIsImpact() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsImpact
		return isImpact;
	}

	public void setIsImpact(String isImpact) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsImpact
		this.isImpact = isImpact;
	}

	public String getPmRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPmRemark
		return pmRemark;
	}

	public void setPmRemark(String pmRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPmRemark
		this.pmRemark = pmRemark;
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

	public String getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(String version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}
	
}
