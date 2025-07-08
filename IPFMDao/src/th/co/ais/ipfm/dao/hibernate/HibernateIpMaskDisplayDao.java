 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpMaskDisplayDao;
import th.co.ais.ipfm.domain1.IpMaskDisplay;


public class HibernateIpMaskDisplayDao extends HibernateGenericDao<IpMaskDisplay> implements IpMaskDisplayDao {

	@Override
	public IpMaskDisplay findIpMaskDisplayByMask(String mask) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference findIpMaskDisplayByMask
		Session session = getSessionFactory().getCurrentSession();
		IpMaskDisplay result;
		StringBuffer sql = new StringBuffer();
		sql.append("select t from IpMaskDisplay t " +
				"where t.mask = '"+mask+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier122
DMAP ConvertedQuery - select t from IpMaskDisplay t where t.mask = 'mask'
**/

		result = (IpMaskDisplay) session.createQuery(sql.toString()).uniqueResult();
		Hibernate.initialize(result);
		
		return result;
	}
}
