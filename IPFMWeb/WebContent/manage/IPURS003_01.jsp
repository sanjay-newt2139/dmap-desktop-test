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
	.rich-filter-input {width:80px;}
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
								class="style9">Manage IP-Level 2</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
					    <tr bgcolor="#BFBFBF">
					         <td>
								  <table border="0" cellpadding="0" cellspacing="0" align="left" >
									<tr>
										   <h:panelGroup id="tabGroup">
										   <td>
										  		<a4j:commandButton id="btnOwnerList" value="Owner List IP" 
													image="../images/tab_owner_ip_list_active.png" style="height: 25; width: 87" 
													action="#{manageDataIPAction.init}">
													<a4j:actionparam name="programIDParam" value="IPURS003_01"/>
				          						</a4j:commandButton>
				          						<a4j:commandButton id="btnIPDetail" value="IP Detail" 
													image="../images/tab_ip_detail_notactive.png" style="height: 25; width: 61" 
													action="#{manageDataIPAction.initIPDetailAdd}">
				          						</a4j:commandButton>
			                      			 </td>
										   </h:panelGroup>
									</tr>
									<tr>
										<td height="2" colspan="8" align="center" valign="bottom"></td>
									</tr>
							  	</table>
							</td>  
					    </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right" >
												<strong><h:outputText value="IP :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22" colspan="3" align="left" >
												<h:panelGroup id="rangIpGroup">
									   				<h:inputText id="stIp1" value="#{manageDataIPBean.stIp1}"  
														size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
			                                        <h:inputText id="stIp2" value="#{manageDataIPBean.stIp2}" 
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
                                        			<h:inputText id="stIp3" value="#{manageDataIPBean.stIp3}"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
													<h:inputText id="stIp4" value="#{manageDataIPBean.stIp4}"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText style="font-weight: bolder;" rendered="#{manageDataIPBean.ipVersion == '6'}">
														&nbsp;.&nbsp;
													</h:outputText>
													<h:inputText id="stIp5" value="#{manageDataIPBean.stIp5}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 	size="1" style="text-align:center" maxlength="3" 
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText style="font-weight: bolder;" rendered="#{manageDataIPBean.ipVersion == '6'}" >
														&nbsp;.&nbsp;
													</h:outputText>
													<h:inputText id="stIp6" value="#{manageDataIPBean.stIp6}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 size="1" style="text-align:center" maxlength="3" />
													&nbsp;<h:outputText value="-" style="font-weight: bolder;" />&nbsp;
													<h:inputText id="edIp1" value="#{manageDataIPBean.edIp1}" 
													 	size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
												</h:panelGroup>																
											</td>														
                                  </tr>
                                  <tr>
                                     <td width="15%" height="25" align="right"><strong><h:outputText value="IP Status :"></h:outputText></strong>&nbsp;</td>
                                  	 <td>
          								<rich:comboBox id="ipStatus" defaultLabel="Please select value" 
											enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											 value="#{manageDataIPBean.ipStatusComboItem}" width="200">
											<f:attribute name="selectItems" value="#{manageDataIPBean.ipStatusList}"/>
											<f:selectItems value="#{manageDataIPBean.ipStatusList}"/>
										</rich:comboBox>
                                  	 </td>	                              
                                  </tr>
                                  <tr>
                                      <td width="15%" height="25" align="right"><strong><h:outputText value="Host Name :"></h:outputText></strong>&nbsp;</td>
                                      <td colspan="3"><h:inputText id="hostName" value="#{manageDataIPBean.hostName}" size="55"	 
                                            style="text-align:cente"> </h:inputText></td>           
                                  </tr>
                                  <tr>
                                  	  <td width="15%" height="25" align="right"><strong><h:outputText value="Site/Location :"></h:outputText></strong>&nbsp;</td>
									  <td>
										 <rich:comboBox id="locationName" defaultLabel="Please select value" 
											enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											value="#{manageDataIPBean.locationComboItem}" width="200">
											<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
											<f:selectItems value="#{manageDataIPBean.locatList}"/>
										</rich:comboBox>
									  </td>	
                                  </tr>
                                  <tr>
                                  	  <td width="20%" height="25" align="right"><strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;</td>
									  <td>
										<rich:comboBox id="networkZone" defaultLabel="Please select value" 
											enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											value="#{manageDataIPBean.networkZoneComboItem}" width="200">
											<f:attribute name="selectItems" value="#{manageDataIPBean.zoneList}"/>
											<f:selectItems value="#{manageDataIPBean.zoneList}"/>
										</rich:comboBox>
									  </td>
                                  </tr>
                                  <tr>
                                  	  <td width="15%" height="25" align="right"><strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;</td>
									  <td>
										<rich:comboBox id="networkType" defaultLabel="Please select value" 
											enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											value="#{manageDataIPBean.networkTypeComboItem}" width="200">
											<f:attribute name="selectItems" value="#{manageDataIPBean.nwTypeList}"/>
											<f:selectItems value="#{manageDataIPBean.nwTypeList}"/>
										</rich:comboBox>
									   </td>	
                                  </tr>
                                  <tr>
                                  	  <td width="15%" height="25" align="right"><strong><h:outputText value="Request From Team :"></h:outputText></strong>&nbsp;</td>
									  <td>
										<rich:comboBox id="requestFromTeam" defaultLabel="Please select value" 
											enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											value="#{manageDataIPBean.tier2TeamComboItem}" width="300">
											<f:attribute name="selectItems" value="#{manageDataIPBean.t2TeamList}"/>
											<f:selectItems value="#{manageDataIPBean.t2TeamList}"/>
										</rich:comboBox>
									   </td>	
                                  </tr>
                                  <tr>
                                  	  <td width="15%" height="25" align="right"><strong><h:outputText value="UR Refer :"></h:outputText></strong>&nbsp;</td>
									  <td>
                                        <h:inputText id="urRefer" value="#{manageDataIPBean.urRefer}" size="15"	 style="text-align:cente"></h:inputText>
									   </td>	
                                  </tr>
                                  <tr>
                                  	  <td width="10%" height="25" align="right"><strong><h:outputText value="Project ID :"></h:outputText></strong>&nbsp;</td>
									  <td colspan="3" >
                                        <h:inputText id="projectId" value="#{manageDataIPBean.projectId}" size="15"	 style="text-align:cente"></h:inputText>
										<img src="../images/p_zoom.gif" style=" width : 16px; height : 16px;">
                                        <h:inputText id="projectName" value="#{manageDataIPBean.projectName}" size="30"	 style="text-align:cente"></h:inputText>
									  </td>	
                                  </tr> 
                                  <tr>
                                    <td width="20%" height="25" align="right"><strong><h:outputText value="Project Owner :"></h:outputText></strong>&nbsp;</td>
									  <td>
                                        <h:inputText id="projectOwner" value="" size="55" style="text-align:cente"></h:inputText>
									  </td>
                                  </tr>
                                  <tr>
                                  	  <td width="20%" height="25" align="right"><strong><h:outputText value="Effective Date from :"></h:outputText></strong>&nbsp;</td>
									  <td colspan="3">
                                         <rich:calendar value="#{manageDataIPBean.effDateFrom}"
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>&nbsp;
							             <strong><h:outputText value="To :"></h:outputText></strong>&nbsp;
							             <rich:calendar value="#{manageDataIPBean.effDateTo}"
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>
									  </td>			  
                                  </tr>  
                                  <tr>
                                  	  <td width="15%" height="25" align="right"><strong><h:outputText value="Expire Date from :"></h:outputText></strong>&nbsp;</td>
									  <td colspan="3">
   							               <rich:calendar value="#{manageDataIPBean.expDateFrom}"
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>&nbsp;
							               <strong><h:outputText value="To :"></h:outputText></strong>&nbsp;
							               <rich:calendar value="#{manageDataIPBean.expDateTo}"
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>
									  </td>	 
                                  </tr> 
                                  <tr>
                                    <td colspan="4" >&nbsp;</td>
                                  </tr>  
                                  <tr>
                                          <td  width="20%"></td>
										  <td  colspan="3">
											<a4j:commandButton id="btnQuery" value="Query" styleClass="rich-button"
												action="#{manageDataIPAction.search}"
												reRender="groupSearchResult" />&nbsp;
											<a4j:commandButton id="btnClear" value="Clear Criteria" styleClass="rich-button"
												action="#{manageDataIPAction.init}"
												reRender="groupSearchResult"/>&nbsp;
											<a4j:commandButton id="btnImport" value="Import" styleClass="rich-button"
												action="#{manageDataIPAction.init}"/>
										  </td>	
	                               </tr>                                                         
								</table>
							</rich:panel>
								<rich:spacer height="5" />	
								
							<rich:simpleTogglePanel switchType="client" id="groupSearchResult" label="Search Result" opened="#{manageDataIPBean.disPlaySearchResult}" >
								 <rich:panel>
								    	<a4j:commandButton id="btnExport" value="Export" styleClass="rich-button"
												action="#{manageDataIPAction.init}"/>
										
										<rich:dataTable width="95%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
									var="ipDetail" value="#{manageDataIPBean.ipDetailList}" reRender="scrollIPDetailTable" 
									rows="#{ipfmConfigBean.rowPerPage}"
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

										<rich:column width="5%">
											<f:facet name="header">
												<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											 <div align="center">
											  <a4j:commandButton id="btnUpd" value="Update" 
													image="../images/p_edit.gif" style="height: 15; width: 15" 
													action="#{manageDataIPAction.initUpdate}">
													<a4j:actionparam name="rowId" value="#{ipDetail.rowId}"/>
				          						</a4j:commandButton>
				          					</div>
										</rich:column>
										<rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.ipAddress,manageDataIPBean.filterIpUrs003.filterColumn1)}"   width="20%"  selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs003.sortColumn1}" sortBy="#{ipDetail.ipAddress}">
											<f:facet name="header">
												 	  <h:panelGroup>
		     <h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs003.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						   <h:outputText value="#{ipDetail.ipAddress}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.ipStatusName,manageDataIPBean.filterIpUrs003.filterColumn2)}"   width="10%"  selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs003.sortColumn2}" sortBy="#{ipDetail.ipStatusName}" >
											<f:facet name="header">											
												  <h:panelGroup>
		 	 <h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP Status</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs003.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          						<h:outputText value="#{ipDetail.ipStatusName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.hostName,manageDataIPBean.filterIpUrs003.filterColumn3)}"   selfSorted="false" sortOrder="#{manageDataIPBean.sortIpUrs003.sortColumn3}" sortBy="#{ipDetail.hostName}" >
											<f:facet name="header">
												 <h:panelGroup>
		 	<h:commandLink rendered="true" action="#{manageDataIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Host Name</strong></span>
				<f:param name="sortColumn" value="#{manageDataIPBean.sortIpUrs003.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          						<h:outputText value="#{ipDetail.hostName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.locationName,manageDataIPBean.filterIpUrs003.filterColumn4)}"   width="10%" >
											<f:facet name="header">
												
												 <h:panelGroup>
		<h:outputText value="Site/Location" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          						 <h:outputText value="#{ipDetail.locationName}"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
							            <rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.networkZoneName,manageDataIPBean.filterIpUrs003.filterColumn5)}"   width="10%" >
											<f:facet name="header">												
												 <h:panelGroup>
		<h:outputText value="Network Zone" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						  <h:outputText value="#{ipDetail.networkZoneName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>									
										<rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.networkType,manageDataIPBean.filterIpUrs003.filterColumn6)}"   width="10%" >
											<f:facet name="header">
												
												<h:panelGroup>
		<h:outputText value="Network Type" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						    <h:outputText value="#{ipDetail.networkType}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column  filterValue="#{manageDataIPBean.filterIpUrs003.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.urRefer,manageDataIPBean.filterIpUrs003.filterColumn7)}"   width="10%" >
											<f:facet name="header">												
													<h:panelGroup>
		<h:outputText value="UR Refer" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{manageDataIPBean.filterIpUrs003.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          					   <h:outputText value="#{ipDetail.urRefer}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          						 <h:outputText value="#{ipDetail.effDate}" styleClass="contentform">
				          						 </h:outputText> 
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Expire Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          						 <h:outputText value="#{ipDetail.expDate}" styleClass="contentform">
				          						 </h:outputText> 
											</div>
										</rich:column>
											

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{ fn:length(manageDataIPBean.ipDetailList) }" /> records
												</rich:column>
												<rich:column colspan="8">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>
											
																						
										</f:facet>
									</rich:dataTable>												
								</rich:panel>
								</rich:simpleTogglePanel>	
								
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
