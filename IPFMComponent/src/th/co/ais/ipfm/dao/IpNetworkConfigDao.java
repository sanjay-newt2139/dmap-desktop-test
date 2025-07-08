package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpNetworkConfig;

public interface IpNetworkConfigDao extends IGenericDao<IpNetworkConfig, Long>{
	public void deleteNetWorkConfigByIpAddress(String ipAddress, String ipPort) throws DataAccessException;
}
