package th.co.ais.ipfm.web.manage.action;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.richfaces.component.html.HtmlDataTable;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import th.co.ais.email.service.EMailService;
import th.co.ais.ipfm.domain.IPRole;
import th.co.ais.ipfm.domain1.EmailDetail;
import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentDto;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
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
import th.co.ais.ipfm.service.AccessListService;
import th.co.ais.ipfm.service.AccessListTNPService;
import th.co.ais.ipfm.service.F5Service;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.service.IPUserService;
import th.co.ais.ipfm.service.IntfGatewayService;
import th.co.ais.ipfm.service.IpSubUrAttachmentService;
import th.co.ais.ipfm.service.IpUrActionService;
import th.co.ais.ipfm.service.IpUrAttachmentService;
import th.co.ais.ipfm.service.PhyInterfaceService;
import th.co.ais.ipfm.service.RoutingService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPAccessListBean;
import th.co.ais.ipfm.web.manage.bean.IPAccessListTNPBean;
import th.co.ais.ipfm.web.manage.bean.IPF5Bean;
import th.co.ais.ipfm.web.manage.bean.IPFirewallBean;
import th.co.ais.ipfm.web.manage.bean.IPIntfGatewayBean;
import th.co.ais.ipfm.web.manage.bean.IPPhyInterfaceBean;
import th.co.ais.ipfm.web.manage.bean.IPRoutingBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.NetworkConfigValidate;

public class ReqNWConfigAction extends AbstractAction {

	private String urNoSearch;
	private List<SelectItem> jobStatus;
	public ReqNWConfigBean networkConfigBean;
	private boolean hasError = false;
	private String msgError = "";
	
	public ReqNWConfigBean getNetworkConfigBean() {
		System.out.println("getNetworkConfigBean getNetworkConfigBean getNetworkConfigBean");
		return (ReqNWConfigBean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("networkConfigBean", networkConfigBean);
	}

	public AttachFileAction getAttachFileAction() {
		return (AttachFileAction) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("fileAttachAction");
	}

	public void setAttachFileAction(AttachFileAction attachFileAction) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("fileAttachAction", attachFileAction);
	}

	public String init() {
		hasError = false;
		msgError = "";
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {

		try {
			String mode = (getRequestParameter("MODE") != null) ? getRequestParameter("MODE") : "";
			String urNo = (getRequestParameter("URNo") != null) ? getRequestParameter("URNo") : "";
			System.out.println("Class >> " + getClass().getName() + " goto " + programID);
			System.out.println("Class >> " + getClass().getName() + " mode " + mode);

			if (mode.equals(IPFMConstant.MODE_VIEW)) {
				viewUrNo(urNo, mode, null);
			} else if (mode.equals(IPFMConstant.ACTION_MRG_APPR)) {
				viewMgrAppr(urNo, IPFMConstant.ACTION_MRG_APPR);
			} else if (mode.equals(IPFMConstant.ACTION_OWNER_APPR)) {
				viewOwnerAppr(urNo, IPFMConstant.ACTION_OWNER_APPR);
			} else if (mode.equals(IPFMConstant.MODE_EDIT)) {
				editUrNo(urNo, IPFMConstant.MODE_EDIT);
			} else if (mode.equals(IPFMConstant.ACTION_ACTM)) {
				viewActm(urNo, IPFMConstant.STATUS_WAIT_ACTM);
			} else if (mode.equals(IPFMConstant.MODE_TEAM)) {
				viewTeam(urNo, IPFMConstant.STATUS_WAIT_TEAM);
			} else if (mode.equals(IPFMConstant.MODE_USER)) {
				viewUserVerify(urNo, IPFMConstant.MODE_USER);
			} else if (mode.equals(IPFMConstant.MODE_CALL_PM)) {
				viewPMAssign(urNo, IPFMConstant.STATUS_WAIT_PM);
			} else if (mode.equals(IPFMConstant.MODE_REJECT_TEAM)) {
				viewPMAssign(urNo, IPFMConstant.STATUS_REJECT_TEAM);
			} else
				initMode();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ReqNWConfigBean reqNetworkBean = new ReqNWConfigBean();
			// reqNetworkBean.setMode(getRequestParameter("MODE"));
			// setNetworkConfigBean(reqNetworkBean);
		}
		return programID;
	}
	
	
	private void initObject(ReqNWConfigBean reqNetworkBean){
		reqNetworkBean.setFirewall(new IPFirewallBean());
		reqNetworkBean.setAccessList(new IPAccessListBean());
		reqNetworkBean.setAccessListTNP(new IPAccessListTNPBean());
		reqNetworkBean.setPhyInterface(new IPPhyInterfaceBean());
		reqNetworkBean.setGateway(new IPIntfGatewayBean());
		reqNetworkBean.setRouting(new IPRoutingBean());
		reqNetworkBean.setF5(new IPF5Bean());
	}

	public void initMode() {
		ReqNWConfigBean reqNetworkBean = new ReqNWConfigBean();
		FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
				.getInstance().getBean("firewallService");
		UserSession userSession = IPFMWebUtil.getUserSession();

		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		reqNetworkBean.setUrNo(nwConfigService.getTempUrNO());

		IPFirewallBean firewall = new IPFirewallBean();
		List<SelectItem> select = new ArrayList<SelectItem>();
		List<IpMasterTable> service = firewallService.getService();
		System.out.println("List Size >>> " + service.size());
		for (IpMasterTable items : service) {
			SelectItem item = new SelectItem();
			item.setLabel((items.getShortDesc() != null) ? items.getShortDesc() : "");
			item.setValue(items.getId().getRefKey());
			select.add(item);
		}

		firewall.setServiveList(select);
		firewall.setSelectList(new ArrayList<String>());

		reqNetworkBean.setIsPeroiod("Y");
		reqNetworkBean.setPeriodStart(new Date());
		
		Date endDate = new Date();
		endDate.setYear(endDate.getYear() + 1);
		
		reqNetworkBean.setPeriodEnd(endDate);
		
		
		reqNetworkBean.setRequestFor("C");
		reqNetworkBean.setIsAttach("N");

		reqNetworkBean.setFirewall(firewall);
		reqNetworkBean.setAccessList(new IPAccessListBean());
		reqNetworkBean.setAccessListTNP(new IPAccessListTNPBean());
		reqNetworkBean.setPhyInterface(new IPPhyInterfaceBean());
		reqNetworkBean.setGateway(new IPIntfGatewayBean());
		reqNetworkBean.setRouting(new IPRoutingBean());
		reqNetworkBean.setF5(new IPF5Bean());

		reqNetworkBean.setErrorFlag(false);
		reqNetworkBean.setErrorMsg("");
		reqNetworkBean.setUser(userSession.getIpUser());
		
		List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
		reqNetworkBean.setNwLocationList(locatStringList);

		List<Map> managerMap = nwConfigService.ListManager(userSession
				.getIpUser());
		List<SelectItem> listManager = new ArrayList<SelectItem>();
		for (Map manager : managerMap) {
			SelectItem item = new SelectItem();
			item.setLabel((String) manager.get("value"));
			item.setValue((String) manager.get("key"));
			listManager.add(item);
		}
		reqNetworkBean.setListManager(listManager);
		reqNetworkBean.setCurrentTab("FW");
		reqNetworkBean.setSelectSubUR("FW");
		setNetworkConfigBean(reqNetworkBean);
	}

	public void editUrNo(String urNo, String mode) {
		viewUrNo(urNo, "", null);
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();

		FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
				.getInstance().getBean("firewallService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		UserSession userSession = IPFMWebUtil.getUserSession();

		IPFirewallBean firewall = new IPFirewallBean();
		List<SelectItem> select = new ArrayList<SelectItem>();
		List<IpMasterTable> service = firewallService.getService();

		for (IpMasterTable items : service) {
			SelectItem item = new SelectItem();
			item.setLabel(items.getShortDesc());
			item.setValue(items.getId().getRefKey());
			select.add(item);
		}

		firewall.setServiveList(select);
		firewall.setSelectList(new ArrayList<String>());
		reqNetworkBean.setFirewall(firewall);

		reqNetworkBean.setAccessList(new IPAccessListBean());
		reqNetworkBean.setAccessListTNP(new IPAccessListTNPBean());
		reqNetworkBean.setPhyInterface(new IPPhyInterfaceBean());
		reqNetworkBean.setGateway(new IPIntfGatewayBean());
		reqNetworkBean.setRouting(new IPRoutingBean());
		reqNetworkBean.setF5(new IPF5Bean());
		
		//Set Trunk
		if(reqNetworkBean.getListPhysicalInterface() != null && reqNetworkBean.getListPhysicalInterface().size() > 0){
			reqNetworkBean.getPhyInterface().setPiType(reqNetworkBean.getListPhysicalInterface().get(0).getPiType());
		}

		setNetworkConfigBean(reqNetworkBean);
		reqNetworkBean.setErrorFlag(false);
		reqNetworkBean.setErrorMsg("");
		reqNetworkBean.setUser(userSession.getIpUser());

		List<Map> managerMap = nwConfigService.ListManager(userSession
				.getIpUser());
		List<SelectItem> listManager = new ArrayList<SelectItem>();
		for (Map manager : managerMap) {
			SelectItem item = new SelectItem();
			item.setLabel((String) manager.get("value"));
			item.setValue((String) manager.get("key"));
			listManager.add(item);
		}
		reqNetworkBean.setListManager(listManager);
		reqNetworkBean.setMode(IPFMConstant.MODE_EDIT);
		setNetworkConfigBean(reqNetworkBean);
	}

	public void viewMgrAppr(String urNo, String mode) {
		viewUrNo(urNo, "", null);
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();
		reqNetworkBean.setMode(IPFMConstant.ACTION_MRG_APPR);
		initObject(reqNetworkBean);
		reqNetworkBean.setMgrRemark("");
		setNetworkConfigBean(reqNetworkBean);
	}

	public void viewActm(String urNo, String mode) {
		UserSession userSession = IPFMWebUtil.getUserSession();
		viewUrNo(urNo, mode, userSession.getIpUser());
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();
		reqNetworkBean.setMode(IPFMConstant.ACTION_ACTM);
		initObject(reqNetworkBean);
		clearRemark(reqNetworkBean);
		setNetworkConfigBean(reqNetworkBean);
	}

	public void viewTeam(String urNo, String mode) {
		UserSession userSession = IPFMWebUtil.getUserSession();
		viewUrNo(urNo, mode, userSession.getIpUser());
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();
		List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
		reqNetworkBean.setNwLocationList(locatStringList);
		reqNetworkBean.setMode(IPFMConstant.MODE_TEAM);
		initObject(reqNetworkBean);
		setNetworkConfigBean(reqNetworkBean);
	}

	public void viewUserVerify(String urNo, String mode) {
		viewUrNo(urNo, "", null);
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();
		List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
		reqNetworkBean.setNwLocationList(locatStringList);
		reqNetworkBean.setMode(IPFMConstant.MODE_USER);
		initObject(reqNetworkBean);
		setNetworkConfigBean(reqNetworkBean);
	}

	public void viewPMAssign(String urNo, String mode) {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		viewUrNo(urNo, mode, userSession.getIpUser());
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();
		if (mode.equalsIgnoreCase(IPFMConstant.MODE_REJECT_TEAM)) reqNetworkBean.setModeReject(mode);
		cancelImpact();
//		if (reqNetworkBean.getListFirewall()!=null && reqNetworkBean.getListFirewall().size()>0 ) {
//			for (IpUrFirewall subUr : reqNetworkBean.getListFirewall()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//		if (reqNetworkBean.getListAccessList()!=null && reqNetworkBean.getListAccessList().size()>0 ) {
//			for (IpUrAccessListCdn subUr : reqNetworkBean.getListAccessList()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//		if (reqNetworkBean.getListAccessTNP()!=null && reqNetworkBean.getListAccessTNP().size()>0 ) {
//			for (IpUrAccessListTnp subUr : reqNetworkBean.getListAccessTNP()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//		if (reqNetworkBean.getListPhysicalInterface()!=null && reqNetworkBean.getListPhysicalInterface().size()>0 ) {
//			for (IpUrPhysicalInterface subUr : reqNetworkBean.getListPhysicalInterface()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//		if (reqNetworkBean.getListGateway()!=null && reqNetworkBean.getListGateway().size()>0 ) {
//			for (IpUrInterfaceGateway subUr : reqNetworkBean.getListGateway()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//		if (reqNetworkBean.getListRouting()!=null && reqNetworkBean.getListRouting().size()>0 ) {
//			for (IpUrRouting subUr : reqNetworkBean.getListRouting()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//		if (reqNetworkBean.getListF5()!=null && reqNetworkBean.getListF5().size()>0 ) {
//			for (IpUrF5 subUr : reqNetworkBean.getListF5()) {
//				if (subUr.getIsImpact()!=null && subUr.getIsImpact().equalsIgnoreCase("Y")) {
//					subUr.setIsImpact("N");
//				}
//			}
//		}
//			try {
//			  IpUrAction	ipUrAction  = nwConfigService.findUrActionNotify(urNo, "REJECT_TEAM", userSession.getIpUser().getUserId());
//			  if(ipUrAction!=null){
//				  reqNetworkBean.setVisibleButtonSubmit(true);
//			  }
//			} catch (IPFMBusinessException e) {
//				e.printStackTrace();
//			}
		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = new ArrayList<String>();
		reqNetworkBean.setListPerson(listPerson);
		reqNetworkBean.setSelectedPerson(selectedPerson);
		reqNetworkBean.setSelectedDelegatePerson(selectedPerson);
		reqNetworkBean.setListdgp(listPerson);
		reqNetworkBean.setMode(IPFMConstant.MODE_CALL_PM);
		initObject(reqNetworkBean);
		setNetworkConfigBean(reqNetworkBean);
	}

	public void viewOwnerAppr(String urNo, String mode) {
		UserSession userSession = IPFMWebUtil.getUserSession();
		viewUrNo(urNo, "", userSession.getIpUser());
		ReqNWConfigBean reqNetworkBean = getNetworkConfigBean();
		reqNetworkBean.setMode(IPFMConstant.ACTION_OWNER_APPR);
		initObject(reqNetworkBean);
		clearRemark(reqNetworkBean);
		setNetworkConfigBean(reqNetworkBean);
	}
	
	public void clearRemark(ReqNWConfigBean reqNetworkBean){
		if (reqNetworkBean.getListAccessList()!=null && reqNetworkBean.getListAccessList().size()>0) {
			for (IpUrAccessListCdn item : reqNetworkBean.getListAccessList()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
		if (reqNetworkBean.getListAccessTNP()!=null && reqNetworkBean.getListAccessTNP().size()>0) {
			for (IpUrAccessListTnp item : reqNetworkBean.getListAccessTNP()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
		if (reqNetworkBean.getListF5()!=null && reqNetworkBean.getListF5().size()>0) {
			for (IpUrF5 item : reqNetworkBean.getListF5()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
		if (reqNetworkBean.getListFirewall()!=null && reqNetworkBean.getListFirewall().size()>0) {
			for (IpUrFirewall item : reqNetworkBean.getListFirewall()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
		if (reqNetworkBean.getListGateway()!=null && reqNetworkBean.getListGateway().size()>0) {
			for (IpUrInterfaceGateway item : reqNetworkBean.getListGateway()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
		if (reqNetworkBean.getListPhysicalInterface()!=null && reqNetworkBean.getListPhysicalInterface().size()>0) {
			for (IpUrPhysicalInterface item : reqNetworkBean.getListPhysicalInterface()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
		if (reqNetworkBean.getListRouting()!=null && reqNetworkBean.getListRouting().size()>0) {
			for (IpUrRouting item : reqNetworkBean.getListRouting()) {
				if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_OWNER_APPR)) {
					item.setSysOwnerRemark("");
				}else if (reqNetworkBean.getMode().equals(IPFMConstant.ACTION_ACTM)) {
					item.setActmRemark("");
				}
			}
		}
	}

	public void viewUrNo(String urNo, String mode, IpUser user) {
		ReqNWConfigBean reqNetworkBean = new ReqNWConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IpUrAttachmentService attachmentService = (IpUrAttachmentService) JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		IpUrNwConfig config = nwConfigService.findByUrNo(urNo);
		reqNetworkBean.setMgrRemark(config.getMrgRemark()==null?"":config.getMrgRemark());
		reqNetworkBean.setNetworkConfig(config);
		cleanSubUr(urNo);
		List<IpSubUrAttachmentDto> subAttachFile = new ArrayList<IpSubUrAttachmentDto>();
		try{
			IpSubUrAttachmentService ipSubUrAttachmentService = (IpSubUrAttachmentService) JSFServiceFinderUtil.getInstance().getBean("ipSubUrAttachmentService");
			subAttachFile = ipSubUrAttachmentService.getByUrNo(urNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		IpUser ipUser = new IpUser();
		ipUser.setUserId(config.getReqUserId());
		ipUser.setUserName(config.getReqUserName());
		ipUser.setEmail(config.getReqEmail());
		ipUser.setMobile(config.getReqMobile());
		ipUser.setTel(config.getReqTel());
		ipUser.setDept(config.getReqDept());
		ipUser.setSection(config.getReqSection());
		ipUser.setPosition(config.getReqPosition());
		ipUser.setTeamName(config.getReqTeamName());
		reqNetworkBean.setUser(ipUser);
		IpUser regUser = new IpUser();
		regUser.setUserId(config.getReqUserId());
		regUser.setUserName(config.getReqUserName());
		regUser.setEmail(config.getReqEmail());
		regUser.setMobile(config.getReqMobile());
		regUser.setTel(config.getReqTel());
		regUser.setDept(config.getReqDept());
		regUser.setSection(config.getReqSection());
		regUser.setPosition(config.getReqPosition());
		regUser.setTeamId(config.getReqTeamId());
		regUser.setTeamName(config.getReqTeamName());
		reqNetworkBean.setUser(regUser);
		reqNetworkBean.setUrNo(config.getUrNo());
		reqNetworkBean.setSubject(config.getReqSubject());
		reqNetworkBean.setObjective(config.getReqObjective());

		reqNetworkBean.setRequirement(config.getReqRequirement());
		reqNetworkBean.setIsPeroiod(config.getIsPeriod());
		if (config.getIsPeriod().equals("Y")) {
			reqNetworkBean.setPeriodStart(config.getPeriodStart());
			reqNetworkBean.setPeriodEnd(config.getPeriodEnd());
		}
		reqNetworkBean.setMgrName(config.getApproveManager());

		reqNetworkBean.setRequestFor(config.getReqFor());
		reqNetworkBean.setIsAttach(config.getIsAttach());

		List<IpUrAttachment> attachList = attachmentService
				.listFilesByUrNo(urNo);
		reqNetworkBean.setListAttach(attachList);
		reqNetworkBean.setListSubAttach(subAttachFile);
		AttachFileAction fileBean = getAttachFileAction();
		if (fileBean == null)
			fileBean = new AttachFileAction();
		fileBean.setListAttach(attachList);
		fileBean.setListSubAttach(subAttachFile);
		setAttachFileAction(fileBean);

		IpUrActionService actionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		List<IpUrAction> listAction1 = actionService.listAction(urNo, user, mode);
		if (mode.equalsIgnoreCase(IPFMConstant.MODE_VIEW)) {
			if ((listAction1==null || listAction1.size()==0)) {
				try {
					IpUrAction action = null;
					List<IpUrActionHistory> historyList = nwConfigService.findHistoryAction(reqNetworkBean.getUrNo(),"NC");
					for (IpUrActionHistory history : historyList) {
						action = new IpUrAction();
						action.setUrNo(history.getUrNo());
						action.setUrType(history.getUrType());
						action.setSubUrNo(history.getSubUrNo());
						action.setSubUrType(history.getSubUrType());
						listAction1.add(action);
					}
					if (listAction1.size()==0) {
						List<IpUrAction> draftActionList = actionService.listAction(urNo, user, "DRAFT");
						for (IpUrAction draftAction : draftActionList) {
							if (draftAction.getSubUrNo()==null || draftAction.getSubUrNo().equalsIgnoreCase("NA")) continue;
							listAction1.add(draftAction);
						}
					}
				} catch (IPFMBusinessException e) {
					e.printStackTrace();
				}
			}
		}
		List<IpUrAction> listAction = new ArrayList<IpUrAction>();
		String tmpSubUrNo = "";
		for (IpUrAction urAction : listAction1) {
			if (!urAction.getSubUrNo().equalsIgnoreCase(tmpSubUrNo)){
				tmpSubUrNo = urAction.getSubUrNo();
				listAction.add(urAction);
			}
		}
		
		List<IpUrFirewall> fwList = new ArrayList<IpUrFirewall>();
		List<IpUrAccessListCdn> alList = new ArrayList<IpUrAccessListCdn>();
		List<IpUrAccessListTnp> atList = new ArrayList<IpUrAccessListTnp>();
		List<IpUrPhysicalInterface> piList = new ArrayList<IpUrPhysicalInterface>();
		List<IpUrInterfaceGateway> igList = new ArrayList<IpUrInterfaceGateway>();
		List<IpUrRouting> rtList = new ArrayList<IpUrRouting>();
		List<IpUrF5> f5List = new ArrayList<IpUrF5>();
		int rowIndex = 0;
		
		for (IpUrAction action : listAction) {
			if (action.getSubUrType().equals("FW")) {
				FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
						.getInstance().getBean("firewallService");

				IpUrFirewall fw = firewallService.findFirewall(
						action.getUrNo(), action.getSubUrNo());
				if (fw != null)
					fwList.add(fw);
			} else if (action.getSubUrType().equals("AL")) {
				AccessListService cdnService = (AccessListService) JSFServiceFinderUtil
						.getInstance().getBean("accessListService");
				IpUrAccessListCdn al = cdnService.findAccessListCdn(action
						.getUrNo(), action.getSubUrNo());
				if (al != null)
					alList.add(al);
			} else if (action.getSubUrType().equals("AT")) {
				AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil
						.getInstance().getBean("accessListTNPService");
				IpUrAccessListTnp at = tnpService.findAccessListTnp(action
						.getUrNo(), action.getSubUrNo());
				if (at != null)
					atList.add(at);
			} else if (action.getSubUrType().equals("PI")) {
				PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil
						.getInstance().getBean("phyInterfaceService");
				IpUrPhysicalInterface pi = phyIntfService.findPhyInterface(
						action.getUrNo(), action.getSubUrNo());
				if (pi != null){
					pi.setRowIndex(rowIndex++);
					piList.add(pi);
				}
			} else if (action.getSubUrType().equals("IG")) {
				IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
						.getInstance().getBean("intfGatewayService");
				IpUrInterfaceGateway ig = intfGatewayService.findFirewall(
						action.getUrNo(), action.getSubUrNo());
				if (ig != null)
					igList.add(ig);
			} else if (action.getSubUrType().equals("RT")) {
				RoutingService routingService = (RoutingService) JSFServiceFinderUtil
						.getInstance().getBean("routingService");
				IpUrRouting rt = routingService.findFirewall(action.getUrNo(),
						action.getSubUrNo());
				if (rt != null)
					rtList.add(rt);
			} else if (action.getSubUrType().equals("F5")) {
				F5Service f5Service = (F5Service) JSFServiceFinderUtil
						.getInstance().getBean("f5Service");
				IpUrF5 f5 = f5Service.findFirewall(action.getUrNo(), action
						.getSubUrNo());
				if (f5 != null)
					f5List.add(f5);
			}
		}
		
		reqNetworkBean.setFirewallCheck(config.getFwSts().equals("Y"));
		if (config.getFwSts().equals("Y")) {
			reqNetworkBean.setListFirewall(fwList);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("FW");
		}

		reqNetworkBean.setAccessListCheck(config.getAlSts().equals("Y"));
		if (config.getAlSts().equals("Y")) {
			reqNetworkBean.setListAccessList(alList);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("AL");
		}

		reqNetworkBean.setAccessTNPCheck(config.getAtSts().equals("Y"));
		if (config.getAtSts().equals("Y")) {
			reqNetworkBean.setListAccessTNP(atList);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("AT");
		}

		reqNetworkBean.setPhysicalCheck(config.getPiSts().equals("Y"));
		if (config.getPiSts().equals("Y")) {
			Collections.sort(piList, IpUrPhysicalInterface.piTrunkNoComparator);
			reqNetworkBean.setListPhysicalInterface(piList);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("PI");
		}

		reqNetworkBean.setGatewayCheck(config.getIgSts().equals("Y"));
		if (config.getIgSts().equals("Y")) {
			reqNetworkBean.setListGateway(igList);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("IG");
		}

		reqNetworkBean.setRoutingCheck(config.getRtSts().equals("Y"));
		if (config.getRtSts().equals("Y")) {
			reqNetworkBean.setListRouting(rtList);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("RT");
		}

		reqNetworkBean.setF5Check(config.getF5Sts().equals("Y"));
		if (config.getF5Sts().equals("Y")) {
			reqNetworkBean.setListF5(f5List);
			String currentTab = reqNetworkBean.getCurrentTab();
			if (currentTab == null)
				reqNetworkBean.setCurrentTab("F5");
		}

		reqNetworkBean.setMode(IPFMConstant.MODE_VIEW);
		
		List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
		reqNetworkBean.setNwLocationList(locatStringList);
		
		setNetworkConfigBean(reqNetworkBean);
	}

	public static void setRequestParameter(String name, String value) {
		FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().put(name, value);
	}

	public String sendForApprove() throws Exception {
		String returnID = "";
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		NetworkConfigValidate nwc = new NetworkConfigValidate(bean);
		String  managerId ="";
		String managername="";
		try {
		if (nwc.validate()) {
			bean.setHideAddButton(true);
			bean.setErrorFlag(true);
			
			if (bean.getSelectedManager().size() != 0  ||  bean.getSelectedManager() != null) {
				List<IpUser> managerList = getManager(bean.getSelectedManager());
				for (IpUser manager : managerList) {
					managerId += (manager.getUserId() + ";");
					managername += (manager.getUserName()+" ("+manager.getTel()+ ");");
				}
			}
			
			HashMap<String, Boolean> checked = new HashMap<String, Boolean>();
			checked.put("fw", bean.getFirewallCheck());
			checked.put("al", bean.getAccessListCheck());
			checked.put("at", bean.getAccessTNPCheck());
			checked.put("pi", bean.getPhysicalCheck());
			checked.put("ig", bean.getGatewayCheck());
			checked.put("rt", bean.getRoutingCheck());
			checked.put("f5", bean.getF5Check());
			
			IpUrNwConfig urNwConfig = nwConfigService.findByUrNo(bean.getUrNo());
			String newUrNo = null;
			if(urNwConfig == null) {
				newUrNo = nwConfigService.getUrNO();
			} else {
				newUrNo = bean.getUrNo();
			}
			

			IpUrNwConfig ipConfg = saveScreenUr(bean, new IpUrNwConfig());
			ipConfg.setUrNo(newUrNo);
			ipConfg.setReqDate(new Date());
			ipConfg.setCreatedBy(userSession.getIpUser().getUserId());
			ipConfg.setCreated(new Date());
			ipConfg.setLastUpd(new Date());
			ipConfg.setLastUpdBy(userSession.getIpUser().getUserId());
			
			IpUrStatus ipUrStatus1  =  nwConfigService.getSubUrStatus("NC", IPFMConstant.STATUS_WAIT_MRG);
			
			nwConfigService.checkIPBeforeApprove(newUrNo);
			
			if(bean.getPhysicalCheck()){
				nwConfigService.updateTrunkFlag(bean.getUrNo(), "PI");
			}
			
			saveSubUr(newUrNo, bean, ipUrStatus1, userSession.getIpUser(),
                    nwConfigService, "Request Network Configure", IPFMConstant.STATUS_WAIT_MRG,
					"F025", IPFMConstant.ACTION_MRG_APPR);
			
			nwConfigService.sendForApprove(bean.getUrNo(), newUrNo, userSession.getIpUser(), ipConfg, managerId, managername,checked);
			
			String reqType = bean.getCurrentTab();
			if (reqType.equals("FW")) {
				FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
				List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
				bean.setListFirewall(listFirewall);
			} else if (reqType.equals("AL")) {
				AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
				List<IpUrAccessListCdn> listCdn = cdnService.findByUrNo(bean.getUrNo());
				bean.setListAccessList(listCdn);
			} else if (reqType.equals("AT")) {
				AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
				List<IpUrAccessListTnp> list = tnpService.findByUrNo(bean.getUrNo());
				bean.setListAccessTNP(list);
			} else if (reqType.equals("PI")) {
				PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
				List<IpUrPhysicalInterface> list = phyIntfService.findByUrNo(bean.getUrNo());
				bean.setListPhysicalInterface(list);
			} else if (reqType.equals("IG")) {
				IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
				List<IpUrInterfaceGateway> list = intfGatewayService.findByUrNo(bean.getUrNo());
				bean.setListGateway(list);
			} else if (reqType.equals("RT")) {
				RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
				List<IpUrRouting> list = routingService.findByUrNo(bean.getUrNo());
				bean.setListRouting(list);
			} else if (reqType.equals("F5")) {
				F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
				List<IpUrF5> list = f5Service.findByUrNo(bean.getUrNo());
				bean.setListF5(list);
			}
							
			EmailDetail email = new EmailDetail();
//			email.setUrNo(bean.getUrNo());
			email.setUrNo(newUrNo);
			email.setUrType("Request Network Config");
			email.setUrStatusDesc("Wait For Manager Approve");
			email.setUrStatus("WAIT_MRG");
			email.setSubjectDesc("Wait For Manager Approve");
			email.setBodyDesc("Wait For Manager Approve");
			email.setUrType("Request Network Config");
			
			sendEmail(bean, email);
			bean.setMode(IPFMConstant.MODE_EDIT);
			setNetworkConfigBean(bean);
			
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));

			IPFMWebUtil.storeOnSession("HOME", true);
		}
		} catch(Exception e) {
			if(e instanceof IPFMBusinessException){
				IPFMBusinessException ipfme = (IPFMBusinessException)e;
				if(ipfme.getMessageCode()!=null && ipfme.getMessageCode().equalsIgnoreCase("ER0210")){
					IPFMMessageUtils.addMessageError(ipfme.getLanguage());
				}else{
					ipfme.printStackTrace();
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
				}
			}else{
				e.printStackTrace();
				IPFMMessageUtils.addMessageError(IPFMDataUtility
						.buildMessage(ErrorMessageUtil.getMessage("ER0008")));				
			}
		}
		return returnID;
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		ReqNWConfigBean bean = getNetworkConfigBean();
		if (IPFMUtils.ifBlank(bean.getMgrRemark(), "").trim().length() == 0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(
					ErrorMessageUtil.getMessage("ER0001"), "Remarks"));
			flgValid = false;
		}

		return flgValid;
	}

	public String saveDraft() throws Exception {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		IpUrStatus draftStatus = nwConfigService.getUrStatus("NC", "DRAFT");
		String formUrNo = bean.getUrNo();
		String urNO = (formUrNo.startsWith("T")) ? nwConfigService.getUrNO()
				: bean.getUrNo();
		NetworkConfigValidate nwc = new NetworkConfigValidate(bean);

		if (nwc.validateSaveDraft()) {
		try {
			IpUrNwConfig nwConfig = nwConfigService.findByUrNo(urNO);

			if (nwConfig == null) {
				IpUrNwConfig draft = saveScreenUr(bean, new IpUrNwConfig());
				draft.setUrNo(urNO);
				draft.setReqDate(new Date());
				draft.setCreatedBy(userSession.getIpUser().getUserId());
				draft.setCreated(new Date());
				draft.setLastUpd(new Date());
				draft.setLastUpdBy(userSession.getIpUser().getUserId());
				draft.setUrStatusTxt(draftStatus.getUrStatusId());
				draft.setUrType(draftStatus.getUrType());
				draft.setUrStatusName(draftStatus.getUrStatusName());

				nwConfigService.saveUr(draft);
				IpUrNwConfig objNwConfig  = new  IpUrNwConfig();
				objNwConfig.setUrNo(urNO);
				objNwConfig.setUrStatusName("Draft UR");
				bean.setNetworkConfig(objNwConfig);
			} else {
				IpUrNwConfig draft = saveScreenUr(bean, nwConfig);
				draft.setLastUpdBy(userSession.getIpUser().getUserId());
				draft.setCreatedBy(nwConfig.getCreatedBy());
				draft.setCreated(nwConfig.getCreated());
				draft.setLastUpd(new Date());
				draft.setLastUpdBy(userSession.getIpUser().getUserId());
				draft.setReqDate(nwConfig.getReqDate());

				draft.setUrStatusTxt(draftStatus.getUrStatusId());
				draft.setUrType(draftStatus.getUrType());
				draft.setUrStatusName(draftStatus.getUrStatusName());
				nwConfigService.updateUr(draft);
			}

			IpUrStatus subUrStatus = nwConfigService.getSubUrStatus("NC","DRAFT");
			saveSubUr(urNO, bean, subUrStatus, userSession.getIpUser(),
                    nwConfigService, "Draft UR", IPFMConstant.STATUS_DRAFT,
					"F008", IPFMConstant.MODE_EDIT);

			if (formUrNo.startsWith("T")) {
				List<Object> listObject = listSubUr(bean);
				if (listObject.size() > 0) {
					bean.setUrNo(urNO);
					saveAction(null, bean, userSession.getIpUser(),
							nwConfigService, "Draft UR",
							IPFMConstant.STATUS_DRAFT, "F008",
							IPFMConstant.MODE_EDIT, null);
				}

				IpUrAttachmentService fileService = (IpUrAttachmentService) JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
				fileService.updateAttachFileName(formUrNo, urNO);
			}
			bean.setMode(IPFMConstant.MODE_EDIT);
			bean.setUrNo(urNO);
			
			String reqType = bean.getCurrentTab();
			if (reqType.equals("FW")) {
				FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
				List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
				bean.setListFirewall(listFirewall);
			} else if (reqType.equals("AL")) {
				AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
				List<IpUrAccessListCdn> listCdn = cdnService.findByUrNo(bean.getUrNo());
				bean.setListAccessList(listCdn);
			} else if (reqType.equals("AT")) {
				AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
				List<IpUrAccessListTnp> list = tnpService.findByUrNo(bean.getUrNo());
				bean.setListAccessTNP(list);
			} else if (reqType.equals("PI")) {
				PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
				List<IpUrPhysicalInterface> list = phyIntfService.findByUrNo(bean.getUrNo());
				bean.setListPhysicalInterface(list);
			} else if (reqType.equals("IG")) {
				IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
				List<IpUrInterfaceGateway> list = intfGatewayService.findByUrNo(bean.getUrNo());
				bean.setListGateway(list);
			} else if (reqType.equals("RT")) {
				RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
				List<IpUrRouting> list = routingService.findByUrNo(bean.getUrNo());
				bean.setListRouting(list);
			} else if (reqType.equals("F5")) {
				F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
				List<IpUrF5> list = f5Service.findByUrNo(bean.getUrNo());
				bean.setListF5(list);
			}
			
			setNetworkConfigBean(bean);

			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
		} catch (IPFMBusinessException ipfme) {
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		}
		return "";
	}

	public void addConfigNetwork(ActionEvent event) {
		String reqType = getRequestParameter("reqType");
		if (reqType.equals("FW")) {
			new NWConfigFirewallAction().addFirewall(event);
		} else if (reqType.equals("AL")) {
			new NWConfigAccessListAction().addAccessList(event);
		} else if (reqType.equals("AT")) {
			new NWConfigAccessListTNPAction().addAccessListTNP(event);
		} else if (reqType.equals("PI")) {
			new NWConfigPhyInterfaceAction().addPhyInterface(event);
		} else if (reqType.equals("IG")) {
			new NWConfigIntfGatewayAction().addIntfGateway(event);
		} else if (reqType.equals("RT")) {
			new NWConfigRoutingAction().addRouting(event);
		} else if (reqType.equals("F5")) {
			new NWConfigF5Action().addData(event);
		}
	}
	
	public void editConfigNetwork(ActionEvent event) {
		String reqType = getRequestParameter("reqType");
		if (reqType.equals("FW")) {
			new NWConfigFirewallAction().editFirewall(event);
		} else if (reqType.equals("AL")) {
			new NWConfigAccessListAction().editAccessList(event);
		} else if (reqType.equals("AT")) {
			new NWConfigAccessListTNPAction().editAccessListTNP(event);
		} else if (reqType.equals("PI")) {
			new NWConfigPhyInterfaceAction().editPhyInterface(event);
		} else if (reqType.equals("IG")) {
			new NWConfigIntfGatewayAction().editIntfGateway(event);
		} else if (reqType.equals("RT")) {
			new NWConfigRoutingAction().editRouting(event);
		} else if (reqType.equals("F5")) {
			new NWConfigF5Action().editF5(event);
		}
	}	

	// deleteUR
	public void deleteSubUr() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		// String reqType = bean.getCurrentTab();
		String urNo = bean.getDeleteUrNo();
		String subUrNo = bean.getDeleteSubUrNo();
		
		if (subUrNo.startsWith("FW")) {
				new NWConfigFirewallAction().deleteFirewall(urNo, subUrNo);
		} else if (subUrNo.startsWith("AL")) {
				new NWConfigAccessListAction().deleteCDN(urNo, subUrNo);
		} else if (subUrNo.startsWith("AT")) {
				new NWConfigAccessListTNPAction().deleteTNP(urNo, subUrNo);
		} else if (subUrNo.startsWith("PI")) {
				new NWConfigPhyInterfaceAction().deleteInterface(urNo, subUrNo);
		} else if (subUrNo.startsWith("IG")) {
				new NWConfigIntfGatewayAction().deleteGateway(urNo, subUrNo);
		} else if (subUrNo.startsWith("RT")) {
				new NWConfigRoutingAction().deleteRouting(urNo, subUrNo);
		} else if (subUrNo.startsWith("F5")) {
				new NWConfigF5Action().deleteF5(urNo, subUrNo);
		}
	}

	public void deleteSomeSelectUr() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		String subUrNo = bean.getCurrentTab();		
		if (subUrNo.startsWith("FW")) {
			List<IpUrFirewall> fwList = bean.getListFirewall();
			for(IpUrFirewall fw : fwList) {
				if(fw.getIsSelected()) {
					new NWConfigFirewallAction().deleteFirewall(fw.getId().getUrNo(), fw.getId().getSubUrNo());
				}
			}
		} else if (subUrNo.startsWith("AL")) {
			List<IpUrAccessListCdn> alList = bean.getListAccessList();
			for(IpUrAccessListCdn al : alList) {
				if(al.getIsSelected()) {
					new NWConfigAccessListAction().deleteCDN(al.getId().getUrNo(), al.getId().getSubUrNo());
				}
			}			
		} else if (subUrNo.startsWith("AT")) {
			List<IpUrAccessListTnp> atList = bean.getListAccessTNP();
			for(IpUrAccessListTnp at : atList) {
				if(at.getIsSelected()) {			
					new NWConfigAccessListTNPAction().deleteTNP(at.getId().getUrNo(), at.getId().getSubUrNo());
				}
			}
		} else if (subUrNo.startsWith("PI")) {
			List<IpUrPhysicalInterface> piList = bean.getListPhysicalInterface();
			for(IpUrPhysicalInterface pi : piList) {
				if(pi.getIsSelected()) {				
					new NWConfigPhyInterfaceAction().deleteInterface(pi.getId().getUrNo(), pi.getId().getSubUrNo());
				}
			}
		} else if (subUrNo.startsWith("IG")) {
			List<IpUrInterfaceGateway> igList = bean.getListGateway();
			for(IpUrInterfaceGateway ig : igList) {
				if(ig.getIsSelected()) {				
					new NWConfigIntfGatewayAction().deleteGateway(ig.getId().getUrNo(), ig.getId().getSubUrNo());
				}
			}
		} else if (subUrNo.startsWith("RT")) {
			List<IpUrRouting> rtList = bean.getListRouting();
			for(IpUrRouting rt : rtList) {
				if(rt.getIsSelected()) {				
					new NWConfigRoutingAction().deleteRouting(rt.getId().getUrNo(), rt.getId().getSubUrNo());
				}
			}
		} else if (subUrNo.startsWith("F5")) {
			List<IpUrF5> f5List = bean.getListF5();
			for(IpUrF5 f5 : f5List) {
				if(f5.getIsSelected()) {				
					new NWConfigF5Action().deleteF5(f5.getId().getUrNo(), f5.getId().getSubUrNo());
				}
			}

		}
		
	}
	
//	public void confirmSelectdDeleteSubUr() {
//		  try{
//			ReqNWConfigBean bean = getNetworkConfigBean();
//			String urNo = getRequestParameter("urNo");
//			String subUrNo = getRequestParameter("subUrNo");
//			
//			bean.setDeleteUrNo(urNo);
//			bean.setDeleteSubUrNo(subUrNo);
//			setNetworkConfigBean(bean);
//		  }catch (Exception e) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
//		  }
//		}

	
	public void confirmDeleteSubUr() {
	  try{
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		
		bean.setDeleteUrNo(urNo);
		bean.setDeleteSubUrNo(subUrNo);
		setNetworkConfigBean(bean);
	  }catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
	  }
	}

	public IpUrNwConfig saveURNWConfig(IPUrNwConfigService service,
			ReqNWConfigBean bean, IpUser user) throws Exception {

		IpUrStatus subUrStatus = service.getSubUrStatus("NC", "WAIT_MRG");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		IpUrNwConfig nwConfig = service.findByUrNo(bean.getUrNo());
		if (nwConfig == null) {
			String urNo = nwConfigService.getUrNO();
			nwConfig = saveScreenUr(bean, new IpUrNwConfig());
			nwConfig.setReqUserId(user.getUserId());
			nwConfig.setCreatedBy(user.getUserId());
			nwConfig.setReqDate(new Date());
			IpUrStatus draftStatus = service.getUrStatus("NC", "DRAFT");
			nwConfig.setUrStatusTxt(draftStatus.getUrStatusId());
			nwConfig.setUrType(draftStatus.getUrType());
			nwConfig.setUrStatusName(draftStatus.getUrStatusName());
			nwConfig.setUrNo(urNo);
			service.saveUr(nwConfig);
			nwConfig = service.findByUrNo(bean.getUrNo());
		}    

		String urNO = (bean.getUrNo().startsWith("T")) ? service.getUrNO()
				: bean.getUrNo();
		if (bean.getUrNo().startsWith("T")) {
			IpUrAttachmentService attachmentService = (IpUrAttachmentService) JSFServiceFinderUtil
					.getInstance().getBean("ipUrAttachmentService");
			attachmentService.updateAttachFileName(bean.getUrNo(), urNO);
		}

		saveSubUr(urNO, bean, subUrStatus, user, service,
				"Wait For Manager Approve", IPFMConstant.STATUS_WAIT_MRG,
				"F025", IPFMConstant.ACTION_MRG_APPR);

		// IpUrNwConfig config = saveScreenUr(bean,nwConfig);
		IpUrNwConfig config = new IpUrNwConfig();
		config.setUrNo(urNO);
		config.setReqUserId(user.getUserId());
		// config.setUrStatus(service.getUrStatus("NC", "WAIT_MRG"));
		nwConfig.setUrStatusTxt(subUrStatus.getUrStatusId());
		nwConfig.setUrType(subUrStatus.getUrType());
		nwConfig.setUrStatusName(subUrStatus.getUrStatusName());
		// config.setTnpStatus();
		config.setLastUpdBy(user.getUserId());
		config.setLastUpd(new Date());
		service.updateUr(config);

		if (bean.getUrNo().startsWith("T"))
			service.deleteByUrNo(bean.getUrNo());

		setNetworkConfigBean(bean);
		return service.findByUrNo(config.getUrNo());
	}

	public IpUrNwConfig saveScreenUr(ReqNWConfigBean bean, IpUrNwConfig config) {
		config.setReqUserId(bean.getUser().getUserId());
		config.setReqUserName(bean.getUser().getUserName());
		config.setReqEmail(bean.getUser().getEmail());
		config.setReqMobile(bean.getUser().getMobile());
		config.setReqTel(bean.getUser().getTel());
		config.setReqTeamId(bean.getUser().getTeamId());
		config.setReqTeamName(bean.getUser().getTeamName());
		config.setReqPosition(bean.getUser().getPosition());
		config.setReqSection(bean.getUser().getSection());
		config.setReqDept(bean.getUser().getDept());

		config.setUrNo(bean.getUrNo());
		config.setReqSubject(bean.getSubject());
		config.setReqObjective(bean.getObjective());
		config.setReqRequirement(bean.getRequirement());
		config.setIsPeriod(bean.getIsPeroiod());
		if (bean.getIsPeroiod().equals("Y")) {
			config.setPeriodStart(bean.getPeriodStart());
			config.setPeriodEnd(bean.getPeriodEnd());
		}
		config.setReqFor(bean.getRequestFor());
		config.setIsAttach(bean.getIsAttach());

		config.setFwSts((bean.getFirewallCheck()) ? "Y" : "N");
		config.setAlSts((bean.getAccessListCheck()) ? "Y" : "N");
		config.setAtSts((bean.getAccessTNPCheck()) ? "Y" : "N");
		config.setPiSts((bean.getPhysicalCheck()) ? "Y" : "N");
		config.setIgSts((bean.getGatewayCheck()) ? "Y" : "N");
		config.setRtSts((bean.getRoutingCheck()) ? "Y" : "N");
		config.setF5Sts((bean.getF5Check()) ? "Y" : "N");

		return config;
	}

	public void saveAction(Object obj, ReqNWConfigBean bean, IpUser user,
			IPUrNwConfigService service, String actionName, String urStatus,
			String CallId, String mode, Map previous) throws Exception {
		String urNo = "";
		String subUrNo = "";
		try {
			if (obj != null) {
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);

				Field fieldUrNO = idObj.getClass().getDeclaredField("urNo");
				fieldUrNO.setAccessible(true);
				urNo = (String) fieldUrNO.get(idObj);
				fieldUrNO.setAccessible(false);

				Field fieldSubUrNO = idObj.getClass().getDeclaredField(
						"subUrNo");
				fieldSubUrNO.setAccessible(true);
				subUrNo = (String) fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);

				fieldId.setAccessible(false);
			} else {
				urNo = bean.getUrNo();
				subUrNo = "NA";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// IpUrAction action = service.findActionByUrNo(bean.getUrNo(),subUrNo);
		Date CreateDate = new Date();
		BigDecimal actionSeq = new BigDecimal(0);
		String createBy = user.getUserId();
		String name = urNo + ":" + subUrNo;
		if (previous != null) {
			Map prev = (Map) previous.get(name);
			if (prev != null) {
				actionSeq = (prev.get("seq") != null) ? (BigDecimal) prev
						.get("seq") : actionSeq;
				CreateDate = (prev.get("createDate") != null) ? (Date) prev
						.get("createDate") : CreateDate;
				createBy = (prev.get("createBy") != null) ? (String) prev
						.get("createBy") : createBy;
			}
		}

		IpUrAction saveAcrion = new IpUrAction();
		saveAcrion.setUrNo(urNo);
		saveAcrion.setUrType("NC");
		saveAcrion.setSubUrNo(subUrNo);
		saveAcrion.setSubUrType(getSubUrType(obj));
		saveAcrion.setSubject(bean.getSubject());
		saveAcrion
				.setActionSeq((urStatus.equals(IPFMConstant.STATUS_DRAFT)) ? actionSeq
						: actionSeq.add(new BigDecimal(1)));
		saveAcrion.setReqestUserId(user.getUserId());
		saveAcrion.setReqestUser(user.getUserName());
		saveAcrion.setReqestDate(new Date());

		String managerId = "";
		String managername = "";
		if ((bean.getSelectedManager().size() != 0)
				&& (bean.getSelectedManager() != null)) {
			List<IpUser> managerList = getManager(bean.getSelectedManager());
			for (IpUser manager : managerList) {
				managerId += (manager.getUserId() + ";");
				managername += (manager.getUserName() + ";");
			}
		}

		saveAcrion.setActionUserId(managerId);
		saveAcrion.setActionUser(managername);

		saveAcrion.setActionName(actionName);
		saveAcrion.setUrStatus(urStatus);
		saveAcrion.setCallFunctionId(CallId);
		saveAcrion.setCallMode(mode);

		if (!urStatus.equals("DRAFT")) {
			String ip = getIp(obj);
			String teamId = service.getOwnerIp(ip);
			String pm = service.getPmRileId(teamId);
			pm = (pm != null) ? pm : "";
			String pmRoleId = (pm.equals("R06")) ? "TNP" : "CDN";
			saveAcrion.setSlaDate(service.getSLADate(CreateDate, "NC", pmRoleId));
			saveAcrion.setOlaDate(service.getOLADate(CreateDate, "NC", "N4"));

		} else {
			saveAcrion.setActionUserId(user.getUserId());
			saveAcrion.setActionUser(user.getUserName());
		}
		saveAcrion.setCreated(CreateDate);
		saveAcrion.setCreatedBy(createBy);
		saveAcrion.setLastUpd(new Date());
		saveAcrion.setLastUpdBy(user.getUserId());
		
		if(actionName.equals("Request Network Configure")) {
			saveAcrion.setActionUserId(user.getUserId());
			saveAcrion.setActionUser(user.getUserName()+" ("+user.getTel()+")");
		}

		service.saveAction(saveAcrion);
	}

	private String getSubUrType(Object obj) {
		String subUrType = "";
		if (obj instanceof IpUrFirewall)
			subUrType = "FW";
		else if (obj instanceof IpUrAccessListCdn)
			subUrType = "AL";
		else if (obj instanceof IpUrAccessListTnp)
			subUrType = "AT";
		else if (obj instanceof IpUrPhysicalInterface)
			subUrType = "PI";
		else if (obj instanceof IpUrInterfaceGateway)
			subUrType = "IG";
		else if (obj instanceof IpUrRouting)
			subUrType = "RT";
		else if (obj instanceof IpUrF5)
			subUrType = "F5";
		else
			subUrType = "NA";
		return subUrType;
	}

	private String getIp(Object obj) {
		String ip = "";
		if (obj instanceof IpUrFirewall)
			ip = ((IpUrFirewall) obj).getDestIp1();
		else if (obj instanceof IpUrAccessListCdn)
			ip = ((IpUrAccessListCdn) obj).getDestIp1();
		else if (obj instanceof IpUrAccessListTnp)
			ip = ((IpUrAccessListTnp) obj).getDestIp();
		else if (obj instanceof IpUrPhysicalInterface)
			ip = ((IpUrPhysicalInterface) obj).getIpNode();
		else if (obj instanceof IpUrInterfaceGateway)
			ip = ((IpUrInterfaceGateway) obj).getIpAddress();
		else if (obj instanceof IpUrRouting)
			ip = ((IpUrRouting) obj).getIpAddress();
		else if (obj instanceof IpUrF5)
			ip = ((IpUrF5) obj).getVipAddress();
		else
			ip = "NA";
		return ip;
	}

	public List<Object> listSubUr(ReqNWConfigBean bean) {
		List<Object> listObj = new ArrayList<Object>();
		if (bean.getFirewallCheck() && (bean.getListFirewall() != null)) {
			for (IpUrFirewall subUR : bean.getListFirewall()) {
				listObj.add(subUR);
			}
		}

		if (bean.getAccessListCheck() && (bean.getListAccessList() != null)) {
			for (IpUrAccessListCdn subUR : bean.getListAccessList()) {
				listObj.add(subUR);
			}
		}

		if (bean.getAccessTNPCheck() && (bean.getListAccessTNP() != null)) {
			for (IpUrAccessListTnp subUR : bean.getListAccessTNP()) {
				listObj.add(subUR);
			}
		}

		if (bean.getPhysicalCheck()
				&& (bean.getListPhysicalInterface() != null)) {
			for (IpUrPhysicalInterface subUR : bean.getListPhysicalInterface()) {
				listObj.add(subUR);
			}
		}

		if (bean.getGatewayCheck() && (bean.getListGateway() != null)) {
			for (IpUrInterfaceGateway subUR : bean.getListGateway()) {
				listObj.add(subUR);
			}
		}

		if (bean.getRoutingCheck() && (bean.getListRouting() != null)) {
			for (IpUrRouting subUR : bean.getListRouting()) {
				listObj.add(subUR);
			}
		}

		if (bean.getF5Check() && (bean.getListF5() != null)) {
			for (IpUrF5 subUR : bean.getListF5()) {
				listObj.add(subUR);
			}
		}

		return listObj;
	}

	public String getUrNoSearch() {
		return urNoSearch;
	}

	public void setUrNoSearch(String urNoSearch) {
		this.urNoSearch = urNoSearch;
	}

	public void managerApprove() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IpUrActionService ipUrActionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
		String urNo = getRequestParameter("urNo");
//		String remark = getRequestParameter("remark");
		
		try {
			//nwConfigService.managerApproveUr(urNo, userSession.getIpUser(), remark);
			nwConfigService.managerApproveUr(urNo, userSession.getIpUser(), bean.getMgrRemark());
			List<IpUrAction> urActionList = ipUrActionService.getIpUrAction(urNo);
			Set<String> userIdSet = new HashSet<String>(); 
			for (IpUrAction urAction : urActionList) {
				String[] actionUserId = urAction.getActionUserId().split(";");
				for (String userId : actionUserId) {
					userIdSet.add(userId);
				}
			}
			for (String userId : userIdSet) {
				IpUser user = ipUserService.findIpUserById(userId);
				EmailDetail email = new EmailDetail();
				email.setEmail(user.getEmail());
				email.setUrNo(bean.getUrNo());
				email.setUserId(user.getUserId());
				email.setUserName(user.getUserName());
				email.setRequestBy(bean.getNetworkConfig().getReqUserName());
				email.setRequestDate(bean.getNetworkConfig().getReqDate());
				email.setSubject(bean.getNetworkConfig().getReqSubject());
				email.setUrType("Request Network Config");
				email.setUrStatusDesc("Wait For System Owner Approve");
				email.setUrStatus(IPFMConstant.STATUS_WAIT_OWNER);
				email.setSubjectDesc("Wait For System Owner Approve");
				email.setBodyDesc("Wait For System Owner Approve");
				email.setUrType("Request Network Config");
				email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
				email.setNodeId("N5");
				sendEmailNotify(bean, email);
			}
			
		}catch(IPFMBusinessException ipfme) {
			if(ipfme.getMessageCode()!=null && ipfme.getMessageCode().equalsIgnoreCase("ER0210")){
				IPFMMessageUtils.addMessageError(ipfme.getLanguage());
			}else{
				ipfme.printStackTrace();
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
			}
			//IPFMMessageUtils.addMessageError(ipfme.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		setNetworkConfigBean(bean);
	}

	public void managerReject() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		String urNo = getRequestParameter("urNo");
//		String remark = getRequestParameter("remark");

		try {
			nwConfigService.managerRejectUr(urNo, userSession.getIpUser(), bean.getMgrRemark());
			IpUrNwConfig config = nwConfigService.findByUrNo(urNo);
			EmailDetail email = new EmailDetail();
			email.setUrNo(urNo);
			email.setSubject(config.getReqSubject());
			email.setUrType("Request Network Config");
			email.setUrStatusDesc("Reject By Manager");
			email.setUrStatus(IPFMConstant.STATUS_REJECT_MRG);
			email.setSubjectDesc("Reject By Manager");
			email.setBodyDesc("Reject By Manager");
			email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
			email.setUserId(config.getReqUserId());
			email.setUserName(config.getReqUserName());
			email.setRequestBy(config.getReqUserName());
			email.setRequestDate(config.getReqDate());
			
			sendEmailReject(bean, email);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			IPFMWebUtil.storeOnSession("HOME", true);

		} catch (IPFMBusinessException ipfme) {
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		} catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0030")));
		}

		setNetworkConfigBean(bean);

	}

	public List<IpUser> getManager(List<String> selectedManager)
			throws Exception {
		IPUserService userService = (IPUserService) JSFServiceFinderUtil
				.getInstance().getBean("ipUserService");
		return userService.getManagerApproveList(selectedManager);
	}

	@SuppressWarnings("unchecked")
	public void sendEmail(ReqNWConfigBean bean, EmailDetail email) throws Exception {
		EMailService emailService = (EMailService) JSFServiceFinderUtil
				.getInstance().getBean("emailService");
		IpUrActionService actionService = (IpUrActionService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrActionService");
		String urNo = email.getUrNo();

		actionService.deleteNotify(email.getUrNo(), email.getDeleteStatus());
		
		UserSession userSession = IPFMWebUtil.getUserSession();
		IpUser user = userSession.getIpUser();

		List<IpUser> managerList = getManager(bean.getSelectedManager());
		for (IpUser manager : managerList) {
//			String key = "IPFM" + urNo + ":" + manager.getUserId();
			String key = emailService.getKeyCodeEmail();
			String[] to = { manager.getEmail() };
			String[] cc = null;
			String from = "ipfm@ais.co.th";

			if (actionService.isSendEmail("NC", "N4")) {
				try {
					Map model = new HashMap();
					model.put("userName", manager.getUserName());
					model.put("urNo", urNo);
					model.put("urType", email.getUrType());
					model.put("urStatus", email.getUrStatusDesc());
					model.put("subjectDesc", email.getSubjectDesc());
					model.put("bodyDesc", email.getBodyDesc());
					model.put("subject", bean.getSubject());
					model.put("requestBy", bean.getUser().getUserName());
					SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
					model.put("requestDate", smf.format(new Date()));
					String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
					model.put("url", getIPFMConfig().getHomeUrl()+ "/home/view.jsf?key=" + encodeUrl);

					emailService.sendMail(to, cc, from, EMailService.TEMPLATE_IPFM_NC_UR, model);

					IpEmailNotify notify = new IpEmailNotify();
					notify.setUserId(manager.getUserId());
					notify.setUrNo(urNo);
					notify.setCreatedBy(user.getUserId());
					notify.setLastUpdBy(user.getUserId());					
					notify.setUrStatus(email.getUrStatus());
					notify.setEmailLinkStatus("N");
					notify.setEmailCode(key);
					actionService.saveEmailNotify(notify);

				} catch (Exception e) {
					System.out.println("Email can not send.");
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void sendEmailReject(ReqNWConfigBean bean, EmailDetail email) throws Exception {
		EMailService emailService = (EMailService) JSFServiceFinderUtil.getInstance().getBean("emailService");
		IpUrActionService actionService = (IpUrActionService)JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
		IpUser reqUser = ipUserService.findIpUserById(email.getUserId());
		UserSession userSession = IPFMWebUtil.getUserSession();
		IpUser user = userSession.getIpUser();		
		
//		String key = "IPFM" + email.getUrNo() + ":" + email.getUserId();
		String key = emailService.getKeyCodeEmail();
		String[] to = { reqUser.getEmail() };
		String[] cc = null;
		String from = "ipfm@ais.co.th";

//		if (actionService.isSendEmail("NC", "N4")) {
			try {
				Map model = new HashMap();
				model.put("userName", email.getUserName());
				model.put("urNo", email.getUrNo());
				model.put("urType", email.getUrType());
				model.put("urStatus", email.getUrStatusDesc());
				model.put("subjectDesc", email.getSubjectDesc());
				model.put("bodyDesc", email.getBodyDesc());
				model.put("subject", email.getSubject());
				model.put("requestBy", email.getRequestBy());
				SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
		        model.put("requestDate", smf.format(email.getRequestDate()));
				String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
				model.put("url", getIPFMConfig().getHomeUrl()+ "/home/view.jsf?key=" + encodeUrl);

				emailService.sendMail(to, cc, from, EMailService.TEMPLATE_IPFM_NC_UR, model);

				IpEmailNotify notify = new IpEmailNotify();
				notify.setUserId(email.getUserId());
				notify.setUrNo(email.getUrNo());
				notify.setCreatedBy(user.getUserId());
				notify.setLastUpdBy(user.getUserId());
				notify.setUrStatus(email.getUrStatus());
				notify.setEmailLinkStatus("N");
				notify.setEmailCode(key);
				actionService.saveEmailNotify(notify);

			} catch (Exception e) {
				System.out.println("Email can not send.");
			}
//		}

	}
	
	@SuppressWarnings("unchecked")
	public void sendEmailOwnerApprove(ReqNWConfigBean bean, EmailDetail email)throws Exception {
		
		EMailService emailService = (EMailService) JSFServiceFinderUtil.getInstance().getBean("emailService");
		IPUserService userService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
		IpUrActionService actionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		String urNo = email.getUrNo();

		UserSession userSession = IPFMWebUtil.getUserSession();
		IpUser ipuser = userSession.getIpUser();			
		
		List<IpUrAction> ipUrActionList = actionService.getIpUrAction(urNo);
		if(ipUrActionList != null && ipUrActionList.size() > 0) { 
		IpUrAction ipUrAction = ipUrActionList.get(0);
		
		String ipUrActionStr = ipUrAction.getActionUserId();
		String [] str = {""};
		
		String[] ipUrActionStrs = ((ipUrActionStr != null) ? ipUrActionStr.split(";") : str);
		
		for(String user : ipUrActionStrs) {
			if(user != null && !"".equals(user)) {
				IpUser ipUser = userService.findIpUserById(user);
//				String key = "IPFM" + urNo + ":"+ipUser.getUserId();
				String key = emailService.getKeyCodeEmail();
				String[] to = { ipUser.getEmail() };
				String[] cc = null;
				String from = "ipfm@ais.co.th";
		
				try {
					Map model = new HashMap();
					model.put("managerName", ipUser.getUserName());
					model.put("urNo", urNo);
					model.put("urType", email.getUrType());
					model.put("urStatus", email.getUrStatusDesc());
					model.put("subjectDesc", email.getSubjectDesc());
					model.put("bodyDesc", email.getBodyDesc());
					model.put("subject", ipUrAction.getSubject());
					model.put("requestBy", ipUrAction.getReqestUser());
					SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
			        model.put("requestDate", smf.format(ipUrAction.getReqestDate()));
					String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
					model.put("url", getIPFMConfig().getHomeUrl()+ "/home/view.jsf?key=" + encodeUrl);
			
					emailService.sendMail(to, cc, from, EMailService.TEMPLATE_IPFM,model);
			
					IpEmailNotify notify = new IpEmailNotify();
					notify.setUserId(user);
					notify.setUrNo(urNo);
					notify.setCreatedBy(ipuser.getUserId());
					notify.setLastUpdBy(ipuser.getUserId());
					notify.setUrStatus(email.getUrStatus());
					notify.setEmailLinkStatus("N");
					notify.setEmailCode(key);
					actionService.saveEmailNotify(notify);
			
				} catch (Exception e) {
					System.out.println("Email can not send.");
				}
			}
		}
	}
	
}
	
	@SuppressWarnings("unchecked")
	public void sendEmailNotify(ReqNWConfigBean bean, EmailDetail email) throws Exception {
		IpUrActionService actionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		if(IPFMUtils.ifBlank(email.getNodeId(),"").length()==0 || actionService.isSendEmail(bean.getNetworkConfig().getUrType(), email.getNodeId())){
			EMailService emailService = (EMailService) JSFServiceFinderUtil.getInstance().getBean("emailService");
			UserSession userSession = IPFMWebUtil.getUserSession();
			IpUser ipuser = userSession.getIpUser();
			
//			String key = "IPFM" + email.getUrNo() + ":"+email.getUserId();
			String key = emailService.getKeyCodeEmail();
			String[] to = { email.getEmail() };
			String[] cc = null;
			String from = "ipfm@ais.co.th";
			try {
				Map model = new HashMap();
				model.put("userName", email.getUserName());
				model.put("urNo", email.getUrNo());
				model.put("urType", email.getUrType());
				model.put("urStatus", email.getUrStatusDesc());
				model.put("subjectDesc", email.getSubjectDesc());
				model.put("bodyDesc", email.getBodyDesc());
				model.put("subject", email.getSubject());
				model.put("requestBy", email.getRequestBy());
				SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
		        model.put("requestDate", smf.format(email.getRequestDate()));
				String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
				model.put("url", getIPFMConfig().getHomeUrl()+ "/home/view.jsf?key=" + encodeUrl);
				emailService.sendMail(to, cc, from, email.getTemplateEmail(),model);
		
				IpEmailNotify notify = new IpEmailNotify();
				notify.setUserId(email.getUserId());
				notify.setUrNo(email.getUrNo());
				notify.setCreatedBy(ipuser.getUserId());
				notify.setLastUpdBy(ipuser.getUserId());
				notify.setUrStatus(email.getUrStatus());
				notify.setEmailLinkStatus("N");
				notify.setEmailCode(key);
				actionService.saveEmailNotify(notify);
			} catch (Exception e) {
				System.out.println("Email can not send.");
			}
		}
	}
		

	@SuppressWarnings("unchecked")
	public void sendEmailTeamReject(List<EmailDetail> emailList) {
		EMailService emailService = (EMailService) JSFServiceFinderUtil.getInstance().getBean("emailService");
		IpUrActionService ipUrActionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		try {
			for (EmailDetail email : emailList) {
				String[] to = { email.getEmail() };
				String[] cc = null;
				String from = "ipfm@ais.co.th";
				Map model = new HashMap();
				model.put("userName", email.getUserName());
				model.put("urNo", email.getUrNo());
				model.put("subUrNo", email.getSubUrNo());
				model.put("urType", email.getUrType());
				model.put("urStatus", email.getUrStatusDesc());
				model.put("subjectDesc", email.getSubjectDesc());
				model.put("bodyDesc", email.getBodyDesc());
				model.put("subject", email.getSubject());
				model.put("requestBy", email.getRequestBy());
				SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
		        model.put("requestDate", smf.format(email.getRequestDate()));
//				String key = "IPFM" + email.getUrNo() + ":"+email.getUserId();
		        String key = emailService.getKeyCodeEmail();
				String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
				model.put("url", email.getUrl());
				emailService.sendMail(to, cc, from, EMailService.TEMPLATE_IPFM_NC_SUBUR,model);
				
				IpEmailNotify notify = new IpEmailNotify();
				notify.setUserId(email.getUserId());
				notify.setUrNo(email.getUrNo());
				notify.setCreatedBy(email.getCreateBy());
				notify.setLastUpdBy(email.getUpdateBy());
				notify.setUrStatus(email.getUrStatus());
				notify.setEmailLinkStatus("N");
				notify.setEmailCode(key);
				ipUrActionService.saveEmailNotify(notify);
			}
		} catch (Exception e) {
			System.out.println("Email can not send.");
			e.printStackTrace();
		}
	}
	

	public void saveSubUr(String urNO, ReqNWConfigBean bean,
			IpUrStatus subUrStatus, IpUser user, IPUrNwConfigService service,
			String actionName, String urStatus, String CallId, String mode)
			throws Exception {
		Map previousUr = deletePreviousUR(bean.getUrNo());

		FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
				.getInstance().getBean("firewallService");
		boolean hasUr = false;
		if (bean.getFirewallCheck()) {

			List<IpUrFirewall> listFW = firewallService.findByUrNo(bean
					.getUrNo());
			for (IpUrFirewall fw : listFW) {
				if (bean.getUrNo().startsWith("T"))
					fw = firewallService.changeUrNo(fw, urNO);
				fw.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				fw.setUrType(subUrStatus.getUrType());
				//Jek
				fw.setLastUpd(new Date());
				//fw.setLastUpd(null);
				fw.setLastUpdBy(user.getUserId());
				firewallService.updateFirewall(fw);

				saveAction(fw, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}

			if (bean.getUrNo().startsWith("T"))
				firewallService.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			firewallService.deleteByUrNo(bean.getUrNo());

		AccessListService cdnService = (AccessListService) JSFServiceFinderUtil
				.getInstance().getBean("accessListService");
		if (bean.getAccessListCheck()) {
			List<IpUrAccessListCdn> listAC = cdnService.findByUrNo(bean
					.getUrNo());
			for (IpUrAccessListCdn ac : listAC) {
				if (bean.getUrNo().startsWith("T"))
					ac = cdnService.changeUrNo(ac, urNO);
				ac.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				ac.setUrType(subUrStatus.getUrType());

				ac.setLastUpd(new Date());
				ac.setLastUpdBy(user.getUserId());
				cdnService.update(ac);

				saveAction(ac, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}
			if (bean.getUrNo().startsWith("T"))
				cdnService.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			cdnService.deleteByUrNo(bean.getUrNo());

		AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil
				.getInstance().getBean("accessListTNPService");
		if (bean.getAccessTNPCheck()) {
			List<IpUrAccessListTnp> listTP = tnpService.findByUrNo(bean
					.getUrNo());
			for (IpUrAccessListTnp at : listTP) {
				if (bean.getUrNo().startsWith("T"))
					at = tnpService.changeUrNo(at, urNO);
				at.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				at.setUrType(subUrStatus.getUrType());

				at.setLastUpd(new Date());
				at.setLastUpdBy(user.getUserId());
				tnpService.update(at);

				saveAction(at, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}
			if (bean.getUrNo().startsWith("T"))
				tnpService.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			tnpService.deleteByUrNo(bean.getUrNo());

		PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil
				.getInstance().getBean("phyInterfaceService");
		if (bean.getPhysicalCheck()) {
			List<IpUrPhysicalInterface> listPI = phyIntfService.findByUrNo(bean
					.getUrNo());
			for (IpUrPhysicalInterface pi : listPI) {
				if (bean.getUrNo().startsWith("T"))
					pi = phyIntfService.changeUrNo(pi, urNO);
				// pi.setSubUrStatus(subUrStatus);
				pi.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				pi.setUrType(subUrStatus.getUrType());

				pi.setLastUpd(new Date());
				pi.setLastUpdBy(user.getUserId());
				phyIntfService.update(pi);

				saveAction(pi, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}
			if (bean.getUrNo().startsWith("T"))
				phyIntfService.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			phyIntfService.deleteByUrNo(bean.getUrNo());

		IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
				.getInstance().getBean("intfGatewayService");
		if (bean.getGatewayCheck()) {
			List<IpUrInterfaceGateway> listIG = intfGatewayService
					.findByUrNo(bean.getUrNo());
			for (IpUrInterfaceGateway ig : listIG) {
				if (bean.getUrNo().startsWith("T"))
					ig = intfGatewayService.changeUrNo(ig, urNO);
				// ig.setSubUrStatus(subUrStatus);
				ig.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				ig.setUrType(subUrStatus.getUrType());

				ig.setLastUpd(new Date());
				ig.setLastUpdBy(user.getUserId());
				intfGatewayService.update(ig);

				saveAction(ig, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}
			if (bean.getUrNo().startsWith("T"))
				intfGatewayService.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			intfGatewayService.deleteByUrNo(bean.getUrNo());

		RoutingService routingService = (RoutingService) JSFServiceFinderUtil
				.getInstance().getBean("routingService");
		if (bean.getRoutingCheck()) {
			List<IpUrRouting> listRT = routingService
					.findByUrNo(bean.getUrNo());
			for (IpUrRouting rt : listRT) {
				if (bean.getUrNo().startsWith("T"))
					rt = routingService.changeUrNo(rt, urNO);
				// rt.setSubUrStatus(subUrStatus);
				rt.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				rt.setUrType(subUrStatus.getUrType());
				rt.setLastUpd(new Date());
				rt.setLastUpdBy(user.getUserId());
				routingService.update(rt);

				saveAction(rt, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}
			if (bean.getUrNo().startsWith("T"))
				routingService.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			routingService.deleteByUrNo(bean.getUrNo());

		F5Service f5Service = (F5Service) JSFServiceFinderUtil.getInstance()
				.getBean("f5Service");
		if (bean.getF5Check()) {
			List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
			for (IpUrF5 f5 : listF5) {
				if (bean.getUrNo().startsWith("T"))
					f5 = f5Service.changeUrNo(f5, urNO);
				// f5.setSubUrStatus(subUrStatus);
				f5.setSubUrStatusTxt(subUrStatus.getSubUrStatusId());
				f5.setUrType(subUrStatus.getUrType());
				f5.setLastUpd(new Date());
				f5.setLastUpdBy(user.getUserId());
				f5Service.update(f5);

				saveAction(f5, bean, user, service, actionName, urStatus,
						CallId, mode, previousUr);
			}
			if (bean.getUrNo().startsWith("T"))
				f5Service.deleteByUrNo(bean.getUrNo());
			hasUr = true;
		} else
			f5Service.deleteByUrNo(bean.getUrNo());

		if (hasUr)
			service.deleteByNA(bean.getUrNo());
	}

	/**
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public void ownerApprove() throws Exception {
		System.out.println("Validate Owner State");
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		//String urNo = getRequestParameter("urNo");

		NetworkConfigValidate validate = new NetworkConfigValidate();
		String resultValidate = "";
		String resultRemark = "";
		Map<String, Object> subUr = new HashMap<String, Object>();
		if (bean.getFirewallCheck()) {
			resultValidate += (validate.checkUnProcess(bean.getListFirewall()));
			resultRemark += (validate.checkRemark(bean.getListFirewall(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListFirewall());
		}
		if (bean.getAccessListCheck()) {
			resultValidate += (validate
					.checkUnProcess(bean.getListAccessList()));
			resultRemark += (validate.checkRemark(bean.getListAccessList(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListAccessList());
		}
		if (bean.getAccessTNPCheck()) {
			resultValidate += (validate.checkUnProcess(bean.getListAccessTNP()));
			resultRemark += (validate.checkRemark(bean.getListAccessTNP(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListAccessTNP());
		}
		if (bean.getPhysicalCheck()) {
			resultValidate += (validate.checkUnProcess(bean.getListPhysicalInterface()));
			resultRemark += (validate.checkRemark(bean.getListPhysicalInterface(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListPhysicalInterface());
		}
		if (bean.getGatewayCheck()) {
			resultValidate += (validate.checkUnProcess(bean.getListGateway()));
			resultRemark += (validate.checkRemark(bean.getListGateway(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListGateway());
		}
		if (bean.getRoutingCheck()) {
			resultValidate += (validate.checkUnProcess(bean.getListRouting()));
			resultRemark += (validate.checkRemark(bean.getListRouting(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListRouting());
		}
		if (bean.getF5Check()) {
			resultValidate += (validate.checkUnProcess(bean.getListF5()));
			resultRemark += (validate.checkRemark(bean.getListF5(), IPFMConstant.STATUS_WAIT_OWNER));
			subUr = addSubUr(subUr, bean.getListF5());
		}

		if (!resultValidate.equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil
					.getMessage("ER0039"), resultValidate));
			bean.setErrorFlag(true);
		} else if (!resultRemark.equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil
					.getMessage("ER0040"), resultRemark));
			bean.setErrorFlag(true);
		} else {
			bean.setErrorFlag(false);
		}
		
		if (!bean.getErrorFlag()) {
			nwConfigService.ownerApproveUr(bean.getUrNo(), userSession.getIpUser(), subUr);
			if (nwConfigService.isOwnerApproveAll(bean.getUrNo())) {
				if(!nwConfigService.isOwnerRejectAll(bean.getUrNo())){
					IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
					IpUser ipUser = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
					EmailDetail email = new EmailDetail();
					email.setEmail(ipUser.getEmail());
					email.setUserId(bean.getNetworkConfig().getReqUserId());
					email.setUserName(bean.getNetworkConfig().getReqUserName());
					email.setRequestBy(bean.getNetworkConfig().getReqUserName());
					email.setRequestDate(bean.getNetworkConfig().getReqDate());
					email.setUrNo(bean.getUrNo());
					email.setUrStatusDesc("Reject By System Owner");
					email.setSubject(bean.getSubject());
					email.setDeleteStatus("WAIT_OWNER");
					email.setUrStatus("REJECT_OWNER");
					email.setSubjectDesc("Reject By System Owner");
					email.setBodyDesc("Reject By System Owner");
					email.setUrType("Request Network Config");
					email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
					email.setNodeId("");
					sendEmailNotify(bean, email);
				}else{
					IpUrActionService ipUrActionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
					IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
					List<IpUrAction> actionList = ipUrActionService.getIpUrAction(bean.getUrNo());
					String pmRoleId="";
					String actionUserId="";
					Set<String> userList = new HashSet<String>();
					Map roleMap = new HashMap();
					for (IpUrAction action : actionList) {
						if(action.getSubUrType().equals("FW") || action.getSubUrType().equals("AL") || action.getSubUrType().equals("F5")){
							pmRoleId="R07";
							List<IpRoleMember> pmUser = ipUserService.getUserForOwnerApprove(pmRoleId);
							for(IpRoleMember member : pmUser){
								userList.add(member.getUserId());
								roleMap.put(member.getUserId(), pmRoleId);
							}
						} else if(action.getSubUrType().equals("AT")){
							pmRoleId="R06";
							List<IpRoleMember> pmUser = ipUserService.getUserForOwnerApprove(pmRoleId);
							for(IpRoleMember member : pmUser){
								userList.add(member.getUserId());
								roleMap.put(member.getUserId(), pmRoleId);
							}
						} else if((action.getSubUrType().equals("PI")) || action.getSubUrType().equals("IG") || action.getSubUrType().equals("RT")){	
							String ipAddress = "";
							if(action.getSubUrType().equals("PI")){
								ipAddress = action.getPhyInterface().getIpNode();
							} else if(action.getSubUrType().equals("IG")){
								ipAddress = action.getGateway().getIpAddress();
							} else if(action.getSubUrType().equals("RT")){
								ipAddress = action.getRouting().getIpAddress();
							}
							IpInfo info = nwConfigService.getIpInfo(ipAddress);
							pmRoleId=info.getT2Team().getPmRoleId();
							List<IpRoleMember> pmUser = ipUserService.getUserForOwnerApprove(pmRoleId);
							for(IpRoleMember member : pmUser){
								userList.add(member.getUserId());
								roleMap.put(member.getUserId(), pmRoleId);
							}
						} 
					}
					for (String userId : userList) {
						IpUser ipUser = ipUserService.findIpUserById(userId);
						EmailDetail email = new EmailDetail();
						email.setEmail(ipUser.getEmail());
						email.setUserId(ipUser.getUserId());
						email.setUserName(ipUser.getUserName());
						email.setRequestBy(bean.getNetworkConfig().getReqUserName());
						email.setRequestDate(bean.getNetworkConfig().getReqDate());
						email.setSubject(bean.getSubject());
						email.setUrNo(bean.getUrNo());
						email.setUrStatusDesc("Wait For PM Assign");						
						email.setUrStatus("WAIT_PM");
						email.setSubjectDesc("Wait For PM Assign");
						email.setBodyDesc("Wait For PM Assign");
						email.setUrType("Request Network Config");
						email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
						if (((String)roleMap.get(ipUser.getUserId())).equals("R06")){
							email.setNodeId("N6");
						}else{
							email.setNodeId("N7");
						}
						sendEmailNotify(bean, email);
					}
				}
			}
		}
		setNetworkConfigBean(bean);
	}

	public void submitACTM() throws Exception {
		System.out.println("Validate Owner State");
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		String urNo = getRequestParameter("urNo");

		NetworkConfigValidate validate = new NetworkConfigValidate();
		String resultValidate = "";
		String resultRemark = "";
		Map<String, Object> subUr = new HashMap<String, Object>();
		if (bean.getFirewallCheck()) {
			resultRemark += (validate.checkACTMRemark(bean.getListFirewall()));
			subUr = addSubUr(subUr, bean.getListFirewall());
		}
		if (bean.getAccessListCheck()) {
			resultRemark += (validate.checkACTMRemark(bean.getListAccessList()));
			subUr = addSubUr(subUr, bean.getListAccessList());
		}
		if (bean.getAccessTNPCheck()) {
			resultRemark += (validate.checkACTMRemark(bean.getListAccessTNP()));
			subUr = addSubUr(subUr, bean.getListAccessTNP());
		}
		if (bean.getPhysicalCheck()) {
			resultRemark += (validate.checkACTMRemark(bean
					.getListPhysicalInterface()));
			subUr = addSubUr(subUr, bean.getListPhysicalInterface());
		}
		if (bean.getGatewayCheck()) {
			resultRemark += (validate.checkACTMRemark(bean.getListGateway()));
			subUr = addSubUr(subUr, bean.getListGateway());
		}
		if (bean.getRoutingCheck()) {
			resultRemark += (validate.checkACTMRemark(bean.getListRouting()));
			subUr = addSubUr(subUr, bean.getListRouting());
		}
		if (bean.getF5Check()) {
			resultRemark += (validate.checkACTMRemark(bean.getListF5()));
			subUr = addSubUr(subUr, bean.getListF5());
		}

		if (!resultRemark.equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil
					.getMessage("ER0043"), resultRemark));
			bean.setErrorFlag(true);
		} else {
			bean.setErrorFlag(false);
		}

		if (!bean.getErrorFlag()) {
			nwConfigService.submitACTM(bean.getUrNo(), userSession.getIpUser(), subUr);

//			List<IpUrAction> actionList = nwConfigService.listActionByACTMTeam(
//					urNo, userSession.getIpUser());
//
//			ArrayList<String> actionUserList = new ArrayList<String>();
//			for (IpUrAction action : actionList) {
//				for (String userName : action.getActionUserId().split(";")) {
//					if (actionList.contains(userName)) {
//						actionUserList.add(userName);
//					}
//				}
//			}

//			for (String actionUser : actionUserList) {
//				if (nwConfigService.isSendMailACTM(actionUser)) {
//					// insert mail code here
//					EmailDetail email = new EmailDetail();
//					email.setUrNo(bean.getUrNo());
//					email.setUrType("Request Network Config");
//					email.setUrStatusDesc("Wait For Config");
//					email.setUrStatus(IPFMConstant.STATUS_WAIT_CONFIG);
//					email.setSubjectDesc("Wait For Config");
//					email.setBodyDesc("Wait For Config");
//					email.setUrType("Request Network Config");
//
//					sendEmail(bean, email);
//				}
//			}
		}
		setNetworkConfigBean(bean);
	}

//	@SuppressWarnings("unchecked")
//	public void teamProcess() {
//		System.out.println("teamProcess");
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		UserSession userSession = IPFMWebUtil.getUserSession();
//		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
//		
//		NetworkConfigValidate validate = new NetworkConfigValidate();
//		String resultValidate = "";
//		String resultRemark = "";
//		String resultPIValidate = "";
//		Map<String, Object> subUr = new HashMap<String, Object>();
//		try {
//		if (bean.getFirewallCheck()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListFirewall()));
//			resultRemark += (validate.checkRemark(bean.getListFirewall(), IPFMConstant.STATUS_WAIT_TEAM));
//			subUr = addSubUr(subUr, bean.getListFirewall());
//		}
//		if (bean.getAccessListCheck()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListAccessList()));
//			resultRemark += (validate.checkRemark(bean.getListAccessList(), IPFMConstant.STATUS_WAIT_TEAM));
//			subUr = addSubUr(subUr, bean.getListAccessList());
//		}
//		if (bean.getAccessTNPCheck()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListAccessTNP()));
//			resultRemark += (validate.checkRemark(bean.getListAccessTNP(), IPFMConstant.STATUS_WAIT_TEAM));
//			subUr = addSubUr(subUr, bean.getListAccessTNP());
//		}
//		if (bean.getPhysicalCheck()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListPhysicalInterface()));
//			resultRemark += (validate.checkRemark(bean.getListPhysicalInterface(), IPFMConstant.STATUS_WAIT_TEAM));
//			resultPIValidate += (validate.checkPIAssignDetail(bean.getListPhysicalInterface()));
//			subUr = addSubUr(subUr, bean.getListPhysicalInterface());
//		}
//		if (bean.getGatewayCheck()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListGateway()));
//			resultRemark += (validate.checkRemark(bean.getListGateway(), IPFMConstant.STATUS_WAIT_TEAM));
//			subUr = addSubUr(subUr, bean.getListGateway());
//		}
//		if (bean.getRoutingCheck()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListRouting()));
//			resultRemark += (validate.checkRemark(bean.getListRouting(), IPFMConstant.STATUS_WAIT_TEAM));
//			subUr = addSubUr(subUr, bean.getListRouting());
//		}
//		if (bean.getF5Check()) {
//			//resultValidate += (validate.checkUnProcess(bean.getListF5()));
//			resultRemark += (validate.checkRemark(bean.getListF5(), IPFMConstant.STATUS_WAIT_TEAM));
//			subUr = addSubUr(subUr, bean.getListF5());
//		}
//
//		if (!resultValidate.equals("")) {
//			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0044"), resultValidate));
//			bean.setErrorFlag(true);
//		} else if (!resultRemark.equals("")) {
//			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0045"), resultRemark));
//			bean.setErrorFlag(true);
//		} else if(!resultPIValidate.equals("")) {
//			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0100"), resultPIValidate));
//			bean.setErrorFlag(true);				
//		} else {
//			bean.setErrorFlag(false);
//		}
//		} catch(Exception e) {
//			e.printStackTrace();
//			bean.setErrorMsg("Problem Occured During Process ... ");
//			bean.setErrorFlag(true);
//		}
//
//		if (!bean.getErrorFlag()) {
//			try {
//				List<IpUrAction> actionTeamList = nwConfigService.listActionTeamProcess(bean.getUrNo(), userSession.getIpUser());
//				IpUrActionService ipUrActionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
//				nwConfigService.teamProcess(bean.getUrNo(), userSession.getIpUser(), subUr);
//				List<EmailDetail> emailList = new ArrayList<EmailDetail>();
//				//IpUrStatus ipUrStatus  =  nwConfigService.getSubUrStatus("NC", IPFMConstant.STATUS_REJECT_TEAM);
//				IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
//				String subUrNoEmail = "";
//				int count = 0;
//				boolean sendMailReject = false;
//				for (IpUrAction urAction : actionTeamList) {
//					boolean hasReject = false;
//					Object subUrItem = subUr.get(urAction.getSubUrNo());
//					boolean hasWait = false;
//					if ((getProperty(subUrItem,"isReject")!=null && getProperty(subUrItem,"isReject").equals("Y"))
//						|| (getProperty(subUrItem,"isApprove")!=null && getProperty(subUrItem,"isApprove").equals("Y"))){
//						List<IpUrAction> ipUrActions = ipUrActionService.listAction(urAction.getUrNo(), urAction.getSubUrNo());
//						for(IpUrAction action : ipUrActions){
//							if (action.getUrStatus().equals(IPFMConstant.STATUS_COMPLETE_TEAM_WAIT) 
//								|| action.getUrStatus().equals(IPFMConstant.STATUS_REJECT_TEAM_WAIT)) {
//								hasWait=true; break;
//							}
//							if (action.getUrStatus().equals(IPFMConstant.STATUS_REJECT_TEAM)) {
//								hasReject = true;
//								hasWait = false;
//								break;
//							}
//						}
//						if (hasWait)continue;
//						if (hasReject) {
//							sendMailReject = true;
//							if (subUrNoEmail.equals("")) {
//								subUrNoEmail = urAction.getSubUrNo();
//							}else{
//								count++;
//								if (count<=5) {
//									subUrNoEmail = subUrNoEmail+","+urAction.getSubUrNo();
//								}else{
//									subUrNoEmail = subUrNoEmail+","+urAction.getSubUrNo()+"... Sub Ur มีมากกว่า 5 รายการ";
//									break;
//								}
//							}
//						}
//					}
//				}
//				if (sendMailReject) {
//					IpUser ipUser = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
//					EmailDetail email = new EmailDetail();
//					email.setEmail(ipUser.getEmail());
//					email.setUserId(ipUser.getUserId());
//					email.setUserName(ipUser.getUserName());
//					email.setUrNo(bean.getUrNo());
//					email.setSubUrNo(subUrNoEmail);
//					email.setUrType(IPFMConstant.URTYPENAME_NETWORK_CONFIG);
//					email.setUrStatusDesc("Reject By Team Process");
//					email.setUrStatus("REJECT_TEAM");
//					email.setSubject(bean.getSubject());
//					email.setSubjectDesc("Reject By Team Process");
//					email.setBodyDesc("Reject By Team Process");
//					email.setRequestBy(bean.getNetworkConfig().getReqUserName());
//					email.setRequestDate(bean.getNetworkConfig().getReqDate());
//					email.setUrl(getIPFMConfig().getHomeUrl());
//					email.setCreateBy(userSession.getIpUser().getUserId());
//					email.setUpdateBy(userSession.getIpUser().getUserId());
//					emailList.add(email);
//					
//					if (emailList!=null && emailList.size()>0) {
//						sendEmailTeamReject(emailList);
//					}
//				}else{
//					boolean completeFlag = true;
//					List<IpUrAction> completeList = ipUrActionService.getIpUrAction(bean.getUrNo());
//					for (IpUrAction completeAction : completeList) {
//						if (!(completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_COMPLETE_TEAM)
//							|| completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_USER))) {
//							completeFlag = false; break;
//						}
//					}
//					if (completeFlag) {
//						IpUser user = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
//						EmailDetail email = new EmailDetail();
//						email.setEmail(user.getEmail());
//						email.setUrNo(bean.getUrNo());
//						email.setUserId(user.getUserId());
//						email.setUserName(user.getUserName());
//						email.setRequestBy(bean.getNetworkConfig().getReqUserName());
//						email.setRequestDate(bean.getNetworkConfig().getReqDate());
//						email.setUrType("Request Network Config");
//						email.setUrStatusDesc("User Verify");
//						email.setUrStatus(IPFMConstant.STATUS_WAIT_USER);
//						email.setSubject(bean.getNetworkConfig().getReqSubject());
//						email.setSubjectDesc("User Verify");
//						email.setBodyDesc("User Verify");
//						email.setUrType("Request Network Config");
//						email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
//						email.setNodeId("");
//						sendEmailNotify(bean, email);
//					}
//				}
//			} catch (IPFMBusinessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				bean.setErrorMsg("Problem Occured During Process ... ");
//				bean.setErrorFlag(true);
//			} catch (Exception e){
//				e.printStackTrace();
//			}
//		}
//		setNetworkConfigBean(bean);
//		
//		try {
//			if (!bean.getErrorFlag()){
//				viewListTab(bean.getUrNo(), IPFMConstant.STATUS_WAIT_TEAM, userSession.getIpUser());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			bean.setErrorFlag(true);
//			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
//		}
//	}
	
	@SuppressWarnings("unchecked")
	public void teamProcess() {
		System.out.println("teamProcess");
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		NetworkConfigValidate validate = new NetworkConfigValidate();
		String resultValidate = "";
		String resultRemark = "";
		String resultPIValidate = "";
		Map<String, Object> subUr = new HashMap<String, Object>();
		try {
		if (bean.getFirewallCheck()) {
			//resultValidate += (validate.checkUnProcess(bean.getListFirewall()));
			resultRemark += (validate.checkRemark(bean.getListFirewall(), IPFMConstant.STATUS_WAIT_TEAM));
			subUr = addSubUr(subUr, bean.getListFirewall());
		}
		if (bean.getAccessListCheck()) {
			//resultValidate += (validate.checkUnProcess(bean.getListAccessList()));
			resultRemark += (validate.checkRemark(bean.getListAccessList(), IPFMConstant.STATUS_WAIT_TEAM));
			subUr = addSubUr(subUr, bean.getListAccessList());
		}
		if (bean.getAccessTNPCheck()) {
			//resultValidate += (validate.checkUnProcess(bean.getListAccessTNP()));
			resultRemark += (validate.checkRemark(bean.getListAccessTNP(), IPFMConstant.STATUS_WAIT_TEAM));
			subUr = addSubUr(subUr, bean.getListAccessTNP());
		}
		if (bean.getPhysicalCheck()) {
//			resultValidate += (validate.checkUnProcess(bean.getListPhysicalInterface()));
			resultRemark += (validate.checkRemarkForTrunk(bean.getListPhysicalInterface(), IPFMConstant.STATUS_WAIT_TEAM));
			resultPIValidate += (validate.checkPIAssignDetailForTrunk(bean.getListPhysicalInterface()));
			subUr = addSubUr(subUr, bean.getListPhysicalInterface());
		}
		if (bean.getGatewayCheck()) {
			//resultValidate += (validate.checkUnProcess(bean.getListGateway()));
			resultRemark += (validate.checkRemark(bean.getListGateway(), IPFMConstant.STATUS_WAIT_TEAM));
			subUr = addSubUr(subUr, bean.getListGateway());
		}
		if (bean.getRoutingCheck()) {
			//resultValidate += (validate.checkUnProcess(bean.getListRouting()));
			resultRemark += (validate.checkRemark(bean.getListRouting(), IPFMConstant.STATUS_WAIT_TEAM));
			subUr = addSubUr(subUr, bean.getListRouting());
		}
		if (bean.getF5Check()) {
			//resultValidate += (validate.checkUnProcess(bean.getListF5()));
			resultRemark += (validate.checkRemark(bean.getListF5(), IPFMConstant.STATUS_WAIT_TEAM));
			subUr = addSubUr(subUr, bean.getListF5());
		}

		if (!resultValidate.equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0044"), resultValidate));
			bean.setErrorFlag(true);
		} else if (!resultRemark.equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0045"), resultRemark));
			bean.setErrorFlag(true);
		} else if(!resultPIValidate.equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0100"), resultPIValidate));
			bean.setErrorFlag(true);				
		} else {
			bean.setErrorFlag(false);
		}
		} catch(Exception e) {
			e.printStackTrace();
			bean.setErrorMsg("Problem Occured During Process ... ");
			bean.setErrorFlag(true);
		}

		if (!bean.getErrorFlag()) {
			try {
				List<IpUrAction> actionTeamList = nwConfigService.listActionTeamProcess(bean.getUrNo(), userSession.getIpUser());
				IpUrActionService ipUrActionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
				nwConfigService.teamProcess(bean.getUrNo(), userSession.getIpUser(), subUr);
				List<EmailDetail> emailList = new ArrayList<EmailDetail>();
				//IpUrStatus ipUrStatus  =  nwConfigService.getSubUrStatus("NC", IPFMConstant.STATUS_REJECT_TEAM);
				IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
				String subUrNoEmail = "";
				int count = 0;
				boolean hasReject = false;
				for (IpUrAction urAction : actionTeamList) {
					Object subUrItem = subUr.get(urAction.getSubUrNo());
					if(subUrItem != null){
						if (getProperty(subUrItem,"isReject")!=null && getProperty(subUrItem,"isReject").equals("Y")) {
							hasReject = true;
							if (subUrNoEmail.equals("")) {
								subUrNoEmail = urAction.getSubUrNo();
							}else{
								count++;
								if (count<=5) {
									subUrNoEmail = subUrNoEmail+","+urAction.getSubUrNo();
								}else{
									subUrNoEmail = subUrNoEmail+","+urAction.getSubUrNo()+"... Sub Ur มีมากกว่า 5 รายการ";
									break;
								}
							}
						}
					}
				}
				if (hasReject) {
					IpUser ipUser = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
					EmailDetail email = new EmailDetail();
					email.setEmail(ipUser.getEmail());
					email.setUserId(ipUser.getUserId());
					email.setUserName(ipUser.getUserName());
					email.setUrNo(bean.getUrNo());
					email.setSubUrNo(subUrNoEmail);
					email.setUrType(IPFMConstant.URTYPENAME_NETWORK_CONFIG);
					email.setUrStatusDesc("Reject By Team Process");
					email.setUrStatus("REJECT_TEAM");
					email.setSubject(bean.getSubject());
					email.setSubjectDesc("Reject By Team Process");
					email.setBodyDesc("Reject By Team Process");
					email.setRequestBy(bean.getNetworkConfig().getReqUserName());
					email.setRequestDate(bean.getNetworkConfig().getReqDate());
					email.setUrl(getIPFMConfig().getHomeUrl());
					email.setCreateBy(userSession.getIpUser().getUserId());
					email.setUpdateBy(userSession.getIpUser().getUserId());
					emailList.add(email);
					
					if (emailList!=null && emailList.size()>0) {
						sendEmailTeamReject(emailList);
					}
				}else{
					boolean completeFlag = true;
					List<IpUrAction> completeList = ipUrActionService.getIpUrAction(bean.getUrNo());
					for (IpUrAction completeAction : completeList) {
						if (!(completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_COMPLETE_TEAM)
							|| completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_USER))) {
							completeFlag = false; break;
						}
					}
					if (completeFlag) {
						IpUser user = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
						EmailDetail email = new EmailDetail();
						email.setEmail(user.getEmail());
						email.setUrNo(bean.getUrNo());
						email.setUserId(user.getUserId());
						email.setUserName(user.getUserName());
						email.setRequestBy(bean.getNetworkConfig().getReqUserName());
						email.setRequestDate(bean.getNetworkConfig().getReqDate());
						email.setUrType("Request Network Config");
						email.setUrStatusDesc("User Verify");
						email.setUrStatus(IPFMConstant.STATUS_WAIT_USER);
						email.setSubject(bean.getNetworkConfig().getReqSubject());
						email.setSubjectDesc("User Verify");
						email.setBodyDesc("User Verify");
						email.setUrType("Request Network Config");
						email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
						email.setNodeId("");
						sendEmailNotify(bean, email);
					}
				}
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				bean.setErrorMsg("Problem Occured During Process ... ");
				bean.setErrorFlag(true);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		setNetworkConfigBean(bean);
		
		try {
			if (!bean.getErrorFlag()){
				viewListTab(bean.getUrNo(), IPFMConstant.STATUS_WAIT_TEAM, userSession.getIpUser());
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean.setErrorFlag(true);
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
		}
	}

	public void userVerify() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		try {
			String urNo = getRequestParameter("urNo");
			nwConfigService.userVerify(bean.getUrNo(), userSession.getIpUser());
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		setNetworkConfigBean(bean);
	}

	
	
	
	
	
	public String showDelegatePM() {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = bean.getUrNo();
		Object listUr = null;
		//String urType = getRequestParameter("currentTab");
		
		//String urType = bean.getSelectSubUR();
		
		String urType = getRequestParameter("subUrType");
		System.out.println(" select Sub Ur type ... " + urType);
		
		if (urType == null) urType = bean.getCurrentTab();
		if (urType.equals("FW")) {
			listUr = bean.getListFirewall();
		} else if (urType.equals("AL")) {
			listUr = bean.getListAccessList();
		} else if (urType.equals("AT")) {
			listUr = bean.getListAccessTNP();
		} else if (urType.equals("PI")) {
			listUr = bean.getListPhysicalInterface();
		} else if (urType.equals("IG")) {
			listUr = bean.getListGateway();
		} else if (urType.equals("RT")) {
			listUr = bean.getListRouting();
		} else if (urType.equals("F5")) {
			listUr = bean.getListF5();
		}
		
		bean.setSelectSubUR(urType);
		
		boolean isError = false;
		List<Object> listSubUr = (List<Object>) listUr;
		List<String> selectedSubUr = new ArrayList<String>();
		boolean isSomeSelectd = false;
		boolean trunkSelect = false;
		try {
			String piType = "";
			for (Object subUr : listSubUr) {
				
				if(subUr instanceof IpUrPhysicalInterface){
					Field fieldId = subUr.getClass().getDeclaredField("piType");
					fieldId.setAccessible(true);
					piType = (String) fieldId.get(subUr);
				}
				
				if (isSelected(subUr)) {
					String subUrNo = getSubUrNo(subUr);
					selectedSubUr.add(subUrNo);
					isSomeSelectd = true;
					trunkSelect = true;
					if (!nwConfigService.isDelegateAble(urNo, subUrNo, userSession.getIpUser().getUserId())) {
						bean.setErrorFlag(true);
						bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
						isError = true;
						break;
					}
				}else{
					if(StringUtils.equals("T", piType) && trunkSelect ){
						String subUrNo = getSubUrNo(subUr);
						selectedSubUr.add(subUrNo);
						isSomeSelectd = true;
						if (!nwConfigService.isDelegateAble(urNo, subUrNo, userSession.getIpUser().getUserId())) {
							bean.setErrorFlag(true);
							bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
							isError = true;
							break;
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(!isSomeSelectd) {
			setHasError(true);
			setMsgError("Error must has some selected");
			return null;
			//IPFMMessageUtils.addMessageError("DetailForm:ipVersion", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}


		try {
		if (!isError) {
//			boolean isR6 = (userSession.getIpUser().getRoleIdList().indexOf(
//					"R06") > 0);
//			boolean isR7 = (userSession.getIpUser().getRoleIdList().indexOf(
//					"R07") > 0);
			
			boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
			boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
			userSession.getIpUser().setUrl(getIPFMConfig().getHomeUrl());

			if (isR6 && isR7) {
				bean.setConfFlag(true);
				bean.setSelectedSubUr(selectedSubUr);
			} else if (isR6) {
				nwConfigService.saveDeleagte(urNo, selectedSubUr,"R07", userSession.getIpUser());
			} else if (isR7) {
				nwConfigService.saveDeleagte(urNo, selectedSubUr,"R06", userSession.getIpUser());
			}
		} 
		} catch(Exception ex) {
			ex.printStackTrace();
		}

//		for (EmailDetail mail : emailList) {
//			try {
//				sendEmail(bean, mail);
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		}

		setNetworkConfigBean(bean);
		if (bean.getModeReject()!=null && bean.getModeReject().equalsIgnoreCase(IPFMConstant.MODE_REJECT_TEAM)) {
			viewListTab(urNo, IPFMConstant.STATUS_REJECT_TEAM, userSession.getIpUser());
		}else{
			viewListTab(urNo, IPFMConstant.STATUS_WAIT_PM, userSession.getIpUser());
		}
//		if ((bean.getListFirewall()==null || bean.getListFirewall().size()==0)
//				&& (bean.getListAccessList()==null || bean.getListAccessList().size() == 0)
//				&& (bean.getListAccessTNP()==null || bean.getListAccessTNP().size() == 0)
//				&& (bean.getListPhysicalInterface()==null || bean.getListPhysicalInterface().size() == 0)
//				&& (bean.getListGateway()==null || bean.getListGateway().size() == 0)
//				&& (bean.getListRouting()==null || bean.getListRouting().size() == 0)
//				&& (bean.getListF5()==null || bean.getListF5().size() == 0)) {
//			return "homePage";
//		} 
		return null;
	}


	public String delegatePM() {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = bean.getUrNo();
		try {
			
			nwConfigService.saveDeleagte(urNo, bean.getSelectedSubUr(), bean.getDelegateTeamID(), userSession.getIpUser());
			if (bean.getModeReject()!=null && bean.getModeReject().equalsIgnoreCase(IPFMConstant.MODE_REJECT_TEAM)) {
				viewListTab(urNo, IPFMConstant.STATUS_REJECT_TEAM, userSession.getIpUser());
			}else{
				viewListTab(urNo, IPFMConstant.STATUS_WAIT_PM, userSession.getIpUser());
			}
//			if ((bean.getListFirewall()==null || bean.getListFirewall().size()==0)
//					&& (bean.getListAccessList()==null || bean.getListAccessList().size() == 0)
//					&& (bean.getListAccessTNP()==null || bean.getListAccessTNP().size() == 0)
//					&& (bean.getListPhysicalInterface()==null || bean.getListPhysicalInterface().size() == 0)
//					&& (bean.getListGateway()==null || bean.getListGateway().size() == 0)
//					&& (bean.getListRouting()==null || bean.getListRouting().size() == 0)
//					&& (bean.getListF5()==null || bean.getListF5().size() == 0)) {
//				return "homePage";
//			} 
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void showRejectWin() {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = bean.getUrNo();
		Object listUr = null;
		//String urType = getRequestParameter("currentTab");
		//String urType = bean.getSelectSubUR();
		
		String urType = getRequestParameter("subUrType");
		
		System.out.println(" select Sub Ur type ... " + urType);
		
		if (urType == null) urType = bean.getCurrentTab();
		if (urType.equals("FW")) {
			listUr = bean.getListFirewall();
		} else if (urType.equals("AL")) {
			listUr = bean.getListAccessList();
		} else if (urType.equals("AT")) {
			listUr = bean.getListAccessTNP();
		} else if (urType.equals("PI")) {
			listUr = bean.getListPhysicalInterface();
		} else if (urType.equals("IG")) {
			listUr = bean.getListGateway();
		} else if (urType.equals("RT")) {
			listUr = bean.getListRouting();
		} else if (urType.equals("F5")) {
			listUr = bean.getListF5();
		}
		
		bean.setSelectSubUR(urType);
		
		boolean isError = false;
		List<Object> listSubUr = (List<Object>) listUr;
		List<String> selectedSubUr = new ArrayList<String>();
		boolean isSomeSelectd = false;
		bean.setRejectRemark("");
		try {
		for (Object subUr : listSubUr) {
			if (isSelected(subUr)) {
				String subUrNo = getSubUrNo(subUr);
				selectedSubUr.add(subUrNo);
				isSomeSelectd = true;
				if (!nwConfigService.isRejectAble(urNo, subUrNo, userSession
						.getIpUser().getUserId())) {
					bean.setErrorFlag(true);
					bean
							.setErrorMsg(IPFMDataUtility
									.buildMessage(ErrorMessageUtil
											.getMessage("ER0053")));
					isError = true;
					break;
				}
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(!isSomeSelectd) {
			setHasError(true);
			setMsgError("Error must has some selected");
			return;
			//IPFMMessageUtils.addMessageError("DetailForm:ipVersion", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}


		setNetworkConfigBean(bean);
	}
	
	
	public String rejectPM() {
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		
		if(bean.getRejectRemark() == null || bean.getRejectRemark().equals("")) {
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0107")));
			return "";
		}
		
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		String urNo = bean.getUrNo();
		Object listUr = null;
		String urType = bean.getSelectSubUR();
		if (urType == null) urType = bean.getCurrentTab();
		if (urType.equals("FW")) {
			listUr = bean.getListFirewall();
		} else if (urType.equals("AL")) {
			listUr = bean.getListAccessList();
		} else if (urType.equals("AT")) {
			listUr = bean.getListAccessTNP();
		} else if (urType.equals("PI")) {
			listUr = bean.getListPhysicalInterface();
		} else if (urType.equals("IG")) {
			listUr = bean.getListGateway();
		} else if (urType.equals("RT")) {
			listUr = bean.getListRouting();
		} else if (urType.equals("F5")) {
			listUr = bean.getListF5();
		}
		boolean isError = false;
		List<Object> listSubUr = (List<Object>) listUr;
		List<String> selectedSubUr = new ArrayList<String>();
		boolean isSomeSelectd = false;
		try {
		for (Object subUr : listSubUr) {
//			
//			if (isSelected(subUr)) {
				String subUrNo = getSubUrNo(subUr);
				selectedSubUr.add(subUrNo);
				isSomeSelectd = true;
//				if (!nwConfigService.isRejectAble(urNo, subUrNo, userSession
//						.getIpUser().getUserId())) {
//					bean.setErrorFlag(true);
//					bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
//					isError = true;
//					break;
//				}
//			}
		}
		} catch(Exception e) {
			e.printStackTrace();
			bean
			.setErrorMsg("Error Occured during Process...");
		}
		
		if(!isSomeSelectd) {
			setHasError(true);
			setMsgError("Error must has some selected");
			return null;
			//IPFMMessageUtils.addMessageError("DetailForm:ipVersion", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}


		try {
			if (!isError) {
				nwConfigService.rejectUnCompleteSubUr(urNo, selectedSubUr,userSession.getIpUser(), bean.getRejectRemark());
				viewListTab(urNo, IPFMConstant.STATUS_WAIT_PM, userSession.getIpUser());
				
				IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
				IpUser user = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
				EmailDetail email = new EmailDetail();
				email.setEmail(user.getEmail());
				email.setUrNo(bean.getUrNo());
				email.setUserId(user.getUserId());
				email.setUserName(user.getUserName());
				email.setRequestBy(bean.getNetworkConfig().getReqUserName());
				email.setRequestDate(bean.getNetworkConfig().getReqDate());
				email.setUrType("Request Network Config");
				email.setUrStatusDesc("Reject By PM");
				email.setUrStatus(IPFMConstant.STATUS_REJECT_PM);
				email.setSubject(bean.getNetworkConfig().getReqSubject());
				email.setSubjectDesc("Reject By PM");
				email.setBodyDesc("Reject By PM");
				email.setUrType("Request Network Config");
				email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
				email.setNodeId("");
				sendEmailNotify(bean, email);
			} 
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		setNetworkConfigBean(bean);	
//		if ((bean.getListFirewall()==null || bean.getListFirewall().size()==0)
//				&& (bean.getListAccessList()==null || bean.getListAccessList().size() == 0)
//				&& (bean.getListAccessTNP()==null || bean.getListAccessTNP().size() == 0)
//				&& (bean.getListPhysicalInterface()==null || bean.getListPhysicalInterface().size() == 0)
//				&& (bean.getListGateway()==null || bean.getListGateway().size() == 0)
//				&& (bean.getListRouting()==null || bean.getListRouting().size() == 0)
//				&& (bean.getListF5()==null || bean.getListF5().size() == 0)) {
//			return "homePage";
//		} 
		return null;
	}

	
	public void setMessageError() {
		String errNo = getRequestParameter("errNo");
		ReqNWConfigBean bean = getNetworkConfigBean();
		bean.setErrorFlag(true);
		bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage(errNo)));
		setNetworkConfigBean(bean);
	}

	public void selectAssignType(ActionEvent action) {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		String changeTo = getRequestParameter("changeTo");
		if (changeTo.equals("T")) {
			bean.getPmAssign().setAssignForPerson("");
			List<SelectItem> listPerson = new ArrayList<SelectItem>();
			List<String> StringList = new ArrayList<String>();

			for (SelectItem item : bean.getListPerson()) {
				StringList.add(new String(item.getValue().toString()));
			}
			bean.getPmAssign().setSelectedPerson(StringList);
			bean.setListPerson(listPerson);
			bean.getPmAssign().setAssignForTeam("T");
			bean.getPmAssign().setAssignForPerson("");
			bean.getPmAssign().setTeamEnable(false);
			bean.getPmAssign().setPersonEnable(true);
			bean.getPmAssign().setIsPersonCdn(false);
			bean.getPmAssign().setIsPersonCdno(false);
			bean.getPmAssign().setIsPersonSta1(false);
			bean.getPmAssign().setIsPersonSta2(false);
			bean.getPmAssign().setIsPersonTdno(false);
		} else if (changeTo.equals("P")) {
			bean.getPmAssign().setAssignForTeam("");
			List<SelectItem> listPerson = new ArrayList<SelectItem>();
			List<String> selectedPerson = new ArrayList<String>();

			boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
			boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));


			if (isR6 && isR7) {
				bean.setIsTnp(false);
			} else if (isR6) {
				bean.setIsTnp(true);
				List<IpRoleMember> userList = nwConfigService
						.listPerson(getPersonId());
				for (IpRoleMember user : userList) {
					SelectItem item = new SelectItem();
					item.setLabel("[" + user.getIpRole().getRoleName() + "] " + user.getIpUser().getUserName());
					item.setValue(user.getUserId() + ":split:" + user.getIpUser().getUserName()+user.getIpUser().getPhone() + "_" + user.getIpRole().getRoleId());
					listPerson.add(item);
				}
			} else if (isR7) {
				bean.setIsTnp(true);
				List<IpRoleMember> userList = nwConfigService.listPerson(getPersonId());
				for (IpRoleMember user : userList) {
					SelectItem item = new SelectItem();
					item.setLabel("[" + user.getIpRole().getRoleName() + "] " + user.getIpUser().getUserName());
					item.setValue(user.getUserId() + ":split:" + user.getIpUser().getUserName()+user.getIpUser().getPhone() + "_" + user.getIpRole().getRoleId());
					listPerson.add(item);
				}

			}
			bean.setListPerson(listPerson);
			bean.getPmAssign().setSelectedPerson(selectedPerson);
			bean.getPmAssign().setAssignForTeam("");
			bean.getPmAssign().setAssignForPerson("P");
			bean.getPmAssign().setTeamEnable(true);
			bean.getPmAssign().setPersonEnable(false);
			bean.getPmAssign().setIsTeamCdn(false);
			bean.getPmAssign().setIsTeamCdno(false);
			bean.getPmAssign().setIsTeamSta1(false);
			bean.getPmAssign().setIsTeamSta2(false);
			bean.getPmAssign().setIsTeamTdno(false);
		}
		bean.setByPerson(bean.getPmAssign().getAssignForPerson().equals("P"));
		// bean.setListPerson(null);
		// bean.getPmAssign().setSelectedPerson(null);
		setNetworkConfigBean(bean);
	}

	public void addAssignPerson(ActionEvent action) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = bean.getPmAssign().getSelectedPerson();
		if(selectedPerson == null) {
			selectedPerson = new ArrayList<String>();
		}
		List<IpRoleMember> userList = nwConfigService.listPerson(getPersonId());
		for (IpRoleMember user : userList) {
			SelectItem item = new SelectItem();
			item.setLabel("[" + user.getIpRole().getRoleName() + "] "
					+ user.getIpUser().getUserName());
			item.setValue(user.getUserId() + ":split:"
					+ user.getIpUser().getUserName()+ user.getIpUser().getPhone() + "_"
					+ user.getIpRole().getRoleId());
			listPerson.add(item);
		}
		bean.setListPerson(listPerson);
		bean.getPmAssign().setSelectedPerson(selectedPerson);
		setNetworkConfigBean(bean);

	}
	
	public void addDelegatePerson(ActionEvent action) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = bean.getPmDelegate().getSelectedDelegatePerson();
		if(selectedPerson == null) {
			selectedPerson = new ArrayList<String>();
		}
		
		
		boolean isR6 = bean.getPmDelegate().getIsTeamTdno();
		boolean isR7 = bean.getPmDelegate().getIsTeamCdn();


		if (isR6) {
			List<IpRoleMember> userList = nwConfigService.listPerson("R06");
			
			
			for (IpRoleMember user : userList) {
				SelectItem item = new SelectItem();
				item.setLabel("[" + user.getIpRole().getRoleName() + "] " + user.getIpUser().getUserName());
				item.setValue(user.getUserId() + ":" + user.getIpUser().getUserName()+user.getIpUser().getPhone());
				listPerson.add(item);
			}
		} 
				
		if (isR7) {
			List<IpRoleMember> userList = nwConfigService.listPerson("R07");
			for (IpRoleMember user : userList) {
				SelectItem item = new SelectItem();
				item.setLabel("[" + user.getIpRole().getRoleName() + "] "+ user.getIpUser().getUserName());
				item.setValue(user.getUserId() + ":" + user.getIpUser().getUserName()+user.getIpUser().getPhone());
				listPerson.add(item);
			}
		}
		
		bean.setListdgp(listPerson);
		bean.getPmDelegate().setSelectedDelegatePerson(selectedPerson);
		setNetworkConfigBean(bean);

	}

	
	private void addUserToTeam(List<String> selectedPerson, String urType,
			ReqNWConfigBean bean, IPUserService userService) throws Exception {
		try {
			UserSession userSession = IPFMWebUtil.getUserSession();
			boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
			boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
			if (urType.equals("FW")) {
				if (bean.getPmAssign().getIsTeamCdno()) {// R12
					findAndSetSelectedPerson(selectedPerson, "R12", userService);
				} if (bean.getPmAssign().getIsTeamSta1()) { // R10
					findAndSetSelectedPerson(selectedPerson, "R10", userService);
				} if (bean.getPmAssign().getIsTeamSta2()) { // R11
					findAndSetSelectedPerson(selectedPerson, "R11", userService);
				}
			} else {
				if (isR6 && !isR7) {
					findAndSetSelectedPerson(selectedPerson, "R09", userService);
				} else if(!isR6 && isR7) {
					if (urType.equals("AL")) {
						findAndSetSelectedPerson(selectedPerson, "R13", userService);
					} else if (urType.equals("AT")) {
						findAndSetSelectedPerson(selectedPerson, "R13", userService);
					} else if (urType.equals("PI")) {
						findAndSetSelectedPerson(selectedPerson, "R14", userService);
					} else if (urType.equals("IG")) {
						findAndSetSelectedPerson(selectedPerson, "R15", userService);
					} else if (urType.equals("RT")) {
						findAndSetSelectedPerson(selectedPerson, "R16", userService);
					} else if (urType.equals("F5")) {
						findAndSetSelectedPerson(selectedPerson, "R17", userService);
					}					
				} else if(isR6 && isR7) {
					if (urType.equals("AL") && bean.getPmAssign().getIsTeamCdn()) {
						findAndSetSelectedPerson(selectedPerson, "R13", userService);
					} else if (urType.equals("AT") && bean.getPmAssign().getIsTeamCdn()) {
						findAndSetSelectedPerson(selectedPerson, "R13", userService);
					} else if (urType.equals("PI") && bean.getPmAssign().getIsTeamCdn()) {
						findAndSetSelectedPerson(selectedPerson, "R14", userService);
					} else if (urType.equals("IG") && bean.getPmAssign().getIsTeamCdn()) {
						findAndSetSelectedPerson(selectedPerson, "R15", userService);
					} else if (urType.equals("RT") && bean.getPmAssign().getIsTeamCdn()) {
						findAndSetSelectedPerson(selectedPerson, "R16", userService);
					} else if (urType.equals("F5") && bean.getPmAssign().getIsTeamCdn()) {
						findAndSetSelectedPerson(selectedPerson, "R17", userService);
					}					
				}
			}
			if (bean.getPmAssign().getIsTeamTdno()) {
				findAndSetSelectedPerson(selectedPerson, "R09", userService);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	private void findAndSetSelectedPerson(List<String> selectedPerson,
			String roleId, IPUserService userService)
			throws IPFMBusinessException {
		List<IpUser> users = userService.findUserByRoleId(roleId);
		for (IpUser user : users) {
			selectedPerson.add(user.getUserId() + ":split:" + user.getUserName() + user.getPhone() + "_" + roleId);
		}
	}

	public String pmAssignment() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPUserService userService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");

		UserSession userSession = IPFMWebUtil.getUserSession();
		String urNo = bean.getUrNo();
		Object listUr = null;
		String urType = bean.getSelectSubUR();
		if (urType == null) urType = bean.getCurrentTab();
		if (urType.equals("FW")) {
			listUr = bean.getListFirewall();
		} else if (urType.equals("AL")) {
			listUr = bean.getListAccessList();
		} else if (urType.equals("AT")) {
			listUr = bean.getListAccessTNP();
		} else if (urType.equals("PI")) {
			listUr = bean.getListPhysicalInterface();
		} else if (urType.equals("IG")) {
			listUr = bean.getListGateway();
		} else if (urType.equals("RT")) {
			listUr = bean.getListRouting();
		} else if (urType.equals("F5")) {
			listUr = bean.getListF5();
		}

		List<String> selectedPersonList = bean.getPmAssign().getSelectedPerson();
		List<PMAssetDTO> pmAssetDTOList = new ArrayList<PMAssetDTO>();
		PMAssetDTO pmAssetDTOR09 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR10 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR11 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR12 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR13 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR14 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR15 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR16 = new PMAssetDTO();
		PMAssetDTO pmAssetDTOR17 = new PMAssetDTO();

		if(bean.getPmAssign().getAssignForPerson() != null && !"".equals(bean.getPmAssign().getAssignForPerson())) { // validate person
			if(selectedPersonList == null || selectedPersonList.size() == 0) {
				bean.setErrorFlag(true);
				bean.setErrorMsg("Please Select User to be Assigned.");
				setNetworkConfigBean(bean);		
				return null;
			}
		}
		if (selectedPersonList != null && selectedPersonList.size() > 0) {
			for (String selectedPerson : selectedPersonList) {
				if (selectedPerson.contains("R09")) {
					pmAssetDTOR09.setSubURType(urType);
					pmAssetDTOR09.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR09.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R10")) {
					pmAssetDTOR10.setSubURType(urType);
					pmAssetDTOR10.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR10.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R11")) {
					pmAssetDTOR11.setSubURType(urType);
					pmAssetDTOR11.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR11.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R12")) {
					pmAssetDTOR12.setSubURType(urType);
					pmAssetDTOR12.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR12.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R13")) {
					pmAssetDTOR13.setSubURType(urType);
					pmAssetDTOR13.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR13.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R14")) {
					pmAssetDTOR14.setSubURType(urType);
					pmAssetDTOR14.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR14.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R15")) {
					pmAssetDTOR15.setSubURType(urType);
					pmAssetDTOR15.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR15.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R16")) {
					pmAssetDTOR16.setSubURType(urType);
					pmAssetDTOR16.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR16.setRoleId(selectedPerson.split("_")[1]);
				} else if (selectedPerson.contains("R17")) {
					pmAssetDTOR17.setSubURType(urType);
					pmAssetDTOR17.getSelectUserIdList().add(selectedPerson.split("_")[0]);
					pmAssetDTOR17.setRoleId(selectedPerson.split("_")[1]);
				}
			}
		} else { // Team Selection
			List<String> userTeamList = bean.getSelectedPerson();
//			if (userTeamList == null) {
				userTeamList = new ArrayList<String>();
				bean.setSelectedPerson(userTeamList);
//			}
			try {
//				if(userTeamList.size() == 0) {
					addUserToTeam(userTeamList, urType, bean, userService);
//				}
				if(bean.getPmAssign().getAssignForTeam() != null && !"".equals(bean.getPmAssign().getAssignForTeam())) { // validate Team
					if(bean.getSelectedPerson() == null || bean.getSelectedPerson().size() == 0) {
						bean.setErrorFlag(true);
						bean.setErrorMsg("Please Select Team to be Assigned.");
						setNetworkConfigBean(bean);			
						return null;
					}
				}			
				
				if (userTeamList != null) {
					for (String userTeam : userTeamList) {
						if (userTeam.contains("R09")) {
							pmAssetDTOR09.setSubURType(urType);
							pmAssetDTOR09.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR09.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R10")) {
							pmAssetDTOR10.setSubURType(urType);
							pmAssetDTOR10.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR10.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R11")) {
							pmAssetDTOR11.setSubURType(urType);
							pmAssetDTOR11.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR11.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R12")) {
							pmAssetDTOR12.setSubURType(urType);
							pmAssetDTOR12.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR12.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R13")) {
							pmAssetDTOR13.setSubURType(urType);
							pmAssetDTOR13.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR13.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R14")) {
							pmAssetDTOR14.setSubURType(urType);
							pmAssetDTOR14.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR14.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R15")) {
							pmAssetDTOR15.setSubURType(urType);
							pmAssetDTOR15.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR15.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R16")) {
							pmAssetDTOR16.setSubURType(urType);
							pmAssetDTOR16.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR16.setRoleId(userTeam.split("_")[1]);
						} else if (userTeam.contains("R17")) {
							pmAssetDTOR17.setSubURType(urType);
							pmAssetDTOR17.getSelectUserIdList().add(
									userTeam.split("_")[0]);
							pmAssetDTOR17.setRoleId(userTeam.split("_")[1]);
						}

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (pmAssetDTOR09.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR09);
		}
		if (pmAssetDTOR10.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR10);
		}
		if (pmAssetDTOR11.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR11);
		}
		if (pmAssetDTOR12.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR12);
		}
		if (pmAssetDTOR13.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR13);
		}
		if (pmAssetDTOR14.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR14);
		}
		if (pmAssetDTOR15.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR15);
		}
		if (pmAssetDTOR16.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR16);
		}
		if (pmAssetDTOR17.getSelectUserIdList().size() > 0) {
			pmAssetDTOList.add(pmAssetDTOR17);
		}

		boolean isError = false;
		List<Object> listSubUr = (List<Object>) listUr;
		List<String> subUrList = new ArrayList<String>();
		try{
			HashMap<String, String> tmpMap = new HashMap<String, String>();
			String piType = "";
			String trunkFlag = "";
			String trunkNo = "";
			for (Object subUr : listSubUr) {
				if(subUr instanceof IpUrPhysicalInterface){
					Field piTypeField = subUr.getClass().getDeclaredField("piType");
					piTypeField.setAccessible(true);
					piType = (String) piTypeField.get(subUr);
					
					Field trunkFlagField = subUr.getClass().getDeclaredField("trunkFlag");
					trunkFlagField.setAccessible(true);
					trunkFlag = (String) trunkFlagField.get(subUr);
					
					Field trunkNoField = subUr.getClass().getDeclaredField("trunkNo");
					trunkNoField.setAccessible(true);
					trunkNo = (String) trunkNoField.get(subUr);
				}
				if(StringUtils.equals("T", piType)){
					if(StringUtils.equals("T", trunkFlag)){
						if (isSelected(subUr)) {
							subUrList.add(getSubUrNo(subUr));
							tmpMap.put(trunkNo,"Y");
						}
					}else{
						if(StringUtils.equals("Y", tmpMap.get(trunkNo))){
							subUrList.add(getSubUrNo(subUr));
						}
					}
				}else{
					if (isSelected(subUr)) {
						subUrList.add(getSubUrNo(subUr));
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			bean.getPmAssign().setHomeUrl(getIPFMConfig().getHomeUrl());
//			nwConfigService.savePMAssign(urNo, subUrList, pmAssetDTOList,userSession.getIpUser(), bean.getPmAssign());
			nwConfigService.savePMAssign(urNo,urType, listSubUr, subUrList, pmAssetDTOList,userSession.getIpUser(), bean.getPmAssign());
		} catch (Exception e) {
			e.printStackTrace();
			bean.setErrorFlag(true);
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
		}
		setNetworkConfigBean(bean);
		
		try {
			if (bean.getModeReject()!=null && bean.getModeReject().equals(IPFMConstant.MODE_REJECT_TEAM)) {
				viewListTab(urNo, IPFMConstant.STATUS_REJECT_TEAM, userSession.getIpUser());
			}else{
				viewListTab(urNo, IPFMConstant.STATUS_WAIT_PM, userSession.getIpUser());
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean.setErrorFlag(true);
			bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0053")));
		}
		return null;
	}

	public String navigateHomepage(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		if ((bean.getListFirewall()==null || bean.getListFirewall().size()==0)
				&& (bean.getListAccessList()==null || bean.getListAccessList().size() == 0)
				&& (bean.getListAccessTNP()==null || bean.getListAccessTNP().size() == 0)
				&& (bean.getListPhysicalInterface()==null || bean.getListPhysicalInterface().size() == 0)
				&& (bean.getListGateway()==null || bean.getListGateway().size() == 0)
				&& (bean.getListRouting()==null || bean.getListRouting().size() == 0)
				&& (bean.getListF5()==null || bean.getListF5().size() == 0)) {
			return "homePage";
		} 
		return null;
	}
	
	private String getPersonId() {
		String result = "";
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();

		String urType = bean.getSelectSubUR();
		
		boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
		boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
		
		if (urType.equals("FW")) {
			if (bean.getPmAssign().getIsPersonCdno()) {// R12
				result +="R12;";
			} if (bean.getPmAssign().getIsPersonSta1()) { // R10
				result +="R10;";
			} if (bean.getPmAssign().getIsPersonSta2()) { // R11
				result +="R11;";
			}
		} else {
			if (isR6 && !isR7) {
				result +="R09;";
			} else if(!isR6 && isR7) {
				if (urType.equals("AL")) {
					result +="R13;";
				} else if (urType.equals("AT")) {
					result +="R13;";
				} else if (urType.equals("PI")) {
					result +="R14;";
				} else if (urType.equals("IG")) {
					result +="R15;";
				} else if (urType.equals("RT")) {
					result +="R16;";
				} else if (urType.equals("F5")) {
					result +="R17;";
				}					
			} else if(isR6 && isR7) {
				if (urType.equals("AL") && bean.getPmAssign().getIsPersonCdn()) {
					result +="R13;";
				} else if (urType.equals("AT") && bean.getPmAssign().getIsPersonCdn()) {
					result +="R13;";
				} else if (urType.equals("PI") && bean.getPmAssign().getIsPersonCdn()) {
					result +="R14;";
				} else if (urType.equals("IG") && bean.getPmAssign().getIsPersonCdn()) {
					result +="R15;";
				} else if (urType.equals("RT") && bean.getPmAssign().getIsPersonCdn()) {
					result +="R16;";
				} else if (urType.equals("F5") && bean.getPmAssign().getIsPersonCdn()) {
					result +="R17;";
				}					
			}
		}
		if (bean.getPmAssign().getIsPersonTdno()) {
			result +="R09;";
		}

		return result;
	}

	private String getTeamId() {
		String result = "";
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();

		boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
		boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));

		if (isR7) {
			if (bean.getPmAssign().getIsTeamCdno()
					&& bean.getSelectSubUR().equals("FW")) {
				result += "R12;";
			}
			if (bean.getPmAssign().getIsTeamSta1()
					&& bean.getSelectSubUR().equals("FW")) {
				result += "R10;";
			}
			if (bean.getPmAssign().getIsTeamSta2()
					&& bean.getSelectSubUR().equals("FW")) {
				result += "R11;";
			}
			if (bean.getPmAssign().getIsTeamTdno()) {
				result += "R09;";
			}
			if (bean.getPmAssign().getIsTeamCdn()
					&& bean.getSelectSubUR().equals("AL")) {
				result += "R13;";
			}
			if (bean.getPmAssign().getIsTeamCdn()
					&& bean.getSelectSubUR().equals("AT")) {
				result += "R13;";
			}
			if (bean.getPmAssign().getIsTeamCdn()
					&& bean.getSelectSubUR().equals("PI")) {
				result += "R14;";
			}
			if (bean.getPmAssign().getIsTeamCdn()
					&& bean.getSelectSubUR().equals("IG")) {
				result += "R15;";
			}
			if (bean.getPmAssign().getIsTeamCdn()
					&& bean.getSelectSubUR().equals("RT")) {
				result += "R16;";
			}
			if (bean.getPmAssign().getIsTeamCdn()
					&& bean.getSelectSubUR().equals("F5")) {
				result += "R17;";
			} 
		} else if (isR6) {
			result = "R09;";
		}

		return result;
	}

	public void showAssignWin() {
		System.out.println("Show Assign window");
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");

		boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
		boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
		
		String subUrType = getRequestParameter("subUrType");
		
		System.out.println(" select Sub Ur type ... " + subUrType);
		
		if(subUrType == null) {
			subUrType = "";
		}
		
		bean.setSelectSubUR(subUrType);

		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = new ArrayList<String>();
		bean.setListPerson(listPerson);
		PmAssign pm = new PmAssign();
		pm.setSelectedPerson(selectedPerson);
		pm.setAssignForTeam("T");
		pm.setPersonEnable(true);
		bean.setPmAssign(pm);

		if (isR6 && isR7) {
			bean.setIsTnp(false);
		} else if (isR6) {
			bean.setIsTnp(true);
			List<IpRoleMember> userList = nwConfigService
					.listPerson(getTeamId());
			List<String> StringList = new ArrayList<String>();
			for (IpRoleMember ipRoleMember : userList) {
				StringList.add(new String(ipRoleMember.getUserId()));
			}
			bean.getPmAssign().setSelectedPerson(StringList);

		} else if (isR7) {
			bean.setIsTnp(true);
			List<IpRoleMember> userList = nwConfigService
					.listPerson(getTeamId());
			List<String> StringList = new ArrayList<String>();
			for (IpRoleMember ipRoleMember : userList) {
				StringList.add(new String(ipRoleMember.getUserId()));
			}
			bean.getPmAssign().setSelectedPerson(StringList);
		}

		setNetworkConfigBean(bean);

	}

	private boolean isSelected(Object obj) {
		boolean done = false;
		try {
			Field fieldId = obj.getClass().getDeclaredField("isSelected");
			fieldId.setAccessible(true);
			done = (Boolean) fieldId.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}
	
	private String getProperty(Object obj, String name) {
		String result = "";
		try {
			Field fieldId = obj.getClass().getDeclaredField(name);
			fieldId.setAccessible(true);
			result = (String) fieldId.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			result = "";
		}
		return result;
	}

	private String getSubUrNo(Object obj) {
		String result = "";
		try {
			Field fieldId = obj.getClass().getDeclaredField("id");
			fieldId.setAccessible(true);
			Object idObj = fieldId.get(obj);
			Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
			fieldSubUrNO.setAccessible(true);
			result = (String) fieldSubUrNO.get(idObj);
			fieldSubUrNO.setAccessible(false);
			fieldId.setAccessible(false);

		} catch (Exception e) {
			e.printStackTrace();
			result = "";
		}
		return result;
	}

	private Map addSubUr(Map source, List list) {
		try {
			for (Object obj : list) {
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);
				Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
				fieldSubUrNO.setAccessible(true);
				String subUrNo = (String) fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);
				fieldId.setAccessible(false);
				source.put(subUrNo, obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return source;
	}

	public void findAssignDateil() {
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");

		ReqNWConfigBean bean = getNetworkConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
//		List<IpvJobAssign> jobAssign = nwConfigService.getJobAssignDetail(urNo,subUrNo);
		List<IpvJobAssign> jobAssign = nwConfigService.findListTeamReject(urNo,subUrNo);
		boolean isComplete = nwConfigService.isJobComplete(urNo, subUrNo);
		String actmRemark ="";
		try {
			actmRemark = nwConfigService.findActmRemark(urNo, subUrNo);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
		IpUrFirewallId  ipUrFirewallId =  new IpUrFirewallId(urNo,subUrNo);
		IpUrFirewall ipUrFirewall = new  IpUrFirewall();
		IPFirewallBean  iPFirewallBean = new  IPFirewallBean();
		ipUrFirewall.setActmRemark(actmRemark);
		ipUrFirewall.setId(ipUrFirewallId);
		iPFirewallBean.setSearchResult(ipUrFirewall);
		IpUrAction action = nwConfigService.findActionByUrNo(urNo, subUrNo);
		String rejectRemark = "";
//		rejectRemark = action.getUserRemark();
		bean.setRejectRemark(rejectRemark);
		bean.setFirewall(iPFirewallBean);
		bean.setJobAssign(jobAssign);
		bean.setIsCompleteJob(isComplete);

		setNetworkConfigBean(bean);
	}

	public List<SelectItem> getJobStatus() {
		List<SelectItem> listResult = new ArrayList<SelectItem>();
		IPFMRichComboItem cbitem1 = new IPFMRichComboItem();
		cbitem1.setLabel("Completed");
		cbitem1.setValue("C");
		listResult.add(new SelectItem(cbitem1, cbitem1.getLabel()));

		IPFMRichComboItem cbitem2 = new IPFMRichComboItem();
		cbitem2.setLabel("Rejected");
		cbitem2.setValue("R");
		listResult.add(new SelectItem(cbitem2, cbitem2.getLabel()));

		return listResult;
	}

	public String forceComplete() {
		try{
			String urNo = getRequestParameter("urNo");
			String subUrNo = getRequestParameter("subUrNo");
			UserSession userSession = IPFMWebUtil.getUserSession();
			ReqNWConfigBean bean = getNetworkConfigBean();
			//String status = bean.getForceStatus().getValue();
			String status = bean.getForceJobStatus();
			IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
			IpUrActionService ipUrActionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
			IPUserService ipUserService = (IPUserService) JSFServiceFinderUtil.getInstance().getBean("ipUserService");
//			if (status.equals("Rejected")) {
//				nwConfigService.forceRejectStatus(urNo, subUrNo, userSession.getIpUser());
//			} else if (status.equals("Completed")) {
//				nwConfigService.forceCompleteStatus(urNo, subUrNo, userSession.getIpUser());
//			}
			
			if (status.equals("Completed")) {
				nwConfigService.forceCompleteStatus(urNo, subUrNo, userSession.getIpUser(),bean.getRejectRemark());
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				viewListTab(urNo, IPFMConstant.MODE_REJECT_TEAM, userSession.getIpUser());
				setNetworkConfigBean(bean);
				
				boolean completeFlag = true;
				List<IpUrAction> completeList = ipUrActionService.getIpUrAction(bean.getUrNo());
				for (IpUrAction completeAction : completeList) {
					if (!(completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_COMPLETE_TEAM)
						|| completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_COMPLETE_PM)
						|| completeAction.getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_USER))) {
						completeFlag = false; break;
					}
				}
				if (completeFlag) {
					IpUser user = ipUserService.findIpUserById(bean.getNetworkConfig().getReqUserId());
					EmailDetail email = new EmailDetail();
					email.setEmail(user.getEmail());
					email.setUrNo(bean.getUrNo());
					email.setUserId(user.getUserId());
					email.setUserName(user.getUserName());
					email.setRequestBy(bean.getNetworkConfig().getReqUserName());
					email.setRequestDate(bean.getNetworkConfig().getReqDate());
					email.setUrType("Request Network Config");
					email.setUrStatusDesc("User Verify");
					email.setUrStatus(IPFMConstant.STATUS_WAIT_USER);
					email.setSubject(bean.getNetworkConfig().getReqSubject());
					email.setSubjectDesc("User Verify");
					email.setBodyDesc("User Verify");
					email.setUrType("Request Network Config");
					email.setTemplateEmail(EMailService.TEMPLATE_IPFM_NC_UR);
					email.setNodeId("");
					sendEmailNotify(bean, email);
				}
				return null;
			}

		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	public void deleteSelectedSubUr() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urType = bean.getCurrentTab();
		if (urType.equals("FW")) {
			String subUrNo = "";
			List<IpUrFirewall> fwList = bean.getListFirewall();
			FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
					.getInstance().getBean("firewallService");
			for (IpUrFirewall fw : fwList) {
				if (fw.getIsSelected()) {
					IpUrFirewall firewall = firewallService.findFirewall(fw
							.getId().getUrNo(), fw.getId().getSubUrNo());
					String changeType = (firewall.getChangeType() != null) ? firewall
							.getChangeType()
							: "";
					if (changeType.equals("A")) {
						firewallService.delete(firewall);
					} else {
						firewall.setChangeType("D");
						firewallService.updateFirewall(firewall);
					}
				}
			}
			List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean
					.getUrNo());
			if(listFirewall != null && listFirewall.size() <= 0) {
				bean.getFirewall().setSubMode("ADD");
			}
			if (bean.getFirewall()!=null) {
				bean.getFirewall().setCheckAll(false);
			}
			bean.setListFirewall(listFirewall);
		} else if (urType.equals("AL")) {
			String subUrNo = "";
			List<IpUrAccessListCdn> alList = bean.getListAccessList();
			AccessListService cdnService = (AccessListService) JSFServiceFinderUtil
					.getInstance().getBean("accessListService");
			for (IpUrAccessListCdn al : alList) {
				if (al.getIsSelected()) {
					IpUrAccessListCdn cnd = cdnService.findAccessListCdn(al
							.getId().getUrNo(), al.getId().getSubUrNo());
					String changeType = (cnd.getChangeType() != null) ? cnd
							.getChangeType() : "";
					if (changeType.equals("A")) {
						cdnService.delete(cnd);
					} else {
						cnd.setChangeType("D");
						try {
							cdnService.update(cnd);
						} catch (IPFMBusinessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			List<IpUrAccessListCdn> list = cdnService
					.findByUrNo(bean.getUrNo());
			if(list != null && list.size() <= 0) {
				bean.getAccessList().setSubMode("ADD");
			}		
			if (bean.getAccessList()!=null) {
				bean.getAccessList().setCheckAll(false);
			}
			bean.setListAccessList(list);
		} else if (urType.equals("AT")) {
			String subUrNo = "";
			List<IpUrAccessListTnp> atList = bean.getListAccessTNP();
			AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil
					.getInstance().getBean("accessListTNPService");
			for (IpUrAccessListTnp at : atList) {
				if (at.getIsSelected()) {
					IpUrAccessListTnp tnp = tnpService.findAccessListTnp(at
							.getId().getUrNo(), at.getId().getSubUrNo());
					String changeType = (tnp.getChangeType() != null) ? tnp
							.getChangeType() : "";
					if (changeType.equals("A")) {
						tnpService.delete(tnp);
					} else {
						tnp.setChangeType("D");
						tnpService.update(tnp);
					}
				}
			}
			List<IpUrAccessListTnp> list = tnpService
					.findByUrNo(bean.getUrNo());
			
//			if(list != null && list.size() <= 0) {
//				bean.getAccessListTNP().setSubMode("ADD");
//			}
			if (bean.getAccessListTNP()!=null) {
				bean.getAccessListTNP().setCheckAll(false);
			}
			bean.setListAccessTNP(list);
		} else if (urType.equals("PI")) {
			String subUrNo = "";
			PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil
					.getInstance().getBean("phyInterfaceService");
			List<IpUrPhysicalInterface> piList = bean
					.getListPhysicalInterface();
			for (IpUrPhysicalInterface pi : piList) {
				if (pi.getIsSelected()) {
					IpUrPhysicalInterface intf = phyIntfService
							.findPhyInterface(pi.getId().getUrNo(), pi.getId()
									.getSubUrNo());
					String changeType = (intf.getChangeType() != null) ? intf
							.getChangeType() : "";
					if (changeType.equals("A")) {
						phyIntfService.delete(intf);
					} else {
						intf.setChangeType("D");
						phyIntfService.update(intf);
					}
				}
			}
			List<IpUrPhysicalInterface> list = phyIntfService.findByUrNo(bean
					.getUrNo());
			if (bean.getPhyInterface()!=null) {
				bean.getPhyInterface().setCheckAll(false);
			}
			bean.setListPhysicalInterface(list);
		} else if (urType.equals("IG")) {
			String subUrNo = "";
			List<IpUrInterfaceGateway> igList = bean.getListGateway();
			IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
					.getInstance().getBean("intfGatewayService");
			for (IpUrInterfaceGateway ig : igList) {
				if (ig.getIsSelected()) {
					IpUrInterfaceGateway gateway = intfGatewayService
							.findFirewall(ig.getId().getUrNo(), ig.getId()
									.getSubUrNo());
					String changeType = (gateway.getChangeType() != null) ? gateway
							.getChangeType()
							: "";
					if (changeType.equals("A")) {
						intfGatewayService.delete(gateway);
					} else {
						gateway.setChangeType("D");
						intfGatewayService.update(gateway);
					}
				}
			}
			List<IpUrInterfaceGateway> list = intfGatewayService
					.findByUrNo(bean.getUrNo());
			if (bean.getGateway()!=null) {
				bean.getGateway().setCheckAll(false);
			}
			bean.setListGateway(list);
		} else if (urType.equals("RT")) {
			String subUrNo = "";
			List<IpUrRouting> rtList = bean.getListRouting();
			RoutingService routingService = (RoutingService) JSFServiceFinderUtil
					.getInstance().getBean("routingService");
			for (IpUrRouting rt : rtList) {
				if (rt.getIsSelected()) {
					IpUrRouting gateway = routingService.findFirewall(rt
							.getId().getUrNo(), rt.getId().getSubUrNo());
					String changeType = (gateway.getChangeType() != null) ? gateway
							.getChangeType()
							: "";
					if (changeType.equals("A")) {
						routingService.delete(gateway);
					} else {
						gateway.setChangeType("D");
						routingService.update(gateway);
					}
				}
			}
			List<IpUrRouting> list = routingService.findByUrNo(bean.getUrNo());
			if (bean.getRouting()!=null) {
				bean.getRouting().setCheckAll(false);
			}
			bean.setListRouting(list);
		} else if (urType.equals("F5")) {
			String subUrNo = "";
			List<IpUrF5> f5List = bean.getListF5();
			F5Service f5Service = (F5Service) JSFServiceFinderUtil
					.getInstance().getBean("f5Service");
			for (IpUrF5 f5 : f5List) {
				if (f5.getIsSelected()) {
					IpUrF5 gateway = f5Service.findFirewall(f5.getId()
							.getUrNo(), f5.getId().getSubUrNo());
					String changeType = (gateway.getChangeType() != null) ? gateway
							.getChangeType()
							: "";
					if (changeType.equals("A")) {
						f5Service.delete(gateway);
					} else {
						gateway.setChangeType("D");
						f5Service.update(gateway);
					}
				}
			}
			List<IpUrF5> list = f5Service.findByUrNo(bean.getUrNo());
			if (bean.getF5()!=null) {
				bean.getF5().setCheckAll(false);
			}
			Set<String> vipCacheIndexReplace = new HashSet<String>();
			for(IpUrF5 f5New : bean.getListF5()) {
				vipCacheIndexReplace.add(f5New.getVipAddress()+"-"+f5New.getVipPort());
			}
			bean.getF5().setVipIndexCache(vipCacheIndexReplace);
			bean.setListF5(list);
		}
		setNetworkConfigBean(bean);
	}

	public void getSelectedSubUR() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String currentTab = getRequestParameter("currentTab");
		String isImpactValue = getRequestParameter("isImpactValue");

		String urType = currentTab;
		bean.setSelectSubUR(urType);
		if (urType.equals("FW")) {
			FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
					.getInstance().getBean("firewallService");
			IpUrFirewall firewall = firewallService.findFirewall(urNo, subUrNo);
			if(firewall.getIsImpact() == null) firewall.setIsImpact("N");
			boolean isImpact = firewall.getIsImpact().equals("Y");
			 firewall.setIsImpact(isImpact?"N":"Y");			
			IPFirewallBean fwBean = new IPFirewallBean();
			fwBean.setCheckAll(bean.getFirewall().isCheckAll());			
			fwBean.setSearchResult(firewall);
			bean.setFirewall(fwBean);
		} else if (urType.equals("AL")) {
			AccessListService cdnService = (AccessListService) JSFServiceFinderUtil
					.getInstance().getBean("accessListService");
			IpUrAccessListCdn cdn = cdnService.findAccessListCdn(urNo, subUrNo);
			if(cdn.getIsImpact() == null) cdn.setIsImpact("N");
			boolean isImpact = cdn.getIsImpact().equals("Y");
			cdn.setIsImpact(isImpact ? "N":"Y");			
			IPAccessListBean alBean = new IPAccessListBean();
			alBean.setCheckAll(bean.getAccessList().isCheckAll());
			alBean.setSearchResult(cdn);
			bean.setAccessList(alBean);
		} else if (urType.equals("AT")) {
			AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil
					.getInstance().getBean("accessListTNPService");
			IpUrAccessListTnp tnp = tnpService.findAccessListTnp(urNo, subUrNo);
			if(tnp.getIsImpact() == null) tnp.setIsImpact("N");
			boolean isImpact = tnp.getIsImpact().equals("Y");
			tnp.setIsImpact(isImpact ? "N":"Y");			
			IPAccessListTNPBean atBean = new IPAccessListTNPBean();
			atBean.setCheckAll(bean.getAccessListTNP().isCheckAll());
			atBean.setSearchResult(tnp);
			bean.setAccessListTNP(atBean);
		} else if (urType.equals("PI")) {
			PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil
					.getInstance().getBean("phyInterfaceService");
			IpUrPhysicalInterface phtInterf = phyIntfService.findPhyInterface(
					urNo, subUrNo);
			if(phtInterf.getIsImpact() == null) phtInterf.setIsImpact("N");			
			boolean isImpact = phtInterf.getIsImpact().equals("Y");
			phtInterf.setIsImpact(isImpact ? "N":"Y");
			IPPhyInterfaceBean piBean = new IPPhyInterfaceBean();
			piBean.setSearchResult(phtInterf);
			piBean.setCheckAll(bean.getPhyInterface().isCheckAll());
			bean.setPhyInterface(piBean);
		} else if (urType.equals("IG")) {
			IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
					.getInstance().getBean("intfGatewayService");
			IpUrInterfaceGateway gateway = intfGatewayService.findFirewall(
					urNo, subUrNo);
			if(gateway.getIsImpact() == null) gateway.setIsImpact("N");					
			boolean isImpact = gateway.getIsImpact().equals("Y");
			gateway.setIsImpact(isImpact ? "N":"Y");
			IPIntfGatewayBean igBean = new IPIntfGatewayBean();
			igBean.setSearchResult(gateway);
			bean.setGateway(igBean);
		} else if (urType.equals("RT")) {
			RoutingService routingService = (RoutingService) JSFServiceFinderUtil
					.getInstance().getBean("routingService");
			IpUrRouting routing = routingService.findFirewall(urNo, subUrNo);
			if(routing.getIsImpact() == null) routing.setIsImpact("N");	
			boolean isImpact = routing.getIsImpact().equals("Y");
			routing.setIsImpact(isImpact ? "N" : "Y");
			IPRoutingBean rtBean = new IPRoutingBean();
			rtBean.setCheckAll(bean.getRouting().isCheckAll());
			rtBean.setSearchResult(routing);
			bean.setRouting(rtBean);
		} else if (urType.equals("F5")) {
			F5Service f5Service = (F5Service) JSFServiceFinderUtil
					.getInstance().getBean("f5Service");
			IpUrF5 f5 = f5Service.findFirewall(urNo, subUrNo);
			if(f5.getIsImpact() == null) f5.setIsImpact("N");	
			boolean isImpact = f5.getIsImpact().equals("Y");
			f5.setIsImpact(isImpact ? "N":"Y");
			IPF5Bean f5Bean = new IPF5Bean();
			f5Bean.setCheckAll(bean.getF5().isCheckAll());
			f5Bean.setSearchResult(f5);
			bean.setF5(f5Bean);
		}

		setNetworkConfigBean(bean);
	}

	public void setImpactUR() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		String selectImpact =	getRequestParameter("selectImpact");
		String urType = bean.getSelectSubUR();
		if (urType.equals("FW")) {
			FirewallService firewallService = (FirewallService) JSFServiceFinderUtil.getInstance().getBean("firewallService");
			IpUrFirewall firewall = bean.getFirewall().getSearchResult();
			//if (bean.isCheckImpact()) {
			if (selectImpact.equalsIgnoreCase("Y")){
				if(firewall.getIsImpact().equals("Y")) {
					firewall.setIsImpact("Y");
				} else {
					firewall.setIsImpact("N");
				}
			}else{
				if(firewall.getIsImpact().equals("Y")) {
					firewall.setIsImpact("N");
				} else {
					firewall.setIsImpact("Y");
				}
			}
			firewallService.updateFirewall(firewall);
			int i=0;
			for (IpUrFirewall fire : bean.getListFirewall()) {
				if (fire.getId().getUrNo().equalsIgnoreCase(firewall.getId().getUrNo()) 
						&& fire.getId().getSubUrNo().equalsIgnoreCase(firewall.getId().getSubUrNo())) {
					firewall.setIsSelected(fire.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListFirewall().size()) bean.getListFirewall().set(i, firewall);
			for (IpUrFirewall fire : bean.getListFirewall()) {
				if (fire.getId().getUrNo().equalsIgnoreCase(firewall.getId().getUrNo()) 
						&& fire.getId().getSubUrNo().equalsIgnoreCase(firewall.getId().getSubUrNo())) {
					if (firewall.getIsImpact()==null || firewall.getIsImpact().equalsIgnoreCase("N")) {
						bean.getFirewall().setImpactAll(false);
						break;
					}
				}else{
					if (fire.getIsImpact()==null || fire.getIsImpact().equalsIgnoreCase("N")) {
						bean.getFirewall().setImpactAll(false);
						break;
					}
				}
			}
			//List<IpUrFirewall> fwList = firewallService.findByUrNo(firewall.getId().getUrNo());
			//bean.setListFirewall(fwList);
		} else if (urType.equals("AL")) {
			AccessListService cdnService = (AccessListService) JSFServiceFinderUtil.getInstance().getBean("accessListService");
			IpUrAccessListCdn cdn = bean.getAccessList().getSearchResult();
			//if (bean.isCheckImpact()) {
			if (selectImpact.equalsIgnoreCase("Y")){
				if(cdn.getIsImpact().equals("Y")) {
					cdn.setIsImpact("Y");
				} else {
					cdn.setIsImpact("N");
				}
			}else{
				if(cdn.getIsImpact().equals("Y")) {
					cdn.setIsImpact("N");
				} else {
					cdn.setIsImpact("Y");
				}
			}
			try {
				cdnService.update(cdn);
			} catch (IPFMBusinessException e) {
				e.printStackTrace();
			}
			int i=0;
			for (IpUrAccessListCdn cdnItem : bean.getListAccessList()) {
				if (cdnItem.getId().getUrNo().equalsIgnoreCase(cdn.getId().getUrNo()) 
						&& cdnItem.getId().getSubUrNo().equalsIgnoreCase(cdn.getId().getSubUrNo())) {
					cdn.setIsSelected(cdnItem.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListAccessList().size()) bean.getListAccessList().set(i, cdn);
			for (IpUrAccessListCdn item : bean.getListAccessList()) {
				if (item.getId().getUrNo().equalsIgnoreCase(item.getId().getUrNo()) 
						&& item.getId().getSubUrNo().equalsIgnoreCase(item.getId().getSubUrNo())) {
					if (cdn.getIsImpact()==null || cdn.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}else{
					if (item.getIsImpact()==null || item.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}
			}
			
		} else if (urType.equals("AT")) {
			AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
			IpUrAccessListTnp tnp = bean.getAccessListTNP().getSearchResult();
			if (selectImpact.equalsIgnoreCase("Y")){
				if(tnp.getIsImpact().equals("Y")) {
					tnp.setIsImpact("Y");
				} else {
					tnp.setIsImpact("N");
				}
			}else{
				if(tnp.getIsImpact().equals("Y")) {
					tnp.setIsImpact("N");
				} else {
					tnp.setIsImpact("Y");
				}
			}
			tnpService.update(tnp);
			int i=0;
			for (IpUrAccessListTnp tnpItem : bean.getListAccessTNP()) {
				if (tnpItem.getId().getUrNo().equalsIgnoreCase(tnp.getId().getUrNo()) 
						&& tnpItem.getId().getSubUrNo().equalsIgnoreCase(tnp.getId().getSubUrNo())) {
					tnp.setIsSelected(tnpItem.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListAccessTNP().size()) bean.getListAccessTNP().set(i, tnp);
			for (IpUrAccessListTnp item : bean.getListAccessTNP()) {
				if (item.getId().getUrNo().equalsIgnoreCase(item.getId().getUrNo()) 
						&& item.getId().getSubUrNo().equalsIgnoreCase(item.getId().getSubUrNo())) {
					if (tnp.getIsImpact()==null || tnp.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}else{
					if (item.getIsImpact()==null || item.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}
			}
		} else if (urType.equals("PI")) {
			PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
			IpUrPhysicalInterface intf = bean.getPhyInterface().getSearchResult();
			//if (bean.isCheckImpact()) {
			
			if (selectImpact.equalsIgnoreCase("Y")){
				if(intf.getIsImpact().equals("Y")) {
					intf.setIsImpact("Y");
				} else {
					intf.setIsImpact("N");
				}
			}else{
				if(intf.getIsImpact().equals("Y")) {
					intf.setIsImpact("N");
				} else {
					intf.setIsImpact("Y");
				}
			}
			phyIntfService.update(intf);
			int i=0;
			for (IpUrPhysicalInterface phy : bean.getListPhysicalInterface()) {
				if (phy.getId().getUrNo().equalsIgnoreCase(intf.getId().getUrNo()) 
						&& phy.getId().getSubUrNo().equalsIgnoreCase(intf.getId().getSubUrNo())) {
					intf.setIsSelected(phy.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListPhysicalInterface().size()) bean.getListPhysicalInterface().set(i, intf);
			for (IpUrPhysicalInterface item : bean.getListPhysicalInterface()) {
				if (item.getId().getUrNo().equalsIgnoreCase(item.getId().getUrNo()) 
						&& item.getId().getSubUrNo().equalsIgnoreCase(item.getId().getSubUrNo())) {
					if (intf.getIsImpact()==null || intf.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}else{
					if (item.getIsImpact()==null || item.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}
			}
		} else if (urType.equals("IG")) {
			IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
					.getInstance().getBean("intfGatewayService");
			IpUrInterfaceGateway gateway = bean.getGateway().getSearchResult();
			if (selectImpact.equalsIgnoreCase("Y")){
				if(gateway.getIsImpact().equals("Y")) {
					gateway.setIsImpact("Y");
				} else {
					gateway.setIsImpact("N");
				}
			}else{
				if(gateway.getIsImpact().equals("Y")) {
					gateway.setIsImpact("N");
				} else {
					gateway.setIsImpact("Y");
				}
			}
			intfGatewayService.update(gateway);
			int i=0;
			for (IpUrInterfaceGateway gatewayItem : bean.getListGateway()) {
				if (gatewayItem.getId().getUrNo().equalsIgnoreCase(gateway.getId().getUrNo()) 
						&& gatewayItem.getId().getSubUrNo().equalsIgnoreCase(gateway.getId().getSubUrNo())) {
					gateway.setIsSelected(gatewayItem.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListGateway().size()) bean.getListGateway().set(i, gateway);
			for (IpUrInterfaceGateway item : bean.getListGateway()) {
				if (item.getId().getUrNo().equalsIgnoreCase(item.getId().getUrNo()) 
						&& item.getId().getSubUrNo().equalsIgnoreCase(item.getId().getSubUrNo())) {
					if (gateway.getIsImpact()==null || gateway.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}else{
					if (item.getIsImpact()==null || item.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}
			}
		} else if (urType.equals("RT")) {
			RoutingService routingService = (RoutingService) JSFServiceFinderUtil
					.getInstance().getBean("routingService");
			IpUrRouting routing = bean.getRouting().getSearchResult();
			if (selectImpact.equalsIgnoreCase("Y")){
				if(routing.getIsImpact().equals("Y")) {
					routing.setIsImpact("Y");
				} else {
					routing.setIsImpact("N");
				}
			}else{
				if(routing.getIsImpact().equals("Y")) {
					routing.setIsImpact("N");
				} else {
					routing.setIsImpact("Y");
				}
			}
			routingService.update(routing);
			int i=0;
			for (IpUrRouting routingItem : bean.getListRouting()) {
				if (routingItem.getId().getUrNo().equalsIgnoreCase(routing.getId().getUrNo()) 
						&& routingItem.getId().getSubUrNo().equalsIgnoreCase(routing.getId().getSubUrNo())) {
					routing.setIsSelected(routingItem.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListRouting().size()) bean.getListRouting().set(i, routing);
			for (IpUrRouting item : bean.getListRouting()) {
				if (item.getId().getUrNo().equalsIgnoreCase(item.getId().getUrNo()) 
						&& item.getId().getSubUrNo().equalsIgnoreCase(item.getId().getSubUrNo())) {
					if (routing.getIsImpact()==null || routing.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}else{
					if (item.getIsImpact()==null || item.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}
			}
//			List<IpUrRouting> alList = routingService.findByUrNo(routing
//					.getId().getUrNo());
//			bean.setListRouting(alList);
		} else if (urType.equals("F5")) {
			F5Service f5Service = (F5Service) JSFServiceFinderUtil
					.getInstance().getBean("f5Service");
			IpUrF5 f5 = bean.getF5().getSearchResult();
			if (selectImpact.equalsIgnoreCase("Y")){
				if(f5.getIsImpact().equals("Y")) {
					f5.setIsImpact("Y");
				} else {
					f5.setIsImpact("N");
				}
			}else{
				if(f5.getIsImpact().equals("Y")) {
					f5.setIsImpact("N");
				} else {
					f5.setIsImpact("Y");
				}
			}
			f5Service.update(f5);
			int i=0;
			for (IpUrF5 f5Item : bean.getListF5()) {
				if (f5Item.getId().getUrNo().equalsIgnoreCase(f5.getId().getUrNo()) 
						&& f5Item.getId().getSubUrNo().equalsIgnoreCase(f5.getId().getSubUrNo())) {
					f5.setIsSelected(f5Item.getIsSelected());
					break;
				}
				i++;
			}
			if ((i)!=bean.getListF5().size()) bean.getListF5().set(i, f5);
			for (IpUrF5 item : bean.getListF5()) {
				if (item.getId().getUrNo().equalsIgnoreCase(item.getId().getUrNo()) 
						&& item.getId().getSubUrNo().equalsIgnoreCase(item.getId().getSubUrNo())) {
					if (f5.getIsImpact()==null || f5.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}else{
					if (item.getIsImpact()==null || item.getIsImpact().equalsIgnoreCase("N")) {
						bean.getAccessList().setImpactAll(false);
						break;
					}
				}
			}
			//List<IpUrF5> alList = f5Service.findByUrNo(f5.getId().getUrNo());
			//bean.setListF5(alList);
		}

		setNetworkConfigBean(bean);
	}

	public void downloadFile() {
		try {
			String fileName = getRequestParameter("fileName");
			String path = getRequestParameter("path");

			downloadFile(path, fileName);
		} catch (FileNotFoundException fex) {
			IPFMMessageUtils.addMessageError(fex.getMessage());
		} catch (Exception ex) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}

	public String cancelUr() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		cleanSubUr(bean.getUrNo());
		return "homePage";
	}
	
	public String cancelImpact() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		try{
			IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
//			nwConfigService.cancelImpact(bean.getUrNo());
			nwConfigService.cancelImpact(bean.getListFirewall(),bean.getListAccessList(),bean.getListAccessTNP(),bean.getListPhysicalInterface(),bean.getListGateway(),bean.getListRouting(),bean.getListF5());
		}catch(Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}
		return "homePage";
	}

	public void deleteUr() {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IpUrAttachmentService attachmentService = (IpUrAttachmentService) JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		try {
			
			if(bean.getUrNo().startsWith("T")){
				nwConfigService.deleteUrNo(bean.getUrNo());
			}
			//Insert IpUrHistory &&  delete  IpUrAction
			nwConfigService.insertHistoryNwConfig(bean.getUrNo(), userSession.getIpUser());

			/// Update IpUrNetWorkConfig
			bean.getNetworkConfig().setUrNo(bean.getUrNo());
			bean.getNetworkConfig().setUrStatusTxt("DEL");
			bean.getNetworkConfig().setUrStatusName("Delete UR");
			bean.getNetworkConfig().setLastUpdBy(userSession.getIpUser().getUserId());
			nwConfigService.updateUr(bean.getNetworkConfig());
			
			//Delete  Check Tab
			nwConfigService.deleteTab(bean.getFirewallCheck(), bean.getAccessListCheck(), bean.getAccessTNPCheck(), bean.getPhysicalCheck()
			, bean.getGatewayCheck(), bean.getRoutingCheck(), bean.getF5Check(), bean.getUrNo(), userSession.getIpUser().getUserId());

			setNetworkConfigBean(bean);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0025")));
			IPFMWebUtil.storeOnSession("HOME", true);

		} catch (IPFMBusinessException ipfme) {
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		} catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility
					.buildMessage(ErrorMessageUtil.getMessage("ER0009")));
		}

	}

	private void cleanSubUr(String urNo) {
		FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
				.getInstance().getBean("firewallService");
		firewallService.cleanSubUR(urNo);

		AccessListService cdnService = (AccessListService) JSFServiceFinderUtil
				.getInstance().getBean("accessListService");
		cdnService.cleanSubUR(urNo);

		AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil
				.getInstance().getBean("accessListTNPService");
		tnpService.cleanSubUR(urNo);

		PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil
				.getInstance().getBean("phyInterfaceService");
		phyIntfService.cleanSubUR(urNo);

		IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
				.getInstance().getBean("intfGatewayService");
		intfGatewayService.cleanSubUR(urNo);

		RoutingService routingService = (RoutingService) JSFServiceFinderUtil
				.getInstance().getBean("routingService");
		routingService.cleanSubUR(urNo);

		F5Service f5Service = (F5Service) JSFServiceFinderUtil.getInstance()
				.getBean("f5Service");
		f5Service.cleanSubUR(urNo);

	}

	private Map deletePreviousUR(String urNo) {
		FirewallService firewallService = (FirewallService) JSFServiceFinderUtil
				.getInstance().getBean("firewallService");
		firewallService.commitSubUR(urNo);

		AccessListService cdnService = (AccessListService) JSFServiceFinderUtil
				.getInstance().getBean("accessListService");
		cdnService.commitSubUR(urNo);

		AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil
				.getInstance().getBean("accessListTNPService");
		tnpService.commitSubUR(urNo);

		PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil
				.getInstance().getBean("phyInterfaceService");
		phyIntfService.commitSubUR(urNo);

		IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil
				.getInstance().getBean("intfGatewayService");
		intfGatewayService.commitSubUR(urNo);

		RoutingService routingService = (RoutingService) JSFServiceFinderUtil
				.getInstance().getBean("routingService");
		routingService.commitSubUR(urNo);

		F5Service f5Service = (F5Service) JSFServiceFinderUtil.getInstance()
				.getBean("f5Service");
		f5Service.commitSubUR(urNo);

		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil
				.getInstance().getBean("ipUrNwConfigService");
		Map previousUr = nwConfigService.deletePrevious(urNo);
		return previousUr;
	}

	public void setErrorMsg(ActionEvent event) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		bean.setErrorFlag(true);
		bean.setErrorMsg("error message will show here");
		setNetworkConfigBean(bean);
	}
	
	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getMsgError() {
		return msgError;
	}
	
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
	public void viewListTab(String urNo, String mode, IpUser user) {
		    ReqNWConfigBean bean = getNetworkConfigBean();
			IpUrActionService actionService = (IpUrActionService) JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
			List<IpUrAction> listAction = actionService.listAction(urNo, user, mode);
		
			List<IpUrFirewall> fwList = new ArrayList<IpUrFirewall>();
			List<IpUrAccessListCdn> alList = new ArrayList<IpUrAccessListCdn>();
			List<IpUrAccessListTnp> atList = new ArrayList<IpUrAccessListTnp>();
			List<IpUrPhysicalInterface> piList = new ArrayList<IpUrPhysicalInterface>();
			List<IpUrInterfaceGateway> igList = new ArrayList<IpUrInterfaceGateway>();
			List<IpUrRouting> rtList = new ArrayList<IpUrRouting>();
			List<IpUrF5> f5List = new ArrayList<IpUrF5>();
			int rowIndex = 0;
			
			for (IpUrAction action : listAction) {
				FirewallService firewallService = (FirewallService) JSFServiceFinderUtil.getInstance().getBean("firewallService");
				IpUrFirewall fw = firewallService.findFirewall(action.getUrNo(), action.getSubUrNo());
				if (fw != null){
					if (fw.getIsImpact()!=null && fw.getIsImpact().equals("Y")) fw.setImpactSelected(true);
					else fw.setImpactSelected(false);
					fwList.add(fw);
				}

				AccessListService cdnService = (AccessListService) JSFServiceFinderUtil.getInstance().getBean("accessListService");
				IpUrAccessListCdn al = cdnService.findAccessListCdn(action.getUrNo(), action.getSubUrNo());
				if (al != null){
					if (al.getIsImpact()!=null && al.getIsImpact().equals("Y")) al.setImpactSelected(true);
					else al.setImpactSelected(false);
					alList.add(al);
				}
				
				AccessListTNPService tnpService = (AccessListTNPService) JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
				IpUrAccessListTnp at = tnpService.findAccessListTnp(action.getUrNo(), action.getSubUrNo());
				if (at != null){
					if (at.getIsImpact()!=null && at.getIsImpact().equals("Y")) at.setImpactSelected(true);
					else at.setImpactSelected(false);
					atList.add(at);
				}

				PhyInterfaceService phyIntfService = (PhyInterfaceService) JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
				IpUrPhysicalInterface pi = phyIntfService.findPhyInterface(action.getUrNo(), action.getSubUrNo());
				if (pi != null){
					if (pi.getIsImpact()!=null && pi.getIsImpact().equals("Y")) pi.setImpactSelected(true);
					else pi.setImpactSelected(false);
					
					if (pi != null){
						pi.setRowIndex(rowIndex++);
						piList.add(pi);
					}
//					piList.add(pi);
				}

				IntfGatewayService intfGatewayService = (IntfGatewayService) JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
				IpUrInterfaceGateway ig = intfGatewayService.findFirewall(action.getUrNo(), action.getSubUrNo());
				if (ig != null){
					if (ig.getIsImpact()!=null && ig.getIsImpact().equals("Y")) ig.setImpactSelected(true);
					else ig.setImpactSelected(false);
					igList.add(ig);
				}

				RoutingService routingService = (RoutingService) JSFServiceFinderUtil.getInstance().getBean("routingService");
				IpUrRouting rt = routingService.findFirewall(action.getUrNo(),action.getSubUrNo());
				if (rt != null){
					if (rt.getIsImpact()!=null && rt.getIsImpact().equals("Y")) rt.setImpactSelected(true);
					else rt.setImpactSelected(false);
					rtList.add(rt);
				}

				F5Service f5Service = (F5Service) JSFServiceFinderUtil.getInstance().getBean("f5Service");
				IpUrF5 f5 = f5Service.findFirewall(action.getUrNo(), action.getSubUrNo());
				if (f5 != null){
					if (f5.getIsImpact()!=null && f5.getIsImpact().equals("Y")) f5.setImpactSelected(true);
					else f5.setImpactSelected(false);
					f5List.add(f5);
				}
			}
			int subSize = 0;
			bean.setListFirewall(fwList);
			bean.setListAccessList(alList);
			bean.setListAccessTNP(atList);
			bean.setListPhysicalInterface(piList);
			bean.setListGateway(igList);
			bean.setListRouting(rtList);
			bean.setListF5(f5List);
			
			if (bean.getFirewall()!=null) {
				bean.getFirewall().setCheckAll(false);
				subSize = 0;
				for (IpUrFirewall sub : bean.getListFirewall()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==fwList.size()) bean.getFirewall().setImpactAll(true);
				else  bean.getFirewall().setImpactAll(false);
			}
			if (bean.getAccessList()!=null) {
				bean.getAccessList().setCheckAll(false);
				subSize = 0;
				for (IpUrAccessListCdn sub : bean.getListAccessList()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==bean.getListAccessList().size()) bean.getAccessList().setImpactAll(true);
				else  bean.getAccessList().setImpactAll(false);
			}
			if (bean.getAccessListTNP()!=null) {
				bean.getAccessListTNP().setCheckAll(false);
				subSize = 0;
				for (IpUrAccessListTnp sub : bean.getListAccessTNP()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==bean.getListAccessTNP().size()) bean.getAccessListTNP().setImpactAll(true);
				else  bean.getAccessListTNP().setImpactAll(false);
			}
			if (bean.getPhyInterface()!=null) {
				bean.getPhyInterface().setCheckAll(false);
				subSize = 0;
				for (IpUrPhysicalInterface sub : bean.getListPhysicalInterface()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==bean.getListPhysicalInterface().size()) bean.getPhyInterface().setImpactAll(true);
				else  bean.getPhyInterface().setImpactAll(false);
			}
			if (bean.getGateway()!=null) {
				bean.getGateway().setCheckAll(false);
				subSize = 0;
				for (IpUrInterfaceGateway sub : bean.getListGateway()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==bean.getListGateway().size()) bean.getGateway().setImpactAll(true);
				else  bean.getGateway().setImpactAll(false);
			}
			if (bean.getRouting()!=null) {
				bean.getRouting().setCheckAll(false);
				subSize = 0;
				for (IpUrRouting sub : bean.getListRouting()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==bean.getListRouting().size()) bean.getRouting().setImpactAll(true);
				else  bean.getRouting().setImpactAll(false);
			}
			if (bean.getF5()!=null) {
				bean.getF5().setCheckAll(false);
				subSize = 0;
				for (IpUrF5 sub : bean.getListF5()){
					if (sub.getIsImpact()!=null && sub.getIsImpact().equals("Y")) {
						subSize++;
					}else break;
				}
				if (subSize!=0 && subSize==bean.getListF5().size()) bean.getF5().setImpactAll(true);
				else  bean.getF5().setImpactAll(false);
			}
			setNetworkConfigBean(bean);
			
	 }
	
	public void alertErrorMsg(ActionEvent event){
		String errorMessage = getRequestParameter("errorMessage");
		IPFMMessageUtils.addMessageError(errorMessage);
	}
	
	public void checkNetworkTypeCombo(){
		 ReqNWConfigBean bean = getNetworkConfigBean();
            if((bean.getGateway().getNetworkType().getValue()==null) && bean.getGateway().getNetworkType().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Type"));
			}
	}
	public void checkIntfNodeTypeCombo(){
		 ReqNWConfigBean bean = getNetworkConfigBean();
           if((bean.getPhyInterface().getIntfNodeType().getValue()==null) && bean.getPhyInterface().getIntfNodeType().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Interface Node Type"));
			}
	}
	public void checkPortStatus(){
		 ReqNWConfigBean bean = getNetworkConfigBean();
          if((bean.getPhyInterface().getPortStatus().getValue()==null) && bean.getPhyInterface().getPortStatus().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Status"));
			}
	}
	public void checkSpeedPort(){
		 ReqNWConfigBean bean = getNetworkConfigBean();
         if((bean.getPhyInterface().getSpeedPort().getValue()==null) && bean.getPhyInterface().getSpeedPort().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Speed Port"));
			}
	}
	public void checkNetworkLocationCombo(){
		 ReqNWConfigBean bean = getNetworkConfigBean();
        if((bean.getPhyInterface().getSpeedPort().getValue()==null) && bean.getPhyInterface().getSpeedPort().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Location"));
			}
	}
	// Method to get the HtmlDataTable.
	private HtmlDataTable getParentDatatable(UIComponent compo) {
	    if (compo == null) {
	        return null;
	    }
	    if (compo instanceof org.richfaces.component.html.HtmlDataTable) {
	        return (HtmlDataTable) compo;
	    }
	    return getParentDatatable(compo.getParent());
	}
	
	public void selectRadio(ActionEvent evt){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String currentTab = getRequestParameter("currentTab");
		String type = getRequestParameter("type");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean) JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		int rowsPerPage = ipfmConfigBean.getRowPerPage();
		int rowIndex = Integer.parseInt(getRequestParameter("rowIndex"));
		String subUrNoSelect = getRequestParameter("subUrNoSelect");
		
		int approveCount = 0;
		int rejectCount = 0;
		int listSize = 0;
		if (currentTab.equals("FW")) {
			IPFirewallBean subBean = bean.getFirewall();
			List<IpUrFirewall> list = bean.getListFirewall();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrFirewall item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
							if(bean.getMode() != null && (bean.getMode().equalsIgnoreCase("OwnerApprove") || bean.getMode().equalsIgnoreCase("TEAM"))){
								if(subUrNoSelect != null && item.getId().getSubUrNo().equals(subUrNoSelect)){
									item.setIsApprove("Y");
									item.setIsReject("N");
								}
							}else if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
							if(bean.getMode() != null && (bean.getMode().equalsIgnoreCase("OwnerApprove") || bean.getMode().equalsIgnoreCase("TEAM"))){
								if(subUrNoSelect != null && item.getId().getSubUrNo().equals(subUrNoSelect)){
									item.setIsApprove("N");
									item.setIsReject("Y");
								}
							}else if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		} else if (currentTab.equals("AL")) {
			IPAccessListBean subBean = bean.getAccessList();
			List<IpUrAccessListCdn> list = bean.getListAccessList();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrAccessListCdn item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
						if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
						if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		} else if (currentTab.equals("AT")) {
			IPAccessListTNPBean subBean = bean.getAccessListTNP();
			List<IpUrAccessListTnp> list = bean.getListAccessTNP();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrAccessListTnp item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
						if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
						if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		} else if (currentTab.equals("PI")) {
			IPPhyInterfaceBean subBean = bean.getPhyInterface();
			List<IpUrPhysicalInterface> list = bean.getListPhysicalInterface();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrPhysicalInterface item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
						if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
						if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		} else if (currentTab.equals("IG")) {
			IPIntfGatewayBean subBean = bean.getGateway();
			List<IpUrInterfaceGateway> list = bean.getListGateway();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrInterfaceGateway item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
						if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
						if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		} else if (currentTab.equals("RT")) {
			IPRoutingBean subBean = bean.getRouting();
			List<IpUrRouting> list = bean.getListRouting();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrRouting item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
						if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
						if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		} else if (currentTab.equals("F5")) {
			IPF5Bean subBean = bean.getF5();
			List<IpUrF5> list = bean.getListF5();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break;
				listSize++;
				IpUrF5 item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVE")){
						if (rowIndex == i) {
							item.setIsApprove("Y");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECT")) {
						if (rowIndex == i) {
							item.setIsApprove("N");
							item.setIsReject("Y");
						}
					}
					if (item.getIsApprove()!=null && item.getIsApprove().equals("Y")) approveCount++;
					else if (item.getIsReject()!=null && item.getIsReject().equals("Y")) rejectCount++;
				}
			}
			if (listSize == approveCount) {
				subBean.setApproveAll(true);
				subBean.setRejectAll(false);
			}else if (listSize == rejectCount) {
				subBean.setApproveAll(false);
				subBean.setRejectAll(true);	
			}else {
				subBean.setApproveAll(false);
				subBean.setRejectAll(false);	
			}
		}
	}
	
	public void checkSelectAll(ActionEvent evt){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String currentTab = getRequestParameter("currentTab");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean) JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		int rowsPerPage = ipfmConfigBean.getRowPerPage();
		int approveCount = 0;
		int rejectCount = 0;
		int totalSize = 0;
		if (currentTab.equals("FW")) {
			IPFirewallBean subBean = bean.getFirewall();
			List<IpUrFirewall> list = bean.getListFirewall();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrFirewall item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		} else if (currentTab.equals("AL")) {
			IPAccessListBean subBean = bean.getAccessList();
			List<IpUrAccessListCdn> list = bean.getListAccessList();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrAccessListCdn item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		} else if (currentTab.equals("AT")) {
			IPAccessListTNPBean subBean = bean.getAccessListTNP();
			List<IpUrAccessListTnp> list = bean.getListAccessTNP();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrAccessListTnp item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		} else if (currentTab.equals("PI")) {
			IPPhyInterfaceBean subBean = bean.getPhyInterface();
			List<IpUrPhysicalInterface> list = bean.getListPhysicalInterface();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrPhysicalInterface item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		} else if (currentTab.equals("IG")) {
			IPIntfGatewayBean subBean = bean.getGateway();
			List<IpUrInterfaceGateway> list = bean.getListGateway();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrInterfaceGateway item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		} else if (currentTab.equals("RT")) {
			IPRoutingBean subBean = bean.getRouting();
			List<IpUrRouting> list = bean.getListRouting();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrRouting item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		} else if (currentTab.equals("F5")) {
			IPF5Bean subBean = bean.getF5();
			List<IpUrF5> list = bean.getListF5();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				totalSize++;
				IpUrF5 item = list.get(i);
				if (item.getIsApprove()!=null && item.getIsApprove().equals("Y"))approveCount++;
				if (item.getIsReject()!=null && item.getIsReject().equals("Y"))rejectCount++;
			}
			if (approveCount == totalSize) subBean.setApproveAll(true);
			else subBean.setApproveAll(false);
			if (rejectCount == totalSize) subBean.setRejectAll(true);
			else subBean.setRejectAll(false);
		}
	}

	public void selectAll(ActionEvent evt){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String currentTab = getRequestParameter("currentTab");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean) JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		int rowsPerPage = ipfmConfigBean.getRowPerPage();
		String type = getRequestParameter("type");
		if (currentTab.equals("FW")) {
			IPFirewallBean subBean = bean.getFirewall();
			List<IpUrFirewall> list = bean.getListFirewall();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
//			List<IpUrFirewall> listTmp = new ArrayList<IpUrFirewall>();
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				IpUrFirewall item = list.get(i);			
				boolean resultCheck = true;
				if(bean.getMode().equalsIgnoreCase("OwnerApprove")){
							if(resultCheck && bean.getFilterReqNWCFW03().getFilterColumn1() != null && !bean.getFilterReqNWCFW03().getFilterColumn1().equals("")){
								if(item.getId().getSubUrNo().toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn1().toLowerCase())) > -1){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW03().getFilterColumn2() != null && !bean.getFilterReqNWCFW03().getFilterColumn2().equals("")){
								if(String.valueOf(item.getSourceIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn2().toLowerCase())) > -1
										||	String.valueOf(item.getSourceEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn2().toLowerCase())) > -1
										||	String.valueOf(item.getSourceHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn2().toLowerCase())) > -1
										||	String.valueOf(item.getSourceNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn2().toLowerCase())) > -1
										||	(String.valueOf(item.getSourceVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn2().toLowerCase())) > -1){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW03().getFilterColumn3() != null && !bean.getFilterReqNWCFW03().getFilterColumn3().equals("")){
								if(String.valueOf(item.getDestIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn3().toLowerCase())) > -1
										||	String.valueOf(item.getDestEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn3().toLowerCase())) > -1
										||	String.valueOf(item.getDestHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn3().toLowerCase())) > -1
										||	String.valueOf(item.getDestNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn3().toLowerCase())) > -1
										||	(String.valueOf(item.getDestVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn3().toLowerCase())) > -1	){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW03().getFilterColumn4() != null && !bean.getFilterReqNWCFW03().getFilterColumn4().equals("")){
								if(item.getServiceTcpPort().toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn4().toLowerCase())) > -1){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW03().getFilterColumn5() != null && !bean.getFilterReqNWCFW03().getFilterColumn5().equals("")){
								if(String.valueOf(item.getTeamRemark()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getSourceIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getSourceEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getSourceHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getSourceNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	(String.valueOf(item.getSourceVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									
									||	String.valueOf(item.getDestIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getDestEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getDestHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	String.valueOf(item.getDestNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1
									||	(String.valueOf(item.getDestVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW03().getFilterColumn5().toLowerCase())) > -1										
										){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							
				}else if(bean.getMode().equalsIgnoreCase("TEAM")){
							if(resultCheck && bean.getFilterReqNWCFW05().getFilterColumn1() != null && !bean.getFilterReqNWCFW05().getFilterColumn1().equals("")){
								if(item.getId().getSubUrNo().toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn1().toLowerCase())) > -1){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW05().getFilterColumn2() != null && !bean.getFilterReqNWCFW05().getFilterColumn2().equals("")){
								if(String.valueOf(item.getSourceIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn2().toLowerCase())) > -1
										||	String.valueOf(item.getSourceEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn2().toLowerCase())) > -1
										||	String.valueOf(item.getSourceHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn2().toLowerCase())) > -1
										||	String.valueOf(item.getSourceNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn2().toLowerCase())) > -1
										||	(String.valueOf(item.getSourceVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn2().toLowerCase())) > -1
										){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW05().getFilterColumn3() != null && !bean.getFilterReqNWCFW05().getFilterColumn3().equals("")){
								if(String.valueOf(item.getDestIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn3().toLowerCase())) > -1
										||	String.valueOf(item.getDestEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn3().toLowerCase())) > -1
										||	String.valueOf(item.getDestHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn3().toLowerCase())) > -1
										||	String.valueOf(item.getDestNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn3().toLowerCase())) > -1
										||	(String.valueOf(item.getDestVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn3().toLowerCase())) > -1){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW05().getFilterColumn4() != null && !bean.getFilterReqNWCFW05().getFilterColumn4().equals("")){
								if(item.getServiceTcpPort().toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn4().toLowerCase())) > -1){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
							}
							if(resultCheck && bean.getFilterReqNWCFW05().getFilterColumn5() != null && !bean.getFilterReqNWCFW05().getFilterColumn5().equals("")){
								if(String.valueOf(item.getTeamRemark()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getSourceIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getSourceEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getSourceHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getSourceNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	(String.valueOf(item.getSourceVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										
										||	String.valueOf(item.getDestIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getDestEmail()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getDestHostName()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	String.valueOf(item.getDestNatIp()).toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										||	(String.valueOf(item.getDestVip()).equalsIgnoreCase("n")?"Yes":"No").toLowerCase().indexOf((bean.getFilterReqNWCFW05().getFilterColumn5().toLowerCase())) > -1
										){
									resultCheck = true;
								}else{
									resultCheck = false;
								}
					}
				}
				
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);							
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);	
						}
					}
				}
				if(resultCheck){
					if (type!=null) {
						if (type.equalsIgnoreCase("APPROVEALL")){
							if (subBean.isApproveAll()) {						
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
//								item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {							
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
//								item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
			}
			
//			for (int i = firstIndex ; i<=lastIndex ; i++) {
//				if (i >= list.size()) break; 
//				IpUrFirewall item = list.get(i);			
//				
//				System.out.println(">>>>> ID : "+item.getId().getUrNo() + " : "+item.getId().getSubUrNo());
//				
//				if (type!=null) {
//					if (type.equalsIgnoreCase("APPROVEALL")){
//						if (subBean.isApproveAll()) {
//							subBean.setApproveAll(true);
//							subBean.setRejectAll(false);							
//							item.setIsApprove("Y");
//							item.setIsReject("N");
//						}else{
//							item.setIsApprove("N");
//							item.setIsReject("N");
//						}
//					}else if (type.equalsIgnoreCase("REJECTALL")) {
//						if (subBean.isRejectAll()) {
//							subBean.setApproveAll(false);
//							subBean.setRejectAll(true);							
//							item.setIsApprove("N");
//							item.setIsReject("Y");
//						}else{
//							item.setIsApprove("N");
//							item.setIsReject("N");
//						}
//					}
//				}
//			}
		} else if (currentTab.equals("AL")) {
			IPAccessListBean subBean = bean.getAccessList();
			List<IpUrAccessListCdn> list = bean.getListAccessList();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				IpUrAccessListCdn item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
		} else if (currentTab.equals("AT")) {
			IPAccessListTNPBean subBean = bean.getAccessListTNP();
			List<IpUrAccessListTnp> list = bean.getListAccessTNP();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				IpUrAccessListTnp item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
		} else if (currentTab.equals("PI")) {
			IPPhyInterfaceBean subBean = bean.getPhyInterface();
			List<IpUrPhysicalInterface> list = bean.getListPhysicalInterface();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				IpUrPhysicalInterface item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
		} else if (currentTab.equals("IG")) {
			IPIntfGatewayBean subBean = bean.getGateway();
			List<IpUrInterfaceGateway> list = bean.getListGateway();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				IpUrInterfaceGateway item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
		} else if (currentTab.equals("RT")) {
			IPRoutingBean subBean = bean.getRouting();
			List<IpUrRouting> list = bean.getListRouting();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				IpUrRouting item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
		} else if (currentTab.equals("F5")) {
			IPF5Bean subBean = bean.getF5();
			List<IpUrF5> list = bean.getListF5();
			rowsPerPage = list.size();
			int page = subBean.getPageScroller();
			int firstIndex = (rowsPerPage*(page-1));
			int lastIndex = (rowsPerPage*(page))-1;
			for (int i = firstIndex ; i<=lastIndex ; i++) {
				if (i >= list.size()) break; 
				IpUrF5 item = list.get(i);
				if (type!=null) {
					if (type.equalsIgnoreCase("APPROVEALL")){
						if (subBean.isApproveAll()) {
							subBean.setApproveAll(true);
							subBean.setRejectAll(false);
							item.setIsApprove("Y");
							item.setIsReject("N");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}else if (type.equalsIgnoreCase("REJECTALL")) {
						if (subBean.isRejectAll()) {
							subBean.setApproveAll(false);
							subBean.setRejectAll(true);
							item.setIsApprove("N");
							item.setIsReject("Y");
						}else{
							item.setIsApprove("N");
							item.setIsReject("N");
						}
					}
				}
			}
		}
	}
	
	
	
	public void showDelegateWin2() {
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");

		boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
		boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
		
		String subUrType = getRequestParameter("subUrType");
		
		System.out.println(" select Sub Ur type ... " + subUrType);
		
		if(subUrType == null) {
			subUrType = "";
		}
		
		bean.setSelectSubUR(subUrType);

		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = new ArrayList<String>();
		bean.setListPerson(listPerson);
		PmAssign pm = new PmAssign();
		pm.setSelectedPerson(selectedPerson);
		pm.setAssignForTeam("T");
		pm.setPersonEnable(true);
		bean.setPmDelegate(pm);
		

		if (isR6 && isR7) {
			bean.setIsTnp(false);
		} else if (isR6) {
			bean.setIsTnp(true);
			List<IpRoleMember> userList = nwConfigService.listPerson("R07");
			List<String> StringList = new ArrayList<String>();
			for (IpRoleMember ipRoleMember : userList) {
				StringList.add(new String(ipRoleMember.getUserId()));
			}
			bean.getPmDelegate().setSelectedPerson(StringList);
			List<SelectItem> items = new ArrayList<SelectItem>();
			
			try{
				IPRole roleData = nwConfigService.getRoleData("R07");
				if(roleData != null){
					SelectItem item = new SelectItem();
					item.setLabel(roleData.getRoleName());
					item.setValue(roleData.getRoleId());
					item.setDescription(roleData.getRoleName());
					items.add(item);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			bean.setTeamList(items);

		} else if (isR7) {
			bean.setIsTnp(true);
			List<IpRoleMember> userList = nwConfigService.listPerson("R06");
			List<String> StringList = new ArrayList<String>();
			for (IpRoleMember ipRoleMember : userList) {
				StringList.add(new String(ipRoleMember.getUserId()));
			}
			bean.getPmDelegate().setSelectedPerson(StringList);
			List<SelectItem> items = new ArrayList<SelectItem>();
			try{
				IPRole roleData = nwConfigService.getRoleData("R06");
				if(roleData != null){
					SelectItem item = new SelectItem();
					item.setLabel(roleData.getRoleName());
					item.setValue(roleData.getRoleId());
					item.setDescription(roleData.getRoleName());
					items.add(item);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			bean.setTeamList(items);
		}

		setNetworkConfigBean(bean);

	}
	
	
	
	public void showDelegateWin() {
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");

		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = new ArrayList<String>();
		PmAssign pmDelegate = new PmAssign();
		bean.setPmDelegate(pmDelegate);
		boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
		boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
		if (isR6 && isR7) {
			bean.getPmDelegate().setIsTeamTdno(false);
			bean.getPmDelegate().setIsTeamCdn(false);
			bean.getPmDelegate().setShowTNP(false);
			bean.getPmDelegate().setShowCDN(false);
			bean.getPmDelegate().setSelectedDelegatePerson(selectedPerson);		
			bean.setListdgp(listPerson);
		} else if (isR6) {
			bean.getPmDelegate().setIsTeamTdno(false);
			bean.getPmDelegate().setIsTeamCdn(false);
			bean.getPmDelegate().setShowTNP(false);
			bean.getPmDelegate().setShowCDN(true);
			bean.getPmDelegate().setSelectedDelegatePerson(selectedPerson);		
			bean.setListdgp(listPerson);
		} else if (isR7) {
			
			bean.getPmDelegate().setIsTeamTdno(false);
			bean.getPmDelegate().setIsTeamCdn(false);
			bean.getPmDelegate().setShowTNP(true);
			bean.getPmDelegate().setShowCDN(false);
			bean.getPmDelegate().setSelectedDelegatePerson(selectedPerson);		
			bean.setListdgp(listPerson);
		}



			bean.getPmDelegate().setAssignForTeam("T");
			bean.getPmDelegate().setAssignForPerson("");
			bean.getPmDelegate().setTeamEnable(true);
			bean.getPmDelegate().setPersonEnable(false);
			
		setNetworkConfigBean(bean);
	}
	
	public void selectDelegateType(ActionEvent action) {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		List<SelectItem> listPerson = new ArrayList<SelectItem>();
		List<String> selectedPerson = new ArrayList<String>();
		boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
		boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
		if (isR6 && isR7) {
			bean.setIsTnp(false);
		} else if (isR6) {
			bean.getPmDelegate().setIsTeamTdno(false);
			bean.getPmDelegate().setIsTeamCdn(false);
			bean.getPmDelegate().setShowTNP(false);
			bean.getPmDelegate().setShowCDN(true);
			bean.getPmDelegate().setSelectedDelegatePerson(new ArrayList<String>());		
			bean.setListdgp(listPerson);
		} else if (isR7) {
			
			bean.getPmDelegate().setIsTeamTdno(false);
			bean.getPmDelegate().setIsPersonCdn(false);
			bean.getPmDelegate().setShowTNP(true);
			bean.getPmDelegate().setShowCDN(false);
			bean.getPmDelegate().setSelectedDelegatePerson(new ArrayList<String>());		
			bean.setListdgp(listPerson);
		}


		String changeTo = getRequestParameter("changeTo");
		if (changeTo.equals("T")) {
			bean.getPmDelegate().setAssignForTeam("T");
			bean.getPmDelegate().setAssignForPerson("");
			bean.getPmDelegate().setTeamEnable(true);
			bean.getPmDelegate().setPersonEnable(false);
			
		} else if (changeTo.equals("P")) {
			bean.getPmDelegate().setAssignForTeam("");
			bean.getPmDelegate().setAssignForPerson("P");
			bean.getPmDelegate().setTeamEnable(false);
			bean.getPmDelegate().setPersonEnable(true);
		}
		setNetworkConfigBean(bean);
	}
	
	
	public String delegatePMNew() {
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService) JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = bean.getUrNo();
		boolean isError = false;
		try {
			if(bean != null){
				List<String> subUrList = new ArrayList<String>();
				PmAssign data = bean.getPmDelegate();
				if(data != null){
					if(data.getMgrRemark() == null || data.getMgrRemark().trim().equals("")){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage("กรุณาระบุข้อมูล Remarks"));
						return null;
					}else{
							Object listUr = null;
							String urType = bean.getSelectSubUR();
							if (urType == null) urType = bean.getCurrentTab();
							if (urType.equals("FW")) {
								listUr = bean.getListFirewall();
							} else if (urType.equals("AL")) {
								listUr = bean.getListAccessList();
							} else if (urType.equals("AT")) {
								listUr = bean.getListAccessTNP();
							} else if (urType.equals("PI")) {
								listUr = bean.getListPhysicalInterface();
							} else if (urType.equals("IG")) {
								listUr = bean.getListGateway();
							} else if (urType.equals("RT")) {
								listUr = bean.getListRouting();
							} else if (urType.equals("F5")) {
								listUr = bean.getListF5();
							}
							
							List<Object> listSubUr = (List<Object>) listUr;
							
							try{
								for (Object subUr : listSubUr) {
										if (isSelected(subUr)) {
											subUrList.add(getSubUrNo(subUr));
										}
									}
							}catch (Exception e) {
								e.printStackTrace();
							}
							
							
							
							String role = "";
							String actionUserId = "";
							String actionUserName = "";
							if(data.getIsTeamCdn()){
								role = "R07";
							}else if(data.getIsTeamTdno()){
								role = "R06";
							}
							
							if(data.getAssignForTeam() != null && data.getAssignForTeam().equalsIgnoreCase("T")){
								if(role.equals("")){
									IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage("กรุณาเลือก Team ที่ต้องการ Delegate"));
									isError = true;
								}else{
									List<IpRoleMember> userList = nwConfigService.listPerson(role);
									for(IpRoleMember user : userList){
										IpUser userData = user.getIpUser();
										actionUserId = actionUserId + (userData.getUserId()+";");
										actionUserName = actionUserName + (userData.getUserName()+userData.getPhone()+";");
									}
								}
								
								
								
								
							}else if(data.getAssignForPerson()!= null && data.getAssignForPerson().equalsIgnoreCase("P")){
								List<String> userList = data.getSelectedDelegatePerson();
								if(userList != null && userList.size() > 0){
									for(String userData : userList){
										if(userData != null && !(userData.trim().equals(""))){
											String userTmp[] = userData.split(":");
											actionUserId = actionUserId + (""+userTmp[0]+";");
											actionUserName = actionUserName + (""+userTmp[1]+";");
										}
									}
								}else{
									IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage("กรุณาเลือกคนที่ต้องการ Delegate"));
									isError = true;
								}
							}
							
							
							
							
							
							
							try {
								if (!isError) {
									boolean isR6 = (userSession.getIpUser().getRoleIdList().contains("R06"));
									boolean isR7 = (userSession.getIpUser().getRoleIdList().contains("R07"));
									userSession.getIpUser().setUrl(getIPFMConfig().getHomeUrl());
		
									if (isR6 && isR7) {
										bean.setConfFlag(true);
										bean.setSelectedSubUr(subUrList);
									} else if (isR6) {
										nwConfigService.saveDeleagteNew(urNo, subUrList, actionUserId, actionUserName, userSession.getIpUser(), "R07",data.getMgrRemark());
									} else if (isR7) {
										nwConfigService.saveDeleagteNew(urNo, subUrList, actionUserId, actionUserName, userSession.getIpUser(), "R06",data.getMgrRemark());
									}
								} 
								} catch(Exception ex) {
									ex.printStackTrace();
								}
		
		
								setNetworkConfigBean(bean);
								if (bean.getModeReject()!=null && bean.getModeReject().equalsIgnoreCase(IPFMConstant.MODE_REJECT_TEAM)) {
									viewListTab(urNo, IPFMConstant.STATUS_REJECT_TEAM, userSession.getIpUser());
								}else{
									viewListTab(urNo, IPFMConstant.STATUS_WAIT_PM, userSession.getIpUser());
								}
		
								return null;
					}					
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
