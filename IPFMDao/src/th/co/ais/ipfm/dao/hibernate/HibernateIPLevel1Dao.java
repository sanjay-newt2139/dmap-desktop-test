 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPLevel1Dao;
import th.co.ais.ipfm.domain1.IpLevel1;




public class HibernateIPLevel1Dao extends HibernateGenericDao<IpLevel1> implements IPLevel1Dao{


	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getLevel1_ID() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLevel1_ID
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier58
DMAP ConvertedQuery - SELECT CONCAT('L1', LPAD(nextvalCAST(('seq_level1_id') AS text), 6, '0'::text) ) AS Level1_ID
**/

//		String level1Id =  (String) session.createSQLQuery("  SELECT 'L1' || LPAD(SEQ_LEVEL1_ID.NEXTVAL ,6,'0') AS Level1_ID  FROM DUAL ")
		String level1Id =  (String) session.createSQLQuery("SELECT CONCAT('L1', LPAD(nextvalCAST(('seq_level1_id') AS text), 6, '0'::text) ) AS Level1_ID")
				.addScalar("Level1_ID", Hibernate.STRING).uniqueResult();
		return level1Id;
	}
	
	@Override
	public List<IpLevel1> findAllIpLevel1(Integer maxSearchResult) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference findAllIpLevel1
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel1> ipLevel1List = new ArrayList<IpLevel1>();
		Criteria criteria = session.createCriteria(IpLevel1.class);
		criteria.addOrder(Order.asc("binary1Start"));
		criteria.addOrder(Order.asc("binary1End"));
		if (maxSearchResult!=null) criteria.setMaxResults(maxSearchResult);
		ipLevel1List = criteria.list();
		Hibernate.initialize(ipLevel1List);
		return ipLevel1List;
	}
	
	public List<IpLevel1> findIpLevel1ByTeam(String teamId,Integer maxSearchResult) throws DataAccessException{ // DMAP Comment : Dead Code Detected - The Following Method has no reference findIpLevel1ByTeam
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel1> ipLevel1List = new ArrayList<IpLevel1>();
		Criteria criteria = session.createCriteria(IpLevel1.class);
		criteria.add(Restrictions.eq("t2TeamId", teamId));
		criteria.addOrder(Order.asc("binary1Start"));
		criteria.addOrder(Order.asc("binary1End"));
		if (maxSearchResult!=null) criteria.setMaxResults(maxSearchResult);
		ipLevel1List = criteria.list();
		Hibernate.initialize(ipLevel1List);
		return ipLevel1List;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel1> searchBinaryStartBetweenDate(String binaryIp,String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchBinaryStartBetweenDate
		String teamSql = "";
		if (teamId!=null && teamId.trim().length()>0)  teamSql = " and t.t2TeamId = '"+teamId+"' ";
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier57
DMAP ConvertedQuery - select t from IpLevel1 t where 'binaryIp' between t.binary1Start and t.binary1End and t.t2TeamId = 'teamId' order by t.binary1Start
**/

/**
**/

		List<IpLevel1> result = session.createQuery("select t from IpLevel1 t " +
							" where '"+binaryIp+"' " +
							" between t.binary1Start and t.binary1End " + teamSql +
							" order by t.binary1Start").list();
		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel1> searchBinaryEndBetweenDate(String binaryIp,String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchBinaryEndBetweenDate
		String teamSql = "";
		if (teamId!=null && teamId.trim().length()>0)  teamSql = " and t.t2TeamId = '"+teamId+"' ";
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier56
DMAP ConvertedQuery - select t from IpLevel1 t where 'binaryIp' between t.binary1Start and t.binary1End and t.t2TeamId = 'teamId' order by t.binary1End 
**/

		List<IpLevel1> result = session.createQuery("select t from IpLevel1 t " +
							" where '"+binaryIp+"' " +
							" between t.binary1Start and t.binary1End " + teamSql +
							" order by t.binary1End ").list();
		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel1> searchBinaryRange(String binaryStart, String binaryEnd ,String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchBinaryRange
		String teamSql = "";
		if (teamId!=null && teamId.trim().length()>0)  {
			teamSql = "  and t.T2_TEAM_ID ='"+teamId+"' ";
//			teamSql = "  and t.t2TeamId ='"+teamId+"' ";
		}
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier55
DMAP ConvertedQuery - select a.* from (select t.* from IP_LEVEL1 t where t.BINARY1_START >= 'binaryStart' and t.T2_TEAM_ID ='teamId' INTERSECT select t.* from IP_LEVEL1 t where t.BINARY1_END <= 'binaryEnd' and t.T2_TEAM_ID ='teamId' ) a order by a.BINARY1_START, a.BINARY1_END
**/

/**
**/

		List<IpLevel1> result = session.createSQLQuery("select a.* from (select t.* from IP_LEVEL1 t " +
							" where t.BINARY1_START >= '"+binaryStart+"' " + teamSql +
							" INTERSECT select t.* from IP_LEVEL1 t " +
							" where t.BINARY1_END <= '"+binaryEnd+"' "+teamSql+" ) a " +
							" order by a.BINARY1_START, a.BINARY1_END").addEntity(IpLevel1.class).list();
//		List<IpLevel1> result = session.createQuery("select a from (select t from IpLevel1 t " +
//				" where t.binary1Start >= '"+binaryStart+"' " + teamSql +
//				" INTERSECT select t from IpLevel1 t " +
//				" where t.binary1End <= '"+binaryEnd+"' "+teamSql+" ) a " +
//				" left join fetch a.t2Team order by a.binary1Start, a.binary1End").list();
		return result;
	}

	@Override
	public void updateTotalT2Assign(String level1Id, Integer totalIp, String userId) throws DataAccessException{ // DMAP Comment : Dead Code Detected - The Following Method has no reference updateTotalT2Assign
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier54
DMAP ConvertedQuery - update ip_level1 set total_t2_assign = coalesce(total_t2_assign, 0)+ totalIp , update_by = 'userId', update_date = statement_timestamp() WHERE level1_id = 'level1Id'
**/

		int rows = session.createSQLQuery("update ip_level1 set " +
					" total_t2_assign = nvl(total_t2_assign,0)+ "+totalIp+
					" , update_by = '"+userId+"' , update_date = sysdate " +
					" where level1_id = '"+level1Id+"' ").executeUpdate();
	}
	@Override
	public IpLevel1 findIpLevel1ByLevel1Id(String level1Id) throws DataAccessException{ // DMAP Comment : Dead Code Detected - The Following Method has no reference findIpLevel1ByLevel1Id
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpLevel1.class);
		criteria.add(Restrictions.eq("level1Id", level1Id));
		return (IpLevel1) criteria.uniqueResult();
	}

	@Override
	public void insertHistoryByLevel1Id(String level1Id,Date updateDate,String updateBy) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference insertHistoryByLevel1Id
		Session session = getSessionFactory().getCurrentSession();		
		String sql = " insert into ip_level1_history ( "+
                     " ip_version,level1_id,level1_start,level1_end,binary1_start, "+
                     " binary1_end,ip_status,company_id, company_name,ip_type_id, "+
                     " ip_type_name, vip, network_ip, gateway, dns_name, vlan_id,effective_date,expired_date, "+
                     " network_type_id, network_type_name, network_zone_id, network_zone_name, total_ip, "+
                     " total_t2_assign,  t1_team_id, t1_team_name,t1_remarks,t2_team_id,t2_team_name, "+
                     " create_by,create_date, update_by, update_date, row_id, version, ip_submask, submask) "+
                     " select ip_version, level1_id,level1_start, level1_end, binary1_start,binary1_end, "+
                     " ip_status,company_id, company_name, ip_type_id, ip_type_name, vip, network_ip, gateway, "+
                     " dns_name, vlan_id, effective_date, expired_date, network_type_id, network_type_name, "+
                     " network_zone_id, network_zone_name, total_ip, total_t2_assign, t1_team_id, t1_team_name, "+
                     " t1_remarks, t2_team_id, t2_team_name, create_by, create_date, ? , ? , "+ 
                     " row_id, version, ip_submask, submask from ip_level1  where level1_id = ?";
/**
DMAP TAG: Query converted but found same: Identifier53
DMAP ConvertedQuery - insert into ip_level1_history ( ip_version,level1_id,level1_start,level1_end,binary1_start, binary1_end,ip_status,company_id, company_name,ip_type_id, ip_type_name, vip, network_ip, gateway, dns_name, vlan_id,effective_date,expired_date, network_type_id, network_type_name, network_zone_id, network_zone_name, total_ip, total_t2_assign, t1_team_id, t1_team_name,t1_remarks,t2_team_id,t2_team_name, create_by,create_date, update_by, update_date, row_id, version, ip_submask, submask) select ip_version, level1_id,level1_start, level1_end, binary1_start,binary1_end, ip_status,company_id, company_name, ip_type_id, ip_type_name, vip, network_ip, gateway, dns_name, vlan_id, effective_date, expired_date, network_type_id, network_type_name, network_zone_id, network_zone_name, total_ip, total_t2_assign, t1_team_id, t1_team_name, t1_remarks, t2_team_id, t2_team_name, create_by, create_date, ? , ? , row_id, version, ip_submask, submask from ip_level1 where level1_id = ?
**/

			int rows = session.createSQLQuery(sql).setString(0, updateBy).setTimestamp(1, updateDate).setString(2, level1Id).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpLevel1> searchStartIpBetweenBinaryStartEndWithTeam2(String binaryStartIp, String binaryEndIp,String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchStartIpBetweenBinaryStartEndWithTeam2
		String teamSql = "";
		if (teamId!=null && teamId.trim().length()>0)  teamSql = " and t.t2TeamId = '"+teamId+"' ";
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier52
DMAP ConvertedQuery - select t from IpLevel1 t where t.binary1Start between 'binaryStartIp' and 'binaryEndIp' and t.t2TeamId = 'teamId' order by t.binary1Start
**/

/**
**/

		List<IpLevel1> result = session.createQuery("select t from IpLevel1 t " +
							" where t.binary1Start " +
							" between  '" + binaryStartIp + "' and '"  + binaryEndIp + "' " + teamSql +
							" order by t.binary1Start").list();
		
		return result;
	}
	
	@Override
	public List<IpLevel1> searchBySubIpMaskWithTeam(String subDigitIp,int mark, String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchBySubIpMaskWithTeam
		String teamSql = "";
		if(subDigitIp == null || subDigitIp.equals("")) {
			return null;
		}
		
		if(mark == 16) {
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier51
DMAP ConvertedQuery - select t from IpLevel1 t where t.level1Start like '.%.0.0' and t.t2TeamId = 'teamId' order by t.binary1Start
**/

			subDigitIp = subDigitIp + ".%.0.0";
		} else if(mark == 24) {
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier50
DMAP ConvertedQuery - select t from IpLevel1 t where t.level1Start like '.%.0' and t.t2TeamId = 'teamId' order by t.binary1Start
**/

			subDigitIp = subDigitIp + ".%.0";
		} else if(mark == 32) {
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier49
DMAP ConvertedQuery - select t from IpLevel1 t where t.level1Start like '.%' and t.t2TeamId = 'teamId' order by t.binary1Start
**/

			subDigitIp = subDigitIp + ".%";
		} 
		
		if (teamId!=null && teamId.trim().length()>0)  teamSql = " and t.t2TeamId = '"+teamId+"' ";
		Session session = getSessionFactory().getCurrentSession();
		List<IpLevel1> result = session.createQuery("select t from IpLevel1 t " +
							" where t.level1Start like '" + subDigitIp + "' " +  teamSql 
							+ " order by t.binary1Start").list();
//							" between  '" + binaryStartIp + "' and '"  + binaryEndIp + "' " + teamSql +
							//" order by t.binary1Start").list();
		
		return result;
	}
}
