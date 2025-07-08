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

<h:panelGrid id="viewPanelCdn" columns="1" width="100%">

<rich:simpleTogglePanel switchType="client" id="PolicyAccessListRequestView" label="Policy Access List For CDN"  width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<rich:dataTable width="100%" id="AccessListTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollCDNDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='VIEW'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL01.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL01.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL01.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputLink value="#" id="link" onclick="viewUrAccessCDN('#{cdn.id.urNo}','#{cdn.id.subUrNo}')">
							<h:outputText value="#{cdn.id.subUrNo}" />
						</h:outputLink>
					</div>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL01.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL01.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL01.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL01.filterColumn2)							
							}"
				width="25%">
					<f:facet name="header">						
							  <h:panelGroup>
		<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL01.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL01.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL01.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL01.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL01.filterColumn3)							
							}"
				width="25%">
					<f:facet name="header">					
								  <h:panelGroup>
		<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL01.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="impactSts" value="#{cdn.isImpact=='Y'}" disabled="true"/>
						</div>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL01.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(cdn.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCAL01.filterColumn4)}"  width="20%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText id="subUrSts" value="#{cdn.subUrStatus.subUrStatusName}" />
							</h:panelGrid>
						</div>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="AccessListTable"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollCDNDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			<!-- Manager Approve -->
			<rich:dataTable width="100%" id="tableMgrApproveAL" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollCDNDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ManagerApprove'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL02.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL02.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header"> 
	  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL02.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
					
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL02.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL02.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL02.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL02.filterColumn2)							
							}" 
				
				width="45%">
					<f:facet name="header">						
						  <h:panelGroup>
		<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL02.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL02.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL02.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL02.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL02.filterColumn3)							
							}"
				width="45%">
					<f:facet name="header">						
						  <h:panelGroup>
	<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL02.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApproveAL"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollCDNDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- owner Approve -->
			<rich:dataTable width="100%" id="tableOwnerApproveAL" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollCDNDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='OwnerApprove'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL03.filterColumn1}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL03.filterColumn1)}"  
				width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL03.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
					
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL03.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL03.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL03.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL03.filterColumn2)							
							}"   
				width="30%">
					<f:facet name="header">						
							  <h:panelGroup>
		<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL03.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL03.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL03.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL03.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL03.filterColumn3)							
							}"
				width="30%">
					<f:facet name="header">						
						  <h:panelGroup>
<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL03.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.accessList.approveAll}" disabled="#{empty networkConfigBean.listAccessList}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveAL">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="AL"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{cdn.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveAL">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="AL"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.accessList.rejectAll}" disabled="#{empty networkConfigBean.listAccessList}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveAL">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="AL"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject"  value="#{cdn.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveAL">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="AL"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL03.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(cdn.sysOwnerRemark,networkConfigBean.filterReqNWCAL03.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
										  <h:panelGroup>
	<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL03.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveAL" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{cdn.sysOwnerRemark}"></h:inputTextarea>
					</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller page="#{networkConfigBean.accessList.pageScroller}" immediate="true" rendered="true" align="right" 
								for="tableMgrApproveAL" id="scrollCDNDetailTable" 
								maxPages="#{ipfmConfigBean.maxPage}" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableOwnerApproveAL" >
									<f:param name="currentTab" value="AL"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- ACTM -->
			<rich:dataTable width="100%" id="tableACTMAL" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollCDNDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ACTM'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL04.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL04.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					 
	  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL04.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
					
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL04.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL04.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL04.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL04.filterColumn2)							
							}"   
				width="30%">
					<f:facet name="header">				
						  <h:panelGroup>
		 			<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL04.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL04.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL04.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL04.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL04.filterColumn3)							
							}"
				width="30%">
					<f:facet name="header">				
								  <h:panelGroup>
		<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL04.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL04.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(cdn.actmRemark,networkConfigBean.filterReqNWCAL04.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
												  <h:panelGroup>
			<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL04.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMAL" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{cdn.actmRemark}"></h:inputTextarea>
				</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableACTMAL"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollCDNDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Team Process -->
			<rich:dataTable width="100%" id="tableTEAMAL" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollCDNTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='TEAM'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL05.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL05.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL05.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
					
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL05.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL05.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL05.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL05.filterColumn2)							
							}" 
				width="30%">
					<f:facet name="header">						
								  <h:panelGroup>
		 <h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL05.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL05.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL05.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL05.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL05.filterColumn3)							
							}"
				width="30%">
					<f:facet name="header">						
									  <h:panelGroup>
		<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL05.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.accessList.approveAll}" disabled="#{empty networkConfigBean.listAccessList}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMAL">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="AL"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove"  value="#{cdn.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMAL">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="AL"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.accessList.rejectAll}" disabled="#{empty networkConfigBean.listAccessList}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMAL">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="AL"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{cdn.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMAL">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="AL"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL05.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(cdn.teamRemark,networkConfigBean.filterReqNWCAL05.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							  <h:panelGroup>
			<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL05.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMAL" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{cdn.teamRemark}"></h:inputTextarea>
					</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller page="#{networkConfigBean.accessList.pageScroller}" immediate="true" rendered="true" align="right" for="tableTEAMAL"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollCDNTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableTEAMAL" >
									<f:param name="currentTab" value="AL"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- User Verify -->
			<rich:dataTable width="100%" id="tableUserVerifyAL" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollCDNUserTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='USER'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL06.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL06.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL06.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
					
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL06.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL06.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL06.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL06.filterColumn2)							
							}" 
				width="30%">
					<f:facet name="header">						
						  <h:panelGroup>
	<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL06.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL06.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL06.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL06.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL06.filterColumn3)							
							}"
				width="30%">
					<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL06.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL06.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(cdn.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCAL06.filterColumn4)}"  width="10%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
									  <h:panelGroup>
		<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL06.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyAL" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.subUrStatus.subUrStatusName}" />
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL06.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(cdn.pmRemark,networkConfigBean.filterReqNWCAL06.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header"> 
							 <h:panelGroup>
<h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL06.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyAL" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{cdn.pmRemark}" readonly="true"></h:inputTextarea>
					</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyAL"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollCDNUserTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- PM Assign -->
			<rich:dataTable width="100%" id="tablePMAL" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPMCDNTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='PM'}"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				
				<rich:column width="5%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.accessList.checkAll}" onclick="validateCheckbox('ALL',this,this,'isSelected','pageAL')" disabled="#{empty networkConfigBean.listAccessList}"/>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isSelected" value="#{cdn.isSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pageAL:tablePMAL:selectAll'),this,'isSelected','pageAL')"/>
						</h:panelGrid>
					</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL07.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.id.subUrNo,networkConfigBean.filterReqNWCAL07.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL07.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{cdn.id.urNo}','#{cdn.id.subUrNo}')" rendered="#{cdn.subUrStatusTxt != 'WAIT_PM'}">
						        	<h:outputText value="#{cdn.id.subUrNo}" />
						    </h:outputLink>
						   <h:outputText value="#{cdn.id.subUrNo}" rendered="#{cdn.subUrStatusTxt eq 'WAIT_PM'}" />
						</h:panelGrid>
					</div>
				</rich:column>
					
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL07.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCAL07.filterColumn2) 
							or fn:containsIgnoreCase(cdn.sourceHostName,networkConfigBean.filterReqNWCAL07.filterColumn2)
							or fn:containsIgnoreCase(cdn.sourceEmail,networkConfigBean.filterReqNWCAL07.filterColumn2)							
							}"
				
				width="30%">
					<f:facet name="header">
										 <h:panelGroup>
		 		<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL07.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCAL07.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCAL07.filterColumn3) 
							or fn:containsIgnoreCase(cdn.destHostName,networkConfigBean.filterReqNWCAL07.filterColumn3)
							or fn:containsIgnoreCase(cdn.destEmail,networkConfigBean.filterReqNWCAL07.filterColumn3)							
							}"
				width="30%">
					<f:facet name="header">						
						 <h:panelGroup>
		 	<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL07.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMAL" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="Email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.accessList.impactAll}" onclick="validateCheckbox('ALL',this,this,'isImpact','pageAL')" disabled="#{empty networkConfigBean.listAccessList}"/>
							<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isImpact" value="#{cdn.impactSelected}"  onclick="validateCheckbox('N',document.getElementById('DetailForm:pageAL:tablePMAL:impactAll'),this,'isImpact','pageAL')">
								<a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
									reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
									<a4j:actionparam name="urNo" value="#{cdn.id.urNo}"/>
	 								<a4j:actionparam name="subUrNo" value="#{cdn.id.subUrNo}"/>
	 								<a4j:actionparam name="currentTab" value="AL" />
 								</a4j:support>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCAL07.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(cdn.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCAL07.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
								 <h:panelGroup>
			<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCAL07.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMAL" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{cdn.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
						</h:panelGrid>
					</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="2">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMAL"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollPMCDNTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</td>
		<td>&nbsp;</td></tr>
		<h:inputHidden id="currentTab" value="AL"/>
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
			<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
			<tr>
				<td align="right">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button"
							onclick="assignJob('AL')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button" rendered="#{not empty networkConfigBean.listAccessList}"
							onclick="rejectJob('AL')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button"
							onclick="delegateJob('AL')">
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