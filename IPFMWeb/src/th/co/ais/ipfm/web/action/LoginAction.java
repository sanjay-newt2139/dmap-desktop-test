package th.co.ais.ipfm.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.ILoginService;
import th.co.ais.ipfm.service.InboxService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.vo.UserVO;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.LoginBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import RSA.RSA;

public class LoginAction extends AbstractAction{
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("en","EN"));
	DateFormat dfm2 = new SimpleDateFormat("dd/MM/yyyy",new Locale("en","EN"));
	
	@SuppressWarnings("unchecked")
	public String login() throws Exception{
		logger.debug("Check Login");
		ILoginService loginService = null;
		String result = "failure";
		LoginBean loginBean =  (LoginBean)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("loginBean");
		loginBean.setUsername(loginBean.getUsername().toLowerCase().trim());
		loginBean.setDisplayErrorMsg(false);
		try{
			IPFMConfigBean ipfmConfigBean = getIPFMConfig();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			String userId = (String) session.getAttribute("sessionUserLogin");
			UserSession userSess = (UserSession) session.getAttribute(IPFMWebUtil.USER_SESSION);
			if(userId == null) {
				session.setAttribute("sessionUserLogin", loginBean.getUsername());
			} else {
				if(!userId.equals(loginBean.getUsername())) {
					return "forceLogOutPage";	
				}
			}			

			// Validate value
			if ( !validateUser(loginBean.getUsername(),loginBean.getPassword()) ){ return result; }
			// Call loginService
			loginService = (ILoginService)JSFServiceFinderUtil.getInstance().getBean("loginService");
			// Run Login Process
			UserVO userVO = null;

			try {
				userVO = loginService.login(loginBean.getUsername(), RSA.main(loginBean.getPassword()));
			
			}catch (IPFMBusinessException e) {
				e.printStackTrace();
				session.setAttribute("sessionUserLogin", null);
				throw new IPFMBusinessException(e.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("sessionUserLogin", null);
			}
			
			
			// Create UserSession Bean 
			UserSession userSession = new UserSession();
			userSession.setIpUser(userVO.getIpUser());
			userSession.setNewUser(userVO.getNewUser());
			userSession.setRoleMonitor(userVO.isRoleMonitor());
			userSession.setLoginDateTime(userVO.getLoginDateTime());
			userSession.setObjUserMenu(userVO.getObjUserMenu());
			userSession.setMenuLevel1List(userVO.getMenuLevel1List());
			userSession.setNews(userVO.getNews());
			userSession.setMaxReqIP4T2(ipfmConfigBean.getMaxReqIP4T2());
			userSession.setMaxReqIP4T3(ipfmConfigBean.getMaxReqIP4T3());
			userSession.setLastEmailNotify(userVO.getLastEmailNotify());
			userSession.setLastUrActionNotify(userVO.getLastUrActionNotify());
			// Store Session
			//HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			if(session == null) {
				session = (HttpSession) facesContext.getExternalContext().getSession(true);
			}
			session.setAttribute(IPFMWebUtil.USER_SESSION, userSession);
			System.out.println(" login session id ====== " + session.getId());
			//Navigate 
			result = "success";	
			if (userSession.getNewUser().equalsIgnoreCase("Y")) {
				InboxService inboxService = (InboxService)JSFServiceFinderUtil.getInstance().getBean("inboxService");
				IpFunction ipFunction = inboxService.getIpFunction("F037");
				perform(ipFunction.getActionUrl(), ipFunction.getProgramId());
				result="frameProfile";
			}else if (userSession.getLastUrActionNotify()!=null) {
				IpFunction ipFunction = loginService.getIpFunction(userSession.getLastUrActionNotify().getCallFunctionId());		
				ServletRequest request = (ServletRequest) facesContext.getExternalContext().getRequest();
		        request.setAttribute("MODE", userSession.getLastUrActionNotify().getCallMode());
		        request.setAttribute("URNo", userSession.getLastUrActionNotify().getUrNo());
		        request.setAttribute("programIDParam", ipFunction.getProgramId());
		        userSession.setNotifyProgramId(userVO.getNotifyProgramId());
		        perform(ipFunction.getActionUrl(),ipFunction.getProgramId());
		        result="frame"+ipFunction.getProgramId();
//		        FacesContext context = FacesContext.getCurrentInstance();
//		        String currentView = context.getViewRoot().getViewId();
//		        ViewHandler vh = context.getApplication().getViewHandler();
//		        UIViewRoot x = vh.createView(context, currentView);
//		        context.setViewRoot(x);
		    }
			loginService.updateSessionId(loginBean.getUsername(), session.getId());
		}catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}finally{
		}
		return result;
	}
	private boolean validateUser(String username, String password) {
		if (username==null || username.trim().length()==0) {
			IPFMMessageUtils.addMessageError("loginForm:username", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0019"), "User Name"));
		}
		if (password==null || password.trim().length()==0) {
			IPFMMessageUtils.addMessageError("loginForm:password", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0019"), "Password"));
		}
		if (IPFMMessageUtils.hasMessages()) return false;
		return true;
	}

	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
		if(session!=null){
			session.invalidate();
		}		
		return "logout";		
		
	}
	@Override
	public String init() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String init(String programID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}	
}
