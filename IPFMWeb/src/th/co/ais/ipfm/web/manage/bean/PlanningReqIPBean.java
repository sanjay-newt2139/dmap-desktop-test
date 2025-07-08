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
  
	private static final long serialVersionUID = 1L;
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
	
	public List<SelectItem> getNwDiagramList() {
		return nwDiagramList;
	}
	public void setNwDiagramList(List<SelectItem> nwDiagramList) {
		this.nwDiagramList = nwDiagramList;
	}
	public List<SelectItem> getApDiagramList() {
		return apDiagramList;
	}
	public void setApDiagramList(List<SelectItem> apDiagramList) {
		this.apDiagramList = apDiagramList;
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
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getLastUpdBy() {
		return lastUpdBy;
	}
	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	public Date getLastUpd() {
		return lastUpd;
	}
	public void setLastUpd(Date lastUpd) {
		this.lastUpd = lastUpd;
	}
	public boolean isModeNew() {
		return modeNew;
	}
	public void setModeNew(boolean modeNew) {
		this.modeNew = modeNew;
	}
	public boolean isModeUpdate() {
		return modeUpdate;
	}
	public void setModeUpdate(boolean modeUpdate) {
		this.modeUpdate = modeUpdate;
	}
	public boolean isModeApprove() {
		return modeApprove;
	}
	public void setModeApprove(boolean modeApprove) {
		this.modeApprove = modeApprove;
	}
	public boolean isModeAssign() {
		return modeAssign;
	}
	public void setModeAssign(boolean modeAssign) {
		this.modeAssign = modeAssign;
	}
	
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public IPFMRichComboItem getLocationComboItem() {
		return locationComboItem;
	}
	public void setLocationComboItem(IPFMRichComboItem locationComboItem) {
		this.locationComboItem = locationComboItem;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getIpTypeList() {
		return ipTypeList;
	}
	public void setIpTypeList(List<SelectItem> ipTypeList) {
		this.ipTypeList = ipTypeList;
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
	public List<SelectItem> getDataList() {
		return DataList;
	}
	public void setDataList(List<SelectItem> dataList) {
		DataList = dataList;
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
	public IpUrIpDetail getIpUrIpdetail() {
		return ipUrIpdetail;
	}
	public void setIpUrIpdetail(IpUrIpDetail ipUrIpdetail) {
		this.ipUrIpdetail = ipUrIpdetail;
	}
	public IpUrAttachment getIpUrAttachment() {
		return ipUrAttachment;
	}
	public void setIpUrAttachment(IpUrAttachment ipUrAttachment) {
		this.ipUrAttachment = ipUrAttachment;
	}
	public List<IpUrIpDetail> getPlanningAssignList() {
		return planningAssignList;
	}
	public void setPlanningAssignList(List<IpUrIpDetail> planningAssignList) {
		this.planningAssignList = planningAssignList;
	}
	public String getIsAttach() {
		return isAttach;
	}
	public void setIsAttach(String isAttach) {
		this.isAttach = isAttach;
	}
	public String getV_Mode() {
		return V_Mode;
	}
	public void setV_Mode(String vMode) {
		V_Mode = vMode;
	}
	public String getV_Action() {
		return V_Action;
	}
	public void setV_Action(String vAction) {
		V_Action = vAction;
	}
	public boolean isButtonDeleteVisible() {
		return buttonDeleteVisible;
	}
	public void setButtonDeleteVisible(boolean buttonDeleteVisible) {
		this.buttonDeleteVisible = buttonDeleteVisible;
	}
	public IpUrIpResult getIpUrIpResult() {
		return ipUrIpResult;
	}
	public void setIpUrIpResult(IpUrIpResult ipUrIpResult) {
		this.ipUrIpResult = ipUrIpResult;
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
	public IpUrAction getIpUrAction() {
		return ipUrAction;
	}
	public void setIpUrAction(IpUrAction ipUrAction) {
		this.ipUrAction = ipUrAction;
	}
	public List<IpUrAttachment> getIpUrAttachmentList() {
		return ipUrAttachmentList;
	}
	public void setIpUrAttachmentList(List<IpUrAttachment> ipUrAttachmentList) {
		this.ipUrAttachmentList = ipUrAttachmentList;
	}

	public List<IpUrIpResult> getAssignmentIPList() {
		return assignmentIPList;
	}
	public void setAssignmentIPList(List<IpUrIpResult> assignmentIPList) {
		this.assignmentIPList = assignmentIPList;
	}
	public IpLevel1 getIpLevel1() {
		return ipLevel1;
	}
	public void setIpLevel1(IpLevel1 ipLevel1) {
		this.ipLevel1 = ipLevel1;
	}
	public List<IpLevel1> getIpLevel1List() {
		return ipLevel1List;
	}
	public void setIpLevel1List(List<IpLevel1> ipLevel1List) {
		this.ipLevel1List = ipLevel1List;
	}
	public HtmlDataTable getAssignIpListDataTable() {
		return assignIpListDataTable;
	}
	public void setAssignIpListDataTable(HtmlDataTable assignIpListDataTable) {
		this.assignIpListDataTable = assignIpListDataTable;
	}
	

	public String getV_urNo() {
		return V_urNo;
	}
	public void setV_urNo(String vUrNo) {
		V_urNo = vUrNo;
	}
	
	public String getV_urStatusDesc() {
		return V_urStatusDesc;
	}
	public void setV_urStatusDesc(String vUrStatusDesc) {
		V_urStatusDesc = vUrStatusDesc;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public Map<Long, Boolean> getChecked() {
		return checked;
	}
	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
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
	public List<IpUrIpResult> getIpUrIpResultList() {
		return ipUrIpResultList;
	}
	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) {
		this.ipUrIpResultList = ipUrIpResultList;
	}
	public HtmlDataTable getSearchIPDataTable() {
		return searchIPDataTable;
	}
	public void setSearchIPDataTable(HtmlDataTable searchIPDataTable) {
		this.searchIPDataTable = searchIPDataTable;
	}
	public String getRenderApproval() {
		return renderApproval;
	}
	public void setRenderApproval(String renderApproval) {
		this.renderApproval = renderApproval;
	}
	public HtmlSuggestionBox getSuggestSystemOwner() {
		return suggestSystemOwner;
	}
	public void setSuggestSystemOwner(HtmlSuggestionBox suggestSystemOwner) {
		this.suggestSystemOwner = suggestSystemOwner;
	}
	public String getSysOwnerTeamId() {
		return sysOwnerTeamId;
	}
	public void setSysOwnerTeamId(String sysOwnerTeamId) {
		this.sysOwnerTeamId = sysOwnerTeamId;
	}
	public List<SelectItem> getNewSystemOwnerTeamList() {
		return newSystemOwnerTeamList;
	}
	public void setNewSystemOwnerTeamList(List<SelectItem> newSystemOwnerTeamList) {
		this.newSystemOwnerTeamList = newSystemOwnerTeamList;
	}
	public void setFilterIpsur002History(FilterBean filterIpsur002History) {
		this.filterIpsur002History = filterIpsur002History;
	}
	public FilterBean getFilterIpsur002History() {
		return filterIpsur002History;
	}
	public void setFilterIpsur002SearchIP(FilterBean filterIpsur002SearchIP) {
		this.filterIpsur002SearchIP = filterIpsur002SearchIP;
	}
	public FilterBean getFilterIpsur002SearchIP() {
		return filterIpsur002SearchIP;
	}
	public void setFilterIpsur002AddAssign(FilterBean filterIpsur002AddAssign) {
		this.filterIpsur002AddAssign = filterIpsur002AddAssign;
	}
	public FilterBean getFilterIpsur002AddAssign() {
		return filterIpsur002AddAssign;
	}
	public void setFilterIpsur002V(FilterBean filterIpsur002V) {
		this.filterIpsur002V = filterIpsur002V;
	}
	public FilterBean getFilterIpsur002V() {
		return filterIpsur002V;
	}
	public void setSortIpsur002History(SortColumnBean sortIpsur002History) {
		this.sortIpsur002History = sortIpsur002History;
	}
	public SortColumnBean getSortIpsur002History() {
		return sortIpsur002History;
	}
	
	
}
