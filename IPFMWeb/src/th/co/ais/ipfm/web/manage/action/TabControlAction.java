package th.co.ais.ipfm.web.manage.action;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.manage.bean.IPFirewallBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
public class TabControlAction extends AbstractAction{
	
	private HtmlTab tabFirewall;
	private HtmlTab tabAccessList;
	private HtmlTab tabAccessTNP;
	private HtmlTab tabPhysical;
	private HtmlTab tabGateway;
	private HtmlTab tabRouting;
	private HtmlTab tabF5;
	private HtmlTabPanel tabPanel;
	
	public HtmlTabPanel getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(HtmlTabPanel tabPanel) {
		this.tabPanel = tabPanel;
	}

	public HtmlTab getTabAccessList() {
		return tabAccessList;
	}

	public void setTabAccessList(HtmlTab tabAccessList) {
		this.tabAccessList = tabAccessList;
	}

	public HtmlTab getTabAccessTNP() {
		return tabAccessTNP;
	}

	public void setTabAccessTNP(HtmlTab tabAccessTNP) {
		this.tabAccessTNP = tabAccessTNP;
	}

	public HtmlTab getTabPhysical() {
		return tabPhysical;
	}

	public void setTabPhysical(HtmlTab tabPhysical) {
		this.tabPhysical = tabPhysical;
	}

	public HtmlTab getTabGateway() {
		return tabGateway;
	}

	public void setTabGateway(HtmlTab tabGateway) {
		this.tabGateway = tabGateway;
	}

	public HtmlTab getTabRouting() {
		return tabRouting;
	}

	public void setTabRouting(HtmlTab tabRouting) {
		this.tabRouting = tabRouting;
	}

	public HtmlTab getTabF5() {
		return tabF5;
	}

	public void setTabF5(HtmlTab tabF5) {
		this.tabF5 = tabF5;
	}

	public HtmlTab getTabFirewall() {
		return tabFirewall;
	}

	public void setTabFirewall(HtmlTab tabFirewall) {
		this.tabFirewall = tabFirewall;
	}

	public TabControlAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void disableTab(ActionEvent event){
		
	}

	public void firewallToggle(ActionEvent event){
		
		ReqNWConfigBean bean = getNetworkConfigBean();
		//tabFirewall.setDisabled(!bean.getFirewallCheck());
		if(!bean.getFirewallCheck()){
			IPFirewallBean firewall = new IPFirewallBean();
			firewall.setTcpCheck(false);
			firewall.setUdpCheck(false);
			firewall.setOtherCheck(false);
			//bean.setListFirewall(new ArrayList<IpUrFirewall>());
		} else {
			//tabPanel.setSelectedTab(tabFirewall);
			bean.setCurrentTab("FW");
		}
		setNetworkConfigBean(bean);
			
	}
	
	public void accessListToggle(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		ReqNWConfigBean reqNetworkBean = (getNetworkConfigBean()!=null)?getNetworkConfigBean():new ReqNWConfigBean();
		//tabAccessList.setDisabled(!bean.getAccessListCheck());
		if(!bean.getAccessListCheck()){
			//reqNetworkBean.setListAccessList(new ArrayList<IpUrAccessListCdn>());
		} else {
			//tabPanel.setSelectedTab(tabAccessList);
			bean.setCurrentTab("AL");
		}
		setNetworkConfigBean(reqNetworkBean);
			
	}
	
	public void accessTNPToggle(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		
		ReqNWConfigBean reqNetworkBean = (getNetworkConfigBean()!=null)?getNetworkConfigBean():new ReqNWConfigBean();

		if(!bean.getAccessTNPCheck()){
			//reqNetworkBean.setListFirewall(new ArrayList<IpUrFirewall>());
		} else {
		//	tabPanel.setSelectedTab(tabAccessTNP);
			bean.setCurrentTab("AT");
		}
		setNetworkConfigBean(reqNetworkBean);
		//tabAccessTNP.setDisabled(!bean.getAccessTNPCheck());	
	}
	
	public void physicalToggle(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		ReqNWConfigBean reqNetworkBean = (getNetworkConfigBean()!=null)?getNetworkConfigBean():new ReqNWConfigBean();

		if(!bean.getPhysicalCheck()){
			//reqNetworkBean.setListFirewall(new ArrayList<IpUrFirewall>());
			
		} else {
		//	tabPanel.setSelectedTab(tabPhysical);
			bean.setCurrentTab("PI");
		}
		setNetworkConfigBean(reqNetworkBean);
		//tabPhysical.setDisabled(!bean.getPhysicalCheck());	
	}
	
	public void gatewatToggle(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		ReqNWConfigBean reqNetworkBean = (getNetworkConfigBean()!=null)?getNetworkConfigBean():new ReqNWConfigBean();

		if(!bean.getGatewayCheck()){
			//reqNetworkBean.setListFirewall(new ArrayList<IpUrFirewall>());
		} else {
			//tabPanel.setSelectedTab(tabGateway);
			bean.setCurrentTab("IG");
		}

		setNetworkConfigBean(reqNetworkBean);
		//tabGateway.setDisabled(!bean.getGatewayCheck());	
	}
	
	public void routingToggle(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		ReqNWConfigBean reqNetworkBean = (getNetworkConfigBean()!=null)?getNetworkConfigBean():new ReqNWConfigBean();

		if(!bean.getRoutingCheck()){
			//reqNetworkBean.setListFirewall(new ArrayList<IpUrFirewall>());
		} else {
			//tabPanel.setSelectedTab(tabRouting);
			bean.setCurrentTab("RT");
		}

		setNetworkConfigBean(reqNetworkBean);
		//tabRouting.setDisabled(!bean.getRoutingCheck());	
	}
	
	public void f5Toggle(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		ReqNWConfigBean reqNetworkBean = (getNetworkConfigBean()!=null)?getNetworkConfigBean():new ReqNWConfigBean();

		if(!bean.getF5Check()){
			//reqNetworkBean.setListFirewall(new ArrayList<IpUrFirewall>());
		} else {
			//tabPanel.setSelectedTab(tabF5);
			bean.setCurrentTab("F5");
		}

		setNetworkConfigBean(reqNetworkBean);
		//tabF5.setDisabled(!bean.getF5Check());	
	}
	
	public void setCurrentTab(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String tabName = getRequestParameter("tabName");
		System.out.println("Change Tab To >>> "+tabName);
		bean.setCurrentTab(tabName);
		setNetworkConfigBean(bean);
	}

	public void changeTab(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		bean.setCurrentTab(getRequestParameter("tabName"));
		System.out.println("Change To >> "+bean.getCurrentTab());
		setNetworkConfigBean(bean);
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String init() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String init(String programID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
