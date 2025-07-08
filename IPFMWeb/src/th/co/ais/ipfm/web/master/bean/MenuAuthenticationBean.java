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
	private static final long serialVersionUID = 5623151652975962315L;
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

	public boolean isRowCheck() {
		return rowCheck;
	}

	public void setRowCheck(boolean rowCheck) {
		this.rowCheck = rowCheck;
	}

	public List<SelectItem> getMasterMenuList() {
		return masterMenuList;
	}

	public void setMasterMenuList(List<SelectItem> masterMenuList) {
		this.masterMenuList = masterMenuList;
	}

	public IPFMRichComboItem getMasterMenuComboItem() {
		return masterMenuComboItem;
	}

	public void setMasterMenuComboItem(IPFMRichComboItem masterMenuComboItem) {
		this.masterMenuComboItem = masterMenuComboItem;
	}

	public IpUser getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(IpUser userInfo) {
		this.userInfo = userInfo;
	}

	public IpFunction getIpFucntion() {
		return ipFucntion;
	}

	public void setIpFucntion(IpFunction ipFucntion) {
		this.ipFucntion = ipFucntion;
	}

	public List<IpFunction> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<IpFunction> menuList) {
		this.menuList = menuList;
	}

	public List<IpFunction> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<IpFunction> roleList) {
		this.roleList = roleList;
	}

	public void setFilterMenu(FilterBean filterMenu) {
		this.filterMenu = filterMenu;
	}

	public FilterBean getFilterMenu() {
		return filterMenu;
	}
	
}
