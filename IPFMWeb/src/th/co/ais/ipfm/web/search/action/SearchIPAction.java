package th.co.ais.ipfm.web.search.action;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.SearchIPService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.search.bean.SearchIPBean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class SearchIPAction  extends AbstractAction {
	
	public SearchIPBean searchIPBean;
	public UserSession  userSession;
	
	
	public SearchIPBean getSearchIPBean() {
		 return (SearchIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("searchIPBean");
	}
	public void setSearchIPBean(SearchIPBean searchIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("searchIPBean", searchIPBean);
	}
	public UserSession getUserSession() {
		  return (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
		}
	public void setUserSession(UserSession userSession) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", userSession);
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		searchIPBean = getSearchIPBean();
		if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			searchIPBean.setSortIP002(sortColumnChange());	
		} 
		return "";
	}
	
	@Override
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		SearchIPService searchIPService = (SearchIPService)JSFServiceFinderUtil.getInstance().getBean("searchIPService");
		UserSession userSessionBean = getUserSession();
		SearchIPBean bean = new SearchIPBean();
		try{
			bean.setSearchFlag(false);

			String  v_UserPermission  = searchIPService.getV_UserPermission(userSessionBean.getIpUser().getUserId());
			List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
			if (v_UserPermission!=null && v_UserPermission.equalsIgnoreCase("T2")){
				v_UserPermission  = userSessionBean.getIpUser().getTeamId();
			}
			bean.getIpInfo().setUserPermission(v_UserPermission);
		    bean.setLocationList(locatStringList);

			setSearchIPBean(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return programID;
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get(name);
    }
	
	public void search(){
		SearchIPService searchIPService = (SearchIPService)JSFServiceFinderUtil.getInstance().getBean("searchIPService");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		UserSession userSessionBean = getUserSession();
		SearchIPBean bean = getSearchIPBean();
		SearchResult searchResult = null;
		bean.getIpInfo().setV_bin_start("ALL");
		try {
			//if(validate()){
				String  stIp1= bean.getIpInfo().getStIp1();
				String  stIp2= bean.getIpInfo().getStIp2();
				String  stIp3= bean.getIpInfo().getStIp3();
				String  stIp4= bean.getIpInfo().getStIp4();
				String  mask= bean.getIpInfo().getSubmask();
				
				 if(bean.getLocationComboItem()!=null){
					 bean.getIpInfo().setLocationId(bean.getLocationComboItem().getValue());
				 }

				IpUrIpResult  result  =  searchIPService.checkIPRange(stIp1,stIp2,stIp3,stIp4,mask);
				if(result==null){
					bean.getIpInfo().setBinaryIpStart("ALL");
				}else{
					bean.getIpInfo().setBinaryIpStart(result.getBinary1Start());
					bean.getIpInfo().setBinaryIpEnd(result.getBinary1End());
				}

				Integer totalRec = searchIPService.getSeachIPTotalRec(bean.getIpInfo(), userSessionBean.getIpUser());				
				if (totalRec.intValue()>1024) {
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage("Network IP " + ErrorMessageUtil.getMessage("ER0074"),String.valueOf("1024")));
				}
				searchResult = searchIPService.searchIP(bean.getIpInfo(), userSessionBean.getIpUser());
				bean.setSearchList(searchResult.getResultList());
				
				setSearchIPBean(bean);
		//	}
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public void popupIPInfo(){
		SearchIPService searchURService = (SearchIPService)JSFServiceFinderUtil.getInstance().getBean("searchIPService");
		SearchIPBean bean = getSearchIPBean();
		String ipAddress = getRequestParameter("ipAddress");
		try {
			
			IpInfo ipInfo = searchURService.getIpInfo(ipAddress);
			if (ipInfo != null) {
				if (ipInfo.getT2Team()==null) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0097"), ipAddress, ipInfo.getT2TeamId()));
				}
				if (ipInfo.getSystemOwnerId()==null) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0096"), ipAddress, ipInfo.getSystemOwner()));
				}
			}
			if (IPFMMessageUtils.hasMessages()) return;
//			bean.setIpInfo(ipInfo);
			bean.setIpInfoPopup(ipInfo);
			setSearchIPBean(bean);
			
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}
	}
	
	public void  reset() throws Exception {
		SearchIPBean bean = getSearchIPBean();
		bean.setSearchList(null);
		init();
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		SearchIPBean bean = getSearchIPBean();
		if (IPFMUtils.ifBlank(bean.getIpInfo().getStIp1(), "").trim().length()==0 
				|| IPFMUtils.ifBlank(bean.getIpInfo().getStIp2(), "").trim().length()==0 
				|| IPFMUtils.ifBlank(bean.getIpInfo().getStIp3(), "").trim().length()==0
				|| IPFMUtils.ifBlank(bean.getIpInfo().getStIp4(), "").trim().length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		 }

		return flgValid;

	}
	
}
