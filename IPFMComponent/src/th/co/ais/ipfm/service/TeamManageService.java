package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;


public interface TeamManageService {
	
	
	public SearchResult searchTeam(IpTeam ipTeam, int maxResult) throws IPFMBusinessException;
	public String getTeamId() throws IPFMBusinessException;
	public List<IpTeam> deleteTeamId(String teamId) throws IPFMBusinessException;
	public void deleteTeam(IpTeam ipTeam)throws IPFMBusinessException;
	public List<IpTeam> searchTeam(IpTeam ipTeam)throws IPFMBusinessException;
	public List<IpUser> getTeamMemberList(String teamId)throws IPFMBusinessException;
	public List<IpUser> getSystemOwnerList() throws IPFMBusinessException;
	public List<IpUser> addTeam(IpUser ipUser)throws IPFMBusinessException;
	public void saveMember(IpTeam ipTeam) throws IPFMBusinessException;
	public List<IpUser> getTeamMember(IpUser ipUser,String teamId) throws IPFMBusinessException;
	public List<IpTeam> addTeamManage(IpTeam ipTeam)throws IPFMBusinessException;
}
