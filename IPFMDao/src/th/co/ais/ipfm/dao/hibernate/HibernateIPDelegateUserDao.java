 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.annotations.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPDelegateUserDao;
import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpDelegateUserId;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.util.IPFMUtils;

public class HibernateIPDelegateUserDao extends HibernateGenericDao<IpDelegateUser> implements
IPDelegateUserDao {


	@Override
	public List<IpDelegateUser> getDelegateDataList(String userId)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpDelegateUser> result = new ArrayList<IpDelegateUser>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.DELEGATE_USER_ID AS DELEGATE_USER_ID ,b.USER_NAME AS USER_NAME ,a.START_DATE AS START_DATE,a.end_date AS end_date "); 
		sql.append("FROM IP_DELEGATE_USER a,IP_USER b ");
		sql.append("WHERE a.USER_ID = '"+userId+"' ");
		sql.append("and a.DELEGATE_USER_ID = b.USER_ID ");
		sql.append("ORDER  BY DELEGATE_USER_ID ");
		
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier356
DMAP ConvertedQuery - SELECT a.DELEGATE_USER_ID AS DELEGATE_USER_ID ,b.USER_NAME AS USER_NAME ,a.START_DATE AS START_DATE,a.end_date AS end_date FROM IP_DELEGATE_USER a,IP_USER b WHERE a.USER_ID = 'userId' and a.DELEGATE_USER_ID = b.USER_ID ORDER BY DELEGATE_USER_ID
**/

		List list = session.createSQLQuery(sql.toString()).addScalar("DELEGATE_USER_ID").addScalar("USER_NAME").addScalar("START_DATE")
		.addScalar("end_date").list();
		Iterator iter = list.iterator();
		IpDelegateUser ipDelegateUser;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipDelegateUser = new IpDelegateUser();
			IpDelegateUserId id = new IpDelegateUserId(null,(String)obj[0]);
			ipDelegateUser.setId(id);
			ipDelegateUser.setDelegateUser(new IpUser());
			ipDelegateUser.setUserName((String)obj[1]);
			ipDelegateUser.getDelegateUser().setUserName(ipDelegateUser.getUserName());
			ipDelegateUser.setStartDate((Date)obj[2]);
			ipDelegateUser.setEndDate((Date)obj[3]);
			result.add(ipDelegateUser);
		}
		return result;
	}

	@Override
	public String getCheckExistingData(IpDelegateUser ipDelegateUser,IpUser ipUser) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCheckExistingData
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier355
DMAP ConvertedQuery - select 'Found' AS result from ip_delegate_user where user_id = 'ipUser.getUserId()' and delegate_user_id = 'ipDelegateUser.getId().getDelegateUserId()' 
**/

		String result =  (String) session.createSQLQuery("  select 'Found' AS  result  from ip_delegate_user where user_id = '"+ipUser.getUserId()+"' and delegate_user_id = '"+ipDelegateUser.getId().getDelegateUserId()+"' ")
				.addScalar("result", Hibernate.STRING).uniqueResult();
		return result;
	}

	@Override
	public List<IpDelegateUser> deleteDelegate(String delegateUserId,String userId)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteDelegate
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier354
DMAP ConvertedQuery - DELETE FROM IP_DELEGATE_USER where user_id = 'userId' and delegate_user_id = 'delegateUserId'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("DELETE FROM IP_DELEGATE_USER where user_id = '" + userId + "' and delegate_user_id = '" + delegateUserId + "'");
		sqlQuery.executeUpdate();  
		
		List<IpDelegateUser> delegateDataList = getDelegateDataList(userId);
		return delegateDataList;
	}

	@Override
	public List<IpDelegateUser> getDelegateAdminList(String userId)throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateAdminList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpDelegateUser.class);
		 criteria.add(Restrictions.eq("id.userId", userId));
		 criteria.setFetchMode("delegateUser", org.hibernate.FetchMode.JOIN);
		 criteria.addOrder(Order.asc("id.delegateUserId"));
       return criteria.list();

	}
		
	@Override
	public void updateDelegate(IpDelegateUser ipDelegateUser,IpUser ipUser) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateDelegate
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		String startDate="";;
		String endDate="";
		try {
			startDate = IPFMUtils.cnvDateToString(ipDelegateUser.getStartDate(), "dd/mm/yyyy");
			endDate = IPFMUtils.cnvDateToString(ipDelegateUser.getEndDate(), "dd/mm/yyyy");
			
			sql.append(" UPDATE IP_DELEGATE_USER ");
			sql.append(" SET START_DATE = TO_DATE('"+startDate+"','dd/mm/yyyy')  ");
			sql.append(" ,END_DATE = TO_DATE('"+endDate+"','dd/mm/yyyy') ");
			sql.append(" ,UPDATE_BY = '"+ipUser.getUserId()+"' ");
			sql.append(" ,UPDATE_DATE = TO_DATE(sysdate,'dd/mm/yyyy hh24:mi:ss') ");
			sql.append(" where user_id = '"+ipDelegateUser.getId().getUserId()+"' ");
			sql.append(" and delegate_user_id = '"+ipDelegateUser.getId().getDelegateUserId()+"' ");
			
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier353
DMAP ConvertedQuery - UPDATE IP_DELEGATE_USER SET START_DATE = TO_DATE('1', '2') , END_DATE = TO_DATE('3', '2') , UPDATE_BY = 'ipUser.getUserId()' , UPDATE_DATE = TO_DATE(statement_timestamp(), '6') WHERE user_id = 'ipDelegateUser.getId().getUserId()' and delegate_user_id = 'ipDelegateUser.getId().getDelegateUserId()'
**/

			SQLQuery sqlQuery  =  session.createSQLQuery(sql.toString());
			sqlQuery.executeUpdate();  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
