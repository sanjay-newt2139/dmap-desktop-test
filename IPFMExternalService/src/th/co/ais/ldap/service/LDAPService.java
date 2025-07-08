package th.co.ais.ldap.service;

import org.apache.log4j.Logger;

import th.co.ais.authenldap.AuthenticateServiceLocator;
import th.co.ais.authenldap.AuthenticateServiceSoap;
import th.co.ais.authenldap.ProjectQuery;
import th.co.ais.authenldap.ServiceResponse;
import th.co.ais.authenldap.UserAuthenticate;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ldap.domain.LDAPResMsg;

public class LDAPService {
	private static final Logger logger = Logger.getLogger(LDAPService.class);
	private String endpoint;
	private String projectCode;
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public LDAPResMsg authenLDAP(String username, String password) throws IPFMBusinessException {
		LDAPResMsg ldapResMsg = authenLDAP(username,password,projectCode);
		return ldapResMsg; 
	}	
	public LDAPResMsg authenLDAP(String username, String password, String projectCode) throws IPFMBusinessException {
		LDAPResMsg ldapResMsg = null;
		try {
			if(endpoint!=null){
				AuthenticateServiceLocator authenticateServiceLocator = new AuthenticateServiceLocator();
				authenticateServiceLocator.setAuthenticateServiceSoapEndpointAddress(endpoint);
				AuthenticateServiceSoap service = authenticateServiceLocator.getAuthenticateServiceSoap() ;
				UserAuthenticate user = new UserAuthenticate();
				user.setUsername(username);
				user.setPassword(password);
				ProjectQuery authenProject = new ProjectQuery();
				authenProject.setProjectCode(projectCode);
				authenProject.setProjectLevel(1);
				
				ServiceResponse res =  service.authenticate(user, authenProject);
				if(res!=null){
					ldapResMsg = new LDAPResMsg();
					ldapResMsg.setSTATUS(String.valueOf(res.getCode()));
					ldapResMsg.setDETAIL(res.getMessage());
				}else{
					throw new IPFMBusinessException("LDAPService:authenLDAP");
				}	
			}else{
				throw new IPFMBusinessException("LDAPService:Required Endpoint!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("LDAPService:authenLDAP", e);
			throw new IPFMBusinessException("LDAPService:authenLDAP");
		}
		return ldapResMsg; 
	}	
}
