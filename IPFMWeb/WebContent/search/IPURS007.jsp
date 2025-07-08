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
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Search UR</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel>
									<table width="97%" border="0" class="thtext_detail" style="" >
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="UR No :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<h:inputText id="urNO" value="#{searchURBean.ipUrIpDetail.urNo}"   size="15"	 	 style="text-align:left"  />
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="UR Type :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<rich:comboBox id="urType" defaultLabel="" 
														enableManualInput="true" itemClass="contentform" 
														itemSelectedClass="contentform" value="#{searchURBean.urTypeComboItem}" width="160" >
													<f:attribute name="selectItems" value="#{searchURBean.urTypeList}"/>
													<f:selectItems value="#{searchURBean.urTypeList}"/>
													<a4j:support reRender="DetailForm" event="onchange" action="#{searchURAction.changeUrStatusList}" />
												</rich:comboBox>
											</td>
										</tr>
																				<tr class="inputRow">
											<td  class="labelStyle" valign="top">
												<strong><h:outputText value="Sub UR Type :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" valign="top" >
												<h:panelGrid columns="8">
										    	<h:selectBooleanCheckbox id="showFirewall" value="#{searchURBean.firewallCheck}" />
										    	<h:outputText value="Firewall" />
										    	<h:selectBooleanCheckbox id="showAccessList" value="#{searchURBean.accessListCheck}" />
										    	<h:outputText value="Access List For CDN" />
										    	<h:selectBooleanCheckbox id="showAccessListTnp" value="#{searchURBean.accessTNPCheck}"  />
										    	<h:outputText value="Access List For TNP" />
										    	<h:selectBooleanCheckbox id="showPhyInterface" value="#{searchURBean.physicalCheck}"  />
										    	<h:outputText value="Physical Interface" />
										    	<h:selectBooleanCheckbox id="showGateway" value="#{searchURBean.gatewayCheck}" />
										    	<h:outputText value="Interface Gateway" />
										    	<h:selectBooleanCheckbox id="showRouting" value="#{searchURBean.routingCheck}" />
										    	<h:outputText value="Routing" />
										    	<h:selectBooleanCheckbox id="showF5" value="#{searchURBean.f5Check}"  />
												<h:outputText value="F5" />
										    </h:panelGrid>
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="UR Status :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
									           <rich:comboBox id="urStatus" defaultLabel="" 
														enableManualInput="true" itemClass="contentform" 
														itemSelectedClass="contentform" value="#{searchURBean.urStatusComboItem}" width="160" >
													<f:attribute name="selectItems" value="#{searchURBean.urStatusList}"/>
													<f:selectItems value="#{searchURBean.urStatusList}"/>
												</rich:comboBox>

											</td>
										</tr>
										
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Subject :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" > 
												<h:inputText id="subject" value="#{searchURBean.ipUrIpDetail.subject}" style="text-align:left;width:255px;"  />
											</td>
										</tr>
										
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Project ID :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<h:inputText id="projID" value="#{searchURBean.ipUrIpDetail.projId}"   size="15"	style="text-align:left"  />
											</td>
										</tr>
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Project Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
												<h:inputText id="projName" value="#{searchURBean.ipUrIpDetail.projName}"   size="15"	 style="text-align:left;width:255px;"  />
											</td>
										</tr>
										
										<tr class="inputRow">
											<td  class="labelStyle">
												<strong><h:outputText value="Requester :"></h:outputText></strong>&nbsp;
											</td>	
									        <td align="left" >
									        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							        			<rich:comboBox id="requerter" defaultLabel=""
													enableManualInput="true"  itemClass="contentform"
													itemSelectedClass="contentform" value="#{searchURBean.requesterComboItem}" width="160">
													<f:attribute name="selectItems" value="#{searchURBean.requesterList}"/>
													<f:selectItems value="#{searchURBean.requesterList}"/>
												</rich:comboBox>
												<h:outputText value="* กรุณาเลือกรายชื่อจาก Dropdown List เท่านั้น" style="COLOR: #0000ff; font-weight:bold;" />
												</h:panelGrid>
											</td>
										</tr>

	                                  	<tr class="inputRow"> 
											<td  class="labelStyle">
												<strong><h:outputText value="Request Date From :"></h:outputText></strong>&nbsp;
											</td>
											<td colspan="3">
												<rich:calendar id="reqDate" value="#{searchURBean.ipUrIpDetail.reqDate}"
								                        locale="en/US"
								                        popup="true"
								                        datePattern="dd/MM/yyyy"
								                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
								                        inputStyle="background-color:white"
								                        inputSize="15"
								                        direction="auto"/>
											&nbsp;<strong><h:outputText value="To :"></h:outputText></strong>&nbsp;
												 <rich:calendar id="reqDateTo" value="#{searchURBean.ipUrIpDetail.reqDateTo}"
								                        locale="en/US"
								                        popup="true"
								                        datePattern="dd/MM/yyyy"
								                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
								                        inputStyle="background-color:white"
								                        inputSize="15"
								                        direction="auto"/>
											</td>	
	                                  	</tr>
	                                  	<tr class="inputRow"> 
											<td  class="labelStyle">
												<strong><h:outputText value="SLA Status :"></h:outputText></strong>&nbsp;
											</td>
											<td colspan="3">
												<h:selectOneRadio
													id="booleanValue" styleClass="contentform" 
													value="#{searchURBean.ipUrIpDetail.overSla}">
													<f:selectItem itemLabel="All" itemValue="1"  />
													<f:selectItem itemLabel="Over SLA" itemValue="2" />
												</h:selectOneRadio>
											</td>	
	                                  	</tr>
	                                  	
	                                  	<tr class="inputRow"> 
											<td  class="labelStyle">
												<strong><h:outputText value="Host Name :"></h:outputText></strong>&nbsp;
											</td>
											<td colspan="3">
												<h:inputText id="hostName" value="#{searchURBean.ipUrIpDetail.hostName}"   size="15"	style="text-align:left"  />
											</td>	
	                                  	</tr>
	                                  	<tr class="inputRow">
												<td class="labelStyle" ><strong><h:outputText value="Source IP Address :"></h:outputText></strong>&nbsp;</td>	
										        <td  colspan="3">
											        <table>
											        	<tr class="inputRow">
											        		<td width="320px">
													        		<h:panelGrid id="rangeIpGroup" columns="17" cellpadding="0" cellspacing="0" border="0" >
															   				<h:inputText id="stIp1" value="#{searchURBean.ipInfo.stIp1}" 
																				size="1" style="text-align:center" maxlength="3" 
															   					onkeypress="return numbersonlyNoDot(event);"
																		 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIp2',this,event,0,255,'190')"
																				onblur="this.value = isNumber(this);" />
																			&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
									                                        <h:inputText id="stIp2" value="#{searchURBean.ipInfo.stIp2}" 
																 				size="1" style="text-align:center" maxlength="3"  
															   					onkeypress="return numbersonlyNoDot(event);"
																		 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIp3',this,event,0,255,'190')"
																			 	onblur="this.value = isNumber(this);" />
																			&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
						                                        			<h:inputText id="stIp3" value="#{searchURBean.ipInfo.stIp3}"  
																 				size="1" style="text-align:center" maxlength="3"  
															   					onkeypress="return numbersonlyNoDot(event);"
																		 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIp4',this,event,0,255,'190')"
																			 	onblur="this.value = isNumber(this);" />
																			&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
																			<h:inputText id="stIp4" value="#{searchURBean.ipInfo.stIp4}"  
																 				size="1" style="text-align:center" maxlength="3"  
															   					onkeypress="return numbersonlyNoDot(event);"
																		 		onkeyup="return keyRangeNumberWithDot('DetailForm:edIp1',this,event,0,255,'191')"											 				
																			 	onblur="this.value = isNumber(this);" />
																			
																			&nbsp;<h:outputText value=" - " style="font-weight: bolder;" />&nbsp;
																			<h:inputText id="edIp1" value="#{searchURBean.ipInfo.stIp4To}" 
																			 	size="1" style="text-align:center" maxlength="3"  
																			 	onkeypress="return numbersonlyNoDot(event);"
																			 	onblur="this.value = isNumber(this);" />
																	</h:panelGrid>										        											        		
											        		</td>
											        		<td class="labelStyle" ><strong><h:outputText value="Destination IP Address :"></h:outputText></strong>&nbsp;</td>	
													        <td>
																<h:panelGrid id="rangeIpGroupTo" columns="17" cellpadding="0" cellspacing="0" border="0" >
													   				<h:inputText id="stIpTo1" value="#{searchURBean.ipInfoTo.stIp1}" 
																		size="1" style="text-align:center" maxlength="3" 
													   					onkeypress="return numbersonlyNoDot(event);"
																 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIpTo2',this,event,0,255,'190')"
																		onblur="this.value = isNumber(this);" />
																	&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
							                                        <h:inputText id="stIpTo2" value="#{searchURBean.ipInfoTo.stIp2}" 
														 				size="1" style="text-align:center" maxlength="3"  
													   					onkeypress="return numbersonlyNoDot(event);"
																 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIpTo3',this,event,0,255,'190')"
																	 	onblur="this.value = isNumber(this);" />
																	&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
				                                        			<h:inputText id="stIpTo3" value="#{searchURBean.ipInfoTo.stIp3}"  
														 				size="1" style="text-align:center" maxlength="3"  
													   					onkeypress="return numbersonlyNoDot(event);"
																 		onkeyup="return keyRangeNumberWithDot('DetailForm:stIpTo4',this,event,0,255,'190')"
																	 	onblur="this.value = isNumber(this);" />
																	&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
																	<h:inputText id="stIpTo4" value="#{searchURBean.ipInfoTo.stIp4}"  
														 				size="1" style="text-align:center" maxlength="3"  
													   					onkeypress="return numbersonlyNoDot(event);"
																 		onkeyup="return keyRangeNumberWithDot('DetailForm:edIpTo1',this,event,0,255,'191')"											 				
																	 	onblur="this.value = isNumber(this);" />
																	
																	&nbsp;<h:outputText value=" - " style="font-weight: bolder;" />&nbsp;
																	<h:inputText id="edIpTo1" value="#{searchURBean.ipInfoTo.stIp4To}" 
																	 	size="1" style="text-align:center" maxlength="3"  
																	 	onkeypress="return numbersonlyNoDot(event);"
																	 	onblur="this.value = isNumber(this);" />
																</h:panelGrid>																													
															</td>										        		
											        	</tr>
											        </table>																																										
												</td>		
												
																								
	                                  	</tr>
	                                  	<tr class="inputRow"> 
											<td  class="labelStyle">
												<strong><h:outputText value="Source Nat IP :"></h:outputText></strong>&nbsp;
											</td>
		 									<td  colspan="3">
											        <table>
											        	<tr class="inputRow">	
												        	<td width="320px">
																<h:inputText id="natIP" value="#{searchURBean.ipUrIpDetail.natIP}"   size="15"	style="text-align:left"  />
															</td>	
															<td  class="labelStyle">
																<strong><h:outputText value="Destination Nat IP :"></h:outputText></strong>&nbsp;
															</td>
															<td>
																<h:inputText id="natIPTo" value="#{searchURBean.ipUrIpDetail.natIPTo}"   size="15"	style="text-align:left"  />
															</td>
											        	</tr>
											        </table>
											</td>								
											
											
											
											
	                                  	</tr>
	                                   <tr>
	                                      <td  colspan="4" align="left">
	                                      	<a4j:commandButton  id="btnQuery" value="Search" styleClass="rich-button"
	                                      		action="#{searchURAction.search}"
												reRender="errorMsg,searchURTable">
											</a4j:commandButton>&nbsp;&nbsp;
											<a4j:commandButton id="btnReset" value="Reset" action="#{searchURAction.reset}" styleClass="rich-button"
												reRender="DetailForm,searchURTable"/>&nbsp;
											<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#urNO,#urType,#urStatus,#subject,#projID,#projName,#requerter,#reqDate,#reqDateTo"/>		
											</td>	
	                                   </tr>                                                    
									</table>
								</rich:panel>
								<rich:spacer height="5" />	
								
							<rich:simpleTogglePanel switchType="client" id="groupSearchResult"  label="Search Result" opened="true" >
								 <rich:panel>
										<rich:dataTable width="100%" id="searchURTable" cellpadding="1" cellspacing="0" border="0"
										reRender="scrollSystemParameterTable" 
										 
										rowClasses="odd,even"  rows="#{ipfmConfigBean.rowPerPage}"
										styleClass="contentform" rowKeyVar="index"  
										headerClass="tableHeader"
										value="#{searchURBean.searchList}" var="result">
																	
										<rich:column  filterValue="#{searchURBean.filterIP007.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(result.urNo,searchURBean.filterIP007.filterColumn5)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{searchURBean.sortIP007.sortColumn5}" sortBy="#{result.urNo}" width="13%" style="vertical-align:top;">
											<f:facet name="header" >												
												<h:panelGroup>
		 <h:commandLink rendered="true" action="#{searchURAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>UR No.</strong></span>
				<f:param name="sortColumn" value="#{searchURBean.sortIP007.sortColumn5}" />
				<f:param name="sortColumnNo" value="5" />
				<f:param name="TablSort" value="searchURTable" />
		  </h:commandLink>
		 <h:inputText value="#{searchURBean.filterIP007.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchURTable" />
		 </h:inputText>
		 	</h:panelGroup>
		 
											</f:facet>
											<div align="center" >
											    <h:graphicImage value="../images/ico_sla.gif" style="border:0"  rendered="#{result.overSla=='Y'}" /><rich:spacer width="2"/>
											    <h:commandLink value="#{result.urNo}" action="#{searchURAction.navigation}" styleClass="contentform">
						                          <f:param name="URNo" value="#{result.urNo}" />
						                          <f:param name="MODE" value="VIEW" />
						                          <f:param name="FuncID" value="#{result.funcId}"/>
					                            </h:commandLink>
											</div>
										</rich:column>
										
										<rich:column sortOrder="#{searchURBean.sortIP007.sortColumn6}" sortBy="#{result.urType}"   width="15%" style="vertical-align:top;">
											<f:facet name="header">
												<h:outputText value="UR Type" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="left">
												<h:outputText value="Request Network Config"  styleClass="contentform" rendered="#{result.urType=='NC'}" />
												<h:outputText value="Planning Request IP"  styleClass="contentform" rendered="#{result.urType=='IP12'}" />
												<h:outputText value="User Request IP"  styleClass="contentform" rendered="#{result.urType=='IP23'}" />
											</div>
										</rich:column>
										
										<rich:column  selfSorted="false"   sortOrder="#{searchURBean.sortIP007.sortColumn1}" sortBy="#{result.subjectDisp}"  filterValue="#{searchURBean.filterIP007.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(result.subjectDisp,searchURBean.filterIP007.filterColumn1)}"  width="24%" style="vertical-align:top;">
											<f:facet name="header">												
												   <h:panelGroup>
		  <h:commandLink rendered="true" action="#{searchURAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Subject</strong></span>
				<f:param name="sortColumn" value="#{searchURBean.sortIP007.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="searchURTable" />
		  </h:commandLink>
		 <h:inputText value="#{searchURBean.filterIP007.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchURTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
												<h:outputText value="#{result.subjectDisp}" escape="false" styleClass="contentform"/>
												<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-right" mode="client" styleClass="tooltip" layout="block">
							     					<h:outputText value="#{result.subjectDesc}" escape="false"/>
							    				</rich:toolTip>
											</div>
										</rich:column>
										
										<rich:column selfSorted="false"  sortOrder="#{searchURBean.sortIP007.sortColumn2}" sortBy="#{result.urStatusName}"   filterValue="#{searchURBean.filterIP007.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(result.urStatusName,searchURBean.filterIP007.filterColumn2)}"   width="17%" style="vertical-align:top;">
											<f:facet name="header">
												
												 <h:panelGroup>
		   <h:commandLink rendered="true" action="#{searchURAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>UR Status</strong></span>
				<f:param name="sortColumn" value="#{searchURBean.sortIP007.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="searchURTable" />
		  </h:commandLink>
		 <h:inputText value="#{searchURBean.filterIP007.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchURTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
												<h:outputText value="#{result.urStatusName}" styleClass="contentform"/>
											</div>
										</rich:column>
										
										<rich:column  selfSorted="false"  sortOrder="#{searchURBean.sortIP007.sortColumn3}" sortBy="#{result.reqName}"  filterValue="#{searchURBean.filterIP007.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(result.reqName,searchURBean.filterIP007.filterColumn3)}" width="12%" style="vertical-align:top;">
											<f:facet name="header">
												
												 <h:panelGroup>
												   <h:commandLink rendered="true" action="#{searchURAction.indexSort}">
													 <span class="contentform tableHeaderText">
														<strong>Request By</strong></span>
														<f:param name="sortColumn" value="#{searchURBean.sortIP007.sortColumn3}" />
														<f:param name="sortColumnNo" value="3" />
														<f:param name="TablSort" value="searchURTable" />
												  </h:commandLink>
												 <h:inputText value="#{searchURBean.filterIP007.filterColumn3}" style="width: 50px;">
													 <a4j:support event="onblur" reRender="searchURTable" />
												 </h:inputText>
											 </h:panelGroup>
											</f:facet>
											<div align="left">
												<h:outputText value="#{result.reqName}"  styleClass="contentform"/>
											</div>
										</rich:column>
										
										<rich:column width="10%" style="vertical-align:top;"  sortOrder="#{searchURBean.sortIP007.sortColumn4}" sortBy="#{result.reqDate}"  >
											<f:facet name="header">
												<h:outputText value="Request Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
												<h:outputText value="#{result.reqDate}" styleClass="contentform">
											     	<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column width="10%" style="vertical-align:top;" >
											<f:facet name="header">
												<h:outputText value="IP Info" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
												<a4j:commandButton value="View" rendered="#{result.urStatus=='CLOSE' and (result.urType=='IP23' or result.urType=='IP12')}" styleClass="rich-button" action="#{searchURAction.getIpInfo}" 
													reRender="ipInfoDialog">
													<f:param name="URNo" value="#{result.urNo}" />
													<f:param name="urType" value="#{result.urType}"/>
													<rich:componentControl for="ipInfoDialog" operation="#{errorMessages ? '' : 'show'}" event="oncomplete" />
												</a4j:commandButton>
											</div>
										</rich:column>
										
										
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="3">
													Total : <h:outputText value="#{ fn:length(searchURBean.searchList) }" /> records
												</rich:column>
												<rich:column colspan="10">
													<rich:datascroller immediate="true" rendered="true" align="right" for="searchURTable"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}" 
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>
											
																						
										</f:facet>
									</rich:dataTable>&nbsp;		
									<div style="float:right;">
									<a4j:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomeSearchURAction}" />
								    </div>										
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
	
	<rich:modalPanel id="ipInfoDialog" width="650" minHeight="400" style="overflow: auto;">			
			<f:facet name="header">
				<h:outputText value="IP Info"  />
			</f:facet>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
                    </td>
                </tr>
                <tr>
                	<td width="100%">
						<h:panelGroup id="groupDataTable">
							<rich:dataTable width="100%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0" rendered="#{fn:length(searchURBean.ipUrIpResultList) > 0}"
								
								var="detail" value="#{searchURBean.ipUrIpResultList}"  
								styleClass="contentform"  rowClasses="odd,even"
								rowKeyVar="rowIndex"  headerClass="tableHeader">
									<rich:column width="5%" style="vertical-align:top;">
										<f:facet name="header">
											<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						   <h:outputText value="#{rowIndex+1}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>			 						
									<rich:column width="70%" style="vertical-align:top;"  >
										<f:facet name="header">
											<h:panelGroup>
													 <span class="contentform tableHeaderText">
														<strong>IP Address</strong></span>
											 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.level2Start} - #{detail.level2End}" styleClass="contentform" rendered="#{searchURBean.urType=='IP23'}"></h:outputText>
											<h:outputText value="#{detail.level1Start} - #{detail.level1End}" styleClass="contentform" rendered="#{searchURBean.urType=='IP12'}"></h:outputText>
										</div>
									</rich:column>
									
									<rich:column width="85px;" style="vertical-align:top;" >
										<f:facet name="header">
											<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
			          					    <h:outputText value="#{detail.effectiveDate}" styleClass="contentform">
			          					    	<f:convertDateTime pattern="dd/MM/yyyy" />
			          					    </h:outputText>
										</div>
									</rich:column>
									<rich:column width="85px;" style="vertical-align:top;" > 
										<f:facet name="header">
											<h:outputText value="Expire Date" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          					     	<h:outputText value="#{detail.expireDate}" styleClass="contentform">
			          					    	<f:convertDateTime pattern="dd/MM/yyyy" />
			          					    </h:outputText>
										</div>
									</rich:column>
									<f:facet name="footer">
	                                    <rich:columnGroup>
											<rich:column colspan="5">
												<h:panelGroup style="float:left;">
													Total : <h:outputText value="#{fn:length(searchURBean.ipUrIpResultList)}" /> records
												</h:panelGroup>
												<h:panelGroup style="float:right;">
													
												</h:panelGroup>
											</rich:column>	
										</rich:columnGroup>										
									</f:facet>
								</rich:dataTable>
							</h:panelGroup>
					</td>
				</tr>
				<tr>
					<td>
					</td>
				</tr>
				<tr>
					<td align="right">
						<a4j:commandButton value="Close" styleClass="rich-button" immediate="true" style="width:70px;" ajaxSingle="true" status="#{rich:component('wait')}.hide();"> 
						    <rich:componentControl for="ipInfoDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</td>
				</tr>
			</table>	
	</rich:modalPanel>
	
<%-- 	<a4j:jsFunction name="goToPage" action="#{headMenuAction.perform}" > --%>
<%--     	<a4j:actionparam name="param1" assignTo="#{headMenuAction.actionName}"  /> --%>
<%--     	<a4j:actionparam name="param2" assignTo="#{headMenuAction.programID}"  />                   --%>
<%--     </a4j:jsFunction> --%>
</f:view>
</body>
</html>
