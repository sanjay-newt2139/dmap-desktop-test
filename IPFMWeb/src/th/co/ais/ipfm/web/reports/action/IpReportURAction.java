package th.co.ais.ipfm.web.reports.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPReportService;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.reports.bean.IpReportURDetailBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpReportURAction  extends AbstractAction {
	
		private static Logger log = Logger.getLogger(IpReportURAction.class); 	
		IPReportService service = (IPReportService)JSFServiceFinderUtil.getInstance().getBean("iPReportService");
		public IpReportURDetailBean bean;

		public IpReportURDetailBean getBean() {
			return (IpReportURDetailBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ipReportURDetailBean");
		}

		public void setBean(IpReportURDetailBean bean) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ipReportURDetailBean", bean);
		}

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
		
		public void popupURList()throws Exception{			
			IpReportURDetailBean bean = getBean();
			String reportId = getRequestParameter("reportId");
			String groupSeq = getRequestParameter("groupSeq");
			String groupName = getRequestParameter("groupName");
			String dataLevel = getRequestParameter("dataLevel");
			String userId = getRequestParameter("userId");
			String urType = getRequestParameter("urType");
			String urTab = getRequestParameter("urTab");
			String action = getRequestParameter("action");
			String status = getRequestParameter("status");
			
			log.debug("test popupURList " +reportId+ " "+groupName+" "+urTab);
			

			if(urType!=null && urType.equals("NC")){
				bean.setUrTypeName("Request Network Config");
			}else{
				bean.setUrTypeName("Request IP Config");
			}
			bean.setUrTypeTab(urTab);
			bean.setAction(action);
			bean.setStatus(status);
			bean.setTeamUser(groupName);
			
			List<String> list = new ArrayList<String>();
			
			try {
				if(urType!=null && urType.equals("NC")){
					list = service.getURList(reportId,"NC", groupSeq, dataLevel, userId, urTab, action, status);
				}else{
					list = service.getURList(reportId,"IP", groupSeq, dataLevel, userId, urTab, action, status);
				}
				log.debug("list " +list.size());
				bean.setUrList(list);
				setBean(bean);

			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
		}

}