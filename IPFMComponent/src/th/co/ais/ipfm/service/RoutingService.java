package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrRouting;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface RoutingService {
	public IpInfo getIPInfo(String ip);
	public String genSubUrNo(String urNo);
	public void saveOrUpdate(IpUrRouting routing) throws IPFMBusinessException;
	public List<IpUrRouting> findByUrNo(String urNo);
	public List<IpMasterTable> getProperty(String refTable);
	
	public IpUrRouting changeUrNo(IpUrRouting tempUr,String urNO);
	public void update(IpUrRouting routing);
	public void deleteByUrNo(String urNo) throws IPFMBusinessException;
	public void delete(IpUrRouting urNo);
	public void delete(String urNo, String subUrNo);
	public IpUrRouting findFirewall(String urNo, String subUrNo);
	
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
	public IpInfo getIPInfoUsedStatus(String ip) throws IPFMBusinessException;
	
}
