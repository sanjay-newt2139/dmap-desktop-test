package th.co.ais.ipfm.web.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.util.IPFMDataUtility;

public class UserSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1416678821907119223L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private IpUser ipUser;
	private String loginDateTime; 
	private String newUser = "N";
	private String news = "";
	private int maxReqIP4T2=0;
	private int maxReqIP4T3=0;
	private Map ObjUserMenu;
	private List<IpFunction> menuLevel1List;
	private boolean roleMonitor = false;
	private String notifyProgramId;
	private IpEmailNotify lastEmailNotify;
	private IpUrAction lastUrActionNotify;
	
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
	public void setMaxReqIP4T2(int maxReqIP4T2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxReqIP4T2
		this.maxReqIP4T2 = maxReqIP4T2;
	}
	public void setMaxReqIP4T3(int maxReqIP4T3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxReqIP4T3
		this.maxReqIP4T3 = maxReqIP4T3;
	}
	public Date getPlanningEffectiveDate() {
		Date effectiveDate = new Date();
		try {
			effectiveDate = IPFMDataUtility.convertStringToDateByFormat(loginDateTime, "dd/MM/yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return effectiveDate;
	}
	public Date getPlanningExpireDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPlanningExpireDate
		Date expireDate = new Date();
		try {
			expireDate = IPFMDataUtility.shiftMonthUp(getPlanningEffectiveDate(), maxReqIP4T2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expireDate;
	}
	public Date getUserReqEffectiveDate() {
		Date effectiveDate = new Date();
		try {
			effectiveDate = IPFMDataUtility.convertStringToDateByFormat(loginDateTime, "dd/MM/yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return effectiveDate;
	}
	public Date getUserReqExpireDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserReqExpireDate
		Date expireDate = new Date();
		try {
			expireDate = IPFMDataUtility.shiftMonthUp(getUserReqEffectiveDate(), maxReqIP4T3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expireDate;
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
