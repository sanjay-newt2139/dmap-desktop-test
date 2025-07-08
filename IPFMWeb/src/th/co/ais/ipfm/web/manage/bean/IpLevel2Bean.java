package th.co.ais.ipfm.web.manage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain1.IpLevel2;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.bean.SortColumnBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;


public class IpLevel2Bean extends IPFMBaseBean {
	
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
	
	private String ipStatusName = "";
	private Date expiredDate;
	private IpLevel2 ipLevel2 = new IpLevel2();
	private List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
	private boolean searchFlag = false;
	private boolean lockFlag = false;
	private HtmlModalPanel lockModal;
	private HtmlDataTable ipLevel2DataTable;	
	private HtmlModalPanel popupModal;
	private String userRole;
	private String currentDate;
	private List<SelectItem> ipVersionList = new ArrayList<SelectItem>();
	private List<SelectItem> locationList = new ArrayList<SelectItem>();
	private List<SelectItem> ipClassList = new ArrayList<SelectItem>();
	private List<SelectItem> companyList = new ArrayList<SelectItem>();
	private List<SelectItem> installTypeList = new ArrayList<SelectItem>();
	private List<SelectItem> zoneList = new ArrayList<SelectItem>();
	private List<SelectItem> nwTypeList = new ArrayList<SelectItem>();
	private List<SelectItem> ipStatusList = new ArrayList<SelectItem>();
	private List<SelectItem> allIpStatusList = new ArrayList<SelectItem>();
	private List<SelectItem> ipTypeList = new ArrayList<SelectItem>();
	
	private IPFMRichComboItem ipStatusComboItem;
	private IPFMRichComboItem locationComboItem;
	private IPFMRichComboItem installTypeComboItem;
	private IPFMRichComboItem ipClassComboItem;
	private IPFMRichComboItem companyComboItem;
    private IPFMRichComboItem networkZoneComboItem;				
	private IPFMRichComboItem networkTypeComboItem;
	private IPFMRichComboItem ipTypeComboItem;
	
	private boolean ipStatusEdit = false;
	private boolean ipTypeEdit = false;
	private boolean networkTypeEdit = false;
	private boolean t2RemarksEdit = false;

	private boolean checkBoxIPStatus = false;
	private boolean checkBoxSystemName = false;
	private boolean checkBoxExpiredDate = false;
	private String systemNameUpdateInfo;
	
	private SortColumnBean sortSIP002View = new SortColumnBean();
	private FilterBean filterSIP002View = new FilterBean();
	
	
	public String getSystemNameUpdateInfo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSystemNameUpdateInfo
		return systemNameUpdateInfo;
	}
	public void setSystemNameUpdateInfo(String systemNameUpdateInfo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSystemNameUpdateInfo
		this.systemNameUpdateInfo = systemNameUpdateInfo;
	}
	public boolean isCheckBoxIPStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxIPStatus
		return checkBoxIPStatus;
	}
	public void setCheckBoxIPStatus(boolean checkBoxIPStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxIPStatus
		this.checkBoxIPStatus = checkBoxIPStatus;
	}
	public boolean isCheckBoxSystemName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxSystemName
		return checkBoxSystemName;
	}
	public void setCheckBoxSystemName(boolean checkBoxSystemName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxSystemName
		this.checkBoxSystemName = checkBoxSystemName;
	}
	public boolean isCheckBoxExpiredDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBoxExpiredDate
		return checkBoxExpiredDate;
	}
	public void setCheckBoxExpiredDate(boolean checkBoxExpiredDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBoxExpiredDate
		this.checkBoxExpiredDate = checkBoxExpiredDate;
	}
	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
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
	public List<SelectItem> getIpVersionList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersionList
		return ipVersionList;
	}
	public void setIpVersionList(List<SelectItem> ipVersionList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersionList
		this.ipVersionList = ipVersionList;
	}
	public List<SelectItem> getIpClassList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassList
		return ipClassList;
	}
	public void setIpClassList(List<SelectItem> ipClassList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassList
		this.ipClassList = ipClassList;
	}
	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}
	public List<SelectItem> getZoneList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getZoneList
		return zoneList;
	}
	public void setZoneList(List<SelectItem> zoneList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setZoneList
		this.zoneList = zoneList;
	}
	public List<SelectItem> getNwTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNwTypeList
		return nwTypeList;
	}
	public void setNwTypeList(List<SelectItem> nwTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNwTypeList
		this.nwTypeList = nwTypeList;
	}
	public List<SelectItem> getInstallTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallTypeList
		return installTypeList;
	}
	public void setInstallTypeList(List<SelectItem> installTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallTypeList
		this.installTypeList = installTypeList;
	}
	public IPFMRichComboItem getInstallTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstallTypeComboItem
		return installTypeComboItem;
	}
	public void setInstallTypeComboItem(IPFMRichComboItem installTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setInstallTypeComboItem
		this.installTypeComboItem = installTypeComboItem;
	}
	public IPFMRichComboItem getIpClassComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassComboItem
		return ipClassComboItem;
	}
	public void setIpClassComboItem(IPFMRichComboItem ipClassComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassComboItem
		this.ipClassComboItem = ipClassComboItem;
	}
	public IPFMRichComboItem getCompanyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyComboItem
		return companyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyComboItem
		this.companyComboItem = companyComboItem;
	}
	public IPFMRichComboItem getNetworkZoneComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkZoneComboItem
		return networkZoneComboItem;
	}
	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkZoneComboItem
		this.networkZoneComboItem = networkZoneComboItem;
	}
	public IPFMRichComboItem getNetworkTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNetworkTypeComboItem
		return networkTypeComboItem;
	}
	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeComboItem
		this.networkTypeComboItem = networkTypeComboItem;
	}
	public boolean isSearchFlag() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isSearchFlag
		return searchFlag;
	}
	public void setSearchFlag(boolean searchFlag) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSearchFlag
		this.searchFlag = searchFlag;
	}

	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}
	public HtmlModalPanel getPopupModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupModal
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupModal
		this.popupModal = popupModal;
	}
	public IpLevel2 getIpLevel2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2
		return ipLevel2;
	}
	public void setIpLevel2(IpLevel2 ipLevel2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2
		this.ipLevel2 = ipLevel2;
	}
	public List<IpLevel2> getIpLevel2List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2List
		return ipLevel2List;
	}
	public void setIpLevel2List(List<IpLevel2> ipLevel2List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2List
		this.ipLevel2List = ipLevel2List;
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
	public HtmlDataTable getIpLevel2DataTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpLevel2DataTable
		return ipLevel2DataTable;
	}
	public void setIpLevel2DataTable(HtmlDataTable ipLevel2DataTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpLevel2DataTable
		this.ipLevel2DataTable = ipLevel2DataTable;
	}
	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		if (ipVersion.equalsIgnoreCase("6")) 
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4+"."+searchIp5+"."+searchIp6;
		else
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4;
	}
	public List<SelectItem> getIpStatusList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusList
		return ipStatusList;
	}
	public void setIpStatusList(List<SelectItem> ipStatusList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusList
		this.ipStatusList = ipStatusList;
	}
	public IPFMRichComboItem getIpStatusComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusComboItem
		return ipStatusComboItem;
	}
	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusComboItem
		this.ipStatusComboItem = ipStatusComboItem;
	}
	public String getIpStatusName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpStatusName
		return ipStatusName;
	}
	public void setIpStatusName(String ipStatusName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusName
		this.ipStatusName = ipStatusName;
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
	public String getCurrentDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCurrentDate
		return currentDate;
	}
	public void setCurrentDate(String currentDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCurrentDate
		this.currentDate = currentDate;
	}
	public Date getExpiredDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getExpiredDate
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setExpiredDate
		this.expiredDate = expiredDate;
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
	public String getUserRole() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserRole
		return userRole;
	}
	public void setUserRole(String userRole) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserRole
		this.userRole = userRole;
	}
	public boolean isIpStatusEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpStatusEdit
		return ipStatusEdit;
	}
	public void setIpStatusEdit(boolean ipStatusEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpStatusEdit
		this.ipStatusEdit = ipStatusEdit;
	}
	public boolean isIpTypeEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isIpTypeEdit
		return ipTypeEdit;
	}
	public void setIpTypeEdit(boolean ipTypeEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeEdit
		this.ipTypeEdit = ipTypeEdit;
	}
	public boolean isNetworkTypeEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isNetworkTypeEdit
		return networkTypeEdit;
	}
	public void setNetworkTypeEdit(boolean networkTypeEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNetworkTypeEdit
		this.networkTypeEdit = networkTypeEdit;
	}
	public boolean isT2RemarksEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isT2RemarksEdit
		return t2RemarksEdit;
	}
	public void setT2RemarksEdit(boolean t2RemarksEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setT2RemarksEdit
		this.t2RemarksEdit = t2RemarksEdit;
	}
	public List<SelectItem> getIpTypeList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeList
		return ipTypeList;
	}
	public void setIpTypeList(List<SelectItem> ipTypeList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeList
		this.ipTypeList = ipTypeList;
	}
	public IPFMRichComboItem getIpTypeComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpTypeComboItem
		return ipTypeComboItem;
	}
	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpTypeComboItem
		this.ipTypeComboItem = ipTypeComboItem;
	}
	public void setFilterSIP002View(FilterBean filterSIP002View) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilterSIP002View
		this.filterSIP002View = filterSIP002View;
	}
	public FilterBean getFilterSIP002View() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilterSIP002View
		return filterSIP002View;
	}
	public void setSortSIP002View(SortColumnBean sortSIP002View) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSortSIP002View
		this.sortSIP002View = sortSIP002View;
	}
	public SortColumnBean getSortSIP002View() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSortSIP002View
		return sortSIP002View;
	}
	
}
