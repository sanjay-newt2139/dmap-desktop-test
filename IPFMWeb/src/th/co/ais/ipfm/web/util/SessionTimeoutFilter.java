package th.co.ais.ipfm.web.util;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.internal.preferences.Base64;

import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.service.ILoginService;
import th.co.ais.ipfm.service.IpUrActionService;
import th.co.ais.ipfm.web.bean.UserSession;

public class SessionTimeoutFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SessionTimeoutFilter.class);
	private String timeoutPage = "login.jsf";
	private String redirectPage = "redirect.jsf";
	private String indexPage = "index.jsp";
	private String viewPage = "home/view.jsf";
	private String forceLogOutPage = "forceLogOutPage.jsf";
	private String reportLaoutPage = "report/IPRUR003_Report_Layout.jsp";
	private String ajaxskiprequest = "a4j";
	private String errorBrowserPage = "errorBrowser.jsp";
	//test
	
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
	ServletException {
		if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {			
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession session = httpServletRequest.getSession(true);
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			String key = httpServletRequest.getParameter("key");
			
			
			String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");
			if(userAgent != null && userAgent.toLowerCase().indexOf("firefox") < 0){
				String errorBrowserPageUrl = httpServletRequest.getContextPath() + "/" + getErrorBrowserPage();
				session.setAttribute("sessionUserLogin", null);
				httpServletResponse.sendRedirect(errorBrowserPageUrl);
				return;
			}
			
			
			
			if(key!=null) mailCheckURNo(key);
			// is session expire control required for this request?
			if (isSessionControlRequiredForThisResource(httpServletRequest)) {
				// is session invalid?
				if (isSessionInvalid(httpServletRequest)) {
					String timeoutUrl = httpServletRequest.getContextPath() + "/" + getRedirectPage() + "?timeout=true";
					logger.debug("Session is invalid! redirecting to timeoutpage : " + timeoutUrl);
					session.setAttribute("sessionUserLogin", null);
					httpServletResponse.sendRedirect(timeoutUrl);
					return;
				}
				if (!isLoginUser(httpServletRequest)) {
					String timeoutUrl = httpServletRequest.getContextPath() + "/" + getRedirectPage() + "?nologin=true";
					logger.debug("Not Login User! redirecting to timeoutpage : " + timeoutUrl);
					session.setAttribute("sessionUserLogin", null);
					httpServletResponse.sendRedirect(timeoutUrl);
					return;
				}				
				
				UserSession userSession = (UserSession) session.getAttribute(IPFMWebUtil.USER_SESSION);
				if(userSession != null) {
					try {
						if(!isUserOwnTheSessionId(userSession.getIpUser().getUserId(), session.getId())) {
							String timeoutUrl = httpServletRequest.getContextPath() + "/" + getRedirectPage() + "?nologin=true";
							logger.debug("Session Not Owner any more ! redirecting to timeoutpage : " + timeoutUrl);
							session.setAttribute("sessionUserLogin", null);
							httpServletResponse.sendRedirect(timeoutUrl);
							return;							
						}
						
						if (isSessionControlRequiredForViewPageByMail(httpServletRequest)) {
							//session.removeAttribute(IPFMWebUtil.USER_SESSION);
							String timeoutUrl = httpServletRequest.getContextPath() + "/" + getRedirectPage() + "?nologin=true";
							logger.debug("View Page redirecting to Login Page : " + timeoutUrl);
							//session.setAttribute("sessionUserLogin", null);
							httpServletResponse.sendRedirect(timeoutUrl);
							return;	
						}

					} catch(Exception e) {
						e.printStackTrace();
						throw new ServletException(e);
					}
				}
			}

		}
		filterChain.doFilter(request, response);
	}
	
	private boolean isUserOwnTheSessionId(String userId, String sessionId) throws Exception{
		try {
		ILoginService loginService = (ILoginService) JSFServiceFinderUtil.getInstance().getBean("loginService");
		IpUser ipUser = loginService.findUserBySessionId(userId, sessionId);
		if(ipUser != null) {
			return true;
		}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/*
	* session shouldnt be checked for some pages. For example: for timeout page..
	* Since we�re redirecting to timeout page from this filter,
	* if we don�t disable session control for it, filter will again redirect to it
	* and this will be result with an infinite loop�
	*/
	private boolean isSessionControlRequiredForThisResource(HttpServletRequest httpServletRequest) {
		String requestPath = httpServletRequest.getRequestURI();
		boolean controlRequired = !(StringUtils.contains(requestPath, getTimeoutPage()) 
				|| StringUtils.contains(requestPath, getRedirectPage())
				|| StringUtils.contains(requestPath, getAjaxskiprequest())
				|| StringUtils.contains(requestPath, getIndexPage())
				|| StringUtils.contains(requestPath, forceLogOutPage)
				|| StringUtils.contains(requestPath, reportLaoutPage)
				);
		return controlRequired;
	}
	
	private boolean isSessionControlRequiredForViewPageByMail(HttpServletRequest httpServletRequest) {
		String requestPath = httpServletRequest.getRequestURI();
		boolean controlRequired = (StringUtils.contains(requestPath, viewPage));
		//System.out.println(requestPath + " ---  " +  controlRequired);
		return controlRequired;
	}	
	
	private boolean isSessionInvalid(HttpServletRequest httpServletRequest) {
		boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)
			&& !httpServletRequest.isRequestedSessionIdValid();
		return sessionInValid;
	}
	
	private boolean isLoginUser(HttpServletRequest httpServletRequest){
		boolean loginValid = (httpServletRequest.getSession(true).getAttribute(IPFMWebUtil.USER_SESSION)!=null);
		return loginValid;
	}
	
	private void mailCheckURNo(String key){
		String text = new String(Base64.decode(key.getBytes()));
//		if(text.startsWith("IPFM")){
//			int pos = text.indexOf(":");
//	        String urNo = text.substring(4, pos);
//	        String userId = text.substring(pos+1);
			IpUrActionService nwConfigService = (IpUrActionService)JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
//			IpEmailNotify notify = nwConfigService.findByResponce(urNo, userId);
			IpEmailNotify notify = nwConfigService.findByResponce(text);
			if (notify!=null) {
				notify.setEmailLinkStatus("Y");
				notify.setLastUpd(new Date());
				nwConfigService.updateEmailNotify(notify);
				System.out.println("Change email flag for ["+notify.getUrNo()+"] By >> "+notify.getUserId());
			}
//		}
	}
	
	public void destroy() {
	
	}
	
	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	public String getTimeoutPage() {
		return timeoutPage;
	}
	
	public void setTimeoutPage(String timeoutPage) {
		this.timeoutPage = timeoutPage;
	}

	public String getRedirectPage() {
		return redirectPage;
	}

	public void setRedirectPage(String redirectPage) {
		this.redirectPage = redirectPage;
	}

	public String getAjaxskiprequest() {
		return ajaxskiprequest;
	}

	public void setAjaxskiprequest(String ajaxskiprequest) {
		this.ajaxskiprequest = ajaxskiprequest;
	}

	public String getErrorBrowserPage() {
		return errorBrowserPage;
	}

	public void setErrorBrowserPage(String errorBrowserPage) {
		this.errorBrowserPage = errorBrowserPage;
	}
	
	

}