 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import oracle.jdbc.driver.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import th.co.ais.ipfm.domain1.IpUrIpResult;

public class PlanningDaoImpl implements PlanningPLDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSessionFactory
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void urIpTodoList(String urno,String urType, String action, String olaDate, String slaDate) throws Exception{ // DMAP Comment : Dead Code Detected - The Following Method has no reference urIpTodoList
		 Connection connection = null;
		 
			try{
				Session session = sessionFactory.getCurrentSession();
				connection = session.connection();
				 
String plName = "call Gen_UR_IP_To_Do_List(?,?,?,?,?)";//String plName = "{call Gen_UR_IP_To_Do_List(?,?,?,?,?)}";
/**
DMAP TAG: Query converted: Identifier337
DMAP ConvertedQuery - call Gen_UR_IP_To_Do_List(?,?,?,?,?)
**/

				 CallableStatement stmt = connection.prepareCall(plName);
				 //set PL parameter &amp; value
				 stmt.setString(1,urno);
				 stmt.setString(2,urType);
				 stmt.setString(3,action);
				 stmt.setString(4,olaDate);
				 stmt.setString(5,slaDate);
				 stmt.execute();
				 
				 stmt.close();
			} catch (Exception ex){
              /*try {
					//connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}*/
				ex.printStackTrace();
				throw ex;
			} finally{
				try{		
					connection.close();
				} catch (Exception ex){
					
				}
			}

	}
	@Override
	public String getUrStatusDesc(String urType,String urStatus) throws Exception{ // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusDesc
		 String statusName = "";
		 Connection connection = null;
		 try{
			 
			 Session session = sessionFactory.getCurrentSession();
			 connection = session.connection();
/**
DMAP TAG: Query converted: Identifier336
DMAP ConvertedQuery - call GET_UR_STATUS_DESC(?,?,?)
**/

//			 CallableStatement stmt = connection.prepareCall("{call GET_UR_STATUS_DESC(?,?,?)}");
			 CallableStatement stmt = connection.prepareCall("call GET_UR_STATUS_DESC(?,?,?)");
			 //set PL parameter &amp; value
			 stmt.setString(1,urType);
			 stmt.setString(2,urStatus);
			 stmt.registerOutParameter(3, OracleTypes.VARCHAR);
			 stmt.execute();
			 statusName = stmt.getString(3);
			 stmt.close();
		 } catch (Exception ex){
              /*try {
					//connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}*/
				ex.printStackTrace();
				throw ex;
		} finally{
			try{		
				connection.close();
			} catch (Exception ex){
				
			}
		}
		return statusName;
	}
	
	@Override
	public IpUrIpResult checkIPRange(String  IpDigit1,String IpDigit2,String IpDigit3,String IpDigit4,String mask) throws Exception{	  // DMAP Comment : Dead Code Detected - The Following Method has no reference checkIPRange
		 IpUrIpResult obj =null;
		 Connection connection = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			connection = session.connection();
String plName = "call check_ip_range(?,?,?,?,?,?,?,?,?,?,?)";//String plName = "{call check_ip_range(?,?,?,?,?,?,?,?,?,?,?)}";
/**
DMAP TAG: Query converted: Identifier335
DMAP ConvertedQuery - call check_ip_range(?,?,?,?,?,?,?,?,?,?,?)
**/

				 CallableStatement stmt = connection.prepareCall(plName);
				 //Set output data type
				 //set PL parameter &amp; value
				 stmt.setLong(1,Long.parseLong(IpDigit1));
				 stmt.setLong(2,Long.parseLong(IpDigit2));
				 stmt.setLong(3,Long.parseLong(IpDigit3));
				 stmt.setLong(4,Long.parseLong(IpDigit4));
				 if(mask!="" && mask!=null){
				  stmt.setLong(5,Long.parseLong(mask));
				 }else{
				  stmt.setLong(5,Long.parseLong("32")); 
				 }
				 
				 stmt.registerOutParameter(6, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(7, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(8, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(9, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(10, OracleTypes.INTEGER);
				 stmt.registerOutParameter(11, OracleTypes.VARCHAR);
				 stmt.executeUpdate();

					obj = new IpUrIpResult();
					obj.setLevel1Start(stmt.getString(6));
					obj.setLevel1End(stmt.getString(7));
					obj.setBinary1Start(stmt.getString(8));
					obj.setBinary1End(stmt.getString(9));
					obj.setTotalIp(stmt.getInt(10));
					obj.setResult(stmt.getString(11));

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
			
	  return obj;
	}

	@Override
	public String checkDuplicateIP(String binSt, String binEd, String option) throws Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference checkDuplicateIP
		String result = "";
		Connection connection = null;
		try{
			 
			 Session session = sessionFactory.getCurrentSession();
			 connection = session.connection();
/**
DMAP TAG: Query converted: Identifier334
DMAP ConvertedQuery - call CHECK_DUP_IP(?,?,?,?)
**/

//			 CallableStatement stmt = connection.prepareCall("{call CHECK_DUP_IP(?,?,?,?)}");
			 CallableStatement stmt = connection.prepareCall("call CHECK_DUP_IP(?,?,?,?)");
			 //set PL parameter &amp; value
			 stmt.setString(1,binSt);
			 stmt.setString(2,binEd);
			 stmt.setLong(3, Long.parseLong(option));
			 stmt.registerOutParameter(4, OracleTypes.VARCHAR);
			 stmt.execute();
			 result = stmt.getString(4);
			 stmt.close();
		 } catch (Exception ex){
             /*try {
					//connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}*/
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


}
