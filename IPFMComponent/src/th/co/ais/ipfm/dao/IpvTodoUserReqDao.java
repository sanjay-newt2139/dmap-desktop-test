package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpvTodoUserReq;


public interface IpvTodoUserReqDao extends IGenericDao<IpvTodoUserReq, Long> {

	List<IpvTodoUserReq> findTodoUserReq(String userId, String actionCode) throws Exception;
	
}
