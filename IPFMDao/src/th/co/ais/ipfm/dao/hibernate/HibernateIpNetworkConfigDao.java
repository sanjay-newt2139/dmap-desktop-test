 /* This application remediation was done for embedded Oracle SQL to make it compatible with PostgreSQL with Newt DMAP Version: v9.1.0.1_v8.4.2.9 on Date: 27-Jun-2025 */
package th.co.ais.ipfm.dao.hibernate;


import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpNetworkConfigDao;
import th.co.ais.ipfm.domain1.IpNetworkConfig;

public class HibernateIpNetworkConfigDao  extends HibernateGenericDao<IpNetworkConfig> implements IpNetworkConfigDao{

	@Override
	public void deleteNetWorkConfigByIpAddress(String ipAddress, String ipPort) // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteNetWorkConfigByIpAddress
			throws DataAccessException {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
String sql = "DELETE FROM IP_NETWORK_CONFIG WHERE (IP_ADDRESS = ?) and (VIP_PORT = ?) and sub_ur_no like 'F5%'";//String sql = "DELETE IP_NETWORK_CONFIG WHERE (IP_ADDRESS = ?) and (VIP_PORT = ?) and sub_ur_no like 'F5%'";
/**
DMAP TAG: Query converted: Identifier123
DMAP ConvertedQuery - DELETE FROM IP_NETWORK_CONFIG WHERE (IP_ADDRESS = ?) and (VIP_PORT = ?) and sub_ur_no like 'F5%'
**/

		session.createSQLQuery(sql)
			.setString(0,ipAddress)
			.setString(1,ipPort)
			.executeUpdate();
	}


}
