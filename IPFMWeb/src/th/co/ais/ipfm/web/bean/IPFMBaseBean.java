package th.co.ais.ipfm.web.bean;

import java.io.Serializable;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.util.IPFMConstant;

public class IPFMBaseBean implements Serializable {
	private static final long serialVersionUID = -2382081872985903096L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	protected HtmlModalPanel popupModal;
	protected HtmlDataTable dataTable;
	protected int selectRowIndex = -1;
	protected String mode = IPFMConstant.MODE_NEW;
	protected String action = "";
	protected String urStatusDesc = "";
	protected String ipVersion = "4";
	protected int scrollerPage = 1;
	protected String sortColumn = null;
	protected boolean sortAscending = true;
	protected boolean checkAll = false;


	public IPFMBaseBean() {
	}

	public static Object getRequestParameter(String name) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestParameter
		return (Object) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(name);
	}

	public ValueExpression createValueExpression(String valueExpression,
			Class<?> valueType) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext
				.getApplication()
				.getExpressionFactory()
				.createValueExpression(facesContext.getELContext(),
						valueExpression, valueType);
	}

	public HtmlModalPanel getPopupModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupModal
		return popupModal;
	}

	public void setPopupModal(HtmlModalPanel popupModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupModal
		this.popupModal = popupModal;
	}

	public HtmlDataTable getDataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDataTable
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDataTable
		this.dataTable = dataTable;
	}

	public int getSelectRowIndex() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectRowIndex
		return selectRowIndex;
	}

	public void setSelectRowIndex(int selectRowIndex) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectRowIndex
		this.selectRowIndex = selectRowIndex;
	}

	public String getMode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMode
		return mode;
	}

	public void setMode(String mode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMode
		this.mode = mode;
	}

	public String getAction() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAction
		return action;
	}

	public void setAction(String action) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAction
		this.action = action;
	}

	public String getUrStatusDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusDesc
		return urStatusDesc;
	}

	public void setUrStatusDesc(String urStatusDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatusDesc
		this.urStatusDesc = urStatusDesc;
	}

	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}

	public int getScrollerPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getScrollerPage
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setScrollerPage
		this.scrollerPage = scrollerPage;
	}

	public String getSortColumn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortColumn
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortColumn
		this.sortColumn = sortColumn;
	}

	public boolean isSortAscending() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSortAscending
		return sortAscending;
	}

	public void setSortAscending(boolean sortAscending) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortAscending
		this.sortAscending = sortAscending;
	}

	public boolean isCheckAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckAll
		return checkAll;
	}

	public void setCheckAll(boolean checkAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckAll
		this.checkAll = checkAll;
	} 
}
