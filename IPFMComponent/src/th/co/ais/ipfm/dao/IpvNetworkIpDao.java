package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpvNetworkIp;



public interface IpvNetworkIpDao extends IGenericDao<IpvNetworkIp, Long>{
	public List<IpvNetworkIp> searhNetworkIpByTier1(Integer maxSearchResult) throws DataAccessException;
	public List<IpvNetworkIp> searhNetworkIpRangeByTier1(String binaryIpStart, String binaryIpEnd, Integer maxSearchResult) throws DataAccessException;
	public List<IpvNetworkIp> searhNetworkIpByTier2(String tier2TeamId, String userId ,Integer maxSearchResult) throws DataAccessException;
	public List<IpvNetworkIp> searhNetworkIpRangeByTier2(String binaryIpStart, String binaryIpEnd, String tier2TeamId, String userId ,Integer maxSearchResult) throws DataAccessException;
	public List<IpvNetworkIp> searhNetworkIpByTier3(String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws DataAccessException;
	public List<IpvNetworkIp> searhNetworkIpRangeByTier3(String binaryIpStart, String binaryIpEnd, String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws DataAccessException;
}
