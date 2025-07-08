package th.co.ais.ipfm.dao;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpInfoTemp;

public interface IIPInfoTempDAO extends IGenericDao<IpInfoTemp, Long> {
	
	public void insertIpInfoTemp(IpInfoTemp ipInfoTemp , String createBy) throws DataAccessException;
	public void deleteIpInfoTempByCreateBy(String createBy) throws DataAccessException;
	public void insertErrorLog(String ip,String type,String msg ,String username) throws DataAccessException;

}
