package th.co.ais.sso.service;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.exception.IPFMBusinessException;
import Permission.bean.ais.com.SSOResponse;

import com.ais.websrv.EmployeeServiceWebServiceV2Proxy;

public class SSOService {
	private String endpoint;
	private String module;
	private String ouType;
	private String projectCode;
	private static final Logger logger = Logger.getLogger(SSOService.class);
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public void setOuType(String ouType) {
		this.ouType = ouType;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public SSOResponse getToken(String username, String password) throws IPFMBusinessException{
		SSOResponse response = null;
		try {
			response = getToken(username, password, module, ouType, projectCode);
		} catch (Exception e) {
			logger.error("SSOService:getToken!", e);
			throw new IPFMBusinessException("SSOService:getToken");
		}
		return response;
	}
	public SSOResponse getToken(String username, String password, String module, String ouType, String projectCode) throws IPFMBusinessException{
		SSOResponse response = null;
		try {
			EmployeeServiceWebServiceV2Proxy ssoService = new EmployeeServiceWebServiceV2Proxy();
			ssoService.setEndpoint(endpoint);
			response = ssoService.getToken(username, password, module, ouType, projectCode);
		} catch (Exception e) {
			logger.error("SSOService:getToken!", e);
			throw new IPFMBusinessException("SSOService:getToken");
		}
		return response;
	}
	

}
