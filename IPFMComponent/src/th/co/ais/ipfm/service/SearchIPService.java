package th.co.ais.ipfm.service;


import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;

public interface SearchIPService {
	
	public SearchResult searchIP(IpInfo ipInfo,IpUser ipUser) throws IPFMBusinessException;
	public String getV_UserPermission(String userId) throws IPFMBusinessException;
	public IpUrIpResult checkIPRange(String  IpDigit1,String IpDigit2,String IpDigit3,String IpDigit4,String mask) throws IPFMBusinessException;
	public IpInfo getIpInfo(String ipAddress) throws IPFMBusinessException;
	public Integer getSeachIPTotalRec(IpInfo ipInfo, IpUser ipUser) throws IPFMBusinessException;
	public List<IpInfo> findIpInfoByHostName(String hostName) throws IPFMBusinessException;
	public IpInfo findIpInfoByWYNodeName(String wyNodeName) throws IPFMBusinessException;
	
}
