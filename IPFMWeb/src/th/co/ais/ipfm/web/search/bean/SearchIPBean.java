package th.co.ais.ipfm.web.search.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain.IPRange;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class SearchIPBean extends IPFMBaseBean {
	
	private IPRange  ipRange = new IPRange();
	private List<IpInfo> searchList;
	private IPRange  popupIPRange = new IPRange();
	private IpInfo  ipInfo = new IpInfo();
	private IpInfo  ipInfoPopup = new IpInfo();
	private IpUrIpResult  ipUrIpResult = new IpUrIpResult();
	private boolean searchFlag;
	private boolean lockFieldFlag;
	private HtmlModalPanel popupModal;
	private String ipLevel;
	
	private List<SelectItem> locationList;

	private IPFMRichComboItem locationComboItem;

	private SortColumnBean sortIP002 = new SortColumnBean();
	private FilterBean filterIP002 = new FilterBean();

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
	public HtmlModalPanel getPopupModal() {
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) {
		this.popupModal = popupModal;
	}
	public String getIpLevel() {
		return ipLevel;
	}
	public void setIpLevel(String ipLevel) {
		this.ipLevel = ipLevel;
	}
	public IPRange getIpRange() {
		return ipRange;
	}
	public void setIpRange(IPRange ipRange) {
		this.ipRange = ipRange;
	}
	public IPRange getPopupIPRange() {
		return popupIPRange;
	}
	public void setPopupIPRange(IPRange popupIPRange) {
		this.popupIPRange = popupIPRange;
	}
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public IPFMRichComboItem getLocationComboItem() {
		return locationComboItem;
	}
	public void setLocationComboItem(IPFMRichComboItem locationComboItem) {
		this.locationComboItem = locationComboItem;
	}
	public IpInfo getIpInfo() {
		return ipInfo;
	}
	public void setIpInfo(IpInfo ipInfo) {
		this.ipInfo = ipInfo;
	}
	public IpUrIpResult getIpUrIpResult() {
		return ipUrIpResult;
	}
	public void setIpUrIpResult(IpUrIpResult ipUrIpResult) {
		this.ipUrIpResult = ipUrIpResult;
	}
	public List<IpInfo> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<IpInfo> searchList) {
		this.searchList = searchList;
	}
	public IpInfo getIpInfoPopup() {
		return ipInfoPopup;
	}
	public void setIpInfoPopup(IpInfo ipInfoPopup) {
		this.ipInfoPopup = ipInfoPopup;
	}
	public void setSortIP002(SortColumnBean sortIP002) {
		this.sortIP002 = sortIP002;
	}
	public SortColumnBean getSortIP002() {
		return sortIP002;
	}
	public void setFilterIP002(FilterBean filterIP002) {
		this.filterIP002 = filterIP002;
	}
	public FilterBean getFilterIP002() {
		return filterIP002;
	}
	

}
