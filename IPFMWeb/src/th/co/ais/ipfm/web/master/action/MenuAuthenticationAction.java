package th.co.ais.ipfm.web.master.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.service.MainMenuService;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.master.bean.MenuAuthenticationBean;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class MenuAuthenticationAction extends AbstractAction{
	/********************** MenuAuthenticationAction ***********************/
	public MenuAuthenticationBean menuAuthenticationBean;
	
	public MenuAuthenticationBean getMenuAuthenticationBean() {
		return (MenuAuthenticationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menuAuthenticationBean");
	}

	public void setMenuAuthenticationBean(MenuAuthenticationBean menuAuthenticationBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("menuAuthenticationBean", menuAuthenticationBean);
	}
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

	@Override
	public String init(String programID) {
		System.out.println("programID > " + programID);
		try{
			MenuAuthenticationBean menuAuthenticationBean = getMenuAuthenticationBean();
			if (menuAuthenticationBean==null) menuAuthenticationBean = new MenuAuthenticationBean(); 
			MainMenuService mainMenuService = (MainMenuService)JSFServiceFinderUtil.getInstance().getBean("mainMenuService");
			List<IpFunction> menuList = mainMenuService.findAllMenu();
			for (IpFunction ipFunction : menuList){
				if (menuAuthenticationBean.getRoleList().size()==4) break;
				if (ipFunction.getMenuLevel().intValue()==0) {
					if (ipFunction.getFuncId().equalsIgnoreCase("F001")) {
						menuAuthenticationBean.getRoleList().add(ipFunction);
					}
				}else{
					if (ipFunction.getFuncMatherId().equalsIgnoreCase("F001")) {
						menuAuthenticationBean.getRoleList().add(ipFunction);
					}
				}
			}
			for (IpFunction ipFunction : menuList){
				if (menuAuthenticationBean.getRoleList().size()==8) break;
				if (ipFunction.getMenuLevel().intValue()==0) {
					if (ipFunction.getFuncId().equalsIgnoreCase("F002")) {
						menuAuthenticationBean.getRoleList().add(ipFunction);
					}
				}else{
					if (ipFunction.getFuncMatherId().equalsIgnoreCase("F001")) {
						menuAuthenticationBean.getRoleList().add(ipFunction);
					}
				}
			}
			menuList = new ArrayList<IpFunction>();
			IpFunction ip = new IpFunction();
			ip.setFuncId("F001");
			ip.setRowId("1");
			ip.setFuncName("User Request");
			ip.setMenuLevel(0);
			ip.setMenuSeq(1);
			ip.setLastUpdBy("Boonyakn");
			ip.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip);
			
			IpFunction ip1 = (IpFunction)ip.clone();
			ip1.setFuncId("F006");
			ip1.setRowId("6");
			ip1.setFuncName("User Request IP");
			ip1.setMenuLevel(1);
			ip1.setMenuSeq(1);
			ip1.setLastUpdBy("Boonyakn");
			ip1.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip1);
			
			IpFunction ip3 = (IpFunction)ip.clone();
			ip3.setFuncId("F006");
			ip3.setRowId("6");
			ip3.setFuncName("Planning Request IP");
			ip3.setMenuLevel(1);
			ip3.setMenuSeq(2);
			ip3.setLastUpdBy("Boonyakn");
			ip3.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip3);
			
			IpFunction ip4 = (IpFunction)ip.clone();
			ip4.setFuncId("F006");
			ip4.setRowId("6");
			ip4.setFuncName("Request Network Config");
			ip4.setMenuLevel(1);
			ip4.setMenuSeq(3);
			ip4.setLastUpdBy("Boonyakn");
			ip4.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip4);
			
			IpFunction ip5 = (IpFunction)ip.clone();
			ip5.setFuncId("F006");
			ip5.setRowId("6");
			ip5.setFuncName("Search");
			ip5.setMenuLevel(0);
			ip5.setMenuSeq(2);
			ip5.setLastUpdBy("Boonyakn");
			ip5.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip5);
			
			IpFunction ip6 = (IpFunction)ip.clone();
			ip6.setFuncId("F006");
			ip6.setRowId("6");
			ip6.setFuncName("Search UR");
			ip6.setMenuLevel(1);
			ip6.setMenuSeq(1);
			ip6.setLastUpdBy("Boonyakn");
			ip6.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip6);
			
			IpFunction ip7 = (IpFunction)ip.clone();
			ip7.setFuncId("F006");
			ip7.setRowId("6");
			ip7.setFuncName("Search IP");
			ip7.setMenuLevel(1);
			ip7.setMenuSeq(2);
			ip7.setLastUpdBy("Boonyakn");
			ip7.setLastUpd(new Date("08/08/2010"));
			menuList.add(ip7);
			
			menuAuthenticationBean.setMenuList(menuList);
			menuAuthenticationBean.getIpFucntion().setMenuLevel(0);
			setMenuAuthenticationBean(menuAuthenticationBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return programID;
	}
	
	public String action_addMenu(){
		MenuAuthenticationBean menuAuthenticationBean = getMenuAuthenticationBean();
			
		setMenuAuthenticationBean(menuAuthenticationBean);
		return null;
	}
	
	public String action_selectRow(){
		MenuAuthenticationBean menuAuthenticationBean = getMenuAuthenticationBean();
		MainMenuService mainMenuService = (MainMenuService)JSFServiceFinderUtil.getInstance().getBean("mainMenuService");
		try {
			int rowId = Integer.parseInt(getRequestParameter("rowId"));
			IpFunction ipFunction = mainMenuService.findMenuByRowId(rowId);
			System.out.println("ipFunction rowId = " + ipFunction.getRowId() + " :: "+ ipFunction.getFuncName());
			menuAuthenticationBean.setIpFucntion((IpFunction)ipFunction.clone());
			
			setMenuAuthenticationBean(menuAuthenticationBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String action_cancel(){
		MenuAuthenticationBean menuAuthenticationBean = getMenuAuthenticationBean();
		init(null);
		setMenuAuthenticationBean(menuAuthenticationBean);
		return null;
	}
	
	public void action_onchangeMenuLevel(){
		MenuAuthenticationBean menuAuthenticationBean = getMenuAuthenticationBean();
		System.out.println("---- menu level = "+menuAuthenticationBean.getIpFucntion().getMenuLevel());
		setMenuAuthenticationBean(menuAuthenticationBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
