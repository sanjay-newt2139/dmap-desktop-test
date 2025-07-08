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
	public List<IpvTodoUserReq> findTodoUserReq(String userId, String actionCode) throws DataAccessException {
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
		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);
		return result;
	}
}
