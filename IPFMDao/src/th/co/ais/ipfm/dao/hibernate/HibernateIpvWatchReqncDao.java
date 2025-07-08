package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IpvWatchReqncDao;
import th.co.ais.ipfm.domain1.IpvWatchReqnc;


public class HibernateIpvWatchReqncDao extends HibernateGenericDao<IpvWatchReqnc> implements IpvWatchReqncDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<IpvWatchReqnc> findWatchReqNC(String userId) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvWatchReqnc> result = new ArrayList<IpvWatchReqnc>();
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate," +
				"t.reqUserId,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvWatchReqnc t " +
				"where t.reqUserId = '"+userId+"' " +
				"order by t.urNo desc, t.subUrNo asc ");
		List result1 = session.createQuery(sql.toString()).list();
		Iterator iter = result1.iterator();
		int i=0;
	 	 while (iter.hasNext()) {
           Object[] obj = (Object[]) iter.next();            
           IpvWatchReqnc nc = new IpvWatchReqnc();
           nc.setRowId("rowId"+i);
           nc.setTitle1((String) obj[0]);
           nc.setSlaSts((Integer) obj[1]); 
           nc.setUrNo((String) obj[2]);
           nc.setSubUrNo((String) obj[11]);
           nc.setSubject((String) obj[3]);			
           nc.setReqDate((Date) obj[4]); 
           nc.setSlaDate((Date) obj[5]);
           nc.setReqUserId((String) obj[6]);
           nc.setUrStatus((String) obj[7]);
           nc.setUrType((String) obj[8]);
           nc.setCallFunctionId((String) obj[9]);
           nc.setCallMode((String) obj[10]);
           result.add(nc);
           i++;
	 	 }
		Hibernate.initialize(result);
		
		return result;
	}
}
