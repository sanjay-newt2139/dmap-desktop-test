package th.co.ais.ipfm.dao.hibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrIPDetailDao;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.util.IPFMUtils;



public class HibernateIPUrIPDetailDao extends HibernateGenericDao<IpUrIpDetail> implements IPUrIPDetailDao{


	@SuppressWarnings({ "deprecation" })
	@Override
	public String getURNo() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		
		String urNo =  (String) session.createSQLQuery(" select 'IP' || TO_CHAR(SYSDATE,'YYYY') || '-' || LPAD(nvl(max(to_number(substr(t.ur_no,8))+1),1) ,6,'0') as urNo from ip_ur_ip_detail t where substr(t.ur_no,0,6) = 'IP'||TO_CHAR(SYSDATE,'YYYY') ")
//		String urNo =  (String) session.createSQLQuery(" SELECT 'IP' || TO_CHAR(SYSDATE,'YYYY') || '-' || LPAD(UR_IP_SEQ.NEXTVAL ,6,'0') as urNo  FROM DUAL ")
				.addScalar("urNo", Hibernate.STRING).uniqueResult();
		return urNo;
	}
	
	@SuppressWarnings({ "deprecation" })
	@Override
	public String getTempURNo() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String TempurNo =  (String) session.createSQLQuery("  SELECT 'T' || TO_CHAR(SYSDATE,'YYYY') || LPAD(TEMP_UR_SEQ.NEXTVAL ,6,'0') as urNo FROM DUAL ")
				.addScalar("urNo", Hibernate.STRING).uniqueResult();
		return TempurNo;
	}

	@Override
	public IpUrIpDetail getIPUrIpDetail(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrIpDetail.class);
		
		criteria.add(Restrictions.eq("urNo", urNo));
					
		
		return (IpUrIpDetail)criteria.uniqueResult();
	}

	@Override
	public int countSearchUR(IpUrIpDetail ipUrIpDetail)throws DataAccessException {
			Session session = getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(IpUrIpDetail.class);
			//criteria.add(Restrictions.eq("ur", parameterGroup));

			criteria.setProjection(Projections.rowCount());
			return ((Integer)criteria.list().get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpUrIpDetail> searchUR(IpUrIpDetail ipUrIpDetail, IpUser ipUser)throws DataAccessException {
		System.out.println(">>>>>>searchUR");
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrIpDetail> ipUrIpDetailList = new ArrayList<IpUrIpDetail>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT a.UR_NO,a.UR_TYPE,a.SUBJECT,a.UR_STATUS, a.REQ_USER_ID,a.REQ_NAME, to_char(a.REQ_DATE,'dd/MM/yyyy HH24:mi:ss') as REQ_DATE,a.OVER_SLA,a.UR_STATUS_NAME FROM (");
		if("IP12".equals(ipUrIpDetail.getUrType()) || "IP23".equals(ipUrIpDetail.getUrType()) 
		   || IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				sql.append(" SELECT A.UR_NO,A.UR_TYPE,A.SUBJECT,A.UR_STATUS,A.REQ_USER_ID,A.REQ_NAME,A.REQ_DATE,OVER_SLA,A.UR_STATUS_NAME "); 
				sql.append(" FROM IP_UR_IP_DETAIL A ");
				sql.append(" WHERE 1 = 1 ");
				
				if(!"ALL".equals(ipUrIpDetail.getV_view())){
					sql.append(" AND ( ");
					sql.append(" A.REQ_USER_ID ='"+ipUser.getUserId()+"'");
					sql.append(" OR A.REQ_TEAM ='"+ipUser.getTeamId()+"'");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t1.UR_NO ");
					sql.append(" FROM IP_UR_ACTION t1 ");
					sql.append(" WHERE INSTR(';'||t1.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t2.UR_NO  ");
					sql.append(" FROM IP_UR_ACTION_HISTORY t2 ");
					sql.append(" WHERE INSTR(';'||t2.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.REQ_USER_ID IN ( ");
					sql.append(" SELECT DISTINCT t3.USER_ID  ");
					sql.append(" FROM IP_USER t3 ");
					sql.append(" WHERE t3.MANAGER_ID='"+ipUser.getUserId()+"'");
				    sql.append(" )) ");
				    sql.append(" ) ");
					
				}
				System.out.println("TEST > ");
				if(!"".equals(ipUrIpDetail.getUrNo()) && ipUrIpDetail.getUrNo()!=null){
				sql.append(" AND upper(A.UR_NO) LIKE '%"+ipUrIpDetail.getUrNo().trim().toUpperCase()+"%'");
				System.out.println(">>>>>" + " AND upper(A.UR_NO) LIKE '%"+ipUrIpDetail.getUrNo().trim().toUpperCase()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getUrType()) && ipUrIpDetail.getUrType()!=null){
				sql.append(" AND A.UR_TYPE ='"+ipUrIpDetail.getUrType().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
					sql.append(" AND upper(A.REQ_USER_ID) ='"+ipUrIpDetail.getReqName().toUpperCase().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getUrStatus()) && ipUrIpDetail.getUrStatus()!=null){
				sql.append(" AND upper(A.UR_STATUS) ='"+ipUrIpDetail.getUrStatus().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getSubject()) && ipUrIpDetail.getSubject()!=null){
				sql.append(" AND upper(A.SUBJECT) LIKE '%"+ipUrIpDetail.getSubject().toUpperCase().trim()+"%'"); 
				}
				if(!"".equals(ipUrIpDetail.getProjId())&& ipUrIpDetail.getProjId()!=null){
				sql.append(" AND upper(A.PROJ_ID) LIKE '%"+ipUrIpDetail.getProjId().toUpperCase().trim()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getProjName()) && ipUrIpDetail.getProjName()!=null){
				sql.append(" AND upper(A.PROJ_NAME) LIKE '%"+ipUrIpDetail.getProjName().toUpperCase().trim()+"%'"); 
				}
				if(!"".equals(ipUrIpDetail.getReqDate()) && ipUrIpDetail.getReqDate()!=null){
					String reqDate="";
					String reqDateTo = "";
					try {
						reqDate = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDate(), "YYYYMMDD");
						reqDateTo = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDateTo(), "YYYYMMDD");
					} catch (Exception e) {
						e.printStackTrace();
					}
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') >= '"+reqDate+"' "); 
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') <= '"+reqDateTo+"' "); 
				}
				if("2".equals(ipUrIpDetail.getOverSla())){
				 sql.append(" AND A.OVER_SLA = 'Y'"); 
				}
		}
		if (("".equals(ipUrIpDetail.getProjId()) || ipUrIpDetail.getProjId()==null) 
			&& ("".equals(ipUrIpDetail.getProjName()) || ipUrIpDetail.getProjName()==null)) {
			if("NC".equals(ipUrIpDetail.getUrType()) || IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				if(IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				 sql.append(" UNION ALL ");
				}
				sql.append(" SELECT A.UR_NO,A.UR_TYPE,A.REQ_SUBJECT SUBJECT,A.UR_STATUS,A.REQ_USER_ID,A.REQ_USER_NAME REQ_NAME,A.REQ_DATE,OVER_SLA,A.UR_STATUS_NAME ");	   
				sql.append(" FROM IP_UR_NW_CONFIG A ");
				sql.append(" WHERE 1 = 1 ");
				
				if(!"ALL".equals(ipUrIpDetail.getV_view())){
					sql.append(" AND ( ");
					sql.append(" A.REQ_USER_ID ='"+ipUser.getUserId()+"'");
					sql.append(" OR A.REQ_TEAM_ID ='"+ipUser.getTeamId()+"'");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t1.UR_NO ");
					sql.append(" FROM IP_UR_ACTION t1 ");
					sql.append(" WHERE INSTR(';'||t1.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t2.UR_NO ");
					sql.append(" FROM IP_UR_ACTION_HISTORY t2 ");
					sql.append(" WHERE INSTR(';'||t2.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.REQ_USER_ID IN ( ");
					sql.append(" SELECT DISTINCT t3.USER_ID ");
					sql.append(" FROM IP_USER t3 ");
					sql.append(" WHERE t3.MANAGER_ID='"+ipUser.getUserId()+"'");
				    sql.append(" )) ");
				    sql.append(" ) ");
					
				}
				
				if(!"".equals(ipUrIpDetail.getUrNo()) && ipUrIpDetail.getUrNo()!=null){
					sql.append(" AND upper(A.UR_NO) LIKE '%"+ipUrIpDetail.getUrNo().trim().toUpperCase()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getUrStatus()) && ipUrIpDetail.getUrStatus()!=null){
					
					
//					if (ipUrIpDetail.getUrStatus().toUpperCase().equalsIgnoreCase("User Verify".toUpperCase())
//						|| ipUrIpDetail.getUrStatus().toUpperCase().equalsIgnoreCase("WAIT_USER".toUpperCase())
//						|| ipUrIpDetail.getUrStatus().toUpperCase().equalsIgnoreCase("REJECT_PM".toUpperCase()) ) {
//						sql.append(" AND A.UR_STATUS IN('REJECT_PM','WAIT_USER')");
////						if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
////							sql.append(" AND upper(T.REQ_USER_ID) = '"+ipUrIpDetail.getReqName().toUpperCase().trim()+"' ");
////						}
////						sql.append(" ) ");
//						
//						//sql.append(" AND ((A.UR_STATUS = 'REJECT_PM') OR (A.UR_STATUS = 'WAIT_USER'))");
//					}else{
						sql.append(" AND A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"' ");
//					}
//						if (ipUrIpDetail.getUrStatus()!=null && !ipUrIpDetail.getUrStatus().equalsIgnoreCase("DEL") && !ipUrIpDetail.getUrStatus().equalsIgnoreCase("WAIT_CONFIG")) {
//							sql.append(" AND A.UR_NO IN (SELECT DISTINCT T.UR_NO FROM IP_UR_ACTION T WHERE T.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"'");
//							if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
//								sql.append(" AND upper(T.REQ_USER_ID) = '"+ipUrIpDetail.getReqName().toUpperCase().trim()+"' ");
//							}
//							sql.append(" ) ");
//						}else{
//							sql.append(" AND A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"'");
//						}
////						sql.append(" AND A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"'");
//					}
//					sql.append(" AND (A.UR_NO IN (SELECT DISTINCT T.UR_NO FROM IP_UR_ACTION T WHERE T.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"' AND T.UR_TYPE='NC' ) ");
//					sql.append(" OR A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"') ");
//				}else{
//					sql.append(" AND A.UR_NO IN (SELECT DISTINCT T.UR_NO FROM IP_UR_ACTION T WHERE T.UR_TYPE='NC' ) ");
				}
				if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
					sql.append(" AND upper(A.REQ_USER_ID) ='"+ipUrIpDetail.getReqName().toUpperCase().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getSubject()) && ipUrIpDetail.getSubject()!=null){
					sql.append(" AND upper(A.REQ_SUBJECT) LIKE '%"+ipUrIpDetail.getSubject().toUpperCase().trim()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getReqDate()) &&  ipUrIpDetail.getReqDate()!=null 
				&& !"".equals(ipUrIpDetail.getReqDateTo()) && ipUrIpDetail.getReqDateTo()!=null ){
					String reqDate="";
					String reqDateTo = "";
					try {
						reqDate = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDate(), "YYYYMMDD");
						reqDateTo = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDateTo(), "YYYYMMDD");
					} catch (Exception e) {
						e.printStackTrace();
					}
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') >= '"+reqDate+"' "); 
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') <= '"+reqDateTo+"' "); 
				}
				if("2".equals(ipUrIpDetail.getOverSla())){
					 sql.append(" AND A.OVER_SLA = 'Y'"); 
				}
				
			}
		}
		sql.append(" ) A ");
//                sql.append(" left outer join ip_ur_ip_result r on (r.ur_no = A.UR_NO) ");
//                sql.append(" left outer join ip_info i on (i.ip_address = r.level1_start) ");
                 
		  
		sql.append(" where a.UR_NO is not null ");
		if(!"".equals(ipUrIpDetail.getHostName()) && ipUrIpDetail.getHostName()!=null){
			sql.append(" and a.ur_no in (select i.ur_refer from ip_info i where upper(i.host_name) like upper('%"+ipUrIpDetail.getHostName()+"%')) ");
		}
               
		sql.append(" ORDER BY 1,2,3 ");
		
		if((ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")) 
				|| (ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")) 
				|| (ipUrIpDetail.getNatIP() != null && !ipUrIpDetail.getNatIP().trim().equals("")) 
				|| (ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")) 
				|| (ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")) 
				|| (ipUrIpDetail.getNatIPTo() != null && !ipUrIpDetail.getNatIPTo().trim().equals("")) 
				)
		{
			String sqlTemp="";			
			sqlTemp = "" +
					"	SELECT a.UR_NO,a.UR_TYPE,a.SUBJECT,a.UR_STATUS,a.REQ_USER_ID,a.REQ_NAME,a.REQ_DATE,a.OVER_SLA,a.UR_STATUS_NAME FROM " +
					"	(	" +
					sql+
					"	) a JOIN" +
					"	(	" +
					"	select UR_NO , Rtrim(Xmlagg (Xmlelement (e, SUB_UR_NAME||',')).extract  ( '//text()' ), ',') as SUB_UR_NAME " +
					"	from (	" ;
					
						sqlTemp += "	select DISTINCT UR_NO , 'FW' as SUB_UR_NAME from IP_UR_FIREWALL	where 1 = 1";
						if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
							sqlTemp += (" and ((source_ip_1 in ("+ipUrIpDetail.getIpCriteria()+"))");
							sqlTemp += ("	or (source_ip_2 in ("+ipUrIpDetail.getIpCriteria()+"))");
							sqlTemp += (")");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
							sqlTemp += (" and ((source_ip_1 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							sqlTemp += ("	or (source_ip_2 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							sqlTemp += (")");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
							sqlTemp += (" and ((source_ip_1 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							sqlTemp += ("	or (source_ip_2 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							sqlTemp += (")");
						}
												
						if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
							sqlTemp += (" and ((dest_ip_1 in ("+ipUrIpDetail.getIpToCriteria()+"))");
							sqlTemp += ("	or (dest_ip_2 in ("+ipUrIpDetail.getIpToCriteria()+")))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
							sqlTemp += (" and ((dest_ip_1 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							sqlTemp += ("	or (dest_ip_2 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
							sqlTemp += (" and ((dest_ip_1 = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							sqlTemp += ("	or (dest_ip_2 = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
						}
						
						
						if(ipUrIpDetail.getNatIP() != null && !ipUrIpDetail.getNatIP().trim().equals("")){
							sqlTemp += (" and (source_nat_ip like ('%"+ipUrIpDetail.getNatIP().trim()+"%'))");
						}						
						if(ipUrIpDetail.getNatIPTo() != null && !ipUrIpDetail.getNatIPTo().trim().equals("")){
							sqlTemp += (" and (dest_nat_ip like ('%"+ipUrIpDetail.getNatIPTo().trim()+"%'))");
						}

				if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
						sqlTemp += "	union	";			
				        sqlTemp += "	select DISTINCT UR_NO , 'AL' as SUB_UR_NAME from IP_UR_ACCESS_LIST_CDN where 1 = 1" ;
				        
				        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
							sqlTemp += (" and ((source_ip_1 in ("+ipUrIpDetail.getIpCriteria()+"))");
							sqlTemp += ("	or (source_ip_2 in ("+ipUrIpDetail.getIpCriteria()+"))");
							sqlTemp += (")");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
							sqlTemp += (" and ((source_ip_1 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							sqlTemp += ("	or (source_ip_2 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							sqlTemp += (")");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
							sqlTemp += (" and ((source_ip_1 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							sqlTemp += ("	or (source_ip_2 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							sqlTemp += (")");
						}
												
						if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
							sqlTemp += (" and ((dest_ip_1 in ("+ipUrIpDetail.getIpToCriteria()+"))");
							sqlTemp += ("	or (dest_ip_2 in ("+ipUrIpDetail.getIpToCriteria()+")))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
							sqlTemp += (" and ((dest_ip_1 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							sqlTemp += ("	or (dest_ip_2 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
							sqlTemp += (" and ((dest_ip_1 = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							sqlTemp += ("	or (dest_ip_2 = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
						}
				        
				        
				        
					
						sqlTemp += "	union	";				
				        sqlTemp += "	select DISTINCT UR_NO , 'AT' as SUB_UR_NAME from IP_UR_ACCESS_LIST_TNP where 1 = 1" ;					
						 if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += ("	or (source_network_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((source_ip like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += ("	or (source_network_ip like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += ("	or (source_network_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += (")");
							}
													
							if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip in ("+ipUrIpDetail.getIpToCriteria()+"))");
								sqlTemp += ("	or (dest_network_ip in ("+ipUrIpDetail.getIpToCriteria()+")))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((dest_ip like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								sqlTemp += ("	or (dest_network_ip like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								sqlTemp += ("	or (dest_network_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
							}
						 
						 						 
						sqlTemp += "	union	";					
				        sqlTemp += "	select DISTINCT UR_NO , 'PI' as SUB_UR_NAME from IP_UR_PHYSICAL_INTERFACE where 1 = 1" ;
				        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
							sqlTemp += (" and  (ip_node in ("+ipUrIpDetail.getIpCriteria()+"))");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
							sqlTemp += (" and  (ip_node like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
							sqlTemp += (" and  (ip_node = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
						}
				        
				        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
							sqlTemp += (" and  (ip_node in ("+ipUrIpDetail.getIpToCriteria()+"))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
							sqlTemp += (" and  (ip_node like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
							sqlTemp += (" and  (ip_node = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
						}
					
						sqlTemp += "	union	";				
				        sqlTemp += "	select DISTINCT UR_NO , 'IG' as SUB_UR_NAME from IP_UR_INTERFACE_GATEWAY where 1 = 1" ;
				        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
				        }else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
				        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
						}
				        
				        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
				        }else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
				        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
						}
					
						sqlTemp += "	union	";				
				        sqlTemp += "	select DISTINCT UR_NO , 'RT' as SUB_UR_NAME from IP_UR_ROUTING where 1 = 1" ;
				        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
				        }else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
				        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
						}
				        
				        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
				        }else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
				        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
				        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
						}
				        
					
						sqlTemp += "	union	";				
				        sqlTemp += "	select DISTINCT UR_NO , 'F5' as SUB_UR_NAME from IP_UR_F5 where 1 = 1" ;
				        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
							sqlTemp += (" and ((vip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
							sqlTemp += ("	or (snap_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
							sqlTemp += ("	or (pool_ip_address in ("+ipUrIpDetail.getIpCriteria()+")))");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
							sqlTemp += (" and ((vip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							sqlTemp += ("	or (snap_ip like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							sqlTemp += ("	or (pool_ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%'))");
						}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
							sqlTemp += (" and ((vip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							sqlTemp += ("	or (snap_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							sqlTemp += ("	or (pool_ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"'))");
						}
				        
				        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
							sqlTemp += (" and ((vip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
							sqlTemp += ("	or (snap_ip in ("+ipUrIpDetail.getIpToCriteria()+"))");
							sqlTemp += ("	or (pool_ip_address in ("+ipUrIpDetail.getIpToCriteria()+")))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
							sqlTemp += (" and ((vip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							sqlTemp += ("	or (snap_ip like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							sqlTemp += ("	or (pool_ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
						}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
							sqlTemp += (" and ((vip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							sqlTemp += ("	or (snap_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							sqlTemp += ("	or (pool_ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
						}
				}
					
			sqlTemp += "	) group by UR_NO" ;
			sqlTemp += "	) b" ;
			sqlTemp += "	on ( a.ur_no = b.ur_no )";
			
			sql.delete(0, sql.length());
			sql.append(sqlTemp);
		}
		
		System.out.println(sql.toString());
		List dataList =  session.createSQLQuery(sql.toString()).list();
		Iterator iter = dataList.iterator();
		IpUrIpDetail objIPUrIpDetail;
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("en","EN"));
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			objIPUrIpDetail = new IpUrIpDetail();
			if("IP12".equals(ipUrIpDetail.getUrType()) || "IP23".equals(ipUrIpDetail.getUrType()) 
				|| IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				objIPUrIpDetail.setUrNo((String)obj[0]);
				objIPUrIpDetail.setUrType((String)obj[1]);
				objIPUrIpDetail.setSubject((String)obj[2]);
				objIPUrIpDetail.setUrStatus((String)obj[3]);
				objIPUrIpDetail.setReqUserId((String)obj[4]);
				objIPUrIpDetail.setReqName((String)obj[5]);
				
				try{
					objIPUrIpDetail.setReqDate(dfm.parse((String)obj[6]));
				}catch(Exception ex){
					objIPUrIpDetail.setReqDate(null);
				}
				
				objIPUrIpDetail.setOverSla((String)obj[7]);
				objIPUrIpDetail.setUrStatusName((String)obj[8]);
			}else if("NC".equals(ipUrIpDetail.getUrType()) || IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				objIPUrIpDetail.setUrNo((String)obj[0]);
				objIPUrIpDetail.setUrType((String)obj[1]);
				objIPUrIpDetail.setSubject((String)obj[2]);
				objIPUrIpDetail.setReqUserId((String)obj[4]);
				objIPUrIpDetail.setReqName((String)obj[5]);
				try{
					objIPUrIpDetail.setReqDate(dfm.parse((String)obj[6]));
				}catch(Exception ex){
					objIPUrIpDetail.setReqDate(null);
				}
				objIPUrIpDetail.setOverSla((String)obj[7]);
				if (!"".equals(ipUrIpDetail.getUrStatus()) && ipUrIpDetail.getUrStatus()!=null) {
					objIPUrIpDetail.setUrStatus(ipUrIpDetail.getUrStatus());
					objIPUrIpDetail.setUrStatusName(ipUrIpDetail.getUrStatusName());
				}else{
					objIPUrIpDetail.setUrStatus((String)obj[3]);
					objIPUrIpDetail.setUrStatusName((String)obj[8]);
				}
			}
			ipUrIpDetailList.add(objIPUrIpDetail);
				
		}
		
		return ipUrIpDetailList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpUrIpDetail> searchUR(IpUrIpDetail ipUrIpDetail, String subUrPack,IpUser ipUser)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpUrIpDetail> ipUrIpDetailList = new ArrayList<IpUrIpDetail>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT a.UR_NO,a.UR_TYPE,a.SUBJECT,a.UR_STATUS, a.REQ_USER_ID,a.REQ_NAME,to_char(a.REQ_DATE,'dd/MM/yyyy HH24:mi:ss') as REQ_DATE,a.OVER_SLA,a.UR_STATUS_NAME FROM (");
		if("IP12".equals(ipUrIpDetail.getUrType()) || "IP23".equals(ipUrIpDetail.getUrType()) 
		   || IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				sql.append(" SELECT A.UR_NO,A.UR_TYPE,A.SUBJECT,A.UR_STATUS,A.REQ_USER_ID,A.REQ_NAME,A.REQ_DATE,OVER_SLA,A.UR_STATUS_NAME "); 
				sql.append(" FROM IP_UR_IP_DETAIL A ");
				sql.append(" WHERE 1 = 1 ");
				
				if(!"ALL".equals(ipUrIpDetail.getV_view())){
					sql.append(" AND ( ");
					sql.append(" A.REQ_USER_ID ='"+ipUser.getUserId()+"'");
					sql.append(" OR A.REQ_TEAM ='"+ipUser.getTeamId()+"'");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t1.UR_NO ");
					sql.append(" FROM IP_UR_ACTION t1 ");
					sql.append(" WHERE INSTR(';'||t1.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t2.UR_NO  ");
					sql.append(" FROM IP_UR_ACTION_HISTORY t2 ");
					sql.append(" WHERE INSTR(';'||t2.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.REQ_USER_ID IN ( ");
					sql.append(" SELECT DISTINCT t3.USER_ID  ");
					sql.append(" FROM IP_USER t3 ");
					sql.append(" WHERE t3.MANAGER_ID='"+ipUser.getUserId()+"'");
				    sql.append(" )) ");
				    sql.append(" ) ");
					
				}
				System.out.println("TEST > ");
				if(!"".equals(ipUrIpDetail.getUrNo()) && ipUrIpDetail.getUrNo()!=null){
				sql.append(" AND upper(A.UR_NO) LIKE '%"+ipUrIpDetail.getUrNo().trim().toUpperCase()+"%'");
				System.out.println(">>>>>" + " AND upper(A.UR_NO) LIKE '%"+ipUrIpDetail.getUrNo().trim().toUpperCase()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getUrType()) && ipUrIpDetail.getUrType()!=null){
				sql.append(" AND A.UR_TYPE ='"+ipUrIpDetail.getUrType().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
					sql.append(" AND upper(A.REQ_USER_ID) ='"+ipUrIpDetail.getReqName().toUpperCase().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getUrStatus()) && ipUrIpDetail.getUrStatus()!=null){
				sql.append(" AND upper(A.UR_STATUS) ='"+ipUrIpDetail.getUrStatus().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getSubject()) && ipUrIpDetail.getSubject()!=null){
				sql.append(" AND upper(A.SUBJECT) LIKE '%"+ipUrIpDetail.getSubject().toUpperCase().trim()+"%'"); 
				}
				if(!"".equals(ipUrIpDetail.getProjId())&& ipUrIpDetail.getProjId()!=null){
				sql.append(" AND upper(A.PROJ_ID) LIKE '%"+ipUrIpDetail.getProjId().toUpperCase().trim()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getProjName()) && ipUrIpDetail.getProjName()!=null){
				sql.append(" AND upper(A.PROJ_NAME) LIKE '%"+ipUrIpDetail.getProjName().toUpperCase().trim()+"%'"); 
				}
				if(!"".equals(ipUrIpDetail.getReqDate()) && ipUrIpDetail.getReqDate()!=null){
					String reqDate="";
					String reqDateTo = "";
					try {
						reqDate = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDate(), "YYYYMMDD");
						reqDateTo = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDateTo(), "YYYYMMDD");
					} catch (Exception e) {
						e.printStackTrace();
					}
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') >= '"+reqDate+"' "); 
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') <= '"+reqDateTo+"' "); 
				}
				if("2".equals(ipUrIpDetail.getOverSla())){
				 sql.append(" AND A.OVER_SLA = 'Y'"); 
				}
		}
		if (("".equals(ipUrIpDetail.getProjId()) || ipUrIpDetail.getProjId()==null) 
			&& ("".equals(ipUrIpDetail.getProjName()) || ipUrIpDetail.getProjName()==null)) {
			if("NC".equals(ipUrIpDetail.getUrType()) || IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				if(IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				 sql.append(" UNION ALL ");
				}
				sql.append(" SELECT A.UR_NO,A.UR_TYPE,A.REQ_SUBJECT SUBJECT,A.UR_STATUS,A.REQ_USER_ID,A.REQ_USER_NAME REQ_NAME,A.REQ_DATE,OVER_SLA,A.UR_STATUS_NAME ");	   
				sql.append(" FROM IP_UR_NW_CONFIG A ");
				sql.append(" WHERE 1 = 1 ");
				
				if(!"ALL".equals(ipUrIpDetail.getV_view())){
					sql.append(" AND ( ");
					sql.append(" A.REQ_USER_ID ='"+ipUser.getUserId()+"'");
					sql.append(" OR A.REQ_TEAM_ID ='"+ipUser.getTeamId()+"'");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t1.UR_NO ");
					sql.append(" FROM IP_UR_ACTION t1 ");
					sql.append(" WHERE INSTR(';'||t1.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.UR_NO IN ( ");
					sql.append(" SELECT DISTINCT t2.UR_NO ");
					sql.append(" FROM IP_UR_ACTION_HISTORY t2 ");
					sql.append(" WHERE INSTR(';'||t2.ACTION_USER_ID||';',';"+ipUser.getUserId()+";')>0");
					sql.append(" )) ");
					sql.append(" OR (A.REQ_USER_ID IN ( ");
					sql.append(" SELECT DISTINCT t3.USER_ID ");
					sql.append(" FROM IP_USER t3 ");
					sql.append(" WHERE t3.MANAGER_ID='"+ipUser.getUserId()+"'");
				    sql.append(" )) ");
				    sql.append(" ) ");
					
				}
				
				if(!"".equals(ipUrIpDetail.getUrNo()) && ipUrIpDetail.getUrNo()!=null){
					sql.append(" AND upper(A.UR_NO) LIKE '%"+ipUrIpDetail.getUrNo().trim().toUpperCase()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getUrStatus()) && ipUrIpDetail.getUrStatus()!=null){
					
					
//					if (ipUrIpDetail.getUrStatus().toUpperCase().equalsIgnoreCase("User Verify".toUpperCase())
//						|| ipUrIpDetail.getUrStatus().toUpperCase().equalsIgnoreCase("WAIT_USER".toUpperCase())
//						|| ipUrIpDetail.getUrStatus().toUpperCase().equalsIgnoreCase("REJECT_PM".toUpperCase()) ) {
//						sql.append(" AND A.UR_STATUS IN('REJECT_PM','WAIT_USER')");
////						if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
////							sql.append(" AND upper(T.REQ_USER_ID) = '"+ipUrIpDetail.getReqName().toUpperCase().trim()+"' ");
////						}
////						sql.append(" ) ");
//						
//						//sql.append(" AND ((A.UR_STATUS = 'REJECT_PM') OR (A.UR_STATUS = 'WAIT_USER'))");
//					}else{
						sql.append(" AND A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"' ");
//					}
//						if (ipUrIpDetail.getUrStatus()!=null && !ipUrIpDetail.getUrStatus().equalsIgnoreCase("DEL") && !ipUrIpDetail.getUrStatus().equalsIgnoreCase("WAIT_CONFIG")) {
//							sql.append(" AND A.UR_NO IN (SELECT DISTINCT T.UR_NO FROM IP_UR_ACTION T WHERE T.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"'");
//							if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
//								sql.append(" AND upper(T.REQ_USER_ID) = '"+ipUrIpDetail.getReqName().toUpperCase().trim()+"' ");
//							}
//							sql.append(" ) ");
//						}else{
//							sql.append(" AND A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"'");
//						}
////						sql.append(" AND A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"'");
//					}
//					sql.append(" AND (A.UR_NO IN (SELECT DISTINCT T.UR_NO FROM IP_UR_ACTION T WHERE T.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"' AND T.UR_TYPE='NC' ) ");
//					sql.append(" OR A.UR_STATUS = '"+ipUrIpDetail.getUrStatus()+"') ");
//				}else{
//					sql.append(" AND A.UR_NO IN (SELECT DISTINCT T.UR_NO FROM IP_UR_ACTION T WHERE T.UR_TYPE='NC' ) ");
				}
				if(!"".equals(ipUrIpDetail.getReqName()) && ipUrIpDetail.getReqName()!=null){
					sql.append(" AND upper(A.REQ_USER_ID) ='"+ipUrIpDetail.getReqName().toUpperCase().trim()+"'");
				}
				if(!"".equals(ipUrIpDetail.getSubject()) && ipUrIpDetail.getSubject()!=null){
					sql.append(" AND upper(A.REQ_SUBJECT) LIKE '%"+ipUrIpDetail.getSubject().toUpperCase().trim()+"%'");
				}
				if(!"".equals(ipUrIpDetail.getReqDate()) &&  ipUrIpDetail.getReqDate()!=null 
				&& !"".equals(ipUrIpDetail.getReqDateTo()) && ipUrIpDetail.getReqDateTo()!=null ){
					String reqDate="";
					String reqDateTo = "";
					try {
						reqDate = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDate(), "YYYYMMDD");
						reqDateTo = IPFMUtils.cnvDateToString(ipUrIpDetail.getReqDateTo(), "YYYYMMDD");
					} catch (Exception e) {
						e.printStackTrace();
					}
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') >= '"+reqDate+"' "); 
					sql.append(" AND TO_CHAR(A.REQ_DATE,'yyyyMMdd') <= '"+reqDateTo+"' "); 
				}
				if("2".equals(ipUrIpDetail.getOverSla())){
					 sql.append(" AND A.OVER_SLA = 'Y'"); 
				}
				
			}
		}
		sql.append(" ) A ");
        //sql.append(" left outer join ip_ur_ip_result r on (r.ur_no = A.UR_NO) ");
        //sql.append(" left outer join ip_info i on (i.ip_address = r.level1_start) ");
         
  
		sql.append(" where a.UR_NO is not null ");
		if(!"".equals(ipUrIpDetail.getHostName()) && ipUrIpDetail.getHostName()!=null){
			sql.append(" and a.ur_no in (select i.ur_refer from ip_info i where upper(i.host_name) like upper('%"+ipUrIpDetail.getHostName()+"%')) ");
		}
		
		sql.append(" ORDER BY 1,2,3 ");
		
		if(subUrPack.length()!=0)
		{
			String sqlTemp="";
			String sqlTemp2="";
	
			String[] subURSynbolarray = subUrPack.split("-");
			Map<String, String> subUrType = new HashMap<String, String>();
			for(int i=0 ; i < subURSynbolarray.length ; i++)
			{
				if(i!=0)
					sqlTemp2 += " OR ";
				
				sqlTemp2 += " SUB_UR_NAME like '%"+subURSynbolarray[i]+"%'";
				subUrType.put(subURSynbolarray[i], subURSynbolarray[i]);
				
			}
//			sqlTemp = "" +
//					"	SELECT a.UR_NO,a.UR_TYPE,a.SUBJECT,a.UR_STATUS,a.REQ_USER_ID,a.REQ_NAME,a.REQ_DATE,a.OVER_SLA,a.UR_STATUS_NAME FROM " +
//					"	(	" +
//					sql+
//					"	) a LEFT OUTER JOIN" +
//					"	(	" +
//					"	select UR_NO , Rtrim(Xmlagg (Xmlelement (e, SUB_UR_NAME||',')).extract  ( '//text()' ), ',') as SUB_UR_NAME " +
//					"	from (	" +
//					"	select DISTINCT UR_NO , 'FW' as SUB_UR_NAME from IP_UR_FIREWALL	" +
//					"	union	" +
//					"	select DISTINCT UR_NO , 'AL' as SUB_UR_NAME from IP_UR_ACCESS_LIST_CDN" +
//					"	union" +
//					"	select DISTINCT UR_NO , 'AT' as SUB_UR_NAME from IP_UR_ACCESS_LIST_TNP" +
//					"	union" +
//					"	select DISTINCT UR_NO , 'PI' as SUB_UR_NAME from IP_UR_PHYSICAL_INTERFACE" +
//					"	union" +
//					"	select DISTINCT UR_NO , 'IG' as SUB_UR_NAME from IP_UR_INTERFACE_GATEWAY" +
//					"	union" +
//					"	select DISTINCT UR_NO , 'RT' as SUB_UR_NAME from IP_UR_ROUTING" +
//					"	union" +
//					"	select DISTINCT UR_NO , 'F5' as SUB_UR_NAME from IP_UR_F5" +
//					"	) group by UR_NO" +
//					"	) b" +
//					"	on ( a.ur_no = b.ur_no ) where " + sqlTemp2;
			
			if(subUrType == null || subUrType.size() == 0){
				sqlTemp = "" +
						"	SELECT a.UR_NO,a.UR_TYPE,a.SUBJECT,a.UR_STATUS,a.REQ_USER_ID,a.REQ_NAME,a.REQ_DATE,a.OVER_SLA,a.UR_STATUS_NAME FROM " +
						"	(	" +
						sql+
						"	) a JOIN" +
						"	(	" +
						"	select UR_NO , Rtrim(Xmlagg (Xmlelement (e, SUB_UR_NAME||',')).extract  ( '//text()' ), ',') as SUB_UR_NAME " +
						"	from (	" ;
						
							sqlTemp += "	select DISTINCT UR_NO , 'FW' as SUB_UR_NAME from IP_UR_FIREWALL	where 1 = 1";
							
							if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip_1 in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += ("	or (source_ip_2 in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((source_ip_1 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += ("	or (source_ip_2 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip_1 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += ("	or (source_ip_2 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += (")");
							}
													
							if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip_1 in ("+ipUrIpDetail.getIpToCriteria()+"))");
								sqlTemp += ("	or (dest_ip_2 in ("+ipUrIpDetail.getIpToCriteria()+")))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((dest_ip_1 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								sqlTemp += ("	or (dest_ip_2 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip_1 = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								sqlTemp += ("	or (dest_ip_2 = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
							}
							
							
							if(ipUrIpDetail.getNatIP() != null && !ipUrIpDetail.getNatIP().trim().equals("")){
								sqlTemp += (" and (source_nat_ip like ('%"+ipUrIpDetail.getNatIP().trim()+"%'))");
							}						
							if(ipUrIpDetail.getNatIPTo() != null && !ipUrIpDetail.getNatIPTo().trim().equals("")){
								sqlTemp += (" and (dest_nat_ip like ('%"+ipUrIpDetail.getNatIPTo().trim()+"%'))");
							}

					if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
							sqlTemp += "	union	";			
					        sqlTemp += "	select DISTINCT UR_NO , 'AL' as SUB_UR_NAME from IP_UR_ACCESS_LIST_CDN where 1 = 1" ;
					        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip_1 in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += ("	or (source_ip_2 in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((source_ip_1 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += ("	or (source_ip_2 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip_1 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += ("	or (source_ip_2 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += (")");
							}
													
							if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip_1 in ("+ipUrIpDetail.getIpToCriteria()+"))");
								sqlTemp += ("	or (dest_ip_2 in ("+ipUrIpDetail.getIpToCriteria()+")))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((dest_ip_1 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								sqlTemp += ("	or (dest_ip_2 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip_1 = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								sqlTemp += ("	or (dest_ip_2 = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
							}
						
							sqlTemp += "	union	";				
					        sqlTemp += "	select DISTINCT UR_NO , 'AT' as SUB_UR_NAME from IP_UR_ACCESS_LIST_TNP where 1 = 1" ;							 
							    if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
									sqlTemp += (" and ((source_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += ("	or (source_network_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += (")");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((source_ip like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += ("	or (source_network_ip like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += (")");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
									sqlTemp += (" and ((source_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += ("	or (source_network_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += (")");
								}
														
								if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
									sqlTemp += (" and ((dest_ip in ("+ipUrIpDetail.getIpToCriteria()+"))");
									sqlTemp += ("	or (dest_network_ip in ("+ipUrIpDetail.getIpToCriteria()+")))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((dest_ip like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
									sqlTemp += ("	or (dest_network_ip like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
									sqlTemp += (" and ((dest_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
									sqlTemp += ("	or (dest_network_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
								}
						
								
							sqlTemp += "	union	";					
					        sqlTemp += "	select DISTINCT UR_NO , 'PI' as SUB_UR_NAME from IP_UR_PHYSICAL_INTERFACE where 1 = 1" ;
					        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
								sqlTemp += (" and  (ip_node in ("+ipUrIpDetail.getIpCriteria()+"))");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
								sqlTemp += (" and  (ip_node like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
								sqlTemp += (" and  (ip_node = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							}
					        
					        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
								sqlTemp += (" and  (ip_node in ("+ipUrIpDetail.getIpToCriteria()+"))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
								sqlTemp += (" and  (ip_node like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
								sqlTemp += (" and  (ip_node = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							}
						
							sqlTemp += "	union	";				
					        sqlTemp += "	select DISTINCT UR_NO , 'IG' as SUB_UR_NAME from IP_UR_INTERFACE_GATEWAY where 1 = 1" ;
					        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
					        }else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
					        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							}
					        
					        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
					        }else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
					        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							}
						
							sqlTemp += "	union	";				
					        sqlTemp += "	select DISTINCT UR_NO , 'RT' as SUB_UR_NAME from IP_UR_ROUTING where 1 = 1" ;
					        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
					        }else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
					        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
							}
					        
					        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
					        }else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
					        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
					        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
							}
					        
						
							sqlTemp += "	union	";				
					        sqlTemp += "	select DISTINCT UR_NO , 'F5' as SUB_UR_NAME from IP_UR_F5 where 1 = 1" ;
					        if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
								sqlTemp += (" and ((vip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += ("	or (snap_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += ("	or (pool_ip_address in ("+ipUrIpDetail.getIpCriteria()+")))");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((vip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += ("	or (snap_ip like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += ("	or (pool_ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%'))");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
								sqlTemp += (" and ((vip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += ("	or (snap_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += ("	or (pool_ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"'))");
							}
					        
					        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
								sqlTemp += (" and ((vip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
								sqlTemp += ("	or (snap_ip in ("+ipUrIpDetail.getIpToCriteria()+"))");
								sqlTemp += ("	or (pool_ip_address in ("+ipUrIpDetail.getIpToCriteria()+")))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((vip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								sqlTemp += ("	or (snap_ip like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								sqlTemp += ("	or (pool_ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
								sqlTemp += (" and ((vip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								sqlTemp += ("	or (snap_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								sqlTemp += ("	or (pool_ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
							}
					}
				sqlTemp += "	) group by UR_NO" ;
				sqlTemp += "	) b" ;
				sqlTemp += "	on ( a.ur_no = b.ur_no ) where " + sqlTemp2;
			}else{
				int ii = 0;
				sqlTemp = "" +
						"	SELECT a.UR_NO,a.UR_TYPE,a.SUBJECT,a.UR_STATUS,a.REQ_USER_ID,a.REQ_NAME,a.REQ_DATE,a.OVER_SLA,a.UR_STATUS_NAME FROM " +
						"	(	" +
						sql+
						"	) a JOIN" +
						"	(	" +
						"	select UR_NO , Rtrim(Xmlagg (Xmlelement (e, SUB_UR_NAME||',')).extract  ( '//text()' ), ',') as SUB_UR_NAME " +
						"	from (	" ;
						
						if(subUrType.get("FW") != null && !subUrType.get("FW").equals("")){
							sqlTemp += "	select DISTINCT UR_NO , 'FW' as SUB_UR_NAME from IP_UR_FIREWALL	where 1 = 1";
							if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip_1 in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += ("	or (source_ip_2 in ("+ipUrIpDetail.getIpCriteria()+"))");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((source_ip_1 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += ("	or (source_ip_2 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								sqlTemp += (")");
							}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
								sqlTemp += (" and ((source_ip_1 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += ("	or (source_ip_2 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								sqlTemp += (")");
							}
													
							if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip_1 in ("+ipUrIpDetail.getIpToCriteria()+"))");
								sqlTemp += ("	or (dest_ip_2 in ("+ipUrIpDetail.getIpToCriteria()+")))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
								sqlTemp += (" and ((dest_ip_1 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								sqlTemp += ("	or (dest_ip_2 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
							}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
								sqlTemp += (" and ((dest_ip_1 = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								sqlTemp += ("	or (dest_ip_2 = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
							}
							
							
							if(ipUrIpDetail.getNatIP() != null && !ipUrIpDetail.getNatIP().trim().equals("")){
								sqlTemp += (" and (source_nat_ip like ('%"+ipUrIpDetail.getNatIP().trim()+"%'))");
							}						
							if(ipUrIpDetail.getNatIPTo() != null && !ipUrIpDetail.getNatIPTo().trim().equals("")){
								sqlTemp += (" and (dest_nat_ip like ('%"+ipUrIpDetail.getNatIPTo().trim()+"%'))");
							}
							
							
							
							ii++;
						}						
						if(subUrType.get("AL") != null && !subUrType.get("AL").equals("")){
							if(ii <  subUrType.size() && ii > 0){
								sqlTemp += "	union	";
							}
							
					        sqlTemp += "	select DISTINCT UR_NO , 'AL' as SUB_UR_NAME from IP_UR_ACCESS_LIST_CDN where 1 = 1" ;
					        if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
					        	if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
									sqlTemp += (" and ((source_ip_1 in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += ("	or (source_ip_2 in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += (")");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((source_ip_1 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += ("	or (source_ip_2 like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += (")");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
									sqlTemp += (" and ((source_ip_1 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += ("	or (source_ip_2 = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += (")");
								}
														
								if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
									sqlTemp += (" and ((dest_ip_1 in ("+ipUrIpDetail.getIpToCriteria()+"))");
									sqlTemp += ("	or (dest_ip_2 in ("+ipUrIpDetail.getIpToCriteria()+")))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((dest_ip_1 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
									sqlTemp += ("	or (dest_ip_2 like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
									sqlTemp += (" and ((dest_ip_1 = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
									sqlTemp += ("	or (dest_ip_2 = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
								}
					        }else{
					        	sqlTemp += (" and 1 = 2");
					        }
					        
					        
							ii++;
						}
						
						if(subUrType.get("AT") != null && !subUrType.get("AT").equals("")){
							if(ii <  subUrType.size() && ii > 0){
								sqlTemp += "	union	";
							}					
					        sqlTemp += "	select DISTINCT UR_NO , 'AT' as SUB_UR_NAME from IP_UR_ACCESS_LIST_TNP where 1 = 1" ;
					        if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
					        	if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
									sqlTemp += (" and ((source_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += ("	or (source_network_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += (")");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("") && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((source_ip like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += ("	or (source_network_ip like '"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += (")");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
									sqlTemp += (" and ((source_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += ("	or (source_network_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += (")");
								}
														
								if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
									sqlTemp += (" and ((dest_ip in ("+ipUrIpDetail.getIpToCriteria()+"))");
									sqlTemp += ("	or (dest_network_ip in ("+ipUrIpDetail.getIpToCriteria()+")))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("") && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((dest_ip like '"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
									sqlTemp += ("	or (dest_network_ip like '"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
									sqlTemp += (" and ((dest_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
									sqlTemp += ("	or (dest_network_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
								}
					        }else{
					        	sqlTemp += (" and 1 = 2");
					        }
							ii++;
						}
						
						if(subUrType.get("PI") != null && !subUrType.get("PI").equals("")){
							if(ii <  subUrType.size() && ii > 0){
								sqlTemp += "	union	";
							}					
					        sqlTemp += "	select DISTINCT UR_NO , 'PI' as SUB_UR_NAME from IP_UR_PHYSICAL_INTERFACE where 1 = 1" ;
					        
					        if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
					        	if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
									sqlTemp += (" and  (ip_node in ("+ipUrIpDetail.getIpCriteria()+"))");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
									sqlTemp += (" and  (ip_node like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
									sqlTemp += (" and  (ip_node = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								}
						        
						        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
									sqlTemp += (" and  (ip_node in ("+ipUrIpDetail.getIpToCriteria()+"))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
									sqlTemp += (" and  (ip_node like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
									sqlTemp += (" and  (ip_node = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								}
					        }else{
					        	sqlTemp += (" and 1 = 2");
					        }
					        
							ii++;
						}
						
						if(subUrType.get("IG") != null && !subUrType.get("IG").equals("")){
							if(ii <  subUrType.size() && ii > 0){
								sqlTemp += "	union	";
							}					
					        sqlTemp += "	select DISTINCT UR_NO , 'IG' as SUB_UR_NAME from IP_UR_INTERFACE_GATEWAY where 1 = 1 " ;
					        if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
					        	if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
						        	sqlTemp += (" where  (ip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
						        }else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
						        	sqlTemp += (" where  (ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
						        	sqlTemp += (" where  (ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								}
					        }else{
					        	sqlTemp += (" and 1 = 2");
					        }
					        
							ii++;
						}
						
						if(subUrType.get("RT") != null && !subUrType.get("RT").equals("")){
							if(ii <  subUrType.size() && ii > 0){
								sqlTemp += "	union	";
							}					
					        sqlTemp += "	select DISTINCT UR_NO , 'RT' as SUB_UR_NAME from IP_UR_ROUTING where 1 = 1" ;
					        if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
					        	if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
						        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
						        }else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
						        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
						        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
								}
						        
						        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
						        	sqlTemp += (" and  (ip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
						        }else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
						        	sqlTemp += (" and  (ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
						        	sqlTemp += (" and  (ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
								}
					        }else{
					        	sqlTemp += (" and 1 = 2");
					        }
					        
							ii++;
						}
						
						if(subUrType.get("F5") != null && !subUrType.get("F5").equals("")){
							if(ii <  subUrType.size() && ii > 0){
								sqlTemp += "	union	";
							}					
					        sqlTemp += "	select DISTINCT UR_NO , 'F5' as SUB_UR_NAME from IP_UR_F5 where 1 = 1" ;
					        if((ipUrIpDetail.getNatIP() == null || ipUrIpDetail.getNatIP().trim().equals("")) && (ipUrIpDetail.getNatIPTo() == null || ipUrIpDetail.getNatIPTo().trim().equals(""))){
					        	if(ipUrIpDetail.getIpCriteria() != null && !ipUrIpDetail.getIpCriteria().equals("")){
									sqlTemp += (" and ((vip_address in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += ("	or (snap_ip in ("+ipUrIpDetail.getIpCriteria()+"))");
									sqlTemp += ("	or (pool_ip_address in ("+ipUrIpDetail.getIpCriteria()+")))");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")  && ipUrIpDetail.getSingleIpCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((vip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += ("	or (snap_ip like '%"+ipUrIpDetail.getSingleIpCriteria()+"%')");
									sqlTemp += ("	or (pool_ip_address like '%"+ipUrIpDetail.getSingleIpCriteria()+"%'))");
								}else if(ipUrIpDetail.getSingleIpCriteria() != null && !ipUrIpDetail.getSingleIpCriteria().equals("")){
									sqlTemp += (" and ((vip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += ("	or (snap_ip = '"+ipUrIpDetail.getSingleIpCriteria()+"')");
									sqlTemp += ("	or (pool_ip_address = '"+ipUrIpDetail.getSingleIpCriteria()+"'))");
								}
						        
						        if(ipUrIpDetail.getIpToCriteria() != null && !ipUrIpDetail.getIpToCriteria().equals("")){
									sqlTemp += (" and ((vip_address in ("+ipUrIpDetail.getIpToCriteria()+"))");
									sqlTemp += ("	or (snap_ip in ("+ipUrIpDetail.getIpToCriteria()+"))");
									sqlTemp += ("	or (pool_ip_address in ("+ipUrIpDetail.getIpToCriteria()+")))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")  && ipUrIpDetail.getSingleIpToCriteria().split("\\.").length < 4){
									sqlTemp += (" and ((vip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
									sqlTemp += ("	or (snap_ip like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%')");
									sqlTemp += ("	or (pool_ip_address like '%"+ipUrIpDetail.getSingleIpToCriteria()+"%'))");
								}else if(ipUrIpDetail.getSingleIpToCriteria() != null && !ipUrIpDetail.getSingleIpToCriteria().equals("")){
									sqlTemp += (" and ((vip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
									sqlTemp += ("	or (snap_ip = '"+ipUrIpDetail.getSingleIpToCriteria()+"')");
									sqlTemp += ("	or (pool_ip_address = '"+ipUrIpDetail.getSingleIpToCriteria()+"'))");
								}
					        }else{
					        	sqlTemp += (" and 1 = 2");
					        }
							ii++;
						}

				sqlTemp += "	) group by UR_NO" ;
				sqlTemp += "	) b" ;
				sqlTemp += "	on ( a.ur_no = b.ur_no ) where " + sqlTemp2;
			}
			
			//sql = new StringBuffer();
			sql.delete(0, sql.length());
			sql.append(sqlTemp);
		}
		System.out.println(sql.toString());
		List dataList =  session.createSQLQuery(sql.toString()).list();
		Iterator iter = dataList.iterator();
		IpUrIpDetail objIPUrIpDetail;
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("en","EN"));
		while(iter.hasNext()) {
			Object[] obj = (Object[])iter.next();
			objIPUrIpDetail = new IpUrIpDetail();
			if("IP12".equals(ipUrIpDetail.getUrType()) || "IP23".equals(ipUrIpDetail.getUrType()) 
				|| IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				objIPUrIpDetail.setUrNo((String)obj[0]);
				objIPUrIpDetail.setUrType((String)obj[1]);
				objIPUrIpDetail.setSubject((String)obj[2]);
				objIPUrIpDetail.setUrStatus((String)obj[3]);
				objIPUrIpDetail.setReqUserId((String)obj[4]);
				objIPUrIpDetail.setReqName((String)obj[5]);
				try{
					objIPUrIpDetail.setReqDate(dfm.parse((String)obj[6]));
				}catch(Exception ex){
					objIPUrIpDetail.setReqDate(null);
				}
				objIPUrIpDetail.setOverSla((String)obj[7]);
				objIPUrIpDetail.setUrStatusName((String)obj[8]);
			}else if("NC".equals(ipUrIpDetail.getUrType()) || IPFMUtils.ifBlank(ipUrIpDetail.getUrType(), "").trim().length()==0){
				objIPUrIpDetail.setUrNo((String)obj[0]);
				objIPUrIpDetail.setUrType((String)obj[1]);
				objIPUrIpDetail.setSubject((String)obj[2]);
				objIPUrIpDetail.setReqUserId((String)obj[4]);
				objIPUrIpDetail.setReqName((String)obj[5]);
				try{
					objIPUrIpDetail.setReqDate(dfm.parse((String)obj[6]));
				}catch(Exception ex){
					objIPUrIpDetail.setReqDate(null);
				}
				objIPUrIpDetail.setOverSla((String)obj[7]);
				if (!"".equals(ipUrIpDetail.getUrStatus()) && ipUrIpDetail.getUrStatus()!=null) {
					objIPUrIpDetail.setUrStatus(ipUrIpDetail.getUrStatus());
					objIPUrIpDetail.setUrStatusName(ipUrIpDetail.getUrStatusName());
				}else{
					objIPUrIpDetail.setUrStatus((String)obj[3]);
					objIPUrIpDetail.setUrStatusName((String)obj[8]);
				}
			}
			ipUrIpDetailList.add(objIPUrIpDetail);
				
		}
		
		return ipUrIpDetailList;
	}

}
