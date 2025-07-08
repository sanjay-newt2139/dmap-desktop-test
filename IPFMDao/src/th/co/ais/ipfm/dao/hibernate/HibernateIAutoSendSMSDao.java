package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IAutoSendSMSDao;
import th.co.ais.ipfm.domain1.IpWfConfig;


public class HibernateIAutoSendSMSDao extends HibernateGenericDao<IpWfConfig> implements IAutoSendSMSDao {

	@Override
	public String getSMSNo(String urType){ //urType = IP23
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT SMS_MOBILE_NO_LIST FROM IP_WF_CONFIG WHERE UR_TYPE = '"+urType+"' AND ROWNUM = 1 ");
		String smsNoList = (String)session.createSQLQuery(sql.toString())		
				.addScalar("SMS_MOBILE_NO_LIST", Hibernate.STRING).uniqueResult();
		return smsNoList;
	
	}

	@Override
	public String getSMSWording(String refKey){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT SHORT_DESC FROM IP_MASTER_TABLE WHERE REF_TABLE = 'SMS_OSLA' AND REF_KEY = '"+refKey+"' ");
		String smsWording = (String)session.createSQLQuery(sql.toString())		
				.addScalar("SHORT_DESC", Hibernate.STRING).uniqueResult();
		return smsWording;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<String> getIPUROverSLAList(String urType){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.UR_NO AS UR_NO FROM IP_UR_IP_DETAIL A WHERE A.OVER_SLA = 'Y' AND A.SEND_SMS = 'N' AND A.UR_TYPE = '"+urType+"' ");
		List<String>  urList = session.createSQLQuery(sql.toString())
				.addScalar("UR_NO", Hibernate.STRING).list();
		return urList;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<String> getNCUROverSLAList(){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.UR_NO AS UR_NO FROM IP_UR_NW_CONFIG A WHERE A.OVER_SLA = 'Y' AND A.SEND_SMS = 'N' ");
		List<String>  urList = session.createSQLQuery(sql.toString())
				.addScalar("UR_NO", Hibernate.STRING).list();
		return urList;
	}

	@Override
	public void updateIPURNo(String urNo){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE IP_UR_IP_DETAIL SET SEND_SMS = 'Y' WHERE UR_NO = ? ");
		session.createSQLQuery(sql.toString()).setString(0, urNo).executeUpdate();		
	}

	@Override
	public void updateNCURNo(String urNo){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE IP_UR_NW_CONFIG SET SEND_SMS = 'Y' WHERE UR_NO = ? ");
		session.createSQLQuery(sql.toString()).setString(0, urNo).executeUpdate();		
	}

}
