package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrF5Id;
import th.co.ais.ipfm.domain1.IpvRetriveF5;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface F5Service {
	public IpInfo getIPInfo(String ip);
	public IpInfo getIPInfoWithStatus(String ip);
	public String genSubUrNo(String urNo);
	public void saveOrUpdate(IpUrF5 f5);
	public List<IpUrF5> findByUrNo(String urNo);
	public List<IpMasterTable> getProperty(String refTable);
	
	public List<IpvRetriveF5> retriveF5(String vip, String port, String urNo);
	public IpUrF5 getF5ById(IpUrF5Id id);
	
	public IpUrF5 changeUrNo(IpUrF5 tempUr,String urNO);
	public void update(IpUrF5 f5);
	
	public void deleteByUrNo(String urNo)throws IPFMBusinessException;
	public void delete(IpUrF5 f5);
	public void delete(String urNo, String subUrNo);
	public IpUrF5 findFirewall(String urNo, String subUrNo);
	
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
	
}
