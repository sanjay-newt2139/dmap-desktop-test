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
<script type="text/javascript">
	history.forward();
</script>
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
		<jsp:include page="../../home/menu.jsp" />					
	</f:subview>
	<f:subview id="error">
					<jsp:include page="../../home/errorModal.jsp" />
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
											<h:inputText id="teamName" value="#{teamManageBean.ipTeam.teamName}" size="40"/>
											<rich:spacer width="20" />												
											<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{teamManageAction.search}" reRender="panelGrop,groupSearchResult" />
											<rich:spacer width="10"></rich:spacer>
											<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{teamManageAction.clear}" reRender="panelGrop,groupSearchResult"/>
											<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#teamName"/>
										</td>														
                                  </tr>                                     
								</table>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0" 
										var="detail" value="#{teamManageBean.searchList}" reRender="scrollIPDetailTable" 
										  
										 
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index"   rows="#{ipfmConfigBean.rowPerPage}"
										headerClass="tableHeader">
	
									<rich:column styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Delete" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
			          						<a4j:commandLink id="btnDel" rendered="#{detail.tier2Team!='Y' && detail.totalMember==0}"
													action="#{teamManageAction.updateValueBeforeDelete}"
													oncomplete="#{rich:component('delconfirm')}.show();">
													<h:graphicImage value="../images/contact_blue_remove.png" alt="Delete" style="height: 15; width: 15; border:none;" />
													<a4j:actionparam name="teamId" value="#{detail.teamId}"/>
				          					</a4j:commandLink>
				          					<h:graphicImage  url="../images/page_lock.gif" style="height: 15; width: 15"   rendered="#{detail.tier2Team=='Y' || detail.totalMember!=0}" ></h:graphicImage>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00201.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.teamId,teamManageBean.filter00201.filterColumn1)}"    styleClass="valignTop" >
										<f:facet name="header">											
											   <h:panelGroup>
		 <h:outputText value="Team ID" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00201.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
											 <a4j:commandLink id="urLink"  action="#{teamManageAction.init}" >
								      	            <h:outputText value="#{detail.teamId}" styleClass="contentform"></h:outputText>
								      	            <a4j:actionparam name="criteria" value="#{teamManageBean.ipTeam.teamName}"/>
								      	            <a4j:actionparam name="programIDParam" value="ISSMS002_02"/>
								      	            <a4j:actionparam name="teamId" value="#{detail.teamId}"/>
								      	            <a4j:actionparam name="teamName" value="#{detail.teamName}"/>
								      	            <a4j:actionparam name="teamDesc" value="#{detail.teamDesc}"/>
								             </a4j:commandLink>
										</div>
									</rich:column>	
									<rich:column  filterValue="#{teamManageBean.filter00201.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.teamName,teamManageBean.filter00201.filterColumn2)}"    width="20%" styleClass="valignTop" >
										<f:facet name="header">
											 <h:panelGroup>
		 <h:outputText value="Team Name" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00201.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
											 <h:outputText value="#{detail.teamName}" styleClass="contentform"/>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00201.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.teamDesc,teamManageBean.filter00201.filterColumn3)}"   width="30%"  styleClass="valignTop" >
										<f:facet name="header">											
											 <h:panelGroup>
		 <h:outputText value="Description" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00201.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
			          						<h:outputText value="#{detail.teamDesc}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00201.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.totalMember,teamManageBean.filter00201.filterColumn4)}"  width="12%" styleClass="valignTop" >
										<f:facet name="header">
											
											 <h:panelGroup>
		 <h:outputText value="No. of Member" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00201.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.totalMember}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>		
									<rich:column  filterValue="#{teamManageBean.filter00201.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.lastUpdBy,teamManageBean.filter00201.filterColumn5)}"  width="10%" styleClass="valignTop">
										<f:facet name="header">											
											 <h:panelGroup>
		 <h:outputText value="Update By" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00201.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
			          						 <h:outputText value="#{detail.lastUpdBy}" styleClass="contentform" ></h:outputText>
										</div>
									</rich:column>							
									<rich:column width="10%" styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Update Date"  escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail.lastUpd}" styleClass="contentform">
		          						     <f:convertDateTime pattern="dd/MM/yyyy"/>
		          						    </h:outputText> 
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(teamManageBean.searchList)}" /> records
											</rich:column>
											<rich:column colspan="10">
												<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
													maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
													style="background-color: #cccccc;"/>
											</rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>
								<rich:spacer height="5" />	
								<div align="right" > 
									<a4j:commandButton value="Add Team"  reRender="popupAddTeamManage"   styleClass="rich-button"  immediate="true"
									  action="#{teamManageAction.popupAddTeam}" oncomplete="#{rich:component('popupAddTeamManage')}.show(); return false" >
									</a4j:commandButton>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnCancel"  value="Cancel" styleClass="rich-button" action="#{homepageAction.gotoInitTeamManageAction}"  />								
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
		<rich:modalPanel id="delconfirm" width="350" height="120">			
		   <f:facet name="header">
			  <h:panelGroup>
				<h:outputText value="Delete UR"></h:outputText>
			  </h:panelGroup>
		   </f:facet>
		   <a4j:form id="delURConfirmDialog">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%"  style="text-align:center;">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this Team ID ?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:panelGroup>
								<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
									action="#{teamManageAction.deleteTeamId}" reRender="ipDetailTable" >
									<rich:componentControl for="delconfirm"  operation="hide" event="onclick"  />
								</a4j:commandButton>												
								<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
								    <rich:componentControl for="delconfirm" operation="hide" event="onclick" />
								</a4j:commandButton>
							</h:panelGroup>
						</h:panelGrid>
					</td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>
	<f:subview id="footer">
		<jsp:include page="../../home/progress.jsp" />
	</f:subview>	
	<jsp:directive.include file="popup/popupAddTeamManage.jsp"/>
		

</f:view>
</body>
</html>
