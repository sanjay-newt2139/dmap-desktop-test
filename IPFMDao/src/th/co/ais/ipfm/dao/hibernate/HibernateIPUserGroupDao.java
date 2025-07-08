package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.CommonDao;
import th.co.ais.ipfm.dao.IIPUserGroupDao;
import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.domain.IPUserGroup;
import th.co.ais.ipfm.domain.MasterTBL;


public class HibernateIPUserGroupDao extends HibernateGenericDao<IPUserGroup> implements IIPUserGroupDao {



	@Override
	public List<IPUserGroup> getUserGroupList()throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPUserGroup.class);
		
		criteria.add(Restrictions.eq("isActive", "1"));
		
		criteria.addOrder(Order.asc("userGroupName"));
		
		return criteria.list();
	}


	

}
