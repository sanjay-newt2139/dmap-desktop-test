 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPUserDao;
import th.co.ais.ipfm.dao.IPFMCommondDaoImpl;
import th.co.ais.ipfm.domain.IPTodoList;
import th.co.ais.ipfm.domain.Inbox;
import th.co.ais.ipfm.domain.TreeMenu;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;

public class HibernateIPUserDao extends HibernateGenericDao<IpUser> implements
IIPUserDao {

	@Override
	public IpUser getIPUser(String userId) throws Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIPUser
		Session session = getSessionFactory().getCurrentSession();
		IpUser ipUser = null;
		try {
			Criteria criteria = session.createCriteria(IpUser.class);		
			criteria.add(Restrictions.eq("userId", userId));
			ipUser = (IpUser)criteria.uniqueResult();
		}catch(DataAccessException d){
			d.printStackTrace();
			throw d;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}

		return ipUser;
	}
	
	@Override
	public Integer getActiveDay() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActiveDay
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted but found same: Identifier307
DMAP ConvertedQuery - select numeric_value from ip_parameter where parameter_group = 'USER' and parameter_subgroup ='EXPDATE'
**/

		Integer activeDay =  (Integer) session.createSQLQuery("select numeric_value from ip_parameter where parameter_group = 'USER' and parameter_subgroup ='EXPDATE'")
				.addScalar("numeric_value", Hibernate.INTEGER).uniqueResult();
		return activeDay;
	}
	@Override
	public String getSysdate() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysdate
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier306
DMAP ConvertedQuery - SELECT to_char(statement_timestamp(), 'dd / mm/yyyy hh24:mi:ss') as datenow
**/

//		String sysDate =  (String) session.createSQLQuery("SELECT  to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')   as datenow  FROM dual")
		String sysDate =  (String) session.createSQLQuery("SELECT to_char(statement_timestamp(), 'dd / mm/yyyy hh24:mi:ss') as datenow")
				.addScalar("datenow", Hibernate.STRING).uniqueResult();
		return sysDate;
	}
	

	
	public List<Inbox> getInboxDetailList(String key, String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInboxDetailList
		Session session = getSessionFactory().getCurrentSession();
		List<Inbox> inboxList = new ArrayList<Inbox>();
		try {
			List params = new ArrayList();
			List<TreeMenu> returnResult = new ArrayList<TreeMenu>();
			params.add(userId);
/**
DMAP TAG: Query converted: Identifier305
DMAP ConvertedQuery - call LIST_TODO_LIST (?,?)
**/

//			List<Map> result = new IPFMCommondDaoImpl().callStore("{call LIST_TODO_LIST (?,?)}", params);
			List<Map> result = new IPFMCommondDaoImpl().callStore("call LIST_TODO_LIST (?,?)", params);
			//List<Map> result = ipfmCommondDao.callStore("{call LIST_TODO_LIST (?,?)}", params);
			
			for(Map map : result){
				TreeMenu menu = new TreeMenu();
				menu.setLevel1((String)map.get("LV1"));
				menu.setLevel2((String)map.get("LV2"));
				menu.setLevel3((String)map.get("LV3"));
				menu.setLevel4((String)map.get("LV4"));
				menu.setActionName((String)map.get("ACTION_NAME"));
				returnResult.add(menu);
			}
			for(TreeMenu menu : returnResult){
				
			}
/**
DMAP TAG: Query converted: Identifier304
DMAP ConvertedQuery - select t from InBox t where t.key='key' order by CTID
**/

			inboxList = session.createQuery("select t from InBox t where t.key='" + key + "' order by CTID");
//			for (Inbox inbox : inboxList) {
//				System.out.println("::::: inbox key = " + inbox.getKey() + " : rowId = " + inbox.getRowId());
//			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return inboxList;
	}

	@Override
	public List callStore(String callName, List<IPTodoList> params) {
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query needs manual remediation: Identifier303
DMAP ConvertedQuery - 
**/

		Query query = session.createSQLQuery(
		"CALL LIST_TODO_Detail(:userId,:urType,:actionName)")
		.addScalar("SLA_DATE").addScalar("OLA_DATE").addScalar("UR_NO")
		.addScalar("SUBJECT").addScalar("REQ_USER").addScalar("REQ_DATE")
		.addScalar("PREV_USER").addScalar("PREV_DATE").addScalar("ACTION_NAME_LIST")
		.addScalar("REMARKS").setParameter("userId", "")
		.setParameter("urType", "7277").setParameter("actionName", "7277");

		return null;
	}
	@Override
	public Integer getOnlineUser() throws Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOnlineUser
		Session session = getSessionFactory().getCurrentSession();
		BigDecimal onlineUser = new BigDecimal(0);
		try{
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(*) FROM IP_USER u WHERE UPPER(u.USER_ACTIVE_STATUS) = 'Y'");
/**
DMAP TAG: Query converted but found same: Identifier302
DMAP ConvertedQuery - SELECT count(*) FROM IP_USER u WHERE UPPER(u.USER_ACTIVE_STATUS) = 'Y'
**/

			onlineUser = (BigDecimal)session.createSQLQuery(sql.toString()).uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return onlineUser.intValue();
	}

	@Override
	public List<IpUser> getManagerApproveList(String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerApproveList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUser> result = new ArrayList<IpUser>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT T4.USER_ID Manager_ID, T4.USER_NAME Manager_Name "); 
		sql.append("FROM ( SELECT T3.USER_ID , T3.USER_NAME FROM IP_USER T3,IP_ROLE_MEMBER M3 WHERE T3.USER_ID= '"+userId+"' ");
		sql.append("AND T3.USER_ID=M3.USER_ID AND M3.ROLE_ID = 'R03' ");
		sql.append("UNION SELECT T1.USER_ID , T1.USER_NAME FROM IP_USER T1 WHERE T1.USER_ID IN ");
		sql.append("(SELECT T2.DELEGATE_USER_ID FROM IP_DELEGATE_USER T2 WHERE T2.USER_ID= '"+userId+"' ");
		sql.append("AND trunc(SYSDATE) BETWEEN T2.START_DATE AND nvl(T2.END_DATE,trunc(sysdate) )+1 ");
		sql.append(")) T4 ORDER BY 2 ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier301
DMAP ConvertedQuery - SELECT DISTINCT T4.USER_ID Manager_ID, T4.USER_NAME Manager_Name FROM (SELECT T3.USER_ID, T3.USER_NAME FROM IP_USER T3, IP_ROLE_MEMBER M3 WHERE T3.USER_ID= 'userId' AND T3.USER_ID=M3.USER_ID AND M3.ROLE_ID = 'R03' UNION SELECT T1.USER_ID, T1.USER_NAME FROM IP_USER T1 WHERE T1.USER_ID IN (SELECT T2.DELEGATE_USER_ID FROM IP_DELEGATE_USER T2 WHERE T2.USER_ID= 'userId' AND trunc(statement_timestamp()) BETWEEN T2.START_DATE AND coalesce(T2.END_DATE, trunc(statement_timestamp()))+1 )) T4 ORDER BY 2
**/

		List list = session.createSQLQuery(sql.toString()).addScalar("Manager_ID").addScalar("Manager_Name").list();
		Iterator iter = list.iterator();
		IpUser ipUser;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipUser = new IpUser();
			ipUser.setUserId((String)obj[0]);
			ipUser.setUserName((String)obj[1]);
			result.add(ipUser);
		}
		return result;
	}

	@Override
	public String getViewUR(String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getViewUR
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(1)  as ViewUR ");
		sql.append(" from ip_role_member ");
		sql.append(" where user_id = '"+userId+"'  ");
		sql.append(" and  role_id in ('R01','R05','R06','R07','R08','R09','R10','R11','R12','R13','R14','R15','R16','R17','R18') ");  
		
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier300
DMAP ConvertedQuery - select count(1) as ViewUR from ip_role_member where user_id = 'userId' and role_id in ('R01','R05','R06','R07','R08','R09','R10','R11','R12','R13','R14','R15','R16','R17','R18')
**/

		Integer v_ViewUR =  (Integer) session.createSQLQuery(sql.toString()).addScalar("ViewUR", Hibernate.INTEGER).uniqueResult();
		String flag ="";
		if(v_ViewUR==0){
			flag = "Normal";
		}else{
			flag ="ALL";
		}
		
		return flag;
	}

	@Override
	public List<IpUser> getManagerApproveList(List<String> mgrList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerApproveList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);
		criteria.add(Restrictions.in("userId", mgrList));
		return criteria.list();
	}

	@Override
	public String getV_UserPermission(String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getV_UserPermission
		Session session = getSessionFactory().getCurrentSession();
		String userPermission="";
		//à¾ÔèÁ Role = Search IP (R21) ÊÓËÃÑº¤é¹ËÒ IP ä´é·Ñé§ËÁ´ã¹ÃÐºº IPFM : Request by : IT Security : Modify by : waratayn : 07/02/2013
			//userPermission =  (String) session.createSQLQuery("  SELECT DISTINCT 'T1' AS V_UserPermission FROM IP_ROLE_MEMBER WHERE USER_ID = '"+userId+"' AND ROLE_ID IN ('R01','R05','R08') ")
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier299
DMAP ConvertedQuery - SELECT DISTINCT 'T1' AS V_UserPermission FROM IP_ROLE_MEMBER WHERE USER_ID = 'userId' AND ROLE_ID IN ('R01','R05','R08','R21') 
**/

			userPermission =  (String) session.createSQLQuery("  SELECT DISTINCT 'T1' AS V_UserPermission FROM IP_ROLE_MEMBER WHERE USER_ID = '"+userId+"' AND ROLE_ID IN ('R01','R05','R08','R21') ")
			.addScalar("V_UserPermission", Hibernate.STRING).uniqueResult();
			
        if(!"T1".equals(userPermission)){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier298
DMAP ConvertedQuery - SELECT 'T2' AS V_UserPermission FROM IP_ROLE_MEMBER WHERE USER_ID = 'userId' AND ROLE_ID='R04' 
**/

			userPermission =  (String) session.createSQLQuery(" SELECT 'T2' AS V_UserPermission FROM IP_ROLE_MEMBER WHERE USER_ID = '"+userId+"' AND ROLE_ID='R04' ")
			.addScalar("V_UserPermission", Hibernate.STRING).uniqueResult();
		}
        
        if(!"T2".equals(userPermission) && !("T1".equals(userPermission))){
			userPermission="T3";
		}
		return userPermission;
	}

	@Override
	public List<IpUser> getTeamMemberList(String teamId)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamMemberList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);
		if(!"".equals(teamId)&& teamId!=null ){
		   criteria.add(Restrictions.eq("teamId", teamId));
		}
		   criteria.addOrder(Order.asc("userName"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IpUser> getTeamAssignURList(String teamId, String roleId)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamAssignURList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUser> result;
		StringBuffer sql = new StringBuffer();
		sql.append("select t from IpUser t , IpRoleMember m" +
				" where t.userId = m.userId and t.teamId = ? and m.roleId = ? ");
/**
DMAP TAG: Query converted but found same: Identifier297
DMAP ConvertedQuery - select t from IpUser t , IpRoleMember m where t.userId = m.userId and t.teamId = ? and m.roleId = ?
**/

		result = session.createQuery(sql.toString()).setString(0, teamId).setString(1, roleId).list();
		Hibernate.initialize(result);
		
		return result;
	}
	
	@Override
	public void updateTeam(IpUser ipUser) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateTeam
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier296
DMAP ConvertedQuery - UPDATE IP_USER SET TEAM_ID ='ipUser.getTeamId()', TEAM_NAME ='ipUser.getTeamName()', UPDATE_BY='ipUser.getLastUpdBy()', UPDATE_DATE=statement_timestamp() WHERE USER_ID ='ipUser.getUserId()'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("UPDATE IP_USER SET TEAM_ID ='" + ipUser.getTeamId() + "', TEAM_NAME ='" + ipUser.getTeamName() + "', UPDATE_BY='" + ipUser.getLastUpdBy() + "', UPDATE_DATE=statement_timestamp() WHERE USER_ID ='" + ipUser.getUserId() + "'");
		sqlQuery.executeUpdate();  
	}

	@Override
	public List<IpUser> getTeamMember(IpUser ipUser,String teamId)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamMember
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier295
DMAP ConvertedQuery - UPDATE IP_USER SET TEAM_ID ='ipUser.getTeamId()', TEAM_NAME ='ipUser.getTeamName()', UPDATE_BY='ipUser.getLastUpdBy()', UPDATE_DATE=statement_timestamp() WHERE USER_ID ='ipUser.getUserId()'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("UPDATE IP_USER SET TEAM_ID ='" + ipUser.getTeamId() + "', TEAM_NAME ='" + ipUser.getTeamName() + "', UPDATE_BY='" + ipUser.getLastUpdBy() + "', UPDATE_DATE=statement_timestamp() WHERE USER_ID ='" + ipUser.getUserId() + "'");
		sqlQuery.executeUpdate();  
		
		Criteria criteria = session.createCriteria(IpUser.class);
		criteria.add(Restrictions.eq("teamId", teamId));
		return criteria.list();
	}

	@Override
	public List<IpUser> getUserList(String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUser> result = new ArrayList<IpUser>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("select user_id,user_name,team_id "); 
		sql.append("from  ip_user ");
		sql.append("where trunc(sysdate) between effective_date and nvl(expire_date,trunc(sysdate)+1) ");
		sql.append("order by user_name ");

/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier294
DMAP ConvertedQuery - select user_id, user_name, team_id from ip_user where trunc(statement_timestamp()) between effective_date and coalesce(expire_date, trunc(statement_timestamp()) + '1 days'::interval) order by user_name
**/

		List list = session.createSQLQuery(sql.toString()).addScalar("user_id").addScalar("user_name").addScalar("team_id").list();
		Iterator iter = list.iterator();
		IpUser ipUser;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipUser = new IpUser();
			ipUser.setUserId((String)obj[0]);
			ipUser.setUserName((String)obj[1]);
			ipUser.setTeamId((String)obj[2]);
			result.add(ipUser);
		}
		return result;
	}
	
	@Override
	public List<IpUser> getDelegateToList(String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateToList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUser> result = new ArrayList<IpUser>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("select user_id,user_name "); 
		sql.append("from  ip_user ");
		sql.append("where trunc(sysdate) between effective_date and nvl(expire_date,trunc(sysdate)+1) ");
		sql.append("and user_id <> '"+userId+"' ");
		sql.append("order by user_name ");

/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier293
DMAP ConvertedQuery - select user_id, user_name from ip_user where trunc(statement_timestamp()) between effective_date and coalesce(expire_date, trunc(statement_timestamp()) + '1 days'::interval) and user_id <> 'userId' order by user_name
**/

		List list = session.createSQLQuery(sql.toString()).addScalar("user_id").addScalar("user_name").list();
		Iterator iter = list.iterator();
		IpUser ipUser;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipUser = new IpUser();
			ipUser.setUserId((String)obj[0]);
			ipUser.setUserName((String)obj[1]);
			result.add(ipUser);
		}
		return result;
	}

	@Override
	public String getManagerName(String managerId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerName
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier292
DMAP ConvertedQuery - SELECT USER_NAME FROM IP_USER WHERE USER_ID='managerId'
**/

		String managerName =  (String) session.createSQLQuery("SELECT USER_NAME FROM IP_USER WHERE USER_ID='"+managerId+"'")
		.addScalar("USER_NAME", Hibernate.STRING).uniqueResult();
		return managerName;
	}

	@Override
	public void updateUserProfile(IpUser ipUser) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateUserProfile
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE IP_USER SET user_name ='"+ipUser.getUserName()+"'");
		sql.append(",section = '"+ipUser.getSection()+"' "); 
		sql.append(",dept = '"+ipUser.getDept()+"' ]");
		sql.append(",position = '"+ipUser.getPosition()+"' ");
		sql.append(",mobile = '"+ipUser.getMobile()+"' ");
		sql.append(",tel = '"+ipUser.getTel()+"' ");
		sql.append(",manager_id = '"+ipUser.getManagerId()+"' ");
		sql.append("update_by = '"+ipUser.getLastUpd()+"' "); 
		sql.append("WHERE USER_ID ='"+ipUser.getUserId()+"' "); 

		sql.append("UPDATE IP_USER SET user_name ='"+ipUser.getUserName()+"'"); 
/**
DMAP TAG: Query needs manual remediation: Identifier291
DMAP ConvertedQuery - UPDATE IP_USER SET user_name ='ipUser.getUserName()' ,section = 'ipUser.getSection()' ,dept = 'ipUser.getDept()' ] ,position = 'ipUser.getPosition()' ,mobile = 'ipUser.getMobile()' ,tel = 'ipUser.getTel()' ,manager_id = 'ipUser.getManagerId()' update_by = 'ipUser.getLastUpd()' WHERE USER_ID ='ipUser.getUserId()' UPDATE IP_USER SET user_name ='ipUser.getUserName()'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery(sql.toString());
		sqlQuery.executeUpdate();  
	}

	@Override
	public List<IpUser> getUserIdList() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserIdList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUser> result = new ArrayList<IpUser>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("select user_id,user_name,team_id "); 
		sql.append("from  ip_user ");
		sql.append("where trunc(sysdate) between effective_date and nvl(expire_date,trunc(sysdate)+1) ");
		sql.append("order by user_id ");

/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier290
DMAP ConvertedQuery - select user_id, user_name, team_id from ip_user where trunc(statement_timestamp()) between effective_date and coalesce(expire_date, trunc(statement_timestamp()) + '1 days'::interval) order by user_id
**/

		List list = session.createSQLQuery(sql.toString()).addScalar("user_id").addScalar("user_name").addScalar("team_id").list();
		Iterator iter = list.iterator();
		IpUser ipUser;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipUser = new IpUser();
			ipUser.setUserId((String)obj[0]);
			ipUser.setUserName((String)obj[1]);
			ipUser.setTeamId((String)obj[2]);
			result.add(ipUser);
		}
		return result;
	}

	@Override
	public List<IpRoleMember> getUserForOwnerApprove(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserForOwnerApprove
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpRoleMember.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		return criteria.list();

	}
	
	@Override
	public void saveUserProfile(IpUser ipUserRcv) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference saveUserProfile
		Session session = getSessionFactory().getCurrentSession();
		IpUser ipUser = (IpUser) session.createCriteria(IpUser.class).add(Restrictions.eq("userId", ipUserRcv.getUserId())).uniqueResult();
		String section = ipUserRcv.getSection();
		if (section==null || section.trim().length()==0)  
			section = ""; 
		String department = ipUserRcv.getDept();
		if (department==null || department.trim().length()==0)  
			department = "";
		ipUser.setUserName(ipUserRcv.getUserName());
		ipUser.setEmail(ipUserRcv.getEmail());
		ipUser.setSection(section);
		ipUser.setDept(department);
		ipUser.setPosition(ipUserRcv.getPosition());
		ipUser.setMobile(ipUserRcv.getMobile());
		ipUser.setTel(ipUserRcv.getTel());
		ipUser.setManagerId(ipUserRcv.getManagerId());
		ipUser.setUserActiveStatus("Y");
		ipUser.setLastUpd(new Date());
		ipUser.setLastUpdBy(ipUserRcv.getLastUpdBy());
		
		session.update(ipUser);
		//SQLQuery sqlQuery  =  session.createSQLQuery(" UPDATE IP_USER SET USER_NAME ='"+ipUser.getUserName()+"',EMAIL = '"+ipUser.getEmail()+"',SECTION ='"+section+"',DEPT='"+department+"',POSITION='"+ipUser.getPosition()+"',MOBILE='"+ipUser.getMobile()+"',TEL='"+ipUser.getTel()+"',MANAGER_ID='"+ipUser.getManagerId()+"',USER_ACTIVE_STATUS='Y'  WHERE USER_ID ='"+ipUser.getUserId()+"'");
		//sqlQuery.executeUpdate();  
	}

	@Override
	public List<IpUser> getRoleIdList(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleIdList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);
		criteria.add(Restrictions.sqlRestriction("INSTR({alias}.ROLE_ID_LIST,?)>0",roleId,Hibernate.STRING));
		return criteria.list();
	}
	
	@Override
	public int  getCheckDuplicate(String userId,String teamId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCheckDuplicate
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(1)  as counts ");
		sql.append(" from ip_user ");
		sql.append(" where user_id = '"+userId+"'  ");
		sql.append(" and team_id = '"+teamId+"'  ");
		
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier289
DMAP ConvertedQuery - select count(1) as counts from ip_user where user_id = 'userId' and team_id = 'teamId'
**/

		Integer counts =  (Integer) session.createSQLQuery(sql.toString()).addScalar("counts", Hibernate.INTEGER).uniqueResult();
		
		return counts;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpUser> getSystemOwnerList() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);

		criteria.addOrder(Order.asc("userName"));
		return criteria.list();
	}
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpTeam> getSystemOwnerTeamList() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpTeam.class);
		criteria.add(Restrictions.eq("activeStatus", "Y"));
		//criteria.add(Restrictions.eq("tier2Team", "Y"));
		criteria.addOrder(Order.asc("teamName"));
		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public IpUser findUserBySesionId(String userId, String sessionId) // DMAP Comment : Dead Code Detected - The Following Method has no reference findUserBySesionId
			throws DataAccessException {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("sessionId", sessionId));
		
		List<IpUser> l = criteria.list();
		return (l != null && l.size() > 0 ) ? (IpUser) l.get(0) : null;
	}
	@Override
	public List<IpRoleMember> getIpRoleMember(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpRoleMember
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpRoleMember.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		criteria.addOrder(Order.asc("userId"));
		return criteria.list();

	}
}
  
