package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpMasterTable;


public interface CommonDao extends IGenericDao<IpMasterTable, Long> {

	public IpMasterTable getMasterById(String rowId) throws DataAccessException;
	public String getROW_ID() throws DataAccessException;
	public IpMasterTable getMasterTableById(String rowId) throws DataAccessException;	
	public List<IpMasterTable> getMasterList(String refTable) throws DataAccessException;	
	public int countSearchMasterTable(String refTable, String refKey) throws DataAccessException;
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey) throws DataAccessException;
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey, int maxResult) throws DataAccessException;
	public List<String> getMasterRefTableList() throws DataAccessException;
	public List<IpMasterTable> getMasterRefKeyList(String refTable) throws DataAccessException;
	public List<IpMasterTable> getMaster_activeStatus_List(String refTable) throws DataAccessException;
	public List<IpMasterTable> searchMasterTable(String refTable, String refKey, String refDesc) throws DataAccessException;
	public void insertMaster(IpMasterTable obj) throws DataAccessException;
	public List<IpMasterTable> getMasterTableList(String refTable) throws DataAccessException;
	public void deleteByRowId(String rowId);
	public void updateNews(IpMasterTable obj);	
	public void updateFlag(IpMasterTable masterTBL,String refTable,String refKey,String userId) throws DataAccessException;	
	public String genReport()throws DataAccessException;
	public String updateUROverSlaOla()throws DataAccessException;
	public List<IpMasterTable> searchMasterTableForADD(String refTable, String refKey, String status) throws DataAccessException;
	
}
