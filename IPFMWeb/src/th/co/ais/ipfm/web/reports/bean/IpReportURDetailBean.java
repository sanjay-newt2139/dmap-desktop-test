package th.co.ais.ipfm.web.reports.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain1.Iprur001Result1Detail;

public final class IpReportURDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7548956543524863222L;

	private int rowPerPage;
	private int maxPage;
	private int maxSearchResult;
	private int fastStepPage;
	private String urTypeName;
	private String urTypeTab;
	private String action;
	private String status;
	private String teamUser;
	private String userName;
	private List<String> urList;
	

	private HtmlModalPanel popupModal;

	public HtmlModalPanel getPopupModal() {
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) {
		this.popupModal = popupModal;
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
	public int getFastStepPage() {
		return fastStepPage;
	}
	public void setFastStepPage(int fastStepPage) {
		this.fastStepPage = fastStepPage;
	}
	public String getUrTypeName() {
		return urTypeName;
	}
	public void setUrTypeName(String urTypeName) {
		this.urTypeName = urTypeName;
	}
	public String getUrTypeTab() {
		return urTypeTab;
	}
	public void setUrTypeTab(String urTypeTab) {
		this.urTypeTab = urTypeTab;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTeamUser() {
		return teamUser;
	}
	public void setTeamUser(String teamUser) {
		this.teamUser = teamUser;
	}
	public List<String> getUrList() {
		return urList;
	}
	public void setUrList(List<String> urList) {
		this.urList = urList;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
