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

	public String getSourceInterNode() {
		return sourceInterNode;
	}

	public void setSourceInterNode(String sourceInterNode) {
		this.sourceInterNode = sourceInterNode;
	}

	public String getSourceInterNw() {
		return sourceInterNw;
	}

	public void setSourceInterNw(String sourceInterNw) {
		this.sourceInterNw = sourceInterNw;
	}

	public String getSourceLocationId() {
		return sourceLocationId;
	}

	public void setSourceLocationId(String sourceLocationId) {
		this.sourceLocationId = sourceLocationId;
	}

	public String getSourceLocationName() {
		return sourceLocationName;
	}

	public void setSourceLocationName(String sourceLocationName) {
		this.sourceLocationName = sourceLocationName;
	}

	public String getSourceNetwork() {
		return sourceNetwork;
	}

	public void setSourceNetwork(String sourceNetwork) {
		this.sourceNetwork = sourceNetwork;
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

	public String getDestInterNode() {
		return destInterNode;
	}

	public void setDestInterNode(String destInterNode) {
		this.destInterNode = destInterNode;
	}

	public String getDestInterNw() {
		return destInterNw;
	}

	public void setDestInterNw(String destInterNw) {
		this.destInterNw = destInterNw;
	}

	public String getDestLocationId() {
		return destLocationId;
	}

	public void setDestLocationId(String destLocationId) {
		this.destLocationId = destLocationId;
	}

	public String getDestLocationName() {
		return destLocationName;
	}

	public void setDestLocationName(String destLocationName) {
		this.destLocationName = destLocationName;
	}

	public String getDestNetwork() {
		return destNetwork;
	}

	public void setDestNetwork(String destNetwork) {
		this.destNetwork = destNetwork;
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
