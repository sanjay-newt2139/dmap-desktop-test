package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrRouting;
import th.co.ais.ipfm.domain1.IpvJobAssign;


public class IPRoutingBean {
	private String ipAddress;
	private String mask;
	private String isFound;
	private String intf;
	private String nextHop;
	private String description;
	
	private IpUrRouting searchResult;
	private IpvJobAssign jobAssign;
	private List<IpvJobAssign> jobAssignList;
	private String subMode = "ADD";
	private int rowNum;
	private boolean checkAll;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private int pageScroller = 1;
	
	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpAddress
		this.ipAddress = ipAddress;
	}
	public String getMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMask
		return mask;
	}
	public void setMask(String mask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMask
		this.mask = mask;
	}
	public String getIsFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsFound
		return isFound;
	}
	public void setIsFound(String isFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsFound
		this.isFound = isFound;
	}
	public String getIntf() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntf
		return intf;
	}
	public void setIntf(String intf) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIntf
		this.intf = intf;
	}
	public String getNextHop() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNextHop
		return nextHop;
	}
	public void setNextHop(String nextHop) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNextHop
		this.nextHop = nextHop;
	}
	public String getDescription() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDescription
		return description;
	}
	public void setDescription(String description) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDescription
		this.description = description;
	}
	public IpUrRouting getSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchResult
		return searchResult;
	}
	public void setSearchResult(IpUrRouting searchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchResult
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
