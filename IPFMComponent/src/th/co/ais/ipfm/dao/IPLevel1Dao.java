package th.co.ais.ipfm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpLevel1;



public interface IPLevel1Dao extends IGenericDao<IpLevel1, Long>{

	public String getLevel1_ID() throws DataAccessException;
	public List<IpLevel1> searchBinaryStartBetweenDate(String binaryIp,String teamId) throws DataAccessException;
	public List<IpLevel1> searchBinaryEndBetweenDate(String binaryIp,String teamId) throws DataAccessException;	
	public List<IpLevel1> searchBinaryRange(String binaryStart,String binaryEnd,String teamId) throws DataAccessException;
	public List<IpLevel1> findAllIpLevel1(Integer maxSearchResult) throws DataAccessException;
	public void updateTotalT2Assign(String level1Id, Integer totalIp, String userId) throws DataAccessException;
	public IpLevel1 findIpLevel1ByLevel1Id(String level1Id) throws DataAccessException;
	public List<IpLevel1> findIpLevel1ByTeam(String teamId, Integer maxSearchResult) throws DataAccessException;
	public void insertHistoryByLevel1Id(String level1Id,Date updateDate,String updateBy) throws DataAccessException;
	public List<IpLevel1> searchStartIpBetweenBinaryStartEndWithTeam2(String binaryStartIp, String binaryEndIp,String teamId) throws DataAccessException;
	public List<IpLevel1> searchBySubIpMaskWithTeam(String subDigitIp, int mark, String teamId) throws DataAccessException;
}
