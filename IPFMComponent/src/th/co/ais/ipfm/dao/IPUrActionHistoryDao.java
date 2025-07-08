package th.co.ais.ipfm.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpUrActionHistory;

public interface IPUrActionHistoryDao extends IGenericDao<IpUrActionHistory, Long>{
	
	public List<IpUrActionHistory> getHistoryList(String urNo) throws DataAccessException;
	public IpUrActionHistory getPMAssign(String urNo,String urType,String subUrNo,String subUrType);
	public IpUrActionHistory getIpUrActionHistory(String urNo) throws DataAccessException;
	public void deleteByUrNo(String urNo) throws DataAccessException;
	public void copyHistory(IpUrActionHistory history);
	public BigDecimal getNextActionSeq(String urNo, String urType, String subUrNo) throws DataAccessException;
	public void deleteNA(String urNo);
	public List<IpUrActionHistory> findHistoryAction(String urNo, String urType);
	public List<IpUrActionHistory> findHistoryAction(String urNo,String subUrNo, String urType, String urStatus);
	public List<IpUrActionHistory> findListTeamReject(String urNo, String subUrNo);
}
