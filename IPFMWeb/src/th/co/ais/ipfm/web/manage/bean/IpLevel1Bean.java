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
	private static final long serialVersionUID = 1L;
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

	public boolean isSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(boolean searchFlag) {
		this.searchFlag = searchFlag;
	}

	public boolean isLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(boolean lockFlag) {
		this.lockFlag = lockFlag;
	}

	public HtmlModalPanel getLockModal() {
		return lockModal;
	}

	public void setLockModal(HtmlModalPanel lockModal) {
		this.lockModal = lockModal;
	}

	public IpLevel1 getIpLevel1Detail() {
		return ipLevel1Detail;
	}

	public void setIpLevel1Detail(IpLevel1 ipLevel1Detail) {
		this.ipLevel1Detail = ipLevel1Detail;
	}
	public List<IpLevel2> getIpLevel2List() {
		return ipLevel2List;
	}

	public void setIpLevel2List(List<IpLevel2> ipLevel2List) {
		this.ipLevel2List = ipLevel2List;
	}

	public IpLevel1 getPopupIpLevel1() {
		return popupIpLevel1;
	}

	public void setPopupIpLevel1(IpLevel1 popupIpLevel1) {
		this.popupIpLevel1 = popupIpLevel1;
	}

	public String getSearchIp1() {
		return searchIp1;
	}

	public void setSearchIp1(String searchIp1) {
		this.searchIp1 = searchIp1;
	}

	public String getSearchIp2() {
		return searchIp2;
	}

	public void setSearchIp2(String searchIp2) {
		this.searchIp2 = searchIp2;
	}

	public String getSearchIp3() {
		return searchIp3;
	}

	public void setSearchIp3(String searchIp3) {
		this.searchIp3 = searchIp3;
	}

	public String getSearchIp4() {
		return searchIp4;
	}

	public void setSearchIp4(String searchIp4) {
		this.searchIp4 = searchIp4;
	}

	public String getSearchIp5() {
		return searchIp5;
	}

	public void setSearchIp5(String searchIp5) {
		this.searchIp5 = searchIp5;
	}

	public String getSearchIp6() {
		return searchIp6;
	}

	public void setSearchIp6(String searchIp6) {
		this.searchIp6 = searchIp6;
	}

	public String getSearchMask() {
		return searchMask;
	}

	public void setSearchMask(String searchMask) {
		this.searchMask = searchMask;
	}

	public HtmlDataTable getIpLevel1DataTable() {
		return ipLevel1DataTable;
	}

	public void setIpLevel1DataTable(HtmlDataTable ipLevel1DataTable) {
		this.ipLevel1DataTable = ipLevel1DataTable;
	}

	public IpLevel2 getIpLevel2() {
		return ipLevel2;
	}

	public void setIpLevel2(IpLevel2 ipLevel2) {
		this.ipLevel2 = ipLevel2;
	}

	public HtmlDataTable getIpLevel2DataTable() {
		return ipLevel2DataTable;
	}

	public void setIpLevel2DataTable(HtmlDataTable ipLevel2DataTable) {
		this.ipLevel2DataTable = ipLevel2DataTable;
	}

	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}

	public String getIpStatusName() {
		return ipStatusName;
	}

	public void setIpStatusName(String ipStatusName) {
		this.ipStatusName = ipStatusName;
	}

	public IPFMRichComboItem getIpStatusComboItem() {
		return ipStatusComboItem;
	}

	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) {
		this.ipStatusComboItem = ipStatusComboItem;
	}

	public List<SelectItem> getIpStatusList() {
		return ipStatusList;
	}

	public void setIpStatusList(List<SelectItem> ipStatusList) {
		this.ipStatusList = ipStatusList;
	}

	public String getIpTypeName() {
		return ipTypeName;
	}

	public void setIpTypeName(String ipTypeName) {
		this.ipTypeName = ipTypeName;
	}

	public String getParamIpVersion() {
		return paramIpVersion;
	}

	public void setParamIpVersion(String paramIpVersion) {
		this.paramIpVersion = paramIpVersion;
	}

	public String getParamSearchIp1() {
		return paramSearchIp1;
	}

	public void setParamSearchIp1(String paramSearchIp1) {
		this.paramSearchIp1 = paramSearchIp1;
	}

	public String getParamSearchIp2() {
		return paramSearchIp2;
	}

	public void setParamSearchIp2(String paramSearchIp2) {
		this.paramSearchIp2 = paramSearchIp2;
	}

	public String getParamSearchIp3() {
		return paramSearchIp3;
	}

	public void setParamSearchIp3(String paramSearchIp3) {
		this.paramSearchIp3 = paramSearchIp3;
	}

	public String getParamSearchIp4() {
		return paramSearchIp4;
	}

	public void setParamSearchIp4(String paramSearchIp4) {
		this.paramSearchIp4 = paramSearchIp4;
	}

	public String getParamSearchIp5() {
		return paramSearchIp5;
	}

	public void setParamSearchIp5(String paramSearchIp5) {
		this.paramSearchIp5 = paramSearchIp5;
	}

	public String getParamSearchIp6() {
		return paramSearchIp6;
	}

	public void setParamSearchIp6(String paramSearchIp6) {
		this.paramSearchIp6 = paramSearchIp6;
	}

	public String getParamSearchMask() {
		return paramSearchMask;
	}

	public void setParamSearchMask(String paramSearchMask) {
		this.paramSearchMask = paramSearchMask;
	}

	public List<SelectItem> getAllIpStatusList() {
		return allIpStatusList;
	}

	public void setAllIpStatusList(List<SelectItem> allIpStatusList) {
		this.allIpStatusList = allIpStatusList;
	}

	public String getIpAddress() {
		if (ipVersion.equalsIgnoreCase("6")) 
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4+"."+searchIp5+"."+searchIp6;
		else
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4;
	}
	
	public boolean isIpStatusEdit() {
		return ipStatusEdit;
	}

	public void setIpStatusEdit(boolean ipStatusEdit) {
		this.ipStatusEdit = ipStatusEdit;
	}

	public boolean isExpiredDateEdit() {
		return expiredDateEdit;
	}

	public void setExpiredDateEdit(boolean expiredDateEdit) {
		this.expiredDateEdit = expiredDateEdit;
	}

	public boolean isT1RemarksEdit() {
		return t1RemarksEdit;
	}

	public void setT1RemarksEdit(boolean t1RemarksEdit) {
		this.t1RemarksEdit = t1RemarksEdit;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setSortSIP001View(SortColumnBean sortSIP001View) {
		this.sortSIP001View = sortSIP001View;
	}

	public SortColumnBean getSortSIP001View() {
		return sortSIP001View;
	}

	public void setFilterSIP001View(FilterBean filterSIP001View) {
		this.filterSIP001View = filterSIP001View;
	}

	public FilterBean getFilterSIP001View() {
		return filterSIP001View;
	}
}
