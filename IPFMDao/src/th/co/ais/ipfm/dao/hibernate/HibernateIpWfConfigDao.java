package th.co.ais.ipfm.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPWfConfigDao;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpWfConfig;

public class HibernateIpWfConfigDao  extends HibernateGenericDao<IpWfConfig> implements IPWfConfigDao{

	@Override
	public IpWfConfig getIpWfConfig(String urType) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpWfConfig.class);
		criteria.add(Restrictions.eq("urType", urType));
		return (IpWfConfig) criteria.uniqueResult();
	}
	
	@Override
	public void updateIpWfConfig(IpWfConfig ipWfConfig,String userId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		StringBuffer sql3 = new StringBuffer();
		StringBuffer sql4 = new StringBuffer();

		sql1.append(" UPDATE IP_WF_CONFIG ");
		sql1.append(" SET SLA = '"+ipWfConfig.getCdnWithoutImpact()+"' ");
		sql1.append(" ,SMS_STATUS = '"+ipWfConfig.getSmsStatus()+"' ");
		sql1.append(" ,SMS_MOBILE_NO_LIST = '"+ipWfConfig.getSmsMobileNoList()+"' ");
		sql1.append(" ,UPDATE_BY = '"+userId+"' ");
		sql1.append(" WHERE UR_TYPE = 'NC' ");
		sql1.append(" AND PM_TEAM = 'CDN' ");
		sql1.append(" AND IMPACT_STATUS = 'N' ");

		sql2.append(" UPDATE IP_WF_CONFIG ");
		sql2.append(" SET SLA = '"+ipWfConfig.getCdnWithImpact()+"' ");
		sql2.append(" ,SMS_STATUS = '"+ipWfConfig.getSmsStatus()+"' ");
		sql2.append(" ,SMS_MOBILE_NO_LIST = '"+ipWfConfig.getSmsMobileNoList()+"' ");
		sql2.append(" ,UPDATE_BY = '"+userId+"' ");
		sql2.append(" WHERE UR_TYPE = 'NC' ");
		sql2.append(" AND PM_TEAM = 'CDN' ");
		sql2.append(" AND IMPACT_STATUS = 'Y' ");
		
		sql3.append(" UPDATE IP_WF_CONFIG ");
		sql3.append(" SET SLA = '"+ipWfConfig.getSlaTnpWithoutImpact()+"' ");
		sql3.append(" ,SMS_STATUS = '"+ipWfConfig.getSmsStatus()+"' ");
		sql3.append(" ,SMS_MOBILE_NO_LIST = '"+ipWfConfig.getSmsMobileNoList()+"' ");
		sql3.append(" ,UPDATE_BY = '"+userId+"' ");
		sql3.append(" WHERE UR_TYPE = 'NC' ");
		sql3.append(" AND PM_TEAM = 'TNP' ");
		sql3.append(" AND IMPACT_STATUS = 'N' ");
		
		sql4.append(" UPDATE IP_WF_CONFIG ");
		sql4.append(" SET SLA = '"+ipWfConfig.getSlaTnpWithImpact()+"' ");
		sql4.append(" ,SMS_STATUS = '"+ipWfConfig.getSmsStatus()+"' ");
		sql4.append(" ,SMS_MOBILE_NO_LIST = '"+ipWfConfig.getSmsMobileNoList()+"' ");
		sql4.append(" ,UPDATE_BY = '"+userId+"' ");
		sql4.append(" WHERE UR_TYPE = 'NC' ");
		sql4.append(" AND PM_TEAM = 'TNP' ");
		sql4.append(" AND IMPACT_STATUS = 'Y' ");
		
		SQLQuery sqlQuery1  =  session.createSQLQuery(sql1.toString());
		SQLQuery sqlQuery2  =  session.createSQLQuery(sql2.toString());
		SQLQuery sqlQuery3  =  session.createSQLQuery(sql3.toString());
		SQLQuery sqlQuery4  =  session.createSQLQuery(sql4.toString());
		
		sqlQuery1.executeUpdate();
		sqlQuery2.executeUpdate(); 
		sqlQuery3.executeUpdate(); 
		sqlQuery4.executeUpdate(); 
	}
	
}
