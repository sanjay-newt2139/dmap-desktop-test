package th.co.ais.ehr.service;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.tempuri.WebDBConfigServiceSoapProxy;

import com.google.gson.Gson;

import th.co.ais.ehr.domain.UserAccount;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.PropertyUtil;

public class AuthenDBService {

	private static final Logger logger = Logger.getLogger(AuthenDBService.class);
	private String username;
	private String password;
	private String endpoint;
	private String projectid;
	
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@SuppressWarnings("unused")
	public UserAccount getAuthenUserConfig() throws IPFMBusinessException {
		UserAccount usr = null;
		try {
			// get config
			endpoint = PropertyUtil.getProperty("AUTH_SERVICE_ENDPOINT");
			//username = PropertyUtil.getProperty("AUTH_SERVICE_USERNAME");
			//password = PropertyUtil.getProperty("AUTH_SERVICE_PASSWORD");
			projectid = PropertyUtil.getProperty("AUTH_SERVICE_PROJECT_ID");
			
			if(endpoint!=null /*&& username!=null && password!=null*/){
				// Get Authen User for Authen DB
				WebDBConfigServiceSoapProxy proxy = new WebDBConfigServiceSoapProxy(endpoint /*, username, password*/);
				usr = proxy.WS_AUTHENDB_USERConfig(projectid);
				
				//System.out.println(new Gson().toJson(usr));
				
				if("".equals(usr.getUserName()) 
						|| "".equals(usr.getPassword()) 
						|| "".equals(usr.getDomainName()) 
						|| "IP is no permission.".equals(usr.getDetail())) {
					throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0216")));
				}
				
				// Decrypt
				String u = CSSDAuthen.decrypt(StringEscapeUtils.unescapeJava(usr.getUserName()));
				String p = CSSDAuthen.decrypt(StringEscapeUtils.unescapeJava(usr.getPassword()));
				String d = CSSDAuthen.decrypt(StringEscapeUtils.unescapeJava(usr.getDomainName()));
				
				// Test By pass Auth DB
//				usr = new UserAccount();
//				String u = "ehrapp_stg";
//				String p = "Ais#2014";
//				String d = "corp-ais900dev";
				
				usr.setDomainName(d);
				usr.setUserName(u);
				usr.setPassword(p);
			}else{
				throw new IPFMBusinessException("AuthenDBService:Required Endpoint, UserName, Password!");
			}
		} catch (IPFMBusinessException ie){
			throw ie;
		} catch (Exception e) {
			logger.error("AuthenDBService:getAuthenUserConfig", e);
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
		}
		
		if (usr == null) {
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0215")));
		}else if("".equals(usr.getUserName()) 
				|| "".equals(usr.getPassword()) 
				|| "".equals(usr.getDomainName()) 
				|| "IP is no permission.".equals(usr.getDetail())) {
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0216")));
		}
		return usr;
	}
	
}
