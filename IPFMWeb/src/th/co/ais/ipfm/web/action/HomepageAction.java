package th.co.ais.ipfm.web.action;

import th.co.ais.ipfm.web.master.action.TeamManageAction;
import th.co.ais.ipfm.web.util.IPFMWebUtil;


public class HomepageAction extends AbstractAction {
	
	public String gotoHomepage(){
		//System.out.println("------- gotoHomepage ------");
		String returnPage = (String)IPFMWebUtil.getObjFromSession("fromPage");
		if (returnPage==null || returnPage.trim().length()==0) returnPage = "homePage";
		return returnPage;
	}

	public String gotoInitTeamManageAction(){
		String returnPage = (String)IPFMWebUtil.getObjFromSession("fromPage");
		if (returnPage==null || returnPage.trim().length()==0) returnPage = "homePage";
		TeamManageAction teamManageAction= new TeamManageAction();
		teamManageAction.init();
		return returnPage;
	}
	
	public String gotoHomeSearchURAction(){
		IPFMWebUtil.storeOnSession("fromPage", null);
		String returnPage = (String)IPFMWebUtil.getObjFromSession("fromPage");
		if (returnPage==null || returnPage.trim().length()==0) returnPage = "homePage";
		return returnPage;
	}
	
	@Override
	public String init() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String init(String programID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
}
