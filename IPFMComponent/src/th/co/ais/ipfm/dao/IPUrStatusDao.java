package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import th.co.ais.ipfm.domain1.IpUrStatus;



public interface IPUrStatusDao extends IGenericDao<IpUrStatus, Long> {
	
	public List<IpUrStatus> getUrStatusList(String urType) throws DataAccessException;
	public List<IpUrStatus> getSubUrStatusList(String urType) throws DataAccessException;
}
