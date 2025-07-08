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

	
	
	public String getImpFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getImpFlag
		return impFlag;
	}

	public void setImpFlag(String impFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImpFlag
		this.impFlag = impFlag;
	}

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public String getReqType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqType
		return reqType;
	}

	public void setReqType(String reqType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqType
		this.reqType = reqType;
	}

	public String getSubid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubid
		return subid;
	}

	public void setSubid(String subid) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubid
		this.subid = subid;
	}

	public String getSourceip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceip
		return sourceip;
	}

	public void setSourceip(String sourceip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceip
		this.sourceip = sourceip;
	}

	public String getDestip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestip
		return destip;
	}

	public void setDestip(String destip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestip
		this.destip = destip;
	}

	public String getShost() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShost
		return shost;
	}

	public void setShost(String shost) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShost
		this.shost = shost;
	}

	public String getDhost() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDhost
		return dhost;
	}

	public void setDhost(String dhost) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDhost
		this.dhost = dhost;
	}

	public String getSmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSmail
		return smail;
	}

	public void setSmail(String smail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSmail
		this.smail = smail;
	}

	public String getDmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDmail
		return dmail;
	}

	public void setDmail(String dmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDmail
		this.dmail = dmail;
	}

	public String getSnat() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSnat
		return snat;
	}

	public void setSnat(String snat) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSnat
		this.snat = snat;
	}

	public String getDnat() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDnat
		return dnat;
	}

	public void setDnat(String dnat) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDnat
		this.dnat = dnat;
	}

	public String getService() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getService
		return service;
	}

	public void setService(String service) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setService
		this.service = service;
	}

	public String getTcp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTcp
		return tcp;
	}

	public void setTcp(String tcp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTcp
		this.tcp = tcp;
	}

	public String getUdp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUdp
		return udp;
	}

	public void setUdp(String udp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUdp
		this.udp = udp;
	}

	public String getPrgId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPrgId
		return prgId;
	}

	public void setPrgId(String prgId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPrgId
		this.prgId = prgId;
	}

	public String getTextComment() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTextComment
		return textComment;
	}

	public void setTextComment(String textComment) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTextComment
		this.textComment = textComment;
	}

	public String getImpDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getImpDetail
		return impDetail;
	}

	public void setImpDetail(String impDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImpDetail
		this.impDetail = impDetail;
	}

	public String getTotJob() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotJob
		return totJob;
	}

	public void setTotJob(String totJob) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotJob
		this.totJob = totJob;
	}

	public String getWconfig() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWconfig
		return wconfig;
	}

	public void setWconfig(String wconfig) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWconfig
		this.wconfig = wconfig;
	}

	public String getRejJob() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRejJob
		return rejJob;
	}

	public void setRejJob(String rejJob) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRejJob
		this.rejJob = rejJob;
	}

	public String getCompleteJob() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompleteJob
		return completeJob;
	}

	public void setCompleteJob(String completeJob) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompleteJob
		this.completeJob = completeJob;
	}

	public String getJobSts() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobSts
		return jobSts;
	}

	public void setJobSts(String jobSts) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobSts
		this.jobSts = jobSts;
	}

	public String getAssignDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignDetail
		return assignDetail;
	}

	public void setAssignDetail(String assignDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignDetail
		this.assignDetail = assignDetail;
	}

	public String getsInterNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getsInterNode
		return sInterNode;
	}

	public void setsInterNode(String sInterNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setsInterNode
		this.sInterNode = sInterNode;
	}

	public String getsInterNw() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getsInterNw
		return sInterNw;
	}

	public void setsInterNw(String sInterNw) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setsInterNw
		this.sInterNw = sInterNw;
	}

	public String getdInterNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getdInterNode
		return dInterNode;
	}

	public void setdInterNode(String dInterNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setdInterNode
		this.dInterNode = dInterNode;
	}

	public String getdInterNw() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getdInterNw
		return dInterNw;
	}

	public void setdInterNw(String dInterNw) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setdInterNw
		this.dInterNw = dInterNw;
	}

	public String getdNetworkIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getdNetworkIp
		return dNetworkIp;
	}

	public void setdNetworkIp(String dNetworkIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setdNetworkIp
		this.dNetworkIp = dNetworkIp;
	}

	public String getsNetworkIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getsNetworkIp
		return sNetworkIp;
	}

	public void setsNetworkIp(String sNetworkIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setsNetworkIp
		this.sNetworkIp = sNetworkIp;
	}

	public String getdLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getdLocation
		return dLocation;
	}

	public void setdLocation(String dLocation) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setdLocation
		this.dLocation = dLocation;
	}

	public String getsLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getsLocation
		return sLocation;
	}

	public void setsLocation(String sLocation) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setsLocation
		this.sLocation = sLocation;
	}

	public String getFloor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFloor
		return floor;
	}

	public void setFloor(String floor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFloor
		this.floor = floor;
	}

	public String getMacAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMacAddress
		return macAddress;
	}

	public void setMacAddress(String macAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMacAddress
		this.macAddress = macAddress;
	}

	public String getSpeedPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSpeedPort
		return speedPort;
	}

	public void setSpeedPort(String speedPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSpeedPort
		this.speedPort = speedPort;
	}

	public String getPortStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPortStatus
		return portStatus;
	}

	public void setPortStatus(String portStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPortStatus
		this.portStatus = portStatus;
	}

	public String getNodeType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNodeType
		return nodeType;
	}

	public void setNodeType(String nodeType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNodeType
		this.nodeType = nodeType;
	}

	public String getNetworkType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkType
		return networkType;
	}

	public void setNetworkType(String networkType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkType
		this.networkType = networkType;
	}

	public String getMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMask
		return mask;
	}

	public void setMask(String mask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMask
		this.mask = mask;
	}

	public String getNextHop() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNextHop
		return nextHop;
	}

	public void setNextHop(String nextHop) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNextHop
		this.nextHop = nextHop;
	}

	public String getInterfaceRouting() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInterfaceRouting
		return interfaceRouting;
	}

	public void setInterfaceRouting(String interfaceRouting) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInterfaceRouting
		this.interfaceRouting = interfaceRouting;
	}

	public String getIpPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpPort
		return ipPort;
	}

	public void setIpPort(String ipPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpPort
		this.ipPort = ipPort;
	}

	public String getIpPool() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpPool
		return ipPool;
	}

	public void setIpPool(String ipPool) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpPool
		this.ipPool = ipPool;
	}

	public String getVlanID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVlanID
		return vlanID;
	}

	public void setVlanID(String vlanID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVlanID
		this.vlanID = vlanID;
	}

	public String getIpRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRemark
		return ipRemark;
	}

	public void setIpRemark(String ipRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRemark
		this.ipRemark = ipRemark;
	}

	public String getVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVip
		return vip;
	}

	public void setVip(String vip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVip
		this.vip = vip;
	}

	public String getVipPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVipPort
		return vipPort;
	}

	public void setVipPort(String vipPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVipPort
		this.vipPort = vipPort;
	}

	public String getMethod() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMethod
		return method;
	}

	public void setMethod(String method) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMethod
		this.method = method;
	}

	public String getWeight() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWeight
		return weight;
	}

	public void setWeight(String weight) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWeight
		this.weight = weight;
	}

	public String getSvip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSvip
		return svip;
	}

	public void setSvip(String svip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSvip
		this.svip = svip;
	}

	public String getDvip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDvip
		return dvip;
	}

	public void setDvip(String dvip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDvip
		this.dvip = dvip;
	}

	
	
	
	
	
}





















