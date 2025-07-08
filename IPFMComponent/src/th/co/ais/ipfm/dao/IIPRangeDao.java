package th.co.ais.ipfm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPRange;


public interface IIPRangeDao extends IGenericDao<IPRange, Long> {
	public static final String BOOLEAN_VALUE_TRUE = "T";
	public static final String BOOLEAN_VALUE_FALSE = "F";
	
	public List<String> getIPVersionListByTier1TeamID(String tier1TeamID) throws DataAccessException;
	public List<IPRange> search(IPRange ipRange, int maxResult) throws DataAccessException;
	public List<IPRange> search(IPRange ipRange) throws DataAccessException;
	public int countSearch(IPRange ipRange)throws DataAccessException;
	public List<Map> checkIPRange(String ipVersion, String mask, String effectiveDate, String expireDate) throws DataAccessException;
	
	
}
