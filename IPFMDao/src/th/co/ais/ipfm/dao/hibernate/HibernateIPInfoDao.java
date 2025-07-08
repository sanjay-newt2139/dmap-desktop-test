package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPInfoDAO;
import th.co.ais.ipfm.domain.IPLevel3NatHistory;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUser;

public class HibernateIPInfoDao extends HibernateGenericDao<IpInfo> implements IIPInfoDAO{

	@SuppressWarnings("unchecked")
	@Override
	public IpInfo findIpInfo(String startIP){
		String [] listIP = startIP.split("\\.");
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);
		criteria.add(Restrictions.eq("ipv4digit1",new BigDecimal(listIP[0])));
		criteria.add(Restrictions.eq("ipv4digit2",new BigDecimal(listIP[1])));
		criteria.add(Restrictions.eq("ipv4digit3",new BigDecimal(listIP[2])));
		criteria.add(Restrictions.eq("ipv4digit4",new BigDecimal(listIP[3])));
		List result = criteria.list();
		return (result.size()==0)?null:(IpInfo)result.get(0);
	}
	
	@Override
	public IpInfo findIpInfoWithStatus(String startIP, String[] status){
		String [] listIP = startIP.split("\\.");
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);
		criteria.add(Restrictions.eq("ipv4digit1",new BigDecimal(listIP[0])));
		criteria.add(Restrictions.eq("ipv4digit2",new BigDecimal(listIP[1])));
		criteria.add(Restrictions.eq("ipv4digit3",new BigDecimal(listIP[2])));
		criteria.add(Restrictions.eq("ipv4digit4",new BigDecimal(listIP[3])));
		if(status != null && status.length > 0) {
			criteria.add(Restrictions.in("ipStatus", status));
		}
		List result = criteria.list();
		return (result.size()==0)?null:(IpInfo)result.get(0);
	}

	@Override
	public String getOwnerIP(String ip) {
		Session session = getSessionFactory().getCurrentSession();
		String teamId =  (String) session.createSQLQuery("SELECT DISTINCT T1_TEAM_ID AS TEAM_ID FROM IP_INFO WHERE IP_ADDRESS='"+ip+"'")
			.addScalar("TEAM_ID", Hibernate.STRING).uniqueResult();
		return teamId;
	}
	
	public int countSearchIP(IpInfo ipInfo,IpUser ipUser)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);

		criteria.setProjection(Projections.rowCount());
		return ((Integer)criteria.list().get(0)).intValue();
     }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IpInfo> searchIpInfo(String ipAddress, String tier2TeamId, String sysOwnerTeamId, String sysOwnerId,Integer maxSearchResult) throws DataAccessException {
		List<IpInfo> result = new ArrayList<IpInfo>();
		Session session = getSessionFactory().getCurrentSession();
		String ipAddressSql = "";
		String tier2TeamIdSql = "";
		String sysOwnerTeamIdSql = "";
		String sysOwnerIdSql = "";
		String openSql = "";
		String endSql = "";
		String andSql = " and ";
		String orSql = " or ";
		if (ipAddress!=null && ipAddress.trim().length()>0) {
			String[] ip = ipAddress.split("\\.");
			ipAddressSql =  " and t.ipv4digit1 = '"+ip[0]+"' " +
							" and t.ipv4digit2 = '"+ip[1]+"' " +
							" and t.ipv4digit3 = '"+ip[2]+"' ";
		}
		if (tier2TeamId!=null && tier2TeamId.trim().length()>0) {
			tier2TeamIdSql = " t.t2TeamId = '"+tier2TeamId+"' ";
		}
		if (sysOwnerTeamId!=null && sysOwnerTeamId.trim().length()>0) {
			if (tier2TeamId!=null && tier2TeamId.trim().length()>0)
				sysOwnerTeamIdSql = orSql + " t.systemOwnerTeamId = '"+sysOwnerTeamId+"' ";
			else
				sysOwnerTeamIdSql = " t.systemOwnerTeamId = '"+sysOwnerTeamId+"' ";
		}
		if (sysOwnerId!=null && sysOwnerId.trim().length()>0) {
			if ((tier2TeamId!=null && tier2TeamId.trim().length()>0) || 
				(sysOwnerTeamId!=null && sysOwnerTeamId.trim().length()>0)) 
				sysOwnerIdSql = orSql + " t.systemOwnerId = '"+sysOwnerId+"' ";
			else
				sysOwnerIdSql = " t.systemOwnerId = '"+sysOwnerId+"' ";
		}
		if ((tier2TeamId!=null && tier2TeamId.trim().length()>0) 
			|| (sysOwnerTeamId!=null && sysOwnerTeamId.trim().length()>0) 
			|| (sysOwnerId!=null && sysOwnerId.trim().length()>0)) {
			openSql = "and ( ";
			endSql = ") ";
		}

		String sql = "Select t from IpInfo t " +
				" left join fetch t.systemOwnerId " +
				" left join fetch t.ipLevel2 " +
				" left join fetch t.t2Team " +
				" where t.rowId is not null " +				
				ipAddressSql + 
				openSql +
				tier2TeamIdSql + sysOwnerTeamIdSql + sysOwnerIdSql +
				endSql +
				" order by t.ipv4digit1, t.ipv4digit2, t.ipv4digit3, t.ipv4digit4";
		
		if (maxSearchResult==null) {
			result = session.createQuery(sql).list();
		}else{
			result = session.createQuery(sql).setMaxResults(maxSearchResult).list();
		}
		Hibernate.initialize(result);
//		System.out.println("searchIpInfo result size = " + result.size());
		return result;
	}
	
	private String getSearchIPSql(IpInfo ipInfo, IpUser ipUser){
		StringBuffer sql = new StringBuffer(); 
		sql.append(" SELECT ");
		sql.append(" A.IP_ADDRESS,A.HOST_NAME,A.IP_STATUS,A.SYSTEM_NAME,A.COMPANY_NAME,A.DNS_NAME,A.SYSTEM_OWNER_NAME ");
		sql.append(" ,A.NETWORK_TYPE_NAME,A.SYSTEM_OWNER_TEAM_NAME ");
		sql.append(" ,A.NETWORK_ZONE_NAME,A.T2_TEAM_ID,A.NETWORK_IP,A.UR_REFER,A.GATEWAY,A.SUBMASK ");
		sql.append(" ,A.EFFECTIVE_DATE,A.EXPIRED_DATE,A.MAC_ADDRESS,A.PROJECT_ID,A.PROJECT_NAME,A.PROJECT_MANAGER,A.IP_TYPE_NAME,A.LOCATION_NAME ");
		sql.append(" ,A.VLAN_ID,A.VIP,A.WY_NODE_NAME,A.INSTALL_TYPE_NAME,A.T3_REMARK,A.IP_SUBMASK ");
		sql.append(" ,A.NAT_IP");
		sql.append(" FROM IP_INFO A ");
		sql.append(" WHERE 1 = 1 ");
		if("T3".equals(ipInfo.getUserPermission())){
			sql.append(" AND ( ");
			sql.append(" A.SYSTEM_OWNER_ID ='"+ipUser.getUserId()+"'");
			sql.append(" OR A.SYSTEM_OWNER_TEAM_ID ='"+ipUser.getTeamId()+"') ");
		}else if(!"T1".equals(ipInfo.getUserPermission())){
			sql.append(" AND (A.T2_TEAM_ID ='"+ipInfo.getUserPermission()+"' OR A.SYSTEM_OWNER_TEAM_ID = '"+ipInfo.getUserPermission()+"' OR A.SYSTEM_OWNER_ID ='"+ipUser.getUserId()+"') ");
		}
		
		if(!"ALL".equals(ipInfo.getBinaryIpStart())){
			sql.append(" AND (A.BINARY_IP BETWEEN '"+ipInfo.getBinaryIpStart()+"' AND '"+ipInfo.getBinaryIpEnd()+"') ");
		}
		if(!"".equals(ipInfo.getLocationId()) && ipInfo.getLocationId()!=null){
			sql.append(" AND A.LOCATION_ID ='"+ipInfo.getLocationId()+"'");
		}
		if(!"".equals(ipInfo.getHostName()) && ipInfo.getHostName()!=null){
			sql.append(" AND UPPER(A.HOST_NAME) LIKE  '%"+ipInfo.getHostName().toUpperCase().trim()+"%' ");
		}
		if(!"".equals(ipInfo.getSystemName()) && ipInfo.getSystemName()!=null){
			sql.append(" AND UPPER(A.SYSTEM_NAME) LIKE  '%"+ipInfo.getSystemName().toUpperCase().trim()+"%' ");
		}
		if(!"".equals(ipInfo.getVlanId()) && ipInfo.getVlanId()!=null){
			sql.append(" AND A.VLAN_ID  = '"+ipInfo.getVlanId()+"' ");
		}
		if(!"".equals(ipInfo.getProjectId()) && ipInfo.getProjectId()!=null){
			sql.append(" AND UPPER(A.PROJECT_ID) LIKE '%"+ipInfo.getProjectId().toUpperCase().trim()+"%' ");
		}
		if(!"".equals(ipInfo.getProjectName()) && ipInfo.getProjectName()!=null){
			sql.append(" AND UPPER(A.PROJECT_NAME) LIKE '%"+ipInfo.getProjectName().toUpperCase().trim()+"%' ");
		}
		if(!"".equals(ipInfo.getWyNodeName()) && ipInfo.getWyNodeName()!=null){
			sql.append(" AND UPPER(A.WY_NODE_NAME) LIKE '%"+ipInfo.getWyNodeName().toUpperCase().trim()+"%' ");
		}
		
		if(!"".equals(ipInfo.getNatIp()) && ipInfo.getNatIp()!=null){
			sql.append(" AND UPPER(A.NAT_IP) LIKE '%"+ipInfo.getNatIp().toUpperCase().trim()+"%' ");
		}
	        sql.append(" ORDER BY A.BINARY_IP ");
	        
	    return sql.toString();
	}
	
	@Override
	public Integer searchIPTotalRec(IpInfo ipInfo, IpUser ipUser) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
		String sql = getSearchIPSql(ipInfo,ipUser);
		sql = "SELECT COUNT(1) TOTALRECORD FROM ( "+sql+" ) A ";
		BigDecimal result = (BigDecimal)session.createSQLQuery(sql).addScalar("TOTALRECORD", Hibernate.BIG_DECIMAL).uniqueResult();
		if (result == null) return 0;
		return result.intValue();
			
	}
	@Override
	public List<IpInfo> searchIP(IpInfo ipInfo, IpUser ipUser) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
			String sql = getSearchIPSql(ipInfo,ipUser);
			sql = "SELECT * FROM ("+sql+") A WHERE ROWNUM <=1024 ";
			List dataList =  session.createSQLQuery(sql).list();
			Iterator iter = dataList.iterator();
			IpInfo objIpInfo;
			while(iter.hasNext()) {
				Object[] obj = (Object[])iter.next();
				objIpInfo = new IpInfo();
				objIpInfo.setIpAddress((String)obj[0]);
				objIpInfo.setHostName((String)obj[1]);
				objIpInfo.setIpStatus((String)obj[2]);
				objIpInfo.setSystemName((String)obj[3]);
				objIpInfo.setCompanyName((String)obj[4]);
				objIpInfo.setDnsName((String)obj[5]);
				objIpInfo.setSystemOwnerName((String)obj[6]);
				objIpInfo.setNetworkTypeName((String)obj[7]);
				objIpInfo.setSystemOwnerTeamName((String)obj[8]);
				objIpInfo.setNetworkZoneName((String)obj[9]);
				objIpInfo.setT2TeamId((String)obj[10]);
				objIpInfo.setNetworkIp((String)obj[11]);
				objIpInfo.setUrRefer((String)obj[12]);
				objIpInfo.setGateway((String)obj[13]);
				objIpInfo.setSubmask((String)obj[14]);
				objIpInfo.setEffectiveDate((Date)obj[15]);
				objIpInfo.setExpiredDate((Date)obj[16]);
				objIpInfo.setMacAddress((String)obj[17]);
				objIpInfo.setProjectId((String)obj[18]);
				objIpInfo.setProjectName((String)obj[19]);
				objIpInfo.setProjectManager((String)obj[20]);
				objIpInfo.setIpTypeName((String)obj[21]);
				objIpInfo.setLocationName((String)obj[22]);
				objIpInfo.setVlanId((String)obj[23]);
				objIpInfo.setVip((String)obj[24]);
				objIpInfo.setWyNodeName((String)obj[25]);
				objIpInfo.setInstallTypeName((String)obj[26]);
				objIpInfo.setT3Remark((String)obj[27]);
				objIpInfo.setIpSubmask((String)obj[28]);
				objIpInfo.setNatIp((String)obj[29]);
				ipInfoList.add(objIpInfo);
			}

		return ipInfoList;
	}

	@Override
	public IpInfo getIpInfo(String ipAddress) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);
		criteria.setFetchMode("systemOwnerId", FetchMode.JOIN);
		criteria.createAlias("systemOwnerId","systemOwnerId",Criteria.LEFT_JOIN); 
		criteria.setFetchMode("ipLevel2", FetchMode.JOIN); 
		criteria.setFetchMode("t2Team", FetchMode.JOIN);
		criteria.createAlias("t2Team","t2Team",Criteria.LEFT_JOIN); 
		criteria.add(Restrictions.eq("ipAddress", ipAddress));
					
		return (IpInfo)criteria.uniqueResult();
	}

	@Override
	public IpUser getIpTeamOwner(String teamID) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUser.class);
		criteria.add(Restrictions.eq("teamId", teamID));
		criteria.addOrder(Order.asc("userId"));
		return (IpUser)criteria.uniqueResult();
	}
	
	
	@Override
	public IpInfo checkIPRange23SearchL1(IpInfo ipInfo) throws Exception {	 
		 Connection connection = null;
		 CallableStatement stmt = null;
		 try{
			 connection = getSessionFactory().getCurrentSession().connection();
			String plName = "{call CHECK_RANGE_IP23_SearchL1(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			stmt = connection.prepareCall(plName);
			//Set output data type
			//set PL parameter &amp; value
			stmt.setString(1,ipInfo.getIpAddress()+"/"+ipInfo.getSubmask());
			stmt.setString(2, ipInfo.getT2TeamId());
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
			stmt.registerOutParameter(13, OracleTypes.INTEGER);
			stmt.registerOutParameter(14, OracleTypes.VARCHAR);
			stmt.execute();
			ipInfo.setBinaryIpStart(stmt.getString(5));
			ipInfo.setBinaryIpEnd(stmt.getString(6));
			ipInfo.setTotalIP(stmt.getInt(7));
			ipInfo.setLevel1Id(stmt.getString(8));
			ipInfo.setAvailableIP(stmt.getInt(13));	
			ipInfo.setResult(stmt.getString(12));	 
			ipInfo.setIpSubmask(stmt.getString(14));
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
	  	return ipInfo;
	}

	@Override
	public IpInfo findIpInfo(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4) throws Exception {

		Session session = getSessionFactory().getCurrentSession();
		IpInfo result;
		StringBuffer sql = new StringBuffer();
		sql.append("select t from IpInfo t " +
				" where t.ipv4digit1 = '"+ipDigit1+"' " +
				" and t.ipv4digit2 = '"+ipDigit2+"' " +
				" and t.ipv4digit3 = '"+ipDigit3+"' " +
				" and t.ipv4digit4 = '"+ipDigit4+"' ");
		result = (IpInfo) session.createQuery(sql.toString()).uniqueResult();
		Hibernate.initialize(result);
		
		return result;
	}

	@Override
	public BigDecimal checkIpInfoTotalAvailable(IpInfo ipInfo) throws Exception {

		Session session = getSessionFactory().getCurrentSession();
		BigDecimal result;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) as totalNotAvailable from IP_INFO t " +
				" where '"+ipInfo.getBinaryIpStart()+"' <= t.BINARY_IP " +
				" and '"+ipInfo.getBinaryIpEnd()+"' >= t.BINARY_IP " +
				" and t.IP_STATUS in ('T','A','R','U') ");
		result = (BigDecimal) session.createSQLQuery(sql.toString()).addScalar("totalNotAvailable", Hibernate.BIG_DECIMAL).uniqueResult();
		Hibernate.initialize(result);
		if (result==null) result = new BigDecimal(0);
		return result;
	}
	
	public List<IpInfo> findIpInfoAssignIp(String binary2Start,String binary2End) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from IP_INFO t " +
				" where '"+binary2Start+"' <= t.BINARY_IP " +
				" and '"+binary2End+"' >= t.BINARY_IP order by t.BINARY_IP " );
		List<IpInfo> result = session.createSQLQuery(sql.toString()).addEntity(IpInfo.class).list();
		Hibernate.initialize(result);
		return result;
	}

	@Override
	public void deleteIpLevel3ByLv2(String level2Id) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("delete IP_INFO where LEVEL2_ID = ? " );
		int result = session.createSQLQuery(sql.toString()).setString(0, level2Id).executeUpdate();		
	}

	@Override
	public String validateOverExpire(String level2Id, String expiredDate) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
//		sql.append("select distinct 'Y' as overExpired from IP_INFO where LEVEL2_ID = '"+level2Id+"' and to_char(EXPIRED_DATE,'yyyymmdd') > " + "'"+expiredDate+"'");
		sql.append("select distinct 'Y' as overExpired from IP_LEVEL1 where LEVEL1_ID = '"+level2Id+"' and EXPIRED_DATE < " + "to_date('"+expiredDate+"','yyyymmdd')");
		
		String overExpired = (String)session.createSQLQuery(sql.toString()).addScalar("overExpired", Hibernate.STRING).uniqueResult();		
		return overExpired;
	}

	@Override
	public void insertIpInfoHistoryByLevel1Id(String level1Id,Date updateDate, String updateBy) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		String sql = "insert into ip_info_history ( ip_address,ip_version, "+
					"submask, ipv4digit1, ipv4digit2,ipv4digit3, ipv4digit4, ipv6digit1, ipv6digit2, "+
					"ipv6digit3, ipv6digit4,ipv6digit5, ipv6digit6, level1_id, level2_id, binary_ip, "+
					"ip_status, company_id, company_name, location_id, location_name, ip_type_id, "+
					"ip_type_name, vip, install_type_id, install_type_name, network_zone_id, network_zone_name, "+ 
					"ip_submask, network_ip, gateway, mac_address, host_name, system_name, network_type_id, "+
					"network_type_name, wy_node_name, vlan_id, dns_name, t1_team_id, t1_team_name,t1_remark, "+
					"t2_remark, t2_team_id, t2_team_name, ur_refer, project_id, project_name, project_manager, "+
					"effective_date, expired_date, system_owner_id, system_owner_name, system_owner_team_id, "+
					"system_owner_team_name, t3_remark, create_by, create_date, update_by, update_date, row_id, "+
					"version) "+
					"select ip_address, ip_version, submask, ipv4digit1, ipv4digit2, ipv4digit3, ipv4digit4, ipv6digit1, "+ 
					"ipv6digit2, ipv6digit3, ipv6digit4, ipv6digit5, ipv6digit6, level1_id, level2_id, binary_ip, "+
					"ip_status, company_id, company_name, location_id, location_name, ip_type_id, ip_type_name, "+
					"vip, install_type_id, install_type_name, network_zone_id, network_zone_name, ip_submask, "+
					"network_ip, gateway, mac_address, host_name, system_name, network_type_id, network_type_name, "+ 
					"wy_node_name, vlan_id, dns_name, t1_team_id, t1_team_name,t1_remark, t2_remark, t2_team_id, "+ 
					"t2_team_name, ur_refer, project_id, project_name, project_manager, effective_date, expired_date, "+ 
					"system_owner_id, system_owner_name, system_owner_team_id, system_owner_team_name, t3_remark, "+ 
					"create_by, create_date, ? , ? , row_id, version from ip_info where level1_id = ? ";
			int rows = session.createSQLQuery(sql).setString(0, updateBy).setTimestamp(1, updateDate).setString(2, level1Id).executeUpdate();
		
	}

	@Override
	public void deleteIpLevel3ByLevel1Id(String level1Id) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("delete IP_INFO where LEVEL1_ID = ? " );
		int result = session.createSQLQuery(sql.toString()).setString(0, level1Id).executeUpdate();
	}

	@Override
	public void insertIpInfoHistoryByLevel2Id(String level2Id,Date updateDate, String updateBy) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		String sql = "insert into ip_info_history ( ip_address,ip_version, "+
		"submask, ipv4digit1, ipv4digit2,ipv4digit3, ipv4digit4, ipv6digit1, ipv6digit2, "+
		"ipv6digit3, ipv6digit4,ipv6digit5, ipv6digit6, level1_id, level2_id, binary_ip, "+
		"ip_status, company_id, company_name, location_id, location_name, ip_type_id, "+
		"ip_type_name, vip, install_type_id, install_type_name, network_zone_id, network_zone_name, "+ 
		"ip_submask, network_ip, gateway, mac_address, host_name, system_name, network_type_id, "+
		"network_type_name, wy_node_name, vlan_id, dns_name, t1_team_id, t1_team_name,t1_remark, "+
		"t2_remark, t2_team_id, t2_team_name, ur_refer, project_id, project_name, project_manager, "+
		"effective_date, expired_date, system_owner_id, system_owner_name, system_owner_team_id, "+
		"system_owner_team_name, t3_remark, create_by, create_date, update_by, update_date, row_id, "+
		"version) "+
		"select ip_address, ip_version, submask, ipv4digit1, ipv4digit2, ipv4digit3, ipv4digit4, ipv6digit1, "+ 
		"ipv6digit2, ipv6digit3, ipv6digit4, ipv6digit5, ipv6digit6, level1_id, level2_id, binary_ip, "+
		"ip_status, company_id, company_name, location_id, location_name, ip_type_id, ip_type_name, "+
		"vip, install_type_id, install_type_name, network_zone_id, network_zone_name, ip_submask, "+
		"network_ip, gateway, mac_address, host_name, system_name, network_type_id, network_type_name, "+ 
		"wy_node_name, vlan_id, dns_name, t1_team_id, t1_team_name,t1_remark, t2_remark, t2_team_id, "+ 
		"t2_team_name, ur_refer, project_id, project_name, project_manager, effective_date, expired_date, "+ 
		"system_owner_id, system_owner_name, system_owner_team_id, system_owner_team_name, t3_remark, "+ 
		"create_by, create_date, ? , ? , row_id, version from ip_info where level2_id = ? ";
int rows = session.createSQLQuery(sql).setString(0, updateBy).setTimestamp(1, updateDate).setString(2, level2Id).executeUpdate();	
	}
	
	
	@Override
	public int findIpinfo(String ipStart,String ipEnd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(t1.ip_address) as result  from ip_info t1  where t1.BINARY_IP between '"+ipStart+"' AND '"+ipEnd+"' " );
		int result =  (Integer) session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return result;
	}
	
	@Override
	public int findIpinfoWithUsedStatus(String ipStart,String ipEnd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(t1.ip_address) as result  from ip_info t1  where t1.BINARY_IP between '"+ipStart+"' AND '"+ipEnd+"' AND  t1.ip_status = 'U' " );
		int result =  (Integer) session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return result;
	}
	
	@Override
	public int findTier2TeamID(String ipStart,String ipEnd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(distinct t1.T2_TEAM_ID)  as result   from ip_info t1 where t1.BINARY_IP between '"+ipStart+"' AND '"+ipEnd+"' " );
		int result = (Integer)session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return  result;
	}
	
	@Override
	public int findTier2TeamIDWithUsedStatus(String ipStart,String ipEnd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(distinct t1.T2_TEAM_ID)  as result   from ip_info t1 where t1.BINARY_IP between '"+ipStart+"' AND '"+ipEnd+"' AND t1.ip_status = 'U' " );
		int result = (Integer)session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return  result;
	}	
	
	@Override
	public int findSystemOwnerTeamID(String ipStart,String ipEnd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(distinct t1.SYSTEM_OWNER_ID||t1.SYSTEM_OWNER_TEAM_ID) as result   from ip_info t1 where t1.BINARY_IP between '"+ipStart+"' AND '"+ipEnd+"' " );
		int result = (Integer) session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return  result;
	}
	
	@Override
	public int findSystemOwnerTeamIDWithUsedStatus(String ipStart,String ipEnd) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(distinct t1.SYSTEM_OWNER_ID||t1.SYSTEM_OWNER_TEAM_ID) as result   from ip_info t1 where t1.BINARY_IP between '"+ipStart+"' AND '"+ipEnd+"' AND t1.ip_status = 'U' " );
		int result = (Integer) session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return  result;
	}
	
	
	@Override
	public int countIpInfoStatusNotUsed(String binaryIpStart, String binaryIpEnd)
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("select count(distinct t1.IP_STATUS) as result   from ip_info t1 where t1.BINARY_IP between '"+binaryIpStart+"' AND '"+binaryIpEnd+"' AND IP_STATUS != 'U' " );
		int result = (Integer) session.createSQLQuery(sql.toString()).addScalar("result", Hibernate.INTEGER).uniqueResult();
		return  result;
	}
	
	public List<IpInfo> findIpInfoStatusNotUsed(String binary2Start,String binary2End) throws DataAccessException{
		Session session = getSessionFactory().getCurrentSession();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from IP_INFO t " +
				" where '"+binary2Start+"' <= t.BINARY_IP " +
				" and '"+binary2End+"' >= t.BINARY_IP " +
				" and t.IP_STATUS != 'U' order by t.BINARY_IP ");
		List<IpInfo> result = session.createSQLQuery(sql.toString()).addEntity(IpInfo.class).list();
		Hibernate.initialize(result);
		return result;
	}

	@Override
	public List<IpInfo> findIpInfoByHostName(String hostName)
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);
		criteria.add(Restrictions.eq("hostName",hostName));
		List<IpInfo> result = criteria.list();
		return result;
	}

	@Override
	public IpInfo findIpInfoByWCHUNodeName(String watchingUNameName)
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpInfo.class);
		criteria.add(Restrictions.eq("wyNodeName",watchingUNameName));
		List result = criteria.list();
		return (result== null || result.size()==0)?null:(IpInfo)result.get(0);
	}
	
	@Override
	public List<IpInfo> findIpInfoByVlan(IpInfo ipInfo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select t.* from IP_INFO t " +
				" where t.vlan_id = '"+ipInfo.getVlanId()+"' " );
		List<IpInfo> result = session.createSQLQuery(sql.toString()).addEntity(IpInfo.class).list();
		Hibernate.initialize(result);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<String> getLv1TeamMemberByIP(String ip) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<String> result = new ArrayList<String>();
		String sql = "select b.user_id from ip_info a,ip_user b where a.t1_team_id = b.team_id and a.ip_address = '"+ip+"'";
		List dataList =  session.createSQLQuery(sql).list();
		Iterator iter = dataList.iterator();
		while(iter.hasNext()) {
			result.add(String.valueOf(iter.next()));
		}
		return result;
	
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<String> getLv2TeamMemberByIP(String ip) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		List<String> result = new ArrayList<String>();
		String sql = "select b.user_id from ip_info a,ip_user b where a.t2_team_id = b.team_id and a.ip_address = '"+ip+"'";
		List dataList =  session.createSQLQuery(sql).list();
		Iterator iter = dataList.iterator();
		while(iter.hasNext()) {
			result.add(String.valueOf(iter.next()));
		}
		return result;
	
	}

	@Override
	public void updateNatIP(String ip, String natIP) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();		
		StringBuffer sql = new StringBuffer();
		sql.append("update IP_INFO set NAT_IP = ? where ip_address = ? " );
		session.createSQLQuery(sql.toString()).setString(0, (natIP==null?"":(natIP.trim()))).setString(1, ip).executeUpdate();		
	}

	@Override
	public void insertNatHistory(List<IPLevel3NatHistory> natHisList) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();	
		String sql = "insert into IP_LEVEL3_NAT_HISTORY (ip_address,nat_ip,nat_ip_old,created_by,created_date) values (?,?,?,?,sysdate)";
		if(natHisList != null && natHisList.size() > 0){
			for(IPLevel3NatHistory bean : natHisList){
				session.createSQLQuery(sql).setString(0, bean.getIpAddress()).setString(1, bean.getNatIP()).setString(2, bean.getNatIPOld()).setString(3, bean.getCreatedBy()).executeUpdate();
			}			
		}		
	}
}
