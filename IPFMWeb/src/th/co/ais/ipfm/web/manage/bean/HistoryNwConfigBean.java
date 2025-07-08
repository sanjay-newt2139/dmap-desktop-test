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

	private static final long serialVersionUID = 1L;
	
	private List<IpUrAction> ipUrActionList;
	private List<IpUrActionHistory> ipUrActionHistoryList;
	private List<IpUrNwConfig> ipUrNwConfigList;
    private IpUrNwConfig  ipUrNwConfig = new IpUrNwConfig();
	
    private SortColumnBean sortHis = new SortColumnBean();	
	private FilterBean filterHis = new FilterBean();
    
	public List<IpUrAction> getIpUrActionList() {
		return ipUrActionList;
	}

	public void setIpUrActionList(List<IpUrAction> ipUrActionList) {
		this.ipUrActionList = ipUrActionList;
	}

	public List<IpUrNwConfig> getIpUrNwConfigList() {
		return ipUrNwConfigList;
	}

	public void setIpUrNwConfigList(List<IpUrNwConfig> ipUrNwConfigList) {
		this.ipUrNwConfigList = ipUrNwConfigList;
	}

	public IpUrNwConfig getIpUrNwConfig() {
		return ipUrNwConfig;
	}

	public void setIpUrNwConfig(IpUrNwConfig ipUrNwConfig) {
		this.ipUrNwConfig = ipUrNwConfig;
	}

	public List<IpUrActionHistory> getIpUrActionHistoryList() {
		return ipUrActionHistoryList;
	}

	public void setIpUrActionHistoryList(
			List<IpUrActionHistory> ipUrActionHistoryList) {
		this.ipUrActionHistoryList = ipUrActionHistoryList;
	}

	public void setSortHis(SortColumnBean sortHis) {
		this.sortHis = sortHis;
	}

	public SortColumnBean getSortHis() {
		return sortHis;
	}

	public void setFilterHis(FilterBean filterHis) {
		this.filterHis = filterHis;
	}

	public FilterBean getFilterHis() {
		return filterHis;
	}

	
	
	
}
