package th.co.ais.ipfm.web.action;

import th.co.ais.ipfm.web.master.action.TeamManageAction;
import th.co.ais.ipfm.web.util.IPFMWebUtil;


public class HomepageAction extends AbstractAction {
	
	public String gotoHomepage(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference gotoHomepage
		//System.out.println("------- gotoHomepage ------");
		String returnPage = (String)IPFMWebUtil.getObjFromSession("fromPage");
		if (returnPage==null || returnPage.trim().length()==0) returnPage = "homePage";
		return returnPage;
	}

	public String gotoInitTeamManageAction(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference gotoInitTeamManageAction
		String returnPage = (String)IPFMWebUtil.getObjFromSession("fromPage");
		if (returnPage==null || returnPage.trim().length()==0) returnPage = "homePage";
		TeamManageAction teamManageAction= new TeamManageAction();
		teamManageAction.init();
		return returnPage;
	}
	
	public String gotoHomeSearchURAction(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference gotoHomeSearchURAction
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
	public boolean validate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference validate
		// TODO Auto-generated method stub
		return false;
	}
}
