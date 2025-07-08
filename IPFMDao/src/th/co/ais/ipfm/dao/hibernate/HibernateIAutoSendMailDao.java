 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IAutoSendMailDao;
import th.co.ais.ipfm.domain1.IpInfo;

public class HibernateIAutoSendMailDao extends HibernateGenericDao<IpInfo> implements IAutoSendMailDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public String getTeamName(String teamId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamName
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT SYSTEM_OWNER_TEAM_NAME FROM IP_INFO WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier144
DMAP ConvertedQuery - SELECT DISTINCT SYSTEM_OWNER_TEAM_NAME FROM IP_INFO WHERE SYSTEM_OWNER_TEAM_ID = 'teamId'
**/

		String  teamName = (String) session.createSQLQuery(sql.toString())
				.addScalar("SYSTEM_OWNER_TEAM_NAME", Hibernate.STRING).uniqueResult();
		return teamName;
		
	}
	
	@Override
	public String getTeamNameLevel2(String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamNameLevel2
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT t2_team_name FROM ip_level1 WHERE t2_team_id = '"+teamId+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier143
DMAP ConvertedQuery - SELECT DISTINCT t2_team_name FROM ip_level1 WHERE t2_team_id = 'teamId'
**/

		String  teamName = (String) session.createSQLQuery(sql.toString())
				.addScalar("t2_team_name", Hibernate.STRING).list().get(0);
		return teamName;
	}
	
	@Override
	public String getTeamNameLevel2TeamAssign(String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamNameLevel2TeamAssign
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT t2_team_name FROM ip_level2 WHERE t2_team_id = '"+teamId+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier142
DMAP ConvertedQuery - SELECT DISTINCT t2_team_name FROM ip_level2 WHERE t2_team_id = 'teamId'
**/

		String  teamName = (String) session.createSQLQuery(sql.toString())
				.addScalar("t2_team_name", Hibernate.STRING).list().get(0);
		return teamName;
	}

	@Override
	public String getConditionDate(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getConditionDate
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT TO_CHAR(TRUNC(SYSDATE) - ORDER_DATA,'YYYYMMDD') AS CONDITION_DATE ");
		sql.append(" FROM IP_MASTER_TABLE ");
		sql.append(" WHERE REF_TABLE = 'EMAIL_EXP' AND REF_KEY = 'L3' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier141
DMAP ConvertedQuery - SELECT TO_CHAR(TRUNC(statement_timestamp()) - ORDER_DATA, 'YYYYMMDD') AS CONDITION_DATE FROM IP_MASTER_TABLE WHERE REF_TABLE = 'EMAIL_EXP' AND REF_KEY = 'L3'
**/

		String smsNoList = (String)session.createSQLQuery(sql.toString())		
				.addScalar("CONDITION_DATE", Hibernate.STRING).uniqueResult();
		return smsNoList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListTeam(String conditionDate){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getListTeam
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT SYSTEM_OWNER_TEAM_ID");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD') ");
		sql.append(" GROUP BY SYSTEM_OWNER_TEAM_ID");
		sql.append(" ORDER BY 1 ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier140
DMAP ConvertedQuery - SELECT SYSTEM_OWNER_TEAM_ID FROM IP_INFO A WHERE EXPIRED_DATE = TO_DATE(conditionDate,'YYYYMMDD') GROUP BY SYSTEM_OWNER_TEAM_ID ORDER BY 1
**/

		List<String>  teamList = session.createSQLQuery(sql.toString())
				.addScalar("SYSTEM_OWNER_TEAM_ID", Hibernate.STRING)
				.list();
		
		return teamList;
		
	}
	
	@Override
	public List<String> getListTeamLevel2(String conditionDate){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getListTeamLevel2
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT t2_team_id ");
		sql.append(" FROM ip_level1 A ");
		sql.append(" WHERE expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') ");
		sql.append(" GROUP BY t2_team_id ");
		sql.append(" ORDER BY 1 ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier139
DMAP ConvertedQuery - SELECT t2_team_id FROM ip_level1 A WHERE expired_date = TO_DATE(conditionDate,'YYYYMMDD') GROUP BY t2_team_id ORDER BY 1
**/

		List<String>  teamList = session.createSQLQuery(sql.toString())
				.addScalar("t2_team_id", Hibernate.STRING)
				.list();
		
		return teamList;
		
	}	
	
	@Override
	public List<String> getListTeamLevel2ForAssignTeam(String conditionDate){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getListTeamLevel2ForAssignTeam
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT t2_team_id ");
		sql.append(" FROM ip_level2 A ");
		sql.append(" WHERE expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') ");
		sql.append(" GROUP BY t2_team_id ");
		sql.append(" ORDER BY 1 ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier138
DMAP ConvertedQuery - SELECT t2_team_id FROM ip_level2 A WHERE expired_date = TO_DATE(conditionDate,'YYYYMMDD') GROUP BY t2_team_id ORDER BY 1
**/

		List<String>  teamList = session.createSQLQuery(sql.toString())
				.addScalar("t2_team_id", Hibernate.STRING)
				.list();
		
		return teamList;
		
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListEmail(String teamId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getListEmail
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT EMAIL FROM IP_USER WHERE TEAM_ID = '"+teamId+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier137
DMAP ConvertedQuery - SELECT EMAIL FROM IP_USER WHERE TEAM_ID = 'teamId'
**/

		List<String>  emailList = session.createSQLQuery(sql.toString())
				.addScalar("EMAIL", Hibernate.STRING).list();
		return emailList;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListIP(String conditionDate, String teamId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getListIP
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT IP_ADDRESS ");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		sql.append(" AND EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD')");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier136
DMAP ConvertedQuery - SELECT IP_ADDRESS FROM IP_INFO A WHERE SYSTEM_OWNER_TEAM_ID = 'teamId' AND EXPIRED_DATE = TO_DATE(conditionDate,'YYYYMMDD')
**/

		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("IP_ADDRESS", Hibernate.STRING).list();
		return ipList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListExpireIPInfo3Digit(String conditionDate, String teamId) throws DataAccessException{ // DMAP Comment : Dead Code Detected - The Following Method has no reference getListExpireIPInfo3Digit
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ipv4digit1||'.'||ipv4digit2 ||'.'|| ipv4digit3 || '.0' as ip3firstDigit ");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		sql.append(" AND EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD') group by ipv4digit1, ipv4digit2, ipv4digit3 ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier135
DMAP ConvertedQuery - SELECT CONCAT(ipv4digit1, '.', ipv4digit2 , '.', ipv4digit3 , '.0') as ip3firstDigit FROM IP_INFO A WHERE SYSTEM_OWNER_TEAM_ID = 'teamId' AND EXPIRED_DATE = TO_DATE(conditionDate, 'YYYYMMDD') group by ipv4digit1, ipv4digit2, ipv4digit3
**/

		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("ip3firstDigit", Hibernate.STRING).list();
		return ipList;
		
	}	
	
	@Override
	public List<String> getListExpireIPLevel2(String conditionDate, // DMAP Comment : Dead Code Detected - The Following Method has no reference getListExpireIPLevel2
			String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT level1_start || ' - ' || level1_end as iplv2exp ");
		sql.append(" FROM ip_level1 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') order by A.level1_start , A.level1_end ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier134
DMAP ConvertedQuery - SELECT CONCAT(level1_start, ' - ' , level1_end) as iplv2exp FROM ip_level1 A WHERE t2_team_id = 'teamId' AND expired_date = TO_DATE(conditionDate, 'YYYYMMDD') order by A.level1_start, A.level1_end
**/

		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("iplv2exp", Hibernate.STRING).list();
		return ipList;
	}	
	

	@Override
	public List<String> getListExpireIPLevel2ForAssignTeam(String conditionDate, // DMAP Comment : Dead Code Detected - The Following Method has no reference getListExpireIPLevel2ForAssignTeam
			String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT level2_start || ' - ' || level2_end as iplv2exp ");
		sql.append(" FROM ip_level2 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') order by A.level2_start , A.level2_end ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier133
DMAP ConvertedQuery - SELECT CONCAT(level2_start, ' - ' , level2_end) as iplv2exp FROM ip_level2 A WHERE t2_team_id = 'teamId' AND expired_date = TO_DATE(conditionDate, 'YYYYMMDD') order by A.level2_start, A.level2_end
**/

		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("iplv2exp", Hibernate.STRING).list();
		return ipList;
	}	

	
	@SuppressWarnings("unchecked")
	@Override
	public String getExpireDate(String conditionDate, String teamId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpireDate
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		sql.append(" AND EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD')");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier132
DMAP ConvertedQuery - SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE FROM IP_INFO A WHERE SYSTEM_OWNER_TEAM_ID = 'teamId' AND EXPIRED_DATE = TO_DATE(conditionDate,'YYYYMMDD')
**/

		String  expireDate = (String)session.createSQLQuery(sql.toString())
				.addScalar("EXPIRED_DATE", Hibernate.STRING).uniqueResult();
		return expireDate;
		
	}
	
	@Override
	public String getExpireDateLevel2(String conditionDate, String teamId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpireDateLevel2
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE");
		sql.append(" FROM ip_level1 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD')");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier131
DMAP ConvertedQuery - SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE FROM ip_level1 A WHERE t2_team_id = 'teamId' AND expired_date = TO_DATE(conditionDate,'YYYYMMDD')
**/

		String  expireDate = (String)session.createSQLQuery(sql.toString())
				.addScalar("EXPIRED_DATE", Hibernate.STRING).uniqueResult();
		return expireDate;
		
	}
	
	@Override
	public String getExpireDateLevel2TeamAssign(String conditionDate, String teamId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpireDateLevel2TeamAssign
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE");
		sql.append(" FROM ip_level2 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD')");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier130
DMAP ConvertedQuery - SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE FROM ip_level2 A WHERE t2_team_id = 'teamId' AND expired_date = TO_DATE(conditionDate,'YYYYMMDD')
**/

		String  expireDate = (String)session.createSQLQuery(sql.toString())
				.addScalar("EXPIRED_DATE", Hibernate.STRING).uniqueResult();
		return expireDate;
		
	}


}
