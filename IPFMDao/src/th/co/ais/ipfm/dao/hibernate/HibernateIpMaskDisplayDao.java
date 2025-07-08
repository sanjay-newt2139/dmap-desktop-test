package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpMaskDisplayDao;
import th.co.ais.ipfm.domain1.IpMaskDisplay;


public class HibernateIpMaskDisplayDao extends HibernateGenericDao<IpMaskDisplay> implements IpMaskDisplayDao {

	@Override
	public IpMaskDisplay findIpMaskDisplayByMask(String mask) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		IpMaskDisplay result;
		StringBuffer sql = new StringBuffer();
		sql.append("select t from IpMaskDisplay t " +
				"where t.mask = '"+mask+"' ");
		result = (IpMaskDisplay) session.createQuery(sql.toString()).uniqueResult();
		Hibernate.initialize(result);
		
		return result;
	}
}
