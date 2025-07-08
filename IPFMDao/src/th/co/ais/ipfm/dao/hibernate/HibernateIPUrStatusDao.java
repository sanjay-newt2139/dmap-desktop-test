 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrStatusDao;
import th.co.ais.ipfm.domain1.IpUrStatus;

public class HibernateIPUrStatusDao extends HibernateGenericDao<IpUrStatus> implements
IPUrStatusDao {

	@Override
	public List<IpUrStatus> getUrStatusList(String urType) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrStatus> ipUrStatusList = new ArrayList<IpUrStatus>();
		StringBuffer sql = new StringBuffer();
				sql.append(" SELECT DISTINCT UR_STATUS_ID,UR_STATUS_NAME "); 
				sql.append(" FROM IP_UR_STATUS ");
				sql.append(" WHERE 1 = 1 ");
				if(!"".equals(urType) && urType !=null ){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier347
DMAP ConvertedQuery - SELECT DISTINCT UR_STATUS_ID,UR_STATUS_NAME FROM IP_UR_STATUS WHERE 1 = 1 AND UR_TYPE = 'urType' AND ACTIVE = 'Y' ORDER BY UR_STATUS_NAME 
**/

/**
**/

					sql.append(" AND UR_TYPE = '"+urType+"' ");
				}
				sql.append(" AND ACTIVE = 'Y' ");
/**
DMAP TAG: Query converted but found same: Identifier346
DMAP ConvertedQuery - SELECT DISTINCT UR_STATUS_ID,UR_STATUS_NAME FROM IP_UR_STATUS WHERE 1 = 1 AND ACTIVE = 'Y' ORDER BY UR_STATUS_NAME 
**/

				sql.append(" ORDER BY UR_STATUS_NAME ");

		List dataList =  session.createSQLQuery(sql.toString()).list();
		Iterator iter = dataList.iterator();
		IpUrStatus objIpUrStatus;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			objIpUrStatus = new IpUrStatus();

			    objIpUrStatus.setUrStatusId((String)obj[0]);
			    objIpUrStatus.setUrStatusName((String)obj[1]);
			    ipUrStatusList.add(objIpUrStatus);
		}
		
		return ipUrStatusList;
		  
	}

	@Override
	public List<IpUrStatus> getSubUrStatusList(String urType) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrStatusList
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrStatus> ipUrStatusList = new ArrayList<IpUrStatus>();
		StringBuffer sql = new StringBuffer();
				sql.append(" SELECT DISTINCT SUB_UR_STATUS_ID,SUB_UR_STATUS_NAME "); 
				sql.append(" FROM IP_UR_STATUS ");
				sql.append(" WHERE 1 = 1 ");
				if(!"".equals(urType) && urType !=null ){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier345
DMAP ConvertedQuery - SELECT DISTINCT SUB_UR_STATUS_ID,SUB_UR_STATUS_NAME FROM IP_UR_STATUS WHERE 1 = 1 AND UR_TYPE = 'urType' AND ACTIVE = 'Y' ORDER BY SUB_UR_STATUS_NAME 
**/

/**
**/

					sql.append(" AND UR_TYPE = '"+urType+"' ");
				}
				sql.append(" AND ACTIVE = 'Y' ");
/**
DMAP TAG: Query converted but found same: Identifier344
DMAP ConvertedQuery - SELECT DISTINCT SUB_UR_STATUS_ID,SUB_UR_STATUS_NAME FROM IP_UR_STATUS WHERE 1 = 1 AND ACTIVE = 'Y' ORDER BY SUB_UR_STATUS_NAME 
**/

				sql.append(" ORDER BY SUB_UR_STATUS_NAME ");

		List dataList =  session.createSQLQuery(sql.toString()).list();
		Iterator iter = dataList.iterator();
		IpUrStatus objIpUrStatus;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			objIpUrStatus = new IpUrStatus();

			    objIpUrStatus.setUrStatusId((String)obj[0]);
			    objIpUrStatus.setUrStatusName((String)obj[1]);
			    ipUrStatusList.add(objIpUrStatus);
		}
		
		return ipUrStatusList;
		  
	}
}
