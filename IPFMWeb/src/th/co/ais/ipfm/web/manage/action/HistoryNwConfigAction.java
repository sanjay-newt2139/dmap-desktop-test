package th.co.ais.ipfm.web.manage.action;

import java.util.List;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.HistoryNwConfigService;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.HistoryNwConfigBean;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;


public class HistoryNwConfigAction  extends AbstractAction {

	public HistoryNwConfigBean historyNwConfigBean;
	public UserSession  userSession;


	public HistoryNwConfigBean getHistoryNwConfigBean() {
		return (HistoryNwConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("historyNwConfigBean");
	}
	public void setHistoryNwConfigBean(HistoryNwConfigBean historyNwConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("historyNwConfigBean", historyNwConfigBean);
	}
	public UserSession getUserSession() {
	  return (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
	}
	public void setUserSession(UserSession userSession) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", userSession);
	}
	
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		historyNwConfigBean = getHistoryNwConfigBean();		
		if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			historyNwConfigBean.setSortHis(sortColumnChange());	
		}  
		return "";
	}
	
	@Override
	public String init(String programID) {
		HistoryNwConfigBean  bean = new HistoryNwConfigBean();
		String urNo = getRequestParameter("urNo");
		HistoryNwConfigService historyNwConfigService = (HistoryNwConfigService)JSFServiceFinderUtil.getInstance().getBean("historyNwConfigService");
		List<IpUrAction> ipUrActionList;
		List<IpUrActionHistory> ipUrActionHistoryList;
		IpUrNwConfig ipUrNwConfig;
		try {
			ipUrActionHistoryList = historyNwConfigService.getHistoryList(urNo);
			ipUrActionList = historyNwConfigService.findIpUrActionList(urNo);
			ipUrNwConfig = historyNwConfigService.findByUrNo(urNo);
			if(ipUrNwConfig!=null){
			  bean.setIpUrNwConfig(ipUrNwConfig);
			}
			bean.setIpUrActionHistoryList(ipUrActionHistoryList);
			bean.setIpUrActionList(ipUrActionList);
			setHistoryNwConfigBean(bean);
		} catch (IPFMBusinessException e) {

			e.printStackTrace();
		}
		
		
		return programID;
	}


	@Override
	public boolean validate() {
		boolean flgValid = true;
		return flgValid;
	}
	
}
