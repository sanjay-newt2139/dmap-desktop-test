package th.co.ais.ipfm.web.reports.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
//import org.jacorb.notification.util.LogUtil;

import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpDelegateUserId;
import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPReportService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.master.bean.MasterTableBean;
import th.co.ais.ipfm.web.master.bean.UserProfileBean;
import th.co.ais.ipfm.web.reports.bean.IpReportListBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IpReportCriteriaAction  extends AbstractAction {
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
			return init(getRequestParameter("programIDParam"));
		}
		
		@Override
		public String init(String programID) {
			System.out.println("---------- init IpReportCriteriaAction");
			IpReportListBean bean = null;
			List<IpReportList> result = new ArrayList<IpReportList>();
			try{
				result = getIpReportCritier();
				bean = new IpReportListBean();
				if(result.size()>0){
					bean.setIpReportList(result);
				}else{
					bean.setIpReportList(new ArrayList<IpReportList>());
				}
			}catch (Exception e) {
				// TODO: handle exception
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
			return programID;
		}
		
		public List<IpReportList> getIpReportCritier() throws Exception{
			List<IpReportList> result = new ArrayList<IpReportList>();
			IpReportListBean bean = new IpReportListBean();
			try{
				result =  service.getIpReportCritier();
				bean.setIpReportList(result);
				setIpReportListBean(bean);
			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
			return result;
		}		
		
		public static String getRequestParameter(String name) {
		    return (String) FacesContext.getCurrentInstance().getExternalContext()
		        .getRequestParameterMap().get(name);
		}
		
		@Override
		public boolean validate() {
			// TODO Auto-generated method stub
	    	boolean flgValid = true;
			IpReportListBean bean = getIpReportListBean();

			log.debug("Validate ");
			if(bean.getStartDate().compareTo(bean.getEndDate()) >0 ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
				flgValid = false;
			}
			return flgValid;
		}
		
		public String AddReport() throws Exception{
			IpReportListBean bean = getIpReportListBean();
			IpReportList ipReportList = new IpReportList();						
			if(bean!=null){			
				try {
					log.info("start : "+bean.getStartDate() +" end : "+ bean.getEndDate());
					if(bean.getStartDate() != null && bean.getEndDate()!= null){
						if(validate()){
							if(bean.getStartDate() != null){
								ipReportList.setStartDate(bean.getStartDate());
							}
							if(bean.getEndDate()!=null){
								ipReportList.setEndDate(bean.getEndDate());
							}
							ipReportList.setReportStatus(IPFMConstant.REPORT_WAITING);
							ipReportList.setUserId(IPFMWebUtil.getUserId());						
							List<IpReportList> result =  service.addReportCriteria(ipReportList);
							bean.setIpReportList(result);
							bean.setStartDate(null);
							bean.setEndDate(null);
							IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
						}	
					}else{
						if(bean.getStartDate() == null){
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Request Date From"));
						}
						if(bean.getEndDate() == null){
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Request Date To"));
						}
					}					
				} catch (IPFMBusinessException e) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
				}
				setIpReportListBean(bean);
			}	
			return "IPRUR001";		
		}
		
		public String delete() throws Exception{
			IpReportListBean bean = getIpReportListBean();
			try{
//				String reportId = getRequestParameter("reportId");
				List<IpReportList> result =  service.deleteReportCriteria(bean.getReportId());
				bean.setIpReportList(result);
				setIpReportListBean(bean);
			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
			}
			return "IPRUR001";
		}	
		
		public void updateValueBeforeDelete(){
			String reportId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("reportId").toString();
			IpReportListBean bean = getIpReportListBean();
			bean.setReportId(reportId);
			setIpReportListBean(bean);
		}

}