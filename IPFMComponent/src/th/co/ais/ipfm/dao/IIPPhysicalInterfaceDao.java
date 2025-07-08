package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterfaceId;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPPhysicalInterfaceDao extends IGenericDao<IpUrPhysicalInterface, Long>{
	public String getSubUrNo(String urNo);
	public IpUrPhysicalInterface getID(IpUrPhysicalInterfaceId id);
	public List<IpUrPhysicalInterface> findByURNo(String urno);
	
	public List<IpMasterTable> getProperty(String refTable);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void cancelImpact(String urNo);
	public String getIntfNodeTypeId(String desc);
	public String getStatusId(String desc);
	public String getSpeedPortId(String desc);
	public void updateSubUrStatus(IpUrPhysicalInterfaceId id, String status,IpUser user);
	
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrPhysicalInterface> waitDeleteUr(String urNo);
	
	public boolean hasProperty(String type,String refTable);
	public IpUrPhysicalInterface findIpUrPhysicalInterface(String urno,String subUrNo);
}
