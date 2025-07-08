<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>Role Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>

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
													image="../images/tab_Role_Auth_active.png" style="height: 25; width: 87" 
													action="#{roleManageAction.init}">
													<a4j:actionparam name="programIDParam" value="IPURS010_01"/>
				          						</a4j:commandButton>
				          						<a4j:commandButton id="btnIPDetail" value="Member List" 
													image="../images/tab_Role_Member_notactive.png" style="height: 25; width: 61" 
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
											</td>	
									      												
                                  </tr>
                                  <tr>
                                    <td colspan="4" >&nbsp;</td>
                                  </tr>  
                                  <tr>
                                          <td  ></td>
										  <td  >
											<a4j:commandButton id="btnQuery" value="Add New Role" styleClass="rich-button"
												action="#{manageDataIPAction.search}"
												reRender="groupSearchResult" />&nbsp;
											<a4j:commandButton id="btnClear" value="Save Change" styleClass="rich-button"
												action="#{manageDataIPAction.init}"
												reRender="groupSearchResult"/>&nbsp;
	                               </tr>                                                         
								</table>
							</rich:panel>
								<rich:spacer height="5" />	
								
							<rich:simpleTogglePanel switchType="client" id="groupSearchResult" label="Result" opened="true" >
								 <rich:panel>
										<rich:dataTable width="95%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
									var="ipDetail" value="" reRender="scrollIPDetailTable" rows="5"
									  
									 
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
										<f:facet name="header">
										<rich:columnGroup >
											<rich:column width="30%">
													<h:outputText value="Function List" styleClass="contentform tableHeaderText"></h:outputText>
											</rich:column>
											<rich:column width="20%">
												<h:outputText value="" styleClass="contentform tableHeaderText"></h:outputText>
											</rich:column>
											<rich:column width="50%">
												<h:outputText value="Authorize Setting" styleClass="contentform tableHeaderText"></h:outputText>
											</rich:column>
											</rich:columnGroup>
										</f:facet>
										
										
										<rich:column width="30%">
											<h:outputText value="User Request : User Request IP" styleClass="contentform"/>
										</rich:column>
										<rich:column width="20%">
											<center>
											<a4j:commandButton id="btnQuery2" value="Advance Setting" styleClass="rich-button"
												action="#{roleManageAction.advanceSetting}"
												 style="width:100px" >
												 <a4j:actionparam name="programIDParam" value="IPURS010_03"/>
												 </a4j:commandButton>
											</center>
										</rich:column>
										<rich:column width="50%">
											<input type="checkbox" name="checkbox" id="checkbox">&nbsp;
											<h:outputText value="Acess Menu" styleClass="contentform"/>
										</rich:column>
										
										
										<rich:column width="30%" breakBefore="true"> 
										<h:outputText value="User Request : Planning Request IP" styleClass="contentform"/>
										</rich:column>
										<rich:column width="20%">
											<center>
											<a4j:commandButton id="btnQuery3" value="Advance Setting" styleClass="rich-button"
												action="#{roleManageAction.advanceSetting}"
												 style="width:100px" >
												<a4j:actionparam name="programIDParam" value="IPURS010_04"/>
												</a4j:commandButton>
											</center>
										</rich:column>
										<rich:column width="50%">
											<input type="checkbox" name="checkbox2" id="checkbox2">&nbsp;
											<h:outputText value="Acess Menu" styleClass="contentform"/>
										</rich:column>
										 
										 
										<rich:column width="30%" breakBefore="true">
										<h:outputText value="User Request : Request Network Config" styleClass="contentform"/>
										</rich:column>
										<rich:column width="20%">
											<center>
											<a4j:commandButton id="btnQuery4" value="Advance Setting" styleClass="rich-button"
												action="#{roleManageAction.advanceSetting}"
												 style="width:100px" >
												<a4j:actionparam name="programIDParam" value="IPURS010_05"/>
												</a4j:commandButton>
											</center>
										</rich:column>
										<rich:column width="50%">
											<input type="checkbox" name="checkbox3" id="checkbox3">&nbsp;
											<h:outputText value="Acess Menu" styleClass="contentform"/>
										</rich:column>
										
										<rich:column width="30%" breakBefore="true">
										<h:outputText value="IP Management : Manage IP-Level1" styleClass="contentform"/>
										</rich:column>
										<rich:column width="20%">
										</rich:column>
										<rich:column width="50%">
											<input type="checkbox" name="checkbox4" id="checkbox4">&nbsp;
											<h:outputText value="Add" styleClass="contentform"/>
											&nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="checkbox5" id="checkbox5">&nbsp;
											<h:outputText value="Update" styleClass="contentform"/>
											&nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="checkbox6" id="checkbox6">&nbsp;
											<h:outputText value="Delete" styleClass="contentform"/>
											&nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="checkbox7" id="checkbox7">&nbsp;
											<h:outputText value="View" styleClass="contentform"/>
										</rich:column>
										
										
										<rich:column width="30%" breakBefore="true">
										<h:outputText value="IP Management : Manage IP-Level2" styleClass="contentform"/>
										</rich:column>
										<rich:column width="20%">
										</rich:column>
										<rich:column width="50%">
											<input type="checkbox" name="checkbox8" id="checkbox8">&nbsp;
											<h:outputText value="Add" styleClass="contentform"/>
											&nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="checkbox9" id="checkbox9">&nbsp;
											<h:outputText value="Update" styleClass="contentform"/>
											&nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="checkbox10" id="checkbox10">&nbsp;
											<h:outputText value="Delete" styleClass="contentform"/>
											&nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="checkbox11" id="checkbox11">&nbsp;
											<h:outputText value="View" styleClass="contentform"/>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{ fn:length(manageDataIPBean.ipDetailList) }" /> records
												</rich:column>
												<rich:column colspan="8">
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
