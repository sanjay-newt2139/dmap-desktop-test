package th.co.ais.ipfm.web.util;

import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SessionTimeoutPhaseListener implements PhaseListener,Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SessionTimeoutPhaseListener.class);
	
	public void beforePhase(PhaseEvent event) {
			if(event.getPhaseId()== getPhaseId()) {
		        FacesContext facesCtx = event
	            .getFacesContext();
	        ExternalContext extCtx = facesCtx
	            .getExternalContext();
	        HttpSession session = (HttpSession)extCtx
	            .getSession(false);
	        
	        boolean newSession = (session == null)
	            || (session.isNew());
	        boolean postback = !extCtx
	            .getRequestParameterMap().isEmpty();
	        boolean timedout = postback && newSession;
	        if(timedout) {
	        	logger.error("Session timed out --> " + timedout);
	            Application app = facesCtx.getApplication();
	            ViewHandler viewHandler = app.getViewHandler();
	            UIViewRoot view = viewHandler.createView(
	                facesCtx,
	                "/redirect.jsp");
	            facesCtx.setViewRoot(view);
	            facesCtx.renderResponse();
	            try {
	                viewHandler.renderView(facesCtx, view);
	                facesCtx.responseComplete();
	            } catch(Throwable t) {
	            	logger.error("Session timed out");
	                throw new FacesException(
	                    "Session timed out", t);
	            }
	        }			
		}
    }

    public void afterPhase(PhaseEvent event) {
//		if(event.getPhaseId()== getPhaseId()) {
//	        FacesContext facesCtx = event
//            .getFacesContext();
//	        ExternalContext extCtx = facesCtx
//	            .getExternalContext();
//	        HttpSession session = (HttpSession)extCtx
//	            .getSession(false);
//	        
//	        boolean newSession = (session == null)
//	            || (session.isNew());
//	        boolean postback = !extCtx
//	            .getRequestParameterMap().isEmpty();
//	        boolean timedout = postback && newSession;
//	        if(timedout) {
//	        	logger.error("Session timed out --> " + timedout);
//	            Application app = facesCtx.getApplication();
//	            ViewHandler viewHandler = app.getViewHandler();
//	            UIViewRoot view = viewHandler.createView(
//	                facesCtx,
//	                "/redirect.jsp");
//	            facesCtx.setViewRoot(view);
//	            facesCtx.renderResponse();
//	            try {
//	                viewHandler.renderView(facesCtx, view);
//	                facesCtx.responseComplete();
//	            } catch(Throwable t) {
//	            	logger.error("Session timed out");
//	                throw new FacesException(
//	                    "Session timed out", t);
//	            }
//	        }    	
//		}
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
