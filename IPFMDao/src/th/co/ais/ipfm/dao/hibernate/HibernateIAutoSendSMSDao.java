 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IAutoSendSMSDao;
import th.co.ais.ipfm.domain1.IpWfConfig;


public class HibernateIAutoSendSMSDao extends HibernateGenericDao<IpWfConfig> implements IAutoSendSMSDao {

	@Override
	public String getSMSNo(String urType){ //urType = IP23 // DMAP Comment : Dead Code Detected - The Following Method has no reference getSMSNo
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT SMS_MOBILE_NO_LIST FROM IP_WF_CONFIG WHERE UR_TYPE = '"+urType+"' AND ROWNUM = 1 ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier343
DMAP ConvertedQuery - SELECT SMS_MOBILE_NO_LIST FROM IP_WF_CONFIG WHERE UR_TYPE = 'urType' LIMIT 1
**/

		String smsNoList = (String)session.createSQLQuery(sql.toString())		
				.addScalar("SMS_MOBILE_NO_LIST", Hibernate.STRING).uniqueResult();
		return smsNoList;
	
	}

	@Override
	public String getSMSWording(String refKey){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getSMSWording
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT SHORT_DESC FROM IP_MASTER_TABLE WHERE REF_TABLE = 'SMS_OSLA' AND REF_KEY = '"+refKey+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier342
DMAP ConvertedQuery - SELECT SHORT_DESC FROM IP_MASTER_TABLE WHERE REF_TABLE = 'SMS_OSLA' AND REF_KEY = 'refKey'
**/

		String smsWording = (String)session.createSQLQuery(sql.toString())		
				.addScalar("SHORT_DESC", Hibernate.STRING).uniqueResult();
		return smsWording;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<String> getIPUROverSLAList(String urType){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getIPUROverSLAList
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.UR_NO AS UR_NO FROM IP_UR_IP_DETAIL A WHERE A.OVER_SLA = 'Y' AND A.SEND_SMS = 'N' AND A.UR_TYPE = '"+urType+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier341
DMAP ConvertedQuery - SELECT A.UR_NO AS UR_NO FROM IP_UR_IP_DETAIL A WHERE A.OVER_SLA = 'Y' AND A.SEND_SMS = 'N' AND A.UR_TYPE = 'urType'
**/

		List<String>  urList = session.createSQLQuery(sql.toString())
				.addScalar("UR_NO", Hibernate.STRING).list();
		return urList;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<String> getNCUROverSLAList(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getNCUROverSLAList
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.UR_NO AS UR_NO FROM IP_UR_NW_CONFIG A WHERE A.OVER_SLA = 'Y' AND A.SEND_SMS = 'N' ");
/**
DMAP TAG: Query converted but found same: Identifier340
DMAP ConvertedQuery - SELECT A.UR_NO AS UR_NO FROM IP_UR_NW_CONFIG A WHERE A.OVER_SLA = 'Y' AND A.SEND_SMS = 'N'
**/

		List<String>  urList = session.createSQLQuery(sql.toString())
				.addScalar("UR_NO", Hibernate.STRING).list();
		return urList;
	}

	@Override
	public void updateIPURNo(String urNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference updateIPURNo
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE IP_UR_IP_DETAIL SET SEND_SMS = 'Y' WHERE UR_NO = ? ");
/**
DMAP TAG: Query converted but found same: Identifier339
DMAP ConvertedQuery - UPDATE IP_UR_IP_DETAIL SET SEND_SMS = 'Y' WHERE UR_NO = ?
**/

		session.createSQLQuery(sql.toString()).setString(0, urNo).executeUpdate();		
	}

	@Override
	public void updateNCURNo(String urNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference updateNCURNo
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE IP_UR_NW_CONFIG SET SEND_SMS = 'Y' WHERE UR_NO = ? ");
/**
DMAP TAG: Query converted but found same: Identifier338
DMAP ConvertedQuery - UPDATE IP_UR_NW_CONFIG SET SEND_SMS = 'Y' WHERE UR_NO = ?
**/

		session.createSQLQuery(sql.toString()).setString(0, urNo).executeUpdate();		
	}

}
