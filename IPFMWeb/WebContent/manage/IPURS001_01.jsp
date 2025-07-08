<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>

<style type="text/css">
	.valignTop {vertical-align:top;}
	.label {font-size:20px; font-weight: bold;}
	.displayLabel {}
	.rowHeight {height:25px;}
	.colWidth {width:200px;}
	.rich-filter-input {width:80px;}
}
</style>
</head>
<body style="overflow:hidden;">

<f:view>
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />					
	</f:subview>
	<f:subview id="error">
		<jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Manage IP Level 3</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" style="width:100%">
									<h:panelGroup style="width:100%">
										<table width="100%" border="0" class="thtext_detail">
										<tr class="inputRow">
											<td class="labelStyle">
												<h:outputText value="IP Address :" ></h:outputText>&nbsp;
											</td>	
									        <td colspan="3">
												<h:panelGroup id="rangeIpGroup" >
													<rich:spacer width="10"></rich:spacer>
									   				<h:inputText id="stIp1" value="#{manageDataIPBean.stIp1}"  
														size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . "  styleClass="label" />
			                                        <h:inputText id="stIp2" value="#{manageDataIPBean.stIp2}" 
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . " styleClass="label" />
	                                       			<h:inputText id="stIp3" value="#{manageDataIPBean.stIp3}"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . " styleClass="label" />
													<h:inputText id="stIp4" value="#{manageDataIPBean.stIp4}"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText rendered="#{manageDataIPBean.ipVersion == '6'}" value=" . "  styleClass="label"></h:outputText>
													<h:inputText id="stIp5" value="#{manageDataIPBean.stIp5}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 	size="1" style="text-align:center" maxlength="3" 
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText rendered="#{manageDataIPBean.ipVersion == '6'}"  styleClass="label" value=" . "></h:outputText>
													<h:inputText id="stIp6" value="#{manageDataIPBean.stIp6}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 size="1" style="text-align:center" maxlength="3" />
													<h:outputText value=" - "  styleClass="label" />
													<h:inputText id="edIp1" value="#{manageDataIPBean.edIp1}" 
													 	size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . "  styleClass="label" />
													<h:inputText id="edIp2" value="#{manageDataIPBean.edIp2}"  
														size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . "  styleClass="label"/>
			                                        <h:inputText id="edIp3" value="#{manageDataIPBean.edIp3}" 
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . "  styleClass="label"/>
	                                       			<h:inputText id="edIp4" value="#{manageDataIPBean.edIp4}"  
										 				size="1" style="text-align:center; width : 32px;" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . " styleClass="label" rendered="#{manageDataIPBean.ipVersion == '6'}" />
													<h:inputText id="edIp5" value="#{manageDataIPBean.edIp5}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 	size="1" style="text-align:center" maxlength="3" 
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText value=" . " styleClass="label" rendered="#{manageDataIPBean.ipVersion == '6'}" />
													<h:inputText id="edIp64" value="#{manageDataIPBean.edIp6}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 	size="1" style="text-align:center" maxlength="3" />
												</h:panelGroup>																											
											</td>														
	                                  </tr>
	                                  <tr class="inputRow">
	                                      <td class="labelStyle"><h:outputText value="IP Status :"></h:outputText>&nbsp;</td>
	                                  	  <td>
	                                  	  	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
		                                  	  	<rich:spacer width="10"></rich:spacer>
		          								<rich:comboBox id="ipStatus" defaultLabel="Please select value" 
													enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													 value="#{manageDataIPBean.ipStatusComboItem}" width="200">
													<f:attribute name="selectItems" value="#{manageDataIPBean.ipStatusList}"/>
													<f:selectItems value="#{manageDataIPBean.ipStatusList}"/>
												</rich:comboBox>
											</h:panelGrid>
	                                  	  </td>	
	                                  	  <td class="labelStyle" style="width:200px;"><h:outputText value="Network Type :"></h:outputText>&nbsp;</td>
										  <td>
										  	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
												<rich:comboBox id="networkType" defaultLabel="Please select value" 
													value="#{manageDataIPBean.networkTypeComboItem}" width="200">
													<f:attribute name="selectItems" value="#{manageDataIPBean.nwTypeList}"/>
													<f:selectItems value="#{manageDataIPBean.nwTypeList}"/>
												</rich:comboBox>
											</h:panelGrid>
										   </td>	
	                                  </tr>
	                                  <tr class="inputRow">
	                                      <td class="labelStyle">
	                                      	<h:outputText value="Host Name :"></h:outputText>&nbsp;
	                                      </td>
	                                      <td>
	                                      	<rich:spacer width="10"></rich:spacer>
	                                      	<h:inputText id="hostName" value="#{manageDataIPBean.hostName}" size="34"> </h:inputText>
	                                      </td>           
	                                
	                                  	  <td class="labelStyle" style="width:200px;"><h:outputText value="Site/Location :"></h:outputText>&nbsp;</td>
										  <td>
										  	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
											 	<rich:comboBox id="locationName" defaultLabel="Please select value" 
													enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													value="#{manageDataIPBean.locationComboItem}" width="200">
													<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
													<f:selectItems value="#{manageDataIPBean.locatList}"/>
												 </rich:comboBox> 
											</h:panelGrid>
										  </td>	
	                                  </tr>
	                                  <tr class="inputRow">
	                                 	  <td class="labelStyle"><h:outputText value="System Name :"></h:outputText>&nbsp;</td>
	                                      <td>
	                                      	<rich:spacer width="10"></rich:spacer>
	                                      	<h:inputText id="systemName" value="#{manageDataIPBean.systemName}" size="34" > </h:inputText>
                                    	  </td>     
	                                  	  <td class="labelStyle" style="width:200px;"><h:outputText value="Network Zone :"></h:outputText>&nbsp;</td>
										  <td>
										  	<rich:spacer width="10"></rich:spacer>
										  	<h:inputText id="networkZoneName" value="#{manageDataIPBean.networkZoneName}" size="33" > </h:inputText>
										  </td>
	                                  </tr>
	                                  
	                                  <tr class="inputRow">
	                                  	  <td class="labelStyle"><h:outputText value="UR Refer :"></h:outputText>&nbsp;</td>
										  <td>
										  		<rich:spacer width="10"></rich:spacer>
	                                        	<h:inputText id="urRefer" value="#{manageDataIPBean.urRefer}" size="34"></h:inputText>
										  </td>
	                                  	  <td class="labelStyle" style="width:200px;">
	                                  	  	<h:outputText value="Request From Planning Team :">
	                                  	  </h:outputText>&nbsp;</td>
										  <td>
										  	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
												<rich:comboBox id="requestFromPlanningTeam" defaultLabel="Please select value" 
													enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													value="#{manageDataIPBean.requestFromTeamComboItem}" width="200">
													<f:attribute name="selectItems" value="#{manageDataIPBean.requestFromTeamList}"/>
													<f:selectItems value="#{manageDataIPBean.requestFromTeamList}"/>
												</rich:comboBox>
											</h:panelGrid>
										   </td>	
	                                  </tr>
	                                  <tr class="inputRow">
	                                  	  <td class="labelStyle" ><h:outputText value="Project ID :"></h:outputText>&nbsp;</td>
										  <td>
										    <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
		                                        <rich:comboBox id="projectId" defaultLabel="Please select value" 
													enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													value="#{manageDataIPBean.projectIdComboItem}" width="200">
													<f:attribute name="selectItems" value="#{manageDataIPBean.projectIdList}"/>
													<f:selectItems value="#{manageDataIPBean.projectIdList}"/>                                        
		                                        </rich:comboBox>
											</h:panelGrid>
										  </td>	
										  <td class="labelStyle" style="width:200px;"><h:outputText value="Project Manager :"></h:outputText>&nbsp;</td>
										  <td>
										  	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
											  	<rich:comboBox id="projectManager" defaultLabel="Please select value" 
													enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													value="#{manageDataIPBean.projectManagerComboItem}" width="200">
													<f:attribute name="selectItems" value="#{manageDataIPBean.projectManagerList}"/>
													<f:selectItems value="#{manageDataIPBean.projectManagerList}"/>                                        
		                                        </rich:comboBox>
											</h:panelGrid>
										  </td>
	                                  </tr> 
	                                  <tr class="inputRow">
	                                  	  <td class="labelStyle"><h:outputText value="Effective Date :"></h:outputText>&nbsp;</td>
										  <td>
										  	<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
	                                         	<rich:calendar value="#{manageDataIPBean.effDateFrom}"
								                        locale="en/US"
								                        popup="true"
								                        datePattern="dd/MM/yyyy"
								                        showApplyButton="false" cellWidth="10px" cellHeight="22px" 
								                        inputStyle="background-color:white"
								                        inputSize="9"
								                        direction="auto"/>
									             <h:outputText value="&nbsp;-&nbsp;&nbsp;" escape="false"></h:outputText>
									             <rich:calendar value="#{manageDataIPBean.effDateTo}"
								                        locale="en/US"
								                        popup="true"
								                        datePattern="dd/MM/yyyy"
								                        showApplyButton="false" cellWidth="10px" cellHeight="22px" 
								                        inputStyle="background-color:white"
								                        inputSize="9"
								                        direction="auto"/>
				                        	</h:panelGrid>
										  </td>	
	                                  	  <td class="labelStyle" style="width:200px;"><h:outputText value="Expire Date :"></h:outputText>&nbsp;</td>
										  <td>
									  		<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
	                                  	  		<rich:spacer width="10"></rich:spacer>
	   							               	<rich:calendar value="#{manageDataIPBean.expDateFrom}"
								                        locale="en/US"
								                        popup="true"
								                        datePattern="dd/MM/yyyy"
								                        showApplyButton="false" cellWidth="10px" cellHeight="22px" 
								                        inputStyle="background-color:white"
								                        inputSize="9"
								                        direction="auto"/>
								               	<h:outputText value="&nbsp;-&nbsp;&nbsp;" escape="false"></h:outputText>
								               	<rich:calendar value="#{manageDataIPBean.expDateTo}"
								                        locale="en/US"
								                        popup="true"
								                        datePattern="dd/MM/yyyy"
								                        showApplyButton="false" cellWidth="10px" cellHeight="22px" 
								                        inputStyle="background-color:white"
								                        inputSize="9"
								                        direction="auto"/>
					                       	</h:panelGrid>
										  </td>	 
	                                  </tr> 
	                                  <tr>
	                                    <td colspan="4"><rich:spacer height="5" /></td>
	                                  </tr>  
	                                  <tr>
											<td align="right" colspan="4">
												<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{groupIPAction.search}" reRender="panelGrop,groupSearchResult" />&nbsp;
												<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{groupIPAction.init}" reRender="panelGrop,groupSearchResult"/>&nbsp;
											</td>	
		                               </tr>                                                         
									</table>
								</h:panelGroup>
							</rich:panel>
							<rich:spacer height="5" />	
							<rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="IPDataTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{manageDataIPBean.ipDetailList}" reRender="scrollIPDetailTable" 
										rowClasses="odd,even" rows="#{ipfmConfigBean.rowPerPage}"
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
	
									<rich:column styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										 <div align="center">
										  	<a4j:commandButton id="btnUpd" value="Update" image="../images/p_edit.gif" style="height: 15; width: 15" action="#{groupIPAction.initUpdate}">
												<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
			          						</a4j:commandButton>
			          					</div>
									</rich:column>
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.ipAddress,manageDataIPBean.filterIpUrs001.filterColumn1)}"   styleClass="valignTop" sortBy="#{detail.ipAddress}"  selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs001.sortColumn1}" >
										<f:facet name="header">										
												  <h:panelGroup>
		 	    <h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP<br>Address</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs001.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>		  
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
		          						   <h:outputText value="#{detail.ipAddress}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.ipStatusName,manageDataIPBean.filterIpUrs001.filterColumn2)}"   styleClass="valignTop" sortBy="#{detail.ipStatusName}"  selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs001.sortColumn2}"  >
										<f:facet name="header">
											  <h:panelGroup>
		 				   <h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP<br>Status</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs001.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>	
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>								
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.ipStatusName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.hostName,manageDataIPBean.filterIpUrs001.filterColumn3)}"   styleClass="valignTop" sortBy="#{detail.hostName}"   selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs001.sortColumn3}"  >
										<f:facet name="header">
											<h:panelGroup>
		 		<h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Host<br>Name</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs001.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>	
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>								
										</f:facet>
										<div>
			          						<h:outputText value="#{ipDetail.hostName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.systemName,manageDataIPBean.filterIpUrs001.filterColumn4)}"   styleClass="valignTop" sortBy="#{detail.systemName}"  selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs001.sortColumn4}"  >
										<f:facet name="header">
										<h:panelGroup>
		 		<h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>System<br>Name</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs001.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>	
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>										
										</f:facet>
										<div align="left">
			          						<h:outputText value="#{detail.systemName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>							
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.locationName,manageDataIPBean.filterIpUrs001.filterColumn5)}"  styleClass="valignTop">
										<f:facet name="header">
										<h:panelGroup>
		 		<h:outputText value="Network<br>Type" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail.networkType}" styleClass="contentform"></h:outputText> 
										</div>
									</rich:column>
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.locationName,manageDataIPBean.filterIpUrs001.filterColumn6)}"  styleClass="valignTop">
										<f:facet name="header">
											<h:panelGroup>
		 			<h:outputText value="Site/Location" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
			          						 <h:outputText value="#{detail.locationName}"styleClass="contentform" ></h:outputText>
										</div>
									</rich:column>
						            <rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(detail.networkZoneName,manageDataIPBean.filterIpUrs001.filterColumn7)}"  styleClass="valignTop">
										<f:facet name="header">										
										<h:panelGroup>
		 				<h:outputText value="Network<br>Zone" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
		          						  <h:outputText value="#{detail.networkZoneName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>		
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn8}"  filterExpression="#{fn:containsIgnoreCase(detail.requestFromTeamName,manageDataIPBean.filterIpUrs001.filterColumn8)}"   styleClass="valignTop">
										<f:facet name="header">										
										<h:panelGroup>
		 				<h:outputText value="Request<br>Planning Team" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn8}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
		          						  <h:outputText value="#{detail.requestFromTeamName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>	
									<rich:column  filterValue="#{manageDataIPBean.filterIpUrs001.filterColumn9}"  filterExpression="#{fn:containsIgnoreCase(detail.projectName,manageDataIPBean.filterIpUrs001.filterColumn9)}"   styleClass="valignTop">
										<f:facet name="header">
											<h:panelGroup>
											<h:outputText value="Project<br>Name" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs001.filterColumn9}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
		          						  <h:outputText value="#{detail.projectName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Effective<br>Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.effDate}" styleClass="contentform">
			          						 </h:outputText> 
										</div>
									</rich:column>
									<rich:column styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Expire<br>Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.expDate}" styleClass="contentform">
			          						 </h:outputText> 
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(manageDataIPBean.ipDetailList) }" /> records
											</rich:column>
											<rich:column colspan="10">
												<rich:datascroller immediate="true" rendered="true" align="right" for="IPDataTable"
													maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" 
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													style="background-color: #cccccc;" fastStep="#{ipfmConfigBean.fastStepPage}">
												   	  	
												</rich:datascroller>
											</rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>&nbsp;
								<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td valign="top" width="15%">
												<a4j:commandLink action="#{userReqIPAction.init}">Download Template</a4j:commandLink>
											</td>
											<td>
												 <rich:fileUpload fileUploadListener="#{systemParameterAction.listener}"
								             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
								             			id="impFirewall" 
								             			immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
								             			acceptedTypes="#{systemParameterFileUploadBean.acceptedTypes}" 
								             			allowFlash="#{systemParameterFileUploadBean.useFlash}"
														sizeErrorLabel="File Size Over!" 
								             			sizeErrorLabelClass="contentform"
								             			uploadListClass="contentform"
								             			transferErrorLabelClass="contentform"
								             			styleClass="contentform"
								             			fileEntryClass="contentform"
								             			fileEntryControlClass="contentform"
								             			progressLabelClass="contentform"
								             			addButtonClass="contentform"
								             			uploadButtonClass="contentform"
								             			listHeight="50" autoclear="true"
								             			addControlLabel="Browse"
								             			listWidth="100%" onuploadcomplete="fireClickEvent(document.getElementById('popupModalSubview:formRegionMultiQuery:ImportForm:btnSubmitUpload'));" >
								             			 <a4j:support event="onuploadcomplete"  reRender="groupImportCommand" />
								         			</rich:fileUpload>
											</td>
										</tr>
										<tr><td colspan="2"><rich:spacer height="10"></rich:spacer></td></tr>
									</table>
								</h:panelGroup>										
							</rich:panel>
							</td>
						</tr>
						
					</table>
					</a4j:form>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>	
		<rich:modalPanel id="confirmDialog" autosized="true">			
		<a4j:form id="delConfirmDialog">
			<table width="150px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
                        </td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform">												
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="confirmDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
		</a4j:form>
	</rich:modalPanel>
	
</f:view>
</body>
</html>
