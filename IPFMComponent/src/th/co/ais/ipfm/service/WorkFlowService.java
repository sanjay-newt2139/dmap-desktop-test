package th.co.ais.ipfm.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpWfConfig;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;
import th.co.ais.ipfm.exception.IPFMBusinessException;



public interface WorkFlowService {
	
	public List<IpWfConfigDetail> getIpWfConfigDetailList(String urType) throws IPFMBusinessException;
	public IpWfConfig getIpWfConfig(String urType) throws IPFMBusinessException;
	public void save(IpWfConfig ipWfConfig, List<IpWfConfigDetail> ipWfConfigDetailList,String userId) throws IPFMBusinessException;
	public int maxOla() throws DataAccessException;
}
