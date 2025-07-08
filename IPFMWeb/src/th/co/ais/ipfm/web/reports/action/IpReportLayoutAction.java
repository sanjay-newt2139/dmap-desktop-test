package th.co.ais.ipfm.web.reports.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.domain1.Iprur001Result1;
import th.co.ais.ipfm.domain1.Iprur001Result2;
import th.co.ais.ipfm.domain1.Iprur001Result4;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPReportService;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.reports.bean.IpReportDetailBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpReportLayoutAction  extends AbstractAction {
	
		private static Logger log = Logger.getLogger(IpReportLayoutAction.class); 	
		IPReportService service = (IPReportService)JSFServiceFinderUtil.getInstance().getBean("iPReportService");
		public IpReportDetailBean bean;

		public IpReportDetailBean getBean() {
			return (IpReportDetailBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ipReportDetailBean");
		}
		public void setBean(IpReportDetailBean bean) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ipReportDetailBean", bean);
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
		
		public void popupLayoutInfo()throws Exception{
			IpReportDetailBean bean = getBean();
			String reportId = getRequestParameter("reportId");
			List<Iprur001Result1> result1 = new ArrayList<Iprur001Result1>();
			List<Iprur001Result4> result4 = new ArrayList<Iprur001Result4>();
			
			// total Ur
			List<Iprur001Result2> result2 = new ArrayList<Iprur001Result2>();
			List<Iprur001Result2> result5 = new ArrayList<Iprur001Result2>();
						
			log.debug(" PopupLayoutInfo : reportId = "+reportId);
			try {
				IpReportList ipReportList = (IpReportList)service.getReportCritierByReportId(reportId);
				result1 = service.getIprur001Result1(reportId);
				result4 = service.getIprur001Result4(reportId);
				result2 = service.getTotalURRequest(reportId,"NC");
				result5 = service.getTotalURRequest(reportId,"IP");
				bean.setIpReportList(ipReportList);
				bean.setResult1List(result1);
				bean.setResult4List(result4);
				bean.setResult2List(result2);
				bean.setResult5List(result5);
				setBean(bean);

			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
		}
}