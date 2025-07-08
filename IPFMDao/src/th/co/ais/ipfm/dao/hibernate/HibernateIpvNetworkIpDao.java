 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpvNetworkIpDao;
import th.co.ais.ipfm.domain1.IpvNetworkIp;




public class HibernateIpvNetworkIpDao extends HibernateGenericDao<IpvNetworkIp> implements IpvNetworkIpDao{

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<IpvNetworkIp> searhNetworkIpByTier1(Integer maxSearchResult) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searhNetworkIpByTier1
		 List<IpvNetworkIp> resultList = new ArrayList<IpvNetworkIp>();
		 Session session = getSessionFactory().getCurrentSession();
		 String sql = "Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 " +
				"from IPV_NETWORK_IP t order by t.NETWORK_IP1,t.NETWORK_IP2,t.NETWORK_IP3,t.NETWORK_IP4 ";
/**
DMAP TAG: Query converted but found same: Identifier362
DMAP ConvertedQuery - Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from IPV_NETWORK_IP t order by t.NETWORK_IP1,t.NETWORK_IP2,t.NETWORK_IP3,t.NETWORK_IP4
**/

		 List result = session.createSQLQuery(sql).addScalar("NETWORK_IP",Hibernate.STRING)
											.addScalar("NETWORK_IP1",Hibernate.INTEGER)
											.addScalar("NETWORK_IP2",Hibernate.INTEGER)
											.addScalar("NETWORK_IP3",Hibernate.INTEGER)
											.addScalar("NETWORK_IP4",Hibernate.INTEGER)
											.setMaxResults(maxSearchResult).list();
		
		 Iterator iter = result.iterator();
	 	 while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();            
            IpvNetworkIp ipvNetworkIp = new IpvNetworkIp();
            ipvNetworkIp.setNetworkIp((String)obj[0]);
            ipvNetworkIp.setNetworkIp1((Integer) obj[1]);
            ipvNetworkIp.setNetworkIp2((Integer) obj[2]);
            ipvNetworkIp.setNetworkIp3((Integer) obj[3]);			
            ipvNetworkIp.setNetworkIp4((Integer) obj[4]); 
            resultList.add(ipvNetworkIp);
	 	 }
		 return resultList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpvNetworkIp> searhNetworkIpByTier2(String tier2TeamId, String userId, Integer maxSearchResult) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searhNetworkIpByTier2
		List<IpvNetworkIp> resultList = new ArrayList<IpvNetworkIp>();
		Session session = getSessionFactory().getCurrentSession();
		String sql = "Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from IPV_NETWORK_IP t " +
				" where t.T2_TEAM_ID = '"+tier2TeamId+"' " +
				" or t.SYSTEM_OWNER_ID = '"+userId+"' "+
				" or t.SYSTEM_OWNER_TEAM_ID = '"+tier2TeamId+"' "+
				" order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4";
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier361
DMAP ConvertedQuery - Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from IPV_NETWORK_IP t where t.T2_TEAM_ID = 'tier2TeamId' or t.SYSTEM_OWNER_ID = 'userId' or t.SYSTEM_OWNER_TEAM_ID = 'tier2TeamId' order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4
**/

		List result = session.createSQLQuery(sql).addScalar("NETWORK_IP",Hibernate.STRING)
				.addScalar("NETWORK_IP1",Hibernate.INTEGER)
				.addScalar("NETWORK_IP2",Hibernate.INTEGER)
				.addScalar("NETWORK_IP3",Hibernate.INTEGER)
				.addScalar("NETWORK_IP4",Hibernate.INTEGER)
				.setMaxResults(maxSearchResult).list();
		
		Iterator iter = result.iterator();
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();            
			IpvNetworkIp ipvNetworkIp = new IpvNetworkIp();
			ipvNetworkIp.setNetworkIp((String)obj[0]);
			ipvNetworkIp.setNetworkIp1((Integer) obj[1]);
			ipvNetworkIp.setNetworkIp2((Integer) obj[2]);
			ipvNetworkIp.setNetworkIp3((Integer) obj[3]);			
			ipvNetworkIp.setNetworkIp4((Integer) obj[4]); 
			resultList.add(ipvNetworkIp);
		}
		return resultList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpvNetworkIp> searhNetworkIpByTier3(String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searhNetworkIpByTier3
		List<IpvNetworkIp> resultList = new ArrayList<IpvNetworkIp>();
		Session session = getSessionFactory().getCurrentSession();
		String sql = "Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4  from IPV_NETWORK_IP t " +
				" where t.SYSTEM_OWNER_TEAM_ID = '"+sysOwnerTeamId+"' " +
				" or t.SYSTEM_OWNER_ID = '"+sysOwnerId+"' "+
				" order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 ";
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier360
DMAP ConvertedQuery - Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from IPV_NETWORK_IP t where t.SYSTEM_OWNER_TEAM_ID = 'sysOwnerTeamId' or t.SYSTEM_OWNER_ID = 'sysOwnerId' order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4
**/

		List result = session.createSQLQuery(sql).addScalar("NETWORK_IP",Hibernate.STRING)
			.addScalar("NETWORK_IP1",Hibernate.INTEGER)
			.addScalar("NETWORK_IP2",Hibernate.INTEGER)
			.addScalar("NETWORK_IP3",Hibernate.INTEGER)
			.addScalar("NETWORK_IP4",Hibernate.INTEGER)
			.setMaxResults(maxSearchResult).list();

		Iterator iter = result.iterator();
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();            
			IpvNetworkIp ipvNetworkIp = new IpvNetworkIp();
			ipvNetworkIp.setNetworkIp((String)obj[0]);
			ipvNetworkIp.setNetworkIp1((Integer) obj[1]);
			ipvNetworkIp.setNetworkIp2((Integer) obj[2]);
			ipvNetworkIp.setNetworkIp3((Integer) obj[3]);			
			ipvNetworkIp.setNetworkIp4((Integer) obj[4]); 
			resultList.add(ipvNetworkIp);
		}
		return resultList;
	}
	@Override
	public List<IpvNetworkIp> searhNetworkIpRangeByTier1(String binaryIpStart, // DMAP Comment : Dead Code Detected - The Following Method has no reference searhNetworkIpRangeByTier1
			String binaryIpEnd, Integer maxSearchResult)
			throws DataAccessException {
		 List<IpvNetworkIp> resultList = new ArrayList<IpvNetworkIp>();
		 Session session = getSessionFactory().getCurrentSession();
		 String sql = "Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 " +
				 "from (SELECT DISTINCT t1.ipv4digit1 || '.' || t1.ipv4digit2 || '.' || t1.ipv4digit3 "+
                 " || '.0' network_ip, "+
				 " TO_NUMBER (t1.ipv4digit1) network_ip1, "+
				 " TO_NUMBER (t1.ipv4digit2) network_ip2, "+
				 " TO_NUMBER (t1.ipv4digit3) network_ip3, "+
				 " TO_NUMBER ('0') network_ip4, t1.t2_team_id, "+
				 " t1.system_owner_id, t1.system_owner_team_id "+
				 " FROM ip_info t1 "+
				 " where t1.binary_ip >= '"+binaryIpStart+"' " +
				 " and t1.binary_ip <= '"+binaryIpEnd+"' " +
				 " ORDER BY network_ip1, network_ip2, network_ip3  "+
				 " ) t order by t.NETWORK_IP1,t.NETWORK_IP2,t.NETWORK_IP3,t.NETWORK_IP4 ";;
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier359
DMAP ConvertedQuery - Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from (SELECT DISTINCT CONCAT(t1.ipv4digit1, '.' , t1.ipv4digit2 , '.' , t1.ipv4digit3 , '.0') network_ip, CAST((t1.ipv4digit1) AS numeric) network_ip1, CAST((t1.ipv4digit2) AS numeric) network_ip2, CAST((t1.ipv4digit3) AS numeric) network_ip3, CAST(('0') AS numeric) network_ip4, t1.t2_team_id, t1.system_owner_id, t1.system_owner_team_id FROM ip_info t1 where t1.binary_ip >= 'binaryIpStart' and t1.binary_ip <= 'binaryIpEnd' ORDER BY network_ip1, network_ip2, network_ip3) t order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4
**/

		 List result = session.createSQLQuery(sql).addScalar("NETWORK_IP",Hibernate.STRING)
											.addScalar("NETWORK_IP1",Hibernate.INTEGER)
											.addScalar("NETWORK_IP2",Hibernate.INTEGER)
											.addScalar("NETWORK_IP3",Hibernate.INTEGER)
											.addScalar("NETWORK_IP4",Hibernate.INTEGER)
											.setMaxResults(maxSearchResult).list();
		
		 Iterator iter = result.iterator();
	 	 while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();            
            IpvNetworkIp ipvNetworkIp = new IpvNetworkIp();
            ipvNetworkIp.setNetworkIp((String)obj[0]);
            ipvNetworkIp.setNetworkIp1((Integer) obj[1]);
            ipvNetworkIp.setNetworkIp2((Integer) obj[2]);
            ipvNetworkIp.setNetworkIp3((Integer) obj[3]);			
            ipvNetworkIp.setNetworkIp4((Integer) obj[4]); 
            resultList.add(ipvNetworkIp);
	 	 }
		 return resultList;
	}
	@Override
	public List<IpvNetworkIp> searhNetworkIpRangeByTier2(String binaryIpStart, // DMAP Comment : Dead Code Detected - The Following Method has no reference searhNetworkIpRangeByTier2
			String binaryIpEnd, String tier2TeamId, String userId,
			Integer maxSearchResult) throws DataAccessException {
		List<IpvNetworkIp> resultList = new ArrayList<IpvNetworkIp>();
		Session session = getSessionFactory().getCurrentSession();
		String sql = "Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 " +
				" from (SELECT DISTINCT t1.ipv4digit1 || '.' || t1.ipv4digit2 || '.' || t1.ipv4digit3 "+
                 " || '.0' network_ip, "+
				 " TO_NUMBER (t1.ipv4digit1) network_ip1, "+
				 " TO_NUMBER (t1.ipv4digit2) network_ip2, "+
				 " TO_NUMBER (t1.ipv4digit3) network_ip3, "+
				 " TO_NUMBER ('0') network_ip4, t1.t2_team_id, "+
				 " t1.system_owner_id, t1.system_owner_team_id "+
				 " FROM ip_info t1 "+
				 " where t1.binary_ip >= '"+binaryIpStart+"' " +
				 " and t1.binary_ip <= '"+binaryIpEnd+"' " +
				 " and (t1.T2_TEAM_ID = '"+tier2TeamId+"' " +
				 /////////////////////////// start chatchai add case same team id with system owner team id
				 " or t1.SYSTEM_OWNER_TEAM_ID = '"+tier2TeamId+"' " +
				 /////////////////////////// end chatchai add case same team id with system owner team id
				 " or t1.SYSTEM_OWNER_ID = '"+userId+"') "+
				 " ORDER BY network_ip1, network_ip2, network_ip3  "+
				 " ) t " +
				 " where t.T2_TEAM_ID = '"+tier2TeamId+"' " +
				 " or t.SYSTEM_OWNER_ID = '"+userId+"' "+
				 /////////////////////////// start chatchai add case same team id with system owner team id
				 " or t.SYSTEM_OWNER_TEAM_ID = '"+tier2TeamId+"' " +
				 /////////////////////////// end chatchai add case same team id with system owner team id				 
				 " order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4";
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier358
DMAP ConvertedQuery - Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from (SELECT DISTINCT CONCAT(t1.ipv4digit1, '.' , t1.ipv4digit2 , '.' , t1.ipv4digit3 , '.0') network_ip, CAST((t1.ipv4digit1) AS numeric) network_ip1, CAST((t1.ipv4digit2) AS numeric) network_ip2, CAST((t1.ipv4digit3) AS numeric) network_ip3, CAST(('0') AS numeric) network_ip4, t1.t2_team_id, t1.system_owner_id, t1.system_owner_team_id FROM ip_info t1 where t1.binary_ip >= 'binaryIpStart' and t1.binary_ip <= 'binaryIpEnd' and (t1.T2_TEAM_ID = 'tier2TeamId' or t1.SYSTEM_OWNER_TEAM_ID = 'tier2TeamId' or t1.SYSTEM_OWNER_ID = 'userId') ORDER BY network_ip1, network_ip2, network_ip3) t WHERE t.T2_TEAM_ID = 'tier2TeamId' or t.SYSTEM_OWNER_ID = 'userId' or t.SYSTEM_OWNER_TEAM_ID = 'tier2TeamId' order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4
**/

		List result = session.createSQLQuery(sql).addScalar("NETWORK_IP",Hibernate.STRING)
				.addScalar("NETWORK_IP1",Hibernate.INTEGER)
				.addScalar("NETWORK_IP2",Hibernate.INTEGER)
				.addScalar("NETWORK_IP3",Hibernate.INTEGER)
				.addScalar("NETWORK_IP4",Hibernate.INTEGER)
				.setMaxResults(maxSearchResult).list();
		
		Iterator iter = result.iterator();
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();            
			IpvNetworkIp ipvNetworkIp = new IpvNetworkIp();
			ipvNetworkIp.setNetworkIp((String)obj[0]);
			ipvNetworkIp.setNetworkIp1((Integer) obj[1]);
			ipvNetworkIp.setNetworkIp2((Integer) obj[2]);
			ipvNetworkIp.setNetworkIp3((Integer) obj[3]);			
			ipvNetworkIp.setNetworkIp4((Integer) obj[4]); 
			resultList.add(ipvNetworkIp);
		}
		return resultList;
	}
	@Override
	public List<IpvNetworkIp> searhNetworkIpRangeByTier3(String binaryIpStart, // DMAP Comment : Dead Code Detected - The Following Method has no reference searhNetworkIpRangeByTier3
			String binaryIpEnd, String sysOwnerTeamId, String sysOwnerId,
			Integer maxSearchResult) throws DataAccessException {
		List<IpvNetworkIp> resultList = new ArrayList<IpvNetworkIp>();
		Session session = getSessionFactory().getCurrentSession();
		String sql = "Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4  " +
				" from (SELECT DISTINCT t1.ipv4digit1 || '.' || t1.ipv4digit2 || '.' || t1.ipv4digit3 "+
                 " || '.0' network_ip, "+
				 " TO_NUMBER (t1.ipv4digit1) network_ip1, "+
				 " TO_NUMBER (t1.ipv4digit2) network_ip2, "+
				 " TO_NUMBER (t1.ipv4digit3) network_ip3, "+
				 " TO_NUMBER ('0') network_ip4, t1.t2_team_id, "+
				 " t1.system_owner_id, t1.system_owner_team_id "+
				 " FROM ip_info t1 "+
				 " where t1.binary_ip >= '"+binaryIpStart+"' " +
				 " and t1.binary_ip <= '"+binaryIpEnd+"' " +
				 " and (t1.SYSTEM_OWNER_TEAM_ID = '"+sysOwnerTeamId+"' " +
				 " or t1.SYSTEM_OWNER_ID = '"+sysOwnerId+"') "+
				 " ORDER BY network_ip1, network_ip2, network_ip3  "+
				 " ) t " +
				 " where t.SYSTEM_OWNER_TEAM_ID = '"+sysOwnerTeamId+"' " +
				 " or t.SYSTEM_OWNER_ID = '"+sysOwnerId+"' "+
				 " order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 ";
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier357
DMAP ConvertedQuery - Select distinct t.NETWORK_IP, t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4 from (SELECT DISTINCT CONCAT(t1.ipv4digit1, '.' , t1.ipv4digit2 , '.' , t1.ipv4digit3 , '.0') network_ip, CAST((t1.ipv4digit1) AS numeric) network_ip1, CAST((t1.ipv4digit2) AS numeric) network_ip2, CAST((t1.ipv4digit3) AS numeric) network_ip3, CAST(('0') AS numeric) network_ip4, t1.t2_team_id, t1.system_owner_id, t1.system_owner_team_id FROM ip_info t1 where t1.binary_ip >= 'binaryIpStart' and t1.binary_ip <= 'binaryIpEnd' and (t1.SYSTEM_OWNER_TEAM_ID = 'sysOwnerTeamId' or t1.SYSTEM_OWNER_ID = 'sysOwnerId') ORDER BY network_ip1, network_ip2, network_ip3) t WHERE t.SYSTEM_OWNER_TEAM_ID = 'sysOwnerTeamId' or t.SYSTEM_OWNER_ID = 'sysOwnerId' order by t.NETWORK_IP1, t.NETWORK_IP2, t.NETWORK_IP3, t.NETWORK_IP4
**/

		List result = session.createSQLQuery(sql).addScalar("NETWORK_IP",Hibernate.STRING)
			.addScalar("NETWORK_IP1",Hibernate.INTEGER)
			.addScalar("NETWORK_IP2",Hibernate.INTEGER)
			.addScalar("NETWORK_IP3",Hibernate.INTEGER)
			.addScalar("NETWORK_IP4",Hibernate.INTEGER)
			.setMaxResults(maxSearchResult).list();

		Iterator iter = result.iterator();
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();            
			IpvNetworkIp ipvNetworkIp = new IpvNetworkIp();
			ipvNetworkIp.setNetworkIp((String)obj[0]);
			ipvNetworkIp.setNetworkIp1((Integer) obj[1]);
			ipvNetworkIp.setNetworkIp2((Integer) obj[2]);
			ipvNetworkIp.setNetworkIp3((Integer) obj[3]);			
			ipvNetworkIp.setNetworkIp4((Integer) obj[4]); 
			resultList.add(ipvNetworkIp);
		}
		return resultList;
	}
	
}
