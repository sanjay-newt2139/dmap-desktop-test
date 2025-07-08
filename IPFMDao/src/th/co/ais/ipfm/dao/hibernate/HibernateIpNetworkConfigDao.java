package th.co.ais.ipfm.dao.hibernate;


import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IpNetworkConfigDao;
import th.co.ais.ipfm.domain1.IpNetworkConfig;

public class HibernateIpNetworkConfigDao  extends HibernateGenericDao<IpNetworkConfig> implements IpNetworkConfigDao{

	@Override
	public void deleteNetWorkConfigByIpAddress(String ipAddress, String ipPort)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE IP_NETWORK_CONFIG WHERE (IP_ADDRESS = ?) and (VIP_PORT = ?) and sub_ur_no like 'F5%'";
		session.createSQLQuery(sql)
			.setString(0,ipAddress)
			.setString(1,ipPort)
			.executeUpdate();
	}


}
