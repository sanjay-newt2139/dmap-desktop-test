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
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>
<style type="text/css">
	.valignTop {vertical-align:top;}
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
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td  height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Search IP</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
							  <rich:panel id="panelGrop" >
							    <table width="97%" border="0" class="thtext_detail" style="" >
								    	<tr class="inputRow">
												<td class="labelStyle" >IP Address :&nbsp;</td>	
										        <td>
													<h:panelGrid id="rangeIpGroup" columns="17" cellpadding="0" cellspacing="0" border="0" >
										   				<h:inputText id="stIp1" value="#{searchIPBean.ipInfo.stIp1}" 
															size="1" style="text-align:center" maxlength="3" 
										   					onkeypress="return numbersonlyNoDot(event);"
													 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIp2',this,event,0,255,'190')"
															onblur="this.value = isNumber(this);" />
														&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
				                                        <h:inputText id="stIp2" value="#{searchIPBean.ipInfo.stIp2}" 
											 				size="1" style="text-align:center" maxlength="3"  
										   					onkeypress="return numbersonlyNoDot(event);"
													 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIp3',this,event,0,255,'190')"
														 	onblur="this.value = isNumber(this);" />
														&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
	                                        			<h:inputText id="stIp3" value="#{searchIPBean.ipInfo.stIp3}"  
											 				size="1" style="text-align:center" maxlength="3"  
										   					onkeypress="return numbersonlyNoDot(event);"
													 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIp4',this,event,0,255,'190')"
														 	onblur="this.value = isNumber(this);" />
														&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
														<h:inputText id="stIp4" value="#{searchIPBean.ipInfo.stIp4}"  
											 				size="1" style="text-align:center" maxlength="3"  
										   					onkeypress="return numbersonlyNoDot(event);"
													 		onkeyup="return keyRangeNumberWithDot('DetailForm:edIp1',this,event,0,255,'191')"											 				
														 	onblur="this.value = isNumber(this);" />
														
														&nbsp;<h:outputText value="/" style="font-weight: bolder;" />&nbsp;
														<h:inputText id="edIp1" value="#{searchIPBean.ipInfo.submask}" 
														 	size="1" style="text-align:center" maxlength="2"  
														 	onkeypress="return numbersonlyNoDot(event);"
														 	onkeyup="enterSubmit('DetailForm:btnQuery',event)"
														 	onblur="this.value = isNumber(this);" />
												</h:panelGrid>																													
											</td>														
	                                  	</tr> 
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Host Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<h:inputText id="hostName" value="#{searchIPBean.ipInfo.hostName}" style="text-align:left;width:200px;"  />
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="System Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
                                                <h:inputText id="systemName" value="#{searchIPBean.ipInfo.systemName}" style="text-align:left;width:200px;"  />
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="VLAN :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
                                               <h:inputText id="vlan"  value="#{searchIPBean.ipInfo.vlanId}" style="text-align:left;width:200px;" 
                                               		onkeypress="return keyRange(this,event,1,4096);"
											        onblur="this.value = isNumber(this);" />
											</td>
										</tr>
										
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Site/Location :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" > 
														<rich:comboBox id="siteLocation"
															defaultLabel="" enableManualInput="false"
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{searchIPBean.locationComboItem}" width="220">
															<f:attribute name="selectItems" value="#{searchIPBean.locationList}"/>
															<f:selectItems value="#{searchIPBean.locationList}"/>
														</rich:comboBox>
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText  value="Project ID :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" > 
                                                 <h:inputText id="projectId"  value="#{searchIPBean.ipInfo.projectId}"  style="text-align:left;width:200px;"  />
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText  value="Project Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" > 
                                                 <h:inputText id="projectName"  value="#{searchIPBean.ipInfo.projectName}" style="text-align:left;width:350px;"  />
											</td>
										</tr>
										
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Watching U Node Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<h:inputText  id="wyNodeName" value="#{searchIPBean.ipInfo.wyNodeName}"  style="text-align:left;width:200px;"  />
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="NAT IP :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<h:inputText  id="natIp" value="#{searchIPBean.ipInfo.natIp}"  style="text-align:left;width:200px;"  />
											</td>
										</tr>
	                                   <tr>
	                                      <td  colspan="4" align="left">
	                                      	<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button"
	                                      		action="#{searchIPAction.search}"
												reRender="errorMsg,groupSearchResult">
											</a4j:commandButton>&nbsp;&nbsp;
											<a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button" action="#{searchIPAction.reset}"
												reRender="panelGrop,groupSearchResult"/>&nbsp;
											<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#stIp1,#stIp2,#stIp3,#stIp4,#edIp1,#hostName,#systemName,#vlan,#siteLocation,#projectId,#projectName,#wyNodeName"/>	
											</td>	
	                                   </tr>                                                    
								 </table>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{searchIPBean.searchList}" reRender="scrollIPDetailTable"
										  
										 
										rowClasses="odd,even"  rows="256"
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
									
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.ipAddress,searchIPBean.filterIP002.filterColumn1)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn1}" sortBy="#{detail.ipAddress}">
										<f:facet name="header">
											    <h:panelGroup>
													 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
														 <span class="contentform tableHeaderText">
															<strong>IP Address</strong></span>
															<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn1}" />
															<f:param name="sortColumnNo" value="1" />
															<f:param name="TablSort" value="ipDetailTable" />
													  </h:commandLink>
													 <h:inputText value="#{searchIPBean.filterIP002.filterColumn1}" style="width: 50px;">
														 <a4j:support event="onblur" reRender="ipDetailTable" />
													 </h:inputText>
												 </h:panelGroup>
										</f:facet>
										<div align="center">
											 <a4j:commandLink id="urLink" reRender="errorMsg,IPSSR002_Popup" action="#{searchIPAction.popupIPInfo}">  
								      	           <h:outputText value="#{detail.ipAddress}" styleClass="contentform" ></h:outputText>
								      	           <rich:componentControl for="IPSSR002_Popup" operation="#{errorMessages ? '' : 'show'}" event="oncomplete" />
								      	           <a4j:actionparam name="ipAddress" value="#{detail.ipAddress}"/>
								             </a4j:commandLink>
										</div>
									</rich:column>
									
									<!-- NAT IP -->
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn11}"  filterExpression="#{fn:containsIgnoreCase(detail.natIp,searchIPBean.filterIP002.filterColumn11)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn1}" sortBy="#{detail.ipAddress}">
										<f:facet name="header">
											    <h:panelGroup>
													 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
														 <span class="contentform tableHeaderText">
															<strong>NAT IP</strong></span>
															<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn11}" />
															<f:param name="sortColumnNo" value="1" />
															<f:param name="TablSort" value="ipDetailTable" />
													  </h:commandLink>
													 <h:inputText value="#{searchIPBean.filterIP002.filterColumn11}" style="width: 50px;">
														 <a4j:support event="onblur" reRender="ipDetailTable" />
													 </h:inputText>
												 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.natIp}" styleClass="contentform" >
			          						</h:outputText>
										</div>
									</rich:column>
									
									
									
									
									<!-- VLAN -->
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn10}"  filterExpression="#{fn:containsIgnoreCase(detail.vlanId,searchIPBean.filterIP002.filterColumn10)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn10}" sortBy="#{detail.vlanId}" >
										<f:facet name="header">
											 <h:panelGroup>
												 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
													 <span class="contentform tableHeaderText">
														<strong>VLAN</strong></span>
														<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn10}" />
														<f:param name="sortColumnNo" value="2" />
														<f:param name="TablSort" value="ipDetailTable" />
												  </h:commandLink>
												 <h:inputText value="#{searchIPBean.filterIP002.filterColumn10}" style="width: 50px;">
													 <a4j:support event="onblur" reRender="ipDetailTable" />
												 </h:inputText>
											 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.vlanId}" styleClass="contentform" >
			          						</h:outputText>
										</div>
									</rich:column>
									
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.networkIp,searchIPBean.filterIP002.filterColumn2)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn2}" sortBy="#{detail.networkIp}" >
										<f:facet name="header">
											 <h:panelGroup>
												 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
													 <span class="contentform tableHeaderText">
														<strong>Network IP</strong></span>
														<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn2}" />
														<f:param name="sortColumnNo" value="2" />
														<f:param name="TablSort" value="ipDetailTable" />
												  </h:commandLink>
												 <h:inputText value="#{searchIPBean.filterIP002.filterColumn2}" style="width: 50px;">
													 <a4j:support event="onblur" reRender="ipDetailTable" />
												 </h:inputText>
											 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.networkIp}" styleClass="contentform" >
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.ipSubmask,searchIPBean.filterIP002.filterColumn3)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn3}" sortBy="#{detail.ipSubmask}" >
										<f:facet name="header">
											<h:panelGroup>
												 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
													 <span class="contentform tableHeaderText">
														<strong>Subnet Mask</strong></span>
														<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn3}" />
														<f:param name="sortColumnNo" value="3" />
														<f:param name="TablSort" value="ipDetailTable" />
												  </h:commandLink>
												 <h:inputText value="#{searchIPBean.filterIP002.filterColumn3}" style="width: 50px;">
													 <a4j:support event="onblur" reRender="ipDetailTable" />
												 </h:inputText>
											 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.ipSubmask}" styleClass="contentform" >			
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.statusName,searchIPBean.filterIP002.filterColumn4)}"    	   styleClass="valignTop" selfSorted="false"   sortOrder="#{searchIPBean.sortIP002.sortColumn4}" sortBy="#{detail.ipStatus}" >
										<f:facet name="header">
											<h:panelGroup>
											<h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
											 <span class="contentform tableHeaderText">
												<strong>IP Status</strong></span>
												<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn4}" />
												<f:param name="sortColumnNo" value="4" />
												<f:param name="TablSort" value="ipDetailTable" />
										  </h:commandLink>		
										   <h:inputText value="#{searchIPBean.filterIP002.filterColumn4}" style="width: 50px;">
											 <a4j:support event="onblur" reRender="ipDetailTable" />
										 </h:inputText>
										  </h:panelGroup>										
										</f:facet>
										<div>
			          						<h:outputText value="Avariable"  rendered="#{detail.ipStatus eq 'N'}" styleClass="contentform"/>
			          						<h:outputText value="Assign To User"  rendered="#{detail.ipStatus eq 'A'}" styleClass="contentform"/>
			          						<h:outputText value="Reserved"  rendered="#{detail.ipStatus eq 'R'}" styleClass="contentform"/>
			          						<h:outputText value="Assign To Planing"  rendered="#{detail.ipStatus eq 'P'}" styleClass="contentform"/>
			          						<h:outputText value="Terminate"  rendered="#{detail.ipStatus eq 'T'}" styleClass="contentform"/>
			          						<h:outputText value="Used"  rendered="#{detail.ipStatus eq 'U'}" styleClass="contentform"/>
										</div>
									</rich:column>
									
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.hostName,searchIPBean.filterIP002.filterColumn5)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn5}" sortBy="#{detail.hostName}" >
										<f:facet name="header">
											<h:panelGroup>
												 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
													 <span class="contentform tableHeaderText">
														<strong>Host Name</strong></span>
														<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn5}" />
														<f:param name="sortColumnNo" value="5" />
														<f:param name="TablSort" value="ipDetailTable" />
												  </h:commandLink>
												 <h:inputText value="#{searchIPBean.filterIP002.filterColumn5}" style="width: 50px;">
													 <a4j:support event="onblur" reRender="ipDetailTable" />
												 </h:inputText>
											 </h:panelGroup>
										</f:facet>
										<div>
			          						<h:outputText value="#{detail.hostName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.systemOwnerName,searchIPBean.filterIP002.filterColumn6)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn6}" sortBy="#{detail.systemOwnerName}" >
										<f:facet name="header">
											<h:panelGroup>
												 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
													 <span class="contentform tableHeaderText">
														<strong>System Owner Name</strong></span>
														<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn6}" />
														<f:param name="sortColumnNo" value="6" />
														<f:param name="TablSort" value="ipDetailTable" />
												  </h:commandLink>
												 <h:inputText value="#{searchIPBean.filterIP002.filterColumn6}" style="width: 50px;">
													 <a4j:support event="onblur" reRender="ipDetailTable" />
												 </h:inputText>
											 </h:panelGroup>
										
										</f:facet>
										<div>
			          						<h:outputText value="#{detail.systemOwnerName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>							
									
									<rich:column styleClass="valignTop"    sortOrder="#{searchIPBean.sortIP002.sortColumn7}" sortBy="#{detail.expiredDate}">
										<f:facet name="header">
											<h:outputText value="Expire Date" escape="false" styleClass="contentform tableHeaderText">
											</h:outputText>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.expiredDate}"styleClass="contentform" >
			          						    <f:convertDateTime pattern="dd/MM/yyyy" />
			          						 </h:outputText>
										</div>
									</rich:column>
									
									<rich:column  styleClass="valignTop"  sortOrder="#{searchIPBean.sortIP002.sortColumn8}" sortBy="#{detail.vip}">
										<f:facet name="header">
												<h:outputText value="VIP" escape="false" styleClass="contentform tableHeaderText" />
										</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail.vip=='Y'?'Yes':'No'}" styleClass="contentform"></h:outputText> 
										</div>
									</rich:column>
									<rich:column  filterValue="#{searchIPBean.filterIP002.filterColumn9}"  filterExpression="#{fn:containsIgnoreCase(detail.locationName,searchIPBean.filterIP002.filterColumn9)}"  styleClass="valignTop"  selfSorted="false" sortOrder="#{searchIPBean.sortIP002.sortColumn9}" sortBy="#{detail.locationName}">
										<f:facet name="header">
											 
										<h:panelGroup>
											 <h:commandLink rendered="true" action="#{searchIPAction.indexSort}">
												 <span class="contentform tableHeaderText">
													<strong>Site/Location</strong></span>
													<f:param name="sortColumn" value="#{searchIPBean.sortIP002.sortColumn9}" />
													<f:param name="sortColumnNo" value="9" />
													<f:param name="TablSort" value="ipDetailTable" />
											  </h:commandLink>
											 <h:inputText value="#{searchIPBean.filterIP002.filterColumn9}" style="width: 50px;">
												 <a4j:support event="onblur" reRender="ipDetailTable" />
											 </h:inputText>
										 </h:panelGroup>
										
										</f:facet>
										<div>
		          						    <h:outputText value="#{detail.locationName}" styleClass="contentform"></h:outputText> 
										</div>
									</rich:column>
									
									
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(searchIPBean.searchList)}" /> records
											</rich:column>
											<rich:column colspan="10">
													<rich:datascroller  immediate="true" rendered="true" align="right" for="ipDetailTable" page="1"   pageIndexVar="pages"  pagesVar="pages"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}" 
														style="background-color: #cccccc;"/>
										 </rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>&nbsp;
									<div style="float:right;">
									<a4j:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
								    </div>		
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
	<jsp:directive.include file="popup/IPSSR002_Popup.jsp"/>
</f:view>
</body>
</html>
