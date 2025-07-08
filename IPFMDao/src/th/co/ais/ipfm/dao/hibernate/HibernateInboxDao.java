 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.InboxDao;
import th.co.ais.ipfm.domain.TempInbox;


public class HibernateInboxDao extends HibernateGenericDao<TempInbox> implements InboxDao {

	@Override
	public List<TempInbox> findInbox(String userId, String title1, String title2, String title3, String urNo) throws Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference findInbox
		Session session = getSessionFactory().getCurrentSession();
		List<TempInbox> result = new ArrayList<TempInbox>();		
		String sqlTitle1= "";
		String sqlTitle2= "";
		String sqlTitle3= "";
		String sqlUrNo= "";
		if (title1!=null && title1.trim().length()>0) sqlTitle1 = "and t.title1='"+title1+"' ";
		if (title2!=null && title2.trim().length()>0) sqlTitle2 = "and t.title2='"+title2+"' ";
		if (title3!=null && title3.trim().length()>0) sqlTitle3 = "and t.title3='"+title3+"' ";
		if (urNo!=null && urNo.trim().length()>0) sqlUrNo = "and t.urNo='"+urNo+"' ";
		try{
			StringBuffer sql = new StringBuffer();
			sql.append("select t from TempInbox t " +
					"where t.userId = '"+userId+"' " +
					sqlTitle1+sqlTitle2+sqlTitle3+sqlUrNo +
					"order by t.seq");
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier373
DMAP ConvertedQuery - select t from TempInbox t where t.userId = 'userId' and t.title1='title1' and t.title2='title2' and t.title3='title3' and t.urNo='urNo' order by t.seq
**/

/**
**/

			result = session.createQuery(sql.toString()).list();
			Hibernate.initialize(result);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public String getNews() throws Exception{ // DMAP Comment : Dead Code Detected - The Following Method has no reference getNews
		List<String> newsList;
		Session session = getSessionFactory().getCurrentSession();
		try{
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT T1.REF_DESC FROM IP_MASTER_TABLE T1 WHERE  T1.REF_TABLE='NEWS' AND T1.ACTIVE_STATUS=1 ORDER BY T1.REF_KEY DESC");
/**
DMAP TAG: Query converted but found same: Identifier372
DMAP ConvertedQuery - SELECT T1.REF_DESC FROM IP_MASTER_TABLE T1 WHERE T1.REF_TABLE='NEWS' AND T1.ACTIVE_STATUS=1 ORDER BY T1.REF_KEY DESC
**/

			newsList = session.createSQLQuery(sql.toString()).list();
			if (newsList!=null && newsList.size()>0) {
				return newsList.get(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return "";
	}

	@Override
	public Integer getWebCounter() throws Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWebCounter
		// TODO Auto-generated method stub
		return null;
	}
	

}
