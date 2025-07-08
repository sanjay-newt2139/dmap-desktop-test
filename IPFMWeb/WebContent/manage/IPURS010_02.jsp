<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>Role Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>


</head>
<body  onload="javascript:test();" style="overflow:hidden;" >

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
								class="style9">Role Management</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
					  <tr bgcolor="#BFBFBF">
					         <td>
								  <table border="0" cellpadding="0" cellspacing="0" align="left" >
									<tr>
										   <h:panelGroup id="tabGroup">
										   <td>
										  		<a4j:commandButton id="btnOwnerList" value="Authorize List " 
													image="../images/tab_Role_Auth_notactive.png" style="height: 25; width: 87" 
													action="#{roleManageAction.init}">
													<a4j:actionparam name="programIDParam" value="IPURS010_01"/>
				          						</a4j:commandButton>
				          						<a4j:commandButton id="btnIPDetail" value="Member List" 
													image="../images/tab_Role_Member_active.png" style="height: 25; width: 61" 
													action="#{roleManageAction.memberList}">
				          						</a4j:commandButton> 
			                      			 </td>
										   </h:panelGroup>
									</tr>
									<tr>
										<td height="2" colspan="8" align="center" valign="bottom"></td>
									</tr>
							  	</table>
							</td>  
					    </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right" >
												<strong><h:outputText value="Role :"></h:outputText></strong>&nbsp;
											</td>
											<td>
												<h:inputText id="role" value="" size="15"	style="text-align:cente"/> 
												&nbsp;
												 <h:graphicImage value="../images/p_zoom.gif" style="border:0" />
												&nbsp;
												<h:inputText id="roleDis" value="" size="55"	style="text-align:cente" disabled="true"/>
												&nbsp;
												<a4j:commandButton id="btnQuery" value="Query" styleClass="rich-button"
												action="#{manageDataIPAction.init}"
												reRender="groupSearchResult"/>&nbsp;
												<a4j:commandButton id="btnadd" value="Add New" styleClass="rich-button"
												reRender="DetailForm"  style="width:70px"/>&nbsp;
											</td>	
                                  </tr>
                                  <tr>
                                    <td colspan="4" >&nbsp;</td>
                                  </tr>  
								</table>
							</rich:panel>
								
								<rich:spacer height="5" />	
								
							<rich:simpleTogglePanel switchType="client" id="groupSearchResult" label="Result" opened="true" >
								 <rich:panel>
										<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td width="7%" height="25" align="left" >								    
													<h:panelGrid  id="groupActionButton1" columns="10" styleClass="contentlabelform">
													
														<a4j:commandButton id="btnSelectAll1" value="Select All" styleClass="rich-button"
															action="#{manageDataIPAction.updateIPDetail}" style="width:65px"
															disabled="#{roleManageAction.btn1}"/>			
														<a4j:commandButton id="btnDsele1" value="Deselect" styleClass="rich-button"
															action="#{manageDataIPAction.updateIPDetail}" style="width:65px"
															disabled="#{roleManageAction.btn1}" />																								
														<a4j:commandButton id="btnDel1" value="Delete" styleClass="rich-button"
															action="#{manageDataIPAction.init}" style="width:50px"
															disabled="#{roleManageAction.btn1}"/>
														<a4j:commandButton id="btnAdd1" value="Add" styleClass="rich-button"
															action="#{roleManageAction.memberAdd1}" reRender="groupActionButton1"
															disabled="#{roleManageAction.btn1}">
															<a4j:actionparam name="action" value="add"/>
															</a4j:commandButton>
															<c:if test="${roleManageAction.txt1}" >
																<h:inputText id="role2" value="" size="15"	style="text-align:cente" /> 
														 		<h:graphicImage value="../images/p_zoom.gif" style="border:0" />
																<h:inputText id="roleDis2" value="" size="40"	style="text-align:cente" disabled="true"/>
																<a4j:commandButton id="btnsave1" value="Submit" styleClass="rich-button"
																	action="#{manageDataIPAction.init}" style="width:50px"
																	/>
																<a4j:commandButton id="btncancel1" value="cancel" styleClass="rich-button"
																	action="#{roleManageAction.memberAdd1}" style="width:65px" reRender="groupActionButton1"
																	>
																	<a4j:actionparam name="action" value="cancel"/>
																	</a4j:commandButton>
															</c:if>
													</h:panelGrid>	
									          </td>
								         </tr>
								</table>	
								<rich:spacer height="5" />	
										<rich:dataTable width="95%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
									var="ipDetail" value="" reRender="scrollIPDetailTable" rows="5"
									  
									 
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
										<f:facet name="header">
										<rich:columnGroup >
											<rich:column width="5%">
											</rich:column>
											<rich:column >
												<h:outputText value="User Name" styleClass="contentform tableHeaderText"></h:outputText>
											</rich:column>
											</rich:columnGroup>
										</f:facet>
										
										<rich:column>
											<input type="checkbox" name="checkbox3" id="checkbox3">
										</rich:column>
										<rich:column>
											<h:outputText value="Mr.Jinda Setthadee" styleClass="contentform"/>
										</rich:column>
										
										<rich:column breakBefore="true">
											<input type="checkbox" name="checkbox4" id="checkbox4">
										</rich:column>
										<rich:column>
											<h:outputText value="Mr.Grokeid Fundee" styleClass="contentform"/>
										</rich:column>
										
										<rich:column breakBefore="true">
											<input type="checkbox" name="checkbox5" id="checkbox5">
										</rich:column>
										<rich:column>
											<h:outputText value="Ms.Sundee Toryod" styleClass="contentform"/>
										</rich:column>
										
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{ fn:length(manageDataIPBean.ipDetailList) }" /> records
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
														maxPages="#{manageDataIPBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="hide" boundaryControls="hide" 
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>												
								</rich:panel>
								</rich:simpleTogglePanel>	
								<rich:spacer height="5" />	
								
							<rich:simpleTogglePanel switchType="client" id="groupSearchResult2" label="Result" opened="true" >
								 <rich:panel>
										<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td width="7%" height="25" align="left" >								    
													<h:panelGrid id="groupActionButton" columns="10" styleClass="contentlabelform">
													
														<a4j:commandButton id="btnSelectAll" value="Select All" styleClass="rich-button"
															action="#{manageDataIPAction.updateIPDetail}" style="width:65px"
															disabled="#{roleManageAction.btn2}"/>			
														<a4j:commandButton id="btnDsele" value="Deselect" styleClass="rich-button"
															action="#{manageDataIPAction.updateIPDetail}" style="width:65px"
															disabled="#{roleManageAction.btn2}" />																								
														<a4j:commandButton id="btnDel" value="Delete" styleClass="rich-button"
															action="#{manageDataIPAction.init}" style="width:50px"
															disabled="#{roleManageAction.btn2}"/>
														<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button"
															action="#{roleManageAction.memberAdd2}" reRender="groupActionButton"
															disabled="#{roleManageAction.btn2}">
															<a4j:actionparam name="action" value="add"/>
															</a4j:commandButton>
														<c:if test="${roleManageAction.txt2}" >
															<h:inputText id="role1" value="" size="15"	style="text-align:cente"/> 
													 		<h:graphicImage value="../images/p_zoom.gif" style="border:0" />
															<h:inputText id="roleDis1" value="" size="40"	style="text-align:cente" disabled="true"/>
															<a4j:commandButton id="btnsave2" value="Submit" styleClass="rich-button"
																	action="#{manageDataIPAction.init}" style="width:50px"
																	/>
															<a4j:commandButton id="btncancel2" value="cancel" styleClass="rich-button"
																action="#{roleManageAction.memberAdd2}" style="width:65px" reRender="groupActionButton"
															>
															<a4j:actionparam name="action" value="cancel"/>
															</a4j:commandButton>
														</c:if>
													</h:panelGrid>	
									          </td>
								         </tr>
								</table>	
								
								<rich:spacer height="5" />	
								
										<rich:dataTable width="95%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="ipDetail" value="" reRender="scrollIPDetailTable" rows="5"
									  
									 
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
										<f:facet name="header">
										<rich:columnGroup >
											<rich:column width="5%">
											</rich:column>
											<rich:column >
												<h:outputText value="Group Name" styleClass="contentform tableHeaderText"></h:outputText>
											</rich:column>
											</rich:columnGroup>
										</f:facet>
										
										<rich:column>
											<input type="checkbox" name="checkbox" id="checkbox">
										</rich:column>
										<rich:column>
											<h:outputText value="ACTM" styleClass="contentform"/>
										</rich:column>
										
										<rich:column breakBefore="true">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</rich:column>
										<rich:column>
											<h:outputText value="Planning WSP" styleClass="contentform"/>
										</rich:column>
											
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{ fn:length(manageDataIPBean.ipDetailList) }" /> records
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
														maxPages="#{manageDataIPBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="hide" boundaryControls="hide" 
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>												
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
	
</f:view>
</body>
</html>
