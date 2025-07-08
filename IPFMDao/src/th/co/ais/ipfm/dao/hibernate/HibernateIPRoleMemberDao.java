package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPRoleMemberDao;
import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUser;

public class HibernateIPRoleMemberDao extends HibernateGenericDao<IpRoleMember> implements IPRoleMemberDao {

	@Override
	public IpRoleMember addIpRoleMembers(IpRoleMember ipRoleMember) throws DataAccessException {
		
		try {
			insert(ipRoleMember);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ipRoleMember;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpRoleMember> findIpRoleMembersByUserId(String userId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpRoleMember> result = new ArrayList<IpRoleMember>();
		if (userId==null || userId.trim().length()==0) return result;
		StringBuffer sql = new StringBuffer();
		sql.append("select t from IpRoleMember t " +
				"where t.userId = '"+userId+"' " +
				"order by t.roleId ");
		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);
		System.out.println("findIpRoleMembersByUserId result = " + result.size());
		return result;
	}

	@Override
	public List<IpRoleMember> getRoleDataList(String roleId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpRoleMember> result = new ArrayList<IpRoleMember>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("select a.role_id as role_id ,a.user_id as user_id ,b.user_name as user_name,b.position as position , b.dept as dept, b.team_id,b.team_name "); 
		sql.append("from ip_role_member a,ip_user b ");
		sql.append("where a.role_id = '"+roleId+"'");
		sql.append("and a.user_id = b.user_id ");
		sql.append("and sysdate between b.effective_date and nvl(b.expire_date,sysdate) + 1 order by b.user_name");
		
		List list = session.createSQLQuery(sql.toString()).addScalar("role_id").addScalar("user_id").addScalar("user_name")
		.addScalar("position").addScalar("dept").addScalar("team_id").addScalar("team_name").list();
		Iterator iter = list.iterator();
		IpRoleMember ipRoleMember;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipRoleMember = new IpRoleMember();
			IpUser ipUser = new IpUser();
			ipRoleMember.setRoleId((String)obj[0]);
			ipRoleMember.setUserId((String)obj[1]);
			ipRoleMember.setUserName((String)obj[2]);
			ipRoleMember.setPosition((String)obj[3]);
			ipRoleMember.setDept((String)obj[4]);
			ipUser.setTeamId((String)obj[5]);
			ipUser.setTeamName((String)obj[6]);
			ipRoleMember.setIpUser(ipUser);
			result.add(ipRoleMember);
		}
		return result;
	}

	@Override
	public String getCheckExistingDataRole(IpRoleMember ipRoleMember)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String result =  (String) session.createSQLQuery("  select 'Found' AS result  from ip_role_member where user_id = '"+ipRoleMember.getUserId()+"' and role_id = '"+ipRoleMember.getRoleId()+"' ")
				.addScalar("result", Hibernate.STRING).uniqueResult();
		return result;
	}
	
	@Override
	public List<IpRoleMember> deleteRole(String roleId,String userId)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery  =  session.createSQLQuery(" DELETE IP_ROLE_MEMBER where user_id = '"+userId+"' and role_id = '"+roleId+"'");
		sqlQuery.executeUpdate();  
		List<IpRoleMember> roleDataList = getRoleDataList(roleId);
		return roleDataList;
	}

	@Override
	public String checkRole(String userId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String result =  (String) session.createSQLQuery("  select 'Found' AS  result  from ip_role_member where user_id ='"+userId+"' and role_id = 'R01' ")
				.addScalar("result", Hibernate.STRING).uniqueResult();
		return result;
	}
	

}
