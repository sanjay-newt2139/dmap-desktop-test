package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPGroup;

public interface IIPGroupDao extends IGenericDao<IPGroup, Long>{
	public List<String> getGroupIPVersion() throws DataAccessException;
	public List<IPGroup> searchIPGroup(String ipVersion,String tire1TeamID, String[] startIP,String[] endIP) throws DataAccessException, Exception;
	public String getMaxGrpId() throws DataAccessException;
	public IPGroup searchGroupEdit() throws DataAccessException;
	public IPGroup searchIPGroupById(String rowId,String grpId) throws Exception;
	public List<String> getGroupIPList() throws DataAccessException;
}
