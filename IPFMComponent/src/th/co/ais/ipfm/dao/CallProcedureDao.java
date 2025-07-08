package th.co.ais.ipfm.dao;

import java.util.Map;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpLevel2;


public interface CallProcedureDao {
	public IpLevel1 getIpLevel1StartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception;
	public IpLevel2 getIpLevel2StartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception;
	public IpInfo getIpInfoStartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception;
	public String checkIsTnp(String urNo) throws Exception;
	public void processIpLevel2(String ip1, String ip2, String ip3, String ip4, String mask, String teamId) throws Exception;
	public Map verifyImportLv3(String username, String userRole) throws Exception;
	public void updateImportLv3(String username) throws Exception;
	public void updateTrunkFlag(String urNo, String type) throws Exception;
}