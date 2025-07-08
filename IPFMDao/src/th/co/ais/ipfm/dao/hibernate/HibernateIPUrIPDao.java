 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPUrIPDao;
import th.co.ais.ipfm.domain.IPUrIP;



public class HibernateIPUrIPDao extends HibernateGenericDao<IPUrIP> implements IIPUrIPDao{

	@Override
	public IPUrIP searchIPUrIPByID(String urNO) throws DataAccessException,Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference searchIPUrIPByID
		Session session = getSessionFactory().getCurrentSession();
		
		IPUrIP result = new IPUrIP();
		
		try{
			StringBuffer sql = new StringBuffer();
			//sql.append("select t from IPUrIP t where t.urNo = '"+urNO+"' ");
			sql.append("select t.* from IP_UR_IP t where t.UR_No = '"+urNO+"' ");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier352
DMAP ConvertedQuery - select t.* from IP_UR_IP t where t.UR_No = 'urNO'
**/

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
	public String getMaxId() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxId
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier351
DMAP ConvertedQuery - SELECT CONCAT('IP', TO_CHAR(statement_timestamp(), 'YYYY') , LPAD(nextvalCAST(('ur_ip_seq') AS text), 6, '0'::text) ) as maxid
**/

//		String maxid =  (String) session.createSQLQuery("  SELECT 'IP' || TO_CHAR(SYSDATE,'YYYY') || LPAD(UR_IP_SEQ.NEXTVAL ,6,'0') as maxid  FROM DUAL ")
		String maxid =  (String) session.createSQLQuery("SELECT CONCAT('IP', TO_CHAR(statement_timestamp(), 'YYYY') , LPAD(nextvalCAST(('ur_ip_seq') AS text), 6, '0'::text) ) as maxid")
				.addScalar("maxid", Hibernate.STRING).uniqueResult();
		return maxid;
	}
	@Override
	public String getSysdate() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysdate
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier350
DMAP ConvertedQuery - SELECT to_char(statement_timestamp(), 'dd / mm/yyyy hh24:mi:ss') as datenow
**/

//		String sysDate =  (String) session.createSQLQuery("SELECT  to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')   as datenow  FROM dual")
		String sysDate =  (String) session.createSQLQuery("SELECT to_char(statement_timestamp(), 'dd / mm/yyyy hh24:mi:ss') as datenow")
				.addScalar("datenow", Hibernate.STRING).uniqueResult();
		return sysDate;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getURNo() throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getURNo
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier349
DMAP ConvertedQuery - SELECT CONCAT('IP', TO_CHAR(statement_timestamp(), 'YYYY') , LPAD(nextvalCAST(('ur_ip_seq') AS text), 6, '0'::text) ) as urNo
**/

//		String urNo =  (String) session.createSQLQuery("  SELECT 	'IP' || TO_CHAR(SYSDATE,'YYYY') || LPAD(UR_IP_SEQ.NEXTVAL ,6,'0') as urNo FROM 	DUAL ")
		String urNo =  (String) session.createSQLQuery("SELECT CONCAT('IP', TO_CHAR(statement_timestamp(), 'YYYY') , LPAD(nextvalCAST(('ur_ip_seq') AS text), 6, '0'::text) ) as urNo")
				.addScalar("urNo", Hibernate.STRING).uniqueResult();
		return urNo;
	}

}
