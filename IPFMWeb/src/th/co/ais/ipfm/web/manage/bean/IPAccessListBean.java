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
	
	public IpUrAccessListCdn getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(IpUrAccessListCdn searchResult) {
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() {
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) {
		this.jobAssign = jobAssign;
	}
	public String getSourceIPStart() {
		return sourceIPStart;
	}
	public void setSourceIPStart(String sourceIPStart) {
		this.sourceIPStart = sourceIPStart;
	}
	public String getSourceIPEnd() {
		return sourceIPEnd;
	}
	public void setSourceIPEnd(String sourceIPEnd) {
		this.sourceIPEnd = sourceIPEnd;
	}
	public String getSourceFound() {
		return sourceFound;
	}
	public void setSourceFound(String sourceFound) {
		this.sourceFound = sourceFound;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceEmail() {
		return sourceEmail;
	}
	public void setSourceEmail(String sourceEmail) {
		this.sourceEmail = sourceEmail;
	}
	public String getDestIPStart() {
		return destIPStart;
	}
	public void setDestIPStart(String destIPStart) {
		this.destIPStart = destIPStart;
	}
	public String getDestIPEnd() {
		return destIPEnd;
	}
	public void setDestIPEnd(String destIPEnd) {
		this.destIPEnd = destIPEnd;
	}
	public String getDestFound() {
		return destFound;
	}
	public void setDestFound(String destFound) {
		this.destFound = destFound;
	}
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public String getDestEmail() {
		return destEmail;
	}
	public void setDestEmail(String destEmail) {
		this.destEmail = destEmail;
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
