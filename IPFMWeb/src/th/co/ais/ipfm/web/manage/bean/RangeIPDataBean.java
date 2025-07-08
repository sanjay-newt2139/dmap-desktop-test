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
	
	public List<SelectItem> getIpVersionList() {
		return ipVersionList;
	}
	public void setIpVersionList(List<SelectItem> ipVersionList) {
		this.ipVersionList = ipVersionList;
	}
	public List<SelectItem> getIpGroupList() {
		return ipGroupList;
	}
	public void setIpGroupList(List<SelectItem> ipGroupList) {
		this.ipGroupList = ipGroupList;
	}
	public List<SelectItem> getIpClassList() {
		return ipClassList;
	}
	public void setIpClassList(List<SelectItem> ipClassList) {
		this.ipClassList = ipClassList;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getIpRangeOwnerList() {
		return ipRangeOwnerList;
	}
	public void setIpRangeOwnerList(List<SelectItem> ipRangeOwnerList) {
		this.ipRangeOwnerList = ipRangeOwnerList;
	}
	public List<SelectItem> getZoneList() {
		return zoneList;
	}
	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}
	public List<SelectItem> getNwTypeList() {
		return nwTypeList;
	}
	public void setNwTypeList(List<SelectItem> nwTypeList) {
		this.nwTypeList = nwTypeList;
	}
	public IPFMRichComboItem getIpRangeOwnerComboItem() {
		return ipRangeOwnerComboItem;
	}
	public void setIpRangeOwnerComboItem(IPFMRichComboItem ipRangeOwnerComboItem) {
		this.ipRangeOwnerComboItem = ipRangeOwnerComboItem;
	}
	public IPFMRichComboItem getIpClassComboItem() {
		return ipClassComboItem;
	}
	public void setIpClassComboItem(IPFMRichComboItem ipClassComboItem) {
		this.ipClassComboItem = ipClassComboItem;
	}
	public IPFMRichComboItem getCompanyComboItem() {
		return companyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) {
		this.companyComboItem = companyComboItem;
	}
	public IPFMRichComboItem getNetworkZoneComboItem() {
		return networkZoneComboItem;
	}
	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) {
		this.networkZoneComboItem = networkZoneComboItem;
	}
	public IPFMRichComboItem getNetworkTypeComboItem() {
		return networkTypeComboItem;
	}
	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) {
		this.networkTypeComboItem = networkTypeComboItem;
	}
	public IPRange getIpRange() {
		return ipRange;
	}
	public void setIpRange(IPRange ipRange) {
		this.ipRange = ipRange;
	}
	public List<IPRange> getIpRangeList() {
		return ipRangeList;
	}
	public void setIpRangeList(List<IPRange> ipRangeList) {
		this.ipRangeList = ipRangeList;
	}
	public boolean isSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(boolean searchFlag) {
		this.searchFlag = searchFlag;
	}

	public boolean isLockFieldFlag() {
		return lockFieldFlag;
	}
	public void setLockFieldFlag(boolean lockFieldFlag) {
		this.lockFieldFlag = lockFieldFlag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public IPRange getPopupIPRange() {
		return popupIPRange;
	}
	public void setPopupIPRange(IPRange popupIPRange) {
		this.popupIPRange = popupIPRange;
	}
	public HtmlModalPanel getPopupModal() {
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) {
		this.popupModal = popupModal;
	}
	public void setSortIpUrs013(SortColumnBean sortIpUrs013) {
		this.sortIpUrs013 = sortIpUrs013;
	}
	public SortColumnBean getSortIpUrs013() {
		return sortIpUrs013;
	}
	public void setFilterIpUrs013(FilterBean filterIpUrs013) {
		this.filterIpUrs013 = filterIpUrs013;
	}
	public FilterBean getFilterIpUrs013() {
		return filterIpUrs013;
	}

	
}
