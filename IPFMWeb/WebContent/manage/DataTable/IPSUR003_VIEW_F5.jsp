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

<h:panelGrid id="viewPanelF5" columns="1" width="100%">

<rich:simpleTogglePanel switchType="client" id="F5RequestView" label="Policy F5"  width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
				<rich:dataTable width="100%" id="f5Table" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='VIEW'}"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF501.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF501.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF501.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="f5Table" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputLink value="#" id="link" onclick="viewUrF5('#{f5.id.urNo}','#{f5.id.subUrNo}')">
						        <h:outputText value="#{f5.id.subUrNo}" />
						    </h:outputLink>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF501.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF501.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF501.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF501.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF501.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF501.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF501.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF501.filterColumn2)						
							}" 
				width="25%" style="vertical-align:top;">
					<f:facet name="header">						
										  <h:panelGroup>
		<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF501.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="f5Table" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText><h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="IP Port:" styleClass="label"></h:outputText><h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						   <h:outputText value="Yes,#{f5.snapIp}" rendered="#{f5.isSnapIp=='Y'}" />
						   <h:outputText value="No" rendered="#{f5.isSnapIp=='N'}" />
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="RoundRobin" rendered="#{f5.method=='RR'}" />
						<h:outputText value="Ratio" rendered="#{f5.method=='RT'}" />
					</div>	
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF501.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF501.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF501.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF501.filterColumn3)						
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
									  <h:panelGroup>
	<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF501.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="f5Table" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="impactSts" value="#{f5.isImpact=='Y'}" disabled="true"/>
						</div>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCF501.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(f5.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCF501.filterColumn4)}"  width="20%" style="vertical-align:top;">
						<f:facet name="header">						
							  <h:panelGroup>
		<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF501.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="f5Table" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText id="subUrSts" value="#{f5.subUrStatus.subUrStatusName}" />
							</h:panelGrid>
						</div>
					</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="8">
							<rich:datascroller immediate="true" rendered="true" align="right" for="f5Table"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollF5DetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		<!-- Manager Approve -->
		<rich:dataTable width="100%" id="tableMgrApproveF5" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ManagerApprove'}"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF502.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF502.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF502.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF502.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF502.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF502.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF502.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF502.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF502.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF502.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF502.filterColumn2)						
							}" 
				
				 width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF502.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="VIP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="30%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="Ratio" rendered="#{f5.method=='RT'}"/>
							<h:outputText value="Round Robin" rendered="#{f5.method=='RR'}"/>
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF502.filterColumn3}" 
				filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF502.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF502.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF502.filterColumn3)						
							}" 
				 width="30%" style="vertical-align:top;">
					<f:facet name="header">						
			  <h:panelGroup>
	<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF502.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableMgrApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApproveF5"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollF5DetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Owner Approve -->
		<rich:dataTable width="100%" id="tableOwnerApproveF5" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='OwnerApprove'}"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF503.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF503.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF503.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF503.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF503.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF503.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF503.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF503.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF503.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF503.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF503.filterColumn2)						
							}" 
				width="24%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 		<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF503.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="IP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="Ratio" rendered="#{f5.method=='RT'}"/>
							<h:outputText value="Round Robin" rendered="#{f5.method=='RR'}"/>
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  
						filterValue="#{networkConfigBean.filterReqNWCF503.filterColumn3}"  
						filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF503.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF503.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF503.filterColumn3)						
							}" 
						width="20%" style="vertical-align:top;">
					<f:facet name="header">				
								  <h:panelGroup>
		 				<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF503.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.f5.approveAll}" disabled="#{empty networkConfigBean.listF5}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveF5">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="F5"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{f5.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveF5">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="F5"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.f5.rejectAll}" disabled="#{empty networkConfigBean.listF5}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApproveF5">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="F5"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject"  value="#{f5.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
								<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApproveF5">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="F5"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCF503.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(f5.sysOwnerRemark,networkConfigBean.filterReqNWCF503.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">				
							  <h:panelGroup>
		 						<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF503.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApproveF5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{f5.sysOwnerRemark}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.f5.pageScroller}" immediate="true" rendered="true" align="right" 
								for="tableMgrApproveF5" id="scrollF5DetailTable" 
								maxPages="#{ipfmConfigBean.maxPage}" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableMgrApproveF5" >
									<f:param name="currentTab" value="F5"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- ACTM -->
		<rich:dataTable width="100%" id="tableACTMF5" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ACTM'}"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF504.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF504.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header"> 
					<h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF504.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF504.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF504.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF504.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF504.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF504.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF504.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF504.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF504.filterColumn2)						
							}" 
				
				width="25%" style="vertical-align:top;">
					<f:facet name="header">
				
						<h:panelGroup>
				<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF504.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="VIP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="Ratio" rendered="#{f5.method=='RT'}"/>
							<h:outputText value="Round Robin" rendered="#{f5.method=='RR'}"/>
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF504.filterColumn3}"   
				filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF504.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF504.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF504.filterColumn3)						
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header"> 
<h:panelGroup>
			<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF504.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCF504.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(f5.actmRemark,networkConfigBean.filterReqNWCF504.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
						
							<h:panelGroup>
				<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF504.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMF5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{f5.actmRemark}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableACTMF5"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollF5DetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
		<!-- Team Process -->
		<rich:dataTable width="100%" id="tableTEAMF5" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='TEAM'}"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF505.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF505.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
		 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF505.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF505.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF505.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF505.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF505.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF505.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF505.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF505.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF505.filterColumn2)						
							}" 
				width="23%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
	<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF505.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="VIP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="Ratio" rendered="#{f5.method=='RT'}"/>
							<h:outputText value="Round Robin" rendered="#{f5.method=='RR'}"/>
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF505.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF505.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF505.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF505.filterColumn3)						
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
	<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF505.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.f5.approveAll}" disabled="#{empty networkConfigBean.listF5}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMF5">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="F5"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{f5.isApprove}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMF5">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="F5"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.f5.rejectAll}" disabled="#{empty networkConfigBean.listF5}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMF5">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="F5"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{f5.isReject}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMF5">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="F5"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCF505.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(f5.teamRemark,networkConfigBean.filterReqNWCF505.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
	  <h:panelGroup>
		<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF505.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMF5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{f5.teamRemark}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.f5.pageScroller}" immediate="true" rendered="true" align="right" for="tableTEAMF5"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollF5DetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableTEAMF5" >
									<f:param name="currentTab" value="F5"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- User Verify -->
		<rich:dataTable width="100%" id="tableUserVerifyF5" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='USER'}"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF506.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF506.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
		 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF506.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.id.subUrNo}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF506.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF506.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF506.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF506.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF506.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF506.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF506.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF506.filterColumn2)						
							}" 
				width="23%" style="vertical-align:top;">
					<f:facet name="header">
						
						  <h:panelGroup>
	<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF506.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="VIP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="Ratio" rendered="#{f5.method=='RT'}"/>
							<h:outputText value="Round Robin" rendered="#{f5.method=='RR'}"/>
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF506.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF506.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF506.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF506.filterColumn3)						
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">				
						  <h:panelGroup>
		<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF506.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF506.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(f5.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCF506.filterColumn4)}"  width="15%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">				
							  <h:panelGroup>
					<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF506.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyF5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.subUrStatus.subUrStatusName}" />
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCF506.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(f5.pmRemark,networkConfigBean.filterReqNWCF506.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							  <h:panelGroup>
					<h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF506.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyF5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{f5.pmRemark}" readonly="true"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyF5"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollF5DetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- PM Assign -->
		<rich:dataTable width="100%" id="tablePMF5" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollF5DetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='PM'}"
				value="#{networkConfigBean.listF5}" var="f5">
				
				<rich:column width="5%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.f5.checkAll}" onclick="validateCheckbox('ALL',this,this,'isSelected','pageF5')" disabled="#{empty networkConfigBean.listF5}"/>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isSelected" value="#{f5.isSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pageF5:tablePMF5:selectAll'),this,'isSelected','pageF5')"/>
						</h:panelGrid>
					</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCF507.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.id.subUrNo,networkConfigBean.filterReqNWCF507.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">				
							  <h:panelGroup>
		 		<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF507.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
					    	<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{f5.id.urNo}','#{f5.id.subUrNo}')" rendered="#{f5.subUrStatusTxt != 'WAIT_PM'}">
					        	<h:outputText value="#{f5.id.subUrNo}" />
					        </h:outputLink>
					        <h:outputText value="#{f5.id.subUrNo}" rendered="#{f5.subUrStatusTxt eq 'WAIT_PM'}" />
						</h:panelGrid>
					</div>
				</rich:column>
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF507.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCF507.filterColumn2) 
							or fn:containsIgnoreCase(f5.vipPort,networkConfigBean.filterReqNWCF507.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'Y','Yes'),networkConfigBean.filterReqNWCF507.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isSnapIp,'N','No'),networkConfigBean.filterReqNWCF507.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'Y','Yes'),networkConfigBean.filterReqNWCF507.filterColumn2)
							or fn:containsIgnoreCase(fn:replace(f5.isPersistence,'N','No'),networkConfigBean.filterReqNWCF507.filterColumn2)		
							or fn:containsIgnoreCase(f5.snapIp,networkConfigBean.filterReqNWCF507.filterColumn2)						
							}" 
				width="23%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		 		<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF507.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="VIP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="Ratio" rendered="#{f5.method=='RT'}"/>
							<h:outputText value="Round Robin" rendered="#{f5.method=='RR'}"/>
						</h:panelGrid>
					</div>	
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCF507.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCF507.filterColumn3) 
							or fn:containsIgnoreCase(f5.poolIpPort,networkConfigBean.filterReqNWCF507.filterColumn3)	
							or fn:containsIgnoreCase(f5.poolWeight,networkConfigBean.filterReqNWCF507.filterColumn3)						
							}"  
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
		 <h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF507.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMF5" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;text-align:center;">
					<f:facet name="header">
						<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.f5.impactAll}" onclick="validateCheckbox('ALL',this,this,'isImpact','pageF5')" disabled="#{empty networkConfigBean.listF5}"/>
							<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isImpact" value="#{f5.impactSelected}"  onclick="validateCheckbox('N',document.getElementById('DetailForm:pageF5:tablePMF5:impactAll'),this,'isImpact','pageF5')">
								<%/*<a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
									reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
									<a4j:actionparam name="urNo" value="#{f5.id.urNo}"/>
	 								<a4j:actionparam name="subUrNo" value="#{f5.id.subUrNo}"/>
	 								<a4j:actionparam name="currentTab" value="F5" />
 								</a4j:support>*/ %>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCF507.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(f5.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCF507.filterColumn4)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							  <h:panelGroup>
		<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCF507.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMF5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{f5.subUrStatus.subUrStatusName}" styleClass="label"></h:outputText>
						</h:panelGrid>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMF5"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollF5DetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</td>
		<td>&nbsp;</td></tr>
		<h:inputHidden id="currentTab" value="F5"/>
		<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
			<tr>
				<td align="right">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button"
							onclick="assignJob('F5')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button" rendered="#{not empty networkConfigBean.listF5}"
							onclick="rejectJob('F5')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button"
							onclick="delegateJob('F5')">
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