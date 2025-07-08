package th.co.ais.ipfm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUser;

public class UserVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1416678821907119223L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private IpUser ipUser;
	private String loginDateTime; 
	private String newUser = "N";
	private String news = "";
	private Integer onlineUser=0;
	private Integer webCounter=0;
	private boolean roleMonitor = false;
	private IpEmailNotify lastEmailNotify;
	private IpUrAction lastUrActionNotify;
	private String notifyProgramId;
	private List<IpFunction> menuLevel1List;
	private Map ObjUserMenu;
	
	public IpUser getIpUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUser
		return ipUser;
	}
	public void setIpUser(IpUser ipUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUser
		this.ipUser = ipUser;
	}
	public String getLoginDateTime() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLoginDateTime
		return loginDateTime;
	}
	public void setLoginDateTime(String loginDateTime) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLoginDateTime
		this.loginDateTime = loginDateTime;
	}
	public Map getObjUserMenu() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getObjUserMenu
		return ObjUserMenu;
	}
	public void setObjUserMenu(Map objUserMenu) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setObjUserMenu
		ObjUserMenu = objUserMenu;
	}
	public String getNewUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNewUser
		return newUser;
	}
	public void setNewUser(String newUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNewUser
		this.newUser = newUser;
	}
	public String getNews() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNews
		return news;
	}
	public void setNews(String news) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNews
		this.news = news;
	}
	public Integer getOnlineUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOnlineUser
		return onlineUser;
	}
	public void setOnlineUser(Integer onlineUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOnlineUser
		this.onlineUser = onlineUser;
	}
	public Integer getWebCounter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWebCounter
		return webCounter;
	}
	public void setWebCounter(Integer webCounter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWebCounter
		this.webCounter = webCounter;
	}
	public boolean isRoleMonitor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isRoleMonitor
		return roleMonitor;
	}
	public void setRoleMonitor(boolean roleMonitor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleMonitor
		this.roleMonitor = roleMonitor;
	}
	public IpEmailNotify getLastEmailNotify() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastEmailNotify
		return lastEmailNotify;
	}
	public void setLastEmailNotify(IpEmailNotify lastEmailNotify) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastEmailNotify
		this.lastEmailNotify = lastEmailNotify;
	}
	public IpUrAction getLastUrActionNotify() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUrActionNotify
		return lastUrActionNotify;
	}
	public void setLastUrActionNotify(IpUrAction lastUrActionNotify) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUrActionNotify
		this.lastUrActionNotify = lastUrActionNotify;
	}
	public String getNotifyProgramId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNotifyProgramId
		return notifyProgramId;
	}
	public void setNotifyProgramId(String notifyProgramId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNotifyProgramId
		this.notifyProgramId = notifyProgramId;
	}
	public List<IpFunction> getMenuLevel1List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMenuLevel1List
		return menuLevel1List;
	}
	public void setMenuLevel1List(List<IpFunction> menuLevel1List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMenuLevel1List
		this.menuLevel1List = menuLevel1List;
	}
}
