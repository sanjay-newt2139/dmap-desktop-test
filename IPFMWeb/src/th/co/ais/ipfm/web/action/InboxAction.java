package th.co.ais.ipfm.web.action;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpvMonitorReqnc;
import th.co.ais.ipfm.domain1.IpvTodoPlanningReq;
import th.co.ais.ipfm.domain1.IpvTodoReqnc;
import th.co.ais.ipfm.domain1.IpvTodoUserReq;
import th.co.ais.ipfm.domain1.IpvWatchPlanningReq;
import th.co.ais.ipfm.domain1.IpvWatchReqnc;
import th.co.ais.ipfm.domain1.IpvWatchUserReq;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.InboxService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.bean.InboxBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class InboxAction extends AbstractAction {
	
	private static final Logger logger = Logger.getLogger(InboxAction.class);
	private InboxBean inboxBean;

	public InboxBean getInboxBean() {
		return (InboxBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("inboxBean");
	}

	public void setInboxBean(InboxBean inboxBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("inboxBean", inboxBean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		return programID;
	}

	@Override
	public boolean validate() {
		return false;
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		inboxBean = getInboxBean();		
		if(TablSort.equalsIgnoreCase("watchNC")) {
			inboxBean.setWatchNCSortColumn(sortColumnChange());	
		} else if(TablSort.equalsIgnoreCase("watchUserIP")) {
			inboxBean.setWatchUserIPSortColumn(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("watchPlan")) {
			inboxBean.setWatchPlanSortColumn(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("monitor")) {
			inboxBean.setnCMSortColumn(sortColumnChange());
		}
		
		else if(TablSort.equalsIgnoreCase("todoplan01")) {
			inboxBean.setSortTodoPlan01(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoplan02")) {
			inboxBean.setSortTodoPlan02(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoplan04")) {
			inboxBean.setSortTodoPlan04(sortColumnChange());
		} 
		
		else if(TablSort.equalsIgnoreCase("todouser01")) {
			inboxBean.setSortTodoUser01(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todouser02")) {
			inboxBean.setSortTodoUser02(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todouser03")) {
			inboxBean.setSortTodoUser03(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todouser04")) {
			inboxBean.setSortTodoUser04(sortColumnChange());
		}  
		
		else if(TablSort.equalsIgnoreCase("todoReqNC01")) {
			inboxBean.setSortTodoReqNC01(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC02Mrg")) {
			inboxBean.setSortTodoReqNC02Mrg(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC02Owner")) {
			inboxBean.setSortTodoReqNC02Owner(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC03")) {
			inboxBean.setSortTodoReqNC03(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC05")) {
			inboxBean.setSortTodoReqNC05(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC11")) {
			inboxBean.setSortTodoReqNC11(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC12")) {
			inboxBean.setSortTodoReqNC12(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC06")) {
			inboxBean.setSortTodoReqNC06(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC07")) {
			inboxBean.setSortTodoReqNC07(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC08")) {
			inboxBean.setSortTodoReqNC08(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC09")) {
			inboxBean.setSortTodoReqNC09(sortColumnChange());
		} else if(TablSort.equalsIgnoreCase("todoReqNC10")) {
			inboxBean.setSortTodoReqNC10(sortColumnChange());
		} 
		
		return "";
	}
	
		
	public String showInbox(){
		String treeType = getRequestParameter("treeType");
		String treeLevel = getRequestParameter("treeLevel");
		String urType = getRequestParameter("urType");
		String actionCode = getRequestParameter("actionCode");
		System.out.println("treeType = " + treeType);
		System.out.println("treeLevel = " + treeLevel);
		System.out.println("urType = " + urType);
		System.out.println("actionCode = " + actionCode);
		inboxBean = getInboxBean();
		if (inboxBean==null) inboxBean = new InboxBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		InboxService inboxService = (InboxService)JSFServiceFinderUtil.getInstance().getBean("inboxService");
		try {
			newInbox();
			inboxBean.setTreeType(treeType);
			inboxBean.setUrType(urType);
			inboxBean.setActionCode(actionCode);
			if (treeType!=null && treeType.equalsIgnoreCase("TODOLIST")) {
				if (urType !=null && urType.trim().length()>0){
					if (urType.equalsIgnoreCase(IPFMConstant.URTYPE_USER_REQ_IP)){
						if (actionCode!=null && actionCode.equalsIgnoreCase("01")){
							inboxBean.setIpvTodoUserReq01List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "01"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("02")){
							inboxBean.setIpvTodoUserReq02List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "02"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("03")){
							inboxBean.setIpvTodoUserReq03List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "03"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("04")){
							inboxBean.setIpvTodoUserReq04List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "04"));
						}else{
							inboxBean.setIpvTodoUserReq01List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "01"));
							inboxBean.setIpvTodoUserReq02List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "02"));
							inboxBean.setIpvTodoUserReq03List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "03"));
							inboxBean.setIpvTodoUserReq04List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "04"));
						}
					}else if (urType.equalsIgnoreCase(IPFMConstant.URTYPE_PLANNING_REQ_IP)){
						if (actionCode!=null && actionCode.equalsIgnoreCase("01")){
							inboxBean.setIpvTodoPlanningReq01List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "01"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("02")){
							inboxBean.setIpvTodoPlanningReq02List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "02"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("04")){
							inboxBean.setIpvTodoPlanningReq04List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "04"));
						}else{
							inboxBean.setIpvTodoPlanningReq01List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "01"));
							inboxBean.setIpvTodoPlanningReq02List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "02"));
							inboxBean.setIpvTodoPlanningReq04List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "04"));
						}
					}else if (urType.equalsIgnoreCase(IPFMConstant.URTYPE_NETWORK_CONFIG)){
						if (actionCode!=null && actionCode.equalsIgnoreCase("01")){
							inboxBean.setIpvTodoReqNC01List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "01"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("02_MRG")){
							inboxBean.setIpvTodoReqNC02MrgList(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "02_MRG"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("02_OWNER")){
							inboxBean.setIpvTodoReqNC02OwnerList(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "02_OWNER"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("03")){
							inboxBean.setIpvTodoReqNC03List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "03"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("04")){
							inboxBean.setIpvTodoReqNC04List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "04"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("05")){
							inboxBean.setIpvTodoReqNC05List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "05"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("06")){
							inboxBean.setIpvTodoReqNC06List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "06"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("07")){
							inboxBean.setIpvTodoReqNC07List(inboxService.findTodoReqNCNoRemark(userSession.getIpUser().getUserId(), "07"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("08")){
							inboxBean.setIpvTodoReqNC08List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "08"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("09")){
							inboxBean.setIpvTodoReqNC09List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "09"));
						}else if (actionCode!=null && actionCode.equalsIgnoreCase("10")){
							inboxBean.setIpvTodoReqNC10List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "10"));
						}else if(actionCode!=null && actionCode.equalsIgnoreCase("11")){
							inboxBean.setIpvTodoReqNC11List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "11"));
						}else if(actionCode!=null && actionCode.equalsIgnoreCase("12")){
							inboxBean.setIpvTodoReqNC12List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "12"));
						}else{
							inboxBean.setIpvTodoReqNC01List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "01"));
							inboxBean.setIpvTodoReqNC02MrgList(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "02_MRG"));
							inboxBean.setIpvTodoReqNC02OwnerList(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "02_OWNER"));
							inboxBean.setIpvTodoReqNC03List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "03"));
							inboxBean.setIpvTodoReqNC04List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "04"));
							inboxBean.setIpvTodoReqNC05List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "05"));
							inboxBean.setIpvTodoReqNC06List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "06"));
							inboxBean.setIpvTodoReqNC07List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "07"));
							inboxBean.setIpvTodoReqNC08List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "08"));
							inboxBean.setIpvTodoReqNC09List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "09"));
							inboxBean.setIpvTodoReqNC10List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "10"));
							inboxBean.setIpvTodoReqNC11List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "11"));
							inboxBean.setIpvTodoReqNC12List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "12"));
						}
					}
				}else{
					inboxBean.setIpvTodoPlanningReq01List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "01"));
					inboxBean.setIpvTodoPlanningReq02List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "02"));
					inboxBean.setIpvTodoPlanningReq04List(inboxService.findTodoPlanningReq(userSession.getIpUser().getUserId(), "04"));
					
					inboxBean.setIpvTodoUserReq01List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "01"));
					inboxBean.setIpvTodoUserReq02List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "02"));
					inboxBean.setIpvTodoUserReq03List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "03"));
					inboxBean.setIpvTodoUserReq04List(inboxService.findTodoUserReq(userSession.getIpUser().getUserId(), "04"));
					
					inboxBean.setIpvTodoReqNC01List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "01"));
					inboxBean.setIpvTodoReqNC02MrgList(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "02_MRG"));
					inboxBean.setIpvTodoReqNC02OwnerList(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "02_OWNER"));
					inboxBean.setIpvTodoReqNC03List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "03"));
					inboxBean.setIpvTodoReqNC04List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "04"));
					inboxBean.setIpvTodoReqNC05List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "05"));
					inboxBean.setIpvTodoReqNC06List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "06"));
					inboxBean.setIpvTodoReqNC07List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "07"));
					inboxBean.setIpvTodoReqNC08List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "08"));
					inboxBean.setIpvTodoReqNC09List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "09"));
					inboxBean.setIpvTodoReqNC10List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "10"));
					inboxBean.setIpvTodoReqNC11List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "11"));
					inboxBean.setIpvTodoReqNC12List(inboxService.findTodoReqNC(userSession.getIpUser().getUserId(), "12"));
					
				}
			}else if (treeType!=null && treeType.equalsIgnoreCase("WATCHLIST")) {
				if (urType !=null && urType.trim().length()>0){
					if (urType.equalsIgnoreCase(IPFMConstant.URTYPE_USER_REQ_IP)){
						inboxBean.setIpvWlUserReqList(inboxService.findWatchUserReq(userSession.getIpUser().getUserId()));
					}else if (urType.equalsIgnoreCase(IPFMConstant.URTYPE_PLANNING_REQ_IP)){
						inboxBean.setIpvWlPlanningReqList(inboxService.findWatchPlanningReq(userSession.getIpUser().getUserId()));
					}else if (urType.equalsIgnoreCase(IPFMConstant.URTYPE_NETWORK_CONFIG)){
						inboxBean.setIpvWlNetworkConfigList(inboxService.findWatchReqNC(userSession.getIpUser().getUserId()));
					}
				}else{
					inboxBean.setIpvWlUserReqList(inboxService.findWatchUserReq(userSession.getIpUser().getUserId()));
					inboxBean.setIpvWlPlanningReqList(inboxService.findWatchPlanningReq(userSession.getIpUser().getUserId()));
					inboxBean.setIpvWlNetworkConfigList(inboxService.findWatchReqNC(userSession.getIpUser().getUserId()));
				}
			}else if (treeType!=null && treeType.equalsIgnoreCase("MONITOR")) {
				inboxBean.setIpvMntNetworkConfigList(inboxService.findMonitorReqNC(userSession.getIpUser().getUserId()));
			}

			inboxBean.setWatchNCSortColumn(new SortColumnBean());
			setInboxBean(inboxBean);
		} catch (IPFMBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return "inbox";
	}
	
	public String navigation(){
		String urNo = getRequestParameter("URNo");
		String mode = getRequestParameter("MODE");
		String funcId = getRequestParameter("FuncID");
		String actionName = "";
		String programId = "";
		String returnPage = null;
		InboxService inboxService = (InboxService)JSFServiceFinderUtil.getInstance().getBean("inboxService");
		IpFunction ipFunction;
		try {
			logger.debug("urNo = "+urNo+"  MODE = "+mode+"  FuncId = "+funcId);
			ipFunction = inboxService.getIpFunction(funcId);		
			
			logger.debug("ActionName = "+IPFMUtils.ifBlank(ipFunction.getActionUrl(),""));
			logger.debug("programId = "+IPFMUtils.ifBlank(ipFunction.getProgramId(),""));
			actionName = ipFunction.getActionUrl();
			programId = ipFunction.getProgramId();
			returnPage = perform(actionName,programId);
			logger.debug("returnPage = "+returnPage);
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
	
	public void newInbox(){
		inboxBean.setTreeType("");
		
		inboxBean.setIpvTodoPlanningReq01List(new ArrayList<IpvTodoPlanningReq>());
		inboxBean.setIpvTodoPlanningReq02List(new ArrayList<IpvTodoPlanningReq>());
		inboxBean.setIpvTodoPlanningReq04List(new ArrayList<IpvTodoPlanningReq>());
		
		inboxBean.setIpvTodoUserReq01List(new ArrayList<IpvTodoUserReq>());
		inboxBean.setIpvTodoUserReq02List(new ArrayList<IpvTodoUserReq>());
		inboxBean.setIpvTodoUserReq03List(new ArrayList<IpvTodoUserReq>());
		inboxBean.setIpvTodoUserReq04List(new ArrayList<IpvTodoUserReq>());
		
		inboxBean.setIpvTodoReqNC01List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC02MrgList(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC02OwnerList(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC03List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC04List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC05List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC06List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC07List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC08List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC09List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC10List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC11List(new ArrayList<IpvTodoReqnc>());
		inboxBean.setIpvTodoReqNC12List(new ArrayList<IpvTodoReqnc>());		
		
		inboxBean.setIpvWlNetworkConfigList(new ArrayList<IpvWatchReqnc>());
		inboxBean.setIpvWlPlanningReqList(new ArrayList<IpvWatchPlanningReq>());
		inboxBean.setIpvWlUserReqList(new ArrayList<IpvWatchUserReq>());
		inboxBean.setIpvMntNetworkConfigList(new ArrayList<IpvMonitorReqnc>());
	}
	
	public String perform(String actionName, String programID) throws Exception {
		String returnPage = null;
		try {
			if(actionName!=null){
				logger.debug("clear session not use");
				clearSessionNotUsed();
				logger.debug(actionName);
			}else{
				logger.debug("NO Action Name!");
			}
			Object o = Class.forName(actionName.trim()).newInstance();		
			System.out.println("init to >> ["+programID+"] "+actionName);
			returnPage = ((AbstractAction) o).init(programID);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return returnPage;
	}	
}
