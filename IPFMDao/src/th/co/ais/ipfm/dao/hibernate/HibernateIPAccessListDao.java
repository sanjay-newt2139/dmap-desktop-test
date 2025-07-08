 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IIPAccessListDao;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListCdnId;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUser;

public class HibernateIPAccessListDao extends HibernateGenericDao<IpUrAccessListCdn> implements IIPAccessListDao {

	@Override
	public String getSubUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		System.out.println("Find Sub Ur For URNO >> "+urNo);
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier7
DMAP ConvertedQuery - SELECT coalesce(MAX(CAST(T1.SUB_UR_NO AS numeric)), 0) AS MAX_SUB_UR_NO FROM IP_UR_ACCESS_LIST_CDN T1 WHERE T1.UR_NO='urNo.trim()'
**/

		String subUrNo =  (String) session.createSQLQuery("SELECT NVL(MAX(T1.SUB_UR_NO),0) AS MAX_SUB_UR_NO FROM IP_UR_ACCESS_LIST_CDN T1 WHERE T1.UR_NO='"+urNo.trim()+"'")
				.addScalar("MAX_SUB_UR_NO", Hibernate.STRING).uniqueResult();
		return subUrNo;
	}

	@Override
	public IpUrAccessListCdn getID(IpUrAccessListCdnId id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getID
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAccessListCdn.class);
		criteria.add(Restrictions.eq("id", id));
		List result = criteria.list();
		return (result.size()!=0)?(IpUrAccessListCdn)result.get(0):null;
	}

	@Override
	public List<IpUrAccessListCdn> findByURNo(String urno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByURNo
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAccessListCdn.class);
		criteria.add(Restrictions.eq("id.urNo", urno));
		criteria.add(Restrictions.or(
				Restrictions.eq("changeType","A"),
				Restrictions.isNull("changeType")));
		criteria.addOrder(Order.asc("id.subUrNo"));
		return criteria.list();
	}
	@Override
	public void cancelImpact(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference cancelImpact
		Session session = getSessionFactory().getCurrentSession();
		String sql = "UPDATE IP_UR_ACCESS_LIST_CDN set IS_IMPACT='N' WHERE UR_NO=?";
/**
DMAP TAG: Query converted but found same: Identifier6
DMAP ConvertedQuery - UPDATE IP_UR_ACCESS_LIST_CDN set IS_IMPACT='N' WHERE UR_NO=?
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	@Override
	public void deleteByUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteByUrNo
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACCESS_LIST_CDN AL WHERE AL.UR_NO=?";
/**
DMAP TAG: Query converted but found same: Identifier5
DMAP ConvertedQuery - DELETE FROM IP_UR_ACCESS_LIST_CDN AL WHERE AL.UR_NO=?
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}

	@Override
	public void delete(String urNo, String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference delete
		Session session = getSessionFactory().getCurrentSession();
String sql = "DELETE FROM IP_UR_ACCESS_LIST_CDN FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN (" + subUrNo + ")";//String sql = "DELETE FROM IP_UR_ACCESS_LIST_CDN FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN ("+subUrNo+")";
/**
DMAP TAG: Query converted: Identifier4
DMAP ConvertedQuery - DELETE FROM IP_UR_ACCESS_LIST_CDN FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN (subUrNo)
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	
	@Override
	public void updateSubUrStatus(IpUrAccessListCdnId id, String status,IpUser user) { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateSubUrStatus
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("update IP_UR_ACCESS_LIST_CDN ");
		sql.append("set SUB_UR_STATUS=? ");
		sql.append(" , UPDATE_BY=? ");
		sql.append(" , UPDATE_DATE=SYSDATE ");
		sql.append("where (SUB_UR_NO=? and UR_NO=?)");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier3
DMAP ConvertedQuery - update IP_UR_ACCESS_LIST_CDN set SUB_UR_STATUS=? , UPDATE_BY=? , UPDATE_DATE=statement_timestamp() WHERE (SUB_UR_NO=? and UR_NO=?)
**/

		session.createSQLQuery(sql.toString())
			.setString(0, status)
			.setString(1, user.getUserId())
			.setString(2, id.getSubUrNo())
			.setString(3, id.getUrNo())
			.executeUpdate();
	}

	@Override
	public void commitSubURDelete(String urNo, String changeType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference commitSubURDelete
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer deleteSQL = new StringBuffer();
		deleteSQL.append("DELETE from IP_UR_ACCESS_LIST_CDN "); 
		deleteSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) ");
/**
DMAP TAG: Query converted but found same: Identifier2
DMAP ConvertedQuery - DELETE from IP_UR_ACCESS_LIST_CDN WHERE (UR_NO=?) AND (CHANGE_TYPE=?)
**/

		session.createSQLQuery(deleteSQL.toString())
			.setString(0, urNo)
			.setString(1, changeType)
			.executeUpdate();
		
	}

	@Override
	public void commitSubURUpdate(String urNo, String changeType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference commitSubURUpdate
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer updateSQL = new StringBuffer();
		updateSQL.append("UPDATE IP_UR_ACCESS_LIST_CDN "); 
		updateSQL.append("SET CHANGE_TYPE='' ");
		updateSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) "); 
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier1
DMAP ConvertedQuery - UPDATE IP_UR_ACCESS_LIST_CDN SET CHANGE_TYPE = NULL WHERE (UR_NO=?) AND (CHANGE_TYPE=?)
**/

		session.createSQLQuery(updateSQL.toString())
			.setString(0, urNo)
			.setString(1, changeType)
			.executeUpdate();
		
		
	}

	@Override
	public List<IpUrAccessListCdn> waitDeleteUr(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference waitDeleteUr
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAccessListCdn.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("changeType", "D"));
		return criteria.list();
	}
	
	@Override
	public IpUrAccessListCdn findIpUrAccessList(String urno,String subUrNo ) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findIpUrAccessList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAccessListCdn.class);
		criteria.add(Restrictions.eq("id.urNo", urno));
		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));
		return (IpUrAccessListCdn) criteria.uniqueResult();
	}

	
}
