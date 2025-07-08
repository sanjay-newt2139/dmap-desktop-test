package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IpvMonitorReqncDao;
import th.co.ais.ipfm.domain1.IpvMonitorReqnc;


public class HibernateIpvMonitorReqncDao extends HibernateGenericDao<IpvMonitorReqnc> implements IpvMonitorReqncDao {

//	@Override
//	public List<IpvMonitorReqnc> findMonitorReqNC(String userId) throws Exception {
//		Session session = getSessionFactory().getCurrentSession();
//		List<IpvMonitorReqnc> result = new ArrayList<IpvMonitorReqnc>();
//		String role = (String)session.createSQLQuery("select distinct 'ACTM' ACTM from IP_ROLE_MEMBER where USER_ID = ? and ROLE_ID = 'R08' ").addScalar("ACTM", Hibernate.STRING).setString(0, userId).uniqueResult();
//		List result1;
//		if (role==null || role.trim().length()==0) {
//			StringBuffer sql = new StringBuffer();
//			sql.append("select distinct t.title1, t.slaSts, t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode from IpvMonitorReqnc t " +
//					"where INSTR(';'|| t.actionUserId ||';' , ';'||?||';' )>0" +
//					"order by t.urNo desc");
//			result1 = session.createQuery(sql.toString()).setString(0, userId).list();
//		}else{
//			StringBuffer sql = new StringBuffer();
//			sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode from IpvMonitorReqnc t " +
//					"order by t.urNo desc");
//			result1 = session.createQuery(sql.toString()).list();
//		}
//		Iterator iter = result1.iterator();
//		int i=0;
//	 	 while (iter.hasNext()) {
//           Object[] obj = (Object[]) iter.next();            
//           IpvMonitorReqnc bean = new IpvMonitorReqnc();
//           bean.setRowId("rowId"+i);
//           bean.setTitle1((String) obj[0]);
//           bean.setSlaSts((Integer) obj[1]); 
//           bean.setUrNo((String) obj[2]);
//           bean.setSubject((String) obj[3]);			
//           bean.setReqDate((Date) obj[4]); 
//           bean.setSlaDate((Date) obj[5]);
//           bean.setUrStatus((String) obj[6]);
//           bean.setUrType((String) obj[7]);
//           bean.setCallFunctionId((String) obj[8]);
//           bean.setCallMode((String) obj[9]);
//           result.add(bean);
//           i++;
//	 	 }
//		Hibernate.initialize(result);
//		
//		return result;
//	}
	
	@Override
	public List<IpvMonitorReqnc> findMonitorReqNC(String userId) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvMonitorReqnc> result = new ArrayList<IpvMonitorReqnc>();
		List<String> role = session.createSQLQuery("select distinct(role_id) role from ip_role_member rm where rm.role_id in ('R06','R07','R08') and rm.user_id=? ").addScalar("role", Hibernate.STRING).setString(0, userId).list();
		
		List result1 = null;
		if (role != null && role.size() > 0) {
			StringBuffer sql = new StringBuffer();
			if(role.contains("R08") || (role.contains("R06") && role.contains("R07"))) {
				sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvMonitorReqnc t order by t.urNo desc , t.subUrNo asc ");
			} else if(role.contains("R06")) {
				sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvMonitorReqnc t where t.subUrType='AT' order by t.urNo desc, t.subUrNo asc ");
			} else if(role.contains("R07")) {
				sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvMonitorReqnc t where t.subUrType<>'AT' order by t.urNo desc, t.subUrNo asc ");
			}

			result1 = session.createQuery(sql.toString()).list();
			
			if(result1 != null && result1.size() > 0) {
				Iterator iter = result1.iterator();
				int i=0;
			 	 while (iter.hasNext()) {
		           Object[] obj = (Object[]) iter.next();            
		           IpvMonitorReqnc bean = new IpvMonitorReqnc();
		           bean.setRowId("rowId"+i);
		           bean.setTitle1((String) obj[0]);
		           bean.setSlaSts((Integer) obj[1]); 
		           bean.setUrNo((String) obj[2]);
		           bean.setSubject((String) obj[3]);			
		           bean.setReqDate((Date) obj[4]); 
		           bean.setSlaDate((Date) obj[5]);
		           bean.setUrStatus((String) obj[6]);
		           bean.setUrType((String) obj[7]);
		           bean.setCallFunctionId((String) obj[8]);
		           bean.setCallMode((String) obj[9]);
		           bean.setSubUrNo((String) obj[10]);
		           result.add(bean);
		           i++;
			 	 }
			//Hibernate.initialize(result);		
			}
		}
		
		return result;
	}	
	
	
	@Override
	public int countMonitorReqNC(String userId) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvMonitorReqnc> result = new ArrayList<IpvMonitorReqnc>();
		List<String> role = session.createSQLQuery("select distinct(role_id) role from ip_role_member rm where rm.role_id in ('R06','R07','R08') and rm.user_id=? order by role ").addScalar("role", Hibernate.STRING).setString(0, userId).list();
		
		List result1 = null;
		if (role != null && role.size() > 0) {
			StringBuffer sql = new StringBuffer();
			if(role.contains("R08") || (role.contains("R06") && role.contains("R07"))) {
				sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvMonitorReqnc t " +
				"order by t.urNo desc");
			} else if(role.contains("R06")) {
				sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvMonitorReqnc t where t.subUrType='AT'" +
				"order by t.urNo desc");
			} else if(role.contains("R07")) {
				sql.append("select distinct t.title1,t.slaSts,t.urNo,t.subject,t.reqDate,t.slaDate,t.urStatus,t.urType,t.callFunctionId,t.callMode,t.subUrNo from IpvMonitorReqnc t where t.subUrType<>'AT'" +
				"order by t.urNo desc");
			}

			result1 = session.createQuery(sql.toString()).list();
			
			if(result1 != null && result1.size() > 0) {
				return result1.size();
			}
		}
		
		return 0;
	}	
}
