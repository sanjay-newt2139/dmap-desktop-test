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
	
	
	public String getSystemNameUpdateInfo() {
		return systemNameUpdateInfo;
	}
	public void setSystemNameUpdateInfo(String systemNameUpdateInfo) {
		this.systemNameUpdateInfo = systemNameUpdateInfo;
	}
	public boolean isCheckBoxIPStatus() {
		return checkBoxIPStatus;
	}
	public void setCheckBoxIPStatus(boolean checkBoxIPStatus) {
		this.checkBoxIPStatus = checkBoxIPStatus;
	}
	public boolean isCheckBoxSystemName() {
		return checkBoxSystemName;
	}
	public void setCheckBoxSystemName(boolean checkBoxSystemName) {
		this.checkBoxSystemName = checkBoxSystemName;
	}
	public boolean isCheckBoxExpiredDate() {
		return checkBoxExpiredDate;
	}
	public void setCheckBoxExpiredDate(boolean checkBoxExpiredDate) {
		this.checkBoxExpiredDate = checkBoxExpiredDate;
	}
	public String getIpVersion() {
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
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
	public List<SelectItem> getIpVersionList() {
		return ipVersionList;
	}
	public void setIpVersionList(List<SelectItem> ipVersionList) {
		this.ipVersionList = ipVersionList;
	}
	public List<SelectItem> getIpClassList() {
		return ipClassList;
	}
	public void setIpClassList(List<SelectItem> ipClassList) {
		this.ipClassList = ipClassList;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getZoneList() {
		return zoneList;
	}
	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}
	public List<SelectItem> getNwTypeList() {
		return nwTypeList;
	}
	public void setNwTypeList(List<SelectItem> nwTypeList) {
		this.nwTypeList = nwTypeList;
	}
	public List<SelectItem> getInstallTypeList() {
		return installTypeList;
	}
	public void setInstallTypeList(List<SelectItem> installTypeList) {
		this.installTypeList = installTypeList;
	}
	public IPFMRichComboItem getInstallTypeComboItem() {
		return installTypeComboItem;
	}
	public void setInstallTypeComboItem(IPFMRichComboItem installTypeComboItem) {
		this.installTypeComboItem = installTypeComboItem;
	}
	public IPFMRichComboItem getIpClassComboItem() {
		return ipClassComboItem;
	}
	public void setIpClassComboItem(IPFMRichComboItem ipClassComboItem) {
		this.ipClassComboItem = ipClassComboItem;
	}
	public IPFMRichComboItem getCompanyComboItem() {
		return companyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) {
		this.companyComboItem = companyComboItem;
	}
	public IPFMRichComboItem getNetworkZoneComboItem() {
		return networkZoneComboItem;
	}
	public void setNetworkZoneComboItem(IPFMRichComboItem networkZoneComboItem) {
		this.networkZoneComboItem = networkZoneComboItem;
	}
	public IPFMRichComboItem getNetworkTypeComboItem() {
		return networkTypeComboItem;
	}
	public void setNetworkTypeComboItem(IPFMRichComboItem networkTypeComboItem) {
		this.networkTypeComboItem = networkTypeComboItem;
	}
	public boolean isSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(boolean searchFlag) {
		this.searchFlag = searchFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public HtmlModalPanel getPopupModal() {
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) {
		this.popupModal = popupModal;
	}
	public IpLevel2 getIpLevel2() {
		return ipLevel2;
	}
	public void setIpLevel2(IpLevel2 ipLevel2) {
		this.ipLevel2 = ipLevel2;
	}
	public List<IpLevel2> getIpLevel2List() {
		return ipLevel2List;
	}
	public void setIpLevel2List(List<IpLevel2> ipLevel2List) {
		this.ipLevel2List = ipLevel2List;
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
	public HtmlDataTable getIpLevel2DataTable() {
		return ipLevel2DataTable;
	}
	public void setIpLevel2DataTable(HtmlDataTable ipLevel2DataTable) {
		this.ipLevel2DataTable = ipLevel2DataTable;
	}
	public String getIpAddress() {
		if (ipVersion.equalsIgnoreCase("6")) 
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4+"."+searchIp5+"."+searchIp6;
		else
			return searchIp1+"."+searchIp2+"."+searchIp3+"."+searchIp4;
	}
	public List<SelectItem> getIpStatusList() {
		return ipStatusList;
	}
	public void setIpStatusList(List<SelectItem> ipStatusList) {
		this.ipStatusList = ipStatusList;
	}
	public IPFMRichComboItem getIpStatusComboItem() {
		return ipStatusComboItem;
	}
	public void setIpStatusComboItem(IPFMRichComboItem ipStatusComboItem) {
		this.ipStatusComboItem = ipStatusComboItem;
	}
	public String getIpStatusName() {
		return ipStatusName;
	}
	public void setIpStatusName(String ipStatusName) {
		this.ipStatusName = ipStatusName;
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
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public boolean isIpStatusEdit() {
		return ipStatusEdit;
	}
	public void setIpStatusEdit(boolean ipStatusEdit) {
		this.ipStatusEdit = ipStatusEdit;
	}
	public boolean isIpTypeEdit() {
		return ipTypeEdit;
	}
	public void setIpTypeEdit(boolean ipTypeEdit) {
		this.ipTypeEdit = ipTypeEdit;
	}
	public boolean isNetworkTypeEdit() {
		return networkTypeEdit;
	}
	public void setNetworkTypeEdit(boolean networkTypeEdit) {
		this.networkTypeEdit = networkTypeEdit;
	}
	public boolean isT2RemarksEdit() {
		return t2RemarksEdit;
	}
	public void setT2RemarksEdit(boolean t2RemarksEdit) {
		this.t2RemarksEdit = t2RemarksEdit;
	}
	public List<SelectItem> getIpTypeList() {
		return ipTypeList;
	}
	public void setIpTypeList(List<SelectItem> ipTypeList) {
		this.ipTypeList = ipTypeList;
	}
	public IPFMRichComboItem getIpTypeComboItem() {
		return ipTypeComboItem;
	}
	public void setIpTypeComboItem(IPFMRichComboItem ipTypeComboItem) {
		this.ipTypeComboItem = ipTypeComboItem;
	}
	public void setFilterSIP002View(FilterBean filterSIP002View) {
		this.filterSIP002View = filterSIP002View;
	}
	public FilterBean getFilterSIP002View() {
		return filterSIP002View;
	}
	public void setSortSIP002View(SortColumnBean sortSIP002View) {
		this.sortSIP002View = sortSIP002View;
	}
	public SortColumnBean getSortSIP002View() {
		return sortSIP002View;
	}
	
}
