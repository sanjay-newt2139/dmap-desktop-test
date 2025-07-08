package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IpvWatchPlanningReqDao;
import th.co.ais.ipfm.domain1.IpvWatchPlanningReq;


public class HibernateIpvWatchPlanningReqDao extends HibernateGenericDao<IpvWatchPlanningReq> implements IpvWatchPlanningReqDao {

	@Override
	public List<IpvWatchPlanningReq> findWatchPlanningReq(String userId){
		Session session = getSessionFactory().getCurrentSession();
		List<IpvWatchPlanningReq> result = new ArrayList<IpvWatchPlanningReq>();
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate, " +
				"t.reqUserId,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.actionUser from IpvWatchPlanningReq t " +
				"where t.reqUserId = '"+userId+"' "  +
				"order by t.urNo desc");
		
		List result1 = session.createQuery(sql.toString()).list();
		Iterator iter = result1.iterator();
		int i=0;
	 	 while (iter.hasNext()) {
           Object[] obj = (Object[]) iter.next();            
           IpvWatchPlanningReq planning = new IpvWatchPlanningReq();
           planning.setRowId("rowId"+i);
           planning.setTitle1((String) obj[0]);
           planning.setSlaSts((Integer) obj[1]); 
           planning.setUrNo((String) obj[2]);
           planning.setSubject((String) obj[3]);			
           planning.setReqDate((Date) obj[4]); 
           planning.setSlaDate((Date) obj[5]);
           planning.setReqUserId((String) obj[6]);
           planning.setUrStatus((String) obj[7]);
           planning.setUrType((String) obj[8]);
           planning.setCallFunctionId((String) obj[9]);
           planning.setCallMode((String) obj[10]);
           planning.setActionUser((String) obj[11]);
           result.add(planning);
           i++;
	 	 }
		Hibernate.initialize(result);
		
		return result;
	}
}
