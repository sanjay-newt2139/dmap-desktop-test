package th.co.ais.ipfm.service;


import java.util.List;

import th.co.ais.ipfm.domain.IPUserGroup;
import th.co.ais.ipfm.exception.IPFMBusinessException;





public interface IIPUserGroupService {

	public List<IPUserGroup> getUserGroupList() throws IPFMBusinessException;
	
}
