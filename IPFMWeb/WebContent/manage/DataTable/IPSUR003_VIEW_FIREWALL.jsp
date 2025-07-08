<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<style type="text/css">
.rich-filter-input {
	width: 80px;
}
</style>

<h:panelGrid id="viewPanelFW" columns="1" width="100%">
	<rich:simpleTogglePanel switchType="client" id="firewallRequestView" label="Policy Firewall Request" width="100%">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
			<tr>
				<td><rich:dataTable width="100%" id="tableAddFirewall" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='VIEW'}" value="#{networkConfigBean.listFirewall}"
						var="firewall">
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW01.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW01.filterColumn1)}"
							width="10%" style="vertical-align:top;">
							 

							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW01.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAddFirewall" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:outputLink value="#" id="link" onclick="viewUrFirewall('#{firewall.id.urNo}','#{firewall.id.subUrNo}')">
									<h:outputText value="#{firewall.id.subUrNo}" />
								</h:outputLink>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW01.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW01.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW01.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW01.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW01.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW01.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW01.filterColumn2)
							}"
							width="20%">
							<f:facet name="header">

								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW01.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAddFirewall" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW01.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW01.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW01.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW01.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW01.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW01.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW01.filterColumn3)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW01.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAddFirewall" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW01.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW01.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW01.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW01.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW01.filterColumn4)
							}"
						width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW01.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAddFirewall" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}" title="#{firewall.serviceTcpPort}" />
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}" title="#{firewall.serviceUdpPort}" />
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}" />
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<rich:column width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>
							</f:facet>
							<div align="center">
								<h:selectBooleanCheckbox id="impactSts" value="#{firewall.isImpact=='Y'}" disabled="true" />
							</div>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW01.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(firewall.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCFW01.filterColumn5)}"
							width="20%" style="vertical-align:top;">
							<f:facet name="header">

								<h:panelGroup>
									<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW01.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAddFirewall" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText id="subUrSts" value="#{firewall.subUrStatus.subUrStatusName}" />
								</h:panelGrid>
							</div>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableAddFirewall"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> <!--  Manager Approve --> <rich:dataTable width="100%" id="tableMgrApprFW" cellpadding="1" cellspacing="0"
						border="0" reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='ManagerApprove'}"
						value="#{networkConfigBean.listFirewall}" var="firewall">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW02.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW02.filterColumn1)}"
							width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW02.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableMgrApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{firewall.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW02.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW02.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW02.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW02.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW02.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW02.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW02.filterColumn2)
							}"
							width="30%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW02.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableMgrApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW02.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW02.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW02.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW02.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW02.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW02.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW02.filterColumn3)
							}"
							width="30%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW02.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableMgrApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>
						
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW02.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW02.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW02.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW02.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW02.filterColumn4)
							}"
							width="30%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW02.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableMgrApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}" title="#{firewall.serviceTcpPort}" />
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}"  title="#{firewall.serviceUdpPort}" />
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}"/>
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApprFW"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> <!--  Owner Approve --> <rich:dataTable width="100%" id="tableOwnerApprFW" cellpadding="1" cellspacing="0"
						border="0" reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='OwnerApprove'}"
						value="#{networkConfigBean.listFirewall}" var="firewall">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW03.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW03.filterColumn1)}"
							width="5%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW03.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{firewall.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW03.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW03.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW03.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW03.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW03.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW03.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW03.filterColumn2)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW03.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW03.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW03.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW03.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW03.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW03.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW03.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW03.filterColumn3)
							}"
							width="20%">
							<f:facet name="header">

								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW03.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>	
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW03.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW03.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW03.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW03.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW03.filterColumn4)
							}"
								width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW03.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}"  title="#{firewall.serviceTcpPort}"/>
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}"  title="#{firewall.serviceUdpPort}" />
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}" />
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<rich:column width="8%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.firewall.approveAll}"
										disabled="#{empty networkConfigBean.listFirewall}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApprFW">
											<f:param name="type" value="APPROVEAll"></f:param>
											<f:param name="currentTab" value="FW"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtApprove" value="#{firewall.isApprove}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApprFW">
									<f:param name="type" value="APPROVE"></f:param>
									<f:param name="currentTab" value="FW"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
									<f:param name="subUrNoSelect" value="#{firewall.id.subUrNo}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column width="7%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.firewall.rejectAll}"
										disabled="#{empty networkConfigBean.listFirewall}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApprFW">
											<f:param name="type" value="REJECTAll"></f:param>
											<f:param name="currentTab" value="FW"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtReject" value="#{firewall.isReject}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApprFW">
									<f:param name="type" value="REJECT"></f:param>
									<f:param name="currentTab" value="FW"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
									<f:param name="subUrNoSelect" value="#{firewall.id.subUrNo}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW03.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW03.filterColumn5) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW03.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW03.filterColumn5)
							}"
							width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW03.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApprFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{firewall.sysOwnerRemark}"></h:inputTextarea>
						</rich:column>


						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller page="#{networkConfigBean.firewall.pageScroller}" immediate="true" rendered="true"
										align="right" for="tableOwnerApprFW" maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable"
										selectedStyleClass="selectScroll" stepControls="hide" fastControls="auto" boundaryControls="auto"
										fastStep="#{ipfmConfigBean.fastStepPage}" style="background-color: #cccccc;">
										<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}"
											reRender="tableOwnerApprFW">
											<f:param name="currentTab" value="FW"></f:param>
										</a4j:support>
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> <!--  ACTM --> <rich:dataTable width="100%" id="tableACTMFW" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='ACTM'}" value="#{networkConfigBean.listFirewall}"
						var="firewall">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW04.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW04.filterColumn1)}"
							width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW04.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{firewall.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW04.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW04.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW04.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW04.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW04.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW04.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW04.filterColumn2)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW04.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW04.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW04.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW04.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW04.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW04.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW04.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW04.filterColumn3)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW04.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW04.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW04.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW04.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW04.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW04.filterColumn4)
							}"
							width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW04.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}" title="#{firewall.serviceTcpPort}" />
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}"  title="#{firewall.serviceUdpPort}"/>
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}" />
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW04.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(firewall.actmRemark,networkConfigBean.filterReqNWCFW04.filterColumn5)}"
							width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW04.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{firewall.actmRemark}"></h:inputTextarea>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableACTMFW"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> <!--  TEAM PROCESS --> <rich:dataTable width="100%" id="tableTEAMFW" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='TEAM'}" value="#{networkConfigBean.listFirewall}"
						var="firewall">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW05.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW05.filterColumn1)}"
							width="5%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW05.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{firewall.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW05.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW05.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW05.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW05.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW05.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW05.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW05.filterColumn2)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW05.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW05.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW05.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW05.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW05.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW05.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW05.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW05.filterColumn3)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW05.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW05.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW05.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW05.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW05.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW05.filterColumn4)
							}"
							width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW05.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}" title="#{firewall.serviceTcpPort}" />
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}"  title="#{firewall.serviceUdpPort}"/>
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}" />
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<rich:column width="8%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.firewall.approveAll}"
										disabled="#{empty networkConfigBean.listFirewall}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMFW">
											<f:param name="type" value="APPROVEAll"></f:param>
											<f:param name="currentTab" value="FW"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtApprove" value="#{firewall.isApprove}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMFW">
									<f:param name="type" value="APPROVE"></f:param>
									<f:param name="currentTab" value="FW"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
									<f:param name="subUrNoSelect" value="#{firewall.id.subUrNo}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column width="7%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.firewall.rejectAll}"
										disabled="#{empty networkConfigBean.listFirewall}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMFW">
											<f:param name="type" value="REJECTAll"></f:param>
											<f:param name="currentTab" value="FW"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtReject" value="#{firewall.isReject}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMFW">
									<f:param name="type" value="REJECT"></f:param>
									<f:param name="currentTab" value="FW"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>	
									<f:param name="subUrNoSelect" value="#{firewall.id.subUrNo}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW05.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW05.filterColumn5) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW05.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW05.filterColumn5)
							}"
							width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW05.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{firewall.teamRemark}"></h:inputTextarea>
						</rich:column>


						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller page="#{networkConfigBean.firewall.pageScroller}" immediate="true" rendered="true"
										align="right" for="tableMgrApprFW" maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable"
										selectedStyleClass="selectScroll" stepControls="hide" fastControls="auto" boundaryControls="auto"
										fastStep="#{ipfmConfigBean.fastStepPage}" style="background-color: #cccccc;">
										<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}"
											reRender="tableMgrApprFW">
											<f:param name="currentTab" value="FW"></f:param>
										</a4j:support>
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> <!-- User Verify --> <rich:dataTable width="100%" id="tableUserVerifyFW" cellpadding="1" cellspacing="0"
						border="0" reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='USER'}" value="#{networkConfigBean.listFirewall}"
						var="firewall">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW06.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW06.filterColumn1)}"
							width="5%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW06.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{firewall.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW06.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW06.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW06.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW06.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW06.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW06.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW06.filterColumn2)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW06.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW06.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW06.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW06.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW06.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW06.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW06.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW06.filterColumn3)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW06.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW06.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW06.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW06.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW06.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW06.filterColumn4)
							}"
							width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW06.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}" title="#{firewall.serviceTcpPort}" />
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}"  title="#{firewall.serviceUdpPort}"/>
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}" />
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW06.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(firewall.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCFW06.filterColumn5)}"
							width="10%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW06.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="1">
								<h:outputText value="#{firewall.subUrStatus.subUrStatusName}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW06.filterColumn6}"
							filterExpression="#{fn:containsIgnoreCase(firewall.pmRemark,networkConfigBean.filterReqNWCFW06.filterColumn6)}"
							width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW06.filterColumn6}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{firewall.pmRemark}" readonly="true"></h:inputTextarea>
						</rich:column>


						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyFW"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> <!-- PM Assign --> <rich:dataTable width="100%" id="tablePMFW" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollFirewallTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='PM'}" value="#{networkConfigBean.listFirewall}"
						var="firewall">

						<rich:column width="5%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.firewall.checkAll}"
										onclick="validateCheckbox('ALL',this,this,'isSelected','pageFW')"
										disabled="#{empty networkConfigBean.listFirewall}" />
								</h:panelGrid>
							</f:facet>
							<h:panelGrid columns="1">
								<h:selectBooleanCheckbox id="isSelected" value="#{firewall.isSelected}"
									onclick="validateCheckbox('N',document.getElementById('DetailForm:pageFW:tablePMFW:selectAll'),this,'isSelected','pageFW')" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW07.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(firewall.id.subUrNo,networkConfigBean.filterReqNWCFW07.filterColumn1)}"
							width="5%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW07.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{firewall.id.urNo}','#{firewall.id.subUrNo}')"
										rendered="#{firewall.subUrStatusTxt != 'WAIT_PM'}">
										<h:outputText value="#{firewall.id.subUrNo}" />
									</h:outputLink>
									<h:outputText value="#{firewall.id.subUrNo}" rendered="#{firewall.subUrStatusTxt eq 'WAIT_PM'}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW07.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW07.filterColumn2) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW07.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW07.filterColumn2)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW07.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW07.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW07.filterColumn2)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW07.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
									<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.sourceNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW07.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW07.filterColumn3)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW07.filterColumn3)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW07.filterColumn3)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW07.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW07.filterColumn3)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW07.filterColumn3)
							}"
							width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW07.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destHostName}" />
								<h:outputText value="Email:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destEmail}" />
								<h:outputText value="VIP:" styleClass="label"></h:outputText>
								<h:panelGroup>
									<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
									<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
								</h:panelGroup>
								<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.destNatIp}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW07.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(firewall.serviceTcpPortStr,networkConfigBean.filterReqNWCFW07.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceUdpPortStr,networkConfigBean.filterReqNWCFW07.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceOtherPortStr,networkConfigBean.filterReqNWCFW07.filterColumn4)
							or fn:containsIgnoreCase(firewall.serviceDesc,networkConfigBean.filterReqNWCFW07.filterColumn4)
							}"
							width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW07.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="TCP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceTcpPortStr}" title="#{firewall.serviceTcpPort}" />
								<h:outputText value="UDP:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceUdpPortStr}"  title="#{firewall.serviceUdpPort}"/>
								<h:outputText value="Other:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceOtherPortStr}" title="#{firewall.serviceOtherPort}" />
								<h:outputText value="Service:" styleClass="label"></h:outputText>
								<h:outputText value="#{firewall.serviceDesc}" escape="false" />
							</h:panelGrid>
						</rich:column>

						<rich:column width="10%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.firewall.impactAll}"
										onclick="validateCheckbox('ALL',this,this,'isImpact','pageFW')"
										disabled="#{empty networkConfigBean.listFirewall}" />
									<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:panelGrid columns="1">
								<h:selectBooleanCheckbox id="isImpact" value="#{firewall.impactSelected}"
									onclick="validateCheckbox('N',document.getElementById('DetailForm:pageFW:tablePMFW:impactAll'),this,'isImpact','pageFW')">
									<%
										/* <a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
																								reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
																								<a4j:actionparam name="urNo" value="#{firewall.id.urNo}"/>
																 								<a4j:actionparam name="subUrNo" value="#{firewall.id.subUrNo}"/>
																 								<a4j:actionparam name="currentTab" value="FW" />
																								</a4j:support> */
									%>
								</h:selectBooleanCheckbox>
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCFW07.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCFW07.filterColumn5) 
							or fn:containsIgnoreCase(firewall.sourceEmail,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(firewall.sourceHostName,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(firewall.sourceNatIp,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'Y','Yes'),networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.sourceVip,'N','No'),networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(firewall.destHostName,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(firewall.destEmail,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(firewall.destNatIp,networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'Y','Yes'),networkConfigBean.filterReqNWCFW07.filterColumn5)
							or fn:containsIgnoreCase(fn:replace(firewall.destVip,'N','No'),networkConfigBean.filterReqNWCFW07.filterColumn5)
							}"
							width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCFW07.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMFW" />
									</h:inputText>
								</h:panelGroup>
							</f:facet>
							<h:panelGrid columns="1">
								<h:outputText value="#{firewall.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
							</h:panelGrid>
						</rich:column>


						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
								<rich:column colspan="8">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMFW"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable></td>
				<td>&nbsp;</td>
			</tr>
			<h:inputHidden id="currentTab" value="FW" />
			<tr>
				<td height="5"><img src="../images/blank.gif" width="10" height="5">
				</td>
			</tr>
			<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
				<tr>
					<td align="right"><h:panelGroup id="buttonGroup">
							<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button" onclick="assignJob('FW')">
							</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button"
								rendered="#{not empty networkConfigBean.listFirewall}" onclick="rejectJob('FW')">
							</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button" onclick="delegateJob('FW')">
							</a4j:commandButton>&nbsp;	
							
					</h:panelGroup></td>
				</tr>
				<tr>
					<td height="5"><img src="../images/blank.gif" width="10" height="5">
					</td>
				</tr>
			</h:panelGroup>
		</table>
	</rich:simpleTogglePanel>


</h:panelGrid>
<jsp:directive.include file="../IPSUR_ALL_JS.jsp"/>