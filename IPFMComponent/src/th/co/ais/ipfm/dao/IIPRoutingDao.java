package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUrRouting;
import th.co.ais.ipfm.domain1.IpUrRoutingId;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPRoutingDao extends IGenericDao<IpUrRouting, Long>{
	public String getSubUrNo(String urNo);
	public IpUrRouting getID(IpUrRoutingId id);
	public List<IpUrRouting> findByURNo(String urno);
	public void cancelImpact(String urNo);
	public List<IpMasterTable> getProperty(String refTable);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void updateSubUrStatus(IpUrRoutingId id, String status,IpUser user);
	
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrRouting> waitDeleteUr(String urNo);
	public IpUrRouting fineIpUrRouting(String urNo,String subUrNo);
}
