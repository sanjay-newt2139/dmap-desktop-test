package th.co.ais.ipfm.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class PropertiesMessageUtil {
	//test svn
	private static PropertiesMessageUtil instance = null;
	private static PropertiesMessageUtil instance1 = null;
	private static PropertiesMessageUtil instance2 = null;
	private static PropertiesMessageUtil instance3 = null;
	private static PropertiesMessageUtil instance4 = null;
	ResourceBundle reportMSG = null;

	private PropertiesMessageUtil(){
		
	}
	
	private PropertiesMessageUtil(String type){
		if (type.equalsIgnoreCase("confirm")) {
			System.out.println("--- confirm = " +type);
			reportMSG = ResourceBundle.getBundle("th.co.ais.ipfm.resource.confirm_message");
		}else if (type.equalsIgnoreCase("error")){
			System.out.println("--- error = " +type);
			reportMSG = ResourceBundle.getBundle("th.co.ais.ipfm.resource.error_message");
		}else if (type.equalsIgnoreCase("config")){
			System.out.println("--- config = " +type);
			reportMSG = ResourceBundle.getBundle("th.co.ais.ipfm.resource.config_message");
		}else if (type.equalsIgnoreCase("programurl")){
			System.out.println("--- programurl = " +type);
			reportMSG = ResourceBundle.getBundle("th.co.ais.ipfm.resource.programurl");
		}
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
	
	public static synchronized PropertiesMessageUtil getInstance(String type) {
		if (type.equalsIgnoreCase("confirm")) {
			if(instance == null){
				instance = new PropertiesMessageUtil(type);
			}
			return instance;
		}else if (type.equalsIgnoreCase("error")){
			if(instance1 == null){
				instance1 = new PropertiesMessageUtil(type);
			}
			return instance1;
		}else if (type.equalsIgnoreCase("config")){
			if(instance2 == null){
				instance2 = new PropertiesMessageUtil(type);
			}
			return instance2;
		}else if (type.equalsIgnoreCase("programurl")){
			if(instance3 == null){
				instance3 = new PropertiesMessageUtil(type);
			}
			return instance3;
		}else{
			if(instance4 == null){
				instance4 = new PropertiesMessageUtil(type);
			}
			return instance4;
		}
		
	}
	
	public static synchronized String getConfirmMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = PropertiesMessageUtil.getInstance("confirm").getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
	
	public static synchronized String getErrorMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = PropertiesMessageUtil.getInstance("error").getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
	public static synchronized String getConfigMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = PropertiesMessageUtil.getInstance("config").getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
	public static synchronized String getProgramurl(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = PropertiesMessageUtil.getInstance("programurl").getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
}

