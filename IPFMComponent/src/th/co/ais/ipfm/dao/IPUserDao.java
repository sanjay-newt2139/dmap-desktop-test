package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;


public interface IPUserDao extends IGenericDao<IpUser, Long> {

	public List<IpUser> getSystemOwnerList() throws DataAccessException;
	public List<IpTeam> getSystemOwnerTeamList() throws DataAccessException;
	public List<IpTeam> getSystemOwnerTeamTier2List() throws DataAccessException;
	
}
