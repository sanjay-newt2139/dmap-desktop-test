 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPTeamDao;
import th.co.ais.ipfm.domain1.IpTeam;

public class HibernateIPTeamDao extends HibernateGenericDao<IpTeam> implements IPTeamDao {

	@Override
	public List<IpTeam> getTier2TeamList() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTier2TeamList
		Session session = this.getSessionFactory().getCurrentSession();
		List<IpTeam> tier2TeamList = new ArrayList<IpTeam>();
		String sql = "select t from IpTeam t where t.tier2Team = 'Y' order by t.teamName";
/**
DMAP TAG: Query converted but found same: Identifier152
DMAP ConvertedQuery - select t from IpTeam t where t.tier2Team = 'Y' order by t.teamName
**/

		tier2TeamList = session.createQuery(sql).list();
		Hibernate.initialize(tier2TeamList);
		return tier2TeamList;
	}

	@Override
	public int countSearchTeam(IpTeam ipTeam)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference countSearchTeam
			Session session = getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(IpTeam.class);

			criteria.setProjection(Projections.rowCount());
			return ((Integer)criteria.list().get(0)).intValue();
	}
	
	@Override
	public List<IpTeam> searchTeam(IpTeam ipTeam, int maxResult)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchTeam
		Session session = getSessionFactory().getCurrentSession();
		List<IpTeam> ipTeamList = new ArrayList<IpTeam>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" A.TEAM_ID,A.TEAM_NAME,A.TEAM_DESC,A.TIER2_TEAM,A.UPDATE_BY,A.UPDATE_DATE,NVL(B.TOTAL_MEMBER,0) TOTAL_MEMBER ");
		sql.append(" FROM IP_TEAM A, ");
		sql.append(" (SELECT  TEAM_ID,  TEAM_NAME,COUNT(1) TOTAL_MEMBER ");
		sql.append(" FROM IP_USER ");
		sql.append(" WHERE TEAM_ID IS NOT NULL ");
		sql.append(" GROUP BY TEAM_ID, TEAM_NAME) B ");
		sql.append(" WHERE A.TEAM_ID = B.TEAM_ID(+) ");
		if(!"".equals(ipTeam.getTeamName()) && ipTeam.getTeamName()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier151
DMAP ConvertedQuery - SELECT A.TEAM_ID, A.TEAM_NAME, A.TEAM_DESC, A.TIER2_TEAM, A.UPDATE_BY, A.UPDATE_DATE, coalesce(B.TOTAL_MEMBER, 0) TOTAL_MEMBER FROM ip_team a LEFT OUTER JOIN (SELECT TEAM_ID, TEAM_NAME, COUNT(1) TOTAL_MEMBER FROM IP_USER WHERE NULLIF(CAST(TEAM_ID AS text), '') IS NOT NULL GROUP BY TEAM_ID, TEAM_NAME) b ON (A.TEAM_ID = B.TEAM_ID) WHERE upper(A.TEAM_NAME) LIKE '%ipTeam.getTeamName().toUpperCase()%' ORDER BY A.TEAM_ID
**/

/**
**/

		sql.append(" AND upper(A.TEAM_NAME) LIKE '%"+ipTeam.getTeamName().toUpperCase()+"%' ");
		}
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier150
DMAP ConvertedQuery - SELECT A.TEAM_ID, A.TEAM_NAME, A.TEAM_DESC, A.TIER2_TEAM, A.UPDATE_BY, A.UPDATE_DATE, coalesce(B.TOTAL_MEMBER, 0) TOTAL_MEMBER FROM ip_team a LEFT OUTER JOIN (SELECT TEAM_ID, TEAM_NAME, COUNT(1) TOTAL_MEMBER FROM IP_USER WHERE NULLIF(CAST(TEAM_ID AS text), '') IS NOT NULL GROUP BY TEAM_ID, TEAM_NAME) b ON (A.TEAM_ID = B.TEAM_ID) ORDER BY A.TEAM_ID
**/

		sql.append(" ORDER BY A.TEAM_ID ");
	        
			List dataList =  session.createSQLQuery(sql.toString()).list();
			Iterator iter = dataList.iterator();
			IpTeam objIpTeam;
			while(iter.hasNext()) {
				Object[] obj = (Object[])iter.next();
				objIpTeam = new IpTeam();
				objIpTeam.setTeamId((String)obj[0]);
				objIpTeam.setTeamName((String)obj[1]);
				objIpTeam.setTeamDesc((String)obj[2]);
				objIpTeam.setTier2Team((String)obj[3]);
				objIpTeam.setLastUpdBy((String)obj[4]);
				objIpTeam.setLastUpd((Date)obj[5]);
				objIpTeam.setTotalMember((BigDecimal)obj[6]);

				ipTeamList.add(objIpTeam);
			}

		return ipTeamList;
	}
	
	@Override
	public List<IpTeam> searchTeam(IpTeam ipTeam)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchTeam
		Session session = getSessionFactory().getCurrentSession();
		List<IpTeam> ipTeamList = new ArrayList<IpTeam>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" A.TEAM_ID,A.TEAM_NAME,A.TEAM_DESC,A.TIER2_TEAM,A.UPDATE_BY,A.UPDATE_DATE,NVL(B.TOTAL_MEMBER,0) TOTAL_MEMBER ");
		sql.append(" FROM IP_TEAM A, ");
		sql.append(" (SELECT  TEAM_ID,  TEAM_NAME,COUNT(1) TOTAL_MEMBER ");
		sql.append(" FROM IP_USER ");
		sql.append(" WHERE TEAM_ID IS NOT NULL ");
		sql.append(" GROUP BY TEAM_ID, TEAM_NAME) B ");
		sql.append(" WHERE A.TEAM_ID = B.TEAM_ID(+) ");
		sql.append(" ORDER BY A.TEAM_ID ");
	        
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier149
DMAP ConvertedQuery - SELECT A.TEAM_ID, A.TEAM_NAME, A.TEAM_DESC, A.TIER2_TEAM, A.UPDATE_BY, A.UPDATE_DATE, coalesce(B.TOTAL_MEMBER, 0) TOTAL_MEMBER FROM ip_team a LEFT OUTER JOIN (SELECT TEAM_ID, TEAM_NAME, COUNT(1) TOTAL_MEMBER FROM IP_USER WHERE NULLIF(CAST(TEAM_ID AS text), '') IS NOT NULL GROUP BY TEAM_ID, TEAM_NAME) b ON (A.TEAM_ID = B.TEAM_ID) ORDER BY A.TEAM_ID
**/

			List dataList =  session.createSQLQuery(sql.toString()).list();
			Iterator iter = dataList.iterator();
			IpTeam objIpTeam;
			while(iter.hasNext()) {
				Object[] obj = (Object[])iter.next();
				objIpTeam = new IpTeam();
				objIpTeam.setTeamId((String)obj[0]);
				objIpTeam.setTeamName((String)obj[1]);
				objIpTeam.setTeamDesc((String)obj[2]);
				objIpTeam.setTier2Team((String)obj[3]);
				objIpTeam.setLastUpdBy((String)obj[4]);
				objIpTeam.setLastUpd((Date)obj[5]);
				objIpTeam.setTotalMember((BigDecimal)obj[6]);

				ipTeamList.add(objIpTeam);
			}

		return ipTeamList;
	}
	
	
	@Override
	public String getTeamId() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamId
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier148
DMAP ConvertedQuery - Select CONCAT('T', LPAD(max((replace(CAST(team_id AS numeric), 'T'::numeric, ''::numeric))::numeric)+1, 3, 0) ) AS teamId From ip_team WHERE position('AT' in team_id) = 0
**/

		String teamId =  (String) session.createSQLQuery("  Select 'T' || lpad(max(to_number(replace(team_id,'T','')))+1,3,0) AS teamId  From ip_team where instr(team_id,'AT') = 0 ")
				.addScalar("teamId", Hibernate.STRING).uniqueResult();
		return teamId;
		
	}
	
	

	@Override
	public String getPmRoleId(String teamID) {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpTeam.class);
		criteria.add(Restrictions.eq("activeStatus", "Y"));
		criteria.add(Restrictions.eq("tier2Team", "Y"));
		criteria.add(Restrictions.eq("teamId", teamID));
		criteria.add(Restrictions.eq("activeStatus", "Y"));
		IpTeam result = (IpTeam)criteria.uniqueResult();
		return (result!=null)?result.getPmRoleId():null;
	}

	@Override
	public IpTeam getIpTeam(String teamID) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTeam
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpTeam.class);
		criteria.add(Restrictions.eq("teamId", teamID));
		
		return (IpTeam) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IpTeam getIpTeamByTeamName(String teamName) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTeamByTeamName
		Session session = this.getSessionFactory().getCurrentSession();
		List<IpTeam> teamList; IpTeam ipTeam=null;
String sql = "select distinct t from IpTeam t where t.activeStatus = 'Y' and t.teamName = '" + teamName + "' order by t.teamName";//String sql = "select distinct t from IpTeam t where t.activeStatus = 'Y' and t.teamName = '"+teamName+"' order by t.teamName";
/**
DMAP TAG: Query converted: Identifier147
DMAP ConvertedQuery - select distinct t from IpTeam t where t.activeStatus = 'Y' and t.teamName = 'teamName' order by t.teamName
**/

		teamList = session.createQuery(sql).list();
		if (teamList.size()>0) ipTeam = teamList.get(0);
		return ipTeam;
	}

	@Override
	public String getNextTeamId() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNextTeamId
		Session session = this.getSessionFactory().getCurrentSession();
		String sql = "SELECT 'AT'||LPAD(SEQ_TEAM_ID.NEXTVAL,5,'0') FROM DUAL";
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier146
DMAP ConvertedQuery - SELECT CONCAT('AT', LPAD(nextvalCAST(('seq_team_id') AS text), 5, '0'::text)) 
**/

		String teamId = (String)session.createSQLQuery(sql).uniqueResult();
		return teamId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String ipTeamByTeamName(String teamName) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference ipTeamByTeamName
		Session session = this.getSessionFactory().getCurrentSession();
		List<IpTeam> teamList; IpTeam ipTeam=null;
String sql = "select 'Found' as v_Status from ip_team where team_name ='" + teamName + "'";//String sql = "select 'Found' as  v_Status from ip_team where team_name  ='"+teamName+"'";
/**
DMAP TAG: Query converted: Identifier145
DMAP ConvertedQuery - select 'Found' as v_Status from ip_team where team_name ='teamName'
**/

		String V_Status = (String)session.createSQLQuery(sql)
		.addScalar("v_Status", Hibernate.STRING).uniqueResult();
	
		if("".equals(V_Status) || V_Status==null){
			V_Status = "NotFound";
		}

	  return V_Status;
	}



}
