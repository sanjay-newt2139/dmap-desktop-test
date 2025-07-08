package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPTodoList;
import th.co.ais.ipfm.domain.Inbox;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;

  
public interface IIPUserDao extends IGenericDao<IpUser, Long> {
	public IpUser getIPUser(String userId) throws Exception;
	public Integer getActiveDay() throws DataAccessException;
	public String getSysdate() throws DataAccessException;
	public List callStore(String callName, List<IPTodoList> params);
	public List<Inbox> getInboxDetailList(String key, String UserId) throws DataAccessException;
	public Integer getOnlineUser() throws Exception;
	public List<IpUser> getManagerApproveList(String userId) throws DataAccessException;
	public String getViewUR(String userId) throws DataAccessException;
	public List<IpUser> getManagerApproveList(List<String> mgrList);
	public String getV_UserPermission(String userId) throws DataAccessException;
	public List<IpUser> getTeamMemberList(String teamId) throws DataAccessException;
	public void updateTeam(IpUser ipUser) throws DataAccessException;
	public List<IpUser> getTeamMember(IpUser ipUser,String teamId)throws DataAccessException;
	public List<IpUser> getUserList(String userId) throws DataAccessException;
	public List<IpUser> getDelegateToList(String userId) throws DataAccessException;
	public String  getManagerName(String managerId) throws DataAccessException;
	public void updateUserProfile(IpUser ipUser) throws DataAccessException; 
	public List<IpUser> getUserIdList() throws DataAccessException;
	public List<IpRoleMember> getUserForOwnerApprove(String roleId);
	public void saveUserProfile(IpUser ipUser) throws DataAccessException;
	public List<IpUser> getRoleIdList(String roleId);
	public List<IpRoleMember> getIpRoleMember(String roleId) throws DataAccessException;
	public int  getCheckDuplicate(String userId,String teamId) throws DataAccessException;
	public List<IpUser> getSystemOwnerList() throws DataAccessException;
	public List<IpTeam> getSystemOwnerTeamList() throws DataAccessException;
	public IpUser findUserBySesionId(String userId, String session) throws DataAccessException;
	public List<IpUser> getTeamAssignURList(String teamId, String roleId)throws DataAccessException;
}
