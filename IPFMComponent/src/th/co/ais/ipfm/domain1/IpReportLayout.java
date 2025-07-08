package th.co.ais.ipfm.domain1;

import java.util.Date;

import javax.persistence.Column;

public class IpReportLayout implements java.io.Serializable  {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date reqDateFrom;
	private Date reqDateTo;
	private Date runAt;
	private String reportId;
    private String userRole;
    private String userId;
    private String urType;
	private int allTab_WI;
    private int allTab_WO;
    private int allTab_RI;
    private int allTab_RO;
    private int allTab_CI;
    private int allTab_CO;
    private int firewall_WI;
    private int firewall_WO;
    private int firewall_RI;
    private int firewall_RO;
    private int firewall_CI;
    private int firewall_CO;
    private int accessListCDND_WI;
    private int accessListCDND_WO;
    private int accessListCDND_RI;
    private int accessListCDND_RO;
    private int accessListCDND_CI;
    private int accessListCDND_CO;
    private int accessListTNP_WI;
    private int accessListTNP_WO;
    private int accessListTNP_RI;
    private int accessListTNP_RO;
    private int accessListTNP_CI;
    private int accessListTNP_CO;
    private int physicalInterface_WI;
    private int physicalInterface_WO;
    private int physicalInterface_RI;
    private int physicalInterface_RO;
    private int physicalInterface_CI;
    private int physicalInterface_CO;
    private int interfaceGateway_WI;
    private int interfaceGateway_WO;
    private int interfaceGateway_RI;
    private int interfaceGateway_RO;
    private int interfaceGateway_CI;
    private int interfaceGateway_CO;
    private int routing_WI;
    private int routing_WO;
    private int routing_RI;
    private int routing_RO;
    private int routing_CI;
    private int routing_CO;
    private int f5_WI;
    private int f5_WO;
    private int f5_RI;
    private int f5_RO;
    private int f5_CI;
    private int f5_CO;
    
    public Date getReqDateFrom() {
		return reqDateFrom;
	}
	public void setReqDateFrom(Date reqDateFrom) {
		this.reqDateFrom = reqDateFrom;
	}
	public Date getReqDateTo() {
		return reqDateTo;
	}
	public void setReqDateTo(Date reqDateTo) {
		this.reqDateTo = reqDateTo;
	}
	public Date getRunAt() {
		return runAt;
	}
	public void setRunAt(Date runAt) {
		this.runAt = runAt;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUrType() {
		return urType;
	}
	public void setUrType(String urType) {
		this.urType = urType;
	}
	public int getAllTab_WI() {
		return allTab_WI;
	}
	public void setAllTab_WI(int allTabWI) {
		allTab_WI = allTabWI;
	}
	public int getAllTab_WO() {
		return allTab_WO;
	}
	public void setAllTab_WO(int allTabWO) {
		allTab_WO = allTabWO;
	}
	public int getAllTab_RI() {
		return allTab_RI;
	}
	public void setAllTab_RI(int allTabRI) {
		allTab_RI = allTabRI;
	}
	public int getAllTab_RO() {
		return allTab_RO;
	}
	public void setAllTab_RO(int allTabRO) {
		allTab_RO = allTabRO;
	}
	public int getAllTab_CI() {
		return allTab_CI;
	}
	public void setAllTab_CI(int allTabCI) {
		allTab_CI = allTabCI;
	}
	public int getAllTab_CO() {
		return allTab_CO;
	}
	public void setAllTab_CO(int allTabCO) {
		allTab_CO = allTabCO;
	}
	public int getFirewall_WI() {
		return firewall_WI;
	}
	public void setFirewall_WI(int firewallWI) {
		firewall_WI = firewallWI;
	}
	public int getFirewall_WO() {
		return firewall_WO;
	}
	public void setFirewall_WO(int firewallWO) {
		firewall_WO = firewallWO;
	}
	public int getFirewall_RI() {
		return firewall_RI;
	}
	public void setFirewall_RI(int firewallRI) {
		firewall_RI = firewallRI;
	}
	public int getFirewall_RO() {
		return firewall_RO;
	}
	public void setFirewall_RO(int firewallRO) {
		firewall_RO = firewallRO;
	}
	public int getFirewall_CI() {
		return firewall_CI;
	}
	public void setFirewall_CI(int firewallCI) {
		firewall_CI = firewallCI;
	}
	public int getFirewall_CO() {
		return firewall_CO;
	}
	public void setFirewall_CO(int firewallCO) {
		firewall_CO = firewallCO;
	}
	public int getAccessListCDND_WI() {
		return accessListCDND_WI;
	}
	public void setAccessListCDND_WI(int accessListCDNDWI) {
		accessListCDND_WI = accessListCDNDWI;
	}
	public int getAccessListCDND_WO() {
		return accessListCDND_WO;
	}
	public void setAccessListCDND_WO(int accessListCDNDWO) {
		accessListCDND_WO = accessListCDNDWO;
	}
	public int getAccessListCDND_RI() {
		return accessListCDND_RI;
	}
	public void setAccessListCDND_RI(int accessListCDNDRI) {
		accessListCDND_RI = accessListCDNDRI;
	}
	public int getAccessListCDND_RO() {
		return accessListCDND_RO;
	}
	public void setAccessListCDND_RO(int accessListCDNDRO) {
		accessListCDND_RO = accessListCDNDRO;
	}
	public int getAccessListCDND_CI() {
		return accessListCDND_CI;
	}
	public void setAccessListCDND_CI(int accessListCDNDCI) {
		accessListCDND_CI = accessListCDNDCI;
	}
	public int getAccessListCDND_CO() {
		return accessListCDND_CO;
	}
	public void setAccessListCDND_CO(int accessListCDNDCO) {
		accessListCDND_CO = accessListCDNDCO;
	}
	public int getAccessListTNP_WI() {
		return accessListTNP_WI;
	}
	public void setAccessListTNP_WI(int accessListTNPWI) {
		accessListTNP_WI = accessListTNPWI;
	}
	public int getAccessListTNP_WO() {
		return accessListTNP_WO;
	}
	public void setAccessListTNP_WO(int accessListTNPWO) {
		accessListTNP_WO = accessListTNPWO;
	}
	public int getAccessListTNP_RI() {
		return accessListTNP_RI;
	}
	public void setAccessListTNP_RI(int accessListTNPRI) {
		accessListTNP_RI = accessListTNPRI;
	}
	public int getAccessListTNP_RO() {
		return accessListTNP_RO;
	}
	public void setAccessListTNP_RO(int accessListTNPRO) {
		accessListTNP_RO = accessListTNPRO;
	}
	public int getAccessListTNP_CI() {
		return accessListTNP_CI;
	}
	public void setAccessListTNP_CI(int accessListTNPCI) {
		accessListTNP_CI = accessListTNPCI;
	}
	public int getAccessListTNP_CO() {
		return accessListTNP_CO;
	}
	public void setAccessListTNP_CO(int accessListTNPCO) {
		accessListTNP_CO = accessListTNPCO;
	}
	public int getPhysicalInterface_WI() {
		return physicalInterface_WI;
	}
	public void setPhysicalInterface_WI(int physicalInterfaceWI) {
		physicalInterface_WI = physicalInterfaceWI;
	}
	public int getPhysicalInterface_WO() {
		return physicalInterface_WO;
	}
	public void setPhysicalInterface_WO(int physicalInterfaceWO) {
		physicalInterface_WO = physicalInterfaceWO;
	}
	public int getPhysicalInterface_RI() {
		return physicalInterface_RI;
	}
	public void setPhysicalInterface_RI(int physicalInterfaceRI) {
		physicalInterface_RI = physicalInterfaceRI;
	}
	public int getPhysicalInterface_RO() {
		return physicalInterface_RO;
	}
	public void setPhysicalInterface_RO(int physicalInterfaceRO) {
		physicalInterface_RO = physicalInterfaceRO;
	}
	public int getPhysicalInterface_CI() {
		return physicalInterface_CI;
	}
	public void setPhysicalInterface_CI(int physicalInterfaceCI) {
		physicalInterface_CI = physicalInterfaceCI;
	}
	public int getPhysicalInterface_CO() {
		return physicalInterface_CO;
	}
	public void setPhysicalInterface_CO(int physicalInterfaceCO) {
		physicalInterface_CO = physicalInterfaceCO;
	}
	public int getInterfaceGateway_WI() {
		return interfaceGateway_WI;
	}
	public void setInterfaceGateway_WI(int interfaceGatewayWI) {
		interfaceGateway_WI = interfaceGatewayWI;
	}
	public int getInterfaceGateway_WO() {
		return interfaceGateway_WO;
	}
	public void setInterfaceGateway_WO(int interfaceGatewayWO) {
		interfaceGateway_WO = interfaceGatewayWO;
	}
	public int getInterfaceGateway_RI() {
		return interfaceGateway_RI;
	}
	public void setInterfaceGateway_RI(int interfaceGatewayRI) {
		interfaceGateway_RI = interfaceGatewayRI;
	}
	public int getInterfaceGateway_RO() {
		return interfaceGateway_RO;
	}
	public void setInterfaceGateway_RO(int interfaceGatewayRO) {
		interfaceGateway_RO = interfaceGatewayRO;
	}
	public int getInterfaceGateway_CI() {
		return interfaceGateway_CI;
	}
	public void setInterfaceGateway_CI(int interfaceGatewayCI) {
		interfaceGateway_CI = interfaceGatewayCI;
	}
	public int getInterfaceGateway_CO() {
		return interfaceGateway_CO;
	}
	public void setInterfaceGateway_CO(int interfaceGatewayCO) {
		interfaceGateway_CO = interfaceGatewayCO;
	}
	public int getRouting_WI() {
		return routing_WI;
	}
	public void setRouting_WI(int routingWI) {
		routing_WI = routingWI;
	}
	public int getRouting_WO() {
		return routing_WO;
	}
	public void setRouting_WO(int routingWO) {
		routing_WO = routingWO;
	}
	public int getRouting_RI() {
		return routing_RI;
	}
	public void setRouting_RI(int routingRI) {
		routing_RI = routingRI;
	}
	public int getRouting_RO() {
		return routing_RO;
	}
	public void setRouting_RO(int routingRO) {
		routing_RO = routingRO;
	}
	public int getRouting_CI() {
		return routing_CI;
	}
	public void setRouting_CI(int routingCI) {
		routing_CI = routingCI;
	}
	public int getRouting_CO() {
		return routing_CO;
	}
	public void setRouting_CO(int routingCO) {
		routing_CO = routingCO;
	}
	public int getF5_WI() {
		return f5_WI;
	}
	public void setF5_WI(int f5WI) {
		f5_WI = f5WI;
	}
	public int getF5_WO() {
		return f5_WO;
	}
	public void setF5_WO(int f5WO) {
		f5_WO = f5WO;
	}
	public int getF5_RI() {
		return f5_RI;
	}
	public void setF5_RI(int f5RI) {
		f5_RI = f5RI;
	}
	public int getF5_RO() {
		return f5_RO;
	}
	public void setF5_RO(int f5RO) {
		f5_RO = f5RO;
	}
	public int getF5_CI() {
		return f5_CI;
	}
	public void setF5_CI(int f5CI) {
		f5_CI = f5CI;
	}
	public int getF5_CO() {
		return f5_CO;
	}
	public void setF5_CO(int f5CO) {
		f5_CO = f5CO;
	}

}
