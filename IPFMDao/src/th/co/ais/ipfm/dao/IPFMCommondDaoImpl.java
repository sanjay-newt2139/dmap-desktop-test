package th.co.ais.ipfm.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPMasterValue;
import th.co.ais.ipfm.domain1.IpInfo;

public class IPFMCommondDaoImpl implements IPFMCommondDao {
	//protected DataSource dataSource;
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String getSysdate() throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		String sysDate =  (String) session.createSQLQuery("SELECT  to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')   as datenow  FROM dual")
				.addScalar("datenow", Hibernate.STRING).uniqueResult();
		return sysDate;
	}

	@Override
	public List<Map> callStore(String callName, List params) {
		// TODO Auto-generated method stub
		List resultList = new ArrayList<Map>();
		System.out.println("Execute from Store >>> "+callName);
		
		ResultSet rs = null;
		CallableStatement cstmt = null;
		Connection connection = null;
		
		try{
			connection = sessionFactory.getCurrentSession().connection();
			//connection = dataSource.getConnection();
			
			cstmt =connection.prepareCall(callName);
			cstmt.registerOutParameter(1,oracle.jdbc.driver.OracleTypes.CURSOR);
			int pos=2;
			if(params!=null){
				for(Object obj : params){
					cstmt.setObject(pos++, obj);
				}
			}
			cstmt.executeQuery();
			rs = (ResultSet)cstmt.getObject(1);
			while(rs.next()){
				Map result = new HashMap<String,Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for(int i=1;i<=columnCount;i++){
					String columnName = rsmd.getColumnName(i);
					result.put(columnName, rs.getObject(columnName));
				}
				resultList.add(result);
			}
			
		} catch (Exception ex){
			ex.printStackTrace();
		} finally{
			try{
				rs.close();
				cstmt.close();
				connection.close();
			} catch (Exception ex){
				
			}
		}
		return resultList;
	}


//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	public void execStore(String callName, List params) {
		// TODO Auto-generated method stub
//		System.out.println("Execute from Store >>> "+callName);
		
		ResultSet rs = null;
		CallableStatement cstmt = null;
		Connection connection = null;
		
		try{
			//connection = dataSource.getConnection();
			connection = sessionFactory.getCurrentSession().connection();
			cstmt =connection.prepareCall(callName);
			int pos=1;
			if(params!=null){
				for(Object obj : params){
					cstmt.setObject(pos++, obj);
				}
			}
			cstmt.executeQuery();
		} catch (Exception ex){
			ex.printStackTrace();
		} finally{
			try{			
				rs.close();
				cstmt.close();
				connection.close();
			} catch (Exception ex){
				
			}
		}
	}

	@Override
	public List<IPMasterValue> getMasterValue(String valueGroup) {		
		Connection connection = null;
		List<IPMasterValue> result = new ArrayList<IPMasterValue>();
		try{
			Session session = sessionFactory.getCurrentSession();
			String sql = "SELECT value_group,name,value,description FROM IP_MASTER_VALUE WHERE value_group = :groupName ";
			List dataList =  session.createSQLQuery(sql).setParameter("groupName", valueGroup).list();
			Iterator iter = dataList.iterator();
			while(iter.hasNext()) {
				
				Object[] obj = (Object[])iter.next();
				IPMasterValue bean = new IPMasterValue();
				bean.setValueGroup((String)obj[0]);
				bean.setValueName((String)obj[1]);
				bean.setValueData((String)obj[2]);
				bean.setValueDescription((String)obj[3]);
				result.add(bean);
			}				
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
