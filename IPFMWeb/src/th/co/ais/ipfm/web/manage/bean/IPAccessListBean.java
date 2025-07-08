package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpvJobAssign;

public class IPAccessListBean {
	private String sourceIPStart;
	private String sourceIPEnd;
	private String sourceFound;
	private String sourceName;
	private String sourceEmail;
	
	private String destIPStart;
	private String destIPEnd;
	private String destFound;
	private String destName;
	private String destEmail;
	private boolean checkAll;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private String subMode = "ADD";
	private int rowNum;
	private int pageScroller = 1;
	private IpUrAccessListCdn searchResult;
	private IpvJobAssign jobAssign;
	private List<IpvJobAssign> jobAssignList;
	
	public IpUrAccessListCdn getSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchResult
		return searchResult;
	}
	public void setSearchResult(IpUrAccessListCdn searchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchResult
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssign
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssign
		this.jobAssign = jobAssign;
	}
	public String getSourceIPStart() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceIPStart
		return sourceIPStart;
	}
	public void setSourceIPStart(String sourceIPStart) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceIPStart
		this.sourceIPStart = sourceIPStart;
	}
	public String getSourceIPEnd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceIPEnd
		return sourceIPEnd;
	}
	public void setSourceIPEnd(String sourceIPEnd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceIPEnd
		this.sourceIPEnd = sourceIPEnd;
	}
	public String getSourceFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceFound
		return sourceFound;
	}
	public void setSourceFound(String sourceFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceFound
		this.sourceFound = sourceFound;
	}
	public String getSourceName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceName
		return sourceName;
	}
	public void setSourceName(String sourceName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceName
		this.sourceName = sourceName;
	}
	public String getSourceEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceEmail
		return sourceEmail;
	}
	public void setSourceEmail(String sourceEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceEmail
		this.sourceEmail = sourceEmail;
	}
	public String getDestIPStart() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestIPStart
		return destIPStart;
	}
	public void setDestIPStart(String destIPStart) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestIPStart
		this.destIPStart = destIPStart;
	}
	public String getDestIPEnd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestIPEnd
		return destIPEnd;
	}
	public void setDestIPEnd(String destIPEnd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestIPEnd
		this.destIPEnd = destIPEnd;
	}
	public String getDestFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestFound
		return destFound;
	}
	public void setDestFound(String destFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestFound
		this.destFound = destFound;
	}
	public String getDestName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestName
		return destName;
	}
	public void setDestName(String destName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestName
		this.destName = destName;
	}
	public String getDestEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestEmail
		return destEmail;
	}
	public void setDestEmail(String destEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestEmail
		this.destEmail = destEmail;
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
