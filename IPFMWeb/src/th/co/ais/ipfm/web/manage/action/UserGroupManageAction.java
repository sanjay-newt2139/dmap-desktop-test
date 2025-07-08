package th.co.ais.ipfm.web.manage.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPGroupMemberUser;
import th.co.ais.ipfm.domain.IPGroupMembers;
import th.co.ais.ipfm.domain.IPUserGroup;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IIPUserGroupService;
import th.co.ais.ipfm.service.UserGroupManageService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.vo.SearchResult;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.UserGroupManageBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class UserGroupManageAction extends AbstractAction {
	
	public UserGroupManageBean userGroupManageBean;
	
	
	
	public UserGroupManageBean getUserGroupManageBean() {
		return (UserGroupManageBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userGroupManageBean");
	}

	public void setUserGroupManageBean(UserGroupManageBean userGroupManageBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userGroupManageBean", userGroupManageBean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	
	@Override
	public String init(String programID) {
		IIPUserGroupService ipUserGroupService = (IIPUserGroupService)JSFServiceFinderUtil.getInstance().getBean("ipUserGroupService");
		List<SelectItem> userGroupList = new ArrayList<SelectItem>();
		UserGroupManageBean userGroupManageBean = new UserGroupManageBean();
		
		List<IPUserGroup> userGroupStringList;
		
		try {
			
			userGroupStringList = ipUserGroupService.getUserGroupList();

		 for (IPUserGroup str:((List<IPUserGroup>)userGroupStringList)) {
			 IPFMRichComboItem cbitem = new IPFMRichComboItem();
			 cbitem.setLabel(str.getUserGroupName());
			 cbitem.setValue(str.getUserGroupId());
			 userGroupList.add(new SelectItem(cbitem, cbitem.getLabel()));
		}
		    userGroupManageBean.setUserGroupList(userGroupList);
		    userGroupManageBean.setIpGroupMember(new IPGroupMemberUser());
		    setUserGroupManageBean(userGroupManageBean);
		
		} catch (IPFMBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	 return programID;
	}
	
	
	public void search(){
		UserGroupManageBean userGroupManageBean = getUserGroupManageBean();
		if(userGroupManageBean!=null){
			SearchResult searchResult = null;
			UserGroupManageService userGroupManageService = (UserGroupManageService)JSFServiceFinderUtil.getInstance().getBean("userGroupManageService");			
			try {
				
				if(userGroupManageBean.getUserGroupComboItem()!=null){
				  userGroupManageBean.setGroupId(userGroupManageBean.getUserGroupComboItem().getValue());
				}
				searchResult = userGroupManageService.searchUserGroupManage(userGroupManageBean.getGroupId(), userGroupManageBean.getMaxSearchResult());
				
				userGroupManageBean.setIpGroupMemberList(searchResult.getResultList());
				if(searchResult.isOverMaxResultLimit()){
					IPFMMessageUtils.addMessageWarn(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0014")));	
				}
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setUserGroupManageBean(userGroupManageBean);
		}
	}

	public void createUserGroupManage(){
		UserGroupManageBean userGroupManageBean = getUserGroupManageBean();
		try {
			 if(validate()){
				UserGroupManageService userGroupManageService = (UserGroupManageService)JSFServiceFinderUtil.getInstance().getBean("userGroupManageService");
				IPGroupMembers ipGroupMember  = new IPGroupMembers();

				
				ipGroupMember.setUserId(userGroupManageBean.getUserId());
				ipGroupMember.setCreatedBy(IPFMWebUtil.getUserId());
				
				ipGroupMember = userGroupManageService.createUserGroupManage(ipGroupMember);
				
				setUserGroupManageBean(userGroupManageBean);
				IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
				search();
			}			
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
	}

	
	public void updateValueBeforeDelete(){
		String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId").toString();
		UserGroupManageBean userGroupManageBean = getUserGroupManageBean();
		userGroupManageBean.setRowId(rowId);
		setUserGroupManageBean(userGroupManageBean);

	}
	
	public void delete(){
		UserGroupManageBean userGroupManageBean = getUserGroupManageBean();
		if(userGroupManageBean!=null && userGroupManageBean.getRowId()!=null && userGroupManageBean.getRowId().trim().length()>0){
			UserGroupManageService userGroupManageService = (UserGroupManageService)JSFServiceFinderUtil.getInstance().getBean("userGroupManageService");
			try {
				List<IPGroupMemberUser> ipGroupMemberList = userGroupManageService.deleteAndReSearchUserGroupManage(userGroupManageBean.getRowId(), userGroupManageBean.getGroupId());
				userGroupManageBean.setIpGroupMemberList(ipGroupMemberList);
				setUserGroupManageBean(userGroupManageBean);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cancel() {
		
		init();
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		UserGroupManageBean userGroupManageBean = getUserGroupManageBean();
		if(!(userGroupManageBean.getUserId()!=null && userGroupManageBean.getUserId().trim().length()>0)){
			IPFMMessageUtils.addMessageError("CriteriaForm:userId", IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "UserIP"));
			flgValid = false;
		}
		return flgValid;
	}

}
