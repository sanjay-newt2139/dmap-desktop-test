package th.co.ais.ipfm.dao.hibernate;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrActionHistoryDao;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.util.IPFMConstant;




public class HibernateIPUrActionHistoryDao extends HibernateGenericDao<IpUrActionHistory> implements IPUrActionHistoryDao{

	@Override
	public List<IpUrActionHistory> getHistoryList(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrActionHistory.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.addOrder(Order.asc("lastUpd"));
		criteria.addOrder(Order.asc("subUrNo"));
		criteria.addOrder(Order.asc("actionSeq"));
		return criteria.list();
	}
	
	@Override
	public IpUrActionHistory getIpUrActionHistory(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrActionHistory.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		return (IpUrActionHistory) criteria.uniqueResult();
	}

	@Override
	public IpUrActionHistory getPMAssign(String urNo, String urType,
			String subUrNo, String subUrType) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrActionHistory.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urType", urType));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		criteria.add(Restrictions.eq("subUrType", subUrType));
		criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_PM_ASSIGN));
		criteria.addOrder(Order.desc("actionSeq"));
		List ipUrH = criteria.list();
		if(ipUrH != null && ipUrH.size() >0) {
			return (IpUrActionHistory)criteria.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteByUrNo(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACTION_HISTORY AC WHERE AC.UR_NO=?";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}

	@Override
	public void copyHistory(IpUrActionHistory history) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(history);
	}
	
	@Override
	public BigDecimal getNextActionSeq(String urNo, String urType, String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		String seqNo =  (String) session.createSQLQuery("SELECT NVL(MAX(ACTION_SEQ),0)+1 as NEWSEQ " +
				"FROM IP_UR_ACTION_HISTORY WHERE UR_NO='"+urNo+"' AND " +
				"UR_TYPE = '"+urType+"' AND SUB_UR_NO = '"+subUrNo+"' " )
				.addScalar("NEWSEQ", Hibernate.STRING).uniqueResult();
		return new BigDecimal(seqNo);
	}
	
	@Override
	public void deleteNA(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACTION_HISTORY AC WHERE AC.UR_NO=? AND AC.SUB_UR_NO='NA'";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
	}

	@Override
	public List<IpUrActionHistory> findHistoryAction(String urNo, String urType) {
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrActionHistory> result = new ArrayList<IpUrActionHistory>();
		String sql = "select distinct t.ur_no,t.ur_type,t.sub_ur_no,t.sub_ur_type " +
					" from ip_ur_action_history t where t.ur_no = ? and t.ur_type = ? order by t.sub_ur_type,t.sub_ur_no";
		List list = session.createSQLQuery(sql).addScalar("ur_no",Hibernate.STRING)
					.addScalar("ur_type",Hibernate.STRING)
					.addScalar("sub_ur_no",Hibernate.STRING)
					.addScalar("sub_ur_type",Hibernate.STRING)
					.setString(0, urNo).setString(1, urType).list();
		Iterator iter = list.iterator();
		IpUrActionHistory history = null;
		while(iter.hasNext()){
			history = new IpUrActionHistory();
			Object[] obj =(Object[])iter.next();
			history.setUrNo((String)obj[0]);
			history.setUrType((String)obj[1]);
			history.setSubUrNo((String)obj[2]);
			history.setSubUrType((String)obj[3]);
			result.add(history);
		}
		return result;
	}
	
	@Override
	public List<IpUrActionHistory> findHistoryAction(String urNo,String subUrNo, String urType,String urStatus) {
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrActionHistory> result = new ArrayList<IpUrActionHistory>();
		String sql = "select distinct t.ur_no,t.ur_type,t.sub_ur_no,t.sub_ur_type " +
					" from ip_ur_action_history t where t.ur_no = ? and t.sub_ur_no = ? " +
					" and t.ur_type = ? and t.ur_status = ? " +
					" order by t.sub_ur_type,t.sub_ur_no";
		List list = session.createSQLQuery(sql).addScalar("ur_no",Hibernate.STRING)
					.addScalar("ur_type",Hibernate.STRING)
					.addScalar("sub_ur_no",Hibernate.STRING)
					.addScalar("sub_ur_type",Hibernate.STRING)
					.setString(0, urNo).setString(1, subUrNo)
					.setString(2, urType).setString(3, urStatus).list();
		Iterator iter = list.iterator();
		IpUrActionHistory history = null;
		while(iter.hasNext()){
			history = new IpUrActionHistory();
			Object[] obj =(Object[])iter.next();
			history.setUrNo((String)obj[0]);
			history.setUrType((String)obj[1]);
			history.setSubUrNo((String)obj[2]);
			history.setSubUrType((String)obj[3]);
			result.add(history);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpUrActionHistory> findListTeamReject(String urNo, String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrActionHistory> result = new ArrayList<IpUrActionHistory>();
		String sql = "select ac.* from ip_ur_action_history ac , "+
			" (select distinct(i.action_user_id)  actionName , max(i.update_date)  maxDate  " +
			" from ip_ur_action_history i  "+
			" where  i.ur_no = ? and i.sub_ur_no = ?  "+
			" and i.ur_status in ('COMPLETE_TEAM_WAIT' , 'REJECT_TEAM_WAIT', 'COMPLETE_TEAM', 'REJECT_TEAM') "+
			" group by i.action_user_id" +
			" having max(i.update_date) > (select max(h.update_date) "+ 
			" from ip_ur_action_history h where h.ur_no = ? "+
			" and h.sub_ur_no = ? "+
			" and h.ur_status in ('PM_ASSIGN'))"+
			" ) dd where ac.action_user_id=dd.actionName  "+
			" and ac.update_date=dd.maxDate and ac.ur_no = ? and ac.sub_ur_no = ? "+
			" order by ac.action_seq";
		result = session.createSQLQuery(sql).addEntity(IpUrActionHistory.class)
		.setString(0, urNo).setString(1, subUrNo).setString(2, urNo).setString(3, subUrNo).setString(4, urNo).setString(5, subUrNo).list();
		return result;
	}
}
