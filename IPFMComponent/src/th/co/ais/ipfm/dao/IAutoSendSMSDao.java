package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpWfConfig;

public interface IAutoSendSMSDao extends IGenericDao<IpWfConfig, Long>{
	public String getSMSNo(String urType);
	public String getSMSWording(String refKey);
	public List<String> getIPUROverSLAList(String urType);
	public List<String> getNCUROverSLAList();
	public void updateIPURNo(String urNo);
	public void updateNCURNo(String urNo);
	
}
