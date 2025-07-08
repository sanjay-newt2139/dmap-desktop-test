package th.co.ais.ipfm.web.master.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import th.co.ais.ipfm.domain1.IpTeam;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPTeamService;
import th.co.ais.ipfm.service.TeamManageService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.master.bean.TeamManageBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class TeamManageAction extends AbstractAction {
	
	/********************** Bean ***********************/
	public TeamManageBean teamManageBean;
	public UserSession  userSession;

	public TeamManageBean getTeamManageBean() {
		return (TeamManageBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("teamManageBean");
	}

	public void setTeamMangeBeam(TeamManageBean teamManageBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("teamManageBean", teamManageBean);
	}
	public UserSession getUserSession() {
		  return (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
		}
	public void setUserSession(UserSession userSession) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", userSession);
	}
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		IPFMWebUtil.storeOnSession("fromPage", null);
		String modeBack = getRequestParameter("modeBack");
		if("ISSMS002".equals(programID)){
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			TeamManageBean bean = getTeamManageBean();
			if (bean!=null) {
				if (!(bean.getFromOutcome()!=null && bean.getFromOutcome().equalsIgnoreCase("PROFILE"))) {
					bean = new TeamManageBean();
				}
			}else{
				bean = new TeamManageBean();
			}
			SearchResult searchResult = null;
			try {
				searchResult = teamManageService.searchTeam(new IpTeam(""), ipfmConfigBean.getMaxSearchResult());
				bean.setSearchList(searchResult.getResultList());
				setTeamMangeBeam(bean);
			} catch (IPFMBusinessException e) {
				e.printStackTrace();
			}			
		}
		if("ISSMS002_02".equals(programID)){
			String teamId = getRequestParameter("teamId");
			String teamName = getRequestParameter("teamName");
			String teamDesc = getRequestParameter("teamDesc");
			String criteria = getRequestParameter("criteria");
			String profile = getRequestParameter("profile");
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("teamName", teamName);
			session.setAttribute("teamDesc", teamDesc);
			TeamManageBean bean = null;
			if (profile != null && profile.trim().equalsIgnoreCase("PROFILE")) {
				bean = new TeamManageBean();
				IPTeamService ipTeamService = (IPTeamService)JSFServiceFinderUtil.getInstance().getBean("ipTeamService");
				try {
					IpTeam team = ipTeamService.findIpTeamById(teamId);
					teamDesc = team.getTeamDesc();
					bean.setFromOutcome(profile);
				} catch (IPFMBusinessException e) {
					e.printStackTrace();
				}
			}else{
				bean = getTeamManageBean();
			}
			List<SelectItem> systemOwnerList = new ArrayList<SelectItem>();
			IPFMRichComboItem userComboItem = new IPFMRichComboItem();
			IPFMRichComboItem cbitem = null;
			List<IpUser> teamMemberList;
				try {
					List<IpUser> systemOwnerStringList = teamManageService.getSystemOwnerList();
					if(systemOwnerStringList!=null && systemOwnerStringList.size()>0){
							for (IpUser str:systemOwnerStringList) {
								cbitem = new IPFMRichComboItem();
								cbitem.setLabel(str.getUserName());
								cbitem.setValue(str.getUserId());
								systemOwnerList.add(new SelectItem(cbitem, cbitem.getLabel()));
							}
					}
					
					teamMemberList = teamManageService.getTeamMemberList(teamId);
					bean.getIpTeam().setTeamId(teamId);
					bean.getIpTeam().setTeamName(teamName);
					bean.getIpTeam().setTeamDesc(teamDesc);
					bean.setSystemOwnerList(systemOwnerList);
					bean.setTeamMemberList(teamMemberList);
					bean.setCriteria(criteria);
					
					///IPFMWebUtil.storeOnSession("fromPage", "ISSMS002");
					IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
					SearchResult searchResult = null;
					List<IpTeam> ipTeamList = null;
					searchResult = teamManageService.searchTeam(bean.getIpTeam(), ipfmConfigBean.getMaxSearchResult());
					bean.setSearchList(searchResult.getResultList());
					
					setTeamMangeBeam(bean);
				} catch (IPFMBusinessException e) {
					e.printStackTrace();
				}
		}
		if("back".equals(modeBack)){
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			TeamManageBean bean = getTeamManageBean();
			
			if (bean.getFromOutcome()!=null && bean.getFromOutcome().equalsIgnoreCase("PROFILE")) return "ISSMS007";
	
			SearchResult searchResult = null;
					try {
						searchResult = teamManageService.searchTeam(bean.getIpTeam(), ipfmConfigBean.getMaxSearchResult());
						bean.setSearchList(searchResult.getResultList());
						setTeamMangeBeam(bean);
					} catch (IPFMBusinessException e) {
						e.printStackTrace();
					}
		}
		return programID;
	}
	public void search(){
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		TeamManageBean bean = getTeamManageBean();
		SearchResult searchResult = null;
		try {	
				searchResult = teamManageService.searchTeam(bean.getIpTeam(), ipfmConfigBean.getMaxSearchResult());
				bean.setSearchList(searchResult.getResultList());
				setTeamMangeBeam(bean);
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}		
	}
	
	public void updateValueBeforeDelete(){
		String teamId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("teamId").toString();
		TeamManageBean bean = getTeamManageBean();
		bean.getIpTeam().setTeamId(teamId);
		setTeamMangeBeam(bean);
	}
	
	public void deleteTeamId(){
		TeamManageBean bean = getTeamManageBean();
		if(bean!=null && bean.getIpTeam().getTeamId()!=null && bean.getIpTeam().getTeamId().trim().length()>0){
			TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
			try {
				List<IpTeam> searchList = teamManageService.deleteTeamId(bean.getIpTeam().getTeamId());
				bean.setSearchList(searchList);
				setTeamMangeBeam(bean);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(){
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		TeamManageBean bean = getTeamManageBean();
		UserSession userSessionBean = getUserSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String curDate = sdf.format(new Date());

		try {
			if(validateAdd()){
				bean.getIpUser().setTeamId(bean.getIpTeam().getTeamId());
				bean.getIpUser().setTeamName(bean.getIpTeam().getTeamName());
				bean.getIpUser().setLastUpdBy(userSessionBean.getIpUser().getUserId());
				bean.getIpUser().setLastUpd(sdf.parse(curDate));
				if(bean.getSystemOwnerComboItem()!=null){
				  bean.getIpUser().setUserId(bean.getSystemOwnerComboItem().getValue());
				}
				List<IpUser> teamMemberList = teamManageService.addTeam(bean.getIpUser());
				bean.setTeamMemberList(teamMemberList);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
//				bean.getIpTeam().setTeamName("");
//				bean.getIpTeam().setTeamDesc("");
				bean.setSystemOwnerComboItem(null);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
				//userSessionBean.getIpUser().setTeamId(bean.getIpUser().getTeamId());
				//userSessionBean.getIpUser().setTeamName(bean.getIpUser().getTeamName());
				session.setAttribute(IPFMWebUtil.USER_SESSION, userSessionBean);
				setTeamMangeBeam(bean);
			}
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void save(){
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		TeamManageBean bean = getTeamManageBean();
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		UserSession userSessionBean = getUserSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String curDate = sdf.format(new Date());
        String teamName = bean.getIpTeam().getTeamName();
		try {
			bean.getSystemOwnerComboItem().getValue();
			bean.getIpTeam().setLastUpd(new Date());
			bean.getIpTeam().setLastUpdBy(userSessionBean.getIpUser().getLastUpdBy());
			teamManageService.saveMember(bean.getIpTeam());
			SearchResult searchResult = null;
			 bean.getIpTeam().setTeamName(bean.getCriteria());
			 searchResult = teamManageService.searchTeam(bean.getIpTeam(), ipfmConfigBean.getMaxSearchResult());
			 bean.setSearchList(searchResult.getResultList());
			 bean.getIpTeam().setTeamName(teamName);
			 bean.setSystemOwnerComboItem(null);
			setTeamMangeBeam(bean);
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));

		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void updateValueBeforeDeleteMember(){
		String userId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId").toString();
		TeamManageBean bean = getTeamManageBean();
		bean.getIpUser().setUserId(userId);
		setTeamMangeBeam(bean);
	}
	
	public void deleteMember(){
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		TeamManageBean bean = getTeamManageBean();
		UserSession userSessionBean = getUserSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String curDate = sdf.format(new Date());

		try {
			bean.getIpUser().setTeamId("");
			bean.getIpUser().setTeamName("");
			bean.getIpUser().setLastUpdBy(userSessionBean.getIpUser().getUserId());
			bean.getIpUser().setLastUpd(sdf.parse(curDate));
			List<IpUser> teamMemberList= teamManageService.getTeamMember(bean.getIpUser(),bean.getIpTeam().getTeamId());
			bean.setTeamMemberList(teamMemberList);
			setTeamMangeBeam(bean);
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void cancel(){
		TeamManageBean bean = getTeamManageBean();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		String teamName = (String) session.getAttribute("teamName");
		String teamDesc = (String) session.getAttribute("teamDesc");
		try {   
			    bean.getIpTeam().setTeamName(teamName);
			    bean.getIpTeam().setTeamDesc(teamDesc);
				setTeamMangeBeam(bean);
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public void clear(){
		TeamManageBean bean = getTeamManageBean();
		try {   
			    bean.getIpTeam().setTeamName("");
				bean.setSearchList(null);
				setTeamMangeBeam(bean);
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
	}
	
	public void popupAddTeam(){
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		UserSession userSessionBean = getUserSession();
		TeamManageBean bean = getTeamManageBean();
		try {
			String teamId = teamManageService.getTeamId();
			bean.getIpTeam().setTeamId(teamId);
			bean.getIpTeam().setTeamName("");
			bean.getIpTeam().setTeamDesc("");
			setTeamMangeBeam(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
		}
	    
	}
	
	public void addTeamManage(){
		TeamManageService teamManageService = (TeamManageService)JSFServiceFinderUtil.getInstance().getBean("teamManageService");
		UserSession userSessionBean = getUserSession();
		TeamManageBean bean = getTeamManageBean();
		SearchResult searchResult = null;
		List<IpTeam> ipTeamList = null;
		try {
			if(validate()){
					bean.getIpTeam().setCreatedBy(userSessionBean.getIpUser().getUserId());
					bean.getIpTeam().setLastUpdBy(userSessionBean.getIpUser().getUserId());
					bean.getIpTeam().setActiveStatus("Y");
					
					ipTeamList =  teamManageService.addTeamManage(bean.getIpTeam());
					bean.setSearchList(ipTeamList);
					bean.setSystemOwnerComboItem(null);
					setTeamMangeBeam(bean);
					IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			}
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	    
	}
	@Override
	public boolean validate() {
		boolean flgValid = true;
		TeamManageBean bean = getTeamManageBean();
		
		if (IPFMUtils.ifBlank(bean.getIpTeam().getTeamName(), "").trim().length()==0) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "TeamName"));
			flgValid = false;
		}
		return flgValid;
	}

	public boolean validateAdd() {
		boolean flgValid = true;
		TeamManageBean bean = getTeamManageBean();
		
		if (IPFMUtils.ifBlank(bean.getSystemOwnerComboItem().getValue(), "").trim().length()==0 && IPFMUtils.ifBlank(bean.getSystemOwnerComboItem().getLabel(), "").trim().length()==0)  {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "User"));
			flgValid = false;
		}
		return flgValid;
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get(name);
    }

}
