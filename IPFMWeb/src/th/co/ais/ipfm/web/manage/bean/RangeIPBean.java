package th.co.ais.ipfm.web.manage.bean;

import java.util.ArrayList;
import java.util.List;

import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain.IPRange;
import th.co.ais.ipfm.domain.TempTable;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;


public class RangeIPBean extends IPFMBaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPRange ipRange = new IPRange();
	private List<IPRange> ipRangeList;
	private List<TempTable> tempList;
	private String importError = "0";
	private boolean searchFlag = false;
	private boolean lockFlag = false;
	private HtmlModalPanel lockModal;
	private IPRange popupIPRange = new IPRange();
	
	private SortColumnBean sortIpUrs002 = new SortColumnBean();	
	private FilterBean filterIpUrs002 = new FilterBean();
	
	private SortColumnBean sortIpUrs0022 = new SortColumnBean();	
	private FilterBean filterIpUrs0022 = new FilterBean();
	
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

	public String getImportError() {
		return importError;
	}

	public void setImportError(String importError) {
		this.importError = importError;
	}

	public List<TempTable> getTempList() {
		if (tempList == null) {;
			tempList = new ArrayList<TempTable>();
			TempTable tmp = new TempTable("22", 
					"Warning : System Owner Team mismatch."
					, "", "", "");
			tempList.add(tmp);
			TempTable tmp1 = new TempTable("24", 
						"Error : Missing System Owner ID."
						, "", "", "");
			tempList.add(tmp1);
			TempTable tmp2 = new TempTable("51", 
					"Warning : System Owner Team mismatch.<br>" +
					"Error : Missing Site/Location.<br>"+
					"Error : Planning Team ID mismatch."
					, "", "", "");
			tempList.add(tmp2);
			TempTable tmp3 = new TempTable("83", 
					"Error : Mission IP Address."
					, "", "", "");
			tempList.add(tmp3);
		}
		return tempList;
	}

	public void setTempList(List<TempTable> tempList) {
		this.tempList = tempList;
	}

	public boolean isSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag) {
		this.searchFlag = searchFlag;
	}

	public boolean isLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(boolean lockFlag) {
		this.lockFlag = lockFlag;
	}

	public HtmlModalPanel getLockModal() {
		return lockModal;
	}

	public void setLockModal(HtmlModalPanel lockModal) {
		this.lockModal = lockModal;
	}

	public IPRange getPopupIPRange() {
		return popupIPRange;
	}

	public void setPopupIPRange(IPRange popupIPRange) {
		this.popupIPRange = popupIPRange;
	}

	public void setFilterIpUrs002(FilterBean filterIpUrs002) {
		this.filterIpUrs002 = filterIpUrs002;
	}

	public FilterBean getFilterIpUrs002() {
		return filterIpUrs002;
	}

	public void setSortIpUrs002(SortColumnBean sortIpUrs002) {
		this.sortIpUrs002 = sortIpUrs002;
	}

	public SortColumnBean getSortIpUrs002() {
		return sortIpUrs002;
	}

	public void setSortIpUrs0022(SortColumnBean sortIpUrs0022) {
		this.sortIpUrs0022 = sortIpUrs0022;
	}

	public SortColumnBean getSortIpUrs0022() {
		return sortIpUrs0022;
	}

	public void setFilterIpUrs0022(FilterBean filterIpUrs0022) {
		this.filterIpUrs0022 = filterIpUrs0022;
	}

	public FilterBean getFilterIpUrs0022() {
		return filterIpUrs0022;
	}
}
