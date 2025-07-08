package th.co.ais.ipfm.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ErrorMessageUtil {
	//test svn
	private static ErrorMessageUtil instance = null;
	ResourceBundle reportMSG = null;

	private ErrorMessageUtil(){
		reportMSG = ResourceBundle.getBundle("th.co.ais.ipfm.resource.error_message");
	}
	
	public String getMSG(String key) {
		String value = null;
		try {
			value = reportMSG.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static synchronized ErrorMessageUtil getInstance() {
		if(instance == null){
			instance = new ErrorMessageUtil();
		}
		return instance;
	}
	
	public static synchronized String getMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = ErrorMessageUtil.getInstance().getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
		
}

