package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface PhyInterfaceService {
	public IpInfo getIPInfo(String ip);
	public IpInfo getIPInfoWithUsedStatus(String ip);
	public String genSubUrNo(String urNo);
	public void saveOrUpdate(IpUrPhysicalInterface phyIntf);
	public List<IpUrPhysicalInterface> findByUrNo(String urNo);
	public List<IpMasterTable> getProperty(String refTable);
	
	public IpUrPhysicalInterface changeUrNo(IpUrPhysicalInterface tempUr,String urNO);
	public void update(IpUrPhysicalInterface phyInterface);
	public void deleteByUrNo(String urno) throws IPFMBusinessException;
	public void delete(IpUrPhysicalInterface intf);
	public void delete(String urNo, String subUrNo);
	public IpUrPhysicalInterface findPhyInterface(String urNo, String subUrNo);
	
	public String getIntfNodeTypeId(String desc);
	public String getStatusId(String desc);
	public String getSpeedPortId(String desc);
	
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
	
	public boolean hasProperty(String type,String refTable);
	
}
