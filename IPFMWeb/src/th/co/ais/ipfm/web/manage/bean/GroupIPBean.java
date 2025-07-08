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
	private static final long serialVersionUID = 3251774689702918816L;

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
	
	public IPFMRichComboItem getIpClassComboItem() {
		return ipClassComboItem;
	}
	public void setIpClassComboItem(IPFMRichComboItem ipClassComboItem) {
		this.ipClassComboItem = ipClassComboItem;
	}
	public IPFMRichComboItem getCompanyComboItem() {
		return CompanyComboItem;
	}
	public void setCompanyComboItem(IPFMRichComboItem companyComboItem) {
		CompanyComboItem = companyComboItem;
	}
	public Integer getTotalAssignT2() {
		return totalAssignT2;
	}
	public void setTotalAssignT2(Integer totalAssignT2) {
		this.totalAssignT2 = totalAssignT2;
	}
	public Integer getTotalAssignT3() {
		return totalAssignT3;
	}
	public void setTotalAssignT3(Integer totalAssignT3) {
		this.totalAssignT3 = totalAssignT3;
	}
	public String getIpClass() {
		return ipClass;
	}
	public void setIpClass(String ipClass) {
		this.ipClass = ipClass;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public boolean isDisableIP() {
		return disableIP;
	}
	public void setDisableIP(boolean disableIP) {
		this.disableIP = disableIP;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isDisableDesc() {
		return disableDesc;
	}
	public void setDisableDesc(boolean disableDesc) {
		this.disableDesc = disableDesc;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getGrpIPST() {
		return grpIPST;
	}

	public void setGrpIPST(String grpIPST) {
		this.grpIPST = grpIPST;
	}

	public String getGrpIPED() {
		return grpIPED;
	}

	public void setGrpIPED(String grpIPED) {
		this.grpIPED = grpIPED;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getGrpSumTot() {
		return grpSumTot;
	}

	public void setGrpSumTot(Integer grpSumTot) {
		this.grpSumTot = grpSumTot;
	}
	public Integer getGrpSumAssign() {
		return grpSumAssign;
	}

	public void setGrpSumAssign(Integer grpSumAssign) {
		this.grpSumAssign = grpSumAssign;
	}
	
	public String getIpVersion() {
		return ipVersion;
	}
	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}
	public String getTire1TeamID() {
		return tire1TeamID;
	}
	public void setTire1TeamID(String tire1TeamID) {
		this.tire1TeamID = tire1TeamID;
	}
	public String getGrpID() {
		return grpID;
	}
	public void setGrpID(String grpID) {
		this.grpID = grpID;
	}
	public String getStIP1() {
		return stIP1;
	}
	public void setStIP1(String stIP1) {
		this.stIP1 = stIP1;
	}
	public String getStIP2() {
		return stIP2;
	}
	public void setStIP2(String stIP2) {
		this.stIP2 = stIP2;
	}
	public String getStIP3() {
		return stIP3;
	}
	public void setStIP3(String stIP3) {
		this.stIP3 = stIP3;
	}
	public String getStIP4() {
		return stIP4;
	}
	public void setStIP4(String stIP4) {
		this.stIP4 = stIP4;
	}
	public String getStIP5() {
		return stIP5;
	}
	public void setStIP5(String stIP5) {
		this.stIP5 = stIP5;
	}
	public String getStIP6() {
		return stIP6;
	}
	public void setStIP6(String stIP6) {
		this.stIP6 = stIP6;
	}
	public String getEnIP1() {
		return enIP1;
	}
	public void setEnIP1(String enIP1) {
		this.enIP1 = enIP1;
	}
	public String getEnIP2() {
		return enIP2;
	}
	public void setEnIP2(String enIP2) {
		this.enIP2 = enIP2;
	}
	public String getEnIP3() {
		return enIP3;
	}
	public void setEnIP3(String enIP3) {
		this.enIP3 = enIP3;
	}
	public String getEnIP4() {
		return enIP4;
	}
	public void setEnIP4(String enIP4) {
		this.enIP4 = enIP4;
	}
	public String getEnIP5() {
		return enIP5;
	}
	public void setEnIP5(String enIP5) {
		this.enIP5 = enIP5;
	}
	public String getEnIP6() {
		return enIP6;
	}
	public void setEnIP6(String enIP6) {
		this.enIP6 = enIP6;
	}
	public IPGroup getIpGroup() {
		return ipGroup;
	}
	public void setIpGroup(IPGroup ipGroup) {
		this.ipGroup = ipGroup;
	}
	
	public List<SelectItem> getIpVersionList() {
		return ipVersionList;
	}
	public void setIpVersionList(List<SelectItem> ipVersionList) {
		this.ipVersionList = ipVersionList;
	}
	public List<IPGroup> getIpGroupList() {
		return ipGroupList;
	}
	public void setIpGroupList(List<IPGroup> ipGroupList) {
		this.ipGroupList = ipGroupList;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	public String getTire1ID() {
		return tire1ID;
	}
	public void setTire1ID(String tire1id) {
		tire1ID = tire1id;
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
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getIpClassList() {
		return ipClassList;
	}
	public void setIpClassList(List<SelectItem> ipClassList) {
		this.ipClassList = ipClassList;
	}
	public IPDetail getIpDetail() {
		return ipDetail;
	}
	public void setIpDetail(IPDetail ipDetail) {
		this.ipDetail = ipDetail;
	}
	public List<IPDetail> getIpDetailList() {
		return ipDetailList;
	}
	public void setIpDetailList(List<IPDetail> ipDetailList) {
		this.ipDetailList = ipDetailList;
	}
	public IPDetail getPopupIPDetail() {
		return popupIPDetail;
	}
	public void setPopupIPDetail(IPDetail popupIPDetail) {
		this.popupIPDetail = popupIPDetail;
	}

	public String getIpValue() {
		return ipValue;
	}

	public void setIpValue(String ipValue) {
		this.ipValue = ipValue;
	}
	
}
