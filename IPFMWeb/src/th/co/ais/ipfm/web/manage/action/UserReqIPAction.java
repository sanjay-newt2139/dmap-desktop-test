package th.co.ais.ipfm.web.manage.action;

import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import jxl.Workbook;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ehr.domain.EmployeeProfileOM;
import th.co.ais.ehr.domain.UserAccount;
import th.co.ais.ehr.service.AuthenDBService;
import th.co.ais.ehr.service.EmployeeProfileService2;
import th.co.ais.email.service.EMailService;
import th.co.ais.ipfm.domain1.ExcelErrorMsg;
import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpLevel2;
import th.co.ais.ipfm.domain1.IpMaskDisplay;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.IpUrIpResultId;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.Project;
import th.co.ais.ipfm.domain1.SearchIP;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.ExcelService;
import th.co.ais.ipfm.service.ILoginService;
import th.co.ais.ipfm.service.IPTeamService;
import th.co.ais.ipfm.service.IPUserService;
import th.co.ais.ipfm.service.IpUrActionService;
import th.co.ais.ipfm.service.ManagementIpService;
import th.co.ais.ipfm.service.PlanningReqIPService;
import th.co.ais.ipfm.service.ProjectService;
import th.co.ais.ipfm.service.UserReqIPService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.UserReqIPBean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class UserReqIPAction  extends AbstractAction {
	
	public UserReqIPBean userReqIPBean;

	public UserReqIPBean getUserReqIPBean() {
		return (UserReqIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userReqIPBean");
	}
	public void setUserReqIPBean(UserReqIPBean userReqIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userReqIPBean", userReqIPBean);
	}
	
	public AttachFileNWAction getAttachFileNWAction() {
		return (AttachFileNWAction) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("attachFileNWAction");
	}
	public void setAttachFileNWAction(AttachFileNWAction attachFileNWAction) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("attachFileNWAction", attachFileNWAction);
	}
	public AttachFileAFAction getAttachFileAFAction() {
		return (AttachFileAFAction) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("attachFileAFAction");
	}
	public void setAttachFileAFAction(AttachFileAFAction attachFileAFAction) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("attachFileAFAction", attachFileAFAction);
	}
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		userReqIPBean = getUserReqIPBean();		
		if(TablSort.equalsIgnoreCase("ipDetailTable2")) {
			userReqIPBean.setSort01(sortColumnChange());	
		} else if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			userReqIPBean.setSortIpsur001History(sortColumnChange());	
		} else if(TablSort.equalsIgnoreCase("ipDetailTableUR")) {
			userReqIPBean.setSort00405(sortColumnChange());	
		}
		return "";
	}
	
	@Override
	public String init(String programID) {
		try{
			UserReqIPBean bean = new UserReqIPBean();
			UserSession userSession = IPFMWebUtil.getUserSession();
			bean.setUserSession(userSession);
			String mode = getRequestParameter("MODE");			
			String urNo = getRequestParameter("URNo");
			if (mode == null) mode = IPFMConstant.MODE_NEW;
			bean.setMode(mode);
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
			IPTeamService ipTeamService = (IPTeamService)JSFServiceFinderUtil.getInstance().getBean("ipTeamService");
			if (!bean.getMode().equalsIgnoreCase(IPFMConstant.MODE_NEW)) {
				bean.setIpUrIpDetail(userReqIPService.getIpUrIpDetail(urNo));
				bean.setTeamId(bean.getIpUrIpDetail().getSysOwnerTeamId());				
			}else if (bean.getMode().equalsIgnoreCase(IPFMConstant.MODE_NEW)) {
				bean.getIpUrIpDetail().setReqName(userSession.getIpUser().getUserName());
				bean.getIpUrIpDetail().setReqUserId(userSession.getIpUser().getUserId());
				bean.getIpUrIpDetail().setReqDept(userSession.getIpUser().getDept());
			    bean.getIpUrIpDetail().setReqEmail(userSession.getIpUser().getEmail());
			    bean.getIpUrIpDetail().setReqSection(userSession.getIpUser().getSection());
			    bean.getIpUrIpDetail().setReqMobile(userSession.getIpUser().getMobile());
			    bean.getIpUrIpDetail().setReqPosition(userSession.getIpUser().getPosition());
			    bean.getIpUrIpDetail().setReqTel(userSession.getIpUser().getTel());
			    bean.getIpUrIpDetail().setReqTeam(userSession.getIpUser().getTeamId());			    
			    bean.getIpUrIpDetail().setReqIpTeam(new IpTeam(userSession.getIpUser().getTeamId(),userSession.getIpUser().getTeamName()));
			    bean.getIpUrIpDetail().getReqIpTeam().setTeamName(userSession.getIpUser().getTeamName());
				bean.getIpUrIpDetail().setUrNo(userReqIPService.getTempURNo());
				bean.getIpUrIpDetail().setSysOwnerId(userSession.getIpUser().getUserId());
				bean.getIpUrIpDetail().setSysOwnerName(userSession.getIpUser().getUserName());
				bean.getIpUrIpDetail().setSysOwnerTeamId(userSession.getIpUser().getTeamId());
				bean.getIpUrIpDetail().setSysOwnerTeamName(userSession.getIpUser().getTeamName());
				bean.getIpUrIpDetail().setUrStatus(IPFMConstant.STATUS_DRAFT);
				bean.getIpUrIpDetail().setReqType(IPFMConstant.NO);
				bean.getIpUrIpDetail().setLocationType("D");
				bean.getIpUrIpDetail().setUrType(IPFMConstant.URTYPE_USER_REQ_IP);
				bean.getIpUrIpDetail().setCreatedBy(userSession.getIpUser().getUserId());
				bean.setTeamId(userSession.getIpUser().getTeamId());				
			}
			if (bean.getMode().equalsIgnoreCase(IPFMConstant.MODE_NEW) || bean.getMode().equalsIgnoreCase(IPFMConstant.MODE_EDIT) || bean.getMode().equalsIgnoreCase(IPFMConstant.MODE_REJECT)) {
				
				List<SelectItem> reqTeamList = new ArrayList<SelectItem>();
				List<SelectItem> officeUserStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
				List<SelectItem> dataCenterStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
				List<SelectItem> systemOwnerList = new ArrayList<SelectItem>();
				List<SelectItem> systemOwnerTeamList = new ArrayList<SelectItem>();
				List<SelectItem> netWorkTypeList = IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems();
				List<SelectItem> netWorkZoneList = IPFMComboBoxUtil.getInstance().getZoneComboBoxItems();
				List<SelectItem> projList = getProjectListSelecItem();
				List<SelectItem> projManagerList = new ArrayList<SelectItem>();
				List<SelectItem> managerApproveList = new ArrayList<SelectItem>();
				List<IPFMRichComboItem> selectManagerApproveList = new ArrayList<IPFMRichComboItem>();
				IPFMRichComboItem cbitem;
				
				List<IpUser> projectManagerStringList = userReqIPService.getSystemOwnerList();
				if(projectManagerStringList!=null && projectManagerStringList.size()>0){
					for (IpUser str:projectManagerStringList) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getUserName());
						cbitem.setValue(str.getUserId());
						projManagerList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
				
				List<IpUser> managerApproveStringList = ipUserService.getManagerApproveList(userSession.getIpUser().getManagerId());
				if(managerApproveStringList!=null && managerApproveStringList.size()>0){
					for (IpUser str:managerApproveStringList) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getUserName());
						cbitem.setValue(str.getUserId());
						managerApproveList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
				//SystemOwner DropDown	
//				List<IpUser> systemOwnerStringList = userReqIPService.getSystemOwnerList();
//				if(systemOwnerStringList!=null && systemOwnerStringList.size()>0){
//						for (IpUser str:systemOwnerStringList) {
//							cbitem = new IPFMRichComboItem();
//							cbitem.setLabel(str.getUserName());
//							cbitem.setValue(str.getUserId());
//							systemOwnerList.add(new SelectItem(cbitem, cbitem.getLabel()));
//						}
//				}
			    //SystemOwnerTeam DropDown	
//				List<IpTeam> systemOwnerTeamStringList = userReqIPService.getSystemOwnerTeamList();
//				if(systemOwnerTeamStringList!=null && systemOwnerTeamStringList.size()>0){
//						for (IpTeam str:systemOwnerTeamStringList) {
//							cbitem = new IPFMRichComboItem();
//							cbitem.setLabel(str.getTeamName());
//							cbitem.setValue(str.getTeamId());
//							systemOwnerTeamList.add(new SelectItem(cbitem, cbitem.getLabel()));
//						}
//				}
				List<IpTeam> tier2TeamList = ipTeamService.getTier2TeamList();
				if(tier2TeamList!=null && tier2TeamList.size()>0){
					for (IpTeam str:tier2TeamList) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getTeamName());
						cbitem.setValue(str.getTeamId());
						reqTeamList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
				if (bean.getIpUrIpDetail().getApproveManagerId()!=null && bean.getIpUrIpDetail().getApproveManagerId().trim().length()>0 
					&& bean.getIpUrIpDetail().getApproveManagerList()!=null && bean.getIpUrIpDetail().getApproveManagerList().trim().length()>0) {
					String[] id = bean.getIpUrIpDetail().getApproveManagerId().split(",");
					String[] name = bean.getIpUrIpDetail().getApproveManagerList().split(",");
					for (int i=0 ; i<id.length ; i++) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(name[i]);
						cbitem.setValue(id[i]);
						for(SelectItem item : managerApproveList){
							IPFMRichComboItem cmb = (IPFMRichComboItem)item.getValue();
							if (cmb.getValue().equalsIgnoreCase(cbitem.getValue())){
								selectManagerApproveList.add(cmb);
								break;
							}
						}						
					}
				}
				
				bean.setSelectManagerApproveList(selectManagerApproveList);
				bean.setManagerApproveList(managerApproveList);
				bean.setReqTeamList(reqTeamList);
				bean.setProjList(projList);
				bean.setProjManagerList(projManagerList);
				bean.setSystemOwnerList(systemOwnerList);
				bean.setSystemOwnerTeamList(systemOwnerTeamList);
				//bean.setNewSystemOwnerTeamList(systemOwnerTeamList);
				bean.setNwZoneList(netWorkZoneList);
			    bean.setNwTypeList(netWorkTypeList);
			    bean.setOfficeUserList(officeUserStringList);
			    bean.setDataList(dataCenterStringList);
			    bean.setReqTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getT2TeamId(),bean.getIpUrIpDetail().getT2TeamName()));
				bean.setProjComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getProjId(),bean.getIpUrIpDetail().getProjId()));
				bean.setProjManagerComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getProjManagerId(),bean.getIpUrIpDetail().getProjManagerName()));
				bean.setSystemOwnerComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerId(),bean.getIpUrIpDetail().getSysOwnerName()));
				bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerTeamId(),bean.getIpUrIpDetail().getSysOwnerTeamName()));
				
				bean.getSystemOwnerTeamList().add(new SelectItem(bean.getSystemOwnerTeamComboItem(), bean.getSystemOwnerTeamComboItem().getLabel()));
//				bean.getNewSystemOwnerTeamList().add(new SelectItem(bean.getSystemOwnerTeamComboItem(), bean.getSystemOwnerTeamComboItem().getLabel()));
				bean.setNwTypeComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getNetworkTypeId(), bean.getIpUrIpDetail().getNetworkTypeName()));
				bean.setNwZoneComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getZoneId(),bean.getIpUrIpDetail().getZoneName()));
				
				if (bean.getIpUrIpDetail().getLocationType().equalsIgnoreCase("O")) {
					bean.setOfficeUserComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getLocationId(),bean.getIpUrIpDetail().getLocationName()));
				}else if (bean.getIpUrIpDetail().getLocationType().equalsIgnoreCase("D")) {
					bean.setDataComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getLocationId(),bean.getIpUrIpDetail().getLocationName()));
				}
				if (bean.getProjComboItem()!=null && IPFMUtils.ifBlank(bean.getProjComboItem().getValue(),"").length()>0) {
					bean.setProjNameDisable(true);
					bean.setProjManagerDisable(true);
				}
			}
			if (bean.getMode().equalsIgnoreCase(IPFMConstant.MODE_ASSIGN_IP)) {		
				List<SelectItem> companyStringList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
				List<SelectItem> ipTypeStringList = IPFMComboBoxUtil.getInstance().getIPTypeListComboBoxItems();
				List<SelectItem> networkTypeList = IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems();
				List<SelectItem> networkZoneList = IPFMComboBoxUtil.getInstance().getZoneComboBoxItems();
				List<SelectItem> locationList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
				
				bean.setIpTypeList(ipTypeStringList);
				bean.setCompanyList(companyStringList);
				bean.setNwZoneList(networkZoneList);
			    bean.setNwTypeList(networkTypeList);
			    bean.setLocationList(locationList);
			    bean.getIpUrIpResult().setInstallTypeId("2");
			    bean.getIpUrIpResult().setInstallTypeName("Permanent");
			    bean.getIpUrIpResult().setVip("N");
			    bean.getIpUrIpResult().setEffectiveDate(userSession.getUserReqEffectiveDate());
			    bean.getIpUrIpResult().setExpireDate(userSession.getUserReqExpireDate());
			    bean.getIpUrIpResult().setIpVersion("4");
//			    bean.getIpUrIpResult().setCompanyId("AIS");
//			    bean.getIpUrIpResult().setCompanyName("AIS");
			    bean.setCompanyComboItem(new IPFMRichComboItem(bean.getIpUrIpResult().getCompanyId(),bean.getIpUrIpResult().getCompanyName()));
			    bean.getIpUrIpResult().setLocationId(bean.getIpUrIpDetail().getLocationId());
			    bean.getIpUrIpResult().setLocationName(bean.getIpUrIpDetail().getLocationName());
			    bean.setLocationComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getLocationId(),bean.getIpUrIpDetail().getLocationName()));
			    bean.getIpUrIpResult().setNetworkTypeId(bean.getIpUrIpDetail().getNetworkTypeId());
			    bean.getIpUrIpResult().setNetworkTypeName(bean.getIpUrIpDetail().getNetworkTypeName());
			    bean.setNwTypeComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getNetworkTypeId(),bean.getIpUrIpDetail().getNetworkTypeName()));
			    bean.getIpUrIpResult().setNetworkZoneId(bean.getIpUrIpDetail().getZoneId());
			    bean.getIpUrIpResult().setNetworkZoneName(bean.getIpUrIpDetail().getZoneName());
			    bean.setNwZoneComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getZoneId(),bean.getIpUrIpDetail().getZoneName()));
			}
			bean.setIsAttach1("N");
			bean.setIsAttach2("N");
			List<IpUrAttachment> diagramList = userReqIPService.getIpUrAttachmentList(bean.getIpUrIpDetail().getUrNo(),IPFMConstant.CATEGORY_NETWORK_DIAGRAM);
			bean.setDiagramList(diagramList);
			List<IpUrAttachment> appFlowList = userReqIPService.getIpUrAttachmentList(bean.getIpUrIpDetail().getUrNo(),IPFMConstant.CATEGORY_APPLICATION_FLOW);
			bean.setAppFlowList(appFlowList);
			
			AttachFileNWAction attachFileNWAction = new AttachFileNWAction();
			attachFileNWAction.setListAttach(diagramList);
			setAttachFileNWAction(attachFileNWAction);
			
			AttachFileAFAction attachFileAFAction = new AttachFileAFAction();
			attachFileAFAction.setListAttach(appFlowList);
			setAttachFileAFAction(attachFileAFAction);
			
			
			if (bean.getIpUrIpDetail().getUrStatus().equalsIgnoreCase(IPFMConstant.STATUS_CLOSE)) {	
				List<IpUrIpResult> ipUrIpResultList = userReqIPService.getIpUrIpResultList(urNo);
				if (ipUrIpResultList == null) ipUrIpResultList = new ArrayList<IpUrIpResult>();
				if (ipUrIpResultList!=null && ipUrIpResultList.size()>0)bean.setIpUrIpResult(ipUrIpResultList.get(0));
//				for (IpUrIpResult ipUrIpResult : ipUrIpResultList) {
//					List<IpInfo> assignList = userReqIPService.getIpInfoAssignIp(ipUrIpResult.getBinary2Start(),ipUrIpResult.getBinary2End());
//					ipUrIpResult.setIpInfoList(assignList);
//				}
				bean.setIpUrIpResultList(ipUrIpResultList);
			}
		
			setUserReqIPBean(bean);
		}catch (IPFMBusinessException e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(e.getMessage());
		}
		return programID;
	}
	
	public List<SelectItem> userSuggestion(Object event) throws Exception{
		if (event.toString()==null) return new ArrayList<SelectItem>();
		return getUserListSelectItem(event.toString());
	}
	
	public void suggestManager() throws IPFMBusinessException{
		UserReqIPBean bean = getUserReqIPBean();
		if (bean.getSuggestProjManager().getRowIndex() < 0){
			bean.setProjManagerComboItem(new IPFMRichComboItem());
			bean.getIpUrIpDetail().setProjManagerId("");
		}else{
			SelectItem item = (SelectItem)bean.getSuggestProjManager().getRowData();
			IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
			bean.getIpUrIpDetail().setProjManagerId(combo.getValue());
			bean.getIpUrIpDetail().setProjManagerName(combo.getLabel());
		}
		setUserReqIPBean(bean);
	}
	
	public void suggestSysOwner() throws Exception{
		UserReqIPBean bean = getUserReqIPBean();
		if (bean.getSuggestSystemOwner().getRowIndex() < 0){
			bean.setSystemOwnerTeamList(new ArrayList<SelectItem>());
			bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem());
			bean.getIpUrIpDetail().setSysOwnerId("");
			bean.getIpUrIpDetail().setSysOwnerTeamId("");
			bean.getIpUrIpDetail().setSysOwnerTeamName("");
			bean.setTeamId("");
		}else{
//			bean.setSystemOwnerTeamList(bean.getNewSystemOwnerTeamList());
			SelectItem item = (SelectItem)bean.getSuggestSystemOwner().getRowData();
			IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
			bean.getIpUrIpDetail().setSysOwnerId(combo.getValue());
			bean.getIpUrIpDetail().setSysOwnerName(combo.getLabel());
			IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
			IpUser ipUser = ipUserService.findIpUserById(combo.getValue());
			if (ipUser==null) {
				AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
				EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
				UserAccount authUser = authService.getAuthenUserConfig();
				List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByEmail(authUser, combo.getValue1());
				bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem());
				if (userList!=null && userList.size()>0) {
					EmployeeProfileOM profile = userList.get(0);
					profile.setSCNAME(profile.getORGNAME());
					profile.setSCCODE(profile.getORGCODE());
					if (profile.getSCNAME()!=null && profile.getSCNAME().trim().length()>0) {
						bean.getIpUrIpDetail().setSysOwnerTeamId(IPFMUtils.ifBlank(profile.getSCNAME(),""));
						bean.getIpUrIpDetail().setSysOwnerTeamName(IPFMUtils.ifBlank(profile.getSCNAME(),""));
					}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
						bean.getIpUrIpDetail().setSysOwnerTeamId(IPFMUtils.ifBlank(profile.getDPNAME(),""));
						bean.getIpUrIpDetail().setSysOwnerTeamName(IPFMUtils.ifBlank(profile.getDPNAME(),""));
					}else{
						bean.getIpUrIpDetail().setSysOwnerTeamId("NA");
						bean.getIpUrIpDetail().setSysOwnerTeamName("NA");
					}
				}
	
				UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
				IpTeam ipTeam = userReqIPService.findIpTeamById(bean.getIpUrIpDetail().getSysOwnerTeamId());
				if (ipTeam!=null){
					bean.getIpUrIpDetail().setSysOwnerTeamId(ipTeam.getTeamId());
					bean.getIpUrIpDetail().setSysOwnerTeamName(ipTeam.getTeamName());
					bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()));
					bean.setTeamId(ipTeam.getTeamId());
				}else{
					bean.setTeamId(bean.getIpUrIpDetail().getSysOwnerTeamName());
					bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerTeamName(),bean.getIpUrIpDetail().getSysOwnerTeamName()));
					bean.getSystemOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerTeamName(),bean.getIpUrIpDetail().getSysOwnerTeamName()),bean.getIpUrIpDetail().getSysOwnerTeamName()));
				}
			}else{
				bean.getIpUrIpDetail().setSysOwnerTeamId(ipUser.getTeamId());
				bean.getIpUrIpDetail().setSysOwnerTeamName(ipUser.getTeamName());
				bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerTeamId(),bean.getIpUrIpDetail().getSysOwnerTeamName()));
				bean.getSystemOwnerTeamList().add(new SelectItem(bean.getSystemOwnerTeamComboItem(), bean.getSystemOwnerTeamComboItem().getLabel()));
			}
//			boolean flag = true;
//			for(SelectItem selectItem : bean.getSystemOwnerTeamList()){
//				if (bean.getIpUrIpDetail().getSysOwnerTeamName().trim().equalsIgnoreCase(selectItem.getLabel().trim())) {
//					bean.getIpUrIpDetail().setSysOwnerTeamId(((IPFMRichComboItem)selectItem.getValue()).getValue());
//					bean.setSystemOwnerTeamComboItem((IPFMRichComboItem)selectItem.getValue());
//					bean.setTeamId(((IPFMRichComboItem)selectItem.getValue()).getValue());
//					flag = false;
//					break;
//				}
//			}
//			if (flag) {
//				bean.setTeamId(bean.getIpUrIpDetail().getSysOwnerTeamName());
//				bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerTeamName(),bean.getIpUrIpDetail().getSysOwnerTeamName()));
//				bean.getSystemOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getSysOwnerTeamName(),bean.getIpUrIpDetail().getSysOwnerTeamName()),bean.getIpUrIpDetail().getSysOwnerTeamName()));
//			}
		}
		setUserReqIPBean(bean);
	}
	
	private List<SelectItem> getUserListSelectItem(String userName) throws Exception{
		AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
		EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
		List<SelectItem> userListSelectItem = new ArrayList<SelectItem>();
		try {
			if (IPFMUtils.ifBlank(userName, "").trim().length()==0) return userListSelectItem;
			Long startTime = System.currentTimeMillis();
			
			UserAccount authUser = authService.getAuthenUserConfig();
			List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByPrefixEngName(authUser, userName+"%");
			
			Long endTime = System.currentTimeMillis();
			System.out.println("call time = "+ new Double((endTime-startTime)/1000D));
			IPFMRichComboItem cbitem;
//			startTime = System.currentTimeMillis();
//			System.out.println("startTime time = "+ startTime);
			String teamName = "";
			if(userList!=null && userList.size()>0){
				int count = 1;
				for (EmployeeProfileOM profile : userList) {
					if (count>getIPFMConfig().getSuggestSize()) break;
					count++;
					cbitem = new IPFMRichComboItem();
					cbitem.setLabel(IPFMUtils.ifBlank(profile.getENFIRSTNAME(),"")+" "+IPFMUtils.ifBlank(profile.getENLASTNAME(),""));
					String email = profile.getEMAIL();
					cbitem.setValue(email.substring(0,email.indexOf("@")));
					if (profile.getSCNAME()!=null && profile.getSCNAME().trim().length()>0) {
						teamName = profile.getSCNAME();
					}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
						teamName = profile.getDPNAME();
					}else{
						teamName = "NA";
					}
					cbitem.setValue2(teamName);					
					cbitem.setValue1(email);
					userListSelectItem.add(new SelectItem(cbitem, cbitem.getLabel()==null?"":cbitem.getLabel()));
				}
			}
//			endTime = System.currentTimeMillis();
//			System.out.println("endTime time = "+ endTime);
//			System.out.println("set value time = "+ new Double((endTime-startTime)/1000D));
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			throw ipfme;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userListSelectItem;
	}
	
	public void clear() {
		UserReqIPBean bean = getUserReqIPBean();
		bean.setIpUrIpDetail(new IpUrIpDetail());
		setUserReqIPBean(bean);
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;		
		if(userReqIPBean.getIpUrIpDetail().getSubject() == null || userReqIPBean.getIpUrIpDetail().getSubject().trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Subject"));
		}
		if(IPFMUtils.ifBlank(userReqIPBean.getReqTeamComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(userReqIPBean.getReqTeamComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Request from Planning Team"));
			}
		}else{
			checkReqTeamCombo();
		}
		
		if (userReqIPBean.getProjComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getProjComboItem().getValue(),"").trim().length()==0) {
			if (IPFMUtils.ifBlank(userReqIPBean.getProjComboItem().getLabel(),"").trim().length()>0) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0075"), userReqIPBean.getProjComboItem().getLabel()));
			} 
//			else if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getProjName(),"").trim().length()>0) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Project ID"));
//			}
		}
		if (userReqIPBean.getProjComboItem()==null || IPFMUtils.ifBlank(userReqIPBean.getProjComboItem().getValue(),"").trim().length()==0) {
			if(IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getProjManagerName(),"").trim().length()>0
				&& IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getProjManagerId(),"").trim().length()==0){
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), userReqIPBean.getIpUrIpDetail().getProjManagerName()));
			}
		} 
		
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getSysOwnerName(),"").length()>0 && userReqIPBean.getIpUrIpDetail().getSysOwnerId().equalsIgnoreCase("")) {
			//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), userReqIPBean.getIpUrIpDetail().getSysOwnerName()));
		}
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getSysOwnerId(),"").length()==0 && IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner"));
		}
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getSysOwnerId(),"").length()>0 && IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerTeamComboItem().getValue(),"").length()==0) {
			if(IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerTeamComboItem().getLabel(),"").length()>0){
				checkSystemOwnerTeamCombo();
			}else{
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Team "));
			}
		}
		
		if(userReqIPBean.getIpUrIpDetail().getNwSysDetail() == null || userReqIPBean.getIpUrIpDetail().getNwSysDetail().trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network System Requirement"));
		}else if(userReqIPBean.getIpUrIpDetail().getNwSysDetail().trim().length()>1000){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Network System Requirement"));
		}
		if(IPFMUtils.ifBlank(userReqIPBean.getNwTypeComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(userReqIPBean.getNwTypeComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Type"));
			}
		}else{
			checkNwTypeCombo();	
		}
		if(userReqIPBean.getIpUrIpDetail().getReqType() == null || userReqIPBean.getIpUrIpDetail().getReqType().trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Request Type"));
		}else{
			if (userReqIPBean.getIpUrIpDetail().getReqType().equalsIgnoreCase("N")) {
				if(IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getLabel(),"").length()==0){
					if(IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getValue(),"").trim().length()==0){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Zone Name"));
					}
				}else{
					checkNwZoneCombo();
				}
			}else{
				if(IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getLabel(),"").length()==0){
					if(IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getValue(),"").trim().length()==0){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Existing Network Zone"));
					}
				}else{
					checkNwZoneCombo();
				}
				if(userReqIPBean.getIpUrIpDetail().getIpRef()==null  || IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getIpRef(),"").trim().length()==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Existing IP Network Ref"));
				}
			}
			if (userReqIPBean.getIpUrIpDetail().getLocationType().equalsIgnoreCase("D")) {
				if(IPFMUtils.ifBlank(userReqIPBean.getDataComboItem().getLabel(),"").length()==0){
					if(IPFMUtils.ifBlank(userReqIPBean.getDataComboItem().getValue(),"").trim().length()==0){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Site/Location"));
					}
				}else{
					checkDataCombo();
				}
			}else{
				if(IPFMUtils.ifBlank(userReqIPBean.getOfficeUserComboItem().getLabel(),"").length()==0){
					if(IPFMUtils.ifBlank(userReqIPBean.getOfficeUserComboItem().getValue(),"").trim().length()==0){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Site/Location "));
					}
				}else{
					checkOfficeUserCombo();
				}
			}
		}
		if ((userReqIPBean.getIpUrIpDetail().getTotalNode()==null ||  userReqIPBean.getIpUrIpDetail().getTotalNode().intValue()==0)
			&& (userReqIPBean.getIpUrIpDetail().getClassB()==null ||  userReqIPBean.getIpUrIpDetail().getClassB().intValue()==0)
			&& (userReqIPBean.getIpUrIpDetail().getClassC()==null ||  userReqIPBean.getIpUrIpDetail().getClassC().intValue()==0)){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Size"));
		}
		
		if (userReqIPBean.getSelectManagerApproveList()==null || userReqIPBean.getSelectManagerApproveList().size()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Approve Manager"));
		}
		
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	} 
	
	private void prepareData(UserReqIPBean userReqIPBean) {
		IpUrIpDetail ipUrIPDetail = userReqIPBean.getIpUrIpDetail();
		// get Value and Label T2Team DropDown
		if(userReqIPBean.getReqTeamComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getReqTeamComboItem().getValue(),"").trim().length()>0){
			ipUrIPDetail.setT2TeamId(userReqIPBean.getReqTeamComboItem().getValue());
			ipUrIPDetail.setT2TeamName(userReqIPBean.getReqTeamComboItem().getLabel());	
		}
		// get Value and Label Project DropDown
		if(userReqIPBean.getProjComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getProjComboItem().getValue(),"").trim().length()>0){
			ipUrIPDetail.setProjId(userReqIPBean.getProjComboItem().getValue());
			ipUrIPDetail.setProjName(userReqIPBean.getProjComboItem().getValue2());	
		}
		// get Value and Label Project Manager DropDown
//		if(userReqIPBean.getProjManagerComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getProjManagerComboItem().getValue(),"").trim().length()>0){
//			ipUrIPDetail.setProjManagerId(userReqIPBean.getProjManagerComboItem().getValue());
//			ipUrIPDetail.setProjManagerName(userReqIPBean.getProjManagerComboItem().getLabel());	
//		}
	    // get Value and Label SystemOwner DropDown
//		if(userReqIPBean.getSystemOwnerComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerComboItem().getValue(),"").trim().length()>0){
//			ipUrIPDetail.setSysOwnerId(userReqIPBean.getSystemOwnerComboItem().getValue());
//			ipUrIPDetail.setSysOwnerName(userReqIPBean.getSystemOwnerComboItem().getLabel());	
//		}
		// get Value and Label SystemOwnerTeam DropDown
		if(userReqIPBean.getSystemOwnerTeamComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerTeamComboItem().getValue(),"").trim().length()>0){
			ipUrIPDetail.setSysOwnerTeamId(userReqIPBean.getSystemOwnerTeamComboItem().getValue());
			ipUrIPDetail.setSysOwnerTeamName(userReqIPBean.getSystemOwnerTeamComboItem().getLabel());	
		}
		// get Value and Label NetworkType DropDown
		if(userReqIPBean.getNwTypeComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getNwTypeComboItem().getValue(),"").trim().length()>0){
			ipUrIPDetail.setNetworkTypeId(userReqIPBean.getNwTypeComboItem().getValue());
			ipUrIPDetail.setNetworkTypeName(userReqIPBean.getNwTypeComboItem().getLabel());	
		}
		// get Value and Label NetworkZone DropDown
		if(userReqIPBean.getNwZoneComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getValue(),"").trim().length()>0){
			ipUrIPDetail.setZoneId(userReqIPBean.getNwZoneComboItem().getValue());
			ipUrIPDetail.setZoneName(userReqIPBean.getNwZoneComboItem().getLabel());	
		}
		// get Value and Label Location DropDown
		if (ipUrIPDetail.getLocationType().equalsIgnoreCase("D")) {
			if(userReqIPBean.getDataComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getDataComboItem().getValue(),"").trim().length()>0){
				ipUrIPDetail.setLocationId(userReqIPBean.getDataComboItem().getValue());
				ipUrIPDetail.setLocationName(userReqIPBean.getDataComboItem().getLabel());	
			}
		}else if (ipUrIPDetail.getLocationType().equalsIgnoreCase("O")){
			if(userReqIPBean.getOfficeUserComboItem()!=null  && IPFMUtils.ifBlank(userReqIPBean.getOfficeUserComboItem().getValue(),"").trim().length()>0){
				ipUrIPDetail.setLocationId(userReqIPBean.getOfficeUserComboItem().getValue());
				ipUrIPDetail.setLocationName(userReqIPBean.getOfficeUserComboItem().getLabel());	
			}
		}
		
		if(ipUrIPDetail.getReqType().equalsIgnoreCase("N")){
			ipUrIPDetail.setIpRef("");
		}
		String approveManagerId = "";
		String approveManagerList = "";
		if (userReqIPBean.getSelectManagerApproveList().size()>0) {
			List<IPFMRichComboItem> selectList = userReqIPBean.getSelectManagerApproveList();
			for (IPFMRichComboItem cmbi : selectList) {
				if (IPFMUtils.ifBlank(approveManagerId,"").trim().length()==0) {
					approveManagerId = cmbi.getValue();
				}else{
					approveManagerId = approveManagerId+","+cmbi.getValue();
				}
				if (IPFMUtils.ifBlank(approveManagerList,"").trim().length()==0) {
					approveManagerList = cmbi.getLabel();
				}else{
					approveManagerList = approveManagerList+","+cmbi.getLabel();
				}
			}
		}
		ipUrIPDetail.setApproveManagerId(approveManagerId);
		ipUrIPDetail.setApproveManagerList(approveManagerList);	
		ipUrIPDetail.setLastUpdBy(IPFMWebUtil.getUserId());
	}
	public void refeshAttachFile(UserReqIPBean bean){
		AttachFileAFAction attachFileAFAction = getAttachFileAFAction();
		AttachFileNWAction attachFileNWAction = getAttachFileNWAction();
		try {
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			List<IpUrAttachment> diagramList = userReqIPService.getIpUrAttachmentList(bean.getIpUrIpDetail().getUrNo(),IPFMConstant.CATEGORY_NETWORK_DIAGRAM);
		
			bean.setDiagramList(diagramList);
			List<IpUrAttachment> appFlowList = userReqIPService.getIpUrAttachmentList(bean.getIpUrIpDetail().getUrNo(),IPFMConstant.CATEGORY_APPLICATION_FLOW);
			bean.setAppFlowList(appFlowList);
			
			attachFileNWAction.setListAttach(diagramList);
			setAttachFileNWAction(attachFileNWAction);
			
			attachFileAFAction.setListAttach(appFlowList);
			setAttachFileAFAction(attachFileAFAction);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	public void checkNewUser(String userId) throws IPFMBusinessException{
		ILoginService loginService = (ILoginService)JSFServiceFinderUtil.getInstance().getBean("loginService");
		loginService.checkNewUser(userId);
	}
	public String saveDraft(){
		try {
			UserSession userSession = IPFMWebUtil.getUserSession();
		    UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
		    IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
		    userReqIPBean = getUserReqIPBean();
		    
			prepareData(userReqIPBean);
			
			if(userReqIPBean.getIpUrIpDetail().getSysOwnerId() == null || userReqIPBean.getIpUrIpDetail().getSysOwnerId().equals("")) {
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), userReqIPBean.getIpUrIpDetail().getSysOwnerName()));
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
			} else if (userReqIPBean.getIpUrIpDetail().getSysOwnerName() == null || userReqIPBean.getIpUrIpDetail().getSysOwnerName().equals("")) {
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), userReqIPBean.getIpUrIpDetail().getSysOwnerName()));
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
			}
			
			if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getSysOwnerId(),"").length()>0 
					&& IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0 ){
					IpUser sysUser = ipUserService.findIpUserById(userReqIPBean.getIpUrIpDetail().getSysOwnerId());
					if (sysUser!=null) {
						if (!sysUser.getTeamId().equalsIgnoreCase(userReqIPBean.getSystemOwnerTeamComboItem().getValue())) {
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
						}
					}else{
						if (!userReqIPBean.getSystemOwnerTeamComboItem().getValue().equalsIgnoreCase(userReqIPBean.getTeamId())) {
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
						}
					}
				}
			if (IPFMMessageUtils.hasMessages()) return null;
			
			
			userReqIPBean.getIpUrIpDetail().setUrStatusName(userReqIPService.getUrStatusDesc(userReqIPBean.getIpUrIpDetail().getUrType(), userReqIPBean.getIpUrIpDetail().getUrStatus()));
			if (userReqIPBean.getMode().equalsIgnoreCase(IPFMConstant.MODE_NEW)) {
				userReqIPBean.setIpUrIpDetail(userReqIPService.createDraft(userReqIPBean.getIpUrIpDetail()));
				userReqIPBean.getSystemOwnerTeamComboItem().setLabel(userReqIPBean.getIpUrIpDetail().getSysOwnerTeamName());
				userReqIPBean.getSystemOwnerTeamComboItem().setValue(userReqIPBean.getIpUrIpDetail().getSysOwnerTeamId());
			}else if (userReqIPBean.getMode().equalsIgnoreCase(IPFMConstant.MODE_EDIT)) {
				userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
				userReqIPBean.getIpUrIpDetail().setLastUpd(null);
				userReqIPBean.setIpUrIpDetail(userReqIPService.updateDraft(userReqIPBean.getIpUrIpDetail()));
				userReqIPBean.getSystemOwnerTeamComboItem().setLabel(userReqIPBean.getIpUrIpDetail().getSysOwnerTeamName());
				userReqIPBean.getSystemOwnerTeamComboItem().setValue(userReqIPBean.getIpUrIpDetail().getSysOwnerTeamId());
			}
			refeshAttachFile(userReqIPBean);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			
			userReqIPBean.setMode(IPFMConstant.MODE_EDIT);				
			setUserReqIPBean(userReqIPBean);
			
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	public String sendForApprove(){
		try {
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			userReqIPBean = getUserReqIPBean();
			UserSession userSession = IPFMWebUtil.getUserSession();
			validate();
			IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
			
			if(userReqIPBean.getIpUrIpDetail().getSysOwnerId() == null || userReqIPBean.getIpUrIpDetail().getSysOwnerId().equals("")) {
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), userReqIPBean.getIpUrIpDetail().getSysOwnerName()));
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
			} else if (userReqIPBean.getIpUrIpDetail().getSysOwnerName() == null || userReqIPBean.getIpUrIpDetail().getSysOwnerName().equals("")) {
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), userReqIPBean.getIpUrIpDetail().getSysOwnerName()));
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
			}
			
			if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getSysOwnerId(),"").length()>0 
				&& IPFMUtils.ifBlank(userReqIPBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0 ){
				IpUser sysUser = ipUserService.findIpUserById(userReqIPBean.getIpUrIpDetail().getSysOwnerId());
				if (sysUser!=null) {
					if (!sysUser.getTeamId().equalsIgnoreCase(userReqIPBean.getSystemOwnerTeamComboItem().getValue())) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
					}
				}else{
					if (!userReqIPBean.getSystemOwnerTeamComboItem().getValue().equalsIgnoreCase(userReqIPBean.getTeamId())) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
					}
				}
			}
			if (IPFMMessageUtils.hasMessages()) return null;
			userReqIPBean.getIpUrIpDetail().setUrStatus(IPFMConstant.STATUS_WAIT_MRG);
			userReqIPBean.getIpUrIpDetail().setUrStatusName(userReqIPService.getUrStatusDesc(userReqIPBean.getIpUrIpDetail().getUrType(), userReqIPBean.getIpUrIpDetail().getUrStatus()));
			userReqIPBean.getIpUrIpDetail().setReqDate(new Date());
			userReqIPBean.getIpUrIpDetail().setOverSla("N");
			userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setLastUpd(null);
			prepareData(userReqIPBean);					
		    if(IPFMUtils.ifBlank(userReqIPBean.getMode(), "").equalsIgnoreCase(IPFMConstant.MODE_NEW) ){
				userReqIPService.createSendForApprove(userReqIPBean.getIpUrIpDetail());
			}else if(IPFMUtils.ifBlank(userReqIPBean.getMode(), "").equalsIgnoreCase(IPFMConstant.MODE_EDIT)){
		    	userReqIPService.updateSendForApprove(userReqIPBean.getIpUrIpDetail());
			}
		    sendEmail(userReqIPBean, userReqIPBean.getIpUrIpDetail().getUrType(), IPFMConstant.URTYPENAME_USER_REQ_IP, userReqIPBean.getIpUrIpDetail().getUrStatus(), userReqIPBean.getIpUrIpDetail().getUrStatusName(), "", "N2" ,EMailService.TEMPLATE_IPFM,IPFMConstant.WAITFORAPPROVE,IPFMConstant.WAITFORAPPROVE);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	public String deleteUR(){
		try {
			UserSession userSession = IPFMWebUtil.getUserSession();
			userReqIPBean = getUserReqIPBean();
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			userReqIPBean.getIpUrIpDetail().setLastUpd(null);
			userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
			userReqIPService.deleteUR(userReqIPBean.getIpUrIpDetail());
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0025")));
			IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0009")));
		}
		return null;
	}
	
	public String approveUR(){
		try {
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			userReqIPBean = getUserReqIPBean();
			UserSession userSession = IPFMWebUtil.getUserSession();
			userReqIPBean.getIpUrIpDetail().setOverSla(userReqIPService.isOverSla(userReqIPBean.getIpUrIpDetail().getUrNo()));
			userReqIPBean.getIpUrIpDetail().setUrStatus(IPFMConstant.STATUS_WAIT_ASSIGN);
			userReqIPBean.getIpUrIpDetail().setUrStatusName(userReqIPService.getUrStatusDesc(userReqIPBean.getIpUrIpDetail().getUrType(), userReqIPBean.getIpUrIpDetail().getUrStatus()));
			userReqIPBean.getIpUrIpDetail().setApproveManagerId(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setApproveManagerList(userSession.getIpUser().getUserName());
			userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setLastUpd(null);
		    userReqIPService.approveUR(userReqIPBean.getIpUrIpDetail(),IPFMConstant.ACTION_MRG_APPR);				
		    sendEmail(userReqIPBean, userReqIPBean.getIpUrIpDetail().getUrType(), IPFMConstant.URTYPENAME_USER_REQ_IP, userReqIPBean.getIpUrIpDetail().getUrStatus(), userReqIPBean.getIpUrIpDetail().getUrStatusName(), "", "N3" ,EMailService.TEMPLATE_IPFM,IPFMConstant.WAITFORASSIGN,IPFMConstant.WAITFORASSIGN);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	public String rejectUR(){
		try {
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			userReqIPBean = getUserReqIPBean();
			UserSession userSession = IPFMWebUtil.getUserSession();
			if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getMrgRemark(),"").equalsIgnoreCase("")) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Remarks"));
				return null;
			}
			userReqIPBean.getIpUrIpDetail().setOverSla("N");
			userReqIPBean.getIpUrIpDetail().setUrStatus(IPFMConstant.STATUS_REJECT_MRG);
			userReqIPBean.getIpUrIpDetail().setUrStatusName(userReqIPService.getUrStatusDesc(userReqIPBean.getIpUrIpDetail().getUrType(), userReqIPBean.getIpUrIpDetail().getUrStatus()));
			userReqIPBean.getIpUrIpDetail().setApproveManagerId(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setApproveManagerList(userSession.getIpUser().getUserName());
			userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setLastUpd(null);
		    userReqIPService.rejectUR(userReqIPBean.getIpUrIpDetail(),IPFMConstant.ACTION_MRG_REJ);				
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	public String rejectURAssignIP(){
		try {
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			userReqIPBean = getUserReqIPBean();
			UserSession userSession = IPFMWebUtil.getUserSession();
//			if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpDetail().getMrgRemark(),"").equalsIgnoreCase("")) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Remarks"));
//				return null;
//			}
			userReqIPBean.getIpUrIpDetail().setUrStatus(IPFMConstant.STATUS_REJECT_BY_PLANNING);
			userReqIPBean.getIpUrIpDetail().setUrStatusName(userReqIPService.getUrStatusDesc(userReqIPBean.getIpUrIpDetail().getUrType(), userReqIPBean.getIpUrIpDetail().getUrStatus()));
			userReqIPBean.getIpUrIpDetail().setApproveManagerId(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setApproveManagerList(userSession.getIpUser().getUserName());
			userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
			userReqIPBean.getIpUrIpDetail().setLastUpd(null);
		    userReqIPService.rejectURAssignIP(userReqIPBean.getIpUrIpDetail());				
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	public String showIpInfoDataTable(){
		userReqIPBean = getUserReqIPBean();
		 try {
			 int rowIndex = Integer.parseInt(getRequestParameter("rowIndex"));
			 HtmlDataTable dataTable = userReqIPBean.getIpResultDataTable();
			 dataTable.setRowIndex(rowIndex);
			 IpUrIpResult ipResult = (IpUrIpResult)dataTable.getRowData();
			 if (ipResult.isRowShowIpInfo()) {
				 ipResult.setRowShowIpInfo(false);
			 }else{
				 ipResult.setRowShowIpInfo(true);
			 }
//			 userReqIPBean.setIpInfoIndex(rowIndex);
			 setUserReqIPBean(userReqIPBean);		     
//		}catch (IPFMBusinessException ipfme){
//			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	public String addIP(){
		UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
		userReqIPBean = getUserReqIPBean();
	    try {
    		//validateAssignInfo();
    	    validateAddIP();
    	    if (IPFMMessageUtils.hasMessages()) return null;
    	    
		    //prepareComboResult(userReqIPBean);
    	    userReqIPBean.getIpUrIpResult().setVt2TeamId(userReqIPBean.getIpUrIpDetail().getT2TeamId());
		    IpUrIpResult  result  =  userReqIPService.checkIPRange23(userReqIPBean.getIpUrIpResult());
		    if(IPFMConstant.RESULT_SUCCESS.equalsIgnoreCase(result.getResult())){
		    	IpUrIpResult  ipUrIpResult = (IpUrIpResult)result.clone();
	        	IpUrIpResultId id = new IpUrIpResultId(userReqIPBean.getIpUrIpDetail().getUrNo(),null);
	        	ipUrIpResult.setId(id);	
	        	ipUrIpResult.setSystemName(userReqIPBean.getIpUrIpResult().getSystemName());
	        	ipUrIpResult.setEffectiveDate(userReqIPBean.getIpUrIpResult().getEffectiveDate());
	        	ipUrIpResult.setExpireDate(userReqIPBean.getIpUrIpResult().getExpireDate());
	        	
	        	List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
	        	String[] strIpStart = ipUrIpResult.getLevel2Start().split("\\.");
	        	if (strIpStart.length==4) {
		        	int ipDigit1 = Integer.parseInt(strIpStart[0]);
		        	int ipDigit2 = Integer.parseInt(strIpStart[1]);
		        	int ipDigit3 = Integer.parseInt(strIpStart[2]);
		        	int ipDigit4 = Integer.parseInt(strIpStart[3]);
					for (int i=0;i<result.getTotalIp();i++) {
						if (ipDigit4>255) { ipDigit4=0; ipDigit3++; }
						if (ipDigit3>255) { ipDigit3=0; ipDigit2++; }
						if (ipDigit2>256) { ipDigit2=0; ipDigit1++; }
						if (ipDigit1>255) break;							
						String ipAddress = String.valueOf(ipDigit1)+"."+String.valueOf(ipDigit2)+"."+String.valueOf(ipDigit3)+"."+String.valueOf(ipDigit4);
						IpInfo ipInfo = newIpInfo(userReqIPBean.getIpUrIpDetail(), ipUrIpResult, ipAddress);
						ipInfoList.add(ipInfo);
						ipDigit4++;
					}
	        	}
	        	ipUrIpResult.setIpInfoList(ipInfoList);
	        	if (ipUrIpResult.getIpInfoList().size()==1) ipUrIpResult.setRowShowIpInfo(true);
	        	userReqIPBean.getIpUrIpResultList().add(ipUrIpResult);
	        	
		    }else if(IPFMConstant.Found.equalsIgnoreCase(result.getResult())){
		    	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER5001"), result.getLevel1Start()+"-"+result.getLevel1End()));
		    }else{
		    	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(result.getResult()));
		    }
		    setUserReqIPBean(userReqIPBean);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}
	
	private boolean validateAddIP() {
		boolean flgValid = true;
		userReqIPBean = getUserReqIPBean();
		ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
		
		if(IPFMUtils.ifBlank(userReqIPBean.getCompanyComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(userReqIPBean.getCompanyComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
			}
		}else{
			checkCompanyCombo();
		}
		if(IPFMUtils.ifBlank(userReqIPBean.getIpTypeComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(userReqIPBean.getIpTypeComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Type"));
			}
		}else{
			checkIpTypeCombo();
		}
		checkLocationCombo();
		checkNwTypeCombo();
		checkNwZoneCombo();
		
		if(IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getIpVersion(),"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}
		
		if(IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getIpDigit1(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getIpDigit2(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getIpDigit3(),"").trim().length()==0 
			|| IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getIpDigit4(),"").trim().length()==0 ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		}
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getMask(),"").trim().length()>0) {
			if (Integer.parseInt(IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getMask(),"").trim()) < 8 || 
				Integer.parseInt(IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getMask(),"").trim())>32 ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
			}
		}
		List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
		int maxSearchResult = getIPFMConfig().getMaxSearchResult();
		
		try {
			ipLevel2List = managementIpService.searchIpManagementLevel2(userReqIPBean.getIpUrIpResult().getIpVersion(), userReqIPBean.getIpUrIpResult().getIpDigit1()
			               , userReqIPBean.getIpUrIpResult().getIpDigit2(), userReqIPBean.getIpUrIpResult().getIpDigit3(), userReqIPBean.getIpUrIpResult().getIpDigit4()
			               , userReqIPBean.getIpUrIpResult().getMask(),maxSearchResult);
		} catch (IPFMBusinessException e1) {
			e1.printStackTrace();
		}
		
		if(ipLevel2List!=null && ipLevel2List.size()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0201")));
			return flgValid;
		}
		
		Date expiredDate = null;
        for(IpLevel2 ipLevel2:ipLevel2List){
            if(ipLevel2.getLevel2Id().equals("0")){
            	expiredDate = ipLevel2.getExpiredDate();
            	break;
            } 
        }
       try {
    	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String  expireDateDefault =  IPFMUtils.cnvDateToString(expiredDate, "dd/MM/yyyy");
			String  userRqExpireDate =  IPFMUtils.cnvDateToString(userReqIPBean.getIpUrIpResult().getExpireDate(), "dd/MM/yyyy");
			Date d1 = df.parse(expireDateDefault);
			Date d2 = df.parse(userRqExpireDate);
				if(d1.equals(d2)|| d1.before(d2)){
					    IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0209")));
				}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	
	public void searchIPCheckAllAction(){
		//System.out.println("------ checkAll -------");
		userReqIPBean = getUserReqIPBean();
		try{
			if (userReqIPBean.getSearchIPDataTable().getRowCount()>0) {
				HtmlDataTable dataTable = userReqIPBean.getSearchIPDataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				if (endRow==0) endRow = dataTable.getRowCount();
				int rowSize = dataTable.getRowCount();
				for (int i=startRow ; i<endRow ; i++) {
					if (i == rowSize) break;
					dataTable.setRowIndex(i);
					IpInfo ipInfo = (IpInfo) dataTable.getRowData();
					if (ipInfo.isButtonCheck()) {
						ipInfo.setRowCheck(userReqIPBean.isSearchIPCheckAll());
					}
				}
			}
			setUserReqIPBean(userReqIPBean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public void checkAll(){
		//System.out.println("------ checkAll -------");
		userReqIPBean = getUserReqIPBean();
		try{
			if (userReqIPBean.getIpResultDataTable().getRowCount()>0) {
				HtmlDataTable dataTable = userReqIPBean.getIpResultDataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				if (endRow==0) endRow = dataTable.getRowCount();
				int rowSize = dataTable.getRowCount();
				for (int i=startRow ; i<endRow ; i++) {
					if (i == rowSize) break;
					dataTable.setRowIndex(i);
					IpUrIpResult ipResult = (IpUrIpResult) dataTable.getRowData();
					ipResult.setRowCheck(userReqIPBean.isCheckAll());
				}
			}
			setUserReqIPBean(userReqIPBean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public String deleteIP(){
		userReqIPBean = getUserReqIPBean();
		//System.out.println("------ delete IP -------");
    	try{
    		List<IpUrIpResult> removeList = new ArrayList<IpUrIpResult>();
    		if (userReqIPBean.getIpResultDataTable().getRowCount()>0) {
				HtmlDataTable dataTable = userReqIPBean.getIpResultDataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				if (endRow==0) endRow = dataTable.getRowCount();
				int rowSize = dataTable.getRowCount();
				int checkCount = 0;
				for (int i=startRow ; i<endRow ; i++) {
					if (i == rowSize) break;
					dataTable.setRowIndex(i);
					IpUrIpResult ipResult = (IpUrIpResult) dataTable.getRowData();
					if (ipResult.isRowCheck()) {
						checkCount++;
	    				removeList.add(ipResult);
	    			}
				}
				if (checkCount==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0032")));
				}else{
					for (IpUrIpResult ipResult : removeList) {
						userReqIPBean.getIpUrIpResultList().remove(ipResult);
					}
				}
			}
//    		IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0032")));
    		setUserReqIPBean(userReqIPBean);
	    }catch (Exception e) {
	    	e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	    return null;
	}
	
	public void prepareAssignment(UserReqIPBean userReqIPBean , IpUrIpResult ipUrIpResult){
		if (userReqIPBean.getCompanyComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getCompanyComboItem().getValue(),"").trim().length()>0) {
			ipUrIpResult.setCompanyId(userReqIPBean.getCompanyComboItem().getValue());
			ipUrIpResult.setCompanyName(userReqIPBean.getCompanyComboItem().getLabel());
		}
		if (userReqIPBean.getLocationComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getLocationComboItem().getValue(),"").trim().length()>0) {
			ipUrIpResult.setLocationId(userReqIPBean.getLocationComboItem().getValue());
			ipUrIpResult.setLocationName(userReqIPBean.getLocationComboItem().getLabel());
		}
		if (userReqIPBean.getIpTypeComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getIpTypeComboItem().getValue(),"").trim().length()>0) {
			ipUrIpResult.setIpTypeId(userReqIPBean.getIpTypeComboItem().getValue());
			ipUrIpResult.setIpTypeName(userReqIPBean.getIpTypeComboItem().getLabel());
		}
		if (userReqIPBean.getNwTypeComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getNwTypeComboItem().getValue(),"").trim().length()>0) {
			ipUrIpResult.setNetworkTypeId(userReqIPBean.getNwTypeComboItem().getValue());
			ipUrIpResult.setNetworkTypeName(userReqIPBean.getNwTypeComboItem().getLabel());
		}
		if (userReqIPBean.getNwZoneComboItem()!=null && IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getValue(),"").trim().length()>0) {
			ipUrIpResult.setNetworkZoneId(userReqIPBean.getNwZoneComboItem().getValue());
			ipUrIpResult.setNetworkZoneName(userReqIPBean.getNwZoneComboItem().getLabel());
		}
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getInstallTypeId(), "").trim().length()>0) {
			if (userReqIPBean.getIpUrIpResult().getInstallTypeId().equalsIgnoreCase("1")) {
				ipUrIpResult.setInstallTypeId(userReqIPBean.getIpUrIpResult().getInstallTypeId());
				ipUrIpResult.setInstallTypeName("Temporary");
			}else if (userReqIPBean.getIpUrIpResult().getInstallTypeId().equalsIgnoreCase("2")) {
				ipUrIpResult.setInstallTypeId(userReqIPBean.getIpUrIpResult().getInstallTypeId());
				ipUrIpResult.setInstallTypeName("Permanent");
			}
		}else{
			ipUrIpResult.setInstallTypeId("");
			ipUrIpResult.setInstallTypeName("");
		}
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getVip(), "").trim().length()>0) {
			ipUrIpResult.setVip(userReqIPBean.getIpUrIpResult().getVip());
		}
		
		if (IPFMUtils.ifBlank(userReqIPBean.getIpUrIpResult().getVlanId(), "").trim().length()>0) {
			ipUrIpResult.setVlanId(userReqIPBean.getIpUrIpResult().getVlanId());
		}
		ipUrIpResult.setDnsName(userReqIPBean.getIpUrIpResult().getDnsName());
		ipUrIpResult.setNetworkIp(userReqIPBean.getIpUrIpResult().getNetworkIp());
		ipUrIpResult.setGateway(userReqIPBean.getIpUrIpResult().getGateway());
		ipUrIpResult.setRemarks(userReqIPBean.getIpUrIpResult().getRemarks());
		ipUrIpResult.setSystemName(userReqIPBean.getIpUrIpResult().getSystemName());
	}
	
	public IpLevel2 newIpLevel2(IpUrIpDetail ipUrIpDetail,IpUrIpResult ipResult) throws IPFMBusinessException{
		UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
		
		IpLevel2 ipLevel2 = new IpLevel2();
		ipLevel2.setLevel1Id(ipResult.getLevel1Id());
		ipLevel2.setLevel2Id(userReqIPService.getLevel2_ID());
		ipLevel2.setLevel2Start(ipResult.getLevel2Start());
		ipLevel2.setLevel2End(ipResult.getLevel2End());
		ipLevel2.setBinary2Start(ipResult.getBinary2Start());
		ipLevel2.setBinary2End(ipResult.getBinary2End());
		ipLevel2.setEffectiveDate(ipResult.getEffectiveDate());
		ipLevel2.setExpiredDate(ipResult.getExpireDate());
		ipLevel2.setSystemName(ipResult.getSystemName());
		
		return ipLevel2;
	}
	
	public IpLevel2 prepareIpLevel2(IpUrIpDetail ipUrIpDetail,IpUrIpResult ipResult, IpLevel2 ipLevel2) throws IPFMBusinessException{
		UserSession userSession = IPFMWebUtil.getUserSession();
		ipLevel2.setIpStatus("A");
		ipLevel2.setLevel1Id(ipResult.getLevel1Id());
		ipLevel2.setIpSubmask(ipResult.getVipSubmask());
		ipLevel2.setCompanyId(ipResult.getCompanyId());
		ipLevel2.setCompanyName(ipResult.getCompanyName());
		ipLevel2.setVip(ipResult.getVip());
		ipLevel2.setT1TeamId(ipResult.getVt1TeamId());
		ipLevel2.setT1TeamName(ipResult.getVt1TeamName());
		ipLevel2.setT1Remark(ipResult.getVt1Remarks());
		ipLevel2.setT2TeamId(ipUrIpDetail.getT2TeamId());
		ipLevel2.setT2TeamName(ipUrIpDetail.getT2TeamName());
		ipLevel2.setTotalIp(new BigDecimal(ipResult.getTotalIp()));
		ipLevel2.setDnsName(ipResult.getDnsName());
		ipLevel2.setGateway(ipResult.getGateway());
		ipLevel2.setInstallTypeId(ipResult.getInstallTypeId());
		ipLevel2.setInstallTypeName(ipResult.getInstallTypeName());
		ipLevel2.setIpTypeId(ipResult.getIpTypeId());
		ipLevel2.setIpTypeName(ipResult.getIpTypeName());
		ipLevel2.setIpVersion(ipResult.getIpVersion());
		ipLevel2.setLocationId(ipUrIpDetail.getLocationId());
		ipLevel2.setLocationName(ipUrIpDetail.getLocationName());
		ipLevel2.setNetworkIp(ipResult.getNetworkIp());
		ipLevel2.setNetworkTypeId(ipResult.getNetworkTypeId());
		ipLevel2.setNetworkTypeName(ipResult.getNetworkTypeName());
		ipLevel2.setNetworkZoneId(ipResult.getNetworkZoneId());
		ipLevel2.setNetworkZoneName(ipResult.getNetworkZoneName());
		ipLevel2.setSubmask(ipResult.getMask());
		ipLevel2.setVlanId(ipResult.getVlanId());
		ipLevel2.setT2Remark(ipResult.getRemarks());
		ipLevel2.setTotalIp(new BigDecimal(ipResult.getTotalIp()));
		ipLevel2.setAvailableIp(new BigDecimal(0));
		ipLevel2.setAssignIp(new BigDecimal(ipResult.getTotalIp()));
		ipLevel2.setReserveIp(new BigDecimal(0));
		ipLevel2.setUseIp(new BigDecimal(0));
		ipLevel2.setTerminateIp(new BigDecimal(0));
		ipLevel2.setCreatedBy(userSession.getIpUser().getUserId());
		ipLevel2.setLastUpdBy(userSession.getIpUser().getUserId());
		return ipLevel2;
	}
	
	private IpInfo newIpInfo(IpUrIpDetail ipUrIpDetail, IpUrIpResult result, String ipAddress) {
		IpInfo bean = new IpInfo();
		bean.setIpVersion(result.getIpVersion());
		bean.setIpAddress(ipAddress);
		//System.out.println("---- getIpAddress = "+bean.getIpAddress());
		String[] ip = ipAddress.split("\\.");
		if (bean.getIpVersion()!=null && bean.getIpVersion().equalsIgnoreCase("4")) {
			bean.setIpv4digit1(new BigDecimal(ip[0])); bean.setIpv4digit2(new BigDecimal(ip[1]));
			bean.setIpv4digit3(new BigDecimal(ip[2])); bean.setIpv4digit4(new BigDecimal(ip[3]));
			String ipDeigit1Binary=""; String ipDeigit2Binary="";
			String ipDeigit3Binary=""; String ipDeigit4Binary="";
			
			try {
				ipDeigit1Binary = IPFMDataUtility.convertStringToBinary(ip[0]);
				ipDeigit2Binary = IPFMDataUtility.convertStringToBinary(ip[1]);
				ipDeigit3Binary = IPFMDataUtility.convertStringToBinary(ip[2]);
				ipDeigit4Binary = IPFMDataUtility.convertStringToBinary(ip[3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bean.setBinaryIp(ipDeigit1Binary+ipDeigit2Binary+ipDeigit3Binary+ipDeigit4Binary);
		//	System.out.println("---- setBinaryIp = "+bean.getBinaryIp());
		}else if (bean.getIpVersion()!=null && bean.getIpVersion().equalsIgnoreCase("6")) {
			bean.setIpv6digit1(new BigDecimal(ip[0])); bean.setIpv6digit2(new BigDecimal(ip[1]));
			bean.setIpv6digit3(new BigDecimal(ip[2])); bean.setIpv6digit4(new BigDecimal(ip[3]));
			bean.setIpv6digit5(new BigDecimal(ip[4])); bean.setIpv6digit6(new BigDecimal(ip[5]));
			String ipDeigit1Binary=""; String ipDeigit2Binary="";
			String ipDeigit3Binary=""; String ipDeigit4Binary="";
			String ipDeigit5Binary=""; String ipDeigit6Binary="";
			try {
				ipDeigit1Binary = IPFMDataUtility.convertStringToBinary(ip[0]);
				ipDeigit2Binary = IPFMDataUtility.convertStringToBinary(ip[1]);
				ipDeigit3Binary = IPFMDataUtility.convertStringToBinary(ip[2]);
				ipDeigit4Binary = IPFMDataUtility.convertStringToBinary(ip[3]);
				ipDeigit5Binary = IPFMDataUtility.convertStringToBinary(ip[4]);
				ipDeigit6Binary = IPFMDataUtility.convertStringToBinary(ip[5]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bean.setBinaryIp(ipDeigit1Binary+ipDeigit2Binary+ipDeigit3Binary+ipDeigit4Binary+ipDeigit5Binary+ipDeigit6Binary);
		}
		bean.setEffectiveDate(result.getEffectiveDate());
		bean.setSystemName(result.getSystemName());
		bean.setExpiredDate(result.getExpireDate());		
		return bean;
	}
	
	private IpInfo prepareIpInfo(IpUrIpDetail ipUrIpDetail, IpUrIpResult result, IpLevel2 ipLevel2, IpInfo bean, String ipAddress) {
		UserSession userSession = IPFMWebUtil.getUserSession();
		bean.setIpStatus("A");
		bean.setLevel1Id(ipLevel2.getLevel1Id());
		bean.setLevel2Id(ipLevel2.getLevel2Id());
		bean.setCompanyId(result.getCompanyId());
		bean.setCompanyName(result.getCompanyName());
		bean.setDnsName(result.getDnsName());
		bean.setGateway(result.getGateway());
		bean.setInstallTypeId(result.getInstallTypeId());
		bean.setInstallTypeName(result.getInstallTypeName());
		bean.setIpSubmask(result.getVipSubmask());
//		bean.setMacAddress("");
		bean.setSystemName(result.getSystemName());
		bean.setIpTypeId(result.getIpTypeId());
		bean.setIpTypeName(result.getIpTypeName());
		bean.setLocationId(result.getLocationId());
		bean.setLocationName(result.getLocationName());
		bean.setNetworkIp(result.getNetworkIp());
		bean.setNetworkTypeId(result.getNetworkTypeId());
		bean.setNetworkTypeName(result.getNetworkTypeName());
		bean.setNetworkZoneId(result.getNetworkZoneId());
		bean.setNetworkZoneName(result.getNetworkZoneName());
		bean.setProjectId(ipUrIpDetail.getProjId());
		bean.setProjectName(ipUrIpDetail.getProjName());
		bean.setProjectManager(ipUrIpDetail.getProjManagerName());		
		bean.setT1TeamId(result.getVt1TeamId());
		bean.setT1TeamName(result.getVt1TeamName());
		bean.setT1Remark(result.getVt1Remarks());		
		bean.setT2TeamId(ipUrIpDetail.getT2TeamId());
		bean.setT2Remark(result.getRemarks());
		bean.setT2TeamName(ipUrIpDetail.getT2TeamName());
		bean.setSubmask(result.getMask());
		bean.setSystemOwner(ipUrIpDetail.getSysOwnerId());
		bean.setSystemOwnerName(ipUrIpDetail.getSysOwnerName());
		bean.setSystemOwnerTeamId(ipUrIpDetail.getSysOwnerTeamId());
		bean.setSystemOwnerTeamName(ipUrIpDetail.getSysOwnerTeamName());
		bean.setUrRefer(ipUrIpDetail.getUrNo());
		bean.setVip(result.getVip());
		bean.setVlanId(result.getVlanId());
		bean.setCreatedBy(userSession.getIpUser().getUserId());
		bean.setLastUpdBy(userSession.getIpUser().getUserId());
		return bean;
	}
	
	public String assignIP() throws IPFMBusinessException{
		try {
			userReqIPBean = getUserReqIPBean();
			UserSession userSession = IPFMWebUtil.getUserSession();
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			ManagementIpService managementIpService = (ManagementIpService)JSFServiceFinderUtil.getInstance().getBean("managementIpService");
			validateAssignInfo();
			if (IPFMMessageUtils.hasMessages()) return null;
			if (userReqIPBean.getIpUrIpResultList().size()==0) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0084")));
				return null;
			}
			
			List<IpLevel2> list = new ArrayList<IpLevel2>();
			int maxSearchResult = getIPFMConfig().getMaxSearchResult();
			
	        
			List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
			int rowIndex = 0;
			boolean flag=true;
			List<ExcelErrorMsg> errorlist = new ArrayList<ExcelErrorMsg>();
			String  expireDateDefault =null;
			String  userRqExpireDate=null;
			for(IpUrIpResult ipResult : userReqIPBean.getIpUrIpResultList()){
					prepareAssignment(userReqIPBean, ipResult);
					ipResult.setCreatedBy(userSession.getIpUser().getUserId());
					ipResult.setLastUpdBy(userSession.getIpUser().getUserId());
					IpLevel2 ipLevel2;
					if (IPFMUtils.ifBlank(ipResult.getLevel2Id(), "").length()>0){
						ipLevel2 = userReqIPService.findIpLevel2ByLevel2Id(ipResult.getLevel2Id());
					}else{
						ipLevel2 = newIpLevel2(userReqIPBean.getIpUrIpDetail(), ipResult);
						prepareIpLevel2(userReqIPBean.getIpUrIpDetail(), ipResult, ipLevel2);
					}
					
					for(IpInfo ipInfo : ipResult.getIpInfoList()){
					       try {
								String[] ip = ipInfo.getIpAddress().split("\\.");
								list = managementIpService.searchIpManagementLevel2(ipInfo.getIpVersion(),ip[0],ip[1],ip[2],ip[3]
									       , ipResult.getMask(),maxSearchResult);
							
								Date expiredDate = null;
						        for(IpLevel2 ipLevel2Obj:list){
						            if(ipLevel2Obj.getLevel2Id().equals("0")){
						            	expiredDate = ipLevel2Obj.getExpiredDate();
						            	break;
						            } 
						        }
					    	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								  expireDateDefault =  IPFMUtils.cnvDateToString(expiredDate, "dd/MM/yyyy");
								  userRqExpireDate =  IPFMUtils.cnvDateToString(ipInfo.getExpiredDate(), "dd/MM/yyyy");
								Date d1 = df.parse(expireDateDefault);
								Date d2 = df.parse(userRqExpireDate);
									if(d1.equals(d2)|| d1.before(d2)){
										ExcelErrorMsg excelMsg = new ExcelErrorMsg();
										excelMsg.setRowNo(String.valueOf(rowIndex+1));	
										addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0208"),expireDateDefault));
										errorlist.add(excelMsg);
										flag=false;
									}else{
								        ipInfo = prepareIpInfo(userReqIPBean.getIpUrIpDetail(), ipResult, ipLevel2, ipInfo, ipInfo.getIpAddress());
									}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
					}					
					ipLevel2List.add(ipLevel2);
					ipResult.setIpLevel2(ipLevel2);
					rowIndex++;
			}
			userReqIPBean.setExpireDateDefault(expireDateDefault);
			userReqIPBean.setErrorMsgList(errorlist);
			setUserReqIPBean(userReqIPBean);
			if(flag){
				userReqIPBean.setIpLevel2List(ipLevel2List);
				List<IpUrIpResult> resultList = new ArrayList<IpUrIpResult>();
				resultList.addAll(userReqIPBean.getIpUrIpResultList());
				userReqIPBean.getIpUrIpDetail().setUrStatus(IPFMConstant.STATUS_CLOSE);
				userReqIPBean.getIpUrIpDetail().setUrStatusName(userReqIPService.getUrStatusDesc(userReqIPBean.getIpUrIpDetail().getUrType(), userReqIPBean.getIpUrIpDetail().getUrStatus()));
				userReqIPBean.getIpUrIpDetail().setLastUpdBy(userSession.getIpUser().getUserId());
				userReqIPBean.getIpUrIpDetail().setLastUpd(null);
			    userReqIPService.assignIP((IpUrIpDetail)userReqIPBean.getIpUrIpDetail().clone(),resultList, IPFMConstant.ACTION_ASSIGN, userSession.getIpUser().getUserId());
			    sendEmail(userReqIPBean, userReqIPBean.getIpUrIpDetail().getUrType(), IPFMConstant.URTYPENAME_USER_REQ_IP, userReqIPBean.getIpUrIpDetail().getUrStatus(), userReqIPBean.getIpUrIpDetail().getUrStatusName(), userReqIPBean.getAssignResultIP(), "N3" ,EMailService.TEMPLATE_IPFM_ASSIGNIP,"Request IP Assign Complete","Request IP Assign Complete");
			    setUserReqIPBean(userReqIPBean);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				IPFMWebUtil.storeOnSession("HOME", true);
			}
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		return null;
	}

	private boolean validateAssignInfo() {
		boolean flgValid = true;	
		userReqIPBean = getUserReqIPBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		
		if(IPFMUtils.ifBlank(userReqIPBean.getCompanyComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(userReqIPBean.getCompanyComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
			}
		}else{
			checkCompanyCombo();
		}
		if(IPFMUtils.ifBlank(userReqIPBean.getIpTypeComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(userReqIPBean.getIpTypeComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Type"));
			}
		}else{
			checkIpTypeCombo();
		}
		checkLocationCombo();
		checkNwTypeCombo();
		checkNwZoneCombo();
		
//		if(userReqIPBean.getNwTypeComboItem()==null || IPFMUtils.ifBlank(userReqIPBean.getNwTypeComboItem().getValue(),"").trim().length()==0){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Type"));
//		}
//		if(userReqIPBean.getNwZoneComboItem()==null || IPFMUtils.ifBlank(userReqIPBean.getNwZoneComboItem().getValue(),"").trim().length()==0){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network zone"));
//		}
		if (userReqIPBean.getIpUrIpResult().getNetworkIp()!=null && userReqIPBean.getIpUrIpResult().getNetworkIp().trim().length()>0) {
			if (!IPFMDataValidateUtil.validateIPFormat(userReqIPBean.getIpUrIpResult().getNetworkIp())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Network IP"));
			}
		}
		if (userReqIPBean.getIpUrIpResult().getGateway()!=null && userReqIPBean.getIpUrIpResult().getGateway().trim().length()>0) {
			if (!IPFMDataValidateUtil.validateIPFormat(userReqIPBean.getIpUrIpResult().getGateway())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Gateway"));
			}
		}
		if("".equals(userReqIPBean.getIpUrIpResult().getEffectiveDate())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Effective Date"));
		}
		if("".equals(userReqIPBean.getIpUrIpResult().getExpireDate())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
		}
		if (!"".equals(userReqIPBean.getIpUrIpResult().getEffectiveDate()) && !"".equals(userReqIPBean.getIpUrIpResult().getEffectiveDate())) {
			if(userReqIPBean.getIpUrIpResult().getEffectiveDate().after(userReqIPBean.getIpUrIpResult().getExpireDate()) ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
			}
		}
/*		if(userReqIPBean.getIpUrIpResult().getExpireDate().equals(userSession.getUserReqExpireDate()) 
				  || userReqIPBean.getIpUrIpResult().getExpireDate().before(userSession.getUserReqExpireDate())){
					try {
						String userReqExpireDate = IPFMUtils.cnvDateToString(userSession.getUserReqExpireDate(), "DD/MM/YYYY");
					    IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0208"), userReqExpireDate));
					} catch (Exception e) {
						e.printStackTrace();
					}
		}*/
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	public void addErrorMsg(ExcelErrorMsg excelMsg, String errorMsg){		
		if (excelMsg.getErrorMsg()==null || excelMsg.getErrorMsg().trim().length()==0) {
			excelMsg.setErrorMsg(errorMsg);
		}else{
			excelMsg.setErrorMsg(excelMsg.getErrorMsg() + "<br>" + errorMsg);
		}
	}
	@SuppressWarnings("unchecked")
	public String importExcel(UploadEvent event) {
		userReqIPBean= getUserReqIPBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		UploadItem item = null;
		List<ExcelErrorMsg> errorlist = new ArrayList<ExcelErrorMsg>();
		try{
			item = event.getUploadItem();
			Workbook w = Workbook.getWorkbook(item.getFile());
			String[] sheetName = w.getSheetNames();
			boolean flagSheetName=false;
			for (int i=0 ; i<sheetName.length ; i++) {
				if (sheetName[i].trim().toUpperCase().equalsIgnoreCase(getIPFMConfig().getAssingIpUserRequestIP().toUpperCase())) {
					flagSheetName = true;
					break;
				}
			}
			if (!flagSheetName) {
				ExcelErrorMsg excelMsg = new ExcelErrorMsg();
				excelMsg.setRowNo("");	
				addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0070"),getIPFMConfig().getAssingIpUserRequestIP()));
				errorlist.add(excelMsg);
				userReqIPBean.setErrorMsgList(errorlist);
				setUserReqIPBean(userReqIPBean);
				return null;
			}
		 }catch (Exception e) {
			e.printStackTrace();
			ExcelErrorMsg excelMsg = new ExcelErrorMsg();
			excelMsg.setRowNo("");	
			addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0071")));
			errorlist.add(excelMsg);
			userReqIPBean.setErrorMsgList(errorlist);
			setUserReqIPBean(userReqIPBean);
			return null;
		 }
		try {
			
			ExcelService excelService = (ExcelService)JSFServiceFinderUtil.getInstance().getBean("excelService");
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			Map resultMap = excelService.userRequestIPImport(item.getFile(), ipfmConfigBean.getAssingIpUserRequestIP(), userReqIPBean.getIpUrIpDetail(),userReqIPBean.getIpUrIpResult(), userSession.getIpUser().getTeamId(), userSession.getIpUser().getUserId());
			List<IpUrIpResult> ipResultImportList = (List<IpUrIpResult>)resultMap.get("result");
			List<ExcelErrorMsg> errorList = (List<ExcelErrorMsg>)resultMap.get("errorMsg");
			if (errorList.size()>0) {
				System.out.println("Have Error = " + errorList.size());
				userReqIPBean.setErrorMsgList(errorList);
			}else{
				System.out.println("Import Success = " + ipResultImportList.size());
				userReqIPBean.setErrorMsgList(new ArrayList<ExcelErrorMsg>());
//				userReqIPBean.getIpUrIpResultList().addAll(ipResultImportList);				
				for (IpUrIpResult importResult : ipResultImportList) {
					userReqIPBean.getIpUrIpResultList().add(importResult);
				}
			}
			setUserReqIPBean(userReqIPBean);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		} finally {
            if (item != null && item.isTempFile() && item.getFile().isFile()) {
                item.getFile().delete();
            }
            item = null;
        }
		return null;
	} 
	
	public void checkViewFile() {
		try{	        
	        String path = getRequestParameter("path");
	        String fileName = getRequestParameter("fileName");
	        File file = new File(path,fileName);
	        if (!file.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	
	public void viewFile() {
		try{
			String path = getRequestParameter("path");
	        String fileName = getRequestParameter("fileName");
	        downloadFile(path, fileName);	        
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateUR23Assign();
	        File file = new File(path,fileName);
	        if (!file.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	
	public void downloadTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateUR23Assign();
	        downloadFile(path, fileName);	        
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	
	public void uploadComplete(){
		System.out.println("====== uploadComplete ======");
		userReqIPBean = getUserReqIPBean();
		UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
		List<IpUrAttachment> ipUrAttachmentList;
		try {
			ipUrAttachmentList = userReqIPService.getIpUrAttachmentList(userReqIPBean.getIpUrIpDetail().getUrNo(),userReqIPBean.getAttachType());
			if (userReqIPBean.getAttachType().equalsIgnoreCase(IPFMConstant.CATEGORY_NETWORK_DIAGRAM)) {
				userReqIPBean.setDiagramList(ipUrAttachmentList);
			}else if (userReqIPBean.getAttachType().equalsIgnoreCase(IPFMConstant.CATEGORY_APPLICATION_FLOW)) {
				userReqIPBean.setAppFlowList(ipUrAttachmentList);
			}
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void onChangeLocationType(){
		userReqIPBean = getUserReqIPBean();
		if (userReqIPBean.getIpUrIpDetail().getLocationType().equalsIgnoreCase("D")) {
			userReqIPBean.setOfficeUserComboItem(new IPFMRichComboItem());
		}else{
			userReqIPBean.setDataComboItem(new IPFMRichComboItem());
		}
		setUserReqIPBean(userReqIPBean);
		
	}
	
	public List<SelectItem> getProjectListSelecItem() throws Exception{
		ProjectService projectService = (ProjectService)JSFServiceFinderUtil.getInstance().getBean("projectService");
		List<SelectItem> projectListSelectItem = new ArrayList<SelectItem>();
		//System.out.println("---- getProjectListSelecItem ----");
		try {
			List<Project> projectList = projectService.getProjectList();
			IPFMRichComboItem cbitem;
			if(projectList!=null && projectList.size()>0){
				for (Project proj:projectList) {
					cbitem = new IPFMRichComboItem();
					cbitem.setLabel(proj.getProjectId());
					cbitem.setValue(proj.getProjectId());
					cbitem.setValue1(proj.getProjectManagerPin());
					cbitem.setValue2(proj.getProjectName());
					projectListSelectItem.add(new SelectItem(cbitem, cbitem.getValue()));
				}
			}
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
//			throw ipfme;
			return new ArrayList<SelectItem>(); 
		}catch (Exception e) {
			e.printStackTrace();
//			throw e;
			return new ArrayList<SelectItem>();
		}
		return projectListSelectItem;
	}
	
	public void onSelectManager(){
		UserReqIPBean bean = getUserReqIPBean();
		bean.getIpUrIpDetail().setProjManagerId(getRequestParameter("managerId"));
	}
	
	public String onChangeProject() throws IPFMBusinessException{
		UserReqIPBean bean = getUserReqIPBean();
		try{
			if (bean.getProjComboItem()!= null && IPFMUtils.ifBlank(bean.getProjComboItem().getLabel(),"").trim().length()>0) {
				bean.setProjNameDisable(true);
				bean.setProjManagerDisable(true);
				if (IPFMUtils.ifBlank(bean.getProjComboItem().getValue(),"").trim().length()==0) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0075"), bean.getProjComboItem().getLabel()));
					bean.getIpUrIpDetail().setProjName(null);
					bean.getIpUrIpDetail().setProjManagerId(null);
					bean.getIpUrIpDetail().setProjManagerName(null);
					bean.setProjManagerComboItem(new IPFMRichComboItem());
					return null;
				}
				bean.getIpUrIpDetail().setProjId(bean.getProjComboItem().getValue());
				bean.getIpUrIpDetail().setProjName(bean.getProjComboItem().getValue2());
				if (IPFMUtils.ifBlank(bean.getProjComboItem().getValue2(),"").trim().length()>0) {
					bean.getIpUrIpDetail().setProjName(bean.getProjComboItem().getValue2());					
				}else{
					bean.getIpUrIpDetail().setProjName(null);
				}
				if (IPFMUtils.ifBlank(bean.getProjComboItem().getValue1(),"").trim().length()==0) {
					bean.getIpUrIpDetail().setProjManagerId(null);
					bean.getIpUrIpDetail().setProjManagerName(null);
					bean.setProjManagerComboItem(new IPFMRichComboItem());
				}else{
					AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
					EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
					UserAccount authUser = authService.getAuthenUserConfig();
					List<EmployeeProfileOM> empList = ehrService.getEmployeeProfileByPIN(authUser, bean.getProjComboItem().getValue1());
					if (empList!=null && empList.size()>0) {
						EmployeeProfileOM profile = empList.get(0);
						String email = profile.getEMAIL();
						String projectManagerId = email.substring(0,email.indexOf("@"));
						IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
						IpUser ipUser = ipUserService.findIpUserById(projectManagerId);
						if (ipUser==null){
							bean.getIpUrIpDetail().setProjManagerId(null);
							bean.getIpUrIpDetail().setProjManagerName(null);
							bean.setProjManagerComboItem(new IPFMRichComboItem());
							return null;
						}
						bean.getIpUrIpDetail().setProjManagerId(projectManagerId);
						bean.getIpUrIpDetail().setProjManagerName((IPFMUtils.ifBlank(profile.getENGNAME(),"")+" "+IPFMUtils.ifBlank(profile.getENGSURNAME(),"")).trim());
						bean.setProjManagerComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getProjManagerId(), bean.getIpUrIpDetail().getProjManagerName()));
					}else{
						bean.getIpUrIpDetail().setProjManagerId(null);
						bean.getIpUrIpDetail().setProjManagerName(null);
						bean.setProjManagerComboItem(new IPFMRichComboItem());
					}
				}
			}else{
				bean.setProjNameDisable(false);
				bean.setProjManagerDisable(false);
				bean.getIpUrIpDetail().setProjId(null);
				bean.getIpUrIpDetail().setProjName(null);
				bean.getIpUrIpDetail().setProjManagerId(null);
				bean.getIpUrIpDetail().setProjManagerName(null);
				bean.setProjManagerComboItem(new IPFMRichComboItem());
			}
			setUserReqIPBean(bean);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		return null;
	}
	
//	public String onChangeProject() throws IPFMBusinessException{
//		UserReqIPBean bean = getUserReqIPBean();
//		//System.out.println("--- onChangeProject ---");
//		try{
//			if (bean.getProjComboItem()!= null && IPFMUtils.ifBlank(bean.getProjComboItem().getLabel(),"").trim().length()>0) {
//				bean.getIpUrIpDetail().setProjId(bean.getProjComboItem().getValue());
//				bean.getIpUrIpDetail().setProjName(bean.getProjComboItem().getValue2());
//				if (IPFMUtils.ifBlank(bean.getProjComboItem().getValue2(),"").trim().length()>0) {
//					bean.getIpUrIpDetail().setProjName(bean.getProjComboItem().getValue2());
//					bean.setProjNameDisable(true);
//				}else{
//					bean.getIpUrIpDetail().setProjName(null);
//					bean.setProjNameDisable(false);
//				}
//				if (IPFMUtils.ifBlank(bean.getProjComboItem().getValue1(),"").trim().length()==0) {
//					bean.setProjManagerDisable(false);
//					bean.setProjManagerComboItem(new IPFMRichComboItem());
//				}else{
//					EmployeeProfileService ehrService = (EmployeeProfileService)JSFServiceFinderUtil.getInstance().getBean("ehrService");
//					List<EmployeeProfile> empList = ehrService.getEmployeeProfilesByPIN(bean.getProjComboItem().getValue1());
//					if (empList!=null && empList.size()>0) {
//						EmployeeProfile profile = empList.get(0);
//						String email = profile.getEmail();
//						String projectManagerId = email.substring(0,email.indexOf("@"));
//						IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
//						IpUser ipUser = ipUserService.findIpUserById(projectManagerId);
//						if (ipUser==null){
//							bean.setProjManagerDisable(false);
//							bean.getIpUrIpDetail().setProjManagerId(null);
//							bean.getIpUrIpDetail().setProjManagerName(null);
//							bean.setProjManagerComboItem(new IPFMRichComboItem());
//							return null;
//						}
//						bean.setProjManagerDisable(true);
//						bean.getIpUrIpDetail().setProjManagerId(projectManagerId);
//						bean.getIpUrIpDetail().setProjManagerName(IPFMUtils.stringCapitalize2((IPFMUtils.ifBlank(profile.getENGName(),"")+" "+IPFMUtils.ifBlank(profile.getENGSurname(),""))).trim());
//						bean.setProjManagerComboItem(new IPFMRichComboItem(bean.getIpUrIpDetail().getProjManagerId(), bean.getIpUrIpDetail().getProjManagerName()));
//					}else{
//						bean.setProjManagerDisable(false);
//						bean.getIpUrIpDetail().setProjManagerId(null);
//						bean.getIpUrIpDetail().setProjManagerName(null);
//					}
//				}
//			}else{
//				bean.setProjNameDisable(false);
//				bean.setProjManagerDisable(false);
//				bean.getIpUrIpDetail().setProjId(null);
//				bean.getIpUrIpDetail().setProjName(null);
//				bean.getIpUrIpDetail().setProjManagerId(null);
//				bean.getIpUrIpDetail().setProjManagerName(null);
//				bean.setProjManagerComboItem(new IPFMRichComboItem());
//			}
//			setUserReqIPBean(bean);
//		}catch (IPFMBusinessException ipfme){
//			ipfme.printStackTrace();
//			IPFMMessageUtils.addMessageError(ipfme.getMessage());
//		}catch (Exception e) {
//			e.printStackTrace();
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
//		}
//		return null;
//	}
	
	private boolean validateIP(String ipVersion, String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4) {
		boolean flgValid = true;
		userReqIPBean = getUserReqIPBean();
		if(IPFMUtils.ifBlank(ipVersion,"").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}
		if(IPFMUtils.ifBlank(ipDigit1,"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipDigit2,"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipDigit3,"").trim().length()==0 
			|| IPFMUtils.ifBlank(ipDigit4,"").trim().length()==0 ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		}
		if (IPFMMessageUtils.hasMessages()) flgValid = false;
		return flgValid;
	}
	
	public void onCheckRowAssignIP(){
		userReqIPBean = getUserReqIPBean();
		SearchIP searchIP = userReqIPBean.getSearchIP();
		try{
			boolean rowCheck = getRequestParameter("rowCheck").equalsIgnoreCase("true")? true : false;
			int subnet = Integer.parseInt(getRequestParameter("subNet"));
			int index = searchIP.getIpMaskDisplay().getLength().intValue()*(subnet-1);
			if (searchIP.getVsubmask().equalsIgnoreCase("32")) {
				int rowIndex = Integer.parseInt(getRequestParameter("rowIndex"));
				IpInfo ipInfo = searchIP.getIpInfoList().get(rowIndex);
				ipInfo.setRowCheck(rowCheck);
			}else{
				for (int i=0; i<searchIP.getIpMaskDisplay().getLength() ; i++) {
					IpInfo ipInfo = searchIP.getIpInfoList().get(index);
					ipInfo.setRowCheck(rowCheck);
					index++;
				}
			}
			setUserReqIPBean(userReqIPBean);
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void assignSearchIP(){
		userReqIPBean = getUserReqIPBean();
		SearchIP searchIP = userReqIPBean.getSearchIP();
		try{
//			int subnet=0;
//			boolean rowCheck = false;
			for (int index=0 ; index<searchIP.getIpInfoList().size() ; index++) {
				IpInfo ipInfoSearch = searchIP.getIpInfoList().get(index);
				
//				if (!searchIP.getVsubmask().equalsIgnoreCase("32")) {
//					if (ipInfoSearch.isRowCheck() || (rowCheck && (subnet==ipInfoSearch.getSubNet().intValue()))) {
//						rowCheck = true;
//						ipInfoSearch.setRowCheck(rowCheck);
//						subnet = ipInfoSearch.getSubNet();
//					}else{
//						rowCheck = false;
//						subnet = 0;
//						index+=(searchIP.getIpMaskDisplay().getLength()-1);
//						continue;
//					}
//				}
				
				if (ipInfoSearch.isRowCheck()) {
					IpUrIpResult result = new IpUrIpResult();
					result.setIpVersion("4");					
					result.setIpAddress(ipInfoSearch.getIpAddress());
					result.setMask(ipInfoSearch.getSubmask());
					result.setVt2TeamId(userReqIPBean.getIpUrIpDetail().getT2TeamId());
					UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
					userReqIPService.checkIPRange23_2(result);
//					System.out.println("result = "+result.getResult());
				    if(IPFMConstant.RESULT_SUCCESS.equalsIgnoreCase(result.getResult())){
				    	IpUrIpResult  ipUrIpResult = (IpUrIpResult)result.clone();
			        	IpUrIpResultId id = new IpUrIpResultId(userReqIPBean.getIpUrIpDetail().getUrNo(),null);
			        	ipUrIpResult.setId(id);
			        	ipUrIpResult.setSystemName(userReqIPBean.getIpUrIpResult().getSystemName());
			        	ipUrIpResult.setEffectiveDate(userReqIPBean.getIpUrIpResult().getEffectiveDate());
			        	ipUrIpResult.setExpireDate(userReqIPBean.getIpUrIpResult().getExpireDate());
			        	
//			        	System.out.println("IP Address : " +result.getLevel2Start() + " - " + result.getLevel2End());
			        	List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
			        	String[] strIpStart = ipUrIpResult.getLevel2Start().split("\\.");
			        	if (strIpStart.length==4) {
				        	int ipDigit1 = Integer.parseInt(strIpStart[0]);
				        	int ipDigit2 = Integer.parseInt(strIpStart[1]);
				        	int ipDigit3 = Integer.parseInt(strIpStart[2]);
				        	int ipDigit4 = Integer.parseInt(strIpStart[3]);
							for (int i=0;i<result.getTotalIp();i++) {
								if (ipDigit4>255) { ipDigit4=0; ipDigit3++; }
								if (ipDigit3>255) { ipDigit3=0; ipDigit2++; }
								if (ipDigit2>256) { ipDigit2=0; ipDigit1++; }
								if (ipDigit1>255) break;							
								String ipAddress = String.valueOf(ipDigit1)+"."+String.valueOf(ipDigit2)+"."+String.valueOf(ipDigit3)+"."+String.valueOf(ipDigit4);
								IpInfo ipInfo = newIpInfo(userReqIPBean.getIpUrIpDetail(), ipUrIpResult, ipAddress);
								ipInfo.setIpStatus("A");
								ipInfoList.add(ipInfo);
								ipDigit4++;
							}
			        	}
//			        	System.out.println("ipInfoList.size() = " + ipInfoList.size());
			        	ipUrIpResult.setIpInfoList(ipInfoList);
			        	if (ipUrIpResult.getIpInfoList().size()==1) ipUrIpResult.setRowShowIpInfo(true);
			        	userReqIPBean.getIpUrIpResultList().add(ipUrIpResult);
				    }else{
				    	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(result.getResult()));
				    	break;
				    }
				}
			}
			setUserReqIPBean(userReqIPBean);
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void linkSearchIP(){		
		userReqIPBean = getUserReqIPBean();
		userReqIPBean.setSearchIP(new SearchIP());
		SearchIP searchIP = userReqIPBean.getSearchIP();
		try {
			searchIP.setIpAddress(getRequestParameter("ipAddress"));
			searchIP.setIpSubmask(getRequestParameter("ipSubmask"));
			searchIP.setIpv4digit1(getRequestParameter("ipDigit1"));
			searchIP.setIpv4digit2(getRequestParameter("ipDigit2"));
			searchIP.setIpv4digit3(getRequestParameter("ipDigit3"));
			searchIP.setIpv4digit4(getRequestParameter("ipDigit4"));
			
			userReqIPBean = searchIPForAssign(userReqIPBean);
			setUserReqIPBean(userReqIPBean); 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public UserReqIPBean searchIPForAssign(UserReqIPBean userReqIPBean){
		try {
			SearchIP searchIP = userReqIPBean.getSearchIP();
			String vDisplayMask = "";
			validateIP("4", searchIP.getIpv4digit1(), searchIP.getIpv4digit2(), searchIP.getIpv4digit3(), searchIP.getIpv4digit4());
			if (IPFMMessageUtils.hasMessages()) return null;
			int mask = 32;
			String vMask = "";
			if (searchIP.getIpSubmask().trim().length()>0) {
				mask = Integer.parseInt(searchIP.getIpSubmask());
				vMask = searchIP.getIpSubmask();
			} else {
				vMask = "32";
			}
			
			// Valid vMask
			if (mask>7 && mask<16) vDisplayMask = "16";
			else if (mask>15 && mask<24) vDisplayMask = "24";
			else if (mask>23 && mask<33) vDisplayMask = "32";
			else {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
				return null;
			}
			IpUrIpResult result = new IpUrIpResult();
			result.setIpVersion("4");
			searchIP.setIpAddress(searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+searchIP.getIpv4digit4());
			result.setIpAddress(searchIP.getIpAddress());
			result.setMask(searchIP.getIpSubmask());
			result.setVt2TeamId(userReqIPBean.getIpUrIpDetail().getT2TeamId());
			
			//CHECK RANGE IP
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
			userReqIPService.checkIPRange23_3(result);
//			System.out.println("result = "+result.getResult());
		    if(IPFMConstant.RESULT_SUCCESS.equalsIgnoreCase(result.getResult()) || result.getResult().contains("Error01")){
		    	IpUrIpResult  ipUrIpResult = (IpUrIpResult)result.clone();
	        	IpUrIpResultId id = new IpUrIpResultId(userReqIPBean.getIpUrIpDetail().getUrNo(),null);
	        	ipUrIpResult.setId(id);	
	        	
	        	//Get Range from Mask
	        //	IpMaskDisplay ipMaskDisplay = userReqIPService.findIpMaskDisplayByMask(result.getMask());
	        	IpMaskDisplay ipMaskDisplay = userReqIPService.findIpMaskDisplayByMask(vMask);
	        	searchIP.setIpMaskDisplay(ipMaskDisplay);
	        	searchIP.setVsubmask(vDisplayMask);
	        	List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
	        	if (vDisplayMask.equalsIgnoreCase("16") || vDisplayMask.equalsIgnoreCase("24")) {
	        		int subnet;
        			int runDigit = 0;
//        			List<IpInfo> checkBoxList = new ArrayList<IpInfo>();
	        		for (int i=1 ; i<=ipMaskDisplay.getSubnet() ; i++) {
	        			subnet = i;
	        			for (int j=0 ; j<ipMaskDisplay.getLength() ; j++) {
	        				String ipAddress=""; String networkIp="";
	        				if (ipMaskDisplay.getDigit().intValue()==1) {
//	        					ipAddress = runDigit+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+ipUrIpResult.getIpDigit4();
//	        					networkIp = runDigit+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+"0";
	        					ipAddress = runDigit+"."+"0"+"."+"0"+"."+"0";
	        					networkIp = runDigit+"."+"0"+"."+"0"+"."+"0";
	        				}else if (ipMaskDisplay.getDigit().intValue()==2){
//	        					ipAddress = ipUrIpResult.getIpDigit1()+"."+runDigit+"."+ipUrIpResult.getIpDigit3()+"."+ipUrIpResult.getIpDigit4();
//	        					networkIp = ipUrIpResult.getIpDigit1()+"."+runDigit+"."+ipUrIpResult.getIpDigit3()+"."+"0";
	        					ipAddress = ipUrIpResult.getIpDigit1()+"."+runDigit+"."+"0"+"."+"0";
	        					networkIp = ipUrIpResult.getIpDigit1()+"."+runDigit+"."+"0"+"."+"0";
	        				}else if (ipMaskDisplay.getDigit().intValue()==3){
//	        					ipAddress = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+runDigit+"."+ipUrIpResult.getIpDigit4();
//	        					networkIp = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+runDigit+"."+"0";
	        					ipAddress = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+runDigit+"."+"0";
	        					networkIp = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+runDigit+"."+"0";
	        				}else if (ipMaskDisplay.getDigit().intValue()==4){
	        					ipAddress = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+runDigit;
	        					networkIp = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+"0";
	        				}
	        				IpInfo ipInfo = newIpInfo(userReqIPBean.getIpUrIpDetail(), ipUrIpResult, ipAddress);
	        				ipInfo.setT2TeamId(userReqIPBean.getIpUrIpDetail().getT2TeamId());
	        				ipInfo.setNetworkIp(networkIp);
	        				ipInfo.setSubNet(subnet);
	        				ipInfo.setSubmask(vDisplayMask);
	        				ipInfo = userReqIPService.checkIPRange23SearchL1(ipInfo);
//	        				if (j==0) {
	        					ipInfo.setButtonCheck(true);
//	        					checkBoxList.add(ipInfo);	        				
//	        				}
	        				if(IPFMConstant.RESULT_SUCCESS.equalsIgnoreCase(ipInfo.getResult())){
//	        					if (ipInfo.getLevel1Id()==null || ipInfo.getLevel1Id().trim().length()==0) {
//	        						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0091")));
//	        						return null;
//	        					}
	        					BigDecimal notAvailable = userReqIPService.checkIpInfoAvailable(ipInfo);
	        					ipInfo.setAvailableIP(ipInfo.getTotalIP().intValue() - notAvailable.intValue());
	        					if (ipInfo.getAvailableIP().intValue()!=ipInfo.getTotalIP().intValue()) {
	        						ipInfo.setButtonCheck(false);
	        					}
//	        					if (ipInfo.getAvailableIP().intValue()==0) {
//		        					for (IpInfo checkBox : checkBoxList) {
//		        						if (checkBox.getSubNet().intValue()==ipInfo.getSubNet().intValue()) {
//		        							checkBox.setButtonDisable(true);
//		        							break;
//		        						}
//		        					}
//	        					}	        					
	        				}else{
	        					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ipInfo.getResult()));
	        					return null;
	        				}
	        				runDigit++;
	        				ipInfoList.add(ipInfo);
	        			}
	        		}
	        	}else if (vDisplayMask.equalsIgnoreCase("32")){
	        		int x = 0;
	        		int subnet;
	        		List<IpInfo> infoList = userReqIPService.searchIpInfo(ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3());
	        		
	        		
	        		for (int i=1 ; i<=ipMaskDisplay.getSubnet() ; i++) {
	        			subnet = i;
	        			for (int j=1 ; j<=ipMaskDisplay.getLength() ; j++) {
	        				String ipAddress = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+x;
	        				String networkIp = ipUrIpResult.getIpDigit1()+"."+ipUrIpResult.getIpDigit2()+"."+ipUrIpResult.getIpDigit3()+"."+"0";
	        				IpInfo ipInfo = newIpInfo(userReqIPBean.getIpUrIpDetail(), ipUrIpResult, ipAddress);
	        				ipInfo.setNetworkIp(networkIp);
	        				ipInfo.setSubNet(subnet);
	        				ipInfo.setSubmask(vDisplayMask);
	        				boolean foundIpInfo = false;
	        				for (IpInfo ipInfoData : infoList) {
	        					if (ipInfoData.getIpAddress().equalsIgnoreCase(ipInfo.getIpAddress())){
	        						ipInfo.setTotalIP(1);
			        				ipInfo.setAvailableIP(0);
			        				ipInfo.setIpStatus(ipInfoData.getIpStatus());
			        				ipInfo.setHostName(ipInfoData.getHostName());
			        				ipInfo.setT2Remark(ipInfoData.getT2Remark());
			        				ipInfo.setT2TeamId(ipInfoData.getT2TeamId());
			        				foundIpInfo = true;
			        				ipInfo.setButtonCheck(false);
			        				break;
	        					}
	        				}
	        				if (!foundIpInfo) {
	        					ipInfo.setTotalIP(1);
		        				ipInfo.setAvailableIP(1);
	        					ipInfo.setIpStatus("P");
		        				ipInfo.setHostName("");
		        				ipInfo.setT2Remark("");
		        				ipInfo.setButtonCheck(true);
	        				}
//	        				IpInfo ipInfoData = userReqIPService.checkStatusDataIpInfo(ipUrIpResult.getIpDigit1(),ipUrIpResult.getIpDigit2(),ipUrIpResult.getIpDigit3(),String.valueOf(x));
//	        				if (ipInfoData == null) {
//	        					ipInfo.setTotalIP(1);
//		        				ipInfo.setAvailableIP(1);
//	        					ipInfo.setIpStatus("A");
//		        				ipInfo.setHostName("");
//		        				ipInfo.setT2Remark("");
//	        				}else{
//	        					ipInfo.setTotalIP(1);
//		        				ipInfo.setAvailableIP(0);
//		        				ipInfo.setIpStatus(ipInfoData.getIpStatus());
//		        				ipInfo.setHostName(ipInfoData.getHostName());
//		        				ipInfo.setT2Remark(ipInfoData.getT2Remark());
//		        			}
//	        				ipInfo.setButtonCheck(true);
	        				ipInfoList.add(ipInfo);
	        				x++;
	        			}
	        		}
	        	}
			
			
			
	        	searchIP.setIpInfoList(ipInfoList);
	        	ArrayList<IpInfo> filterTeamOwnerIpInfoList = new ArrayList<IpInfo>();

//	        	String ipDigit1Bin =  getIpToBinary(searchIP.getIpv4digit1());
//	        	String ipDigit2Bin =  getIpToBinary(searchIP.getIpv4digit2());
//	        	String ipDigit3Bin =  getIpToBinary(searchIP.getIpv4digit3());
//	        	String ipDigit4Bin =  getIpToBinary(searchIP.getIpv4digit4());
//	        	String ipBinary =  ipDigit1Bin+ipDigit2Bin+ipDigit3Bin+ipDigit4Bin;
	        	
	        	//List<IpLevel1> listSearcIpLevel1 = userReqIPService.searchIpLevel1ByBinIpAndTeam(ipBinary, userReqIPBean.getIpUrIpDetail().getT2TeamId());
	        	
	        	List<IpLevel1> listSearcIpLevel1 = userReqIPService.searchIpLevel1ByBinIpAndTeam(searchIP.getIpv4digit1(), 
	        			searchIP.getIpv4digit2(), searchIP.getIpv4digit3(),
	        			searchIP.getIpv4digit4(), Integer.valueOf(vDisplayMask) 
	        			,userReqIPBean.getIpUrIpDetail().getT2TeamId());
	        	
	        	
	        	
		        	if(listSearcIpLevel1 != null && listSearcIpLevel1.size() > 0) {
		        		for(IpLevel1 ipLevel1 : listSearcIpLevel1) {
		        			if(ipLevel1 != null && ipLevel1.getTotalIp().intValue() > 1) {
				        		long decIpStart = Long.parseLong(ipLevel1.getBinary1Start(), 2);
				        		long decIpEnd = Long.parseLong(ipLevel1.getBinary1End(), 2);
				        		
				        		for(IpInfo ipInfo : ipInfoList) {
				        			String ip[] = ipInfo.getIpAddress().split("\\.");
			
				    	        	String ipDG1Bin =  getIpToBinary(ip[0]);
				    	        	String ipDG2Bin =  getIpToBinary(ip[1]);
				    	        	String ipDG3Bin =  getIpToBinary(ip[2]);
				    	        	String ipDG4Bin =  getIpToBinary(ip[3]);
				    	        	
				    	        	String binaryIp = ipDG1Bin+ipDG2Bin+ipDG3Bin+ipDG4Bin;
				    	        	
				    	        	long decIp = Long.parseLong(binaryIp, 2);
				    	        	
				    	        	if(decIp >= decIpStart && decIp <= decIpEnd) {
				    	        		filterTeamOwnerIpInfoList.add(ipInfo);
				    	        	}
				        		}

		        			}
		        		}
			        	
		        	}
		        	
		        	List<IpLevel1> listSearcIpLevel12 = userReqIPService.searchIpLevel1ByBinIpAndTeam(searchIP.getIpv4digit1(), 
		        			searchIP.getIpv4digit2(), searchIP.getIpv4digit3(),
		        			searchIP.getIpv4digit4(), 32 
		        			,userReqIPBean.getIpUrIpDetail().getT2TeamId());
		        	
		        	
		        	
			        	if(listSearcIpLevel12 != null && listSearcIpLevel12.size() > 0) {
			        		for(IpLevel1 ipLevel1 : listSearcIpLevel12) {
			        			if(ipLevel1 != null && ipLevel1.getTotalIp().intValue() == 1) {
					        		long decIpStart = Long.parseLong(ipLevel1.getBinary1Start(), 2);
					        		long decIpEnd = Long.parseLong(ipLevel1.getBinary1End(), 2);
					        		
					        		for(IpInfo ipInfo : ipInfoList) {
					        			String ip[] = ipInfo.getIpAddress().split("\\.");
				
					    	        	String ipDG1Bin =  getIpToBinary(ip[0]);
					    	        	String ipDG2Bin =  getIpToBinary(ip[1]);
					    	        	String ipDG3Bin =  getIpToBinary(ip[2]);
					    	        	String ipDG4Bin =  getIpToBinary(ip[3]);
					    	        	
					    	        	String binaryIp = ipDG1Bin+ipDG2Bin+ipDG3Bin+ipDG4Bin;
					    	        	
					    	        	long decIp = Long.parseLong(binaryIp, 2);
					    	        	
					    	        	if(decIp == decIpStart && decIp == decIpEnd) {
					    	        		filterTeamOwnerIpInfoList.add(ipInfo);
					    	        	}
					        		}

			        			}
			        		}
				        	
			        	}		        	
		        	
/*		        	List<IpLevel1> listSearchIpL1 = userReqIPService.searchByIpWithMark(searchIP.getIpv4digit1(), 
		        			searchIP.getIpv4digit2(), searchIP.getIpv4digit3(), searchIP.getIpv4digit4(), 
		        			String.valueOf(vDisplayMask), userReqIPBean.getIpUrIpDetail().getT2TeamId());
		        	
	        		if(listSearchIpL1 != null && listSearchIpL1.size() >0) {
	        			for(IpLevel1 l1 : listSearchIpL1) {
			        		long decIpStart = Long.parseLong(l1.getBinary1Start(), 2);
			        		long decIpEnd = Long.parseLong(l1.getBinary1End(), 2);
			        		
	        				for(IpInfo ipInfo : ipInfoList) {
			        			String ip[] = ipInfo.getIpAddress().split("\\.");
			        			
			    	        	String ipDG1Bin =  getIpToBinary(ip[0]);
			    	        	String ipDG2Bin =  getIpToBinary(ip[1]);
			    	        	String ipDG3Bin =  getIpToBinary(ip[2]);
			    	        	String ipDG4Bin =  getIpToBinary(ip[3]);
			    	        	
			    	        	String binaryIp = ipDG1Bin+ipDG2Bin+ipDG3Bin+ipDG4Bin;
			    	        	
			    	        	long decIp = Long.parseLong(binaryIp, 2);
			    	        	
			    	        	if(decIp == decIpStart && decIp == decIpEnd) {
			    	        		filterTeamOwnerIpInfoList.add(ipInfo);
			    	        	}
	        				}
	        			}
	        			
	        		}
*/	        		
	        		if(filterTeamOwnerIpInfoList != null && filterTeamOwnerIpInfoList.size() > 0) {
	        		    BeanComparator actorComparator = new BeanComparator("binaryIp");
	        		    Collections.sort(filterTeamOwnerIpInfoList, actorComparator);

	        		}
		        	
	        		searchIP.setIpInfoList(filterTeamOwnerIpInfoList);
		        	
/*	        		if(ipLevel1Found != null && ipLevel1Found.getTotalIp().intValue() > 1) { 

		        		long decIpStart = Long.parseLong(ipLevel1Found.getBinary1Start(), 2);
		        		long decIpEnd = Long.parseLong(ipLevel1Found.getBinary1End(), 2);
		        		
		        		for(IpInfo ipInfo : ipInfoList) {
		        			String ip[] = ipInfo.getIpAddress().split("\\.");
	
		    	        	String ipDG1Bin =  getIpToBinary(ip[0]);
		    	        	String ipDG2Bin =  getIpToBinary(ip[1]);
		    	        	String ipDG3Bin =  getIpToBinary(ip[2]);
		    	        	String ipDG4Bin =  getIpToBinary(ip[3]);
		    	        	
		    	        	String binaryIp = ipDG1Bin+ipDG2Bin+ipDG3Bin+ipDG4Bin;
		    	        	
		    	        	long decIp = Long.parseLong(binaryIp, 2);
		    	        	
		    	        	if(decIp >= decIpStart && decIp <= decIpEnd) {
		    	        		filterTeamOwnerIpInfoList.add(ipInfo);
		    	        	}
		        		}
		        	}else{
		        		List<IpLevel1> listSearchIpL1 = userReqIPService.searchByIpWithMark(searchIP.getIpv4digit1(), searchIP.getIpv4digit2(), searchIP.getIpv4digit3(), searchIP.getIpv4digit4(), String.valueOf(mask), userReqIPBean.getIpUrIpDetail().getT2TeamId());
		        		
		        		if(listSearchIpL1 != null && listSearchIpL1.size() >0) {
		        			for(IpLevel1 l1 : listSearchIpL1) {
				        		long decIpStart = Long.parseLong(l1.getBinary1Start(), 2);
				        		long decIpEnd = Long.parseLong(l1.getBinary1End(), 2);
				        		
		        				for(IpInfo ipInfo : ipInfoList) {
				        			String ip[] = ipInfo.getIpAddress().split("\\.");
				        			
				    	        	String ipDG1Bin =  getIpToBinary(ip[0]);
				    	        	String ipDG2Bin =  getIpToBinary(ip[1]);
				    	        	String ipDG3Bin =  getIpToBinary(ip[2]);
				    	        	String ipDG4Bin =  getIpToBinary(ip[3]);
				    	        	
				    	        	String binaryIp = ipDG1Bin+ipDG2Bin+ipDG3Bin+ipDG4Bin;
				    	        	
				    	        	long decIp = Long.parseLong(binaryIp, 2);
				    	        	
				    	        	if(decIp == decIpStart && decIp == decIpEnd) {
				    	        		filterTeamOwnerIpInfoList.add(ipInfo);
				    	        	}
		        				}
		        			}
		        			
		        		}
		        		searchIP.setIpInfoList(filterTeamOwnerIpInfoList);
		        	}                  
	        	
	        */
	        	
	        	
	        	searchIP.setVsubmask(vDisplayMask);
	        	
	        	System.out.println("ipInfoList.size() = " + ipInfoList.size());
	        	System.out.println("filterTeamOwnerIpInfoList.size()ss = " + filterTeamOwnerIpInfoList.size());
		    }else{
		    	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(result.getResult()));
		    }
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
		return userReqIPBean;
	}
	
	public String getIpToBinary(String subIpInRang){
		String ipStr = "";
		ipStr = Integer.toBinaryString(Integer.parseInt(subIpInRang));
		for (int i = ipStr.length() ; i<8 ; i++){
			ipStr = "0"+ipStr;
		}
		return ipStr;
	}	
	
	public void searchIP(){
		//System.out.println("----searchIP----");
		userReqIPBean = getUserReqIPBean();
		userReqIPBean = searchIPForAssign(userReqIPBean);
		if (IPFMMessageUtils.hasMessages()) return;
	    setUserReqIPBean(userReqIPBean); 		
	}
	
	
	public void resetSearchIP(){
		//System.out.println("----resetSearchIP----");
		userReqIPBean = getUserReqIPBean();
		try {
			userReqIPBean.setSearchIP(new SearchIP());
		    setUserReqIPBean(userReqIPBean); 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void validateImportExcel(){
		userReqIPBean = getUserReqIPBean();
		try {
			validateAssignInfo();
			if (IPFMMessageUtils.hasMessages()) return;
		    setUserReqIPBean(userReqIPBean); 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void popupSearchIP(){
		userReqIPBean = getUserReqIPBean();
		try {
			validateAssignInfo();
			if (IPFMMessageUtils.hasMessages()) return;
			userReqIPBean.setSearchIP(new SearchIP());
			userReqIPBean.setSearchIPCheckAll(false);
		    setUserReqIPBean(userReqIPBean); 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void popupSearchIP1(){
		userReqIPBean = getUserReqIPBean();
		try {
			userReqIPBean.setSearchIP1(new SearchIP());
		    setUserReqIPBean(userReqIPBean); 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void popupHistory(){
		userReqIPBean = getUserReqIPBean();
		UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
	    String URNo = userReqIPBean.getIpUrIpDetail().getUrNo();
		try {
			List<IpUrActionHistory> historyList = userReqIPService.getHistoryList(URNo);
			//System.out.println("historyList size = " + historyList.size());
			userReqIPBean.setHistoryList(historyList);
		    List<IpUrAction>  urActionList  = userReqIPService.getURActionList(URNo);
		   System.out.println("urActionList size = " + urActionList.size());
		    userReqIPBean.setUrActionList(urActionList);
		    userReqIPBean.setIpUrAction(userReqIPService.getIpUrAction(URNo,"NA"));
			
		    setUserReqIPBean(userReqIPBean); 
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void popupAttachFile(){
		userReqIPBean = getUserReqIPBean();
		try {
			String attachType = getRequestParameter("attachType");
			//System.out.println(attachType);
			userReqIPBean.setAttachType(attachType);			
		    setUserReqIPBean(userReqIPBean); 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void sendEmail(UserReqIPBean bean,String urType,String urTypeName,String urStatus,String urStatusName,String assignResultIP,String nodeId,String template,String subjectDesc,String bodyDesc) throws Exception{	
		UserSession userSession = IPFMWebUtil.getUserSession();
		EMailService emailService = (EMailService)JSFServiceFinderUtil.getInstance().getBean("emailService");
		IpUrActionService actionService = (IpUrActionService)JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		String urNo = bean.getIpUrIpDetail().getUrNo();
		IPUserService userService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");		
		int length = 0;
		String[] id = {};
		List<IpUser> ipUserList = new ArrayList<IpUser>();		
		if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_ASSIGN)) {
			ipUserList = userService.getIpUserListByTeam(bean.getIpUrIpDetail().getT2TeamId());
			length = ipUserList.size();
		}else if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_MRG)){
			id = bean.getIpUrIpDetail().getApproveManagerId().split(",");
			length = id.length;
	    }else if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.STATUS_CLOSE)) {
	    	length = 1;
	    }
		for (int i=0 ; i<length ; i++) {
			String userId = "";
			if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_ASSIGN)) {
				userId = ((IpUser)ipUserList.get(i)).getUserId();
			}else if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.STATUS_WAIT_MRG)){
				userId = id[i];
			}else if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.STATUS_CLOSE)) {
				userId = bean.getIpUrIpDetail().getReqUserId();
		    }
			IpUser manager = userService.findIpUserById(userId);
//			String key = "IPFM"+urNo+":"+manager.getUserId();
			String key = emailService.getKeyCodeEmail();
			String[] to = {manager.getEmail()};
	        String[] cc = null;
	        String from = "ipfm@ais.co.th";
	       // System.out.println("urType = " +urType+ " :: nodeId = "+nodeId);
	        if(actionService.isSendEmail(urType, nodeId)){
		        try{
//		        	System.out.println("--------actionService.isSendEmail-------");
			        Map model = new HashMap();
			        model.put("subjectDesc", subjectDesc);
			        model.put("bodyDesc", bodyDesc);
			        model.put("managerName", manager.getUserName());
			        model.put("urNo", urNo);
			        model.put("urType", urTypeName);
			        model.put("urStatus", urStatusName);
			        model.put("subject", bean.getIpUrIpDetail().getSubject());
			        model.put("assignResultIP", assignResultIP);
			        model.put("requestBy", bean.getIpUrIpDetail().getReqName());
//			        model.put("requestBy", bean.getUserSession().getIpUser().getUserName());
			        SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
			        model.put("requestDate", smf.format(new Date()));
			        String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
			//        System.out.println("encodeUrl >>> "+encodeUrl);
			        model.put("url",getIPFMConfig().getHomeUrl()+"/home/view.jsf?key="+encodeUrl);
			        
			        emailService.sendMail(to, cc, from, template, model);
			        
			        IpEmailNotify notify = new IpEmailNotify();
			        notify.setUserId(manager.getUserId());
			        notify.setUrNo(urNo);
			        notify.setUrStatus(urStatus);
			        notify.setEmailLinkStatus("N");
			        notify.setEmailCode(key);
			        notify.setCreatedBy(userSession.getIpUser().getUserId());
			        notify.setLastUpdBy(userSession.getIpUser().getUserId());
			        actionService.saveEmailNotify(notify);
			        
		        } catch (Exception e) {
					System.out.println("Email can not send.");
				}
	        }
		}
	}
	
	public void checkReqTeamCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getReqTeamComboItem().getValue()==null) && userReqIPBean.getReqTeamComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Request from Planning Team"));
			}
	}
	public void checkProjCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getProjComboItem().getValue()==null) && userReqIPBean.getProjComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Project ID"));
			}
	}
	public void checkProjManagerCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getProjManagerComboItem().getValue()==null) && userReqIPBean.getProjManagerComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Project Manager"));
			}
	}
	public void checkSystemOwnerTeamCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getSystemOwnerTeamComboItem().getValue()==null) && userReqIPBean.getSystemOwnerTeamComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "System Owner Team"));
			}
	}
	public void checkSystemOwnerCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getSystemOwnerComboItem().getValue()==null) && userReqIPBean.getSystemOwnerComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "System Owner"));
			}
	}
	public void checkNwTypeCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getNwTypeComboItem().getValue()==null) && userReqIPBean.getNwTypeComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Type"));
			}
	}
	public void checkNwZoneCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getNwZoneComboItem().getValue()==null) && userReqIPBean.getNwZoneComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Zone"));
			}
	}
	public void checkDataCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getDataComboItem().getValue()==null) && userReqIPBean.getDataComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Site/Location"));
			}
	}
	public void checkOfficeUserCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getOfficeUserComboItem().getValue()==null) && userReqIPBean.getOfficeUserComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Site/Location"));
			}
	}
	public void checkCompanyCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getCompanyComboItem().getValue()==null) && userReqIPBean.getCompanyComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Company"));
			}
	}
	public void checkIpTypeCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getIpTypeComboItem().getValue()==null) && userReqIPBean.getIpTypeComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "IP Type"));
			}
	}
	public void checkLocationCombo(){
		userReqIPBean = getUserReqIPBean();
            if((userReqIPBean.getLocationComboItem().getValue()==null) && userReqIPBean.getLocationComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Site/Location"));
			}
	}
	
	
}
