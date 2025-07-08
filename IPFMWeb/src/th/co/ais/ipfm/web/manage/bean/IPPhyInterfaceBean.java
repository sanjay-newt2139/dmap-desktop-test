package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class IPPhyInterfaceBean {
	private String ipNode;
	private String ipFound;
	private String hostName;
	private String location;
	private String vlanID;
	private String macAddress;
	private String floor;
	
	private IPFMRichComboItem intfNodeType;
	private String intfNodeTypeDesc;
	private String interfaceDesc;
	private IPFMRichComboItem portStatus;
	private String portStatusDesc;
	private IPFMRichComboItem speedPort;
	private String speedPortDesc;
	private String enclosure;
	private String reqRemark;
	private boolean checkAll;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private int pageScroller = 1;
	private IpUrPhysicalInterface searchResult;
	private IpvJobAssign jobAssign;
    private List<IpvJobAssign> jobAssignList;
    
	private String subMode = "ADD";
	private int rowNum;
	
	private String piType = "A";
	private String trunkNo = "TK001";
	
	public String getMacAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMacAddress
		return macAddress;
	}
	public void setMacAddress(String macAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMacAddress
		this.macAddress = macAddress;
	}
	public String getIpNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpNode
		return ipNode;
	}
	public void setIpNode(String ipNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpNode
		this.ipNode = ipNode;
	}
	public String getIpFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpFound
		return ipFound;
	}
	public void setIpFound(String ipFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpFound
		this.ipFound = ipFound;
	}
	public String getHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHostName
		return hostName;
	}
	public void setHostName(String hostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHostName
		this.hostName = hostName;
	}
	public String getLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocation
		return location;
	}
	public void setLocation(String location) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocation
		this.location = location;
	}
	public String getVlanID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVlanID
		return vlanID;
	}
	public void setVlanID(String vlanID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVlanID
		this.vlanID = vlanID;
	}
	public IPFMRichComboItem getIntfNodeType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntfNodeType
		return intfNodeType;
	}
	public void setIntfNodeType(IPFMRichComboItem intfNodeType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntfNodeType
		this.intfNodeType = intfNodeType;
	}
	public String getInterfaceDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInterfaceDesc
		return interfaceDesc;
	}
	public void setInterfaceDesc(String interfaceDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInterfaceDesc
		this.interfaceDesc = interfaceDesc;
	}
	public IPFMRichComboItem getPortStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPortStatus
		return portStatus;
	}
	public void setPortStatus(IPFMRichComboItem portStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPortStatus
		this.portStatus = portStatus;
	}
	public IPFMRichComboItem getSpeedPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSpeedPort
		return speedPort;
	}
	public void setSpeedPort(IPFMRichComboItem speedPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSpeedPort
		this.speedPort = speedPort;
	}
	public String getEnclosure() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnclosure
		return enclosure;
	}
	public void setEnclosure(String enclosure) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnclosure
		this.enclosure = enclosure;
	}
	public String getReqRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqRemark
		return reqRemark;
	}
	public void setReqRemark(String reqRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqRemark
		this.reqRemark = reqRemark;
	}
	public String getFloor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFloor
		return floor;
	}
	public void setFloor(String floor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFloor
		this.floor = floor;
	}
	public IpUrPhysicalInterface getSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchResult
		return searchResult;
	}
	public void setSearchResult(IpUrPhysicalInterface searchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchResult
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssign
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssign
		this.jobAssign = jobAssign;
	}
	public String getIntfNodeTypeDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntfNodeTypeDesc
		return intfNodeTypeDesc;
	}
	public void setIntfNodeTypeDesc(String intfNodeTypeDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntfNodeTypeDesc
		this.intfNodeTypeDesc = intfNodeTypeDesc;
	}
	public String getPortStatusDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPortStatusDesc
		return portStatusDesc;
	}
	public void setPortStatusDesc(String portStatusDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPortStatusDesc
		this.portStatusDesc = portStatusDesc;
	}
	public String getSpeedPortDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSpeedPortDesc
		return speedPortDesc;
	}
	public void setSpeedPortDesc(String speedPortDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSpeedPortDesc
		this.speedPortDesc = speedPortDesc;
	}
	public String getSubMode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubMode
		return subMode;
	}
	public void setSubMode(String subMode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubMode
		this.subMode = subMode;
	}
	public int getRowNum() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowNum
		return rowNum;
	}
	public void setRowNum(int rowNum) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowNum
		this.rowNum = rowNum;
	}
	public boolean isCheckAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckAll
		return checkAll;
	}
	public void setCheckAll(boolean checkAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckAll
		this.checkAll = checkAll;
	}
	public List<IpvJobAssign> getJobAssignList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssignList
		return jobAssignList;
	}
	public void setJobAssignList(List<IpvJobAssign> jobAssignList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssignList
		this.jobAssignList = jobAssignList;
	}
	public boolean isApproveAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isApproveAll
		return approveAll;
	}
	public void setApproveAll(boolean approveAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setApproveAll
		this.approveAll = approveAll;
	}
	public boolean isRejectAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isRejectAll
		return rejectAll;
	}
	public void setRejectAll(boolean rejectAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRejectAll
		this.rejectAll = rejectAll;
	}
	public int getPageScroller() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPageScroller
		return pageScroller;
	}
	public void setPageScroller(int pageScroller) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPageScroller
		this.pageScroller = pageScroller;
	}
	public void setImpactAll(boolean impactAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImpactAll
		this.impactAll = impactAll;
	}
	public boolean isImpactAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isImpactAll
		return impactAll;
	}
	public String getPiType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPiType
		return piType;
	}
	public void setPiType(String piType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPiType
		this.piType = piType;
	}
	public String getTrunkNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTrunkNo
		return trunkNo;
	}
	public void setTrunkNo(String trunkNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTrunkNo
		this.trunkNo = trunkNo;
	}
	
}
