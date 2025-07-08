package th.co.ais.ipfm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.co.ais.ipfm.domain.IPRole;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrRouting;
import th.co.ais.ipfm.domain1.IpUrStatus;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.PMAssetDTO;
import th.co.ais.ipfm.domain1.PmAssign;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IPUrNwConfigService {
	public String getTempUrNO();
	public String getUrNO();
	public String genRowId();
	public IpUrNwConfig saveUr(IpUrNwConfig draft)throws IPFMBusinessException ;
	public IpUrNwConfig updateUr(IpUrNwConfig draft)throws IPFMBusinessException;
	
	public IpUrNwConfig findByUrNo(String urNo);
	public void deleteByUrNo(String urNo) throws IPFMBusinessException;
	public void deleteByNA(String urNo);
	
	
	public IpUrAction findActionByUrNo(String urNo,String subUrNo);
	public void deleteAction(IpUrAction action);
	public void deleteActionByRowId(String rowID);
	public void saveAction(IpUrAction action);
	public Date getSLADate(Date reqDate,String urType,String pmTeam);
	public Date getSLADate(Date reqDate,String urType,String pmTeam,String isImpact);
	public Date getOLADate(Date reqDate,String urType,String nodeId);
	public List<Map> ListManager(IpUser user);
	public IpvJobAssign getJobAssign(String urNo,String subUrNo);
	public List<IpvJobAssign> getJobAssignDetail(String urNo,String subUrNo);
	public List<IpvJobAssign> getJobAssignList(String urNo,String subUrNo);
	public List<IpvJobAssign> findListTeamReject(String urNo, String subUrNo);
	public IpUrStatus getSubUrStatus(String urType,String subUrId);
	public IpUrStatus getUrStatus(String urType,String subUrId);
	public String getOwnerIp(String ip);
	public String getPmRileId(String teamId);
	public List<IpUrAction> listActionByStatus(String urNo,String status);
	public List<IpUrAction> listActionByOwner(String urNo,String status);
	public List<IpUrAction> listActionByACTM(String urNo,IpUser user);
	public List<IpUrAction> listActionByACTMTeam(String urNo,IpUser user);
	public List<IpUrAction> listActionTeamProcess(String urNo,IpUser user);
	public List<IpUrAction> listUserVarify(String urNo,IpUser user);
	public List<IpRoleMember> listPerson(String teamId);
	public Map deletePrevious(String urNo);
	
	public void managerApproveUr(String urNo,IpUser user,String remark) throws IPFMBusinessException;
	public void managerRejectUr(String urNo,IpUser user,String remark)throws IPFMBusinessException;
	public void ownerApproveUr(String urNo,IpUser user,Map subUR) throws IPFMBusinessException;
	public void submitACTM(String urNo,IpUser user, Map subUR) throws IPFMBusinessException;
	public void teamProcess(String urNo,IpUser user, Map subUR) throws IPFMBusinessException;
	public void userVerify(String urNo,IpUser user)throws IPFMBusinessException;
	public boolean isRejectAble(String urNo, String subUrNo, String userId) throws IPFMBusinessException;
	public void rejectUnCompleteSubUr(String urNo,List<String> selectedSubUr,IpUser user, String actionRemark)throws IPFMBusinessException;
	public void saveDeleagte(String urNo,List<String> selectedSubUr,String roleId,IpUser user)throws IPFMBusinessException;
	public void saveDeleagte(String urNo,String roleId,IpUser user)throws IPFMBusinessException;
	public void savePMAssign(String urNo,List<String> subUrList, List<PMAssetDTO> pmAssetList,IpUser user,PmAssign pm) throws IPFMBusinessException;
	public void savePMAssign(String urNo,String subUrType, List<Object> listUr, List<String> subUrList, List<PMAssetDTO> pmAssetList,IpUser user,PmAssign pm) throws IPFMBusinessException;
	public void forceRejectStatus(String urNo,String subUrNo,IpUser user)throws IPFMBusinessException;
	public void forceCompleteStatus(String urNo,String subUrNo,IpUser user,String remark) throws IPFMBusinessException;
	
	public boolean isApproveAll(String urNo);
	public boolean isSendMailACTM(String user);
	public boolean isDelegateAble(String urNo, String subUrNo,String userId);
	public boolean isJobComplete(String urNo,String subUrNo);
	public String isTnp(String ip);
	public void insertHistoryNwConfig(String urNo,IpUser ipUser) throws IPFMBusinessException;
	public void deleteTab(boolean fw,boolean al,boolean at,boolean pi,boolean ig,boolean rt,boolean f5,String urNo,String userId) throws IPFMBusinessException;
	public void deleteUrNo(String urNo) throws IPFMBusinessException;
	public void sendForApprove(String urNo, String newUrNo, IpUser user,IpUrNwConfig ipUrNwConfig,String managerId,String managername,HashMap<String, Boolean> checked) throws IPFMBusinessException;
	public boolean isOwnerApproveAll(String urNo);
	public boolean isOwnerRejectAll(String urNo);
	public IpUrAction findUrActionNotify(String urNo,String status,String userId)throws IPFMBusinessException;
	public String  findActmRemark(String urNo,String subUrNo) throws IPFMBusinessException;
	public void cancelImpact(String urNo) throws IPFMBusinessException;
	public void cancelImpact(List<IpUrFirewall> listFirewall,
			List<IpUrAccessListCdn> listAccessList,
			List<IpUrAccessListTnp> listAccessTNP,
			List<IpUrPhysicalInterface> listPhysicalInterface,
			List<IpUrInterfaceGateway> listGateway,
			List<IpUrRouting> listRouting, List<IpUrF5> listF5)throws IPFMBusinessException;
	public List<IpUrActionHistory> findHistoryAction(String urNo, String urType) throws IPFMBusinessException;
	public IpInfo getIpInfo(String ipAddress) throws IPFMBusinessException;
	public void checkIPBeforeApprove(String newUrNo)throws IPFMBusinessException;
	public void updateTrunkFlag(String urNo, String type) throws IPFMBusinessException;
	
	
	public List<IpRoleMember> getRoleMember(String roleId) throws IPFMBusinessException;
	public IPRole getRoleData(String roleId) throws IPFMBusinessException;
	public void saveDeleagteNew(String urNo,List<String> selectedSubUr,String actionId,String actionName,IpUser user,String roleId,String remark)throws IPFMBusinessException;
}
