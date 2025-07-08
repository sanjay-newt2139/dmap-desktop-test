package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.TempInbox;


public interface InboxDao extends IGenericDao<TempInbox, Long> {

	public List<TempInbox> findInbox(String userId, String title1, String title2, String title3, String urNo) throws DataAccessException, Exception;
	public String getNews() throws Exception;
	public Integer getWebCounter() throws Exception;
}
