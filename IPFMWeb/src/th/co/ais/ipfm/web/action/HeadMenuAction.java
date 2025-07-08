package th.co.ais.ipfm.web.action;

import org.apache.log4j.Logger;

public class HeadMenuAction extends AbstractAction {
	
	private static final Logger logger = Logger.getLogger(HeadMenuAction.class);
	private String actionName;
	private String programID;
	
	
	public String getProgramID() {
		return programID;
	}


	public void setProgramID(String programID) {
		this.programID = programID;
	}


	public String getActionName() {
		return actionName;
	}


	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String perform(){
		String returnPage = null;
		try {
			if(actionName!=null){
				logger.debug("clear session not use");
				clearSessionNotUsed();
				logger.debug("-------------------" + actionName);
				Object o = Class.forName(actionName.trim()).newInstance();
				System.out.println("init to >> ["+this.programID+"] "+actionName);
				returnPage = ((AbstractAction) o).init(this.programID);
			}else{
				logger.debug("NO Action Name!");
			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
