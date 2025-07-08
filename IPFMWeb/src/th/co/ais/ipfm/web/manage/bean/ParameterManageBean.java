package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;

public class ParameterManageBean implements Serializable {
	
	private static final long serialVersionUID = 3251774689702918816L;
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
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSubGroup() {
		return subGroup;
	}
	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}
	public boolean isDisPlaySearchResult() {
		return disPlaySearchResult;
	}
	public void setDisPlaySearchResult(boolean disPlaySearchResult) {
		this.disPlaySearchResult = disPlaySearchResult;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public IPParameter getIpParameter() {
		return ipParameter;
	}
	public void setIpParameter(IPParameter ipParameter) {
		this.ipParameter = ipParameter;
	}
	public List<SelectItem> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<SelectItem> groupList) {
		this.groupList = groupList;
	}
	public List<SelectItem> getSubGroupList() {
		return subGroupList;
	}
	public void setSubGroupList(List<SelectItem> subGroupList) {
		this.subGroupList = subGroupList;
	}
	public List<IPParameter> getIpParameterList() {
		return ipParameterList;
	}
	public void setIpParameterList(List<IPParameter> ipParameterList) {
		this.ipParameterList = ipParameterList;
	}
	public boolean isDisabledForEdit() {
		return disabledForEdit;
	}
	public void setDisabledForEdit(boolean disabledForEdit) {
		this.disabledForEdit = disabledForEdit;
	}
	public boolean isDisplayForEdit() {
		return displayForEdit;
	}
	public void setDisplayForEdit(boolean displayForEdit) {
		this.displayForEdit = displayForEdit;
	}
	public boolean isDisplayForCreate() {
		return displayForCreate;
	}
	public void setDisplayForCreate(boolean displayForCreate) {
		this.displayForCreate = displayForCreate;
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
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public String getNumericValue() {
		return numericValue;
	}
	public void setNumericValue(String numericValue) {
		this.numericValue = numericValue;
	}
	public String getBooleanValue() {
		return booleanValue;
	}
	public void setBooleanValue(String booleanValue) {
		this.booleanValue = booleanValue;
	}
	public void setSortIpUrs014(SortColumnBean sortIpUrs014) {
		this.sortIpUrs014 = sortIpUrs014;
	}
	public SortColumnBean getSortIpUrs014() {
		return sortIpUrs014;
	}
	public void setFilterIpUrs014(FilterBean filterIpUrs014) {
		this.filterIpUrs014 = filterIpUrs014;
	}
	public FilterBean getFilterIpUrs014() {
		return filterIpUrs014;
	}

}
