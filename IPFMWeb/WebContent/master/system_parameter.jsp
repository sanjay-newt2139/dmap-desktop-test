<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<title>IP Flow Management</title>
<link
	href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>
</head>
<body style="margin: 0 0">
<f:view>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<f:subview id="menu">
					<jsp:include page="../home/menu.jsp" />
				</f:subview>
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<table width="99%" border="0" cellspacing="0" cellpadding="0">

						<tr>
							<td height="35"><span class="ms8"><img
								src="../images/ic-pencil.png" hspace="9"><font
								class="ms8blue">Master Setup &gt;&gt;</font>&nbsp;&nbsp;<font
								class="ms8red">Parameter Setup</font></span></td>
						</tr>
					</table>
					<table width="99%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="7"><img src="../images/bg-blue-l.png"></td>
							<td height="32" background="../images/bg-blue-m.png" class="ms10w"><strong>
							IPFMMS001:Parameter Setup</strong></td>
							<td width="7" align="right"><img src="../images/bg-blue-r.png"></td>
						</tr>
					</table>
					<table width="97%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
							<jsp:include page="../home/errorModal.jsp" /> 
							<a4j:form id="CriteriaForm">
								<rich:simpleTogglePanel switchType="client"
									label="Search Criteria">
									<h:panelGrid id="groupSearchCriteria" columns="4" styleClass="contentlabelform" >
										<h:outputText value="Group :" style="font-weight: bolder;">
										</h:outputText>
										<rich:comboBox id="group" defaultLabel="Select some value" enableManualInput="false"  
											styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform"
											value="#{systemParameterBean.group}" >
											<f:selectItems value="#{systemParameterBean.groupList}" />
											<a4j:support reRender="groupSearchCriteria" event="onchange" action="#{systemParameterAction.changeGroup}" />
										</rich:comboBox>
										<h:outputText value="Sub Group :" style="font-weight: bolder;">
										</h:outputText>
										<rich:comboBox id="subGroup" defaultLabel="Select some value" enableManualInput="false" 
											styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform" 
											value="#{systemParameterBean.subGroup}" >
											<f:selectItems value="#{systemParameterBean.subGroupList}"/>
										</rich:comboBox>
									</h:panelGrid>
									<br/>
									<h:panelGrid id="groupSearchButton" columns="4" styleClass="contentlabelform" >
										<a4j:commandButton id="btnSearch" styleClass="rich-button" value="Search" action="#{systemParameterAction.search}" 
										reRender="groupSearchResult, errorMsg" /> 
										<a4j:commandButton id="btnClear" styleClass="rich-button" value="Clear" action="#{systemParameterAction.clear}" 
										reRender="groupSearchResult, groupSearchCriteria" />
										<h:commandButton id="btnAdd" styleClass="rich-button" value="Add" action="#{systemParameterAction.clickAdd}" />
										<h:commandButton id="btnImport" styleClass="rich-button" value="Import" action="#{systemParameterAction.clickImport}" />										
									</h:panelGrid>
								</rich:simpleTogglePanel>
								
								<rich:spacer height="5" />
								
								<rich:simpleTogglePanel switchType="client" id="groupSearchResult" label="Search Result" 
									opened="true" >
										<rich:dataTable width="95%" id="systemParameterTable" cellpadding="1" cellspacing="0" border="0"
									var="ipParameter" value="#{systemParameterBean.ipParameterList}" reRender="scrollSystemParameterTable" 
									rows="#{systemParameterBean.rowPerPage}"
									rowClasses="cur"
									styleClass="contentform">
										<rich:column  filterValue="#{systemParameterBean.filterSysParam.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.parameterGroup,systemParameterBean.filterSysParam.filterColumn1)}"  width="15%"  selfSorted="false" sortOrder="#{systemParameterBean.sortSys.sortColumn1}" sortBy="#{ipParameter.parameterGroup}"  >
											<f:facet name="header">
											
												    <h:panelGroup>
												     <h:commandLink rendered="true" action="#{systemParameterAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Group</strong></span>
				<f:param name="sortColumn" value="#{systemParameterBean.sortSys.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="systemParameterTable" />
		  </h:commandLink>
		 <h:inputText value="#{systemParameterBean.filterSysParam.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
												<h:outputText value="#{ipParameter.parameterGroup}" styleClass="contentform" />
											</div>
										</rich:column>

										<rich:column  filterValue="#{systemParameterBean.filterSysParam.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.parameterSubGroup,systemParameterBean.filterSysParam.filterColumn2)}"  width="15%"  selfSorted="false" sortOrder="#{systemParameterBean.sortSys.sortColumn2}" sortBy="#{ipParameter.parameterSubGroup}">
											<f:facet name="header">											
												 <h:panelGroup>
				 <h:commandLink rendered="true" action="#{systemParameterAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Sub Group</strong></span>
				<f:param name="sortColumn" value="#{systemParameterBean.sortSys.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="systemParameterTable" />
		  </h:commandLink>
		 <h:inputText value="#{systemParameterBean.filterSysParam.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
												<h:outputText value="#{ipParameter.parameterSubGroup}" styleClass="contentform" />
											</div>
										</rich:column>

										<rich:column  filterValue="#{systemParameterBean.filterSysParam.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.stringValue,systemParameterBean.filterSysParam.filterColumn3)}"   width="20%">
											<f:facet name="header">
												
												 <h:panelGroup>
				<h:outputText value="String Value" styleClass="contentform" />
		 <h:inputText value="#{systemParameterBean.filterSysParam.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
												<h:outputText value="#{ipParameter.stringValue}" styleClass="contentform" />
											</div>
										</rich:column>

										<rich:column  filterValue="#{systemParameterBean.filterSysParam.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.numericValue,systemParameterBean.filterSysParam.filterColumn4)}"   width="20%" >
											<f:facet name="header">
												<h:panelGroup>
				<h:outputText value="Numeric Value" styleClass="contentform" />
		 <h:inputText value="#{systemParameterBean.filterSysParam.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="right">
												<h:outputText value="#{ipParameter.numericValue}" styleClass="contentform" />
											</div>
										</rich:column>

										<rich:column  filterValue="#{systemParameterBean.filterSysParam.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(ipParameter.realBooleanValue,systemParameterBean.filterSysParam.filterColumn5)}"   width="20%" >
											<f:facet name="header">
												<h:panelGroup>
				<h:outputText value="Boolean Value" styleClass="contentform" />
		 <h:inputText value="#{systemParameterBean.filterSysParam.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="systemParameterTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
												<h:outputText value="#{ipParameter.realBooleanValue}" styleClass="contentform" />
											</div>
										</rich:column>

										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Action" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<a4j:commandButton id="btnUpd" value="Update" 
													image="../images/ic-pencil.png" style="height: 15; width: 15"
													action="#{systemParameterAction.initUpdate}">
													<a4j:actionparam name="rowId" value="#{ipParameter.rowId}"/>
				          						</a4j:commandButton>
												<a4j:commandButton id="btnDel" value="Delete" 
													image="../images/ico_delete.png" style="height: 15; width: 15"
													action="#{systemParameterAction.updateValueBeforeDelete}"
													oncomplete="#{rich:component('confirmDialog')}.show();">
													<a4j:actionparam name="rowId" value="#{ipParameter.rowId}"/>
				          						</a4j:commandButton>	
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:datascroller immediate="true" rendered="true" align="center" for="systemParameterTable" 
												maxPages="#{systemParameterBean.maxPage}" id="scrollSystemParameterTable" selectedStyleClass="selectScroll" />
										</f:facet>
									</rich:dataTable>												
								</rich:simpleTogglePanel>								
							</a4j:form></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>
	
	<rich:modalPanel id="confirmDialog" autosized="true">			
		<a4j:form id="delConfirmDialog">
			<table width="150px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
							<h:outputText value="Do you want to delete this parameter?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{systemParameterAction.delete}" reRender="groupSearchResult" >
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
