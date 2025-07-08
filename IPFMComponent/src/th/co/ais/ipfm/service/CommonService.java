package th.co.ais.ipfm.service;

import java.util.HashMap;
import java.util.List;
import th.co.ais.ipfm.domain.Suggestion;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.SearchResult;




public interface CommonService {

	public List<IpMasterTable> getMasterList(String ABBr) throws IPFMBusinessException;
	public HashMap getAllMasterList() throws IPFMBusinessException;
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey) throws IPFMBusinessException;
	public SearchResult searchMasterTable(String refTable, String refKey, int maxResult) throws IPFMBusinessException;
	public IpMasterTable createMasterTBL(IpMasterTable masterTBL) throws IPFMBusinessException;
	public IpMasterTable getMasterTBL(String rowId) throws IPFMBusinessException;
	public IpMasterTable updateMasterTBL(IpMasterTable masterTBL) throws IPFMBusinessException;
	public void deleteMasterTable(IpMasterTable masterTBL) throws IPFMBusinessException;
	public List<IpMasterTable> deleteAndReSearchMasterTable(String rowId, String refTable, String refKey) throws IPFMBusinessException;
	
	public List<String> getMasterRefTableList() throws IPFMBusinessException;
	public List<IpMasterTable> getMasterRefKeyList(String refTable) throws IPFMBusinessException;
	public List<Suggestion> findSuggestion(String refID, String key);
	public List<IpMasterTable> findMasterTableByRefKey(String ref);
	public List<IpMasterTable> deleteAndListMasterTable(String rowId, String refTable, String refKey,String userId) throws IPFMBusinessException;

	public String callBatchGenReport()throws IPFMBusinessException;//gen_report_iprur001
	public String callBatchUpdateUROverSlaOla()throws IPFMBusinessException;//update_ur_over_ola_sla
	
	
}
