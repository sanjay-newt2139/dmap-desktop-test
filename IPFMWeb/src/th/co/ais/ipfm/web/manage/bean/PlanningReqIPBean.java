package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlSuggestionBox;

import th.co.ais.ipfm.domain1.ExcelErrorMsg;
import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUrActionHistory;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUrIpResult;
import th.co.ais.ipfm.domain1.SearchIP;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;


public class PlanningReqIPBean implements Serializable{
  
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private int  count;
	private String isAttach;
	private String V_Mode; 
	private String V_Action;
	private String V_urNo;
	private String V_urStatusDesc;
	private boolean buttonDeleteVisible ;
	private String attachType = "";
	private String renderApproval="";
	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();

	private IpUrIpDetail ipUrIpdetail = new IpUrIpDetail();
	private IpUrAttachment ipUrAttachment = new IpUrAttachment();
	private IpUrIpResult   ipUrIpResult = new IpUrIpResult();
	private IpUrAction  ipUrAction = new IpUrAction();
	private IpLevel1  ipLevel1 = new IpLevel1();
	
	private SearchIP searchIP = new SearchIP();
	private SearchIP searchIP1;
	private boolean searchIPCheckAll = false;
	
	protected String createdBy;
	protected Date created;
	protected String lastUpdBy;
	protected Date lastUpd;
	
	private IPFMRichComboItem nwTypeComboItem;
	private IPFMRichComboItem nwZoneComboItem;
	private IPFMRichComboItem locationComboItem;
	private IPFMRichComboItem companyComboItem;
	private IPFMRichComboItem ipTypeComboItem;
	private IPFMRichComboItem systemOwnerComboItem;
	private IPFMRichComboItem systemOwnerTeamComboItem;

	
	private List<SelectItem> nwTypeList;
	private List<SelectItem> nwZoneList;
	private List<SelectItem> locationList;
	private List<SelectItem> companyList;
	private List<SelectItem> ipTypeList;
	private List<SelectItem> DataList;
	private List<SelectItem> systemOwnerList;
	private List<SelectItem> systemOwnerTeamList;
	private List<SelectItem> newSystemOwnerTeamList;
	
	private List<IpUrIpDetail> planningAssignList;
	private List<IpUrActionHistory> historyList;
	private List<IpUrAction> urActionList;
	private List<IpUrAttachment> ipUrAttachmentList;
	private List<IpUrIpResult> assignmentIPList;
	private List<IpLevel1> ipLevel1List;
	
	private boolean modeNew =true;
	private boolean modeUpdate =false;
	private boolean modeApprove =false;
	private boolean modeAssign =false;
	
	private List<SelectItem> nwDiagramList;
	private List<SelectItem> apDiagramList;
	private HtmlDataTable searchIPDataTable;
	private HtmlDataTable assignIpListDataTable;
	private List<ExcelErrorMsg> errorMsgList = new ArrayList<ExcelErrorMsg>();
	private List<IpUrIpResult> ipUrIpResultList = new ArrayList<IpUrIpResult>();
	
	private HtmlSuggestionBox suggestSystemOwner = new HtmlSuggestionBox();
	private String sysOwnerTeamId = "";
 	
	private SortColumnBean sortIpsur002History = new SortColumnBean();
	private FilterBean filterIpsur002History = new FilterBean();
	private FilterBean filterIpsur002SearchIP = new FilterBean();
	
	private FilterBean filterIpsur002AddAssign = new FilterBean();
	private FilterBean filterIpsur002V = new FilterBean();
	
	public List<SelectItem> getNwDiagramList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwDiagramList
		return nwDiagramList;
	}
	public void setNwDiagramList(List<SelectItem> nwDiagramList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwDiagramList
		this.nwDiagramList = nwDiagramList;
	}
	public List<SelectItem> getApDiagramList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getApDiagramList
		return apDiagramList;
	}
	public void setApDiagramList(List<SelectItem> apDiagramList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setApDiagramList
		this.apDiagramList = apDiagramList;
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
	
	
	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		return createdBy;
	}
	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		this.createdBy = createdBy;
	}
	public Date getCreated() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreated
		return created;
	}
	public void setCreated(Date created) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreated
		this.created = created;
	}
	public String getLastUpdBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpdBy
		return lastUpdBy;
	}
	public void setLastUpdBy(String lastUpdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpdBy
		this.lastUpdBy = lastUpdBy;
	}
	public Date getLastUpd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpd
		return lastUpd;
	}
	public void setLastUpd(Date lastUpd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpd
		this.lastUpd = lastUpd;
	}
	public boolean isModeNew() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isModeNew
		return modeNew;
	}
	public void setModeNew(boolean modeNew) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setModeNew
		this.modeNew = modeNew;
	}
	public boolean isModeUpdate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isModeUpdate
		return modeUpdate;
	}
	public void setModeUpdate(boolean modeUpdate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setModeUpdate
		this.modeUpdate = modeUpdate;
	}
	public boolean isModeApprove() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isModeApprove
		return modeApprove;
	}
	public void setModeApprove(boolean modeApprove) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setModeApprove
		this.modeApprove = modeApprove;
	}
	public boolean isModeAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isModeAssign
		return modeAssign;
	}
	public void setModeAssign(boolean modeAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setModeAssign
		this.modeAssign = modeAssign;
	}
	
	public List<SelectItem> getLocationList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationList
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationList
		this.locationList = locationList;
	}
	public IPFMRichComboItem getLocationComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLocationComboItem
		return locationComboItem;
	}
	public void setLocationComboItem(IPFMRichComboItem locationComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLocationComboItem
		this.locationComboItem = locationComboItem;
	}
	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}
	public List<SelectItem> getIpTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeList
		return ipTypeList;
	}
	public void setIpTypeList(List<SelectItem> ipTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeList
		this.ipTypeList = ipTypeList;
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
	public List<SelectItem> getDataList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDataList
		return DataList;
	}
	public void setDataList(List<SelectItem> dataList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDataList
		DataList = dataList;
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
	public IpUrIpDetail getIpUrIpdetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpdetail
		return ipUrIpdetail;
	}
	public void setIpUrIpdetail(IpUrIpDetail ipUrIpdetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpdetail
		this.ipUrIpdetail = ipUrIpdetail;
	}
	public IpUrAttachment getIpUrAttachment() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachment
		return ipUrAttachment;
	}
	public void setIpUrAttachment(IpUrAttachment ipUrAttachment) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrAttachment
		this.ipUrAttachment = ipUrAttachment;
	}
	public List<IpUrIpDetail> getPlanningAssignList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPlanningAssignList
		return planningAssignList;
	}
	public void setPlanningAssignList(List<IpUrIpDetail> planningAssignList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPlanningAssignList
		this.planningAssignList = planningAssignList;
	}
	public String getIsAttach() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsAttach
		return isAttach;
	}
	public void setIsAttach(String isAttach) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsAttach
		this.isAttach = isAttach;
	}
	public String getV_Mode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getV_Mode
		return V_Mode;
	}
	public void setV_Mode(String vMode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setV_Mode
		V_Mode = vMode;
	}
	public String getV_Action() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getV_Action
		return V_Action;
	}
	public void setV_Action(String vAction) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setV_Action
		V_Action = vAction;
	}
	public boolean isButtonDeleteVisible() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isButtonDeleteVisible
		return buttonDeleteVisible;
	}
	public void setButtonDeleteVisible(boolean buttonDeleteVisible) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setButtonDeleteVisible
		this.buttonDeleteVisible = buttonDeleteVisible;
	}
	public IpUrIpResult getIpUrIpResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpResult
		return ipUrIpResult;
	}
	public void setIpUrIpResult(IpUrIpResult ipUrIpResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpResult
		this.ipUrIpResult = ipUrIpResult;
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
	public IpUrAction getIpUrAction() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAction
		return ipUrAction;
	}
	public void setIpUrAction(IpUrAction ipUrAction) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrAction
		this.ipUrAction = ipUrAction;
	}
	public List<IpUrAttachment> getIpUrAttachmentList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachmentList
		return ipUrAttachmentList;
	}
	public void setIpUrAttachmentList(List<IpUrAttachment> ipUrAttachmentList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrAttachmentList
		this.ipUrAttachmentList = ipUrAttachmentList;
	}

	public List<IpUrIpResult> getAssignmentIPList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignmentIPList
		return assignmentIPList;
	}
	public void setAssignmentIPList(List<IpUrIpResult> assignmentIPList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignmentIPList
		this.assignmentIPList = assignmentIPList;
	}
	public IpLevel1 getIpLevel1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel1
		return ipLevel1;
	}
	public void setIpLevel1(IpLevel1 ipLevel1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel1
		this.ipLevel1 = ipLevel1;
	}
	public List<IpLevel1> getIpLevel1List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel1List
		return ipLevel1List;
	}
	public void setIpLevel1List(List<IpLevel1> ipLevel1List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel1List
		this.ipLevel1List = ipLevel1List;
	}
	public HtmlDataTable getAssignIpListDataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignIpListDataTable
		return assignIpListDataTable;
	}
	public void setAssignIpListDataTable(HtmlDataTable assignIpListDataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignIpListDataTable
		this.assignIpListDataTable = assignIpListDataTable;
	}
	

	public String getV_urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getV_urNo
		return V_urNo;
	}
	public void setV_urNo(String vUrNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setV_urNo
		V_urNo = vUrNo;
	}
	
	public String getV_urStatusDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getV_urStatusDesc
		return V_urStatusDesc;
	}
	public void setV_urStatusDesc(String vUrStatusDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setV_urStatusDesc
		V_urStatusDesc = vUrStatusDesc;
	}
	public int getCount() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCount
		return count;
	}
	public void setCount(int count) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCount
		this.count = count;
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
	public Map<Long, Boolean> getChecked() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChecked
		return checked;
	}
	public void setChecked(Map<Long, Boolean> checked) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setChecked
		this.checked = checked;
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
	public List<IpUrIpResult> getIpUrIpResultList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrIpResultList
		return ipUrIpResultList;
	}
	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrIpResultList
		this.ipUrIpResultList = ipUrIpResultList;
	}
	public HtmlDataTable getSearchIPDataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIPDataTable
		return searchIPDataTable;
	}
	public void setSearchIPDataTable(HtmlDataTable searchIPDataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIPDataTable
		this.searchIPDataTable = searchIPDataTable;
	}
	public String getRenderApproval() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRenderApproval
		return renderApproval;
	}
	public void setRenderApproval(String renderApproval) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRenderApproval
		this.renderApproval = renderApproval;
	}
	public HtmlSuggestionBox getSuggestSystemOwner() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestSystemOwner
		return suggestSystemOwner;
	}
	public void setSuggestSystemOwner(HtmlSuggestionBox suggestSystemOwner) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestSystemOwner
		this.suggestSystemOwner = suggestSystemOwner;
	}
	public String getSysOwnerTeamId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSysOwnerTeamId
		return sysOwnerTeamId;
	}
	public void setSysOwnerTeamId(String sysOwnerTeamId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSysOwnerTeamId
		this.sysOwnerTeamId = sysOwnerTeamId;
	}
	public List<SelectItem> getNewSystemOwnerTeamList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNewSystemOwnerTeamList
		return newSystemOwnerTeamList;
	}
	public void setNewSystemOwnerTeamList(List<SelectItem> newSystemOwnerTeamList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNewSystemOwnerTeamList
		this.newSystemOwnerTeamList = newSystemOwnerTeamList;
	}
	public void setFilterIpsur002History(FilterBean filterIpsur002History) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpsur002History
		this.filterIpsur002History = filterIpsur002History;
	}
	public FilterBean getFilterIpsur002History() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpsur002History
		return filterIpsur002History;
	}
	public void setFilterIpsur002SearchIP(FilterBean filterIpsur002SearchIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpsur002SearchIP
		this.filterIpsur002SearchIP = filterIpsur002SearchIP;
	}
	public FilterBean getFilterIpsur002SearchIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpsur002SearchIP
		return filterIpsur002SearchIP;
	}
	public void setFilterIpsur002AddAssign(FilterBean filterIpsur002AddAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpsur002AddAssign
		this.filterIpsur002AddAssign = filterIpsur002AddAssign;
	}
	public FilterBean getFilterIpsur002AddAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpsur002AddAssign
		return filterIpsur002AddAssign;
	}
	public void setFilterIpsur002V(FilterBean filterIpsur002V) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterIpsur002V
		this.filterIpsur002V = filterIpsur002V;
	}
	public FilterBean getFilterIpsur002V() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterIpsur002V
		return filterIpsur002V;
	}
	public void setSortIpsur002History(SortColumnBean sortIpsur002History) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortIpsur002History
		this.sortIpsur002History = sortIpsur002History;
	}
	public SortColumnBean getSortIpsur002History() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortIpsur002History
		return sortIpsur002History;
	}
	
	
}
