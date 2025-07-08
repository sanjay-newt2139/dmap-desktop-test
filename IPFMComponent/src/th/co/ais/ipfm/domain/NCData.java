package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NC_DATA_TEMP"
    ,schema="IPFMBK"
)
public class NCData implements Serializable{
	@Column(name="REQ_TYPE", length=255)
	private String reqType;
	
	@Column(name="SUBID", length=255)
	private String subid;
	
	@Column(name="SOURCEIP", length=255)
	private String sourceip;
	
	@Column(name="DESTIP", length=255)
	private String destip;
	
	@Column(name="SHOST", length=255)
	private String shost;
	
	@Column(name="DHOST", length=255)
	private String dhost;
	
	@Column(name="SMAIL", length=255)
	private String smail;
	
	@Column(name="DMAIL", length=255)
	private String dmail;
	
	@Column(name="SNAT", length=255)
	private String snat;
	
	@Column(name="DNAT", length=255)
	private String dnat;
	
	@Column(name="SERVICE", length=255)
	private String service;
	
	@Column(name="TCP", length=255)
	private String tcp;
	
	@Column(name="UDP", length=255)
	private String udp;
	
	@Column(name="PRG_ID", length=255)
	private String prgId;
	
	@Column(name="TEXT_COMMENT", length=255)
	private String textComment;
	
	@Column(name="IMP_DETAIL", length=255)
	private String impDetail;
	
	@Column(name="TOT_JOB", length=255)
	private String totJob;
	
	@Column(name="WCONFIG", length=255)
	private String wconfig;
	
	@Column(name="REJ_JOB", length=255)
	private String rejJob;
	
	@Column(name="COMPLETE_JOB", length=255)
	private String completeJob;
	
	@Column(name="JOB_STS", length=255)
	private String jobSts;
	
	@Column(name="ASSIGN_DETAIL", length=255)
	private String assignDetail;
	
	@Column(name="IMP_FLAG", length=255)
	private String impFlag;
	
	@Column(name="S_INTER_NODE", length=255)
	private String sInterNode;
	
	@Column(name="S_INTER_NW", length=255)
	private String sInterNw;
	
	@Column(name="D_INTER_NODE", length=255)
	private String dInterNode;
	
	@Column(name="D_INTER_NW", length=255)
	private String dInterNw;

	@Column(name="D_NETWORK_IP", length=255)
	private String dNetworkIp;
	
	@Column(name="S_NETWORK_IP", length=255)
	private String sNetworkIp;
	
	@Column(name="D_LOCATION", length=255)
	private String dLocation;
	
	@Column(name="S_LOCATION", length=255)
	private String sLocation;
	
	@Column(name="FLOOR", length=255)
	private String floor;
	
	@Column(name="MAC_ADDRESS", length=255)
	private String macAddress;
	
	@Column(name="SPEED_PORT", length=255)
	private String speedPort;
	
	@Column(name="PORT_STATUS", length=255)
	private String portStatus;
	
	@Column(name="NODE_TYPE", length=255)
	private String nodeType;
	
	@Column(name="NETWORK_TYPE", length=255)
	private String networkType;
	
	@Column(name="MASK", length=255)
	private String mask;
	
	@Column(name="NEXT_HOP", length=255)
	private String nextHop;
	
	@Column(name="INTERFACE_ROUTING", length=255)
	private String interfaceRouting;
	
	@Column(name="IP_PORT", length=255)
	private String ipPort;
	
	@Column(name="IP_POOL", length=255)
	private String ipPool;
	
	@Column(name="VLAN_ID", length=255)
	private String vlanID;
	
	@Column(name="IP_REMARK", length=255)
	private String ipRemark;
	
	@Column(name="VIP", length=255)
	private String vip;
	
	@Column(name="VIP_PORT", length=255)
	private String vipPort;
	
	@Column(name="METHOD", length=255)
	private String method;
	
	@Column(name="WEIGHT", length=255)
	private String weight;
	
	@Column(name="SVIP", length=255)
	private String svip;
	
	@Column(name="DVIP", length=255)
	private String dvip;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	private String rowId;

	
	
	public String getImpFlag() {
		return impFlag;
	}

	public void setImpFlag(String impFlag) {
		this.impFlag = impFlag;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getSubid() {
		return subid;
	}

	public void setSubid(String subid) {
		this.subid = subid;
	}

	public String getSourceip() {
		return sourceip;
	}

	public void setSourceip(String sourceip) {
		this.sourceip = sourceip;
	}

	public String getDestip() {
		return destip;
	}

	public void setDestip(String destip) {
		this.destip = destip;
	}

	public String getShost() {
		return shost;
	}

	public void setShost(String shost) {
		this.shost = shost;
	}

	public String getDhost() {
		return dhost;
	}

	public void setDhost(String dhost) {
		this.dhost = dhost;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public String getDmail() {
		return dmail;
	}

	public void setDmail(String dmail) {
		this.dmail = dmail;
	}

	public String getSnat() {
		return snat;
	}

	public void setSnat(String snat) {
		this.snat = snat;
	}

	public String getDnat() {
		return dnat;
	}

	public void setDnat(String dnat) {
		this.dnat = dnat;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTcp() {
		return tcp;
	}

	public void setTcp(String tcp) {
		this.tcp = tcp;
	}

	public String getUdp() {
		return udp;
	}

	public void setUdp(String udp) {
		this.udp = udp;
	}

	public String getPrgId() {
		return prgId;
	}

	public void setPrgId(String prgId) {
		this.prgId = prgId;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

	public String getImpDetail() {
		return impDetail;
	}

	public void setImpDetail(String impDetail) {
		this.impDetail = impDetail;
	}

	public String getTotJob() {
		return totJob;
	}

	public void setTotJob(String totJob) {
		this.totJob = totJob;
	}

	public String getWconfig() {
		return wconfig;
	}

	public void setWconfig(String wconfig) {
		this.wconfig = wconfig;
	}

	public String getRejJob() {
		return rejJob;
	}

	public void setRejJob(String rejJob) {
		this.rejJob = rejJob;
	}

	public String getCompleteJob() {
		return completeJob;
	}

	public void setCompleteJob(String completeJob) {
		this.completeJob = completeJob;
	}

	public String getJobSts() {
		return jobSts;
	}

	public void setJobSts(String jobSts) {
		this.jobSts = jobSts;
	}

	public String getAssignDetail() {
		return assignDetail;
	}

	public void setAssignDetail(String assignDetail) {
		this.assignDetail = assignDetail;
	}

	public String getsInterNode() {
		return sInterNode;
	}

	public void setsInterNode(String sInterNode) {
		this.sInterNode = sInterNode;
	}

	public String getsInterNw() {
		return sInterNw;
	}

	public void setsInterNw(String sInterNw) {
		this.sInterNw = sInterNw;
	}

	public String getdInterNode() {
		return dInterNode;
	}

	public void setdInterNode(String dInterNode) {
		this.dInterNode = dInterNode;
	}

	public String getdInterNw() {
		return dInterNw;
	}

	public void setdInterNw(String dInterNw) {
		this.dInterNw = dInterNw;
	}

	public String getdNetworkIp() {
		return dNetworkIp;
	}

	public void setdNetworkIp(String dNetworkIp) {
		this.dNetworkIp = dNetworkIp;
	}

	public String getsNetworkIp() {
		return sNetworkIp;
	}

	public void setsNetworkIp(String sNetworkIp) {
		this.sNetworkIp = sNetworkIp;
	}

	public String getdLocation() {
		return dLocation;
	}

	public void setdLocation(String dLocation) {
		this.dLocation = dLocation;
	}

	public String getsLocation() {
		return sLocation;
	}

	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getSpeedPort() {
		return speedPort;
	}

	public void setSpeedPort(String speedPort) {
		this.speedPort = speedPort;
	}

	public String getPortStatus() {
		return portStatus;
	}

	public void setPortStatus(String portStatus) {
		this.portStatus = portStatus;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getNextHop() {
		return nextHop;
	}

	public void setNextHop(String nextHop) {
		this.nextHop = nextHop;
	}

	public String getInterfaceRouting() {
		return interfaceRouting;
	}

	public void setInterfaceRouting(String interfaceRouting) {
		this.interfaceRouting = interfaceRouting;
	}

	public String getIpPort() {
		return ipPort;
	}

	public void setIpPort(String ipPort) {
		this.ipPort = ipPort;
	}

	public String getIpPool() {
		return ipPool;
	}

	public void setIpPool(String ipPool) {
		this.ipPool = ipPool;
	}

	public String getVlanID() {
		return vlanID;
	}

	public void setVlanID(String vlanID) {
		this.vlanID = vlanID;
	}

	public String getIpRemark() {
		return ipRemark;
	}

	public void setIpRemark(String ipRemark) {
		this.ipRemark = ipRemark;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getVipPort() {
		return vipPort;
	}

	public void setVipPort(String vipPort) {
		this.vipPort = vipPort;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSvip() {
		return svip;
	}

	public void setSvip(String svip) {
		this.svip = svip;
	}

	public String getDvip() {
		return dvip;
	}

	public void setDvip(String dvip) {
		this.dvip = dvip;
	}

	
	
	
	
	
}





















