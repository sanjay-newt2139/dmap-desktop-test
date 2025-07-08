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
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<table width="97%" border="0" cellpadding="1" cellspacing="1"
						bgcolor="#CCCCCC" class="thtext_detail2">
						<tr>
							<td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Parameter Management</span></strong></td>
						</tr>
						<tr>
							<td>
								<a4j:form id="CriteriaForm" >
								 <rich:panel id="groupSearchCriteria" >	
									<table width="97%" border="0" cellpadding="0" cellspacing="0"
										class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right"><strong>Parameter Group<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
											<td align="left" >	
											   <rich:comboBox id="group" defaultLabel="Select some value" enableManualInput="false"  
													styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform"
													value="#{parameterManageBean.group}" >
													<f:selectItems value="#{parameterManageBean.groupList}" />
													<a4j:support reRender="groupSearchCriteria" event="onchange" action="#{parameterManageAction.changeGroup}" />
												</rich:comboBox>
											</td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="group" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Parameter Subgroup<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
												<rich:comboBox id="subGroup" defaultLabel="Select some value" enableManualInput="false" 
													styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform" 
													value="#{parameterManageBean.subGroup}" >
													<f:selectItems value="#{parameterManageBean.subGroupList}"/>
												</rich:comboBox>
										   </td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="subGroup" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>String Value&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="stringValue" value="#{parameterManageBean.stringValue}" maxlength="100" ></h:inputText>  	
										   </td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Numeric Value&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="numericValue" value="#{parameterManageBean.numericValue}" maxlength="6" style="text-align:right" onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                                  onchange="numberformat.formatDecimalObject(this)">
										</h:inputText>	
										   </td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Boolean Value&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
												<h:selectOneRadio id="booleanValue" styleClass="contentform" value="#{parameterManageBean.booleanValue}">
													<f:selectItem itemLabel="True" itemValue="T" />
													<f:selectItem itemLabel="False" itemValue="F" />
												</h:selectOneRadio>
										   </td>
										</tr>										
										<tr><td height="10"></td></tr>
										<tr>
										   <td></td>
										   <td align="left">
										      <a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{parameterManageAction.search}" reRender="systemParameterTable" />&nbsp;
										      <a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button" action="#{parameterManageAction.cancel}"  reRender="CriteriaForm"/>&nbsp;
										      <a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" action="#{parameterManageAction.initAdd}"  reRender="CriteriaForm,errorMsg,systemParameterTable"/>&nbsp;
										  </td>
										</tr>
									</table>
                                  </rich:panel>	
									<rich:spacer height="10" />
									
									<rich:panel>						    
										<rich:dataTable width="95%" id="systemParameterTable" cellpadding="1" cellspacing="0" border="0" 
											var="ipParameter" value="#{parameterManageBean.ipParameterList}"  reRender="scrollSystemParameterTable" rows="10"
											  
											 
											rowClasses="odd,even" 
											styleClass="contentform" rowKeyVar="index" 
											headerClass="tableHeader">
												<rich:column width="5%">
													<f:facet name="header">
														<h:outputText value="Edit" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
                                                          <a4j:commandButton id="btnUpd" value="Update" 
															image="../images/p_edit.gif" style="height: 15; width: 15" 
															action="#{parameterManageAction.initUpdate}">
															<a4j:actionparam name="rowId" value="#{ipParameter.rowId}"/>
						          						</a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column width="5%">
													<f:facet name="header">
														<h:outputText value="Delete" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
														<a4j:commandButton id="btnDel" value="Delete" 
															image="../images/p_delete.gif" style="height: 15; width: 15"
															action="#{parameterManageAction.updateValueBeforeDelete}"
															oncomplete="#{rich:component('confirmDialog')}.show();">
															<a4j:actionparam name="rowId" value="#{ipParameter.rowId}"/>
						          						</a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{parameterManageBean.filterIpUrs014.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.parameterGroup,parameterManageBean.filterIpUrs014.filterColumn1)}"   width="7%"   selfSorted="false" sortOrder="#{parameterManageBean.sortIpUrs014.sortColumn1}" sortBy="#{ipParameter.parameterGroup}" >
													<f:facet name="header" >													
														    <h:panelGroup>
		 	  <h:commandLink rendered="true" action="#{parameterManageAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Parameter Group</strong></span>
				<f:param name="sortColumn" value="#{parameterManageBean.sortIpUrs014.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="systemParameterTable" />
		  </h:commandLink>
		 <h:inputText value="#{parameterManageBean.filterIpUrs014.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                    								<h:outputText value="#{ipParameter.parameterGroup}" styleClass="contentform" />
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{parameterManageBean.filterIpUrs014.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.parameterSubGroup,parameterManageBean.filterIpUrs014.filterColumn2)}"   width="10%"  selfSorted="false" sortOrder="#{parameterManageBean.sortIpUrs014.sortColumn2}" sortBy="#{ipParameter.parameterSubGroup}">
													<f:facet name="header">														
														<h:panelGroup>
		 	<h:commandLink rendered="true" action="#{parameterManageAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Parameter Subgroup</strong></span>
				<f:param name="sortColumn" value="#{parameterManageBean.sortIpUrs014.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="systemParameterTable" />
		  </h:commandLink>
		 <h:inputText value="#{parameterManageBean.filterIpUrs014.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
														<h:outputText value="#{ipParameter.parameterSubGroup}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{parameterManageBean.filterIpUrs014.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.stringValue,parameterManageBean.filterIpUrs014.filterColumn3)}"   width="10%">
													<f:facet name="header">														
														<h:panelGroup>
		 	<h:outputText value="String Value" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{parameterManageBean.filterIpUrs014.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                       <h:outputText value="#{ipParameter.stringValue}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{parameterManageBean.filterIpUrs014.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.numericValue,parameterManageBean.filterIpUrs014.filterColumn4)}"   width="10%">
													<f:facet name="header">														
														<h:panelGroup>
		 	<h:outputText value="Numeric Value" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{parameterManageBean.filterIpUrs014.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
														<h:outputText value="#{ipParameter.numericValue}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{parameterManageBean.filterIpUrs014.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.realBooleanValue,parameterManageBean.filterIpUrs014.filterColumn5)}"   width="10%">
													<f:facet name="header">														
														<h:panelGroup>
		 	<h:outputText value="Boolean Value" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{parameterManageBean.filterIpUrs014.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
											            <h:outputText value="#{ipParameter.realBooleanValue}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{parameterManageBean.filterIpUrs014.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.createdBy,parameterManageBean.filterIpUrs014.filterColumn6)}"   width="7%">
													<f:facet name="header">														
														<h:panelGroup>
		 	<h:outputText value="Create By" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{parameterManageBean.filterIpUrs014.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                   <h:outputText value="#{ipParameter.createdBy}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column width="10%">
													<f:facet name="header">
														<h:outputText value="Create Date" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
	                                                <h:outputText value="#{ipParameter.created}" styleClass="contentform">
	                                                	<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
	                                                </h:outputText>
				          							</div>
												</rich:column>	
												<rich:column width="7%">
													<f:facet name="header">
														<h:outputText value="Update By" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
			                                         <h:outputText value="#{ipParameter.lastUpdBy}" styleClass="contentform" >
			                                         </h:outputText>
				          							</div>
												</rich:column>
												<rich:column width="10%">
													<f:facet name="header">
														<h:outputText value="Update Date" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
	                                 					 <h:outputText value="#{ipParameter.lastUpd}" styleClass="contentform">
	                                 					 	<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
	                                 					 </h:outputText>
				          							</div>
												</rich:column>														
												
											<f:facet name="footer">
												<rich:columnGroup>
													<rich:column colspan="3">
														Total : <h:outputText value="#{ fn:length(parameterManageBean.ipParameterList) }" /> records
													</rich:column>
													<rich:column colspan="8">
														<rich:datascroller immediate="true" rendered="true" align="right" for="systemParameterTable"
															maxPages="#{parameterManageBean.maxPage}" id="scrollSystemParameterTable" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="hide" boundaryControls="hide" 
															style="background-color: #cccccc;"/>
													</rich:column>
												</rich:columnGroup>
										  </f:facet>
											</rich:dataTable>	
										</rich:panel>											
									</a4j:form>
								</td>
							</tr>
						</table>
						<br>
						<br>
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
						<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
							<h:outputText value="Do you want to delete this Row ?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{parameterManageAction.delete}" reRender="systemParameterTable" >
								<rich:componentControl for="confirmDialog" operation="hide" event="onclick"  />
							</a4j:commandButton>												
							<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
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
