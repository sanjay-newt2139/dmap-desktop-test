package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpvTodoReqnc;


public interface IpvTodoReqncDao extends IGenericDao<IpvTodoReqnc, Long> {

	List<IpvTodoReqnc> findTodoReqNC(String userId, String actionCode) throws Exception;
	List<IpvTodoReqnc> findTodoReqNCNoRemark(String userId, String actionCode) throws Exception;
	public List<IpvTodoReqnc> findTodoReqNCDraft(String userId, String actionCode) throws Exception;
}
