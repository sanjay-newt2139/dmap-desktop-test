package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IIPLogVerifyDAO;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpLogVerify;

public class HibernateIPLogVerifyDao extends HibernateGenericDao<IpLogVerify>
		implements IIPLogVerifyDAO {

	@Override
	public List<IpLogVerify> findIpLogVerify(String username){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpLogVerify.class);
		criteria.add(Restrictions.eq("username",username));
		List<IpLogVerify> resultList = criteria.list();
		return resultList;
	}
			
}
