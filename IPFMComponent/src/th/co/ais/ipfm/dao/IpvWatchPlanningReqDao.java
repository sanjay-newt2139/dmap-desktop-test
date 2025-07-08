package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpvWatchPlanningReq;


public interface IpvWatchPlanningReqDao extends IGenericDao<IpvWatchPlanningReq, Long> {

	List<IpvWatchPlanningReq> findWatchPlanningReq(String userId) throws DataAccessException;
	
}
