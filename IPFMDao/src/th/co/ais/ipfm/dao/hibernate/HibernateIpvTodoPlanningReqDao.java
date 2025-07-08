 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IpvTodoPlanningReqDao;
import th.co.ais.ipfm.domain1.IpvTodoPlanningReq;


public class HibernateIpvTodoPlanningReqDao extends HibernateGenericDao<IpvTodoPlanningReq> implements IpvTodoPlanningReqDao {

	@Override
	public List<IpvTodoPlanningReq> findTodoPlanningReq(String userId, String actionCode){ // DMAP Comment : Dead Code Detected - The Following Method has no reference findTodoPlanningReq
		Session session = getSessionFactory().getCurrentSession();
		List<IpvTodoPlanningReq> result = new ArrayList<IpvTodoPlanningReq>();
		String actionCodeSql = "";
		if (actionCode!=null && actionCode.trim().length()>0) {
			actionCodeSql = "and t.colCode = '"+actionCode+"' ";;
		}
		StringBuffer sql = new StringBuffer();
		System.out.println("userId = "+userId);
		System.out.println("actionCode = "+actionCode);
		sql.append("select t from IpvTodoPlanningReq t " +
				"where INSTR(';'|| t.actionUserId ||';' , ';'|| '"+userId+"' ||';' )>0 " + actionCodeSql +
				//"t.actionUserId = '"+userId+"' " + actionCodeSql +
				"order by t.colCode asc, t.urNo desc");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier95
DMAP ConvertedQuery - select t from IpvTodoPlanningReq t where position( CONCAT(';', 'userId' , ';') in CONCAT(';', t.actionUserId , ';')) >0 and t.colCode = 'actionCode' order by t.colCode asc, t.urNo desc
**/

/**
**/

		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);

		return result;
	}
}
