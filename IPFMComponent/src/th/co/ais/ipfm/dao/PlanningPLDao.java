package th.co.ais.ipfm.dao;

import th.co.ais.ipfm.domain1.IpUrIpResult;


public interface PlanningPLDao {
	public void urIpTodoList(String urno, String urType, String action, String olaDate, String slaDate) throws Exception;
	public String getUrStatusDesc(String urType,String urStatus) throws Exception;
	public IpUrIpResult  checkIPRange(String  IpDigit1,String IpDigit2,String IpDigit3,String IpDigit4,String mask) throws Exception;
	public String checkDuplicateIP(String binSt, String binEd, String option) throws Exception;
}