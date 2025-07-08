 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IIPRangeDao;
import th.co.ais.ipfm.domain.IPRange;

public class HibernateIPRangeDao extends HibernateGenericDao<IPRange> implements IIPRangeDao {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<String> getIPVersionListByTier1TeamID(String tier1TeamID) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIPVersionListByTier1TeamID
		Session session = getSessionFactory().getCurrentSession();
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier44
DMAP ConvertedQuery - SELECT DISTINCT IP_VERSION FROM IP_RANGE WHERE TIER1_TEAM_ID='tier1TeamID' ORDER BY IP_VERSION
**/

		List<String> ipVersionList = session.createSQLQuery("SELECT DISTINCT IP_VERSION FROM IP_RANGE WHERE TIER1_TEAM_ID='"+tier1TeamID+"' ORDER BY IP_VERSION")
		.addScalar("IP_VERSION", Hibernate.STRING).list();
		return ipVersionList;
	}

	@Override
	public int countSearch(IPRange ipRange) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference countSearch
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPRange> search(IPRange ipRange, int maxResult) // DMAP Comment : Dead Code Detected - The Following Method has no reference search
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		
		List<IPRange> ipRangeList = new ArrayList<IPRange>();
		IPRange ir = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" RANG_ID, GROUP_ID, IP_VERSION, ");
		sql.append(" RANG_ID, GROUP_ID, IP_VERSION, ");
		sql.append(" IP_CLASS, RANG_IP_ST, RANG_IP_ED, ");
		sql.append(" ST_IP_1, ST_IP_2, ST_IP_3, ");
		sql.append(" ST_IP_4, ST_IP_5, ST_IP_6, ");
		sql.append(" ED_IP_1, ED_IP_2, ED_IP_3, ");
		sql.append(" ED_IP_4, ED_IP_5, ED_IP_6, ");
		sql.append(" RANG_DESC, ACTIVE_STATUS, COMPANY_ID, ");
		sql.append(" COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, ");
		sql.append(" TOTAL_USED, TOTAL_RESERVED, TIER2_ID, ");
		sql.append(" TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, ");
		sql.append(" DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, ");
		sql.append(" LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, ");
		sql.append(" NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, ");
		sql.append(" UR_REFER, NETWORK, GATEWAY, ");
		sql.append(" IP_TYPE, VIP, CREATE_BY, ");
		sql.append(" ROW_ID, VERSION, NETWORK_TYPE_ID ");
		sql.append(" FROM IP_RANGE ");
		sql.append(" WHERE ACTIVE_STATUS='1' ");
		
		if(!"".equals(ipRange.getIpVersion())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier43
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND IP_VERSION = ipRange.getIpVersion() 
**/

/**
**/

			sql.append(" AND IP_VERSION = "+ipRange.getIpVersion()+" ");
		}
		if(ipRange.getIpClass()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier42
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND IP_CLASS = ipRange.getIpClass() 
**/

			sql.append(" AND IP_CLASS = "+ipRange.getIpClass()+" ");
		}
		if(ipRange.getCompanyId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier41
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND COMPANY_ID = ipRange.getCompanyId() 
**/

			sql.append(" AND COMPANY_ID = "+ipRange.getCompanyId()+" ");
		}
		if(!"".equals(ipRange.getGrpId())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier40
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND GROUP_ID = ipRange.getGrpId() 
**/

			sql.append(" AND GROUP_ID = "+ipRange.getGrpId()+" ");
		}
		if("6".equals(ipRange.getIpVersion())){
			
			if(!"".equals(ipRange.getStIp1())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier39
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_1=ipRange.getStIp1() AND ED_IP_1=ipRange.getStIp1()) 
**/

				sql.append(" AND (ST_IP_1="+ipRange.getStIp1()+" AND ED_IP_1="+ipRange.getStIp1()+") ");
			}
			if(!"".equals(ipRange.getStIp2())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier38
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_2=ipRange.getStIp2() AND ED_IP_2=ipRange.getStIp2()) 
**/

				sql.append(" AND (ST_IP_2="+ipRange.getStIp2()+" AND ED_IP_2="+ipRange.getStIp2()+") ");
			}
			if(!"".equals(ipRange.getStIp3())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier37
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_3=ipRange.getStIp3() AND ED_IP_3=ipRange.getStIp3()) 
**/

				sql.append(" AND (ST_IP_3="+ipRange.getStIp3()+" AND ED_IP_3="+ipRange.getStIp3()+") ");
			}
			if(!"".equals(ipRange.getStIp4())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier36
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_4=ipRange.getStIp4() AND ED_IP_4=ipRange.getStIp4()) 
**/

				sql.append(" AND (ST_IP_4="+ipRange.getStIp4()+" AND ED_IP_4="+ipRange.getStIp4()+") ");
			}
			if(!"".equals(ipRange.getStIp5())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier35
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_5=ipRange.getStIp5() AND ED_IP_5=ipRange.getStIp5()) 
**/

				sql.append(" AND (ST_IP_5="+ipRange.getStIp5()+" AND ED_IP_5="+ipRange.getStIp5()+") ");
			}
			if(!"".equals(ipRange.getStIp6())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier34
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_6=ipRange.getStIp6()) 
**/

				sql.append(" AND (ST_IP_6="+ipRange.getStIp6()+") ");
			}
			if(!"".equals(ipRange.getStIp1())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier33
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ED_IP_6=ipRange.getStIp1()) 
**/

				sql.append(" AND (ED_IP_6="+ipRange.getStIp1()+") ");
			}
			
		}else if("4".equals(ipRange.getIpVersion())){
			
			if(!"".equals(ipRange.getStIp1())){
				sql.append(" AND (ST_IP_1="+ipRange.getStIp1()+" AND ED_IP_1="+ipRange.getStIp1()+") ");
			}
			if(!"".equals(ipRange.getStIp2())){
				sql.append(" AND (ST_IP_2="+ipRange.getStIp2()+" AND ED_IP_2="+ipRange.getStIp2()+") ");
			}
			if(!"".equals(ipRange.getStIp3())){
				sql.append(" AND (ST_IP_3="+ipRange.getStIp3()+" AND ED_IP_3="+ipRange.getStIp3()+") ");
			}
			if(!"".equals(ipRange.getStIp4())){
				sql.append(" AND (ST_IP_4="+ipRange.getStIp4()+") ");
			}
			if(!"".equals(ipRange.getStIp1())){
				sql.append(" AND (ED_IP_4="+ipRange.getStIp1()+") ");
			}	
		}
		  
		   if(ipRange.getTier2TeamId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier32
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND TIER2_TEAM_ID = ipRange.getGrpId() 
**/

			   sql.append(" AND TIER2_TEAM_ID = "+ipRange.getGrpId()+" ");
		   }
		   if(!"".equals(ipRange.getLocationId())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier31
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND LOCATION_ID = ipRange.getLocationId() 
**/

			   sql.append(" AND LOCATION_ID = "+ipRange.getLocationId()+" "); 
		   }
		   if(ipRange.getEffDate()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier30
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND EFFECTIVE_DATE>=ipRange.getEffDate() 
**/

			   sql.append(" AND EFFECTIVE_DATE>="+ipRange.getEffDate()+" "); 
		   }
		   if(ipRange.getExpDate()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier29
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND EXPIRED_DATE>=ipRange.getExpDate() 
**/

			   sql.append(" AND EXPIRED_DATE>="+ipRange.getExpDate()+" "); 
		   }
		   if(ipRange.getNetworkTypeId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier28
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND NETWORK_TYPE_ID=ipRange.getNetworkTypeId() 
**/

			   sql.append(" AND NETWORK_TYPE_ID="+ipRange.getNetworkTypeId()+" "); 
		   }
		   if(ipRange.getNetworkZoneId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier27
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND NETWORK_ZONE_ID==ipRange.getNetworkZoneId() 
**/

			   sql.append(" AND NETWORK_ZONE_ID=="+ipRange.getNetworkZoneId()+" "); 
		   }
		   if(!"".equals(ipRange.getUrRefer())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier26
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND UR_REFER=ipRange.getUrRefer() 
**/

			   sql.append(" AND UR_REFER="+ipRange.getUrRefer()+" "); 
		   }
		   
		   List lst  = session.createSQLQuery(sql.toString())
		   		.addScalar("ROW_ID", Hibernate.STRING)
				.addScalar("RANG_ID", Hibernate.STRING)
				.addScalar("GROUP_ID", Hibernate.STRING)
				.addScalar("IP_VERSION", Hibernate.STRING)
				.addScalar("IP_CLASS", Hibernate.STRING)
				.addScalar("RANG_IP_ST", Hibernate.STRING)
				.addScalar("RANG_IP_ED", Hibernate.STRING)
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
				.addScalar("RANG_DESC", Hibernate.STRING)
				.addScalar("ACTIVE_STATUS", Hibernate.STRING)
				.addScalar("COMPANY_ID", Hibernate.STRING)
				.addScalar("COMPANY_NAME", Hibernate.STRING)
				.addScalar("TOTAL_IP", Hibernate.INTEGER)
				.addScalar("TOTAL_ASSIGN_T3", Hibernate.INTEGER)
				.addScalar("TOTAL_USED", Hibernate.INTEGER)
				.addScalar("TOTAL_RESERVED", Hibernate.INTEGER)
				.addScalar("TIER2_ID", Hibernate.STRING)
				.addScalar("TIER1_TEAM_ID", Hibernate.STRING)
				.addScalar("VLAN_ID", Hibernate.STRING)
				.addScalar("DNS_NAME", Hibernate.STRING)
				.addScalar("EFFECTIVE_DATE", Hibernate.STRING)
				.addScalar("TIER2_TEAM_ID", Hibernate.STRING)
				.addScalar("LOCATION_ID", Hibernate.STRING)
				.addScalar("LOCATION_NAME", Hibernate.STRING)
				.addScalar("NETWORK_ZONE_ID", Hibernate.STRING)
				.addScalar("NETWORK_ZONE_NAME", Hibernate.STRING)
				.addScalar("NETWORK_TYPE_NAME", Hibernate.STRING)
				.addScalar("SUBMASK", Hibernate.STRING)
				.addScalar("UR_REFER", Hibernate.STRING)
				.addScalar("NETWORK", Hibernate.STRING)
			    .addScalar("GATEWAY", Hibernate.STRING)
			    .addScalar("IP_TYPE", Hibernate.STRING)
			    .addScalar("VIP", Hibernate.STRING)
			    .addScalar("CREATE_BY", Hibernate.STRING)
			    .addScalar("CREATE_DATE", Hibernate.DATE)
			    .addScalar("UPDATE_BY", Hibernate.STRING)
			    .addScalar("UPDATE_DATE", Hibernate.DATE)
			    .addScalar("VERSION", Hibernate.INTEGER)
			    .addScalar("NETWORK_TYPE_ID", Hibernate.STRING)
			    
				.list();
		   
			Iterator iter = lst.iterator();
		 	if (!iter.hasNext())
	        {
	            return ipRangeList;
	        }
	        while (iter.hasNext())
	        {
	            Object[] obj = (Object[]) iter.next();
	            
	            IPRange range = new IPRange();
	            range.setRowId((String) obj[0]);
	            range.setRngId((String) obj[1]); 
	            range.setGrpId((String) obj[2]); 
	            range.setIpVersion((String) obj[3]);
	            range.setIpClass((String) obj[4]);
	            range.setRngIpSt((String) obj[5]);
	            range.setRngIpEd((String) obj[6]);
	            range.setStIp1((String) obj[7]);
	            range.setStIp2((String) obj[8]);
	            range.setStIp3((String) obj[9]);
	            range.setStIp4((String) obj[10]);
	            range.setStIp5((String) obj[11]);
	            range.setStIp6((String) obj[12]);
	            range.setEdIp1((String) obj[13]);
	            range.setEdIp2((String) obj[14]);
	            range.setEdIp3((String) obj[15]);
	            range.setEdIp4((String) obj[16]);
	            range.setEdIp5((String) obj[17]);
	            range.setEdIp6((String) obj[18]);
	            range.setRangeDesc((String) obj[19]);
	            range.setActiveStatus((String) obj[20]);
	            range.setCompanyId((String) obj[21]);
	            range.setCompanyName((String) obj[22]);
	            range.setTotalIP((Integer) obj[23]);
	            range.setTotalAssignT3((Integer) obj[24]);
	            range.setTotalUsed((Integer) obj[25]);
	            range.setTotalReserved((Integer) obj[26]);
	            range.setTier2Id((String) obj[27]);
	            range.setTier1TeamId((String) obj[28]);
	            range.setvLanId((String) obj[29]);
	            range.setDnsName((String) obj[30]);
	            range.setEffDate((String) obj[31]);
	            range.setTier2TeamId((String) obj[32]);
	            range.setLocationId((String) obj[33]);
	            range.setLocationName((String) obj[34]);
	            range.setNetworkZoneId((String) obj[35]);
	            range.setNetworkZoneName((String) obj[36]);
	            range.setNetworkTypeName((String) obj[37]);
	            range.setSubMask((String) obj[38]);
	            range.setUrRefer((String) obj[39]);
	            range.setNetWork((String) obj[40]);
	            range.setGateWay((String) obj[41]);
	            range.setIpType((String) obj[42]);
	            range.setVip((String) obj[43]);
	            range.setCreatedBy((String) obj[44]);
	            range.setCreated((Date) obj[45]);
	            range.setLastUpdBy((String) obj[46]);
	            range.setLastUpd((Date) obj[47]);
	            range.setVersion((String) obj[48]);
	            range.setNetworkTypeId((String) obj[49]);
	            

				ipRangeList.add(range);
	        }
		
		return ipRangeList;
	}
	
	@Override
	public List<IPRange> search(IPRange ipRange) // DMAP Comment : Dead Code Detected - The Following Method has no reference search
			throws DataAccessException {
		
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sb = new StringBuffer();
		List<IPRange> ipRangeList = new ArrayList<IPRange>();
		IPRange ir = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" RANG_ID, GROUP_ID, IP_VERSION, ");
		sql.append(" RANG_ID, GROUP_ID, IP_VERSION, ");
		sql.append(" IP_CLASS, RANG_IP_ST, RANG_IP_ED, ");
		sql.append(" ST_IP_1, ST_IP_2, ST_IP_3, ");
		sql.append(" ST_IP_4, ST_IP_5, ST_IP_6, ");
		sql.append(" ED_IP_1, ED_IP_2, ED_IP_3, ");
		sql.append(" ED_IP_4, ED_IP_5, ED_IP_6, ");
		sql.append(" RANG_DESC, ACTIVE_STATUS, COMPANY_ID, ");
		sql.append(" COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, ");
		sql.append(" TOTAL_USED, TOTAL_RESERVED, TIER2_ID, ");
		sql.append(" TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, ");
		sql.append(" DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, ");
		sql.append(" LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, ");
		sql.append(" NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, ");
		sql.append(" UR_REFER, NETWORK, GATEWAY, ");
		sql.append(" IP_TYPE, VIP, CREATE_BY, ");
		sql.append(" ROW_ID, VERSION, NETWORK_TYPE_ID ");
		sql.append(" FROM IP_RANGE ");
		sql.append(" WHERE ACTIVE_STATUS='1' ");
		
		if(!"".equals(ipRange.getIpVersion())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier25
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND IP_VERSION = ipRange.getIpVersion() 
**/

/**
**/

			sql.append(" AND IP_VERSION = "+ipRange.getIpVersion()+" ");
		}
		if(ipRange.getIpClass()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier24
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND IP_CLASS = ipRange.getIpClass() 
**/

			sql.append(" AND IP_CLASS = "+ipRange.getIpClass()+" ");
		}
		if(ipRange.getCompanyId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier23
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND COMPANY_ID = ipRange.getCompanyId() 
**/

			sql.append(" AND COMPANY_ID = "+ipRange.getCompanyId()+" ");
		}
		if(!"".equals(ipRange.getGrpId())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier22
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND GROUP_ID = ipRange.getGrpId() 
**/

			sql.append(" AND GROUP_ID = "+ipRange.getGrpId()+" ");
		}
		if("6".equals(ipRange.getIpVersion())){
			
			if(!"".equals(ipRange.getStIp1())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier21
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_1=ipRange.getStIp1() AND ED_IP_1=ipRange.getStIp1()) 
**/

				sql.append(" AND (ST_IP_1="+ipRange.getStIp1()+" AND ED_IP_1="+ipRange.getStIp1()+") ");
			}
			if(!"".equals(ipRange.getStIp2())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier20
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_2=ipRange.getStIp2() AND ED_IP_2=ipRange.getStIp2()) 
**/

				sql.append(" AND (ST_IP_2="+ipRange.getStIp2()+" AND ED_IP_2="+ipRange.getStIp2()+") ");
			}
			if(!"".equals(ipRange.getStIp3())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier19
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_3=ipRange.getStIp3() AND ED_IP_3=ipRange.getStIp3()) 
**/

				sql.append(" AND (ST_IP_3="+ipRange.getStIp3()+" AND ED_IP_3="+ipRange.getStIp3()+") ");
			}
			if(!"".equals(ipRange.getStIp4())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier18
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_4=ipRange.getStIp4() AND ED_IP_4=ipRange.getStIp4()) 
**/

				sql.append(" AND (ST_IP_4="+ipRange.getStIp4()+" AND ED_IP_4="+ipRange.getStIp4()+") ");
			}
			if(!"".equals(ipRange.getStIp5())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier17
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_5=ipRange.getStIp5() AND ED_IP_5=ipRange.getStIp5()) 
**/

				sql.append(" AND (ST_IP_5="+ipRange.getStIp5()+" AND ED_IP_5="+ipRange.getStIp5()+") ");
			}
			if(!"".equals(ipRange.getStIp6())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier16
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ST_IP_6=ipRange.getStIp6()) 
**/

				sql.append(" AND (ST_IP_6="+ipRange.getStIp6()+") ");
			}
			if(!"".equals(ipRange.getStIp1())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier15
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND (ED_IP_6=ipRange.getStIp1()) 
**/

				sql.append(" AND (ED_IP_6="+ipRange.getStIp1()+") ");
			}
			
		}else if("4".equals(ipRange.getIpVersion())){
			
			if(!"".equals(ipRange.getStIp1())){
				sql.append(" AND (ST_IP_1="+ipRange.getStIp1()+" AND ED_IP_1="+ipRange.getStIp1()+") ");
			}
			if(!"".equals(ipRange.getStIp2())){
				sql.append(" AND (ST_IP_2="+ipRange.getStIp2()+" AND ED_IP_2="+ipRange.getStIp2()+") ");
			}
			if(!"".equals(ipRange.getStIp3())){
				sql.append(" AND (ST_IP_3="+ipRange.getStIp3()+" AND ED_IP_3="+ipRange.getStIp3()+") ");
			}
			if(!"".equals(ipRange.getStIp4())){
				sql.append(" AND (ST_IP_4="+ipRange.getStIp4()+") ");
			}
			if(!"".equals(ipRange.getStIp1())){
				sql.append(" AND (ED_IP_4="+ipRange.getStIp1()+") ");
			}	
		}
		  
		   if(ipRange.getTier2TeamId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier14
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND TIER2_TEAM_ID = ipRange.getGrpId() 
**/

			   sql.append(" AND TIER2_TEAM_ID = "+ipRange.getGrpId()+" ");
		   }
		   if(!"".equals(ipRange.getLocationId())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier13
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND LOCATION_ID = ipRange.getLocationId() 
**/

			   sql.append(" AND LOCATION_ID = "+ipRange.getLocationId()+" "); 
		   }
		   if(ipRange.getEffDate()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier12
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND EFFECTIVE_DATE>=ipRange.getEffDate() 
**/

			   sql.append(" AND EFFECTIVE_DATE>="+ipRange.getEffDate()+" "); 
		   }
		   if(ipRange.getExpDate()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier11
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND EXPIRED_DATE>=ipRange.getExpDate() 
**/

			   sql.append(" AND EXPIRED_DATE>="+ipRange.getExpDate()+" "); 
		   }
		   if(ipRange.getNetworkTypeId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier10
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND NETWORK_TYPE_ID=ipRange.getNetworkTypeId() 
**/

			   sql.append(" AND NETWORK_TYPE_ID="+ipRange.getNetworkTypeId()+" "); 
		   }
		   if(ipRange.getNetworkZoneId()!=null){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier9
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND NETWORK_ZONE_ID==ipRange.getNetworkZoneId() 
**/

			   sql.append(" AND NETWORK_ZONE_ID=="+ipRange.getNetworkZoneId()+" "); 
		   }
		   if(!"".equals(ipRange.getUrRefer())){
/**
DMAP TAG: Query converted Needs Manual Intervention : Identifier8
DMAP ConvertedQuery - SELECT RANG_ID, GROUP_ID, IP_VERSION, RANG_ID, GROUP_ID, IP_VERSION, IP_CLASS, RANG_IP_ST, RANG_IP_ED, ST_IP_1, ST_IP_2, ST_IP_3, ST_IP_4, ST_IP_5, ST_IP_6, ED_IP_1, ED_IP_2, ED_IP_3, ED_IP_4, ED_IP_5, ED_IP_6, RANG_DESC, ACTIVE_STATUS, COMPANY_ID, COMPANY_NAME, TOTAL_IP, TOTAL_ASSIGN_T3, TOTAL_USED, TOTAL_RESERVED, TIER2_ID, TIER1_TEAM_ID, TIER2_TEAM_ID, VLAN_ID, DNS_NAME, EFFECTIVE_DATE, EXPIRED_DATE, LOCATION_ID, LOCATION_NAME, NETWORK_ZONE_ID, NETWORK_ZONE_NAME, NETWORK_TYPE_NAME, SUBMASK, UR_REFER, NETWORK, GATEWAY, IP_TYPE, VIP, CREATE_BY, ROW_ID, VERSION, NETWORK_TYPE_ID FROM IP_RANGE WHERE ACTIVE_STATUS='1' AND UR_REFER=ipRange.getUrRefer() 
**/

			   sql.append(" AND UR_REFER="+ipRange.getUrRefer()+" "); 
		   }
		   
		   List lst  = session.createSQLQuery(sql.toString())
		   		.addScalar("ROW_ID", Hibernate.STRING)
				.addScalar("RANG_ID", Hibernate.STRING)
				.addScalar("GROUP_ID", Hibernate.STRING)
				.addScalar("IP_VERSION", Hibernate.STRING)
				.addScalar("IP_CLASS", Hibernate.STRING)
				.addScalar("RANG_IP_ST", Hibernate.STRING)
				.addScalar("RANG_IP_ED", Hibernate.STRING)
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
				.addScalar("RANG_DESC", Hibernate.STRING)
				.addScalar("ACTIVE_STATUS", Hibernate.STRING)
				.addScalar("COMPANY_ID", Hibernate.STRING)
				.addScalar("COMPANY_NAME", Hibernate.STRING)
				.addScalar("TOTAL_IP", Hibernate.INTEGER)
				.addScalar("TOTAL_ASSIGN_T3", Hibernate.INTEGER)
				.addScalar("TOTAL_USED", Hibernate.INTEGER)
				.addScalar("TOTAL_RESERVED", Hibernate.INTEGER)
				.addScalar("TIER2_ID", Hibernate.STRING)
				.addScalar("TIER1_TEAM_ID", Hibernate.STRING)
				.addScalar("VLAN_ID", Hibernate.STRING)
				.addScalar("DNS_NAME", Hibernate.STRING)
				.addScalar("EFFECTIVE_DATE", Hibernate.STRING)
				.addScalar("TIER2_TEAM_ID", Hibernate.STRING)
				.addScalar("LOCATION_ID", Hibernate.STRING)
				.addScalar("LOCATION_NAME", Hibernate.STRING)
				.addScalar("NETWORK_ZONE_ID", Hibernate.STRING)
				.addScalar("NETWORK_ZONE_NAME", Hibernate.STRING)
				.addScalar("NETWORK_TYPE_NAME", Hibernate.STRING)
				.addScalar("SUBMASK", Hibernate.STRING)
				.addScalar("UR_REFER", Hibernate.STRING)
				.addScalar("NETWORK", Hibernate.STRING)
			    .addScalar("GATEWAY", Hibernate.STRING)
			    .addScalar("IP_TYPE", Hibernate.STRING)
			    .addScalar("VIP", Hibernate.STRING)
			    .addScalar("CREATE_BY", Hibernate.STRING)
			    .addScalar("CREATE_DATE", Hibernate.DATE)
			    .addScalar("UPDATE_BY", Hibernate.STRING)
			    .addScalar("UPDATE_DATE", Hibernate.DATE)
			    .addScalar("VERSION", Hibernate.INTEGER)
			    .addScalar("NETWORK_TYPE_ID", Hibernate.STRING)
			    
				.list();
		   
			Iterator iter = lst.iterator();
		 	if (!iter.hasNext())
	        {
	            return ipRangeList;
	        }
	        while (iter.hasNext())
	        {
	            Object[] obj = (Object[]) iter.next();
	            
	            IPRange range = new IPRange();
	            range.setRowId((String) obj[0]);
	            range.setRngId((String) obj[1]); 
	            range.setGrpId((String) obj[2]); 
	            range.setIpVersion((String) obj[3]);
	            range.setIpClass((String) obj[4]);
	            range.setRngIpSt((String) obj[5]);
	            range.setRngIpEd((String) obj[6]);
	            range.setStIp1((String) obj[7]);
	            range.setStIp2((String) obj[8]);
	            range.setStIp3((String) obj[9]);
	            range.setStIp4((String) obj[10]);
	            range.setStIp5((String) obj[11]);
	            range.setStIp6((String) obj[12]);
	            range.setEdIp1((String) obj[13]);
	            range.setEdIp2((String) obj[14]);
	            range.setEdIp3((String) obj[15]);
	            range.setEdIp4((String) obj[16]);
	            range.setEdIp5((String) obj[17]);
	            range.setEdIp6((String) obj[18]);
	            range.setRangeDesc((String) obj[19]);
	            range.setActiveStatus((String) obj[20]);
	            range.setCompanyId((String) obj[21]);
	            range.setCompanyName((String) obj[22]);
	            range.setTotalIP((Integer) obj[23]);
	            range.setTotalAssignT3((Integer) obj[24]);
	            range.setTotalUsed((Integer) obj[25]);
	            range.setTotalReserved((Integer) obj[26]);
	            range.setTier2Id((String) obj[27]);
	            range.setTier1TeamId((String) obj[28]);
	            range.setvLanId((String) obj[29]);
	            range.setDnsName((String) obj[30]);
	            range.setEffDate((String) obj[31]);
	            range.setTier2TeamId((String) obj[32]);
	            range.setLocationId((String) obj[33]);
	            range.setLocationName((String) obj[34]);
	            range.setNetworkZoneId((String) obj[35]);
	            range.setNetworkZoneName((String) obj[36]);
	            range.setNetworkTypeName((String) obj[37]);
	            range.setSubMask((String) obj[38]);
	            range.setUrRefer((String) obj[39]);
	            range.setNetWork((String) obj[40]);
	            range.setGateWay((String) obj[41]);
	            range.setIpType((String) obj[42]);
	            range.setVip((String) obj[43]);
	            range.setCreatedBy((String) obj[44]);
	            range.setCreated((Date) obj[45]);
	            range.setLastUpdBy((String) obj[46]);
	            range.setLastUpd((Date) obj[47]);
	            range.setVersion((String) obj[48]);
	            range.setNetworkTypeId((String) obj[49]);
	            

				ipRangeList.add(range);
	        }
		
		return ipRangeList;
	}
	
	public List<Map> checkIPRange(String ipVersion, String mask, String effectiveDate, String expireDate) throws DataAccessException { // DMAP Comment : Dead Code Detected - The Following Method has no reference checkIPRange
		//Map key
		//1. result
		//2. errorMsg
		
		return null;
	}





}
