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
	private static final long serialVersionUID = 5623151652975962315L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
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
	
	public String mNameOrder() {	 // DMAP Comment : Dead Code Detected - The Following Method has no reference mNameOrder
		if((this.getNameOrder()!=null) && (this.getNameOrder().equals("ASCENDING"))) 
			this.setNameOrder(Ordering.DESCENDING.name());
		else  this.setNameOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	public String mPosOrder() {	 // DMAP Comment : Dead Code Detected - The Following Method has no reference mPosOrder
		if((this.getPosOrder()!=null) && (this.getPosOrder().equals("ASCENDING"))) 
			this.setPosOrder(Ordering.DESCENDING.name());
		else  this.setPosOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	public String mTeamOrder() {	 // DMAP Comment : Dead Code Detected - The Following Method has no reference mTeamOrder
		if((this.getTeamOrder()!=null) && (this.getTeamOrder().equals("ASCENDING"))) 
			this.setTeamOrder(Ordering.DESCENDING.name());
		else  this.setTeamOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	public String mDepartOrder() {	 // DMAP Comment : Dead Code Detected - The Following Method has no reference mDepartOrder
		if((this.getDepartOrder()!=null) && (this.getDepartOrder().equals("ASCENDING"))) 
			this.setDepartOrder(Ordering.DESCENDING.name());
		else  this.setDepartOrder(Ordering.ASCENDING.name());		
		
		return "";
	}
	
	
	 
	public String getPosFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPosFilter
		return posFilter;
	}




	public void setPosFilter(String posFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPosFilter
		this.posFilter = posFilter;
	}




	public String getPosOrder() {
		return posOrder;
	}




	public void setPosOrder(String posOrder) {
		this.posOrder = posOrder;
	}




	public String getTeamFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamFilter
		return teamFilter;
	}




	public void setTeamFilter(String teamFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamFilter
		this.teamFilter = teamFilter;
	}




	public String getTeamOrder() {
		return teamOrder;
	}




	public void setTeamOrder(String teamOrder) {
		this.teamOrder = teamOrder;
	}




	public String getDepartFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDepartFilter
		return departFilter;
	}




	public void setDepartFilter(String departFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDepartFilter
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



	

	 

	public String getNameFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNameFilter
		return nameFilter;
	}

	public void setNameFilter(String nameFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNameFilter
		this.nameFilter = nameFilter;
	}

	public boolean getRoleVisible() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleVisible
		return roleVisible;
	}

	public void setRoleVisible(boolean roleVisible) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleVisible
		this.roleVisible = roleVisible;
	}

	public boolean getRoleAllVisible() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleAllVisible
		return roleAllVisible;
	}

	public void setRoleAllVisible(boolean roleAllVisible) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleAllVisible
		this.roleAllVisible = roleAllVisible;
	}

	public UserProfileBean() {
		try {
			userInfo = (IpUser)IPFMWebUtil.getUserSession().getIpUser().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}		
	}

	public List<SelectItem> getDelegateList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateList
		return delegateList;
	}

	public void setDelegateList(List<SelectItem> delegateList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateList
		this.delegateList = delegateList;
	}

	public IPFMRichComboItem getDelegateComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateComboItem
		return delegateComboItem;
	}

	public void setDelegateComboItem(IPFMRichComboItem delegateComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateComboItem
		this.delegateComboItem = delegateComboItem;
	}

	public boolean isRowCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isRowCheck
		return rowCheck;
	}

	public void setRowCheck(boolean rowCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowCheck
		this.rowCheck = rowCheck;
	}

	public IpUser getUserInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserInfo
		return userInfo;
	}

	public void setUserInfo(IpUser userInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserInfo
		this.userInfo = userInfo;
	}
	public List<SelectItem> getUserComboList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserComboList
		return userComboList;
	}

	public void setUserComboList(List<SelectItem> userComboList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserComboList
		this.userComboList = userComboList;
	}

	public IPFMRichComboItem getUserComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserComboItem
		return userComboItem;
	}

	public void setUserComboItem(IPFMRichComboItem userComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserComboItem
		this.userComboItem = userComboItem;
	}

	public List<SelectItem> getRoleComboList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleComboList
		return roleComboList;
	}

	public void setRoleComboList(List<SelectItem> roleComboList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleComboList
		this.roleComboList = roleComboList;
	}

	public IPFMRichComboItem getRoleComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleComboItem
		return roleComboItem;
	}

	public void setRoleComboItem(IPFMRichComboItem roleComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleComboItem
		this.roleComboItem = roleComboItem;
	}

	public List<SelectItem> getDelegateToList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateToList
		return delegateToList;
	}

	public void setDelegateToList(List<SelectItem> delegateToList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateToList
		this.delegateToList = delegateToList;
	}

	public IPFMRichComboItem getDelegateToComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateToComboItem
		return delegateToComboItem;
	}

	public void setDelegateToComboItem(IPFMRichComboItem delegateToComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateToComboItem
		this.delegateToComboItem = delegateToComboItem;
	}

	public List<IpRoleMember> getRoleDataList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleDataList
		return roleDataList;
	}

	public void setRoleDataList(List<IpRoleMember> roleDataList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleDataList
		this.roleDataList = roleDataList;
	}

	public List<IpUser> getUserDataList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserDataList
		return userDataList;
	}

	public void setUserDataList(List<IpUser> userDataList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserDataList
		this.userDataList = userDataList;
	}

	public List<IpDelegateUser> getDelegateDataList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateDataList
		return delegateDataList;
	}

	public void setDelegateDataList(List<IpDelegateUser> delegateDataList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateDataList
		this.delegateDataList = delegateDataList;
	}

	public IpDelegateUser getIpDelegateUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpDelegateUser
		return ipDelegateUser;
	}

	public void setIpDelegateUser(IpDelegateUser ipDelegateUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpDelegateUser
		this.ipDelegateUser = ipDelegateUser;
	}

	public IpRoleMember getIpRoleMember() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRoleMember
		return ipRoleMember;
	}

	public void setIpRoleMember(IpRoleMember ipRoleMember) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpRoleMember
		this.ipRoleMember = ipRoleMember;
	}

	public List<SelectItem> getUserIdComboList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserIdComboList
		return userIdComboList;
	}

	public void setUserIdComboList(List<SelectItem> userIdComboList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserIdComboList
		this.userIdComboList = userIdComboList;
	}

	public IPFMRichComboItem getUserIdComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserIdComboItem
		return userIdComboItem;
	}

	public void setUserIdComboItem(IPFMRichComboItem userIdComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserIdComboItem
		this.userIdComboItem = userIdComboItem;
	}

	public List<SelectItem> getRoleAllComboList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleAllComboList
		return roleAllComboList;
	}

	public void setRoleAllComboList(List<SelectItem> roleAllComboList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleAllComboList
		this.roleAllComboList = roleAllComboList;
	}

	public IPFMRichComboItem getRoleAllComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleAllComboItem
		return roleAllComboItem;
	}

	public void setRoleAllComboItem(IPFMRichComboItem roleAllComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleAllComboItem
		this.roleAllComboItem = roleAllComboItem;
	}

	public boolean isDelegateRender() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDelegateRender
		return delegateRender;
	}

	public void setDelegateRender(boolean delegateRender) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateRender
		this.delegateRender = delegateRender;
	}

	public String getRole06Flag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRole06Flag
		return role06Flag;
	}

	public void setRole06Flag(String role06Flag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRole06Flag
		this.role06Flag = role06Flag;
	}

	public String getRole07Flag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRole07Flag
		return role07Flag;
	}

	public void setRole07Flag(String role07Flag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRole07Flag
		this.role07Flag = role07Flag;
	}

	public String getUserStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserStatus
		return userStatus;
	}

	public void setUserStatus(String userStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserStatus
		this.userStatus = userStatus;
	}

	public void setFilterPopupAddUser(FilterBean filterPopupAddUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterPopupAddUser
		this.filterPopupAddUser = filterPopupAddUser;
	}

	public FilterBean getFilterPopupAddUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterPopupAddUser
		return filterPopupAddUser;
	}

	public void setSortPopupAddUser(SortColumnBean sortPopupAddUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortPopupAddUser
		this.sortPopupAddUser = sortPopupAddUser;
	}

	public SortColumnBean getSortPopupAddUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortPopupAddUser
		return sortPopupAddUser;
	}

	public void setFilter001(FilterBean filter001) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter001
		this.filter001 = filter001;
	}

	public FilterBean getFilter001() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter001
		return filter001;
	}

	public void setSort002(SortColumnBean sort002) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSort002
		this.sort002 = sort002;
	}

	public SortColumnBean getSort002() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSort002
		return sort002;
	}

	public void setFilter002(FilterBean filter002) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter002
		this.filter002 = filter002;
	}

	public FilterBean getFilter002() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter002
		return filter002;
	}

	public void setSort007(SortColumnBean sort007) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSort007
		this.sort007 = sort007;
	}

	public SortColumnBean getSort007() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSort007
		return sort007;
	}

	public void setFilter007(FilterBean filter007) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter007
		this.filter007 = filter007;
	}

	public FilterBean getFilter007() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter007
		return filter007;
	}

	public void setFilter0071(FilterBean filter0071) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter0071
		this.filter0071 = filter0071;
	}

	public FilterBean getFilter0071() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter0071
		return filter0071;
	}

	public void setFilterIs007(FilterBean filterIs007) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIs007
		this.filterIs007 = filterIs007;
	}

	public FilterBean getFilterIs007() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIs007
		return filterIs007;
	}

	
	
}
