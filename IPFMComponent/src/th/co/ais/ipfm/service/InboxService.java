package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain.TempInbox;
import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpvMonitorReqnc;
import th.co.ais.ipfm.domain1.IpvTodoPlanningReq;
import th.co.ais.ipfm.domain1.IpvTodoReqnc;
import th.co.ais.ipfm.domain1.IpvTodoUserReq;
import th.co.ais.ipfm.domain1.IpvWatchPlanningReq;
import th.co.ais.ipfm.domain1.IpvWatchReqnc;
import th.co.ais.ipfm.domain1.IpvWatchUserReq;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface InboxService {

	public List<TempInbox> findInbox(String userId , String title1, String title2, String title3, String urNo) throws IPFMBusinessException;
	public String getNews() throws IPFMBusinessException;
	public List<IpvTodoReqnc> findTodoReqNC(String userId , String actionCode) throws IPFMBusinessException;
	public List<IpvTodoReqnc> findTodoReqNCNoRemark(String userId , String actionCode) throws IPFMBusinessException;
	public List<IpvTodoUserReq> findTodoUserReq(String userId , String actionCode) throws IPFMBusinessException;
	public List<IpvTodoPlanningReq> findTodoPlanningReq(String userId , String actionCode) throws IPFMBusinessException;
	public List<IpvWatchReqnc> findWatchReqNC(String userId) throws IPFMBusinessException;
	public List<IpvWatchUserReq> findWatchUserReq(String userId) throws IPFMBusinessException;
	public List<IpvWatchPlanningReq> findWatchPlanningReq(String userId) throws IPFMBusinessException;
	public List<IpvMonitorReqnc> findMonitorReqNC(String userId) throws IPFMBusinessException;
	public List<String> getUrTypeList(String urType) throws IPFMBusinessException;	
	public IpFunction getIpFunction(String funcId) throws IPFMBusinessException;
}
