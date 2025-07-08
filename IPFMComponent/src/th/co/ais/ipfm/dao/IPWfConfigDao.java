package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpWfConfig;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;

public interface IPWfConfigDao extends IGenericDao<IpWfConfig, Long>{
	
	public IpWfConfig getIpWfConfig(String urType) throws DataAccessException;
	public void updateIpWfConfig(IpWfConfig ipWfConfig, String userId) throws DataAccessException;

}


