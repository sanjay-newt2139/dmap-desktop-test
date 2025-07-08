package th.co.ais.ipfm.service;


import th.co.ais.ipfm.domain.IPUrIP;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IIPUrIPService {
	public String addIPUrIP(IPUrIP ipUrIP) throws IPFMBusinessException, Exception;
	public IPUrIP editIPUrIP(IPUrIP obj) throws IPFMBusinessException, Exception;
	public IPUrIP findIPUrIPByUrNo(String urNo) throws IPFMBusinessException, Exception;
}
