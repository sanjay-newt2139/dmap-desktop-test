package th.co.ais.ipfm.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpLevel2;

public class CallProcedureDaoImpl implements CallProcedureDao {
	private SessionFactory sessionFactory;
	private TempIPLevel2Dao tempIpLevel2Dao;

	public void setTempIpLevel2Dao(TempIPLevel2Dao tempIpLevel2Dao) {
		this.tempIpLevel2Dao = tempIpLevel2Dao;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("deprecation")
	public void processIpLevel2(String ip1, String ip2, String ip3, String ip4, String mask, String teamId) throws Exception {
		Connection connection = null;
		CallableStatement stmt = null;
		try{
			Session session = sessionFactory.getCurrentSession();
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

	public Map getIpStartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception {
		Map ipMap = new HashedMap();
		Connection connection = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			connection = session.connection();
			 
			 String procedureName = "{call GET_IP_START_END(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			 CallableStatement stmt = connection.prepareCall(procedureName);
			 //set PL parameter &amp; value
			 stmt.setLong(1,Long.parseLong(ip1));
			 stmt.setLong(2,Long.parseLong(ip2));
			 stmt.setLong(3,Long.parseLong(ip3));
			 stmt.setLong(4,Long.parseLong(ip4));
			 stmt.setLong(5,Long.parseLong(mask));
			 
			 stmt.registerOutParameter(6, OracleTypes.INTEGER);
			 stmt.registerOutParameter(7, OracleTypes.INTEGER);
			 stmt.registerOutParameter(8, OracleTypes.INTEGER);
			 stmt.registerOutParameter(9, OracleTypes.INTEGER);
			 stmt.registerOutParameter(10, OracleTypes.INTEGER);
			 stmt.registerOutParameter(11, OracleTypes.INTEGER);
			 stmt.registerOutParameter(12, OracleTypes.INTEGER);
			 stmt.registerOutParameter(13, OracleTypes.INTEGER);
			 stmt.execute();
			 
			 String ipStart = stmt.getInt(6)+"."+stmt.getInt(7)+"."+stmt.getInt(8)+"."+stmt.getInt(9);
			 String ipEnd = stmt.getInt(10)+"."+stmt.getInt(11)+"."+stmt.getInt(12)+"."+stmt.getInt(13);
			 ipMap.put("ipStart", ipStart);
			 ipMap.put("ipEnd", ipEnd);
			 stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
			throw ex;
		} finally{
			try{
				if (connection!=null) connection.close();
			} catch (Exception ex){}
		}
		return ipMap;
	}
	public Map getIpStartEnd2(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception {
		Map ipMap = new HashedMap();
		Connection connection = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			connection = session.connection();
			 
			 String procedureName = "{call GET_IP_START_END2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			 CallableStatement stmt = connection.prepareCall(procedureName);
			 //set PL parameter &amp; value
			 stmt.setLong(1,Long.parseLong(ip1));
			 stmt.setLong(2,Long.parseLong(ip2));
			 stmt.setLong(3,Long.parseLong(ip3));
			 stmt.setLong(4,Long.parseLong(ip4));
			 stmt.setLong(5,Long.parseLong(mask));
			 
			 stmt.registerOutParameter(6, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(7, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(8, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(9, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(10, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(11, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(12, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(13, OracleTypes.VARCHAR); 
			 stmt.registerOutParameter(14, OracleTypes.VARCHAR);
			 stmt.registerOutParameter(15, OracleTypes.VARCHAR);
			 stmt.execute();
			 
			 String ipStart = stmt.getString(6);
			 String ipEnd = stmt.getString(7);
			 ipMap.put("ipStart", ipStart);
			 ipMap.put("ipEnd", ipEnd);
			 stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
			throw ex;
		} finally{
			try{
				if (connection!=null) connection.close();
			} catch (Exception ex){}
		}
		return ipMap;
	}
	@Override
	public IpLevel1 getIpLevel1StartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception {
		IpLevel1 ipLevel1 = new IpLevel1();
		try{
			Map ipMap = getIpStartEnd(ip1, ip2, ip3, ip4, mask);
			ipLevel1.setLevel1Start((String)ipMap.get("ipStart"));
			ipLevel1.setLevel1End((String)ipMap.get("ipEnd"));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return ipLevel1;
	}
	
	@Override
	public IpLevel2 getIpLevel2StartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception {
		IpLevel2 ipLevel2 = new IpLevel2();
		try{
			Map ipMap = getIpStartEnd(ip1, ip2, ip3, ip4, mask);
			ipLevel2.setLevel2Start((String)ipMap.get("ipStart"));
			ipLevel2.setLevel2End((String)ipMap.get("ipEnd"));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return ipLevel2;
	}
	
	@Override
	public IpInfo getIpInfoStartEnd(String ip1, String ip2, String ip3, String ip4, String mask) throws Exception {
		IpInfo ipInfo = new IpInfo();
		try{
			Map ipMap = getIpStartEnd2(ip1, ip2, ip3, ip4, mask);
			ipInfo.setBinaryIpStart((String)ipMap.get("ipStart"));
			ipInfo.setBinaryIpEnd((String)ipMap.get("ipEnd"));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return ipInfo;
	}
	
	@Override
	public String checkIsTnp(String urNo) throws Exception {
		String result = "";
		Connection connection = null;
		try{
			 Session session = sessionFactory.getCurrentSession();
			 connection = session.connection();
			 CallableStatement stmt = connection.prepareCall("{call check_is_tnp(?,?)}");

			 stmt.setString(1,urNo);
			 stmt.registerOutParameter(2, OracleTypes.VARCHAR);
			 stmt.execute();
			 result = stmt.getString(2);
			 stmt.close();
		 } catch (Exception ex){
				ex.printStackTrace();
				throw ex;
		} finally{
			try{		
				connection.close();
			} catch (Exception ex){
				
			}
		}
		return result;
	}
	
	public Map verifyImportLv3(String username, String userRole) throws Exception {
		Map resultMap = new HashedMap();
		Connection connection = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			connection = session.connection();
			 
			 String procedureName = "{call VERIFY_IMPORT_LV3(? ,? ,? ,?)}";
			 CallableStatement stmt = connection.prepareCall(procedureName);
			 //set PL parameter &amp; value
			 stmt.setString(1,username);
			 stmt.setString(2,userRole);
			 
			 stmt.registerOutParameter(3, OracleTypes.INTEGER);
			 stmt.registerOutParameter(4, OracleTypes.INTEGER);
			 stmt.execute();
			 
			 resultMap.put("error", stmt.getInt(3));
			 resultMap.put("warn", stmt.getInt(4));
			 stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
			throw ex;
		} finally{
			try{
				if (connection!=null) connection.close();
			} catch (Exception ex){}
		}
		return resultMap;
	}
	
	public void updateImportLv3(String username) throws Exception {
		Map resultMap = new HashedMap();
		Connection connection = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			connection = session.connection();
			 
			 String procedureName = "{call UPDATE_IMPORT_LV3(? )}";
			 CallableStatement stmt = connection.prepareCall(procedureName);
			 //set PL parameter &amp; value
			 stmt.setString(1,username);
			 
			 stmt.execute();
			 stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
			throw ex;
		} finally{
			try{
				if (connection!=null) connection.close();
			} catch (Exception ex){}
		}
	}
	
	public void updateTrunkFlag(String urNo, String type) throws Exception {
		Connection connection = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			connection = session.connection();
			 
			 String procedureName = "{call UPDATE_TRUNK_FLAG(?, ? )}";
			 CallableStatement stmt = connection.prepareCall(procedureName);
			 //set PL parameter &amp; value
			 stmt.setString(1,urNo);
			 stmt.setString(2,type);
			 
			 stmt.execute();
			 stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
			throw ex;
		} finally{
			try{
				if (connection!=null) connection.close();
			} catch (Exception ex){}
		}
	}
}