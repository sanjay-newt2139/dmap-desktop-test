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
								class="style9">Master Table Management</span></strong></td>
						</tr>
						<tr>
							<td>
								<a4j:form id="CriteriaForm">
								 <rich:panel id="groupSearchCriteria" >	
									<table width="97%" border="0" cellpadding="0" cellspacing="0"
										class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right"><strong>Referance Table<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
											<td align="left" >
                                                 <rich:comboBox id="referTable" defaultLabel="Select some value" enableManualInput="false"  
													styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform"
													value="#{masterTableBean.refTable}" >
													<f:selectItems value="#{masterTableBean.refTableList}" />
													<a4j:support reRender="groupSearchCriteria" event="onchange" action="#{masterTableAction.changeRefKey}" />
												 </rich:comboBox>
											</td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="referTable" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Referance Key<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
												 <rich:comboBox id="referKey" defaultLabel="Please select value" 
											       enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											       value="#{masterTableBean.refKeyComboItem}" width="150">
											       <f:attribute name="selectItems" value="#{masterTableBean.refKeyList}"/>
											     <f:selectItems value="#{masterTableBean.refKeyList}"/>
										</rich:comboBox>
										   </td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="referKey" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Description<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="description" value="#{masterTableBean.refDesc}" size="50" style="text-align:cente"></h:inputText>&nbsp;  	
										   </td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Short Description&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="shortDesc" value="#{masterTableBean.shortDesc}" size="50" style="text-align:cente"></h:inputText>&nbsp;	
										   </td>
										</tr>
										<tr><td height="10"></td></tr>
										<tr>
										   <td></td>
										   <td align="left">
										      <a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{masterTableAction.search}" reRender="masterTable"/>&nbsp;
										      <a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button" action="#{masterTableAction.cancel}"  reRender="CriteriaForm"/>&nbsp;
										      <a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" action="#{masterTableAction.initAdd}" reRender="CriteriaForm,errorMsg,masterTable"/>&nbsp;
										  </td>
										</tr>
									</table>
                                  </rich:panel>	
									<rich:spacer height="10" />
									
									<rich:panel>	
									    								    
										<rich:dataTable width="95%" id="masterTable" cellpadding="1" cellspacing="0" border="0"
											var="masterTbl" value="#{masterTableBean.masterTBLList}" reRender="scrollMasterTable" rows="10"
											  
											 
											rowClasses="odd,even" 
											styleClass="contentform" rowKeyVar="index" 
											headerClass="tableHeader">
												<rich:column width="3%">
													<f:facet name="header">
														<h:outputText value="Edit" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
                                                          <a4j:commandButton id="btnUpd" value="Update" 
															image="../images/p_edit.gif" style="height: 15; width: 15" 
															action="#{masterTableAction.initUpdate}">
															<a4j:actionparam name="rowId" value="#{masterTbl.rowId}"/>
						          						</a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column width="3%">
													<f:facet name="header">
														<h:outputText value="Delete" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
														<a4j:commandButton id="btnDel" value="Delete" 
															image="../images/p_delete.gif" style="height: 15; width: 15"
															action="#{masterTableAction.updateValueBeforeDelete}"
															oncomplete="#{rich:component('confirmDialog')}.show();">
															<a4j:actionparam name="rowId" value="#{masterTbl.rowId}"/>
						          						</a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{masterTableBean.filter013.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.refTable,masterTableBean.filter013.filterColumn1)}"   width="7%">
													<f:facet name="header">													
														    <h:panelGroup>
			<h:outputText value="Referance Table" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter013.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                      <h:outputText value="#{masterTbl.refTable}" styleClass="contentform" />
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{masterTableBean.filter013.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.refKey,masterTableBean.filter013.filterColumn2)}"   width="7%">
													<f:facet name="header">
													
														    <h:panelGroup>
				<h:outputText value="Referance Key" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter013.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                    <h:outputText value="#{masterTbl.refKey}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{masterTableBean.filter013.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.refDesc,masterTableBean.filter013.filterColumn3)}"   width="15%">
													<f:facet name="header">
												
														    <h:panelGroup>
			<h:outputText value="Description" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter013.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                    <h:outputText value="#{masterTbl.refDesc}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{masterTableBean.filter013.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.shortDesc,masterTableBean.filter013.filterColumn4)}"   width="10%">
													<f:facet name="header">
												
														 <h:panelGroup>
				<h:outputText value="Short Description" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter013.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                    <h:outputText value="#{masterTbl.shortDesc}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{masterTableBean.filter013.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.createdBy,masterTableBean.filter013.filterColumn5)}"   width="7%">
													<f:facet name="header">
													
														 <h:panelGroup>
					<h:outputText value="Create By" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter013.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                   <h:outputText value="#{masterTbl.createdBy}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column width="10%">
													<f:facet name="header">
														<h:outputText value="Create Date" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
														 <h:outputText value="#{masterTbl.created}" styleClass="contentform" >
														   <f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
														 </h:outputText>
				          							</div>
												</rich:column>	
												<rich:column  filterValue="#{masterTableBean.filter013.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.lastUpdBy,masterTableBean.filter013.filterColumn6)}"   width="7%">
													<f:facet name="header">													
														 <h:panelGroup>
				<h:outputText value="Update By" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter013.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
														<h:outputText value="#{masterTbl.lastUpdBy}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<rich:column width="10%">
													<f:facet name="header">
														<h:outputText value="Update Date" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
														<h:outputText value="#{masterTbl.lastUpd}" styleClass="contentform" >
														<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
														</h:outputText>
														
				          							</div>
												</rich:column>	
											<f:facet name="footer">
												<rich:columnGroup>
													<rich:column colspan="2">
														Total : <h:outputText value="#{ fn:length(masterTableBean.masterTBLList) }" /> records
													</rich:column>
													<rich:column colspan="8">
														<rich:datascroller immediate="true" rendered="true" align="right" for="masterTable"
															maxPages="#{masterTableBean.maxPage}" id="scrollMasterTable" selectedStyleClass="selectScroll"
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
							<h:outputText value="Do you want to delete this Range Row?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{masterTableAction.delete}" reRender="masterTable" >
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
