package th.co.ais.ipfm.dao.hibernate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.CommonDao;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpMasterTableId;


public class HibernateCommonDao extends HibernateGenericDao<IpMasterTable> implements CommonDao {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String getROW_ID() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
//		String msId = (String) session.createSQLQuery("  SELECT 'MS' || LPAD(SEQ_MS_TABLE.NEXTVAL ,6,'0') AS ROW_ID  FROM DUAL ")
		String msId = (String) session.createSQLQuery(" SELECT SYS_GUID()AS ROW_ID FROM DUAL ")
		
				.addScalar("ROW_ID", Hibernate.STRING).uniqueResult();
		return msId;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpMasterTable> getMasterList(String refTable) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable", refTable));
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.addOrder(Order.asc("orderData"));
		criteria.addOrder(Order.asc("shortDesc"));
		return criteria.list();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public IpMasterTable getMasterById(String rowId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("rowId", rowId)).list();

		IpMasterTable ipMasterTable = new IpMasterTable();
		ipMasterTable = (IpMasterTable)criteria.list().get(0);
		return ipMasterTable;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public IpMasterTable getMasterTableById(String rowId) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT REF_TABLE, REF_KEY, SHORT_DESC, REF_DESC, REF_TYPE, TCP, UDP, OTHER, HOLIDAY_DATE, ACTIVE_STATUS,");
		sql.append(" CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, ROW_ID, VERSION, ORDER_DATA ");
		sql.append(" FROM IPFM.IP_MASTER_TABLE ");
		sql.append(" WHERE ROW_ID = '"+rowId+"' ");
		
		HashMap map = (HashMap)session.createSQLQuery(sql.toString())
		.addScalar("REF_TABLE", Hibernate.STRING)
		.addScalar("REF_KEY", Hibernate.STRING)
		.addScalar("SHORT_DESC", Hibernate.STRING)
		.addScalar("REF_DESC", Hibernate.STRING)
		.addScalar("REF_TYPE", Hibernate.STRING)
		.addScalar("TCP", Hibernate.STRING)
		.addScalar("UDP", Hibernate.STRING)
		.addScalar("OTHER", Hibernate.STRING)
		.addScalar("HOLIDAY_DATE", Hibernate.DATE)
		.addScalar("ACTIVE_STATUS", Hibernate.STRING)
		.addScalar("CREATE_BY", Hibernate.STRING)
		.addScalar("CREATE_DATE", Hibernate.DATE)
		.addScalar("UPDATE_BY", Hibernate.STRING)
		.addScalar("UPDATE_DATE", Hibernate.DATE)
		.addScalar("ROW_ID", Hibernate.STRING)
		.addScalar("VERSION", Hibernate.STRING)
		.addScalar("ORDER_DATA", Hibernate.STRING)
		.uniqueResult();

		IpMasterTable ipMasterTable = new IpMasterTable();
		IpMasterTableId id = new IpMasterTableId();
		id.setRefTable((String)map.get("REF_TABLE"));
		id.setRefKey((String)map.get("REF_KEY"));
		ipMasterTable.setId(id);		
		ipMasterTable.setShortDesc((String)map.get("SHORT_DESC"));
		ipMasterTable.setRefDesc((String)map.get("REF_DESC"));
		ipMasterTable.setRefType((String)map.get("REF_TYPE"));
		ipMasterTable.setTcp((String)map.get("TCP"));
		ipMasterTable.setUdp((String)map.get("UDP"));
		ipMasterTable.setOther((String)map.get("OTHER"));
		ipMasterTable.setHolidayDate((Date)map.get("HOLIDAY_DATE"));
		ipMasterTable.setActiveStatus((String)map.get("ACTIVE_STATUS"));
		ipMasterTable.setCreatedBy((String)map.get("CREATE_BY"));
		ipMasterTable.setCreated((Date)map.get("CREATE_DATE"));
		ipMasterTable.setLastUpdBy((String)map.get("UPDATE_BY"));
		ipMasterTable.setLastUpd((Date)map.get("UPDATE_DATE"));
		ipMasterTable.setRowId((String)map.get("ROW_ID"));
		ipMasterTable.setVersion((Long)map.get("VERSION"));
		ipMasterTable.setOrderData(Integer.parseInt((String)map.get("ORDER_DATA")));
	
		return ipMasterTable;
		
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpMasterTable> getMasterTableList(String refTable) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT REF_TABLE, REF_KEY, SHORT_DESC, REF_DESC, REF_TYPE, TCP, UDP, OTHER, TO_CHAR(HOLIDAY_DATE,'DD/MM/YYYY') AS HOLIDAY_DATE, ACTIVE_STATUS, ROW_ID");
		sql.append(" FROM IPFM.IP_MASTER_TABLE ");
		sql.append(" WHERE REF_TYPE like 'MS' AND ACTIVE_STATUS = '1' AND REF_TABLE = '"+refTable+"'");
		
		List<IpMasterTable>  masterList = session.createSQLQuery(sql.toString())
		.addScalar("REF_TABLE", Hibernate.STRING)
		.addScalar("REF_KEY", Hibernate.STRING)
		.addScalar("SHORT_DESC", Hibernate.STRING)
		.addScalar("REF_DESC", Hibernate.STRING)
		.addScalar("REF_TYPE", Hibernate.STRING)
		.addScalar("TCP", Hibernate.STRING)
		.addScalar("UDP", Hibernate.STRING)
		.addScalar("OTHER", Hibernate.STRING)
		.addScalar("HOLIDAY_DATE", Hibernate.DATE)
		.addScalar("ACTIVE_STATUS", Hibernate.STRING)
		.addScalar("ROW_ID", Hibernate.STRING)
//		.addScalar("ORDER_DATA", Hibernate.INTEGER)
		.list();
		return masterList;
		
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<IpMasterTable> getMaster_activeStatus_List(String refTable) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		criteria.add(Restrictions.eq("id.refTable", refTable));
		criteria.add(Restrictions.eq("activeStatus", "1"));
		
		criteria.addOrder(Order.asc("shortDesc"));
		return criteria.list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		
		if(refTable!=null && refTable.trim().length()>0){
			criteria.add(Restrictions.eq("id.refTable", refTable.trim()));		
		}
		if(refKey!=null && refKey.trim().length()>0){
			criteria.add(Restrictions.eq("id.refKey", refKey.trim()));		
		}
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.add(Restrictions.eq("refType", "MS"));
	
		criteria.addOrder(Order.asc("id.refTable"));		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpMasterTable> searchMasterTableForADD(String refTable, String refKey, String status) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		
		if(refTable!=null && refTable.trim().length()>0){
			criteria.add(Restrictions.eq("id.refTable", refTable.trim()));		
		}
		if(refKey!=null && refKey.trim().length()>0){
			criteria.add(Restrictions.eq("id.refKey", refKey.trim()));		
		}
		if(status!=null && status.trim().length()>0){
			criteria.add(Restrictions.ne("activeStatus", status.trim()));		
		}
		criteria.add(Restrictions.eq("refType", "MS"));	
		criteria.addOrder(Order.asc("id.refTable"));		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey, String refDesc) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		
		if(refTable!=null && refTable.trim().length()>0){
			criteria.add(Restrictions.like("id.refTable", "%"+refTable+"%"));		
		}
		if(refKey!=null && refKey.trim().length()>0){
			criteria.add(Restrictions.like("id.refKey", "%"+refKey+"%"));		
		}
		if(refDesc!=null && refDesc.trim().length()>0){
			criteria.add(Restrictions.like("refDesc", "%"+refDesc+"%"));		
		}else{
			criteria.add(Restrictions.eq("refDesc", null));
		}
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.add(Restrictions.eq("refType", "MS"));
	
		criteria.addOrder(Order.asc("id.refKey"));		
		return criteria.list();
	}

	@Override
	public int countSearchMasterTable(String refTable, String refKey) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		
		if(refTable!=null && refTable.trim().length()>0){
			criteria.add(Restrictions.like("id.refTable", "%"+refTable+"%"));		
		}
		if(refKey!=null && refKey.trim().length()>0){
			criteria.add(Restrictions.like("id.refKey", "%"+refKey+"%"));		
		}
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.add(Restrictions.eq("refType", "MS"));
		
		criteria.setProjection(Projections.rowCount());
		
		return ((Integer)criteria.list().get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey, int maxResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		if(maxResult>0){
			criteria.setMaxResults(maxResult);	
		}		
		if(refTable!=null && refTable.trim().length()>0){
			criteria.add(Restrictions.like("id.refTable", "%"+refTable+"%"));		
		}
		if(refKey!=null && refKey.trim().length()>0){
			criteria.add(Restrictions.like("id.refKey", "%"+refKey+"%"));		
		}
		criteria.add(Restrictions.eq("activeStatus", "1"));
		criteria.add(Restrictions.eq("refType", "MS"));
		criteria.addOrder(Order.asc("id.refTable"));	
		return criteria.list();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<String> getMasterRefTableList() throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sb = new StringBuffer();
		String ms="MS";
		sb.append(" SELECT DISTINCT  REF_TABLE ");
		sb.append(" FROM  IP_MASTER_TABLE  ");
		sb.append(" WHERE ACTIVE_STATUS = '"+1+"' ");
		sb.append(" AND REF_TYPE = '"+ms+"'");
		sb.append(" ORDER BY REF_TABLE ");
		List<String> masterRefTableList = session.createSQLQuery(sb.toString())
		.addScalar("REF_TABLE", Hibernate.STRING).list();
		return masterRefTableList;
	}
	

	@Override
	public List<IpMasterTable> getMasterRefKeyList(String refTable)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpMasterTable.class);
		
		criteria.add(Restrictions.like("id.refTable", "%"+refTable+"%"));
		criteria.add(Restrictions.like("activeStatus", "1"));
		criteria.add(Restrictions.like("refType", "MS"));
		if(refTable!=null && refTable.equals("HOLIDAY")){
			criteria.addOrder(Order.asc("id.refKey"));
		}else{
			criteria.addOrder(Order.asc("shortDesc"));
		}
		
		
		return criteria.list();
	}


	public void insertMaster(IpMasterTable entity) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Object[] params = null;			
		
		sql.append(" INSERT INTO IP_MASTER_TABLE ");
		sql.append(" (REF_TABLE, REF_KEY, SHORT_DESC, REF_DESC, REF_TYPE, TCP, UDP, OTHER, HOLIDAY_DATE, ACTIVE_STATUS, ");
		sql.append(" CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, ROW_ID, VERSION, ORDER_DATA) ");
		sql.append(" VALUES ('"+entity.getId().getRefTable()+"', ");
		sql.append(" '"+entity.getId().getRefKey()+"', ");
		sql.append(" '"+entity.getShortDesc()+"', ");
		sql.append(" '"+entity.getRefDesc()+"', ");
		sql.append(" '"+entity.getRefType()+"', ");
		if(entity.getTcp()!=null){
			sql.append(" '"+entity.getTcp()+"', ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getUdp()!=null){
			sql.append(" '"+entity.getUdp()+"', ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getOther()!=null){
			sql.append(" '"+entity.getOther()+"', ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getHolidayDate()!=null){
			sql.append(entity.getHolidayDate()+", ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getActiveStatus()!=null){
			sql.append(" '"+entity.getActiveStatus()+"', ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getCreatedBy()!=null){
			sql.append(" '"+entity.getCreatedBy()+"', ");
		}else{
			sql.append(" null, ");			
		}
		sql.append(" SYSDATE, ");
		if(entity.getLastUpdBy()!=null){
			sql.append(" '"+entity.getLastUpdBy()+"', ");
		}else{
			sql.append(" null, ");			
		}
		sql.append(" SYSDATE, ");
		if(entity.getRowId()!=null){
			sql.append(" '"+entity.getRowId()+"', ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getVersion()!=null){
			sql.append(" '"+entity.getVersion()+"', ");
		}else{
			sql.append(" null, ");			
		}
		if(entity.getOrderData()!=null){
			sql.append(" '"+entity.getOrderData()+"', ");
		}else{
			sql.append(" null ");			
		}		

		sql.append(") ");	
		
		//DateUtil.convertDateTime2String(alOwnerBean.getAlDate(), "ddMMyyyy HH:mm:ss");
		session.createSQLQuery(sql.toString()).executeUpdate();
		session.save(entity);
		session.flush();
		
	}
	
	@Override
	public void deleteByRowId(String rowId) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_MASTER_TABLE WHERE ROW_ID = ?";
		session.createSQLQuery(sql).setString(0, rowId).executeUpdate();
		
	}
	
	@Override
	public void updateNews(IpMasterTable obj) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();

		sql.append(" UPDATE IP_MASTER_TABLE ");
		sql.append(" SET REF_DESC = ?,");
		sql.append(" UPDATE_BY = ? ,");
		sql.append(" UPDATE_DATE = SYSDATE ");
		sql.append(" WHERE REF_TABLE='NEWS' AND ACTIVE_STATUS=1 ");
			
		session.createSQLQuery(sql.toString())
		.setString(0, obj.getRefDesc())
		.setString(1, obj.getLastUpdBy())
		.executeUpdate();
		
	} 

	@Override
	public void updateFlag(IpMasterTable masterTBL,String refTable,String refKey,String userId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
       try{
			sql.append(" UPDATE IP_MASTER_TABLE ");
			sql.append(" SET ACTIVE_STATUS  = ?,");
			sql.append(" UPDATE_BY = ? ,");
			sql.append(" UPDATE_DATE = SYSDATE ");
			sql.append(" WHERE REF_TYPE = ?  AND REF_TABLE = ?  AND REF_KEY = ? ");
				
			session.createSQLQuery(sql.toString())
			.setString(0, "0")
			.setString(1, userId)
			.setString(2, "MS") 
			.setString(3, refTable)
			.setString(4, refKey)
	
			.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 

	public String genReport()throws DataAccessException{
		 
		 Connection connection = null;
		 CallableStatement stmt = null;
		 String plName = "";
		 try{
			 
			connection = getSessionFactory().getCurrentSession().connection();
			plName = "{call GEN_REPORT_IPRUR001()}";
			
			stmt = connection.prepareCall(plName);
			
			stmt.execute();
			
			System.out.println("plName : "+plName);
			
		} catch (Exception ex){
				ex.printStackTrace();
		} finally{
			try{	
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				if (connection!=null) {
					connection.close();
					connection=null;
				}
			} catch (Exception ex){}
		}
		return plName;
	
	}
	
	public String updateUROverSlaOla()throws DataAccessException{
		 
		 Connection connection = null;
		 CallableStatement stmt = null;
		 String plName = "";
		 try{

			connection = getSessionFactory().getCurrentSession().connection();
			plName = "{call UPDATE_UR_OVER_OLA_SLA()}";
			stmt = connection.prepareCall(plName);
			stmt.execute();
		} catch (Exception ex){
				ex.printStackTrace();
		} finally{
			try{	
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				if (connection!=null) {
					connection.close();
					connection=null;
				}
			} catch (Exception ex){}
		}
		return plName;
	}
}
