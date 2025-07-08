package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpUrAccessListTnpId;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPAccessListTNPDao extends IGenericDao<IpUrAccessListTnp, Long>{
	public String getSubUrNo(String urNo);
	public IpUrAccessListTnp getID(IpUrAccessListTnpId id);
	public List<IpUrAccessListTnp> findByURNo(String urno);
	public void cancelImpact(String urNo);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void updateSubUrStatus(IpUrAccessListTnpId id, String status,IpUser user);
	
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrAccessListTnp> waitDeleteUr(String urNo);
	public IpUrAccessListTnp findIpUrAccessListTnp(String urNo,String subUrNo);
}
