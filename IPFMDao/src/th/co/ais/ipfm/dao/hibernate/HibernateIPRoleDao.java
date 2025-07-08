package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPRoleDao;
import th.co.ais.ipfm.domain1.IpRole;

public class HibernateIPRoleDao extends HibernateGenericDao<IpRole> implements IPRoleDao {


	@Override
	public List<IpRole> getRoleList(String userId, String role06, String role07) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpRole> result = new ArrayList<IpRole>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("select role_id,role_name "); 
		sql.append("from ip_role ");
		sql.append("where role_id in (select role_id from ip_role_member ");
		sql.append("where user_id = '"+userId+"') ");
		if(role06.equalsIgnoreCase("Y")){
			sql.append(" or role_id = 'R09'");
		}
		if(role07.equalsIgnoreCase("Y")){
			sql.append(" or role_id in ('R10','R11','R12','R13','R14','R15','R16','R17')");
		}
		sql.append("order by priority, role_name ");

		List list = session.createSQLQuery(sql.toString()).addScalar("role_id").addScalar("role_name").list();
		Iterator iter = list.iterator();
		IpRole ipRole;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipRole = new IpRole();
			ipRole.setRoleId((String)obj[0]);
			ipRole.setRoleName((String)obj[1]);
			result.add(ipRole);
		}
		return result;
	}
	
	@Override
	public List<IpRole> getRoleList(String userId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpRole> result = new ArrayList<IpRole>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("select role_id,role_name "); 
		sql.append("from ip_role ");
		sql.append("where role_id in (select role_id from ip_role_member ");
		sql.append("where user_id = '"+userId+"')");
		sql.append("order by priority, role_name ");

		List list = session.createSQLQuery(sql.toString()).addScalar("role_id").addScalar("role_name").list();
		Iterator iter = list.iterator();
		IpRole ipRole;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipRole = new IpRole();
			ipRole.setRoleId((String)obj[0]);
			ipRole.setRoleName((String)obj[1]);
			result.add(ipRole);
		}
		return result;
	}


	@Override
	public List<IpRole> getRoleAllList() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpRole.class);
		  criteria.addOrder(Order.asc("priority"));
		  criteria.addOrder(Order.asc("roleName"));
		return criteria.list();
	}
	
	@Override
	public IpRole getIpRole(String roleId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(IpRole.class);	
			criteria.add(Restrictions.eq("roleId", roleId));

		return (IpRole)criteria.uniqueResult();
	}
}
