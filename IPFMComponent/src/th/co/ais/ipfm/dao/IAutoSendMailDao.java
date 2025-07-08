package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IAutoSendMailDao extends IGenericDao<IpInfo, Long>{
	public String getTeamName(String teamId);
	public String getTeamNameLevel2(String teamId) throws DataAccessException;
	public String getTeamNameLevel2TeamAssign(String teamId) throws DataAccessException;
	public String getConditionDate();
	public List<String> getListTeam(String conditionDate);
	public List<String> getListTeamLevel2(String conditionDate) throws DataAccessException;
	public List<String> getListTeamLevel2ForAssignTeam(String conditionDate) throws DataAccessException;	
	public List<String> getListEmail(String teamId);
	public List<String> getListIP(String conditionDate, String teamId);
	public String getExpireDate(String conditionDate, String teamId);
	public String getExpireDateLevel2(String conditionDate, String teamId);
	public String getExpireDateLevel2TeamAssign(String conditionDate, String teamId);	
	public List<String> getListExpireIPInfo3Digit(String conditionDate, String teamId) throws DataAccessException;
	public List<String> getListExpireIPLevel2(String conditionDate, String teamId) throws DataAccessException;
	public List<String> getListExpireIPLevel2ForAssignTeam(String conditionDate, String teamId) throws DataAccessException;	
	
}
