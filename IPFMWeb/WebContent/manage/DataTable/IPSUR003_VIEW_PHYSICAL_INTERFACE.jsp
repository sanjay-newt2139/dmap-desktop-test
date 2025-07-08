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

<h:panelGrid id="viewPanelPI" columns="1" width="100%">

<rich:simpleTogglePanel switchType="client" id="PIRequestView" label="Policy Physical Interface"  width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<rich:dataTable width="100%" id="PhysicalTable1" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='VIEW'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI01.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI01.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
							 	<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI01.filterColumn1}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="PhysicalTable1" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
							<h:outputLink value="#" id="link" onclick="viewUrPhyInterface('#{physical.id.urNo}','#{physical.id.subUrNo}')">
						        <h:outputText value="#{physical.id.subUrNo}"/>
						    </h:outputLink>
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI01.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI01.filterColumn6)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">					
							  <h:panelGroup>
							 	<h:outputText value="Trunk No" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI01.filterColumn6}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="PhysicalTable1" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
							<h:outputText value="#{physical.trunkNo}"/>
					</div>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI01.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI01.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI01.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI01.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI01.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI01.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI01.filterColumn2)							
							}"
				width="30%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI01.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable1" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI01.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI01.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI01.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI01.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI01.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI01.filterColumn3)							
							}"
				width="30%" style="vertical-align:top;">
					<f:facet name="header">					
						 <h:panelGroup>
	<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI01.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable1" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:outputText value="Team Assign Detail" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="2" >
							<h:outputText value="Network Rack Name : "/>
							<h:inputText id="nwReckName" value="#{physical.networkRackName}" disabled="true" style="width:150px"></h:inputText>
							<h:outputText value="Network Device : "/>
							<h:inputText id="nwDevice" value="#{physical.networkDevice}" disabled="true" style="width:150px"></h:inputText>
							<h:outputText value="Network Port : "/>
							<h:inputText id="nwPort" value="#{physical.networkPort}" disabled="true" maxlength="10" style="width:150px"></h:inputText>
							<h:outputText value="Network Location : "/>
								<rich:comboBox id="networkZoneName"  disabled="true"
									defaultLabel="" enableManualInput="true" 
									itemClass="contentform" itemSelectedClass="contentform"
									value="#{physical.networkLocationDesc}" width="160">
									<f:attribute name="selectItems" value="#{networkConfigBean.nwLocationList}"/>
									<f:selectItems value="#{networkConfigBean.nwLocationList}"/>
								</rich:comboBox>
							<h:outputText value="Network Floor : "/>
							<h:inputText id="nwFloor" value="#{physical.networkFloor}" disabled="true" onkeypress="return numberformat.keyPressIntegerOnly(this, event);" maxlength="10"  style="width:150px"></h:inputText>
						</h:panelGrid>
				</rich:column>					
				
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI01.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI01.filterColumn4)}"  width="20%" style="vertical-align:top;">
					<f:facet name="header">					
						 <h:panelGroup>
		<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI01.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable1" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}" />
				</rich:column>
			
				
				<rich:column width="10%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Impact Status" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="impactSts" value="#{physical.isImpact=='Y'}" disabled="true"/>
						</div>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI01.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(physical.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCPI01.filterColumn5)}"  width="20%" style="vertical-align:top;">
						<f:facet name="header">						
								 <h:panelGroup>
		<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI01.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable1" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText id="subUrSts" value="#{physical.subUrStatus.subUrStatusName}" />
							</h:panelGrid>
						</div>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="PhysicalTable1"
								maxPages="5" id="scrollPIDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Manager Approve -->
			<rich:dataTable width="100%" id="tableMgrApprovePI" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ManagerApprove'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI02.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI02.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
							 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI02.filterColumn1}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tableMgrApprovePI" />
							 </h:inputText>
						 </h:panelGroup> 
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.id.subUrNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI02.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI02.filterColumn5)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
							 <h:outputText value="Trunk No" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI02.filterColumn5}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tableMgrApprovePI" />
							 </h:inputText>
						 </h:panelGroup> 
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.trunkNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI02.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI02.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI02.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI02.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI02.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI02.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI02.filterColumn2)							
							}" 
				width="30%" style="vertical-align:top;">
					<f:facet name="header">
						 <h:panelGroup>
		<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI02.filterColumn2}" style="width: 50px;" >
			 <a4j:support event="onblur" reRender="tableMgrApprovePI" />
		 </h:inputText>
	 </h:panelGroup> 
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI02.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI02.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI02.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI02.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI02.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI02.filterColumn3)							
							}"  
				width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							 <h:panelGroup>
		<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI02.filterColumn3}" style="width: 50px;" >
			 <a4j:support event="onblur" reRender="tableMgrApprovePI" />
		 </h:inputText>
	 </h:panelGroup> 
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI02.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI02.filterColumn4)}"  width="30%" style="vertical-align:top;">
					<f:facet name="header">						
							 <h:panelGroup>
		<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI02.filterColumn4}" style="width: 50px;" >
			 <a4j:support event="onblur" reRender="tableMgrApprovePI" />
		 </h:inputText>
	 </h:panelGroup> 
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}"/>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApprovePI"
								maxPages="5" id="scrollPIDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- Owner Approve -->
			<rich:dataTable width="100%" id="tableOwnerApprovePI" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='OwnerApprove'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI03.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI03.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
							 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI03.filterColumn1}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tableOwnerApprovePI" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.id.subUrNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI03.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI03.filterColumn6)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
							 <h:outputText value="Trunk No" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI03.filterColumn6}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tableOwnerApprovePI" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.trunkNo}" />
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI03.filterColumn2}"   
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI03.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI03.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI03.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI03.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI03.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI03.filterColumn2)							
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
						  <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>		 
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI03.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApprovePI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI03.filterColumn3}" 
				 filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI03.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI03.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI03.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI03.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI03.filterColumn3)							
							}"  
				  width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
					<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>	 
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI03.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApprovePI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI03.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI03.filterColumn4)}"  width="18%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
			<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI03.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableOwnerApprovePI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}"/>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.phyInterface.approveAll}" disabled="#{empty networkConfigBean.listPhysicalInterface}" >
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApprovePI">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="PI"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Approve" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove" value="#{physical.isApprove}" >
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApprovePI">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="PI"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.phyInterface.rejectAll}" disabled="#{empty networkConfigBean.listPhysicalInterface}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableOwnerApprovePI">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="PI"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{physical.isReject}" >
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableOwnerApprovePI">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="PI"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI03.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(physical.sysOwnerRemark,networkConfigBean.filterReqNWCPI03.filterColumn5)}"  width="25%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">					
							  <h:panelGroup>
					<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI03.filterColumn5}" style="width: 50px;" >
			 <a4j:support event="onblur" reRender="tableOwnerApprovePI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{physical.sysOwnerRemark}" ></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.phyInterface.pageScroller}" immediate="true" rendered="true" align="right" 
								for="tableOwnerApprovePI" id="scrollPIDetailTable" 
								maxPages="#{ipfmConfigBean.maxPage}" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableOwnerApprovePI" >
									<f:param name="currentTab" value="PI"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- ACTM -->
			<rich:dataTable width="100%" id="tableACTMPI" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='ACTM'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI04.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI04.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
							 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI04.filterColumn1}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tableACTMPI" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.id.subUrNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI04.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI04.filterColumn6)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
							 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI04.filterColumn6}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tableACTMPI" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.trunkNo}" />
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI04.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI04.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI04.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI04.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI04.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI04.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI04.filterColumn2)							
							}" 
				width="25%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI04.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI04.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI04.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI04.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI04.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI04.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI04.filterColumn3)							
							}"  
				width="25%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI04.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI04.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI04.filterColumn4)}"  width="20%" style="vertical-align:top;">
					<f:facet name="header">					
						  <h:panelGroup>
		<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI04.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableACTMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}"/>
				</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI04.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(physical.actmRemark,networkConfigBean.filterReqNWCPI04.filterColumn5)}"  width="20%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							<h:panelGroup>
		<h:outputText value="Impact Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI04.filterColumn5}" style="width: 50px;" >
			 <a4j:support event="onblur" reRender="tableACTMPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea style="width:100%;" rows="7" value="#{physical.actmRemark}" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}"/>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableMgrApprovePI"
								maxPages="5" id="scrollPIDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- TEAM Process -->
			<rich:dataTable width="100%" id="tableTEAMPI" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='TEAM'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI05.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
								 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
								 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn1}" style="width: 50px;">
									 <a4j:support event="onblur" reRender="tableTEAMPI" />
								 </h:inputText>
							 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.id.subUrNo}" />
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI05.filterColumn7)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
								 <h:outputText value="Trunk No" styleClass="contentform tableHeaderText"></h:outputText>
								 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn7}" style="width: 50px;">
									 <a4j:support event="onblur" reRender="tableTEAMPI" />
								 </h:inputText>
							 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.trunkNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI05.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI05.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI05.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI05.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI05.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI05.filterColumn2)							
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
<h:outputText value="IP Address/Mask" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI05.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI05.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI05.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI05.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI05.filterColumn3)	
							or fn:containsIgnoreCase(physical.piType,networkConfigBean.filterReqNWCPI05.filterColumn3)						
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
					 <h:outputText value="#{physical.piType} #{physical.rowIndex}"/>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI05.filterColumn4)}"  width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}"/>
				</rich:column>
				
				<rich:column width="8%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="ApproveAll" value="#{networkConfigBean.phyInterface.approveAll}" disabled="#{empty networkConfigBean.listPhysicalInterface}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMPI">
										<f:param name="type" value="APPROVEAll"></f:param>
										<f:param name="currentTab" value="PI"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Complete" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtApprove"  value="#{physical.isApprove}" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMPI">
								<f:param name="type" value="APPROVE"></f:param>
								<f:param name="currentTab" value="PI"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column width="7%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="RejectAll" value="#{networkConfigBean.phyInterface.rejectAll}" disabled="#{empty networkConfigBean.listPhysicalInterface}">
									<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectAll}" reRender="tableTEAMPI">
										<f:param name="type" value="REJECTAll"></f:param>
										<f:param name="currentTab" value="PI"></f:param>
									</a4j:support>
								</h:selectBooleanCheckbox>
								<h:outputText value="Reject" styleClass="contentform tableHeaderText"></h:outputText>
							</h:panelGrid>
						</f:facet>
						<h:selectOneRadio id="rtReject" value="#{physical.isReject}" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}">
							<f:selectItem itemValue="Y" itemLabel=""/>
							<a4j:support event="onclick" actionListener="#{reqNWConfigAction.selectRadio}" reRender="tableTEAMPI">
								<f:param name="type" value="REJECT"></f:param>
								<f:param name="currentTab" value="PI"></f:param>
								<f:param name="rowIndex" value="#{index}"></f:param>
							</a4j:support>
						</h:selectOneRadio>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn5}"  
					filterExpression="#{fn:containsIgnoreCase(physical.networkRackName,networkConfigBean.filterReqNWCPI05.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							 <h:panelGroup>
	<h:outputText value="Team Assign Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="2" >
							<h:outputText value="Network Rack Name : "/>
							<h:inputText id="nwReckName" value="#{physical.networkRackName}" style="width:150px" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}"></h:inputText>
							<h:outputText value="Network Device : "/>
							<h:inputText id="nwDevice" value="#{physical.networkDevice}" style="width:150px" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}"></h:inputText>
							<h:outputText value="Network Port : "/>
							<h:inputText id="nwPort" value="#{physical.networkPort}" maxlength="10" style="width:150px" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}"></h:inputText>
							<h:outputText value="Network Location : "/>
								<rich:comboBox id="networkZoneName"  
									defaultLabel="" enableManualInput="true" 
									itemClass="contentform" itemSelectedClass="contentform"
									value="#{physical.networkLocationDesc}" width="160" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}">
									<f:attribute name="selectItems" value="#{networkConfigBean.nwLocationList}"/>
									<f:selectItems value="#{networkConfigBean.nwLocationList}"/>
								</rich:comboBox>
							<h:outputText value="Network Floor : "/>
							<h:inputText id="nwFloor" value="#{physical.networkFloor}" onkeypress="return numberformat.keyPressIntegerOnly(this, event);" maxlength="10"  style="width:150px" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}"></h:inputText>
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI05.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(physical.teamRemark,networkConfigBean.filterReqNWCPI05.filterColumn6)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							 <h:panelGroup>
	<h:outputText value="Team Process Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI05.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableTEAMPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{physical.teamRemark}" disabled="#{(physical.piType eq 'T') and physical.trunkFlag eq 'N'}"></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller page="#{networkConfigBean.phyInterface.pageScroller}" immediate="true" rendered="true" align="right" for="tableTEAMPI"
								maxPages="#{ipfmConfigBean.maxPage}" id="scrollPIDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
								style="background-color: #cccccc;">
								<a4j:support event="onpagechange" actionListener="#{reqNWConfigAction.checkSelectAll}" reRender="tableTEAMPI" >
									<f:param name="currentTab" value="PI"></f:param>
								</a4j:support>
							</rich:datascroller>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			<!-- User Verify -->
			<rich:dataTable width="100%" id="tableUserVerifyPI" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='USER'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI06.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
						 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
						 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn1}" style="width: 50px;">
							 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
						 </h:inputText>
					 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.id.subUrNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn8}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI06.filterColumn8)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
						 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
						 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn8}" style="width: 50px;">
							 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
						 </h:inputText>
					 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.trunkNo}" />
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn2}"   
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI06.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI06.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI06.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI06.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI06.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI06.filterColumn2)							
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI06.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI06.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI06.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI06.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI06.filterColumn3)							
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI06.filterColumn4)}"  width="20%" style="vertical-align:top;">
					<f:facet name="header">						
							 <h:panelGroup>
<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}"/>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(physical.networkRackName,networkConfigBean.filterReqNWCPI06.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
							 <h:panelGroup>
	<h:outputText value="Team Assign Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="2" >
							<h:outputText value="Network Rack Name : "/>
							<h:inputText id="nwReckName" value="#{physical.networkRackName}" disabled="true" style="width:150px"></h:inputText>
							<h:outputText value="Network Device : "/>
							<h:inputText id="nwDevice" value="#{physical.networkDevice}" disabled="true" style="width:150px"></h:inputText>
							<h:outputText value="Network Port : "/>
							<h:inputText id="nwPort" value="#{physical.networkPort}" disabled="true" maxlength="10" style="width:150px"></h:inputText>
							<h:outputText value="Network Location : "/>
								<rich:comboBox id="networkZoneName"  disabled="true"
									defaultLabel="" enableManualInput="true" 
									itemClass="contentform" itemSelectedClass="contentform"
									value="#{physical.networkLocationDesc}" width="160">
									<f:attribute name="selectItems" value="#{networkConfigBean.nwLocationList}"/>
									<f:selectItems value="#{networkConfigBean.nwLocationList}"/>
								</rich:comboBox>
							<h:outputText value="Network Floor : "/>
							<h:inputText id="nwFloor" value="#{physical.networkFloor}" disabled="true" onkeypress="return numberformat.keyPressIntegerOnly(this, event);" maxlength="10"  style="width:150px"></h:inputText>
						</h:panelGrid>
				</rich:column>	
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(physical.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCPI06.filterColumn6)}"  width="10%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">						
										 <h:panelGroup>
		<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.subUrStatus.subUrStatusName}"  />
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI06.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(physical.pmRemark,networkConfigBean.filterReqNWCPI06.filterColumn7)}"  width="20%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">							
							 <h:panelGroup>
<h:outputText value="PM Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI06.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableUserVerifyPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:inputTextarea id="remarks" rows="4" style="width:100%" value="#{physical.pmRemark}" readonly="true" ></h:inputTextarea>
					</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tableUserVerifyPI"
								maxPages="5" id="scrollPIDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
			
			<!-- PM Assign -->
			<rich:dataTable width="100%" id="tablePMPI" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollPIDetailTable" 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				rendered="#{networkConfigBean.mode=='PM'}"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
				
				<rich:column width="5%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
							<h:panelGrid columns="2">
								<h:selectBooleanCheckbox id="selectAll" value="#{networkConfigBean.phyInterface.checkAll}" onclick="validateCheckbox('ALL',this,this,'isSelected','pagePI')" disabled="#{empty networkConfigBean.listPhysicalInterface}"/>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isSelected" value="#{physical.isSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pagePI:tablePMPI:selectAll'),this,'isSelected','pagePI')" disabled="#{physical.trunkFlag eq 'N'}"/>
						</h:panelGrid>
					</rich:column>
					
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI07.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.id.subUrNo,networkConfigBean.filterReqNWCPI07.filterColumn1)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
							 <h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI07.filterColumn1}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tablePMPI" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputLink value="#" id="link" onclick="viewAssignDetail('#{physical.id.urNo}','#{physical.id.subUrNo}')" rendered="#{physical.subUrStatusTxt != 'WAIT_PM'}">
					        	<h:outputText value="#{physical.id.subUrNo}" />
					        </h:outputLink>
					        <h:outputText value="#{physical.id.subUrNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI07.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(physical.trunkNo,networkConfigBean.filterReqNWCPI07.filterColumn6)}"  width="10%" style="vertical-align:top;">
					<f:facet name="header">						
							  <h:panelGroup>
							 <h:outputText value="Trunk No" styleClass="contentform tableHeaderText"></h:outputText>
							 <h:inputText value="#{networkConfigBean.filterReqNWCPI07.filterColumn6}" style="width: 50px;">
								 <a4j:support event="onblur" reRender="tablePMPI" />
							 </h:inputText>
						 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.trunkNo}"/>
						</h:panelGrid>	
					</div>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI07.filterColumn2}"  
				filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPI07.filterColumn2) 
							or fn:containsIgnoreCase(physical.hostName,networkConfigBean.filterReqNWCPI07.filterColumn2)
							or fn:containsIgnoreCase(physical.macAddress,networkConfigBean.filterReqNWCPI07.filterColumn2)	
							or fn:containsIgnoreCase(physical.locationName,networkConfigBean.filterReqNWCPI07.filterColumn2)			
							or fn:containsIgnoreCase(physical.floor,networkConfigBean.filterReqNWCPI07.filterColumn2)		
							or fn:containsIgnoreCase(physical.vlanId,networkConfigBean.filterReqNWCPI07.filterColumn2)							
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">
						
						 <h:panelGroup>
		<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI07.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column  
				filterValue="#{networkConfigBean.filterReqNWCPI07.filterColumn3}"  
				filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPI07.filterColumn3) 
							or fn:containsIgnoreCase(physical.portStatusDesc,networkConfigBean.filterReqNWCPI07.filterColumn3)
							or fn:containsIgnoreCase(physical.speedPortDesc,networkConfigBean.filterReqNWCPI07.filterColumn3)	
							or fn:containsIgnoreCase(physical.enclosure,networkConfigBean.filterReqNWCPI07.filterColumn3)			
							or fn:containsIgnoreCase(physical.interfaceDesc,networkConfigBean.filterReqNWCPI07.filterColumn3)							
							}" 
				width="20%" style="vertical-align:top;">
					<f:facet name="header">
					
							 <h:panelGroup>
		<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI07.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI07.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPI07.filterColumn4)}"  width="20%" style="vertical-align:top;">
					<f:facet name="header">
						
						 <h:panelGroup>
		<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI07.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMPI" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:inputTextarea style="width:100%;" rows="7" readonly="true" value="#{physical.reqRemarks}"/>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;text-align:center;">
					<f:facet name="header">
						<h:selectBooleanCheckbox id="impactAll" value="#{networkConfigBean.phyInterface.impactAll}" onclick="validateCheckbox('ALL',this,this,'isImpact','pagePI')" disabled="#{empty networkConfigBean.listPhysicalInterface}"/>
							<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="1">
							<h:selectBooleanCheckbox id="isImpact" value="#{physical.impactSelected}" onclick="validateCheckbox('N',document.getElementById('DetailForm:pagePI:tablePMPI:impactAll'),this,'isImpact','pagePI')" disabled="#{physical.trunkFlag eq 'N'}">
								<% /* <a4j:support action="#{reqNWConfigAction.getSelectedSubUR}" event="onclick" 
									reRender="networkConfigTab" oncomplete="Richfaces.showModalPanel('confirmImpact');">
									<a4j:actionparam name="urNo" value="#{physical.id.urNo}"/>
	 								<a4j:actionparam name="subUrNo" value="#{physical.id.subUrNo}"/>
	 								<a4j:actionparam name="currentTab" value="PI" />
	 								<a4j:actionparam name="isImpactValue" value="#{physical.isImpact}" />
 								</a4j:support> */ %>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</rich:column>
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPI07.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(physical.subUrStatus.subUrStatusName,networkConfigBean.filterReqNWCPI07.filterColumn5)}"  width="30%" style="vertical-align:top;text-align:center;">
						<f:facet name="header">
			
							 <h:panelGroup>
						<h:outputText value="Job Status " styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPI07.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tablePMPI" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="1">
							<h:outputText value="#{physical.subUrStatus.subUrStatusName}" styleClass="label" ></h:outputText>
						</h:panelGrid>
					</rich:column>
					
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="tablePMPI"
								maxPages="5" id="scrollPIDetailTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
			
		</td>
		<td>&nbsp;</td></tr>
		<h:inputHidden id="currentTab" value="PI"/>
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
			<h:panelGroup rendered="#{networkConfigBean.mode=='PM'}">
			<tr>
				<td align="right">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton id="btnAssign" value="Assign Job" styleClass="rich-button"
							onclick="assignJob('PI')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnReject" value="Reject Job" styleClass="rich-button" rendered="#{not empty networkConfigBean.listPhysicalInterface}"
							onclick="rejectJob('PI')">
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnDelegate" value="Delegate Job" styleClass="rich-button"
							onclick="delegateJob('PI')">
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