package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPFunctionDao;
import th.co.ais.ipfm.domain1.IpFunction;

public class HibernateIPFunctionDao extends HibernateGenericDao<IpFunction> implements IPFunctionDao {

	@Override
	public IpFunction findIPFunctionByFuncID(String funcId) throws DataAccessException{
//		System.out.println("--findIPFunctionByFuncID-- "+funcId);
		Session session = this.getSessionFactory().getCurrentSession();
		IpFunction result = new IpFunction();
		String sql = "select t from IpFunction t where t.id.funcId = '"+funcId+"' ";
		result = (IpFunction) session.createQuery(sql).uniqueResult();
		Hibernate.initialize(result);
		return result;
	}
}