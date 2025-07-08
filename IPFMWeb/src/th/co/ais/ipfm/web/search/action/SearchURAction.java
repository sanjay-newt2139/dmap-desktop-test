package th.co.ais.ipfm.web.search.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.IpUrStatus;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.InboxService;
import th.co.ais.ipfm.service.SearchURService;
import th.co.ais.ipfm.service.UserReqIPService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.util.StringHelper;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.search.bean.SearchURBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class SearchURAction  extends AbstractAction{
	
	private Logger logger = Logger.getLogger(SearchURAction.class);

	public SearchURBean searchURBean;
	public UserSession  userSession;
	
	public SearchURBean getSearchURDataBean() {
		return (SearchURBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("searchURBean");
	}

	public void setSearchURDataBean(SearchURBean searchURBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("searchURBean", searchURBean);
	}
	public UserSession getUserSession() {
		  return (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
		}
	public void setUserSession(UserSession userSession) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", userSession);
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		searchURBean = getSearchURDataBean();
		if(TablSort.equalsIgnoreCase("searchURTable")) {
			searchURBean.setSortIP007(sortColumnChange());	
		} 
		return "";
	}
		
	@Override
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		SearchURService searchURService = (SearchURService)JSFServiceFinderUtil.getInstance().getBean("searchURService");
		UserSession userSessionBean = getUserSession();
		SearchURBean bean = new SearchURBean();
		List<SelectItem> urStatusList = new ArrayList<SelectItem>();
		IPFMRichComboItem requesterCombo = new IPFMRichComboItem();
		List<SelectItem> urTypeList = new ArrayList<SelectItem>();
		List<SelectItem> requesterList = new ArrayList<SelectItem>();
		IPFMRichComboItem cbitem = null;
		String urTypeCode="";
		bean.getIpUrIpDetail().setOverSla("1");
		try {
			    IPFMRichComboItem cbitem1 = new IPFMRichComboItem();
				cbitem1.setLabel("Request Network Config");
				cbitem1.setValue("F030");
				urTypeList.add(new SelectItem(cbitem1, cbitem1.getLabel()));
				IPFMRichComboItem cbitem2 = new IPFMRichComboItem();
				cbitem2.setLabel("Planning Request IP");
				cbitem2.setValue("F029");
				urTypeList.add(new SelectItem(cbitem2, cbitem2.getLabel()));
				IPFMRichComboItem cbitem3 = new IPFMRichComboItem();
				cbitem3.setLabel("User Request IP");
				cbitem3.setValue("F027");
				urTypeList.add(new SelectItem(cbitem3, cbitem3.getLabel()));
				
				List<IpUrStatus> urStatusComboStringList = searchURService.getUrStatusList(urTypeCode);
//				List<IpUrStatus> urStatusComboStringList = searchURService.getSubUrStatusList(urTypeCode);
				if(urStatusComboStringList!=null && urStatusComboStringList.size()>0){
					for (IpUrStatus str:urStatusComboStringList) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getUrStatusName());
						cbitem.setValue(str.getUrStatusId());
						urStatusList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
//				if(urStatusComboStringList!=null && urStatusComboStringList.size()>0){
//						boolean verifyFlag = true;
//						for (IpUrStatus str:urStatusComboStringList) {
////							System.out.println(" str.getUrStatusId() = "+str.getUrStatusId()+"  str.getUrStatusName() = "+str.getUrStatusName());
////							if (str.getUrStatusId().equalsIgnoreCase("APPROVE_MRG")) continue;
//							cbitem = new IPFMRichComboItem();
//							cbitem.setLabel(str.getUrStatusName());							
//							if (cbitem.getLabel().equalsIgnoreCase("User Verify")) {
//								for (SelectItem item : urStatusList) {
//									if (cbitem.getLabel().equalsIgnoreCase(((IPFMRichComboItem)(item.getValue())).getValue())){ 
//										verifyFlag = false;
//										break;
//									}
//								}
//								if (!verifyFlag) break;
//								cbitem.setValue(str.getUrStatusName());
//							}else{
//								cbitem.setValue(str.getUrStatusId());
//							}
//							urStatusList.add(new SelectItem(cbitem, cbitem.getLabel()));
//						}
//				}
				
				List<IpUser> requesterStringList = searchURService.getSystemOwnerList();
				if(requesterStringList!=null && requesterStringList.size()>0){
						for (IpUser str:requesterStringList) {
							cbitem = new IPFMRichComboItem();
							cbitem.setLabel(str.getUserName());
							cbitem.setValue(str.getUserId());
							requesterList.add(new SelectItem(cbitem, cbitem.getLabel()));
						}
				}
				
				String  v_ViewUR  = searchURService.getViewUR (userSessionBean.getIpUser().getUserId());
				bean.getIpUrIpDetail().setV_view(v_ViewUR);
    			bean.setUrTypeList(urTypeList);
				bean.setUrStatusList(urStatusList);
				bean.setRequesterList(requesterList);
				
				setSearchURDataBean(bean);
			
		} catch (IPFMBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return programID;
	}

	public void changeUrStatusList(){
		SearchURService searchURService = (SearchURService)JSFServiceFinderUtil.getInstance().getBean("searchURService");
		SearchURBean bean = getSearchURDataBean();
		List<SelectItem> urStatusList = new ArrayList<SelectItem>();
		IPFMRichComboItem cbitem = null;
        String urTypeCode="";
		try {
			    if("F030".equals(bean.getUrTypeComboItem().getValue())){
			    	urTypeCode="NC";
			    }else if("F029".equals(bean.getUrTypeComboItem().getValue())){
			    	urTypeCode="IP12";
			    }else if("F027".equals(bean.getUrTypeComboItem().getValue())){
			    	urTypeCode="IP23";
			    }
//				List<IpUrStatus> urStatusComboStringList = searchURService.getSubUrStatusList(urTypeCode);
			    List<IpUrStatus> urStatusComboStringList = searchURService.getUrStatusList(urTypeCode);
				if(urStatusComboStringList!=null && urStatusComboStringList.size()>0){
						for (IpUrStatus str:urStatusComboStringList) {
							cbitem = new IPFMRichComboItem();
							cbitem.setLabel(str.getUrStatusName());
							cbitem.setValue(str.getUrStatusId());
							urStatusList.add(new SelectItem(cbitem, cbitem.getLabel()));
						}
				}
								
//				if(urStatusComboStringList!=null && urStatusComboStringList.size()>0){
//					boolean verifyFlag = true;
//					for (IpUrStatus str:urStatusComboStringList) {
//						if (str.getUrStatusId().equalsIgnoreCase("APPROVE_MRG")) continue;
//						cbitem = new IPFMRichComboItem();
//						cbitem.setLabel(str.getUrStatusName());							
//						if (cbitem.getLabel().equalsIgnoreCase("User Verify")) {
//							for (SelectItem item : urStatusList) {
//								if (cbitem.getLabel().equalsIgnoreCase(((IPFMRichComboItem)(item.getValue())).getValue())){ 
//									verifyFlag = false;
//									break;
//								}
//							}
//							if (!verifyFlag) break;
//							cbitem.setValue(str.getUrStatusName());
//						}else{
//							cbitem.setValue(str.getUrStatusId());
//						}
//						urStatusList.add(new SelectItem(cbitem, cbitem.getLabel()));
//					}
//				}
				bean.setUrStatusList(urStatusList);
				setSearchURDataBean(bean);
		
		} catch (IPFMBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
   public void search(){
		SearchURService searchURService = (SearchURService)JSFServiceFinderUtil.getInstance().getBean("searchURService");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		SearchURBean bean = getSearchURDataBean();
		String subUrPack="";
		UserSession userSessionBean = getUserSession();
		List<IpUrIpDetail> ipUrIpDetailList = new ArrayList<IpUrIpDetail>();
			SearchResult searchResult = null;		
			try {
			if(validate()){
					 if(bean.getUrTypeComboItem()!=null && IPFMUtils.ifBlank(bean.getUrTypeComboItem().getLabel(), "").length()>0){
					    if("F030".equals(bean.getUrTypeComboItem().getValue())){
					    	bean.getIpUrIpDetail().setUrType("NC");
					    }else if("F029".equals(bean.getUrTypeComboItem().getValue())){
					    	bean.getIpUrIpDetail().setUrType("IP12");
					    }else if("F027".equals(bean.getUrTypeComboItem().getValue())){
					    	bean.getIpUrIpDetail().setUrType("IP23");
					    }
					 }else{
						 bean.getIpUrIpDetail().setUrType("");
					 }
					 if(bean.getUrStatusComboItem()!=null && IPFMUtils.ifBlank(bean.getUrStatusComboItem().getLabel(), "").length()>0){
						 bean.getIpUrIpDetail().setUrStatusName(bean.getUrStatusComboItem().getLabel());
					 	 bean.getIpUrIpDetail().setUrStatus((bean.getUrStatusComboItem().getValue()));
					 }else{
						 bean.getIpUrIpDetail().setUrStatus("");
					 }
					 if(bean.getRequesterComboItem()!=null && IPFMUtils.ifBlank(bean.getRequesterComboItem().getLabel(), "").length()>0){
					 	 bean.getIpUrIpDetail().setReqName((bean.getRequesterComboItem().getValue()));
					 }else{
						 bean.getIpUrIpDetail().setReqName("");
					 }

					  if(bean.getFirewallCheck()==true)
					       subUrPack += "FW-";
					      if(bean.getAccessListCheck()==true)
					       subUrPack += "AL-";
					      if(bean.getAccessTNPCheck()==true)
					       subUrPack += "AT-";
					      if(bean.getPhysicalCheck()==true)
					       subUrPack += "PI-";
					      if(bean.getGatewayCheck()==true)
					       subUrPack += "IG-";
					      if(bean.getRoutingCheck()==true)
					       subUrPack += "RT-";
					      if(bean.getF5Check()==true)
					       subUrPack += "F5-";
					      
	
					      
					      if(subUrPack.length()!=0)
					      subUrPack = subUrPack.substring(0, subUrPack.length()-1);
					      
					      if(bean.getIpInfo() != null 
					    		  && StringHelper.notEmptyString(bean.getIpInfo().getStIp1())  
					    		  && StringHelper.notEmptyString(bean.getIpInfo().getStIp2())  
					    		  && StringHelper.notEmptyString(bean.getIpInfo().getStIp3())  
					    		  && StringHelper.notEmptyString(bean.getIpInfo().getStIp4())  
					    		  && StringHelper.notEmptyString(bean.getIpInfo().getStIp4To())){
					    	  String prefix = bean.getIpInfo().getStIp1()+"."+ bean.getIpInfo().getStIp2() + "."+ bean.getIpInfo().getStIp3()+".";
					    	  String ipList = convertListIp(prefix, bean.getIpInfo().getStIp4(), bean.getIpInfo().getStIp4To());
					    	  bean.getIpUrIpDetail().setIpCriteria(ipList);
					    	  bean.getIpUrIpDetail().setSingleIpCriteria("");
					      }else if((bean.getIpInfo() != null)
					    		  && ((StringHelper.notEmptyString(bean.getIpInfo().getStIp1())
					    		  || StringHelper.notEmptyString(bean.getIpInfo().getStIp2())
					    		  || StringHelper.notEmptyString(bean.getIpInfo().getStIp3()) 
					    		  || StringHelper.notEmptyString(bean.getIpInfo().getStIp4())))
					    		  && !(StringHelper.notEmptyString(bean.getIpInfo().getStIp4To()))){
					    	  bean.getIpUrIpDetail().setIpCriteria("");
					    	  bean.getIpUrIpDetail().setSingleIpCriteria(convertIp(bean.getIpInfo().getStIp1(), bean.getIpInfo().getStIp2(), bean.getIpInfo().getStIp3(), bean.getIpInfo().getStIp4()));
					      }else{
					    	  bean.getIpUrIpDetail().setIpCriteria("");
					    	  bean.getIpUrIpDetail().setSingleIpCriteria("");
					      }
					      
					      
					      
					      
					      //destination ip to
					      if(bean.getIpInfoTo() != null 
					    		  && StringHelper.notEmptyString(bean.getIpInfoTo().getStIp1())  
					    		  && StringHelper.notEmptyString(bean.getIpInfoTo().getStIp2())  
					    		  && StringHelper.notEmptyString(bean.getIpInfoTo().getStIp3())  
					    		  && StringHelper.notEmptyString(bean.getIpInfoTo().getStIp4())  
					    		  && StringHelper.notEmptyString(bean.getIpInfoTo().getStIp4To())){
					    	  String prefix = bean.getIpInfoTo().getStIp1()+"."+ bean.getIpInfoTo().getStIp2() + "."+ bean.getIpInfoTo().getStIp3()+".";
					    	  String ipList = convertListIp(prefix, bean.getIpInfoTo().getStIp4(), bean.getIpInfoTo().getStIp4To());
					    	  bean.getIpUrIpDetail().setIpToCriteria(ipList);
					    	  bean.getIpUrIpDetail().setSingleIpToCriteria("");
					      }else if((bean.getIpInfoTo() != null)
					    		  && ((StringHelper.notEmptyString(bean.getIpInfoTo().getStIp1())
					    		  || StringHelper.notEmptyString(bean.getIpInfoTo().getStIp2())
					    		  || StringHelper.notEmptyString(bean.getIpInfoTo().getStIp3()) 
					    		  || StringHelper.notEmptyString(bean.getIpInfoTo().getStIp4())))
					    		  && !(StringHelper.notEmptyString(bean.getIpInfoTo().getStIp4To()))){
					    	  bean.getIpUrIpDetail().setIpToCriteria("");
					    	  bean.getIpUrIpDetail().setSingleIpToCriteria(convertIp(bean.getIpInfoTo().getStIp1(), bean.getIpInfoTo().getStIp2(), bean.getIpInfoTo().getStIp3(), bean.getIpInfoTo().getStIp4()));
					      }else{
					    	  bean.getIpUrIpDetail().setIpToCriteria("");
					    	  bean.getIpUrIpDetail().setSingleIpToCriteria("");
					      }
					      
					      
					      
					      if(subUrPack.length()==0)
					       searchResult = searchURService.searchUR(bean.getIpUrIpDetail(), userSessionBean.getIpUser());
					      else
					       searchResult = searchURService.searchUR(bean.getIpUrIpDetail(),subUrPack, userSessionBean.getIpUser());
	
					List<IpUrIpDetail> list = searchResult.getResultList();
					for (IpUrIpDetail ipUrIpDetail : list){
						if("NC".equals(ipUrIpDetail.getUrType())){
						  ipUrIpDetail.setFuncId("F030");
						}else if("IP12".equals(ipUrIpDetail.getUrType())){
						  ipUrIpDetail.setFuncId("F029");
						}else if("IP23".equals(ipUrIpDetail.getUrType())){
							ipUrIpDetail.setFuncId("F027");
						}
						ipUrIpDetailList.add(ipUrIpDetail);
					}
					
					bean.setSearchList(ipUrIpDetailList);
					
					if(searchResult.isOverMaxResultLimit()){
						IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0014")));	
					}
					
					setSearchURDataBean(bean);
				
			}
				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public String navigation(){
		SearchURBean bean = getSearchURDataBean();
		String urNo = getRequestParameter("URNo");
		String mode = getRequestParameter("MODE");
		String funcId = getRequestParameter("FuncID");
		String actionName = "";
		String programId = "";
		String returnPage = null;
		InboxService inboxService = (InboxService)JSFServiceFinderUtil.getInstance().getBean("inboxService");
		IpFunction ipFunction;
		try {

			ipFunction = inboxService.getIpFunction(funcId);		

			actionName = ipFunction.getActionUrl();
			programId = ipFunction.getProgramId();
			returnPage = perform(actionName,programId);
			IPFMWebUtil.storeOnSession("fromPage", "IPSSR001");
			setSearchURDataBean(bean);
		} catch (IPFMBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return returnPage;
	}
	
	public String perform(String actionName, String programID) throws Exception {
		String returnPage = null;
		try {
			if(actionName!=null){
				clearSessionNotUsed();
			}
			Object o = Class.forName(actionName.trim()).newInstance();		
			System.out.println("init to >> ["+programID+"] "+actionName);
			returnPage = ((AbstractAction) o).init(programID);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return returnPage;
	}
	
	public void  reset() throws Exception {
		SearchURBean bean = getSearchURDataBean();
		bean.setSearchList(null);
		init();
	}
	
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		SearchURBean bean = getSearchURDataBean();
		
		if (bean.getIpUrIpDetail().getReqDate()==null && bean.getIpUrIpDetail().getReqDateTo()!=null) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"Request Date From"));
			flgValid = false;
		}
		if (bean.getIpUrIpDetail().getReqDate()!=null && bean.getIpUrIpDetail().getReqDateTo()==null) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"Request Date To"));
			flgValid = false;
		}
		
		if(bean.getIpUrIpDetail().getReqDate()!=null  && bean.getIpUrIpDetail().getReqDateTo()!=null ){
			if(bean.getIpUrIpDetail().getReqDate().after(bean.getIpUrIpDetail().getReqDateTo()) ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
				flgValid = false;
			}
		}

		return flgValid;
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }
	
	public String getIpInfo(){
		logger.debug("===== getIpInfo =====");
		SearchURBean bean = getSearchURDataBean();
		UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
		String urNo = getRequestParameter("URNo");
		String urType = getRequestParameter("urType");
		try{
			IpUrIpDetail ipUrIpDetail = userReqIPService.getIpUrIpDetail(urNo);
			if (ipUrIpDetail.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_CLOSE)) {	
				List<IpUrIpResult> ipUrIpResultList = userReqIPService.getIpUrIpResultList(urNo);
				bean.setIpUrIpResultList(ipUrIpResultList);
				bean.setUrType(urType);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String convertListIp(String prefix,String ipFrom, String ipTo){
		String result = "";
		int from = Integer.parseInt(ipFrom);
		int to = Integer.parseInt(ipTo);
		
		if(from < to){
			for(int i = 0;i <= (to - from);i++){
				result = result + ",'"+prefix+(from+i)+"'";
			}
		}else if(from > to){
			for(int i = 0;i >= (to - from);i--){
				result = result + ",'"+prefix+(from+i)+"'";
			}
		}else if(from == to){
			result = result + ",'"+prefix+(from)+"'";
		}
		
		if(!result.equals("")){
			result = result.substring(1);
		}
		
		return result;
	}
	
	public String convertIp(String ip1,String ip2,String ip3,String ip4){
		String result = "";
		result = result + StringHelper.convertEmptyToblank(ip1);
		if(StringHelper.notEmptyString(ip2)){
			result = result + "."+ StringHelper.convertEmptyToblank(ip2);
		}
		
		if(StringHelper.notEmptyString(ip3)){
			result = result + "."+ StringHelper.convertEmptyToblank(ip3);
		}
		
		if(StringHelper.notEmptyString(ip4)){
			result = result + "."+ StringHelper.convertEmptyToblank(ip4);
		}
		
		return result;
	}
	
	
}
