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
								class="style9"></span>Workflow Management</strong></td>
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
										  		<a4j:commandButton id="btnOwnerList" value="Owner List IP" 
													image="../images/tab_user_req_notactive.png" style="height: 25; width: 90" 
													action="#{workflowManageAction.init}">
													<a4j:actionparam name="programIDParam" value="IPURS011_1"/>
				          						</a4j:commandButton>
				          						<a4j:commandButton id="btnplanRequestIp" value="IP Detail" 
													image="../images/tab_planning_req_active.png" style="height: 25; width: 135" 
													action="#{workflowManageAction.initPlanningRequestIp}">
				          						</a4j:commandButton>
				          						<a4j:commandButton id="btnIPDetail" value="IP Detail" 
													image="../images/tab_req_nw_notactive.png" style="height: 25; width: 135" 
													action="#{workflowManageAction.initRequestNetworkConfig}">
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
											<td width="15%" height="25" align="center">
											      <h:graphicImage value="../images/User_req.jpg" style="border:0;width: 1000px;height: 300px"/>
											</td>
                                        </tr>                                                          
								    </table>
							   </rich:panel>
								<rich:spacer height="5" />	

								 <rich:panel>
									<table width="70%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail" bordercolor="#CCCCCC">
										<tr>
											<td width="10%" height="25" align="right" >
												<strong><h:outputText value="Node"></h:outputText>&nbsp;:&nbsp;</strong>
											</td> 
											<td height="25" align="left" >
												<strong><h:outputText value="N1-Request IP"></h:outputText></strong>
											</td>  
                                        </tr>
                                        <tr>
											<td width="10%" height="25" align="right" >
												<strong><h:outputText value="OLA"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td> 
											<td height="25" align="left" >
												 <h:inputText id="projectId" value="#{manageDataIPBean.projectId}" size="30"></h:inputText>&nbsp;<strong>Days</strong>
											</td>  
                                        </tr>
                                       <tr>
										   <td width="10%" height="25" align="right"><strong>Sand Mail<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <input type="radio" name="_id0:sor" value="11" border="1" title="Select any one of the choice"><strong>True</strong></input>
                                                 <input type="radio" name="_id0:sor" value="11" border="1" checked="checked" title="Select any one of the choice"><strong>False</strong></input>
										   </td>
									</tr>
									<tr><td height="7"></td></tr>
									<tr>
									   <td width="10%" height="25" align="right"></td>
									   <td align="left">
									     <a4j:commandButton id="btnSubmit" value="Update data" styleClass="rich-button" action="#{manageDataIPAction.search}"/>&nbsp;
												<a4j:commandButton id="btnClose" value="Close" styleClass="rich-button" action="#{manageDataIPAction.search}"/>
									   </td>
									</tr>                                                          
								    </table>								    			
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
