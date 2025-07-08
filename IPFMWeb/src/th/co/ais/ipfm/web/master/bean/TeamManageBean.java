package th.co.ais.ipfm.web.master.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;


public class TeamManageBean extends IPFMBaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3251774689702918816L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	private List detailList = new ArrayList();
	private IpTeam   ipTeam = new IpTeam();
	private IpUser   ipUser = new IpUser();
	private List<IpTeam> searchList;
	private List<IpUser> teamMemberList;
	private IPFMRichComboItem systemOwnerComboItem;
	private List<SelectItem> systemOwnerList;
	private String criteria;
	private String fromOutcome;

	private FilterBean filter00201 = new FilterBean();
	private FilterBean filter00202 = new FilterBean();
	private FilterBean filter00801 = new FilterBean();
	private FilterBean filter00803 = new FilterBean();
	
	public List getDetailList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDetailList
		return detailList;
	}

	public void setDetailList(List detailList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDetailList
		this.detailList = detailList;
	}

	public IpTeam getIpTeam() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTeam
		return ipTeam;
	}

	public void setIpTeam(IpTeam ipTeam) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTeam
		this.ipTeam = ipTeam;
	}

	public List<IpTeam> getSearchList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchList
		return searchList;
	}

	public void setSearchList(List<IpTeam> searchList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchList
		this.searchList = searchList;
	}

	public IpUser getIpUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUser
		return ipUser;
	}

	public void setIpUser(IpUser ipUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUser
		this.ipUser = ipUser;
	}

	public List<IpUser> getTeamMemberList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamMemberList
		return teamMemberList;
	}

	public void setTeamMemberList(List<IpUser> teamMemberList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamMemberList
		this.teamMemberList = teamMemberList;
	}
	public IPFMRichComboItem getSystemOwnerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerComboItem
		return systemOwnerComboItem;
	}

	public void setSystemOwnerComboItem(IPFMRichComboItem systemOwnerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerComboItem
		this.systemOwnerComboItem = systemOwnerComboItem;
	}

	public List<SelectItem> getSystemOwnerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerList
		return systemOwnerList;
	}

	public void setSystemOwnerList(List<SelectItem> systemOwnerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerList
		this.systemOwnerList = systemOwnerList;
	}

	public String getCriteria() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCriteria
		return criteria;
	}

	public void setCriteria(String criteria) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCriteria
		this.criteria = criteria;
	}

	public String getFromOutcome() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFromOutcome
		return fromOutcome;
	}

	public void setFromOutcome(String fromOutcome) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFromOutcome
		this.fromOutcome = fromOutcome;
	}

	public void setFilter00201(FilterBean filter00201) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00201
		this.filter00201 = filter00201;
	}

	public FilterBean getFilter00201() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00201
		return filter00201;
	}

	public void setFilter00202(FilterBean filter00202) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00202
		this.filter00202 = filter00202;
	}

	public FilterBean getFilter00202() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00202
		return filter00202;
	}

	public void setFilter00801(FilterBean filter00801) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00801
		this.filter00801 = filter00801;
	}

	public FilterBean getFilter00801() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00801
		return filter00801;
	}

	public void setFilter00803(FilterBean filter00803) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00803
		this.filter00803 = filter00803;
	}

	public FilterBean getFilter00803() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00803
		return filter00803;
	}

	 
	
}
