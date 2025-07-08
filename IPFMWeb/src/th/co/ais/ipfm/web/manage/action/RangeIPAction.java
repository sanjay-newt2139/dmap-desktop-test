package th.co.ais.ipfm.web.manage.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain.IPRange;
import th.co.ais.ipfm.service.RangeIPService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.RangeIPBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class RangeIPAction extends AbstractAction {
	
	/********************** Bean ***********************/
	public RangeIPBean rangeIPBean;

	public RangeIPBean getRangeIPBean() {
		return (RangeIPBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rangeIPBean");
	}

	public void setRangeIPBean(RangeIPBean rangeIPBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rangeIPBean", rangeIPBean);
	}

	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	public String indexSort() {			
		String TablSort = getRequestParameter("TablSort");
		
		rangeIPBean = getRangeIPBean();		
		if(TablSort.equalsIgnoreCase("IPDataTable")) {
			rangeIPBean.setSortIpUrs002(sortColumnChange());	
		} else if(TablSort.equalsIgnoreCase("RangeIPDataTable")) {
			rangeIPBean.setSortIpUrs0022(sortColumnChange());	
		} 
		return "";
	}
	
	
	public void importData(){
		RangeIPBean rangeIPBean = getRangeIPBean();
		rangeIPBean.setImportError("1");
		System.out.println("--------- rangeIPBean = "+rangeIPBean.getImportError());
	}
	
	public void importData1(){
		RangeIPBean rangeIPBean = getRangeIPBean();
		rangeIPBean.setImportError("2");
		System.out.println("--------- rangeIPBean = "+rangeIPBean.getImportError());
	}
		
	@Override
	public String init(String programID) {
		RangeIPService rangeIPService = (RangeIPService)JSFServiceFinderUtil.getInstance().getBean("rangeIPService");
		UserSession userSession = IPFMWebUtil.getUserSession();
		RangeIPBean rangeIPBean = new RangeIPBean();
		if(rangeIPService!=null){
			setRangeIPBean(rangeIPBean);
		}
		return programID;
	}
	public String action_back(){
		search();
		return "IPSIP001";
	}
	public String action_popupEdit(){
		RangeIPBean rangeIPBean = getRangeIPBean();
		rangeIPBean.getPopupIPRange().setEdIp1(getRequestParameter("rangeIP"));
		if (getRequestParameter("lockFieldFlag").equalsIgnoreCase("true")){
			rangeIPBean.setLockFlag(true);
		}else{
			rangeIPBean.setLockFlag(false);
		}
		rangeIPBean.getLockModal().setRendered(true);
		setRangeIPBean(rangeIPBean);
		return null;
	}
	public String action_viewDetail(){
		RangeIPBean rangeIPBean = getRangeIPBean();
		rangeIPBean.getIpRange().setStIp1(getRequestParameter("rangeIP"));
		List<IPRange> ipRangeList = new ArrayList<IPRange>();
		IPRange ipRange1 = new IPRange();
		ipRange1.setRowId("1");
		ipRange1.setStIp1("172.0.0.0 - 172.0.0.250");
		ipRange1.setTotalIP(251);
		ipRange1.setTotalAvailable(0);
		ipRange1.setAssignToUser("200");
		ipRange1.setReserved("1");
		ipRange1.setUsed("50");
		//ipRange1.setTerminate(0);
		ipRangeList.add(ipRange1);
		
		IPRange ipRange2 = new IPRange();
		ipRange2.setRowId("2");
		ipRange2.setStIp1("172.0.0.251 - 172.0.0.255");
		ipRange2.setTotalIP(5);
		ipRange2.setTotalAvailable(0);
		ipRange2.setAssignToUser("0");
		ipRange2.setReserved("5");
		ipRange2.setUsed("0");
		//ipRange1.setTerminate(0);
		ipRangeList.add(ipRange2);
		
		IPRange ipRange3 = new IPRange();
		ipRange3.setRowId("3");
		ipRange3.setStIp1("172.0.1.1 - 172.0.1.255");
		ipRange3.setTotalIP(255);
		ipRange3.setTotalAvailable(255);
		ipRange3.setAssignToUser("0");
		ipRange3.setReserved("0");
		ipRange3.setUsed("0");
		//ipRange1.setTerminate(0);
		ipRangeList.add(ipRange3);
		
		rangeIPBean.setIpRangeList(ipRangeList);
		setRangeIPBean(rangeIPBean);
		return "IPSIP001_VIEW_DETAIL";
	}
		
	public void search(){
		RangeIPBean rangeIPBean = getRangeIPBean();
//		SearchResult searchResult = null;
//		IPRange ipRange = new IPRange();
		try {
			if(validate()){
				rangeIPBean.getIpRange().setStIp1("172");
				rangeIPBean.getIpRange().setStIp2("0");
				rangeIPBean.getIpRange().setStIp3("0");
				rangeIPBean.getIpRange().setStIp4("0");
				rangeIPBean.getIpRange().setStIp5("8");
				List<IPRange> ipRangeList = new ArrayList<IPRange>();
				IPRange ipRange1 = new IPRange();
				ipRange1.setRowId("0");
				ipRange1.setStIp1("172.0.0.0 - 172.0.1.255");
				ipRange1.setStrTotalIP("511");
				ipRange1.setAssignToPlanning("IP-CDN");
				ipRangeList.add(ipRange1);
				
				IPRange ipRange2 = new IPRange();
				ipRange2.setRowId("1");
				ipRange2.setStIp1("172.0.2.0 - 172.0.2.200");
				ipRange2.setStrTotalIP("201");
				ipRange2.setAssignToPlanning("IP-CDN");
				ipRangeList.add(ipRange2);
				
				IPRange ipRange3 = new IPRange();
				ipRange3.setRowId("2");
				ipRange3.setStIp1("172.1.0.0 - 172.1.255.255");
				ipRange3.setStrTotalIP("65,533");
				ipRange3.setAssignToPlanning("IP-WSP");
				ipRangeList.add(ipRange3);
//				
//				IPRange ipRange4 = new IPRange();
//				ipRange4.setRowId("4");
//				ipRange4.setStIp1("172.16.0.1 - 172.162.255.255");
//				ipRange4.setStrTotalIP("65,653");
//				ipRange4.setAssignToPlanning("8,192");
//				ipRange4.setAssignToUser("256");
//				ipRange4.setReserved("50");
//				ipRange4.setUsed("156");
//				ipRangeList.add(ipRange4);
//				
//				IPRange ipRange5 = new IPRange();
//				ipRange5.setRowId("5");
//				ipRange5.setStIp1("172.20.0.1 - 172.20.255.255");
//				ipRange5.setStrTotalIP("65,653");
//				ipRange5.setAssignToPlanning("64");
//				ipRange5.setAssignToUser("0");
//				ipRange5.setReserved("0");
//				ipRange5.setUsed("0");
//				ipRangeList.add(ipRange5);
				rangeIPBean.setIpRangeList(ipRangeList);
				setRangeIPBean(rangeIPBean);
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
	
	public String addRange(){
		RangeIPService rangeIPService = (RangeIPService)JSFServiceFinderUtil.getInstance().getBean("rangeIPService");	
		UserSession userSession = IPFMWebUtil.getUserSession();
		if(rangeIPService!=null){
			try {
				
				List<SelectItem> ipVersionList = new ArrayList<SelectItem>();				
				List<String> ipVersionStringList = null;
				
				/// IP Version
				if(ipVersionStringList!=null && ipVersionStringList.size()>0){
					for (String str:ipVersionStringList) {
						ipVersionList.add(new SelectItem(str,str));
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return "IPURS002_02";
	}
	
	public String editRange(){
		RangeIPService rangeIPService = (RangeIPService)JSFServiceFinderUtil.getInstance().getBean("rangeIPService");	
		UserSession userSession = IPFMWebUtil.getUserSession();
		if(rangeIPService!=null){
			try {
				setRangeIPBean(rangeIPBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return "IPURS002_02";
	}

}
