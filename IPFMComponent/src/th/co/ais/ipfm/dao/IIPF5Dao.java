package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrF5Id;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvRetriveF5;

public interface IIPF5Dao extends IGenericDao<IpUrF5, Long>{
	public String getSubUrNo(String urNo);
	public IpUrF5 getID(IpUrF5Id id);
	public List<IpUrF5> findByURNo(String urno);
	
	public List<IpMasterTable> getProperty(String refTable);
	
	public List<IpvRetriveF5> retriveF5(String vip, String port, String urNo);
	public void cancelImpact(String urNo);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void updateSubUrStatus(IpUrF5Id id, String status,IpUser user);
	
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrF5> waitDeleteUr(String urNo);
	public IpUrF5 fineIpUrF5(String urNo,String subUrNo);
}
