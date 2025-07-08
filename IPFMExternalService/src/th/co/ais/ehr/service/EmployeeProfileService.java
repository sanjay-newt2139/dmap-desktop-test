package th.co.ais.ehr.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.tempuri.WS_OM_OMEHRServicesSoapProxy;

import th.co.ais.ehr.domain.Approver;
import th.co.ais.ehr.domain.DiffgramApprover;
import th.co.ais.ehr.domain.DiffgramEmployeeProfile;
import th.co.ais.ehr.domain.EmployeeProfile;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;

public class EmployeeProfileService {

	private static final Logger logger = Logger.getLogger(EmployeeProfileService.class);
	private String username;
	private String password;
	private String endpoint;
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Approver> listAllApprover(String pin, String position) throws IPFMBusinessException {
		List<Approver> aprList = null;
		try {
			if(endpoint!=null && username!=null && password!=null){
				WS_OM_OMEHRServicesSoapProxy proxy = new WS_OM_OMEHRServicesSoapProxy(endpoint, username, password);
				org.tempuri.ListAllApproverResponseListAllApproverResult result =  proxy.listAllApprover(pin, position);
				if(result!=null && result.get_any()!=null && result.get_any().length>1 && (result.get_any()[1])!=null && (result.get_any()[1]).getAsString()!=null){
					//System.out.println((result.get_any()[1]).getAsString());
					DiffgramApprover diff = EHRXMLUtil.parserApproverMSXML((result.get_any()[1]).getAsString());					
					if(diff!=null && diff.getNewDataSet()!=null){
						aprList = diff.getNewDataSet().getApprovers();
					}
				}
			}else{
				throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
			}
		} catch (IPFMBusinessException ie){
			throw ie;
		} catch (Exception e) {
			logger.error("EmployeeProfileService:listAllApprover", e);
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
//			throw new IPFMBusinessException("EmployeeProfileService:listAllApprover");
		}
		return aprList; 
	}	
	
	public List<EmployeeProfile> getEmployeeProfilesByEmail(String email) throws IPFMBusinessException {
		List<EmployeeProfile> empList = null;
		try {
			if(endpoint!=null && username!=null && password!=null){
				WS_OM_OMEHRServicesSoapProxy proxy = new WS_OM_OMEHRServicesSoapProxy(endpoint, username, password);
				org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult result =  proxy.getEmployeeProfileByEmail(email);
				if(result!=null && result.get_any()!=null && result.get_any().length>1 && (result.get_any()[1])!=null && (result.get_any()[1]).getAsString()!=null){
					System.out.println((result.get_any()[1]).getAsString());
					DiffgramEmployeeProfile diff = EHRXMLUtil.parserEmployeeMSXML((result.get_any()[1]).getAsString());
					if(diff!=null && diff.getNewDataSet()!=null){
						empList = diff.getNewDataSet().getEmployeeProfiles();
					}
				}
			}else{
				throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService:getEmployeeProfilesByEmail", e);
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
//			throw new IPFMBusinessException("EmployeeProfileService:getEmployeeProfilesByEmail");
		}
		return empList; 
	}
	
	public List<EmployeeProfile> getEmployeeProfilesByPIN(String pin) throws IPFMBusinessException {
		List<EmployeeProfile> empList = null;
		try {
			if(endpoint!=null && username!=null && password!=null){
				WS_OM_OMEHRServicesSoapProxy proxy = new WS_OM_OMEHRServicesSoapProxy(endpoint, username, password);
				org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult result =  proxy.getEmployeeProfile(pin);
				if(result!=null && result.get_any()!=null && result.get_any().length>1 && (result.get_any()[1])!=null && (result.get_any()[1]).getAsString()!=null){
					System.out.println((result.get_any()[1]).getAsString());
					DiffgramEmployeeProfile diff = EHRXMLUtil.parserEmployeeMSXML((result.get_any()[1]).getAsString());
					if(diff!=null && diff.getNewDataSet()!=null){
						empList = diff.getNewDataSet().getEmployeeProfiles();
					}
				}
			}else{
				throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService:getEmployeeProfilesByPIN", e);
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
//			throw new IPFMBusinessException("EmployeeProfileService:getEmployeeProfilesByPIN");
		}
		return empList; 
	}	
	
	public List<EmployeeProfile> GetEmployeeProfileByPrefixEngName(String engName) throws IPFMBusinessException {
		List<EmployeeProfile> empList = null;
		try {
			if(endpoint!=null && username!=null && password!=null){
				WS_OM_OMEHRServicesSoapProxy proxy = new WS_OM_OMEHRServicesSoapProxy(endpoint, username, password);
				org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult result =  proxy.getEmployeeProfileByPrefixEngName(engName);
				if(result!=null && result.get_any()!=null && result.get_any().length>1 && (result.get_any()[1])!=null && (result.get_any()[1]).getAsString()!=null){
//					System.out.println((result.get_any()[1]).getAsString());
					DiffgramEmployeeProfile diff = EHRXMLUtil.parserEmployeeMSXML((result.get_any()[1]).getAsString());
					if(diff!=null && diff.getNewDataSet()!=null){
						empList = diff.getNewDataSet().getEmployeeProfiles();
					}
				}
			}else{
				throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
//				throw new IPFMBusinessException("EmployeeProfileService:Required Endpoint, UserName, Password!");
			}
		} catch (IPFMBusinessException ie){
			throw ie;			
		} catch (Exception e) {
			logger.error("EmployeeProfileService:getEmployeeProfilesByUsername", e);
			throw new IPFMBusinessException(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0027")));
//			throw new IPFMBusinessException("EmployeeProfileService:getEmployeeProfilesByUsername");
		}
		return empList; 
	}		
}
