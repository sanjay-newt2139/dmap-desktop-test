package th.co.ais.ipfm.service;


import java.util.List;

import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IPUrIPResultService {
	public IpUrIpResult checkIPRange(IpUrIpResult ipUrIpResult) throws IPFMBusinessException;
	public IpUrIpResult checkIPRange23(IpUrIpResult ipUrIpResult) throws IPFMBusinessException;
	public IpUrIpResult checkIPRange23_2(IpUrIpResult ipUrIpResult) throws IPFMBusinessException;
	public IpUrIpResult addIpUrIpResult(IpUrIpResult ipUrIpResult) throws IPFMBusinessException;
	public List<IpUrIpResult> addIpUrIpResult(List<IpUrIpResult> ipUrIpResultList) throws IPFMBusinessException;
}
