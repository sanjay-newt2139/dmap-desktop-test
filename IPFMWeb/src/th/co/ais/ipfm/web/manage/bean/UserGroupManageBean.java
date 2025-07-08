package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPGroupMember;
import th.co.ais.ipfm.domain.IPGroupMemberUser;
import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class UserGroupManageBean implements Serializable {
	
	
	private static final long serialVersionUID = 3251774689702918816L;
	
	private String  rowId;
	private String  groupId;
	private String  groupName;
	private String  userId;
	private String  userName;
	
	
	private IPGroupMemberUser ipGroupMember;
	private List<IPGroupMemberUser> ipGroupMemberList;
	private List<SelectItem> userGroupList;
	private IPFMRichComboItem userGroupComboItem;
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	private boolean disabledButtonSelectAll=false;
	private boolean disabledButtonSelect=false;
	private boolean disabledButtonDeSelect=false;
	private boolean disabledButtonAddUser=false;
	private boolean disabledButtonDelete=false;
	
	private boolean displayButtonAdd=false;
	private boolean displayButtonCancel=false;
	
	private FilterBean filterIpUrs012 = new FilterBean();
	
	public boolean isDisabledButtonSelectAll() {
		return disabledButtonSelectAll;
	}
	public void setDisabledButtonSelectAll(boolean disabledButtonSelectAll) {
		this.disabledButtonSelectAll = disabledButtonSelectAll;
	}
	public boolean isDisabledButtonSelect() {
		return disabledButtonSelect;
	}
	public void setDisabledButtonSelect(boolean disabledButtonSelect) {
		this.disabledButtonSelect = disabledButtonSelect;
	}
	public boolean isDisabledButtonDeSelect() {
		return disabledButtonDeSelect;
	}
	public void setDisabledButtonDeSelect(boolean disabledButtonDeSelect) {
		this.disabledButtonDeSelect = disabledButtonDeSelect;
	}
	public boolean isDisabledButtonAddUser() {
		return disabledButtonAddUser;
	}
	public void setDisabledButtonAddUser(boolean disabledButtonAddUser) {
		this.disabledButtonAddUser = disabledButtonAddUser;
	}
	public boolean isDisabledButtonDelete() {
		return disabledButtonDelete;
	}
	public void setDisabledButtonDelete(boolean disabledButtonDelete) {
		this.disabledButtonDelete = disabledButtonDelete;
	}
	public boolean isDisplayButtonAdd() {
		return displayButtonAdd;
	}
	public void setDisplayButtonAdd(boolean displayButtonAdd) {
		this.displayButtonAdd = displayButtonAdd;
	}
	public boolean isDisplayButtonCancel() {
		return displayButtonCancel;
	}
	public void setDisplayButtonCancel(boolean displayButtonCancel) {
		this.displayButtonCancel = displayButtonCancel;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() {
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
	}
	public IPGroupMemberUser getIpGroupMember() {
		return ipGroupMember;
	}
	public void setIpGroupMember(IPGroupMemberUser ipGroupMember) {
		this.ipGroupMember = ipGroupMember;
	}
	public List<IPGroupMemberUser> getIpGroupMemberList() {
		return ipGroupMemberList;
	}
	public void setIpGroupMemberList(List<IPGroupMemberUser> ipGroupMemberList) {
		this.ipGroupMemberList = ipGroupMemberList;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<SelectItem> getUserGroupList() {
		return userGroupList;
	}
	public void setUserGroupList(List<SelectItem> userGroupList) {
		this.userGroupList = userGroupList;
	}
	public IPFMRichComboItem getUserGroupComboItem() {
		return userGroupComboItem;
	}
	public void setUserGroupComboItem(IPFMRichComboItem userGroupComboItem) {
		this.userGroupComboItem = userGroupComboItem;
	}
	public void setFilterIpUrs012(FilterBean filterIpUrs012) {
		this.filterIpUrs012 = filterIpUrs012;
	}
	public FilterBean getFilterIpUrs012() {
		return filterIpUrs012;
	}

}
