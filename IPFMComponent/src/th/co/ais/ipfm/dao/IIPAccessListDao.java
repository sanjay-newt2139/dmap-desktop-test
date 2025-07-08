package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListCdnId;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPAccessListDao extends IGenericDao<IpUrAccessListCdn, Long>{
	public String getSubUrNo(String urNo);
	public IpUrAccessListCdn getID(IpUrAccessListCdnId id);
	public List<IpUrAccessListCdn> findByURNo(String urno);
	public void cancelImpact(String urNo);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void updateSubUrStatus(IpUrAccessListCdnId id, String status,IpUser user);
	
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrAccessListCdn> waitDeleteUr(String urNo);
	public IpUrAccessListCdn findIpUrAccessList(String urno,String subUrNo );
}
