package th.co.ais.ipfm.web.manage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain1.IpLevel1;
import th.co.ais.ipfm.domain1.IpLevel2;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;


public class IpLevel1Bean extends IPFMBaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private String ipVersion = "4";
	private String searchIp1 = "";
	private String searchIp2 = "";
	private String searchIp3 = "";
	private String searchIp4 = "";
	private String searchIp5 = "";
	private String searchIp6 = "";
	private String searchMask = "";
	
	private String paramIpVersion = "4";
	private String paramSearchIp1 = "";
	private String paramSearchIp2 = "";
	private String paramSearchIp3 = "";
	private String paramSearchIp4 = "";
	private String paramSearchIp5 = "";
	private String paramSearchIp6 = "";
	private String paramSearchMask = "";
	private String userRole = "";
	private String ipTypeName = "";
	private String ipStatusName = "";
	private IPFMRichComboItem ipStatusComboItem;
	private List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
	private List<SelectItem> allIpStatusList = new ArrayList<SelectItem>();
	private IpLevel1 ipLevel1 = new IpLevel1();
	private IpLevel2 ipLevel2 = new IpLevel2();
	private IpLevel1 ipLevel1Detail = new IpLevel1();
	private List<IpLevel1> ipLevel1List;
	private List<IpLevel2> ipLevel2List;
	private boolean searchFlag = false;
	private boolean lockFlag = false;
	private HtmlModalPanel lockModal;
	private IpLevel1 popupIpLevel1 = new IpLevel1();
	private HtmlDataTable ipLevel1DataTable;
	private HtmlDataTable ipLevel2DataTable;
	private boolean ipStatusEdit = false;
	private boolean expiredDateEdit = false;
	private boolean t1RemarksEdit = false;

	private SortColumnBean sortSIP001View = new SortColumnBean();
	private FilterBean filterSIP001View = new FilterBean();

	
	
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

	public boolean isSearchFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSearchFlag
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchFlag
		this.searchFlag = searchFlag;
	}

	public boolean isLockFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isLockFlag
		return lockFlag;
	}

	public void setLockFlag(boolean lockFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLockFlag
		this.lockFlag = lockFlag;
	}

	public HtmlModalPanel getLockModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLockModal
		return lockModal;
	}

	public void setLockModal(HtmlModalPanel lockModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLockModal
		this.lockModal = lockModal;
	}

	public IpLevel1 getIpLevel1Detail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel1Detail
		return ipLevel1Detail;
	}

	public void setIpLevel1Detail(IpLevel1 ipLevel1Detail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel1Detail
		this.ipLevel1Detail = ipLevel1Detail;
	}
	public List<IpLevel2> getIpLevel2List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2List
		return ipLevel2List;
	}

	public void setIpLevel2List(List<IpLevel2> ipLevel2List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2List
		this.ipLevel2List = ipLevel2List;
	}

	public IpLevel1 getPopupIpLevel1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupIpLevel1
		return popupIpLevel1;
	}

	public void setPopupIpLevel1(IpLevel1 popupIpLevel1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupIpLevel1
		this.popupIpLevel1 = popupIpLevel1;
	}

	public String getSearchIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp1
		return searchIp1;
	}

	public void setSearchIp1(String searchIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp1
		this.searchIp1 = searchIp1;
	}

	public String getSearchIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp2
		return searchIp2;
	}

	public void setSearchIp2(String searchIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp2
		this.searchIp2 = searchIp2;
	}

	public String getSearchIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp3
		return searchIp3;
	}

	public void setSearchIp3(String searchIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp3
		this.searchIp3 = searchIp3;
	}

	public String getSearchIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp4
		return searchIp4;
	}

	public void setSearchIp4(String searchIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp4
		this.searchIp4 = searchIp4;
	}

	public String getSearchIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp5
		return searchIp5;
	}

	public void setSearchIp5(String searchIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp5
		this.searchIp5 = searchIp5;
	}

	public String getSearchIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchIp6
		return searchIp6;
	}

	public void setSearchIp6(String searchIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchIp6
		this.searchIp6 = searchIp6;
	}

	public String getSearchMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSearchMask
		return searchMask;
	}

	public void setSearchMask(String searchMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchMask
		this.searchMask = searchMask;
	}

	public HtmlDataTable getIpLevel1DataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel1DataTable
		return ipLevel1DataTable;
	}

	public void setIpLevel1DataTable(HtmlDataTable ipLevel1DataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel1DataTable
		this.ipLevel1DataTable = ipLevel1DataTable;
	}

	public IpLevel2 getIpLevel2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2
		return ipLevel2;
	}

	public void setIpLevel2(IpLevel2 ipLevel2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2
		this.ipLevel2 = ipLevel2;
	}

	public HtmlDataTable getIpLevel2DataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2DataTable
		return ipLevel2DataTable;
	}

	public void setIpLevel2DataTable(HtmlDataTable ipLevel2DataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2DataTable
		this.ipLevel2DataTable = ipLevel2DataTable;
	}

	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}

	public String getIpStatusName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusName
		return ipStatusName;
	}

	public void setIpStatusName(String ipStatusName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusName
		this.ipStatusName = ipStatusName;
	}

	public IPFMRichComboItem getIpStatusComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusComboItem
		return ipStatusComboItem;
	}

	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusComboItem
		this.ipStatusComboItem = ipStatusComboItem;
	}

	public List<SelectItem> getIpStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusList
		return ipStatusList;
	}

	public void setIpStatusList(List<SelectItem> ipStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusList
		this.ipStatusList = ipStatusList;
	}

	public String getIpTypeName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeName
		return ipTypeName;
	}

	public void setIpTypeName(String ipTypeName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeName
		this.ipTypeName = ipTypeName;
	}

	public String getParamIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamIpVersion
		return paramIpVersion;
	}

	public void setParamIpVersion(String paramIpVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamIpVersion
		this.paramIpVersion = paramIpVersion;
	}

	public String getParamSearchIp1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp1
		return paramSearchIp1;
	}

	public void setParamSearchIp1(String paramSearchIp1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp1
		this.paramSearchIp1 = paramSearchIp1;
	}

	public String getParamSearchIp2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp2
		return paramSearchIp2;
	}

	public void setParamSearchIp2(String paramSearchIp2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp2
		this.paramSearchIp2 = paramSearchIp2;
	}

	public String getParamSearchIp3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp3
		return paramSearchIp3;
	}

	public void setParamSearchIp3(String paramSearchIp3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp3
		this.paramSearchIp3 = paramSearchIp3;
	}

	public String getParamSearchIp4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp4
		return paramSearchIp4;
	}

	public void setParamSearchIp4(String paramSearchIp4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp4
		this.paramSearchIp4 = paramSearchIp4;
	}

	public String getParamSearchIp5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp5
		return paramSearchIp5;
	}

	public void setParamSearchIp5(String paramSearchIp5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp5
		this.paramSearchIp5 = paramSearchIp5;
	}

	public String getParamSearchIp6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchIp6
		return paramSearchIp6;
	}

	public void setParamSearchIp6(String paramSearchIp6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchIp6
		this.paramSearchIp6 = paramSearchIp6;
	}

	public String getParamSearchMask() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParamSearchMask
		return paramSearchMask;
	}

	public void setParamSearchMask(String paramSearchMask) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParamSearchMask
		this.paramSearchMask = paramSearchMask;
	}

	public List<SelectItem> getAllIpStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAllIpStatusList
		return allIpStatusList;
	}

	public void setAllIpStatusList(List<SelectItem> allIpStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAllIpStatusList
		this.allIpStatusList = allIpStatusList;
	}

	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		if (ipVersion.equalsIgnoreCase("6")) 
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4+"."+searchIp5+"."+searchIp6;
		else
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4;
	}
	
	public boolean isIpStatusEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpStatusEdit
		return ipStatusEdit;
	}

	public void setIpStatusEdit(boolean ipStatusEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusEdit
		this.ipStatusEdit = ipStatusEdit;
	}

	public boolean isExpiredDateEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isExpiredDateEdit
		return expiredDateEdit;
	}

	public void setExpiredDateEdit(boolean expiredDateEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpiredDateEdit
		this.expiredDateEdit = expiredDateEdit;
	}

	public boolean isT1RemarksEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isT1RemarksEdit
		return t1RemarksEdit;
	}

	public void setT1RemarksEdit(boolean t1RemarksEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT1RemarksEdit
		this.t1RemarksEdit = t1RemarksEdit;
	}

	public String getUserRole() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserRole
		return userRole;
	}

	public void setUserRole(String userRole) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserRole
		this.userRole = userRole;
	}

	public void setSortSIP001View(SortColumnBean sortSIP001View) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortSIP001View
		this.sortSIP001View = sortSIP001View;
	}

	public SortColumnBean getSortSIP001View() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortSIP001View
		return sortSIP001View;
	}

	public void setFilterSIP001View(FilterBean filterSIP001View) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterSIP001View
		this.filterSIP001View = filterSIP001View;
	}

	public FilterBean getFilterSIP001View() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterSIP001View
		return filterSIP001View;
	}
}
