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
<script type="text/javascript">
	function rejectUR(){
		var rem = document.getElementById("DetailForm:remark").value;
		if(rem!=""){
			Richfaces.showModalPanel('confirmSendForRejectURModal');
		} else {
			Richfaces.showModalPanel('alertBlankRemark');
		}
	}

	function approveUR(){
		Richfaces.hideModalPanel('confirmSendForApproveURModal');
		Richfaces.showModalPanel('AlertComplete');
	}

	function rejectURComplete(){
		Richfaces.hideModalPanel('confirmSendForRejectURModal');
		Richfaces.showModalPanel('AlertComplete');
	}
	
</script>


</head>
<body style="overflow:hidden;">

<f:view>
	<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>
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
				  	<h:inputHidden id='urNo' value="#{networkConfigBean.urNo}"/>
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
									    <td class="labelStyle" valign="top"><strong>Subject&nbsp;:</strong>&nbsp;</td>
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
									    <td class="labelStyle" valign="top"><strong>Objective&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="objective" style="width:360px;" rows="3"
									    		value="#{networkConfigBean.objective}" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="inputRow">
									    <td class="labelStyle" valign="top"><strong>Requirement&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="requirement" style="width:360px;" rows="3"
									    		value="#{networkConfigBean.requirement}" readonly="true">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Period&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="Permanent" rendered="#{networkConfigBean.isPeroiod=='N'}"/>
									    	<h:outputText value="#{networkConfigBean.periodStart}" rendered="#{networkConfigBean.isPeroiod=='Y'}">
									    		<f:convertDateTime pattern="dd/MM/yyyy"/>
									    	</h:outputText>
									    	<h:outputText value="&nbsp;-&nbsp" escape="false" rendered="#{networkConfigBean.isPeroiod=='Y'}"/>
											<h:outputText value="#{networkConfigBean.periodEnd}" rendered="#{networkConfigBean.isPeroiod=='Y'}">
												<f:convertDateTime pattern="dd/MM/yyyy"/>
											</h:outputText>									    	
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Request For&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="Config Network" rendered="#{networkConfigBean.requestFor=='C'}"/>
									    	<h:outputText value="Terminate Network" rendered="#{networkConfigBean.requestFor=='T'}"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Attach File&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
											<table>
									    	<tr>
										    	<td>
											    	<rich:dataTable width="300" id="tblAttachFile" cellpadding="1" cellspacing="0" border="0"
														rowClasses="odd,even" 
														styleClass="contentform" rowKeyVar="index" 
														headerClass="tableHeader"
														rendered="#{networkConfigBean.isAttach=='Y'}"
														value="#{networkConfigBean.listAttach}" var="attach">
														<rich:column width="300" style="vertical-align:top;">
															<f:facet name="header"> 
																<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
															<div align="left">
																<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
																onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?attachFilePath=#{attach.fileLocation}&attachFileName=#{attach.fileName}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" 
							     									 id="attdl" >
							     									<h:outputText value="#{attach.fileName}"/>
							     								</h:outputLink>
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
									    <td class="labelStyle" valign="top"><strong>Network Type&nbsp;:</strong>&nbsp;</td>
									    <td>
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
								
								<rich:tabPanel switchType="ajax" id="policyTab">
									<rich:tab id="tbFirewall" label="Firewall"
										rendered="#{networkConfigBean.firewallCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_FIREWALL.jsp" id="pageFW"/>
									</rich:tab>
									<rich:tab id="tbAccessList" label="Access List For CDN" 
										rendered="#{networkConfigBean.accessListCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ACCESS_LIST.jsp" id="pageAL"/>
									</rich:tab>
									<rich:tab id="tbAccessListTNP" label="Access List For TNP" 
										rendered="#{networkConfigBean.accessTNPCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ACCESS_LIST_TNP.jsp" id="pageAT"/>
									</rich:tab>
									<rich:tab id="tbPhysicalInterface" label="Physical Interface"  
										rendered="#{networkConfigBean.physicalCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_PHYSICAL_INTERFACE.jsp"  id="pagePI"/>
									</rich:tab>
									<rich:tab id="tbInterfaceGateway" label="Interface Gateway" 
										rendered="#{networkConfigBean.gatewayCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_INTERFACE_GATEWAY.jsp"  id="pageIG"/>
									</rich:tab>
									<rich:tab id="tbRouting" label="Routing" 
										rendered="#{networkConfigBean.routingCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ROUTING.jsp"  id="pageRT"/>
									</rich:tab>
									<rich:tab id="tbF5" label="F5" 
										rendered="#{networkConfigBean.f5Check}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_F5.jsp"  id="pageF5"/>
									</rich:tab>
							    </rich:tabPanel>
							  
							</td>
						</tr>
						<tr>
							<td align="left">
							<table width="500" border="0">
								<tr>
									<td width="100" align="right" valign="top"><strong>Remarks</strong></td>
									<td width="400" align="right" valign="top">
										
										<h:inputTextarea id="remark" style="width:360px;" rows="3"  value="#{networkConfigBean.mgrRemark}" onkeydown="return limitText(this,1000)" onkeyup="return limitText(this,1000)">
										</h:inputTextarea>
									</td>
								</tr>
							</table>		
							</td>
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
									    	<a4j:commandButton id="btnApprove" value="Approve" styleClass="rich-button" 
									    		reRender="remark" oncomplete="Richfaces.showModalPanel('confirmSendForApproveURModal');">
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button"
												onclick="rejectUR();" reRender="errorMsg">												
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button">
												<rich:componentControl for="confirmCancel" operation="show" event="onclick" />
											</a4j:commandButton>
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
	
	<rich:modalPanel id="confirmSendForApproveURModal" autosized="true" minWidth="350">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Approve UR"></h:outputText>
			</h:panelGroup>
	   	</f:facet>
	   	<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0005}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Yes" action="#{reqNWConfigAction.managerApprove}" styleClass="rich-button"
							style="width:50px;" oncomplete="if (#{!errorMessages}) approveUR(); Richfaces.hideModalPanel('confirmSendForApproveURModal');" reRender="errorMsg">
							<a4j:actionparam name="urNo" value="#{networkConfigBean.urNo}"/>
							<a4j:actionparam name="remark" value="#{networkConfigBean.mgrRemark}"/>
						</a4j:commandButton>
						<rich:spacer width="10" />
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" style="width:50px;">
						    <rich:componentControl for="confirmSendForApproveURModal" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
	</rich:modalPanel>
	
	<rich:modalPanel id="confirmSendForRejectURModal" autosized="true" minWidth="400" >			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Reject UR"></h:outputText>
			</h:panelGroup>
	   	</f:facet>
	   	<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0008}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Yes" action="#{reqNWConfigAction.managerReject}" styleClass="rich-button" style="width:50px;" oncomplete="rejectURComplete();" >
							<a4j:actionparam name="urNo" value="#{networkConfigBean.urNo}"/>
							<a4j:actionparam name="remark" value="#{networkConfigBean.mgrRemark}"/>
							<rich:componentControl for="confirmSendForRejectURModal" operation="hide" event="oncomplete" />
						</a4j:commandButton>
						<rich:spacer width="10" />
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" style="width:50px;">
						    <rich:componentControl for="confirmSendForRejectURModal" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
	</rich:modalPanel>
	
	<rich:modalPanel id="alertBlankRemark" autosized="true" minWidth="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="IPFM Message"></h:outputText>
			</h:panelGroup>
	   	</f:facet>
	   	<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid columns="1" styleClass="contentlabelform" width="100%">
					<h:panelGroup  styleClass="contentlabelform" style="font-weight:bold;color: red;">Required Remarks</h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup style="width:100%;text-align:center;">
						<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true" style="width:50px;">
						    <rich:componentControl for="alertBlankRemark" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
	</rich:modalPanel>
	
	<rich:modalPanel id="AlertComplete" autosized="true" minWidth="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="IPFM Message"></h:outputText>
			</h:panelGroup>
	   	</f:facet>
	   	<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="Save Data Complete !" escape="true"/></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Close" styleClass="rich-button" immediate="true" style="width:50px;" 
							action="homePage" onclick="reloadTree();">
						    <rich:componentControl for="AlertComplete" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
	</rich:modalPanel>
	
	<rich:modalPanel id="confirmCancel" autosized="true" minWidth="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Cancel UR"></h:outputText>
			</h:panelGroup>
	   	</f:facet>
	   	<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0002}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" style="width:50px;" 
							action="homePage">
						    <rich:componentControl for="confirmCancel" operation="hide" event="onclick" />
						</a4j:commandButton>
						<rich:spacer width="10" />
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" style="width:50px;">
						    <rich:componentControl for="confirmCancel" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
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
