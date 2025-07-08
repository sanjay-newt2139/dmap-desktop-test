package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain.IPGroupMemberUser;
import th.co.ais.ipfm.domain.IPGroupMembers;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;

public interface UserGroupManageService {
	
	public List<IPGroupMemberUser> searchUserGroupManage(String groupId) throws IPFMBusinessException;
	public SearchResult searchUserGroupManage(String grpId, int maxResult) throws IPFMBusinessException;
	
	public IPGroupMembers createUserGroupManage(IPGroupMembers ipGroupMember) throws IPFMBusinessException;
	public void deleteUserGroupManage(IPGroupMemberUser ipGroupMember) throws IPFMBusinessException;
	public List<IPGroupMemberUser> deleteAndReSearchUserGroupManage(String rowId, String grpId) throws IPFMBusinessException;
 
}
