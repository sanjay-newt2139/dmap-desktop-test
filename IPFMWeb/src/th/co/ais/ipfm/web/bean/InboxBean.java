package th.co.ais.ipfm.web.bean;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.ipfm.domain1.IpvMonitorReqnc;
import th.co.ais.ipfm.domain1.IpvTodoPlanningReq;
import th.co.ais.ipfm.domain1.IpvTodoReqnc;
import th.co.ais.ipfm.domain1.IpvTodoUserReq;
import th.co.ais.ipfm.domain1.IpvWatchPlanningReq;
import th.co.ais.ipfm.domain1.IpvWatchReqnc;
import th.co.ais.ipfm.domain1.IpvWatchUserReq;
import th.co.ais.ipfm.util.IPFMConstant;

public class InboxBean extends IPFMBaseBean {
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private String urNo = "";
	private String treeType = "";
	private String actionCode = "";
	private String urType = "";

	private List<IpvTodoReqnc> ipvTodoReqNC01List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC02List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC02MrgList = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC02OwnerList = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC03List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC04List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC05List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC06List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC07List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC08List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC09List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC10List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC11List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoReqnc> ipvTodoReqNC12List = new ArrayList<IpvTodoReqnc>();
	private List<IpvTodoUserReq> ipvTodoUserReq01List = new ArrayList<IpvTodoUserReq>();
	private List<IpvTodoUserReq> ipvTodoUserReq02List = new ArrayList<IpvTodoUserReq>();
	private List<IpvTodoUserReq> ipvTodoUserReq03List = new ArrayList<IpvTodoUserReq>();
	private List<IpvTodoUserReq> ipvTodoUserReq04List = new ArrayList<IpvTodoUserReq>();
	private List<IpvTodoPlanningReq> ipvTodoPlanningReq01List = new ArrayList<IpvTodoPlanningReq>();
	private List<IpvTodoPlanningReq> ipvTodoPlanningReq02List = new ArrayList<IpvTodoPlanningReq>();
	private List<IpvTodoPlanningReq> ipvTodoPlanningReq03List = new ArrayList<IpvTodoPlanningReq>();
	private List<IpvTodoPlanningReq> ipvTodoPlanningReq04List = new ArrayList<IpvTodoPlanningReq>();

	private List<IpvWatchReqnc> ipvWlNetworkConfigList = new ArrayList<IpvWatchReqnc>();
	private List<IpvWatchUserReq> ipvWlUserReqList = new ArrayList<IpvWatchUserReq>();
	private List<IpvWatchPlanningReq> ipvWlPlanningReqList = new ArrayList<IpvWatchPlanningReq>();
	private List<IpvMonitorReqnc> ipvMntNetworkConfigList = new ArrayList<IpvMonitorReqnc>();

	private SortColumnBean watchNCSortColumn = new SortColumnBean();
	private SortColumnBean watchUserIPSortColumn = new SortColumnBean();
	private SortColumnBean watchPlanSortColumn = new SortColumnBean();
	
	private SortColumnBean nCMSortColumn = new SortColumnBean();
	
	private SortColumnBean sortTodoPlan01 = new SortColumnBean();
	private SortColumnBean sortTodoPlan02 = new SortColumnBean();
	private SortColumnBean sortTodoPlan04 = new SortColumnBean();
	
	private SortColumnBean sortTodoUser01 = new SortColumnBean();
	private SortColumnBean sortTodoUser02 = new SortColumnBean();
	private SortColumnBean sortTodoUser03 = new SortColumnBean();	
	private SortColumnBean sortTodoUser04 = new SortColumnBean();
	
	private SortColumnBean sortTodoReqNC01 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC02Mrg = new SortColumnBean();
	private SortColumnBean sortTodoReqNC02Owner = new SortColumnBean();
	private SortColumnBean sortTodoReqNC03 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC05 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC11 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC12 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC06 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC07 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC08 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC09 = new SortColumnBean();
	private SortColumnBean sortTodoReqNC10 = new SortColumnBean();
	
	private FilterBean filterTodoReqNC01 = new FilterBean();
	private FilterBean filterTodoReqNC02Mrg = new FilterBean();
	private FilterBean filterTodoReqNC02Owner = new FilterBean();
	private FilterBean filterTodoReqNC03 = new FilterBean();
	private FilterBean filterTodoReqNC05 = new FilterBean();
	private FilterBean filterTodoReqNC11 = new FilterBean();
	private FilterBean filterTodoReqNC12 = new FilterBean();
	private FilterBean filterTodoReqNC06 = new FilterBean();
	private FilterBean filterTodoReqNC07 = new FilterBean();
	private FilterBean filterTodoReqNC08 = new FilterBean();
	private FilterBean filterTodoReqNC09 = new FilterBean();
	private FilterBean filterTodoReqNC10 = new FilterBean();
	 	
	private String nCMURNoFilter;
	private String nCMSubURNoFilter;
	private String nCMSubjectFilter;
	private String nCMStatusFilter;

	private String urNoFilter;
	private String subUrNoFilter;
	private String subjectFilter;
	private String statusFilter;

	private String urNoFilterU;
	private String subjectFilterU;
	private String statusFilterU;
	private String actionUserFilterU;

	private String urNoFilterP;
	private String subjectFilterP;
	private String statusFilterP;
	private String actionUserFilterP;
		
	private String filterTodoPlan01urNo;
	private String filterTodoPlan01subject;

	private String filterTodoPlan02urNo;
	private String filterTodoPlan02subject;
	private String filterTodoPlan02status;
	private String filterTodoPlan02rejectBy;
	private String filterTodoPlan02remarks;

	private String filterTodoPlan04urNo;
	private String filterTodoPlan04subject;
	private String filterTodoPlan04requestBy;
	private String filterTodoPlan04actionUser;
	
	private String filterTodoUser01urNo;
	private String filterTodoUser01subject;

	private String filterTodoUser02urNo;
	private String filterTodoUser02subject;
	private String filterTodoUser02status;
	private String filterTodoUser02rejectBy;
	private String filterTodoUser02remarks;

	private String filterTodoUser03urNo;
	private String filterTodoUser03subject;
	private String filterTodoUser03requestBy;
	private String filterTodoUser03actionUser;

	private String filterTodoUser04urNo;
	private String filterTodoUser04subject;
	private String filterTodoUser04requestBy;
	private String filterTodoUser04actionUser;
	
	public String getUrNoFilterU() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNoFilterU
		return urNoFilterU;
	}

	public void setUrNoFilterU(String urNoFilterU) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNoFilterU
		this.urNoFilterU = urNoFilterU;
	}

	public String getSubjectFilterU() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubjectFilterU
		return subjectFilterU;
	}

	public void setSubjectFilterU(String subjectFilterU) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubjectFilterU
		this.subjectFilterU = subjectFilterU;
	}

	public String getStatusFilterU() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatusFilterU
		return statusFilterU;
	}

	public void setStatusFilterU(String statusFilterU) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatusFilterU
		this.statusFilterU = statusFilterU;
	}

	public String getActionUserFilterU() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUserFilterU
		return actionUserFilterU;
	}

	public void setActionUserFilterU(String actionUserFilterU) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionUserFilterU
		this.actionUserFilterU = actionUserFilterU;
	}

	public String getUrNoFilterP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNoFilterP
		return urNoFilterP;
	}

	public void setUrNoFilterP(String urNoFilterP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNoFilterP
		this.urNoFilterP = urNoFilterP;
	}

	public String getSubjectFilterP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubjectFilterP
		return subjectFilterP;
	}

	public void setSubjectFilterP(String subjectFilterP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubjectFilterP
		this.subjectFilterP = subjectFilterP;
	}

	public String getStatusFilterP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatusFilterP
		return statusFilterP;
	}

	public void setStatusFilterP(String statusFilterP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatusFilterP
		this.statusFilterP = statusFilterP;
	}

	public String getActionUserFilterP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionUserFilterP
		return actionUserFilterP;
	}

	public void setActionUserFilterP(String actionUserFilterP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionUserFilterP
		this.actionUserFilterP = actionUserFilterP;
	}

	public String getSubUrNoFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubUrNoFilter
		return subUrNoFilter;
	}

	public void setSubUrNoFilter(String subUrNoFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubUrNoFilter
		this.subUrNoFilter = subUrNoFilter;
	}

	public String getSubjectFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubjectFilter
		return subjectFilter;
	}

	public void setSubjectFilter(String subjectFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubjectFilter
		this.subjectFilter = subjectFilter;
	}

	public String getStatusFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatusFilter
		return statusFilter;
	}

	public void setStatusFilter(String statusFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatusFilter
		this.statusFilter = statusFilter;
	}

	public String getUrNoFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNoFilter
		return urNoFilter;
	}

	public void setUrNoFilter(String urNoFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNoFilter
		this.urNoFilter = urNoFilter;
	}

	public InboxBean() {

	}

	public String getTreeType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTreeType
		return treeType;
	}

	public void setTreeType(String treeType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTreeType
		this.treeType = treeType;
	}

	public String getActionCode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionCode
		return actionCode;
	}

	public void setActionCode(String actionCode) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionCode
		this.actionCode = actionCode;
	}

	public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
		return urType;
	}

	public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
		this.urType = urType;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC01List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC01List
		return ipvTodoReqNC01List;
	}

	public void setIpvTodoReqNC01List(List<IpvTodoReqnc> ipvTodoReqNC01List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC01List
		this.ipvTodoReqNC01List = ipvTodoReqNC01List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC02List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC02List
		return ipvTodoReqNC02List;
	}

	public void setIpvTodoReqNC02List(List<IpvTodoReqnc> ipvTodoReqNC02List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC02List
		this.ipvTodoReqNC02List = ipvTodoReqNC02List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC03List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC03List
		return ipvTodoReqNC03List;
	}

	public void setIpvTodoReqNC03List(List<IpvTodoReqnc> ipvTodoReqNC03List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC03List
		this.ipvTodoReqNC03List = ipvTodoReqNC03List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC04List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC04List
		return ipvTodoReqNC04List;
	}

	public void setIpvTodoReqNC04List(List<IpvTodoReqnc> ipvTodoReqNC04List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC04List
		this.ipvTodoReqNC04List = ipvTodoReqNC04List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC05List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC05List
		return ipvTodoReqNC05List;
	}

	public void setIpvTodoReqNC05List(List<IpvTodoReqnc> ipvTodoReqNC05List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC05List
		this.ipvTodoReqNC05List = ipvTodoReqNC05List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC06List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC06List
		return ipvTodoReqNC06List;
	}

	public void setIpvTodoReqNC06List(List<IpvTodoReqnc> ipvTodoReqNC06List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC06List
		this.ipvTodoReqNC06List = ipvTodoReqNC06List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC07List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC07List
		return ipvTodoReqNC07List;
	}

	public void setIpvTodoReqNC07List(List<IpvTodoReqnc> ipvTodoReqNC07List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC07List
		this.ipvTodoReqNC07List = ipvTodoReqNC07List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC08List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC08List
		return ipvTodoReqNC08List;
	}

	public void setIpvTodoReqNC08List(List<IpvTodoReqnc> ipvTodoReqNC08List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC08List
		this.ipvTodoReqNC08List = ipvTodoReqNC08List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC09List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC09List
		return ipvTodoReqNC09List;
	}

	public void setIpvTodoReqNC09List(List<IpvTodoReqnc> ipvTodoReqNC09List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC09List
		this.ipvTodoReqNC09List = ipvTodoReqNC09List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC10List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC10List
		return ipvTodoReqNC10List;
	}

	public void setIpvTodoReqNC10List(List<IpvTodoReqnc> ipvTodoReqNC10List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC10List
		this.ipvTodoReqNC10List = ipvTodoReqNC10List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq01List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoUserReq01List
		return ipvTodoUserReq01List;
	}

	public void setIpvTodoUserReq01List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoUserReq01List
			List<IpvTodoUserReq> ipvTodoUserReq01List) {
		this.ipvTodoUserReq01List = ipvTodoUserReq01List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq02List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoUserReq02List
		return ipvTodoUserReq02List;
	}

	public void setIpvTodoUserReq02List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoUserReq02List
			List<IpvTodoUserReq> ipvTodoUserReq02List) {
		this.ipvTodoUserReq02List = ipvTodoUserReq02List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq03List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoUserReq03List
		return ipvTodoUserReq03List;
	}

	public void setIpvTodoUserReq03List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoUserReq03List
			List<IpvTodoUserReq> ipvTodoUserReq03List) {
		this.ipvTodoUserReq03List = ipvTodoUserReq03List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq04List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoUserReq04List
		return ipvTodoUserReq04List;
	}

	public void setIpvTodoUserReq04List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoUserReq04List
			List<IpvTodoUserReq> ipvTodoUserReq04List) {
		this.ipvTodoUserReq04List = ipvTodoUserReq04List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq01List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoPlanningReq01List
		return ipvTodoPlanningReq01List;
	}

	public void setIpvTodoPlanningReq01List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoPlanningReq01List
			List<IpvTodoPlanningReq> ipvTodoPlanningReq01List) {
		this.ipvTodoPlanningReq01List = ipvTodoPlanningReq01List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq02List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoPlanningReq02List
		return ipvTodoPlanningReq02List;
	}

	public void setIpvTodoPlanningReq02List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoPlanningReq02List
			List<IpvTodoPlanningReq> ipvTodoPlanningReq02List) {
		this.ipvTodoPlanningReq02List = ipvTodoPlanningReq02List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq03List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoPlanningReq03List
		return ipvTodoPlanningReq03List;
	}

	public void setIpvTodoPlanningReq03List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoPlanningReq03List
			List<IpvTodoPlanningReq> ipvTodoPlanningReq03List) {
		this.ipvTodoPlanningReq03List = ipvTodoPlanningReq03List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq04List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoPlanningReq04List
		return ipvTodoPlanningReq04List;
	}

	public void setIpvTodoPlanningReq04List( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoPlanningReq04List
			List<IpvTodoPlanningReq> ipvTodoPlanningReq04List) {
		this.ipvTodoPlanningReq04List = ipvTodoPlanningReq04List;
	}

	public List<IpvWatchReqnc> getIpvWlNetworkConfigList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvWlNetworkConfigList
		return ipvWlNetworkConfigList;
	}

	public void setIpvWlNetworkConfigList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvWlNetworkConfigList
			List<IpvWatchReqnc> ipvWlNetworkConfigList) {
		this.ipvWlNetworkConfigList = ipvWlNetworkConfigList;
	}

	public List<IpvWatchUserReq> getIpvWlUserReqList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvWlUserReqList
		return ipvWlUserReqList;
	}

	public void setIpvWlUserReqList(List<IpvWatchUserReq> ipvWlUserReqList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvWlUserReqList
		this.ipvWlUserReqList = ipvWlUserReqList;
	}

	public List<IpvWatchPlanningReq> getIpvWlPlanningReqList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvWlPlanningReqList
		return ipvWlPlanningReqList;
	}

	public void setIpvWlPlanningReqList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvWlPlanningReqList
			List<IpvWatchPlanningReq> ipvWlPlanningReqList) {
		this.ipvWlPlanningReqList = ipvWlPlanningReqList;
	}

	public List<IpvMonitorReqnc> getIpvMntNetworkConfigList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvMntNetworkConfigList
		return ipvMntNetworkConfigList;
	}

	public void setIpvMntNetworkConfigList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvMntNetworkConfigList
			List<IpvMonitorReqnc> ipvMntNetworkConfigList) {
		this.ipvMntNetworkConfigList = ipvMntNetworkConfigList;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC11List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC11List
		return ipvTodoReqNC11List;
	}

	public void setIpvTodoReqNC11List(List<IpvTodoReqnc> ipvTodoReqNC11List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC11List
		this.ipvTodoReqNC11List = ipvTodoReqNC11List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC12List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC12List
		return ipvTodoReqNC12List;
	}

	public void setIpvTodoReqNC12List(List<IpvTodoReqnc> ipvTodoReqNC12List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC12List
		this.ipvTodoReqNC12List = ipvTodoReqNC12List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC02MrgList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC02MrgList
		return ipvTodoReqNC02MrgList;
	}

	public void setIpvTodoReqNC02MrgList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC02MrgList
			List<IpvTodoReqnc> ipvTodoReqNC02MrgList) {
		this.ipvTodoReqNC02MrgList = ipvTodoReqNC02MrgList;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC02OwnerList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpvTodoReqNC02OwnerList
		return ipvTodoReqNC02OwnerList;
	}

	public void setIpvTodoReqNC02OwnerList( // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpvTodoReqNC02OwnerList
			List<IpvTodoReqnc> ipvTodoReqNC02OwnerList) {
		this.ipvTodoReqNC02OwnerList = ipvTodoReqNC02OwnerList;
	}

	public String getUserReqIPSize() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserReqIPSize
		int size = 0;
		size = ipvTodoUserReq01List.size() + ipvTodoUserReq02List.size()
				+ ipvTodoUserReq03List.size() + ipvTodoUserReq04List.size();
		return String.valueOf(size);
	}

	public String getPlanningReqIPSize() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPlanningReqIPSize
		int size = 0;
		size = ipvTodoPlanningReq01List.size()
				+ ipvTodoPlanningReq02List.size()
				+ ipvTodoPlanningReq03List.size()
				+ ipvTodoPlanningReq04List.size();
		return String.valueOf(size);
	}

	public String getNetworkConfigSize() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkConfigSize
		int size = 0;
		size = ipvTodoReqNC01List.size() + ipvTodoReqNC02MrgList.size()
				+ ipvTodoReqNC02OwnerList.size() + ipvTodoReqNC03List.size()
				+ ipvTodoReqNC04List.size() + ipvTodoReqNC05List.size()
				+ ipvTodoReqNC06List.size() + ipvTodoReqNC07List.size()
				+ ipvTodoReqNC08List.size() + ipvTodoReqNC09List.size()
				+ ipvTodoReqNC10List.size() + ipvTodoReqNC11List.size()
				+ ipvTodoReqNC12List.size();
		return String.valueOf(size);
	}

	public String getUrNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrNo
		return urNo;
	}

	public void setUrNo(String urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrNo
		this.urNo = urNo;
	}

	public String getUrTypeUserReq() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeUserReq
		return IPFMConstant.URTYPE_USER_REQ_IP;
	}

	public String getUrTypePlanning() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypePlanning
		return IPFMConstant.URTYPE_PLANNING_REQ_IP;
	}

	public String getUrTypeNetwork() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeNetwork
		return IPFMConstant.URTYPE_NETWORK_CONFIG;
	}

	public String getUrTypeUserReqDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeUserReqDesc
		String str = "";
		if (ipvTodoUserReq01List.size() > 0) {
			str = ((IpvTodoUserReq) ipvTodoUserReq01List.get(0)).getTitle1();
		} else if (ipvTodoUserReq02List.size() > 0) {
			str = ((IpvTodoUserReq) ipvTodoUserReq02List.get(0)).getTitle1();
		} else if (ipvTodoUserReq03List.size() > 0) {
			str = ((IpvTodoUserReq) ipvTodoUserReq03List.get(0)).getTitle1();
		} else if (ipvTodoUserReq04List.size() > 0) {
			str = ((IpvTodoUserReq) ipvTodoUserReq04List.get(0)).getTitle1();
		}
		return str;
	}

	public String getUrTypePlanningDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypePlanningDesc
		String str = "";
		if (ipvTodoPlanningReq01List.size() > 0) {
			str = ((IpvTodoPlanningReq) ipvTodoPlanningReq01List.get(0))
					.getTitle1();
		} else if (ipvTodoPlanningReq02List.size() > 0) {
			str = ((IpvTodoPlanningReq) ipvTodoPlanningReq02List.get(0))
					.getTitle1();
		} else if (ipvTodoPlanningReq03List.size() > 0) {
			str = ((IpvTodoPlanningReq) ipvTodoPlanningReq03List.get(0))
					.getTitle1();
		} else if (ipvTodoPlanningReq04List.size() > 0) {
			str = ((IpvTodoPlanningReq) ipvTodoPlanningReq04List.get(0))
					.getTitle1();
		}
		return str;
	}

	public String getUrTypeNetworkDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrTypeNetworkDesc
		String str = "";
		if (ipvTodoReqNC01List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC01List.get(0)).getTitle1();
		} else if (ipvTodoReqNC02MrgList.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC02MrgList.get(0)).getTitle1();
		} else if (ipvTodoReqNC02OwnerList.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC02OwnerList.get(0)).getTitle1();
		} else if (ipvTodoReqNC03List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC03List.get(0)).getTitle1();
		} else if (ipvTodoReqNC04List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC04List.get(0)).getTitle1();
		} else if (ipvTodoReqNC05List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC05List.get(0)).getTitle1();
		} else if (ipvTodoReqNC06List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC06List.get(0)).getTitle1();
		} else if (ipvTodoReqNC07List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC07List.get(0)).getTitle1();
		} else if (ipvTodoReqNC08List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC08List.get(0)).getTitle1();
		} else if (ipvTodoReqNC09List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC09List.get(0)).getTitle1();
		} else if (ipvTodoReqNC10List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC10List.get(0)).getTitle1();
		} else if (ipvTodoReqNC11List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC11List.get(0)).getTitle1();
		} else if (ipvTodoReqNC12List.size() > 0) {
			str = ((IpvTodoReqnc) ipvTodoReqNC12List.get(0)).getTitle1();
		}
		return str;
	}

	public void setWatchNCSortColumn(SortColumnBean watchNCSortColumn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWatchNCSortColumn
		this.watchNCSortColumn = watchNCSortColumn;
	}

	public SortColumnBean getWatchNCSortColumn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWatchNCSortColumn
		return watchNCSortColumn;
	}

	public void setWatchUserIPSortColumn(SortColumnBean watchUserIPSortColumn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWatchUserIPSortColumn
		this.watchUserIPSortColumn = watchUserIPSortColumn;
	}

	public SortColumnBean getWatchUserIPSortColumn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWatchUserIPSortColumn
		return watchUserIPSortColumn;
	}

	public void setWatchPlanSortColumn(SortColumnBean watchPlanSortColumn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWatchPlanSortColumn
		this.watchPlanSortColumn = watchPlanSortColumn;
	}

	public SortColumnBean getWatchPlanSortColumn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWatchPlanSortColumn
		return watchPlanSortColumn;
	}

	public SortColumnBean getnCMSortColumn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getnCMSortColumn
		return nCMSortColumn;
	}

	public void setnCMSortColumn(SortColumnBean nCMSortColumn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setnCMSortColumn
		this.nCMSortColumn = nCMSortColumn;
	}

	public String getnCMURNoFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getnCMURNoFilter
		return nCMURNoFilter;
	}

	public void setnCMURNoFilter(String nCMURNoFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setnCMURNoFilter
		this.nCMURNoFilter = nCMURNoFilter;
	}

	public String getnCMSubURNoFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getnCMSubURNoFilter
		return nCMSubURNoFilter;
	}

	public void setnCMSubURNoFilter(String nCMSubURNoFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setnCMSubURNoFilter
		this.nCMSubURNoFilter = nCMSubURNoFilter;
	}

	public String getnCMSubjectFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getnCMSubjectFilter
		return nCMSubjectFilter;
	}

	public void setnCMSubjectFilter(String nCMSubjectFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setnCMSubjectFilter
		this.nCMSubjectFilter = nCMSubjectFilter;
	}

	public String getnCMStatusFilter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getnCMStatusFilter
		return nCMStatusFilter;
	}

	public void setnCMStatusFilter(String nCMStatusFilter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setnCMStatusFilter
		this.nCMStatusFilter = nCMStatusFilter;
	}

	public SortColumnBean getSortTodoPlan01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoPlan01
		return sortTodoPlan01;
	}

	public void setSortTodoPlan01(SortColumnBean sortTodoPlan01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoPlan01
		this.sortTodoPlan01 = sortTodoPlan01;
	}

	public SortColumnBean getSortTodoPlan02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoPlan02
		return sortTodoPlan02;
	}

	public void setSortTodoPlan02(SortColumnBean sortTodoPlan02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoPlan02
		this.sortTodoPlan02 = sortTodoPlan02;
	}

	public SortColumnBean getSortTodoPlan04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoPlan04
		return sortTodoPlan04;
	}

	public void setSortTodoPlan04(SortColumnBean sortTodoPlan04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoPlan04
		this.sortTodoPlan04 = sortTodoPlan04;
	}

	public String getFilterTodoPlan01urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan01urNo
		return filterTodoPlan01urNo;
	}

	public void setFilterTodoPlan01urNo(String filterTodoPlan01urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan01urNo
		this.filterTodoPlan01urNo = filterTodoPlan01urNo;
	}

	public String getFilterTodoPlan01subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan01subject
		return filterTodoPlan01subject;
	}

	public void setFilterTodoPlan01subject(String filterTodoPlan01subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan01subject
		this.filterTodoPlan01subject = filterTodoPlan01subject;
	}

	public String getFilterTodoPlan02urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan02urNo
		return filterTodoPlan02urNo;
	}

	public void setFilterTodoPlan02urNo(String filterTodoPlan02urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan02urNo
		this.filterTodoPlan02urNo = filterTodoPlan02urNo;
	}

	public String getFilterTodoPlan02subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan02subject
		return filterTodoPlan02subject;
	}

	public void setFilterTodoPlan02subject(String filterTodoPlan02subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan02subject
		this.filterTodoPlan02subject = filterTodoPlan02subject;
	}

	public String getFilterTodoPlan02status() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan02status
		return filterTodoPlan02status;
	}

	public void setFilterTodoPlan02status(String filterTodoPlan02status) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan02status
		this.filterTodoPlan02status = filterTodoPlan02status;
	}

	public String getFilterTodoPlan02rejectBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan02rejectBy
		return filterTodoPlan02rejectBy;
	}

	public void setFilterTodoPlan02rejectBy(String filterTodoPlan02rejectBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan02rejectBy
		this.filterTodoPlan02rejectBy = filterTodoPlan02rejectBy;
	}

	public String getFilterTodoPlan02remarks() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan02remarks
		return filterTodoPlan02remarks;
	}

	public void setFilterTodoPlan02remarks(String filterTodoPlan02remarks) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan02remarks
		this.filterTodoPlan02remarks = filterTodoPlan02remarks;
	}

	public String getFilterTodoPlan04urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan04urNo
		return filterTodoPlan04urNo;
	}

	public void setFilterTodoPlan04urNo(String filterTodoPlan04urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan04urNo
		this.filterTodoPlan04urNo = filterTodoPlan04urNo;
	}

	public String getFilterTodoPlan04subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan04subject
		return filterTodoPlan04subject;
	}

	public void setFilterTodoPlan04subject(String filterTodoPlan04subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan04subject
		this.filterTodoPlan04subject = filterTodoPlan04subject;
	}

	public String getFilterTodoPlan04requestBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan04requestBy
		return filterTodoPlan04requestBy;
	}

	public void setFilterTodoPlan04requestBy(String filterTodoPlan04requestBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan04requestBy
		this.filterTodoPlan04requestBy = filterTodoPlan04requestBy;
	}

	public String getFilterTodoPlan04actionUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoPlan04actionUser
		return filterTodoPlan04actionUser;
	}

	public void setFilterTodoPlan04actionUser(String filterTodoPlan04actionUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoPlan04actionUser
		this.filterTodoPlan04actionUser = filterTodoPlan04actionUser;
	}

	public SortColumnBean getSortTodoUser01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoUser01
		return sortTodoUser01;
	}

	public void setSortTodoUser01(SortColumnBean sortTodoUser01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoUser01
		this.sortTodoUser01 = sortTodoUser01;
	}

	public SortColumnBean getSortTodoUser02() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoUser02
		return sortTodoUser02;
	}

	public void setSortTodoUser02(SortColumnBean sortTodoUser02) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoUser02
		this.sortTodoUser02 = sortTodoUser02;
	}

	public SortColumnBean getSortTodoUser03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoUser03
		return sortTodoUser03;
	}

	public void setSortTodoUser03(SortColumnBean sortTodoUser03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoUser03
		this.sortTodoUser03 = sortTodoUser03;
	}

	public SortColumnBean getSortTodoUser04() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoUser04
		return sortTodoUser04;
	}

	public void setSortTodoUser04(SortColumnBean sortTodoUser04) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoUser04
		this.sortTodoUser04 = sortTodoUser04;
	}

	public String getFilterTodoUser01urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser01urNo
		return filterTodoUser01urNo;
	}

	public void setFilterTodoUser01urNo(String filterTodoUser01urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser01urNo
		this.filterTodoUser01urNo = filterTodoUser01urNo;
	}

	public String getFilterTodoUser01subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser01subject
		return filterTodoUser01subject;
	}

	public void setFilterTodoUser01subject(String filterTodoUser01subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser01subject
		this.filterTodoUser01subject = filterTodoUser01subject;
	}

	public String getFilterTodoUser02urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser02urNo
		return filterTodoUser02urNo;
	}

	public void setFilterTodoUser02urNo(String filterTodoUser02urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser02urNo
		this.filterTodoUser02urNo = filterTodoUser02urNo;
	}

	public String getFilterTodoUser02subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser02subject
		return filterTodoUser02subject;
	}

	public void setFilterTodoUser02subject(String filterTodoUser02subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser02subject
		this.filterTodoUser02subject = filterTodoUser02subject;
	}

	public String getFilterTodoUser02status() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser02status
		return filterTodoUser02status;
	}

	public void setFilterTodoUser02status(String filterTodoUser02status) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser02status
		this.filterTodoUser02status = filterTodoUser02status;
	}

	public String getFilterTodoUser02rejectBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser02rejectBy
		return filterTodoUser02rejectBy;
	}

	public void setFilterTodoUser02rejectBy(String filterTodoUser02rejectBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser02rejectBy
		this.filterTodoUser02rejectBy = filterTodoUser02rejectBy;
	}

	public String getFilterTodoUser02remarks() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser02remarks
		return filterTodoUser02remarks;
	}

	public void setFilterTodoUser02remarks(String filterTodoUser02remarks) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser02remarks
		this.filterTodoUser02remarks = filterTodoUser02remarks;
	}

	public String getFilterTodoUser03urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser03urNo
		return filterTodoUser03urNo;
	}

	public void setFilterTodoUser03urNo(String filterTodoUser03urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser03urNo
		this.filterTodoUser03urNo = filterTodoUser03urNo;
	}

	public String getFilterTodoUser03subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser03subject
		return filterTodoUser03subject;
	}

	public void setFilterTodoUser03subject(String filterTodoUser03subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser03subject
		this.filterTodoUser03subject = filterTodoUser03subject;
	}

	public String getFilterTodoUser03requestBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser03requestBy
		return filterTodoUser03requestBy;
	}

	public void setFilterTodoUser03requestBy(String filterTodoUser03requestBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser03requestBy
		this.filterTodoUser03requestBy = filterTodoUser03requestBy;
	}

	public String getFilterTodoUser03actionUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser03actionUser
		return filterTodoUser03actionUser;
	}

	public void setFilterTodoUser03actionUser(String filterTodoUser03actionUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser03actionUser
		this.filterTodoUser03actionUser = filterTodoUser03actionUser;
	}

	public String getFilterTodoUser04urNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser04urNo
		return filterTodoUser04urNo;
	}

	public void setFilterTodoUser04urNo(String filterTodoUser04urNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser04urNo
		this.filterTodoUser04urNo = filterTodoUser04urNo;
	}

	public String getFilterTodoUser04subject() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser04subject
		return filterTodoUser04subject;
	}

	public void setFilterTodoUser04subject(String filterTodoUser04subject) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser04subject
		this.filterTodoUser04subject = filterTodoUser04subject;
	}

	public String getFilterTodoUser04requestBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser04requestBy
		return filterTodoUser04requestBy;
	}

	public void setFilterTodoUser04requestBy(String filterTodoUser04requestBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser04requestBy
		this.filterTodoUser04requestBy = filterTodoUser04requestBy;
	}

	public String getFilterTodoUser04actionUser() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoUser04actionUser
		return filterTodoUser04actionUser;
	}

	public void setFilterTodoUser04actionUser(String filterTodoUser04actionUser) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoUser04actionUser
		this.filterTodoUser04actionUser = filterTodoUser04actionUser;
	}

	public SortColumnBean getSortTodoReqNC01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC01
		return sortTodoReqNC01;
	}

	public void setSortTodoReqNC01(SortColumnBean sortTodoReqNC01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC01
		this.sortTodoReqNC01 = sortTodoReqNC01;
	}

	public SortColumnBean getSortTodoReqNC02Mrg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC02Mrg
		return sortTodoReqNC02Mrg;
	}

	public void setSortTodoReqNC02Mrg(SortColumnBean sortTodoReqNC02Mrg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC02Mrg
		this.sortTodoReqNC02Mrg = sortTodoReqNC02Mrg;
	}

	public SortColumnBean getSortTodoReqNC02Owner() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC02Owner
		return sortTodoReqNC02Owner;
	}

	public void setSortTodoReqNC02Owner(SortColumnBean sortTodoReqNC02Owner) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC02Owner
		this.sortTodoReqNC02Owner = sortTodoReqNC02Owner;
	}

	public SortColumnBean getSortTodoReqNC03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC03
		return sortTodoReqNC03;
	}

	public void setSortTodoReqNC03(SortColumnBean sortTodoReqNC03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC03
		this.sortTodoReqNC03 = sortTodoReqNC03;
	}

	public SortColumnBean getSortTodoReqNC05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC05
		return sortTodoReqNC05;
	}

	public void setSortTodoReqNC05(SortColumnBean sortTodoReqNC05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC05
		this.sortTodoReqNC05 = sortTodoReqNC05;
	}

	public SortColumnBean getSortTodoReqNC11() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC11
		return sortTodoReqNC11;
	}

	public void setSortTodoReqNC11(SortColumnBean sortTodoReqNC11) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC11
		this.sortTodoReqNC11 = sortTodoReqNC11;
	}

	public SortColumnBean getSortTodoReqNC12() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC12
		return sortTodoReqNC12;
	}

	public void setSortTodoReqNC12(SortColumnBean sortTodoReqNC12) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC12
		this.sortTodoReqNC12 = sortTodoReqNC12;
	}

	public SortColumnBean getSortTodoReqNC06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC06
		return sortTodoReqNC06;
	}

	public void setSortTodoReqNC06(SortColumnBean sortTodoReqNC06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC06
		this.sortTodoReqNC06 = sortTodoReqNC06;
	}

	public SortColumnBean getSortTodoReqNC07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC07
		return sortTodoReqNC07;
	}

	public void setSortTodoReqNC07(SortColumnBean sortTodoReqNC07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC07
		this.sortTodoReqNC07 = sortTodoReqNC07;
	}

	public SortColumnBean getSortTodoReqNC08() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC08
		return sortTodoReqNC08;
	}

	public void setSortTodoReqNC08(SortColumnBean sortTodoReqNC08) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC08
		this.sortTodoReqNC08 = sortTodoReqNC08;
	}

	public SortColumnBean getSortTodoReqNC09() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC09
		return sortTodoReqNC09;
	}

	public void setSortTodoReqNC09(SortColumnBean sortTodoReqNC09) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC09
		this.sortTodoReqNC09 = sortTodoReqNC09;
	}

	public SortColumnBean getSortTodoReqNC10() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortTodoReqNC10
		return sortTodoReqNC10;
	}

	public void setSortTodoReqNC10(SortColumnBean sortTodoReqNC10) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortTodoReqNC10
		this.sortTodoReqNC10 = sortTodoReqNC10;
	}

	public FilterBean getFilterTodoReqNC01() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC01
		return filterTodoReqNC01;
	}

	public void setFilterTodoReqNC01(FilterBean filterTodoReqNC01) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC01
		this.filterTodoReqNC01 = filterTodoReqNC01;
	}

	public FilterBean getFilterTodoReqNC02Mrg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC02Mrg
		return filterTodoReqNC02Mrg;
	}

	public void setFilterTodoReqNC02Mrg(FilterBean filterTodoReqNC02Mrg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC02Mrg
		this.filterTodoReqNC02Mrg = filterTodoReqNC02Mrg;
	}

	public FilterBean getFilterTodoReqNC02Owner() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC02Owner
		return filterTodoReqNC02Owner;
	}

	public void setFilterTodoReqNC02Owner(FilterBean filterTodoReqNC02Owner) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC02Owner
		this.filterTodoReqNC02Owner = filterTodoReqNC02Owner;
	}

	public FilterBean getFilterTodoReqNC03() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC03
		return filterTodoReqNC03;
	}

	public void setFilterTodoReqNC03(FilterBean filterTodoReqNC03) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC03
		this.filterTodoReqNC03 = filterTodoReqNC03;
	}

	public FilterBean getFilterTodoReqNC05() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC05
		return filterTodoReqNC05;
	}

	public void setFilterTodoReqNC05(FilterBean filterTodoReqNC05) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC05
		this.filterTodoReqNC05 = filterTodoReqNC05;
	}

	public FilterBean getFilterTodoReqNC11() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC11
		return filterTodoReqNC11;
	}

	public void setFilterTodoReqNC11(FilterBean filterTodoReqNC11) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC11
		this.filterTodoReqNC11 = filterTodoReqNC11;
	}

	public FilterBean getFilterTodoReqNC12() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC12
		return filterTodoReqNC12;
	}

	public void setFilterTodoReqNC12(FilterBean filterTodoReqNC12) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC12
		this.filterTodoReqNC12 = filterTodoReqNC12;
	}

	public FilterBean getFilterTodoReqNC06() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC06
		return filterTodoReqNC06;
	}

	public void setFilterTodoReqNC06(FilterBean filterTodoReqNC06) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC06
		this.filterTodoReqNC06 = filterTodoReqNC06;
	}

	public FilterBean getFilterTodoReqNC07() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC07
		return filterTodoReqNC07;
	}

	public void setFilterTodoReqNC07(FilterBean filterTodoReqNC07) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC07
		this.filterTodoReqNC07 = filterTodoReqNC07;
	}

	public FilterBean getFilterTodoReqNC08() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC08
		return filterTodoReqNC08;
	}

	public void setFilterTodoReqNC08(FilterBean filterTodoReqNC08) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC08
		this.filterTodoReqNC08 = filterTodoReqNC08;
	}

	public FilterBean getFilterTodoReqNC09() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC09
		return filterTodoReqNC09;
	}

	public void setFilterTodoReqNC09(FilterBean filterTodoReqNC09) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC09
		this.filterTodoReqNC09 = filterTodoReqNC09;
	}

	public FilterBean getFilterTodoReqNC10() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterTodoReqNC10
		return filterTodoReqNC10;
	}

	public void setFilterTodoReqNC10(FilterBean filterTodoReqNC10) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterTodoReqNC10
		this.filterTodoReqNC10 = filterTodoReqNC10;
	}

	 

}
