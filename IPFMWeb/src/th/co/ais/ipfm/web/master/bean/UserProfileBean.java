package th.co.ais.ipfm.web.master.bean;

import java.util.List;

import javax.faces.model.SelectItem;
import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import org.richfaces.model.Ordering;

public class UserProfileBean extends IPFMBaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5623151652975962315L;
	
	private boolean roleVisible;
	private boolean roleAllVisible;
	
	private IpUser userInfo = new IpUser();
	private IpDelegateUser ipDelegateUser = new IpDelegateUser();
	private IpRoleMember ipRoleMember = new IpRoleMember();
	private List<IpRoleMember> roleDataList;
	private List<IpUser> userDataList;
	private List<IpDelegateUser> delegateDataList;
	private String userStatus = "";
	private boolean delegateRender = false;
	private boolean rowCheck = false;
	private List<SelectItem> userIdComboList;
	private List<SelectItem> delegateList;
	private List<SelectItem> userComboList;
	private List<SelectItem> roleComboList;
	private List<SelectItem> roleAllComboList;
	private List<SelectItem> delegateToList;
	
	
	private IPFMRichComboItem userIdComboItem;
	private IPFMRichComboItem delegateComboItem;
	private IPFMRichComboItem userComboItem;
	private IPFMRichComboItem roleComboItem;
	private IPFMRichComboItem roleAllComboItem;
	private IPFMRichComboItem delegateToComboItem;
	
	private String role06Flag = "N";
	private String role07Flag = "N";

	private String nameFilter;
	private String nameOrder;
	
	private String posFilter;
	private String posOrder;
		
	private String teamFilter;
	private String teamOrder;
	
	private String departFilter;
	private String departOrder;
	
	private SortColumnBean sortPopupAddUser = new SortColumnBean();
	private FilterBean filterPopupAddUser = new FilterBean();
	
	private FilterBean filter001 = new FilterBean();
	
	private SortColumnBean sort002 = new SortColumnBean();
	private FilterBean filter002 = new FilterBean();
	
	private SortColumnBean sort007 = new SortColumnBean();
	private FilterBean filter007 = new FilterBean();
	
	private FilterBean filter0071 = new FilterBean();
	
	private FilterBean filterIs007 = new FilterBean();
	
	public String mNameOrder() {	
		if((this.getNameOrder()!=null) && (this.getNameOrder().equals("ASCENDING"))) 
			this.setNameOrder(Ordering.DESCENDING.name());
		else  this.setNameOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	public String mPosOrder() {	
		if((this.getPosOrder()!=null) && (this.getPosOrder().equals("ASCENDING"))) 
			this.setPosOrder(Ordering.DESCENDING.name());
		else  this.setPosOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	public String mTeamOrder() {	
		if((this.getTeamOrder()!=null) && (this.getTeamOrder().equals("ASCENDING"))) 
			this.setTeamOrder(Ordering.DESCENDING.name());
		else  this.setTeamOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	public String mDepartOrder() {	
		if((this.getDepartOrder()!=null) && (this.getDepartOrder().equals("ASCENDING"))) 
			this.setDepartOrder(Ordering.DESCENDING.name());
		else  this.setDepartOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	
	 
	public String getPosFilter() {
		return posFilter;
	}




	public void setPosFilter(String posFilter) {
		this.posFilter = posFilter;
	}




	public String getPosOrder() {
		return posOrder;
	}




	public void setPosOrder(String posOrder) {
		this.posOrder = posOrder;
	}




	public String getTeamFilter() {
		return teamFilter;
	}




	public void setTeamFilter(String teamFilter) {
		this.teamFilter = teamFilter;
	}




	public String getTeamOrder() {
		return teamOrder;
	}




	public void setTeamOrder(String teamOrder) {
		this.teamOrder = teamOrder;
	}




	public String getDepartFilter() {
		return departFilter;
	}




	public void setDepartFilter(String departFilter) {
		this.departFilter = departFilter;
	}




	public String getDepartOrder() {
		return departOrder;
	}




	public void setDepartOrder(String departOrder) {
		this.departOrder = departOrder;
	}




	public String getNameOrder() {
		return nameOrder;
	}

	public void setNameOrder(String nameOrder) {
		this.nameOrder = nameOrder;
	}



	

	 

	public String getNameFilter() {
		return nameFilter;
	}

	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}

	public boolean getRoleVisible() {
		return roleVisible;
	}

	public void setRoleVisible(boolean roleVisible) {
		this.roleVisible = roleVisible;
	}

	public boolean getRoleAllVisible() {
		return roleAllVisible;
	}

	public void setRoleAllVisible(boolean roleAllVisible) {
		this.roleAllVisible = roleAllVisible;
	}

	public UserProfileBean() {
		try {
			userInfo = (IpUser)IPFMWebUtil.getUserSession().getIpUser().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}		
	}

	public List<SelectItem> getDelegateList() {
		return delegateList;
	}

	public void setDelegateList(List<SelectItem> delegateList) {
		this.delegateList = delegateList;
	}

	public IPFMRichComboItem getDelegateComboItem() {
		return delegateComboItem;
	}

	public void setDelegateComboItem(IPFMRichComboItem delegateComboItem) {
		this.delegateComboItem = delegateComboItem;
	}

	public boolean isRowCheck() {
		return rowCheck;
	}

	public void setRowCheck(boolean rowCheck) {
		this.rowCheck = rowCheck;
	}

	public IpUser getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(IpUser userInfo) {
		this.userInfo = userInfo;
	}
	public List<SelectItem> getUserComboList() {
		return userComboList;
	}

	public void setUserComboList(List<SelectItem> userComboList) {
		this.userComboList = userComboList;
	}

	public IPFMRichComboItem getUserComboItem() {
		return userComboItem;
	}

	public void setUserComboItem(IPFMRichComboItem userComboItem) {
		this.userComboItem = userComboItem;
	}

	public List<SelectItem> getRoleComboList() {
		return roleComboList;
	}

	public void setRoleComboList(List<SelectItem> roleComboList) {
		this.roleComboList = roleComboList;
	}

	public IPFMRichComboItem getRoleComboItem() {
		return roleComboItem;
	}

	public void setRoleComboItem(IPFMRichComboItem roleComboItem) {
		this.roleComboItem = roleComboItem;
	}

	public List<SelectItem> getDelegateToList() {
		return delegateToList;
	}

	public void setDelegateToList(List<SelectItem> delegateToList) {
		this.delegateToList = delegateToList;
	}

	public IPFMRichComboItem getDelegateToComboItem() {
		return delegateToComboItem;
	}

	public void setDelegateToComboItem(IPFMRichComboItem delegateToComboItem) {
		this.delegateToComboItem = delegateToComboItem;
	}

	public List<IpRoleMember> getRoleDataList() {
		return roleDataList;
	}

	public void setRoleDataList(List<IpRoleMember> roleDataList) {
		this.roleDataList = roleDataList;
	}

	public List<IpUser> getUserDataList() {
		return userDataList;
	}

	public void setUserDataList(List<IpUser> userDataList) {
		this.userDataList = userDataList;
	}

	public List<IpDelegateUser> getDelegateDataList() {
		return delegateDataList;
	}

	public void setDelegateDataList(List<IpDelegateUser> delegateDataList) {
		this.delegateDataList = delegateDataList;
	}

	public IpDelegateUser getIpDelegateUser() {
		return ipDelegateUser;
	}

	public void setIpDelegateUser(IpDelegateUser ipDelegateUser) {
		this.ipDelegateUser = ipDelegateUser;
	}

	public IpRoleMember getIpRoleMember() {
		return ipRoleMember;
	}

	public void setIpRoleMember(IpRoleMember ipRoleMember) {
		this.ipRoleMember = ipRoleMember;
	}

	public List<SelectItem> getUserIdComboList() {
		return userIdComboList;
	}

	public void setUserIdComboList(List<SelectItem> userIdComboList) {
		this.userIdComboList = userIdComboList;
	}

	public IPFMRichComboItem getUserIdComboItem() {
		return userIdComboItem;
	}

	public void setUserIdComboItem(IPFMRichComboItem userIdComboItem) {
		this.userIdComboItem = userIdComboItem;
	}

	public List<SelectItem> getRoleAllComboList() {
		return roleAllComboList;
	}

	public void setRoleAllComboList(List<SelectItem> roleAllComboList) {
		this.roleAllComboList = roleAllComboList;
	}

	public IPFMRichComboItem getRoleAllComboItem() {
		return roleAllComboItem;
	}

	public void setRoleAllComboItem(IPFMRichComboItem roleAllComboItem) {
		this.roleAllComboItem = roleAllComboItem;
	}

	public boolean isDelegateRender() {
		return delegateRender;
	}

	public void setDelegateRender(boolean delegateRender) {
		this.delegateRender = delegateRender;
	}

	public String getRole06Flag() {
		return role06Flag;
	}

	public void setRole06Flag(String role06Flag) {
		this.role06Flag = role06Flag;
	}

	public String getRole07Flag() {
		return role07Flag;
	}

	public void setRole07Flag(String role07Flag) {
		this.role07Flag = role07Flag;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public void setFilterPopupAddUser(FilterBean filterPopupAddUser) {
		this.filterPopupAddUser = filterPopupAddUser;
	}

	public FilterBean getFilterPopupAddUser() {
		return filterPopupAddUser;
	}

	public void setSortPopupAddUser(SortColumnBean sortPopupAddUser) {
		this.sortPopupAddUser = sortPopupAddUser;
	}

	public SortColumnBean getSortPopupAddUser() {
		return sortPopupAddUser;
	}

	public void setFilter001(FilterBean filter001) {
		this.filter001 = filter001;
	}

	public FilterBean getFilter001() {
		return filter001;
	}

	public void setSort002(SortColumnBean sort002) {
		this.sort002 = sort002;
	}

	public SortColumnBean getSort002() {
		return sort002;
	}

	public void setFilter002(FilterBean filter002) {
		this.filter002 = filter002;
	}

	public FilterBean getFilter002() {
		return filter002;
	}

	public void setSort007(SortColumnBean sort007) {
		this.sort007 = sort007;
	}

	public SortColumnBean getSort007() {
		return sort007;
	}

	public void setFilter007(FilterBean filter007) {
		this.filter007 = filter007;
	}

	public FilterBean getFilter007() {
		return filter007;
	}

	public void setFilter0071(FilterBean filter0071) {
		this.filter0071 = filter0071;
	}

	public FilterBean getFilter0071() {
		return filter0071;
	}

	public void setFilterIs007(FilterBean filterIs007) {
		this.filterIs007 = filterIs007;
	}

	public FilterBean getFilterIs007() {
		return filterIs007;
	}

	
	
}
