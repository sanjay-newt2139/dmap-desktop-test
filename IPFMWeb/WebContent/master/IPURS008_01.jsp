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
	.label {font-weight: bold;}
	.displayLabel {}
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
								class="style9">Team Management</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
																
									<tr class="inputRow">
										<td class="labelStyle">Team Name :&nbsp;</td>	
								        <td colspan="3">	
								        	<rich:spacer width="10"></rich:spacer>							   			
											<h:inputText id="teamName" value="#{teamManageBean.teamName}" size="40"/>
											<rich:spacer width="20" />												
											<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{teamManageAction.search}" reRender="panelGrop,groupSearchResult" />
											<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#teamName"/>
											<rich:spacer width="10"></rich:spacer>
											<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{teamManageAction.init}" reRender="panelGrop,groupSearchResult"/>
											
										</td>														
                                  </tr>                                     
								</table>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{teamManageBean.detailList}" reRender="scrollIPDetailTable" 
										  
										 rows="#{teamManageBean.rowPerPage}"
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
	
									<rich:column styleClass="valignTop" style="width:40px;">
										<f:facet name="header">
											<h:outputText value="Delete" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						   <a4j:commandButton id="btnUpd" image="../images/contact_blue_remove.png" style="height: 15; width: 15" >
												<a4j:actionparam name="rowId" value="#{detail[0]}"/> 
			          						</a4j:commandButton>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00801.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail[1],teamManageBean.filter00801.filterColumn1)}"  styleClass="valignTop" >
										<f:facet name="header">
											
											 <h:panelGroup>
		<h:outputText value="Team Name" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00801.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div>
											<h:commandLink value="#{detail[1]}" action="#{teamManageAction.action_gotoIPURS008_03}"></h:commandLink>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00801.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail[2],teamManageBean.filter00801.filterColumn2)}"   styleClass="valignTop" >
										<f:facet name="header">										
											<h:panelGroup>
		<h:outputText value="Description" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00801.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
	 
										</f:facet>
										<div>
			          						<h:outputText value="#{detail[2]}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00801.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail[3],teamManageBean.filter00801.filterColumn3)}"   styleClass="valignTop" >
										<f:facet name="header">											
											<h:panelGroup>
	<h:outputText value="No. of Member" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00801.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail[3]}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>							
									<rich:column styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Create Date"  escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail[4]}" styleClass="contentform"></h:outputText> 
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00801.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail[5],teamManageBean.filter00801.filterColumn4)}"  styleClass="valignTop">
										<f:facet name="header">
											<h:panelGroup>
	<h:outputText value="Create By" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00801.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div>
			          						 <h:outputText value="#{detail[5]}" styleClass="contentform" ></h:outputText>
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(teamManageBean.detailList)}" /> records
											</rich:column>
											<rich:column colspan="10">
												<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
													maxPages="#{teamManageBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{teamManageBean.fastStepPage}"
													style="background-color: #cccccc;"/>
											</rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>
								<rich:spacer height="5" />	
								<div align="right" > 
									<a4j:commandButton value="Add Team" styleClass="rich-button"  immediate="true" >
										<rich:componentControl for="popupAddTeamManage" operation="show" event="onclick" />
									</a4j:commandButton>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnCancel"  value="Cancel" styleClass="rich-button" action="#{teamManageAction.init}" />								
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
	<jsp:directive.include file="popup/popupAddTeamManage.jsp"/>	
</f:view>
</body>
</html>
