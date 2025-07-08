package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import th.co.ais.ipfm.domain.TempTable;
import th.co.ais.ipfm.web.bean.FilterBean;

public class WFUserBean implements Serializable {
	private List<TempTable> tempTable;
	private String roleName;
	
	private FilterBean filterPopupView = new FilterBean();

	public List<TempTable> getTempTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTempTable
		return tempTable;
	}

	public void setTempTable(List<TempTable> tempTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTempTable
		this.tempTable = tempTable;
	}

	public String getRoleName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleName
		return roleName;
	}

	public void setRoleName(String roleName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleName
		this.roleName = roleName;
	}

	public void setFilterPopupView(FilterBean filterPopupView) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterPopupView
		this.filterPopupView = filterPopupView;
	}

	public FilterBean getFilterPopupView() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterPopupView
		return filterPopupView;
	}
	
	
	
	
}
