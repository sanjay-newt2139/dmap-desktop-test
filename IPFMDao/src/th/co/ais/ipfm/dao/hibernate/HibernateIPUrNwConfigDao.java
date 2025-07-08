package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrNwConfigDao;
import th.co.ais.ipfm.domain.IPRole;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvJobAssign;

public class HibernateIPUrNwConfigDao extends HibernateGenericDao<IpUrNwConfig> implements IPUrNwConfigDao{
	
	public String getTempURNo() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String urNo =  (String) session.createSQLQuery("SELECT 'TNC'||LPAD(UR_NW_TEMP_SEQ.NEXTVAL,7,'0') as urNo FROM DUAL")
				.addScalar("urNo", Hibernate.STRING).uniqueResult();
		return urNo;
	}

	@Override
	public String getURNo() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String urNo =  (String) session.createSQLQuery(" select 'NC' || TO_CHAR(SYSDATE,'YYYY') || '-' || LPAD(nvl(max(to_number(substr(t.ur_no,8))+1),1) ,6,'0') as urNo from ip_ur_nw_config t where substr(t.ur_no,0,6) = 'NC'||TO_CHAR(SYSDATE,'YYYY') ")
//		String urNo =  (String) session.createSQLQuery("SELECT 'NC'||TO_CHAR(SYSDATE,'YYYY')||'-'||LPAD( UR_NW_SEQ.NEXTVAL,6,'0') AS urNo FROM DUAL")
				.addScalar("urNo", Hibernate.STRING).uniqueResult();
		return urNo;
	}

	@Override
	public IpUrNwConfig findByUrNo(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrNwConfig.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		List<IpUrNwConfig> result = criteria.list();
		return (result.size()!=0)?result.get(0):null;
	}

	@Override
	public List<Map> listManager(IpUser user) {
		StringBuffer bf = new StringBuffer();
		Session session = getSessionFactory().getCurrentSession();
//		bf.append("SELECT DISTINCT T4.USER_ID , T4.USER_NAME ");
//		bf.append("FROM ");
//		bf.append(" ( SELECT T3.USER_ID , T3.USER_NAME ");
//		bf.append("  FROM IP_USER T3 ");
//		bf.append("  WHERE INSTR(';'||?||';' , ';'||T3.USER_ID||';')>0 ");
//		bf.append(" UNION ");
//		bf.append(" SELECT T1.USER_ID , T1.USER_NAME "); 
//		bf.append("  FROM IP_USER T1 ");
//		bf.append("  WHERE T1.USER_ID IN ");
//		bf.append("   (SELECT T2.DELEGATE_USER_ID "); 
//		bf.append("FROM IP_DELEGATE_USER T2  ");
//		bf.append("  WHERE INSTR(';'||?||';' , ';'||T2.USER_ID||';')>0 ");
//		bf.append("AND SYSDATE BETWEEN T2.START_DATE AND T2.END_DATE ) ");
//		bf.append(") T4 ");
//		bf.append("ORDER BY 2 ");

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT T4.USER_ID Manager_ID, T4.USER_NAME Manager_Name "); 
		sql.append("FROM ( SELECT T3.USER_ID , T3.USER_NAME FROM IP_USER T3,IP_ROLE_MEMBER M3 WHERE T3.USER_ID= '"+user.getManagerId()+"' ");
		sql.append("AND T3.USER_ID=M3.USER_ID AND M3.ROLE_ID = 'R03' ");
		sql.append("UNION SELECT T1.USER_ID , T1.USER_NAME FROM IP_USER T1 WHERE T1.USER_ID IN ");
		sql.append("(SELECT T2.DELEGATE_USER_ID FROM IP_DELEGATE_USER T2 WHERE T2.USER_ID= '"+user.getManagerId()+"' ");
		sql.append("AND trunc(SYSDATE) BETWEEN T2.START_DATE AND nvl(T2.END_DATE,trunc(sysdate) )+1 ");
		sql.append(")) T4 ORDER BY 2 ");
		List list = session.createSQLQuery(sql.toString()).addScalar("Manager_ID").addScalar("Manager_Name").list();		
		
		List<Map> map = new ArrayList<Map>();
		
		//SQLQuery query = (session.createSQLQuery(bf.toString())
		List listResult = session.createSQLQuery(sql.toString()).addScalar("Manager_ID").addScalar("Manager_Name").list();
		//List listResult =query.list();
		for(Object ls : listResult){
			Object[] obj = (Object[])ls;
			Map m = new HashMap<String, String>();
			m.put("key", (String)obj[0]);
			m.put("value", (String)obj[1]);
			map.add(m);
		}
		return map;
	}

	@Override
	public IpvJobAssign getJobAssign(String urNo, String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpvJobAssign.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		criteria.addOrder(Order.asc("createDate"));
		List<IpvJobAssign> result = criteria.list(); 
		return (result.size()!=0)?result.get(0):new IpvJobAssign();
	}

	@Override
	public List<IpRoleMember> finByRoleId(String roleId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpRoleMember.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		return criteria.list();
	}

	@Override
	public List<IpRoleMember> listPersonAssign(String teamId) {
		Session session = getSessionFactory().getCurrentSession();
		String [] listTeamId = teamId.split(";");
		List<IpRoleMember> listResult = new ArrayList<IpRoleMember>();
		for(String id : listTeamId){
			List<IpRoleMember> role = finByRoleId(id);
			listResult.addAll(role);
		}
		
		return listResult;

	}

	@Override
	public List<IpvJobAssign> getJobAssignDetail(String urNo, String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpvJobAssign.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		return criteria.list();
	}

	@Override
	public boolean isJobComplete(String urNo,String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpvJobAssign.class);
		String [] status = {"COMPLETE_TEAM","REJECT_TEAM"}; 
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		criteria.add(Restrictions.not(Restrictions.in("urStatus", status)));
		List<IpvJobAssign> list = criteria.list(); 
		return (list.size()==0);

	}

	@Override
	public Map<String,String> getIpOwner(String ip) {
		Map<String,String> map = null;
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);
		criteria.add(Restrictions.eq("ipAddress", ip));
		IpInfo ipInfo = (IpInfo)criteria.uniqueResult();
		if(ipInfo!=null){
			String tier3Id = ipInfo.getSystemOwnerTeamId();
			Criteria criteria2 = session.createCriteria(IpUser.class);
			criteria2.add(Restrictions.eq("teamId", tier3Id));
			List<IpUser> userList = criteria2.list();
			String userTeam = "";
			String userName = "";
			for(IpUser user : userList){
				userTeam+=(";"+user.getUserId());
				userName+=(";"+user.getUserName()+"("+user.getTel()+")");
			}
			if(!userTeam.equals("")) userTeam = userTeam.substring(1);
			if(!userName.equals("")) userName = userName.substring(1);
			map = new HashMap<String, String>();
			map.put("id", userTeam);
			map.put("name", userName);
			
		}
		return map;
	}

	@Override
	public IPRole getRoleData(String roleId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPRole.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		List<IPRole> result = criteria.list();
		return (result.size()!=0)?result.get(0):null;
	}

	@Override
	public IpRoleMember getRoleMemberData(String roleId, String userId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpRoleMember.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		criteria.add(Restrictions.eq("userId", userId));
		List<IpRoleMember> result = criteria.list();
		return (result.size()!=0)?result.get(0):null;
	}


	
}
