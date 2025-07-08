package th.co.ais.ipfm.dao;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpUrIpResult;

public interface IPUrIPResultDao extends IGenericDao<IpUrIpResult, Long>{

	public String reCheck_ip_range(IpUrIpResult ipUrIpResult) throws DataAccessException;
	public String reCheck_ip_range23(IpUrIpResult ipUrIpResult) throws DataAccessException;
	public BigDecimal getSeqNo(String urNo);
	public IpUrIpResult addIpUrIpResult(IpUrIpResult ipUrIpResult) throws DataAccessException;
	public IpUrIpResult updateIpUrIpResult(IpUrIpResult ipUrIpResult) throws DataAccessException;
	public IpUrIpResult getIpUrIpResult(String urNo) throws DataAccessException;
	public IpUrIpResult checkIPRange(IpUrIpResult ipUrIpResult) throws DataAccessException;
	public IpUrIpResult checkIPRange23(IpUrIpResult ipUrIpResult) throws Exception;
	public IpUrIpResult checkIPRange23_2(IpUrIpResult ipUrIpResult) throws Exception;
	public IpUrIpResult checkIPRange23_3(IpUrIpResult ipUrIpResult) throws Exception;
	public List<IpUrIpResult> getIpUrIpResultList(String urNo) throws DataAccessException;
	public IpUrIpResult getIpStartEnd3(String ip1, String ip2, String ip3, String ip4, String mark) throws Exception;
	
}
