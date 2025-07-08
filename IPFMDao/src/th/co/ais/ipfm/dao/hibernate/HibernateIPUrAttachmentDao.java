 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrActionDao;
import th.co.ais.ipfm.dao.IPUrAttachmentDao;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrFirewall;

public class HibernateIPUrAttachmentDao extends HibernateGenericDao<IpUrAttachment> implements IPUrAttachmentDao{

	@Override
	public BigDecimal getSeqNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSeqNo
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier110
DMAP ConvertedQuery - SELECT coalesce(MAX(CAST(SEQ AS numeric)), 0)+1 as NEWSEQ FROM IP_UR_ATTACHMENT WHERE UR_NO='urNo'
**/

		String seqNo =  (String) session.createSQLQuery("SELECT NVL(MAX(SEQ),0)+1 as NEWSEQ FROM IP_UR_ATTACHMENT WHERE UR_NO='"+urNo+"'")
				.addScalar("NEWSEQ", Hibernate.STRING).uniqueResult();
		return new BigDecimal(seqNo);
	}

	@Override
	public IpUrAttachment findByFileName(String urNo, String filename, // DMAP Comment : Dead Code Detected - The Following Method has no reference findByFileName
			String catagory) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("fileName", filename));
		criteria.add(Restrictions.eq("id.category", catagory));
		List<IpUrAttachment> result=criteria.list();
		
		return (result.size()!=0)?result.get(0):null;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpUrAttachment> getIpUrAttachmentList(String urNo) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachmentList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));

		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpUrAttachment> getIpUrAttachmentList(String urNo,String category) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachmentList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.category", category));

		return criteria.list();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void updateIpUrAttachment(String urNo ,String tempUrNo) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference updateIpUrAttachment
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier109
DMAP ConvertedQuery - UPDATE IP_UR_ATTACHMENT SET UR_NO ='urNo', file_location = replace(file_location, CONCAT('/', 'tempUrNo') , CONCAT('/', 'urNo') ) WHERE UR_NO ='tempUrNo'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("UPDATE IP_UR_ATTACHMENT SET UR_NO ='" + urNo + "', file_location = replace(file_location, CONCAT('/', '" + tempUrNo + "') , CONCAT('/', '" + urNo + "') ) WHERE UR_NO ='" + tempUrNo + "'");

		sqlQuery.executeUpdate();  
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void deleteIpUrAttachment(String urNo) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteIpUrAttachment
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier108
DMAP ConvertedQuery - DELETE FROM IP_UR_ATTACHMENT WHERE UR_NO ='urNo'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("DELETE FROM IP_UR_ATTACHMENT WHERE UR_NO ='" + urNo + "'");
		sqlQuery.executeUpdate();  
	}

	@Override
	public List<IpUrAttachment> findByUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByUrNo
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));		
		return criteria.list();
	}

	@Override
	public IpUrAttachment findByUrNoSeq(String urNo, BigDecimal seq) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByUrNoSeq
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.seq", seq));
		List<IpUrAttachment> result =  criteria.list();
		
		return (result.size()!=0)?result.get(0):null;
	}
	
	@Override
	public List<IpUrAttachment> findByCategory(String urNo, String category) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByCategory
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));		
		criteria.add(Restrictions.eq("id.category", category));		
		return criteria.list();
	}
}
