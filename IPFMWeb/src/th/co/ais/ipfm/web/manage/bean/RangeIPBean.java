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
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
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

	public String getImportError() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getImportError
		return importError;
	}

	public void setImportError(String importError) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setImportError
		this.importError = importError;
	}

	public List<TempTable> getTempList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTempList
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

	public void setTempList(List<TempTable> tempList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTempList
		this.tempList = tempList;
	}

	public boolean isSearchFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSearchFlag
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchFlag
		this.searchFlag = searchFlag;
	}

	public boolean isLockFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isLockFlag
		return lockFlag;
	}

	public void setLockFlag(boolean lockFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLockFlag
		this.lockFlag = lockFlag;
	}

	public HtmlModalPanel getLockModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLockModal
		return lockModal;
	}

	public void setLockModal(HtmlModalPanel lockModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLockModal
		this.lockModal = lockModal;
	}

	public IPRange getPopupIPRange() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupIPRange
		return popupIPRange;
	}

	public void setPopupIPRange(IPRange popupIPRange) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupIPRange
		this.popupIPRange = popupIPRange;
	}

	public void setFilterIpUrs002(FilterBean filterIpUrs002) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs002
		this.filterIpUrs002 = filterIpUrs002;
	}

	public FilterBean getFilterIpUrs002() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs002
		return filterIpUrs002;
	}

	public void setSortIpUrs002(SortColumnBean sortIpUrs002) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpUrs002
		this.sortIpUrs002 = sortIpUrs002;
	}

	public SortColumnBean getSortIpUrs002() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpUrs002
		return sortIpUrs002;
	}

	public void setSortIpUrs0022(SortColumnBean sortIpUrs0022) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpUrs0022
		this.sortIpUrs0022 = sortIpUrs0022;
	}

	public SortColumnBean getSortIpUrs0022() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpUrs0022
		return sortIpUrs0022;
	}

	public void setFilterIpUrs0022(FilterBean filterIpUrs0022) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs0022
		this.filterIpUrs0022 = filterIpUrs0022;
	}

	public FilterBean getFilterIpUrs0022() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs0022
		return filterIpUrs0022;
	}
}
