package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPGroupDao;
import th.co.ais.ipfm.domain.IPGroup;

public class HibernateIPGroupDao extends HibernateGenericDao<IPGroup> implements IIPGroupDao {
 	SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy", new Locale("en","EN"));
 	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<String> getGroupIPVersion() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<String> groupIPVersion =session.createSQLQuery("SELECT DISTINCT T1.IP_VERSION FROM IP_GROUP T1 ORDER BY 1 ") 
		.addScalar("IP_VERSION", Hibernate.STRING).list();
		
		if(groupIPVersion == null || groupIPVersion.size() == 0){
			 groupIPVersion = session.createSQLQuery("SELECT STRING_VALUE FROM IPFM.IP_PARAMETER WHERE PARAMETER_GROUP='IP' AND PARAMETER_SUBGROUP='VERSION'  ") 
			.addScalar("STRING_VALUE", Hibernate.STRING).list();
		}
		return groupIPVersion;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IPGroup> searchIPGroup(String ipVersion,String tire1TeamID, String[] arrST,String[] arrED) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		
		List<IPGroup> lstIPGroup = new ArrayList<IPGroup>();
		
		try{
			
		if(ipVersion!=null && tire1TeamID!= null){
			StringBuffer sql = new StringBuffer();
			
			if(ipVersion.equals("6")){
				sql.append(" SELECT T7.ROW_ID, T7.IP_VERSION , T7.IP_CLASS , T7.COMPANY_ID ");
				sql.append(" , T7.GROUP_ID , T7.GROUP_IP_ST , T7.GROUP_IP_ED");
				sql.append(" , T7.ST_IP_1,T7.ST_IP_2, T7.ST_IP_3, T7.ST_IP_4,T7.ST_IP_5, T7.ST_IP_6");
				sql.append(" , T7.ED_IP_1,T7.ED_IP_2, T7.ED_IP_3, T7.ED_IP_4,T7.ED_IP_5, T7.ED_IP_6");
				sql.append(" , T7.GROUP_DESC , T7.TOTAL_IP , T7.TOTAL_ASSIGN_T2");
				sql.append("  , T7.TOTAL_ASSIGN_T3 , to_char(T7.CREATE_DATE,'dd/mm/yyy') as CREATE_DATE");
				sql.append(" , (NVL(T7.TOTAL_IP,0) - NVL(T7.TOTAL_ASSIGN_T2,0)) TOTAL_AVAIL ,M.SHORT_DESC as COMPANY_NAME,I.SHORT_DESC as IPCLASS_NAME ");
				sql.append(" FROM (");
				sql.append(" SELECT * FROM");
				sql.append(" (SELECT * FROM");
				sql.append(" (SELECT * FROM");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM IP_GROUP T1 ");
			}else{
				sql.append(" SELECT T5.ROW_ID, T5.IP_VERSION , T5.IP_CLASS , T5.COMPANY_ID   ");
				sql.append(" , T5.GROUP_ID , T5.GROUP_IP_ST , T5.GROUP_IP_ED");
				sql.append(" , T5.ST_IP_1,T5.ST_IP_2, T5.ST_IP_3, T5.ST_IP_4,T5.ST_IP_5, T5.ST_IP_6");
				sql.append(" , T5.ED_IP_1,T5.ED_IP_2, T5.ED_IP_3, T5.ED_IP_4,T5.ED_IP_5, T5.ED_IP_6");
				sql.append(" , T5.GROUP_DESC , T5.TOTAL_IP , T5.TOTAL_ASSIGN_T2");
				sql.append("  , T5.TOTAL_ASSIGN_T3 , to_char(T5.CREATE_DATE,'dd/mm/yyy') as CREATE_DATE");
				sql.append(" , (NVL(T5.TOTAL_IP,0) - NVL(T5.TOTAL_ASSIGN_T2,0)) TOTAL_AVAIL ,M.SHORT_DESC as COMPANY_NAME,I.SHORT_DESC as IPCLASS_NAME ");
				sql.append(" FROM (");
				sql.append("  SELECT * FROM");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM IP_GROUP T1");
			}
			
			if(arrST[0] == null || arrST[0].equals("")){
				sql.append(" WHERE( 255 >= T1.ST_IP_1 AND 0 <= T1.ED_IP_1)  ) T2");
			}else{
				sql.append(" WHERE("+arrST[0]+" >= T1.ST_IP_1 AND "+arrST[0]+" <= T1.ED_IP_1)  ) T2");
			}
			if(arrST[1] == null || arrST[1].equals("")){
				sql.append(" WHERE ( 255 >= T2.ST_IP_2 AND 0 <= T2.ED_IP_2)) T3");
			}else{
				sql.append(" WHERE ("+arrST[1]+">= T2.ST_IP_2 AND "+arrST[1]+" <= T2.ED_IP_2)) T3");
			}
			if(arrST[2] == null || arrST[2].equals("")){
				sql.append(" WHERE ( 255 >= T3.ST_IP_3 AND 0 <= T3.ED_IP_3) ) T4");
			}else{
				sql.append(" WHERE ("+arrST[2]+" >= T3.ST_IP_3 AND "+arrST[2]+" <= T3.ED_IP_3) ) T4");
			}
			
			if(ipVersion.equals("6")){
				if(arrST[3] == null || arrST[3].equals("")){
					sql.append(" WHERE ( 255 >= T4.ST_IP_4 AND 0 <= T4.ED_IP_4)) T5 ");
				}else{
					sql.append("  WHERE ("+arrST[3]+" >= T4.ST_IP_4 AND "+arrST[3]+" <= T4.ED_IP_4)) T5 ");
				}
				if(arrST[4] == null || arrST[4].equals("")){
					sql.append(" WHERE (255 >= T5.ST_IP_5 AND 0 <= T5.ED_IP_5)) T6");
				}else{
					sql.append(" WHERE ("+arrST[4]+" >= T5.ST_IP_5 AND "+arrST[4]+" <= T5.ED_IP_5)) T6");
				}
				if(arrST[5] == null || arrST[5].equals("")){
					sql.append("  WHERE (255 >= T6.ST_IP_6 AND 0 <= T6.ED_IP_6) ");
				}else{
					sql.append("  WHERE ("+arrST[5]+" >= T6.ST_IP_6 AND "+arrST[5]+"<= T6.ED_IP_6) ");
				}
				sql.append(" UNION ");
				sql.append(" SELECT * FROM");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM ");
			}else{
				if(arrST[3] == null || arrST[3].equals("")){
					sql.append("  WHERE ( 255 >= T4.ST_IP_4 AND 0 <= T4.ED_IP_4) ");
				}else{
					sql.append("  WHERE ("+arrST[3]+" >= T4.ST_IP_4 AND "+arrST[3]+" <= T4.ED_IP_4) ");
				}
				sql.append(" UNION ");
				sql.append(" SELECT * FROM");
				sql.append(" (SELECT * FROM ");
				sql.append(" (SELECT * FROM ");
			}
			
			
			sql.append("  (SELECT * FROM IP_GROUP T1");
			
			if(arrED[0] == null || arrED[0].equals("")){
				sql.append(" WHERE (255 >= T1.ST_IP_1 AND 0 <= T1.ED_IP_1)) T2 ");
			}else{
				sql.append(" WHERE ("+arrED[0]+" >= T1.ST_IP_1 AND "+arrED[0]+" <= T1.ED_IP_1)) T2 ");
			}
			if(arrED[1] == null || arrED[1].equals("")){
				sql.append("  WHERE (255 >= T2.ST_IP_2 AND 0 <= T2.ED_IP_2)) T3 ");
			}else{
				sql.append("  WHERE ("+arrED[1]+" >= T2.ST_IP_2 AND "+arrED[1]+" <= T2.ED_IP_2)) T3 ");
			}
			if(arrED[2] == null || arrED[2].equals("")){
				sql.append("  WHERE (255 >= T3.ST_IP_3 AND 0 <= T3.ED_IP_3)) T4 ");
			}else{
				sql.append("  WHERE ("+arrED[2]+" >= T3.ST_IP_3 AND "+arrED[2]+" <= T3.ED_IP_3)) T4 ");
			}
			if(arrED[3] == null || arrED[3].equals("")){
				sql.append(" WHERE (255 >= T4.ST_IP_4 AND 0 <= T4.ED_IP_4)) T5 ");
			}else{
				sql.append(" WHERE ("+arrED[3]+" >= T4.ST_IP_4 AND "+arrED[3]+" <= T4.ED_IP_4)) T5 ");
			}
			
			
			if(ipVersion.equals("6")){
				if(arrED[4] == null || arrED[4].equals("")){
					sql.append("  WHERE (255 >= T5.ST_IP_5 AND 0 <= T5.ED_IP_5)) T6  ");
				}else{
					sql.append("  WHERE ("+arrED[4]+" >= T5.ST_IP_5 AND "+arrED[4]+"  <= T5.ED_IP_5)) T6  ");
				}
				if(arrED[5] == null || arrED[5].equals("")){
					sql.append(" WHERE (255 >= T6.ST_IP_6 AND 0 <= T6.ED_IP_6)) T7 ");
				}else{
					sql.append(" WHERE ("+arrED[5]+"  >= T6.ST_IP_6 AND "+arrED[5]+"  <= T6.ED_IP_6)) T7 ");
				}
				sql.append(" LEFT OUTER JOIN IP_MASTER_TABLE M  on T7.COMPANY_ID = M.REF_KEY and M.REF_TABLE='COMPANY'  ");
				sql.append(" LEFT OUTER JOIN IP_MASTER_TABLE I  on T7.COMPANY_ID = I.REF_KEY and I.REF_TABLE='IP_CLASS'  ");
				sql.append(" WHERE ");
				sql.append(" T7.ACTIVE_STATUS=1");
				sql.append(" AND T7.IP_VERSION='"+ipVersion+"'");
				sql.append(" AND T7.TIER1_TEAM_ID='T2'");
			}else{
				sql.append(" LEFT OUTER JOIN IP_MASTER_TABLE M  on T5.COMPANY_ID = M.REF_KEY and M.REF_TABLE='COMPANY'  ");
				sql.append(" LEFT OUTER JOIN IP_MASTER_TABLE I  on T5.COMPANY_ID = I.REF_KEY and I.REF_TABLE='IP_CLASS'  ");
				sql.append(" WHERE ");
				sql.append(" T5.ACTIVE_STATUS=1");
				sql.append(" AND T5.IP_VERSION='"+ipVersion+"'");
				sql.append(" AND T5.TIER1_TEAM_ID='"+tire1TeamID+"'");
			}
			
			List lst  = session.createSQLQuery(sql.toString())
				.addScalar("ROW_ID", Hibernate.STRING)
				.addScalar("IP_VERSION", Hibernate.STRING)
				.addScalar("IP_CLASS", Hibernate.STRING)
				.addScalar("COMPANY_ID", Hibernate.STRING)
				.addScalar("GROUP_ID", Hibernate.STRING)
				.addScalar("GROUP_IP_ST", Hibernate.STRING)
				.addScalar("GROUP_IP_ED", Hibernate.STRING)
				.addScalar("ST_IP_1", Hibernate.STRING)
				.addScalar("ST_IP_2", Hibernate.STRING)
				.addScalar("ST_IP_3", Hibernate.STRING)
				.addScalar("ST_IP_4", Hibernate.STRING)
				.addScalar("ST_IP_5", Hibernate.STRING)
				.addScalar("ST_IP_6", Hibernate.STRING)
				.addScalar("ED_IP_1", Hibernate.STRING)
				.addScalar("ED_IP_2", Hibernate.STRING)
				.addScalar("ED_IP_3", Hibernate.STRING)
				.addScalar("ED_IP_4", Hibernate.STRING)
				.addScalar("ED_IP_5", Hibernate.STRING)
				.addScalar("ED_IP_6", Hibernate.STRING)
				.addScalar("GROUP_DESC", Hibernate.STRING)
				.addScalar("TOTAL_IP", Hibernate.INTEGER)
				.addScalar("TOTAL_ASSIGN_T2", Hibernate.INTEGER)
				.addScalar("TOTAL_ASSIGN_T3", Hibernate.INTEGER)
				.addScalar("CREATE_DATE", Hibernate.STRING)
				.addScalar("TOTAL_AVAIL", Hibernate.INTEGER)
				.addScalar("COMPANY_NAME", Hibernate.STRING)
				.addScalar("IPCLASS_NAME", Hibernate.STRING)
				.list();
			
				Iterator iter = lst.iterator();
				 	if (!iter.hasNext())
			        {
			            return lstIPGroup;
			        }
			        while (iter.hasNext())
			        {
			            Object[] obj = (Object[]) iter.next();
			            
			            IPGroup group = new IPGroup();
						group.setRowID((String) obj[0]);
						group.setIpVersion((String) obj[1]);
						group.setIpClass((String) obj[2]);
						group.setCompanyID((String) obj[3]);
						
						group.setGrpID((String) obj[4]); 
						group.setGrpIPST((String) obj[5]);
						group.setGrpIPED((String) obj[6]);
						
						group.setStIP1((String) obj[7]);
						group.setStIP2((String) obj[8]);
						group.setStIP3((String) obj[9]);
						group.setStIP4((String) obj[10]);
						group.setStIP5((String) obj[11]);
						group.setStIP6((String) obj[12]);
						group.setEdIP1((String) obj[13]);
						group.setEdIP2((String) obj[14]);
						group.setEdIP3((String) obj[15]);
						group.setEdIP4((String) obj[16]);
						group.setEdIP5((String) obj[17]);
						group.setEdIP6((String) obj[18]);
						
						if(obj[18] != null){
							group.setGrpDesc((String) obj[19]);
						}
						group.setTotalIP((Integer) obj[20]);
						group.setTotalAssignT2((Integer) obj[21]);
						group.setTotalAssignT3((Integer) obj[22]);
						if( obj[23]!= null){
							Date dmy = smf.parse((String) obj[23]);
							group.setCreated(dmy);
						}
						group.setTotAVAIL((Integer) obj[24]);
						group.setCompanyName((String) obj[25]);
						group.setIpClassName((String) obj[26]);
						lstIPGroup.add(group);
			        }
	
		}

 		}catch (Exception e) {
			throw e;
		}
		return lstIPGroup;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IPGroup searchIPGroupById(String rowId,String grpId) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		
		IPGroup group = new IPGroup();
		
		try{
			
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT T1.ROW_ID, T1.IP_VERSION ");
			sql.append(" , T1.IP_CLASS ,cl.SHORT_DESC as CLASS_NAME, T1.COMPANY_ID ,c.SHORT_DESC as COMPANY_NAME");
			sql.append(" , T1.GROUP_ID , T1.GROUP_IP_ST , T1.GROUP_IP_ED");
			sql.append(" , T1.ST_IP_1,T1.ST_IP_2, T1.ST_IP_3, T1.ST_IP_4,T1.ST_IP_5, T1.ST_IP_6");
			sql.append(" , T1.ED_IP_1,T1.ED_IP_2, T1.ED_IP_3, T1.ED_IP_4,T1.ED_IP_5, T1.ED_IP_6");
			sql.append(" , T1.GROUP_DESC , T1.TOTAL_ASSIGN_T2 , T1.TOTAL_ASSIGN_T3,T1.TOTAL_IP,T1.CREATE_DATE");
			sql.append(" FROM IP_GROUP T1");
			sql.append(" left  join IP_MASTER_TABLE c");
			sql.append(" on T1.COMPANY_ID =c.REF_KEY and c.REF_TABLE='COMPANY'");
			sql.append(" left  join IP_MASTER_TABLE cl");
			sql.append(" on T1.IP_CLASS =cl.REF_KEY and cl.REF_TABLE='IP_CLASS'");
			if(rowId!= null){
				sql.append(" WHERE T1.ROW_ID='"+rowId+"'");
			}else if(grpId!= null){
				sql.append(" WHERE T1.GROUP_ID='"+grpId+"'");
			}
			List lst  = session.createSQLQuery(sql.toString())
				.addScalar("ROW_ID", Hibernate.STRING)
				.addScalar("IP_VERSION", Hibernate.STRING)
				.addScalar("IP_CLASS", Hibernate.STRING)
				.addScalar("CLASS_NAME", Hibernate.STRING)
				.addScalar("COMPANY_ID", Hibernate.STRING)
				.addScalar("COMPANY_NAME", Hibernate.STRING)
				.addScalar("GROUP_ID", Hibernate.STRING)
				.addScalar("GROUP_IP_ST", Hibernate.STRING)
				.addScalar("GROUP_IP_ED", Hibernate.STRING)
				.addScalar("ST_IP_1", Hibernate.STRING)
				.addScalar("ST_IP_2", Hibernate.STRING)
				.addScalar("ST_IP_3", Hibernate.STRING)
				.addScalar("ST_IP_4", Hibernate.STRING)
				.addScalar("ST_IP_5", Hibernate.STRING)
				.addScalar("ST_IP_6", Hibernate.STRING)
				.addScalar("ED_IP_1", Hibernate.STRING)
				.addScalar("ED_IP_2", Hibernate.STRING)
				.addScalar("ED_IP_3", Hibernate.STRING)
				.addScalar("ED_IP_4", Hibernate.STRING)
				.addScalar("ED_IP_5", Hibernate.STRING)
				.addScalar("ED_IP_6", Hibernate.STRING)
				.addScalar("GROUP_DESC", Hibernate.STRING)
				.addScalar("TOTAL_ASSIGN_T2", Hibernate.INTEGER)
				.addScalar("TOTAL_ASSIGN_T3", Hibernate.INTEGER)
				.addScalar("TOTAL_IP", Hibernate.INTEGER)
				.addScalar("CREATE_DATE", Hibernate.DATE)
				.list();
			
			  
				Iterator iter = lst.iterator();
				 	if (!iter.hasNext())
			        {
			            return group;
			        }
			        if (iter.hasNext())
			        {
			            Object[] obj = (Object[]) iter.next();
			            
						group.setRowID((String) obj[0]);
						group.setIpVersion((String) obj[1]);
						group.setIpClass((String) obj[2]);
						group.setIpClassName((String) obj[3]);
						group.setCompanyID((String) obj[4]);
						group.setCompanyName((String) obj[5]);
						group.setGrpID((String) obj[6]); 
						group.setGrpIPST((String) obj[7]);
						group.setGrpIPED((String) obj[8]);
						group.setStIP1((String) obj[9]);
						group.setStIP2((String) obj[10]);
						group.setStIP3((String) obj[11]);
						group.setStIP4((String) obj[12]);
						group.setStIP5((String) obj[13]);
						group.setStIP6((String) obj[14]);
						group.setEdIP1((String) obj[15]);
						group.setEdIP2((String) obj[16]);
						group.setEdIP3((String) obj[17]);
						group.setEdIP4((String) obj[18]);
						group.setEdIP5((String) obj[19]);
						group.setEdIP6((String) obj[20]);
						group.setGrpDesc((String) obj[21]);
						group.setTotalAssignT2((Integer) obj[22]);
						group.setTotalAssignT3((Integer) obj[23]);
						group.setTotalIP((Integer) obj[24]);
						//if( obj[26]!= null){
						//	Date dmy = smf.parse((String) obj[26]);
							group.setCreated((Date)obj[25]);
						//}
			        }

 		}catch (Exception e) {
			throw e;
		}
		return group;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getMaxGrpId() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String maxid =  (String) session.createSQLQuery("  select 'G'||LPAD(SEQ_GROUP_ID.Nextval,4,0) as maxid from dual ")
				.addScalar("maxid", Hibernate.STRING).uniqueResult();
		return maxid;
	}

	@Override
	public IPGroup searchGroupEdit() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<String> getGroupIPList()
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<String> groupIPList = session.createSQLQuery("SELECT DISTINCT GROUP_IP_ST||' - '||GROUP_IP_ED AS GROUP_IP FROM IP_GROUP ORDER BY 1")		
		.addScalar("GROUP_IP", Hibernate.STRING).list();
		return groupIPList;
	}

}
