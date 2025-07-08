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
	.textAlignRight {text-align:right;}
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
					<td width="100%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Menu Authentication</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop">
									<h:panelGroup style="width:100%;">
										<rich:tabPanel id="tab1" switchType="ajax">
									        <rich:tab label="Menu">		
									        	<h:panelGroup style="100%">						        	
									            <table width="100%" border="0" class="thtext_detail">
									            	<tr class="inputRow">
														<td class="labelStyle"><h:outputText value="Menu Name" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
														<td class="valueStyle">
															<rich:spacer width="10"></rich:spacer>
															<h:inputText value="#{menuAuthenticationBean.ipFucntion.funcName}" size="30"></h:inputText>
														</td>
				                                  	</tr>
				                                  	<tr class="inputRow">
														<td class="labelStyle"  >
															<h:outputText value="Menu Level" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/>
														</td>	
												        <td class="valueStyle">
												        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
																<rich:spacer width="10"></rich:spacer>
																<rich:comboBox defaultLabel="" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform"
																	value="#{menuAuthenticationBean.ipFucntion.menuLevel}" width="60" >
																	<a4j:support event="onselect" action="#{menuAuthenticationAction.action_onchangeMenuLevel}" reRender="tab1"></a4j:support>
																	<f:selectItem itemLabel="0" itemValue="0"/>
																	<f:selectItem itemLabel="1" itemValue="1"/>
																</rich:comboBox>
															</h:panelGrid>																								
														</td>
														<h:panelGroup rendered="#{menuAuthenticationBean.ipFucntion.menuLevel==0}">
															<td>
																
															</td>
															<td class="valueStyle">
																
															</td>
														</h:panelGroup>	
														<h:panelGroup rendered="#{menuAuthenticationBean.ipFucntion.menuLevel==1}">
															<td class="labelStyle"  >
																<h:outputText value="Master Menu :&nbsp;" escape="false" ></h:outputText>
															</td>	
													        <td class="valueStyle">	
													        	<h:panelGrid  columns="2" cellpadding="0" cellspacing="0" >
																	<rich:spacer width="10"></rich:spacer>
																	<rich:comboBox defaultLabel="" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
																		value="" width="200">
																		<f:selectItem itemLabel="User Request" itemValue="User Request"/>
																		<f:selectItem itemLabel="Search" itemValue="Search"/>
																		<f:selectItem itemLabel="Reports" itemValue="Reports"/>
																	</rich:comboBox>
																</h:panelGrid>																						
															</td>		
														</h:panelGroup>								
				                                  	</tr>
				                                  	<tr class="inputRow">
														<td class="labelStyle"><h:outputText value="Menu Sequence" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
														<td colspan="3">
															<rich:spacer width="10"></rich:spacer>
															<h:inputText value="#{menuAuthenticationBean.ipFucntion.menuSeq}" size="2"></h:inputText>
														</td>										
				                                  	</tr>
				                                  	<tr class="inputRow">
														<td class="labelStyle"><h:outputText value="Program ID" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
														<td colspan="3">
															<rich:spacer width="10"></rich:spacer>
															<h:inputText value="#{menuAuthenticationBean.ipFucntion.programId}" size="30"></h:inputText>
														</td>								
				                                  	</tr>
				                                  	<tr class="inputRow">
														<td class="labelStyle"><h:outputText value="Program Action" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
														<td colspan="3">
															<rich:spacer width="10"></rich:spacer>
															<h:inputText value="#{menuAuthenticationBean.ipFucntion.programUrl}" size="113"></h:inputText>
														</td>									
				                                  	</tr>
				                                  	<tr>
				                                  		<td colspan="4">
					                                        <a4j:commandButton rendered="#{menuAuthenticationBean.mode == 'A'}" value="Add" styleClass="rich-button" action="#{menuAuthenticationAction.init}" />
				                                  			<a4j:commandButton rendered="#{menuAuthenticationBean.mode == 'E'}" value="Save" styleClass="rich-button" action="#{menuAuthenticationAction.init}" />
					                                        <rich:spacer width="10"></rich:spacer>
				                                  			<a4j:commandButton rendered="#{menuAuthenticationBean.mode == 'E'}" value="Cancel" styleClass="rich-button" action="#{menuAuthenticationAction.init}" />
					                                   </td>
				                                  	</tr>
				                                  	<tr>
				                                  		<td colspan="4">
					                                        <h:panelGroup style="width:100%">
																<rich:dataTable id="menuDataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
																		var="detail" value="#{menuAuthenticationBean.menuList}"
																		  
																		 
																		rowClasses="odd,even" 
																		styleClass="contentform" rowKeyVar="index" 
																		headerClass="tableHeader">
																	
																	<rich:column styleClass="valignTop" style="width:40px;">
																		<f:facet name="header">
																			<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
																		</f:facet>
																		 <div align="center">
																		  	<a4j:commandButton id="btnEdit" value="Edit" image="../images/p_edit.gif" style="height: 15; width: 15" action="#{menuAuthenticationAction.action_selectRow}" reRender="tab1">
																				<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
											          						</a4j:commandButton>
											          					</div>
																	</rich:column>
																	<rich:column styleClass="valignTop" style="width:40px;">
																		<f:facet name="header">
																			<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
																		</f:facet>
																		 <div align="center">
																		  	<a4j:commandButton id="btnDelete" value="Delete" image="../images/p_delete.gif" style="height: 15; width: 15" action="#{menuAuthenticationAction.init}">
																				<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
											          						</a4j:commandButton>
											          					</div>
																	</rich:column>
																	<rich:column  filterValue="#{menuAuthenticationBean.filterMenu.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.funcName,menuAuthenticationBean.filterMenu.filterColumn1)}"   styleClass="valignTop">
																		<f:facet name="header">
																		
																			    <h:panelGroup>
			<h:outputText value="Menu Name" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{menuAuthenticationBean.filterMenu.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="menuDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																		</f:facet>
																		<div>
										          						   <h:outputText value="#{detail.funcName}" styleClass="contentform"></h:outputText>
																		</div>
																	</rich:column>
																	<rich:column  filterValue="#{menuAuthenticationBean.filterMenu.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.menuLevel,menuAuthenticationBean.filterMenu.filterColumn2)}"   styleClass="valignTop">
																		<f:facet name="header">
																		
																		  <h:panelGroup>
				<h:outputText value="Menu Level" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{menuAuthenticationBean.filterMenu.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="menuDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																		</f:facet>
																		<div align="center">
											          						<h:outputText value="#{detail.menuLevel}" styleClass="contentform"></h:outputText>
																		</div>
																	</rich:column>
																	<rich:column  filterValue="#{menuAuthenticationBean.filterMenu.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.statusAdvance,menuAuthenticationBean.filterMenu.filterColumn3)}"   styleClass="valignTop">
																		<f:facet name="header">																			
																		  <h:panelGroup>
				<h:outputText value="Master Menu" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{menuAuthenticationBean.filterMenu.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="menuDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																		</f:facet>
																		<div>
											          						<h:outputText value="#{detail.statusAdvance}" styleClass="contentform"></h:outputText>
																		</div>
																	</rich:column>
																	<rich:column  filterValue="#{menuAuthenticationBean.filterMenu.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.menuSeq,menuAuthenticationBean.filterMenu.filterColumn4)}"   styleClass="valignTop">
																		<f:facet name="header">
																			 <h:panelGroup>
				<h:outputText value="Menu Sequence" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{menuAuthenticationBean.filterMenu.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="menuDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																		</f:facet>
																		<div align="center">
											          						<h:outputText value="#{detail.menuSeq}" styleClass="contentform"></h:outputText>
																		</div>
																	</rich:column>
																	<rich:column  filterValue="#{menuAuthenticationBean.filterMenu.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.updateBy,menuAuthenticationBean.filterMenu.filterColumn5)}"   styleClass="valignTop">
																		<f:facet name="header">																			
																			 <h:panelGroup>
				<h:outputText value="Update By" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{menuAuthenticationBean.filterMenu.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="menuDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																		</f:facet>
																		<div>
											          						<h:outputText value="#{detail.updateBy}" styleClass="contentform"></h:outputText>
																		</div>
																	</rich:column>
																	<rich:column styleClass="valignTop">
																		<f:facet name="header">
																			<h:outputText value="Update Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
																		</f:facet>
																		<div align="center">
											          						<h:outputText value="#{detail.updateDate}" styleClass="contentform">
											          							<f:convertDateTime pattern="dd/MM/yyyy"/>
											          						</h:outputText>
																		</div>
																	</rich:column>
																	<f:facet name="footer">
																		<rich:columnGroup>
																			<rich:column colspan="3">
																				Total : <h:outputText value="#{fn:length(MenuAuthenticationBean.menuList)}" /> records
																			</rich:column>
																			<rich:column colspan="10">
																				<rich:datascroller immediate="true" rendered="true" align="right" for="menuDataTable"
																					maxPages="#{menuAuthenticationBean.maxPage}" selectedStyleClass="selectScroll"
																					fastStep="#{menuAuthenticationBean.fastStepPage}"  boundaryControls="auto" fastControls="auto" stepControls="hide"
																					style="background-color: #cccccc;"
																					
																				/>
																			</rich:column>
																		</rich:columnGroup>					
																	</f:facet>										
																</rich:dataTable>
															</h:panelGroup>
				                                  		</td>
				                                  	</tr>
				                            	</table>
									        </h:panelGroup>	
									        </rich:tab>	
									        <rich:tab label="Authorize" >
									        <h:panelGroup style="width:100%;">
									           	<table width="100%" border="0" class="thtext_detail">
													<tr class="inputRow">
														<td class="labelStyle"><h:outputText value="User Role" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
														<td>
															<h:panelGrid id="roleId" columns="2" cellpadding="0" cellspacing="0" >
																<rich:spacer width="10"></rich:spacer>
																<rich:comboBox defaultLabel="" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
																	value="Requester" width="200">
																	<f:selectItem itemLabel="Requester" itemValue="Requester"/>
																	<f:selectItem itemLabel="CDN (Tier 1)" itemValue="CDN (Tier 1)"/>
																	<f:selectItem itemLabel="Planning" itemValue="Planning"/>
																</rich:comboBox>
															</h:panelGrid>	
														</td>										
				                                  	</tr>
				                                  	<tr>
														<td colspan="2">
															<h:panelGroup style="width:100%">
																<rich:dataTable id="roleDataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
																		var="detail" value="#{menuAuthenticationBean.roleList}"
																		  
																		 
																		rowClasses="odd,even inputRow" 
																		styleClass="contentform" rowKeyVar="index" 
																		headerClass="tableHeader">
																	
																	<rich:column styleClass="valignTop">
																		<f:facet name="header">
																			<h:outputText value="Menu List" styleClass="contentform tableHeaderText"></h:outputText>
																		</f:facet>
																		<h:panelGroup>
																			<rich:spacer rendered="#{detail.menuLevel == '1'}" width="15"></rich:spacer>
																			<h:outputText value="#{detail.funcName}"></h:outputText>
																		</h:panelGroup>
																	</rich:column>
																	<rich:column styleClass="valignTop" width="40px;" style="text-align:center;">
																		<f:facet name="header">
																			<h:outputText value="Enable" styleClass="contentform tableHeaderText"></h:outputText>
																		</f:facet>
																		<h:selectBooleanCheckbox value="false"></h:selectBooleanCheckbox>
																	</rich:column>
																</rich:dataTable>
															</h:panelGroup>
														</td>
				                                  	</tr>
				                            	</table>
				                            </h:panelGroup>
									        </rich:tab>
			    						</rich:tabPanel>
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
</f:view>
</body>
</html>
