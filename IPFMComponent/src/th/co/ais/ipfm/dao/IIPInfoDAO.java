package th.co.ais.ipfm.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPLevel3NatHistory;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPInfoDAO  extends IGenericDao<IpInfo, Long>{
	public IpInfo findIpInfo(String startIP);
	public List<IpInfo> searchIpInfo(String ipAddress, String tier2TeamId, String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws DataAccessException;
	public int countSearchIP(IpInfo inInfo,IpUser ipUser) throws DataAccessException;
	public List<IpInfo> searchIP(IpInfo ipInfo,IpUser ipUser) throws DataAccessException;
	public IpInfo getIpInfo(String ipAddress) throws DataAccessException;
	public String getOwnerIP(String ip);
	public IpUser getIpTeamOwner(String teamID);
	public IpInfo checkIPRange23SearchL1(IpInfo ipInfo) throws Exception;
	public IpInfo findIpInfo(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4) throws Exception;
	public BigDecimal checkIpInfoTotalAvailable(IpInfo ipInfo) throws Exception;
	public List<IpInfo> findIpInfoAssignIp(String binary2Start,String binary2End) throws DataAccessException;
	public Integer searchIPTotalRec(IpInfo ipInfo, IpUser ipUser) throws DataAccessException;
	public void deleteIpLevel3ByLv2(String level2Id) throws DataAccessException;
	public String validateOverExpire(String level2Id, String expiredDate) throws DataAccessException;
	public void deleteIpLevel3ByLevel1Id(String level1Id) throws DataAccessException;
	public void insertIpInfoHistoryByLevel1Id(String level1Id,Date updateDate, String updateBy) throws DataAccessException;
	public void insertIpInfoHistoryByLevel2Id(String level2Id,Date updateDate, String updateBy) throws DataAccessException;
	public int findIpinfo(String ipStart,String ipEnd) throws DataAccessException;
	public int findIpinfoWithUsedStatus(String ipStart,String ipEnd) throws DataAccessException;
	public int findTier2TeamID(String ipStart,String ipEnd) throws DataAccessException;
	public int findTier2TeamIDWithUsedStatus(String ipStart,String ipEnd) throws DataAccessException;
	public int findSystemOwnerTeamID(String ipStart,String ipEnd) throws DataAccessException;
	public int findSystemOwnerTeamIDWithUsedStatus(String ipStart,String ipEnd) throws DataAccessException;
	public IpInfo findIpInfoWithStatus(String ipAddress,String[] status) throws DataAccessException;
	public int countIpInfoStatusNotUsed(String binaryIpStart, String binaryIpEnd)throws DataAccessException;
	public List<IpInfo> findIpInfoStatusNotUsed(String binaryIpStart, String binaryIpEnd)throws DataAccessException;
	public List<IpInfo> findIpInfoByHostName(String hostName) throws DataAccessException;
	public IpInfo findIpInfoByWCHUNodeName(String watchingUNameName) throws DataAccessException;
	public List<IpInfo> findIpInfoByVlan(IpInfo ipInfo) throws DataAccessException;
	public List<String> getLv2TeamMemberByIP(String ip) throws DataAccessException;
	public List<String> getLv1TeamMemberByIP(String ip) throws DataAccessException;
	public void updateNatIP(String ip,String natIP) throws DataAccessException;
	public void insertNatHistory(List<IPLevel3NatHistory> natHisList) throws DataAccessException;
}
