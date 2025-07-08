package th.co.ais.ipfm.dao;


import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPUrIP;


public interface IIPUrIPDao extends IGenericDao<IPUrIP, Long>{
	public IPUrIP searchIPUrIPByID(String rowid) throws DataAccessException, Exception;
	public String getMaxId() throws DataAccessException;
	public String getSysdate() throws DataAccessException;
	public String getURNo() throws DataAccessException;
}
