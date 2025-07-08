package th.co.ais.ipfm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

public class IPAccessListTNP {
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

	@Column(name="SOURCE_INTER_NODE", length=255)
	private String sourceInterNode;

	@Column(name="SOURCE_INTER_NW", length=255)
	private String sourceInterNw;

	@Column(name="SOURCE_LOCATION_ID", length=255)
	private String sourceLocationId;

	@Column(name="SOURCE_LOCATION_NAME", length=255)
	private String sourceLocationName;

	@Column(name="SOURCE_NETWORK", length=255)
	private String sourceNetwork;

	@Column(name="DEST_IP", length=255)
	private String destIp;

	@Column(name="DEST_HOST_NAME", length=255)
	private String destHostName;

	@Column(name="DEST_INTER_NODE", length=255)
	private String destInterNode;

	@Column(name="DEST_INTER_NW", length=255)
	private String destInterNw;

	@Column(name="DEST_LOCATION_ID", length=255)
	private String destLocationId;
	
	@Column(name="DEST_LOCATION_NAME", length=255)
	private String destLocationName;

	@Column(name="DEST_NETWORK", length=255)
	private String destNetwork;

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

	public String getSourceInterNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceInterNode
		return sourceInterNode;
	}

	public void setSourceInterNode(String sourceInterNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceInterNode
		this.sourceInterNode = sourceInterNode;
	}

	public String getSourceInterNw() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceInterNw
		return sourceInterNw;
	}

	public void setSourceInterNw(String sourceInterNw) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceInterNw
		this.sourceInterNw = sourceInterNw;
	}

	public String getSourceLocationId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceLocationId
		return sourceLocationId;
	}

	public void setSourceLocationId(String sourceLocationId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceLocationId
		this.sourceLocationId = sourceLocationId;
	}

	public String getSourceLocationName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceLocationName
		return sourceLocationName;
	}

	public void setSourceLocationName(String sourceLocationName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceLocationName
		this.sourceLocationName = sourceLocationName;
	}

	public String getSourceNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceNetwork
		return sourceNetwork;
	}

	public void setSourceNetwork(String sourceNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceNetwork
		this.sourceNetwork = sourceNetwork;
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

	public String getDestInterNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestInterNode
		return destInterNode;
	}

	public void setDestInterNode(String destInterNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestInterNode
		this.destInterNode = destInterNode;
	}

	public String getDestInterNw() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestInterNw
		return destInterNw;
	}

	public void setDestInterNw(String destInterNw) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestInterNw
		this.destInterNw = destInterNw;
	}

	public String getDestLocationId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestLocationId
		return destLocationId;
	}

	public void setDestLocationId(String destLocationId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestLocationId
		this.destLocationId = destLocationId;
	}

	public String getDestLocationName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestLocationName
		return destLocationName;
	}

	public void setDestLocationName(String destLocationName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestLocationName
		this.destLocationName = destLocationName;
	}

	public String getDestNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestNetwork
		return destNetwork;
	}

	public void setDestNetwork(String destNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestNetwork
		this.destNetwork = destNetwork;
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
