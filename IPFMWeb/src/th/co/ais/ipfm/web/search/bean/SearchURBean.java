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
	private String v_view; // DMAP Comment : Dead Code Detected - The Following Field has no reference v_view
	
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

	public IPFMRichComboItem getUrTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeComboItem
		return urTypeComboItem;
	}

	public void setUrTypeComboItem(IPFMRichComboItem urTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrTypeComboItem
		this.urTypeComboItem = urTypeComboItem;
	}

	public IPFMRichComboItem getUrStatusComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusComboItem
		return urStatusComboItem;
	}

	public void setUrStatusComboItem(IPFMRichComboItem urStatusComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatusComboItem
		this.urStatusComboItem = urStatusComboItem;
	}

	public IPFMRichComboItem getRequesterComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequesterComboItem
		return requesterComboItem;
	}

	public void setRequesterComboItem(IPFMRichComboItem requesterComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequesterComboItem
		this.requesterComboItem = requesterComboItem;
	}

	public List<SelectItem> getUrTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeList
		return urTypeList;
	}

	public void setUrTypeList(List<SelectItem> urTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrTypeList
		this.urTypeList = urTypeList;
	}

	public List<SelectItem> getUrStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusList
		return urStatusList;
	}

	public void setUrStatusList(List<SelectItem> urStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatusList
		this.urStatusList = urStatusList;
	}

	public List<SelectItem> getRequesterList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequesterList
		return requesterList;
	}

	public void setRequesterList(List<SelectItem> requesterList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequesterList
		this.requesterList = requesterList;
	}


	public IpUrIpDetail getIpUrIpDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpDetail
		return ipUrIpDetail;
	}

	public void setIpUrIpDetail(IpUrIpDetail ipUrIpDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpDetail
		this.ipUrIpDetail = ipUrIpDetail;
	}

	public List<IpUrIpDetail> getSearchList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchList
		return searchList;
	}

	public void setSearchList(List<IpUrIpDetail> searchList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchList
		this.searchList = searchList;
	}

	public void setFilterIP007(FilterBean filterIP007) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIP007
		this.filterIP007 = filterIP007;
	}

	public FilterBean getFilterIP007() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIP007
		return filterIP007;
	}

	public void setSortIP007(SortColumnBean sortIP007) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIP007
		this.sortIP007 = sortIP007;
	}

	public SortColumnBean getSortIP007() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIP007
		return sortIP007;
	}

	public Boolean getFirewallCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFirewallCheck
		return firewallCheck;
	}

	public void setFirewallCheck(Boolean firewallCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFirewallCheck
		this.firewallCheck = firewallCheck;
	}

	public Boolean getAccessListCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAccessListCheck
		return accessListCheck;
	}

	public void setAccessListCheck(Boolean accessListCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAccessListCheck
		this.accessListCheck = accessListCheck;
	}

	public Boolean getAccessTNPCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAccessTNPCheck
		return accessTNPCheck;
	}

	public void setAccessTNPCheck(Boolean accessTNPCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAccessTNPCheck
		this.accessTNPCheck = accessTNPCheck;
	}

	public Boolean getPhysicalCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhysicalCheck
		return physicalCheck;
	}

	public void setPhysicalCheck(Boolean physicalCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhysicalCheck
		this.physicalCheck = physicalCheck;
	}

	public Boolean getGatewayCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGatewayCheck
		return gatewayCheck;
	}

	public void setGatewayCheck(Boolean gatewayCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGatewayCheck
		this.gatewayCheck = gatewayCheck;
	}

	public Boolean getRoutingCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoutingCheck
		return routingCheck;
	}

	public void setRoutingCheck(Boolean routingCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoutingCheck
		this.routingCheck = routingCheck;
	}

	public Boolean getF5Check() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5Check
		return f5Check;
	}

	public void setF5Check(Boolean f5Check) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5Check
		this.f5Check = f5Check;
	}

	public List<IpUrIpResult> getIpUrIpResultList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpResultList
		return ipUrIpResultList;
	}

	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpResultList
		this.ipUrIpResultList = ipUrIpResultList;
	}

	public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
		return urType;
	}

	public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
		this.urType = urType;
	}

	public IpInfo getIpInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfo
		return ipInfo;
	}

	public void setIpInfo(IpInfo ipInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfo
		this.ipInfo = ipInfo;
	}

	public IpInfo getIpInfoTo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfoTo
		return ipInfoTo;
	}

	public void setIpInfoTo(IpInfo ipInfoTo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfoTo
		this.ipInfoTo = ipInfoTo;
	}
	
	
	
}
