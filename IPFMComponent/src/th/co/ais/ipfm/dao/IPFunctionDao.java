package th.co.ais.ipfm.dao;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpFunction;

public interface IPFunctionDao extends IGenericDao<IpFunction, Long>{
	public IpFunction findIPFunctionByFuncID(String funcId) throws DataAccessException;
}
