package th.co.ais.ipfm.web.util;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.ILoginService;
import th.co.ais.ipfm.web.bean.UserSession;

public class IPFMSessionListener implements HttpSessionListener {
	
	private static final Logger logger = Logger.getLogger(IPFMSessionListener.class);
	
	public void sessionCreated(HttpSessionEvent event) {
		logger.debug("Current Session created : " 
				+ event.getSession().getId() 
				+ " at "+ new Date());

	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.debug("Current Session destroyed :"  + session.getId() + " Logging out user.");
		try {
			prepareLogoutInfoAndLogoutActiveUser(session);
		} catch(Exception e) {
			e.printStackTrace();
			logger.debug("Error while logging out at session destroyed : "+ e.getMessage());
		}
	}

	public void prepareLogoutInfoAndLogoutActiveUser(HttpSession httpSession) {
		UserSession userSession = (UserSession) httpSession.getAttribute(IPFMWebUtil.USER_SESSION);
		ILoginService loginService = (ILoginService)JSFServiceFinderUtil.getInstance().getBean("loginService");
		try {
			if (userSession != null) {
				IpUser ipUser = loginService.getIPUser(userSession.getIpUser().getUserId());
	//			logger.debug("Change status from "+ ipUser.getUserActiveStatus());
				if (ipUser.getUserActiveStatus().equalsIgnoreCase("Y")) {
					ipUser.setUserActiveStatus("N");
					loginService.updateUser(ipUser);
				}
			}
//			logger.debug("Change status to "+ ipUser.getUserActiveStatus());
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
		// Only if needed
	}
}
