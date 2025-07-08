package th.co.ais.ipfm.service;

import java.util.HashMap;
import java.util.List;

import th.co.ais.ipfm.domain.IPGroup;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IIPGroupService {
	public List<String> getGroupIPVersion() throws IPFMBusinessException;
	public List<IPGroup> searchIPGroup(String ipVersion,String tire1TeamID, String[] startIP,String[] endIP) throws IPFMBusinessException, Exception;
	public IPGroup addIPGroup(IPGroup ipGroup) throws IPFMBusinessException, Exception;
	public IPGroup editIPGroup(IPGroup  ipGroup) throws IPFMBusinessException, Exception;
	public IPGroup deleteIPGroup(IPGroup  ipGroup) throws IPFMBusinessException;
	public HashMap initGroupIPSearch(String tier1TeamID) throws IPFMBusinessException;
} 
