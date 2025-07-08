package th.co.ais.ipfm.web.master.action;

import th.co.ais.ipfm.web.action.AbstractAction;

public class WorkFlowManageAction extends AbstractAction {

	@Override
	public String init() {
		// TODO Auto-generated method stub
		return "workflow_management";
	}
	
	@Override
	public String init(String programID) {
		return null;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
