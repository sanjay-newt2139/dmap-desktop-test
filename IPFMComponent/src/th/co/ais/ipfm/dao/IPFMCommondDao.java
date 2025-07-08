package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPMasterValue;

public interface IPFMCommondDao {
	public String getSysdate() throws DataAccessException;
	public List callStore(String callName, List params);
	public void execStore(String callName, List params);
	public List<IPMasterValue> getMasterValue(String valueGroup);
}