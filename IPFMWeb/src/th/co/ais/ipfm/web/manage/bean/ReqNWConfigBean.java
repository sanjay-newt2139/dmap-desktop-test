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
 
	public String getKey() {
		return new String(Base64.encodeBase64("NC2010-000120".getBytes()));
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLinkUrl() {
		return "view.jsf";
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public List<SelectItem> getListManager() {
		return listManager;
	}

	public void setListManager(List<SelectItem> listManager) {
		this.listManager = listManager;
	}

	public IpUser getUser() {
		return user;
	}

	public void setUser(IpUser user) {
		this.user = user;
	}

	public Boolean getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(Boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getDetailViewName() {
		return detailViewName;
	}

	public void setDetailViewName(String detailViewName) {
		this.detailViewName = detailViewName;
	}

	public Boolean getHideAddButton() {
		return hideAddButton;
	}

	public void setHideAddButton(Boolean hideAddButton) {
		this.hideAddButton = hideAddButton;
	}

	public Boolean getFirewallCheck() {
		return firewallCheck;
	}

	public void setFirewallCheck(Boolean firewallCheck) {
		this.firewallCheck = firewallCheck;
	}

	public List<IpUrFirewall> getListFirewall() {
		return listFirewall;
	}

	public void setListFirewall(List<IpUrFirewall> listFirewall) {
		this.listFirewall = listFirewall;
	}

	public Boolean getAccessListCheck() {
		return accessListCheck;
	}

	public void setAccessListCheck(Boolean accessListCheck) {
		this.accessListCheck = accessListCheck;
	}

	public Boolean getAccessTNPCheck() {
		return accessTNPCheck;
	}

	public void setAccessTNPCheck(Boolean accessTNPCheck) {
		this.accessTNPCheck = accessTNPCheck;
	}

	public Boolean getPhysicalCheck() {
		return physicalCheck;
	}

	public void setPhysicalCheck(Boolean physicalCheck) {
		this.physicalCheck = physicalCheck;
	}

	public Boolean getGatewayCheck() {
		return gatewayCheck;
	}

	public void setGatewayCheck(Boolean gatewayCheck) {
		this.gatewayCheck = gatewayCheck;
	}

	public Boolean getRoutingCheck() {
		return routingCheck;
	}

	public void setRoutingCheck(Boolean routingCheck) {
		this.routingCheck = routingCheck;
	}

	public Boolean getF5Check() {
		return f5Check;
	}

	public void setF5Check(Boolean f5Check) {
		this.f5Check = f5Check;
	}

	public List<IpUrAccessListCdn> getListAccessList() {
		return listAccessList;
	}

	public void setListAccessList(List<IpUrAccessListCdn> listAccessList) {
		this.listAccessList = listAccessList;
	}

	public List<IpUrAccessListTnp> getListAccessTNP() {
		return listAccessTNP;
	}

	public void setListAccessTNP(List<IpUrAccessListTnp> listAccessTNP) {
		this.listAccessTNP = listAccessTNP;
	}

	public List<IpUrPhysicalInterface> getListPhysicalInterface() {
		return listPhysicalInterface;
	}

	public void setListPhysicalInterface(
			List<IpUrPhysicalInterface> listPhysicalInterface) {
		this.listPhysicalInterface = listPhysicalInterface;
	}

	public List<IpUrInterfaceGateway> getListGateway() {
		return listGateway;
	}

	public void setListGateway(List<IpUrInterfaceGateway> listGateway) {
		this.listGateway = listGateway;
	}

	public List<IpUrRouting> getListRouting() {
		return listRouting;
	}

	public void setListRouting(List<IpUrRouting> listRouting) {
		this.listRouting = listRouting;
	}

	public List<IpUrF5> getListF5() {
		return listF5;
	}

	public void setListF5(List<IpUrF5> listF5) {
		this.listF5 = listF5;
	}

	public Boolean getShowDetail() {
		return showDetail;
	}

	public void setShowDetail(Boolean showDetail) {
		this.showDetail = showDetail;
	}

	public List<NCAssign> getListAssign() {
		return listAssign;
	}

	public void setListAssign(List<NCAssign> listAssign) {
		this.listAssign = listAssign;
	}

	public NCData getViewResult() {
		return viewResult;
	}

	public void setViewResult(NCData viewResult) {
		this.viewResult = viewResult;
	}

	public IPFirewallBean getFirewall() {
		return firewall;
	}

	public void setFirewall(IPFirewallBean firewall) {
		this.firewall = firewall;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getIsPeroiod() {
		return isPeroiod;
	}

	public void setIsPeroiod(String isPeroiod) {
		this.isPeroiod = isPeroiod;
	}

	public String getRequestFor() {
		return requestFor;
	}

	public void setRequestFor(String requestFor) {
		this.requestFor = requestFor;
	}

	public Date getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HtmlModalPanel getErrorPanel() {
		return errorPanel;
	}

	public void setErrorPanel(HtmlModalPanel errorPanel) {
		this.errorPanel = errorPanel;
	}

	public Boolean getInsertF5Mode() {
		return InsertF5Mode;
	}

	public void setInsertF5Mode(Boolean insertF5Mode) {
		InsertF5Mode = insertF5Mode;
	}

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getIsAttach() {
		return isAttach;
	}

	public void setIsAttach(String isAttach) {
		this.isAttach = isAttach;
	}

	public IPAccessListBean getAccessList() {
		return accessList;
	}

	public void setAccessList(IPAccessListBean accessList) {
		this.accessList = accessList;
	}

	public IPAccessListTNPBean getAccessListTNP() {
		return accessListTNP;
	}

	public void setAccessListTNP(IPAccessListTNPBean accessListTNP) {
		this.accessListTNP = accessListTNP;
	}

	public IPPhyInterfaceBean getPhyInterface() {
		return phyInterface;
	}

	public void setPhyInterface(IPPhyInterfaceBean phyInterface) {
		this.phyInterface = phyInterface;
	}

	public IPIntfGatewayBean getGateway() {
		return gateway;
	}

	public void setGateway(IPIntfGatewayBean gateway) {
		this.gateway = gateway;
	}

	public IPRoutingBean getRouting() {
		return routing;
	}

	public void setRouting(IPRoutingBean routing) {
		this.routing = routing;
	}

	public IPF5Bean getF5() {
		return f5;
	}

	public void setF5(IPF5Bean f5) {
		this.f5 = f5;
	}

	public IpUrF5 getEditUrF5() {
		return editUrF5;
	}

	public void setEditUrF5(IpUrF5 editUrF5) {
		this.editUrF5 = editUrF5;
	}

	public String getUrStatusDesc() {
		return urStatusDesc;
	}

	public void setUrStatusDesc(String urStatusDesc) {
		this.urStatusDesc = urStatusDesc;
	}

	public List<IpUrAttachment> getListAttach() {
		return listAttach;
	}

	public void setListAttach(List<IpUrAttachment> listAttach) {
		this.listAttach = listAttach;
	}

	public List<String> getSelectedManager() {
		return selectedManager;
	}

	public void setSelectedManager(List<String> selectedManager) {
		this.selectedManager = selectedManager;
	}

	public IpUrNwConfig getNetworkConfig() {
		return networkConfig;
	}

	public void setNetworkConfig(IpUrNwConfig networkConfig) {
		this.networkConfig = networkConfig;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMgrRemark() {
		return mgrRemark;
	}

	public void setMgrRemark(String mgrRemark) {
		this.mgrRemark = mgrRemark;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public List<MsgUploadError> getValidateResult() {
		return validateResult;
	}

	public void setValidateResult(List<MsgUploadError> validateResult) {
		this.validateResult = validateResult;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSelectSubUR() {
		return selectSubUR;
	}

	public void setSelectSubUR(String selectSubUR) {
		this.selectSubUR = selectSubUR;
	}

	public Boolean getConfFlag() {
		return confFlag;
	}

	public void setConfFlag(Boolean confFlag) {
		this.confFlag = confFlag;
	}

	public String getDelegateTeamID() {
		return delegateTeamID;
	}

	public void setDelegateTeamID(String delegateTeamID) {
		this.delegateTeamID = delegateTeamID;
	}

	public List<SelectItem> getListPerson() {
		return listPerson;
	}

	public void setListPerson(List<SelectItem> listPerson) {
		this.listPerson = listPerson;
	}

	public List<String> getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(List<String> selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public Boolean getByPerson() {
		return byPerson;
	}

	public void setByPerson(Boolean byPerson) {
		this.byPerson = byPerson;
	}

	public Boolean getIsTnp() {
		return isTnp;
	}

	public void setIsTnp(Boolean isTnp) {
		this.isTnp = isTnp;
	}

	public String getAssignForTeam() {
		return assignForTeam;
	}

	public void setAssignForTeam(String assignForTeam) {
		this.assignForTeam = assignForTeam;
	}

	public String getAssignForPerson() {
		return assignForPerson;
	}

	public void setAssignForPerson(String assignForPernon) {
		this.assignForPerson = assignForPernon;
	}

	public Boolean getIsTeamCdno() {
		return isTeamCdno;
	}

	public void setIsTeamCdno(Boolean isTeamCdno) {
		this.isTeamCdno = isTeamCdno;
	}

	public Boolean getIsTeamSta1() {
		return isTeamSta1;
	}

	public void setIsTeamSta1(Boolean isTeamSta1) {
		this.isTeamSta1 = isTeamSta1;
	}

	public Boolean getIsTeamSta2() {
		return isTeamSta2;
	}

	public void setIsTeamSta2(Boolean isTeamSta2) {
		this.isTeamSta2 = isTeamSta2;
	}

	public Boolean getIsTeamTdno() {
		return isTeamTdno;
	}

	public void setIsTeamTdno(Boolean isTeamTdno) {
		this.isTeamTdno = isTeamTdno;
	}

	public Boolean getIsTeamCdn() {
		return isTeamCdn;
	}

	public void setIsTeamCdn(Boolean isTeamCdn) {
		this.isTeamCdn = isTeamCdn;
	}

	public Boolean getIsPersonCdno() {
		return isPersonCdno;
	}

	public void setIsPersonCdno(Boolean isPersonCdno) {
		this.isPersonCdno = isPersonCdno;
	}

	public Boolean getIsPersonSta1() {
		return isPersonSta1;
	}

	public void setIsPersonSta1(Boolean isPersonSta1) {
		this.isPersonSta1 = isPersonSta1;
	}

	public Boolean getIsPersonSta2() {
		return isPersonSta2;
	}

	public void setIsPersonSta2(Boolean isPersonSta2) {
		this.isPersonSta2 = isPersonSta2;
	}

	public Boolean getIsPersonTdno() {
		return isPersonTdno;
	}

	public void setIsPersonTdno(Boolean isPersonTdno) {
		this.isPersonTdno = isPersonTdno;
	}

	public Boolean getIsPersonCdn() {
		return isPersonCdn;
	}

	public void setIsPersonCdn(Boolean isPersonCdn) {
		this.isPersonCdn = isPersonCdn;
	}

	public PmAssign getPmAssign() {
		return pmAssign;
	}

	public void setPmAssign(PmAssign pmAssign) {
		this.pmAssign = pmAssign;
	}

	public List<IpvJobAssign> getJobAssign() {
		return jobAssign;
	}

	public void setJobAssign(List<IpvJobAssign> jobAssign) {
		this.jobAssign = jobAssign;
	}

	public Boolean getIsCompleteJob() {
		return isCompleteJob;
	}

	public void setIsCompleteJob(Boolean isCompleteJob) {
		this.isCompleteJob = isCompleteJob;
	}

	public IPFMRichComboItem getForceStatus() {
		return forceStatus;
	}

	public void setForceStatus(IPFMRichComboItem forceStatus) {
		this.forceStatus = forceStatus;
	}

	public String getDeleteUrNo() {
		return deleteUrNo;
	}

	public void setDeleteUrNo(String deleteUrNo) {
		this.deleteUrNo = deleteUrNo;
	}

	public String getDeleteSubUrNo() {
		return deleteSubUrNo;
	}

	public void setDeleteSubUrNo(String deleteSubUrNo) {
		this.deleteSubUrNo = deleteSubUrNo;
	}

	public String getDeleteUrType() {
		return deleteUrType;
	}

	public void setDeleteUrType(String deleteUrType) {
		this.deleteUrType = deleteUrType;
	}

	public String getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(String currentTab) {
		this.currentTab = currentTab;
	}

	public List<String> getSelectedSubUr() {
		return selectedSubUr;
	}

	public void setSelectedSubUr(List<String> selectedSubUr) {
		this.selectedSubUr = selectedSubUr;
	}

	public Boolean getIsSendEmail() {
		return isSendEmail;
	}

	public void setIsSendEmail(Boolean isSendEmail) {
		this.isSendEmail = isSendEmail;
	}

	public List<EmailDetail> getEmailDetail() {
		return emailDetail;
	}

	public void setEmailDetail(List<EmailDetail> emailDetail) {
		this.emailDetail = emailDetail;
	}

	public String getRejectRemark() {
		return rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	public boolean isVisibleButtonSubmit() {
		return visibleButtonSubmit;
	}

	public void setVisibleButtonSubmit(boolean visibleButtonSubmit) {
		this.visibleButtonSubmit = visibleButtonSubmit;
	}

	public String getForceJobStatus() {
		return forceJobStatus;
	}

	public void setForceJobStatus(String forceJobStatus) {
		this.forceJobStatus = forceJobStatus;
	}

	public boolean isCheckImpactFw() {
		return checkImpactFw;
	}

	public void setCheckImpactFw(boolean checkImpactFw) {
		this.checkImpactFw = checkImpactFw;
	}

	public boolean isCheckImpactAL() {
		return checkImpactAL;
	}

	public void setCheckImpactAL(boolean checkImpactAL) {
		this.checkImpactAL = checkImpactAL;
	}

	public boolean isCheckImpactAT() {
		return checkImpactAT;
	}

	public void setCheckImpactAT(boolean checkImpactAT) {
		this.checkImpactAT = checkImpactAT;
	}

	public boolean isCheckImpactPI() {
		return checkImpactPI;
	}

	public void setCheckImpactPI(boolean checkImpactPI) {
		this.checkImpactPI = checkImpactPI;
	}

	public boolean isCheckImpactIG() {
		return checkImpactIG;
	}

	public void setCheckImpactIG(boolean checkImpactIG) {
		this.checkImpactIG = checkImpactIG;
	}

	public boolean isCheckImpactRT() {
		return checkImpactRT;
	}

	public void setCheckImpactRT(boolean checkImpactRT) {
		this.checkImpactRT = checkImpactRT;
	}

	public boolean isCheckImpactF5() {
		return checkImpactF5;
	}

	public void setCheckImpactF5(boolean checkImpactF5) {
		this.checkImpactF5 = checkImpactF5;
	}

	public List<SelectItem> getNwLocationList() {
		return nwLocationList;
	}

	public void setNwLocationList(List<SelectItem> nwLocationList) {
		this.nwLocationList = nwLocationList;
	}

	public IPFMRichComboItem getLocationComboItem() {
		return locationComboItem;
	}

	public void setLocationComboItem(IPFMRichComboItem locationComboItem) {
		this.locationComboItem = locationComboItem;
	}

	public String getModeReject() {
		return modeReject;
	}

	public void setModeReject(String modeReject) {
		this.modeReject = modeReject;
	}

	public int getPageScroller() {
		return pageScroller;
	}

	public void setPageScroller(int pageScroller) {
		this.pageScroller = pageScroller;
	}

	public FilterBean getFilterReqNWCTNP01() {
		return filterReqNWCTNP01;
	}

	public void setFilterReqNWCTNP01(FilterBean filterReqNWCTNP01) {
		this.filterReqNWCTNP01 = filterReqNWCTNP01;
	}

	public FilterBean getFilterReqNWCTNP02() {
		return filterReqNWCTNP02;
	}

	public void setFilterReqNWCTNP02(FilterBean filterReqNWCTNP02) {
		this.filterReqNWCTNP02 = filterReqNWCTNP02;
	}

	public FilterBean getFilterReqNWCTNP03() {
		return filterReqNWCTNP03;
	}

	public void setFilterReqNWCTNP03(FilterBean filterReqNWCTNP03) {
		this.filterReqNWCTNP03 = filterReqNWCTNP03;
	}

	public FilterBean getFilterReqNWCTNP04() {
		return filterReqNWCTNP04;
	}

	public void setFilterReqNWCTNP04(FilterBean filterReqNWCTNP04) {
		this.filterReqNWCTNP04 = filterReqNWCTNP04;
	}

	public FilterBean getFilterReqNWCTNP05() {
		return filterReqNWCTNP05;
	}

	public void setFilterReqNWCTNP05(FilterBean filterReqNWCTNP05) {
		this.filterReqNWCTNP05 = filterReqNWCTNP05;
	}

	public FilterBean getFilterReqNWCTNP06() {
		return filterReqNWCTNP06;
	}

	public void setFilterReqNWCTNP06(FilterBean filterReqNWCTNP06) {
		this.filterReqNWCTNP06 = filterReqNWCTNP06;
	}

	public FilterBean getFilterReqNWCTNP07() {
		return filterReqNWCTNP07;
	}

	public void setFilterReqNWCTNP07(FilterBean filterReqNWCTNP07) {
		this.filterReqNWCTNP07 = filterReqNWCTNP07;
	}

	public FilterBean getFilterReqNWCFW01() {
		return filterReqNWCFW01;
	}

	public void setFilterReqNWCFW01(FilterBean filterReqNWCFW01) {
		this.filterReqNWCFW01 = filterReqNWCFW01;
	}

	public FilterBean getFilterReqNWCFW02() {
		return filterReqNWCFW02;
	}

	public void setFilterReqNWCFW02(FilterBean filterReqNWCFW02) {
		this.filterReqNWCFW02 = filterReqNWCFW02;
	}

	public FilterBean getFilterReqNWCFW03() {
		return filterReqNWCFW03;
	}

	public void setFilterReqNWCFW03(FilterBean filterReqNWCFW03) {
		this.filterReqNWCFW03 = filterReqNWCFW03;
	}

	public FilterBean getFilterReqNWCFW04() {
		return filterReqNWCFW04;
	}

	public void setFilterReqNWCFW04(FilterBean filterReqNWCFW04) {
		this.filterReqNWCFW04 = filterReqNWCFW04;
	}

	public FilterBean getFilterReqNWCFW05() {
		return filterReqNWCFW05;
	}

	public void setFilterReqNWCFW05(FilterBean filterReqNWCFW05) {
		this.filterReqNWCFW05 = filterReqNWCFW05;
	}

	public FilterBean getFilterReqNWCFW06() {
		return filterReqNWCFW06;
	}

	public void setFilterReqNWCFW06(FilterBean filterReqNWCFW06) {
		this.filterReqNWCFW06 = filterReqNWCFW06;
	}

	public FilterBean getFilterReqNWCFW07() {
		return filterReqNWCFW07;
	}

	public void setFilterReqNWCFW07(FilterBean filterReqNWCFW07) {
		this.filterReqNWCFW07 = filterReqNWCFW07;
	}

	public FilterBean getFilterReqNWCAL01() {
		return filterReqNWCAL01;
	}

	public void setFilterReqNWCAL01(FilterBean filterReqNWCAL01) {
		this.filterReqNWCAL01 = filterReqNWCAL01;
	}

	public FilterBean getFilterReqNWCAL02() {
		return filterReqNWCAL02;
	}

	public void setFilterReqNWCAL02(FilterBean filterReqNWCAL02) {
		this.filterReqNWCAL02 = filterReqNWCAL02;
	}

	public FilterBean getFilterReqNWCAL03() {
		return filterReqNWCAL03;
	}

	public void setFilterReqNWCAL03(FilterBean filterReqNWCAL03) {
		this.filterReqNWCAL03 = filterReqNWCAL03;
	}

	public FilterBean getFilterReqNWCAL04() {
		return filterReqNWCAL04;
	}

	public void setFilterReqNWCAL04(FilterBean filterReqNWCAL04) {
		this.filterReqNWCAL04 = filterReqNWCAL04;
	}

	public FilterBean getFilterReqNWCAL05() {
		return filterReqNWCAL05;
	}

	public void setFilterReqNWCAL05(FilterBean filterReqNWCAL05) {
		this.filterReqNWCAL05 = filterReqNWCAL05;
	}

	public FilterBean getFilterReqNWCAL06() {
		return filterReqNWCAL06;
	}

	public void setFilterReqNWCAL06(FilterBean filterReqNWCAL06) {
		this.filterReqNWCAL06 = filterReqNWCAL06;
	}

	public FilterBean getFilterReqNWCAL07() {
		return filterReqNWCAL07;
	}

	public void setFilterReqNWCAL07(FilterBean filterReqNWCAL07) {
		this.filterReqNWCAL07 = filterReqNWCAL07;
	}

	public FilterBean getFilterReqNWCF501() {
		return filterReqNWCF501;
	}

	public void setFilterReqNWCF501(FilterBean filterReqNWCF501) {
		this.filterReqNWCF501 = filterReqNWCF501;
	}

	public FilterBean getFilterReqNWCF502() {
		return filterReqNWCF502;
	}

	public void setFilterReqNWCF502(FilterBean filterReqNWCF502) {
		this.filterReqNWCF502 = filterReqNWCF502;
	}

	public FilterBean getFilterReqNWCF503() {
		return filterReqNWCF503;
	}

	public void setFilterReqNWCF503(FilterBean filterReqNWCF503) {
		this.filterReqNWCF503 = filterReqNWCF503;
	}

	public FilterBean getFilterReqNWCF504() {
		return filterReqNWCF504;
	}

	public void setFilterReqNWCF504(FilterBean filterReqNWCF504) {
		this.filterReqNWCF504 = filterReqNWCF504;
	}

	public FilterBean getFilterReqNWCF505() {
		return filterReqNWCF505;
	}

	public void setFilterReqNWCF505(FilterBean filterReqNWCF505) {
		this.filterReqNWCF505 = filterReqNWCF505;
	}

	public FilterBean getFilterReqNWCF506() {
		return filterReqNWCF506;
	}

	public void setFilterReqNWCF506(FilterBean filterReqNWCF506) {
		this.filterReqNWCF506 = filterReqNWCF506;
	}

	public FilterBean getFilterReqNWCF507() {
		return filterReqNWCF507;
	}

	public void setFilterReqNWCF507(FilterBean filterReqNWCF507) {
		this.filterReqNWCF507 = filterReqNWCF507;
	}

	public FilterBean getFilterReqNWCGW01() {
		return filterReqNWCGW01;
	}

	public void setFilterReqNWCGW01(FilterBean filterReqNWCGW01) {
		this.filterReqNWCGW01 = filterReqNWCGW01;
	}

	public FilterBean getFilterReqNWCGW02() {
		return filterReqNWCGW02;
	}

	public void setFilterReqNWCGW02(FilterBean filterReqNWCGW02) {
		this.filterReqNWCGW02 = filterReqNWCGW02;
	}

	public FilterBean getFilterReqNWCGW03() {
		return filterReqNWCGW03;
	}

	public void setFilterReqNWCGW03(FilterBean filterReqNWCGW03) {
		this.filterReqNWCGW03 = filterReqNWCGW03;
	}

	public FilterBean getFilterReqNWCGW04() {
		return filterReqNWCGW04;
	}

	public void setFilterReqNWCGW04(FilterBean filterReqNWCGW04) {
		this.filterReqNWCGW04 = filterReqNWCGW04;
	}

	public FilterBean getFilterReqNWCGW05() {
		return filterReqNWCGW05;
	}

	public void setFilterReqNWCGW05(FilterBean filterReqNWCGW05) {
		this.filterReqNWCGW05 = filterReqNWCGW05;
	}

	public FilterBean getFilterReqNWCGW06() {
		return filterReqNWCGW06;
	}

	public void setFilterReqNWCGW06(FilterBean filterReqNWCGW06) {
		this.filterReqNWCGW06 = filterReqNWCGW06;
	}

	public FilterBean getFilterReqNWCGW07() {
		return filterReqNWCGW07;
	}

	public void setFilterReqNWCGW07(FilterBean filterReqNWCGW07) {
		this.filterReqNWCGW07 = filterReqNWCGW07;
	}

	public FilterBean getFilterReqNWCRO01() {
		return filterReqNWCRO01;
	}

	public void setFilterReqNWCRO01(FilterBean filterReqNWCRO01) {
		this.filterReqNWCRO01 = filterReqNWCRO01;
	}

	public FilterBean getFilterReqNWCRO02() {
		return filterReqNWCRO02;
	}

	public void setFilterReqNWCRO02(FilterBean filterReqNWCRO02) {
		this.filterReqNWCRO02 = filterReqNWCRO02;
	}

	public FilterBean getFilterReqNWCRO03() {
		return filterReqNWCRO03;
	}

	public void setFilterReqNWCRO03(FilterBean filterReqNWCRO03) {
		this.filterReqNWCRO03 = filterReqNWCRO03;
	}

	public FilterBean getFilterReqNWCRO04() {
		return filterReqNWCRO04;
	}

	public void setFilterReqNWCRO04(FilterBean filterReqNWCRO04) {
		this.filterReqNWCRO04 = filterReqNWCRO04;
	}

	public FilterBean getFilterReqNWCRO05() {
		return filterReqNWCRO05;
	}

	public void setFilterReqNWCRO05(FilterBean filterReqNWCRO05) {
		this.filterReqNWCRO05 = filterReqNWCRO05;
	}

	public FilterBean getFilterReqNWCRO06() {
		return filterReqNWCRO06;
	}

	public void setFilterReqNWCRO06(FilterBean filterReqNWCRO06) {
		this.filterReqNWCRO06 = filterReqNWCRO06;
	}

	public FilterBean getFilterReqNWCRO07() {
		return filterReqNWCRO07;
	}

	public void setFilterReqNWCRO07(FilterBean filterReqNWCRO07) {
		this.filterReqNWCRO07 = filterReqNWCRO07;
	}

	public FilterBean getFilterTablAccess() {
		return filterTablAccess;
	}

	public void setFilterTablAccess(FilterBean filterTablAccess) {
		this.filterTablAccess = filterTablAccess;
	}

	public FilterBean getFilterTablAssign() {
		return filterTablAssign;
	}

	public void setFilterTablAssign(FilterBean filterTablAssign) {
		this.filterTablAssign = filterTablAssign;
	}

	public FilterBean getFilterTablView() {
		return filterTablView;
	}

	public void setFilterTablView(FilterBean filterTablView) {
		this.filterTablView = filterTablView;
	}

	public FilterBean getFilterReqNWCPopupAL() {
		return filterReqNWCPopupAL;
	}

	public void setFilterReqNWCPopupAL(FilterBean filterReqNWCPopupAL) {
		this.filterReqNWCPopupAL = filterReqNWCPopupAL;
	}

	public FilterBean getFilterReqNWCPopupTNP() {
		return filterReqNWCPopupTNP;
	}

	public void setFilterReqNWCPopupTNP(FilterBean filterReqNWCPopupTNP) {
		this.filterReqNWCPopupTNP = filterReqNWCPopupTNP;
	}

	public FilterBean getFilterReqNWCPopupAS() {
		return filterReqNWCPopupAS;
	}

	public void setFilterReqNWCPopupAS(FilterBean filterReqNWCPopupAS) {
		this.filterReqNWCPopupAS = filterReqNWCPopupAS;
	}

	public FilterBean getFilterReqNWCPopupF5() {
		return filterReqNWCPopupF5;
	}

	public void setFilterReqNWCPopupF5(FilterBean filterReqNWCPopupF5) {
		this.filterReqNWCPopupF5 = filterReqNWCPopupF5;
	}

	public FilterBean getFilterReqNWCPopupFW() {
		return filterReqNWCPopupFW;
	}

	public void setFilterReqNWCPopupFW(FilterBean filterReqNWCPopupFW) {
		this.filterReqNWCPopupFW = filterReqNWCPopupFW;
	}

	public FilterBean getFilterReqNWCPopupGW() {
		return filterReqNWCPopupGW;
	}

	public void setFilterReqNWCPopupGW(FilterBean filterReqNWCPopupGW) {
		this.filterReqNWCPopupGW = filterReqNWCPopupGW;
	}

	public FilterBean getFilterReqNWCPopupPI() {
		return filterReqNWCPopupPI;
	}

	public void setFilterReqNWCPopupPI(FilterBean filterReqNWCPopupPI) {
		this.filterReqNWCPopupPI = filterReqNWCPopupPI;
	}

	public FilterBean getFilterReqNWCPopupRO() {
		return filterReqNWCPopupRO;
	}

	public void setFilterReqNWCPopupRO(FilterBean filterReqNWCPopupRO) {
		this.filterReqNWCPopupRO = filterReqNWCPopupRO;
	}


	public FilterBean getFilterReqNWCPI01() {
		return filterReqNWCPI01;
	}

	public void setFilterReqNWCPI01(FilterBean filterReqNWCPI01) {
		this.filterReqNWCPI01 = filterReqNWCPI01;
	}

	public FilterBean getFilterReqNWCPI02() {
		return filterReqNWCPI02;
	}

	public void setFilterReqNWCPI02(FilterBean filterReqNWCPI02) {
		this.filterReqNWCPI02 = filterReqNWCPI02;
	}

	public FilterBean getFilterReqNWCPI03() {
		return filterReqNWCPI03;
	}

	public void setFilterReqNWCPI03(FilterBean filterReqNWCPI03) {
		this.filterReqNWCPI03 = filterReqNWCPI03;
	}

	public FilterBean getFilterReqNWCPI04() {
		return filterReqNWCPI04;
	}

	public void setFilterReqNWCPI04(FilterBean filterReqNWCPI04) {
		this.filterReqNWCPI04 = filterReqNWCPI04;
	}

	public FilterBean getFilterReqNWCPI05() {
		return filterReqNWCPI05;
	}

	public void setFilterReqNWCPI05(FilterBean filterReqNWCPI05) {
		this.filterReqNWCPI05 = filterReqNWCPI05;
	}

	public FilterBean getFilterReqNWCPI06() {
		return filterReqNWCPI06;
	}

	public void setFilterReqNWCPI06(FilterBean filterReqNWCPI06) {
		this.filterReqNWCPI06 = filterReqNWCPI06;
	}

	public FilterBean getFilterReqNWCPI07() {
		return filterReqNWCPI07;
	}

	public void setFilterReqNWCPI07(FilterBean filterReqNWCPI07) {
		this.filterReqNWCPI07 = filterReqNWCPI07;
	}

	public String getIpType() {
		return ipType;
	}

	public void setIpType(String ipType) {
		this.ipType = ipType;
	}

	public List<IpSubUrAttachmentDto> getListSubAttach() {
		return listSubAttach;
	}

	public void setListSubAttach(List<IpSubUrAttachmentDto> listSubAttach) {
		this.listSubAttach = listSubAttach;
	}

	public PmAssign getPmDelegate() {
		return pmDelegate;
	}

	public void setPmDelegate(PmAssign pmDelegate) {
		this.pmDelegate = pmDelegate;
	}

	public List<SelectItem> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<SelectItem> teamList) {
		this.teamList = teamList;
	}

	public String getDelegateTeamSelect() {
		return delegateTeamSelect;
	}

	public void setDelegateTeamSelect(String delegateTeamSelect) {
		this.delegateTeamSelect = delegateTeamSelect;
	}

	public List<SelectItem> getListdgp() {
		return listdgp;
	}

	public void setListdgp(List<SelectItem> listdgp) {
		this.listdgp = listdgp;
	}

	public List<String> getSelectedDelegatePerson() {
		return selectedDelegatePerson;
	}

	public void setSelectedDelegatePerson(List<String> selectedDelegatePerson) {
		this.selectedDelegatePerson = selectedDelegatePerson;
	}

	
	
	
}
