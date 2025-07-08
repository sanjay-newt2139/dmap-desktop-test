package th.co.ais.ipfm.dao.hibernate;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import th.co.ais.ipfm.dao.TempIPLevel2Dao;
import th.co.ais.ipfm.domain1.TempIpLevel2;




public class HibernateTempIPLevel2Dao extends HibernateGenericDao<TempIpLevel2> implements TempIPLevel2Dao{
	
	@Override
	public void createTempIPLevel2(String ip1, String ip2,
			String ip3, String ip4, String mask, String teamId)
			throws Exception {
		Connection connection = null;
		CallableStatement stmt = null;
		try{
			Session session = getSessionFactory().getCurrentSession();
			connection = session.connection();
			 
			 String procedureName = "{call List_IP_Level2(?,?,?,?,?,?)}";
			 stmt = connection.prepareCall(procedureName);
			 //set PL parameter &amp; value
			 stmt.setLong(1,Long.parseLong(ip1));
			 stmt.setLong(2,Long.parseLong(ip2));
			 stmt.setLong(3,Long.parseLong(ip3));
			 stmt.setLong(4,Long.parseLong(ip4));
			 stmt.setLong(5,Long.parseLong(mask));
			 if (teamId!=null && teamId.trim().length()>0) stmt.setString(6, teamId);
			 else stmt.setString(6, "All");
			 stmt.execute();
			 
			
//			 IpLevel2 ipLevel2 = getIpLevel2StartEnd(ip1, ip2, ip3, ip4, mask);
//			 String binaryStart = "";
//				String binaryEnd = "";
//				List<IpLevel2> ipLevel2StartList = ipLevel2Dao.searchBinaryStartBetweenDate(ipLevel2.getIp1StartBinary()+ipLevel2.getIp2StartBinary()+ipLevel2.getIp3StartBinary()+ipLevel2.getIp4StartBinary());
//				if (ipLevel2StartList.size()>0) {
//					binaryStart = ipLevel2StartList.get(0).getBinary2Start();
//				}else{
//					binaryStart = ipLevel2.getIp1StartBinary()+ipLevel2.getIp2StartBinary()+ipLevel2.getIp3StartBinary()+ipLevel2.getIp4StartBinary();
//				}
//				List<IpLevel2> ipLevel2EndList = ipLevel2Dao.searchBinaryEndBetweenDate(ipLevel2.getIp1EndBinary()+ipLevel2.getIp2EndBinary()+ipLevel2.getIp3EndBinary()+ipLevel2.getIp4EndBinary());
//				if (ipLevel2EndList.size()>0) {
//					binaryEnd = ipLevel2EndList.get(ipLevel2EndList.size()-1).getBinary2End();
//				}else{
//					binaryEnd = ipLevel2.getIp1EndBinary()+ipLevel2.getIp2EndBinary()+ipLevel2.getIp3EndBinary()+ipLevel2.getIp4EndBinary();
//				}
//			 List<IpLevel2> result = ipLevel2Dao.searchBinaryRange(binaryStart,binaryEnd,1000);
			 stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
			throw ex;
		} finally{
			try{
				if (stmt!=null){
					stmt.close();
					stmt = null;
				}
				if (connection!=null) {
					connection.close();
					connection=null;
				}
			} catch (Exception ex){}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TempIpLevel2> findTempIpLevel2(Integer maxSearchResult) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		List<TempIpLevel2> result = new ArrayList<TempIpLevel2>();
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t ");
		sql.append(" from TempIpLevel2 t ");
		sql.append(" order by t.binary2Start, t.binary2Start ");  
		
		result =  session.createQuery(sql.toString()).setMaxResults(maxSearchResult).list();
		
//		Criteria criteria = session.createCriteria(TempIpLevel2.class);
//		criteria.addOrder(Order.asc("binary2Start"));
//		criteria.addOrder(Order.asc("binary2End"));
//		criteria.setMaxResults(maxSearchResult);
//		result = criteria.list();
//		Hibernate.initialize(result);
		return result;
	}
	
	public List<TempIpLevel2> searchIpLevel2(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4, String mask, String teamId, Integer maxSearchResult) throws Exception {
		List<TempIpLevel2> result = new ArrayList<TempIpLevel2>();
		createTempIPLevel2(ipDigit1, ipDigit2, ipDigit3, ipDigit4, mask, teamId);
		result = findTempIpLevel2(maxSearchResult);
		return result;
	}
}
