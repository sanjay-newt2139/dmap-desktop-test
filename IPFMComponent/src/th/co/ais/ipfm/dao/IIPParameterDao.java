package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPParameter;

public interface IIPParameterDao extends IGenericDao<IPParameter, Long> {
	public static final String BOOLEAN_VALUE_TRUE = "T";
	public static final String BOOLEAN_VALUE_FALSE = "F";
	
	public List<IPParameter> searchIPParameter(String parameterGroup, String parameterSubGroup) throws DataAccessException;
	public List<String> getParameterGroupList() throws DataAccessException;
	public List<String> getParameterSubGroupList(String parameterGroup) throws DataAccessException;
	public int countSearchIPParameter(String parameterGroup, String parameterSubGroup) throws DataAccessException;
	public List<IPParameter> searchIPParameter(String parameterGroup, String parameterSubGroup, int maxResult) throws DataAccessException;
	public IPParameter getIPVersion() throws DataAccessException;
	public String getDownloadDocumentURL();
	
}
