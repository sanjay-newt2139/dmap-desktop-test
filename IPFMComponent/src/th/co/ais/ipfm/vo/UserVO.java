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
	private static final long serialVersionUID = 1416678821907119223L;
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
	
	public IpUser getIpUser() {
		return ipUser;
	}
	public void setIpUser(IpUser ipUser) {
		this.ipUser = ipUser;
	}
	public String getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	public Map getObjUserMenu() {
		return ObjUserMenu;
	}
	public void setObjUserMenu(Map objUserMenu) {
		ObjUserMenu = objUserMenu;
	}
	public String getNewUser() {
		return newUser;
	}
	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public Integer getOnlineUser() {
		return onlineUser;
	}
	public void setOnlineUser(Integer onlineUser) {
		this.onlineUser = onlineUser;
	}
	public Integer getWebCounter() {
		return webCounter;
	}
	public void setWebCounter(Integer webCounter) {
		this.webCounter = webCounter;
	}
	public boolean isRoleMonitor() {
		return roleMonitor;
	}
	public void setRoleMonitor(boolean roleMonitor) {
		this.roleMonitor = roleMonitor;
	}
	public IpEmailNotify getLastEmailNotify() {
		return lastEmailNotify;
	}
	public void setLastEmailNotify(IpEmailNotify lastEmailNotify) {
		this.lastEmailNotify = lastEmailNotify;
	}
	public IpUrAction getLastUrActionNotify() {
		return lastUrActionNotify;
	}
	public void setLastUrActionNotify(IpUrAction lastUrActionNotify) {
		this.lastUrActionNotify = lastUrActionNotify;
	}
	public String getNotifyProgramId() {
		return notifyProgramId;
	}
	public void setNotifyProgramId(String notifyProgramId) {
		this.notifyProgramId = notifyProgramId;
	}
	public List<IpFunction> getMenuLevel1List() {
		return menuLevel1List;
	}
	public void setMenuLevel1List(List<IpFunction> menuLevel1List) {
		this.menuLevel1List = menuLevel1List;
	}
}
