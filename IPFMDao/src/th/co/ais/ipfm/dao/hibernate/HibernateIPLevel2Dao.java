package th.co.ais.ipfm.dao.hibernate;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPLevel2Dao;
import th.co.ais.ipfm.domain1.IpLevel2;




public class HibernateIPLevel2Dao extends HibernateGenericDao<IpLevel2> implements IPLevel2Dao{


	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getLevel2_ID() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String level2Id =  (String) session.createSQLQuery("  SELECT 'L2' || LPAD(SEQ_LEVEL2_ID.NEXTVAL ,6,'0') AS Level2_ID  FROM DUAL ")
				.addScalar("Level2_ID", Hibernate.STRING).uniqueResult();
		return level2Id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> findAllIpLevel2(Integer maxSearchResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
		Criteria criteria = session.createCriteria(IpLevel2.class);
		criteria.addOrder(Order.asc("binary2Start"));
		criteria.addOrder(Order.asc("binary2End"));
		if (maxSearchResult!=null) criteria.setMaxResults(maxSearchResult);
		ipLevel2List = criteria.list();
		return ipLevel2List;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> searchBinaryStartBetweenDate(String binaryIp) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel2> result = session.createQuery("select t from IpLevel2 t " +
							" where '"+binaryIp+"' " +
							" between t.binary2Start and t.binary2End " +
							" order by t.binary2Start").list();
		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> searchBinaryStartBetweenDate(String binaryIp,String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel2> result = session.createQuery("select t from IpLevel2 t " +
							" where '"+binaryIp+"' " +
							" between t.binary2Start and t.binary2End " +
							" and t.t2TeamId = '"+teamId+"' " +
							" order by t.binary2Start").list();
		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> searchBinaryEndBetweenDate(String binaryIp) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel2> result = session.createQuery("select t from IpLevel2 t " +
							" where '"+binaryIp+"' " +
							" between t.binary2Start and t.binary2End " +
							" order by t.binary2End").list();
		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> searchBinaryEndBetweenDate(String binaryIp,String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel2> result = session.createQuery("select t from IpLevel2 t " +
							" where '"+binaryIp+"' " +
							" between t.binary2Start and t.binary2End " +
							" and t.t2TeamId = '"+teamId+"' " +
							" order by t.binary2End").list();
		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> searchBinaryRange(String binaryStart, String binaryEnd, Integer maxSearchResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select a.* from (select t.* from IP_LEVEL2 t " +
					" where t.BINARY2_START >= '"+binaryStart+"' " +
					" INTERSECT select t.* from IP_LEVEL2 t " +
					" where t.BINARY2_END <= '"+binaryEnd+"') a " +
					" order by a.BINARY2_START,a.BINARY2_END ";
		
//		String sql = "select t.* from IP_LEVEL2 t " +
//					" where '"+binaryStart+"' >= t.BINARY2_START " +
//					" and '"+binaryEnd+"' <= t.BINARY2_END ";
		List<IpLevel2> result = session.createSQLQuery(sql).addEntity(IpLevel2.class).setMaxResults(maxSearchResult).list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> searchBinaryRange(String binaryStart, String binaryEnd, String teamId, Integer maxSearchResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
//		String sql = "select t.* from IP_LEVEL2 t " +
//					" where '"+binaryStart+"' >= t.BINARY2_START " +
//					" and '"+binaryEnd+"' <= t.BINARY2_END " +
//					" and t.T2_TEAM_ID = '"+teamId+"'";
//		List<IpLevel2> result = session.createSQLQuery(sql).addEntity(IpLevel2.class).list();
		String sql = "select a.* from (select t.* from IP_LEVEL2 t " +
							" where t.BINARY2_START >= '"+binaryStart+"' and t.T2_TEAM_ID ='"+teamId+"' " +
							" INTERSECT select t.* from IP_LEVEL2 t " +
							" where t.BINARY2_END <= '"+binaryEnd+"' and t.T2_TEAM_ID ='"+teamId+"') a " +
							" order by a.BINARY2_START , a.BINARY2_END";
		List<IpLevel2> result = session.createSQLQuery(sql).addEntity(IpLevel2.class).setMaxResults(maxSearchResult).list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel2> findIpLevel2ByTeam(String teamId,Integer maxSearchResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpLevel2.class);
		criteria.add(Restrictions.eq("t2TeamId", teamId));
		criteria.addOrder(Order.asc("binary2Start"));
		criteria.addOrder(Order.asc("binary2End"));
//		criteria.setFetchMode("ipLevel1", FetchMode.JOIN);
		if (maxSearchResult!=null) criteria.setMaxResults(maxSearchResult);
		return criteria.list();
	}

	@Override
	public BigDecimal checkIpLevel2TotalNotAvailable(String binarySt,String binaryEd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		BigDecimal result;
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(nvl(t.assign_ip,0)) as totalNotAvailable from IP_LEVEL2  t " +
				" where t.binary2_start <= '"+binarySt+"' " +
				" and t.binary2_end >= '"+binaryEd+"' ");
		result = (BigDecimal) session.createSQLQuery(sql.toString()).addScalar("totalNotAvailable", Hibernate.BIG_DECIMAL).uniqueResult();
		Hibernate.initialize(result);
		if (result==null) result = new BigDecimal(0);
		return result;
	}
	@Override
	public IpLevel2 findIpLevel2ByLevel2Id(String level2Id) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpLevel2.class);
		criteria.add(Restrictions.eq("level2Id", level2Id));
		return (IpLevel2) criteria.uniqueResult();
	}

	@Override
	public String validateOverExpireLevel1(String level1Id, String expiredDate) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct 'Y' as overExpired from IP_LEVEL2 where LEVEL1_ID = '"+level1Id+"' and to_char(EXPIRED_DATE,'yyyymmdd') > " + expiredDate);
		String overExpired = (String)session.createSQLQuery(sql.toString()).addScalar("overExpired", Hibernate.STRING).uniqueResult();		
		return overExpired;
	}

	@Override
	public void deleteIpLevel2ByLevel1Id(String level1Id) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("delete IP_LEVEL2 where LEVEL1_ID = ? " );
		int result = session.createSQLQuery(sql.toString()).setString(0, level1Id).executeUpdate();
	}

	@Override
	public void insertHistoryByLevel1Id(String level1Id,Date updateDate,String updateBy) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		String sql = "insert into ip_level2_history " +
				" (ip_version, level1_id, level2_id, level2_start, "+
				" level2_end, binary2_start, binary2_end, ip_status, company_id, "+
				" company_name, vip, ip_submask, ip_type_id, ip_type_name, network_type_id, "+
				" network_type_name, vlan_id, network_zone_id, network_zone_name, "+
				" dns_name, submask, network_ip, gateway, system_name, location_id, "+
				" location_name, install_type_id, install_type_name, effective_date, "+
				" expired_date, t1_team_id, t1_team_name, t1_remark, t2_team_id, "+
				" t2_team_name, t2_remark, total_ip, available_ip, assign_ip, reserve_ip, "+
				" use_ip, terminate_ip,create_by, create_date, update_by, update_date, "+
				" row_id, version) SELECT ip_version, level1_id, level2_id, level2_start, " +
				" level2_end, binary2_start, binary2_end, ip_status, company_id, company_name, "+
				" vip, ip_submask, ip_type_id, ip_type_name, network_type_id, network_type_name, "+
				" vlan_id, network_zone_id, network_zone_name, dns_name, submask, network_ip, "+
				" gateway, system_name, location_id, location_name, install_type_id, install_type_name, "+
				" effective_date, expired_date, t1_team_id, t1_team_name, t1_remark, t2_team_id, "+
				" t2_team_name, t2_remark, total_ip, available_ip, assign_ip, reserve_ip, use_ip, "+
				" terminate_ip, create_by, create_date, ? , ? , row_id, version "+
				" from ip_level2 where level1_id = ?";
			int rows = session.createSQLQuery(sql).setString(0, updateBy).setTimestamp(1, updateDate).setString(2, level1Id).executeUpdate();
		
	}

	@Override
	public void insertHistoryByLevel2Id(String level2Id,Date updateDate,String updateBy) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		String sql = "insert into ip_level2_history " +
		" (ip_version, level1_id, level2_id, level2_start, "+
		" level2_end, binary2_start, binary2_end, ip_status, company_id, "+
		" company_name, vip, ip_submask, ip_type_id, ip_type_name, network_type_id, "+
		" network_type_name, vlan_id, network_zone_id, network_zone_name, "+
		" dns_name, submask, network_ip, gateway, system_name, location_id, "+
		" location_name, install_type_id, install_type_name, effective_date, "+
		" expired_date, t1_team_id, t1_team_name, t1_remark, t2_team_id, "+
		" t2_team_name, t2_remark, total_ip, available_ip, assign_ip, reserve_ip, "+
		" use_ip, terminate_ip,create_by, create_date, update_by, update_date, "+
		" row_id, version) SELECT ip_version, level1_id, level2_id, level2_start, " +
		" level2_end, binary2_start, binary2_end, ip_status, company_id, company_name, "+
		" vip, ip_submask, ip_type_id, ip_type_name, network_type_id, network_type_name, "+
		" vlan_id, network_zone_id, network_zone_name, dns_name, submask, network_ip, "+
		" gateway, system_name, location_id, location_name, install_type_id, install_type_name, "+
		" effective_date, expired_date, t1_team_id, t1_team_name, t1_remark, t2_team_id, "+
		" t2_team_name, t2_remark, total_ip, available_ip, assign_ip, reserve_ip, use_ip, "+
		" terminate_ip, create_by, create_date, ? , ? , row_id, version "+
		" from ip_level2 where level2_id = ?";
	int rows = session.createSQLQuery(sql).setString(0, updateBy).setTimestamp(1, updateDate).setString(2, level2Id).executeUpdate();
	}

}
