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
	private static final long serialVersionUID = 5623151652975962315L;
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

	public IpUser getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(IpUser userInfo) {
		this.userInfo = userInfo;
	}

	public IpWfConfig getIpWfConfig() {
		return ipWfConfig;
	}

	public void setIpWfConfig(IpWfConfig ipWfConfig) {
		this.ipWfConfig = ipWfConfig;
	}

	public List<IpWfConfigDetail> getIpWfConfigPlanningList() {
		return ipWfConfigPlanningList;
	}

	public void setIpWfConfigPlanningList(
			List<IpWfConfigDetail> ipWfConfigPlanningList) {
		this.ipWfConfigPlanningList = ipWfConfigPlanningList;
	}

	public List<IpWfConfigDetail> getIpWfConfigUserRequestList() {
		return ipWfConfigUserRequestList;
	}

	public void setIpWfConfigUserRequestList(
			List<IpWfConfigDetail> ipWfConfigUserRequestList) {
		this.ipWfConfigUserRequestList = ipWfConfigUserRequestList;
	}

	public List<IpWfConfigDetail> getIpWfConfigRequestNetworkList() {
		return ipWfConfigRequestNetworkList;
	}

	public void setIpWfConfigRequestNetworkList(
			List<IpWfConfigDetail> ipWfConfigRequestNetworkList) {
		this.ipWfConfigRequestNetworkList = ipWfConfigRequestNetworkList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setFilter003(FilterBean filter003) {
		this.filter003 = filter003;
	}

	public FilterBean getFilter003() {
		return filter003;
	}



	
	
	
}
