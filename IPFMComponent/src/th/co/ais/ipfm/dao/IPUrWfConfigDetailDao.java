package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;

public interface IPUrWfConfigDetailDao extends IGenericDao<IpWfConfigDetail, Long>{
	
	public List<IpWfConfigDetail> getIpWfConfigDetailList(String urType) throws DataAccessException;
	public int  maxOla() throws DataAccessException;

}


