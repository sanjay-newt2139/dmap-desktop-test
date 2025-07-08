package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.codec.binary.Base64;
import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain.NCAssign;
import th.co.ais.ipfm.domain.NCData;
import th.co.ais.ipfm.domain1.EmailDetail;
import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentDto;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrRouting;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.domain1.PmAssign;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class ReqNWConfigBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IpUrFirewall> listFirewall;
	private List<IpUrAccessListCdn> listAccessList;
	private List<IpUrAccessListTnp> listAccessTNP;
	private List<IpUrPhysicalInterface> listPhysicalInterface;
	private List<IpUrInterfaceGateway> listGateway;
	private List<IpUrRouting> listRouting;
	private List<IpUrF5> listF5;
	private List<NCAssign> listAssign;
	private List<IpUrAttachment> listAttach;
	private List<IpSubUrAttachmentDto> listSubAttach;
	private List<SelectItem> listManager;
	private List<String> selectedManager;
	private List<MsgUploadError> validateResult;
	private List<SelectItem> listPerson;
	private List<SelectItem> listdgp;
	private List<String> selectedPerson;
	private List<String> selectedDelegatePerson;
	private List<IpvJobAssign> jobAssign;
	private List<String> selectedSubUr;

	private Boolean isSendEmail;
	private List<EmailDetail> emailDetail;

	private IPFMRichComboItem forceStatus;
	private String forceJobStatus;

	private String urNo;
	private String subject;
	private String objective;
	private String requirement;
	private String isPeroiod;
	private Date periodStart;
	private Date periodEnd;
	private String requestFor;
	private String isAttach;
	private String urStatusDesc;
	private String mgrRemark;
	private String mgrName;
	private String selectSubUR;
	private String delegateTeamID;
	private String assignForTeam;
	private String assignForPerson;
	private String currentTab;

	private IpUrNwConfig networkConfig;

	private Boolean firewallCheck = false;
	private Boolean accessListCheck = false;
	private Boolean accessTNPCheck = false;
	private Boolean physicalCheck = false;
	private Boolean gatewayCheck = false;
	private Boolean routingCheck = false;
	private Boolean f5Check = false;
	private Boolean showDetail = false;
	private Boolean InsertF5Mode = true;
	private Boolean byPerson = false;
	private Boolean isTnp = false;

	private Boolean isTeamCdno = false;
	private Boolean isTeamSta1 = false;
	private Boolean isTeamSta2 = false;
	private Boolean isTeamTdno = false;
	private Boolean isTeamCdn = false;

	private Boolean isPersonCdno = false;
	private Boolean isPersonSta1 = false;
	private Boolean isPersonSta2 = false;
	private Boolean isPersonTdno = false;
	private Boolean isPersonCdn = false;
	private Boolean isCompleteJob = false;

	private Boolean hideAddButton = false;
	private String detailViewName;
	private NCData viewResult;

	private IPFirewallBean firewall;
	private IPAccessListBean accessList;
	private IPAccessListTNPBean accessListTNP;
	private IPPhyInterfaceBean phyInterface;
	private IPIntfGatewayBean gateway;
	private IPRoutingBean routing;
	private IPF5Bean f5;

	private IpUrF5 editUrF5;
	private IpUser user;

	private Boolean confFlag = false;
	private Boolean errorFlag = false;
	private String errorMsg;
	private String mode;
	private String modeReject;
	private HtmlModalPanel errorPanel;

	private String deleteUrNo;
	private String deleteSubUrNo;
	private String deleteUrType;

	private PmAssign pmAssign;

	private String linkUrl;
	private String key;
	private String rejectRemark;
	private boolean visibleButtonSubmit = false;
	private boolean checkImpactFw;
	private boolean checkImpactAL;
	private boolean checkImpactAT;
	private boolean checkImpactPI;
	private boolean checkImpactIG;
	private boolean checkImpactRT;
	private boolean checkImpactF5;
	private int pageScroller = 1;

	private List<SelectItem> nwLocationList;
	private IPFMRichComboItem locationComboItem;
	private List<SelectItem> teamList;
	private String delegateTeamSelect;

	private FilterBean filterReqNWCTNP01 = new FilterBean();
	private FilterBean filterReqNWCTNP02 = new FilterBean();
	private FilterBean filterReqNWCTNP03 = new FilterBean();
	private FilterBean filterReqNWCTNP04 = new FilterBean();
	private FilterBean filterReqNWCTNP05 = new FilterBean();
	private FilterBean filterReqNWCTNP06 = new FilterBean();
	private FilterBean filterReqNWCTNP07 = new FilterBean();
	
	private FilterBean filterReqNWCFW01 = new FilterBean();
	private FilterBean filterReqNWCFW02 = new FilterBean();
	private FilterBean filterReqNWCFW03 = new FilterBean();
	private FilterBean filterReqNWCFW04 = new FilterBean();
	private FilterBean filterReqNWCFW05 = new FilterBean();
	private FilterBean filterReqNWCFW06 = new FilterBean();
	private FilterBean filterReqNWCFW07 = new FilterBean();
	
	private FilterBean filterReqNWCAL01 = new FilterBean();
	private FilterBean filterReqNWCAL02 = new FilterBean();
	private FilterBean filterReqNWCAL03 = new FilterBean();
	private FilterBean filterReqNWCAL04 = new FilterBean();
	private FilterBean filterReqNWCAL05 = new FilterBean();
	private FilterBean filterReqNWCAL06 = new FilterBean();
	private FilterBean filterReqNWCAL07 = new FilterBean();
	
	private FilterBean filterReqNWCF501 = new FilterBean();
	private FilterBean filterReqNWCF502 = new FilterBean();
	private FilterBean filterReqNWCF503 = new FilterBean();
	private FilterBean filterReqNWCF504 = new FilterBean();
	private FilterBean filterReqNWCF505 = new FilterBean();
	private FilterBean filterReqNWCF506 = new FilterBean();
	private FilterBean filterReqNWCF507 = new FilterBean();
	
	private FilterBean filterReqNWCGW01 = new FilterBean();
	private FilterBean filterReqNWCGW02 = new FilterBean();
	private FilterBean filterReqNWCGW03 = new FilterBean();
	private FilterBean filterReqNWCGW04 = new FilterBean();
	private FilterBean filterReqNWCGW05 = new FilterBean();
	private FilterBean filterReqNWCGW06 = new FilterBean();
	private FilterBean filterReqNWCGW07 = new FilterBean();
	
	private FilterBean filterReqNWCRO01 = new FilterBean();
	private FilterBean filterReqNWCRO02 = new FilterBean();
	private FilterBean filterReqNWCRO03 = new FilterBean();
	private FilterBean filterReqNWCRO04 = new FilterBean();
	private FilterBean filterReqNWCRO05 = new FilterBean();
	private FilterBean filterReqNWCRO06 = new FilterBean();
	private FilterBean filterReqNWCRO07 = new FilterBean();
	
	private FilterBean filterReqNWCPI01 = new FilterBean();
	private FilterBean filterReqNWCPI02 = new FilterBean();
	private FilterBean filterReqNWCPI03 = new FilterBean();
	private FilterBean filterReqNWCPI04 = new FilterBean();
	private FilterBean filterReqNWCPI05 = new FilterBean();
	private FilterBean filterReqNWCPI06 = new FilterBean();
	private FilterBean filterReqNWCPI07 = new FilterBean();
	 
	
	private FilterBean filterTablAccess = new FilterBean();
	private FilterBean filterTablAssign = new FilterBean();
	private FilterBean filterTablView = new FilterBean();
	
	private FilterBean filterReqNWCPopupAL = new FilterBean();
	private FilterBean filterReqNWCPopupTNP = new FilterBean();
	private FilterBean filterReqNWCPopupAS = new FilterBean();
	private FilterBean filterReqNWCPopupF5 = new FilterBean();
	private FilterBean filterReqNWCPopupFW = new FilterBean();
	private FilterBean filterReqNWCPopupGW = new FilterBean();
	private FilterBean filterReqNWCPopupPI = new FilterBean();
	private FilterBean filterReqNWCPopupRO = new FilterBean();
	
	private String ipType;
	
	private PmAssign pmDelegate;
 
	public String getKey() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getKey
		return new String(Base64.encodeBase64("NC2010-000120".getBytes()));
	}

	public void setKey(String key) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setKey
		this.key = key;
	}

	public String getLinkUrl() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLinkUrl
		return "view.jsf";
	}

	public void setLinkUrl(String linkUrl) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLinkUrl
		this.linkUrl = linkUrl;
	}

	public List<SelectItem> getListManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListManager
		return listManager;
	}

	public void setListManager(List<SelectItem> listManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListManager
		this.listManager = listManager;
	}

	public IpUser getUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUser
		return user;
	}

	public void setUser(IpUser user) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUser
		this.user = user;
	}

	public Boolean getErrorFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorFlag
		return errorFlag;
	}

	public void setErrorFlag(Boolean errorFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorFlag
		this.errorFlag = errorFlag;
	}

	public String getDetailViewName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDetailViewName
		return detailViewName;
	}

	public void setDetailViewName(String detailViewName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDetailViewName
		this.detailViewName = detailViewName;
	}

	public Boolean getHideAddButton() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHideAddButton
		return hideAddButton;
	}

	public void setHideAddButton(Boolean hideAddButton) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHideAddButton
		this.hideAddButton = hideAddButton;
	}

	public Boolean getFirewallCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFirewallCheck
		return firewallCheck;
	}

	public void setFirewallCheck(Boolean firewallCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFirewallCheck
		this.firewallCheck = firewallCheck;
	}

	public List<IpUrFirewall> getListFirewall() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListFirewall
		return listFirewall;
	}

	public void setListFirewall(List<IpUrFirewall> listFirewall) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListFirewall
		this.listFirewall = listFirewall;
	}

	public Boolean getAccessListCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAccessListCheck
		return accessListCheck;
	}

	public void setAccessListCheck(Boolean accessListCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAccessListCheck
		this.accessListCheck = accessListCheck;
	}

	public Boolean getAccessTNPCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAccessTNPCheck
		return accessTNPCheck;
	}

	public void setAccessTNPCheck(Boolean accessTNPCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAccessTNPCheck
		this.accessTNPCheck = accessTNPCheck;
	}

	public Boolean getPhysicalCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhysicalCheck
		return physicalCheck;
	}

	public void setPhysicalCheck(Boolean physicalCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhysicalCheck
		this.physicalCheck = physicalCheck;
	}

	public Boolean getGatewayCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGatewayCheck
		return gatewayCheck;
	}

	public void setGatewayCheck(Boolean gatewayCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGatewayCheck
		this.gatewayCheck = gatewayCheck;
	}

	public Boolean getRoutingCheck() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoutingCheck
		return routingCheck;
	}

	public void setRoutingCheck(Boolean routingCheck) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoutingCheck
		this.routingCheck = routingCheck;
	}

	public Boolean getF5Check() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5Check
		return f5Check;
	}

	public void setF5Check(Boolean f5Check) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5Check
		this.f5Check = f5Check;
	}

	public List<IpUrAccessListCdn> getListAccessList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListAccessList
		return listAccessList;
	}

	public void setListAccessList(List<IpUrAccessListCdn> listAccessList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListAccessList
		this.listAccessList = listAccessList;
	}

	public List<IpUrAccessListTnp> getListAccessTNP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListAccessTNP
		return listAccessTNP;
	}

	public void setListAccessTNP(List<IpUrAccessListTnp> listAccessTNP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListAccessTNP
		this.listAccessTNP = listAccessTNP;
	}

	public List<IpUrPhysicalInterface> getListPhysicalInterface() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListPhysicalInterface
		return listPhysicalInterface;
	}

	public void setListPhysicalInterface( // DMAP Comment : Dead Code Detected - The Following Method has no reference setListPhysicalInterface
			List<IpUrPhysicalInterface> listPhysicalInterface) {
		this.listPhysicalInterface = listPhysicalInterface;
	}

	public List<IpUrInterfaceGateway> getListGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListGateway
		return listGateway;
	}

	public void setListGateway(List<IpUrInterfaceGateway> listGateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListGateway
		this.listGateway = listGateway;
	}

	public List<IpUrRouting> getListRouting() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListRouting
		return listRouting;
	}

	public void setListRouting(List<IpUrRouting> listRouting) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListRouting
		this.listRouting = listRouting;
	}

	public List<IpUrF5> getListF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListF5
		return listF5;
	}

	public void setListF5(List<IpUrF5> listF5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListF5
		this.listF5 = listF5;
	}

	public Boolean getShowDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShowDetail
		return showDetail;
	}

	public void setShowDetail(Boolean showDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowDetail
		this.showDetail = showDetail;
	}

	public List<NCAssign> getListAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListAssign
		return listAssign;
	}

	public void setListAssign(List<NCAssign> listAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListAssign
		this.listAssign = listAssign;
	}

	public NCData getViewResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getViewResult
		return viewResult;
	}

	public void setViewResult(NCData viewResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setViewResult
		this.viewResult = viewResult;
	}

	public IPFirewallBean getFirewall() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFirewall
		return firewall;
	}

	public void setFirewall(IPFirewallBean firewall) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFirewall
		this.firewall = firewall;
	}

	public String getSubject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubject
		return subject;
	}

	public void setSubject(String subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubject
		this.subject = subject;
	}

	public String getObjective() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getObjective
		return objective;
	}

	public void setObjective(String objective) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setObjective
		this.objective = objective;
	}

	public String getRequirement() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequirement
		return requirement;
	}

	public void setRequirement(String requirement) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequirement
		this.requirement = requirement;
	}

	public String getIsPeroiod() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPeroiod
		return isPeroiod;
	}

	public void setIsPeroiod(String isPeroiod) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPeroiod
		this.isPeroiod = isPeroiod;
	}

	public String getRequestFor() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestFor
		return requestFor;
	}

	public void setRequestFor(String requestFor) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestFor
		this.requestFor = requestFor;
	}

	public Date getPeriodStart() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPeriodStart
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPeriodStart
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPeriodEnd
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPeriodEnd
		this.periodEnd = periodEnd;
	}

	public String getErrorMsg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMsg
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMsg
		this.errorMsg = errorMsg;
	}

	public HtmlModalPanel getErrorPanel() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorPanel
		return errorPanel;
	}

	public void setErrorPanel(HtmlModalPanel errorPanel) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorPanel
		this.errorPanel = errorPanel;
	}

	public Boolean getInsertF5Mode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInsertF5Mode
		return InsertF5Mode;
	}

	public void setInsertF5Mode(Boolean insertF5Mode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInsertF5Mode
		InsertF5Mode = insertF5Mode;
	}

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getIsAttach() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsAttach
		return isAttach;
	}

	public void setIsAttach(String isAttach) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsAttach
		this.isAttach = isAttach;
	}

	public IPAccessListBean getAccessList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAccessList
		return accessList;
	}

	public void setAccessList(IPAccessListBean accessList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAccessList
		this.accessList = accessList;
	}

	public IPAccessListTNPBean getAccessListTNP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAccessListTNP
		return accessListTNP;
	}

	public void setAccessListTNP(IPAccessListTNPBean accessListTNP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAccessListTNP
		this.accessListTNP = accessListTNP;
	}

	public IPPhyInterfaceBean getPhyInterface() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPhyInterface
		return phyInterface;
	}

	public void setPhyInterface(IPPhyInterfaceBean phyInterface) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPhyInterface
		this.phyInterface = phyInterface;
	}

	public IPIntfGatewayBean getGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGateway
		return gateway;
	}

	public void setGateway(IPIntfGatewayBean gateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGateway
		this.gateway = gateway;
	}

	public IPRoutingBean getRouting() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRouting
		return routing;
	}

	public void setRouting(IPRoutingBean routing) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRouting
		this.routing = routing;
	}

	public IPF5Bean getF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getF5
		return f5;
	}

	public void setF5(IPF5Bean f5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setF5
		this.f5 = f5;
	}

	public IpUrF5 getEditUrF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEditUrF5
		return editUrF5;
	}

	public void setEditUrF5(IpUrF5 editUrF5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEditUrF5
		this.editUrF5 = editUrF5;
	}

	public String getUrStatusDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrStatusDesc
		return urStatusDesc;
	}

	public void setUrStatusDesc(String urStatusDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrStatusDesc
		this.urStatusDesc = urStatusDesc;
	}

	public List<IpUrAttachment> getListAttach() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListAttach
		return listAttach;
	}

	public void setListAttach(List<IpUrAttachment> listAttach) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListAttach
		this.listAttach = listAttach;
	}

	public List<String> getSelectedManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectedManager
		return selectedManager;
	}

	public void setSelectedManager(List<String> selectedManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectedManager
		this.selectedManager = selectedManager;
	}

	public IpUrNwConfig getNetworkConfig() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkConfig
		return networkConfig;
	}

	public void setNetworkConfig(IpUrNwConfig networkConfig) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkConfig
		this.networkConfig = networkConfig;
	}

	public String getMode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMode
		return mode;
	}

	public void setMode(String mode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMode
		this.mode = mode;
	}

	public String getMgrRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMgrRemark
		return mgrRemark;
	}

	public void setMgrRemark(String mgrRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMgrRemark
		this.mgrRemark = mgrRemark;
	}

	public String getMgrName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMgrName
		return mgrName;
	}

	public void setMgrName(String mgrName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMgrName
		this.mgrName = mgrName;
	}

	public List<MsgUploadError> getValidateResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValidateResult
		return validateResult;
	}

	public void setValidateResult(List<MsgUploadError> validateResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValidateResult
		this.validateResult = validateResult;
	}

	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}

	public String getSelectSubUR() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectSubUR
		return selectSubUR;
	}

	public void setSelectSubUR(String selectSubUR) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectSubUR
		this.selectSubUR = selectSubUR;
	}

	public Boolean getConfFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getConfFlag
		return confFlag;
	}

	public void setConfFlag(Boolean confFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setConfFlag
		this.confFlag = confFlag;
	}

	public String getDelegateTeamID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateTeamID
		return delegateTeamID;
	}

	public void setDelegateTeamID(String delegateTeamID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateTeamID
		this.delegateTeamID = delegateTeamID;
	}

	public List<SelectItem> getListPerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListPerson
		return listPerson;
	}

	public void setListPerson(List<SelectItem> listPerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListPerson
		this.listPerson = listPerson;
	}

	public List<String> getSelectedPerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectedPerson
		return selectedPerson;
	}

	public void setSelectedPerson(List<String> selectedPerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectedPerson
		this.selectedPerson = selectedPerson;
	}

	public Boolean getByPerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getByPerson
		return byPerson;
	}

	public void setByPerson(Boolean byPerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setByPerson
		this.byPerson = byPerson;
	}

	public Boolean getIsTnp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTnp
		return isTnp;
	}

	public void setIsTnp(Boolean isTnp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTnp
		this.isTnp = isTnp;
	}

	public String getAssignForTeam() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignForTeam
		return assignForTeam;
	}

	public void setAssignForTeam(String assignForTeam) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignForTeam
		this.assignForTeam = assignForTeam;
	}

	public String getAssignForPerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignForPerson
		return assignForPerson;
	}

	public void setAssignForPerson(String assignForPernon) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignForPerson
		this.assignForPerson = assignForPernon;
	}

	public Boolean getIsTeamCdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamCdno
		return isTeamCdno;
	}

	public void setIsTeamCdno(Boolean isTeamCdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamCdno
		this.isTeamCdno = isTeamCdno;
	}

	public Boolean getIsTeamSta1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamSta1
		return isTeamSta1;
	}

	public void setIsTeamSta1(Boolean isTeamSta1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamSta1
		this.isTeamSta1 = isTeamSta1;
	}

	public Boolean getIsTeamSta2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamSta2
		return isTeamSta2;
	}

	public void setIsTeamSta2(Boolean isTeamSta2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamSta2
		this.isTeamSta2 = isTeamSta2;
	}

	public Boolean getIsTeamTdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamTdno
		return isTeamTdno;
	}

	public void setIsTeamTdno(Boolean isTeamTdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamTdno
		this.isTeamTdno = isTeamTdno;
	}

	public Boolean getIsTeamCdn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamCdn
		return isTeamCdn;
	}

	public void setIsTeamCdn(Boolean isTeamCdn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamCdn
		this.isTeamCdn = isTeamCdn;
	}

	public Boolean getIsPersonCdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonCdno
		return isPersonCdno;
	}

	public void setIsPersonCdno(Boolean isPersonCdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonCdno
		this.isPersonCdno = isPersonCdno;
	}

	public Boolean getIsPersonSta1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonSta1
		return isPersonSta1;
	}

	public void setIsPersonSta1(Boolean isPersonSta1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonSta1
		this.isPersonSta1 = isPersonSta1;
	}

	public Boolean getIsPersonSta2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonSta2
		return isPersonSta2;
	}

	public void setIsPersonSta2(Boolean isPersonSta2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonSta2
		this.isPersonSta2 = isPersonSta2;
	}

	public Boolean getIsPersonTdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonTdno
		return isPersonTdno;
	}

	public void setIsPersonTdno(Boolean isPersonTdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonTdno
		this.isPersonTdno = isPersonTdno;
	}

	public Boolean getIsPersonCdn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonCdn
		return isPersonCdn;
	}

	public void setIsPersonCdn(Boolean isPersonCdn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonCdn
		this.isPersonCdn = isPersonCdn;
	}

	public PmAssign getPmAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPmAssign
		return pmAssign;
	}

	public void setPmAssign(PmAssign pmAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPmAssign
		this.pmAssign = pmAssign;
	}

	public List<IpvJobAssign> getJobAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getJobAssign
		return jobAssign;
	}

	public void setJobAssign(List<IpvJobAssign> jobAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setJobAssign
		this.jobAssign = jobAssign;
	}

	public Boolean getIsCompleteJob() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsCompleteJob
		return isCompleteJob;
	}

	public void setIsCompleteJob(Boolean isCompleteJob) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsCompleteJob
		this.isCompleteJob = isCompleteJob;
	}

	public IPFMRichComboItem getForceStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getForceStatus
		return forceStatus;
	}

	public void setForceStatus(IPFMRichComboItem forceStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setForceStatus
		this.forceStatus = forceStatus;
	}

	public String getDeleteUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDeleteUrNo
		return deleteUrNo;
	}

	public void setDeleteUrNo(String deleteUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDeleteUrNo
		this.deleteUrNo = deleteUrNo;
	}

	public String getDeleteSubUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDeleteSubUrNo
		return deleteSubUrNo;
	}

	public void setDeleteSubUrNo(String deleteSubUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDeleteSubUrNo
		this.deleteSubUrNo = deleteSubUrNo;
	}

	public String getDeleteUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDeleteUrType
		return deleteUrType;
	}

	public void setDeleteUrType(String deleteUrType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDeleteUrType
		this.deleteUrType = deleteUrType;
	}

	public String getCurrentTab() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCurrentTab
		return currentTab;
	}

	public void setCurrentTab(String currentTab) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCurrentTab
		this.currentTab = currentTab;
	}

	public List<String> getSelectedSubUr() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectedSubUr
		return selectedSubUr;
	}

	public void setSelectedSubUr(List<String> selectedSubUr) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectedSubUr
		this.selectedSubUr = selectedSubUr;
	}

	public Boolean getIsSendEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsSendEmail
		return isSendEmail;
	}

	public void setIsSendEmail(Boolean isSendEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsSendEmail
		this.isSendEmail = isSendEmail;
	}

	public List<EmailDetail> getEmailDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEmailDetail
		return emailDetail;
	}

	public void setEmailDetail(List<EmailDetail> emailDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEmailDetail
		this.emailDetail = emailDetail;
	}

	public String getRejectRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRejectRemark
		return rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRejectRemark
		this.rejectRemark = rejectRemark;
	}

	public boolean isVisibleButtonSubmit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isVisibleButtonSubmit
		return visibleButtonSubmit;
	}

	public void setVisibleButtonSubmit(boolean visibleButtonSubmit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVisibleButtonSubmit
		this.visibleButtonSubmit = visibleButtonSubmit;
	}

	public String getForceJobStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getForceJobStatus
		return forceJobStatus;
	}

	public void setForceJobStatus(String forceJobStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setForceJobStatus
		this.forceJobStatus = forceJobStatus;
	}

	public boolean isCheckImpactFw() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactFw
		return checkImpactFw;
	}

	public void setCheckImpactFw(boolean checkImpactFw) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactFw
		this.checkImpactFw = checkImpactFw;
	}

	public boolean isCheckImpactAL() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactAL
		return checkImpactAL;
	}

	public void setCheckImpactAL(boolean checkImpactAL) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactAL
		this.checkImpactAL = checkImpactAL;
	}

	public boolean isCheckImpactAT() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactAT
		return checkImpactAT;
	}

	public void setCheckImpactAT(boolean checkImpactAT) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactAT
		this.checkImpactAT = checkImpactAT;
	}

	public boolean isCheckImpactPI() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactPI
		return checkImpactPI;
	}

	public void setCheckImpactPI(boolean checkImpactPI) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactPI
		this.checkImpactPI = checkImpactPI;
	}

	public boolean isCheckImpactIG() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactIG
		return checkImpactIG;
	}

	public void setCheckImpactIG(boolean checkImpactIG) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactIG
		this.checkImpactIG = checkImpactIG;
	}

	public boolean isCheckImpactRT() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactRT
		return checkImpactRT;
	}

	public void setCheckImpactRT(boolean checkImpactRT) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactRT
		this.checkImpactRT = checkImpactRT;
	}

	public boolean isCheckImpactF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckImpactF5
		return checkImpactF5;
	}

	public void setCheckImpactF5(boolean checkImpactF5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckImpactF5
		this.checkImpactF5 = checkImpactF5;
	}

	public List<SelectItem> getNwLocationList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwLocationList
		return nwLocationList;
	}

	public void setNwLocationList(List<SelectItem> nwLocationList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwLocationList
		this.nwLocationList = nwLocationList;
	}

	public IPFMRichComboItem getLocationComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationComboItem
		return locationComboItem;
	}

	public void setLocationComboItem(IPFMRichComboItem locationComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationComboItem
		this.locationComboItem = locationComboItem;
	}

	public String getModeReject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getModeReject
		return modeReject;
	}

	public void setModeReject(String modeReject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setModeReject
		this.modeReject = modeReject;
	}

	public int getPageScroller() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPageScroller
		return pageScroller;
	}

	public void setPageScroller(int pageScroller) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPageScroller
		this.pageScroller = pageScroller;
	}

	public FilterBean getFilterReqNWCTNP01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP01
		return filterReqNWCTNP01;
	}

	public void setFilterReqNWCTNP01(FilterBean filterReqNWCTNP01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP01
		this.filterReqNWCTNP01 = filterReqNWCTNP01;
	}

	public FilterBean getFilterReqNWCTNP02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP02
		return filterReqNWCTNP02;
	}

	public void setFilterReqNWCTNP02(FilterBean filterReqNWCTNP02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP02
		this.filterReqNWCTNP02 = filterReqNWCTNP02;
	}

	public FilterBean getFilterReqNWCTNP03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP03
		return filterReqNWCTNP03;
	}

	public void setFilterReqNWCTNP03(FilterBean filterReqNWCTNP03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP03
		this.filterReqNWCTNP03 = filterReqNWCTNP03;
	}

	public FilterBean getFilterReqNWCTNP04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP04
		return filterReqNWCTNP04;
	}

	public void setFilterReqNWCTNP04(FilterBean filterReqNWCTNP04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP04
		this.filterReqNWCTNP04 = filterReqNWCTNP04;
	}

	public FilterBean getFilterReqNWCTNP05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP05
		return filterReqNWCTNP05;
	}

	public void setFilterReqNWCTNP05(FilterBean filterReqNWCTNP05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP05
		this.filterReqNWCTNP05 = filterReqNWCTNP05;
	}

	public FilterBean getFilterReqNWCTNP06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP06
		return filterReqNWCTNP06;
	}

	public void setFilterReqNWCTNP06(FilterBean filterReqNWCTNP06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP06
		this.filterReqNWCTNP06 = filterReqNWCTNP06;
	}

	public FilterBean getFilterReqNWCTNP07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCTNP07
		return filterReqNWCTNP07;
	}

	public void setFilterReqNWCTNP07(FilterBean filterReqNWCTNP07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCTNP07
		this.filterReqNWCTNP07 = filterReqNWCTNP07;
	}

	public FilterBean getFilterReqNWCFW01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW01
		return filterReqNWCFW01;
	}

	public void setFilterReqNWCFW01(FilterBean filterReqNWCFW01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW01
		this.filterReqNWCFW01 = filterReqNWCFW01;
	}

	public FilterBean getFilterReqNWCFW02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW02
		return filterReqNWCFW02;
	}

	public void setFilterReqNWCFW02(FilterBean filterReqNWCFW02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW02
		this.filterReqNWCFW02 = filterReqNWCFW02;
	}

	public FilterBean getFilterReqNWCFW03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW03
		return filterReqNWCFW03;
	}

	public void setFilterReqNWCFW03(FilterBean filterReqNWCFW03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW03
		this.filterReqNWCFW03 = filterReqNWCFW03;
	}

	public FilterBean getFilterReqNWCFW04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW04
		return filterReqNWCFW04;
	}

	public void setFilterReqNWCFW04(FilterBean filterReqNWCFW04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW04
		this.filterReqNWCFW04 = filterReqNWCFW04;
	}

	public FilterBean getFilterReqNWCFW05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW05
		return filterReqNWCFW05;
	}

	public void setFilterReqNWCFW05(FilterBean filterReqNWCFW05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW05
		this.filterReqNWCFW05 = filterReqNWCFW05;
	}

	public FilterBean getFilterReqNWCFW06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW06
		return filterReqNWCFW06;
	}

	public void setFilterReqNWCFW06(FilterBean filterReqNWCFW06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW06
		this.filterReqNWCFW06 = filterReqNWCFW06;
	}

	public FilterBean getFilterReqNWCFW07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCFW07
		return filterReqNWCFW07;
	}

	public void setFilterReqNWCFW07(FilterBean filterReqNWCFW07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCFW07
		this.filterReqNWCFW07 = filterReqNWCFW07;
	}

	public FilterBean getFilterReqNWCAL01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL01
		return filterReqNWCAL01;
	}

	public void setFilterReqNWCAL01(FilterBean filterReqNWCAL01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL01
		this.filterReqNWCAL01 = filterReqNWCAL01;
	}

	public FilterBean getFilterReqNWCAL02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL02
		return filterReqNWCAL02;
	}

	public void setFilterReqNWCAL02(FilterBean filterReqNWCAL02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL02
		this.filterReqNWCAL02 = filterReqNWCAL02;
	}

	public FilterBean getFilterReqNWCAL03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL03
		return filterReqNWCAL03;
	}

	public void setFilterReqNWCAL03(FilterBean filterReqNWCAL03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL03
		this.filterReqNWCAL03 = filterReqNWCAL03;
	}

	public FilterBean getFilterReqNWCAL04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL04
		return filterReqNWCAL04;
	}

	public void setFilterReqNWCAL04(FilterBean filterReqNWCAL04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL04
		this.filterReqNWCAL04 = filterReqNWCAL04;
	}

	public FilterBean getFilterReqNWCAL05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL05
		return filterReqNWCAL05;
	}

	public void setFilterReqNWCAL05(FilterBean filterReqNWCAL05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL05
		this.filterReqNWCAL05 = filterReqNWCAL05;
	}

	public FilterBean getFilterReqNWCAL06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL06
		return filterReqNWCAL06;
	}

	public void setFilterReqNWCAL06(FilterBean filterReqNWCAL06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL06
		this.filterReqNWCAL06 = filterReqNWCAL06;
	}

	public FilterBean getFilterReqNWCAL07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCAL07
		return filterReqNWCAL07;
	}

	public void setFilterReqNWCAL07(FilterBean filterReqNWCAL07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCAL07
		this.filterReqNWCAL07 = filterReqNWCAL07;
	}

	public FilterBean getFilterReqNWCF501() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF501
		return filterReqNWCF501;
	}

	public void setFilterReqNWCF501(FilterBean filterReqNWCF501) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF501
		this.filterReqNWCF501 = filterReqNWCF501;
	}

	public FilterBean getFilterReqNWCF502() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF502
		return filterReqNWCF502;
	}

	public void setFilterReqNWCF502(FilterBean filterReqNWCF502) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF502
		this.filterReqNWCF502 = filterReqNWCF502;
	}

	public FilterBean getFilterReqNWCF503() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF503
		return filterReqNWCF503;
	}

	public void setFilterReqNWCF503(FilterBean filterReqNWCF503) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF503
		this.filterReqNWCF503 = filterReqNWCF503;
	}

	public FilterBean getFilterReqNWCF504() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF504
		return filterReqNWCF504;
	}

	public void setFilterReqNWCF504(FilterBean filterReqNWCF504) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF504
		this.filterReqNWCF504 = filterReqNWCF504;
	}

	public FilterBean getFilterReqNWCF505() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF505
		return filterReqNWCF505;
	}

	public void setFilterReqNWCF505(FilterBean filterReqNWCF505) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF505
		this.filterReqNWCF505 = filterReqNWCF505;
	}

	public FilterBean getFilterReqNWCF506() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF506
		return filterReqNWCF506;
	}

	public void setFilterReqNWCF506(FilterBean filterReqNWCF506) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF506
		this.filterReqNWCF506 = filterReqNWCF506;
	}

	public FilterBean getFilterReqNWCF507() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCF507
		return filterReqNWCF507;
	}

	public void setFilterReqNWCF507(FilterBean filterReqNWCF507) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCF507
		this.filterReqNWCF507 = filterReqNWCF507;
	}

	public FilterBean getFilterReqNWCGW01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW01
		return filterReqNWCGW01;
	}

	public void setFilterReqNWCGW01(FilterBean filterReqNWCGW01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW01
		this.filterReqNWCGW01 = filterReqNWCGW01;
	}

	public FilterBean getFilterReqNWCGW02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW02
		return filterReqNWCGW02;
	}

	public void setFilterReqNWCGW02(FilterBean filterReqNWCGW02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW02
		this.filterReqNWCGW02 = filterReqNWCGW02;
	}

	public FilterBean getFilterReqNWCGW03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW03
		return filterReqNWCGW03;
	}

	public void setFilterReqNWCGW03(FilterBean filterReqNWCGW03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW03
		this.filterReqNWCGW03 = filterReqNWCGW03;
	}

	public FilterBean getFilterReqNWCGW04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW04
		return filterReqNWCGW04;
	}

	public void setFilterReqNWCGW04(FilterBean filterReqNWCGW04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW04
		this.filterReqNWCGW04 = filterReqNWCGW04;
	}

	public FilterBean getFilterReqNWCGW05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW05
		return filterReqNWCGW05;
	}

	public void setFilterReqNWCGW05(FilterBean filterReqNWCGW05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW05
		this.filterReqNWCGW05 = filterReqNWCGW05;
	}

	public FilterBean getFilterReqNWCGW06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW06
		return filterReqNWCGW06;
	}

	public void setFilterReqNWCGW06(FilterBean filterReqNWCGW06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW06
		this.filterReqNWCGW06 = filterReqNWCGW06;
	}

	public FilterBean getFilterReqNWCGW07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCGW07
		return filterReqNWCGW07;
	}

	public void setFilterReqNWCGW07(FilterBean filterReqNWCGW07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCGW07
		this.filterReqNWCGW07 = filterReqNWCGW07;
	}

	public FilterBean getFilterReqNWCRO01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO01
		return filterReqNWCRO01;
	}

	public void setFilterReqNWCRO01(FilterBean filterReqNWCRO01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO01
		this.filterReqNWCRO01 = filterReqNWCRO01;
	}

	public FilterBean getFilterReqNWCRO02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO02
		return filterReqNWCRO02;
	}

	public void setFilterReqNWCRO02(FilterBean filterReqNWCRO02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO02
		this.filterReqNWCRO02 = filterReqNWCRO02;
	}

	public FilterBean getFilterReqNWCRO03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO03
		return filterReqNWCRO03;
	}

	public void setFilterReqNWCRO03(FilterBean filterReqNWCRO03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO03
		this.filterReqNWCRO03 = filterReqNWCRO03;
	}

	public FilterBean getFilterReqNWCRO04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO04
		return filterReqNWCRO04;
	}

	public void setFilterReqNWCRO04(FilterBean filterReqNWCRO04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO04
		this.filterReqNWCRO04 = filterReqNWCRO04;
	}

	public FilterBean getFilterReqNWCRO05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO05
		return filterReqNWCRO05;
	}

	public void setFilterReqNWCRO05(FilterBean filterReqNWCRO05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO05
		this.filterReqNWCRO05 = filterReqNWCRO05;
	}

	public FilterBean getFilterReqNWCRO06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO06
		return filterReqNWCRO06;
	}

	public void setFilterReqNWCRO06(FilterBean filterReqNWCRO06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO06
		this.filterReqNWCRO06 = filterReqNWCRO06;
	}

	public FilterBean getFilterReqNWCRO07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCRO07
		return filterReqNWCRO07;
	}

	public void setFilterReqNWCRO07(FilterBean filterReqNWCRO07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCRO07
		this.filterReqNWCRO07 = filterReqNWCRO07;
	}

	public FilterBean getFilterTablAccess() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTablAccess
		return filterTablAccess;
	}

	public void setFilterTablAccess(FilterBean filterTablAccess) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTablAccess
		this.filterTablAccess = filterTablAccess;
	}

	public FilterBean getFilterTablAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTablAssign
		return filterTablAssign;
	}

	public void setFilterTablAssign(FilterBean filterTablAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTablAssign
		this.filterTablAssign = filterTablAssign;
	}

	public FilterBean getFilterTablView() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTablView
		return filterTablView;
	}

	public void setFilterTablView(FilterBean filterTablView) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTablView
		this.filterTablView = filterTablView;
	}

	public FilterBean getFilterReqNWCPopupAL() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupAL
		return filterReqNWCPopupAL;
	}

	public void setFilterReqNWCPopupAL(FilterBean filterReqNWCPopupAL) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupAL
		this.filterReqNWCPopupAL = filterReqNWCPopupAL;
	}

	public FilterBean getFilterReqNWCPopupTNP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupTNP
		return filterReqNWCPopupTNP;
	}

	public void setFilterReqNWCPopupTNP(FilterBean filterReqNWCPopupTNP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupTNP
		this.filterReqNWCPopupTNP = filterReqNWCPopupTNP;
	}

	public FilterBean getFilterReqNWCPopupAS() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupAS
		return filterReqNWCPopupAS;
	}

	public void setFilterReqNWCPopupAS(FilterBean filterReqNWCPopupAS) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupAS
		this.filterReqNWCPopupAS = filterReqNWCPopupAS;
	}

	public FilterBean getFilterReqNWCPopupF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupF5
		return filterReqNWCPopupF5;
	}

	public void setFilterReqNWCPopupF5(FilterBean filterReqNWCPopupF5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupF5
		this.filterReqNWCPopupF5 = filterReqNWCPopupF5;
	}

	public FilterBean getFilterReqNWCPopupFW() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupFW
		return filterReqNWCPopupFW;
	}

	public void setFilterReqNWCPopupFW(FilterBean filterReqNWCPopupFW) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupFW
		this.filterReqNWCPopupFW = filterReqNWCPopupFW;
	}

	public FilterBean getFilterReqNWCPopupGW() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupGW
		return filterReqNWCPopupGW;
	}

	public void setFilterReqNWCPopupGW(FilterBean filterReqNWCPopupGW) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupGW
		this.filterReqNWCPopupGW = filterReqNWCPopupGW;
	}

	public FilterBean getFilterReqNWCPopupPI() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupPI
		return filterReqNWCPopupPI;
	}

	public void setFilterReqNWCPopupPI(FilterBean filterReqNWCPopupPI) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupPI
		this.filterReqNWCPopupPI = filterReqNWCPopupPI;
	}

	public FilterBean getFilterReqNWCPopupRO() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPopupRO
		return filterReqNWCPopupRO;
	}

	public void setFilterReqNWCPopupRO(FilterBean filterReqNWCPopupRO) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPopupRO
		this.filterReqNWCPopupRO = filterReqNWCPopupRO;
	}


	public FilterBean getFilterReqNWCPI01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI01
		return filterReqNWCPI01;
	}

	public void setFilterReqNWCPI01(FilterBean filterReqNWCPI01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI01
		this.filterReqNWCPI01 = filterReqNWCPI01;
	}

	public FilterBean getFilterReqNWCPI02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI02
		return filterReqNWCPI02;
	}

	public void setFilterReqNWCPI02(FilterBean filterReqNWCPI02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI02
		this.filterReqNWCPI02 = filterReqNWCPI02;
	}

	public FilterBean getFilterReqNWCPI03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI03
		return filterReqNWCPI03;
	}

	public void setFilterReqNWCPI03(FilterBean filterReqNWCPI03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI03
		this.filterReqNWCPI03 = filterReqNWCPI03;
	}

	public FilterBean getFilterReqNWCPI04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI04
		return filterReqNWCPI04;
	}

	public void setFilterReqNWCPI04(FilterBean filterReqNWCPI04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI04
		this.filterReqNWCPI04 = filterReqNWCPI04;
	}

	public FilterBean getFilterReqNWCPI05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI05
		return filterReqNWCPI05;
	}

	public void setFilterReqNWCPI05(FilterBean filterReqNWCPI05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI05
		this.filterReqNWCPI05 = filterReqNWCPI05;
	}

	public FilterBean getFilterReqNWCPI06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI06
		return filterReqNWCPI06;
	}

	public void setFilterReqNWCPI06(FilterBean filterReqNWCPI06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI06
		this.filterReqNWCPI06 = filterReqNWCPI06;
	}

	public FilterBean getFilterReqNWCPI07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterReqNWCPI07
		return filterReqNWCPI07;
	}

	public void setFilterReqNWCPI07(FilterBean filterReqNWCPI07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterReqNWCPI07
		this.filterReqNWCPI07 = filterReqNWCPI07;
	}

	public String getIpType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpType
		return ipType;
	}

	public void setIpType(String ipType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpType
		this.ipType = ipType;
	}

	public List<IpSubUrAttachmentDto> getListSubAttach() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListSubAttach
		return listSubAttach;
	}

	public void setListSubAttach(List<IpSubUrAttachmentDto> listSubAttach) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListSubAttach
		this.listSubAttach = listSubAttach;
	}

	public PmAssign getPmDelegate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPmDelegate
		return pmDelegate;
	}

	public void setPmDelegate(PmAssign pmDelegate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPmDelegate
		this.pmDelegate = pmDelegate;
	}

	public List<SelectItem> getTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamList
		return teamList;
	}

	public void setTeamList(List<SelectItem> teamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamList
		this.teamList = teamList;
	}

	public String getDelegateTeamSelect() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDelegateTeamSelect
		return delegateTeamSelect;
	}

	public void setDelegateTeamSelect(String delegateTeamSelect) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDelegateTeamSelect
		this.delegateTeamSelect = delegateTeamSelect;
	}

	public List<SelectItem> getListdgp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getListdgp
		return listdgp;
	}

	public void setListdgp(List<SelectItem> listdgp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setListdgp
		this.listdgp = listdgp;
	}

	public List<String> getSelectedDelegatePerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectedDelegatePerson
		return selectedDelegatePerson;
	}

	public void setSelectedDelegatePerson(List<String> selectedDelegatePerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectedDelegatePerson
		this.selectedDelegatePerson = selectedDelegatePerson;
	}

	
	
	
}
