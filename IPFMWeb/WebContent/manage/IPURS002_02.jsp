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
	.rowHeight {height: 25px;}
	.label {font-weight: bold;}
	.displayLabel{}
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
								class="style9">Manage IP Level 1</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
									<tr class="inputRow">
											<td class="labelStyle" >IP Version <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
									        <td>
												<h:outputText value="#{rangeIPBean.ipRange.ipVersion}"></h:outputText>																								
											</td>
										<td class="labelStyle">IP Address <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
								        <td>
											<h:panelGrid columns="14" id="rangeIpGroup" cellpadding="0" cellspacing="0">
												<rich:spacer width="10"></rich:spacer>
								   				<h:outputText id="stIp1" value="#{rangeIPBean.ipRange.stIp1}" />
												<h:outputText value="."/>
		                                        <h:outputText id="stIp2" value="#{rangeIPBean.ipRange.stIp2}" />
												<h:outputText value="."/>
                                       			<h:outputText id="stIp3" value="#{rangeIPBean.ipRange.stIp3}" />
												<h:outputText value="."/>
												<h:outputText id="stIp4" value="#{rangeIPBean.ipRange.stIp4}" />
												<h:outputText value=" / "/>
												<h:outputText id="edIp1" value="#{rangeIPBean.ipRange.stIp5}" />
												<rich:spacer width="20" />												
												<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{rangeIPAction.search}" reRender="panelGrop,groupSearchResult" disabled="true"/>
												<rich:spacer width="5" />
												<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{rangeIPAction.init}" reRender="panelGrop,groupSearchResult"/>
											</h:panelGrid>																											
										</td>														
                                  </tr>                                     
								</table>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult" style="width:100%">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="RangeIPDataTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{rangeIPBean.ipRangeList}" reRender="scrollIPDetailTable" 
										rowClasses="odd,even" rows="#{ipfmConfigBean.rowPerPage}"
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
									
									<rich:column styleClass="valignTop" style="width:40px;">
										<f:facet name="header">
											<h:outputText value="Edit" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
											<a4j:commandButton id="btnUpd" value="Update" image="../images/p_edit.gif" style="height: 15; width: 15" action="#{rangeIPAction.action_gotoIPURS002_02}">
												<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
			          						</a4j:commandButton>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPBean.filterIpUrs0022.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.stIp1,rangeIPBean.filterIpUrs0022.filterColumn1)}"   styleClass="valignTop" sortBy="#{detail.stIp1}"  selfSorted="false" sortOrder="#{rangeIPBean.sortIpUrs0022.sortColumn1}" >
										<f:facet name="header">
											<h:panelGroup>
		 	    <h:commandLink rendered="true" action="#{rangeIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Range IP</strong></span>
				<f:param name="sortColumn" value="#{rangeIPBean.sortIpUrs0022.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="RangeIPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPBean.filterIpUrs002.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RangeIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>	
										</f:facet>
										<div align="center">
		          						   <a4j:commandLink value="#{detail.stIp1}" action="#{rangeIPAction.action_gotoIPURS002_02}" styleClass="contentform" >
		          						   		<a4j:actionparam name="rowId" value="#{detail.rowId}"/>
		          						   </a4j:commandLink>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPBean.filterIpUrs0022.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.strTotalIP,rangeIPBean.filterIpUrs0022.filterColumn2)}"   styleClass="valignTop" sortBy="#{detail.strTotalIP}"  selfSorted="false" sortOrder="#{rangeIPBean.sortIpUrs0022.sortColumn2}"  >
										<f:facet name="header">
											<h:panelGroup>
		 	    <h:commandLink rendered="true" action="#{rangeIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>TOTAL IP</strong></span>
				<f:param name="sortColumn" value="#{rangeIPBean.sortIpUrs0022.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="RangeIPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPBean.filterIpUrs002.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RangeIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>	
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detailstrTotalIP}" styleClass="contentform">
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPBean.filterIpUrs0022.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.assignToPlanning,rangeIPBean.filterIpUrs0022.filterColumn3)}"   styleClass="valignTop" sortBy="#{detail.assignToPlanning}"  selfSorted="false" sortOrder="#{rangeIPBean.sortIpUrs0022.sortColumn3}"  >
										<f:facet name="header">
										 <h:panelGroup>
		 	    <h:commandLink rendered="true" action="#{rangeIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Assign to Planning</strong></span>
				<f:param name="sortColumn" value="#{rangeIPBean.sortIpUrs0022.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="RangeIPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPBean.filterIpUrs002.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RangeIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>	
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.assignToPlanning}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPBean.filterIpUrs0022.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.assignToUser,rangeIPBean.filterIpUrs0022.filterColumn4)}"   styleClass="valignTop" sortBy="#{detail.assignToUser}"  selfSorted="false" sortOrder="#{rangeIPBean.sortIpUrs0022.sortColumn4}"  >
										<f:facet name="header">
										 <h:panelGroup>
		 	    <h:commandLink rendered="true" action="#{rangeIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Assign to user</strong></span>
				<f:param name="sortColumn" value="#{rangeIPBean.sortIpUrs0022.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="RangeIPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPBean.filterIpUrs002.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RangeIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>										
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.assignToUser}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>							
									<rich:column  filterValue="#{rangeIPBean.filterIpUrs0022.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.assignToUser,rangeIPBean.filterIpUrs0022.filterColumn5)}"   styleClass="valignTop">
										<f:facet name="header">											
											 <h:panelGroup>
		 	<h:outputText value="Reserved" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{rangeIPBean.filterIpUrs002.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RangeIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail.reserved}" styleClass="contentform"></h:outputText> 		          						    
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPBean.filterIpUrs0022.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.used,rangeIPBean.filterIpUrs0022.filterColumn6)}"   styleClass="valignTop">
										<f:facet name="header">
										
												  <h:panelGroup>
		 	<h:outputText value="Used" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{rangeIPBean.filterIpUrs002.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RangeIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.used}"styleClass="contentform" ></h:outputText>
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(rangeIPBean.ipRangeList)}" /> records
											</rich:column>
											<rich:column colspan="10">
												<rich:datascroller immediate="true" rendered="true" align="right" for="RangeIPDataTable"
													maxPages="#{ipfmConfigBean.maxPage}" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
													style="background-color: #cccccc;"/>
											</rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>&nbsp;								
								<div align="right" > 
									<a4j:commandButton  value="Cancel" styleClass="rich-button" action="#{rangeIPAction.search}" reRender="groupSearchResult" />									
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
