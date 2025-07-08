package th.co.ais.ipfm.service;


import java.util.List;

import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.exception.IPFMBusinessException;





public interface IPTeamService {

	public List<IpTeam> getTier2TeamList() throws IPFMBusinessException;
	public IpTeam findIpTeamById(String teamId) throws IPFMBusinessException;
	
}
