package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface AccessListService {
	public IpInfo getIPInfo(String ip);
	public IpInfo getIPInfoWithUsedStatus(String ip);
	public String genSubUrNo(String urNo);
	public IpUrAccessListCdn saveOrUpdate(IpUrAccessListCdn cdn);
	public List<IpUrAccessListCdn> findByUrNo(String urNo);
	
	public void cleanSubUR(String urNo);
	public void commitSubUR(String urNo);
	
	public IpUrAccessListCdn changeUrNo(IpUrAccessListCdn tempUr,String urNO);
	public void save(IpUrAccessListCdn cdn);
	public void update(IpUrAccessListCdn cdn) throws IPFMBusinessException;
	public void deleteByUrNo(String urNo) throws IPFMBusinessException ;
	public void delete(IpUrAccessListCdn cdn);
	public void delete(String urNo, String subUrNo);
	public IpUrAccessListCdn findAccessListCdn(String urNo,String subUrNo);
	public int  fineIpinfo(String ipStart,String ipEnd);
	public int  findTier2TeamID(String ipStart,String ipEnd);
	public int  findSystemOwnerTeamID(String ipStart,String ipEnd);
	public List<IpInfo> findIpInfoAssignIp(String binary2Start,String binary2End) throws IPFMBusinessException;
	
	
}
