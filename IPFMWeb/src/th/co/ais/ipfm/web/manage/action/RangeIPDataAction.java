package th.co.ais.ipfm.web.manage.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.domain.IPRange;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.GroupIPBean;
import th.co.ais.ipfm.web.manage.bean.RangeIPDataBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;

public class RangeIPDataAction extends AbstractAction {
	
	/********************** Bean ***********************/
	public RangeIPDataBean rangeIPDataBean;
	public GroupIPBean groupIPBean;

	public GroupIPBean getGgroupIPBean() {
		return (GroupIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("groupIPBean");
	}

	public void setGroupIPBean(GroupIPBean groupIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("groupIPBean", groupIPBean);
	}
	
	public RangeIPDataBean getRangeIPDataBean() {
		return (RangeIPDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rangeIPDataBean");
	}

	public void setRangeIPDataBean(RangeIPDataBean rangeIPDataBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rangeIPDataBean", rangeIPDataBean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		rangeIPDataBean = getRangeIPDataBean();		
		if(TablSort.equalsIgnoreCase("ipDetailTable")) {
			rangeIPDataBean.setSortIpUrs013(sortColumnChange());	
		}  		
		
		return "";
	}
	

	@Override
	public String init(String programID) {
//		RangeIPDataBean rangeIPDataBean = getRangeIPDataBean();
//		rangeIPDataBean.getIpRange().setVersion("4");
//		setRangeIPDataBean(rangeIPDataBean);
//		if(rangeIPService!=null){
//			try {
//			
//				List<SelectItem> ipVersionList = new ArrayList<SelectItem>();
//				List<SelectItem> ipGroupList = new ArrayList<SelectItem>();
//
//				List<String> ipGroupStringList = null;
//				List<String> ipVersionStringList = null;
//				
//				HashMap result = rangeIPService.initRangeIPSearch(userSession.getIpUser().getUserTeamId());
//				
//				if(result.containsKey(IPFMConstant.LIST_IPGROUP) && result.get(IPFMConstant.LIST_IPGROUP)!=null){
//					ipGroupStringList = (List<String>)result.get(IPFMConstant.LIST_IPGROUP);	
//				}
//				if(result.containsKey(IPFMConstant.LIST_IPVERSION) && result.get(IPFMConstant.LIST_IPVERSION)!=null){
//					ipVersionStringList	= (List<String>)result.get(IPFMConstant.LIST_IPVERSION);
//				}
//				 
//				/// IP Version
//				if(ipVersionStringList!=null && ipVersionStringList.size()>0){
//					for (String str:ipVersionStringList) {
//						ipVersionList.add(new SelectItem(str, str));
//					}
//				}
//				/// Group IP
//				if(ipGroupStringList!=null && ipGroupStringList.size()>0){
//					for (String str:ipGroupStringList) {
//						ipGroupList.add(new SelectItem(str, str));
//					}
//				}
//				
//				List<SelectItem> ipClassList = IPFMComboBoxUtil.getInstance().getIPClassComboBoxItems();
//				List<SelectItem> ipRangeOwnerList = IPFMComboBoxUtil.getInstance().getTier2TeamComboBoxItems();
//				List<SelectItem> zoneList = IPFMComboBoxUtil.getInstance().getZoneComboBoxItems();
//				List<SelectItem> nwTypeList = IPFMComboBoxUtil.getInstance().getNWTypeComboBoxItems();
//				List<SelectItem> companyList = IPFMComboBoxUtil.getInstance().getCompanyComboBoxItems();
//
//				RangeIPBean	rangeIPBean = new RangeIPBean();
//				rangeIPBean.setIpVersionList(ipVersionList);
//				//rangIPBean.setIpVersion(String.valueOf(IPFMComboBoxUtil.getInstance().getIPVersion()));	
//				rangeIPBean.setIpGroupList(ipGroupList);
//				if(ipGroupList!=null && ipGroupList.size()>0){
//					//rangeIPBean.setGrpId(((SelectItem)ipGroupList.get(0)).getValue().toString());
//				}
//				rangeIPBean.setIpClassList(ipClassList);
//				rangeIPBean.setCompanyList(companyList);
//				rangeIPBean.setIpRangeOwnerList(ipRangeOwnerList);
//				rangeIPBean.setZoneList(zoneList);
//				rangeIPBean.setNwTypeList(nwTypeList);
//				setRangeIPBean(rangeIPBean);
//			} catch (IPFMBusinessException e) {
//				e.printStackTrace();
//			}
//		}
		return programID;
	}
	
	public String action_popupEdit(){
		System.out.println("---------action_popupEdit---------");
		RangeIPDataBean rangeIPDataBean = getRangeIPDataBean();
		rangeIPDataBean.getPopupIPRange().setStIp1(getRequestParameter("rangeIP"));
		if (getRequestParameter("lockFieldFlag").equalsIgnoreCase("true")){
			rangeIPDataBean.setLockFieldFlag(true);
		}else{
			rangeIPDataBean.setLockFieldFlag(false);
		}
		rangeIPDataBean.getPopupModal().setRendered(true);
		setRangeIPDataBean(rangeIPDataBean);
		return null;
	}
	
	public String action_popupDetailEdit(){
		System.out.println("---------action_popupDetailEdit---------");
		GroupIPBean groupIPBean = getGgroupIPBean();
		groupIPBean.getPopupIPDetail().setIpAddress(getRequestParameter("rangeIP"));
		groupIPBean.getPopupIPDetail().setHostName("HOST B");
		groupIPBean.getPopupIPDetail().setIpStatusName("Used");
		groupIPBean.getPopupIPDetail().setSystemName("System A");
		groupIPBean.getPopupIPDetail().setGateway("172.0.0.1");
		groupIPBean.getPopupIPDetail().setSubmask("255.255.255.0");
//		if (getRequestParameter("lockFieldFlag").equalsIgnoreCase("true")){
//			groupIPBean.setLockFieldFlag(true);
//		}else{
//			groupIPBean.setLockFieldFlag(false);
//		}
		//groupIPBean.setMode(getRequestParameter("mode"));
		groupIPBean.getPopupModal().setRendered(true);
		setGroupIPBean(groupIPBean);
		return null;
	}
	
	public String action_viewDetail(){
		RangeIPDataBean rangeIPDataBean = getRangeIPDataBean();
		List<IPRange> ipRangeList = new ArrayList<IPRange>();
		IPRange ipRange1;
		for (int i=251 ; i<256 ; i++) {
			ipRange1 = new IPRange();
			ipRange1.setRowId(String.valueOf(i));
			ipRange1.setStIp1("172.0.0."+(i));
			ipRange1.setTotalIP(1);
			ipRange1.setTotalAvailable(0);
			ipRange1.setAssignToUser("0");
			if (i==252) {
				ipRange1.setReserved("0");
				ipRange1.setUsed("1");
			}else{
				ipRange1.setReserved("1");
				ipRange1.setUsed("0");
			}
			ipRangeList.add(ipRange1);
		}
		rangeIPDataBean.setIpRangeList(ipRangeList);
		setRangeIPDataBean(rangeIPDataBean);
		return "IPSIP002_VIEW_DETAIL";
	}
		
	public void search(){
		RangeIPDataBean rangeIPDataBean = getRangeIPDataBean();
		try {
			if(validate()){
//				rangeIPBean.setStIp1("172");
//				rangeIPBean.setStIp2("0");
//				rangeIPBean.setStIp3("0");
//				rangeIPBean.setStIp4("0");
//				rangeIPBean.setStIp5("8");
				List<IPRange> ipRangeList = new ArrayList<IPRange>();
				IPRange ipRange1 = new IPRange();
				ipRange1.setRowId("1");
				ipRange1.setStIp1("172.0.0.0 - 172.0.0.250");
				ipRange1.setTotalIP(251);
				ipRange1.setTotalAvailable(0);
				ipRange1.setAssignToUser("200");
				ipRange1.setReserved("1");
				ipRange1.setUsed("50");
				ipRangeList.add(ipRange1);
				
				IPRange ipRange2 = new IPRange();
				ipRange2.setRowId("2");
				ipRange2.setStIp1("172.0.0.251 - 172.0.0.255");
				ipRange2.setTotalIP(5);
				ipRange2.setTotalAvailable(0);
				ipRange2.setAssignToUser("0");
				ipRange2.setReserved("4");
				ipRange2.setUsed("1");
				ipRangeList.add(ipRange2);
				
				IPRange ipRange3 = new IPRange();
				ipRange3.setRowId("3");
				ipRange3.setStIp1("172.0.2.0 - 172.0.2.100");
				ipRange3.setTotalIP(101);
				ipRange3.setTotalAvailable(0);
				ipRange3.setAssignToUser("0");
				ipRange3.setReserved("101");
				ipRange3.setUsed("0");
				ipRangeList.add(ipRange3);
				
				IPRange ipRange4 = new IPRange();
				ipRange4.setRowId("4");
				ipRange4.setStIp1("172.0.2.101 - 172.0.2.200");
				ipRange4.setTotalIP(100);
				ipRange4.setTotalAvailable(0);
				ipRange4.setAssignToUser("50");
				ipRange4.setReserved("0");
				ipRange4.setUsed("50");
				ipRangeList.add(ipRange4);
				rangeIPDataBean.setIpRangeList(ipRangeList);
				rangeIPDataBean.setSearchFlag(true);
				setRangeIPDataBean(rangeIPDataBean);
			}
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		
	}
	
	public void search1(){
		RangeIPDataBean rangeIPDataBean = getRangeIPDataBean();
		try {
			if(validate()){
				List<IPRange> ipRangeList = new ArrayList<IPRange>();
				IPRange ipRange1 = new IPRange();
				ipRange1.setRowId("1");
				ipRange1.setStIp1("172.0.0.0 - 172.0.0.250");
				ipRange1.setTotalIP(251);
				ipRange1.setTotalAvailable(0);
				ipRange1.setAssignToUser("200");
				ipRange1.setReserved("1");
				ipRange1.setUsed("50");
				ipRangeList.add(ipRange1);
				
				IPRange ipRange2 = new IPRange();
				ipRange2.setRowId("2");
				ipRange2.setStIp1("172.0.0.251 - 172.0.0.255");
				ipRange2.setTotalIP(5);
				ipRange2.setTotalAvailable(0);
				ipRange2.setAssignToUser("0");
				ipRange2.setReserved("5");
				ipRange2.setUsed("0");
				ipRangeList.add(ipRange2);
				
				IPRange ipRange5 = new IPRange();
				ipRange5.setRowId("5");
				ipRange5.setStIp1("172.0.1.0 - 172.0.1.255");
				ipRange5.setTotalIP(256);
				ipRange5.setTotalAvailable(256);
				ipRange5.setAssignToUser("0");
				ipRange5.setReserved("0");
				ipRange5.setUsed("0");
				ipRangeList.add(ipRange5);
				
				IPRange ipRange3 = new IPRange();
				ipRange3.setRowId("3");
				ipRange3.setStIp1("172.0.2.0 - 172.0.2.100");
				ipRange3.setTotalIP(101);
				ipRange3.setTotalAvailable(0);
				ipRange3.setAssignToUser("0");
				ipRange3.setReserved("101");
				ipRange3.setUsed("0");
				ipRangeList.add(ipRange3);
				
				IPRange ipRange4 = new IPRange();
				ipRange4.setRowId("4");
				ipRange4.setStIp1("172.0.2.101 - 172.0.2.200");
				ipRange4.setTotalIP(100);
				ipRange4.setTotalAvailable(0);
				ipRange4.setAssignToUser("50");
				ipRange4.setReserved("0");
				ipRange4.setUsed("50");
				ipRangeList.add(ipRange4);
				
				IPRange ipRange6 = new IPRange();
				ipRange6.setRowId("6");
				ipRange6.setStIp1("172.0.2.201 - 172.0.2.255");
				ipRange6.setTotalIP(55);
				ipRange6.setTotalAvailable(55);
				ipRange6.setAssignToUser("0");
				ipRange6.setReserved("0");
				ipRange6.setUsed("0");
				ipRangeList.add(ipRange6);
				
				IPRange ipRange7 = new IPRange();
				ipRange7.setRowId("7");
				ipRange7.setStIp1("172.0.5.0 - 172.0.5.255");
				ipRange7.setTotalIP(256);
				ipRange7.setTotalAvailable(256);
				ipRange7.setAssignToUser("0");
				ipRange7.setReserved("0");
				ipRange7.setUsed("0");
				ipRangeList.add(ipRange7);
				
				IPRange ipRange8 = new IPRange();
				ipRange8.setRowId("8");
				ipRange8.setStIp1("172.0.6.0 - 172.0.6.49");
				ipRange8.setTotalIP(50);
				ipRange8.setTotalAvailable(50);
				ipRange8.setAssignToUser("0");
				ipRange8.setReserved("0");
				ipRange8.setUsed("0");
				ipRangeList.add(ipRange8);
				
				IPRange ipRange9 = new IPRange();
				ipRange9.setRowId("9");
				ipRange9.setStIp1("172.0.6.50 - 172.0.6.99");
				ipRange9.setTotalIP(50);
				ipRange9.setTotalAvailable(50);
				ipRange9.setAssignToUser("0");
				ipRange9.setReserved("0");
				ipRange9.setUsed("0");
				ipRangeList.add(ipRange9);
				
				rangeIPDataBean.setIpRangeList(ipRangeList);
				setRangeIPDataBean(rangeIPDataBean);
			}
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0011")));
		}
		
	}
	
	
	@Override
	public boolean validate() {
		boolean flgValid = true;

		return flgValid;
	}
}
