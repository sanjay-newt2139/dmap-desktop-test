package th.co.ais.ipfm.service;


import java.util.List;

import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IPUserService {
	public IpUser findIpUserById(String userId) throws Exception ;
	public Integer getOnlineUser() throws Exception ;
	public List<IpUser> getManagerApproveList(String userId) throws Exception;
	public List<IpUser> getManagerApproveList(List<String> userId) throws Exception;
	public List<IpUser> getIpUserListByTeam(String teamId) throws Exception;
	public List<IpUser> getSystemOwnerList() throws IPFMBusinessException;
	public List<IpTeam> getSystemOwnerTeamList() throws IPFMBusinessException;
	public IpUser saveIpUser(IpUser ipUser) throws IPFMBusinessException; 
	public List<IpUser> findUserByRoleId(String roleId) throws IPFMBusinessException; 
	public List<IpRoleMember> findUserByIpRoleMember(String roleId) throws IPFMBusinessException;
	public List<IpUser> getTeamAssignURList(String teamId,String roleId) throws IPFMBusinessException;
	public List<IpRoleMember> getUserForOwnerApprove(String pmRoleId) throws IPFMBusinessException;
}
