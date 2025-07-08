package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPGroupMemberUser;

public interface IIPGroupMemberDao extends IGenericDao<IPGroupMemberUser, Long>{

	public List<IPGroupMemberUser> searchUserGroupManage(String groupId) throws DataAccessException;
	public int countSearchUserGroupManage(String groupId) throws DataAccessException;
	public List<IPGroupMemberUser> searchUserGroupManage(String groupId, int maxResult) throws DataAccessException;
	
}
