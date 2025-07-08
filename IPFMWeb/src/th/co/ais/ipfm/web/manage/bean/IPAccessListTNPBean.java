package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpvJobAssign;

public class IPAccessListTNPBean {
	private String sourceIP;
	private String sourceFound;
	private String sourceHostName;
	private String sourceLocation;
	private String sourceNetwork;
	private String sourceInterfaceNode;
	private String sourceInterfaceNetwork;
	
	private String destIP;
	private String destFound;
	private String destHostName;
	private String destLocation;
	private String destNetwork;
	private String destInterfaceNode;
	private String destInterfaceNetwork;
	
	private String description;
	private String impact;
	private int pageScroller = 1;
	private String subMode = "ADD";
	private int rowNum;
	private boolean checkAll;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private IpUrAccessListTnp searchResult;
	private IpvJobAssign jobAssign;	
	private List<IpvJobAssign> jobAssignList;
	
	public String getSourceIP() {
		return sourceIP;
	}
	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}
	public String getSourceFound() {
		return sourceFound;
	}
	public void setSourceFound(String sourceFound) {
		this.sourceFound = sourceFound;
	}
	public String getSourceHostName() {
		return sourceHostName;
	}
	public void setSourceHostName(String sourceHostName) {
		this.sourceHostName = sourceHostName;
	}
	public String getSourceLocation() {
		return sourceLocation;
	}
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	public String getSourceNetwork() {
		return sourceNetwork;
	}
	public void setSourceNetwork(String sourceNetwork) {
		this.sourceNetwork = sourceNetwork;
	}
	public String getSourceInterfaceNode() {
		return sourceInterfaceNode;
	}
	public void setSourceInterfaceNode(String sourceInterfaceNode) {
		this.sourceInterfaceNode = sourceInterfaceNode;
	}
	public String getSourceInterfaceNetwork() {
		return sourceInterfaceNetwork;
	}
	public void setSourceInterfaceNetwork(String sourceInterfaceNetwork) {
		this.sourceInterfaceNetwork = sourceInterfaceNetwork;
	}
	public String getDestIP() {
		return destIP;
	}
	public void setDestIP(String destIP) {
		this.destIP = destIP;
	}
	public String getDestFound() {
		return destFound;
	}
	public void setDestFound(String destFound) {
		this.destFound = destFound;
	}
	public String getDestHostName() {
		return destHostName;
	}
	public void setDestHostName(String destHostName) {
		this.destHostName = destHostName;
	}
	public String getDestLocation() {
		return destLocation;
	}
	public void setDestLocation(String destLocation) {
		this.destLocation = destLocation;
	}
	public String getDestNetwork() {
		return destNetwork;
	}
	public void setDestNetwork(String destNetwork) {
		this.destNetwork = destNetwork;
	}
	public String getDestInterfaceNode() {
		return destInterfaceNode;
	}
	public void setDestInterfaceNode(String destInterfaceNode) {
		this.destInterfaceNode = destInterfaceNode;
	}
	public String getDestInterfaceNetwork() {
		return destInterfaceNetwork;
	}
	public void setDestInterfaceNetwork(String destInterfaceNetwork) {
		this.destInterfaceNetwork = destInterfaceNetwork;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public IpUrAccessListTnp getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(IpUrAccessListTnp searchResult) {
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() {
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) {
		this.jobAssign = jobAssign;
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
	
}
