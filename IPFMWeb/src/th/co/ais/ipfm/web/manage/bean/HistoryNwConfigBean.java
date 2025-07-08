package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;


public class HistoryNwConfigBean implements Serializable{

	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
	private List<IpUrAction> ipUrActionList;
	private List<IpUrActionHistory> ipUrActionHistoryList;
	private List<IpUrNwConfig> ipUrNwConfigList;
    private IpUrNwConfig  ipUrNwConfig = new IpUrNwConfig();
	
    private SortColumnBean sortHis = new SortColumnBean();	
	private FilterBean filterHis = new FilterBean();
    
	public List<IpUrAction> getIpUrActionList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrActionList
		return ipUrActionList;
	}

	public void setIpUrActionList(List<IpUrAction> ipUrActionList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrActionList
		this.ipUrActionList = ipUrActionList;
	}

	public List<IpUrNwConfig> getIpUrNwConfigList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrNwConfigList
		return ipUrNwConfigList;
	}

	public void setIpUrNwConfigList(List<IpUrNwConfig> ipUrNwConfigList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrNwConfigList
		this.ipUrNwConfigList = ipUrNwConfigList;
	}

	public IpUrNwConfig getIpUrNwConfig() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrNwConfig
		return ipUrNwConfig;
	}

	public void setIpUrNwConfig(IpUrNwConfig ipUrNwConfig) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrNwConfig
		this.ipUrNwConfig = ipUrNwConfig;
	}

	public List<IpUrActionHistory> getIpUrActionHistoryList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrActionHistoryList
		return ipUrActionHistoryList;
	}

	public void setIpUrActionHistoryList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrActionHistoryList
			List<IpUrActionHistory> ipUrActionHistoryList) {
		this.ipUrActionHistoryList = ipUrActionHistoryList;
	}

	public void setSortHis(SortColumnBean sortHis) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortHis
		this.sortHis = sortHis;
	}

	public SortColumnBean getSortHis() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortHis
		return sortHis;
	}

	public void setFilterHis(FilterBean filterHis) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterHis
		this.filterHis = filterHis;
	}

	public FilterBean getFilterHis() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterHis
		return filterHis;
	}

	
	
	
}
