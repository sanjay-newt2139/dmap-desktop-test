package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface SendIPExpireWarningService {
	public String getTeamName(String teamId);	
	public String getTeamNameLevel2(String teamId);
	public String getTeamNameLevel2TeamAssign(String teamId);	
	public String getConditionDate();
	public List<String> getListTeam(String conditionDate);
	public List<String> getListTeamLevel2(String conditionDate) throws IPFMBusinessException;
	public List<String> getListTeamLevel2ForAssignTeam(String conditionDate) throws IPFMBusinessException;
	public List<String> getListEmail(String teamId);
	public List<String> getListIP(String conditionDate, String teamId);
	public String getExpireDate(String conditionDate, String teamId);
	public String getExpireDateLevel2(String conditionDate, String teamId);
	public String getExpireDateLevel2TeamAssign(String conditionDate, String teamId);
	public List<String> getListExpireIPInfo3Digit(String conditionDate, String teamId) throws IPFMBusinessException;
	public List<String> getListExpireIPLevel2(String conditionDate, String teamId) throws IPFMBusinessException;
	public List<String> getListExpireIPLevel2ForAssignTeam(String conditionDate, String teamId) throws IPFMBusinessException;
	
}
