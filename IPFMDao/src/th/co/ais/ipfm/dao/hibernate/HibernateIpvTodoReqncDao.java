package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IpvTodoReqncDao;
import th.co.ais.ipfm.domain1.IpvTodoReqnc;


public class HibernateIpvTodoReqncDao extends HibernateGenericDao<IpvTodoReqnc> implements IpvTodoReqncDao {

	@Override
	public List<IpvTodoReqnc> findTodoReqNC(String userId, String actionCode) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvTodoReqnc> result = new ArrayList<IpvTodoReqnc>();
		String actionCodeSql = "";
		if (actionCode!=null && actionCode.trim().length()>0) {
			actionCodeSql = "and t.colCode = '"+actionCode+"' ";;
		}
		StringBuffer sql = new StringBuffer();
		System.out.println("userId = "+userId);
		System.out.println("actionCode = "+actionCode);
		sql.append("select distinct t from IpvTodoReqnc t "); 
				//"where t.actionUserId = '"+userId+"' " + actionCodeSql +
		sql.append(" where INSTR(';'|| t.actionUserId ||';' , ';'|| '"+userId+"' ||';' )> 0 " + actionCodeSql );
		sql.append("  order by " );
		sql.append((actionCode==null?"":(actionCode.trim().equals("")?"":(actionCode.trim().equals("10")?("lastUpd asc, "):"")))+" t.colCode asc, t.urNo desc, t.subUrNo asc ");
		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);
		
		return result;
	}
	

	public List<IpvTodoReqnc> findTodoReqNCUserVerify(String userId, String actionCode) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvTodoReqnc> result = new ArrayList<IpvTodoReqnc>();
		String actionCodeSql = "";
		if (actionCode!=null && actionCode.trim().length()>0) {
			actionCodeSql = "and t.colCode = '"+actionCode+"' ";;
		}
		StringBuffer sql = new StringBuffer();
		System.out.println("userId = "+userId);
		System.out.println("actionCode = "+actionCode);
		sql.append("select distinct t from IpvTodoReqnc t " +
				//"where t.actionUserId = '"+userId+"' " + actionCodeSql +
				"where INSTR(';'|| t.actionUserId ||';' , ';'|| '"+userId+"' ||';' )>0 " + actionCodeSql +
				"order by t.colCode asc, t.urNo desc, t.subUrNo asc ");
		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);
		
		return result;
	}
	
	@Override
	public List<IpvTodoReqnc> findTodoReqNCDraft(String userId, String actionCode) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvTodoReqnc> result = new ArrayList<IpvTodoReqnc>();
		String actionCodeSql = "";
		if (actionCode!=null && actionCode.trim().length()>0) {
			actionCodeSql = "and t.colCode = '"+actionCode+"' ";;
		}
		StringBuffer sql = new StringBuffer();
		System.out.println("userId = "+userId);
		System.out.println("actionCode = "+actionCode);
		sql.append("select distinct t from IpvTodoReqnc t " +
				"where INSTR(';'|| t.actionUserId ||';' , ';'|| '"+userId+"' ||';' )>0 " + actionCodeSql +
				"and t.created = (select max(a.created) " +
				"from IpvTodoReqnc a "+
				"where  instr(';'||a.actionUserId||';', ';'||'"+userId+"'||';')>0 "+
				"and a.colCode='"+actionCode+"' "+
				"and t.urNo = a.urNo "+
				") "+
				"order by t.colCode asc, t.urNo desc, t.subUrNo asc ");
		result = session.createQuery(sql.toString()).list();
		Hibernate.initialize(result);
		
		return result;
	}
	
	@Override
	public List<IpvTodoReqnc> findTodoReqNCNoRemark(String userId, String actionCode) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<IpvTodoReqnc> result = new ArrayList<IpvTodoReqnc>();
		String actionCodeSql = "";
		if (actionCode!=null && actionCode.trim().length()>0) {
			actionCodeSql = "and t.colCode = '"+actionCode+"' ";;
		}
		StringBuffer sql = new StringBuffer();
		System.out.println("userId = "+userId);
		System.out.println("actionCode = "+actionCode);
		sql.append("select distinct t.actionName,t.actionSeq,t.actionUser, t.actionUserId,t.callFunctionId,t.callMode" +
				",t.colCode,t.created ,t.createdBy ,t.createUserName,t.lastUpd as lastUpd,t.lastUpdBy,t.olaDate,t.olaSts" +
				",t.reqDate,t.reqUser,t.reqUserId ,t.slaDate ,t.slaSts,t.subject ,t.subUrNo ,t.subUrType" +
				",t.title1,t.title2SubUr,t.title2Ur,t.urNo,t.urStatus,t.urType "+
//			    ",  (select created from IpUrAction h where h.urNo = t.urNo and h.subUrNo = t.subUrNo   ) " +
//			    ",  (select max(lastUpd) from IpUrAction h where h.urNo = t.urNo) "+
                ",  (select max(lastUpd) from IpUrActionHistory h where h.urNo = t.urNo and h.urStatus = 'APPROVE_OWNER') as col_28_0_ "+
                
//				",t.actionRemark " +
				" from IpvTodoReqnc t " +
				"where INSTR(';'|| t.actionUserId ||';' , ';'|| '"+userId+"' ||';' )>0 " + actionCodeSql +
				"order by col_28_0_ asc, t.colCode asc, t.urNo desc, t.subUrNo asc ");
//		result = session.createQuery(sql.toString()).list();
		System.out.println("TEST ==> "+sql.toString());
		List result1 = session.createQuery(sql.toString()).list();
		Iterator iter = result1.iterator();
		int i=0;
	 	 while (iter.hasNext()) {
           Object[] obj = (Object[]) iter.next();            
           IpvTodoReqnc bean = new IpvTodoReqnc();
           bean.setRowId("rowId"+i);
           bean.setActionName((String)obj[0]);
           bean.setActionSeq((String)obj[1]);
           bean.setActionUser((String)obj[2]);
           bean.setActionUserId((String)obj[3]);
//           bean.setActionRemark((String)obj[28]);
           bean.setCallFunctionId((String)obj[4]);
           bean.setCallMode((String)obj[5]);
           bean.setColCode((String)obj[6]);
           bean.setCreated((Date)obj[7]);
           bean.setCreatedBy((String)obj[8]);
           bean.setCreateUserName((String)obj[9]);
           bean.setLastUpd((Date)obj[10]);
           bean.setLastUpdBy((String)obj[11]);
           bean.setOlaDate((Date)obj[12]);
           bean.setOlaSts((Integer)obj[13]);
           bean.setReqDate((Date)obj[14]);
           bean.setReqUser((String)obj[15]);
           bean.setReqUserId((String)obj[16]);
           bean.setSlaDate((Date)obj[17]);
           bean.setSlaSts((Integer)obj[18]);
           bean.setSubject((String)obj[19]);
           bean.setSubUrNo((String)obj[20]);
           bean.setSubUrType((String)obj[21]);
           bean.setTitle1((String)obj[22]);
           bean.setTitle2SubUr((String)obj[23]);
           bean.setTitle2Ur((String)obj[24]);
           bean.setUrNo((String)obj[25]);
           bean.setUrStatus((String)obj[26]);
           bean.setUrType((String)obj[27]);
           bean.setWaitingPm((Date)obj[28]);
           result.add(bean);
           i++;
	 	 }
		
		return result;
	}
}
