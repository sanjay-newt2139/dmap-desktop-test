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
	private static final long serialVersionUID = 3251774689702918816L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
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

	public boolean isDisplayForCreate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForCreate
		return displayForCreate;
	}

	public void setDisplayForCreate(boolean displayForCreate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForCreate
		this.displayForCreate = displayForCreate;
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

	public IPParameter getIpParameter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpParameter
		return ipParameter;
	}

	public void setIpParameter(IPParameter ipParameter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpParameter
		this.ipParameter = ipParameter;
	}

	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	public boolean isDisPlaySearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisPlaySearchResult
		if(ipParameterList!=null && ipParameterList.size()>0){
			return true;
		}else{
			return false;
		}
	}

	public void setDisPlaySearchResult(boolean disPlaySearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisPlaySearchResult
		this.disPlaySearchResult = disPlaySearchResult;
	}

	public List<IPParameter> getIpParameterList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpParameterList
		return ipParameterList;
	}

	public void setIpParameterList(List<IPParameter> ipParameterList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpParameterList
		this.ipParameterList = ipParameterList;
	}

	public String getGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGroup
		return group;
	}
	
	public void setGroup(String group) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGroup
		this.group = group;
	}
	
	public String getSubGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubGroup
		return subGroup;
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

	public void setSubGroup(String subGroup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubGroup
		this.subGroup = subGroup;
	}

	public void setFilterSysParam(FilterBean filterSysParam) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterSysParam
		this.filterSysParam = filterSysParam;
	}

	public FilterBean getFilterSysParam() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterSysParam
		return filterSysParam;
	}

	public void setSortSys(SortColumnBean sortSys) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortSys
		this.sortSys = sortSys;
	}

	public SortColumnBean getSortSys() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortSys
		return sortSys;
	}
	
	
	
	
}
