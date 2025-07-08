package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.ipfm.dao.IPSubUrAttachmentDao;
import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentDto;

public class HibernateIPSubUrAttachmentDao extends HibernateGenericDao<IpSubUrAttachment> implements IPSubUrAttachmentDao{

	@Override
	public void deleteIpUrAttachment(String urNo,String fileName, String catagory){
		Session session = getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery  =  session.createSQLQuery(" DELETE  FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO ='"+urNo+"' and FILE_NAME = '"+fileName+"' and CATEGORY = '"+catagory+"'");
		sqlQuery.executeUpdate();  
	}


	@SuppressWarnings("deprecation")
	@Override
	public BigDecimal getSeqNo(String urNo, String catagory) {
		Session session = getSessionFactory().getCurrentSession();
		String seqNo =  (String) session.createSQLQuery("SELECT NVL(MAX(SEQ),0)+1 as NEWSEQ FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO='"+urNo+"'  and CATEGORY = '"+catagory+"'")
				.addScalar("NEWSEQ", Hibernate.STRING).uniqueResult();
		return new BigDecimal(seqNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IpSubUrAttachment findByFileName(String urNo,String filename, String catagory) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
//		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));
		criteria.add(Restrictions.eq("id.fileName", filename));
		criteria.add(Restrictions.eq("id.category", catagory));
		List<IpSubUrAttachment> result=criteria.list();
		
		return (result.size()!=0)?result.get(0):null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<IpSubUrAttachment> findByUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));

		return criteria.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<IpSubUrAttachment> getIpUrAttachmentList(String urNo){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));

		return criteria.list();
	}


	@Override
	public String findSubUrByUrNoAndSeq(String urNo, String seq) {
		// select wm_concat(sub_ur_no) as subUrNo from IP_SUB_UR_ATTACHMENT where ur_no = 'IP2011-000375' and seq = '1';
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public IpSubUrAttachment findAttachmentSubUr(String urNo, String filename,String catagory) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.fileName", filename));
		criteria.add(Restrictions.eq("id.category", catagory));
		List<IpSubUrAttachment> result=criteria.list();
		
		return (result.size()!=0)?result.get(0):null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<IpSubUrAttachment> getIpUrAttachment(String urNo,String subUrNo, String status, String createBy) {

		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.subUrNo", subUrNo));
		criteria.add(Restrictions.eq("urStatus", status));
		criteria.add(Restrictions.eq("createdBy", createBy));
		List<IpSubUrAttachment> result=criteria.list();
		return (result.size()!=0)?result:null;
	
	}


	@Override
	public void deleteIpUrAttachmentSubmit(String urNo, String subUrNo,String status, String createBy) {
		Session session = getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery  =  session.createSQLQuery(" DELETE  FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO ='"+urNo+"' and SUB_UR_NO = '"+subUrNo+"' and UR_STATUS = '"+status+"' and CREATE_BY = '"+createBy+"'");
		sqlQuery.executeUpdate();  
	
	}


	@Override
	public List<IpSubUrAttachmentDto> getByUrNo(String urNo) {
		List<IpSubUrAttachmentDto> result = new ArrayList<IpSubUrAttachmentDto>();
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer qry = new StringBuffer();
		qry.append(" select  ur_no, ");
		qry.append("  create_by, ");
      	qry.append("  category, ");
      	qry.append("  file_location, ");
      	qry.append("  file_name, ");
      	qry.append("  ur_status, ");
      	qry.append("  sub_ur_status, ");
      	qry.append("  '' as action, ");
      	qry.append("  WM_CONCAT(sub_ur_no) as sub_Ur_No ");
  		qry.append(" from ip_sub_ur_attachment  ");
 		qry.append(" where ur_no = '"+urNo+"' ");
 		qry.append(" group by ur_no, ");
 		qry.append("  create_by, ");
 		qry.append("  category, ");
 		qry.append("  file_location, ");
 		qry.append("  file_name, ");
 		qry.append("  ur_status, ");
 		qry.append("  sub_ur_status ");
		
 		result  =  session.createSQLQuery(qry.toString()).addEntity(IpSubUrAttachmentDto.class).list();
 		return result;
	}

}
