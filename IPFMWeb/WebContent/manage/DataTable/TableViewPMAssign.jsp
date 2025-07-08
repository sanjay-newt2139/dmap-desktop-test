<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<rich:simpleTogglePanel switchType="client" id="firewallRequest" label="Policy Firewall Request List">
	<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<rich:dataTable width="100%" id="fierwallPolicyTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="5"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listFirewall}" var="firewall">
				
				
				<rich:column width="10%" style="vertical-align:top;">
					<f:facet name="header"  >
						<h:selectBooleanCheckbox value="1" id="tcpCheckAll" />
					</f:facet>
					<div align="center">
						<h:selectBooleanCheckbox value="1" id="tcpCheck" />
					</div>
				</rich:column>
				
				<rich:column width="30%"  filterValue="#{networkConfigBean.filterTablAccess.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(firewall.urNo,networkConfigBean.filterTablAccess.filterColumn1)}"  style="vertical-align:top;">
					<f:facet name="header">
						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterTablAccess.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="fierwallPolicyTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:outputText value="#{firewall.urNo}" />
				</rich:column>
				<rich:column width="20%"  filterValue="#{networkConfigBean.filterTablAccess.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(firewall.source.ip,networkConfigBean.filterTablAccess.filterColumn2)}" >
					<f:facet name="header">
					
						 <h:panelGroup>
		<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterTablAccess.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="fierwallPolicyTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputLink value="#" id="link">
					        <h:outputText value="#{firewall.source.ip}" />
					        <rich:componentControl for="ViewFirewall" attachTo="link" operation="show" event="onclick"/>
					    </h:outputLink>
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.source.hostName}" />
						<h:outputText value="email:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.source.email}" />
						<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.source.natIp}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="20%"  filterValue="#{networkConfigBean.filterTablAccess.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(firewall.dest.ip,networkConfigBean.filterTablAccess.filterColumn3)}" >
					<f:facet name="header">
						
						 <h:panelGroup>
	<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterTablAccess.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="fierwallPolicyTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.dest.ip}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.dest.hostName}" />
						<h:outputText value="email:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.dest.email}" />
						<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.dest.natIp}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="15%"  filterValue="#{networkConfigBean.filterTablAccess.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(firewall.service.serviceName,networkConfigBean.filterTablAccess.filterColumn4)}"  style="vertical-align:top;">
					<f:facet name="header">
					
						 <h:panelGroup>
	<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterTablAccess.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="fierwallPolicyTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="TCP:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.service.tcpPort}" />
						<h:outputText value="UDP:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.service.udpPort}" />
						<h:outputText value="Service:" styleClass="label"></h:outputText>
						<h:outputText value="#{firewall.service.serviceName}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="10%" style="vertical-align:top;">	
					<f:facet name="header">
						<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:selectBooleanCheckbox value="1" id="chkApprove" />
					</div>
				</rich:column>
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="" />
					</div>
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Total Job" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="" />
					</div>
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Wait for Config Network" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="" />
					</div>
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Reject Job" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="" />
					</div>
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Complete Job" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="" />
					</div>
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Assign Detail" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="" />
					</div>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="fierwallPolicyTable"
								maxPages="5" id="scrollFirewallTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</td>
		<td>&nbsp;</td></tr>
		<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
		<tr><td width="760" align="right">
			<a4j:region renderRegionOnly="true">
				<h:panelGroup id="btnFirewallPolicyGroup">
					<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button"
						reRender="AddFirewallPopup">
						<rich:componentControl for="AddFirewallPopup" attachTo="btnAdd" operation="show" event="onclick"/>
					</a4j:commandButton>&nbsp;
					<a4j:commandButton id="btnImport" value="Import" styleClass="rich-button"
						action="#{manageDataIPAction.init}"
						reRender="groupSearchResult"/>&nbsp;	
					<a4j:commandButton id="btnDelete" value="Delete" styleClass="rich-button"
						action="#{manageDataIPAction.init}"
						reRender="groupSearchResult"/>&nbsp;
				</h:panelGroup>
			</a4j:region>
		</td>
		<td>&nbsp;</td></tr>
	</table>
</rich:simpleTogglePanel>
