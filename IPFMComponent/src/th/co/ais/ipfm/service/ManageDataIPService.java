package th.co.ais.ipfm.service;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.IPDetailVO;
import th.co.ais.ipfm.vo.SearchResult;




public interface ManageDataIPService {

	public SearchResult search(IPDetailVO DTO, int maxResult) throws IPFMBusinessException;
	public IPDetail searchIPDetail(IPDetailVO DTO) throws IPFMBusinessException;
	public IPDetail  getIPDetail(String rowId) throws IPFMBusinessException;
	public IPDetail updateIpDetail(IPDetail ipDetail) throws IPFMBusinessException;
}
