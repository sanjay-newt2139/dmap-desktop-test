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
	
	public String getSourceIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceIP
		return sourceIP;
	}
	public void setSourceIP(String sourceIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceIP
		this.sourceIP = sourceIP;
	}
	public String getSourceFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceFound
		return sourceFound;
	}
	public void setSourceFound(String sourceFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceFound
		this.sourceFound = sourceFound;
	}
	public String getSourceHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceHostName
		return sourceHostName;
	}
	public void setSourceHostName(String sourceHostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceHostName
		this.sourceHostName = sourceHostName;
	}
	public String getSourceLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceLocation
		return sourceLocation;
	}
	public void setSourceLocation(String sourceLocation) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceLocation
		this.sourceLocation = sourceLocation;
	}
	public String getSourceNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceNetwork
		return sourceNetwork;
	}
	public void setSourceNetwork(String sourceNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceNetwork
		this.sourceNetwork = sourceNetwork;
	}
	public String getSourceInterfaceNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceInterfaceNode
		return sourceInterfaceNode;
	}
	public void setSourceInterfaceNode(String sourceInterfaceNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceInterfaceNode
		this.sourceInterfaceNode = sourceInterfaceNode;
	}
	public String getSourceInterfaceNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceInterfaceNetwork
		return sourceInterfaceNetwork;
	}
	public void setSourceInterfaceNetwork(String sourceInterfaceNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceInterfaceNetwork
		this.sourceInterfaceNetwork = sourceInterfaceNetwork;
	}
	public String getDestIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestIP
		return destIP;
	}
	public void setDestIP(String destIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestIP
		this.destIP = destIP;
	}
	public String getDestFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestFound
		return destFound;
	}
	public void setDestFound(String destFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestFound
		this.destFound = destFound;
	}
	public String getDestHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestHostName
		return destHostName;
	}
	public void setDestHostName(String destHostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestHostName
		this.destHostName = destHostName;
	}
	public String getDestLocation() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestLocation
		return destLocation;
	}
	public void setDestLocation(String destLocation) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestLocation
		this.destLocation = destLocation;
	}
	public String getDestNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestNetwork
		return destNetwork;
	}
	public void setDestNetwork(String destNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestNetwork
		this.destNetwork = destNetwork;
	}
	public String getDestInterfaceNode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestInterfaceNode
		return destInterfaceNode;
	}
	public void setDestInterfaceNode(String destInterfaceNode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestInterfaceNode
		this.destInterfaceNode = destInterfaceNode;
	}
	public String getDestInterfaceNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestInterfaceNetwork
		return destInterfaceNetwork;
	}
	public void setDestInterfaceNetwork(String destInterfaceNetwork) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestInterfaceNetwork
		this.destInterfaceNetwork = destInterfaceNetwork;
	}
	public String getDescription() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDescription
		return description;
	}
	public void setDescription(String description) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDescription
		this.description = description;
	}
	public String getImpact() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getImpact
		return impact;
	}
	public void setImpact(String impact) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImpact
		this.impact = impact;
	}
	public IpUrAccessListTnp getSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchResult
		return searchResult;
	}
	public void setSearchResult(IpUrAccessListTnp searchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchResult
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssign
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssign
		this.jobAssign = jobAssign;
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
	
}
