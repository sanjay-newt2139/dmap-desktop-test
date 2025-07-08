package th.co.ais.ipfm.web.search.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.TempTable;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class SearchURBean extends IPFMBaseBean{
	
	private IPFMRichComboItem urTypeComboItem;
	private IPFMRichComboItem urStatusComboItem;
	private IPFMRichComboItem requesterComboItem;

	private List<SelectItem> urTypeList;
	private List<SelectItem> urStatusList;
	private List<SelectItem> requesterList;
	private String v_view;
	
	private IpUrIpDetail ipUrIpDetail = new IpUrIpDetail();
	
	private List<IpUrIpDetail> searchList;
	
	 private Boolean firewallCheck = false;
	 private Boolean accessListCheck = false;
	 private Boolean accessTNPCheck = false;
	 private Boolean physicalCheck = false;
	 private Boolean gatewayCheck = false;
	 private Boolean routingCheck = false;
	 private Boolean f5Check = false;
	 private IpInfo  ipInfo = new IpInfo();
	 private IpInfo  ipInfoTo = new IpInfo();
	 
	
	private FilterBean filterIP007 = new FilterBean();
	private SortColumnBean sortIP007 = new SortColumnBean();
	
	private List<IpUrIpResult> ipUrIpResultList = new ArrayList<IpUrIpResult>();
	private String urType;

	public IPFMRichComboItem getUrTypeComboItem() {
		return urTypeComboItem;
	}

	public void setUrTypeComboItem(IPFMRichComboItem urTypeComboItem) {
		this.urTypeComboItem = urTypeComboItem;
	}

	public IPFMRichComboItem getUrStatusComboItem() {
		return urStatusComboItem;
	}

	public void setUrStatusComboItem(IPFMRichComboItem urStatusComboItem) {
		this.urStatusComboItem = urStatusComboItem;
	}

	public IPFMRichComboItem getRequesterComboItem() {
		return requesterComboItem;
	}

	public void setRequesterComboItem(IPFMRichComboItem requesterComboItem) {
		this.requesterComboItem = requesterComboItem;
	}

	public List<SelectItem> getUrTypeList() {
		return urTypeList;
	}

	public void setUrTypeList(List<SelectItem> urTypeList) {
		this.urTypeList = urTypeList;
	}

	public List<SelectItem> getUrStatusList() {
		return urStatusList;
	}

	public void setUrStatusList(List<SelectItem> urStatusList) {
		this.urStatusList = urStatusList;
	}

	public List<SelectItem> getRequesterList() {
		return requesterList;
	}

	public void setRequesterList(List<SelectItem> requesterList) {
		this.requesterList = requesterList;
	}


	public IpUrIpDetail getIpUrIpDetail() {
		return ipUrIpDetail;
	}

	public void setIpUrIpDetail(IpUrIpDetail ipUrIpDetail) {
		this.ipUrIpDetail = ipUrIpDetail;
	}

	public List<IpUrIpDetail> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<IpUrIpDetail> searchList) {
		this.searchList = searchList;
	}

	public void setFilterIP007(FilterBean filterIP007) {
		this.filterIP007 = filterIP007;
	}

	public FilterBean getFilterIP007() {
		return filterIP007;
	}

	public void setSortIP007(SortColumnBean sortIP007) {
		this.sortIP007 = sortIP007;
	}

	public SortColumnBean getSortIP007() {
		return sortIP007;
	}

	public Boolean getFirewallCheck() {
		return firewallCheck;
	}

	public void setFirewallCheck(Boolean firewallCheck) {
		this.firewallCheck = firewallCheck;
	}

	public Boolean getAccessListCheck() {
		return accessListCheck;
	}

	public void setAccessListCheck(Boolean accessListCheck) {
		this.accessListCheck = accessListCheck;
	}

	public Boolean getAccessTNPCheck() {
		return accessTNPCheck;
	}

	public void setAccessTNPCheck(Boolean accessTNPCheck) {
		this.accessTNPCheck = accessTNPCheck;
	}

	public Boolean getPhysicalCheck() {
		return physicalCheck;
	}

	public void setPhysicalCheck(Boolean physicalCheck) {
		this.physicalCheck = physicalCheck;
	}

	public Boolean getGatewayCheck() {
		return gatewayCheck;
	}

	public void setGatewayCheck(Boolean gatewayCheck) {
		this.gatewayCheck = gatewayCheck;
	}

	public Boolean getRoutingCheck() {
		return routingCheck;
	}

	public void setRoutingCheck(Boolean routingCheck) {
		this.routingCheck = routingCheck;
	}

	public Boolean getF5Check() {
		return f5Check;
	}

	public void setF5Check(Boolean f5Check) {
		this.f5Check = f5Check;
	}

	public List<IpUrIpResult> getIpUrIpResultList() {
		return ipUrIpResultList;
	}

	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) {
		this.ipUrIpResultList = ipUrIpResultList;
	}

	public String getUrType() {
		return urType;
	}

	public void setUrType(String urType) {
		this.urType = urType;
	}

	public IpInfo getIpInfo() {
		return ipInfo;
	}

	public void setIpInfo(IpInfo ipInfo) {
		this.ipInfo = ipInfo;
	}

	public IpInfo getIpInfoTo() {
		return ipInfoTo;
	}

	public void setIpInfoTo(IpInfo ipInfoTo) {
		this.ipInfoTo = ipInfoTo;
	}
	
	
	
}
