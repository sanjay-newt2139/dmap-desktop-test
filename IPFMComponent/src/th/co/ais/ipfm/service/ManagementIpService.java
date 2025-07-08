package th.co.ais.ipfm.service;

import java.util.HashMap;
import java.util.List;

import th.co.ais.ipfm.domain.IPLevel3NatHistory;
import th.co.ais.ipfm.domain.IPMasterValue;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpInfoHistory;
import th.co.ais.ipfm.domain1.IpInfoTemp;
import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpLevel2;
import th.co.ais.ipfm.domain1.IpLevel2History;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpvNetworkIp;
import th.co.ais.ipfm.domain1.IpLogVerify;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface ManagementIpService {
	public String getSysdate() throws IPFMBusinessException;
	public List<IpRoleMember> findIpRoleMemberByUserId(String userId) throws IPFMBusinessException;
	public List<IpLevel1> findAllIpLevel1(Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpLevel2> findAllIpLevel2(Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpLevel2> findIpLevel2ByTeam(String teamId, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpLevel1> searchIpManagementLevel1(String ipVersion, String ip1, String ip2, String ip3, String ip4, String mask, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpLevel1> searchIpManagementLevel1ByTeam(String ipVersion, String ip1, String ip2, String ip3, String ip4, String mask, String teamId, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpLevel2> searchIpManagementLevel2(String ipVersion, String ip1, String ip2, String ip3, String ip4, String mask, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpLevel2> searchIpManagementLevel2ByTeam(String ipVersion, String ip1, String ip2, String ip3, String ip4, String mask, String teamId, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpInfo> searchIpManagementLevel3(String ipAddress, String tier2TeamId, String sysOwnerTeamId, String sysOwnerId, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpvNetworkIp> searhNetworkIpByTier1(Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpvNetworkIp> searhNetworkIpByTier2(String tier2TeamId,String userId,Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpvNetworkIp> searhNetworkIpByTier3(String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpvNetworkIp> searhNetworkIpRangeByTier1(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4, String mask, Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpvNetworkIp> searhNetworkIpRangeByTier2(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4, String mask, String tier2TeamId,String userId,Integer maxSearchResult) throws IPFMBusinessException;
	public List<IpvNetworkIp> searhNetworkIpRangeByTier3(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4, String mask, String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws IPFMBusinessException;
	public IpLevel1 saveIpLevel1(IpLevel1 ipLevel1, String updateBy) throws IPFMBusinessException;
	public IpLevel2 saveIpLevel2(IpLevel2 ipLevel2, String updateBy) throws IPFMBusinessException;
	public IpInfo updateIpInfo(String oldIpStatus, IpInfo ipInfo, String updateBy) throws IPFMBusinessException;
	public IpInfoHistory copyIpInfoHistory(IpInfo ipInfo) throws IPFMBusinessException;
	public void updateIpLevel2ExpireDate(List<IpLevel2> ipLevel2List) throws IPFMBusinessException;
	public void updateIpInfoExpireDate(List<IpInfo> ipInfoList) throws IPFMBusinessException;
	public void ipInfoAssignToPlanning(IpInfo ipInfo,String updateBy) throws IPFMBusinessException;
	public void ipLevel2AssignToAvailable(IpLevel2 ipLevel2) throws IPFMBusinessException;
	public List<IpLevel1> findIpLevel1ByTeam(String teamId,Integer maxSearchResult) throws IPFMBusinessException;
	public IpLevel2History copyIpLevel2History(IpLevel2 bean) throws IPFMBusinessException;
	public IpTeam findIpTeamById(String teamId) throws IPFMBusinessException;
	public boolean validateOverExpire(String level2Id, String expiredDate) throws IPFMBusinessException;
	public boolean validateOverExpireLevel1(String level1Id, String format) throws IPFMBusinessException;
	
	public void saveIpLevel2(List<IpLevel2> ipLevel2List, String updateBy) throws IPFMBusinessException;
	public void updateIpInfo(List<IpInfo> ipInfoList, String updateBy) throws IPFMBusinessException;
	public List<IpInfo> checkDupVlan(IpInfo ipInfo) throws IPFMBusinessException;
	public HashMap verifyIpInfoTemp(List<IpInfoTemp> ipInfoTempList,String username,String userRole) throws IPFMBusinessException;
	public List<IpLogVerify> findIpLogVerifyByUsername(String username) throws IPFMBusinessException;
	public void saveImportIpLv3(String username)  throws IPFMBusinessException;
	public boolean deleteAndInsertIpInfoTemp (List<IpInfoTemp> ipInfoTempList,String username) throws IPFMBusinessException;
	public boolean checkPermissionUpdateNatIP(String userId,String ip) throws IPFMBusinessException;
	public void insertLogVerify(String ip,String type,String msg ,String username)  throws IPFMBusinessException;
	public void updateNatIP(String ip,String natIP)  throws IPFMBusinessException;
	public IPLevel3NatHistory validateInsertNatHis(String ip,String natIP,String username)  throws IPFMBusinessException;
	public void insertNatHistory(List<IPLevel3NatHistory> hisList)  throws IPFMBusinessException;
	public List<IPMasterValue> getMasterList(String group) throws IPFMBusinessException;
}
