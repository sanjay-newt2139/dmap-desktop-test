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

	public IpUrF5 getSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchResult
		return searchResult;
	}

	public void setSearchResult(IpUrF5 searchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchResult
		this.searchResult = searchResult;
	}

	public IpvJobAssign getJobAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssign
		return jobAssign;
	}

	public void setJobAssign(IpvJobAssign jobAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssign
		this.jobAssign = jobAssign;
	}

	public String getPersistence() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPersistence
		return persistence;
	}

	public void setPersistence(String persistence) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPersistence
		this.persistence = persistence;
	}

	public String getMethod() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMethod
		return method;
	}

	public void setMethod(String method) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMethod
		this.method = method;
	}

	public String getIpPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpPort
		return ipPort;
	}

	public void setIpPort(String ipPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpPort
		this.ipPort = ipPort;
	}

	public String getVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVip
		return vip;
	}

	public void setVip(String vip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVip
		this.vip = vip;
	}

	public String getIsSnatIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsSnatIP
		return isSnatIP;
	}

	public void setIsSnatIP(String isSnatIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsSnatIP
		this.isSnatIP = isSnatIP;
	}

	public String getSnatIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSnatIp
		return snatIp;
	}

	public void setSnatIp(String snatIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSnatIp
		this.snatIp = snatIp;
	}

	public String getIsSnatIPTxt() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsSnatIPTxt
		return isSnatIPTxt;
	}

	public void setIsSnatIPTxt(String isSnatIPTxt) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsSnatIPTxt
		this.isSnatIPTxt = isSnatIPTxt;
	}

	public String getPersistenceTxt() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPersistenceTxt
		return persistenceTxt;
	}

	public void setPersistenceTxt(String persistenceTxt) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPersistenceTxt
		this.persistenceTxt = persistenceTxt;
	}

	public String getMethodTxt() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMethodTxt
		return methodTxt;
	}

	public void setMethodTxt(String methodTxt) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMethodTxt
		this.methodTxt = methodTxt;
	}

	public String getIpPool() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpPool
		return ipPool;
	}

	public void setIpPool(String ipPool) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpPool
		this.ipPool = ipPool;
	}

	public String getIpPoolPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpPoolPort
		return ipPoolPort;
	}

	public void setIpPoolPort(String ipPoolPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpPoolPort
		this.ipPoolPort = ipPoolPort;
	}

	public String getIpWeight() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpWeight
		return ipWeight;
	}

	public void setIpWeight(String ipWeight) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpWeight
		this.ipWeight = ipWeight;
	}

	public Boolean getRetriveFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRetriveFound
		return retriveFound;
	}

	public void setRetriveFound(Boolean retriveFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRetriveFound
		this.retriveFound = retriveFound;
	}

	public String getErrorMessage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMessage
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMessage
		this.errorMessage = errorMessage;
	}

	public String getIsFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsFound
		return isFound;
	}

	public void setIsFound(String isFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsFound
		this.isFound = isFound;
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


	public Set<String> getVipIndexCache() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVipIndexCache
		return vipIndexCache;
	}

	public void setVipIndexCache(Set<String> vipIndexCache) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVipIndexCache
		this.vipIndexCache = vipIndexCache;
	}

	public void setImpactAll(boolean impactAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImpactAll
		this.impactAll = impactAll;
	}

	public boolean isImpactAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isImpactAll
		return impactAll;
	}
	
	
	
	
}
