package th.co.ais.ipfm.web.reports.action;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.web.action.AbstractAction;

public class Report5Action extends AbstractAction  {

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	@Override
	public String init(String programID) {
	
		
	
		return programID;
	}
	
	
	public static String getRequestParameter(String name) {
	    return (String) FacesContext.getCurrentInstance().getExternalContext()
	        .getRequestParameterMap().get(name);
	}
	
	
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
