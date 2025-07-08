package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;

public interface IIPParameterService {
	public List<IPParameter> searchIPParameter(String parameterGroup, String parameterSubGroup) throws IPFMBusinessException;
	public SearchResult searchIPParameter(String parameterGroup, String parameterSubGroup, int maxResult) throws IPFMBusinessException;
	public List<String> getParameterGroupList() throws IPFMBusinessException;
	public List<String> getParameterSubGroupList(String parameterGroup) throws IPFMBusinessException;
	public IPParameter getIPParameter(String parameterId) throws IPFMBusinessException;
	public IPParameter createIPParameter(IPParameter ipParameter) throws IPFMBusinessException;
	public IPParameter updateIPParameter(IPParameter ipParameter) throws IPFMBusinessException;
	public void deleteIPParameter(IPParameter ipParameter) throws IPFMBusinessException;
	public List<IPParameter> deleteAndReSearchIPParameter(String rowId, String parameterGroup, String parameterSubGroup) throws IPFMBusinessException;
	public IPParameter getIPVersion() throws IPFMBusinessException;
	public String getDownloadDocumentURL();  

}
