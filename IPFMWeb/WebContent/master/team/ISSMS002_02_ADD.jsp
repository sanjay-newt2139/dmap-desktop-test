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
	.label {font-weight: bold;}
	.displayLabel {}
	.rowHeight {height: 25px;}
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
					<table width="98%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Team Member</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >	
									<h:panelGroup style="width:100%;">
									<table width="100%" border="0" class="thtext_detail">
								
									<tr class="displayRow">
										<td class="labelStyle"><strong>Team ID : </strong>&nbsp;</td>	
								        <td width="10" >
											<rich:spacer width="10"></rich:spacer>	
							        	</td>
								        <td colspan="2">	
								        	<h:outputText value="#{teamManageBean.ipTeam.teamId}" />
										</td>														
                                  	</tr> 
									<tr class="displayRow">
										<td class="labelStyle">Team Name:&nbsp;</td>
										<td width="10" >
											<rich:spacer width="10"></rich:spacer>	
							        	</td>
								        <td colspan="2">	
								        	<h:inputText value="#{teamManageBean.ipTeam.teamName}" readonly="true" style="width:178" ></h:inputText>						   			
										</td>														
                                  	</tr> 
                                  	<tr class="displayRow">
										<td class="labelStyle">Description :&nbsp;</td>	
								        <td width="10" >
											<rich:spacer width="10"></rich:spacer>	
							        	</td>
								        <td colspan="2">					
								        	<h:inputText value="#{teamManageBean.ipTeam.teamDesc}" style="width:178" readonly="#{teamManageBean.fromOutcome=='PROFILE'}"></h:inputText>
										</td>														
                                  	</tr>  
                                  	<tr class="inputRow">
										<td class="labelStyle">User :&nbsp;</td>	
								        <td width="10" >
											<rich:spacer width="10"></rich:spacer>	
							        	</td>
								        <td colspan="2">							   			
											<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
												<rich:comboBox  defaultLabel=""
													enableManualInput="true"  itemClass="contentform"
													itemSelectedClass="contentform" value="#{teamManageBean.systemOwnerComboItem}" width="185" listWidth="180" listHeight="150">
													<f:attribute name="selectItems" value="#{teamManageBean.systemOwnerList}"/>
													<f:selectItems value="#{teamManageBean.systemOwnerList}"/>
												  </rich:comboBox>
		                                        <rich:spacer width="10"></rich:spacer>
		                                        <a4j:commandLink action="#{teamManageAction.add}" reRender="ipDetailTable,errorMsg" >
		                                        	<h:graphicImage value="../images/add1.png" alt="Add" style="border:none;" />
		                                        </a4j:commandLink>		                                       
		                                    </h:panelGrid>	
										</td>														
                                  	</tr> 
                                  	<tr>
	                                      <td  colspan="5" align="left">
	                                      	<a4j:commandButton  id="btnSave" value="Save" styleClass="rich-button"
	                                      		action="#{teamManageAction.save}" rendered="#{teamManageBean.fromOutcome!='PROFILE'}"
												reRender="DetailForm,errorMsg,groupSearchResult">
											</a4j:commandButton>&nbsp;&nbsp;
											<a4j:commandButton id="btnCancel2" value="Cancel" styleClass="rich-button" 
												action="#{teamManageAction.cancel}" rendered="#{teamManageBean.fromOutcome!='PROFILE'}"
												reRender="DetailForm,groupSearchResult" />&nbsp;
											</td>	
	                                   </tr>                                 
								</table>
								</h:panelGroup>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{teamManageBean.teamMemberList}" reRender="scrollIPDetailTable" 
										rows="#{ipfmConfigBean.rowPerPage}"
										  
										 
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
	
									<rich:column styleClass="valignTop" style="width:40px;">
										<f:facet name="header">
											<h:outputText value="Delete" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
			          						<a4j:commandLink id="btnDel" action="#{teamManageAction.updateValueBeforeDeleteMember}"
													oncomplete="#{rich:component('delconfirm')}.show();">
													<h:graphicImage value="../images/contact_blue_remove.png" alt="Delete" style="height: 15; width: 15; border:none;" />
													<a4j:actionparam name="userId" value="#{detail.userId}"/> 
				          					</a4j:commandLink>	
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00202.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.userName,teamManageBean.filter00202.filterColumn1)}"   styleClass="valignTop" >
										<f:facet name="header">											
											   <h:panelGroup>
		 <h:outputText value="User Name" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00202.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
											<h:outputText value="#{detail.userName}" escape="false" styleClass="contentform"></h:outputText>
			          					</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00202.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.dept,teamManageBean.filter00202.filterColumn2)}"   styleClass="valignTop" >
										<f:facet name="header">											
											 <h:panelGroup>
		 <h:outputText value="Department" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00202.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
			          						<h:outputText value="#{detail.dept}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{teamManageBean.filter00202.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.section,teamManageBean.filter00202.filterColumn3)}"   styleClass="valignTop" >
										<f:facet name="header">
											 <h:panelGroup>
		 <h:outputText value="Section" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00202.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
			          						<h:outputText value="#{detail.section}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>							
									<rich:column  filterValue="#{teamManageBean.filter00202.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.position,teamManageBean.filter00202.filterColumn4)}"   styleClass="valignTop">
										<f:facet name="header">
											 <h:panelGroup>
		 <h:outputText value="Position" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{teamManageBean.filter00202.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="left">
		          						    <h:outputText value="#{detail.position}" styleClass="contentform"></h:outputText> 
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(teamManageBean.teamMemberList)}" /> records
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
<!--									<a4j:commandButton value="Add User" styleClass="rich-button"  immediate="true" >-->
<!--										<rich:componentControl for="popupAddUser" operation="show" event="onclick" />-->
<!--									</a4j:commandButton>-->
<!--									<rich:spacer width="10"></rich:spacer>-->
									<a4j:commandButton id="btnCancelProfile"  value="Close" styleClass="rich-button" 
										action="#{userProfileAction.gotoUserProfile}" rendered="#{teamManageBean.fromOutcome=='PROFILE'}">
									   		
									</a4j:commandButton>
									<a4j:commandButton id="btnCancel"  value="Close" styleClass="rich-button" 
										action="#{teamManageAction.init}" rendered="#{teamManageBean.fromOutcome!='PROFILE'}">
									   <a4j:actionparam name="programIDParam" value="ISSMS002"></a4j:actionparam>	
									    <a4j:actionparam name="modeBack" value="back"></a4j:actionparam>
									   <f:setPropertyActionListener value="#{teamManageBean.criteria}" target="#{teamManageAction.teamManageBean.ipTeam.teamName}"/>
									   <f:setPropertyActionListener value="" target="#{teamManageAction.teamManageBean.systemOwnerComboItem}"/>		
									</a4j:commandButton>						
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
		<jsp:include page="../../home/progress.jsp" />
	</f:subview>	
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
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this Team ID ?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:panelGroup>
								<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
									action="#{teamManageAction.deleteMember}" reRender="ipDetailTable" >
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

</f:view>
</body>
</html>
