package th.co.ais.ipfm.web.util;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Application Lifecycle Listener implementation class FaceConfigureParserListener
 *
 */
public class FaceConfigureParserListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FaceConfigureParserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	ServletContext servletContext = arg0.getServletContext();
    	try {
    	InputStream ins =  servletContext.getResourceAsStream("/WEB-INF/faces-config.xml");
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	DocumentBuilder db = dbf.newDocumentBuilder();
    	Document doc = db.parse(ins);
    	doc.getDocumentElement().normalize();
    	System.out.println("Root element " + doc.getDocumentElement().getNodeName());
    	NodeList nodeLst = doc.getElementsByTagName("navigation-case");    	
    	FaceNavigatorMapping navigatorMap =  FaceNavigatorMapping.getInstance();
    	for (int s = 0; s < nodeLst.getLength(); s++) {
    		  Node fstNode = nodeLst.item(s);
    		  if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
    		        Element element = (Element) fstNode;//from-outcome
	    		    NodeList fstNmElmntLst = element.getElementsByTagName("from-outcome");
	    		    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
	    		    NodeList fstNm = fstNmElmnt.getChildNodes();
	    		    String formOutCome = ((Node) fstNm.item(0)).getNodeValue();
	    		    System.out.println("form-outcome : "  + formOutCome);    		        
    		        
	    		    NodeList scdNmElmntLst = element.getElementsByTagName("to-view-id");
	    		    Element scdNmElmnt = (Element) scdNmElmntLst.item(0);
	    		    NodeList scdNm = scdNmElmnt.getChildNodes();
	    		    String toViewId = ((Node) scdNm.item(0)).getNodeValue();
	    		    System.out.println("to-view-id : "  + toViewId);
	    		    
	    		    navigatorMap =  FaceNavigatorMapping.getInstance();
	    		    navigatorMap.putNavigationCaseMap(formOutCome, toViewId);
    		  }

    		}    	

    	} catch (Exception ex) {
    		System.out.println("..... ERROR while Process FaceConfigurationParserListerner.contextInitialized() Message Caused : " + ex.getMessage());
    		ex.printStackTrace();
    	}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	try {
			FaceNavigatorMapping.getInstance().removeNavigationCaseMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
    		System.out.println("..... ERROR while Process FaceConfigurationParserListerner.contextDestroyed() Message Caused : " + e.getMessage());
			e.printStackTrace();
		}
    }
	
}
