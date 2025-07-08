package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpRoleMember;

public interface IPRoleMemberDao extends IGenericDao<IpRoleMember, Long>{

	public IpRoleMember addIpRoleMembers(IpRoleMember ipRoleMember) throws DataAccessException;
	public List<IpRoleMember> findIpRoleMembersByUserId(String userId) throws DataAccessException;
	public List<IpRoleMember> getRoleDataList(String roleId) throws DataAccessException;
	public String  getCheckExistingDataRole(IpRoleMember ipRoleMember) throws DataAccessException;
	public List<IpRoleMember> deleteRole(String roleId,String userId)throws DataAccessException;
	public String  checkRole(String  userId) throws DataAccessException;
}
