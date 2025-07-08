package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpvTodoPlanningReq;


public interface IpvTodoPlanningReqDao extends IGenericDao<IpvTodoPlanningReq, Long> {

	List<IpvTodoPlanningReq> findTodoPlanningReq(String userId, String actionCode) throws DataAccessException;
	
}
