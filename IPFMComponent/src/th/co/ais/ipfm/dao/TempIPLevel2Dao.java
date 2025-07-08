package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain1.TempIpLevel2;



public interface TempIPLevel2Dao extends IGenericDao<TempIpLevel2, Long>{

	public void createTempIPLevel2(String ipDigit1,String ipDigit2, String ipDigit3, String ipDigit4,String mask,String teamId) throws Exception;
	public List<TempIpLevel2> findTempIpLevel2(Integer maxSearchResult) throws Exception;
	public List<TempIpLevel2> searchIpLevel2(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4, String mask, String teamId, Integer maxSearchResult) throws Exception;
}
