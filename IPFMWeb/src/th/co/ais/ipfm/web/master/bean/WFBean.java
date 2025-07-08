package th.co.ais.ipfm.web.master.bean;

import java.math.BigDecimal;
import java.util.List;

import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpWfConfig;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.util.IPFMWebUtil;

public class WFBean extends IPFMBaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5623151652975962315L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private IpUser userInfo = new IpUser();
	private IpWfConfig ipWfConfig = new IpWfConfig();
	private List<IpWfConfigDetail> ipWfConfigPlanningList;
	private List<IpWfConfigDetail> ipWfConfigUserRequestList;
	private List<IpWfConfigDetail> ipWfConfigRequestNetworkList;
	private int total;
	
	private FilterBean filter003 = new FilterBean();
	
	public WFBean(){
		userInfo = IPFMWebUtil.getUserSession().getIpUser();		
	}

	public IpUser getUserInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserInfo
		return userInfo;
	}

	public void setUserInfo(IpUser userInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserInfo
		this.userInfo = userInfo;
	}

	public IpWfConfig getIpWfConfig() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpWfConfig
		return ipWfConfig;
	}

	public void setIpWfConfig(IpWfConfig ipWfConfig) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpWfConfig
		this.ipWfConfig = ipWfConfig;
	}

	public List<IpWfConfigDetail> getIpWfConfigPlanningList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpWfConfigPlanningList
		return ipWfConfigPlanningList;
	}

	public void setIpWfConfigPlanningList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpWfConfigPlanningList
			List<IpWfConfigDetail> ipWfConfigPlanningList) {
		this.ipWfConfigPlanningList = ipWfConfigPlanningList;
	}

	public List<IpWfConfigDetail> getIpWfConfigUserRequestList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpWfConfigUserRequestList
		return ipWfConfigUserRequestList;
	}

	public void setIpWfConfigUserRequestList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpWfConfigUserRequestList
			List<IpWfConfigDetail> ipWfConfigUserRequestList) {
		this.ipWfConfigUserRequestList = ipWfConfigUserRequestList;
	}

	public List<IpWfConfigDetail> getIpWfConfigRequestNetworkList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpWfConfigRequestNetworkList
		return ipWfConfigRequestNetworkList;
	}

	public void setIpWfConfigRequestNetworkList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpWfConfigRequestNetworkList
			List<IpWfConfigDetail> ipWfConfigRequestNetworkList) {
		this.ipWfConfigRequestNetworkList = ipWfConfigRequestNetworkList;
	}

	public int getTotal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotal
		return total;
	}

	public void setTotal(int total) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotal
		this.total = total;
	}

	public void setFilter003(FilterBean filter003) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter003
		this.filter003 = filter003;
	}

	public FilterBean getFilter003() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter003
		return filter003;
	}



	
	
	
}
