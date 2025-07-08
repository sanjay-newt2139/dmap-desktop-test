package th.co.ais.ehr.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jivesoftware.authHelper.utils.CredentialsUtils;
import com.jivesoftware.authHelper.utils.SSLUtils;

import th.co.ais.ehr.domain.ApproverOM;
import th.co.ais.ehr.domain.EmployeeProfileOM;
import th.co.ais.ehr.domain.EmployeeProfileQueryResponse;
import th.co.ais.ehr.domain.UserAccount;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.PropertyUtil;

public class EmployeeProfileService2 {

	private static final Logger logger = Logger.getLogger(EmployeeProfileService2.class);
	private String endpoint;
	private String omcode;
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public void setOmcode(String omcode) {
		this.omcode = omcode;
	}
	
	private void getConfig() {
		endpoint = PropertyUtil.getProperty("EHR_SERVICE_ENDPOINT");
		omcode = PropertyUtil.getProperty("EHR_SERVICE_OM_CODE");
	}
	
	public List<EmployeeProfileOM> getEmployeeProfileByEmail(UserAccount authUser, String email) throws IPFMBusinessException {
		List<EmployeeProfileOM> profile = null;
		try {
			getConfig();
			if(endpoint!=null && authUser!=null && authUser.getUserName()!=null && authUser.getPassword()!=null && omcode!=null){
				
				UUID uuid = UUID.randomUUID();
				String json = "{\"methodName\":\"OM_WS_RPA_GetEmployeeProfileByEmail\",\"omCode\":\""+ omcode +"\",\"parameterList\":[{\"name\":\"Email\",\"value\":\""+ email +"\"}],\"transactionID\":\"" + uuid.toString() +"\"}";
				String res = callRestWS(authUser.getDomainName(), authUser.getUserName(), authUser.getPassword(), json);
				
				if(res != null && !"".equals(res)) {
					Gson g = new Gson();
			    	EmployeeProfileQueryResponse em = g.fromJson(res, EmployeeProfileQueryResponse.class);
			    	
			    	if(em != null && em.getResponseDataList() != null && !"".equals(em.getResponseDataList().trim())) {
			    		TypeToken<List<EmployeeProfileOM>> listType = new TypeToken<List<EmployeeProfileOM>>() {};
			    		List<EmployeeProfileOM> employeeProfileList = g.fromJson(em.getResponseDataList(), listType.getType());
			    		
			    		if(employeeProfileList != null && employeeProfileList.size() > 0) {
			    			profile = employeeProfileList;
			    		}
			    	}
				}
			}else{
				//throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
				throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0216")));
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService2:getEmployeeProfilesByEmail", e);
			//throw new IPFMBusinessException(IPFMDataUtility.buildMessage(e.getMessage()));
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
		}
		return profile;
	}
	
	public List<ApproverOM> listAllApprover(UserAccount authUser, String pin, String position) throws IPFMBusinessException {
		List<ApproverOM> aprList = null;
		try {
			getConfig();
			if(endpoint!=null && authUser!=null && authUser.getUserName()!=null && authUser.getPassword()!=null && omcode!=null){
				
				UUID uuid = UUID.randomUUID();
				String json = "{\"methodName\":\"OM_WS_ListAllApprover\",\"omCode\":\""+ omcode +"\",\"parameterList\":[{\"name\":\"Pin\",\"value\":\""+ pin +"\"},{\"name\":\"PositionID\",\"value\":\""+ position +"\"}],\"transactionID\":\""+ uuid.toString() +"\"}";
				String res = callRestWS(authUser.getDomainName(), authUser.getUserName(), authUser.getPassword(), json);
				
				if(res != null && !"".equals(res)) {
					Gson g = new Gson();
			    	EmployeeProfileQueryResponse em = g.fromJson(res, EmployeeProfileQueryResponse.class);
			    	
			    	if(em != null && em.getResponseDataList() != null && !"".equals(em.getResponseDataList().trim())) {
			    		TypeToken<List<ApproverOM>> listType = new TypeToken<List<ApproverOM>>() {};
			    		List<ApproverOM> approverList = g.fromJson(em.getResponseDataList(), listType.getType());
			    		
			    		if(approverList != null && approverList.size() > 0) {
			    			aprList = approverList;
			    		}
			    	}
				}
			}else{
				//throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
				throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0216")));
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService2:listAllApprover", e);
			//throw new IPFMBusinessException(IPFMDataUtility.buildMessage(e.getMessage()));
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
		}
		return aprList;
	}
	
	public List<EmployeeProfileOM> getEmployeeProfileByPIN(UserAccount authUser, String pin) throws IPFMBusinessException {
		List<EmployeeProfileOM> profile = null;
		try {
			getConfig();
			if(endpoint!=null && authUser!=null && authUser.getUserName()!=null && authUser.getPassword()!=null && omcode!=null){
				
				UUID uuid = UUID.randomUUID();
				String json = "{\"methodName\":\"OM_WS_GetEmployeeProfileByPIN\",\"omCode\":\""+ omcode +"\",\"parameterList\":[{\"name\":\"Pin\",\"value\":\""+ pin +"\"}],\"transactionID\":\"" + uuid.toString() +"\"}";
				String res = callRestWS(authUser.getDomainName(), authUser.getUserName(), authUser.getPassword(), json);
				
				if(res != null && !"".equals(res)) {
					Gson g = new Gson();
			    	EmployeeProfileQueryResponse em = g.fromJson(res, EmployeeProfileQueryResponse.class);
			    	
			    	if(em != null && em.getResponseDataList() != null && !"".equals(em.getResponseDataList().trim())) {
			    		TypeToken<List<EmployeeProfileOM>> listType = new TypeToken<List<EmployeeProfileOM>>() {};
			    		List<EmployeeProfileOM> employeeProfileList = g.fromJson(em.getResponseDataList(), listType.getType());
			    		
			    		if(employeeProfileList != null && employeeProfileList.size() > 0) {
			    			profile = employeeProfileList;
			    		}
			    	}
				}
			}else{
				//throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
				throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0216")));
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService2:getEmployeeProfileByPIN", e);
			//throw new IPFMBusinessException(IPFMDataUtility.buildMessage(e.getMessage()));
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
		}
		return profile;
	}
	
	public List<EmployeeProfileOM> getEmployeeProfileByPrefixEngName(UserAccount authUser, String empEngName) throws IPFMBusinessException {
		List<EmployeeProfileOM> profile = null;
		try {
			getConfig();
			if(endpoint!=null && authUser!=null && authUser.getUserName()!=null && authUser.getPassword()!=null && omcode!=null){
				
				UUID uuid = UUID.randomUUID();
				String json = "{\"methodName\":\"OM_WS_RPA_ListEmployeeProfileByPrefixEngName\",\"omCode\":\""+ omcode +"\",\"parameterList\":[{\"name\":\"PrefixNameEN\",\"value\":\""+ empEngName +"\"}],\"transactionID\":\"" + uuid.toString() +"\"}";
				String res = callRestWS(authUser.getDomainName(), authUser.getUserName(), authUser.getPassword(), json);
				
				if(res != null && !"".equals(res)) {
					Gson g = new Gson();
			    	EmployeeProfileQueryResponse em = g.fromJson(res, EmployeeProfileQueryResponse.class);
			    	
			    	if(em != null && em.getResponseDataList() != null && !"".equals(em.getResponseDataList().trim())) {
			    		TypeToken<List<EmployeeProfileOM>> listType = new TypeToken<List<EmployeeProfileOM>>() {};
			    		List<EmployeeProfileOM> employeeProfileList = g.fromJson(em.getResponseDataList(), listType.getType());
			    		
			    		if(employeeProfileList != null && employeeProfileList.size() > 0) {
			    			profile = employeeProfileList;
			    		}
			    	}
				}
			}else{
				//throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
				throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0216")));
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService2:getEmployeeProfileByPrefixEngName", e);
			//throw new IPFMBusinessException(IPFMDataUtility.buildMessage(e.getMessage()));
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
		}
		return profile;
	}
	
	public String callRestWS(String doamin, String user, String pass, String json) throws IOException, IPFMBusinessException {
		String res = "";
		
//	    String d = "corp-ais900dev";
//	    String u = "ehrapp_stg";
//	    String p = "Ais#2014";
		
//		String json = "{\"methodName\":\"OM_WS_RPA_GetEmployeeProfileByEmail\",\"omCode\":\"OMTESTIPFM\",\"parameterList\":[{\"name\":\"Email\",\"value\":\"48437@%\"}],\"transactionID\":\"6853e3c6-3020-49e1-a675-59681bf8d8e5\"}";

		
		HttpClient httpclient = new HttpClient();
		SSLUtils.trustAllSSLCertificates();
		CredentialsUtils.setNTLMCredentials(httpclient, new UsernamePasswordCredentials(user, pass), doamin);
		
//		PostMethod post = new PostMethod("https://test-omws.ais.co.th/omworkdayws/api/WS_OM_OMService.svc/queryProfileData");
		PostMethod post = new PostMethod(endpoint);

	    StringRequestEntity entity = new StringRequestEntity(json);
	    post.setRequestEntity(entity);
	    post.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	    
	    try { 
		    httpclient.executeMethod(post);
		    
		    // for debug
		    System.out.println(post.getStatusLine());
		    System.out.println("Request Headers : ");
		    for(Header h : post.getRequestHeaders()) System.out.println("> " + h.getName() + " : " + h.getValue());
		    System.out.println("\nResponse Headers : ");
		    for(Header h : post.getResponseHeaders()) System.out.println("> " + h.getName() + " : " + h.getValue());
		    System.out.println("Response Body : \n" + post.getResponseBodyAsString());
		    
		    
		    if("HTTP/1.1 200 OK".equals(post.getStatusLine().toString())) {
		    	res = post.getResponseBodyAsString();
		    } else {
		    	//throw new IPFMBusinessException(post.getStatusLine().toString());
		    	throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
		    }
		} finally {
			post.releaseConnection();
		}
	    
		return res;	
	}
	
}
