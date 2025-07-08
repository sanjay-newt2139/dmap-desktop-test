package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpTeam;



public interface IPTeamDao extends IGenericDao<IpTeam, Long> {

	public List<IpTeam> getTier2TeamList() throws DataAccessException;
	public int countSearchTeam(IpTeam ipTeam) throws DataAccessException;
	List<IpTeam> searchTeam(IpTeam ipTeam,int maxResult) throws DataAccessException;
	List<IpTeam> searchTeam(IpTeam ipTeam) throws DataAccessException;
	public String getTeamId() throws DataAccessException;
	public String getPmRoleId(String teamID);
	public IpTeam getIpTeam(String teamID) throws DataAccessException;
	public IpTeam getIpTeamByTeamName(String teamName)throws DataAccessException;
	public String getNextTeamId() throws DataAccessException;
	public String ipTeamByTeamName(String teamName) throws DataAccessException;
		
}
