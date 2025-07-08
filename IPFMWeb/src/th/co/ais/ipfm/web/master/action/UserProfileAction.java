package th.co.ais.ipfm.web.master.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpDelegateUserId;
import th.co.ais.ipfm.domain1.IpRole;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPTeamService;
import th.co.ais.ipfm.service.UserProfileService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.master.bean.UserProfileBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class UserProfileAction extends AbstractAction{
	/********************** Bean ***********************/
	public UserProfileBean userProfileBean;
	
	public UserProfileBean getUserProfileBean() {
		return (UserProfileBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userProfileBean");
	}

	public void setUserProfileBean(UserProfileBean userProfileBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userProfileBean", userProfileBean);
	}
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get(name);
    }
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		userProfileBean = getUserProfileBean();		
		if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			userProfileBean.setSortPopupAddUser(sortColumnChange());	
		} else if(TablSort.equalsIgnoreCase("roleDataTable")) {
			userProfileBean.setSort002(sortColumnChange());	
		}
		
		return "";
	}

	@Override
	public String init(String programID) {
		UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		List<SelectItem> userIdList = new ArrayList<SelectItem>();
		List<SelectItem> delegateToList = new ArrayList<SelectItem>();
		List<SelectItem> roleList = new ArrayList<SelectItem>();
		List<SelectItem> roleAllList = new ArrayList<SelectItem>();
		List<SelectItem> userList = new ArrayList<SelectItem>();
		UserProfileBean bean = new UserProfileBean();
		IPFMRichComboItem roleComboItem = new IPFMRichComboItem();
		IPFMRichComboItem roleAllComboItem = new IPFMRichComboItem();
		IPFMRichComboItem userIdComboItem = new IPFMRichComboItem();
		IPFMRichComboItem cbitem = null;
		 try{
			 	UserSession userSession = IPFMWebUtil.getUserSession();
			 	List<IpRoleMember> roleMemberList = userProfileService.findIpRoleMemberByUserId(userSession.getIpUser().getUserId());
			 	for(IpRoleMember roleMember : roleMemberList){
					if (roleMember.getRoleId().equalsIgnoreCase("R03")){
						bean.setDelegateRender(true);
					}
					if (roleMember.getRoleId().equalsIgnoreCase("R06")){
						bean.setRole06Flag("Y");
					}
					if (roleMember.getRoleId().equalsIgnoreCase("R07")){
						bean.setRole07Flag("Y");
					}
				}
				
			    // UserIdCombo
				List<IpUser> userIdStringList = userProfileService.getUserIdList();
				if(userIdStringList!=null && userIdStringList.size()>0){
					for (IpUser str:userIdStringList) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getUserName());
						cbitem.setValue(str.getUserId());
						cbitem.setValue1(str.getTeamId());
						userIdList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
			    }
				
			    // DelegateToCombo
				List<IpUser> delegateToStringList = userProfileService.getDelegateToList(bean.getUserInfo().getUserId());
				if(delegateToStringList!=null && delegateToStringList.size()>0){
					for (IpUser str:delegateToStringList) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getUserName());
						cbitem.setValue(str.getUserId());
						cbitem.setValue1(str.getTeamId());
						delegateToList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
			    }
				
				//RoleAllCombo
				List<IpRole> roleAllStringList = userProfileService.getRoleAllList();
					if(roleAllStringList!=null && roleAllStringList.size()>0){
						IpRole obj =roleAllStringList.get(0);
						roleAllComboItem.setValue(obj.getRoleId());
						roleAllComboItem.setLabel(obj.getRoleName());
						bean.setRoleAllComboItem(roleAllComboItem);
						for (IpRole str:roleAllStringList) {
							cbitem = new IPFMRichComboItem();
							cbitem.setLabel(str.getRoleName());
							cbitem.setValue(str.getRoleId());
							roleAllList.add(new SelectItem(cbitem, cbitem.getLabel()));
						}
				    }
					
					//RoleCombo
					List<IpRole> roleStringList = userProfileService.getRoleList(bean.getUserInfo().getUserId(),bean.getRole06Flag(),bean.getRole07Flag());
						if(roleStringList!=null && roleStringList.size()>0){
							for (IpRole str:roleStringList) {
								if(str.getRoleId() != null && !str.getRoleId().equals("R03")){
									cbitem = new IPFMRichComboItem();
									cbitem.setLabel(str.getRoleName());
									cbitem.setValue(str.getRoleId());
									roleList.add(new SelectItem(cbitem, cbitem.getLabel()));
								}
							}
							if(roleList != null && roleList.size() > 0) {
								SelectItem obj =roleList.get(0);
								bean.setRoleComboItem((IPFMRichComboItem) obj.getValue());
							}
					    }
				
				    // UserCombo
				List<IpUser> userStringList = userProfileService.getUserList(bean.getUserInfo().getUserId());
					if(userStringList!=null && userStringList.size()>0){
						for (IpUser str:userStringList) {
							cbitem = new IPFMRichComboItem();
							cbitem.setLabel(str.getUserName());
							cbitem.setValue(str.getUserId());
							cbitem.setValue1(str.getTeamId());
							userList.add(new SelectItem(cbitem, cbitem.getLabel()));
						}
				    }
				if("IPSMS002".equals(programID)){
					String checkRole = userProfileService.checkRole(bean.getUserInfo().getUserId());
					if(IPFMConstant.Found.equals(checkRole)){
						bean.setRoleAllVisible(true);
						bean.setRoleVisible(false);
					}else{
						bean.setRoleAllVisible(false);
						bean.setRoleVisible(true);
					}
				}else{
					bean.setRoleVisible(true);
				}
				String managerName = "";
				try{
					managerName = userProfileService.getManagerName(bean.getUserInfo().getManagerId());
				}catch (Exception ex) {
					managerName = bean.getUserInfo().getManagerId();
				}
				 
				List<IpDelegateUser>   delegateDataList  = userProfileService.getDelegateDataList(bean.getUserInfo().getUserId());
				List<IpRoleMember>  roleDataList = null;
				if (bean.getRoleAllVisible()){
					if(bean.getRoleComboItem()!=null){
					    roleDataList  = userProfileService.getRoleDataList(bean.getRoleAllComboItem().getValue());
					}
				}else{
					if(bean.getRoleComboItem()!=null){
					    roleDataList  = userProfileService.getRoleDataList(bean.getRoleComboItem().getValue());
					}
				}
				bean.setUserIdComboList(userIdList);
				bean.setRoleComboList(roleList);
				bean.setRoleAllComboList(roleAllList);
				bean.setUserComboList(userList);
				
				bean.setDelegateToList(delegateToList); 
				bean.getUserInfo().setManagerName(managerName);
				bean.setDelegateDataList(delegateDataList);
				bean.setRoleDataList(roleDataList);
				
				userIdComboItem.setValue(bean.getUserInfo().getUserId());
				userIdComboItem.setLabel(bean.getUserInfo().getUserName());
				bean.setUserIdComboItem(userIdComboItem);
			
			    setUserProfileBean(bean);
			
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}

		return programID;
	}
	
	public void onchngeUsreIdCobo(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean = getUserProfileBean();
		 List<SelectItem> delegateToList = new ArrayList<SelectItem>();
		 List<SelectItem> roleList = new ArrayList<SelectItem>();
		 List<SelectItem> roleAllList = new ArrayList<SelectItem>();
		 IPFMRichComboItem roleComboItem = new IPFMRichComboItem();
		 IPFMRichComboItem roleAllComboItem = new IPFMRichComboItem();
		 IPFMRichComboItem cbitem = null;
		 try {
			  if (bean.getUserIdComboItem()==null || bean.getUserIdComboItem().getValue()==null) {
				  IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0090"),bean.getUserIdComboItem().getLabel()));
				  bean.getUserIdComboItem().setValue(bean.getUserInfo().getUserId());
				  bean.getUserIdComboItem().setLabel(bean.getUserInfo().getUserName());
				  setUserProfileBean(bean);
				  return;
			  }else{
				  List<IpRoleMember> roleMemberList = userProfileService.findIpRoleMemberByUserId(bean.getUserIdComboItem().getValue());
				  bean.setDelegateRender(false);
				 	for(IpRoleMember roleMember : roleMemberList){
						if (roleMember.getRoleId().equalsIgnoreCase("R03")){
							bean.setDelegateRender(true);
						}
						if (roleMember.getRoleId().equalsIgnoreCase("R06")){
							bean.setRole06Flag("Y");
						}
						if (roleMember.getRoleId().equalsIgnoreCase("R07")){
							bean.setRole07Flag("Y");
						}
					}
			  }
				    // DelegateToCombo
			        if(bean.getUserIdComboItem().getValue()!=null){
						List<IpUser> delegateToStringList = userProfileService.getDelegateToList(bean.getUserIdComboItem().getValue());
						if(delegateToStringList!=null && delegateToStringList.size()>0){
							for (IpUser str:delegateToStringList) {
								cbitem = new IPFMRichComboItem();
								cbitem.setLabel(str.getUserName());
								cbitem.setValue(str.getUserId());
								delegateToList.add(new SelectItem(cbitem, cbitem.getLabel()));
							}
					    }
			        }
				    String checkRole = userProfileService.checkRole(bean.getUserIdComboItem().getValue());
						if(IPFMConstant.Found.equals(checkRole)){
							  //RoleAllCombo
							  List<IpRole> roleAllStringList = userProfileService.getRoleAllList();
								if(roleAllStringList!=null && roleAllStringList.size()>0){
/*									IpRole obj =roleAllStringList.get(0);
									roleAllComboItem.setValue(obj.getRoleId());
									roleAllComboItem.setLabel(obj.getRoleName());
									bean.setRoleAllComboItem(roleAllComboItem);*/
									for (IpRole str:roleAllStringList) {
										cbitem = new IPFMRichComboItem();
										cbitem.setLabel(str.getRoleName());
										cbitem.setValue(str.getRoleId());
										roleAllList.add(new SelectItem(cbitem, cbitem.getLabel()));
									}
							    }
							 bean.setRoleAllVisible(true);
							 bean.setRoleVisible(false);
						}else{
								//RoleCombo
								List<IpRole> roleStringList = userProfileService.getRoleList(bean.getUserIdComboItem().getValue(),bean.getRole06Flag(),bean.getRole07Flag());
									if(roleStringList!=null && roleStringList.size()>0){
										IpRole objRole =roleStringList.get(0);
										roleComboItem.setValue(objRole.getRoleId());
										roleComboItem.setLabel(objRole.getRoleName());
										bean.setRoleComboItem(roleComboItem);
										for (IpRole str:roleStringList) {
											cbitem = new IPFMRichComboItem();
											cbitem.setLabel(str.getRoleName());
											cbitem.setValue(str.getRoleId());
											roleList.add(new SelectItem(cbitem, cbitem.getLabel()));
										}
								    }else{
								    	bean.setRoleComboItem(new IPFMRichComboItem());
								    }
							bean.setRoleAllVisible(false);
							bean.setRoleVisible(true);
						}
					  IpUser  obj	=  userProfileService.getIPUser(bean.getUserIdComboItem().getValue());
					  String managerName = ""; 
					  
					  try{
							managerName = userProfileService.getManagerName(obj.getManagerId());
						}catch (Exception ex) {
							managerName = bean.getUserInfo().getManagerId();
						}
						
					  List<IpDelegateUser>   delegateDataList  = userProfileService.getDelegateAdminList(bean.getUserIdComboItem().getValue());
						
					  bean.setUserInfo(obj);
					  bean.getUserInfo().setManagerName(managerName);
					  bean.setDelegateDataList(delegateDataList);
				      bean.setDelegateToList(delegateToList); 
				      bean.setRoleAllComboList(roleAllList);
				      bean.setRoleComboList(roleList);
				      List<IpRoleMember>  roleDataList = null;
						if (bean.getRoleAllVisible()){
							if(bean.getRoleComboItem()!=null){
							    roleDataList  = userProfileService.getRoleDataList(bean.getRoleAllComboItem().getValue());
							}
						}else{
							if(bean.getRoleComboItem()!=null){
							    roleDataList  = userProfileService.getRoleDataList(bean.getRoleComboItem().getValue());
							}
						}
						bean.setRoleDataList(roleDataList);
			          setUserProfileBean(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateFromEhr(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean = getUserProfileBean();
		 String userId = getRequestParameter("userId");
		 try {
				IpUser ipUser = userProfileService.getEhrByUserId(userId);
				bean.getUserInfo().setUserName(ipUser.getUserName());
				bean.getUserInfo().setDept(ipUser.getDept());
				bean.getUserInfo().setSection(ipUser.getSection());
				bean.getUserInfo().setPosition(ipUser.getPosition());
				bean.getUserInfo().setManagerId(ipUser.getManagerId());
				bean.getUserInfo().setManagerName(ipUser.getManagerName());		
				bean.getUserInfo().setEmail(ipUser.getEmail());
				setUserProfileBean(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
	}
	
	public String saveUserProfile(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean = getUserProfileBean();
		 try {
			  if(validateSave()){
				userProfileService.saveUserProfile(bean.getUserInfo());
				UserSession userSession = IPFMWebUtil.getUserSession();
				userSession.setIpUser(bean.getUserInfo());
				bean.setUserStatus(userSession.getNewUser());
				userSession.setNewUser("N");
				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
				session.setAttribute(IPFMWebUtil.USER_SESSION, userSession);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				setUserProfileBean(bean);
				
			  }
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String saveUserProfileByAdmin(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean = getUserProfileBean();
		 try {
			  if(validateSave()){
				IpUser userInfo = bean.getUserInfo();
				UserSession userSession = IPFMWebUtil.getUserSession();
				userInfo.setLastUpdBy(userSession.getIpUser().getUserId());
				userProfileService.saveUserProfile(userInfo);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				setUserProfileBean(bean);
				
			  }
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	public String reloadPage(){
		UserProfileBean bean = getUserProfileBean();
		if (bean.getUserStatus().equalsIgnoreCase("Y")) {
			return "ISSMS007";
		}
		return null;
	}
	
	public void changeComboRole(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 List<IpRoleMember>  roleDataList=null;
		 String chk = getRequestParameter("chk");
		 String roleId ="";
		 try {
			if("All".equals(chk)){
				roleId = bean.getRoleAllComboItem().getValue();
			}else {
				roleId = bean.getRoleComboItem().getValue();
			}
			  roleDataList  = userProfileService.getRoleDataList(roleId);
			
			bean.setRoleDataList(roleDataList);
			setUserProfileBean(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
	}

	public void addDelegate(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 try {
			if(validate()){
			IpDelegateUserId ipDelegateUserId  = new IpDelegateUserId(bean.getUserInfo().getUserId(), bean.getDelegateComboItem().getValue());
			bean.getIpDelegateUser().setId(ipDelegateUserId);
			bean.getIpDelegateUser().setCreatedBy(bean.getUserInfo().getUserId());
			bean.getIpDelegateUser().setLastUpdBy(bean.getUserInfo().getUserId());
			List<IpDelegateUser>   delegateDataList = userProfileService.addDelegate(bean.getIpDelegateUser(),bean.getUserInfo());
			bean.setDelegateDataList(delegateDataList);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			bean.setDelegateComboItem(null);
			bean.getIpDelegateUser().setStartDate(null);
			bean.getIpDelegateUser().setEndDate(null);
			setUserProfileBean(bean);
			}
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
	}
	
	public void updateValueBeforeDeleteDelegate(){
		String delegateUserId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("delegateUserId").toString();
		UserProfileBean bean =  getUserProfileBean();
		IpDelegateUserId ipDelegateUserId  = new IpDelegateUserId(null, delegateUserId);
		bean.getIpDelegateUser().setId(ipDelegateUserId);
		setUserProfileBean(bean);
	}
	
	public void deleteDelegate(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 try {
			    IpDelegateUserId ipDelegateUserId  = new IpDelegateUserId(bean.getUserInfo().getUserId(),bean.getIpDelegateUser().getId().getDelegateUserId());
				bean.getIpDelegateUser().setId(ipDelegateUserId);
				List<IpDelegateUser>   delegateDataList = userProfileService.deleteDelegate(bean.getIpDelegateUser(),bean.getUserInfo());
				bean.setDelegateDataList(delegateDataList);
				setUserProfileBean(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
	}
	
	public void addRole(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 try {
			  if(validateRole()){
			
			  if (bean.getRoleComboItem().getValue().equalsIgnoreCase("R04")) {
					IPTeamService ipTeamService = (IPTeamService)JSFServiceFinderUtil.getInstance().getBean("ipTeamService");
					IpTeam ipTeam = ipTeamService.findIpTeamById(bean.getUserComboItem().getValue1());
					if (ipTeam!=null && (ipTeam.getTier2Team()==null || !ipTeam.getTier2Team().equalsIgnoreCase("Y"))) {
						String teamTier2 = "";
						List<IpTeam> ipTeamList = ipTeamService.getTier2TeamList();
						for (IpTeam t2team : ipTeamList) {
							if (teamTier2.length()==0) teamTier2 = t2team.getTeamName();
							else teamTier2 = teamTier2+", "+t2team.getTeamName();
						}
						IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0098"),bean.getUserComboItem().getLabel(),teamTier2));
//						return;
					}
				}
			    if(bean.getRoleComboItem()!=null){
				   bean.getIpRoleMember().setRoleId(bean.getRoleComboItem().getValue());
				}
				if(bean.getUserComboItem().getValue()!=null){
				bean.getIpRoleMember().setUserId(bean.getUserComboItem().getValue());
				bean.getIpRoleMember().setUserName(bean.getUserComboItem().getLabel());
				}
				bean.getIpRoleMember().setCreatedBy(bean.getUserInfo().getUserId());
				bean.getIpRoleMember().setLastUpdBy(bean.getUserInfo().getUserId());
				List<IpRoleMember>   roleDataList = userProfileService.addRole(bean.getIpRoleMember());
				bean.setRoleDataList(roleDataList);
				bean.setUserComboItem(null);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				
				setUserProfileBean(bean);
			  }
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void updateValueBeforeDeleteRole(){
		String roleId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("roleId").toString();
		String userId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId").toString();
		String userName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userName").toString();
		UserProfileBean bean =  getUserProfileBean();
		bean.getIpRoleMember().setRoleId(roleId);
		bean.getIpRoleMember().setUserId(userId);
		bean.getIpRoleMember().setUserName(userName);
		setUserProfileBean(bean);
	}
	
	public void deleteRole(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 try {
			List<IpRoleMember>   roleDataList = userProfileService.deleteRole(bean.getIpRoleMember());
			bean.setRoleDataList(roleDataList);
			setUserProfileBean(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
	}
		
	public void addDelegateAdmin(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 try {
			if(validate()){
				
				IpDelegateUserId ipDelegateUserId  = new IpDelegateUserId(bean.getUserIdComboItem().getValue(), bean.getDelegateComboItem().getValue());
				bean.getIpDelegateUser().setId(ipDelegateUserId);
				bean.getIpDelegateUser().setCreatedBy(bean.getUserInfo().getUserId());
				bean.getIpDelegateUser().setLastUpdBy(bean.getUserInfo().getUserId());
				List<IpDelegateUser>   delegateDataList = userProfileService.addDelegate(bean.getIpDelegateUser(),bean.getUserInfo());
				bean.setDelegateDataList(delegateDataList);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				bean.setDelegateComboItem(null);
				bean.getIpDelegateUser().setStartDate(null);
				bean.getIpDelegateUser().setEndDate(null);
				setUserProfileBean(bean);
			}
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}

	public void addRoleAdmin(){
		 UserProfileService userProfileService = (UserProfileService)JSFServiceFinderUtil.getInstance().getBean("userProfileService");
		 UserProfileBean bean =  getUserProfileBean();
		 try {
			  if(validateRole()){
				  if(bean.getRoleVisible()){
					  if (bean.getRoleComboItem().getValue().equalsIgnoreCase("R04") ){
						  IPTeamService ipTeamService = (IPTeamService)JSFServiceFinderUtil.getInstance().getBean("ipTeamService");
							IpTeam ipTeam = ipTeamService.findIpTeamById(bean.getUserComboItem().getValue1());
							if (ipTeam!=null && (ipTeam.getTier2Team()==null || !ipTeam.getTier2Team().equalsIgnoreCase("Y"))) {
								String teamTier2 = "";
								List<IpTeam> ipTeamList = ipTeamService.getTier2TeamList();
								for (IpTeam t2team : ipTeamList) {
									if (teamTier2.length()==0) teamTier2 = t2team.getTeamName();
									else teamTier2 = teamTier2+", "+t2team.getTeamName();
								}
								IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0098"),bean.getUserComboItem().getLabel(),teamTier2));
			//							return;
							}
					  }
				  }
				  if(bean.getRoleAllVisible()){
					  if ( bean.getRoleAllComboItem().getValue().equalsIgnoreCase("R04")){
						  IPTeamService ipTeamService = (IPTeamService)JSFServiceFinderUtil.getInstance().getBean("ipTeamService");
							IpTeam ipTeam = ipTeamService.findIpTeamById(bean.getUserComboItem().getValue1());
							if (ipTeam!=null && (ipTeam.getTier2Team()==null || !ipTeam.getTier2Team().equalsIgnoreCase("Y"))) {
								String teamTier2 = "";
								List<IpTeam> ipTeamList = ipTeamService.getTier2TeamList();
								for (IpTeam t2team : ipTeamList) {
									if (teamTier2.length()==0) teamTier2 = t2team.getTeamName();
									else teamTier2 = teamTier2+", "+t2team.getTeamName();
								}
								IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0098"),bean.getUserComboItem().getLabel(),teamTier2));
			//							return;
							}
					  }
				  }
			    if(bean.getRoleComboItem()!=null || bean.getRoleAllComboItem()!=null ){
				      if(bean.getRoleVisible()){
					   bean.getIpRoleMember().setRoleId(bean.getRoleComboItem().getValue());
				      }
				      if(bean.getRoleAllVisible()){
				       bean.getIpRoleMember().setRoleId(bean.getRoleAllComboItem().getValue());  
				      }
				}
				if(bean.getUserIdComboItem().getValue()!=null){
				bean.getIpRoleMember().setUserId(bean.getUserComboItem().getValue());
				bean.getIpRoleMember().setUserName(bean.getUserComboItem().getLabel());
				}
				bean.getIpRoleMember().setCreatedBy(IPFMWebUtil.getUserId());
				bean.getIpRoleMember().setLastUpdBy(IPFMWebUtil.getUserId());
				List<IpRoleMember>   roleDataList = userProfileService.addRole(bean.getIpRoleMember());
				bean.setRoleDataList(roleDataList);
				bean.setUserComboItem(null);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				setUserProfileBean(bean);
			  }
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	
	
	public boolean validateSave() {
    	boolean flgValid = true;
    	UserProfileBean bean =  getUserProfileBean();

		if(IPFMUtils.ifBlank(bean.getUserInfo().getTel(), "").trim().length()==0 && IPFMUtils.ifBlank(bean.getUserInfo().getMobile(), "").trim().length()==0){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0046")));
			flgValid = false;
		}
		

	return flgValid;
	}
	

	public boolean validateRole() {
    	boolean flgValid = true;
    	UserProfileBean bean =  getUserProfileBean();
    	if (bean.getRoleVisible()) {    		
    		if(IPFMUtils.ifBlank(bean.getRoleComboItem().getLabel(),"").length()==0){
    			if(IPFMUtils.ifBlank(bean.getRoleComboItem().getValue(),"").trim().length()==0){
    				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Role Name"));
    				flgValid = false;
    			}
    		}else{
    			if((bean.getRoleComboItem().getValue()==null) && bean.getRoleComboItem().getLabel().trim().length()>0){
    				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Role Name"));
    				flgValid = false;
    			}
    		}
    	}
    	if (bean.getRoleAllVisible()) {
    		if(IPFMUtils.ifBlank(bean.getRoleAllComboItem().getLabel(),"").length()==0){
    			if(IPFMUtils.ifBlank(bean.getRoleAllComboItem().getValue(),"").length()==0){
		    		IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Role Name"));
					flgValid = false;
		    	}
    		}else{
    			if((bean.getRoleAllComboItem().getValue()==null) && bean.getRoleAllComboItem().getLabel().trim().length()>0){
    				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Role Name"));
    				flgValid = false;
    			}
    		}
    	}
    	if(IPFMUtils.ifBlank(bean.getUserComboItem().getLabel(),"").length()==0){
    		if(IPFMUtils.ifBlank(bean.getUserComboItem().getValue(),"").length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "User"));
				flgValid = false;
			}
    	}else{
			if((bean.getUserComboItem().getValue()==null) && bean.getUserComboItem().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "User"));
				flgValid = false;
			}
    	}

    	return flgValid;
	}
	
	@Override
	public boolean validate() {
    	boolean flgValid = true;
    	UserProfileBean bean =  getUserProfileBean();
    	DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy",new Locale("en","EN"));
    	try {
    		if(IPFMUtils.ifBlank(bean.getDelegateComboItem().getLabel(),"").length()==0){
        		if(IPFMUtils.ifBlank(bean.getDelegateComboItem().getValue(),"").length()==0){
    				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Delegate To"));
    				flgValid = false;
    			}
        	}else{
    			if((bean.getDelegateComboItem().getValue()==null) && bean.getDelegateComboItem().getLabel().trim().length()>0){
    				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Delegate To"));
    				flgValid = false;
    			}
        	}
			if(bean.getIpDelegateUser().getStartDate()==null){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Start Date"));
				flgValid = false;
			}
			
			if(bean.getIpDelegateUser().getEndDate()==null){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "End Date"));
				flgValid = false;
			}
			if(bean.getIpDelegateUser().getStartDate()!=null && bean.getIpDelegateUser().getEndDate()!=null){
				if(bean.getIpDelegateUser().getStartDate().after(bean.getIpDelegateUser().getEndDate()) ){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
					flgValid = false;
				}else if(dfm.format(bean.getIpDelegateUser().getStartDate()).compareTo(dfm.format(IPFMDataUtility.getCurrentDate()))<0){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0041")));
					flgValid = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	return flgValid;
	}
	
	public String gotoUserProfile(){
		changeComboRole();
		return "ISSMS007";
	}
}
