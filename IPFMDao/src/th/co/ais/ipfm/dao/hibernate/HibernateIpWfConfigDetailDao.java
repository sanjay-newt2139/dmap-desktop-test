package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrWfConfigDetailDao;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;
import th.co.ais.ipfm.domain1.IpWfConfigDetailId;

public class HibernateIpWfConfigDetailDao  extends HibernateGenericDao<IpWfConfigDetail> implements IPUrWfConfigDetailDao{

	@Override
	public List<IpWfConfigDetail> getIpWfConfigDetailList(String urType) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpWfConfigDetail> result = new ArrayList<IpWfConfigDetail>();
	
		StringBuffer sql = new StringBuffer();
		sql.append("Select NODE_ID, UR_TYPE, ROW_ID,NODE_DESC, OLA, EMAIL_STATUS, VERSION, CREATE_DATE, CREATE_BY, UPDATE_BY, UPDATE_DATE   FROM  IP_WF_CONFIG_DETAIL "); 
		sql.append("WHERE  UR_TYPE ='"+urType+"' ");
		sql.append("ORDER BY to_number(substr(NODE_ID,2)) ");
		List list = session.createSQLQuery(sql.toString()).addScalar("NODE_ID").addScalar("UR_TYPE").addScalar("ROW_ID")
		.addScalar("NODE_DESC").addScalar("OLA").addScalar("EMAIL_STATUS").addScalar("VERSION").addScalar("CREATE_DATE").addScalar("CREATE_BY").addScalar("UPDATE_BY").addScalar("UPDATE_DATE").list();
		Iterator iter = list.iterator();
		IpWfConfigDetail ipWfConfigDetail;
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			ipWfConfigDetail = new IpWfConfigDetail();
			IpWfConfigDetailId id = new IpWfConfigDetailId((String)obj[0],(String)obj[1]);
			ipWfConfigDetail.setId(id);
			ipWfConfigDetail.setRowId((String)obj[2]);
			ipWfConfigDetail.setNodeDesc((String)obj[3]);
			ipWfConfigDetail.setOla((BigDecimal)obj[4]);
			ipWfConfigDetail.setEmailStatus((String)obj[5]);
			BigDecimal version = (BigDecimal)obj[6];
			ipWfConfigDetail.setVersion(version.longValue());
			ipWfConfigDetail.setCreated((Date)obj[7]);
			ipWfConfigDetail.setCreatedBy((String)obj[8]);
			ipWfConfigDetail.setLastUpdBy((String)obj[9]);
			ipWfConfigDetail.setLastUpd((Date)obj[10]);
			result.add(ipWfConfigDetail);
		}
		return result;
	}
	
	@Override
	public int  maxOla() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Integer  maxOla =  (Integer) session.createSQLQuery("SELECT MAX(OLA) AS maxOla  FROM IP_WF_CONFIG_DETAIL  WHERE UR_TYPE = 'NC' AND STEP >= 500 AND STEP <600")
				.addScalar("maxOla", Hibernate.INTEGER).uniqueResult();
		return maxOla;
	}
	
}
