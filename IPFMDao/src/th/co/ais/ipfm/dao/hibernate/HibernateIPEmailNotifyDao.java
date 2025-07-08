package th.co.ais.ipfm.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IPEmailNotifyDao;
import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;

public class HibernateIPEmailNotifyDao extends HibernateGenericDao<IpEmailNotify> implements IPEmailNotifyDao{

	@Override
	public IpEmailNotify findByResponce(String urNo, String userId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpEmailNotify.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.addOrder(Order.desc("lastUpd"));
		List<IpEmailNotify> result = criteria.list();
		if (result == null || result.size()==0) return null; 
		return result.get(0);
	}
	
	@Override
	public IpEmailNotify findByResponce(String emailCode) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpEmailNotify.class);
		criteria.add(Restrictions.eq("emailCode", emailCode));
		List<IpEmailNotify> result = criteria.list();
		if (result == null || result.size()==0) return null; 
		return result.get(0);
	}

	@Override
	public boolean isSendEmail(String type, String id) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpWfConfigDetail.class);
		criteria.add(Restrictions.eq("id.urType", type));
		criteria.add(Restrictions.eq("id.nodeId", id));
		IpWfConfigDetail cfd = (IpWfConfigDetail)criteria.uniqueResult();
		if (cfd==null) return true;
		return cfd.getEmailStatus().equals("Y");
	}

	@Override
	public void deleteNotibyByStatus(String urNo, String urStatus) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE IP_EMAIL_NOTIFY WHERE (UR_NO = ?) AND (UR_STATUS=?)";
		session.createSQLQuery(sql)
			.setString(0,urNo)
			.setString(1,urStatus)
			.executeUpdate();
	}

	@Override
	public void deleteNotibyByUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE IP_EMAIL_NOTIFY WHERE (UR_NO = ?)";
		session.createSQLQuery(sql)
			.setString(0,urNo)
			.executeUpdate();
	}

	@Override
	public void deleteByUser(String urNo, String userId, String status) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("delete  IP_EMAIL_NOTIFY ");
		sql.append("Where (UR_NO = ?)	and (UR_STATUS = ?) and (USER_ID = ?) ");
		Session session = getSessionFactory().getCurrentSession();
		session.createSQLQuery(sql.toString())
			.setString(0,urNo)
			.setString(1,status)
			.setString(2,userId)
			.executeUpdate();
		
	}
	
	@Override
	public void deleteByUser(String userId, String status) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("delete  IP_EMAIL_NOTIFY ");
		sql.append("Where (EMAIL_LINK_STATUS = ?) and (USER_ID = ?) ");
		Session session = getSessionFactory().getCurrentSession();
		session.createSQLQuery(sql.toString())
			.setString(0,status)
			.setString(1,userId)
			.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public IpEmailNotify findLastEmailNotifyByUserId(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.* ");
		sql.append("FROM IP_EMAIL_NOTIFY t ");
		sql.append("WHERE t.USER_ID='"+userId+"' ");
		sql.append("AND t.EMAIL_LINK_STATUS='Y' ");
		sql.append("ORDER BY t.UPDATE_DATE DESC ");
		System.out.println(" sql = "+sql.toString());
		Session session = getSessionFactory().getCurrentSession();
		List<IpEmailNotify> result = session.createSQLQuery(sql.toString()).addEntity(IpEmailNotify.class).list();
		if (result.size()>0) {
			return (IpEmailNotify)result.get(0);
		}
		return null;
	}
	
			


}
