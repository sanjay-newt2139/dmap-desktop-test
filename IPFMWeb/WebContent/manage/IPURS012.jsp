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
								class="style9">User Group Management</span></strong></td>
						</tr>
						<tr>
							<td>
								<a4j:form id="CriteriaForm">
								 <rich:panel>	
									<table width="25%" border="0" cellpadding="1" cellspacing="1" align="center"
										class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right"><strong>Group&nbsp;:&nbsp;</strong></td>
											<td width="15%" align="left" >
												<rich:comboBox id="userGruop" defaultLabel="Please select value" 
											       enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											       value="#{userGroupManageBean.userGroupComboItem}" width="150">
											        <f:attribute name="selectItems" value="#{userGroupManageBean.userGroupList}"/>
											      <f:selectItems value="#{userGroupManageBean.userGroupList}"/>
											    </rich:comboBox>
											</td>
											<td width="15%" align="right" >
											    <a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{userGroupManageAction.search}" style=" width : 50px;" reRender="userGrupTable" />&nbsp;
											    <a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button" action="#{userGroupManageAction.cancel}" reRender="CriteriaForm,userGrupTable"  />
											</td>
										</tr>
									</table>
                                  </rich:panel>	
									<rich:spacer height="10" />
									
									<rich:panel>		
                                      <table width="97%" border="0" cellpadding="1" cellspacing="1"  bgcolor="#CCCCCC" class="thtext_detail2">
									   <tr>
                                        <td width="15%" height="25" align="right"><strong>UserId<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
									    <td width="574" align="left">
                                          <h:inputText id="userId" value="#{userGroupManageBean.userId}" size="30" style="text-align:cente"></h:inputText>&nbsp; 
                                          <a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" action="#{userGroupManageAction.createUserGroupManage}"  reRender="CriteriaForm,errorMsg,userGrupTable" />&nbsp;
									    </td>
									   </tr>
										<tr>
											<td width="15%" align="right"></td>
											<td align="left" >
                                                 <h:message for="userId" style="color:red"/>
											</td>
										</tr>
									  </table>							    
										<rich:dataTable width="95%" id="userGrupTable" cellpadding="1" cellspacing="0" border="0"
											var="userGrup" value="#{userGroupManageBean.ipGroupMemberList}" reRender="scrollUserGrupTable" rows="10"
											  
											 
											rowClasses="odd,even" 
											styleClass="contentform" rowKeyVar="index" 
											headerClass="tableHeader">
												<rich:column width="5%">
													<f:facet name="header">
														<h:outputText value="Delete" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
														<a4j:commandButton id="btnDel" value="Delete" 
															image="../images/p_delete.gif" style="height: 15; width: 15"
															action="#{userGroupManageAction.updateValueBeforeDelete}"
															oncomplete="#{rich:component('confirmDialog')}.show();">
															<a4j:actionparam name="rowId" value="#{userGrup.rowId}"/>
						          						</a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{userGroupManageBean.filterIpUrs012.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(userGrup.userId.userName,userGroupManageBean.filterIpUrs012.filterColumn1)}"   width="15%">
													<f:facet name="header">														
															  <h:panelGroup>
		 <h:outputText value="User Name" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{userGroupManageBean.filterIpUrs012.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userGrupTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                     <h:outputText value="#{userGrup.userId.userName}" styleClass="contentform" />
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{userGroupManageBean.filterIpUrs012.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(userGrup.groupId,userGroupManageBean.filterIpUrs012.filterColumn2)}"   width="15%">
													<f:facet name="header">
														 <h:panelGroup>
		 <h:outputText value="User Team" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{userGroupManageBean.filterIpUrs012.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userGrupTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                    <h:outputText value="#{userGrup.groupId}" styleClass="contentform" />
				          							</div>
												</rich:column>	
												<f:facet name="footer">
													<rich:columnGroup>
														<rich:column colspan="2">
															Total : <h:outputText value="#{ fn:length(manageDataIPBean.ipDetailList) }" /> records
														</rich:column>
														<rich:column colspan="3">
															<rich:datascroller immediate="true" rendered="true" align="right" for="userGrupTable"
																maxPages="#{manageDataIPBean.maxPage}" id="scrollUserGrupTable" selectedStyleClass="selectScroll"
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
							<h:outputText value="Do you want to delete this Row?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{userGroupManageAction.delete}" reRender="userGrupTable" >
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
