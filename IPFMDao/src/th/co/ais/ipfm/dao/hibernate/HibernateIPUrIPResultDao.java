package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrIPResultDao;
import th.co.ais.ipfm.domain1.IpUrIpResult;



public class HibernateIPUrIPResultDao extends HibernateGenericDao<IpUrIpResult> implements IPUrIPResultDao{

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String reCheck_ip_range(IpUrIpResult ipUrIpResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String result =  (String) session.createSQLQuery("  SELECT DISTINCT 'X' AS chk  FROM IP_LEVEL1 A  WHERE A.BINARY1_START BETWEEN '"+ipUrIpResult.getBinary1Start()+"' AND '"+
				       ipUrIpResult.getBinary1End()+"' AND A.BINARY1_END BETWEEN '"+ipUrIpResult.getBinary1Start()+"' AND '"+ipUrIpResult.getBinary1End()+"'")
				.addScalar("chk", Hibernate.STRING).uniqueResult();
		return result;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String reCheck_ip_range23(IpUrIpResult ipUrIpResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		String result =  (String) session.createSQLQuery("  SELECT DISTINCT 'X' AS chk  FROM IP_LEVEL2 A  WHERE A.BINARY2_START BETWEEN '"+ipUrIpResult.getBinary2Start()+"' AND '"+
				       ipUrIpResult.getBinary2End()+"' AND A.BINARY2_END BETWEEN '"+ipUrIpResult.getBinary2Start()+"' AND '"+ipUrIpResult.getBinary2End()+"'")
				.addScalar("chk", Hibernate.STRING).uniqueResult();
		return result;
	}
	
	@Override
	public BigDecimal getSeqNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String seqNo =  (String) session.createSQLQuery("SELECT NVL(MAX(SEQ),0)+1 as NEWSEQ FROM IP_UR_IP_RESULT WHERE UR_NO='"+urNo+"'")
				.addScalar("NEWSEQ", Hibernate.STRING).uniqueResult();
		return new BigDecimal(seqNo);
	}
	
	@Override
	public IpUrIpResult addIpUrIpResult(IpUrIpResult ipUrIpResult) throws DataAccessException {
		
		try {
			insert(ipUrIpResult);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ipUrIpResult;
	}
	@Override
	public IpUrIpResult updateIpUrIpResult(IpUrIpResult ipUrIpResult) throws DataAccessException {
		
		try {
			update(ipUrIpResult);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ipUrIpResult;
	}


	@Override
	public IpUrIpResult getIpUrIpResult(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrIpResult.class);
		
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.add(Restrictions.eq("id.seq", new BigDecimal(1)));
		return (IpUrIpResult)criteria.uniqueResult();
	}
	
	
	@Override
	public IpUrIpResult checkIPRange(IpUrIpResult ipUrIpResult) throws DataAccessException {	 
		 IpUrIpResult obj =null;
		 Connection connection = null;
		 try{
			     connection = getSessionFactory().getCurrentSession().connection();
				 String plName = "{call check_ip_range(?,?,?,?,?,?,?,?,?,?,?)}";
				 CallableStatement stmt = connection.prepareCall(plName);
				 //Set output data type
				 //set PL parameter &amp; value
				 stmt.setLong(1,Long.parseLong(ipUrIpResult.getIpDigit1()));
				 stmt.setLong(2,Long.parseLong(ipUrIpResult.getIpDigit2()));
				 stmt.setLong(3,Long.parseLong(ipUrIpResult.getIpDigit3()));
				 stmt.setLong(4,Long.parseLong(ipUrIpResult.getIpDigit4()));
				 stmt.setLong(5,Long.parseLong(ipUrIpResult.getMask()));
				 
				 stmt.registerOutParameter(6, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(7, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(8, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(9, OracleTypes.VARCHAR);
				 stmt.registerOutParameter(10, OracleTypes.INTEGER);
				 stmt.registerOutParameter(11, OracleTypes.VARCHAR);
				 stmt.execute();

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
		} finally{
			try{		
				connection.close();
			} catch (Exception ex){
				
			}
		}
	  	return obj;
	}
	@Override
	public IpUrIpResult checkIPRange23(IpUrIpResult ipUrIpResult) throws Exception {	 
//		System.out.println("-- checkIPRange23 --");
		 Connection connection = null;
		 CallableStatement stmt = null;
		 try{
//			System.out.println(" ip = "+ ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+ipUrIpResult.getIpDigit4()+"/"+ipUrIpResult.getMask());
//			System.out.println(" ipUrIpResult.getVt2TeamId() = "+ ipUrIpResult.getVt2TeamId());
//			System.out.println(" result = "+ ipUrIpResult.getResult());
			connection = getSessionFactory().getCurrentSession().connection();
			String plName = "{call check_ip_range23(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			stmt = connection.prepareCall(plName);
			//Set output data type
			//set PL parameter &amp; value
			stmt.setLong(1,Long.parseLong(ipUrIpResult.getIpDigit1()));
			stmt.setLong(2,Long.parseLong(ipUrIpResult.getIpDigit2()));
			stmt.setLong(3,Long.parseLong(ipUrIpResult.getIpDigit3()));
			stmt.setLong(4,Long.parseLong(ipUrIpResult.getIpDigit4()));
			
			if (ipUrIpResult.getMask()!=null && ipUrIpResult.getMask().trim().length()>0) {
				stmt.setLong(5,Long.parseLong(ipUrIpResult.getMask()));
			}else{
				ipUrIpResult.setMask("32");
				stmt.setLong(5,Long.parseLong(ipUrIpResult.getMask()));
			}
			stmt.setString(6, ipUrIpResult.getVt2TeamId());
			stmt.registerOutParameter(7, OracleTypes.VARCHAR);
			stmt.registerOutParameter(8, OracleTypes.VARCHAR);
			stmt.registerOutParameter(9, OracleTypes.VARCHAR);
			stmt.registerOutParameter(10, OracleTypes.VARCHAR);
			stmt.registerOutParameter(11, OracleTypes.INTEGER);
			stmt.registerOutParameter(12, OracleTypes.VARCHAR);
			stmt.registerOutParameter(13, OracleTypes.VARCHAR);
			stmt.registerOutParameter(14, OracleTypes.VARCHAR);
			stmt.registerOutParameter(15, OracleTypes.VARCHAR);
			stmt.registerOutParameter(16, OracleTypes.VARCHAR);
			stmt.registerOutParameter(17, OracleTypes.VARCHAR);
			stmt.execute();

			ipUrIpResult.setLevel2Start(stmt.getString(7));
			ipUrIpResult.setLevel2End(stmt.getString(8));
			ipUrIpResult.setBinary2Start(stmt.getString(9));
			ipUrIpResult.setBinary2End(stmt.getString(10));
			ipUrIpResult.setTotalIp(stmt.getInt(11));
			ipUrIpResult.setLevel1Id(stmt.getString(12));
			ipUrIpResult.setVt1TeamId(stmt.getString(13));
			ipUrIpResult.setVt1TeamName(stmt.getString(14));	
			ipUrIpResult.setVt1Remarks(stmt.getString(15));	
			ipUrIpResult.setResult(stmt.getString(16));	
			ipUrIpResult.setVipSubmask(stmt.getString(17));
			
		} catch (Exception ex){
				ex.printStackTrace();
				throw ex;
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
	  	return ipUrIpResult;
	}
	@Override
	public IpUrIpResult checkIPRange23_2(IpUrIpResult ipUrIpResult) throws Exception {	 
		 Connection connection = null;
		 CallableStatement stmt = null;
		 try{
			connection = getSessionFactory().getCurrentSession().connection();
			String plName = "{call check_ip_range23_2(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			stmt = connection.prepareCall(plName);
			//Set output data type
			//set PL parameter &amp; value
//			stmt.setLong(1,Long.parseLong(ipUrIpResult.getIpVersion()));
			//stmt.setString(2,ipUrIpResult.getMask());
			String mask = "";
			if (ipUrIpResult.getMask()!=null && ipUrIpResult.getMask().trim().length()>0) {
				mask = "/"+ipUrIpResult.getMask();
			}
			stmt.setString(1,ipUrIpResult.getIpAddress()+mask);
			stmt.setString(2,ipUrIpResult.getVt2TeamId());
			stmt.registerOutParameter(3, OracleTypes.VARCHAR);
			stmt.registerOutParameter(4, OracleTypes.VARCHAR);
			stmt.registerOutParameter(5, OracleTypes.VARCHAR);
			stmt.registerOutParameter(6, OracleTypes.VARCHAR);
			stmt.registerOutParameter(7, OracleTypes.INTEGER);
			stmt.registerOutParameter(8, OracleTypes.VARCHAR);
			stmt.registerOutParameter(9, OracleTypes.VARCHAR);
			stmt.registerOutParameter(10, OracleTypes.VARCHAR);
			stmt.registerOutParameter(11, OracleTypes.VARCHAR);
			stmt.registerOutParameter(12, OracleTypes.VARCHAR);
			stmt.registerOutParameter(13, OracleTypes.VARCHAR);
			stmt.registerOutParameter(14, OracleTypes.INTEGER);
			stmt.execute();

			//obj = new IpUrIpResult();
			ipUrIpResult.setLevel2Start(stmt.getString(3));
			ipUrIpResult.setLevel2End(stmt.getString(4));
			ipUrIpResult.setBinary2Start(stmt.getString(5));
			ipUrIpResult.setBinary2End(stmt.getString(6));
			ipUrIpResult.setTotalIp(stmt.getInt(7));
			ipUrIpResult.setLevel1Id(stmt.getString(8));
			ipUrIpResult.setVt1TeamId(stmt.getString(9));
			ipUrIpResult.setVt1TeamName(stmt.getString(10));
			ipUrIpResult.setVt1Remarks(stmt.getString(11));
			ipUrIpResult.setResult(stmt.getString(12));		 
			ipUrIpResult.setVipSubmask(stmt.getString(13));
			ipUrIpResult.setVmask(stmt.getInt(14));
			ipUrIpResult.setMask(String.valueOf(stmt.getInt(14)));
		} catch (Exception ex){
				ex.printStackTrace();
				throw ex;
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
	  	return ipUrIpResult;
	}
	@Override
	public IpUrIpResult checkIPRange23_3(IpUrIpResult ipUrIpResult) throws Exception {	 
		 Connection connection = null;
		 CallableStatement stmt = null;
		 try{
			 connection = getSessionFactory().getCurrentSession().connection();
			String plName = "{call check_ip_range23_3(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			stmt = connection.prepareCall(plName);
			//Set output data type
			//set PL parameter &amp; value
			stmt.setLong(1,Long.parseLong(ipUrIpResult.getIpDigit1()));
			stmt.setLong(2,Long.parseLong(ipUrIpResult.getIpDigit2()));
			stmt.setLong(3,Long.parseLong(ipUrIpResult.getIpDigit3()));
			stmt.setLong(4,Long.parseLong(ipUrIpResult.getIpDigit4()));
			
			if (ipUrIpResult.getMask()!=null && ipUrIpResult.getMask().trim().length()>0) {
				stmt.setLong(5,Long.parseLong(ipUrIpResult.getMask()));
			}else{
				ipUrIpResult.setMask("32");
				stmt.setLong(5,Long.parseLong(ipUrIpResult.getMask()));
			}
			stmt.setString(6, ipUrIpResult.getVt2TeamId());
			stmt.registerOutParameter(7, OracleTypes.VARCHAR);
			stmt.registerOutParameter(8, OracleTypes.VARCHAR);
			stmt.registerOutParameter(9, OracleTypes.VARCHAR);
			stmt.registerOutParameter(10, OracleTypes.VARCHAR);
			stmt.registerOutParameter(11, OracleTypes.INTEGER);
			stmt.registerOutParameter(12, OracleTypes.VARCHAR);
			stmt.registerOutParameter(13, OracleTypes.VARCHAR);
			stmt.registerOutParameter(14, OracleTypes.VARCHAR);
			stmt.registerOutParameter(15, OracleTypes.VARCHAR);
			stmt.registerOutParameter(16, OracleTypes.VARCHAR);
			stmt.registerOutParameter(17, OracleTypes.VARCHAR);
			stmt.execute();

			ipUrIpResult.setLevel2Start(stmt.getString(7));
			ipUrIpResult.setLevel2End(stmt.getString(8));
			ipUrIpResult.setBinary2Start(stmt.getString(9));
			ipUrIpResult.setBinary2End(stmt.getString(10));
			ipUrIpResult.setTotalIp(stmt.getInt(11));
			ipUrIpResult.setLevel1Id(stmt.getString(12));
			ipUrIpResult.setVt1TeamId(stmt.getString(13));		 
			ipUrIpResult.setVt1TeamName(stmt.getString(14));
			ipUrIpResult.setVt1Remarks(stmt.getString(15));	
			ipUrIpResult.setResult(stmt.getString(16));	 
			ipUrIpResult.setVipSubmask(stmt.getString(17));	 
		} catch (Exception ex){
				ex.printStackTrace();
				throw ex;
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
	  	return ipUrIpResult;
	}

	@Override
	public List<IpUrIpResult> getIpUrIpResultList(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrIpResult.class);		
		criteria.add(Restrictions.eq("id.urNo", urNo));
		criteria.addOrder(Order.asc("id.seq"));
		return criteria.list();
	}
	
	@Override
	public IpUrIpResult getIpStartEnd3(String ip1, String ip2, String ip3, String ip4, String mark) throws Exception {
		 Connection connection = null;
		 CallableStatement stmt = null;
		 IpUrIpResult ipUrIpResult = new IpUrIpResult();
		 try{
			 connection = getSessionFactory().getCurrentSession().connection();
			String plName = "{call get_ip_start_end3(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			stmt = connection.prepareCall(plName);
			//Set output data type
			//set PL parameter &amp; value
			stmt.setLong(1,Long.parseLong(ip1));
			stmt.setLong(2,Long.parseLong(ip2));
			stmt.setLong(3,Long.parseLong(ip3));
			stmt.setLong(4,Long.parseLong(ip4));
			
			if (mark!=null && mark.length()>0) {
				stmt.setLong(5,Long.parseLong(mark));
			}else{
				mark = "32";
				stmt.setLong(5,Long.parseLong(mark));
			}
			stmt.registerOutParameter(6, OracleTypes.VARCHAR);
			stmt.registerOutParameter(7, OracleTypes.VARCHAR);
			stmt.registerOutParameter(8, OracleTypes.VARCHAR);
			stmt.registerOutParameter(9, OracleTypes.VARCHAR);
			stmt.registerOutParameter(10, OracleTypes.VARCHAR);
			stmt.registerOutParameter(11, OracleTypes.INTEGER);
			stmt.registerOutParameter(12, OracleTypes.VARCHAR);
			stmt.registerOutParameter(13, OracleTypes.VARCHAR);
			stmt.registerOutParameter(14, OracleTypes.VARCHAR);
			stmt.registerOutParameter(15, OracleTypes.VARCHAR);
			stmt.execute();

			ipUrIpResult.setLevel1Start(stmt.getString(6));	
			ipUrIpResult.setLevel1End(stmt.getString(7));
			ipUrIpResult.setBinary1Start(stmt.getString(8));
			ipUrIpResult.setBinary1End(stmt.getString(9));
			ipUrIpResult.setTotalIp(stmt.getInt(10));
			ipUrIpResult.setLevel2Start(stmt.getString(12));
			ipUrIpResult.setLevel2End(stmt.getString(13));		 
			ipUrIpResult.setBinary2Start(stmt.getString(14));
			ipUrIpResult.setBinary2End(stmt.getString(15));	
		} catch (Exception ex){
				ex.printStackTrace();
				throw ex;
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
	  	return ipUrIpResult;
		
	}
}
