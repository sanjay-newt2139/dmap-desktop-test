package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpRole;


public interface IPRoleDao extends IGenericDao<IpRole, Long> {

	public List<IpRole> getRoleList(String userId) throws DataAccessException;
	public List<IpRole> getRoleList(String userId, String role06, String role07) throws DataAccessException;
	public List<IpRole> getRoleAllList() throws DataAccessException;
	public IpRole getIpRole(String roleId) throws DataAccessException;
}
