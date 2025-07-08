package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPUserGroup;


public interface IIPUserGroupDao extends IGenericDao<IPUserGroup, Long> {


	public List<IPUserGroup> getUserGroupList() throws DataAccessException;
	
	
	
}
