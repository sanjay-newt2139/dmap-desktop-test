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
					  <tr>
							<td>
							<rich:simpleTogglePanel switchType="client" id="reqProfile" label="Requester Profile" >	
								<table width="97%" border="0" class="thtext_detail">
								    <tr class="displayRow">
									    <td class="labelStyle"><strong>Name :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.userName}"/>
										</td>
										
									    <td class="labelStyle"><strong>Department :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.dept}"/>
									    </td>
										<td>&nbsp;</td>
									</tr><tr class="displayRow">
										<td class="labelStyle"><strong>Email :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.email}"/>
										</td>
										<td class="labelStyle"><strong>Section :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.section}"/>
										</td>
										<td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td class="labelStyle"><strong>Mobile :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.mobile}"/>
										</td>
										<td class="labelStyle"><strong>Position :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.position}"/>
									    </td>
									    
										<td>&nbsp;</td>
									</tr><tr class="displayRow">
										<td class="labelStyle"><strong>Telephone :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.tel}"/>
									    </td>
									    <td class="labelStyle"><strong>Team :</strong>&nbsp;</td>
									    <td class="valueStyle">&nbsp;
									    	<h:outputText value="#{networkConfigBean.user.teamName}"/>
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
								    <tr class="inputRow">
									    <td class="labelStyle" valign="top"><strong>Subject&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle" style="width:610" align="left">
									    	<h:inputTextarea id="subject" style="width:360px;" rows="3" 
									    		value="#{networkConfigBean.subject}" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td align="right">
									   	   <h:outputText value="#{networkConfigBean.networkConfig.urNo}" style="FONT-SIZE: 10; FONT-WEIGHT: bold; COLOR: #0000ff;"/><br>
									   	   <h:outputText value="#{networkConfigBean.networkConfig.urStatusName}" style="FONT-SIZE: 10; FONT-WEIGHT: bold; COLOR: #ff0000;"/>
									   	</td>
									</tr>
									<tr class="inputRow">
									    <td class="labelStyle" valign="top"><strong>Objective&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="objective" style="width:360px;" rows="3"
									    		value="#{networkConfigBean.objective}" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="inputRow">
									    <td class="labelStyle" valign="top"><strong>Requirement&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="requirement" style="width:360px;" rows="3"
									    		value="#{networkConfigBean.requirement}" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Period&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    
									    	<table>
									    	<tr>
									    		<td><h:outputText value="Permanent" rendered="#{networkConfigBean.isPeroiod=='N'}"/></td>
									    	</tr>
									    	<tr>
									    		<td>
									    		<h:outputText value="#{networkConfigBean.periodStart}" rendered="#{networkConfigBean.isPeroiod=='Y'}">
										    		<f:convertDateTime pattern="dd/MM/yyyy"/>
										    	</h:outputText>
										    	<h:outputText value="&nbsp;-&nbsp" escape="false" rendered="#{networkConfigBean.isPeroiod=='Y'}"/>
										    	
												<h:outputText value="#{networkConfigBean.periodEnd}" rendered="#{networkConfigBean.isPeroiod=='Y'}">
													<f:convertDateTime pattern="dd/MM/yyyy"/>
												</h:outputText>
											</td>
									    	</tr>
									    	</table>							    	
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Request For&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="Config Network" rendered="#{networkConfigBean.requestFor=='C'}"/>
									    	<h:outputText value="Terminate Network" rendered="#{networkConfigBean.requestFor=='T'}"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Manager&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{networkConfigBean.mgrName}" />
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Attach File&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    <table>
									    	<tr>
										    	<td>
											    	<rich:dataTable width="300" id="tblAttachFile" cellpadding="1" cellspacing="0" border="0"
														rowClasses="odd,even" 
														styleClass="contentform" rowKeyVar="index" 
														headerClass="tableHeader"											
														value="#{networkConfigBean.listAttach}" var="attach">
														<rich:column width="300" style="vertical-align:top;">
															<f:facet name="header"> 
																<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
															<div align="left">
															  <h:commandLink action="#{reqNWConfigAction.downloadFile}">
																<h:outputText value="#{attach.fileName}" style="TEXT-DECORATION: underline;"/>
																	<a4j:actionparam name="fileName" value="#{attach.fileName}"/>
																    <a4j:actionparam name="path" value="#{attach.fileLocation}"/>
															 </h:commandLink>
															</div>
														</rich:column>
													</rich:dataTable>
										    	</td>
									    	</tr>
									    	<tr>
									    		<td>
										    		<rich:dataTable width="300" id="tblSubAttachFile" cellpadding="1" cellspacing="0" border="0"
														rowClasses="odd,even" 
														styleClass="contentform" rowKeyVar="index" 
														headerClass="tableHeader"											
														value="#{networkConfigBean.listSubAttach}" var="attach">
														<rich:column width="300" style="vertical-align:top;">
															<div align="left">
															  <h:commandLink action="#{reqNWConfigAction.downloadFile}">
																<h:outputText value="#{attach.fileName} (#{attach.createdBy})" title="#{attach.subUrNo}" style="TEXT-DECORATION: underline;"/>
																	<a4j:actionparam name="fileName" value="#{attach.fileName}"/>
																    <a4j:actionparam name="path" value="#{attach.fileLocation}"/>
															 </h:commandLink>
															</div>
														</rich:column>
													</rich:dataTable>
										    	</td>
									    	</tr>
									    
									    </table>
									    	
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Network Type&nbsp:</strong>&nbsp;</td>
									    <td class="valueStyle" colspan="6">
									    	<h:panelGrid columns="8">
										    	<h:selectBooleanCheckbox id="showFirewall" value="#{networkConfigBean.firewallCheck}" 
										    		rendered="#{networkConfigBean.firewallCheck}" disabled="true"/>
										    	<h:outputText value="Firewall" rendered="#{networkConfigBean.firewallCheck}"/>
										    	<h:selectBooleanCheckbox id="showAccessList" value="#{networkConfigBean.accessListCheck}" 
										    	 	rendered="#{networkConfigBean.accessListCheck}" disabled="true"/>
										    	<h:outputText value="Access List For CDN" rendered="#{networkConfigBean.accessListCheck}"/>
										    	<h:selectBooleanCheckbox id="showAccessListTnp" value="#{networkConfigBean.accessTNPCheck}"  
										    		rendered="#{networkConfigBean.accessTNPCheck}" disabled="true"/>
										    	<h:outputText value="Access List For TNP" rendered="#{networkConfigBean.accessTNPCheck}"/>
										    	<h:selectBooleanCheckbox id="showPhyInterface" value="#{networkConfigBean.physicalCheck}"
										    	  	rendered="#{networkConfigBean.physicalCheck}" disabled="true"/>
										    	<h:outputText value="Physical Interface" rendered="#{networkConfigBean.physicalCheck}"/>
										    	<h:selectBooleanCheckbox id="showGateway" value="#{networkConfigBean.gatewayCheck}" 
										    		rendered="#{networkConfigBean.gatewayCheck}" disabled="true"/>
										    	<h:outputText value="Interface Gateway" rendered="#{networkConfigBean.gatewayCheck}"/>
										    	<h:selectBooleanCheckbox id="showRouting" value="#{networkConfigBean.routingCheck}"  
										    		rendered="#{networkConfigBean.routingCheck}" disabled="true"/>
										    	<h:outputText value="Routing" rendered="#{networkConfigBean.routingCheck}"/>
										    	<h:selectBooleanCheckbox id="showF5" value="#{networkConfigBean.f5Check}"  
										    		rendered="#{networkConfigBean.f5Check}" disabled="true"/>
												<h:outputText value="F5" rendered="#{networkConfigBean.f5Check}"/>
										    </h:panelGrid>
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
									<rich:tab id="tbFirewall" label="Firewall" 
										rendered="#{networkConfigBean.firewallCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_FIREWALL.jsp"/>
									</rich:tab>
									<rich:tab id="tbAccessList" label="Access List For CDN"  
										rendered="#{networkConfigBean.accessListCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ACCESS_LIST.jsp"/>
									</rich:tab>
									<rich:tab id="tbAccessListTNP" label="Access List For TNP"  
										rendered="#{networkConfigBean.accessTNPCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ACCESS_LIST_TNP.jsp"/>
									</rich:tab>
									<rich:tab id="tbPhysicalInterface" label="Physical Interface"  
										rendered="#{networkConfigBean.physicalCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_PHYSICAL_INTERFACE.jsp"/>
									</rich:tab>
									<rich:tab id="tbInterfaceGateway" label="Interface Gateway"  
										rendered="#{networkConfigBean.gatewayCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_INTERFACE_GATEWAY.jsp"/>
									</rich:tab>
									<rich:tab id="tbRouting" label="Routing"  
										rendered="#{networkConfigBean.routingCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ROUTING.jsp"/>
									</rich:tab>
									<rich:tab id="tbF5" label="F5"  
										rendered="#{networkConfigBean.f5Check}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_F5.jsp"/>
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
								   <tr>
									<td width="170" align="left" valign="top">
										<a4j:commandLink id="urLink" reRender="PopupHistory_NetworkConfig" action="#{historyNwConfigAction.init}"  style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
											oncomplete="#{rich:component('PopupHistory_NetworkConfig')}.show(); return false" >
											<a4j:actionparam name="urNo" value="#{networkConfigBean.urNo}"/>
											<h:outputText value="View History"/>
										</a4j:commandLink>
									</td>
									<td align="right">
										<h:panelGroup id="buttonGroup">
											<a4j:commandButton id="btnClose" value="Close" styleClass="rich-button"
												action="#{homepageAction.gotoHomepage}"/>
										</h:panelGroup>
									</td>
								  </tr>
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
	
	<jsp:directive.include file="popup/IPSUR003_VIEW_FIREWALL_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_ACCESS_LIST_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_ACCESS_LIST_TNP_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_PHYSICAL_INTERFACE_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_INTERFACE_GATEWAY_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_ROUTING_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_F5_POPUP.jsp"/>
	<jsp:directive.include file="../manage/popup/ReqNWConfigHistory.jsp"/>
	
</f:view>
</body>
</html>
