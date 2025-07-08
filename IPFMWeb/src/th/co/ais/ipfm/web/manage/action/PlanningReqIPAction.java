package th.co.ais.ipfm.web.manage.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import jxl.Workbook;

import org.apache.commons.codec.binary.Base64;
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
import th.co.ais.ipfm.domain1.IpMaskDisplay;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrAttachmentId;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.IpUrIpResultId;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.SearchIP;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.poi.util.GXLSColumn;
import th.co.ais.ipfm.poi.util.GXLSUtil;
import th.co.ais.ipfm.service.ExcelService;
import th.co.ais.ipfm.service.IPTeamService;
import th.co.ais.ipfm.service.IPUserService;
import th.co.ais.ipfm.service.IpUrActionService;
import th.co.ais.ipfm.service.IpUrAttachmentService;
import th.co.ais.ipfm.service.PlanningReqIPService;
import th.co.ais.ipfm.service.UserReqIPService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.PlanningReqIPBean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;


public class PlanningReqIPAction  extends AbstractAction {
	
	public PlanningReqIPBean planningReqIPBean;
	public UserSession  userSession;

	public PlanningReqIPBean getPlanningReqIPBean() {
		return (PlanningReqIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("planningReqIPBean");
	}
	public void setPlanningReqIPBean(PlanningReqIPBean planningReqIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("planningReqIPBean", planningReqIPBean);
	}
	public UserSession getUserSession() {
	  return (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
	}
	public void setUserSession(UserSession userSession) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", userSession);
	}
	
	public AttachFileAction getFileAttachAction() {
		return (AttachFileAction) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("fileAttachAction");
	}
	public void setFileAttachAction(AttachFileAction fileAttachAction) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("fileAttachAction", fileAttachAction);
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		planningReqIPBean = getPlanningReqIPBean();		
		 if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			 planningReqIPBean.setSortIpsur002History(sortColumnChange());	
		}
		return "";
	}
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	@Override
	public String init(String programID) {
		PlanningReqIPBean bean = new PlanningReqIPBean();
		UserSession userSessionBean = getUserSession();
		IPFMRichComboItem systemOwner = new IPFMRichComboItem();
		IPFMRichComboItem systemOwnerTeam = new IPFMRichComboItem();
		IPFMRichComboItem networkType = new IPFMRichComboItem();
		IPFMRichComboItem networkZone = new IPFMRichComboItem();
		List<SelectItem> systemOwnerList = new ArrayList<SelectItem>();
		List<SelectItem> systemOwnerTeamList = new ArrayList<SelectItem>();
		List<SelectItem> netWorkTypeList = new ArrayList<SelectItem>();
		List<SelectItem> netWorkZoneList = new ArrayList<SelectItem>();
		String mode = getRequestParameter("MODE");
		String URNo = getRequestParameter("URNo");
		bean.setV_Mode(mode);
	    IPFMRichComboItem cbitem = null;
		
		try{
			PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");

			   //DropDown
				List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
				List<SelectItem> companyStringList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
				List<SelectItem> ipTypeStringList = IPFMComboBoxUtil.getInstance().getIPTypeListComboBoxItems();
				List<SelectItem> dataCenterStringList = IPFMComboBoxUtil.getInstance().getDataCenterComboBoxItems();
				   //SystemOwner DropDown	
//					List<IpUser> systemOwnerStringList = planningReqIPService.getSystemOwnerList();
//					if(systemOwnerStringList!=null && systemOwnerStringList.size()>0){
//							for (IpUser str:systemOwnerStringList) {
//								cbitem = new IPFMRichComboItem();
//								cbitem.setLabel(str.getUserName());
//								cbitem.setValue(str.getUserId());
//								systemOwnerList.add(new SelectItem(cbitem, cbitem.getLabel()));
//							}
//					}
				   //SystemOwnerTeam DropDown	
					List<IpTeam> systemOwnerTeamStringList = planningReqIPService.getSystemOwnerTeamList();
					if(systemOwnerTeamStringList!=null && systemOwnerTeamStringList.size()>0){
							for (IpTeam str:systemOwnerTeamStringList) {
								cbitem = new IPFMRichComboItem();
								cbitem.setLabel(str.getTeamName());
								cbitem.setValue(str.getTeamId());
								systemOwnerTeamList.add(new SelectItem(cbitem, cbitem.getLabel()));
							}
					}
					//NetworkType DropDown	
					List<IpMasterTable> nwTypeStringList = planningReqIPService.getMaster_activeStatus_List(IPFMConstant.MCODE_NWTYPE);
					if(nwTypeStringList!=null && nwTypeStringList.size()>0){
							for (IpMasterTable str:nwTypeStringList) {
								cbitem = new IPFMRichComboItem();
								cbitem.setLabel(str.getShortDesc());
								cbitem.setValue(str.getId().getRefKey());
								netWorkTypeList.add(new SelectItem(cbitem, cbitem.getLabel()));
							}
					}
					//NetworkZone DropDown	
					List<IpMasterTable> zoneStringList = planningReqIPService.getMaster_activeStatus_List(IPFMConstant.MCODE_ZONE);
					if(zoneStringList!=null && zoneStringList.size()>0){
							for (IpMasterTable str:zoneStringList) {
								cbitem = new IPFMRichComboItem();
								cbitem.setLabel(str.getShortDesc());
								cbitem.setValue(str.getId().getRefKey());
								netWorkZoneList.add(new SelectItem(cbitem, cbitem.getLabel()));
							}
					}	
					    bean.setLocationList(locatStringList);
					    bean.setNwZoneList(netWorkZoneList);
					    bean.setNwTypeList(netWorkTypeList);
					    bean.setCompanyList(companyStringList);
					    bean.setIpTypeList(ipTypeStringList);
					    bean.setDataList(dataCenterStringList);
					    bean.setSystemOwnerList(systemOwnerList); 
					    bean.setSystemOwnerTeamList(systemOwnerTeamList);
//					    bean.setNewSystemOwnerTeamList(systemOwnerTeamList);
					    
						systemOwner.setValue(userSessionBean.getIpUser().getUserId());
						systemOwner.setLabel(userSessionBean.getIpUser().getUserName());
						systemOwnerTeam.setValue(userSessionBean.getIpUser().getTeamId());
						systemOwnerTeam.setLabel(userSessionBean.getIpUser().getTeamName());
						bean.setSystemOwnerComboItem(systemOwner);
						bean.setSystemOwnerTeamComboItem(systemOwnerTeam);
						bean.getIpUrIpdetail().setSysOwnerId(userSessionBean.getIpUser().getUserId());
						bean.getIpUrIpdetail().setSysOwnerName(userSessionBean.getIpUser().getUserName());
						bean.getIpUrIpdetail().setSysOwnerTeamId(userSessionBean.getIpUser().getTeamId());
						bean.getIpUrIpdetail().setSysOwnerTeamName(userSessionBean.getIpUser().getTeamName());
						bean.setSysOwnerTeamId(userSessionBean.getIpUser().getTeamId());
						bean.getIpUrIpResult().setIpVersion("4");
				
						if(IPFMConstant.MODE_EDIT.equals(mode)){
				                IpUrAttachmentId id = new IpUrAttachmentId(URNo,null,null);
				                bean.getIpUrAttachment().setId(id);
				                
								IpUrIpDetail ipUrIpDetail = planningReqIPService.getIpUrIpDetail(URNo);
								
								systemOwner.setValue(ipUrIpDetail.getSysOwnerId());
								systemOwner.setLabel(ipUrIpDetail.getSysOwnerName());
								systemOwnerTeam.setValue(ipUrIpDetail.getSysOwnerTeamId());
								systemOwnerTeam.setLabel(ipUrIpDetail.getSysOwnerTeamName());
								networkType.setValue(ipUrIpDetail.getNetworkTypeId());
								networkType.setLabel(ipUrIpDetail.getNetworkTypeName());
								networkZone.setValue(ipUrIpDetail.getZoneId());
								networkZone.setLabel(ipUrIpDetail.getZoneName());
								bean.setSystemOwnerComboItem(systemOwner);
								bean.setSystemOwnerTeamComboItem(systemOwnerTeam);
								bean.setNwTypeComboItem(networkType);
								bean.setNwZoneComboItem(networkZone);
								bean.setSysOwnerTeamId(ipUrIpDetail.getSysOwnerTeamId());
								bean.setButtonDeleteVisible(true);  
								bean.getIpUrIpdetail().setUrNo(URNo);
								bean.setIpUrIpdetail(ipUrIpDetail);
								bean.setV_urNo(URNo);
								bean.setV_urStatusDesc(IPFMConstant.DRAFTUR);
						 }else if(IPFMConstant.MODE_ASSIGN_IP.equals(mode)){	
							    bean.getIpUrIpResult().setVip(IPFMConstant.NO);
								IpUrIpDetail ipUrIpDetail = planningReqIPService.getIpUrIpDetail(URNo);
								
								networkType.setValue(ipUrIpDetail.getNetworkTypeId());
								networkType.setLabel(ipUrIpDetail.getNetworkTypeName());
								networkZone.setValue(ipUrIpDetail.getZoneId());
								networkZone.setLabel(ipUrIpDetail.getZoneName());
								bean.setNwTypeComboItem(networkType);
								bean.setNwZoneComboItem(networkZone);
								
								bean.getIpUrIpResult().setEffectiveDate(userSessionBean.getPlanningEffectiveDate());
								bean.getIpUrIpResult().setExpireDate(userSessionBean.getPlanningExpireDate());
								bean.setSysOwnerTeamId(ipUrIpDetail.getSysOwnerTeamId());
								bean.setIpUrIpdetail(ipUrIpDetail); 
								List<IpUrAttachment>  ipUrAttachmentList = planningReqIPService.getIpUrAttachmentList(URNo);
								bean.setIpUrAttachmentList(ipUrAttachmentList);
						 }else if(IPFMConstant.MODE_VIEW.equals(mode)){							 
								IpUrIpDetail ipUrIpDetail = planningReqIPService.getIpUrIpDetail(URNo);
								bean.getIpUrIpdetail().setUrStatus(ipUrIpDetail.getUrStatus());
								if(ipUrIpDetail==null){
									IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0003")));
								}else{
									String urStatusDesc = planningReqIPService.getUrStatusDesc(IPFMConstant.URTYPE_PLANNING_REQ_IP,ipUrIpDetail);
									List<IpUrAttachment>  ipUrAttachmentList = planningReqIPService.getIpUrAttachmentList(URNo);
									List<IpUrIpResult>  ipUrIpResultList =  planningReqIPService.getIpUrIpResultList(URNo);
									bean.setSysOwnerTeamId(ipUrIpDetail.getSysOwnerTeamId());
									bean.setV_urStatusDesc(urStatusDesc);
									bean.setIpUrIpdetail(ipUrIpDetail);
									bean.setIpUrAttachmentList(ipUrAttachmentList);
									if (ipUrIpResultList !=null && ipUrIpResultList.size()>0) bean.setIpUrIpResult(ipUrIpResultList.get(0));
									else ipUrIpResultList = new ArrayList<IpUrIpResult>();
									if(IPFMConstant.STATUS_CLOSE.equals(ipUrIpDetail.getUrStatus())){
										bean.setAssignmentIPList(ipUrIpResultList);
									}
								}
						 }else{
							   //get tempNo
							    bean.setV_Mode(IPFMConstant.MODE_NEW);
							    String  tempUrno = planningReqIPService.getTempURNo();
							    bean.getIpUrIpdetail().setUrNo(tempUrno);
							    
								bean.getIpUrIpdetail().setReqType(IPFMConstant.NO);
								bean.setButtonDeleteVisible(false);  
						 }
				 List<IpUrAttachment>  diagramList	=	planningReqIPService.getIpUrAttachmentList(bean.getIpUrIpdetail().getUrNo());
				 AttachFileAction  attachFileAction = new AttachFileAction();
				 attachFileAction.setListAttach(diagramList);
				 setFileAttachAction(attachFileAction);
			     setPlanningReqIPBean(bean);
    
		   }catch (Exception e) {
			   e.printStackTrace();
		}
		return programID;
	}

	public void saveDraft(){
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		UserSession userSessionBean = getUserSession();
		String  tempUrNo = planningBean.getIpUrIpdetail().getUrNo();
		try {
				PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
				IpUrAttachmentService ipUrAttachmentService = (IpUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
				IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
				
			    IpUrIpDetail ipUrIPBean = planningBean.getIpUrIpdetail();
			    ipUrIPBean.setReqName(userSessionBean.getIpUser().getUserName());
			    ipUrIPBean.setReqUserId(userSessionBean.getIpUser().getUserId());
			    ipUrIPBean.setReqDept(userSessionBean.getIpUser().getDept());
			    ipUrIPBean.setReqEmail(userSessionBean.getIpUser().getEmail());
			    ipUrIPBean.setReqSection(userSessionBean.getIpUser().getSection());
			    ipUrIPBean.setReqMobile(userSessionBean.getIpUser().getMobile());
			    ipUrIPBean.setReqPosition(userSessionBean.getIpUser().getPosition());
			    ipUrIPBean.setReqTel(userSessionBean.getIpUser().getTel());
			    ipUrIPBean.setReqTeam(userSessionBean.getIpUser().getTeamId());
			    ipUrIPBean.setUrType(IPFMConstant.URTYPE_PLANNING_REQ_IP);
			    ipUrIPBean.setUrStatus(IPFMConstant.DRAFT);
	    	    ipUrIPBean.setUrStatusName(IPFMConstant.DRAFTUR);
	    	    if (IPFMUtils.ifBlank(ipUrIPBean.getCreatedBy(),"").length()==0) {
	    	    	ipUrIPBean.setCreatedBy(userSessionBean.getIpUser().getUserId());
				}
			    ipUrIPBean.setLastUpdBy(userSessionBean.getIpUser().getUserId());
			    
			    // get Value and Label NetworkType DropDown
				if(planningBean.getNwTypeComboItem()!=null ){
						ipUrIPBean.setNetworkTypeId(planningBean.getNwTypeComboItem().getValue());
						ipUrIPBean.setNetworkTypeName(planningBean.getNwTypeComboItem().getLabel());	
				}
				// get Value and Label NetworkZone DropDown
				if(planningBean.getNwZoneComboItem()!=null){
						ipUrIPBean.setZoneId(planningBean.getNwZoneComboItem().getValue());
						ipUrIPBean.setZoneName(planningBean.getNwZoneComboItem().getLabel());	
				}
				// get Value and Label SystemOwner DropDown
//				if(planningBean.getSystemOwnerComboItem()!=null){
//						ipUrIPBean.setSysOwnerId(planningBean.getSystemOwnerComboItem().getValue());
//						ipUrIPBean.setSysOwnerName(planningBean.getSystemOwnerComboItem().getLabel());	
//				}
				// get Value and Label SystemOwnerTeam DropDown
				if(planningBean.getSystemOwnerTeamComboItem()!=null){
						ipUrIPBean.setSysOwnerTeamId(planningBean.getSystemOwnerTeamComboItem().getValue());
						ipUrIPBean.setSysOwnerTeamName(planningBean.getSystemOwnerTeamComboItem().getLabel());	
				}
			    
				
				if(planningBean.getIpUrIpdetail().getSysOwnerId() == null || planningBean.getIpUrIpdetail().getSysOwnerId().equals("")) {
					//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), planningBean.getIpUrIpdetail().getSysOwnerName()));
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
				} else if (planningBean.getIpUrIpdetail().getSysOwnerName() == null || planningBean.getIpUrIpdetail().getSysOwnerName().equals("")) {
					//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), planningBean.getIpUrIpdetail().getSysOwnerName()));
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
				}
				
				if (IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSysOwnerId(),"").length()>0 
						&& IPFMUtils.ifBlank(planningBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0 ){
						IpUser sysUser = ipUserService.findIpUserById(planningBean.getIpUrIpdetail().getSysOwnerId());
						if (sysUser!=null) {
							if (!sysUser.getTeamId().equalsIgnoreCase(planningBean.getSystemOwnerTeamComboItem().getValue())) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
							}
						}else{
							if (!planningBean.getSystemOwnerTeamComboItem().getValue().equalsIgnoreCase(planningBean.getIpUrIpdetail().getSysOwnerTeamId())) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
							}
						}
					}
				if (IPFMMessageUtils.hasMessages()) return;			
				
				
				
				
				
					    if(IPFMConstant.MODE_EDIT.equals(planningBean.getV_Mode())){
					    	planningBean.getIpUrIpdetail().setLastUpd(null);
				    	    planningReqIPService.updateDraft(planningBean.getIpUrIpdetail());
							IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
							planningBean.setButtonDeleteVisible(true); 
					     }else{
				            IpUrAttachmentId id = new IpUrAttachmentId(planningBean.getIpUrIpdetail().getUrNo(),null,null);
				            planningBean.getIpUrAttachment().setId(id);
							//get URNo 
							String  urno = planningReqIPService.getURNo();
							planningBean.getIpUrIpdetail().setUrNo(urno);
							planningBean.getIpUrIpdetail().setReqDate(IPFMDataUtility.getCurrentDate());
							planningBean.getIpUrIpdetail().setOverSla("N");
							planningReqIPService.createDraft(ipUrIPBean, planningBean.getIpUrAttachment());
							ipUrAttachmentService.updateAttachFile(tempUrNo,urno,userSessionBean.getIpUser().getUserId());
							IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
							planningBean.setV_urNo(urno);
							planningBean.setV_urStatusDesc(IPFMConstant.DRAFTUR);
							planningBean.setV_Mode("EDIT");
							planningBean.setButtonDeleteVisible(true); 
					     }
				setPlanningReqIPBean(planningBean);
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
    public void  sendForAssign(){
		PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
		IpUrAttachmentService ipUrAttachmentService = (IpUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipUrAttachmentService");
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		UserSession userSessionBean = getUserSession();
		String  tempUrNo = planningBean.getIpUrIpdetail().getUrNo();
		try {
		 	validate();
		 	
			IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
			if (IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSysOwnerId(),"").length()>0 
				&& IPFMUtils.ifBlank(planningBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0 ){
				IPTeamService ipTeamService = (IPTeamService)JSFServiceFinderUtil.getInstance().getBean("ipTeamService");
				IpUser sysUser = ipUserService.findIpUserById(planningBean.getIpUrIpdetail().getSysOwnerId());
				if (sysUser!=null) {
					IpTeam ipTeam = ipTeamService.findIpTeamById(sysUser.getTeamId());
					if (ipTeam==null || (ipTeam!=null && !IPFMUtils.ifBlank(ipTeam.getTier2Team(),"").equalsIgnoreCase("Y"))){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0081")));
					}else{
						if (!sysUser.getTeamId().equalsIgnoreCase(planningBean.getSystemOwnerTeamComboItem().getValue())) {
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0082")));
						}
					}
				}else{
					if (!planningBean.getSystemOwnerTeamComboItem().getValue().equalsIgnoreCase(planningBean.getSysOwnerTeamId())) {
						IpTeam ipTeam = ipTeamService.findIpTeamById(planningBean.getSystemOwnerTeamComboItem().getValue());
						if (ipTeam==null || (ipTeam!=null && !IPFMUtils.ifBlank(ipTeam.getTier2Team(),"").equalsIgnoreCase("Y"))){
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0081")));
						}else{
							if (!planningBean.getSystemOwnerTeamComboItem().getValue().equalsIgnoreCase(planningBean.getSysOwnerTeamId())) {
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0082")));
							}
						}
					}else{
						IpTeam ipTeam = ipTeamService.findIpTeamById(planningBean.getSysOwnerTeamId());
						if (ipTeam==null || (ipTeam!=null && !IPFMUtils.ifBlank(ipTeam.getTier2Team(),"").equalsIgnoreCase("Y"))){
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0081")));
						}
					}
				}					
			}
			
			if(planningBean.getIpUrIpdetail().getSysOwnerId() == null || planningBean.getIpUrIpdetail().getSysOwnerId().equals("")) {
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), planningBean.getIpUrIpdetail().getSysOwnerName()));
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
			} else if (planningBean.getIpUrIpdetail().getSysOwnerName() == null || planningBean.getIpUrIpdetail().getSysOwnerName().equals("")) {
				//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), planningBean.getIpUrIpdetail().getSysOwnerName()));
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
			}
			
			if (IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSysOwnerId(),"").length()>0 
					&& IPFMUtils.ifBlank(planningBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0 ){
					IpUser sysUser = ipUserService.findIpUserById(planningBean.getIpUrIpdetail().getSysOwnerId());
					if (sysUser!=null) {
						if (!sysUser.getTeamId().equalsIgnoreCase(planningBean.getSystemOwnerTeamComboItem().getValue())) {
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
						}
					}else{
						if (!planningBean.getSystemOwnerTeamComboItem().getValue().equalsIgnoreCase(planningBean.getIpUrIpdetail().getSysOwnerTeamId())) {
							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0202")));
						}
					}
				}
			
			
			if (IPFMMessageUtils.hasMessages()) return;
		    IpUrIpDetail ipUrIPBean = planningBean.getIpUrIpdetail();
		    if(IPFMConstant.MODE_NEW.equals(planningBean.getV_Mode()))
		    {
			    	 // get Value and Label NetworkType DropDown
					if(planningBean.getNwTypeComboItem()!=null ){
							ipUrIPBean.setNetworkTypeId(planningBean.getNwTypeComboItem().getValue());
							ipUrIPBean.setNetworkTypeName(planningBean.getNwTypeComboItem().getLabel());	
					}
					// get Value and Label NetworkZone DropDown
					if(planningBean.getNwZoneComboItem()!=null){
							ipUrIPBean.setZoneId(planningBean.getNwZoneComboItem().getValue());
							ipUrIPBean.setZoneName(planningBean.getNwZoneComboItem().getLabel());	
					}
					// get Value and Label SystemOwner DropDown
					if(planningBean.getSystemOwnerComboItem()!=null){
							ipUrIPBean.setSysOwnerId(planningBean.getSystemOwnerComboItem().getValue());
							ipUrIPBean.setSysOwnerName(planningBean.getSystemOwnerComboItem().getLabel());	
					}
					// get Value and Label SystemOwnerTeam DropDown
					if(planningBean.getSystemOwnerTeamComboItem()!=null){
							ipUrIPBean.setSysOwnerTeamId(planningBean.getSystemOwnerTeamComboItem().getValue());
							ipUrIPBean.setSysOwnerTeamName(planningBean.getSystemOwnerTeamComboItem().getLabel());	
					}
					//get URNo 
					String  urno = planningReqIPService.getURNo();
					planningBean.getIpUrIpdetail().setUrNo(urno);
					ipUrIPBean.setReqName(userSessionBean.getIpUser().getUserName());
				    ipUrIPBean.setReqUserId(userSessionBean.getIpUser().getUserId());
				    ipUrIPBean.setReqDept(userSessionBean.getIpUser().getDept());
				    ipUrIPBean.setReqEmail(userSessionBean.getIpUser().getEmail());
				    ipUrIPBean.setReqSection(userSessionBean.getIpUser().getSection());
				    ipUrIPBean.setReqMobile(userSessionBean.getIpUser().getMobile());
				    ipUrIPBean.setReqPosition(userSessionBean.getIpUser().getPosition());
				    ipUrIPBean.setReqTel(userSessionBean.getIpUser().getTel());
				    ipUrIPBean.setReqTeam(userSessionBean.getIpUser().getTeamId());
					ipUrIPBean.setUrType("IP12");
					ipUrIPBean.setReqDate(IPFMDataUtility.getCurrentDate());
					ipUrIPBean.setOverSla("N");
					ipUrIPBean.setUrStatus(IPFMConstant.WAIT_ASSIGN);
					ipUrIPBean.setUrStatusName(IPFMConstant.WAITFORASSIGN);
					ipUrIPBean.setCreatedBy(userSessionBean.getIpUser().getUserId());
					ipUrIPBean.setLastUpdBy(userSessionBean.getIpUser().getUserId());
					ipUrIPBean.setLastUpd(null);
					IpUrAttachmentId   ipUrAttachmentId = new IpUrAttachmentId();
					ipUrAttachmentId.setUrNo(planningBean.getIpUrIpdetail().getUrNo());
					planningBean.getIpUrAttachment().setId(ipUrAttachmentId);
					ipUrIPBean = planningReqIPService.createSendForAssign(ipUrIPBean, planningBean.getIpUrAttachment());
					ipUrAttachmentService.updateAttachFile(tempUrNo,urno,userSessionBean.getIpUser().getUserId());
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
					planningBean.setButtonDeleteVisible(true); 
			}else {
		    	    ipUrIPBean.setUrType("IP12");
					ipUrIPBean.setReqDate(IPFMDataUtility.getCurrentDate());
					ipUrIPBean.setOverSla("N");
					ipUrIPBean.setLastUpd(null);
					ipUrIPBean.setLastUpdBy(userSessionBean.getIpUser().getUserId());
		    	    ipUrIPBean.setUrStatus(IPFMConstant.WAIT_ASSIGN);
		    	    ipUrIPBean.setUrStatusName(IPFMConstant.WAITFORASSIGN);
					ipUrIPBean = planningReqIPService.updateSendForAssign(ipUrIPBean);
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
		    sendEmail(planningBean, planningBean.getIpUrIpdetail().getUrType(), IPFMConstant.URTYPENAME_PLANNING_REQ_IP, planningBean.getIpUrIpdetail().getUrStatus(), planningBean.getIpUrIpdetail().getUrStatusName(), "", "N3" ,EMailService.TEMPLATE_IPFM,IPFMConstant.WAITFORASSIGN,IPFMConstant.WAITFORASSIGN);
			IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void updateValueBeforeDeleteUR(){
			String urNo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("urNoParam").toString();
			PlanningReqIPBean planningBean = getPlanningReqIPBean();
			IpUrAttachmentId   ipUrAttachmentId = new IpUrAttachmentId();
			ipUrAttachmentId.setUrNo(urNo);
			planningBean.getIpUrIpdetail().setUrNo(urNo);
			planningBean.getIpUrAttachment().setId(ipUrAttachmentId);
			setPlanningReqIPBean(planningBean);
	}
	
	public void deleteUR(){
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		try {
			    PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
			    IpUrIpDetail ipUrIPBean = planningBean.getIpUrIpdetail();
			    IpUrAttachment ipUrAttachment = planningBean.getIpUrAttachment();
			    
				ipUrIPBean = planningReqIPService.deleteUR(ipUrIPBean,ipUrAttachment);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0025")));
				IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0009")));
		}
	}
	
	public void popupHistory(){
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
			    PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
			    String URNo = planningBean.getIpUrIpdetail().getUrNo();
				try {
					List<IpUrActionHistory> historyList = planningReqIPService.getHistoryList(URNo);
			    	planningBean.setHistoryList(historyList);
				    List<IpUrAction>  urActionList  = planningReqIPService.getURActionList(URNo);
				    IpUrAction ipUrAction = planningReqIPService.getIpUrAction(URNo);
				    if(ipUrAction == null){
				    	planningBean.setRenderApproval("");
				    } else if(ipUrAction != null && ipUrAction.getUrStatus().equals("")) {
				    	planningBean.setRenderApproval("");
				    } else {
				    	planningBean.setRenderApproval("Render");
				    }
				    
				    planningBean.setIpUrAction(ipUrAction);
				    planningBean.setUrActionList(urActionList);
				    setPlanningReqIPBean(planningBean); 
				} catch (IPFMBusinessException e) {
					e.printStackTrace();
				}
	}

   public void downloadFile() {
		try{
			String fileName = getRequestParameter("fileName");
			String path = getRequestParameter("path");
			
	        downloadFile(path, fileName);	        
		} catch (FileNotFoundException fex) {
        	IPFMMessageUtils.addMessageError(fex.getMessage());
        } catch (Exception ex) {
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
 }
 
 
   public void addIP() throws Exception{
		PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		UserSession userSessionBean = getUserSession();
		List<IpUrIpResult>  assignmentIPList =null;
		List<IpLevel1>  ipLevel1List =null;
	    try {
	    	   if(validateAddIP()){
	    		    String ipDigit1 = planningBean.getIpUrIpResult().getIpDigit1();
	    		    String ipDigit2 = planningBean.getIpUrIpResult().getIpDigit2();
	    		    String ipDigit3 = planningBean.getIpUrIpResult().getIpDigit3();
	    		    String ipDigit4 = planningBean.getIpUrIpResult().getIpDigit4();
	    		    String mask = planningBean.getIpUrIpResult().getMask();
	    		    
				    IpUrIpResult  result  =  planningReqIPService.checkIPRange(ipDigit1,ipDigit2,ipDigit3,ipDigit4,mask);
				    if(!IPFMConstant.Found.equals(result.getResult())){  
//				    		if(result.getLevel1Start() != null && result.getLevel1End() != null) {
//				    			if(result.getLevel1Start().trim().equals("0.0.0.0") && result.getLevel1End().trim().equals("0.0.0.0") ) {
//				    				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0200")));
//				    				return;
//				    			}
//				    		}
				    	
					           if(planningBean.getAssignmentIPList()==null){ 
					        	  assignmentIPList = new ArrayList<IpUrIpResult>();
					        	  ipLevel1List = new ArrayList<IpLevel1>();
					           } 
					        	IpUrIpResult  ipUrIpResult = new IpUrIpResult();
					        	IpLevel1  ipLevel1 = new IpLevel1();
					        	ipUrIpResult = result;
					        	ipUrIpResult.setIpVersion(planningBean.getIpUrIpResult().getIpVersion());
					        	ipUrIpResult.setEffectiveDate(planningBean.getIpUrIpResult().getEffectiveDate());
					        	ipUrIpResult.setExpireDate(planningBean.getIpUrIpResult().getExpireDate());
					        	ipUrIpResult.setRemarks(planningBean.getIpUrIpResult().getRemarks());
					        	ipUrIpResult.setCreatedBy(userSessionBean.getIpUser().getUserId());
					        	ipUrIpResult.setLastUpdBy(userSessionBean.getIpUser().getUserId());
					        	IpUrIpResultId id = new IpUrIpResultId(planningBean.getIpUrIpdetail().getUrNo(),null);
					        	ipUrIpResult.setId(id);
					        	
					        	String level1Id = planningReqIPService.getLevel1_ID();
					        	ipLevel1.setLevel1Id(level1Id);
							    ipLevel1.setLevel1Start(result.getLevel1Start());
							    ipLevel1.setLevel1End(result.getLevel1End());
							    ipLevel1.setBinary1Start(result.getBinary1Start());
							    ipLevel1.setBinary1End(result.getBinary1End());
							    ipLevel1.setIpStatus(IPFMConstant.IPSTATUS);
							    ipLevel1.setT1TeamId(userSessionBean.getIpUser().getTeamId());
							    ipLevel1.setT2TeamId(planningBean.getIpUrIpdetail().getSysOwnerTeamId());
							    ipLevel1.setTotalIp(new BigDecimal(result.getTotalIp()));
							    ipLevel1.setTotalT2Assign(new BigDecimal(0));
								ipLevel1.setCreatedBy(userSessionBean.getIpUser().getUserId());
								ipLevel1.setLastUpdBy(userSessionBean.getIpUser().getUserId());
								ipLevel1.setNetworkZoneId(planningBean.getNwZoneComboItem().getValue());
							    
							    if(planningBean.getAssignmentIPList()==null){
							      ipUrIpResult.setIpLevel1(ipLevel1);
								  assignmentIPList.add(ipUrIpResult);
								  ipLevel1List.add(ipLevel1);
								  planningBean.setAssignmentIPList(assignmentIPList);
								  planningBean.setIpLevel1List(ipLevel1List);
							   }else{
								  ipUrIpResult.setIpLevel1(ipLevel1);
								  planningBean.getAssignmentIPList().add(ipUrIpResult);
								  planningBean.getIpLevel1List().add(ipLevel1);
							   }
							    planningBean.setIpUrIpResult(ipUrIpResult);
					    }else{
					    	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER5001"), result.getLevel1Start()+"-"+result.getLevel1End()));
					    	return;
					    }
				    
	    	         planningBean.setCount(planningBean.getAssignmentIPList().size());
				     setPlanningReqIPBean(planningBean);
	    	   }     

				     
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
    }  
    public void deleteIP(){
    	PlanningReqIPBean planningBean = getPlanningReqIPBean();
    	List<IpUrIpResult> tmpDeleteIpResult = new ArrayList<IpUrIpResult>();
    	try{
	    	if(planningBean.getChecked() != null && planningBean.getChecked().size() > 0) {
		    	for(int i=0; i < planningBean.getChecked().size(); i++){
		    	  if(planningBean.getChecked().get(i)){
		    		  tmpDeleteIpResult.add(planningBean.getAssignmentIPList().get(i));
		    	  }
		    	}
		    	if(tmpDeleteIpResult != null) {
		    		for(int i=0; i < tmpDeleteIpResult.size(); i++){
		    			IpUrIpResult result = tmpDeleteIpResult.get(i);
		    			planningBean.getIpLevel1List().remove(result.getIpLevel1());
		    			planningBean.getAssignmentIPList().remove(result);
		    		}
		    	}
		    }
	    	planningBean.setChecked(new HashMap<Long,Boolean>());
	     planningBean.setCount(planningBean.getAssignmentIPList().size());
	     setPlanningReqIPBean(planningBean);
	    }catch (Exception e) {
	    	e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
    }
    

    
    public void importExcel(UploadEvent event) {
   	 PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
   	 SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy", new Locale("en","EN"));
	   	 PlanningReqIPBean planningBean = getPlanningReqIPBean();
	   	 UserSession userSessionBean = getUserSession();
		 List<IpUrIpResult>  assignmentIPList =null;
		 List<IpLevel1>  ipLevel1List =null;
	   	 List<ExcelErrorMsg> errorlist = new ArrayList<ExcelErrorMsg>();
		 UploadItem item = event.getUploadItem();
		 try{
			Workbook w = Workbook.getWorkbook(item.getFile());
			String[] sheetName = w.getSheetNames();
			boolean flagSheetName=false;
			for (int i=0 ; i<sheetName.length ; i++) {
				if (sheetName[i].trim().toUpperCase().equalsIgnoreCase(getIPFMConfig().getAssingIpPlanningRequestIP().toUpperCase())) {
					flagSheetName = true;
					break;
				}
			}
			if (!flagSheetName) {
				ExcelErrorMsg excelMsg = new ExcelErrorMsg();
				excelMsg.setRowNo("");	
				addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0070"), getIPFMConfig().getAssingIpPlanningRequestIP()));
				errorlist.add(excelMsg);
				planningBean.setErrorMsgList(errorlist);
				setPlanningReqIPBean(planningBean);
				return;
			}
		 }catch (Exception e) {
			e.printStackTrace();
			ExcelErrorMsg excelMsg = new ExcelErrorMsg();
			excelMsg.setRowNo("");	
			addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0071")));
			errorlist.add(excelMsg);
			planningBean.setErrorMsgList(errorlist);
			setPlanningReqIPBean(planningBean);
			return;
		 }
		 try {	 			 
				List<GXLSColumn> columns = new ArrayList<GXLSColumn>();
				columns.add(new GXLSColumn("ipVersion", null, 0));
				columns.add(new GXLSColumn("ip", null, 1));
				columns.add(new GXLSColumn("effDate", null, 2));
				columns.add(new GXLSColumn("expDate", null, 3));
				
				@SuppressWarnings("unchecked")
				String file = item.getFile().toString();
				List<IpUrIpResult> dataList = GXLSUtil.fromFile(file, columns, IpUrIpResult.class);
				ExcelErrorMsg excelMsg;
				int rows=0;
				assignmentIPList = new ArrayList<IpUrIpResult>();
	        	ipLevel1List = new ArrayList<IpLevel1>();
	        	ExcelService excelService = (ExcelService)JSFServiceFinderUtil.getInstance().getBean("excelService");
				for (IpUrIpResult ipUrIpResultBean : dataList){
					if(ipUrIpResultBean.getIp()!=null && ipUrIpResultBean.getEffDate()!=null 
					  && ipUrIpResultBean.getExpDate()!=null && ipUrIpResultBean.getExpDate()!=null ){
						
					  if(rows>=1){
						excelMsg = new ExcelErrorMsg();
						excelMsg.setRowNo(String.valueOf(rows));	
						
						if (ipUrIpResultBean.getIpVersion()!=null && ipUrIpResultBean.getIpVersion().trim().length()>0) {
							if (ipUrIpResultBean.getIpVersion().indexOf(".")>-1) {
								ipUrIpResultBean.setIpVersion(ipUrIpResultBean.getIpVersion().trim().substring(0, ipUrIpResultBean.getIpVersion().trim().indexOf(".")));
							}
						}
						ipUrIpResultBean.setIpAddress(ipUrIpResultBean.getIp().trim());
						excelService.prepareIPVersion(ipUrIpResultBean, ipUrIpResultBean.getIpVersion().trim(), excelMsg);
						excelService.prepareIPAddress(ipUrIpResultBean, ipUrIpResultBean.getIp().trim(), excelMsg);
						excelService.prepareEffExpDate(ipUrIpResultBean, ipUrIpResultBean.getEffDate().trim(), ipUrIpResultBean.getExpDate().trim(), excelMsg);
						
						if (excelMsg.getErrorMsg()!=null && excelMsg.getErrorMsg().trim().length()>0) {
							errorlist.add(excelMsg);
							continue;
						}
//						if(!"".equals(ipUrIpResultBean.getIp()) && ipUrIpResultBean.getIp()!=null){
//							String[] ip = ipUrIpResultBean.getIp().split("\\.");
//							String[] mask = ip[3].split("\\/");
//							ipUrIpResultBean.setIpDigit1(ip[0]);
//							ipUrIpResultBean.setIpDigit2(ip[1]);
//							ipUrIpResultBean.setIpDigit3(ip[2]);
//							ipUrIpResultBean.setIpDigit4(mask[0]);
//							if(mask.length >=2){
//							ipUrIpResultBean.setMask(mask[1]);
//							}
//						}
						//validateAssignInfo(ipUrIpResultBean,excelMsg);	
						if (excelMsg.getErrorMsg()!=null && excelMsg.getErrorMsg().trim().length()>0) {
							//errorlist.add(excelMsg);
							//planningBean.setErrorMsgList(errorlist);
						}else{
							if (IPFMUtils.ifBlank(ipUrIpResultBean.getIpDigit1(), "").trim().length()!=0 
									&& IPFMUtils.ifBlank(ipUrIpResultBean.getIpDigit2(), "").trim().length()!=0 
									&& IPFMUtils.ifBlank(ipUrIpResultBean.getIpDigit3(), "").trim().length()!=0
									&& IPFMUtils.ifBlank(ipUrIpResultBean.getIpDigit4(), "").trim().length()!=0
									) {
								
			    		    String ipDigit1 = ipUrIpResultBean.getIpDigit1();
			    		    String ipDigit2 = ipUrIpResultBean.getIpDigit2();
			    		    String ipDigit3 = ipUrIpResultBean.getIpDigit3();
			    		    String ipDigit4 = ipUrIpResultBean.getIpDigit4();
			    		    String mask = "";
			    		    if (ipUrIpResultBean.getMask()==null || ipUrIpResultBean.getMask().trim().length()==0){ 
			    		    	ipUrIpResultBean.setMask("32");
			    		    	mask = "32";
			    		    }else{
			    		    	mask = ipUrIpResultBean.getMask();
			    		    }
							IpUrIpResult  result  =  planningReqIPService.checkIPRange(ipDigit1,ipDigit2,ipDigit3,ipDigit4,mask);
							if(!IPFMConstant.Found.equals(result.getResult())){
						          
							        	IpUrIpResult  ipUrIpResult = new IpUrIpResult();
							        	IpLevel1  ipLevel1 = new IpLevel1();
							        	ipUrIpResult = result;
							        	IpUrIpResultId id = new IpUrIpResultId(planningBean.getIpUrIpdetail().getUrNo(),null);
							        	ipUrIpResult.setId(id);
							        	ipUrIpResult.setEffectiveDate(smf.parse((ipUrIpResultBean.getEffDate())));
							        	ipUrIpResult.setExpireDate(smf.parse((ipUrIpResultBean.getExpDate())));
							        	ipUrIpResult.setCreatedBy(userSessionBean.getIpUser().getUserId());
							        	ipUrIpResult.setLastUpdBy(userSessionBean.getIpUser().getUserId());
							        	
							        	String level1Id = planningReqIPService.getLevel1_ID();
							        	ipLevel1.setLevel1Id(level1Id);
									    ipLevel1.setLevel1Start(result.getLevel1Start());
									    ipLevel1.setLevel1End(result.getLevel1End());
									    ipLevel1.setEffectiveDate(ipUrIpResult.getEffectiveDate());
									    ipLevel1.setExpiredDate(ipUrIpResult.getExpireDate());
									    ipLevel1.setBinary1Start(result.getBinary1Start());
									    ipLevel1.setBinary1End(result.getBinary1End());
									    ipLevel1.setIpStatus(IPFMConstant.IPSTATUS);
									    ipLevel1.setT1TeamId(userSessionBean.getIpUser().getTeamId());
									    ipLevel1.setT2TeamId(planningBean.getIpUrIpdetail().getSysOwnerTeamId());
									    ipLevel1.setTotalIp(new BigDecimal(result.getTotalIp()));
									    ipLevel1.setTotalT2Assign(new BigDecimal(0));
										ipLevel1.setCreatedBy(userSessionBean.getIpUser().getUserId());
										ipLevel1.setLastUpdBy(userSessionBean.getIpUser().getUserId());
									    
										ipUrIpResult.setV_Mode_Assign("excel");
										
										ipUrIpResult.setIpLevel1(ipLevel1);
									    assignmentIPList.add(ipUrIpResult);
									    ipLevel1List.add(ipLevel1);
										 
									    
/*									    if(planningBean.getAssignmentIPList()==null){
										  assignmentIPList.add(ipUrIpResult);
										  ipLevel1List.add(ipLevel1);
										  planningBean.setAssignmentIPList(assignmentIPList);
										  planningBean.setIpLevel1List(ipLevel1List);
									   }else{
										  planningBean.getAssignmentIPList().add(ipUrIpResult);
										  planningBean.getIpLevel1List().add(ipLevel1);
									   }*/
									      planningBean.setIpUrIpResult(ipUrIpResult);
							    }else{
									addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER5001"), result.getLevel1Start()+"-"+result.getLevel1End()));
									errorlist.add(excelMsg);
									//planningBean.setErrorMsgList(errorlist);
							    }
						  }
						}
				     }
					  
					}
					rows++;
				}
				if (errorlist.size()==0) {
					
					 if(planningBean.getAssignmentIPList()==null) planningBean.setAssignmentIPList(new ArrayList<IpUrIpResult>());
					planningBean.getAssignmentIPList().addAll(assignmentIPList);
					if(planningBean.getIpLevel1List()==null) planningBean.setIpLevel1List(new ArrayList<IpLevel1>());
					planningBean.getIpLevel1List().addAll(ipLevel1List);
				}else{
					planningBean.setErrorMsgList(errorlist);
				}
				if (planningBean.getAssignmentIPList()==null) planningBean.setAssignmentIPList(new ArrayList<IpUrIpResult>()); 
				planningBean.setCount(planningBean.getAssignmentIPList().size());
				System.out.println("planningBean.getCount() = "+planningBean.getCount());
				setPlanningReqIPBean(planningBean);
				
				planningBean = getPlanningReqIPBean();
				System.out.println("planningBean.getCount() = "+planningBean.getCount());
			}catch (IPFMBusinessException ipfme){
				IPFMMessageUtils.addMessageError(ipfme.getMessage());
			}catch (Exception e) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0030")));
			}
		
   }
  
	public void popupSearchIP(){
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		try {
			validateAssignIPInfo();
			if (IPFMMessageUtils.hasMessages()) return;
			planningBean.setSearchIP(new SearchIP());
			planningBean.setSearchIPCheckAll(false);
		    setPlanningReqIPBean(planningBean) ;
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void popupSearchIP1(){
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		try {
			planningBean.setSearchIP1(new SearchIP());
			setPlanningReqIPBean(planningBean) ; 
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
    
    
    public void assignIP() {
		PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		UserSession userSessionBean = getUserSession();
		try {
			 if(validateAssignIPInfo()){ 
				 if (planningBean.getAssignmentIPList()==null || planningBean.getAssignmentIPList().size()==0) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0084")));
						return ;
					}
				 	List<IpLevel1> level1List = new ArrayList<IpLevel1>();
				 	List<IpUrIpResult> ipUrIpResultList = new ArrayList<IpUrIpResult>();
                    int i=0;  				
		    		for(IpUrIpResult bean : planningBean.getAssignmentIPList()){
		    			bean.setIpVersion(planningBean.getIpUrIpResult().getIpVersion());
//						String result  = planningReqIPService.reCheck_ip_range(bean);
//						if(result!=null){
//							IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER5001"), bean.getLevel1Start()+"-"+bean.getLevel1End()));
//						}else {
		    				if(planningBean.getCompanyComboItem()!=null){
		    					bean.setCompanyId(planningBean.getCompanyComboItem().getValue());
		    					bean.setCompanyName(planningBean.getCompanyComboItem().getLabel());	
						    }
		    				if(planningBean.getIpTypeComboItem()!=null){
		    					bean.setIpTypeId(planningBean.getIpTypeComboItem().getValue());
		    					bean.setIpTypeName(planningBean.getIpTypeComboItem().getLabel());	
						    }
		    				if(planningBean.getNwTypeComboItem()!=null){
		    					bean.setNetworkTypeId(planningBean.getNwTypeComboItem().getValue());
		    					bean.setNetworkTypeName(planningBean.getNwTypeComboItem().getLabel());	
						    }
		    				if(planningBean.getNwZoneComboItem()!=null){
		    					bean.setNetworkZoneId(planningBean.getNwZoneComboItem().getValue());
		    					bean.setNetworkZoneName(planningBean.getNwZoneComboItem().getLabel());	
						    }
		    				
		    				bean.setVlanId(planningBean.getIpUrIpResult().getVlanId());
		    				bean.setDnsName(planningBean.getIpUrIpResult().getDnsName());
		    				bean.setVip(planningBean.getIpUrIpResult().getVip());
		    				bean.setNetworkIp(planningBean.getIpUrIpResult().getNetworkIp());
		    				bean.setGateway(planningBean.getIpUrIpResult().getGateway());
		    				bean.setRemarks(planningBean.getIpUrIpResult().getRemarks());
		    				
							IpLevel1 ipLevel1 = (IpLevel1) planningBean.getIpLevel1List().get(i);
							ipLevel1.setIpVersion(planningBean.getIpUrIpResult().getIpVersion());
							ipLevel1.setT2TeamId(planningBean.getIpUrIpdetail().getReqTeam());
							//ipLevel1.setT2TeamName(planningBean.getIpUrIpdetail().getT2TeamName());
							ipLevel1.setT2TeamName(planningBean.getIpUrIpdetail().getSysOwnerTeamName());
							ipLevel1.setT2Team(new IpTeam(planningBean.getIpUrIpdetail().getReqTeam(),planningBean.getIpUrIpdetail().getT2TeamName()));
							ipLevel1.setCompanyId(planningBean.getCompanyComboItem().getValue());
							ipLevel1.setCompanyName(planningBean.getCompanyComboItem().getLabel());
							ipLevel1.setIpTypeId(planningBean.getIpTypeComboItem().getValue());
							ipLevel1.setIpTypeName(planningBean.getIpTypeComboItem().getLabel());
							ipLevel1.setNetworkTypeId(planningBean.getNwTypeComboItem().getValue());
							ipLevel1.setNetworkTypeName(planningBean.getNwTypeComboItem().getLabel());	
							ipLevel1.setNetworkZoneId(planningBean.getNwZoneComboItem().getValue());
							ipLevel1.setNetworkZoneName(planningBean.getNwZoneComboItem().getLabel());
							ipLevel1.setGateway(planningBean.getIpUrIpResult().getGateway());
							ipLevel1.setDnsName(planningBean.getIpUrIpResult().getDnsName());
							ipLevel1.setVlanId(planningBean.getIpUrIpResult().getVlanId());
							ipLevel1.setT1TeamName(userSessionBean.getIpUser().getTeamName());							
							ipLevel1.setVip(planningBean.getIpUrIpResult().getVip());
							ipLevel1.setNetworkIp(planningBean.getIpUrIpResult().getNetworkIp());
							if(!"excel".equals(bean.getV_Mode_Assign())){
							ipLevel1.setEffectiveDate(planningBean.getIpUrIpResult().getEffectiveDate());
							ipLevel1.setExpiredDate(planningBean.getIpUrIpResult().getExpireDate());
							}
							ipLevel1.setT1Remarks(planningBean.getIpUrIpResult().getRemarks());
							
							level1List.add((IpLevel1)ipLevel1.clone());
							ipUrIpResultList.add((IpUrIpResult)bean.clone());
							i++;
//						} 
		    		}
		    		planningBean.getIpUrIpdetail().setUrStatus(IPFMConstant.STATUS_CLOSE);
		    		planningBean.getIpUrIpdetail().setUrStatusName(IPFMConstant.STATUS_CLOSE_UR);
		    		planningBean.getIpUrIpdetail().setLastUpdBy(userSessionBean.getIpUser().getUserId());
		    		planningBean.getIpUrIpdetail().setLastUpd(null);
		    		planningReqIPService.createAssignIP((IpUrIpDetail)planningBean.getIpUrIpdetail().clone(),ipUrIpResultList, level1List);
					
//		    		planningReqIPService.updateIpDetail_genURIpToDoList(planningBean.getIpUrIpdetail());
		    		String assignResultIP = "";
		    	    for (IpUrIpResult ipResult : planningBean.getAssignmentIPList()) {
		    	    		assignResultIP = assignResultIP+ipResult.getLevel1Start()+"-"+ipResult.getLevel1End()+"<br>";
		    	    }
		    		sendEmail(planningBean, planningBean.getIpUrIpdetail().getUrType(), IPFMConstant.URTYPENAME_PLANNING_REQ_IP, planningBean.getIpUrIpdetail().getUrStatus(), planningBean.getIpUrIpdetail().getUrStatusName(), assignResultIP, "N3" ,EMailService.TEMPLATE_IPFM_ASSIGNIP,"Request IP Assign Complete","Request IP Assign Complete");
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
    }  
    
    public void reject() throws Exception{
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		try {
			    PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
				IpUrAttachmentId   ipUrAttachmentId = new IpUrAttachmentId();
				ipUrAttachmentId.setUrNo(planningBean.getIpUrIpdetail().getUrNo());
				planningBean.getIpUrAttachment().setId(ipUrAttachmentId);
				
				planningReqIPService.rejectUR(planningBean.getIpUrIpdetail(),planningBean.getIpUrAttachment());
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0025")));
				IPFMWebUtil.storeOnSession("HOME", true);
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0009")));
		}
    	
    }  
    
    
	public void downloadTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateUR12Assign();
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
	        String fileName = ipfmConfigBean.getTemplateUR12Assign();
	        File file = new File(path,fileName);
	        if (!file.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }

	@SuppressWarnings("unchecked")
	public void sendEmail(PlanningReqIPBean bean,String urType,String urTypeName,String urStatus,String urStatusName,String  assignResultIP,String nodeId,String template,String subjectDesc,String bodyDesc) throws Exception{	
		
		EMailService emailService = (EMailService)JSFServiceFinderUtil.getInstance().getBean("emailService");
		IpUrActionService actionService = (IpUrActionService)JSFServiceFinderUtil.getInstance().getBean("ipUrActionService");
		String urNo = bean.getIpUrIpdetail().getUrNo();
		IPUserService userService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
		UserSession userSessionBean = getUserSession();
		int length = 0;
		List<IpRoleMember> ipUserList = new ArrayList<IpRoleMember>();		
		if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.WAIT_ASSIGN)) {
			ipUserList = userService.findUserByIpRoleMember("R05");
			length = ipUserList.size();
		}else{
			length = 1;
	    }
		for (int i=0 ; i<length ; i++) {
			String userId = "";
			if (urStatus!=null && urStatus.trim().equalsIgnoreCase(IPFMConstant.WAIT_ASSIGN)) {
				userId = ((IpRoleMember)ipUserList.get(i)).getUserId();
			}else{
				userId = bean.getIpUrIpdetail().getReqUserId();
		    }
			IpUser manager = userService.findIpUserById(userId);
//			String key = "IPFM"+urNo+":"+manager.getUserId();
			String key = emailService.getKeyCodeEmail();
			String[] to = {manager.getEmail()};
	        String[] cc = null;
	        String from = "ipfm@ais.co.th";
	        
	        if(actionService.isSendEmail(urType, nodeId)){
		        try{
			        Map model = new HashMap();
			        model.put("subjectDesc", subjectDesc);
			        model.put("bodyDesc", bodyDesc);
			        model.put("managerName", manager.getUserName());
			        model.put("urNo", urNo);
			        model.put("urType", urTypeName);
			        model.put("urStatus", urStatusName);
			        model.put("subject", bean.getIpUrIpdetail().getSubject());
			        model.put("assignResultIP", assignResultIP);
			        model.put("requestBy", userSessionBean.getIpUser().getUserName());
			        SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("TH", "th"));
			        model.put("requestDate", smf.format(new Date()));
			        String encodeUrl = new String(Base64.encodeBase64(key.getBytes()));
			        System.out.println("encodeUrl >>> "+encodeUrl);
			        model.put("url",getIPFMConfig().getHomeUrl()+"/home/view.jsf?key="+encodeUrl);
			        
			        emailService.sendMail(to, cc, from, template, model);
			        
			        IpEmailNotify notify = new IpEmailNotify();
			        notify.setUserId(manager.getUserId());
			        notify.setUrNo(urNo);
			        notify.setUrStatus(urStatus);
			        notify.setEmailLinkStatus("N");
			        notify.setEmailCode(key);
			        notify.setCreatedBy(userSessionBean.getIpUser().getUserId());
			        notify.setLastUpdBy(userSessionBean.getIpUser().getUserId());
			        actionService.saveEmailNotify(notify);
			        
		        } catch (Exception e) {
					System.out.println("Email can not send.");
				}
	        }
		}
	}
	
	
	private boolean validateIP(String ipVersion, String ipDigit1, String ipDigit2, String ipDigit3, String ipDigit4) {
		boolean flgValid = true;
		PlanningReqIPBean planningReqIPBean = getPlanningReqIPBean();
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
	
	public void searchIPCheckAllAction(){
		//System.out.println("------ checkAll -------");
		PlanningReqIPBean planningReqIPBean = getPlanningReqIPBean();
		try{
			if (planningReqIPBean.getSearchIPDataTable().getRowCount()>0) {
				HtmlDataTable dataTable = planningReqIPBean.getSearchIPDataTable();
				int startRow = dataTable.getFirst();
				int endRow = dataTable.getFirst() + dataTable.getRows();
				if (endRow==0) endRow = dataTable.getRowCount();
				int rowSize = dataTable.getRowCount();
				for (int i=startRow ; i<endRow ; i++) {
					if (i == rowSize) break;
					dataTable.setRowIndex(i);
					IpInfo ipInfo = (IpInfo) dataTable.getRowData();
					if (ipInfo.isButtonCheck()) {
						ipInfo.setRowCheck(planningReqIPBean.isSearchIPCheckAll());
					}
				}
			}
			setPlanningReqIPBean(planningReqIPBean);
		}catch (Exception e){
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	public void assignSearchIP(){
		PlanningReqIPBean planningReqIPBean = getPlanningReqIPBean();
		SearchIP searchIP = planningReqIPBean.getSearchIP();
		UserSession userSessionBean = IPFMWebUtil.getUserSession();
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
					IpUrIpResult ipUrIpResult = new IpUrIpResult();
					ipUrIpResult.setIpVersion("4");					
					ipUrIpResult.setIpAddress(ipInfoSearch.getIpAddress());
					ipUrIpResult.setMask(ipInfoSearch.getSubmask());
					PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
		        	ipUrIpResult = planningReqIPService.checkIPRange(String.valueOf(ipInfoSearch.getIpv4digit1()), String.valueOf(ipInfoSearch.getIpv4digit2()), String.valueOf(ipInfoSearch.getIpv4digit3()), String.valueOf(ipInfoSearch.getIpv4digit4()), ipInfoSearch.getSubmask());
		        	IpUrIpResultId id = new IpUrIpResultId(planningReqIPBean.getIpUrIpdetail().getUrNo(),null);
		        	ipUrIpResult.setId(id);		        	
					ipUrIpResult.setRemarks(planningReqIPBean.getIpUrIpResult().getRemarks());
		        	ipUrIpResult.setCreatedBy(userSessionBean.getIpUser().getUserId());
		        	ipUrIpResult.setLastUpdBy(userSessionBean.getIpUser().getUserId());
		        	ipUrIpResult.setEffectiveDate(planningReqIPBean.getIpUrIpResult().getEffectiveDate());
		        	ipUrIpResult.setExpireDate(planningReqIPBean.getIpUrIpResult().getExpireDate());
		        	
		        	if (!IPFMConstant.Found.equalsIgnoreCase(ipUrIpResult.getResult())) {
			        	IpLevel1  ipLevel1 = new IpLevel1();
			        	String level1Id = planningReqIPService.getLevel1_ID();
			        	ipLevel1.setLevel1Id(level1Id);
					    ipLevel1.setLevel1Start(ipUrIpResult.getLevel1Start());
					    ipLevel1.setLevel1End(ipUrIpResult.getLevel1End());
					    ipLevel1.setBinary1Start(ipUrIpResult.getBinary1Start());
					    ipLevel1.setBinary1End(ipUrIpResult.getBinary1End());
					    ipLevel1.setIpStatus(IPFMConstant.IPSTATUS);
					    ipLevel1.setT1TeamId(userSessionBean.getIpUser().getTeamId());
					    ipLevel1.setT2TeamId(planningReqIPBean.getIpUrIpdetail().getSysOwnerTeamId());
					    ipLevel1.setTotalIp(new BigDecimal(ipUrIpResult.getTotalIp()));
					    ipLevel1.setTotalT2Assign(new BigDecimal(0));
						ipLevel1.setCreatedBy(userSessionBean.getIpUser().getUserId());
						ipLevel1.setLastUpdBy(userSessionBean.getIpUser().getUserId());
						ipLevel1.setNetworkZoneId(planningReqIPBean.getNwZoneComboItem().getValue());			        		
		        		
						if (planningReqIPBean.getIpLevel1List()==null) 
							planningReqIPBean.setIpLevel1List(new ArrayList<IpLevel1>());
						planningReqIPBean.getIpLevel1List().add(ipLevel1);	
						if (planningReqIPBean.getAssignmentIPList()==null) 
							planningReqIPBean.setAssignmentIPList(new ArrayList<IpUrIpResult>());
						ipUrIpResult.setIpLevel1(ipLevel1);
						planningReqIPBean.getAssignmentIPList().add(ipUrIpResult);
		        	}else{
				    	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ipUrIpResult.getResult()));
				    	break;
				    }
				}
			}
			planningReqIPBean.setCount(planningReqIPBean.getAssignmentIPList().size());
			setPlanningReqIPBean(planningReqIPBean);
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public void linkSearchIP(){		
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		planningBean.setSearchIP(new SearchIP());
		SearchIP searchIP = planningBean.getSearchIP();
		try {
			searchIP.setIpAddress(getRequestParameter("ipAddress"));
			searchIP.setIpSubmask(getRequestParameter("ipSubmask"));
			searchIP.setIpv4digit1(getRequestParameter("ipDigit1"));
			searchIP.setIpv4digit2(getRequestParameter("ipDigit2"));
			searchIP.setIpv4digit3(getRequestParameter("ipDigit3"));
			searchIP.setIpv4digit4(getRequestParameter("ipDigit4"));
			
			planningBean = searchIPForAssign(planningBean);
			setPlanningReqIPBean(planningBean);
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	
	public PlanningReqIPBean searchIPForAssign(PlanningReqIPBean planningReqIPBean){
		try {
			SearchIP searchIP = planningReqIPBean.getSearchIP();
			String vDisplayMask = "";
			validateIP("4", searchIP.getIpv4digit1(), searchIP.getIpv4digit2(), searchIP.getIpv4digit3(), searchIP.getIpv4digit4());
			if (IPFMMessageUtils.hasMessages()) return null;
			int mask = 32; String vMask = "";
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
			searchIP.setIpAddress(searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+searchIP.getIpv4digit4());
			
			//CHECK RANGE IP
			PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
			UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
	        	//Get Range from Mask
	        	IpMaskDisplay ipMaskDisplay = planningReqIPService.findIpMaskDisplayByMask(vMask);
	        	searchIP.setIpMaskDisplay(ipMaskDisplay);
	        	searchIP.setVsubmask(vDisplayMask);
	        	List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
//	        	IpUrIpResult resultCheck = planningReqIPService.checkIPRange(searchIP.getIpv4digit1(), searchIP.getIpv4digit2(), searchIP.getIpv4digit3(), searchIP.getIpv4digit4(), searchIP.getIpSubmask());
//	        	if(IPFMConstant.Found.equalsIgnoreCase(resultCheck.getResult())){
//	        		IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER5001"), resultCheck.getLevel1Start()+"-"+resultCheck.getLevel1End()));
//					return null;
//				}
//	        	if (vDisplayMask.equalsIgnoreCase("16") || vDisplayMask.equalsIgnoreCase("24")) {
	        		int subnet; 	
        			int runDigit = 0;
//        			List<IpInfo> checkBoxList = new ArrayList<IpInfo>();
	        		for (int i=1 ; i<=ipMaskDisplay.getSubnet() ; i++) {
	        			subnet = i;
	        			for (int j=0 ; j<ipMaskDisplay.getLength() ; j++) {
	        				String ipAddress=""; String networkIp="";
	        				if (ipMaskDisplay.getDigit().intValue()==1) {
//	        					ipAddress = runDigit+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+searchIP.getIpv4digit4();
//	        					networkIp = runDigit+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+"0";
	        					ipAddress = runDigit+"."+"0"+"."+"0"+"."+"0";
	        					networkIp = runDigit+"."+"0"+"."+"0"+"."+"0";
	        				}else if (ipMaskDisplay.getDigit().intValue()==2){
//	        					ipAddress = searchIP.getIpv4digit1()+"."+runDigit+"."+searchIP.getIpv4digit3()+"."+searchIP.getIpv4digit4();
//	        					networkIp = searchIP.getIpv4digit1()+"."+runDigit+"."+searchIP.getIpv4digit3()+"."+"0";
	        					ipAddress = searchIP.getIpv4digit1()+"."+runDigit+"."+"0"+"."+"0";
	        					networkIp = searchIP.getIpv4digit1()+"."+runDigit+"."+"0"+"."+"0";
	        				}else if (ipMaskDisplay.getDigit().intValue()==3){
//	        					ipAddress = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+runDigit+"."+searchIP.getIpv4digit4();
//	        					networkIp = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+runDigit+"."+"0";
	        					ipAddress = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+runDigit+"."+"0";
	        					networkIp = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+runDigit+"."+"0";
	        				}else if (ipMaskDisplay.getDigit().intValue()==4){
	        					ipAddress = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+runDigit;
	        					networkIp = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+"0";
	        				}
	        				String[] ipDigit = ipAddress.split("\\.");
	        				IpUrIpResult ipUrIpResult = planningReqIPService.checkIPRange(ipDigit[0], ipDigit[1], ipDigit[2], ipDigit[3], String.valueOf(vDisplayMask));
	        				ipUrIpResult.setIpVersion("4");
	        				IpInfo ipInfo = newIpInfo(planningReqIPBean.getIpUrIpdetail(), ipUrIpResult, ipAddress);
	        				ipInfo.setT2TeamId(planningReqIPBean.getIpUrIpdetail().getT2TeamId());
	        				ipInfo.setNetworkIp(networkIp);
	        				ipInfo.setSubNet(subnet);
	        				ipInfo.setSubmask(vDisplayMask);
	        				ipInfo.setBinaryIpStart(ipUrIpResult.getBinary1Start());
	        				ipInfo.setBinaryIpEnd(ipUrIpResult.getBinary1End());
	        				//ipInfo 
	        				
//	        				if (j==0) {
	        					ipInfo.setButtonCheck(true);
//	        					checkBoxList.add(ipInfo);	        				
//	        				}
	        				if(!IPFMConstant.Found.equalsIgnoreCase(ipUrIpResult.getResult())){
//	        					BigDecimal notAvailable = planningReqIPService.checkIpLevel2TotalNotAvailable(ipUrIpResult.getBinary1Start(),ipUrIpResult.getBinary1End());
//	        					ipInfo.setAvailableIP(ipInfo.getTotalIP().intValue() - notAvailable.intValue());
//	        					if (ipInfo.getAvailableIP().intValue()!=ipInfo.getTotalIP().intValue()) {
//	        						ipInfo.setButtonCheck(false);
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
	        					ipInfo.setButtonCheck(false);
//	        					BigDecimal notAvailable = userReqIPService.checkIpInfoAvailable(ipInfo);
	        					//ipInfo.setAvailableIP(ipInfo.getTotalIP().intValue() - notAvailable.intValue());
	        					ipInfo.setAvailableIP(0);
//	        					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ipInfo.getResult()));
//	        					return null;
	        				}
	        				runDigit++;
	        				ipInfoList.add(ipInfo);
	        			}
	        		}
//	        	}else if (vDisplayMask.equalsIgnoreCase("32")){
//	        		int x = 0;
//	        		int subnet;
//	        		IpUrIpResult result = new IpUrIpResult();
//	        		result.setExpireDate(planningReqIPBean.getIpUrIpResult().getExpireDate());
//	        		result.setEffectiveDate(planningReqIPBean.getIpUrIpResult().getEffectiveDate());
//	        		//result.setTotalIp(totalIp);
//	        		result.setIpVersion("4");
//	        		List<IpInfo> infoList = userReqIPService.searchIpInfo(searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3());
//	        		for (int i=1 ; i<=ipMaskDisplay.getSubnet() ; i++) {
//	        			subnet = i;
//	        			for (int j=1 ; j<=ipMaskDisplay.getLength() ; j++) {
//	        				String ipAddress = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+x;
//	        				String networkIp = searchIP.getIpv4digit1()+"."+searchIP.getIpv4digit2()+"."+searchIP.getIpv4digit3()+"."+"0";
//	        				IpInfo ipInfo = newIpInfo(planningReqIPBean.getIpUrIpdetail(), result , ipAddress);
//	        				ipInfo.setNetworkIp(networkIp);
//	        				ipInfo.setSubNet(subnet);
//	        				ipInfo.setSubmask(vDisplayMask);
//	        				IpUrIpResult resultCheck1 = planningReqIPService.checkIPRange(searchIP.getIpv4digit1(),searchIP.getIpv4digit2(),searchIP.getIpv4digit3(),String.valueOf(x), "32");
//	        				if(!IPFMConstant.Found.equalsIgnoreCase(resultCheck1.getResult())){
//	        					ipInfo.setButtonCheck(true);
//	        					ipInfo.setTotalIP(1);
//		        				ipInfo.setAvailableIP(1);
//	        					ipInfo.setIpStatus("");
//		        				ipInfo.setHostName("");
//		        				ipInfo.setT2Remark("");
//	        				}else{
//	        					boolean foundIpInfo = false;
//		        				for (IpInfo ipInfoData : infoList) {
//		        					if (ipInfoData.getIpAddress().equalsIgnoreCase(ipInfo.getIpAddress())){
//		        						ipInfo.setTotalIP(1);
//				        				ipInfo.setAvailableIP(0);
//				        				ipInfo.setIpStatus(ipInfoData.getIpStatus());
//				        				ipInfo.setHostName(ipInfoData.getHostName());
//				        				ipInfo.setT2Remark(ipInfoData.getT2Remark());
//				        				foundIpInfo = true;
//				        				ipInfo.setButtonCheck(false);
//				        				break;
//		        					}
//		        				}
//		        				if (!foundIpInfo) {
//		        					ipInfo.setTotalIP(1);
//		        					ipInfo.setButtonCheck(false);		        					
//			        				ipInfo.setAvailableIP(1);
//		        					ipInfo.setIpStatus("P");
//			        				ipInfo.setHostName("");
//			        				ipInfo.setT2Remark("");
//		        				}
//	        				}
//	        				ipInfoList.add(ipInfo);
//	        				x++;
//	        			}
//	        		}
//	        	}
	        	searchIP.setIpInfoList(ipInfoList);
	        	searchIP.setVsubmask(vDisplayMask);
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
		return planningReqIPBean;
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
			String ipDigit1Binary=""; String ipDigit2Binary="";
			String ipDigit3Binary=""; String ipDigit4Binary="";
			
			try {
				ipDigit1Binary = IPFMDataUtility.convertStringToBinary(ip[0]);
				ipDigit2Binary = IPFMDataUtility.convertStringToBinary(ip[1]);
				ipDigit3Binary = IPFMDataUtility.convertStringToBinary(ip[2]);
				ipDigit4Binary = IPFMDataUtility.convertStringToBinary(ip[3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bean.setBinaryIp(ipDigit1Binary+ipDigit2Binary+ipDigit3Binary+ipDigit4Binary);
		//	System.out.println("---- setBinaryIp = "+bean.getBinaryIp());
		}else if (bean.getIpVersion()!=null && bean.getIpVersion().equalsIgnoreCase("6")) {
			bean.setIpv6digit1(new BigDecimal(ip[0])); bean.setIpv6digit2(new BigDecimal(ip[1]));
			bean.setIpv6digit3(new BigDecimal(ip[2])); bean.setIpv6digit4(new BigDecimal(ip[3]));
			bean.setIpv6digit5(new BigDecimal(ip[4])); bean.setIpv6digit6(new BigDecimal(ip[5]));
			String ipDigit1Binary=""; String ipDigit2Binary="";
			String ipDigit3Binary=""; String ipDigit4Binary="";
			String ipDigit5Binary=""; String ipDigit6Binary="";
			try {
				ipDigit1Binary = IPFMDataUtility.convertStringToBinary(ip[0]);
				ipDigit2Binary = IPFMDataUtility.convertStringToBinary(ip[1]);
				ipDigit3Binary = IPFMDataUtility.convertStringToBinary(ip[2]);
				ipDigit4Binary = IPFMDataUtility.convertStringToBinary(ip[3]);
				ipDigit5Binary = IPFMDataUtility.convertStringToBinary(ip[4]);
				ipDigit6Binary = IPFMDataUtility.convertStringToBinary(ip[5]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bean.setBinaryIp(ipDigit1Binary+ipDigit2Binary+ipDigit3Binary+ipDigit4Binary+ipDigit5Binary+ipDigit6Binary);
		}
		bean.setTotalIP(result.getTotalIp());
		bean.setEffectiveDate(result.getEffectiveDate());
		bean.setExpiredDate(result.getExpireDate());		
		return bean;
	}
	
	
	public void searchIP(){
		//System.out.println("----searchIP----");
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		planningBean = searchIPForAssign(planningBean);
		if (IPFMMessageUtils.hasMessages()) return;
		setPlanningReqIPBean(planningBean);		
	}
	
	
	public void resetSearchIP(){
		//System.out.println("----resetSearchIP----");
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		try {
			planningBean.setSearchIP(new SearchIP());
		    setPlanningReqIPBean(planningBean);
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
    
    public boolean validateAddIP(){
    	boolean flgValid = true;
			PlanningReqIPBean planningBean = getPlanningReqIPBean();
			if(IPFMUtils.ifBlank(planningBean.getCompanyComboItem().getLabel(),"").length()==0){
				if(IPFMUtils.ifBlank(planningBean.getCompanyComboItem().getValue(), "").length()==0){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
						flgValid = false;
				}
			}else{
				checkCompanyCombo();
			}
			if(IPFMUtils.ifBlank(planningBean.getIpTypeComboItem().getLabel(),"").length()==0){
				if(IPFMUtils.ifBlank(planningBean.getIpTypeComboItem().getValue(), "").length()==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Type"));
					flgValid = false;
				}
			}else{
				checkipTypeCombo();
			}
			
			checkNetworkTypeCombo();
			checkNetworkZoneCombo();
			
			if("".equals(planningBean.getIpUrIpResult().getEffectiveDate())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Effective Date"));
				flgValid = false;
			}
			if("".equals(planningBean.getIpUrIpResult().getExpireDate())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
				flgValid = false;
			}
			if(planningBean.getIpUrIpResult().getEffectiveDate().after(planningBean.getIpUrIpResult().getExpireDate()) ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
				flgValid = false;
			}
//			if("".equals(planningBean.getIpUrIpResult().getIpDigit1()) && "".equals(planningBean.getIpUrIpResult().getIpDigit2()) 
//			   && "".equals(planningBean.getIpUrIpResult().getIpDigit3())&& "".equals(planningBean.getIpUrIpResult().getIpDigit4()) 
//			   && "".equals(planningBean.getIpUrIpResult().getMask())){
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP"));
//				flgValid = false;
//			}
			if(IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getIpDigit1(),"").trim().length()==0 
					|| IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getIpDigit2(),"").trim().length()==0 
					|| IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getIpDigit3(),"").trim().length()==0 
					|| IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getIpDigit4(),"").trim().length()==0 ){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
				flgValid = false;
			}
			if (IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getMask(),"").trim().length()>0) {
				if (Integer.parseInt(IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getMask(),"").trim()) < 8 || 
					Integer.parseInt(IPFMUtils.ifBlank(planningBean.getIpUrIpResult().getMask(),"").trim())>32 ){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
					flgValid = false;
				}
			}
    	return flgValid;
    }
    
    public boolean validateAssignIPInfo(){
    	boolean flgValid = true;
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		if(IPFMUtils.ifBlank(planningBean.getCompanyComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(planningBean.getCompanyComboItem().getValue(), "").length()==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
					flgValid = false;
			}
		}else{
			checkCompanyCombo();
		}
		if(IPFMUtils.ifBlank(planningBean.getIpTypeComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(planningBean.getIpTypeComboItem().getValue(), "").length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Type"));
				flgValid = false;
			}
		}else{
			checkipTypeCombo();
		}
		
		checkNetworkTypeCombo();
		checkNetworkZoneCombo();

		if (planningBean.getIpUrIpResult().getNetworkIp()!=null && planningBean.getIpUrIpResult().getNetworkIp().trim().length()>0) {
			if (!IPFMDataValidateUtil.validateIPFormat(planningBean.getIpUrIpResult().getNetworkIp())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Network IP"));
				flgValid = false;
			}
		}
		if (planningBean.getIpUrIpResult().getGateway()!=null && planningBean.getIpUrIpResult().getGateway().trim().length()>0) {
			if (!IPFMDataValidateUtil.validateIPFormat(planningBean.getIpUrIpResult().getGateway())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Gateway"));
				flgValid = false;
			}
		}
		
		if("".equals(planningBean.getIpUrIpResult().getEffectiveDate())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Effective Date"));
			flgValid = false;
		}
		if("".equals(planningBean.getIpUrIpResult().getExpireDate())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire Date"));
			flgValid = false;
		}
    	
    	return flgValid;
    }
    
	public void validateAssignInfo(IpUrIpResult ipUrIpResult, ExcelErrorMsg excelMsg) {

		if (IPFMUtils.ifBlank(ipUrIpResult.getIpVersion(), "").trim().length()==0) {
			addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
		}
		if (IPFMUtils.ifBlank(ipUrIpResult.getIp(), "").trim().length()==0){
			addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
		}
		if (IPFMUtils.ifBlank(ipUrIpResult.getIpDigit1(), "").trim().length()==0 
				|| IPFMUtils.ifBlank(ipUrIpResult.getIpDigit2(), "").trim().length()==0 
				|| IPFMUtils.ifBlank(ipUrIpResult.getIpDigit3(), "").trim().length()==0
				|| IPFMUtils.ifBlank(ipUrIpResult.getIpDigit4(), "").trim().length()==0
				|| IPFMUtils.ifBlank(ipUrIpResult.getMask(), "").trim().length()==0) {
			addErrorMsg(excelMsg, IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0031"), "IP Address"));
		}
	}
    
	@Override
	public boolean validate() {
		boolean flgValid = true;
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		if("".equals(planningBean.getIpUrIpdetail().getSubject())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Subject"));
				flgValid = false;
		}
//		if(planningBean.getSystemOwnerComboItem()==null){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SystemOwner"));
//			flgValid = false;
//		}
//		if(planningBean.getSystemOwnerTeamComboItem()==null){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SystemOwnerTeam"));
//			flgValid = false;
//		}
		if (IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSysOwnerName(),"").length()>0 && planningBean.getIpUrIpdetail().getSysOwnerId().equalsIgnoreCase("")) {
			//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0076"), planningBean.getIpUrIpdetail().getSysOwnerName()));
			flgValid = false;
		}
		if (IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSysOwnerId(),"").length()==0 && IPFMUtils.ifBlank(planningBean.getSystemOwnerTeamComboItem().getValue(),"").length()>0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner"));
			flgValid = false;
		}
		if (IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSysOwnerId(),"").length()>0 && IPFMUtils.ifBlank(planningBean.getSystemOwnerTeamComboItem().getValue(),"").length()==0) {
			if(IPFMUtils.ifBlank(planningBean.getSystemOwnerTeamComboItem().getLabel(),"").length()>0){
//				PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
//				try {
//					IpTeam ipTeam = planningReqIPService.findIpTeamById(planningBean.getSystemOwnerTeamComboItem().getLabel());
//					if ((ipTeam==null) || (ipTeam!=null && ipTeam.getTier2Team().equalsIgnoreCase("Y"))) {
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0099"), planningBean.getIpUrIpdetail().getSysOwnerName()));
//						flgValid = false;
//					}
//				} catch (IPFMBusinessException e) {
//					e.printStackTrace();
//				}
//				checkSystemTeamOwenCombo();
			}else{
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner Team "));
				flgValid = false;
			}
		}
		
		if("".equals(planningBean.getIpUrIpdetail().getNwSysDetail())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network System Requirement"));
			flgValid = false;
		}
		if(IPFMUtils.ifBlank(planningBean.getNwTypeComboItem().getLabel(),"").length()==0){
			if(IPFMUtils.ifBlank(planningBean.getNwTypeComboItem().getValue(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Type"));
				flgValid = false;
			}
		}else{
			checkNetworkTypeCombo();
		}
		if("".equals(planningBean.getIpUrIpdetail().getReqType())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Request Type"));
			flgValid = false;
		}/*else{
			
			if (planningBean.getIpUrIpdetail().getReqType().equalsIgnoreCase("N")) {
				if(planningBean.getNwZoneComboItem()==null || IPFMUtils.ifBlank(planningBean.getNwZoneComboItem().getValue(),"").trim().length()==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Zone Name"));
					flgValid = false;
				}
			}else if (planningBean.getIpUrIpdetail().getReqType().equalsIgnoreCase("E")) {
				if(planningBean.getNwZoneComboItem()==null || IPFMUtils.ifBlank(planningBean.getNwZoneComboItem().getValue(),"").trim().length()==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Existing Network Zone"));
					flgValid = false;
				}
				if(IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getIpRef(),"").trim().length()==0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Existing IP Network Ref"));
					flgValid = false;
				}
			}
			if(IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getSystemPlane(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network System Plane"));
				flgValid = false;
			}
			if(IPFMUtils.ifBlank(planningBean.getIpUrIpdetail().getUserPlane(),"").trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "User Plane"));
				flgValid = false;
			}
		}*/
		
		checkNetworkZoneCombo();
		
		if(planningBean.getIpUrIpdetail().getTotalNode()!=null && planningBean.getIpUrIpdetail().getTotalNode().intValue()==0
			&& planningBean.getIpUrIpdetail().getClassB()!=null && planningBean.getIpUrIpdetail().getClassB().intValue()==0
			&& planningBean.getIpUrIpdetail().getClassC()!=null && planningBean.getIpUrIpdetail().getClassC().intValue()==0 ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Size"));
			flgValid = false;
		}
		
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
	
	public void uploadComplete(){
		System.out.println("====== uploadComplete ======");
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		UserReqIPService userReqIPService = (UserReqIPService)JSFServiceFinderUtil.getInstance().getBean("userReqIPService");
		List<IpUrAttachment> ipUrAttachmentList;
		try {
			ipUrAttachmentList = userReqIPService.getIpUrAttachmentList(planningBean.getIpUrIpdetail().getUrNo(),planningBean.getAttachType());
			 planningBean.setIpUrAttachmentList(ipUrAttachmentList);
			
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void popupAttachFile(){
		PlanningReqIPBean planningBean = getPlanningReqIPBean();
		try {
			String attachType = getRequestParameter("attachType");
			System.out.println(attachType);
			planningBean.setAttachType(attachType);			
		    setPlanningReqIPBean(planningBean);
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
		}
	}
	public void suggestSysOwner() throws Exception{
		PlanningReqIPBean bean = getPlanningReqIPBean();
		if (bean.getSuggestSystemOwner().getRowIndex() < 0){
//			bean.setSystemOwnerTeamList(new ArrayList<SelectItem>());
			bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(null,null));
			bean.getIpUrIpdetail().setSysOwnerId("");
			bean.getIpUrIpdetail().setSysOwnerTeamId("");
			bean.getIpUrIpdetail().setSysOwnerTeamName("");
			bean.setSysOwnerTeamId("");
		}else{
//			bean.setSystemOwnerTeamList(bean.getNewSystemOwnerTeamList());
			SelectItem item = (SelectItem)bean.getSuggestSystemOwner().getRowData();
			IPFMRichComboItem combo = (IPFMRichComboItem)item.getValue();
			bean.getIpUrIpdetail().setSysOwnerId(combo.getValue());
			bean.getIpUrIpdetail().setSysOwnerName(combo.getLabel());
			
			PlanningReqIPService planningReqIPService = (PlanningReqIPService)JSFServiceFinderUtil.getInstance().getBean("planningReqIPService");
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
					if (profile.getORGNAME()!=null && profile.getORGNAME().trim().length()>0) {
						bean.getIpUrIpdetail().setSysOwnerTeamId(IPFMUtils.ifBlank(profile.getORGNAME(),""));
						bean.getIpUrIpdetail().setSysOwnerTeamName(IPFMUtils.ifBlank(profile.getORGNAME(),""));
//					if (profile.getScname()!=null && profile.getScname().trim().length()>0) {
//						bean.getIpUrIpdetail().setSysOwnerTeamId(IPFMUtils.ifBlank(profile.getScname(),""));
//						bean.getIpUrIpdetail().setSysOwnerTeamName(IPFMUtils.ifBlank(profile.getScname(),""));
					}else if (profile.getDPNAME()!=null && profile.getDPNAME().trim().length()>0) {
						bean.getIpUrIpdetail().setSysOwnerTeamId(IPFMUtils.ifBlank(profile.getDPNAME(),""));
						bean.getIpUrIpdetail().setSysOwnerTeamName(IPFMUtils.ifBlank(profile.getDPNAME(),""));
					}else{
						bean.getIpUrIpdetail().setSysOwnerTeamId("NA");
						bean.getIpUrIpdetail().setSysOwnerTeamName("NA");
					}
				}
			
				IpTeam ipTeam = planningReqIPService.findIpTeamById(bean.getIpUrIpdetail().getSysOwnerTeamId());
				if (ipTeam!=null){
					if (ipTeam.getTier2Team()==null || !ipTeam.getTier2Team().equalsIgnoreCase("Y")) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0099"), bean.getIpUrIpdetail().getSysOwnerName()));
						bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem());
//						bean.getIpUrIpdetail().setSysOwnerId("");
//						bean.getIpUrIpdetail().setSysOwnerName("");
						bean.getIpUrIpdetail().setSysOwnerTeamId("");
						bean.getIpUrIpdetail().setSysOwnerTeamName("");
						bean.setSysOwnerTeamId("");
					}else{
						bean.getIpUrIpdetail().setSysOwnerTeamId(ipTeam.getTeamId());
						bean.getIpUrIpdetail().setSysOwnerTeamName(ipTeam.getTeamName());
						bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(ipTeam.getTeamId(),ipTeam.getTeamName()));
						bean.setSysOwnerTeamId(ipTeam.getTeamId());
					}
				}else{
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0099"), bean.getIpUrIpdetail().getSysOwnerName()));
					bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem());
//					bean.getIpUrIpdetail().setSysOwnerId("");
//					bean.getIpUrIpdetail().setSysOwnerName("");
					bean.getIpUrIpdetail().setSysOwnerTeamId("");
					bean.getIpUrIpdetail().setSysOwnerTeamName("");
					bean.setSysOwnerTeamId("");
//					bean.setSysOwnerTeamId(bean.getIpUrIpdetail().getSysOwnerTeamName());
//					bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpdetail().getSysOwnerTeamName(),bean.getIpUrIpdetail().getSysOwnerTeamName()));
//					bean.getSystemOwnerTeamList().add(new SelectItem(new IPFMRichComboItem(bean.getIpUrIpdetail().getSysOwnerTeamName(),bean.getIpUrIpdetail().getSysOwnerTeamName()),bean.getIpUrIpdetail().getSysOwnerTeamName()));
				}
			}else{
				IpTeam ipTeam = planningReqIPService.findIpTeamById(ipUser.getTeamId());
				if (ipTeam!=null){
					if (ipTeam.getTier2Team()==null || !ipTeam.getTier2Team().equalsIgnoreCase("Y")) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0099"), bean.getIpUrIpdetail().getSysOwnerName()));
						bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem());
//						bean.getIpUrIpdetail().setSysOwnerId("");
//						bean.getIpUrIpdetail().setSysOwnerName("");
						bean.getIpUrIpdetail().setSysOwnerTeamId("");
						bean.getIpUrIpdetail().setSysOwnerTeamName("");
						bean.setSysOwnerTeamId("");
					}else{
						bean.getIpUrIpdetail().setSysOwnerTeamId(ipUser.getTeamId());
						bean.getIpUrIpdetail().setSysOwnerTeamName(ipUser.getTeamName());
						bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem(bean.getIpUrIpdetail().getSysOwnerTeamId(),bean.getIpUrIpdetail().getSysOwnerTeamName()));
					}
				}else{
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0099"), bean.getIpUrIpdetail().getSysOwnerName()));
					bean.setSystemOwnerTeamComboItem(new IPFMRichComboItem());
//					bean.getIpUrIpdetail().setSysOwnerId("");
//					bean.getIpUrIpdetail().setSysOwnerName("");
					bean.getIpUrIpdetail().setSysOwnerTeamId("");
					bean.getIpUrIpdetail().setSysOwnerTeamName("");
					bean.setSysOwnerTeamId("");
				}
			}
		}
		setPlanningReqIPBean(bean);
	}
	public List<SelectItem> userSuggestion(Object event) throws Exception{
		if (event.toString()==null) return new ArrayList<SelectItem>();
		return getUserListSelectItem(event.toString());
	}
	private List<SelectItem> getUserListSelectItem(String userName) throws Exception{
		AuthenDBService authService = (AuthenDBService)JSFServiceFinderUtil.getInstance().getBean("authService");
		EmployeeProfileService2 ehrService = (EmployeeProfileService2)JSFServiceFinderUtil.getInstance().getBean("ehrService2");
		List<SelectItem> userListSelectItem = new ArrayList<SelectItem>();
		try {
			if (IPFMUtils.ifBlank(userName, "").trim().length()==0) return userListSelectItem;
//			Long startTime = System.currentTimeMillis();
			
			UserAccount authUser = authService.getAuthenUserConfig();
			List<EmployeeProfileOM> userList = ehrService.getEmployeeProfileByPrefixEngName(authUser, userName+"%");
			
//			Long endTime = System.currentTimeMillis();
//			System.out.println("call time = "+ new Double((endTime-startTime)/1000D));
			IPFMRichComboItem cbitem;
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
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			throw ipfme;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userListSelectItem;
	}
	
	public void checkSystemTeamOwenCombo(){
		PlanningReqIPBean bean = getPlanningReqIPBean();
            if((bean.getSystemOwnerTeamComboItem().getValue()==null) && bean.getSystemOwnerTeamComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "System Owner Team"));
			}
	}
	
	public void checkNetworkTypeCombo(){
		PlanningReqIPBean bean = getPlanningReqIPBean();
            if((bean.getNwTypeComboItem().getValue()==null) && bean.getNwTypeComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Type"));
			}
	}
	public void checkNetworkZoneCombo(){
		PlanningReqIPBean bean = getPlanningReqIPBean();
            if((bean.getNwZoneComboItem().getValue()==null) && bean.getNwZoneComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Zone Name"));
			}
	}
	public void checkCompanyCombo(){
		PlanningReqIPBean bean = getPlanningReqIPBean();
            if((bean.getCompanyComboItem().getValue()==null) && bean.getCompanyComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Company"));
			}
	}
	
	public void checkipTypeCombo(){
		PlanningReqIPBean bean = getPlanningReqIPBean();
            if((bean.getIpTypeComboItem().getValue()==null) && bean.getIpTypeComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "IP Type"));
			}
	}
	
	
	
	
}
