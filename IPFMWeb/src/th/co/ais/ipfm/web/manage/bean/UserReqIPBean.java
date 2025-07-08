package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlSuggestionBox;

import th.co.ais.ipfm.domain1.ExcelErrorMsg;
import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpLevel2;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.SearchIP;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import java.util.Date;


public class UserReqIPBean extends IPFMBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private UserSession userSession;
	private IpUrIpDetail ipUrIpDetail = new IpUrIpDetail();	
	private IpInfo ipInfo = new IpInfo();
	private IpUrIpResult ipUrIpResult = new IpUrIpResult();
	private SearchIP searchIP = new SearchIP();
	private SearchIP searchIP1;
	private boolean searchIPCheckAll = false;
	private HtmlDataTable searchIPDataTable;
	private IpUrAction ipUrAction;
	private String isAttach1;
	private String isAttach2;
	private String attachType = "";
	private boolean projManagerDisable = false;
	private boolean projNameDisable = false;
	private int ipInfoIndex = -1;
	private HtmlDataTable ipResultDataTable;
	private String managerName="";
	private String sysOwnerEmail = "";
	private IPFMRichComboItem reqTeamComboItem;
	private IPFMRichComboItem projComboItem;
	private IPFMRichComboItem projManagerComboItem;
	private IPFMRichComboItem systemOwnerComboItem;
	private IPFMRichComboItem systemOwnerTeamComboItem;
	private IPFMRichComboItem companyComboItem;
	private IPFMRichComboItem ipTypeComboItem;
	private IPFMRichComboItem nwTypeComboItem;
	private IPFMRichComboItem nwZoneComboItem;
	private IPFMRichComboItem officeUserComboItem;
	private IPFMRichComboItem dataComboItem;
	private IPFMRichComboItem locationComboItem;

	private List<SelectItem> nwTypeList;
	private List<SelectItem> nwZoneList;
	private List<SelectItem> officeUserList;
	private List<SelectItem> companyList;
	private List<SelectItem> ipTypeList;
	private List<SelectItem> DataList;
	private List<SelectItem> systemOwnerList;
	private List<SelectItem> systemOwnerTeamList;
	private List<SelectItem> newSystemOwnerTeamList;
	private List<SelectItem> projList;
	private List<SelectItem> reqTeamList;
	private List<SelectItem> projManagerList;
	private List<SelectItem> locationList;
	
	private List<IpUrAttachment> diagramList;
	private List<IpUrAttachment> appFlowList;
	
	private List<SelectItem> managerApproveList;
	private List<IPFMRichComboItem> selectManagerApproveList;
	
	private List<IpUrActionHistory> historyList;
	private List<IpUrAction> urActionList;
	
	private List<IpUrIpResult> ipUrIpResultList = new ArrayList<IpUrIpResult>();
	private List<ExcelErrorMsg> errorMsgList = new ArrayList<ExcelErrorMsg>();
	
	private List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
	private List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
	private String teamId="";
	private HtmlSuggestionBox suggestSystemOwner = new HtmlSuggestionBox();
	private HtmlSuggestionBox suggestProjManager= new HtmlSuggestionBox();
	private String expireDateDefault;
	
	private FilterBean filterIpsur001History = new FilterBean();
	private SortColumnBean sortIpsur001History = new SortColumnBean();
	
	private FilterBean filterIpsur001SearchIP = new FilterBean();	
	
	private SortColumnBean sort01 = new SortColumnBean();	
	private FilterBean filter01 = new FilterBean();	 
	private FilterBean filter012 = new FilterBean();
	
	private SortColumnBean sortV01 = new SortColumnBean();	
	private FilterBean filterV01 = new FilterBean();
	
	private FilterBean filter00405 = new FilterBean();
	private FilterBean filter00406 = new FilterBean();
	private FilterBean filter00408 = new FilterBean();
	private FilterBean filter00409 = new FilterBean();
	private FilterBean filter00410 = new FilterBean();
	
	private SortColumnBean sort00405 = new SortColumnBean();	
	
	public UserSession getUserSession() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserSession
		return userSession;
	}
	public void setUserSession(UserSession userSession) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserSession
		this.userSession = userSession;
	}
	public List<IpUrAttachment> getDiagramList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDiagramList
		return diagramList;
	}
	public void setDiagramList(List<IpUrAttachment> diagramList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDiagramList
		this.diagramList = diagramList;
	}
	public List<IpUrAttachment> getAppFlowList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAppFlowList
		return appFlowList;
	}
	public void setAppFlowList(List<IpUrAttachment> appFlowList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAppFlowList
		this.appFlowList = appFlowList;
	}
	public List<SelectItem> getNwTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwTypeList
		return nwTypeList;
	}
	public void setNwTypeList(List<SelectItem> nwTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwTypeList
		this.nwTypeList = nwTypeList;
	}
	public List<SelectItem> getNwZoneList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwZoneList
		return nwZoneList;
	}
	public void setNwZoneList(List<SelectItem> nwZoneList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwZoneList
		this.nwZoneList = nwZoneList;
	}
	public IPFMRichComboItem getNwTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwTypeComboItem
		return nwTypeComboItem;
	}
	public void setNwTypeComboItem(IPFMRichComboItem nwTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwTypeComboItem
		this.nwTypeComboItem = nwTypeComboItem;
	}
	public IPFMRichComboItem getNwZoneComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwZoneComboItem
		return nwZoneComboItem;
	}
	public void setNwZoneComboItem(IPFMRichComboItem nwZoneComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwZoneComboItem
		this.nwZoneComboItem = nwZoneComboItem;
	}
	public IPFMRichComboItem getOfficeUserComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOfficeUserComboItem
		return officeUserComboItem;
	}
	public void setOfficeUserComboItem(IPFMRichComboItem officeUserComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOfficeUserComboItem
		this.officeUserComboItem = officeUserComboItem;
	}
	public List<SelectItem> getOfficeUserList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getOfficeUserList
		return officeUserList;
	}
	public void setOfficeUserList(List<SelectItem> officeUserList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOfficeUserList
		this.officeUserList = officeUserList;
	}
	public List<SelectItem> getIpTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeList
		return ipTypeList;
	}
	public void setIpTypeList(List<SelectItem> ipTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeList
		this.ipTypeList = ipTypeList;
	}
	public List<SelectItem> getDataList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDataList
		return DataList;
	}
	public void setDataList(List<SelectItem> dataList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDataList
		DataList = dataList;
	}
	public IpUrIpDetail getIpUrIpDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpDetail
		return ipUrIpDetail;
	}
	public void setIpUrIpDetail(IpUrIpDetail ipUrIpDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpDetail
		this.ipUrIpDetail = ipUrIpDetail;
	}
	public IPFMRichComboItem getReqTeamComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqTeamComboItem
		return reqTeamComboItem;
	}
	public void setReqTeamComboItem(IPFMRichComboItem reqTeamComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqTeamComboItem
		this.reqTeamComboItem = reqTeamComboItem;
	}
	public IPFMRichComboItem getProjComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjComboItem
		return projComboItem;
	}
	public void setProjComboItem(IPFMRichComboItem projComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjComboItem
		this.projComboItem = projComboItem;
	}
	public IPFMRichComboItem getProjManagerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjManagerComboItem
		return projManagerComboItem;
	}
	public void setProjManagerComboItem(IPFMRichComboItem projManagerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerComboItem
		this.projManagerComboItem = projManagerComboItem;
	}
	public IPFMRichComboItem getSystemOwnerComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerComboItem
		return systemOwnerComboItem;
	}
	public void setSystemOwnerComboItem(IPFMRichComboItem systemOwnerComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerComboItem
		this.systemOwnerComboItem = systemOwnerComboItem;
	}
	public IPFMRichComboItem getSystemOwnerTeamComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamComboItem
		return systemOwnerTeamComboItem;
	}
	public void setSystemOwnerTeamComboItem( // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamComboItem
			IPFMRichComboItem systemOwnerTeamComboItem) {
		this.systemOwnerTeamComboItem = systemOwnerTeamComboItem;
	}
	public List<SelectItem> getProjList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjList
		return projList;
	}
	public void setProjList(List<SelectItem> projList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjList
		this.projList = projList;
	}
	public List<SelectItem> getReqTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqTeamList
		return reqTeamList;
	}
	public void setReqTeamList(List<SelectItem> reqTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqTeamList
		this.reqTeamList = reqTeamList;
	}
	public List<SelectItem> getProjManagerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjManagerList
		return projManagerList;
	}
	public void setProjManagerList(List<SelectItem> projManagerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerList
		this.projManagerList = projManagerList;
	}
	public List<SelectItem> getSystemOwnerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerList
		return systemOwnerList;
	}
	public void setSystemOwnerList(List<SelectItem> systemOwnerList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerList
		this.systemOwnerList = systemOwnerList;
	}
	public List<SelectItem> getSystemOwnerTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemOwnerTeamList
		return systemOwnerTeamList;
	}
	public void setSystemOwnerTeamList(List<SelectItem> systemOwnerTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemOwnerTeamList
		this.systemOwnerTeamList = systemOwnerTeamList;
	}
	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}
	public IPFMRichComboItem getDataComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDataComboItem
		return dataComboItem;
	}
	public void setDataComboItem(IPFMRichComboItem dataComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDataComboItem
		this.dataComboItem = dataComboItem;
	}
	public List<SelectItem> getManagerApproveList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerApproveList
		return managerApproveList;
	}
	public void setManagerApproveList(List<SelectItem> managerApproveList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setManagerApproveList
		this.managerApproveList = managerApproveList;
	}
	public List<IPFMRichComboItem> getSelectManagerApproveList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectManagerApproveList
		return selectManagerApproveList;
	}
	public void setSelectManagerApproveList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectManagerApproveList
			List<IPFMRichComboItem> selectManagerApproveList) {
		this.selectManagerApproveList = selectManagerApproveList;
	}
	public List<IpUrActionHistory> getHistoryList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHistoryList
		return historyList;
	}
	public void setHistoryList(List<IpUrActionHistory> historyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHistoryList
		this.historyList = historyList;
	}
	public List<IpUrAction> getUrActionList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrActionList
		return urActionList;
	}
	public void setUrActionList(List<IpUrAction> urActionList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrActionList
		this.urActionList = urActionList;
	}
	public IpInfo getIpInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfo
		return ipInfo;
	}
	public void setIpInfo(IpInfo ipInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfo
		this.ipInfo = ipInfo;
	}
	public List<IpUrIpResult> getIpUrIpResultList() {
		return ipUrIpResultList;
	}
	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpResultList
		this.ipUrIpResultList = ipUrIpResultList;
	}
	public List<ExcelErrorMsg> getErrorMsgList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMsgList
		return errorMsgList;
	}
	public void setErrorMsgList(List<ExcelErrorMsg> errorMsgList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMsgList
		this.errorMsgList = errorMsgList;
	}
	public String getAttachType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAttachType
		return attachType;
	}
	public void setAttachType(String attachType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAttachType
		this.attachType = attachType;
	}
	public List<IpLevel2> getIpLevel2List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2List
		return ipLevel2List;
	}
	public void setIpLevel2List(List<IpLevel2> ipLevel2List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2List
		this.ipLevel2List = ipLevel2List;
	}
	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}
	public IPFMRichComboItem getCompanyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyComboItem
		return companyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyComboItem
		this.companyComboItem = companyComboItem;
	}
	public IPFMRichComboItem getIpTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeComboItem
		return ipTypeComboItem;
	}
	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeComboItem
		this.ipTypeComboItem = ipTypeComboItem;
	}
	public IpUrIpResult getIpUrIpResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpResult
		return ipUrIpResult;
	}
	public void setIpUrIpResult(IpUrIpResult ipUrIpResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpResult
		this.ipUrIpResult = ipUrIpResult;
	}
	public boolean isProjManagerDisable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isProjManagerDisable
		return projManagerDisable;
	}
	public void setProjManagerDisable(boolean projManagerDisable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjManagerDisable
		this.projManagerDisable = projManagerDisable;
	}
	public String getManagerName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getManagerName
		return managerName;
	}
	public void setManagerName(String managerName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setManagerName
		this.managerName = managerName;
	}
	public IPFMRichComboItem getLocationComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationComboItem
		return locationComboItem;
	}
	public void setLocationComboItem(IPFMRichComboItem locationComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationComboItem
		this.locationComboItem = locationComboItem;
	}
	public List<SelectItem> getLocationList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationList
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationList
		this.locationList = locationList;
	}
	public int getIpInfoIndex() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpInfoIndex
		return ipInfoIndex;
	}
	public void setIpInfoIndex(int ipInfoIndex) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfoIndex
		this.ipInfoIndex = ipInfoIndex;
	}
	public HtmlDataTable getIpResultDataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpResultDataTable
		return ipResultDataTable;
	}
	public void setIpResultDataTable(HtmlDataTable ipResultDataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpResultDataTable
		this.ipResultDataTable = ipResultDataTable;
	}
	public List<IpInfo> getIpInfoList() {
		return ipInfoList;
	}
	public void setIpInfoList(List<IpInfo> ipInfoList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpInfoList
		this.ipInfoList = ipInfoList;
	}
	public String getIsAttach1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsAttach1
		return isAttach1;
	}
	public void setIsAttach1(String isAttach1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsAttach1
		this.isAttach1 = isAttach1;
	}
	public String getIsAttach2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsAttach2
		return isAttach2;
	}
	public void setIsAttach2(String isAttach2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsAttach2
		this.isAttach2 = isAttach2;
	}
	public IpUrAction getIpUrAction() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAction
		return ipUrAction;
	}
	public void setIpUrAction(IpUrAction ipUrAction) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrAction
		this.ipUrAction = ipUrAction;
	}
	public String getAssignResultIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignResultIP
		String assignResultIP = "";
	    for (IpUrIpResult ipResult : this.getIpUrIpResultList()) {
	    	for (IpInfo ipInfo : ipResult.getIpInfoList()) {
	    		assignResultIP += (assignResultIP==null||assignResultIP.trim().length()==0) ? ipInfo.getIpAddress() : "<br>"+ipInfo.getIpAddress();
	    	}
	    }
	    return assignResultIP;
	}
	public SearchIP getSearchIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIP
		return searchIP;
	}
	public void setSearchIP(SearchIP searchIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIP
		this.searchIP = searchIP;
	}
	public SearchIP getSearchIP1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIP1
		return searchIP1;
	}
	public void setSearchIP1(SearchIP searchIP1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIP1
		this.searchIP1 = searchIP1;
	}
	public boolean isSearchIPCheckAll() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSearchIPCheckAll
		return searchIPCheckAll;
	}
	public void setSearchIPCheckAll(boolean searchIPCheckAll) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIPCheckAll
		this.searchIPCheckAll = searchIPCheckAll;
	}
	public boolean isProjNameDisable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isProjNameDisable
		return projNameDisable;
	}
	public void setProjNameDisable(boolean projNameDisable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjNameDisable
		this.projNameDisable = projNameDisable;
	}
	public HtmlDataTable getSearchIPDataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIPDataTable
		return searchIPDataTable;
	}
	public void setSearchIPDataTable(HtmlDataTable searchIPDataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIPDataTable
		this.searchIPDataTable = searchIPDataTable;
	}
	public List<SelectItem> getNewSystemOwnerTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNewSystemOwnerTeamList
		return newSystemOwnerTeamList;
	}
	public void setNewSystemOwnerTeamList(List<SelectItem> newSystemOwnerTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNewSystemOwnerTeamList
		this.newSystemOwnerTeamList = newSystemOwnerTeamList;
	}
	public String getSysOwnerEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerEmail
		return sysOwnerEmail;
	}
	public void setSysOwnerEmail(String sysOwnerEmail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerEmail
		this.sysOwnerEmail = sysOwnerEmail;
	}
	public String getTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamId
		return teamId;
	}
	public void setTeamId(String teamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamId
		this.teamId = teamId;
	}
	public HtmlSuggestionBox getSuggestSystemOwner() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestSystemOwner
		return suggestSystemOwner;
	}
	public void setSuggestSystemOwner(HtmlSuggestionBox suggestSystemOwner) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestSystemOwner
		this.suggestSystemOwner = suggestSystemOwner;
	}
	public HtmlSuggestionBox getSuggestProjManager() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestProjManager
		return suggestProjManager;
	}
	public void setSuggestProjManager(HtmlSuggestionBox suggestProjManager) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestProjManager
		this.suggestProjManager = suggestProjManager;
	}
	public String getExpireDateDefault() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpireDateDefault
		return expireDateDefault;
	}
	public void setExpireDateDefault(String expireDateDefault) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpireDateDefault
		this.expireDateDefault = expireDateDefault;
	}
	public void setFilterIpsur001History(FilterBean filterIpsur001History) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpsur001History
		this.filterIpsur001History = filterIpsur001History;
	}
	public FilterBean getFilterIpsur001History() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpsur001History
		return filterIpsur001History;
	}
	public void setFilterIpsur001SearchIP(FilterBean filterIpsur001SearchIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpsur001SearchIP
		this.filterIpsur001SearchIP = filterIpsur001SearchIP;
	}
	public FilterBean getFilterIpsur001SearchIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpsur001SearchIP
		return filterIpsur001SearchIP;
	}
	public void setSort01(SortColumnBean sort01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSort01
		this.sort01 = sort01;
	}
	public SortColumnBean getSort01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSort01
		return sort01;
	}
	public void setFilter01(FilterBean filter01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter01
		this.filter01 = filter01;
	}
	public FilterBean getFilter01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter01
		return filter01;
	}
	public void setFilter012(FilterBean filter012) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter012
		this.filter012 = filter012;
	}
	public FilterBean getFilter012() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter012
		return filter012;
	}
	public void setSortV01(SortColumnBean sortV01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortV01
		this.sortV01 = sortV01;
	}
	public SortColumnBean getSortV01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortV01
		return sortV01;
	}
	public void setFilterV01(FilterBean filterV01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterV01
		this.filterV01 = filterV01;
	}
	public FilterBean getFilterV01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterV01
		return filterV01;
	}
	public FilterBean getFilter00405() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00405
		return filter00405;
	}
	public void setFilter00405(FilterBean filter00405) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00405
		this.filter00405 = filter00405;
	}
	public FilterBean getFilter00406() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00406
		return filter00406;
	}
	public void setFilter00406(FilterBean filter00406) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00406
		this.filter00406 = filter00406;
	}
	public FilterBean getFilter00408() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00408
		return filter00408;
	}
	public void setFilter00408(FilterBean filter00408) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00408
		this.filter00408 = filter00408;
	}
	public FilterBean getFilter00409() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00409
		return filter00409;
	}
	public void setFilter00409(FilterBean filter00409) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00409
		this.filter00409 = filter00409;
	}
	public FilterBean getFilter00410() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter00410
		return filter00410;
	}
	public void setFilter00410(FilterBean filter00410) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter00410
		this.filter00410 = filter00410;
	}
	public void setSortIpsur001History(SortColumnBean sortIpsur001History) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpsur001History
		this.sortIpsur001History = sortIpsur001History;
	}
	public SortColumnBean getSortIpsur001History() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpsur001History
		return sortIpsur001History;
	}
	public void setSort00405(SortColumnBean sort00405) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSort00405
		this.sort00405 = sort00405;
	}
	public SortColumnBean getSort00405() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSort00405
		return sort00405;
	}
	 
	
}
