package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUserDao;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;


public class HibernateIIPUserDao extends HibernateGenericDao<IpUser> implements IPUserDao {



	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpUser> getSystemOwnerList() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);

		criteria.addOrder(Order.asc("userName"));
		return criteria.list();
	}
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpTeam> getSystemOwnerTeamList() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpTeam.class);
		criteria.add(Restrictions.eq("activeStatus", "Y"));
		//criteria.add(Restrictions.eq("tier2Team", "Y"));
		criteria.addOrder(Order.asc("teamName"));
		return criteria.list();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpTeam> getSystemOwnerTeamTier2List() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpTeam.class);
		criteria.add(Restrictions.eq("activeStatus", "Y"));
		criteria.add(Restrictions.eq("tier2Team", "Y"));
		criteria.addOrder(Order.asc("teamName"));
		return criteria.list();
	}

}
