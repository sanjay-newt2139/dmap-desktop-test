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
	public String getTeamName(String teamId){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT SYSTEM_OWNER_TEAM_NAME FROM IP_INFO WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		String  teamName = (String) session.createSQLQuery(sql.toString())
				.addScalar("SYSTEM_OWNER_TEAM_NAME", Hibernate.STRING).uniqueResult();
		return teamName;
		
	}
	
	@Override
	public String getTeamNameLevel2(String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT t2_team_name FROM ip_level1 WHERE t2_team_id = '"+teamId+"' ");
		String  teamName = (String) session.createSQLQuery(sql.toString())
				.addScalar("t2_team_name", Hibernate.STRING).list().get(0);
		return teamName;
	}
	
	@Override
	public String getTeamNameLevel2TeamAssign(String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT t2_team_name FROM ip_level2 WHERE t2_team_id = '"+teamId+"' ");
		String  teamName = (String) session.createSQLQuery(sql.toString())
				.addScalar("t2_team_name", Hibernate.STRING).list().get(0);
		return teamName;
	}

	@Override
	public String getConditionDate(){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT TO_CHAR(TRUNC(SYSDATE) - ORDER_DATA,'YYYYMMDD') AS CONDITION_DATE ");
		sql.append(" FROM IP_MASTER_TABLE ");
		sql.append(" WHERE REF_TABLE = 'EMAIL_EXP' AND REF_KEY = 'L3' ");
		String smsNoList = (String)session.createSQLQuery(sql.toString())		
				.addScalar("CONDITION_DATE", Hibernate.STRING).uniqueResult();
		return smsNoList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListTeam(String conditionDate){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT SYSTEM_OWNER_TEAM_ID");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD') ");
		sql.append(" GROUP BY SYSTEM_OWNER_TEAM_ID");
		sql.append(" ORDER BY 1 ");
		List<String>  teamList = session.createSQLQuery(sql.toString())
				.addScalar("SYSTEM_OWNER_TEAM_ID", Hibernate.STRING)
				.list();
		
		return teamList;
		
	}
	
	@Override
	public List<String> getListTeamLevel2(String conditionDate){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT t2_team_id ");
		sql.append(" FROM ip_level1 A ");
		sql.append(" WHERE expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') ");
		sql.append(" GROUP BY t2_team_id ");
		sql.append(" ORDER BY 1 ");
		List<String>  teamList = session.createSQLQuery(sql.toString())
				.addScalar("t2_team_id", Hibernate.STRING)
				.list();
		
		return teamList;
		
	}	
	
	@Override
	public List<String> getListTeamLevel2ForAssignTeam(String conditionDate){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT t2_team_id ");
		sql.append(" FROM ip_level2 A ");
		sql.append(" WHERE expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') ");
		sql.append(" GROUP BY t2_team_id ");
		sql.append(" ORDER BY 1 ");
		List<String>  teamList = session.createSQLQuery(sql.toString())
				.addScalar("t2_team_id", Hibernate.STRING)
				.list();
		
		return teamList;
		
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListEmail(String teamId){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT EMAIL FROM IP_USER WHERE TEAM_ID = '"+teamId+"' ");
		List<String>  emailList = session.createSQLQuery(sql.toString())
				.addScalar("EMAIL", Hibernate.STRING).list();
		return emailList;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListIP(String conditionDate, String teamId){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT IP_ADDRESS ");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		sql.append(" AND EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD')");
		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("IP_ADDRESS", Hibernate.STRING).list();
		return ipList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getListExpireIPInfo3Digit(String conditionDate, String teamId) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ipv4digit1||'.'||ipv4digit2 ||'.'|| ipv4digit3 || '.0' as ip3firstDigit ");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		sql.append(" AND EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD') group by ipv4digit1, ipv4digit2, ipv4digit3 ");
		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("ip3firstDigit", Hibernate.STRING).list();
		return ipList;
		
	}	
	
	@Override
	public List<String> getListExpireIPLevel2(String conditionDate,
			String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT level1_start || ' - ' || level1_end as iplv2exp ");
		sql.append(" FROM ip_level1 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') order by A.level1_start , A.level1_end ");
		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("iplv2exp", Hibernate.STRING).list();
		return ipList;
	}	
	

	@Override
	public List<String> getListExpireIPLevel2ForAssignTeam(String conditionDate,
			String teamId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT level2_start || ' - ' || level2_end as iplv2exp ");
		sql.append(" FROM ip_level2 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD') order by A.level2_start , A.level2_end ");
		List<String>  ipList = session.createSQLQuery(sql.toString())
				.addScalar("iplv2exp", Hibernate.STRING).list();
		return ipList;
	}	

	
	@SuppressWarnings("unchecked")
	@Override
	public String getExpireDate(String conditionDate, String teamId){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE SYSTEM_OWNER_TEAM_ID = '"+teamId+"' ");
		sql.append(" AND EXPIRED_DATE  = TO_DATE("+conditionDate+",'YYYYMMDD')");
		String  expireDate = (String)session.createSQLQuery(sql.toString())
				.addScalar("EXPIRED_DATE", Hibernate.STRING).uniqueResult();
		return expireDate;
		
	}
	
	@Override
	public String getExpireDateLevel2(String conditionDate, String teamId){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE");
		sql.append(" FROM ip_level1 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD')");
		String  expireDate = (String)session.createSQLQuery(sql.toString())
				.addScalar("EXPIRED_DATE", Hibernate.STRING).uniqueResult();
		return expireDate;
		
	}
	
	@Override
	public String getExpireDateLevel2TeamAssign(String conditionDate, String teamId){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT TO_CHAR(EXPIRED_DATE,'DD/MM/YYYY') AS EXPIRED_DATE");
		sql.append(" FROM ip_level2 A ");
		sql.append(" WHERE t2_team_id = '"+teamId+"' ");
		sql.append(" AND expired_date  = TO_DATE("+conditionDate+",'YYYYMMDD')");
		String  expireDate = (String)session.createSQLQuery(sql.toString())
				.addScalar("EXPIRED_DATE", Hibernate.STRING).uniqueResult();
		return expireDate;
		
	}


}
