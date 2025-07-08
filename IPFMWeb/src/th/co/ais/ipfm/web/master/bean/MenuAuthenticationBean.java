package th.co.ais.ipfm.web.master.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;

public class MenuAuthenticationBean extends IPFMBaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5623151652975962315L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private IpUser userInfo = new IpUser();
	private IpFunction ipFucntion = new IpFunction();
	private List<IpFunction> menuList = new ArrayList<IpFunction>();
	private List<IpFunction> roleList = new ArrayList<IpFunction>();
	private boolean rowCheck = false;
	private List<SelectItem> masterMenuList = new ArrayList<SelectItem>();
	private IPFMRichComboItem masterMenuComboItem;
	
	private FilterBean filterMenu = new FilterBean();
	
	public MenuAuthenticationBean(){
		userInfo = IPFMWebUtil.getUserSession().getIpUser();		
	}

	public boolean isRowCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isRowCheck
		return rowCheck;
	}

	public void setRowCheck(boolean rowCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowCheck
		this.rowCheck = rowCheck;
	}

	public List<SelectItem> getMasterMenuList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMasterMenuList
		return masterMenuList;
	}

	public void setMasterMenuList(List<SelectItem> masterMenuList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMasterMenuList
		this.masterMenuList = masterMenuList;
	}

	public IPFMRichComboItem getMasterMenuComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMasterMenuComboItem
		return masterMenuComboItem;
	}

	public void setMasterMenuComboItem(IPFMRichComboItem masterMenuComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMasterMenuComboItem
		this.masterMenuComboItem = masterMenuComboItem;
	}

	public IpUser getUserInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserInfo
		return userInfo;
	}

	public void setUserInfo(IpUser userInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserInfo
		this.userInfo = userInfo;
	}

	public IpFunction getIpFucntion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpFucntion
		return ipFucntion;
	}

	public void setIpFucntion(IpFunction ipFucntion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpFucntion
		this.ipFucntion = ipFucntion;
	}

	public List<IpFunction> getMenuList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMenuList
		return menuList;
	}

	public void setMenuList(List<IpFunction> menuList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMenuList
		this.menuList = menuList;
	}

	public List<IpFunction> getRoleList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleList
		return roleList;
	}

	public void setRoleList(List<IpFunction> roleList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleList
		this.roleList = roleList;
	}

	public void setFilterMenu(FilterBean filterMenu) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterMenu
		this.filterMenu = filterMenu;
	}

	public FilterBean getFilterMenu() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterMenu
		return filterMenu;
	}
	
}
