/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.ais.ipfm.dao.hibernate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPFMCommondDaoImpl;
import th.co.ais.ipfm.dao.IPReportListDao;
import th.co.ais.ipfm.domain.Inbox;
import th.co.ais.ipfm.domain.TreeMenu;
import th.co.ais.ipfm.domain1.IpReportDetail;
import th.co.ais.ipfm.domain1.IpReportLayout;
import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.Iprur001Result1;
import th.co.ais.ipfm.domain1.Iprur001Result1PK;
import th.co.ais.ipfm.domain1.Iprur001Result2;
import th.co.ais.ipfm.domain1.Iprur001Result2PK;
import th.co.ais.ipfm.domain1.Iprur001Result3;
import th.co.ais.ipfm.domain1.Iprur001Result3PK;
import th.co.ais.ipfm.domain1.Iprur001Result4;
import th.co.ais.ipfm.domain1.Iprur001Result4PK;

public class HibernateIpReportListDao extends HibernateGenericDao<IpReportList> implements IPReportListDao {

	@SuppressWarnings("unchecked")
	public void addCritier(IpReportList entity) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		session.save(entity);

//		Fix Bug JTA : Unknown Reason 
		session.flush();
	}
	
	@SuppressWarnings("unchecked")
	public String getReportId() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String reportId =  (String) session.createSQLQuery("  SELECT 'R' || TO_CHAR(SYSDATE,'YYYY') || LPAD(SEQ_REPORT_ID.NEXTVAL ,7,'0') as reportId  FROM DUAL ")
				.addScalar("reportId", Hibernate.STRING).uniqueResult();
		return reportId;
	}
	
	@SuppressWarnings("unchecked")
	public List<IpReportList> getIpReportList() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT REPORT_ID, REPORT_NAME FROM IP_REPORT_LIST WHERE UPPER(REPORT_STATUS)='COMPLETED' ORDER BY REPORT_NAME");
		
		List<IpReportList>  ipReportList = session.createSQLQuery(sql.toString())
		.addScalar("REPORT_ID", Hibernate.STRING)
		.addScalar("REPORT_NAME", Hibernate.STRING)
		.list();
	
		return ipReportList;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<IpReportList> getIpReportCritier() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TO_CHAR(REQ_DATETIME,'DD/MM/YYYY HH24:mi:ss') as REQ_DATETIME, USER_ID, TO_CHAR(START_DATE,'DD/MM/YYYY')as START_DATE, TO_CHAR(END_DATE,'DD/MM/YYYY') as END_DATE, REPORT_STATUS, REPORT_NAME, ROW_ID, RUN_AT, ERROR_DESC, REPORT_ID ");
		sql.append("FROM IP_REPORT_LIST ");
		sql.append("WHERE UPPER(REPORT_STATUS)='WAITING' ");
		sql.append("ORDER BY REPORT_ID ");
		
		List<IpReportList>  ipReportList = session.createSQLQuery(sql.toString())
		.addScalar("REQ_DATETIME", Hibernate.STRING)
		.addScalar("USER_ID", Hibernate.STRING)
		.addScalar("START_DATE", Hibernate.STRING)
		.addScalar("END_DATE", Hibernate.STRING)
		.addScalar("REPORT_STATUS", Hibernate.STRING)
		.addScalar("REPORT_NAME", Hibernate.STRING)
		.addScalar("ROW_ID", Hibernate.STRING)
		.addScalar("RUN_AT", Hibernate.STRING)
		.addScalar("ERROR_DESC", Hibernate.STRING)
		.addScalar("REPORT_ID", Hibernate.STRING)
		.list();
	
		return ipReportList;
	}
	
	@Override
	public void deleteReportList(String reportId)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery  =  session.createSQLQuery(" DELETE IP_REPORT_LIST where REPORT_ID = '"+reportId+"'");
		sqlQuery.executeUpdate();  
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<IpReportDetail> getIpReportDetail(IpReportDetail obj) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT REPORT_ID, USER_ROLE, USER_ID, UR_TYPE, UR_NO, IN_OVER_DUE, IN_REPORT_STATUS, TOTAL_COUNT, SUB_UR_TYPE, TOTAL_UR ");
		sql.append(" FROM IP_REPORT_DETAIL ");
		sql.append(" WHERE REPORT_ID ='"+ obj.getReportId()+"'");
		if(obj.getUrType()!=null && obj.getUrType().equalsIgnoreCase("NC")){
			sql.append(" AND UR_TYPE='"+ obj.getUrType()+"'");
		}else{
			sql.append(" AND UR_TYPE like '"+ obj.getUrType()+"%'");
		}
		sql.append(" ORDER BY REPORT_ID ");
		
		List<IpReportDetail>  ipReportDetail = session.createSQLQuery(sql.toString())
		.addScalar("REPORT_ID", Hibernate.STRING)
		.addScalar("USER_ROLE", Hibernate.STRING)
		.addScalar("USER_ID", Hibernate.STRING)
		.addScalar("UR_TYPE", Hibernate.STRING)
		.addScalar("UR_NO", Hibernate.STRING)
		.addScalar("IN_OVER_DUE", Hibernate.STRING)
		.addScalar("IN_REPORT_STATUS", Hibernate.STRING)
		.addScalar("TOTAL_COUNT", Hibernate.STRING)
		.addScalar("SUB_UR_TYPE", Hibernate.STRING)
		.addScalar("TOTAL_UR", Hibernate.STRING)
		.list();
	
		return ipReportDetail;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Iprur001Result1> getIprur001Result1(String reportId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT REPORT_ID ,GROUP_SEQ ,GROUP_NAME  ,DATA_LEVEL ,USER_ID,");
		sql.append(" ALL_WAIT_INDUE ,ALL_WAIT_OVERDUE, ALL_REJECT_INDUE, ALL_REJECT_OVERDUE, ALL_COMPLETE_INDUE ,ALL_COMPLETE_OVERDUE , ");
		sql.append(" FW_WAIT_INDUE  ,FW_WAIT_OVERDUE , FW_REJECT_INDUE, FW_REJECT_OVERDUE ,FW_COMPLETE_INDUE,FW_COMPLETE_OVERDUE, ");
		sql.append(" ACDN_WAIT_INDUE, ACDN_WAIT_OVERDUE , ACDN_REJECT_INDUE,ACDN_REJECT_OVERDUE,ACDN_COMPLETE_INDUE ,ACDN_COMPLETE_OVERDUE, ");
		sql.append(" ATNP_WAIT_INDUE ,ATNP_WAIT_OVERDUE, ATNP_REJECT_INDUE ,ATNP_REJECT_OVERDUE ,ATNP_COMPLETE_INDUE,ATNP_COMPLETE_OVERDUE, ");
		sql.append(" PHY_WAIT_INDUE  ,PHY_WAIT_OVERDUE , PHY_REJECT_INDUE, PHY_REJECT_OVERDUE ,PHY_COMPLETE_INDUE,PHY_COMPLETE_OVERDUE , ");
		sql.append(" INTG_WAIT_INDUE ,INTG_WAIT_OVERDUE, INTG_REJECT_INDUE, INTG_REJECT_OVERDUE,INTG_COMPLETE_INDUE,INTG_COMPLETE_OVERDUE , ");
		sql.append(" RT_WAIT_INDUE  ,RT_WAIT_OVERDUE , RT_REJECT_INDUE,RT_REJECT_OVERDUE ,RT_COMPLETE_INDUE  ,RT_COMPLETE_OVERDUE , ");
		sql.append(" F5_WAIT_INDUE ,F5_WAIT_OVERDUE , F5_REJECT_INDUE  ,F5_REJECT_OVERDUE ,F5_COMPLETE_INDUE,F5_COMPLETE_OVERDUE, ");
		sql.append(" CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, ROW_ID, VERSION, USER_NAME ");
		sql.append(" FROM IPRUR001_RESULT1 ");
		sql.append(" WHERE REPORT_ID ='"+ reportId+"'");
		sql.append(" ORDER BY GROUP_SEQ, DATA_LEVEL, USER_ID ");
		
		List<Iprur001Result1>  result1 = session.createSQLQuery(sql.toString())
		.addScalar("REPORT_ID", Hibernate.STRING)
		.addScalar("GROUP_SEQ", Hibernate.STRING)
		.addScalar("GROUP_NAME", Hibernate.STRING)
		.addScalar("DATA_LEVEL", Hibernate.STRING)
		.addScalar("USER_ID", Hibernate.STRING)
		.addScalar("ALL_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("ALL_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("ALL_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("ALL_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("ALL_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("ALL_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("FW_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("FW_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("FW_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("FW_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("FW_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("FW_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("ACDN_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("ACDN_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("ACDN_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("ACDN_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("ACDN_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("ATNP_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("ATNP_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("ATNP_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("ATNP_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("ATNP_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("ATNP_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("ATNP_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("PHY_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("PHY_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("PHY_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("PHY_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("PHY_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("PHY_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("INTG_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("INTG_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("INTG_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("INTG_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("INTG_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("INTG_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("RT_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("RT_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("RT_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("RT_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("RT_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("RT_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("F5_WAIT_INDUE", Hibernate.INTEGER)
		.addScalar("F5_WAIT_OVERDUE", Hibernate.INTEGER)
		.addScalar("F5_REJECT_INDUE", Hibernate.INTEGER)
		.addScalar("F5_REJECT_OVERDUE", Hibernate.INTEGER)
		.addScalar("F5_COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("F5_COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("CREATE_BY", Hibernate.STRING)
		.addScalar("CREATE_DATE", Hibernate.DATE)
		.addScalar("UPDATE_BY", Hibernate.STRING)
		.addScalar("UPDATE_DATE", Hibernate.DATE)
		.addScalar("ROW_ID", Hibernate.STRING)
		.addScalar("VERSION", Hibernate.STRING)
		.addScalar("USER_NAME", Hibernate.STRING)
		.list();
		return result1;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Iprur001Result2> getTotalURRequest(String reportId, String urType) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT REPORT_ID, INDUE, OVERDUE, GROUP_SEQ, GROUP_NAME, UR_TYPE");
		sql.append(" FROM IPRUR001_RESULT2 ");
		sql.append(" WHERE REPORT_ID ='"+ reportId+"'");
		sql.append(" AND UR_TYPE like '"+ urType+"%'");
		sql.append(" ORDER BY GROUP_SEQ");
		
		List<Iprur001Result2>  result = session.createSQLQuery(sql.toString())
		.addScalar("REPORT_ID", Hibernate.STRING)
		.addScalar("INDUE", Hibernate.INTEGER)
		.addScalar("OVERDUE", Hibernate.INTEGER)
		.addScalar("GROUP_SEQ", Hibernate.STRING)
		.addScalar("GROUP_NAME", Hibernate.STRING)
		.addScalar("UR_TYPE", Hibernate.STRING)
		.list();
		return result;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Iprur001Result4> getIprur001Result4(String reportId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT REPORT_ID, GROUP_SEQ , GROUP_NAME , DATA_LEVEL, USER_ID,");
		sql.append(" COMPLETE_INDUE, COMPLETE_OVERDUE, WAITMAPP_INDUE, WAITMAPP_OVERDUE, WAITASSIGN_INDUE, WAITASSIGN_OVERDUE, ");
		sql.append(" CREATE_BY , CREATE_DATE, UPDATE_BY, UPDATE_DATE, ROW_ID, VERSION, USER_NAME ");
		sql.append(" FROM IPRUR001_RESULT4 ");
		sql.append(" WHERE REPORT_ID ='"+ reportId+"'");
		sql.append(" ORDER BY GROUP_SEQ, DATA_LEVEL, USER_ID ");
		
		List<Iprur001Result4>  result4 = session.createSQLQuery(sql.toString())
		.addScalar("REPORT_ID", Hibernate.STRING)
		.addScalar("GROUP_SEQ", Hibernate.STRING)
		.addScalar("GROUP_NAME", Hibernate.STRING)
		.addScalar("DATA_LEVEL", Hibernate.STRING)
		.addScalar("USER_ID", Hibernate.STRING)
		.addScalar("COMPLETE_INDUE", Hibernate.INTEGER)
		.addScalar("COMPLETE_OVERDUE", Hibernate.INTEGER)
		.addScalar("WAITMAPP_INDUE", Hibernate.INTEGER)
		.addScalar("WAITMAPP_OVERDUE", Hibernate.INTEGER)
		.addScalar("WAITASSIGN_INDUE", Hibernate.INTEGER)
		.addScalar("WAITASSIGN_OVERDUE", Hibernate.INTEGER)
		.addScalar("CREATE_BY", Hibernate.STRING)
		.addScalar("CREATE_DATE", Hibernate.DATE)
		.addScalar("UPDATE_BY", Hibernate.STRING)
		.addScalar("UPDATE_DATE", Hibernate.DATE)
		.addScalar("ROW_ID", Hibernate.STRING)
		.addScalar("VERSION", Hibernate.STRING)
		.addScalar("USER_NAME", Hibernate.STRING)
		.list();
		return result4;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override	
	public List<String> getURNCList(String reportId, String seq, String level, String userId, String tab, String action, String status) 
		throws DataAccessException{
	
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT UR_NO ");
		sb.append(" FROM IPRUR001_RESULT1_DETAIL");
		sb.append(" WHERE REPORT_ID = '"+reportId+"' ");
		sb.append(" AND GROUP_SEQ = '"+seq+"'");
		sb.append(" AND DATA_LEVEL = '"+level+"'");
		sb.append(" AND USER_ID = '"+userId+"'");
		sb.append(" AND SUB_UR_TYPE = '"+tab+"'");
		sb.append(" AND ACTION_STATUS = '"+action+"'");
		sb.append(" AND DUE_STATUS = '"+status+"'");
		sb.append(" ORDER BY UR_NO ");
		List<String> list = session.createSQLQuery(sb.toString())
		.addScalar("UR_NO", Hibernate.STRING).list();
		return list;
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<String> getURIPList(String reportId, String seq, String level, String userId, String action, String status) 
		throws DataAccessException{
	
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT distinct(UR_NO) ");
		sb.append(" FROM IPRUR001_RESULT4_DETAIL");
		sb.append(" WHERE REPORT_ID = '"+reportId+"' ");
		sb.append(" AND GROUP_SEQ = '"+seq+"'");
		sb.append(" AND DATA_LEVEL = '"+level+"'");
		sb.append(" AND USER_ID = '"+userId+"'");
		sb.append(" AND ACTION_STATUS = '"+action+"'"); 
		sb.append(" AND DUE_STATUS = '"+status+"'");
		sb.append(" ORDER BY UR_NO ");
		List<String> list = session.createSQLQuery(sb.toString())
		.addScalar("UR_NO", Hibernate.STRING).list();
		return list;	
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	public IpReportList getReportCritierByReportId(String reportId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		IpReportList ipReportList = null;
		try {
			Criteria criteria = session.createCriteria(IpReportList.class);		
			criteria.add(Restrictions.eq("reportId", reportId));
			ipReportList = (IpReportList)criteria.uniqueResult();
		}catch(DataAccessException d){
			d.printStackTrace();
			throw d;
		}
		return ipReportList;
	}
}
