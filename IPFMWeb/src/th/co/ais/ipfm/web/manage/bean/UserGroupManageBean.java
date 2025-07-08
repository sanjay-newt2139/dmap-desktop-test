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
	
	
	private static final long serialVersionUID = 3251774689702918816L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
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
	
	public boolean isDisabledButtonSelectAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledButtonSelectAll
		return disabledButtonSelectAll;
	}
	public void setDisabledButtonSelectAll(boolean disabledButtonSelectAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledButtonSelectAll
		this.disabledButtonSelectAll = disabledButtonSelectAll;
	}
	public boolean isDisabledButtonSelect() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledButtonSelect
		return disabledButtonSelect;
	}
	public void setDisabledButtonSelect(boolean disabledButtonSelect) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledButtonSelect
		this.disabledButtonSelect = disabledButtonSelect;
	}
	public boolean isDisabledButtonDeSelect() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledButtonDeSelect
		return disabledButtonDeSelect;
	}
	public void setDisabledButtonDeSelect(boolean disabledButtonDeSelect) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledButtonDeSelect
		this.disabledButtonDeSelect = disabledButtonDeSelect;
	}
	public boolean isDisabledButtonAddUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledButtonAddUser
		return disabledButtonAddUser;
	}
	public void setDisabledButtonAddUser(boolean disabledButtonAddUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledButtonAddUser
		this.disabledButtonAddUser = disabledButtonAddUser;
	}
	public boolean isDisabledButtonDelete() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledButtonDelete
		return disabledButtonDelete;
	}
	public void setDisabledButtonDelete(boolean disabledButtonDelete) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledButtonDelete
		this.disabledButtonDelete = disabledButtonDelete;
	}
	public boolean isDisplayButtonAdd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayButtonAdd
		return displayButtonAdd;
	}
	public void setDisplayButtonAdd(boolean displayButtonAdd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayButtonAdd
		this.displayButtonAdd = displayButtonAdd;
	}
	public boolean isDisplayButtonCancel() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayButtonCancel
		return displayButtonCancel;
	}
	public void setDisplayButtonCancel(boolean displayButtonCancel) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayButtonCancel
		this.displayButtonCancel = displayButtonCancel;
	}
	public int getRowPerPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage
		return maxPage;
	}
	public void setMaxPage(int maxPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult
		this.maxSearchResult = maxSearchResult;
	}
	public IPGroupMemberUser getIpGroupMember() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpGroupMember
		return ipGroupMember;
	}
	public void setIpGroupMember(IPGroupMemberUser ipGroupMember) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpGroupMember
		this.ipGroupMember = ipGroupMember;
	}
	public List<IPGroupMemberUser> getIpGroupMemberList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpGroupMemberList
		return ipGroupMemberList;
	}
	public void setIpGroupMemberList(List<IPGroupMemberUser> ipGroupMemberList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpGroupMemberList
		this.ipGroupMemberList = ipGroupMemberList;
	}
	public String getGroupId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupId
		return groupId;
	}
	public void setGroupId(String groupId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupId
		this.groupId = groupId;
	}
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}
	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	public String getGroupName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupName
		return groupName;
	}
	public void setGroupName(String groupName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupName
		this.groupName = groupName;
	}
	public String getUserId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserId
		return userId;
	}
	public void setUserId(String userId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserId
		this.userId = userId;
	}
	public String getUserName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserName
		return userName;
	}
	public void setUserName(String userName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserName
		this.userName = userName;
	}
	public List<SelectItem> getUserGroupList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserGroupList
		return userGroupList;
	}
	public void setUserGroupList(List<SelectItem> userGroupList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserGroupList
		this.userGroupList = userGroupList;
	}
	public IPFMRichComboItem getUserGroupComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserGroupComboItem
		return userGroupComboItem;
	}
	public void setUserGroupComboItem(IPFMRichComboItem userGroupComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserGroupComboItem
		this.userGroupComboItem = userGroupComboItem;
	}
	public void setFilterIpUrs012(FilterBean filterIpUrs012) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs012
		this.filterIpUrs012 = filterIpUrs012;
	}
	public FilterBean getFilterIpUrs012() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs012
		return filterIpUrs012;
	}

}
