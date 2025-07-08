package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.domain1.Iprur001Result1;
import th.co.ais.ipfm.domain1.Iprur001Result2;
import th.co.ais.ipfm.domain1.Iprur001Result4;



public interface IPReportService {
	
	public List<IpReportList> getIpReportCritier() throws Exception;
	public List<IpReportList> addReportCriteria(IpReportList obj) throws Exception ;
	public List<IpReportList> deleteReportCriteria(String reportId) throws Exception;
	public List<IpReportList> getIpReportList() throws Exception ;
	
	public List<Iprur001Result1> getIprur001Result1(String reportId) throws Exception;
	public List<Iprur001Result4> getIprur001Result4(String reportId) throws Exception;
	public List<Iprur001Result2> getTotalURRequest(String reportId, String urType) throws Exception;
	public List<String> getURList(String reportId, String urType, String seq, String level, String userId, String tab, String action, String status) throws Exception;
	public IpReportList getReportCritierByReportId(String reportId) throws Exception;

}
