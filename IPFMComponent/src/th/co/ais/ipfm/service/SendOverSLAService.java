package th.co.ais.ipfm.service;

import java.util.List;

public interface SendOverSLAService {
	
	public String getSMSNo(String urType)throws Exception;
	public String getSMSWording(String refKey)throws Exception;
	public List<String> listUROverSLA(String refKey, String urType)throws Exception;
	public void updateSendSMS(String urType, String urNo)throws Exception;	
	
}
