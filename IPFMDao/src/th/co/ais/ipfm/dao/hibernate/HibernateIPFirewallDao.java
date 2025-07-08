 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPFirewallDAO;
import th.co.ais.ipfm.domain.NCAssign;
import th.co.ais.ipfm.domain.NCData;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUser;

public class HibernateIPFirewallDao extends HibernateGenericDao<IpUrFirewall> implements IIPFirewallDAO{

	@Override
	public String genSubUrno(String urNo) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference genSubUrno
		Session session = getSessionFactory().getCurrentSession();
		System.out.println("Find Sub Ur For URNO >> "+urNo);
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier229
DMAP ConvertedQuery - SELECT coalesce(MAX(CAST(T1.SUB_UR_NO AS numeric)), 0) AS MAX_SUB_UR_NO FROM IP_UR_FIREWALL T1 WHERE T1.UR_NO='urNo.trim()'
**/

		String subUrNo =  (String) session.createSQLQuery("SELECT NVL(MAX(T1.SUB_UR_NO),0) AS MAX_SUB_UR_NO FROM IP_UR_FIREWALL T1 WHERE T1.UR_NO='"+urNo.trim()+"'")
				.addScalar("MAX_SUB_UR_NO", Hibernate.STRING).uniqueResult();
		return subUrNo;
	}
	
	@Override
	public List<IpUrFirewall> findByUrNo(String urNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference findByUrNo
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrFirewall.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.or(
				Restrictions.eq("changeType","A"),
				Restrictions.isNull("changeType")));
		criteria.addOrder(Order.asc("id.subUrNo"));
		return criteria.list();
	}

	// this part is old
	
	@Override
	public List<IpUrFirewall> listFirewall() { // DMAP Comment : Dead Code Detected - The Following Method has no reference listFirewall
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrFirewall.class);
		List<IpUrFirewall> temp = criteria.list(); 
		return temp;
	}

	@Override
	public List<NCData> listResultByPage(String type, String page) { // DMAP Comment : Dead Code Detected - The Following Method has no reference listResultByPage
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(NCData.class);
		criteria.add(Restrictions.eq("reqType", type));
		criteria.add(Restrictions.eq("prgId", page));
		return criteria.list(); 
	}

	@Override
	public List<NCAssign> listAssign(String page) { // DMAP Comment : Dead Code Detected - The Following Method has no reference listAssign
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(NCAssign.class);
		criteria.add(Restrictions.eq("prgId", page));
		return criteria.list(); 
	}

	@Override
	public NCData findUR(String type, String page, String urSubID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findUR
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(NCData.class);
		criteria.add(Restrictions.eq("reqType", type));
		criteria.add(Restrictions.eq("prgId", page));
		criteria.add(Restrictions.eq("subid", urSubID));
		List<NCData> temp = criteria.list();
		return (temp.size()!=0)?temp.get(0):null;
	}

	@Override
	public List<IpMasterTable> getServiceName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceName
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.add(Restrictions.eq("id.refTable", "SERVICE"));
		criteria.addOrder(Order.asc("shortDesc"));
		return criteria.list();
	}
	
	public IpMasterTable getServiceNameByRefId(String refId){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceNameByRefId
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refKey", refId));
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.add(Restrictions.eq("id.refTable", "SERVICE"));
		criteria.addOrder(Order.asc("shortDesc"));
		List<IpMasterTable> result = criteria.list(); 
		return (result.size()!=0)?result.get(0):null;
	}

	@Override
	public IpUrFirewall findByKey(IpUrFirewallId id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByKey
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrFirewall.class);
		criteria.add(Restrictions.eq("id", id));
		List<IpUrFirewall> result = criteria.list();
		return (result.size()!=0)?result.get(0):null;
	}

	@Override
	public void deleteByUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteByUrNo
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_FIREWALL FW WHERE FW.UR_NO=?";
/**
DMAP TAG: Query converted but found same: Identifier228
DMAP ConvertedQuery - DELETE FROM IP_UR_FIREWALL FW WHERE FW.UR_NO=?
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
	}

	@Override
	public void delete(String urNo, String subUrNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference delete
		Session session = getSessionFactory().getCurrentSession();
String sql = "DELETE FROM IP_UR_FIREWALL FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN (" + subUrNo + ")";//String sql = "DELETE FROM IP_UR_FIREWALL FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN ("+subUrNo+")";
/**
DMAP TAG: Query converted: Identifier227
DMAP ConvertedQuery - DELETE FROM IP_UR_FIREWALL FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN (subUrNo)
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	@Override
	public void cancelImpact(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference cancelImpact
		Session session = getSessionFactory().getCurrentSession();
		String sql = "UPDATE IP_UR_FIREWALL set IS_IMPACT='N' WHERE UR_NO=?";
/**
DMAP TAG: Query converted but found same: Identifier226
DMAP ConvertedQuery - UPDATE IP_UR_FIREWALL set IS_IMPACT='N' WHERE UR_NO=?
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	@Override
	public void updateSubUrStatus(IpUrFirewallId id, String status,IpUser user) { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateSubUrStatus
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("update ip_ur_firewall ");
		sql.append("set SUB_UR_STATUS=? ");
		sql.append(" , UPDATE_BY=? ");
		sql.append(" , UPDATE_DATE=SYSDATE ");
		sql.append("where (SUB_UR_NO=? and UR_NO=?)");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier225
DMAP ConvertedQuery - update ip_ur_firewall set SUB_UR_STATUS=? , UPDATE_BY=? , UPDATE_DATE=statement_timestamp() WHERE (SUB_UR_NO=? and UR_NO=?)
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
		deleteSQL.append("DELETE from IP_UR_FIREWALL "); 
		deleteSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) ");
/**
DMAP TAG: Query converted but found same: Identifier224
DMAP ConvertedQuery - DELETE from IP_UR_FIREWALL WHERE (UR_NO=?) AND (CHANGE_TYPE=?)
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
		updateSQL.append("UPDATE IP_UR_FIREWALL "); 
		updateSQL.append("SET CHANGE_TYPE='' ");
		updateSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) "); 
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier223
DMAP ConvertedQuery - UPDATE IP_UR_FIREWALL SET CHANGE_TYPE = NULL WHERE (UR_NO=?) AND (CHANGE_TYPE=?)
**/

		session.createSQLQuery(updateSQL.toString())
			.setString(0, urNo)
			.setString(1, changeType)
			.executeUpdate();
		
		
	}

	@Override
	public List<IpUrFirewall> waitDeleteUr(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference waitDeleteUr
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrFirewall.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("changeType", "D"));
		return criteria.list();
	}


	@Override
	public List<IpUrFirewall> findByUrNoSubUr(String urNo,String subUrNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference findByUrNoSubUr
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrFirewall.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));
		
		criteria.addOrder(Order.asc("id.subUrNo"));
		return criteria.list();
	}
	
	@Override
	public IpUrFirewall findIpUrFirewall(String urNo,String subUrNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference findIpUrFirewall
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrFirewall.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));

		return (IpUrFirewall) criteria.uniqueResult();
	}
	

}
