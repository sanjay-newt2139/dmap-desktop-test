package th.co.ais.ipfm.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import th.co.ais.ipfm.domain.MenuCaption;
import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;

public class IPFMWebUtil implements Serializable{

	public static String USER_SESSION = "userSession";
	private static final long serialVersionUID = 1L;
	
	public static UserSession getUserSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		return (UserSession) session.getAttribute(USER_SESSION);
	}
	public static void storeOnSession(String key, Object object) {
	    FacesContext ctx = FacesContext.getCurrentInstance();
	    Map sessionState = ctx.getExternalContext().getSessionMap();
	    sessionState.put(key, object);
	}
	public static Object getObjFromSession(String key) {
	    FacesContext ctx = FacesContext.getCurrentInstance();
	    Map sessionState = ctx.getExternalContext().getSessionMap();
	    return sessionState.get(key);
	}
	public static String getUserId(){
		String loginName = "";
		try{
			loginName = getUserSession().getIpUser().getUserId();
		}catch (Exception e) {
			FacesContext facesCtx = FacesContext.getCurrentInstance();
			Application app = facesCtx.getApplication();
            ViewHandler viewHandler = app.getViewHandler();
            UIViewRoot view = viewHandler.createView(
                facesCtx,
                "/login.jsf");
            facesCtx.setViewRoot(view);
            facesCtx.renderResponse();
		}
		return loginName;
	}
	
	public static String getHeader(){
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletcontext = (ServletContext)context.getExternalContext().getContext();
		String filename = servletcontext.getRealPath("/home/ipfm/logo/header.jpg");
		
		System.out.println("filename = "+filename);
		System.out.println("servletcontext.getContextPath() = "+servletcontext.getContextPath());
		System.out.println("servletcontext.getServletContextName() = "+servletcontext.getServletContextName());
		return filename;
	}

	public static String getHeadMenu() throws Exception{
		UserSession userSession = IPFMWebUtil.getUserSession();
		//System.out.println("--------------getHeadMenu-----------"+userSession.getNewUser());
		Map listMenu = userSession.getObjUserMenu();
		StringBuffer sb = new StringBuffer();
		if (userSession.getMenuLevel1List()==null || userSession.getMenuLevel1List().size()==0) return "<li></li>";
		for (IpFunction ipFunction : userSession.getMenuLevel1List()) {
			Iterator it = listMenu.entrySet().iterator();
			//if (!it.hasNext()) return "<li></li>";
		    while (it.hasNext()) {
		    	Map.Entry pairs = (Map.Entry)it.next();
		        String key = (String)pairs.getKey();
		        if (!ipFunction.getFuncName().equalsIgnoreCase(key)) continue;
		        ArrayList valueList = (ArrayList) pairs.getValue();
		        
		        sb.append("<li><a href='#'>"+key+"</a>");
				sb.append("<ul>");
				
		        for(int i=0;i<valueList.size();i++){
		        	MenuCaption caption = (MenuCaption)valueList.get(i);
		        	String progID = (caption.getProgramID()!=null)?caption.getProgramID().trim():"";
		        	String url = (caption.getLinkURL()!=null)?caption.getLinkURL().trim():"";
		        	String capt = (caption.getCaption()!=null)?caption.getCaption().trim():"";
		        	sb.append("	<li><a style=\"cursor:pointer\" onclick=\"parent.tree.location='../home/tree.jsf';goToPage('"+url+"','"+progID+"')\" >"+capt+"</a></li>");
		        }
				sb.append("</ul>");
				sb.append("</li>");
				break;
		    }
		}
		
		
	   // System.out.println("--------------finish HeadMenu-----------");
		return sb.toString();
	}
	
	public static Integer webConfigMaxRecord(){
		int count = 80;
		try {
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			File file = new File(ipfmConfigBean.getMaxRecordPath(),ipfmConfigBean.getMaxRecordFile());
		    if(file.exists()) {
				FileReader input = new FileReader(file);
				BufferedReader bufRead = new BufferedReader(input);
				count = Integer.parseInt(bufRead.readLine().toString());
			}		    
		   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}  
		return count;
	}
}
