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
	
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getIpNode() {
		return ipNode;
	}
	public void setIpNode(String ipNode) {
		this.ipNode = ipNode;
	}
	public String getIpFound() {
		return ipFound;
	}
	public void setIpFound(String ipFound) {
		this.ipFound = ipFound;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getVlanID() {
		return vlanID;
	}
	public void setVlanID(String vlanID) {
		this.vlanID = vlanID;
	}
	public IPFMRichComboItem getIntfNodeType() {
		return intfNodeType;
	}
	public void setIntfNodeType(IPFMRichComboItem intfNodeType) {
		this.intfNodeType = intfNodeType;
	}
	public String getInterfaceDesc() {
		return interfaceDesc;
	}
	public void setInterfaceDesc(String interfaceDesc) {
		this.interfaceDesc = interfaceDesc;
	}
	public IPFMRichComboItem getPortStatus() {
		return portStatus;
	}
	public void setPortStatus(IPFMRichComboItem portStatus) {
		this.portStatus = portStatus;
	}
	public IPFMRichComboItem getSpeedPort() {
		return speedPort;
	}
	public void setSpeedPort(IPFMRichComboItem speedPort) {
		this.speedPort = speedPort;
	}
	public String getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}
	public String getReqRemark() {
		return reqRemark;
	}
	public void setReqRemark(String reqRemark) {
		this.reqRemark = reqRemark;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public IpUrPhysicalInterface getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(IpUrPhysicalInterface searchResult) {
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() {
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) {
		this.jobAssign = jobAssign;
	}
	public String getIntfNodeTypeDesc() {
		return intfNodeTypeDesc;
	}
	public void setIntfNodeTypeDesc(String intfNodeTypeDesc) {
		this.intfNodeTypeDesc = intfNodeTypeDesc;
	}
	public String getPortStatusDesc() {
		return portStatusDesc;
	}
	public void setPortStatusDesc(String portStatusDesc) {
		this.portStatusDesc = portStatusDesc;
	}
	public String getSpeedPortDesc() {
		return speedPortDesc;
	}
	public void setSpeedPortDesc(String speedPortDesc) {
		this.speedPortDesc = speedPortDesc;
	}
	public String getSubMode() {
		return subMode;
	}
	public void setSubMode(String subMode) {
		this.subMode = subMode;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public boolean isCheckAll() {
		return checkAll;
	}
	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	}
	public List<IpvJobAssign> getJobAssignList() {
		return jobAssignList;
	}
	public void setJobAssignList(List<IpvJobAssign> jobAssignList) {
		this.jobAssignList = jobAssignList;
	}
	public boolean isApproveAll() {
		return approveAll;
	}
	public void setApproveAll(boolean approveAll) {
		this.approveAll = approveAll;
	}
	public boolean isRejectAll() {
		return rejectAll;
	}
	public void setRejectAll(boolean rejectAll) {
		this.rejectAll = rejectAll;
	}
	public int getPageScroller() {
		return pageScroller;
	}
	public void setPageScroller(int pageScroller) {
		this.pageScroller = pageScroller;
	}
	public void setImpactAll(boolean impactAll) {
		this.impactAll = impactAll;
	}
	public boolean isImpactAll() {
		return impactAll;
	}
	public String getPiType() {
		return piType;
	}
	public void setPiType(String piType) {
		this.piType = piType;
	}
	public String getTrunkNo() {
		return trunkNo;
	}
	public void setTrunkNo(String trunkNo) {
		this.trunkNo = trunkNo;
	}
	
}
