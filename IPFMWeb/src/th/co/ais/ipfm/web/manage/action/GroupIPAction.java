package th.co.ais.ipfm.web.manage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.domain.IPGroup;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IIPGroupService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.GroupIPBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class GroupIPAction  extends AbstractAction {
	
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("en","EN"));
	/********************** Bean ***********************/
	public GroupIPBean groupIPBean;

	public GroupIPBean getGroupIPBean() {
		return (GroupIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("groupIPBean");
	}

	public void setGroupIPBean(GroupIPBean groupIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("groupIPBean", groupIPBean);
	}
	
//	public ManageDataIPBean manageDataIPBean;
//
//
//	public ManageDataIPBean getManageDataIPBean() {
//		return (ManageDataIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("manageDataIPBean");
//	}
//
//	public void setManageDataIPBean(ManageDataIPBean manageDataIPBean) {
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("manageDataIPBean", manageDataIPBean);
//	}
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	@Override
	public String init(String programID) {
	//public String init() {
//		System.out.println("Class >> "+getClass().getName()+" goto "+programID);
		//initDropDown();
//		IIPGroupService ipGroupService = (IIPGroupService)JSFServiceFinderUtil.getInstance().getBean("ipGroupService");
//		if(ipGroupService!=null){
//			try{
//				List<SelectItem> ipVersionList = new ArrayList<SelectItem>();
//				List<String> ipVersionStringList = ipGroupService.getGroupIPVersion();
//				if(ipVersionStringList!=null && ipVersionStringList.size()>0){
//					for (String str:ipVersionStringList) {
//						ipVersionList.add(new SelectItem(str,str));
//					}
//				}
//				
//				
//				GroupIPBean	groupIPBean = new GroupIPBean();
//				groupIPBean.setIpVersionList(ipVersionList);
//				
//				UserSession user = IPFMWebUtil.getUserSession();
//				groupIPBean.setTire1TeamID(user.getIpUser().getUserTeamId());
//				groupIPBean.setUserLoginId(user.getIpUser().getUserId());
//				
//				//combo
//				List<SelectItem> companyStringList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
//				List<SelectItem> ipClassStringList = IPFMComboBoxUtil.getInstance().getIPClassComboBoxItemsShort();
//				groupIPBean.setCompanyList(companyStringList);
//				groupIPBean.setIpClassList(ipClassStringList);
//				
//				setGroupIPBean(groupIPBean);
//			
//			}catch (IPFMBusinessException e) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(e.getMessage()));
//			}
//		}
		action_search();
		return programID;
	}
	
	public void search() throws Exception{
		GroupIPBean groupIPBean = getGroupIPBean();
		if(groupIPBean!=null){
			IIPGroupService ipGroupService = (IIPGroupService)JSFServiceFinderUtil.getInstance().getBean("ipGroupService");			
			try {
				//check space
				 if(groupIPBean.getIpVersion() == null || groupIPBean.getIpVersion().trim().equals("")){
					 IPFMMessageUtils.addMessageError("DetailForm:ipVersion", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
					 return ;
				 }
				 String[] startIP = new String[]{groupIPBean.getStIP1(),groupIPBean.getStIP2(),groupIPBean.getStIP3(),groupIPBean.getStIP4(),groupIPBean.getStIP4(),groupIPBean.getStIP5(),groupIPBean.getStIP6()};
				 String[] endIP = new String[]{groupIPBean.getEnIP1(),groupIPBean.getEnIP2(),groupIPBean.getEnIP3(),groupIPBean.getEnIP4(),groupIPBean.getEnIP4(),groupIPBean.getEnIP5(),groupIPBean.getEnIP6()};
				 
			//	String startIP=groupIPBean.getStIP1()+":;:"+groupIPBean.getStIP2()+":;:"+groupIPBean.getStIP3()+":;:"+groupIPBean.getStIP4()+":;:"+groupIPBean.getStIP5()+":;:"+groupIPBean.getStIP6();
			//	String endIP=groupIPBean.getEnIP1()+":;:"+groupIPBean.getEnIP2()+":;:"+groupIPBean.getEnIP3()+":;:"+groupIPBean.getEnIP4()+":;:"+groupIPBean.getEnIP5()+":;:"+groupIPBean.getEnIP6();
				
				if(groupIPBean.getCompanyComboItem() != null){
					groupIPBean.setCompanyID(groupIPBean.getCompanyComboItem().getValue());
				}
				if(groupIPBean.getIpClassComboItem() != null){
					groupIPBean.setIpClass(groupIPBean.getIpClassComboItem().getValue());
				}
				List<IPGroup> searchResult = ipGroupService.searchIPGroup(groupIPBean.getIpVersion(),groupIPBean.getTire1TeamID(), startIP,endIP);
				groupIPBean.setIpGroupList(searchResult);
				
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setGroupIPBean(groupIPBean);
		}
	}
	
	public void action_search(){
		System.out.println("---------- action_search = ");
		GroupIPBean bean = getGroupIPBean();
		if (bean==null) {
			bean = new GroupIPBean();
			bean.setIpValue("1");
		}
		try {
			List<IPDetail> ipDetailList = new ArrayList<IPDetail>(); 
			IPDetail ipDetail = new IPDetail();
			ipDetail.setIpAddress("172.0.0.25");
			ipDetail.setIpStatusName("Used");
			ipDetail.setExpDate("1/12/2010");
			ipDetail.setHostName("Host A");
			ipDetail.setSystemName("System A");
			ipDetail.setSubmask("255.255.0.0");
			ipDetail.setGateway("172.0.0.1");
			ipDetail.setSystemOwnerName("User A");
			ipDetailList.add(ipDetail);
			
			IPDetail d1 = (IPDetail)ipDetail.clone();
			d1.setIpAddress("172.0.0.36");
			d1.setHostName("Host B");
			d1.setSystemOwnerName("User B");
			ipDetailList.add(d1);
			bean.setIpDetailList(ipDetailList);
			setGroupIPBean(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void action_search1(){
		System.out.println("---------- action_search1 = ");
		GroupIPBean bean = getGroupIPBean();
		if (bean==null) bean = new GroupIPBean();
		try {
			List<IPDetail> ipDetailList = new ArrayList<IPDetail>(); 
			IPDetail ipDetail = new IPDetail();
			ipDetail.setIpAddress("172.1.5.10");
			ipDetail.setIpStatusName("Used");
			ipDetail.setExpDate("31/12/2010");
			ipDetail.setHostName("Host C");
			ipDetail.setSystemName("System C");
			ipDetail.setSubmask("255.255.255.0");
			ipDetail.setGateway("172.1.5.1");
			ipDetail.setSystemOwnerName("User A");
			ipDetailList.add(ipDetail);
			
			IPDetail d1 = (IPDetail)ipDetail.clone();
			d1.setIpAddress("172.1.5.11");
			d1.setHostName("Host D");
			d1.setSystemName("");
			ipDetailList.add(d1);
			
			IPDetail d2 = (IPDetail)ipDetail.clone();
			d2.setIpAddress("172.1.5.12");
			d2.setHostName("Host F");
			d2.setExpDate("30/12/2010");
			d2.setSystemName("System C4");
			d2.setSystemOwnerName("User B");
			ipDetailList.add(d2);

			IPDetail d3 = (IPDetail)d2.clone();
			d3.setIpAddress("172.1.5.13");
			d3.setHostName("Host G");
			d3.setSystemName("System C6");
			ipDetailList.add(d3);
			
			IPDetail d4 = (IPDetail)d3.clone();
			d4.setIpAddress("172.1.5.14");
			d4.setHostName("Host Z");
			d4.setExpDate("10/11/2010");
			d4.setSystemName("");
			d4.setSystemOwnerName("User A");
			ipDetailList.add(d4);
			bean.setIpDetailList(ipDetailList);
			setGroupIPBean(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String action_popupEdit() {
		GroupIPBean bean = getGroupIPBean();
		//bean.getPopupIPDetail().setIpAddress(getRequestParameter("rowIndex"));
		try{
			System.out.println(" -------- row id = " + bean.getDataTable().getRowIndex());
			System.out.println(" -------- lockFieldFlag = " + getRequestParameter("lockFieldFlag"));
			IPDetail ipDetail = (IPDetail)bean.getDataTable().getRowData();
			System.out.println(" -------- lockFieldFlag = " + getRequestParameter("lockFieldFlag"));
			bean.setPopupIPDetail((IPDetail)ipDetail.clone());
			System.out.println(" -------- lockFieldFlag = " + getRequestParameter("lockFieldFlag"));
//			if (getRequestParameter("lockFieldFlag").equalsIgnoreCase("true")){
//				bean.setLockFieldFlag(true);
//			}else{
//				bean.setLockFieldFlag(false);
//			}
			System.out.println(" -------- lockFieldFlag = " + getRequestParameter("lockFieldFlag"));
			bean.getPopupModal().setRendered(true);
			setGroupIPBean(bean);
			System.out.println(" -------- finish");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
//	public String initUpdate(){
//		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
//		ManageDataIPService manageDataIPService = (ManageDataIPService)JSFServiceFinderUtil.getInstance().getBean("manageDataIPService");	
//		System.out.println("-----------GroupIp Action initUpdate ------- rowId = "+rowId);
//		
//		if(manageDataIPService!=null && rowId!=null){
//			try {
//				System.out.println("-----------GroupIp Action controlTextEdit ------- Start");
//				//controlTextEdit();
//				System.out.println("-----------GroupIp Action controlTextEdit ------- Finish");
//				IPDetail ipDetail = manageDataIPService.getIPDetail(rowId);
//				
//				ManageDataIPBean manageDataIPBean = getManageDataIPBean(); 
//				
//				manageDataIPBean.setIpDetail(ipDetail);
//				manageDataIPBean.setIpAddress("172.16.0."+rowId);
//				manageDataIPBean.setIpStatusName("Used");
//				manageDataIPBean.setEffDate("01/01/2010");
//				manageDataIPBean.setExpDate("01/06/2010");
//				manageDataIPBean.setHostName("Host A"+rowId);
//				manageDataIPBean.setSystemName("Sys A"+rowId);
//				manageDataIPBean.setSystemOwnerId("ladda.k");
//				manageDataIPBean.setSystemOwnerName("ladda.k");
//				manageDataIPBean.setSystemOwnerId("IPSS");
//				manageDataIPBean.setSystemOwnerName("Ladda Klaithong");
//				manageDataIPBean.setRequestFromTeamName("IP-CDN");
//				manageDataIPBean.setProjectName("Project A");
//				manageDataIPBean.setGateway("10.13.33.1");
//				manageDataIPBean.setNetwork("10.13.33.0");
//				manageDataIPBean.setUrRefer("IP2010000010");
//				manageDataIPBean.setCompanyName("AIS");
//				manageDataIPBean.setSubmask("255.255.255.0");
//				manageDataIPBean.setMacAddress("ad-co-cd-bb-01-00");
//				manageDataIPBean.setDnsName("dmzfe10320");
//				manageDataIPBean.setFloor("11");
//				manageDataIPBean.setVip("NO");
//				
//				setManageDataIPBean(manageDataIPBean);				
//			} catch (IPFMBusinessException e) {
//				e.printStackTrace();
//			}
//		}		
//		return "IPURS001_02";
//	}
//	public void controlTextEdit(){
//
//		ManageDataIPBean manageDataIPBean = getManageDataIPBean(); 
//		String userLevel = manageDataIPBean.getTier1TeamId().substring(0,2);
//		if("T1".equals(userLevel)){
//			manageDataIPBean.setDisabledTextIpSts(false);
//			manageDataIPBean.setDisabledTextCompany(false);
//			manageDataIPBean.setDisabledTextLocation(false);
//			manageDataIPBean.setDisabledTextPriority(false);
//			manageDataIPBean.setDisabledTextInstallType(false);
//			manageDataIPBean.setDisabledTextMask(false);
//			manageDataIPBean.setDisabledTextNetworkZone(false);
//			manageDataIPBean.setDisabledTextNetwork(false);
//			manageDataIPBean.setDisabledTextGateway(false);
//			manageDataIPBean.setDisabledTextMacAdress(false);
//			manageDataIPBean.setDisabledTextHostName(false);
//			manageDataIPBean.setDisabledTextSystemName(false);
//			manageDataIPBean.setDisabledTextNetworkType(false);
//			manageDataIPBean.setDisabledTextVipIp(false);
//			manageDataIPBean.setDisabledTextVlanId(false);
//			manageDataIPBean.setDisabledTextDnsName(false);
//			manageDataIPBean.setDisabledTextTire1Remark(false);
//			manageDataIPBean.setDisabledTextIpType(false);
//			manageDataIPBean.setDisabledTextFloor(false);
//			manageDataIPBean.setDisabledTextProjectID(false);
//			manageDataIPBean.setDisabledTextProjectName(false);
//			manageDataIPBean.setDisabledTextProjectManager(false);
//			manageDataIPBean.setDisabledTextEffectiveDate(false);
//			manageDataIPBean.setDisabledTextExpireDate(false);
//			manageDataIPBean.setDisabledTextSystemOwnerID(false);
//			manageDataIPBean.setDisabledTextSystemOwnerName(false);
//			manageDataIPBean.setDisabledTextSystemOwnerTeam(false);
//		}else if("T2".equals(userLevel)){
//			manageDataIPBean.setDisabledTextIpSts(false);	
//			manageDataIPBean.setDisabledTextPriority(false);
//			manageDataIPBean.setDisabledTextNetworkZone(false);
//			manageDataIPBean.setDisabledTextNetwork(false);
//			manageDataIPBean.setDisabledTextGateway(false);
//			manageDataIPBean.setDisabledTextMacAdress(false);
//			manageDataIPBean.setDisabledTextHostName(false);
//			manageDataIPBean.setDisabledTextSystemName(false);
//			manageDataIPBean.setDisabledTextNetworkType(false);
//			manageDataIPBean.setDisabledTextVipIp(false);
//			manageDataIPBean.setDisabledTextVlanId(false);
//			manageDataIPBean.setDisabledTextDnsName(false);
//			manageDataIPBean.setDisabledTextTire2Remark(false);
//			manageDataIPBean.setDisabledTextIpType(false);
//			manageDataIPBean.setDisabledTextFloor(false);
//			manageDataIPBean.setDisabledTextProjectID(false);
//			manageDataIPBean.setDisabledTextProjectName(false);
//			manageDataIPBean.setDisabledTextProjectManager(false);
//			manageDataIPBean.setDisabledTextExpireDate(false);
//			manageDataIPBean.setDisabledTextSystemOwnerID(false);
//			manageDataIPBean.setDisabledTextSystemOwnerName(false);
//			manageDataIPBean.setDisabledTextSystemOwnerTeam(false);			
//		}else if("T3".equals(userLevel)){
//			manageDataIPBean.setDisabledTextIpBox(true);
//			manageDataIPBean.setDisabledTextIpSts(false);	
//			manageDataIPBean.setDisabledTextPriority(false);
//			manageDataIPBean.setDisabledTextNetworkZone(false);
//			manageDataIPBean.setDisabledTextMacAdress(false);
//			manageDataIPBean.setDisabledTextHostName(false);
//			manageDataIPBean.setDisabledTextSystemName(false);
//			manageDataIPBean.setDisabledTextNetworkType(false);
//			manageDataIPBean.setDisabledTextTire3Remark(false);
//			manageDataIPBean.setDisabledTextIpType(false);
//			manageDataIPBean.setDisabledTextFloor(false);
//			manageDataIPBean.setDisabledTextProjectID(false);
//			manageDataIPBean.setDisabledTextProjectName(false);
//			manageDataIPBean.setDisabledTextProjectManager(false);
//			manageDataIPBean.setDisabledTextExpireDate(false);
//			manageDataIPBean.setDisabledTextSystemOwnerID(false);
//			manageDataIPBean.setDisabledTextSystemOwnerName(false);
//			manageDataIPBean.setDisabledTextSystemOwnerTeam(false);		
//		}
//		
//		   setManageDataIPBean(manageDataIPBean);
//}	

//	public void initDropDown(){
//		List<SelectItem> ipStatusStringList = IPFMComboBoxUtil.getInstance().getIPStatusComboBoxItems();
//		List<SelectItem> locatStringList = IPFMComboBoxUtil.getInstance().getLocationComboBoxItems();
//		List<SelectItem> zoneStringList = IPFMComboBoxUtil.getInstance().getZoneComboBoxItems();
//		List<SelectItem> nwTypeStringList = IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems();
//		List<SelectItem> t2TeamStringList = IPFMComboBoxUtil.getInstance().getTier2TeamComboBoxItems();
//		List<SelectItem> companyStringList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
//		List<SelectItem> priorityStringList = IPFMComboBoxUtil.getInstance().getPriorityComboBoxItems();
//		List<SelectItem> installTypeStringList = IPFMComboBoxUtil.getInstance().getInstallTypeComboBoxItems();
//		List<SelectItem> ipTypeStringList = IPFMComboBoxUtil.getInstance().getIPTypeListComboBoxItems();
//		List<SelectItem> requestFromTeamList = IPFMComboBoxUtil.getInstance().getRequestFromTeamComboBoxItems();
//		List<SelectItem> projectIdList = IPFMComboBoxUtil.getInstance().getProjectIdComboBoxItems();
//		List<SelectItem> projectManagerList = IPFMComboBoxUtil.getInstance().getProjectManagerComboBoxItems();
//		List<SelectItem> systemOwnerList = IPFMComboBoxUtil.getInstance().getSystemOwnerComboBoxItems();
//		List<SelectItem> systemOwnerTeamList = IPFMComboBoxUtil.getInstance().getSystemOwnerTeamComboBoxItems();
//	
//		ManageDataIPBean manageDataIPBean = new ManageDataIPBean();
//		manageDataIPBean.setIpStatusList(ipStatusStringList);
//		manageDataIPBean.setLocatList(locatStringList);
//		manageDataIPBean.setZoneList(zoneStringList);
//		manageDataIPBean.setNwTypeList(nwTypeStringList);
//		manageDataIPBean.setT2TeamList(t2TeamStringList);
//		
//		manageDataIPBean.setCompanyList(companyStringList);
//		manageDataIPBean.setPriorityList(priorityStringList);
//		manageDataIPBean.setInstallTypeList(installTypeStringList);
//		manageDataIPBean.setIpTypeList(ipTypeStringList);
//		
//		manageDataIPBean.setRequestFromTeamList(requestFromTeamList);
//		manageDataIPBean.setProjectIdList(projectIdList);
//		manageDataIPBean.setProjectManagerList(projectManagerList);
//		
//		manageDataIPBean.setSystemOwnerList(systemOwnerList);
//		manageDataIPBean.setSystemOwnerList(systemOwnerTeamList);
//		setManageDataIPBean(manageDataIPBean);
//}	
	
//	public void search() throws Exception {
//		System.out.println("----------GroupIp Action search----------");
//		ManageDataIPBean manageDataIPBean = getManageDataIPBean();
//		manageDataIPBean.setStIp1("172");
//		manageDataIPBean.setStIp2("16");
//		manageDataIPBean.setStIp3("6");
//		manageDataIPBean.setStIp4("0");
//		manageDataIPBean.setEdIp1("172");
//		manageDataIPBean.setEdIp2("16");
//		manageDataIPBean.setEdIp3("50");
//		manageDataIPBean.setEdIp4("255");
//		
//		List<IPDetail> ipDetailList = new ArrayList<IPDetail>();
//		IPDetail iPDetail;
//		for (int i=0;i<20;i++) {
//			iPDetail = new IPDetail();
//			iPDetail.setIpAddress("172.16.0."+i);
//			iPDetail.setIpStatusName("Used");
//			iPDetail.setHostName("HOST A"+(i+1));
//			iPDetail.setSystemName("Sys A"+(i+1));
//			iPDetail.setRowId(String.valueOf(i+1));
//			iPDetail.setNetworkType("LAN/WAN");
//			iPDetail.setLocationName("ESE Bld. floor11");
//			iPDetail.setNetworkZoneName("IPTN");
//			iPDetail.setRequestFromTeamName("IP-CDN");
//			iPDetail.setProjectId("PRJ01");
//			iPDetail.setProjectName("Project A");
//			iPDetail.setEffDate("01/01/2010");
//			iPDetail.setExpDate("01/06/2010");
//			ipDetailList.add(iPDetail);
//		}
//		manageDataIPBean.setIpDetailList(ipDetailList);
//		
//	}
	
	public void clear(){
		GroupIPBean groupIPBean = getGroupIPBean();
		groupIPBean.setIpVersion(null);
		groupIPBean.setIpClass(null);
		groupIPBean.setCompanyID(null);
		
		IPFMRichComboItem ipClassItem = new IPFMRichComboItem();
		IPFMRichComboItem companyItem = new IPFMRichComboItem();
		ipClassItem.setValue("1");
		ipClassItem.setLabel("Class A");
		groupIPBean.setIpClassComboItem(ipClassItem);
		companyItem.setValue("1");
		companyItem.setLabel("AIS");
		groupIPBean.setCompanyComboItem(companyItem);
		
		groupIPBean.setStIP1(null);
		groupIPBean.setStIP2(null);
		groupIPBean.setStIP3(null);
		groupIPBean.setStIP4(null);
		groupIPBean.setStIP5(null);
		groupIPBean.setStIP6(null);
		groupIPBean.setEnIP6(null);
		groupIPBean.setGrpDesc(null);
		groupIPBean.setDisable(false);
		groupIPBean.setDisableDesc(false);
		groupIPBean.setDisableIP(false);
		setGroupIPBean(groupIPBean);
	}
	public void showIPBox(){
		GroupIPBean groupIPBean = getGroupIPBean();
		if(groupIPBean != null){
			if(groupIPBean.getIpVersion()!= null && groupIPBean.getIpVersion().equals("6")) {
				groupIPBean.setDisable(true);
			}else{
				groupIPBean.setDisable(false);
			}
		}
		
	}
	public String showAddGroup() throws Exception{
		GroupIPBean groupIPBean = getGroupIPBean();
		IIPGroupService ipGroupService = (IIPGroupService)JSFServiceFinderUtil.getInstance().getBean("ipGroupService");	
		if(ipGroupService!=null){
			try {
				clear();
				
				//show edit buttom
				groupIPBean.setDisableIP(false);
				groupIPBean.setDisableDesc(false);
				
				groupIPBean.setIpGroupList(null);
				setGroupIPBean(groupIPBean);
				
				
			} catch (Exception e) {
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(e.getMessage()));
			}
		}		
		return "IPURS001_02";
	}
	public String addGroup() throws Exception{
		GroupIPBean groupIPBean = getGroupIPBean();
		IIPGroupService ipGroupService = (IIPGroupService)JSFServiceFinderUtil.getInstance().getBean("ipGroupService");	
		if(ipGroupService!=null){
			try {
				//set comboid
				if(groupIPBean.getCompanyComboItem() != null){
					groupIPBean.setCompanyID(groupIPBean.getCompanyComboItem().getValue());
				}
				if(groupIPBean.getIpClassComboItem() != null){
					groupIPBean.setIpClass(groupIPBean.getIpClassComboItem().getValue());
				}
				
				//check space
				 if(groupIPBean.getIpVersion() == null || groupIPBean.getIpVersion().trim().equals("")){
					 IPFMMessageUtils.addMessageError("DetailForm:ipVersion", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Version"));
					 return null;
				 }
				 if(groupIPBean.getIpClassComboItem() == null){
					 IPFMMessageUtils.addMessageError("DetailForm:ipClass", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Class"));
					 return null;
				 }
				 if(groupIPBean.getCompanyComboItem() == null ){
					 IPFMMessageUtils.addMessageError("DetailForm:company", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
					 return null;
				 }

				 if( (groupIPBean.getStIP4() == null || groupIPBean.getStIP4().trim().equals(""))
						|| (groupIPBean.getEnIP6() == null || groupIPBean.getEnIP6().trim().equals(""))){
					 IPFMMessageUtils.addMessageError("DetailForm:stIP1", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Group IP"));
					 return null;
				 }else{ 
					  if( (groupIPBean.getStIP3() == null || groupIPBean.getStIP3().trim().equals("")))
						  groupIPBean.setStIP3("0");
					  if( (groupIPBean.getStIP2() == null || groupIPBean.getStIP2().trim().equals("")))
						  groupIPBean.setStIP2("0");
					  if( (groupIPBean.getStIP1() == null || groupIPBean.getStIP1().trim().equals("")))
						  groupIPBean.setStIP1("0");
				 }
				 
				if(groupIPBean.getIpVersion().equals("6")){
						if(	groupIPBean.getStIP5() == null || groupIPBean.getStIP5() == ""
							|| groupIPBean.getStIP6() == null || groupIPBean.getStIP6() == ""
						){IPFMMessageUtils.addMessageError("DetailForm:stIP1", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Group IP"));
						 return null;}
				}
				
				IPGroup obj = new IPGroup();
				
				obj.setIpVersion(groupIPBean.getIpVersion());
				obj.setIpClass(groupIPBean.getIpClassComboItem().getValue());
				obj.setCompanyID(groupIPBean.getCompanyComboItem().getValue());
				obj.setIpClass(groupIPBean.getIpClass());
				obj.setGrpDesc(groupIPBean.getGrpDesc());
				obj.setIsActive(groupIPBean.getIsActive());
				
				
				obj.setStIP1(groupIPBean.getStIP1());
				obj.setStIP2(groupIPBean.getStIP2());
				obj.setStIP3(groupIPBean.getStIP3());
				obj.setStIP4(groupIPBean.getStIP4());
				obj.setStIP5(groupIPBean.getStIP5());
				obj.setStIP6(groupIPBean.getStIP6());
				
				obj.setEdIP1(groupIPBean.getStIP1());
				obj.setEdIP2(groupIPBean.getStIP2());
				obj.setEdIP3(groupIPBean.getStIP3());
				
				if(obj.getIpVersion().equals("6")){
					obj.setGrpIPST(groupIPBean.getStIP1()+"."+groupIPBean.getStIP2()+"."+groupIPBean.getStIP3()+"."+groupIPBean.getStIP4()+"."+groupIPBean.getStIP5()+"."+groupIPBean.getStIP6());
					obj.setGrpIPED(groupIPBean.getStIP1()+"."+groupIPBean.getStIP2()+"."+groupIPBean.getStIP3()+"."+groupIPBean.getStIP4()+"."+groupIPBean.getStIP5()+"."+groupIPBean.getEnIP6());
					
					obj.setEdIP4(groupIPBean.getStIP4());
					obj.setEdIP5(groupIPBean.getStIP5());
					obj.setEdIP6(groupIPBean.getEnIP6());
					
					obj.setTotalIP(Integer.parseInt(groupIPBean.getEnIP6()) - Integer.parseInt(groupIPBean.getStIP6()));
				}else{
					obj.setGrpIPST(groupIPBean.getStIP1()+"."+groupIPBean.getStIP2()+"."+groupIPBean.getStIP3()+"."+groupIPBean.getStIP4());
					obj.setGrpIPED(groupIPBean.getStIP1()+"."+groupIPBean.getStIP2()+"."+groupIPBean.getStIP3()+"."+groupIPBean.getEnIP6());
					
					obj.setEdIP4(groupIPBean.getEnIP6());
					obj.setEdIP5(null);
					
					obj.setTotalIP(Integer.parseInt(groupIPBean.getEnIP6()) - Integer.parseInt(groupIPBean.getStIP4()));
					obj.setEdIP6(null);
				}
				obj.setTotalAssignT2(0);
				obj.setTotalAssignT3(0);
				obj.setTire1ID(groupIPBean.getUserLoginId());
				obj.setTire1TeamID(groupIPBean.getTire1TeamID());
				obj.setCreatedBy(groupIPBean.getUserLoginId());
				obj.setLastUpdBy(groupIPBean.getUserLoginId());
				obj.setVersion(1);
				
				IPGroup result	= ipGroupService.addIPGroup(obj);
				
				if(result == null){
					//duplicate
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0020")));
					return null;
				}
					
				List<IPGroup> lstGroupAdd = new ArrayList<IPGroup>();
				if(groupIPBean != null && groupIPBean.getIpGroupList() != null){
				  lstGroupAdd = groupIPBean.getIpGroupList();
				}
				lstGroupAdd.add(result);
				groupIPBean.setIpGroupList(lstGroupAdd);
				
				clear();
			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(e.getMessage()));
			}
		}
		return null;		
	}
	public String showEdit() throws IPFMBusinessException, Exception{
		GroupIPBean groupIPBean = getGroupIPBean();
		
		   groupIPBean.setIpVersion(getRequestParameter("ipVersionParam"));
		   
		   	IPFMRichComboItem ipClassItem = new IPFMRichComboItem();
			IPFMRichComboItem companyItem = new IPFMRichComboItem();
			ipClassItem.setValue(getRequestParameter("ipClassParam"));
			ipClassItem.setLabel(getRequestParameter("ipClassNameParam"));
			groupIPBean.setIpClassComboItem(ipClassItem);
			companyItem.setValue(getRequestParameter("companyIDParam"));
			companyItem.setLabel(getRequestParameter("companyNameParam"));
			groupIPBean.setCompanyComboItem(companyItem);
			
		   groupIPBean.setGrpDesc(getRequestParameter("grpDescParam"));
		   groupIPBean.setStIP1(getRequestParameter("stIP1Param"));
		   groupIPBean.setStIP2(getRequestParameter("stIP2Param"));
		   groupIPBean.setStIP3(getRequestParameter("stIP3Param"));
		   groupIPBean.setStIP4(getRequestParameter("stIP4Param"));
		   groupIPBean.setStIP5(getRequestParameter("stIP5Param"));
		   groupIPBean.setStIP6(getRequestParameter("stIP6Param"));
		   groupIPBean.setRowId(getRequestParameter("rowIDParam"));
		   if(getRequestParameter("edIP4Param") !=null){
			   groupIPBean.setEnIP6(getRequestParameter("edIP4Param"));   
		   }else{
			   groupIPBean.setEnIP6(getRequestParameter("edIP6Param"));
		   }
		
	   if(getRequestParameter("indexParam") != null){
	   		groupIPBean.setIndex(Integer.parseInt(getRequestParameter("indexParam")));
	   }
	   //show edit buttom
		groupIPBean.setDisableIP(true);
		groupIPBean.setDisableDesc(false);
		showIPBox();
		return "IPURS001_02";
	}
	
	
	public String showView(){
		GroupIPBean groupIPBean = getGroupIPBean();
			groupIPBean.setIpVersion(getRequestParameter("ipVersionParam"));
			
			IPFMRichComboItem ipClassItem = new IPFMRichComboItem();
			IPFMRichComboItem companyItem = new IPFMRichComboItem();
			ipClassItem.setValue(getRequestParameter("ipClassParam"));
			ipClassItem.setLabel(getRequestParameter("ipClassNameParam"));
			groupIPBean.setIpClassComboItem(ipClassItem);
			companyItem.setValue(getRequestParameter("companyIDParam"));
			companyItem.setLabel(getRequestParameter("companyNameParam"));
			groupIPBean.setCompanyComboItem(companyItem);
		   
		   groupIPBean.setGrpDesc(getRequestParameter("grpDescParam"));
		   groupIPBean.setStIP1(getRequestParameter("stIP1Param"));
		   groupIPBean.setStIP2(getRequestParameter("stIP2Param"));
		   groupIPBean.setStIP3(getRequestParameter("stIP3Param"));
		   groupIPBean.setStIP4(getRequestParameter("stIP4Param"));
		   groupIPBean.setStIP5(getRequestParameter("stIP5Param"));
		   groupIPBean.setStIP6(getRequestParameter("stIP6Param"));
		   if(getRequestParameter("edIP4Param") !=null){
			   groupIPBean.setEnIP6(getRequestParameter("edIP4Param"));   
		   }else{
			   groupIPBean.setEnIP6(getRequestParameter("edIP6Param"));
		   }
		   groupIPBean.setRowId(getRequestParameter("rowIDParam"));
	   
	   //show edit buttom
		groupIPBean.setDisableIP(true);
		groupIPBean.setDisableDesc(true);
		groupIPBean.setIpGroupList(null);
		showIPBox();
		return "IPURS001_02";
	}
	
//	public String updateIPDetail(){
//		try {
//			ManageDataIPBean manageDataIPBean = getManageDataIPBean();
//			manageDataIPBean.setStIp1("172");
//			manageDataIPBean.setStIp2("16");
//			manageDataIPBean.setStIp3("6");
//			manageDataIPBean.setStIp4("0");
//			manageDataIPBean.setEdIp1("172");
//			manageDataIPBean.setEdIp2("16");
//			manageDataIPBean.setEdIp3("6");
//			manageDataIPBean.setEdIp4("255");
//			
//			List<IPDetail> ipDetailList = new ArrayList<IPDetail>();
//			IPDetail iPDetail;
//			for (int i=0;i<256;i++) {
//				iPDetail = new IPDetail();
//				iPDetail.setIpAddress("172.16.0."+i);
//				if (i < 50) {
//					iPDetail.setIpStatusName("Reserved");
//				}else if (i<156){
//					iPDetail.setIpStatusName("Used");
//				}else{
//					iPDetail.setIpStatusName("Assign to User");
//				}
//				
//				iPDetail.setHostName("HOST A"+(i+1));
//				iPDetail.setSystemName("Sys A"+(i+1));
//				iPDetail.setRowId(String.valueOf(i+1));
//				iPDetail.setNetworkType("Client/User");
//				iPDetail.setLocationName("ESE Bld. floor11");
//				iPDetail.setNetworkZoneName("LAN/WAN");
//				iPDetail.setRequestFromTeamName("IP-CDN");
//				iPDetail.setProjectId("PRJ01");
//				iPDetail.setProjectName("Project A");
//				iPDetail.setEffDate("01/01/2010");
//				iPDetail.setExpDate("01/06/2010");
//				ipDetailList.add(iPDetail);
//			}
//			manageDataIPBean.setIpDetailList(ipDetailList);
//		} catch (Exception e) {
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
//		}
//		return "IPURS001_01";
//	}	
	
	public void updateGroup() throws Exception{
		GroupIPBean groupIPBean = getGroupIPBean();
		IIPGroupService ipGroupService = (IIPGroupService)JSFServiceFinderUtil.getInstance().getBean("ipGroupService");	
		if(ipGroupService!=null){
			try {
				IPGroup obj = new IPGroup();
				
				obj.setGrpID(groupIPBean.getGrpID());
				obj.setGrpDesc(groupIPBean.getGrpDesc());
				obj.setLastUpdBy(groupIPBean.getUserLoginId());
				obj.setRowID(groupIPBean.getRowId());
				IPGroup  result = ipGroupService.editIPGroup(obj);
				
				List<IPGroup> lstGroupAdd = new ArrayList<IPGroup>();
				lstGroupAdd = groupIPBean.getIpGroupList();
				lstGroupAdd.set(groupIPBean.getIndex(),result);
				
				groupIPBean.setIpGroupList(lstGroupAdd);
				clear();
			} catch (IPFMBusinessException e) {
				e.printStackTrace();
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
			}
		}		
	}
	public void deleteGroup() throws Exception{
		GroupIPBean groupIPBean = getGroupIPBean();
		IIPGroupService ipGroupService = (IIPGroupService)JSFServiceFinderUtil.getInstance().getBean("ipGroupService");	
		if(ipGroupService!=null){
			try {
				
				if(getRequestParameter("assignParam") != null)
					if(Integer.parseInt(getRequestParameter("assignParam")) > 0){
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0021")));
						return;
					}
				
				IPGroup obj = new IPGroup();
				obj.setRowID(getRequestParameter("rowIDParam"));
				obj.setGrpID(" ");
				obj.setIpClass(" ");
				obj.setIpVersion(" ");
				ipGroupService.deleteIPGroup(obj);
				
				
				List<IPGroup> lstGroupAdd = new ArrayList<IPGroup>();
				lstGroupAdd = groupIPBean.getIpGroupList();
				lstGroupAdd.remove(Integer.parseInt(getRequestParameter("indexParam")));
				
				groupIPBean.setIpGroupList(lstGroupAdd);
				
			} catch (IPFMBusinessException e) {
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(e.getMessage()));
			}
		}		
	}
	String ipClassVal="";
	public void setIPClass(){
		GroupIPBean groupIPBean = getGroupIPBean();
		ipClassVal = groupIPBean.getIpClassComboItem().getValue();
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getIpClassVal() {
		return ipClassVal;
	}

	public void setIpClassVal(String ipClassVal) {
		this.ipClassVal = ipClassVal;
	}
}
