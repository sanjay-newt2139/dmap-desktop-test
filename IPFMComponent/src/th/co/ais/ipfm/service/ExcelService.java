package th.co.ais.ipfm.service;

import java.io.File;
import java.util.Map;

import th.co.ais.ipfm.domain1.ExcelErrorMsg;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.exception.IPFMBusinessException;




public interface ExcelService {

	public Map userRequestIPImport(File file, String sheetName, IpUrIpDetail ipUrIpDetail, IpUrIpResult ipResult,String userTeamId, String userId) throws IPFMBusinessException ;
	public void prepareIPVersion(IpUrIpResult ipUrIpResult, String ipVersion, ExcelErrorMsg excelMsg);
	public void prepareIPAddress(IpUrIpResult ipUrIpResult, String ipAddress, ExcelErrorMsg excelMsg);
	public void prepareEffExpDate(IpUrIpResult ipUrIpResult, String effectiveDate, String expireDate, ExcelErrorMsg excelMsg);
}
