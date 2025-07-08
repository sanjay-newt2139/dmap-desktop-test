package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import th.co.ais.ipfm.domain.TempTable;
import th.co.ais.ipfm.web.bean.FilterBean;

public class WFUserBean implements Serializable {
	private List<TempTable> tempTable;
	private String roleName;
	
	private FilterBean filterPopupView = new FilterBean();

	public List<TempTable> getTempTable() {
		return tempTable;
	}

	public void setTempTable(List<TempTable> tempTable) {
		this.tempTable = tempTable;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setFilterPopupView(FilterBean filterPopupView) {
		this.filterPopupView = filterPopupView;
	}

	public FilterBean getFilterPopupView() {
		return filterPopupView;
	}
	
	
	
	
}
