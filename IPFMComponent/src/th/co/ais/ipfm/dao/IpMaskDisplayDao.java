package th.co.ais.ipfm.dao;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpMaskDisplay;

public interface IpMaskDisplayDao extends IGenericDao<IpMaskDisplay, Long>{
	public IpMaskDisplay findIpMaskDisplayByMask(String mask) throws DataAccessException;
}
