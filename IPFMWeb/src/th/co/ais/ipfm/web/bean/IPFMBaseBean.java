package th.co.ais.ipfm.web.bean;

import java.io.Serializable;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.util.IPFMConstant;

public class IPFMBaseBean implements Serializable {
	private static final long serialVersionUID = -2382081872985903096L;
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

	public static Object getRequestParameter(String name) {
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

	public HtmlModalPanel getPopupModal() {
		return popupModal;
	}

	public void setPopupModal(HtmlModalPanel popupModal) {
		this.popupModal = popupModal;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public int getSelectRowIndex() {
		return selectRowIndex;
	}

	public void setSelectRowIndex(int selectRowIndex) {
		this.selectRowIndex = selectRowIndex;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrStatusDesc() {
		return urStatusDesc;
	}

	public void setUrStatusDesc(String urStatusDesc) {
		this.urStatusDesc = urStatusDesc;
	}

	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public boolean isSortAscending() {
		return sortAscending;
	}

	public void setSortAscending(boolean sortAscending) {
		this.sortAscending = sortAscending;
	}

	public boolean isCheckAll() {
		return checkAll;
	}

	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	} 
}
