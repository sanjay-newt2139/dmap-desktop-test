package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpRole;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface UserProfileService {
	
	public List<IpUser> getUserList(String userId) throws IPFMBusinessException;
	public List<IpRole> getRoleList(String userId) throws IPFMBusinessException;
	public List<IpRole> getRoleList(String userId,String role06, String rolle07) throws IPFMBusinessException;
	public List<IpRole> getRoleAllList() throws IPFMBusinessException;
	public List<IpUser> getDelegateToList(String userId) throws IPFMBusinessException;
	public String getManagerName(String managerId) throws IPFMBusinessException;
	public List<IpDelegateUser> getDelegateDataList(String userId) throws IPFMBusinessException;
	public List<IpRoleMember> getRoleDataList(String roleId) throws IPFMBusinessException; 
	public IpUser getEhrByUserId(String userId) throws IPFMBusinessException;
	public void saveUserProfile(IpUser ipUser) throws IPFMBusinessException;
	public List<IpDelegateUser>  addDelegate(IpDelegateUser ipDelegateUser,IpUser ipUser) throws IPFMBusinessException;
	public List<IpDelegateUser>  deleteDelegate(IpDelegateUser ipDelegateUser, IpUser ipUser) throws IPFMBusinessException;
	public List<IpRoleMember>  addRole(IpRoleMember ipRoleMember) throws IPFMBusinessException;
	public List<IpRoleMember>  deleteRole(IpRoleMember ipRoleMember) throws IPFMBusinessException;
	public List<IpUser> getUserIdList() throws IPFMBusinessException;
	public String checkRole(String userId) throws IPFMBusinessException;
	public IpUser getIPUser(String userId) throws IPFMBusinessException;
	public List<IpDelegateUser> getDelegateAdminList(String userId) throws IPFMBusinessException;
	public List<IpRoleMember> findIpRoleMemberByUserId(String userId)throws IPFMBusinessException;
}
