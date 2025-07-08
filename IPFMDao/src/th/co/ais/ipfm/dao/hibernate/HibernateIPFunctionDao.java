 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPFunctionDao;
import th.co.ais.ipfm.domain1.IpFunction;

public class HibernateIPFunctionDao extends HibernateGenericDao<IpFunction> implements IPFunctionDao {

	@Override
	public IpFunction findIPFunctionByFuncID(String funcId) throws DataAccessException{ // DMAP Comment : Dead Code Detected - The Following Method has no reference findIPFunctionByFuncID
//		System.out.println("--findIPFunctionByFuncID-- "+funcId);
		Session session = this.getSessionFactory().getCurrentSession();
		IpFunction result = new IpFunction();
String sql = "select t from IpFunction t where t.id.funcId = '" + funcId + "'";//String sql = "select t from IpFunction t where t.id.funcId = '"+funcId+"' ";
/**
DMAP TAG: Query converted: Identifier94
DMAP ConvertedQuery - select t from IpFunction t where t.id.funcId = 'funcId'
**/

		result = (IpFunction) session.createQuery(sql).uniqueResult();
		Hibernate.initialize(result);
		return result;
	}
}
