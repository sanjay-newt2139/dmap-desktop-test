package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface AccessListTNPService {
	public IpInfo getIPInfo(String ip);
	public IpInfo getIPInfoWithUsedStatus(String ip);
	public String genSubUrNo(String urNo);
	public void saveOrUpdate(IpUrAccessListTnp tnp);
	public List<IpUrAccessListTnp> findByUrNo(String urNo);
	
	public IpUrAccessListTnp changeUrNo(IpUrAccessListTnp tempUr,String urNO);
	public void update(IpUrAccessListTnp tnp);
	public void deleteByUrNo(String urNo)throws IPFMBusinessException;
	public void delete(IpUrAccessListTnp tnp);
	public void delete(String urNo, String subUrNo);
	public IpUrAccessListTnp findAccessListTnp(String urNo, String subUrNo);
	
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
	
}
