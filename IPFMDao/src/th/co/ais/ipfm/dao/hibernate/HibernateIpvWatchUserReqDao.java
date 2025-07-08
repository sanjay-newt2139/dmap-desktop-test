 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpvWatchUserReqDao;
import th.co.ais.ipfm.domain1.IpvWatchUserReq;


public class HibernateIpvWatchUserReqDao extends HibernateGenericDao<IpvWatchUserReq> implements IpvWatchUserReqDao {

	@Override
	public List<IpvWatchUserReq> findWatchUserReq(String userId) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference findWatchUserReq
		Session session = getSessionFactory().getCurrentSession();
		List<IpvWatchUserReq> result = new ArrayList<IpvWatchUserReq>();
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate, " +
				"t.reqUserId,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.actionUser from IpvWatchUserReq t " +
				"where t.reqUserId = '"+userId+"' " +
				"order by t.urNo desc");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier329
DMAP ConvertedQuery - select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate, t.reqUserId,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.actionUser from IpvWatchUserReq t where t.reqUserId = 'userId' order by t.urNo desc
**/

		List result1 = session.createQuery(sql.toString()).list();
		Iterator iter = result1.iterator();
		int i=0;
	 	 while (iter.hasNext()) {
           Object[] obj = (Object[]) iter.next();            
           IpvWatchUserReq user = new IpvWatchUserReq();
           user.setRowId("rowId"+i);
           user.setTitle1((String) obj[0]);
           user.setSlaSts((Integer) obj[1]); 
           user.setUrNo((String) obj[2]);
           user.setSubject((String) obj[3]);			
           user.setReqDate((Date) obj[4]); 
           user.setSlaDate((Date) obj[5]);
           user.setReqUserId((String) obj[6]);
           user.setUrStatus((String) obj[7]);
           user.setUrType((String) obj[8]);
           user.setCallFunctionId((String) obj[9]);
           user.setCallMode((String) obj[10]);
           user.setActionUser((String) obj[11]);
           result.add(user);
           i++;
	 	 }
		Hibernate.initialize(result);
		
		return result;
	}
}
