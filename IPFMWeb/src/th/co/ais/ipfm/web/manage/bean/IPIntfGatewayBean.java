package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class IPIntfGatewayBean {
	
	private String ipAddress;
	private String mask;
	private String ipFound;
	private String location;
	private String vlanID;
	private String description;
	private IPFMRichComboItem networkType;
	private String networkTypeDesc;
	private String subMode = "ADD";
	private int rowNum;
	private int pageScroller = 1;
	private boolean checkAll;
	private boolean approveAll;
	private boolean rejectAll;
	private boolean impactAll;
	private IpUrInterfaceGateway searchResult;
	private IpvJobAssign jobAssign;
	private List<IpvJobAssign> jobAssignList;
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public String getIpFound() {
		return ipFound;
	}
	public void setIpFound(String ipFound) {
		this.ipFound = ipFound;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IPFMRichComboItem getNetworkType() {
		return networkType;
	}
	public void setNetworkType(IPFMRichComboItem networkType) {
		this.networkType = networkType;
	}
	public IpUrInterfaceGateway getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(IpUrInterfaceGateway searchResult) {
		this.searchResult = searchResult;
	}
	public IpvJobAssign getJobAssign() {
		return jobAssign;
	}
	public void setJobAssign(IpvJobAssign jobAssign) {
		this.jobAssign = jobAssign;
	}
	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}
	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
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
