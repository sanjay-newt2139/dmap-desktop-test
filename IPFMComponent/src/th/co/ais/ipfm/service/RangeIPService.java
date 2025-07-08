package th.co.ais.ipfm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.co.ais.ipfm.domain.IPRange;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;

public interface RangeIPService {

	public HashMap initRangeIPSearch(String tier1TeamID) throws IPFMBusinessException;
	public SearchResult search(IPRange ipRange,int maxResult) throws IPFMBusinessException;
	public void deleteIPRang(IPRange ipRange) throws IPFMBusinessException;
	public List<IPRange> deleteAndReSearchIPRange(String rowId,IPRange ipRange) throws IPFMBusinessException;
	public List<Map> checkIPRange(String ipVersion, String mask, String effectiveDate, String expireDate) throws IPFMBusinessException;
}
