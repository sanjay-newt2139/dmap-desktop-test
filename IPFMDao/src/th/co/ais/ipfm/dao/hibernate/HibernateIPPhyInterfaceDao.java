 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IIPPhysicalInterfaceDao;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListCdnId;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterfaceId;
import th.co.ais.ipfm.domain1.IpUser;

public class HibernateIPPhyInterfaceDao extends HibernateGenericDao<IpUrPhysicalInterface> implements IIPPhysicalInterfaceDao {

	@Override
	public String getSubUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		System.out.println("Find Sub Ur For URNO >> "+urNo);
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier418
DMAP ConvertedQuery - SELECT coalesce(MAX(CAST(T1.SUB_UR_NO AS numeric)), 0) AS MAX_SUB_UR_NO FROM IP_UR_PHYSICAL_INTERFACE T1 WHERE T1.UR_NO='urNo.trim()'
**/

		String subUrNo =  (String) session.createSQLQuery("SELECT NVL(MAX(T1.SUB_UR_NO),0) AS MAX_SUB_UR_NO FROM IP_UR_PHYSICAL_INTERFACE T1 WHERE T1.UR_NO='"+urNo.trim()+"'")
				.addScalar("MAX_SUB_UR_NO", Hibernate.STRING).uniqueResult();
		return subUrNo;
	}

	@Override
	public List<IpUrPhysicalInterface> findByURNo(String urno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByURNo
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrPhysicalInterface.class);
		criteria.add(Restrictions.eq("id.urNo", urno));
		criteria.add(Restrictions.or(
				Restrictions.eq("changeType","A"),
				Restrictions.isNull("changeType")));
		criteria.addOrder(Order.asc("id.subUrNo"));
		return criteria.list();
	}

	@Override
	public IpUrPhysicalInterface getID(IpUrPhysicalInterfaceId id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getID
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrPhysicalInterface.class);
		criteria.add(Restrictions.eq("id", id));
		List result = criteria.list();
		return (result.size()!=0)?(IpUrPhysicalInterface)result.get(0):null;
	}

	@Override
	public List<IpMasterTable> getProperty(String refTable){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getProperty
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable", refTable));
		criteria.addOrder(Order.asc("shortDesc"));
		return criteria.list();
	}

	@Override
	public void deleteByUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteByUrNo
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM ip_ur_physical_interface pi WHERE pi.UR_NO=?";
/**
DMAP TAG: Query converted but found same: Identifier417
DMAP ConvertedQuery - DELETE FROM ip_ur_physical_interface pi WHERE pi.UR_NO=?
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}

	@Override
	public String getIntfNodeTypeId(String desc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIntfNodeTypeId
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable","ND_TYPE"));
		criteria.add(Restrictions.eq("shortDesc",desc));
		IpMasterTable ms = (IpMasterTable)criteria.uniqueResult();
		return (ms!=null)?ms.getId().getRefKey():"";
		
	}

	@Override
	public String getSpeedPortId(String desc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSpeedPortId
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable","ND_TYPE"));
		criteria.add(Restrictions.eq("shortDesc",desc));
		IpMasterTable ms = (IpMasterTable)criteria.uniqueResult();
		return (ms!=null)?ms.getId().getRefKey():"";
		
	}

	@Override
	public String getStatusId(String desc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatusId
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable","SPEED_PORT"));
		criteria.add(Restrictions.eq("shortDesc",desc));
		IpMasterTable ms = (IpMasterTable)criteria.uniqueResult();
		return (ms!=null)?ms.getId().getRefKey():"";
		
	}
	@Override
	public void cancelImpact(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference cancelImpact
		Session session = getSessionFactory().getCurrentSession();
		String sql = "UPDATE IP_UR_PHYSICAL_INTERFACE set IS_IMPACT='N' WHERE UR_NO=?";
/**
DMAP TAG: Query converted but found same: Identifier416
DMAP ConvertedQuery - UPDATE IP_UR_PHYSICAL_INTERFACE set IS_IMPACT='N' WHERE UR_NO=?
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}
	@Override
	public void delete(String urNo, String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference delete
		Session session = getSessionFactory().getCurrentSession();
String sql = "DELETE FROM IP_UR_PHYSICAL_INTERFACE FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN (" + subUrNo + ")";//String sql = "DELETE FROM IP_UR_PHYSICAL_INTERFACE FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN ("+subUrNo+")";
/**
DMAP TAG: Query converted: Identifier415
DMAP ConvertedQuery - DELETE FROM IP_UR_PHYSICAL_INTERFACE FW WHERE FW.UR_NO=? AND FW.SUB_UR_NO IN (subUrNo)
**/

		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
	}
	
	@Override
	public void updateSubUrStatus(IpUrPhysicalInterfaceId id, String status,IpUser user) { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateSubUrStatus
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("update IP_UR_PHYSICAL_INTERFACE ");
		sql.append("set SUB_UR_STATUS=? ");
		sql.append(" , UPDATE_BY=? ");
		sql.append(" , UPDATE_DATE=SYSDATE ");
		sql.append("where (SUB_UR_NO=? and UR_NO=?)");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier414
DMAP ConvertedQuery - update IP_UR_PHYSICAL_INTERFACE set SUB_UR_STATUS=? , UPDATE_BY=? , UPDATE_DATE=statement_timestamp() WHERE (SUB_UR_NO=? and UR_NO=?)
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
		deleteSQL.append("DELETE from IP_UR_PHYSICAL_INTERFACE "); 
		deleteSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) ");
/**
DMAP TAG: Query converted but found same: Identifier413
DMAP ConvertedQuery - DELETE from IP_UR_PHYSICAL_INTERFACE WHERE (UR_NO=?) AND (CHANGE_TYPE=?)
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
		updateSQL.append("UPDATE IP_UR_PHYSICAL_INTERFACE "); 
		updateSQL.append("SET CHANGE_TYPE='' ");
		updateSQL.append("WHERE (UR_NO=?) AND (CHANGE_TYPE=?) "); 
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier412
DMAP ConvertedQuery - UPDATE IP_UR_PHYSICAL_INTERFACE SET CHANGE_TYPE = NULL WHERE (UR_NO=?) AND (CHANGE_TYPE=?)
**/

		session.createSQLQuery(updateSQL.toString())
			.setString(0, urNo)
			.setString(1, changeType)
			.executeUpdate();
		
		
	}

	@Override
	public List<IpUrPhysicalInterface> waitDeleteUr(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference waitDeleteUr
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrPhysicalInterface.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("changeType", "D"));
		return criteria.list();
	}

	@Override
	public boolean hasProperty(String type,String refTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference hasProperty
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable", refTable));
		criteria.add(Restrictions.eq("shortDesc", type));
		IpMasterTable master = (IpMasterTable)criteria.uniqueResult();		
		return (master!=null);
	}

	@Override
	public IpUrPhysicalInterface findIpUrPhysicalInterface(String urno,String subUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findIpUrPhysicalInterface
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrPhysicalInterface.class);
		criteria.add(Restrictions.eq("id.urNo", urno));
		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));
		return (IpUrPhysicalInterface) criteria.uniqueResult();
	}
	
}
