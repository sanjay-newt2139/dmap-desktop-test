package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;

public class ParameterManageBean implements Serializable {
	
	private static final long serialVersionUID = 3251774689702918816L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private String group;
	private String subGroup;
	private String stringValue;
	private String numericValue;
	private String booleanValue;
	private boolean disPlaySearchResult = false;
	private String rowId;
	private IPParameter ipParameter;
	
	private List<SelectItem> groupList;
	private List<SelectItem> subGroupList;
	private List<IPParameter> ipParameterList;
	
	private boolean disabledForEdit;
	private boolean displayForEdit;
	private boolean displayForCreate;
	
	private SortColumnBean sortIpUrs014 = new SortColumnBean();	
	private FilterBean filterIpUrs014 = new FilterBean();
	
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	public String getGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroup
		return group;
	}
	public void setGroup(String group) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroup
		this.group = group;
	}
	public String getSubGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubGroup
		return subGroup;
	}
	public void setSubGroup(String subGroup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubGroup
		this.subGroup = subGroup;
	}
	public boolean isDisPlaySearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisPlaySearchResult
		return disPlaySearchResult;
	}
	public void setDisPlaySearchResult(boolean disPlaySearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisPlaySearchResult
		this.disPlaySearchResult = disPlaySearchResult;
	}
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}
	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	public IPParameter getIpParameter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpParameter
		return ipParameter;
	}
	public void setIpParameter(IPParameter ipParameter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpParameter
		this.ipParameter = ipParameter;
	}
	public List<SelectItem> getGroupList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroupList
		return groupList;
	}
	public void setGroupList(List<SelectItem> groupList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroupList
		this.groupList = groupList;
	}
	public List<SelectItem> getSubGroupList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubGroupList
		return subGroupList;
	}
	public void setSubGroupList(List<SelectItem> subGroupList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubGroupList
		this.subGroupList = subGroupList;
	}
	public List<IPParameter> getIpParameterList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpParameterList
		return ipParameterList;
	}
	public void setIpParameterList(List<IPParameter> ipParameterList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpParameterList
		this.ipParameterList = ipParameterList;
	}
	public boolean isDisabledForEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledForEdit
		return disabledForEdit;
	}
	public void setDisabledForEdit(boolean disabledForEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledForEdit
		this.disabledForEdit = disabledForEdit;
	}
	public boolean isDisplayForEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForEdit
		return displayForEdit;
	}
	public void setDisplayForEdit(boolean displayForEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForEdit
		this.displayForEdit = displayForEdit;
	}
	public boolean isDisplayForCreate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForCreate
		return displayForCreate;
	}
	public void setDisplayForCreate(boolean displayForCreate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForCreate
		this.displayForCreate = displayForCreate;
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
	public String getStringValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStringValue
		return stringValue;
	}
	public void setStringValue(String stringValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStringValue
		this.stringValue = stringValue;
	}
	public String getNumericValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNumericValue
		return numericValue;
	}
	public void setNumericValue(String numericValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNumericValue
		this.numericValue = numericValue;
	}
	public String getBooleanValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getBooleanValue
		return booleanValue;
	}
	public void setBooleanValue(String booleanValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setBooleanValue
		this.booleanValue = booleanValue;
	}
	public void setSortIpUrs014(SortColumnBean sortIpUrs014) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpUrs014
		this.sortIpUrs014 = sortIpUrs014;
	}
	public SortColumnBean getSortIpUrs014() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpUrs014
		return sortIpUrs014;
	}
	public void setFilterIpUrs014(FilterBean filterIpUrs014) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpUrs014
		this.filterIpUrs014 = filterIpUrs014;
	}
	public FilterBean getFilterIpUrs014() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpUrs014
		return filterIpUrs014;
	}

}
