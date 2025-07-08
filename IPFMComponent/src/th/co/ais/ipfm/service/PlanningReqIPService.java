package th.co.ais.ipfm.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpMaskDisplay;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface PlanningReqIPService {
	
	public IpUrIpDetail createDraft(IpUrIpDetail ipUrIpdetail,IpUrAttachment ipUrAttachment) throws IPFMBusinessException;
	public IpUrIpDetail updateDraft(IpUrIpDetail ipUrIpdetail) throws IPFMBusinessException;
	public IpUrIpDetail createSendForAssign(IpUrIpDetail ipUrIpdetail,IpUrAttachment ipUrAttachment) throws IPFMBusinessException;
	public IpUrIpDetail updateSendForAssign(IpUrIpDetail ipUrIpdetail) throws IPFMBusinessException, Exception;
	public IpUrIpDetail deleteUR(IpUrIpDetail ipUrIpdetail,IpUrAttachment ipUrAttachment) throws IPFMBusinessException;
	public IpUrIpDetail getIpUrIpDetail(String URNo) throws IPFMBusinessException;
	public List<IpUser> getSystemOwnerList() throws IPFMBusinessException;
	public List<IpTeam> getSystemOwnerTeamList() throws IPFMBusinessException;
	public String getURNo() throws IPFMBusinessException;
	public String getTempURNo() throws IPFMBusinessException;
	public List<IpMasterTable> getMaster_activeStatus_List(String refTable) throws IPFMBusinessException;
	public List<IpUrActionHistory> getHistoryList(String urNo) throws IPFMBusinessException;
	public List<IpUrAction> getURActionList(String urNo) throws IPFMBusinessException;
	public List<IpUrAttachment> getIpUrAttachmentList(String urNo) throws IPFMBusinessException;
	public IpUrIpResult checkIPRange(String  IpDigit1,String IpDigit2,String IpDigit3,String IpDigit4,String mask) throws IPFMBusinessException;
	public String  reCheck_ip_range(IpUrIpResult ipUrIpResult) throws IPFMBusinessException;
	public String checkDuplicateIP(String binSt, String binEd, String option) throws IPFMBusinessException;
	public void createAssignIP(IpUrIpResult ipUrIpResult,IpLevel1 ipLevel1) throws IPFMBusinessException;
	public void updateIpDetail_genURIpToDoList(IpUrIpDetail ipUrIpdetail)throws IPFMBusinessException;
	public String getLevel1_ID() throws IPFMBusinessException; 
	public IpUrIpResult getIpUrIpResult(String URNo) throws IPFMBusinessException;
	public String getUrStatusDesc(String urType,IpUrIpDetail ipUrIpDetail) throws IPFMBusinessException;
	public void rejectUR(IpUrIpDetail ipUrIpdetail,IpUrAttachment ipUrAttachment)throws IPFMBusinessException;
	public String getOlaDate(Date reqDate, String urType, String nodeId) throws IPFMBusinessException;
	public String getSlaDate(Date reqDate, String urType, String pm) throws IPFMBusinessException;
	public IpUrAction getIpUrAction(String urNo) throws IPFMBusinessException;
	public IpMaskDisplay findIpMaskDisplayByMask(String mask)throws IPFMBusinessException;
	public BigDecimal checkIpLevel2TotalNotAvailable(String binarySt,String binaryEd) throws IPFMBusinessException;
	public IpInfo checkStatusDataIpInfo(String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4) throws IPFMBusinessException;
	public List<IpUrIpResult> getIpUrIpResultList(String URNo) throws IPFMBusinessException;
	public void createAssignIP(IpUrIpDetail clone, List<IpUrIpResult> ipUrIpResultList, List<IpLevel1> level1List)throws IPFMBusinessException;
	public IpTeam findIpTeamById(String teamId) throws IPFMBusinessException;
}
