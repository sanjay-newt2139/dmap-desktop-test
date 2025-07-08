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
	public HtmlModalPanel getPopupModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupModal
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupModal
		this.popupModal = popupModal;
	}
	public String getIpLevel() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel
		return ipLevel;
	}
	public void setIpLevel(String ipLevel) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel
		this.ipLevel = ipLevel;
	}
	public IPRange getIpRange() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRange
		return ipRange;
	}
	public void setIpRange(IPRange ipRange) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRange
		this.ipRange = ipRange;
	}
	public IPRange getPopupIPRange() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupIPRange
		return popupIPRange;
	}
	public void setPopupIPRange(IPRange popupIPRange) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupIPRange
		this.popupIPRange = popupIPRange;
	}
	public List<SelectItem> getLocationList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationList
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationList
		this.locationList = locationList;
	}
	public IPFMRichComboItem getLocationComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationComboItem
		return locationComboItem;
	}
	public void setLocationComboItem(IPFMRichComboItem locationComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationComboItem
		this.locationComboItem = locationComboItem;
	}
	public IpInfo getIpInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfo
		return ipInfo;
	}
	public void setIpInfo(IpInfo ipInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfo
		this.ipInfo = ipInfo;
	}
	public IpUrIpResult getIpUrIpResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpResult
		return ipUrIpResult;
	}
	public void setIpUrIpResult(IpUrIpResult ipUrIpResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpResult
		this.ipUrIpResult = ipUrIpResult;
	}
	public List<IpInfo> getSearchList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchList
		return searchList;
	}
	public void setSearchList(List<IpInfo> searchList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchList
		this.searchList = searchList;
	}
	public IpInfo getIpInfoPopup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfoPopup
		return ipInfoPopup;
	}
	public void setIpInfoPopup(IpInfo ipInfoPopup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfoPopup
		this.ipInfoPopup = ipInfoPopup;
	}
	public void setSortIP002(SortColumnBean sortIP002) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIP002
		this.sortIP002 = sortIP002;
	}
	public SortColumnBean getSortIP002() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIP002
		return sortIP002;
	}
	public void setFilterIP002(FilterBean filterIP002) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIP002
		this.filterIP002 = filterIP002;
	}
	public FilterBean getFilterIP002() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIP002
		return filterIP002;
	}
	

}
