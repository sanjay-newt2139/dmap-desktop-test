package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPGroupMemberDao;
import th.co.ais.ipfm.dao.IIPParameterDao;
import th.co.ais.ipfm.domain.IPGroup;
import th.co.ais.ipfm.domain.IPGroupMember;
import th.co.ais.ipfm.domain.IPGroupMemberUser;
import th.co.ais.ipfm.domain.IPParameter;

public class HibernateIPGroupMemberDao extends HibernateGenericDao<IPGroupMemberUser> implements
    IIPGroupMemberDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<IPGroupMemberUser> searchUserGroupManage(String groupId) throws DataAccessException {
			 Session session = getSessionFactory().getCurrentSession();
			 Criteria criteria = session.createCriteria(IPGroupMemberUser.class);
			
			 	 criteria.createAlias("userId", "u");
			 	 if(groupId!=null && groupId.trim().length()>0){
				    criteria.add(Restrictions.eq("groupId", groupId));
			 	 }
	
			     criteria.addOrder(Order.asc("u.userId"));
			
			return criteria.list();
	}

	@Override
	public int countSearchUserGroupManage(String groupId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPGroupMemberUser.class);

	 	 criteria.createAlias("userId", "u");
	 	 
	 	 if(groupId!=null && groupId.trim().length()>0){
		    criteria.add(Restrictions.eq("groupId", groupId));
	 	 }

	     criteria.addOrder(Order.asc("u.userId"));
	     
		criteria.setProjection(Projections.rowCount());
		return ((Integer)criteria.list().get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPGroupMemberUser> searchUserGroupManage(String groupId, int maxResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPGroupMemberUser.class);
		if(maxResult>0){
			criteria.setMaxResults(maxResult);	
		}
		
	 	 criteria.createAlias("userId", "u");
	 	 
	 	 if(groupId!=null && groupId.trim().length()>0){
		      criteria.add(Restrictions.eq("groupId", groupId));
	 	 }

	     criteria.addOrder(Order.asc("u.userId"));;
		
		return criteria.list();
	}
	


}
