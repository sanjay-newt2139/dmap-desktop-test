package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface IntfGatewayService {
	public IpInfo getIPInfo(String ip);
	public IpInfo getIPInfoWithUsedStatus(String ip);
	public String genSubUrNo(String urNo);
	public void saveOrUpdate(IpUrInterfaceGateway gateway);
	public List<IpUrInterfaceGateway> findByUrNo(String urNo);
	public List<IpMasterTable> getProperty(String refTable);
	
	public IpUrInterfaceGateway changeUrNo(IpUrInterfaceGateway tempUr,String urNO);
	public void update(IpUrInterfaceGateway gateway);
	public void deleteByUrNo(String urNo)  throws IPFMBusinessException;
	public void delete(IpUrInterfaceGateway gateway);
	public void delete(String urNo, String subUrNo);
	public IpUrInterfaceGateway findFirewall(String urNo, String subUrNo);
	
	public String getNetworkTypeId(String desc); 
	public boolean hasNetworkType(String type);
	
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
}
