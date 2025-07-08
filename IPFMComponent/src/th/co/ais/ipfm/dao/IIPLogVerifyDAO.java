package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.IpLogVerify;

public interface IIPLogVerifyDAO extends IGenericDao<IpLogVerify, Long> {
	
	public List<IpLogVerify> findIpLogVerify(String username);

}
