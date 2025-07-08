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
	private static final long serialVersionUID = 1416678821907119223L;
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
	public void setMaxReqIP4T2(int maxReqIP4T2) {
		this.maxReqIP4T2 = maxReqIP4T2;
	}
	public void setMaxReqIP4T3(int maxReqIP4T3) {
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
	public Date getPlanningExpireDate() {
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
	public Date getUserReqExpireDate() {
		Date expireDate = new Date();
		try {
			expireDate = IPFMDataUtility.shiftMonthUp(getUserReqEffectiveDate(), maxReqIP4T3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expireDate;
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
