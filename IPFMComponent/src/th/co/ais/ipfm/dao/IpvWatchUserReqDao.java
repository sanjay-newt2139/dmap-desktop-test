package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpvWatchUserReq;


public interface IpvWatchUserReqDao extends IGenericDao<IpvWatchUserReq, Long> {

	List<IpvWatchUserReq> findWatchUserReq(String userId) throws Exception;
	
}
