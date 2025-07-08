package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpvWatchReqnc;


public interface IpvWatchReqncDao extends IGenericDao<IpvWatchReqnc, Long> {

	List<IpvWatchReqnc> findWatchReqNC(String userId) throws Exception;
	
}
