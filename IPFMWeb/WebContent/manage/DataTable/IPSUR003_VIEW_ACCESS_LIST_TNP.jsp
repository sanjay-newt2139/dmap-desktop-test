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

<h:panelGrid columns="1" width="100%">

	<rich:simpleTogglePanel switchType="client" id="accessListTnpRequestView" label="Policy Access List For TNP"
		width="100%">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
			<tr>
				<td>
				<rich:dataTable width="100%" id="AccessTNPTable1" cellpadding="1" cellspacing="0" border="0" 
						reRender="scrollTNPDetailTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='VIEW'}" value="#{networkConfigBean.listAccessTNP}"
						var="tnp">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP01.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.id.subUrNo,networkConfigBean.filterReqNWCTNP01.filterColumn1)}"
							 width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP01.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="AccessTNPTable1" />
									</h:inputText>
								</h:panelGroup>								
							</f:facet>
							<div align="center">
								<h:outputLink value="#" onclick="viewUrAccessTNP('#{tnp.id.urNo}','#{tnp.id.subUrNo}')">
									<h:outputText value="#{tnp.id.subUrNo}" />
								</h:outputLink>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP01.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP01.filterColumn2) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP01.filterColumn2)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP01.filterColumn2)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP01.filterColumn2)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP01.filterColumn2)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP01.filterColumn2)							
							}"
							 width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP01.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="AccessTNPTable1" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP01.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP01.filterColumn3) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP01.filterColumn3)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP01.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP01.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP01.filterColumn3)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP01.filterColumn3)						
							}"
							 width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP01.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="AccessTNPTable1" />
									</h:inputText>
								</h:panelGroup>								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP01.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP01.filterColumn4)}"
							 width="15%">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP01.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="AccessTNPTable1" />
									</h:inputText>
								</h:panelGroup>								
							</f:facet>
							<div align="center">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP01.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCTNP01.filterColumn5)}"
							 width="10%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP01.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="AccessTNPTable1" />
									</h:inputText>
								</h:panelGroup>							
							</f:facet>
							<div align=center>
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}" />
							</div>
						</rich:column>

						<rich:column width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>								
							</f:facet>
							<div align="center">
								<h:selectBooleanCheckbox id="impactSts" value="#{tnp.isImpact=='Y'}" disabled="true" />
							</div>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP01.filterColumn6}"
							filterExpression="#{fn:containsIgnoreCase(tnp.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCTNP01.filterColumn6)}"
							 width="15%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP01.filterColumn6}" style="width: 50px;">
										<a4j:support event="onblur" reRender="AccessTNPTable1" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText id="subUrSts" value="#{tnp.subUrStatus.subUrStatusName}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller immediate="true" rendered="true" align="right" for="AccessTNPTable1"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTNPDetailTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;" />
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable>
					
					
					
					 <!-- Manager Approve --> 
					 <rich:dataTable width="100%" id="tableAgrApproveAT" cellpadding="1" cellspacing="0"
						border="0" reRender="scrollTNPDetailTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='ManagerApprove'}"
						value="#{networkConfigBean.listAccessTNP}" var="tnp">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP02.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.id.subUrNo,networkConfigBean.filterReqNWCTNP02.filterColumn1)}"
							 width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP02.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAgrApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{tnp.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP02.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP02.filterColumn2) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP02.filterColumn2)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP02.filterColumn2)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP02.filterColumn2)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP02.filterColumn2)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP02.filterColumn2)							
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP02.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAgrApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP02.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP02.filterColumn3) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP02.filterColumn3)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP02.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP02.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP02.filterColumn3)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP02.filterColumn3)						
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP02.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAgrApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP02.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP02.filterColumn4)}"
							 width="20%">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP02.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAgrApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP02.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCTNP02.filterColumn5)}"
							 width="20%">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP02.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableAgrApproveAT" />
									</h:inputText>
								</h:panelGroup>
							
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}" />
							</div>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableAgrApproveAT"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTNPDetailTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;" />
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> 
					
					
					<!-- Owner Approve --> 
					<rich:dataTable width="1500" id="tableOwnerApproveAT" cellpadding="1" cellspacing="0"
						border="0" reRender="scrollTNPDetailTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='OwnerApprove'}"
						value="#{networkConfigBean.listAccessTNP}" var="tnp">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP03.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.id.subUrNo,networkConfigBean.filterReqNWCTNP03.filterColumn1)}"
							 width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
									<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP03.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApproveAT" />
									</h:inputText>
								</h:panelGroup>
							
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{tnp.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP03.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP03.filterColumn2) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP03.filterColumn2)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP03.filterColumn2)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP03.filterColumn2)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP03.filterColumn2)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP03.filterColumn2)							
							}"
							 width="15%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP03.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP03.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP03.filterColumn3) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP03.filterColumn3)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP03.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP03.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP03.filterColumn3)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP03.filterColumn3)						
							}"
							 width="15%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP03.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP03.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP03.filterColumn4)}"
							 width="15%">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP03.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP03.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCTNP03.filterColumn5)}"
							 width="15%">
							<f:facet name="header">
								<h:panelGroup>	<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP03.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApproveAT" />
									</h:inputText>
								</h:panelGroup>
							
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}" />
							</div>
						</rich:column>

						<rich:column width="8%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">								
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.accessListTNP.approveAll}"
										disabled="#{empty networkConfigBean.listAccessTNP}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveAT">
											<f:param name="type" value="APPROVEAll"></f:param>
											<f:param name="currentTab" value="AT"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtApprove" value="#{tnp.isApprove}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveAT">
									<f:param name="type" value="APPROVE"></f:param>
									<f:param name="currentTab" value="AT"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column width="7%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">								
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.accessListTNP.rejectAll}"
										disabled="#{empty networkConfigBean.listAccessTNP}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveAT">
											<f:param name="type" value="REJECTAll"></f:param>
											<f:param name="currentTab" value="AT"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtReject" value="#{tnp.isReject}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveAT">
									<f:param name="type" value="REJECT"></f:param>
									<f:param name="currentTab" value="AT"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP03.filterColumn6}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sysOwnerRemark,networkConfigBean.filterReqNWCTNP03.filterColumn6)}"
							 width="15%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP03.filterColumn6}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableOwnerApproveAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:inputTextarea style="width:100%;" rows="7" value="#{tnp.sysOwnerRemark}" />
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller page="#{networkConfigBean.accessListTNP.pageScroller}" immediate="true" rendered="true"
										align="right" for="tableAgrApproveAT" maxPages="#{ipfmConfigBean.maxPage}" id="scrollTNPDetailTable"
										selectedStyleClass="selectScroll" stepControls="hide" fastControls="auto" boundaryControls="auto"
										fastStep="#{ipfmConfigBean.fastStepPage}" style="background-color: #cccccc;">
										<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}"
											reRender="tableAgrApproveAT">
											<f:param name="currentTab" value="AT"></f:param>
										</a4j:support>
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable>
					
					 <!-- ACTM --> 
					 
					 <rich:dataTable width="100%" id="tableACTMAT" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollTNPDetailTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='ACTM'}" value="#{networkConfigBean.listAccessTNP}"
						var="tnp">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP04.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.id.subUrNo,networkConfigBean.filterReqNWCTNP04.filterColumn1)}"
							 width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP04.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{tnp.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP04.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP04.filterColumn2) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP04.filterColumn2)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP04.filterColumn2)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP04.filterColumn2)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP04.filterColumn2)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP04.filterColumn2)							
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>	<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP04.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMAT" />
									</h:inputText>
								</h:panelGroup>
							
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP04.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP04.filterColumn3) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP04.filterColumn3)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP04.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP04.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP04.filterColumn3)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP04.filterColumn3)						
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP04.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP04.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP04.filterColumn4)}"
							 width="20%">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP04.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP04.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCTNP04.filterColumn5)}"
							 width="20%">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Requiremant Impact" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP04.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}" />
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP04.filterColumn6}"
							filterExpression="#{fn:containsIgnoreCase(tnp.actmRemark,networkConfigBean.filterReqNWCTNP04.filterColumn6)}"
							 width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP04.filterColumn6}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableACTMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:inputTextarea style="width:100%;" rows="7" value="#{tnp.actmRemark}" />
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableACTMAT"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTNPDetailTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> 
					
					<!-- Team Process --> 
					<rich:dataTable width="100%" id="tableTEAMAT" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollTNPDetailTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='TEAM'}" value="#{networkConfigBean.listAccessTNP}"
						var="tnp">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP05.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.id.subUrNo,networkConfigBean.filterReqNWCTNP05.filterColumn1)}"
							 width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP05.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{tnp.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP05.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP05.filterColumn2) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP05.filterColumn2)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP05.filterColumn2)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP05.filterColumn2)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP05.filterColumn2)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP05.filterColumn2)							
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP05.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP05.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP05.filterColumn3) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP05.filterColumn3)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP05.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP05.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP05.filterColumn3)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP05.filterColumn3)						
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP05.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP05.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP05.filterColumn4)}"
							 width="20%" style="vertical-align:top;">
							<f:facet name="header">
							<h:panelGroup><h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP05.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMAT" />
									</h:inputText>
								</h:panelGroup>								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP05.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCTNP05.filterColumn5)}"
							 width="20%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup>
								<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP05.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}" />
							</div>
						</rich:column>

						<rich:column width="8%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">								 
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.accessListTNP.approveAll}"
										disabled="#{empty networkConfigBean.listAccessTNP}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMAT">
											<f:param name="type" value="APPROVEAll"></f:param>
											<f:param name="currentTab" value="AT"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtApprove" value="#{tnp.isApprove}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMAT">
									<f:param name="type" value="APPROVE"></f:param>
									<f:param name="currentTab" value="AT"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column width="7%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
																<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.accessListTNP.rejectAll}"
										disabled="#{empty networkConfigBean.listAccessTNP}">
										<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMAT">
											<f:param name="type" value="REJECTAll"></f:param>
											<f:param name="currentTab" value="AT"></f:param>
										</a4j:support>
									</h:selectBooleanCheckbox>
									<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
								</h:panelGrid>
							</f:facet>
							<h:selectOneRadio id="rtReject" value="#{tnp.isReject}">
								<f:selectItem itemValue="Y" itemLabel="" />
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMAT">
									<f:param name="type" value="REJECT"></f:param>
									<f:param name="currentTab" value="AT"></f:param>
									<f:param name="rowIndex" value="#{index}"></f:param>
								</a4j:support>
							</h:selectOneRadio>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP05.filterColumn6}"
							filterExpression="#{fn:containsIgnoreCase(tnp.teamRemark,networkConfigBean.filterReqNWCTNP05.filterColumn6)}"
							 width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP05.filterColumn6}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableTEAMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:inputTextarea id="remarks" rows="7" style="width:100%" value="#{tnp.teamRemark}"></h:inputTextarea>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller page="#{networkConfigBean.accessListTNP.pageScroller}" immediate="true" rendered="true"
										align="right" for="tableTEAMAT" maxPages="#{ipfmConfigBean.maxPage}" id="scrollTNPDetailTable"
										selectedStyleClass="selectScroll" stepControls="hide" fastControls="auto" boundaryControls="auto"
										fastStep="#{ipfmConfigBean.fastStepPage}" style="background-color: #cccccc;">
										<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableTEAMAT">
											<f:param name="currentTab" value="AT"></f:param>
										</a4j:support>
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> 
					
					<!-- User Verify --> 
					<rich:dataTable width="100%" id="tableUserVerifyAT" cellpadding="1" cellspacing="0"
						border="0" reRender="scrollUserTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='USER'}" value="#{networkConfigBean.listAccessTNP}"
						var="tnp">

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.id.subUrNo,networkConfigBean.filterReqNWCTNP06.filterColumn1)}"
							 width="10%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputText value="#{tnp.id.subUrNo}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP06.filterColumn2) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP06.filterColumn2)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP06.filterColumn2)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP06.filterColumn2)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP06.filterColumn2)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP06.filterColumn2)							
							}"
							 width="16%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP06.filterColumn3) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP06.filterColumn3)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP06.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP06.filterColumn3)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP06.filterColumn3)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP06.filterColumn3)						
							}"
							 width="16%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP06.filterColumn4)}"
							 width="16%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn5}"
							filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCTNP06.filterColumn5)}"
							 width="16%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn5}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}" />
							</div>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn6}"
							filterExpression="#{fn:containsIgnoreCase(tnp.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCTNP06.filterColumn6)}"
							 width="10%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn6}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="1">
								<h:outputText value="#{tnp.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP06.filterColumn7}"
							filterExpression="#{fn:containsIgnoreCase(tnp.pmRemark,networkConfigBean.filterReqNWCTNP06.filterColumn7)}"
							 width="16%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP06.filterColumn7}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tableUserVerifyAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea id="remarks" rows="7" style="width:100%" value="#{tnp.pmRemark}" readonly="true"></h:inputTextarea>
							</div>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyAT"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollUserTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable> 
					
					<!-- PM Assign --> 
					<rich:dataTable width="100%" id="tablePMAT" cellpadding="1" cellspacing="0" border="0"
						reRender="scrollPMATNPTable" rowClasses="odd,even" styleClass="contentform" rowKeyVar="index"
						headerClass="tableHeader" rendered="#{networkConfigBean.mode=='PM'}" value="#{networkConfigBean.listAccessTNP}"
						var="tnp">

						<rich:column width="5%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">								 
								<h:panelGrid columns="2">
									<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.accessListTNP.checkAll}"
										onclick="validateCheckbox('ALL',this,this,'isSelected','pageAT')"
										disabled="#{empty networkConfigBean.listAccessTNP}" />
								</h:panelGrid>
							</f:facet>
							<h:panelGrid columns="1">
								<h:selectBooleanCheckbox id="isSelected" value="#{tnp.isSelected}"
									onclick="validateCheckbox('N',document.getElementById('DetailForm:pageAT:tablePMAT:selectAll'),this,'isSelected','pageAT')" />
							</h:panelGrid>
						</rich:column>

						<rich:column width="10%" style="vertical-align:top;">
							<f:facet name="header">								
								<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							</f:facet>
							<div align="center">
								<h:panelGrid columns="1">
									<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{tnp.id.urNo}','#{tnp.id.subUrNo}')"
										rendered="#{tnp.subUrStatusTxt != 'WAIT_PM'}">
										<h:outputText value="#{tnp.id.subUrNo}" />
									</h:outputLink>
									<h:outputText value="#{tnp.id.subUrNo}" rendered="#{tnp.subUrStatusTxt eq 'WAIT_PM'}" />
								</h:panelGrid>
							</div>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP07.filterColumn1}"
							filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCTNP07.filterColumn1) 
							or fn:containsIgnoreCase(tnp.sourceHostName,networkConfigBean.filterReqNWCTNP07.filterColumn1)
							or fn:containsIgnoreCase(tnp.sourceLocationName,networkConfigBean.filterReqNWCTNP07.filterColumn1)	
							or fn:containsIgnoreCase(tnp.sourceNetworkIp,networkConfigBean.filterReqNWCTNP07.filterColumn1)			
							or fn:containsIgnoreCase(tnp.sourceInterNode,networkConfigBean.filterReqNWCTNP07.filterColumn1)		
							or fn:containsIgnoreCase(tnp.sourceInterNw,networkConfigBean.filterReqNWCTNP07.filterColumn1)							
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP07.filterColumn1}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.sourceInterNw}" />
							</h:panelGrid>
						</rich:column>
						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP07.filterColumn2}"
							filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCTNP07.filterColumn2) 
							or fn:containsIgnoreCase(tnp.destHostName,networkConfigBean.filterReqNWCTNP07.filterColumn2)
							or fn:containsIgnoreCase(tnp.destLocationName,networkConfigBean.filterReqNWCTNP07.filterColumn2)		
							or fn:containsIgnoreCase(tnp.destNetworkIp,networkConfigBean.filterReqNWCTNP07.filterColumn2)		
							or fn:containsIgnoreCase(tnp.destInterNode,networkConfigBean.filterReqNWCTNP07.filterColumn2)	
							or fn:containsIgnoreCase(tnp.destInterNw,networkConfigBean.filterReqNWCTNP07.filterColumn2)						
							}"
							 width="25%" style="vertical-align:top;">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP07.filterColumn2}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<h:panelGrid columns="2">
								<h:outputText value="IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destIp}" />
								<h:outputText value="Host Name:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destHostName}" />
								<h:outputText value="Location:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destLocationName}" />
								<h:outputText value="Network IP:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destNetworkIp}" />
								<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNode}" />
								<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
								<h:outputText value="#{tnp.destInterNw}" />
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP07.filterColumn3}"
							filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCTNP07.filterColumn3)}"
							 width="20%">
							<f:facet name="header">
								<h:panelGroup><h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP07.filterColumn3}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMAT" />
									</h:inputText>
								</h:panelGroup>
								
							</f:facet>
							<div align="left">
								<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.description}" />
							</div>
						</rich:column>
						<rich:column width="10%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">								 
								<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.accessListTNP.impactAll}"
									onclick="validateCheckbox('ALL',this,this,'isImpact','pageAT')"
									disabled="#{empty networkConfigBean.listAccessTNP}" />
								<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
							</f:facet>
							<h:panelGrid columns="1">
								<h:selectBooleanCheckbox id="isImpact" value="#{tnp.impactSelected}"
									onclick="validateCheckbox('N',document.getElementById('DetailForm:pageAT:tablePMAT:impactAll'),this,'isImpact','pageAT')">
									<%
										/* <a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
																								reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
																								<a4j:actionparam name="urNo" value="#{tnp.id.urNo}"/>
																 								<a4j:actionparam name="subUrNo" value="#{tnp.id.subUrNo}"/>
																 								<a4j:actionparam name="currentTab" value="AT" />
																								</a4j:support> */
									%>
								</h:selectBooleanCheckbox>
							</h:panelGrid>
						</rich:column>

						<rich:column filterValue="#{networkConfigBean.filterReqNWCTNP07.filterColumn4}"
							filterExpression="#{fn:containsIgnoreCase(tnp.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCTNP07.filterColumn4)}"
							 width="30%" style="vertical-align:top;text-align:center;">
							<f:facet name="header">
								<h:panelGroup>	<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
									<h:inputText value="#{networkConfigBean.filterReqNWCTNP07.filterColumn4}" style="width: 50px;">
										<a4j:support event="onblur" reRender="tablePMAT" />
									</h:inputText>
								</h:panelGroup>
							
							</f:facet>
							<h:panelGrid columns="1">
								<h:outputText value="#{tnp.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
							</h:panelGrid>
						</rich:column>

						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
								<rich:column colspan="10">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMAT"
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollPMATNPTable" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;">
									</rich:datascroller>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable></td>
				<td>&nbsp;</td>
			</tr>
			<h:inputHidden id="currentTab" value="AT" />
			<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
				<tr>
					<td height="5"><img src="../images/blank.gif" width="10" height="5">
					</td>
				</tr>
				<tr>
					<td align="right"><h:panelGroup id="buttonGroup">
							<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button" onclick="assignJob('AT')">
							</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button"
								rendered="#{not empty networkConfigBean.listAccessTNP}" onclick="rejectJob('AT')">
							</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button" onclick="delegateJob('AT')">
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