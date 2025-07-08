 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpvTodoUserReqDao;
import th.co.ais.ipfm.domain1.IpvTodoUserReq;


public class HibernateIpvTodoUserReqDao extends HibernateGenericDao<IpvTodoUserReq> implements IpvTodoUserReqDao {

	@Override
	public List<IpvTodoUserReq> findTodoUserReq(String userId, String actionCode) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference findTodoUserReq
		Session session = getSessionFactory().getCurrentSession();
		List<IpvTodoUserReq> result = new ArrayList<IpvTodoUserReq>();
		String actionCodeSql = "";
		if (actionCode!=null && actionCode.trim().length()>0) {
			actionCodeSql = "and t.colCode = '"+actionCode+"' ";;
		}
		StringBuffer sql = new StringBuffer();
		System.out.println("userId = "+userId);
		System.out.println("actionCode = "+actionCode);
		sql.append("select t from IpvTodoUserReq t " +
				//"where t.actionUserId = '"+userId+"' " + actionCodeSql +
				"where INSTR(';'|| t.actionUserId ||';' , ';'|| '"+userId+"' ||';' )>0 " + actionCodeSql +
				"order by t.colCode asc , t.urNo desc");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier316
DMAP ConvertedQuery - select t from IpvTodoUserReq t where position( CONCAT(';', 'userId' , ';') in CONCAT(';', t.actionUserId , ';')) >0 and t.colCode = 'actionCode' order by t.colCode asc, t.urNo desc
**/

/**
**/

		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);
		return result;
	}
}
