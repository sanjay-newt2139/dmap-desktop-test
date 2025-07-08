package th.co.ais.ipfm.web.master.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.MasterTBL;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.web.bean.FilterBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class MasterTableBean implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	private FilterBean filter001 = new FilterBean();
	private FilterBean filter006 = new FilterBean();
	private FilterBean filter013 = new FilterBean();
	
	private IpUrAttachment ipUrAttachment = new IpUrAttachment();
	
	public IpUrAttachment getIpUrAttachment() {
		return ipUrAttachment;
	}
	public void setIpUrAttachment(IpUrAttachment ipUrAttachment) {
		this.ipUrAttachment = ipUrAttachment;
	}
	private String rowId;
    private Long version;
    private String refTable;
    private String refKey;
    private String refDesc;
    private String shortDesc;
    private String activeStatus;
    private String refType;
    private IpMasterTable masterTBL;
    private List<IpMasterTable> masterTBLList;
	private List<SelectItem> refTableList;
	private List<SelectItem> refKeyList;
    
	private IPFMRichComboItem refKeyComboItem;
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	private boolean displayForEdit;
	private boolean displayForCreate;
	private boolean disabledForEdit;
	private boolean displayHolidays;
	private boolean displayNews;
	private boolean displayOther;
	private boolean displayLogo;
	private boolean displayService;
	
	public boolean isDisplayService() {
		return displayService;
	}
	public void setDisplayService(boolean displayService) {
		this.displayService = displayService;
	}
	public boolean isDisplayLogo() {
		return displayLogo;
	}
	public void setDisplayLogo(boolean displayLogo) {
		this.displayLogo = displayLogo;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getRefTable() {
		return refTable;
	}
	public void setRefTable(String refTable) {
		this.refTable = refTable;
	}
	public String getRefKey() {
		return refKey;
	}
	public void setRefKey(String refKey) {
		this.refKey = refKey;
	}
	public String getRefDesc() {
		return refDesc;
	}
	public void setRefDesc(String refDesc) {
		this.refDesc = refDesc;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() {
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
	}
	public boolean isDisplayForEdit() {
		return displayForEdit;
	}
	public void setDisplayForEdit(boolean displayForEdit) {
		this.displayForEdit = displayForEdit;
	}
	public boolean isDisplayForCreate() {
		return displayForCreate;
	}
	public void setDisplayForCreate(boolean displayForCreate) {
		this.displayForCreate = displayForCreate;
	}
	public List<SelectItem> getRefTableList() {
		return refTableList;
	}
	public void setRefTableList(List<SelectItem> refTableList) {
		this.refTableList = refTableList;
	}
	public List<SelectItem> getRefKeyList() {
		return refKeyList;
	}
	public void setRefKeyList(List<SelectItem> refKeyList) {
		this.refKeyList = refKeyList;
	}
	public IPFMRichComboItem getRefKeyComboItem() {
		return refKeyComboItem;
	}
	public void setRefKeyComboItem(IPFMRichComboItem refKeyComboItem) {
		this.refKeyComboItem = refKeyComboItem;
	}
	public boolean isDisabledForEdit() {
		return disabledForEdit;
	}
	public void setDisabledForEdit(boolean disabledForEdit) {
		this.disabledForEdit = disabledForEdit;
	}
	public boolean isDisplayHolidays() {
		return displayHolidays;
	}
	public void setDisplayHolidays(boolean displayHolidays) {
		this.displayHolidays = displayHolidays;
	}
	public boolean isDisplayNews() {
		return displayNews;
	}
	public void setDisplayNews(boolean displayNews) {
		this.displayNews = displayNews;
	}
	public boolean isDisplayOther() {
		return displayOther;
	}
	public void setDisplayOther(boolean displayOther) {
		this.displayOther = displayOther;
	}
	public IpMasterTable getMasterTBL() {
		return masterTBL;
	}
	public void setMasterTBL(IpMasterTable masterTBL) {
		this.masterTBL = masterTBL;
	}
	public List<IpMasterTable> getMasterTBLList() {
		return masterTBLList;
	}
	public void setMasterTBLList(List<IpMasterTable> masterTBLList) {
		this.masterTBLList = masterTBLList;
	}
	public void setFilter001(FilterBean filter001) {
		this.filter001 = filter001;
	}
	public FilterBean getFilter001() {
		return filter001;
	}
	public void setFilter006(FilterBean filter006) {
		this.filter006 = filter006;
	}
	public FilterBean getFilter006() {
		return filter006;
	}
	public void setFilter013(FilterBean filter013) {
		this.filter013 = filter013;
	}
	public FilterBean getFilter013() {
		return filter013;
	}


	
}
