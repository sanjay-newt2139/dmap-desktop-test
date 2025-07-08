package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPParameterDao;
import th.co.ais.ipfm.domain.IPParameter;

public class HibernateIPParameterDao extends HibernateGenericDao<IPParameter> implements
		IIPParameterDao {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<String> getParameterGroupList() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<String> parameterGroupList = session.createSQLQuery("select distinct parameter_group from ip_parameter order by parameter_group ")
		.addScalar("parameter_group", Hibernate.STRING).list();
		return parameterGroupList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<String> getParameterSubGroupList(String parameterGroup)
			throws DataAccessException {
		List<String> parameterSubGroupList = null;
		if(parameterGroup!=null && parameterGroup.trim().length()>0){
			Session session = getSessionFactory().getCurrentSession();
			StringBuffer sb = new StringBuffer();
			sb.append("select distinct parameter_subgroup from ip_parameter where ");
			sb.append("parameter_group = '" + parameterGroup + "' ");
			sb.append("order by parameter_subgroup");
			parameterSubGroupList = session.createSQLQuery(sb.toString())
			.addScalar("parameter_subgroup", Hibernate.STRING).list();
		}		
		return parameterSubGroupList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPParameter> searchIPParameter(String parameterGroup,
			String parameterSubGroup) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPParameter.class);
		
		if(parameterGroup!=null && parameterGroup.trim().length()>0){
			criteria.add(Restrictions.eq("parameterGroup", parameterGroup));
			if(parameterSubGroup!=null && parameterSubGroup.trim().length()>0){
				criteria.add(Restrictions.eq("parameterSubGroup", parameterSubGroup));
			}			
		}
		
		criteria.addOrder(Order.asc("parameterGroup"));
		criteria.addOrder(Order.asc("parameterSubGroup"));
		
		return criteria.list();
	}

	@Override
	public int countSearchIPParameter(String parameterGroup,
			String parameterSubGroup) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPParameter.class);
		if(parameterGroup!=null && parameterGroup.trim().length()>0){
			criteria.add(Restrictions.eq("parameterGroup", parameterGroup));
			if(parameterSubGroup!=null && parameterSubGroup.trim().length()>0){
				criteria.add(Restrictions.eq("parameterSubGroup", parameterSubGroup));
			}			
		}
		criteria.setProjection(Projections.rowCount());
		return ((Integer)criteria.list().get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPParameter> searchIPParameter(String parameterGroup,
			String parameterSubGroup, int maxResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPParameter.class);
		if(maxResult>0){
			criteria.setMaxResults(maxResult);	
		}
		if(!"".equals(parameterGroup)){
			criteria.add(Restrictions.eq("parameterGroup", parameterGroup));
/*			if(!"".equals(parameterSubGroup)){
				criteria.add(Restrictions.eq("parameterSubGroup", parameterSubGroup));
			}*/		
		}
		
		criteria.addOrder(Order.asc("parameterSubGroup"));
		
		return criteria.list();
	}
	
	@Override
	public IPParameter getIPVersion() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPParameter.class);
		
		criteria.add(Restrictions.eq("parameterGroup","IP"));
		criteria.add(Restrictions.eq("parameterSubGroup","VERSION"));
					
		
		return (IPParameter)criteria.uniqueResult();
	}

	@Override
	public String getDownloadDocumentURL() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPParameter.class);
		criteria.add(Restrictions.eq("parameterGroup", "DOCUMENT"));
		criteria.add(Restrictions.eq("parameterSubGroup", "MANUAL"));
		List result = criteria.list();
		return (result.size()!=0)?((IPParameter)result.get(0)).getStringValue():"";
	}
	


}
