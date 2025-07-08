package th.co.ais.ipfm.web.manage.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import th.co.ais.ipfm.domain.TempTable;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.manage.bean.WFUserBean;

public class WFUserAction  extends AbstractAction {
	
	public WFUserBean wfUserBean;

	public WFUserBean getWfUserBean() {
		return (WFUserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("wfUserBean");
	}

	public void setWfUserBean(WFUserBean wfUserBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("wfUserBean", wfUserBean);
	}

	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	@Override
	public String init(String programID) {
	//public String init() {
		try{
			ReqNWConfigBean reqNetworkBean = new ReqNWConfigBean();
			System.out.println("Class >> "+getClass().getName()+" goto "+programID);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return programID;
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void showUser(ActionEvent event){
		WFUserBean bean = getWfUserBean();
		List<TempTable> temp = new ArrayList<TempTable>();
		temp.add(new TempTable("1","Boongkiat Ngouvisikul","DP-CSS","","Engineer Specialist"));
		temp.add(new TempTable("2","Atrat Mardar","DP-MRK","","IS"));
		temp.add(new TempTable("3","Suksan Maheysak","DP-CSR","","IS"));
		bean.setTempTable(temp);
		
		String header = getRequestParameter("header");
		bean.setRoleName(header);
		setWfUserBean(bean);
	}
	
	


}
