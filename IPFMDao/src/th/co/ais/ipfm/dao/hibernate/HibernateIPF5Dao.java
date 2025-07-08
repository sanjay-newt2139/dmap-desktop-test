package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IIPF5Dao;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrF5Id;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvRetriveF5;

public class HibernateIPF5Dao extends HibernateGenericDao<IpUrF5> implements IIPF5Dao {

	@Override
	public String getSubUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		System.out.println("Find Sub Ur For URNO >> "+urNo);
		String subUrNo =  (String) session.createSQLQuery("SELECT NVL(MAX(T1.SUB_UR_NO),0) AS MAX_SUB_UR_NO FROM IP_UR_F5 T1 WHERE T1.UR_NO='"+urNo.trim()+"'")
				.addScalar("MAX_SUB_UR_NO", Hibernate.STRING).uniqueResult();
		return subUrNo;
	}

	@Override
	public List<IpUrF5> findByURNo(String urno) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrF5.class);
		criteria.add(Restrictions.eq("id.urNo", urno));
		criteria.add(Restrictions.or(
				Restrictions.eq("changeType","A"),
				Restrictions.isNull("changeType")));
		criteria.addOrder(Order.asc("id.subUrNo"));
		return criteria.list();
	}

	@Override
	public IpUrF5 getID(IpUrF5Id id) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrF5.class);
		criteria.add(Restrictions.eq("id", id));
		List result = criteria.list();
		return (result.size()!=0)?(IpUrF5)result.get(0):null;
	}

	@Override
	public List<IpMasterTable> getProperty(String refTable){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable", refTable));
		criteria.addOrder(Order.asc("shortDesc"));
		return criteria.list();
	}

	@Override
	public List<IpvRetriveF5> retriveF5(String vip, String port, String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpvRetriveF5.class);
		criteria.add(Restrictions.eq("ipAddress", vip));
		criteria.add(Restrictions.eq("vipPort", port));

		return criteria.list();
	}
	@Override
	public void cancelImpact(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "UPDATE IP_UR_F5 set IS_IMPACT='N' WHERE UR_NO=?";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	@Override
	public void deleteByUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_F5 F5 WHERE F5.UR_NO=?";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}

	@Override
	public void delete(String urNo, String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_F5 FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN ("+subUrNo+")";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	
	@Override
	public void updateSubUrStatus(IpUrF5Id id, String status,IpUser user) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("update IP_UR_F5 ");
		sql.append("set SUB_UR_STATUS=? ");
		sql.append(" , UPDATE_BY=? ");
		sql.append(" , UPDATE_DATE=SYSDATE ");
		sql.append("where (SUB_UR_NO=? and UR_NO=?)");
		session.createSQLQuery(sql.toString())
			.setString(0, status)
			.setString(1, user.getUserId())
			.setString(2, id.getSubUrNo())
			.setString(3, id.getUrNo())
			.executeUpdate();
	}
	
	@Override
	public void commitSubURDelete(String urNo, String changeType) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer deleteSQL = new StringBuffer();
		deleteSQL.append("DELETE from IP_UR_F5 "); 
		deleteSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) ");
		session.createSQLQuery(deleteSQL.toString())
			.setString(0, urNo)
			.setString(1, changeType)
			.executeUpdate();
		
	}

	@Override
	public void commitSubURUpdate(String urNo, String changeType) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer updateSQL = new StringBuffer();
		updateSQL.append("UPDATE IP_UR_F5 "); 
		updateSQL.append("SET CHANGE_TYPE='' ");
		updateSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) "); 
		session.createSQLQuery(updateSQL.toString())
			.setString(0, urNo)
			.setString(1, changeType)
			.executeUpdate();
		
		
	}

	@Override
	public List<IpUrF5> waitDeleteUr(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrF5.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("changeType", "D"));
		return criteria.list();
	}

	@Override
	public IpUrF5 fineIpUrF5(String urNo,String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrF5.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));
		return (IpUrF5) criteria.uniqueResult();
	}
	
	
}
