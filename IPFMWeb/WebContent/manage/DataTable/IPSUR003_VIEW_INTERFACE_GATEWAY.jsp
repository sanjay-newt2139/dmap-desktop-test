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

<h:panelGrid id="viewPanelIG" columns="1" width="100%">

<rich:simpleTogglePanel switchType="client" id="InterfaceGatewayRequestView" label="Policy Interface Gateway"  width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<rich:dataTable width="100%" id="GatewayTable" cellpadding="1" cellspacing="0" border="0" 
				reRender="scrollIGDetailTable" 
					rowClasses="odd,even" 
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='VIEW'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW01.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW01.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW01.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="GatewayTable" />
		 </h:inputText>
	 </h:panelGroup> 
					</f:facet>
					<div align="center">
						<h:outputLink value="#" id="link" onclick="viewUrGateway('#{gateway.id.urNo}','#{gateway.id.subUrNo}')">
							<h:outputText value="#{gateway.id.subUrNo}" styleClass="contentform" />
						</h:outputLink>	
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW01.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW01.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW01.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW01.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW01.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW01.filterColumn2)								
							}"
				width="30%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
		<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW01.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="GatewayTable" />
		 </h:inputText>
	 </h:panelGroup> 
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW01.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW01.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW01.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="GatewayTable" />
		 </h:inputText>
	 </h:panelGroup> 
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="impactSts" value="#{gateway.isImpact=='Y'}" disabled="true"/>
						</div>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW01.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(gateway.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCGW01.filterColumn4)}"  width="20%" style="vertical-align:top;">
						<f:facet name="header">
							  <h:panelGroup>
<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW01.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="GatewayTable" />
		 </h:inputText>
	 </h:panelGroup> 
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText id="subUrSts" value="#{gateway.subUrStatus.subUrStatusName}" />
							</h:panelGrid>
						</div>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="GatewayTable"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollIGDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			<!-- Manager Approve -->
			<rich:dataTable width="100%" id="tableMgrApproveIG" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIGDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ManagerApprove'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW02.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW02.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW02.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{gateway.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW02.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW02.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW02.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW02.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW02.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW02.filterColumn2)								
							}"
				width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW02.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW02.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW02.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW02.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApproveIG"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollIGDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Owner Approve -->
			<rich:dataTable width="100%" id="tableOwnerApproveIG" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIGDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='OwnerApprove'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW03.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW03.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW03.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{gateway.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW03.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW03.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW03.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW03.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW03.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW03.filterColumn2)								
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW03.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW03.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW03.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW03.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.gateway.approveAll}" disabled="#{empty networkConfigBean.listGateway}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveIG">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="IG"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{gateway.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveIG">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="IG"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.gateway.rejectAll}" disabled="#{empty networkConfigBean.listGateway}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveIG">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="IG"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{gateway.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveIG">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="IG"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW03.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(gateway.sysOwnerRemark,networkConfigBean.filterReqNWCGW03.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW03.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveIG" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{gateway.sysOwnerRemark}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.gateway.pageScroller}" immediate="true" rendered="true" align="right" 
								for="tableOwnerApproveIG" id="scrollIGDetailTable" 
								maxPages="#{ipfmConfigBean.maxPage}" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableOwnerApproveIG" >
									<f:param name="currentTab" value="IG"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- ACTM -->
			<rich:dataTable width="100%" id="tableACTMIG" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIGDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ACTM'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW04.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW04.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW04.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{gateway.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW04.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW04.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW04.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW04.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW04.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW04.filterColumn2)								
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW04.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW04.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW04.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW04.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(gateway.actmRemark,networkConfigBean.filterReqNWCGW04.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							  <h:panelGroup>
<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW04.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMIG" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea style="width:100%;" rows="7" value="#{gateway.actmRemark}"/>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableACTMIG"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollIGDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Team Process -->
				<rich:dataTable width="100%" id="tableTEAMIG" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIGDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='TEAM'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW05.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW05.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW05.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{gateway.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW05.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW05.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW05.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW05.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW05.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW05.filterColumn2)								
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW05.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW05.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW05.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
					
					
					<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.gateway.approveAll}" disabled="#{empty networkConfigBean.listGateway}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMIG">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="IG"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{gateway.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMIG">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="IG"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.gateway.rejectAll}" disabled="#{empty networkConfigBean.listGateway}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMIG">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="IG"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{gateway.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMIG">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="IG"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW05.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(gateway.teamRemark,networkConfigBean.filterReqNWCGW05.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							  <h:panelGroup>
<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW05.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMIG" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea  id="remarks" rows="4"  style="width:100%;"  value="#{gateway.teamRemark}"/>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						 <rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.gateway.pageScroller}" immediate="true" rendered="true" align="right" for="tableTEAMIG"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollIGDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableTEAMIG" >
									<f:param name="currentTab" value="IG"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- User Verify -->
			<rich:dataTable width="100%" id="tableUserVerifyIG" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIGDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='USER'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW06.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW06.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW06.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyIG" />
		 </h:inputText>
	 </h:panelGroup>
 
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{gateway.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW06.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW06.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW06.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW06.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW06.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW06.filterColumn2)								
							}" 
				width="30%" style="vertical-align:top;">
					<f:facet name="header">
											  <h:panelGroup>
	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW06.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW06.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW06.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW06.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW06.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(gateway.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCGW06.filterColumn4)}"  width="10%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							  <h:panelGroup>
<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW06.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyIG" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{gateway.subUrStatus.subUrStatusName}" />
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW06.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(gateway.pmRemark,networkConfigBean.filterReqNWCGW06.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							  <h:panelGroup>
<h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW06.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyIG" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{gateway.pmRemark}" readonly="true"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyIG"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollIGDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			
			<!-- PM Assign -->
			<rich:dataTable width="100%" id="tablePMIG" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIGDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='PM'}"
				value="#{networkConfigBean.listGateway}" var="gateway">
				
				<rich:column width="5%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.gateway.checkAll}" onclick="validateCheckbox('ALL',this,this,'isSelected','pageIG')" disabled="#{empty networkConfigBean.listGateway}"/>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isSelected" value="#{gateway.isSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pageIG:tablePMIG:selectAll'),this,'isSelected','pageIG')"/>
						</h:panelGrid>
					</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW07.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.id.subUrNo,networkConfigBean.filterReqNWCGW07.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW07.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{gateway.id.urNo}','#{gateway.id.subUrNo}')" rendered="#{gateway.subUrStatusTxt != 'WAIT_PM'}">
						        	<h:outputText value="#{gateway.id.subUrNo}" />
						    </h:outputLink>
						   <h:outputText value="#{gateway.id.subUrNo}" rendered="#{(gateway.subUrStatusTxt eq 'WAIT_PM')}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCGW07.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCGW07.filterColumn2) 
							or fn:containsIgnoreCase(gateway.mask,networkConfigBean.filterReqNWCGW07.filterColumn2)
							or fn:containsIgnoreCase(gateway.networkTypeDesc,networkConfigBean.filterReqNWCGW07.filterColumn2)	
							or fn:containsIgnoreCase(gateway.locationName,networkConfigBean.filterReqNWCGW07.filterColumn2)			
							or fn:containsIgnoreCase(gateway.reqVlanId,networkConfigBean.filterReqNWCGW07.filterColumn2)								
							}" 
				width="30%" style="vertical-align:top;">
					<f:facet name="header">				
							  <h:panelGroup>
				<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW07.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{gateway.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{gateway.mask}" />
							</h:panelGroup>
							<h:outputText value="Network Type:" />
							<h:outputText value="#{gateway.networkTypeDesc}" />
							<h:outputText value="Location:" />
							<h:outputText value="#{gateway.locationName}" />
							<h:outputText value="VLAN ID:" />
							<h:outputText value="#{gateway.reqVlanId}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW07.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCGW07.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
				<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW07.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMIG" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{gateway.reqDesc}"/>
					</div>	
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;text-align:center;">
					<f:facet name="header">
						<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.gateway.impactAll}" onclick="validateCheckbox('ALL',this,this,'isImpact','pageIG')" disabled="#{empty networkConfigBean.listGateway}"/>
							<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isImpact" value="#{gateway.impactSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pageIG:tablePMIG:impactAll'),this,'isImpact','pageIG')">
								<% /*<a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
									reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
									<a4j:actionparam name="urNo" value="#{gateway.id.urNo}"/>
	 								<a4j:actionparam name="subUrNo" value="#{gateway.id.subUrNo}"/>
	 								<a4j:actionparam name="currentTab" value="IG" />
 								</a4j:support> */ %>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCGW07.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(gateway.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCGW07.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							  <h:panelGroup>
			<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCGW07.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMIG" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{firewall.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
						</h:panelGrid>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMIG"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollIGDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
		</td>
		<td>&nbsp;</td></tr>
		<h:inputHidden id="currentTab" value="IG"/>
		<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
			<tr>
				<td align="right">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button"
							onclick="assignJob('IG')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button" rendered="#{not empty networkConfigBean.listGateway}"
							onclick="rejectJob('IG')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button"
							onclick="delegateJob('IG')">
						</a4j:commandButton>&nbsp;	
					</h:panelGroup>
				</td>
			</tr>
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
		</h:panelGroup>	
		</table>
	</rich:simpleTogglePanel>


</h:panelGrid>
<jsp:directive.include file="../IPSUR_ALL_JS.jsp"/>
