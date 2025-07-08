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
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
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
	public String getSourceNatIP() {
		return sourceNatIP;
	}
	public void setSourceNatIP(String sourceNatIP) {
		this.sourceNatIP = sourceNatIP;
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
	public String getDestNatIP() {
		return destNatIP;
	}
	public void setDestNatIP(String destNatIP) {
		this.destNatIP = destNatIP;
	}
	public Boolean getTcpCheck() {
		return tcpCheck;
	}
	public void setTcpCheck(Boolean tcpCheck) {
		this.tcpCheck = tcpCheck;
	}
	public String getTcpPort() {
		return tcpPort;
	}
	public void setTcpPort(String tcpPort) {
		this.tcpPort = tcpPort;
	}
	public Boolean getUdpCheck() {
		return udpCheck;
	}
	public void setUdpCheck(Boolean udpCheck) {
		this.udpCheck = udpCheck;
	}
	public String getUdpPort() {
		return udpPort;
	}
	public void setUdpPort(String udpPort) {
		this.udpPort = udpPort;
	}
	public Boolean getOtherCheck() {
		return otherCheck;
	}
	public void setOtherCheck(Boolean otherCheck) {
		this.otherCheck = otherCheck;
	}
	public String getOtherPort() {
		return otherPort;
	}
	public void setOtherPort(String otherPort) {
		this.otherPort = otherPort;
	}
	public String getServicePort() {
		return servicePort;
	}
	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}
	public String getSourceEmail() {
		return sourceEmail;
	}
	public void setSourceEmail(String sourceEmail) {
		this.sourceEmail = sourceEmail;
	}
	public String getSourceVip() {
		return sourceVip;
	}
	public void setSourceVip(String sourceVip) {
		this.sourceVip = sourceVip;
	}
	public String getSourceFound() {
		return sourceFound;
	}
	public void setSourceFound(String sourceFound) {
		this.sourceFound = sourceFound;
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
	public String getDestVip() {
		return destVip;
	}
	public void setDestVip(String destVip) {
		this.destVip = destVip;
	}
	public List<SelectItem> getServiveList() {
		return serviveList;
	}
	public void setServiveList(List<SelectItem> serviveList) {
		this.serviveList = serviveList;
	}
	public List<String> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}
	public IpUrFirewall getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(IpUrFirewall searchResult) {
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() {
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) {
		this.jobAssign = jobAssign;
	}
	public Map<Long, Boolean> getChecked() {
		return checked;
	}
	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public IpUrFirewall toUrObject(){
		return null;
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
	public String getSourceIpEndDisp() {
		return sourceIpEndDisp;
	}
	public void setSourceIpEndDisp(String sourceIpEndDisp) {
		this.sourceIpEndDisp = sourceIpEndDisp;
	}
	public String getDestIpEndDisp() {
		return destIpEndDisp;
	}
	public void setDestIpEndDisp(String destIpEndDisp) {
		this.destIpEndDisp = destIpEndDisp;
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
	public boolean isImpactAll() {
		return impactAll;
	}
	public void setImpactAll(boolean impactAll) {
		this.impactAll = impactAll;
	}
}
