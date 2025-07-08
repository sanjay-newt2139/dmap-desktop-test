package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpReportDetail;
import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.domain1.Iprur001Result1;
import th.co.ais.ipfm.domain1.Iprur001Result1PK;
import th.co.ais.ipfm.domain1.Iprur001Result2;
import th.co.ais.ipfm.domain1.Iprur001Result2PK;
import th.co.ais.ipfm.domain1.Iprur001Result3;
import th.co.ais.ipfm.domain1.Iprur001Result3PK;
import th.co.ais.ipfm.domain1.Iprur001Result4;
import th.co.ais.ipfm.domain1.Iprur001Result4PK;


public interface IPReportListDao extends IGenericDao<IpReportList, Long>{
	
	public String getReportId() throws DataAccessException;
	public List<IpReportList> getIpReportCritier() throws DataAccessException;
	public void addCritier(IpReportList entity) throws DataAccessException;
	public void deleteReportList(String reportId)throws DataAccessException;
	public List<IpReportList> getIpReportList() throws DataAccessException;
	public List<IpReportDetail> getIpReportDetail(IpReportDetail obj) throws DataAccessException;	
	public List<Iprur001Result1> getIprur001Result1(String reportId) throws DataAccessException;
	public List<Iprur001Result4> getIprur001Result4(String reportId) throws DataAccessException;
	public List<Iprur001Result2> getTotalURRequest(String reportId, String urType) throws DataAccessException;
	public List<String> getURNCList(String reportId, String seq, String level, String userId, String tab, String action, String status) throws DataAccessException;
	public List<String> getURIPList(String reportId, String seq, String level, String userId, String action, String status) throws DataAccessException;
	public IpReportList getReportCritierByReportId(String reportId) throws DataAccessException;

}
