package th.co.ais.ipfm.web.manage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.domain.IPGroup;
import th.co.ais.ipfm.web.bean.IPFMBaseBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class GroupIPBean extends IPFMBaseBean {
	private static final long serialVersionUID = 3251774689702918816L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	private IPDetail ipDetail;
	private List<IPDetail> ipDetailList = new ArrayList<IPDetail>();
	private IPDetail popupIPDetail = new IPDetail();
	private String ipValue;
	private String rowId;
	private String ipVersion;
	private String grpID;
	private String tire1ID;
	private String tire1TeamID;
	private String grpIPST;
	private String grpIPED;
	private String grpDesc;
	private Integer version;
	private String isActive="1";
	
	private String stIP1=null;
	private String stIP2=null;
	private String stIP3=null;
	private String stIP4=null;
	private String stIP5=null;
	private String stIP6=null;
	
	private String enIP1=null;
	private String enIP2=null;
	private String enIP3=null;
	private String enIP4=null;
	private String enIP5=null;
	private String enIP6=null;

	private IPGroup ipGroup;
	
	private List<SelectItem> ipVersionList;
	private List<SelectItem> companyList;
	private List<SelectItem> ipClassList;
	private List<IPGroup> ipGroupList;
	
	private boolean disable = false;
	private boolean disableDesc = false;
	private boolean disableIP = false;
	private Integer grpSumTot=0;
	private Integer grpSumAssign=0;
	
	private String userLoginId;
	private String createdBy;
	private Date created;
	private String lastUpdBy;
	private Date lastUpd;
	private Integer totalAssignT2;
	private Integer totalAssignT3;
	private IPFMRichComboItem ipClassComboItem;
	private String ipClass;
	private IPFMRichComboItem CompanyComboItem;
	private String companyID;
	
	private int index;
	
	public GroupIPBean(){
		
	}
	
	public IPFMRichComboItem getIpClassComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassComboItem
		return ipClassComboItem;
	}
	public void setIpClassComboItem(IPFMRichComboItem ipClassComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassComboItem
		this.ipClassComboItem = ipClassComboItem;
	}
	public IPFMRichComboItem getCompanyComboItem() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyComboItem
		return CompanyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyComboItem
		CompanyComboItem = companyComboItem;
	}
	public Integer getTotalAssignT2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalAssignT2
		return totalAssignT2;
	}
	public void setTotalAssignT2(Integer totalAssignT2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalAssignT2
		this.totalAssignT2 = totalAssignT2;
	}
	public Integer getTotalAssignT3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalAssignT3
		return totalAssignT3;
	}
	public void setTotalAssignT3(Integer totalAssignT3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalAssignT3
		this.totalAssignT3 = totalAssignT3;
	}
	public String getIpClass() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClass
		return ipClass;
	}
	public void setIpClass(String ipClass) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClass
		this.ipClass = ipClass;
	}
	public String getCompanyID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyID
		return companyID;
	}
	public void setCompanyID(String companyID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyID
		this.companyID = companyID;
	}
	public boolean isDisableIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisableIP
		return disableIP;
	}
	public void setDisableIP(boolean disableIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisableIP
		this.disableIP = disableIP;
	}
	public int getIndex() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIndex
		return index;
	}
	public void setIndex(int index) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIndex
		this.index = index;
	}
	public boolean isDisableDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisableDesc
		return disableDesc;
	}
	public void setDisableDesc(boolean disableDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisableDesc
		this.disableDesc = disableDesc;
	}
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}
	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}
	public String getUserLoginId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserLoginId
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserLoginId
		this.userLoginId = userLoginId;
	}
	public String getGrpIPST() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpIPST
		return grpIPST;
	}

	public void setGrpIPST(String grpIPST) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpIPST
		this.grpIPST = grpIPST;
	}

	public String getGrpIPED() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpIPED
		return grpIPED;
	}

	public void setGrpIPED(String grpIPED) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpIPED
		this.grpIPED = grpIPED;
	}

	public String getGrpDesc() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpDesc
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpDesc
		this.grpDesc = grpDesc;
	}

	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}

	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}

	public String getIsActive() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsActive
		return isActive;
	}

	public void setIsActive(String isActive) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsActive
		this.isActive = isActive;
	}

	public Integer getGrpSumTot() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpSumTot
		return grpSumTot;
	}

	public void setGrpSumTot(Integer grpSumTot) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpSumTot
		this.grpSumTot = grpSumTot;
	}
	public Integer getGrpSumAssign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpSumAssign
		return grpSumAssign;
	}

	public void setGrpSumAssign(Integer grpSumAssign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpSumAssign
		this.grpSumAssign = grpSumAssign;
	}
	
	public String getIpVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersion
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersion
		this.ipVersion = ipVersion;
	}
	public String getTire1TeamID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTire1TeamID
		return tire1TeamID;
	}
	public void setTire1TeamID(String tire1TeamID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTire1TeamID
		this.tire1TeamID = tire1TeamID;
	}
	public String getGrpID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getGrpID
		return grpID;
	}
	public void setGrpID(String grpID) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setGrpID
		this.grpID = grpID;
	}
	public String getStIP1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP1
		return stIP1;
	}
	public void setStIP1(String stIP1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP1
		this.stIP1 = stIP1;
	}
	public String getStIP2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP2
		return stIP2;
	}
	public void setStIP2(String stIP2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP2
		this.stIP2 = stIP2;
	}
	public String getStIP3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP3
		return stIP3;
	}
	public void setStIP3(String stIP3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP3
		this.stIP3 = stIP3;
	}
	public String getStIP4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP4
		return stIP4;
	}
	public void setStIP4(String stIP4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP4
		this.stIP4 = stIP4;
	}
	public String getStIP5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP5
		return stIP5;
	}
	public void setStIP5(String stIP5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP5
		this.stIP5 = stIP5;
	}
	public String getStIP6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStIP6
		return stIP6;
	}
	public void setStIP6(String stIP6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStIP6
		this.stIP6 = stIP6;
	}
	public String getEnIP1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnIP1
		return enIP1;
	}
	public void setEnIP1(String enIP1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnIP1
		this.enIP1 = enIP1;
	}
	public String getEnIP2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnIP2
		return enIP2;
	}
	public void setEnIP2(String enIP2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnIP2
		this.enIP2 = enIP2;
	}
	public String getEnIP3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnIP3
		return enIP3;
	}
	public void setEnIP3(String enIP3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnIP3
		this.enIP3 = enIP3;
	}
	public String getEnIP4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnIP4
		return enIP4;
	}
	public void setEnIP4(String enIP4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnIP4
		this.enIP4 = enIP4;
	}
	public String getEnIP5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnIP5
		return enIP5;
	}
	public void setEnIP5(String enIP5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnIP5
		this.enIP5 = enIP5;
	}
	public String getEnIP6() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEnIP6
		return enIP6;
	}
	public void setEnIP6(String enIP6) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEnIP6
		this.enIP6 = enIP6;
	}
	public IPGroup getIpGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpGroup
		return ipGroup;
	}
	public void setIpGroup(IPGroup ipGroup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpGroup
		this.ipGroup = ipGroup;
	}
	
	public List<SelectItem> getIpVersionList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpVersionList
		return ipVersionList;
	}
	public void setIpVersionList(List<SelectItem> ipVersionList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpVersionList
		this.ipVersionList = ipVersionList;
	}
	public List<IPGroup> getIpGroupList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpGroupList
		return ipGroupList;
	}
	public void setIpGroupList(List<IPGroup> ipGroupList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpGroupList
		this.ipGroupList = ipGroupList;
	}
	public boolean isDisable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisable
		return disable;
	}
	public void setDisable(boolean disable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisable
		this.disable = disable;
	}
	public String getTire1ID() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTire1ID
		return tire1ID;
	}
	public void setTire1ID(String tire1id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTire1ID
		tire1ID = tire1id;
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
	public List<SelectItem> getCompanyList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCompanyList
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCompanyList
		this.companyList = companyList;
	}
	public List<SelectItem> getIpClassList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpClassList
		return ipClassList;
	}
	public void setIpClassList(List<SelectItem> ipClassList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpClassList
		this.ipClassList = ipClassList;
	}
	public IPDetail getIpDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpDetail
		return ipDetail;
	}
	public void setIpDetail(IPDetail ipDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpDetail
		this.ipDetail = ipDetail;
	}
	public List<IPDetail> getIpDetailList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpDetailList
		return ipDetailList;
	}
	public void setIpDetailList(List<IPDetail> ipDetailList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpDetailList
		this.ipDetailList = ipDetailList;
	}
	public IPDetail getPopupIPDetail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupIPDetail
		return popupIPDetail;
	}
	public void setPopupIPDetail(IPDetail popupIPDetail) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupIPDetail
		this.popupIPDetail = popupIPDetail;
	}

	public String getIpValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpValue
		return ipValue;
	}

	public void setIpValue(String ipValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpValue
		this.ipValue = ipValue;
	}
	
}
