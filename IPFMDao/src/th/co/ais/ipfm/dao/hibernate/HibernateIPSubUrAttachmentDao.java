 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
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
	public void deleteIpUrAttachment(String urNo,String fileName, String catagory){ // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteIpUrAttachment
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier48
DMAP ConvertedQuery - DELETE FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO ='urNo' and FILE_NAME = 'fileName' and CATEGORY = 'catagory'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("DELETE FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO ='" + urNo + "' and FILE_NAME = '" + fileName + "' and CATEGORY = '" + catagory + "'");
		sqlQuery.executeUpdate();  
	}


	@SuppressWarnings("deprecation")
	@Override
	public BigDecimal getSeqNo(String urNo, String catagory) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSeqNo
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier47
DMAP ConvertedQuery - SELECT coalesce(MAX(CAST(SEQ AS numeric)), 0)+1 as NEWSEQ FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO='urNo' and CATEGORY = 'catagory'
**/

		String seqNo =  (String) session.createSQLQuery("SELECT NVL(MAX(SEQ),0)+1 as NEWSEQ FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO='"+urNo+"'  and CATEGORY = '"+catagory+"'")
				.addScalar("NEWSEQ", Hibernate.STRING).uniqueResult();
		return new BigDecimal(seqNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IpSubUrAttachment findByFileName(String urNo,String filename, String catagory) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByFileName
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
	public List<IpSubUrAttachment> findByUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findByUrNo
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));

		return criteria.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<IpSubUrAttachment> getIpUrAttachmentList(String urNo){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachmentList
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpSubUrAttachment.class);
		criteria.add(Restrictions.eq("id.urNo", urNo));

		return criteria.list();
	}


	@Override
	public String findSubUrByUrNoAndSeq(String urNo, String seq) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findSubUrByUrNoAndSeq
		// select wm_concat(sub_ur_no) as subUrNo from IP_SUB_UR_ATTACHMENT where ur_no = 'IP2011-000375' and seq = '1';
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public IpSubUrAttachment findAttachmentSubUr(String urNo, String filename,String catagory) { // DMAP Comment : Dead Code Detected - The Following Method has no reference findAttachmentSubUr
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
	public List<IpSubUrAttachment> getIpUrAttachment(String urNo,String subUrNo, String status, String createBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachment

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
	public void deleteIpUrAttachmentSubmit(String urNo, String subUrNo,String status, String createBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteIpUrAttachmentSubmit
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted: Identifier46
DMAP ConvertedQuery - DELETE FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO ='urNo' and SUB_UR_NO = 'subUrNo' and UR_STATUS = 'status' and CREATE_BY = 'createBy'
**/

		SQLQuery sqlQuery  =  session.createSQLQuery("DELETE FROM IP_SUB_UR_ATTACHMENT WHERE UR_NO ='" + urNo + "' and SUB_UR_NO = '" + subUrNo + "' and UR_STATUS = '" + status + "' and CREATE_BY = '" + createBy + "'");
		sqlQuery.executeUpdate();  
	
	}


	@Override
	public List<IpSubUrAttachmentDto> getByUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getByUrNo
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
		
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier45
DMAP ConvertedQuery - select ur_no, create_by, category, file_location, file_name, ur_status, sub_ur_status, '' as action, string_agg(CAST(sub_ur_no AS TEXT),',') as sub_Ur_No from ip_sub_ur_attachment WHERE ur_no = 'urNo' group by ur_no, create_by, category, file_location, file_name, ur_status, sub_ur_status
**/

 		result  =  session.createSQLQuery(qry.toString()).addEntity(IpSubUrAttachmentDto.class).list();
 		return result;
	}

}
