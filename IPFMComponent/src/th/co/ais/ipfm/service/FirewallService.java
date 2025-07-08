package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain.NCAssign;
import th.co.ais.ipfm.domain.NCData;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface FirewallService {
	public IpInfo getIPInfo(String ip);
	public IpInfo getIPInfoWithUsedStatus(String ip);
	public String genSubUrNo(String urNo);
	public List<IpMasterTable> getService();
	public IpMasterTable getServiceByRefID(String refNo);
	public void saveOrUpdate(IpUrFirewall firewall);
	public List<IpUrFirewall> findByUrNo(String urNo);
	public IpUrFirewall changeUrNo(IpUrFirewall tempUr,String urNO);
	public void updateFirewall(IpUrFirewall firewall);
	public void deleteByUrNo(String urNo)throws IPFMBusinessException;
	public void delete(IpUrFirewall firewall);
	public void delete(String urNo, String subUrNo);
	public IpUrFirewall findFirewall(String urNo, String subUrNo);
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
	
	
	// Old Part
	public List<IpUrFirewall> listFirewall();
	public List<NCData> listResultByPage(String type,String page);
	public List<NCAssign> listAssign(String page);
	public NCData findUR(String type, String page,String urSubID);
	public void updateFirewallSubUrStatus(IpUrFirewall ipUrFirewall)throws IPFMBusinessException;
	public int  fineIpinfo(String ipStart,String ipEnd);
	public int  findTier2TeamID(String ipStart,String ipEnd);
	public int  findSystemOwnerTeamID(String ipStart,String ipEnd);
	public List<IpInfo> findIpInfoAssignIp(String binary2Start,String binary2End) throws IPFMBusinessException;
	public int  countIpInfoStatusNotUsed(String binaryIpStart,String binaryIpEnd);
	public List<IpInfo>  findIpInfoStatusNotUsed(String binaryIpStart,String binaryIpEnd);
}
