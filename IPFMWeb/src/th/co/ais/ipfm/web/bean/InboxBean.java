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
	private static final long serialVersionUID = 1L;
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
	
	public String getUrNoFilterU() {
		return urNoFilterU;
	}

	public void setUrNoFilterU(String urNoFilterU) {
		this.urNoFilterU = urNoFilterU;
	}

	public String getSubjectFilterU() {
		return subjectFilterU;
	}

	public void setSubjectFilterU(String subjectFilterU) {
		this.subjectFilterU = subjectFilterU;
	}

	public String getStatusFilterU() {
		return statusFilterU;
	}

	public void setStatusFilterU(String statusFilterU) {
		this.statusFilterU = statusFilterU;
	}

	public String getActionUserFilterU() {
		return actionUserFilterU;
	}

	public void setActionUserFilterU(String actionUserFilterU) {
		this.actionUserFilterU = actionUserFilterU;
	}

	public String getUrNoFilterP() {
		return urNoFilterP;
	}

	public void setUrNoFilterP(String urNoFilterP) {
		this.urNoFilterP = urNoFilterP;
	}

	public String getSubjectFilterP() {
		return subjectFilterP;
	}

	public void setSubjectFilterP(String subjectFilterP) {
		this.subjectFilterP = subjectFilterP;
	}

	public String getStatusFilterP() {
		return statusFilterP;
	}

	public void setStatusFilterP(String statusFilterP) {
		this.statusFilterP = statusFilterP;
	}

	public String getActionUserFilterP() {
		return actionUserFilterP;
	}

	public void setActionUserFilterP(String actionUserFilterP) {
		this.actionUserFilterP = actionUserFilterP;
	}

	public String getSubUrNoFilter() {
		return subUrNoFilter;
	}

	public void setSubUrNoFilter(String subUrNoFilter) {
		this.subUrNoFilter = subUrNoFilter;
	}

	public String getSubjectFilter() {
		return subjectFilter;
	}

	public void setSubjectFilter(String subjectFilter) {
		this.subjectFilter = subjectFilter;
	}

	public String getStatusFilter() {
		return statusFilter;
	}

	public void setStatusFilter(String statusFilter) {
		this.statusFilter = statusFilter;
	}

	public String getUrNoFilter() {
		return urNoFilter;
	}

	public void setUrNoFilter(String urNoFilter) {
		this.urNoFilter = urNoFilter;
	}

	public InboxBean() {

	}

	public String getTreeType() {
		return treeType;
	}

	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getUrType() {
		return urType;
	}

	public void setUrType(String urType) {
		this.urType = urType;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC01List() {
		return ipvTodoReqNC01List;
	}

	public void setIpvTodoReqNC01List(List<IpvTodoReqnc> ipvTodoReqNC01List) {
		this.ipvTodoReqNC01List = ipvTodoReqNC01List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC02List() {
		return ipvTodoReqNC02List;
	}

	public void setIpvTodoReqNC02List(List<IpvTodoReqnc> ipvTodoReqNC02List) {
		this.ipvTodoReqNC02List = ipvTodoReqNC02List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC03List() {
		return ipvTodoReqNC03List;
	}

	public void setIpvTodoReqNC03List(List<IpvTodoReqnc> ipvTodoReqNC03List) {
		this.ipvTodoReqNC03List = ipvTodoReqNC03List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC04List() {
		return ipvTodoReqNC04List;
	}

	public void setIpvTodoReqNC04List(List<IpvTodoReqnc> ipvTodoReqNC04List) {
		this.ipvTodoReqNC04List = ipvTodoReqNC04List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC05List() {
		return ipvTodoReqNC05List;
	}

	public void setIpvTodoReqNC05List(List<IpvTodoReqnc> ipvTodoReqNC05List) {
		this.ipvTodoReqNC05List = ipvTodoReqNC05List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC06List() {
		return ipvTodoReqNC06List;
	}

	public void setIpvTodoReqNC06List(List<IpvTodoReqnc> ipvTodoReqNC06List) {
		this.ipvTodoReqNC06List = ipvTodoReqNC06List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC07List() {
		return ipvTodoReqNC07List;
	}

	public void setIpvTodoReqNC07List(List<IpvTodoReqnc> ipvTodoReqNC07List) {
		this.ipvTodoReqNC07List = ipvTodoReqNC07List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC08List() {
		return ipvTodoReqNC08List;
	}

	public void setIpvTodoReqNC08List(List<IpvTodoReqnc> ipvTodoReqNC08List) {
		this.ipvTodoReqNC08List = ipvTodoReqNC08List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC09List() {
		return ipvTodoReqNC09List;
	}

	public void setIpvTodoReqNC09List(List<IpvTodoReqnc> ipvTodoReqNC09List) {
		this.ipvTodoReqNC09List = ipvTodoReqNC09List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC10List() {
		return ipvTodoReqNC10List;
	}

	public void setIpvTodoReqNC10List(List<IpvTodoReqnc> ipvTodoReqNC10List) {
		this.ipvTodoReqNC10List = ipvTodoReqNC10List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq01List() {
		return ipvTodoUserReq01List;
	}

	public void setIpvTodoUserReq01List(
			List<IpvTodoUserReq> ipvTodoUserReq01List) {
		this.ipvTodoUserReq01List = ipvTodoUserReq01List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq02List() {
		return ipvTodoUserReq02List;
	}

	public void setIpvTodoUserReq02List(
			List<IpvTodoUserReq> ipvTodoUserReq02List) {
		this.ipvTodoUserReq02List = ipvTodoUserReq02List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq03List() {
		return ipvTodoUserReq03List;
	}

	public void setIpvTodoUserReq03List(
			List<IpvTodoUserReq> ipvTodoUserReq03List) {
		this.ipvTodoUserReq03List = ipvTodoUserReq03List;
	}

	public List<IpvTodoUserReq> getIpvTodoUserReq04List() {
		return ipvTodoUserReq04List;
	}

	public void setIpvTodoUserReq04List(
			List<IpvTodoUserReq> ipvTodoUserReq04List) {
		this.ipvTodoUserReq04List = ipvTodoUserReq04List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq01List() {
		return ipvTodoPlanningReq01List;
	}

	public void setIpvTodoPlanningReq01List(
			List<IpvTodoPlanningReq> ipvTodoPlanningReq01List) {
		this.ipvTodoPlanningReq01List = ipvTodoPlanningReq01List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq02List() {
		return ipvTodoPlanningReq02List;
	}

	public void setIpvTodoPlanningReq02List(
			List<IpvTodoPlanningReq> ipvTodoPlanningReq02List) {
		this.ipvTodoPlanningReq02List = ipvTodoPlanningReq02List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq03List() {
		return ipvTodoPlanningReq03List;
	}

	public void setIpvTodoPlanningReq03List(
			List<IpvTodoPlanningReq> ipvTodoPlanningReq03List) {
		this.ipvTodoPlanningReq03List = ipvTodoPlanningReq03List;
	}

	public List<IpvTodoPlanningReq> getIpvTodoPlanningReq04List() {
		return ipvTodoPlanningReq04List;
	}

	public void setIpvTodoPlanningReq04List(
			List<IpvTodoPlanningReq> ipvTodoPlanningReq04List) {
		this.ipvTodoPlanningReq04List = ipvTodoPlanningReq04List;
	}

	public List<IpvWatchReqnc> getIpvWlNetworkConfigList() {
		return ipvWlNetworkConfigList;
	}

	public void setIpvWlNetworkConfigList(
			List<IpvWatchReqnc> ipvWlNetworkConfigList) {
		this.ipvWlNetworkConfigList = ipvWlNetworkConfigList;
	}

	public List<IpvWatchUserReq> getIpvWlUserReqList() {
		return ipvWlUserReqList;
	}

	public void setIpvWlUserReqList(List<IpvWatchUserReq> ipvWlUserReqList) {
		this.ipvWlUserReqList = ipvWlUserReqList;
	}

	public List<IpvWatchPlanningReq> getIpvWlPlanningReqList() {
		return ipvWlPlanningReqList;
	}

	public void setIpvWlPlanningReqList(
			List<IpvWatchPlanningReq> ipvWlPlanningReqList) {
		this.ipvWlPlanningReqList = ipvWlPlanningReqList;
	}

	public List<IpvMonitorReqnc> getIpvMntNetworkConfigList() {
		return ipvMntNetworkConfigList;
	}

	public void setIpvMntNetworkConfigList(
			List<IpvMonitorReqnc> ipvMntNetworkConfigList) {
		this.ipvMntNetworkConfigList = ipvMntNetworkConfigList;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC11List() {
		return ipvTodoReqNC11List;
	}

	public void setIpvTodoReqNC11List(List<IpvTodoReqnc> ipvTodoReqNC11List) {
		this.ipvTodoReqNC11List = ipvTodoReqNC11List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC12List() {
		return ipvTodoReqNC12List;
	}

	public void setIpvTodoReqNC12List(List<IpvTodoReqnc> ipvTodoReqNC12List) {
		this.ipvTodoReqNC12List = ipvTodoReqNC12List;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC02MrgList() {
		return ipvTodoReqNC02MrgList;
	}

	public void setIpvTodoReqNC02MrgList(
			List<IpvTodoReqnc> ipvTodoReqNC02MrgList) {
		this.ipvTodoReqNC02MrgList = ipvTodoReqNC02MrgList;
	}

	public List<IpvTodoReqnc> getIpvTodoReqNC02OwnerList() {
		return ipvTodoReqNC02OwnerList;
	}

	public void setIpvTodoReqNC02OwnerList(
			List<IpvTodoReqnc> ipvTodoReqNC02OwnerList) {
		this.ipvTodoReqNC02OwnerList = ipvTodoReqNC02OwnerList;
	}

	public String getUserReqIPSize() {
		int size = 0;
		size = ipvTodoUserReq01List.size() + ipvTodoUserReq02List.size()
				+ ipvTodoUserReq03List.size() + ipvTodoUserReq04List.size();
		return String.valueOf(size);
	}

	public String getPlanningReqIPSize() {
		int size = 0;
		size = ipvTodoPlanningReq01List.size()
				+ ipvTodoPlanningReq02List.size()
				+ ipvTodoPlanningReq03List.size()
				+ ipvTodoPlanningReq04List.size();
		return String.valueOf(size);
	}

	public String getNetworkConfigSize() {
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

	public String getUrNo() {
		return urNo;
	}

	public void setUrNo(String urNo) {
		this.urNo = urNo;
	}

	public String getUrTypeUserReq() {
		return IPFMConstant.URTYPE_USER_REQ_IP;
	}

	public String getUrTypePlanning() {
		return IPFMConstant.URTYPE_PLANNING_REQ_IP;
	}

	public String getUrTypeNetwork() {
		return IPFMConstant.URTYPE_NETWORK_CONFIG;
	}

	public String getUrTypeUserReqDesc() {
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

	public String getUrTypePlanningDesc() {
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

	public String getUrTypeNetworkDesc() {
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

	public void setWatchNCSortColumn(SortColumnBean watchNCSortColumn) {
		this.watchNCSortColumn = watchNCSortColumn;
	}

	public SortColumnBean getWatchNCSortColumn() {
		return watchNCSortColumn;
	}

	public void setWatchUserIPSortColumn(SortColumnBean watchUserIPSortColumn) {
		this.watchUserIPSortColumn = watchUserIPSortColumn;
	}

	public SortColumnBean getWatchUserIPSortColumn() {
		return watchUserIPSortColumn;
	}

	public void setWatchPlanSortColumn(SortColumnBean watchPlanSortColumn) {
		this.watchPlanSortColumn = watchPlanSortColumn;
	}

	public SortColumnBean getWatchPlanSortColumn() {
		return watchPlanSortColumn;
	}

	public SortColumnBean getnCMSortColumn() {
		return nCMSortColumn;
	}

	public void setnCMSortColumn(SortColumnBean nCMSortColumn) {
		this.nCMSortColumn = nCMSortColumn;
	}

	public String getnCMURNoFilter() {
		return nCMURNoFilter;
	}

	public void setnCMURNoFilter(String nCMURNoFilter) {
		this.nCMURNoFilter = nCMURNoFilter;
	}

	public String getnCMSubURNoFilter() {
		return nCMSubURNoFilter;
	}

	public void setnCMSubURNoFilter(String nCMSubURNoFilter) {
		this.nCMSubURNoFilter = nCMSubURNoFilter;
	}

	public String getnCMSubjectFilter() {
		return nCMSubjectFilter;
	}

	public void setnCMSubjectFilter(String nCMSubjectFilter) {
		this.nCMSubjectFilter = nCMSubjectFilter;
	}

	public String getnCMStatusFilter() {
		return nCMStatusFilter;
	}

	public void setnCMStatusFilter(String nCMStatusFilter) {
		this.nCMStatusFilter = nCMStatusFilter;
	}

	public SortColumnBean getSortTodoPlan01() {
		return sortTodoPlan01;
	}

	public void setSortTodoPlan01(SortColumnBean sortTodoPlan01) {
		this.sortTodoPlan01 = sortTodoPlan01;
	}

	public SortColumnBean getSortTodoPlan02() {
		return sortTodoPlan02;
	}

	public void setSortTodoPlan02(SortColumnBean sortTodoPlan02) {
		this.sortTodoPlan02 = sortTodoPlan02;
	}

	public SortColumnBean getSortTodoPlan04() {
		return sortTodoPlan04;
	}

	public void setSortTodoPlan04(SortColumnBean sortTodoPlan04) {
		this.sortTodoPlan04 = sortTodoPlan04;
	}

	public String getFilterTodoPlan01urNo() {
		return filterTodoPlan01urNo;
	}

	public void setFilterTodoPlan01urNo(String filterTodoPlan01urNo) {
		this.filterTodoPlan01urNo = filterTodoPlan01urNo;
	}

	public String getFilterTodoPlan01subject() {
		return filterTodoPlan01subject;
	}

	public void setFilterTodoPlan01subject(String filterTodoPlan01subject) {
		this.filterTodoPlan01subject = filterTodoPlan01subject;
	}

	public String getFilterTodoPlan02urNo() {
		return filterTodoPlan02urNo;
	}

	public void setFilterTodoPlan02urNo(String filterTodoPlan02urNo) {
		this.filterTodoPlan02urNo = filterTodoPlan02urNo;
	}

	public String getFilterTodoPlan02subject() {
		return filterTodoPlan02subject;
	}

	public void setFilterTodoPlan02subject(String filterTodoPlan02subject) {
		this.filterTodoPlan02subject = filterTodoPlan02subject;
	}

	public String getFilterTodoPlan02status() {
		return filterTodoPlan02status;
	}

	public void setFilterTodoPlan02status(String filterTodoPlan02status) {
		this.filterTodoPlan02status = filterTodoPlan02status;
	}

	public String getFilterTodoPlan02rejectBy() {
		return filterTodoPlan02rejectBy;
	}

	public void setFilterTodoPlan02rejectBy(String filterTodoPlan02rejectBy) {
		this.filterTodoPlan02rejectBy = filterTodoPlan02rejectBy;
	}

	public String getFilterTodoPlan02remarks() {
		return filterTodoPlan02remarks;
	}

	public void setFilterTodoPlan02remarks(String filterTodoPlan02remarks) {
		this.filterTodoPlan02remarks = filterTodoPlan02remarks;
	}

	public String getFilterTodoPlan04urNo() {
		return filterTodoPlan04urNo;
	}

	public void setFilterTodoPlan04urNo(String filterTodoPlan04urNo) {
		this.filterTodoPlan04urNo = filterTodoPlan04urNo;
	}

	public String getFilterTodoPlan04subject() {
		return filterTodoPlan04subject;
	}

	public void setFilterTodoPlan04subject(String filterTodoPlan04subject) {
		this.filterTodoPlan04subject = filterTodoPlan04subject;
	}

	public String getFilterTodoPlan04requestBy() {
		return filterTodoPlan04requestBy;
	}

	public void setFilterTodoPlan04requestBy(String filterTodoPlan04requestBy) {
		this.filterTodoPlan04requestBy = filterTodoPlan04requestBy;
	}

	public String getFilterTodoPlan04actionUser() {
		return filterTodoPlan04actionUser;
	}

	public void setFilterTodoPlan04actionUser(String filterTodoPlan04actionUser) {
		this.filterTodoPlan04actionUser = filterTodoPlan04actionUser;
	}

	public SortColumnBean getSortTodoUser01() {
		return sortTodoUser01;
	}

	public void setSortTodoUser01(SortColumnBean sortTodoUser01) {
		this.sortTodoUser01 = sortTodoUser01;
	}

	public SortColumnBean getSortTodoUser02() {
		return sortTodoUser02;
	}

	public void setSortTodoUser02(SortColumnBean sortTodoUser02) {
		this.sortTodoUser02 = sortTodoUser02;
	}

	public SortColumnBean getSortTodoUser03() {
		return sortTodoUser03;
	}

	public void setSortTodoUser03(SortColumnBean sortTodoUser03) {
		this.sortTodoUser03 = sortTodoUser03;
	}

	public SortColumnBean getSortTodoUser04() {
		return sortTodoUser04;
	}

	public void setSortTodoUser04(SortColumnBean sortTodoUser04) {
		this.sortTodoUser04 = sortTodoUser04;
	}

	public String getFilterTodoUser01urNo() {
		return filterTodoUser01urNo;
	}

	public void setFilterTodoUser01urNo(String filterTodoUser01urNo) {
		this.filterTodoUser01urNo = filterTodoUser01urNo;
	}

	public String getFilterTodoUser01subject() {
		return filterTodoUser01subject;
	}

	public void setFilterTodoUser01subject(String filterTodoUser01subject) {
		this.filterTodoUser01subject = filterTodoUser01subject;
	}

	public String getFilterTodoUser02urNo() {
		return filterTodoUser02urNo;
	}

	public void setFilterTodoUser02urNo(String filterTodoUser02urNo) {
		this.filterTodoUser02urNo = filterTodoUser02urNo;
	}

	public String getFilterTodoUser02subject() {
		return filterTodoUser02subject;
	}

	public void setFilterTodoUser02subject(String filterTodoUser02subject) {
		this.filterTodoUser02subject = filterTodoUser02subject;
	}

	public String getFilterTodoUser02status() {
		return filterTodoUser02status;
	}

	public void setFilterTodoUser02status(String filterTodoUser02status) {
		this.filterTodoUser02status = filterTodoUser02status;
	}

	public String getFilterTodoUser02rejectBy() {
		return filterTodoUser02rejectBy;
	}

	public void setFilterTodoUser02rejectBy(String filterTodoUser02rejectBy) {
		this.filterTodoUser02rejectBy = filterTodoUser02rejectBy;
	}

	public String getFilterTodoUser02remarks() {
		return filterTodoUser02remarks;
	}

	public void setFilterTodoUser02remarks(String filterTodoUser02remarks) {
		this.filterTodoUser02remarks = filterTodoUser02remarks;
	}

	public String getFilterTodoUser03urNo() {
		return filterTodoUser03urNo;
	}

	public void setFilterTodoUser03urNo(String filterTodoUser03urNo) {
		this.filterTodoUser03urNo = filterTodoUser03urNo;
	}

	public String getFilterTodoUser03subject() {
		return filterTodoUser03subject;
	}

	public void setFilterTodoUser03subject(String filterTodoUser03subject) {
		this.filterTodoUser03subject = filterTodoUser03subject;
	}

	public String getFilterTodoUser03requestBy() {
		return filterTodoUser03requestBy;
	}

	public void setFilterTodoUser03requestBy(String filterTodoUser03requestBy) {
		this.filterTodoUser03requestBy = filterTodoUser03requestBy;
	}

	public String getFilterTodoUser03actionUser() {
		return filterTodoUser03actionUser;
	}

	public void setFilterTodoUser03actionUser(String filterTodoUser03actionUser) {
		this.filterTodoUser03actionUser = filterTodoUser03actionUser;
	}

	public String getFilterTodoUser04urNo() {
		return filterTodoUser04urNo;
	}

	public void setFilterTodoUser04urNo(String filterTodoUser04urNo) {
		this.filterTodoUser04urNo = filterTodoUser04urNo;
	}

	public String getFilterTodoUser04subject() {
		return filterTodoUser04subject;
	}

	public void setFilterTodoUser04subject(String filterTodoUser04subject) {
		this.filterTodoUser04subject = filterTodoUser04subject;
	}

	public String getFilterTodoUser04requestBy() {
		return filterTodoUser04requestBy;
	}

	public void setFilterTodoUser04requestBy(String filterTodoUser04requestBy) {
		this.filterTodoUser04requestBy = filterTodoUser04requestBy;
	}

	public String getFilterTodoUser04actionUser() {
		return filterTodoUser04actionUser;
	}

	public void setFilterTodoUser04actionUser(String filterTodoUser04actionUser) {
		this.filterTodoUser04actionUser = filterTodoUser04actionUser;
	}

	public SortColumnBean getSortTodoReqNC01() {
		return sortTodoReqNC01;
	}

	public void setSortTodoReqNC01(SortColumnBean sortTodoReqNC01) {
		this.sortTodoReqNC01 = sortTodoReqNC01;
	}

	public SortColumnBean getSortTodoReqNC02Mrg() {
		return sortTodoReqNC02Mrg;
	}

	public void setSortTodoReqNC02Mrg(SortColumnBean sortTodoReqNC02Mrg) {
		this.sortTodoReqNC02Mrg = sortTodoReqNC02Mrg;
	}

	public SortColumnBean getSortTodoReqNC02Owner() {
		return sortTodoReqNC02Owner;
	}

	public void setSortTodoReqNC02Owner(SortColumnBean sortTodoReqNC02Owner) {
		this.sortTodoReqNC02Owner = sortTodoReqNC02Owner;
	}

	public SortColumnBean getSortTodoReqNC03() {
		return sortTodoReqNC03;
	}

	public void setSortTodoReqNC03(SortColumnBean sortTodoReqNC03) {
		this.sortTodoReqNC03 = sortTodoReqNC03;
	}

	public SortColumnBean getSortTodoReqNC05() {
		return sortTodoReqNC05;
	}

	public void setSortTodoReqNC05(SortColumnBean sortTodoReqNC05) {
		this.sortTodoReqNC05 = sortTodoReqNC05;
	}

	public SortColumnBean getSortTodoReqNC11() {
		return sortTodoReqNC11;
	}

	public void setSortTodoReqNC11(SortColumnBean sortTodoReqNC11) {
		this.sortTodoReqNC11 = sortTodoReqNC11;
	}

	public SortColumnBean getSortTodoReqNC12() {
		return sortTodoReqNC12;
	}

	public void setSortTodoReqNC12(SortColumnBean sortTodoReqNC12) {
		this.sortTodoReqNC12 = sortTodoReqNC12;
	}

	public SortColumnBean getSortTodoReqNC06() {
		return sortTodoReqNC06;
	}

	public void setSortTodoReqNC06(SortColumnBean sortTodoReqNC06) {
		this.sortTodoReqNC06 = sortTodoReqNC06;
	}

	public SortColumnBean getSortTodoReqNC07() {
		return sortTodoReqNC07;
	}

	public void setSortTodoReqNC07(SortColumnBean sortTodoReqNC07) {
		this.sortTodoReqNC07 = sortTodoReqNC07;
	}

	public SortColumnBean getSortTodoReqNC08() {
		return sortTodoReqNC08;
	}

	public void setSortTodoReqNC08(SortColumnBean sortTodoReqNC08) {
		this.sortTodoReqNC08 = sortTodoReqNC08;
	}

	public SortColumnBean getSortTodoReqNC09() {
		return sortTodoReqNC09;
	}

	public void setSortTodoReqNC09(SortColumnBean sortTodoReqNC09) {
		this.sortTodoReqNC09 = sortTodoReqNC09;
	}

	public SortColumnBean getSortTodoReqNC10() {
		return sortTodoReqNC10;
	}

	public void setSortTodoReqNC10(SortColumnBean sortTodoReqNC10) {
		this.sortTodoReqNC10 = sortTodoReqNC10;
	}

	public FilterBean getFilterTodoReqNC01() {
		return filterTodoReqNC01;
	}

	public void setFilterTodoReqNC01(FilterBean filterTodoReqNC01) {
		this.filterTodoReqNC01 = filterTodoReqNC01;
	}

	public FilterBean getFilterTodoReqNC02Mrg() {
		return filterTodoReqNC02Mrg;
	}

	public void setFilterTodoReqNC02Mrg(FilterBean filterTodoReqNC02Mrg) {
		this.filterTodoReqNC02Mrg = filterTodoReqNC02Mrg;
	}

	public FilterBean getFilterTodoReqNC02Owner() {
		return filterTodoReqNC02Owner;
	}

	public void setFilterTodoReqNC02Owner(FilterBean filterTodoReqNC02Owner) {
		this.filterTodoReqNC02Owner = filterTodoReqNC02Owner;
	}

	public FilterBean getFilterTodoReqNC03() {
		return filterTodoReqNC03;
	}

	public void setFilterTodoReqNC03(FilterBean filterTodoReqNC03) {
		this.filterTodoReqNC03 = filterTodoReqNC03;
	}

	public FilterBean getFilterTodoReqNC05() {
		return filterTodoReqNC05;
	}

	public void setFilterTodoReqNC05(FilterBean filterTodoReqNC05) {
		this.filterTodoReqNC05 = filterTodoReqNC05;
	}

	public FilterBean getFilterTodoReqNC11() {
		return filterTodoReqNC11;
	}

	public void setFilterTodoReqNC11(FilterBean filterTodoReqNC11) {
		this.filterTodoReqNC11 = filterTodoReqNC11;
	}

	public FilterBean getFilterTodoReqNC12() {
		return filterTodoReqNC12;
	}

	public void setFilterTodoReqNC12(FilterBean filterTodoReqNC12) {
		this.filterTodoReqNC12 = filterTodoReqNC12;
	}

	public FilterBean getFilterTodoReqNC06() {
		return filterTodoReqNC06;
	}

	public void setFilterTodoReqNC06(FilterBean filterTodoReqNC06) {
		this.filterTodoReqNC06 = filterTodoReqNC06;
	}

	public FilterBean getFilterTodoReqNC07() {
		return filterTodoReqNC07;
	}

	public void setFilterTodoReqNC07(FilterBean filterTodoReqNC07) {
		this.filterTodoReqNC07 = filterTodoReqNC07;
	}

	public FilterBean getFilterTodoReqNC08() {
		return filterTodoReqNC08;
	}

	public void setFilterTodoReqNC08(FilterBean filterTodoReqNC08) {
		this.filterTodoReqNC08 = filterTodoReqNC08;
	}

	public FilterBean getFilterTodoReqNC09() {
		return filterTodoReqNC09;
	}

	public void setFilterTodoReqNC09(FilterBean filterTodoReqNC09) {
		this.filterTodoReqNC09 = filterTodoReqNC09;
	}

	public FilterBean getFilterTodoReqNC10() {
		return filterTodoReqNC10;
	}

	public void setFilterTodoReqNC10(FilterBean filterTodoReqNC10) {
		this.filterTodoReqNC10 = filterTodoReqNC10;
	}

	 

}
