package th.co.ais.ipfm.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpLevel2;



public interface IPLevel2Dao extends IGenericDao<IpLevel2, Long>{

	public String getLevel2_ID() throws DataAccessException;
	public List<IpLevel2> searchBinaryStartBetweenDate(String binaryIp) throws DataAccessException;
	public List<IpLevel2> searchBinaryStartBetweenDate(String binaryIp,String teamId) throws DataAccessException;
	public List<IpLevel2> searchBinaryEndBetweenDate(String binaryIp) throws DataAccessException;	
	public List<IpLevel2> searchBinaryEndBetweenDate(String binaryIp,String teamId) throws DataAccessException;
	public List<IpLevel2> searchBinaryRange(String binaryStart,String binaryEnd,Integer maxSearchResult) throws DataAccessException;
	public List<IpLevel2> searchBinaryRange(String binaryStart,String binaryEnd,String teamId,Integer maxSearchResult) throws DataAccessException;
	public List<IpLevel2> findAllIpLevel2(Integer maxSearchResult) throws DataAccessException;
	public List<IpLevel2> findIpLevel2ByTeam(String teamId,Integer maxSearchResult) throws DataAccessException;
	public BigDecimal checkIpLevel2TotalNotAvailable(String binarySt,String binaryEd) throws DataAccessException;
	public IpLevel2 findIpLevel2ByLevel2Id(String level2Id) throws DataAccessException;
	public String validateOverExpireLevel1(String level1Id, String expiredDate) throws DataAccessException;
	public void insertHistoryByLevel1Id(String level1Id,Date updateDate,String updateBy) throws DataAccessException;
	public void deleteIpLevel2ByLevel1Id(String level1Id) throws DataAccessException;
	public void insertHistoryByLevel2Id(String level2Id,Date updateDate,String updateBy) throws DataAccessException;
}
