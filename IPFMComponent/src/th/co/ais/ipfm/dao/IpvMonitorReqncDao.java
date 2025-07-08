package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpvMonitorReqnc;


public interface IpvMonitorReqncDao extends IGenericDao<IpvMonitorReqnc, Long> {

	List<IpvMonitorReqnc> findMonitorReqNC(String userId) throws Exception;
	
	int countMonitorReqNC(String userId) throws Exception ;
	
}
