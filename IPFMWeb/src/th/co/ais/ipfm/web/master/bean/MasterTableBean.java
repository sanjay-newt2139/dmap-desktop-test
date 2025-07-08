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
	
	

	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	private FilterBean filter001 = new FilterBean();
	private FilterBean filter006 = new FilterBean();
	private FilterBean filter013 = new FilterBean();
	
	private IpUrAttachment ipUrAttachment = new IpUrAttachment();
	
	public IpUrAttachment getIpUrAttachment() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpUrAttachment
		return ipUrAttachment;
	}
	public void setIpUrAttachment(IpUrAttachment ipUrAttachment) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpUrAttachment
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
	
	public boolean isDisplayService() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayService
		return displayService;
	}
	public void setDisplayService(boolean displayService) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayService
		this.displayService = displayService;
	}
	public boolean isDisplayLogo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayLogo
		return displayLogo;
	}
	public void setDisplayLogo(boolean displayLogo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayLogo
		this.displayLogo = displayLogo;
	}
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}
	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	public Long getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}
	public void setVersion(Long version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}
	public String getRefTable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefTable
		return refTable;
	}
	public void setRefTable(String refTable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefTable
		this.refTable = refTable;
	}
	public String getRefKey() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefKey
		return refKey;
	}
	public void setRefKey(String refKey) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefKey
		this.refKey = refKey;
	}
	public String getRefDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefDesc
		return refDesc;
	}
	public void setRefDesc(String refDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefDesc
		this.refDesc = refDesc;
	}
	public String getShortDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShortDesc
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShortDesc
		this.shortDesc = shortDesc;
	}
	public String getActiveStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActiveStatus
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActiveStatus
		this.activeStatus = activeStatus;
	}
	public String getRefType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefType
		return refType;
	}
	public void setRefType(String refType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefType
		this.refType = refType;
	}
	public int getRowPerPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage
		return maxPage;
	}
	public void setMaxPage(int maxPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult
		this.maxSearchResult = maxSearchResult;
	}
	public boolean isDisplayForEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForEdit
		return displayForEdit;
	}
	public void setDisplayForEdit(boolean displayForEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForEdit
		this.displayForEdit = displayForEdit;
	}
	public boolean isDisplayForCreate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayForCreate
		return displayForCreate;
	}
	public void setDisplayForCreate(boolean displayForCreate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayForCreate
		this.displayForCreate = displayForCreate;
	}
	public List<SelectItem> getRefTableList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefTableList
		return refTableList;
	}
	public void setRefTableList(List<SelectItem> refTableList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefTableList
		this.refTableList = refTableList;
	}
	public List<SelectItem> getRefKeyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefKeyList
		return refKeyList;
	}
	public void setRefKeyList(List<SelectItem> refKeyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefKeyList
		this.refKeyList = refKeyList;
	}
	public IPFMRichComboItem getRefKeyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRefKeyComboItem
		return refKeyComboItem;
	}
	public void setRefKeyComboItem(IPFMRichComboItem refKeyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRefKeyComboItem
		this.refKeyComboItem = refKeyComboItem;
	}
	public boolean isDisabledForEdit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisabledForEdit
		return disabledForEdit;
	}
	public void setDisabledForEdit(boolean disabledForEdit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisabledForEdit
		this.disabledForEdit = disabledForEdit;
	}
	public boolean isDisplayHolidays() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayHolidays
		return displayHolidays;
	}
	public void setDisplayHolidays(boolean displayHolidays) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayHolidays
		this.displayHolidays = displayHolidays;
	}
	public boolean isDisplayNews() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayNews
		return displayNews;
	}
	public void setDisplayNews(boolean displayNews) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayNews
		this.displayNews = displayNews;
	}
	public boolean isDisplayOther() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayOther
		return displayOther;
	}
	public void setDisplayOther(boolean displayOther) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayOther
		this.displayOther = displayOther;
	}
	public IpMasterTable getMasterTBL() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMasterTBL
		return masterTBL;
	}
	public void setMasterTBL(IpMasterTable masterTBL) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMasterTBL
		this.masterTBL = masterTBL;
	}
	public List<IpMasterTable> getMasterTBLList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMasterTBLList
		return masterTBLList;
	}
	public void setMasterTBLList(List<IpMasterTable> masterTBLList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMasterTBLList
		this.masterTBLList = masterTBLList;
	}
	public void setFilter001(FilterBean filter001) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter001
		this.filter001 = filter001;
	}
	public FilterBean getFilter001() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter001
		return filter001;
	}
	public void setFilter006(FilterBean filter006) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter006
		this.filter006 = filter006;
	}
	public FilterBean getFilter006() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter006
		return filter006;
	}
	public void setFilter013(FilterBean filter013) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFilter013
		this.filter013 = filter013;
	}
	public FilterBean getFilter013() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFilter013
		return filter013;
	}


	
}
