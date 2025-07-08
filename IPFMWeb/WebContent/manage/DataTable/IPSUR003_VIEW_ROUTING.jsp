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

<h:panelGrid id="viewPanelRT" columns="1" width="100%">

<rich:simpleTogglePanel switchType="client" id="RTRequestView" label="Policy Routing"  width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<rich:dataTable width="100%" id="RoutingTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='VIEW'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO01.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO01.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO01.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputLink value="#" id="link" onclick="viewUrRouting('#{routing.id.urNo}','#{routing.id.subUrNo}')">
							<h:outputText value="#{routing.id.subUrNo}" />
						</h:outputLink>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO01.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO01.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO01.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO01.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO01.filterColumn2)										
							}" 
				width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO01.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO01.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO01.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">				
							  <h:panelGroup>
			<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO01.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>
				
				<rich:column width="7%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="impactSts" value="#{routing.isImpact=='Y'}" disabled="true"/>
						</div>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO01.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(routing.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCRO01.filterColumn4)}"  width="20%" style="vertical-align:top;">
						<f:facet name="header">						
							  <h:panelGroup>
				<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO01.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText id="subUrSts" value="#{routing.subUrStatus.subUrStatusName}" />
							</h:panelGrid>
						</div>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="RoutingTable"
								maxPages="5" id="scrollRTDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			<!-- Manager Approve -->
			<rich:dataTable width="100%" id="tableMgrApproveTR" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ManagerApprove'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO02.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO02.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO02.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO02.filterColumn2}"   
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO02.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO02.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO02.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO02.filterColumn2)										
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
			<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO02.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO02.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO02.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
			<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO02.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApproveTR"
								maxPages="5" id="scrollRTDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Owner Approve -->
			<rich:dataTable width="100%" id="tableOwnerApproveTR" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='OwnerApprove'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO03.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO03.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO03.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO03.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO03.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO03.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO03.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO03.filterColumn2)										
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						 <h:panelGroup>
			<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO03.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO03.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO03.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">				
						 <h:panelGroup>
			<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO03.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.routing.approveAll}" disabled="#{empty networkConfigBean.listRouting}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveTR">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="RT"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{routing.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveTR">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="RT"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.routing.rejectAll}" disabled="#{empty networkConfigBean.listRouting}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveTR">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="RT"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{routing.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveTR">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="RT"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO03.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(routing.sysOwnerRemark,networkConfigBean.filterReqNWCRO03.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							 <h:panelGroup>
		<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO03.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveTR" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{routing.sysOwnerRemark}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.phyInterface.pageScroller}" immediate="true" rendered="true" align="right" 
								for="tableOwnerApproveTR" id="scrollRTDetailTable" 
								maxPages="#{ipfmConfigBean.maxPage}" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableOwnerApproveTR" >
									<f:param name="currentTab" value="RT"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- ACTM -->
			<rich:dataTable width="100%" id="tableACTMTR" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ACTM'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO04.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO04.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO04.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO04.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO04.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO04.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO04.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO04.filterColumn2)										
							}"   
				width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
			<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO04.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO04.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO04.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO04.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>

					<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO04.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(routing.actmRemark,networkConfigBean.filterReqNWCRO04.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO04.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMTR" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea style="width:100%;" rows="7" value="#{routing.actmRemark}"/>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApproveTR"
								maxPages="5" id="scrollFirewallTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Team Process -->
			<rich:dataTable width="100%" id="tableTEAMTR" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='TEAM'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO05.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO05.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO05.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO05.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO05.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO05.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO05.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO05.filterColumn2)										
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">
				
						 <h:panelGroup>
			<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO05.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO05.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO05.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO05.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.routing.approveAll}" disabled="#{empty networkConfigBean.listRouting}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMTR">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="RT"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{routing.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMTR">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="RT"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.routing.rejectAll}" disabled="#{empty networkConfigBean.listRouting}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMTR">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="RT"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{routing.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMTR">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="RT"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO05.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(routing.teamRemark,networkConfigBean.filterReqNWCRO05.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">					
							 <h:panelGroup>
		<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO05.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMTR" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{routing.teamRemark}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.phyInterface.pageScroller}" immediate="true" rendered="true" align="right" 
								for="tableTEAMTR"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollRTDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableTEAMTR" >
									<f:param name="currentTab" value="RT"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- User Verify -->
			<rich:dataTable width="100%" id="tableUserVerifyTR" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='USER'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO06.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO06.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">
						
						  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO06.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyTR" />
		 </h:inputText>
	 </h:panelGroup>
 
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO06.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO06.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO06.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO06.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO06.filterColumn2)										
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">
					
						  <h:panelGroup>
		 	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO06.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO06.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO06.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">
						
						 <h:panelGroup>
		 <h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO06.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyTR" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO06.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(routing.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCRO06.filterColumn4)}"  width="10%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							 <h:panelGroup>
			<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO06.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyTR" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.subUrStatus.subUrStatusName}" />
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO06.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(routing.pmRemark,networkConfigBean.filterReqNWCRO06.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							 <h:panelGroup>
		<h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO06.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyTR" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{routing.pmRemark}" readonly="true"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyTR"
								maxPages="5" id="scrollFirewallTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			
			<!-- PM Assign -->
			<rich:dataTable width="100%" id="tablePMRT" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollRTDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='PM'}"
				value="#{networkConfigBean.listRouting}" var="routing">
				
				<rich:column width="5%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.routing.checkAll}"  onclick="validateCheckbox('ALL',this,this,'isSelected','pageRT')" disabled="#{empty networkConfigBean.listRouting}"/>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isSelected" value="#{routing.isSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pageRT:tablePMRT:selectAll'),this,'isSelected','pageRT')"/>
						</h:panelGrid>
					</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO07.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.id.subUrNo,networkConfigBean.filterReqNWCRO07.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">
					
						 <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO07.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMRT" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{routing.id.urNo}','#{routing.id.subUrNo}')" rendered="#{routing.subUrStatusTxt != 'WAIT_PM'}">
						        	<h:outputText value="#{routing.id.subUrNo}" />
						    </h:outputLink>
						   <h:outputText value="#{routing.id.subUrNo}" rendered="#{routing.subUrStatusTxt eq 'WAIT_PM'}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCRO07.filterColumn2}"   
				filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCRO07.filterColumn2) 
							or fn:containsIgnoreCase(routing.mask,networkConfigBean.filterReqNWCRO07.filterColumn2)
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO07.filterColumn2)	
							or fn:containsIgnoreCase(routing.interface,networkConfigBean.filterReqNWCRO07.filterColumn2)										
							}"   
				width="30%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO07.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMRT" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="2">
							<h:outputText value="IP Address/Mask:" />
							<h:panelGroup>
								<h:outputText value="#{routing.ipAddress}" />
								&nbsp;/&nbsp;
								<h:outputText value="#{routing.mask}" />
							</h:panelGroup>
							<h:outputText value="Interface:" />
							<h:outputText value="#{routing.interface}" />
							<h:outputText value="Next Hop:" />
							<h:outputText value="#{routing.nextHop}" />
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO07.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCRO07.filterColumn3)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						 <h:panelGroup>
	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO07.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMRT" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{routing.reqDesc}"/>
					</div>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;text-align:center;">
					<f:facet name="header">
						<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.routing.impactAll}"  onclick="validateCheckbox('ALL',this,this,'isImpact','pageRT')" disabled="#{empty networkConfigBean.listRouting}"/>
							<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isImpact" value="#{routing.impactSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pageRT:tablePMRT:impactAll'),this,'isImpact','pageRT')">
								<%/* <a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
									reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
									<a4j:actionparam name="urNo" value="#{routing.id.urNo}"/>
	 								<a4j:actionparam name="subUrNo" value="#{routing.id.subUrNo}"/>
	 								<a4j:actionparam name="currentTab" value="RT" />
 								</a4j:support> */ %>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCRO07.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(routing.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCRO07.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							 <h:panelGroup>
	<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCRO07.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMRT" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{routing.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
						</h:panelGrid>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMRT"
								maxPages="5" id="scrollFirewallTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</td>
		<td>&nbsp;</td></tr>
		<h:inputHidden id="currentTab" value="RT"/>
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
			<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
			<tr>
				<td align="right">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button"
							onclick="assignJob('RT')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button" rendered="#{not empty networkConfigBean.listRouting}"
							onclick="rejectJob('RT')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button"
							onclick="delegateJob('RT')">
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