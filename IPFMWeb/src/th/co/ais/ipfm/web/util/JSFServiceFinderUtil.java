package th.co.ais.ipfm.web.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class JSFServiceFinderUtil implements Serializable{

	private static final long serialVersionUID = 1L;
	private static JSFServiceFinderUtil instance = null;
	private ApplicationContext ctx = null;
	
	private JSFServiceFinderUtil(){
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletcontext = (ServletContext)context.getExternalContext().getContext();
		ctx = WebApplicationContextUtils.getWebApplicationContext(servletcontext);
	}
	
	public static JSFServiceFinderUtil getInstance() {
        if (instance == null) {
            instance = new JSFServiceFinderUtil();
        }
        return instance;
    }
	
	public Object getBean(String name){
		Object x = null;
		try {
			x = ctx.getBean(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
