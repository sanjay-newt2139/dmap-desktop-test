package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.vo.IPDetailVO;



public interface IPDetailDao extends IGenericDao<IPDetail, Long> {

	public List<IPDetail> search(IPDetailVO DTO,int maxResult) throws DataAccessException;
	public IPDetail searchIPDetail(IPDetailVO DTO) throws DataAccessException;
	public int countSearchIPDetail(IPDetailVO DTO) throws DataAccessException;

	
	
	
}
