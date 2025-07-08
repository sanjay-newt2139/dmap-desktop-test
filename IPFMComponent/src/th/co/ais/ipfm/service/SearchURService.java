package th.co.ais.ipfm.service;

import java.util.List;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrStatus;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;

public interface SearchURService {
	
	public List<IpUrStatus> getUrStatusList(String urType) throws IPFMBusinessException;
	public List<IpUrStatus> getSubUrStatusList(String urType) throws IPFMBusinessException;
	public SearchResult searchUR(IpUrIpDetail ipUrIpDetail,IpUser ipUser) throws IPFMBusinessException;
	public SearchResult searchUR(IpUrIpDetail ipUrIpDetail,String subUrPack,IpUser ipUser) throws IPFMBusinessException;
	public String getViewUR(String userId) throws IPFMBusinessException;
	public List<IpUser> getSystemOwnerList() throws IPFMBusinessException;

}
