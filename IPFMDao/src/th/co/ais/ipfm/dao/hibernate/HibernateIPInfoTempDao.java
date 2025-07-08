package th.co.ais.ipfm.dao.hibernate;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPInfoTempDAO;
import th.co.ais.ipfm.domain1.IpInfoTemp;
//import th.co.ais.ipfm.web.bean.UserSession;
//import th.co.ais.ipfm.web.util.IPFMWebUtil;


public class HibernateIPInfoTempDao extends HibernateGenericDao<IpInfoTemp> implements IIPInfoTempDAO {
	
	
	@Override
	public void insertIpInfoTemp(IpInfoTemp ipInfoTemp , String createBy) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql  =  new StringBuffer();
		sql.append(" insert into ip_info_temp ( ");
		sql.append(" IP_ADDRESS, IP_STATUS, IP_SUBMASK, GATEWAY, HOST_NAME,  ");
		sql.append(" SYSTEM_NAME, VLAN_ID, EXPIRED_DATE, SYSTEM_OWNER_NAME, CREATE_BY, ");
		sql.append(" CREATE_DATE, UPDATE_BY, UPDATE_DATE, ");
		sql.append(" NAT_IP ");
		sql.append(" ) ");
		sql.append(" values( ? ,? ,? ,? ,?, ");
		sql.append(" ? ,? ,? ,? ,? ");
		sql.append(" sysdate ,? ,sysdate  ");
		sql.append(" ,? ");
		sql.append(" ) ");
	
		Query query = session.createSQLQuery(sql.toString());
		query.setString(0, ipInfoTemp.getIpAddress());
		query.setString(1, ipInfoTemp.getIpStatus());
		query.setString(2, ipInfoTemp.getIpSubmask());
		query.setString(3, ipInfoTemp.getGateway());
		query.setString(4, ipInfoTemp.getHostName());
		query.setString(5, ipInfoTemp.getSystemName());
		query.setString(6, ipInfoTemp.getVlanId());
		query.setTimestamp(7, ipInfoTemp.getExpiredDate());
		query.setString(8, ipInfoTemp.getSystemOwnerName());
		query.setString(9, ipInfoTemp.getCreatedBy());
		query.setString(10, ipInfoTemp.getCreatedBy());
		query.setString(11, ipInfoTemp.getNatIp());

		
		int rows = query.executeUpdate();
		
	}
		
	@Override
	public void deleteIpInfoTempByCreateBy(String createBy) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE IP_INFO_TEMP WHERE CREATE_BY = ? " );
		int result = session.createSQLQuery(sql.toString()).setString(0, createBy).executeUpdate();
	}
	

	@Override
	public void insertErrorLog(String ip, String type, String msg, String username) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO IP_LOG_VERIFY (IP, TYPE, MSG, username,row_id, create_date) VALUES (?, ?, ?, ?,sys_guid(), sysdate)" );
		int result = session.createSQLQuery(sql.toString()).setString(0, ip).setString(1, type).setString(2, msg).setString(3, username).executeUpdate();
		
	}
}
