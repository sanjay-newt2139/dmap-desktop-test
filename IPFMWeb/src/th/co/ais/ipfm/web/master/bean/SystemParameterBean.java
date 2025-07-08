package th.co.ais.ipfm.web.master.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;

public class SystemParameterBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3251774689702918816L;
	private String group;
	private String subGroup;
	private boolean disPlaySearchResult = false;
	private String rowId;
	private IPParameter ipParameter;
	
	private List<SelectItem> groupList;
	private List<SelectItem> subGroupList;
	private List<IPParameter> ipParameterList;
	
	private boolean disabledForEdit;
	private boolean displayForEdit;
	private boolean displayForCreate;
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	private FilterBean filterSysParam = new FilterBean();
	private SortColumnBean sortSys = new SortColumnBean();;
	
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

	public boolean isDisplayForCreate() {
		return displayForCreate;
	}

	public void setDisplayForCreate(boolean displayForCreate) {
		this.displayForCreate = displayForCreate;
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

	public IPParameter getIpParameter() {
		return ipParameter;
	}

	public void setIpParameter(IPParameter ipParameter) {
		this.ipParameter = ipParameter;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public boolean isDisPlaySearchResult() {
		if(ipParameterList!=null && ipParameterList.size()>0){
			return true;
		}else{
			return false;
		}
	}

	public void setDisPlaySearchResult(boolean disPlaySearchResult) {
		this.disPlaySearchResult = disPlaySearchResult;
	}

	public List<IPParameter> getIpParameterList() {
		return ipParameterList;
	}

	public void setIpParameterList(List<IPParameter> ipParameterList) {
		this.ipParameterList = ipParameterList;
	}

	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getSubGroup() {
		return subGroup;
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

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public void setFilterSysParam(FilterBean filterSysParam) {
		this.filterSysParam = filterSysParam;
	}

	public FilterBean getFilterSysParam() {
		return filterSysParam;
	}

	public void setSortSys(SortColumnBean sortSys) {
		this.sortSys = sortSys;
	}

	public SortColumnBean getSortSys() {
		return sortSys;
	}
	
	
	
	
}
