package th.co.ais.ipfm.dao;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpWfConfig;



public interface IPUrActionDao extends IGenericDao<IpUrAction, Long>{
	
	public List<IpUrAction> getURActionList(String urNo) throws DataAccessException;
	
	public void deleteByUrNo(String urNo);
	public void deleteBySubUrNo(String urNo,String subUrNo,String urStatus);
	public void deleteByRowID(String rowID);  
	public void deleteNA(String urNo);
	public void deleteACTM(String urNo,IpUser user);
	public void updateAction(String urNo,String urStatus,String callFunc,String callMode,IpUser user);
	public void updateActionReject(String urNo,String urStatus,String callFunc,String callMode,IpUser user, IpUser reqUser);
	public IpUrAction findUrAction(String urNo,String subUrNo) throws DataAccessException;
	public List<IpUrAction> findUrActions(String urNo,String subUrNo) throws DataAccessException;
	public IpUrAction findUrAction(String urNo,String subUrNo,String user) throws DataAccessException;
	public String isOverSla(String urNo);
	public Date getSLADate(Date reqDate,String urType,String pm);
	public Date getSLADate(Date reqDate,String urType,String nodeId,String isImpact);
	public Date getOLADate(Date reqDate,String urType,String nodeId);
	public List<IpUrAction> findActionBySubURAndStatus(String urNo,String subUrNo, String[] status) throws Exception;
	public List<IpUrAction> listActionByStatus(String urNo,String status);
	public List<IpUrAction> listActionByOwner(String urNo,String owner);
	public List<IpUrAction> listActionForActm(String urNo,IpUser user);
	public List<IpUrAction> listActionTeam(String urNo,IpUser user);
	public List<IpUrAction> listWaitTeamProcess(String urNo,IpUser user);
	public List<IpUrAction> findActionStatus(IpUrAction action, String ststus);
	public List<IpUrAction> listPMAssign(String urNo,IpUser user);
	public IpUrAction findUrActionNotify(String urNo,String status,String userId);
	public Map deletePreviousUrAction(String urNo);
	
	public List<IpUrAction> listAction(String urNo,String subUrNo);
	public List<IpUrAction> listAction(String urNo,IpUser user,String status);
 	public boolean isSendMailACTM(String user);
	public boolean isOwnerApproveAll(String urNo);
	public boolean isOwnerRejectAll(String urNo);
	public boolean isDelegateAble(String urNo,String subUrNo,String userId);
	public boolean isRejectAble(String urNo,String subUrNo,String userId)throws Exception;
	public int getHoliday(Date start,Date end);
	public int nonWorkDay(Date start,Date end);

	public boolean isInRole(String user,String RoleId);
	
	public int getOLADateFromNodeID(String roleId);
	public IpWfConfig getSLADateImpact(String isImpact);
	public int getUnFinishUR(String urNo);
	public List<IpUrAction> getURAction(String urNo) throws DataAccessException;
	public List<IpUrAction> findIpUrActionList(String urNo) throws DataAccessException;
	public List<IpUrAction> findActionByURAndStatus(String urNo, String[] status) throws Exception;
	public BigDecimal getNextActionSeq(String urNo, String urType, String subUrNo) throws Exception;
	public Integer getValueOLADate(String urType,String nodeId);
	public Integer getValueSLADate(String urType,String pm,String isImpact);
}
