package th.co.ais.ipfm.web.reports.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPReportService;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.reports.bean.IpReportDetailBean;
import th.co.ais.ipfm.web.reports.bean.IpReportListBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpReportListAction  extends AbstractAction {
		private static Logger log = Logger.getLogger(IpReportCriteriaAction.class); 	
		IPReportService service = (IPReportService)JSFServiceFinderUtil.getInstance().getBean("iPReportService");
		
		IpReportListBean ipReportListBean;
		public IpReportListBean getIpReportListBean() {
			return (IpReportListBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ipReportListBean");
		}
		public void setIpReportListBean(IpReportListBean ipReportListBean) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ipReportListBean", ipReportListBean);
		}
		
		public String init() {
			return init(getRequestParameter("programID"));
		}
		
		@Override
		public String init(String programID) {		
			System.out.println("---------- init IpReportListAction");
			IpReportListBean bean = new IpReportListBean();
			List<IpReportList> result = new ArrayList<IpReportList>();
			try{
				result =getIpReportList();
				if(result.size()>0){
					bean.setIpReportList(result);
				}else{
					bean.setIpReportList(new ArrayList<IpReportList>());
				}
				setIpReportListBean(bean);
			}catch (Exception e) {
				// TODO: handle exception
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
			return programID;	

		}
		
		public List<IpReportList> getIpReportList() throws Exception{
			List<IpReportList> result = new ArrayList<IpReportList>();
			IpReportListBean bean = new IpReportListBean();
			try{
				result =  service.getIpReportList();
				if(result.size()>0){
					bean.setIpReportList(result);
				}else{
					bean.setIpReportList(new ArrayList<IpReportList>());
				}
				setIpReportListBean(bean);
			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
			return result;
		}
		
		
		public static String getRequestParameter(String name) {
		    return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
		}
		
		
		@Override
		public boolean validate() {
			// TODO Auto-generated method stub
			return false;
		}


}