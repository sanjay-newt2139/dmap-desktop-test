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
	private static final long serialVersionUID = 7548956543524863222L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

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

	public HtmlModalPanel getPopupModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupModal
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupModal
		this.popupModal = popupModal;
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
	public int getFastStepPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage
		return fastStepPage;
	}
	public void setFastStepPage(int fastStepPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage
		this.fastStepPage = fastStepPage;
	}
	public String getUrTypeName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeName
		return urTypeName;
	}
	public void setUrTypeName(String urTypeName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrTypeName
		this.urTypeName = urTypeName;
	}
	public String getUrTypeTab() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeTab
		return urTypeTab;
	}
	public void setUrTypeTab(String urTypeTab) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrTypeTab
		this.urTypeTab = urTypeTab;
	}
	public String getAction() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAction
		return action;
	}
	public void setAction(String action) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAction
		this.action = action;
	}
	public String getStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatus
		return status;
	}
	public void setStatus(String status) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatus
		this.status = status;
	}
	public String getTeamUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamUser
		return teamUser;
	}
	public void setTeamUser(String teamUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamUser
		this.teamUser = teamUser;
	}
	public List<String> getUrList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrList
		return urList;
	}
	public void setUrList(List<String> urList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrList
		this.urList = urList;
	}
	public String getUserName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserName
		return userName;
	}
	public void setUserName(String userName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserName
		this.userName = userName;
	}
	
	
	
	
}
