package th.co.ais.ipfm.web.manage.action;

import th.co.ais.ipfm.web.action.AbstractAction;

public class WorkflowManageAction  extends AbstractAction {
	
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		
	 return programID;
	}
	
	public String initRequestNetworkConfig() {
		
		
		
	      return "IPURS011_2";
    }
	
	public String initPlanningRequestIp() {
		
		
		
	      return "IPURS011_3";
  }
	
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
