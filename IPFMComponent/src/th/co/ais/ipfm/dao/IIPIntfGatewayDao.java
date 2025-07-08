package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrInterfaceGatewayId;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPIntfGatewayDao extends IGenericDao<IpUrInterfaceGateway, Long>{
	public String getSubUrNo(String urNo);
	public IpUrInterfaceGateway getID(IpUrInterfaceGatewayId id);
	public List<IpUrInterfaceGateway> findByURNo(String urno);
	
	public List<IpMasterTable> getProperty(String refTable);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void cancelImpact(String urNo);
	public String getNetworkTypeId(String desc);
	public void updateSubUrStatus(IpUrInterfaceGatewayId id, String status,IpUser user);
	public boolean hasNetworkType(String type);
	
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrInterfaceGateway> waitDeleteUr(String urNo);
	public IpUrInterfaceGateway fineIpUrInterfaceGateway(String urNo,String subUrNo);
}
