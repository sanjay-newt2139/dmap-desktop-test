package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="IP_UR_FIREWALL"
    ,schema="IPFMBK"
)
public class IPFirewall implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="UR_NO", length=255)
	private String urNo;
	
	@Column(name="ITEM_NO", length=255)
	private String itemNo;
	
	@Column(name="REQ_TYPE", length=255)
	private String reqType;

	@Embedded
	private IPFMSourceIP source;
/*	
	@Column(name="SOURCE_IP", length=100)
	private String sourceIp;
	
	@Column(name="SOURCE_HOST_NAME", length=100)
	private String sourceHostName;
	
	@Column(name="SOURCE_EMAIL", length=100)
	private String sourceEmail;
	
	@Column(name="SOURCE_NAT_IP", length=100)
	private String sourceNatIp;
*/	
	@Embedded
	private IPFMDestIP dest;
/*	@Column(name="DEST_IP", length=100)
	private String destIp;
	
	@Column(name="DEST_HOST_NAME", length=100)
	private String destHostName;
	
	@Column(name="DEST_EMAIL", length=100)
	private String destEmail;
	
	@Column(name="DEST_NAT_IP", length=100)
	private String destNatIp;
*/	
	@Embedded
	private IPFMServiceInfo service;
/*	@Column(name="SERVICE_STATUS", length=100)
	private String serviceStatus;
	
	@Column(name="SERVICE_ID", length=100)
	private String serviceId;
	
	@Column(name="SERVICE_NAME", length=100)
	private String serviceName;
	
	@Column(name="SERVICE_TCP_STATUS", length=100)
	private String serviceTcpStatus;
	
	@Column(name="SERVICE_TCP_PORT", length=100)
	private String serviceTcpPort;
	
	@Column(name="SERVICE_UDP_STATUS", length=100)
	private String serviceUdpStatus;
	
	@Column(name="SERVICE_UDP_PORT", length=100)
	private String serviceUdpPort;
*/	
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
	
	@Version
	@Column(name="VERSION")
	private Integer version;

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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public IPFMSourceIP getSource() {
		return source;
	}

	public void setSource(IPFMSourceIP source) {
		this.source = source;
	}

	public IPFMDestIP getDest() {
		return dest;
	}

	public void setDest(IPFMDestIP dest) {
		this.dest = dest;
	}

	public IPFMServiceInfo getService() {
		return service;
	}

	public void setService(IPFMServiceInfo service) {
		this.service = service;
	}

	
	
}
