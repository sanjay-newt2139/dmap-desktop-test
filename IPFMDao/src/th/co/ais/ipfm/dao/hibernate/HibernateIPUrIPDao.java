package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPUrIPDao;
import th.co.ais.ipfm.domain.IPUrIP;



public class HibernateIPUrIPDao extends HibernateGenericDao<IPUrIP> implements IIPUrIPDao{

	@Override
	public IPUrIP searchIPUrIPByID(String urNO) throws DataAccessException,Exception {
		Session session = getSessionFactory().getCurrentSession();
		
		IPUrIP result = new IPUrIP();
		
		try{
			StringBuffer sql = new StringBuffer();
			//sql.append("select t from IPUrIP t where t.urNo = '"+urNO+"' ");
			sql.append("select t.* from IP_UR_IP t where t.UR_No = '"+urNO+"' ");
			result = (IPUrIP)session.createSQLQuery(sql.toString()).addEntity(IPUrIP.class).uniqueResult();
			System.out.println("----------result----------");
			Hibernate.initialize(result);
		}catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getMaxId() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String maxid =  (String) session.createSQLQuery("  SELECT 'IP' || TO_CHAR(SYSDATE,'YYYY') || LPAD(UR_IP_SEQ.NEXTVAL ,6,'0') as maxid  FROM DUAL ")
				.addScalar("maxid", Hibernate.STRING).uniqueResult();
		return maxid;
	}
	@Override
	public String getSysdate() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String sysDate =  (String) session.createSQLQuery("SELECT  to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')   as datenow  FROM dual")
				.addScalar("datenow", Hibernate.STRING).uniqueResult();
		return sysDate;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getURNo() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String urNo =  (String) session.createSQLQuery("  SELECT 	'IP' || TO_CHAR(SYSDATE,'YYYY') || LPAD(UR_IP_SEQ.NEXTVAL ,6,'0') as urNo FROM 	DUAL ")
				.addScalar("urNo", Hibernate.STRING).uniqueResult();
		return urNo;
	}

}
