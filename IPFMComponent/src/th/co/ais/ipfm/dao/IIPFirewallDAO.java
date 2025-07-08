package th.co.ais.ipfm.dao;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.ipfm.domain.NCAssign;
import th.co.ais.ipfm.domain.NCData;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUser;

public interface IIPFirewallDAO  extends IGenericDao<IpUrFirewall, Long>{
	public String genSubUrno(String urNo);
	public List<IpMasterTable> getServiceName();
	public IpMasterTable getServiceNameByRefId(String refId);
	public List<IpUrFirewall> findByUrNo(String urNo);
	public IpUrFirewall findByKey(IpUrFirewallId id);
	public void cancelImpact(String urNo);
	public void deleteByUrNo(String urNo);
	public void delete(String urNo, String subUrNo);
	public void updateSubUrStatus(IpUrFirewallId id,String status,IpUser user);
	public void commitSubURUpdate(String urNo,String changeType);
	public void commitSubURDelete(String urNo,String changeType);
	public List<IpUrFirewall> waitDeleteUr(String urNo);
	
	// this is old function 
	public List<IpUrFirewall> listFirewall();
	public List<NCData> listResultByPage(String type,String page);
	public List<NCAssign> listAssign(String page);
	public NCData findUR(String type, String page,String urSubID);
	public List<IpUrFirewall> findByUrNoSubUr(String urNo,String subUrNo);
	public IpUrFirewall findIpUrFirewall(String urNo,String subUrNo);
}
