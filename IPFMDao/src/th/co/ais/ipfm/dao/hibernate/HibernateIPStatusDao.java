package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IIPStatusDAO;
import th.co.ais.ipfm.domain1.IpUrStatus;

public class HibernateIPStatusDao extends HibernateGenericDao<IpUrStatus> implements IIPStatusDAO{

	public IpUrStatus getSubStatus(String urType,String subUrStatus){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubStatus
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrStatus.class);
		criteria.add(Restrictions.eq("urType",urType));
		criteria.add(Restrictions.eq("subUrStatusId",subUrStatus));
		return (IpUrStatus)criteria.uniqueResult();
	}

	@Override
	public IpUrStatus getStatus(String urType, String urStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatus
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrStatus.class);
		criteria.add(Restrictions.eq("urType",urType));
		criteria.add(Restrictions.eq("urStatusId",urStatus));
		return (IpUrStatus)criteria.uniqueResult();
	}


}
