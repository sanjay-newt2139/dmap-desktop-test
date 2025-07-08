package th.co.ais.ipfm.web.manage.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpvJobAssign;

public class IPFirewallBean {
	private String sourceIPStart;
	private String sourceIPEnd;
	private String sourceIpEndDisp;
	private String sourceNatIP;
	private String destIPStart;
	private String destIPEnd;
	private String destIpEndDisp;
	private String destNatIP;
	private Boolean tcpCheck = false;
	private String tcpPort;
	private Boolean udpCheck = false;
	private String udpPort;
	private Boolean otherCheck = false;
	private String otherPort;
	private String servicePort;
	private String serviceName;
	private boolean checkAll = false;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private String sourceFound;
	private String sourceName;
	private String sourceEmail;
	private String sourceVip;
	
	private String destFound;
	private String destName;
	private String destEmail;
	private String destVip;
	
	private IpUrFirewall searchResult;
	private IpvJobAssign jobAssign;
	private List<IpvJobAssign> jobAssignList;
	
	private List<SelectItem> serviveList;
	private List<String> selectList;
	
	private String subMode = "ADD";
	private int rowNum;
	private int pageScroller = 1;
	
	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
	
	public String getSourceName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceName
		return sourceName;
	}
	public void setSourceName(String sourceName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceName
		this.sourceName = sourceName;
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
	public String getSourceNatIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceNatIP
		return sourceNatIP;
	}
	public void setSourceNatIP(String sourceNatIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceNatIP
		this.sourceNatIP = sourceNatIP;
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
	public String getDestNatIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestNatIP
		return destNatIP;
	}
	public void setDestNatIP(String destNatIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestNatIP
		this.destNatIP = destNatIP;
	}
	public Boolean getTcpCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTcpCheck
		return tcpCheck;
	}
	public void setTcpCheck(Boolean tcpCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTcpCheck
		this.tcpCheck = tcpCheck;
	}
	public String getTcpPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTcpPort
		return tcpPort;
	}
	public void setTcpPort(String tcpPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTcpPort
		this.tcpPort = tcpPort;
	}
	public Boolean getUdpCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUdpCheck
		return udpCheck;
	}
	public void setUdpCheck(Boolean udpCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUdpCheck
		this.udpCheck = udpCheck;
	}
	public String getUdpPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUdpPort
		return udpPort;
	}
	public void setUdpPort(String udpPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUdpPort
		this.udpPort = udpPort;
	}
	public Boolean getOtherCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOtherCheck
		return otherCheck;
	}
	public void setOtherCheck(Boolean otherCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOtherCheck
		this.otherCheck = otherCheck;
	}
	public String getOtherPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOtherPort
		return otherPort;
	}
	public void setOtherPort(String otherPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOtherPort
		this.otherPort = otherPort;
	}
	public String getServicePort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServicePort
		return servicePort;
	}
	public void setServicePort(String servicePort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServicePort
		this.servicePort = servicePort;
	}
	public String getSourceEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceEmail
		return sourceEmail;
	}
	public void setSourceEmail(String sourceEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceEmail
		this.sourceEmail = sourceEmail;
	}
	public String getSourceVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceVip
		return sourceVip;
	}
	public void setSourceVip(String sourceVip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceVip
		this.sourceVip = sourceVip;
	}
	public String getSourceFound() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceFound
		return sourceFound;
	}
	public void setSourceFound(String sourceFound) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceFound
		this.sourceFound = sourceFound;
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
	public String getDestVip() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestVip
		return destVip;
	}
	public void setDestVip(String destVip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestVip
		this.destVip = destVip;
	}
	public List<SelectItem> getServiveList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiveList
		return serviveList;
	}
	public void setServiveList(List<SelectItem> serviveList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServiveList
		this.serviveList = serviveList;
	}
	public List<String> getSelectList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectList
		return selectList;
	}
	public void setSelectList(List<String> selectList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectList
		this.selectList = selectList;
	}
	public IpUrFirewall getSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchResult
		return searchResult;
	}
	public void setSearchResult(IpUrFirewall searchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchResult
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssign
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssign
		this.jobAssign = jobAssign;
	}
	public Map<Long, Boolean> getChecked() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChecked
		return checked;
	}
	public void setChecked(Map<Long, Boolean> checked) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setChecked
		this.checked = checked;
	}
	public String getServiceName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceName
		return serviceName;
	}
	public void setServiceName(String serviceName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServiceName
		this.serviceName = serviceName;
	}
	
	public IpUrFirewall toUrObject(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference toUrObject
		return null;
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
	public String getSourceIpEndDisp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSourceIpEndDisp
		return sourceIpEndDisp;
	}
	public void setSourceIpEndDisp(String sourceIpEndDisp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSourceIpEndDisp
		this.sourceIpEndDisp = sourceIpEndDisp;
	}
	public String getDestIpEndDisp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDestIpEndDisp
		return destIpEndDisp;
	}
	public void setDestIpEndDisp(String destIpEndDisp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDestIpEndDisp
		this.destIpEndDisp = destIpEndDisp;
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
	public boolean isImpactAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isImpactAll
		return impactAll;
	}
	public void setImpactAll(boolean impactAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImpactAll
		this.impactAll = impactAll;
	}
}
