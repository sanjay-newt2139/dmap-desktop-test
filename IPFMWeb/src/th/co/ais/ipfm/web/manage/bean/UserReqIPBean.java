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
	
	public UserSession getUserSession() {
		return userSession;
	}
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
	public List<IpUrAttachment> getDiagramList() {
		return diagramList;
	}
	public void setDiagramList(List<IpUrAttachment> diagramList) {
		this.diagramList = diagramList;
	}
	public List<IpUrAttachment> getAppFlowList() {
		return appFlowList;
	}
	public void setAppFlowList(List<IpUrAttachment> appFlowList) {
		this.appFlowList = appFlowList;
	}
	public List<SelectItem> getNwTypeList() {
		return nwTypeList;
	}
	public void setNwTypeList(List<SelectItem> nwTypeList) {
		this.nwTypeList = nwTypeList;
	}
	public List<SelectItem> getNwZoneList() {
		return nwZoneList;
	}
	public void setNwZoneList(List<SelectItem> nwZoneList) {
		this.nwZoneList = nwZoneList;
	}
	public IPFMRichComboItem getNwTypeComboItem() {
		return nwTypeComboItem;
	}
	public void setNwTypeComboItem(IPFMRichComboItem nwTypeComboItem) {
		this.nwTypeComboItem = nwTypeComboItem;
	}
	public IPFMRichComboItem getNwZoneComboItem() {
		return nwZoneComboItem;
	}
	public void setNwZoneComboItem(IPFMRichComboItem nwZoneComboItem) {
		this.nwZoneComboItem = nwZoneComboItem;
	}
	public IPFMRichComboItem getOfficeUserComboItem() {
		return officeUserComboItem;
	}
	public void setOfficeUserComboItem(IPFMRichComboItem officeUserComboItem) {
		this.officeUserComboItem = officeUserComboItem;
	}
	public List<SelectItem> getOfficeUserList() {
		return officeUserList;
	}
	public void setOfficeUserList(List<SelectItem> officeUserList) {
		this.officeUserList = officeUserList;
	}
	public List<SelectItem> getIpTypeList() {
		return ipTypeList;
	}
	public void setIpTypeList(List<SelectItem> ipTypeList) {
		this.ipTypeList = ipTypeList;
	}
	public List<SelectItem> getDataList() {
		return DataList;
	}
	public void setDataList(List<SelectItem> dataList) {
		DataList = dataList;
	}
	public IpUrIpDetail getIpUrIpDetail() {
		return ipUrIpDetail;
	}
	public void setIpUrIpDetail(IpUrIpDetail ipUrIpDetail) {
		this.ipUrIpDetail = ipUrIpDetail;
	}
	public IPFMRichComboItem getReqTeamComboItem() {
		return reqTeamComboItem;
	}
	public void setReqTeamComboItem(IPFMRichComboItem reqTeamComboItem) {
		this.reqTeamComboItem = reqTeamComboItem;
	}
	public IPFMRichComboItem getProjComboItem() {
		return projComboItem;
	}
	public void setProjComboItem(IPFMRichComboItem projComboItem) {
		this.projComboItem = projComboItem;
	}
	public IPFMRichComboItem getProjManagerComboItem() {
		return projManagerComboItem;
	}
	public void setProjManagerComboItem(IPFMRichComboItem projManagerComboItem) {
		this.projManagerComboItem = projManagerComboItem;
	}
	public IPFMRichComboItem getSystemOwnerComboItem() {
		return systemOwnerComboItem;
	}
	public void setSystemOwnerComboItem(IPFMRichComboItem systemOwnerComboItem) {
		this.systemOwnerComboItem = systemOwnerComboItem;
	}
	public IPFMRichComboItem getSystemOwnerTeamComboItem() {
		return systemOwnerTeamComboItem;
	}
	public void setSystemOwnerTeamComboItem(
			IPFMRichComboItem systemOwnerTeamComboItem) {
		this.systemOwnerTeamComboItem = systemOwnerTeamComboItem;
	}
	public List<SelectItem> getProjList() {
		return projList;
	}
	public void setProjList(List<SelectItem> projList) {
		this.projList = projList;
	}
	public List<SelectItem> getReqTeamList() {
		return reqTeamList;
	}
	public void setReqTeamList(List<SelectItem> reqTeamList) {
		this.reqTeamList = reqTeamList;
	}
	public List<SelectItem> getProjManagerList() {
		return projManagerList;
	}
	public void setProjManagerList(List<SelectItem> projManagerList) {
		this.projManagerList = projManagerList;
	}
	public List<SelectItem> getSystemOwnerList() {
		return systemOwnerList;
	}
	public void setSystemOwnerList(List<SelectItem> systemOwnerList) {
		this.systemOwnerList = systemOwnerList;
	}
	public List<SelectItem> getSystemOwnerTeamList() {
		return systemOwnerTeamList;
	}
	public void setSystemOwnerTeamList(List<SelectItem> systemOwnerTeamList) {
		this.systemOwnerTeamList = systemOwnerTeamList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public IPFMRichComboItem getDataComboItem() {
		return dataComboItem;
	}
	public void setDataComboItem(IPFMRichComboItem dataComboItem) {
		this.dataComboItem = dataComboItem;
	}
	public List<SelectItem> getManagerApproveList() {
		return managerApproveList;
	}
	public void setManagerApproveList(List<SelectItem> managerApproveList) {
		this.managerApproveList = managerApproveList;
	}
	public List<IPFMRichComboItem> getSelectManagerApproveList() {
		return selectManagerApproveList;
	}
	public void setSelectManagerApproveList(
			List<IPFMRichComboItem> selectManagerApproveList) {
		this.selectManagerApproveList = selectManagerApproveList;
	}
	public List<IpUrActionHistory> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(List<IpUrActionHistory> historyList) {
		this.historyList = historyList;
	}
	public List<IpUrAction> getUrActionList() {
		return urActionList;
	}
	public void setUrActionList(List<IpUrAction> urActionList) {
		this.urActionList = urActionList;
	}
	public IpInfo getIpInfo() {
		return ipInfo;
	}
	public void setIpInfo(IpInfo ipInfo) {
		this.ipInfo = ipInfo;
	}
	public List<IpUrIpResult> getIpUrIpResultList() {
		return ipUrIpResultList;
	}
	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) {
		this.ipUrIpResultList = ipUrIpResultList;
	}
	public List<ExcelErrorMsg> getErrorMsgList() {
		return errorMsgList;
	}
	public void setErrorMsgList(List<ExcelErrorMsg> errorMsgList) {
		this.errorMsgList = errorMsgList;
	}
	public String getAttachType() {
		return attachType;
	}
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	public List<IpLevel2> getIpLevel2List() {
		return ipLevel2List;
	}
	public void setIpLevel2List(List<IpLevel2> ipLevel2List) {
		this.ipLevel2List = ipLevel2List;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public IPFMRichComboItem getCompanyComboItem() {
		return companyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) {
		this.companyComboItem = companyComboItem;
	}
	public IPFMRichComboItem getIpTypeComboItem() {
		return ipTypeComboItem;
	}
	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) {
		this.ipTypeComboItem = ipTypeComboItem;
	}
	public IpUrIpResult getIpUrIpResult() {
		return ipUrIpResult;
	}
	public void setIpUrIpResult(IpUrIpResult ipUrIpResult) {
		this.ipUrIpResult = ipUrIpResult;
	}
	public boolean isProjManagerDisable() {
		return projManagerDisable;
	}
	public void setProjManagerDisable(boolean projManagerDisable) {
		this.projManagerDisable = projManagerDisable;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public IPFMRichComboItem getLocationComboItem() {
		return locationComboItem;
	}
	public void setLocationComboItem(IPFMRichComboItem locationComboItem) {
		this.locationComboItem = locationComboItem;
	}
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public int getIpInfoIndex() {
		return ipInfoIndex;
	}
	public void setIpInfoIndex(int ipInfoIndex) {
		this.ipInfoIndex = ipInfoIndex;
	}
	public HtmlDataTable getIpResultDataTable() {
		return ipResultDataTable;
	}
	public void setIpResultDataTable(HtmlDataTable ipResultDataTable) {
		this.ipResultDataTable = ipResultDataTable;
	}
	public List<IpInfo> getIpInfoList() {
		return ipInfoList;
	}
	public void setIpInfoList(List<IpInfo> ipInfoList) {
		this.ipInfoList = ipInfoList;
	}
	public String getIsAttach1() {
		return isAttach1;
	}
	public void setIsAttach1(String isAttach1) {
		this.isAttach1 = isAttach1;
	}
	public String getIsAttach2() {
		return isAttach2;
	}
	public void setIsAttach2(String isAttach2) {
		this.isAttach2 = isAttach2;
	}
	public IpUrAction getIpUrAction() {
		return ipUrAction;
	}
	public void setIpUrAction(IpUrAction ipUrAction) {
		this.ipUrAction = ipUrAction;
	}
	public String getAssignResultIP() {
		String assignResultIP = "";
	    for (IpUrIpResult ipResult : this.getIpUrIpResultList()) {
	    	for (IpInfo ipInfo : ipResult.getIpInfoList()) {
	    		assignResultIP += (assignResultIP==null||assignResultIP.trim().length()==0) ? ipInfo.getIpAddress() : "<br>"+ipInfo.getIpAddress();
	    	}
	    }
	    return assignResultIP;
	}
	public SearchIP getSearchIP() {
		return searchIP;
	}
	public void setSearchIP(SearchIP searchIP) {
		this.searchIP = searchIP;
	}
	public SearchIP getSearchIP1() {
		return searchIP1;
	}
	public void setSearchIP1(SearchIP searchIP1) {
		this.searchIP1 = searchIP1;
	}
	public boolean isSearchIPCheckAll() {
		return searchIPCheckAll;
	}
	public void setSearchIPCheckAll(boolean searchIPCheckAll) {
		this.searchIPCheckAll = searchIPCheckAll;
	}
	public boolean isProjNameDisable() {
		return projNameDisable;
	}
	public void setProjNameDisable(boolean projNameDisable) {
		this.projNameDisable = projNameDisable;
	}
	public HtmlDataTable getSearchIPDataTable() {
		return searchIPDataTable;
	}
	public void setSearchIPDataTable(HtmlDataTable searchIPDataTable) {
		this.searchIPDataTable = searchIPDataTable;
	}
	public List<SelectItem> getNewSystemOwnerTeamList() {
		return newSystemOwnerTeamList;
	}
	public void setNewSystemOwnerTeamList(List<SelectItem> newSystemOwnerTeamList) {
		this.newSystemOwnerTeamList = newSystemOwnerTeamList;
	}
	public String getSysOwnerEmail() {
		return sysOwnerEmail;
	}
	public void setSysOwnerEmail(String sysOwnerEmail) {
		this.sysOwnerEmail = sysOwnerEmail;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public HtmlSuggestionBox getSuggestSystemOwner() {
		return suggestSystemOwner;
	}
	public void setSuggestSystemOwner(HtmlSuggestionBox suggestSystemOwner) {
		this.suggestSystemOwner = suggestSystemOwner;
	}
	public HtmlSuggestionBox getSuggestProjManager() {
		return suggestProjManager;
	}
	public void setSuggestProjManager(HtmlSuggestionBox suggestProjManager) {
		this.suggestProjManager = suggestProjManager;
	}
	public String getExpireDateDefault() {
		return expireDateDefault;
	}
	public void setExpireDateDefault(String expireDateDefault) {
		this.expireDateDefault = expireDateDefault;
	}
	public void setFilterIpsur001History(FilterBean filterIpsur001History) {
		this.filterIpsur001History = filterIpsur001History;
	}
	public FilterBean getFilterIpsur001History() {
		return filterIpsur001History;
	}
	public void setFilterIpsur001SearchIP(FilterBean filterIpsur001SearchIP) {
		this.filterIpsur001SearchIP = filterIpsur001SearchIP;
	}
	public FilterBean getFilterIpsur001SearchIP() {
		return filterIpsur001SearchIP;
	}
	public void setSort01(SortColumnBean sort01) {
		this.sort01 = sort01;
	}
	public SortColumnBean getSort01() {
		return sort01;
	}
	public void setFilter01(FilterBean filter01) {
		this.filter01 = filter01;
	}
	public FilterBean getFilter01() {
		return filter01;
	}
	public void setFilter012(FilterBean filter012) {
		this.filter012 = filter012;
	}
	public FilterBean getFilter012() {
		return filter012;
	}
	public void setSortV01(SortColumnBean sortV01) {
		this.sortV01 = sortV01;
	}
	public SortColumnBean getSortV01() {
		return sortV01;
	}
	public void setFilterV01(FilterBean filterV01) {
		this.filterV01 = filterV01;
	}
	public FilterBean getFilterV01() {
		return filterV01;
	}
	public FilterBean getFilter00405() {
		return filter00405;
	}
	public void setFilter00405(FilterBean filter00405) {
		this.filter00405 = filter00405;
	}
	public FilterBean getFilter00406() {
		return filter00406;
	}
	public void setFilter00406(FilterBean filter00406) {
		this.filter00406 = filter00406;
	}
	public FilterBean getFilter00408() {
		return filter00408;
	}
	public void setFilter00408(FilterBean filter00408) {
		this.filter00408 = filter00408;
	}
	public FilterBean getFilter00409() {
		return filter00409;
	}
	public void setFilter00409(FilterBean filter00409) {
		this.filter00409 = filter00409;
	}
	public FilterBean getFilter00410() {
		return filter00410;
	}
	public void setFilter00410(FilterBean filter00410) {
		this.filter00410 = filter00410;
	}
	public void setSortIpsur001History(SortColumnBean sortIpsur001History) {
		this.sortIpsur001History = sortIpsur001History;
	}
	public SortColumnBean getSortIpsur001History() {
		return sortIpsur001History;
	}
	public void setSort00405(SortColumnBean sort00405) {
		this.sort00405 = sort00405;
	}
	public SortColumnBean getSort00405() {
		return sort00405;
	}
	 
	
}
