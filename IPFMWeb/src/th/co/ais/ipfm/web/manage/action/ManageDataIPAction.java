package th.co.ais.ipfm.web.manage.action;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IIPParameterService;
import th.co.ais.ipfm.service.ManageDataIPService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.vo.IPDetailVO;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.ManageDataIPBean;
import th.co.ais.ipfm.web.util.IPFMComboBoxUtil;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;



public class ManageDataIPAction extends AbstractAction {
	
	/********************** Bean ***********************/
	public ManageDataIPBean manageDataIPBean;


	public ManageDataIPBean getManageDataIPBean() {
		return (ManageDataIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("manageDataIPBean");
	}

	public void setManageDataIPBean(ManageDataIPBean manageDataIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("manageDataIPBean", manageDataIPBean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		manageDataIPBean = getManageDataIPBean();		
		if(TablSort.equalsIgnoreCase("IPDataTable")) {
			manageDataIPBean.setSortIpUrs001(sortColumnChange());	
		} else if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			manageDataIPBean.setSortIpUrs003(sortColumnChange());	
		} 
		
		
		return "";
	}
	
	@Override
	public String init(String programID) {
	//public String init() {
		IIPParameterService ipParameterService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
		IPParameter ipParameter = null;
		if(ipParameterService!=null ){
			try {
		        
				initDropDown();
				ipParameter = ipParameterService.getIPVersion();
				
				ManageDataIPBean manageDataIPBean = getManageDataIPBean();
 				manageDataIPBean.setIpVersion(ipParameter.getNumericValue().toString());
				setManageDataIPBean(manageDataIPBean);
				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		//return "IPURS003_01";
		return programID;
	}
	
	public void search(){
		ManageDataIPBean manageDataIPBean = getManageDataIPBean();
		IPDetailVO ipDetailDTO = new IPDetailVO(); 
		SearchResult searchResult = null;
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		UserSession userSession = (UserSession) session.getAttribute(IPFMWebUtil.USER_SESSION);
		
		if(manageDataIPBean!=null){
			List<IPDetail> ipDetailList = null;
			ManageDataIPService manageDataIPService = (ManageDataIPService)JSFServiceFinderUtil.getInstance().getBean("manageDataIPService");
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			try {
				
				//IP Address
				ipDetailDTO.setStIp1(manageDataIPBean.getStIp1());
				ipDetailDTO.setStIp2(manageDataIPBean.getStIp2());
				ipDetailDTO.setStIp3(manageDataIPBean.getStIp3());
				ipDetailDTO.setStIp4(manageDataIPBean.getStIp4());
				ipDetailDTO.setStIp5(manageDataIPBean.getStIp5());
				ipDetailDTO.setStIp6(manageDataIPBean.getStIp6());
				ipDetailDTO.setEdIp1(manageDataIPBean.getEdIp1());
				
				if(manageDataIPBean.getIpStatusComboItem()!=null){
					ipDetailDTO.setIpStatusId(manageDataIPBean.getIpStatusComboItem().getValue());
				}
				if(manageDataIPBean.getLocationComboItem()!=null){
					ipDetailDTO.setLocationId(manageDataIPBean.getLocationComboItem().getValue());
				}
				if(manageDataIPBean.getNetworkZoneComboItem()!=null){
					ipDetailDTO.setNetworkZoneId(manageDataIPBean.getNetworkZoneComboItem().getValue());
				}
				if(manageDataIPBean.getRequestFromTeamComboItem()!=null){	
					ipDetailDTO.setReqestFromTeamId(manageDataIPBean.getRequestFromTeamComboItem().getValue());
				}
				if(manageDataIPBean.getNetworkTypeComboItem()!=null){
					ipDetailDTO.setNetworkType(manageDataIPBean.getNetworkTypeComboItem().getLabel());
				}
				ipDetailDTO.setHostName(manageDataIPBean.getHostName());
				ipDetailDTO.setUrRefer(manageDataIPBean.getUrRefer());
				ipDetailDTO.setProjectId(manageDataIPBean.getProjectId());
				ipDetailDTO.setProjectManager(manageDataIPBean.getProjectManager());
				ipDetailDTO.setEffDateFrom(manageDataIPBean.getEffDateFrom());
				ipDetailDTO.setEffDateTo(manageDataIPBean.getEffDateTo());
				ipDetailDTO.setExpDateFrom(manageDataIPBean.getExpDateFrom());
				ipDetailDTO.setExpDateTo(manageDataIPBean.getExpDateTo());
				
				ipDetailDTO.setTier1TeamId(manageDataIPBean.getUserTeamId());
				ipDetailDTO.setTier2TeamId(manageDataIPBean.getUserTeamId());
				ipDetailDTO.setTier3TeamId(manageDataIPBean.getUserTeamId());
				
				ipDetailDTO.setIpVersion(manageDataIPBean.getIpVersion());
				
				
				searchResult = manageDataIPService.search(ipDetailDTO,ipfmConfigBean.getMaxSearchResult());
				if(searchResult.isOverMaxResultLimit()){
					IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0014")));	
				}
				manageDataIPBean.setDisPlaySearchResult(true);
//				manageDataIPBean.setTier1TeamId(userSession.getIpUser().getUserTeamId());
//				manageDataIPBean.setTier2TeamId(userSession.getIpUser().getUserTeamId());
//				manageDataIPBean.setTier3TeamId(userSession.getIpUser().getUserTeamId());
				manageDataIPBean.setIpDetailList(searchResult.getResultList());
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 setManageDataIPBean(manageDataIPBean);
		}
	}
		
	public String initIPDetailAdd() {
			ManageDataIPBean manageDataIPBean = getManageDataIPBean();
			
			manageDataIPBean.setIpDetail(new IPDetail());	
			//Flag MODE Button
			manageDataIPBean.setDisplayForCreate(true);
			manageDataIPBean.setDisplayForEdit(false);
			manageDataIPBean.setDisplayForQueryButton(true);
			
			setManageDataIPBean(manageDataIPBean);
			
	return "IPURS003_02";
	}
	
	public void searchIPDetail(){
		ManageDataIPBean manageDataIPBean = getManageDataIPBean();
		IPDetailVO ipDetailDTO = new IPDetailVO();
		String ipAddress="";
		
		if(manageDataIPBean!=null){
			IPDetail ipDetail = null;
			ManageDataIPService manageDataIPService = (ManageDataIPService)JSFServiceFinderUtil.getInstance().getBean("manageDataIPService");			
			try {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
				UserSession userSession = (UserSession) session.getAttribute(IPFMWebUtil.USER_SESSION);
				
				if("6".equals(manageDataIPBean.getIpVersion())){
					
					ipAddress = manageDataIPBean.getStIp1()+"."+manageDataIPBean.getStIp2()+"."+
					            manageDataIPBean.getStIp3()+"."+manageDataIPBean.getStIp4()+"."+
					            manageDataIPBean.getStIp5()+"."+manageDataIPBean.getStIp6();
				}
				else{
					ipAddress = manageDataIPBean.getStIp1()+"."+manageDataIPBean.getStIp2()+"."+
					            manageDataIPBean.getStIp3()+"."+manageDataIPBean.getStIp4();
				}

				ipDetailDTO.setIpAddress(ipAddress);
//                ipDetailDTO.setTier1TeamId(userSession.getIpUser().getUserTeamId());
//                ipDetailDTO.setTier2TeamId(userSession.getIpUser().getUserTeamId());
//                ipDetailDTO.setTier3TeamId(userSession.getIpUser().getUserTeamId());
                
				ipDetail = manageDataIPService.searchIPDetail(ipDetailDTO);
				
				if(ipDetail!=null){
//					manageDataIPBean.setTier1TeamId(userSession.getIpUser().getUserTeamId());
					controlTextEdit();
					manageDataIPBean.setIpDetail(ipDetail);
					manageDataIPBean.setDisplayForCreate(false);
					manageDataIPBean.setDisplayForEdit(true);
					manageDataIPBean.setDisplayForQueryButton(false);
				}else{	
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0003")));
				}

			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 setManageDataIPBean(manageDataIPBean);
		}
	}
	
	public String initUpdate(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		ManageDataIPService manageDataIPService = (ManageDataIPService)JSFServiceFinderUtil.getInstance().getBean("manageDataIPService");	
		if(manageDataIPService!=null && rowId!=null){
			try {
				controlTextEdit();
				IPDetail ipDetail = manageDataIPService.getIPDetail(rowId);
				
				ManageDataIPBean manageDataIPBean = getManageDataIPBean(); 
				String[] stIp=null;
				if("6".equals(manageDataIPBean.getIpVersion())){
					stIp = ipDetail.getIpAddress().split("\\.");
					manageDataIPBean.setStIp1(stIp[0]);
					manageDataIPBean.setStIp2(stIp[1]);
					manageDataIPBean.setStIp3(stIp[2]);
					manageDataIPBean.setStIp4(stIp[3]);
					manageDataIPBean.setStIp5(stIp[4]);
					manageDataIPBean.setStIp6(stIp[5]);				
				}else{
					stIp = ipDetail.getIpAddress().split("\\.");
					manageDataIPBean.setStIp1(stIp[0]);
					manageDataIPBean.setStIp2(stIp[1]);
					manageDataIPBean.setStIp3(stIp[2]);
					manageDataIPBean.setStIp4(stIp[3]);
				}
				
				IPFMRichComboItem ipStatus = new IPFMRichComboItem();
				IPFMRichComboItem company = new IPFMRichComboItem();
				IPFMRichComboItem location = new IPFMRichComboItem();
				IPFMRichComboItem piority = new IPFMRichComboItem();
				IPFMRichComboItem install = new IPFMRichComboItem();
				IPFMRichComboItem networkZone = new IPFMRichComboItem();
				IPFMRichComboItem networkType = new IPFMRichComboItem();
				IPFMRichComboItem reqestFromTeam = new IPFMRichComboItem();
				IPFMRichComboItem ipType = new IPFMRichComboItem();
				
				ipStatus.setValue(ipDetail.getIpStatusId());
				ipStatus.setLabel(ipDetail.getIpStatusName());
				company.setValue(ipDetail.getCompanyId());
				company.setLabel(ipDetail.getCompanyName());				
				location.setValue(ipDetail.getLocationId());
				location.setLabel(ipDetail.getLocationName());
				piority.setValue(ipDetail.getPiority());
				piority.setLabel(ipDetail.getPiority());
				install.setValue(ipDetail.getInstallId());
				install.setLabel(ipDetail.getInstallTypeName());
				networkZone.setValue(ipDetail.getNetworkZoneId());
				networkZone.setLabel(ipDetail.getNetworkZoneName());
				networkType.setValue(ipDetail.getNetworkType());
				networkType.setLabel(ipDetail.getNetworkType());
				reqestFromTeam.setValue(ipDetail.getReqestFromTeamId());
				reqestFromTeam.setLabel(ipDetail.getRequestFromTeamName());
				ipType.setValue(ipDetail.getIpType());
				ipType.setLabel(ipDetail.getIpType());
				
				manageDataIPBean.setIpStatusComboItem(ipStatus);   
     			manageDataIPBean.setCompanyComboItem(company); 
				manageDataIPBean.setLocationComboItem(location); 
				manageDataIPBean.setPiorityComboItem(piority); 
				manageDataIPBean.setInstallComboItem(install); 
				manageDataIPBean.setNetworkZoneComboItem(networkZone); 
				manageDataIPBean.setNetworkTypeComboItem(networkType);
				manageDataIPBean.setRequestFromTeamComboItem(reqestFromTeam); 
				manageDataIPBean.setIpTypeComboItem(ipType);
				
				manageDataIPBean.setIpDetail(ipDetail);
				manageDataIPBean.setIpDetailList(null);
				manageDataIPBean.setRowId(rowId);
				
				manageDataIPBean.setDisplayForCreate(false);
				manageDataIPBean.setDisplayForEdit(true);
				manageDataIPBean.setDisplayForQueryButton(false);
				
				setManageDataIPBean(manageDataIPBean);				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return "IPURS003_02";
	}
	
	
	public void updateIPDetail(){
		try {
			if(validate()){
				ManageDataIPService manageDataIPService = (ManageDataIPService)JSFServiceFinderUtil.getInstance().getBean("manageDataIPService");
				ManageDataIPBean manageDataIPBean = getManageDataIPBean(); 
						IPDetail ipDetail = manageDataIPBean.getIpDetail();	
						
						if(manageDataIPBean.getIpStatusComboItem()!=null){
							ipDetail.setIpStatusId(manageDataIPBean.getIpStatusComboItem().getValue());
							ipDetail.setIpStatusName(manageDataIPBean.getIpStatusComboItem().getLabel());	
						}
						if(manageDataIPBean.getLocationComboItem()!=null){
							ipDetail.setLocationId(manageDataIPBean.getLocationComboItem().getValue());
							ipDetail.setLocationName(manageDataIPBean.getLocationComboItem().getLabel());
						}
                        if(manageDataIPBean.getInstallComboItem()!=null){
    						ipDetail.setInstallId(manageDataIPBean.getInstallComboItem().getValue());
    						ipDetail.setInstallTypeName(manageDataIPBean.getInstallComboItem().getLabel());
                        }
					    if(manageDataIPBean.getPiorityComboItem()!=null){
					    	ipDetail.setPiority(manageDataIPBean.getPiorityComboItem().getLabel());
					    }
						if(manageDataIPBean.getNetworkZoneComboItem()!=null){
							ipDetail.setNetworkZoneId(manageDataIPBean.getNetworkZoneComboItem().getValue());
							ipDetail.setNetworkZoneName(manageDataIPBean.getNetworkZoneComboItem().getLabel());
						}
						if(manageDataIPBean.getNetworkTypeComboItem()!=null){
							ipDetail.setNetworkType(manageDataIPBean.getNetworkTypeComboItem().getLabel());
						}
                        if(manageDataIPBean.getRequestFromTeamComboItem()!=null){
    						ipDetail.setReqestFromTeamId(manageDataIPBean.getRequestFromTeamComboItem().getValue());
    						ipDetail.setRequestFromTeamName(manageDataIPBean.getRequestFromTeamComboItem().getLabel());
                        }
					    if(manageDataIPBean.getCompanyComboItem()!=null){
							ipDetail.setCompanyId(manageDataIPBean.getCompanyComboItem().getValue());
							ipDetail.setCompanyName(manageDataIPBean.getCompanyComboItem().getLabel());
					    }
						if(manageDataIPBean.getIpTypeComboItem()!=null){
							ipDetail.setIpType(manageDataIPBean.getIpTypeComboItem().getLabel());
						}
	
						manageDataIPService.updateIpDetail(ipDetail);
						manageDataIPBean.setIpDetail(null);
						manageDataIPBean.setDisplayForEdit(false);
						manageDataIPBean.setDisplayForCreate(true);
						manageDataIPBean.setDisplayForQueryButton(true);
						controlTextAdd(true);
						manageDataIPBean.setDisplayForQueryButton(true);
						manageDataIPBean.setDisplayForQueryButton(true);
						
						manageDataIPBean.setStIp1("");
						manageDataIPBean.setStIp2("");
						manageDataIPBean.setStIp3("");
						manageDataIPBean.setStIp4("");
						manageDataIPBean.setStIp5("");
						manageDataIPBean.setStIp6("");
						manageDataIPBean.setIpStatusComboItem(null);
						manageDataIPBean.setCompanyComboItem(null);
						manageDataIPBean.setLocationComboItem(null);
						manageDataIPBean.setPiorityComboItem(null);
						manageDataIPBean.setInstallComboItem(null);
						manageDataIPBean.setNetworkZoneComboItem(null);
						manageDataIPBean.setNetworkTypeComboItem(null);
						manageDataIPBean.setRequestFromTeamComboItem(null);
						manageDataIPBean.setIpTypeComboItem(null);
						
						setManageDataIPBean(manageDataIPBean);
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
		} catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}	
	
	public void initDropDown(){
				List<SelectItem> ipStatusStringList = IPFMComboBoxUtil.getInstance().getIPStatusComboBoxItems();
				List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
				List<SelectItem> zoneStringList = IPFMComboBoxUtil.getInstance().getZoneComboBoxItems();
				List<SelectItem> nwTypeStringList = IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems();
				List<SelectItem> t2TeamStringList = IPFMComboBoxUtil.getInstance().getTier2TeamComboBoxItems();
				List<SelectItem> companyStringList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
				List<SelectItem> priorityStringList = IPFMComboBoxUtil.getInstance().getPriorityComboBoxItems();
				List<SelectItem> installTypeStringList = IPFMComboBoxUtil.getInstance().getInstallTypeComboBoxItems();
				List<SelectItem> ipTypeStringList = IPFMComboBoxUtil.getInstance().getIPTypeListComboBoxItems();
				
 				ManageDataIPBean manageDataIPBean = new ManageDataIPBean();
 				manageDataIPBean.setIpStatusList(ipStatusStringList);
 				manageDataIPBean.setLocatList(locatStringList);
 				manageDataIPBean.setZoneList(zoneStringList);
 				manageDataIPBean.setNwTypeList(nwTypeStringList);
 				manageDataIPBean.setT2TeamList(t2TeamStringList);
 				
 				manageDataIPBean.setCompanyList(companyStringList);
 				manageDataIPBean.setPriorityList(priorityStringList);
 				manageDataIPBean.setInstallTypeList(installTypeStringList);
 				manageDataIPBean.setIpTypeList(ipTypeStringList);
 				
				setManageDataIPBean(manageDataIPBean);
	}	
	public void controlTextAdd(boolean flag){
		ManageDataIPBean manageDataIPBean = getManageDataIPBean(); 
			manageDataIPBean.setDisabledTextIpSts(flag);
			manageDataIPBean.setDisabledTextCompany(flag);
			manageDataIPBean.setDisabledTextLocation(flag);
			manageDataIPBean.setDisabledTextPriority(flag);
			manageDataIPBean.setDisabledTextInstallType(flag);
			manageDataIPBean.setDisabledTextMask(flag);
			manageDataIPBean.setDisabledTextNetworkZone(flag);
			manageDataIPBean.setDisabledTextNetwork(flag);
			manageDataIPBean.setDisabledTextGateway(flag);
			manageDataIPBean.setDisabledTextMacAdress(flag);
			manageDataIPBean.setDisabledTextHostName(flag);
			manageDataIPBean.setDisabledTextSystemName(flag);
			manageDataIPBean.setDisabledTextNetworkType(flag);
			manageDataIPBean.setDisabledTextVipIp(flag);
			manageDataIPBean.setDisabledTextVlanId(flag);
			manageDataIPBean.setDisabledTextDnsName(flag);
			manageDataIPBean.setDisabledTextTire1Remark(flag);
			manageDataIPBean.setDisabledTextIpType(flag);
			manageDataIPBean.setDisabledTextFloor(flag);
			manageDataIPBean.setDisabledTextProjectID(flag);
			manageDataIPBean.setDisabledTextProjectName(flag);
			manageDataIPBean.setDisabledTextProjectManager(flag);
			manageDataIPBean.setDisabledTextEffectiveDate(flag);
			manageDataIPBean.setDisabledTextExpireDate(flag);
			manageDataIPBean.setDisabledTextSystemOwnerID(flag);
			manageDataIPBean.setDisabledTextSystemOwnerName(flag);
			manageDataIPBean.setDisabledTextSystemOwnerTeam(flag);
   	        manageDataIPBean.setDisabledTextRequestFromTeam(flag);
			manageDataIPBean.setDisabledTextUrRefer(flag);
			manageDataIPBean.setDisabledTextTire2Remark(flag);
			manageDataIPBean.setDisabledTextTire3Remark(flag);
			manageDataIPBean.setDisabledTextServiceDetail(flag);
		    setManageDataIPBean(manageDataIPBean);
}	
	
	public void controlTextEdit(){

			ManageDataIPBean manageDataIPBean = getManageDataIPBean(); 
			String userLevel = manageDataIPBean.getTier1TeamId().substring(0,2);
			if("T1".equals(userLevel)){
				manageDataIPBean.setDisabledTextIpSts(false);
				manageDataIPBean.setDisabledTextCompany(false);
				manageDataIPBean.setDisabledTextLocation(false);
				manageDataIPBean.setDisabledTextPriority(false);
				manageDataIPBean.setDisabledTextInstallType(false);
				manageDataIPBean.setDisabledTextMask(false);
				manageDataIPBean.setDisabledTextNetworkZone(false);
				manageDataIPBean.setDisabledTextNetwork(false);
				manageDataIPBean.setDisabledTextGateway(false);
				manageDataIPBean.setDisabledTextMacAdress(false);
				manageDataIPBean.setDisabledTextHostName(false);
				manageDataIPBean.setDisabledTextSystemName(false);
				manageDataIPBean.setDisabledTextNetworkType(false);
				manageDataIPBean.setDisabledTextVipIp(false);
				manageDataIPBean.setDisabledTextVlanId(false);
				manageDataIPBean.setDisabledTextDnsName(false);
				manageDataIPBean.setDisabledTextTire1Remark(false);
				manageDataIPBean.setDisabledTextIpType(false);
				manageDataIPBean.setDisabledTextFloor(false);
				manageDataIPBean.setDisabledTextProjectID(false);
				manageDataIPBean.setDisabledTextProjectName(false);
				manageDataIPBean.setDisabledTextProjectManager(false);
				manageDataIPBean.setDisabledTextEffectiveDate(false);
				manageDataIPBean.setDisabledTextExpireDate(false);
				manageDataIPBean.setDisabledTextSystemOwnerID(false);
				manageDataIPBean.setDisabledTextSystemOwnerName(false);
				manageDataIPBean.setDisabledTextSystemOwnerTeam(false);
			}else if("T2".equals(userLevel)){
				manageDataIPBean.setDisabledTextIpSts(false);	
				manageDataIPBean.setDisabledTextPriority(false);
				manageDataIPBean.setDisabledTextNetworkZone(false);
				manageDataIPBean.setDisabledTextNetwork(false);
				manageDataIPBean.setDisabledTextGateway(false);
				manageDataIPBean.setDisabledTextMacAdress(false);
				manageDataIPBean.setDisabledTextHostName(false);
				manageDataIPBean.setDisabledTextSystemName(false);
				manageDataIPBean.setDisabledTextNetworkType(false);
				manageDataIPBean.setDisabledTextVipIp(false);
				manageDataIPBean.setDisabledTextVlanId(false);
				manageDataIPBean.setDisabledTextDnsName(false);
				manageDataIPBean.setDisabledTextTire2Remark(false);
				manageDataIPBean.setDisabledTextIpType(false);
				manageDataIPBean.setDisabledTextFloor(false);
				manageDataIPBean.setDisabledTextProjectID(false);
				manageDataIPBean.setDisabledTextProjectName(false);
				manageDataIPBean.setDisabledTextProjectManager(false);
				manageDataIPBean.setDisabledTextExpireDate(false);
				manageDataIPBean.setDisabledTextSystemOwnerID(false);
				manageDataIPBean.setDisabledTextSystemOwnerName(false);
				manageDataIPBean.setDisabledTextSystemOwnerTeam(false);			
			}else if("T3".equals(userLevel)){
				manageDataIPBean.setDisabledTextIpBox(true);
				manageDataIPBean.setDisabledTextIpSts(false);	
				manageDataIPBean.setDisabledTextPriority(false);
				manageDataIPBean.setDisabledTextNetworkZone(false);
				manageDataIPBean.setDisabledTextMacAdress(false);
				manageDataIPBean.setDisabledTextHostName(false);
				manageDataIPBean.setDisabledTextSystemName(false);
				manageDataIPBean.setDisabledTextNetworkType(false);
				manageDataIPBean.setDisabledTextTire3Remark(false);
				manageDataIPBean.setDisabledTextIpType(false);
				manageDataIPBean.setDisabledTextFloor(false);
				manageDataIPBean.setDisabledTextProjectID(false);
				manageDataIPBean.setDisabledTextProjectName(false);
				manageDataIPBean.setDisabledTextProjectManager(false);
				manageDataIPBean.setDisabledTextExpireDate(false);
				manageDataIPBean.setDisabledTextSystemOwnerID(false);
				manageDataIPBean.setDisabledTextSystemOwnerName(false);
				manageDataIPBean.setDisabledTextSystemOwnerTeam(false);		
			}
			
			   setManageDataIPBean(manageDataIPBean);
	}	
	
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		ManageDataIPBean manageDataIPBean = getManageDataIPBean();
		
		if("6".equals(manageDataIPBean.getIpVersion())){
			
			if("".equals(manageDataIPBean.getStIp1()) && "".equals(manageDataIPBean.getStIp2()) && 
				"".equals(manageDataIPBean.getStIp3()) && "".equals(manageDataIPBean.getStIp4()) && 
				"".equals(manageDataIPBean.getStIp5()) && "".equals(manageDataIPBean.getStIp6())){
				IPFMMessageUtils.addMessageError("DetailForm:stIp1", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP"));
				flgValid = false;
			}
		}
		else{
			if("".equals(manageDataIPBean.getStIp1()) && "".equals(manageDataIPBean.getStIp2()) && 
			    "".equals(manageDataIPBean.getStIp3()) && "".equals(manageDataIPBean.getStIp4())){
			    IPFMMessageUtils.addMessageError("DetailForm:stIp1", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP"));
				flgValid = false;
			}
		}
		
		if("".equals(manageDataIPBean.getIpDetail().getIpStatusName())){
			   IPFMMessageUtils.addMessageError("DetailForm:ipStatus", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IPStatus"));
				flgValid = false;
		}
		if(manageDataIPBean.getIpDetail().getHostName()==null){
			   IPFMMessageUtils.addMessageError("DetailForm:hostName", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "HostName"));
				flgValid = false;
		}
		if(manageDataIPBean.getIpDetail().getSystemName()==null){
			   IPFMMessageUtils.addMessageError("DetailForm:systemName", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SystemName"));
				flgValid = false;
		}
		if(manageDataIPBean.getIpDetail().getExpDate()==null){
			   IPFMMessageUtils.addMessageError("DetailForm:expire", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Expire"));
				flgValid = false;
		}
		if(manageDataIPBean.getIpDetail().getSystemOwnerId()==null){
			   IPFMMessageUtils.addMessageError("DetailForm:systemOwnerID", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "System Owner ID"));
				flgValid = false;
		}
		

		return flgValid;
	}
}
