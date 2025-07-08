package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.exception.IPFMBusinessException;


public interface HistoryNwConfigService {
	
	public List<IpUrAction> getIpUrActionList(String urNo) throws IPFMBusinessException;
	public IpUrNwConfig findByUrNo(String urNo) throws IPFMBusinessException;
	public List<IpUrActionHistory> getHistoryList(String urNo) throws IPFMBusinessException;
	public List<IpUrAction> findIpUrActionList(String urNo) throws IPFMBusinessException;
	
}
