package th.co.ais.ipfm.web.manage.bean;

import java.util.List;
import java.util.Set;

import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpvJobAssign;


public class IPF5Bean {
	private String vip;
	private String ipPort;
	
	private String isSnatIP;
	private String isSnatIPTxt;
	private String snatIp;
	private String persistence;
	private String persistenceTxt;
	private String method;
	private String methodTxt;
	
	private String ipPool;
	private String ipPoolPort;
	private String ipWeight;
	
	private IpUrF5 searchResult;
	private IpvJobAssign jobAssign;
	private Boolean retriveFound = false;
	private String errorMessage;
	private String isFound;
	private boolean checkAll;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private String subMode = "ADD";
	private int rowNum;		
	private int pageScroller = 1;
	private List<IpvJobAssign> jobAssignList;
	private Set<String> vipIndexCache;

	public IpUrF5 getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(IpUrF5 searchResult) {
		this.searchResult = searchResult;
	}

	public IpvJobAssign getJobAssign() {
		return jobAssign;
	}

	public void setJobAssign(IpvJobAssign jobAssign) {
		this.jobAssign = jobAssign;
	}

	public String getPersistence() {
		return persistence;
	}

	public void setPersistence(String persistence) {
		this.persistence = persistence;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getIpPort() {
		return ipPort;
	}

	public void setIpPort(String ipPort) {
		this.ipPort = ipPort;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getIsSnatIP() {
		return isSnatIP;
	}

	public void setIsSnatIP(String isSnatIP) {
		this.isSnatIP = isSnatIP;
	}

	public String getSnatIp() {
		return snatIp;
	}

	public void setSnatIp(String snatIp) {
		this.snatIp = snatIp;
	}

	public String getIsSnatIPTxt() {
		return isSnatIPTxt;
	}

	public void setIsSnatIPTxt(String isSnatIPTxt) {
		this.isSnatIPTxt = isSnatIPTxt;
	}

	public String getPersistenceTxt() {
		return persistenceTxt;
	}

	public void setPersistenceTxt(String persistenceTxt) {
		this.persistenceTxt = persistenceTxt;
	}

	public String getMethodTxt() {
		return methodTxt;
	}

	public void setMethodTxt(String methodTxt) {
		this.methodTxt = methodTxt;
	}

	public String getIpPool() {
		return ipPool;
	}

	public void setIpPool(String ipPool) {
		this.ipPool = ipPool;
	}

	public String getIpPoolPort() {
		return ipPoolPort;
	}

	public void setIpPoolPort(String ipPoolPort) {
		this.ipPoolPort = ipPoolPort;
	}

	public String getIpWeight() {
		return ipWeight;
	}

	public void setIpWeight(String ipWeight) {
		this.ipWeight = ipWeight;
	}

	public Boolean getRetriveFound() {
		return retriveFound;
	}

	public void setRetriveFound(Boolean retriveFound) {
		this.retriveFound = retriveFound;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getIsFound() {
		return isFound;
	}

	public void setIsFound(String isFound) {
		this.isFound = isFound;
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


	public Set<String> getVipIndexCache() {
		return vipIndexCache;
	}

	public void setVipIndexCache(Set<String> vipIndexCache) {
		this.vipIndexCache = vipIndexCache;
	}

	public void setImpactAll(boolean impactAll) {
		this.impactAll = impactAll;
	}

	public boolean isImpactAll() {
		return impactAll;
	}
	
	
	
	
}
