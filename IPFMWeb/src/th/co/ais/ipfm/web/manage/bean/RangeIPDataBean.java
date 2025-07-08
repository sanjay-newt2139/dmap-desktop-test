package th.co.ais.ipfm.web.manage.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain.IPRange;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;


public class RangeIPDataBean extends IPFMBaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3251774689702918816L;
	
	private IPRange  ipRange = new IPRange();
	private List<IPRange> ipRangeList;
	private IPRange  popupIPRange = new IPRange();
	private boolean searchFlag;
	private boolean lockFieldFlag;
	private HtmlModalPanel popupModal;
	
	private List<SelectItem> ipVersionList;
	private List<SelectItem> ipGroupList;
	private List<SelectItem> ipClassList;
	private List<SelectItem> companyList;
	private List<SelectItem> ipRangeOwnerList;
	private List<SelectItem> zoneList;
	private List<SelectItem> nwTypeList;

	private IPFMRichComboItem ipRangeOwnerComboItem;
	private IPFMRichComboItem ipClassComboItem;
	private IPFMRichComboItem companyComboItem;
    private IPFMRichComboItem networkZoneComboItem;				
	private IPFMRichComboItem networkTypeComboItem;
	
	private SortColumnBean sortIpUrs013 = new SortColumnBean();	
	private FilterBean filterIpUrs013 = new FilterBean();
	
	public List<SelectItem> getIpVersionList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersionList
		return ipVersionList;
	}
	public void setIpVersionList(List<SelectItem> ipVersionList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersionList
		this.ipVersionList = ipVersionList;
	}
	public List<SelectItem> getIpGroupList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpGroupList
		return ipGroupList;
	}
	public void setIpGroupList(List<SelectItem> ipGroupList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpGroupList
		this.ipGroupList = ipGroupList;
	}
	public List<SelectItem> getIpClassList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassList
		return ipClassList;
	}
	public void setIpClassList(List<SelectItem> ipClassList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassList
		this.ipClassList = ipClassList;
	}
	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}
	public List<SelectItem> getIpRangeOwnerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRangeOwnerList
		return ipRangeOwnerList;
	}
	public void setIpRangeOwnerList(List<SelectItem> ipRangeOwnerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRangeOwnerList
		this.ipRangeOwnerList = ipRangeOwnerList;
	}
	public List<SelectItem> getZoneList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getZoneList
		return zoneList;
	}
	public void setZoneList(List<SelectItem> zoneList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setZoneList
		this.zoneList = zoneList;
	}
	public List<SelectItem> getNwTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwTypeList
		return nwTypeList;
	}
	public void setNwTypeList(List<SelectItem> nwTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwTypeList
		this.nwTypeList = nwTypeList;
	}
	public IPFMRichComboItem getIpRangeOwnerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRangeOwnerComboItem
		return ipRangeOwnerComboItem;
	}
	public void setIpRangeOwnerComboItem(IPFMRichComboItem ipRangeOwnerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRangeOwnerComboItem
		this.ipRangeOwnerComboItem = ipRangeOwnerComboItem;
	}
	public IPFMRichComboItem getIpClassComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassComboItem
		return ipClassComboItem;
	}
	public void setIpClassComboItem(IPFMRichComboItem ipClassComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassComboItem
		this.ipClassComboItem = ipClassComboItem;
	}
	public IPFMRichComboItem getCompanyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyComboItem
		return companyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyComboItem
		this.companyComboItem = companyComboItem;
	}
	public IPFMRichComboItem getNetworkZoneComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneComboItem
		return networkZoneComboItem;
	}
	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneComboItem
		this.networkZoneComboItem = networkZoneComboItem;
	}
	public IPFMRichComboItem getNetworkTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkTypeComboItem
		return networkTypeComboItem;
	}
	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeComboItem
		this.networkTypeComboItem = networkTypeComboItem;
	}
	public IPRange getIpRange() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRange
		return ipRange;
	}
	public void setIpRange(IPRange ipRange) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRange
		this.ipRange = ipRange;
	}
	public List<IPRange> getIpRangeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRangeList
		return ipRangeList;
	}
	public void setIpRangeList(List<IPRange> ipRangeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRangeList
		this.ipRangeList = ipRangeList;
	}
	public boolean isSearchFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSearchFlag
		return searchFlag;
	}
	public void setSearchFlag(boolean searchFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchFlag
		this.searchFlag = searchFlag;
	}

	public boolean isLockFieldFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isLockFieldFlag
		return lockFieldFlag;
	}
	public void setLockFieldFlag(boolean lockFieldFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLockFieldFlag
		this.lockFieldFlag = lockFieldFlag;
	}
	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}
	public IPRange getPopupIPRange() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupIPRange
		return popupIPRange;
	}
	public void setPopupIPRange(IPRange popupIPRange) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupIPRange
		this.popupIPRange = popupIPRange;
	}
	public HtmlModalPanel getPopupModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupModal
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupModal
		this.popupModal = popupModal;
	}
	public void setSortIpUrs013(SortColumnBean sortIpUrs013) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpUrs013
		this.sortIpUrs013 = sortIpUrs013;
	}
	public SortColumnBean getSortIpUrs013() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpUrs013
		return sortIpUrs013;
	}
	public void setFilterIpUrs013(FilterBean filterIpUrs013) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs013
		this.filterIpUrs013 = filterIpUrs013;
	}
	public FilterBean getFilterIpUrs013() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs013
		return filterIpUrs013;
	}

	
}
