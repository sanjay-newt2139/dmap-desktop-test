<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>User Request IP </title>
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
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<f:subview id="error">
					<jsp:include page="../home/errorModal.jsp" />
				</f:subview>
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Request Network Config</span></strong></td>
					  </tr>
<!-- 					  
					  <tr bgcolor="#f3f2f2">
                             <td height="25" align="left" valign="middle">
                             <table border="0" width="100%">
                             	<tr>
                             		<td width="160" align="right"><span class="HeaderLabel"><strong>UR No&nbsp;:&nbsp;</strong></span></td>
                             		<td width="140"><span class="HeaderLabel">NC2010000001</span></td>
                             		<td width="380"  align="right"><span class="statusID">Wait for Varify Job</span></td>
                             		<td>&nbsp;</td>
                             	</tr>
                             </table>
                             </td>
					  </tr>
-->					  
					  <tr>
							<td>
							<rich:simpleTogglePanel switchType="client" id="reqProfile" label="Requester Profile" >	
								<table width="97%" border="0" class="thtext_detail">
								    <tr class="displayRow">
									    <td class="labelStyle"><strong>Name :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.userName}"/>
										</td>
										
									    <td class="labelStyle"><strong>Department :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.dept}"/>
									    </td>
										<td>&nbsp;</td>
									</tr><tr class="displayRow">
										<td class="labelStyle"><strong>Email :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.email}"/>
										</td>
										<td class="labelStyle"><strong>Section :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.section}"/>
										</td>
										<td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td class="labelStyle"><strong>Mobile :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.mobile}"/>
										</td>
										<td class="labelStyle"><strong>Position :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.position}"/>
									    </td>
									    
										<td>&nbsp;</td>
									</tr><tr class="displayRow">
										<td class="labelStyle"><strong>Telephone :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.tel}"/>
									    </td>
									    <td class="labelStyle"><strong>Team :</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{userSession.ipUser.userTeamId}"/>
									    </td>
									    
									    <td>&nbsp;</td>
									  </tr>

									</table>	
							</rich:simpleTogglePanel>
							</td>
						</tr>
						<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="profile" label="Profile" >
									<table width="97%" border="0" class="thtext_detail">
								    <tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Subject<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;</strong>&nbsp;</td>
									    <td class="valueStyle" style="width:610px" align="left">
									    	<h:inputTextarea id="subject" style="width:360px;" rows="3" 
									    		value="Request Network 1" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Objective<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="objective" style="width:360px;" rows="3"
									    		value="Objective 1" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Requirement<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="requirement" style="width:360px;" rows="3"
									    		value="Request Network Config" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Period<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="10/06/2010"/>
									    	&nbsp;-&nbsp;
									    	<h:outputText value="10/06/2011"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Request For<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="Config Network"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Manager&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="Praditpong Soipetch"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	Firewall&nbsp;
									    	Access List&nbsp;
										</td>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
									</tr>
									</table>
								</rich:simpleTogglePanel>
							</td>
						</tr>
						
						<tr>
							<td>
								<a4j:region renderRegionOnly="true">
								<rich:tabPanel switchType="ajax" id="policyTab">
									<rich:tab id="tbFirewall" label="Firewall">
										<a4j:include viewId="DataTable/IPSUR003_VERIFY_JOB_FIREWALL.jsp"/>
									</rich:tab>
									<rich:tab id="tbAccessList" label="Access List">
										<a4j:include viewId="DataTable/IPSUR003_VERIFY_JOB_ACCESS_LIST.jsp"/>
									</rich:tab>
								
							    </rich:tabPanel>
							    </a4j:region>
							</td>
						</tr>
						<tr>
							<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
						</tr>
						
					    <!-- submit part  -->
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
									<td width="170">&nbsp;</td>
									<td align="right">
										<h:panelGroup id="buttonGroup">
									    	<a4j:commandButton id="btnApprove" value="Accept UR" styleClass="rich-button"
												action="#{reqNWConfigAction.OwnerApprove}"
												reRender="groupSearchResult" oncomplete="reloadTree();"/>&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
												action="#{homepageAction.gotoHomepage}"/>
										</h:panelGroup>
									</td>
								</table>
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
	<jsp:directive.include file="popup/popupAddFirewall.jsp"/>
	<jsp:directive.include file="popup/popupAddAccessList.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_FIREWALL_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_ACCESS_LIST_POPUP.jsp"/>
</f:view>
</body>
</html>
