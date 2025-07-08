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
<script type="text/javascript" language="javascript" src="../js/attach_file.js"></script>
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>

<script language="javascript">
function selectAll(obj,selItem){
	if(!obj.checked) return false;
	var pos = obj.name.lastIndexOf(":");
	var index = 0;
	var objName = obj.name.substring(0,pos)+":"+index+":"+selItem;
	while(document.getElementById(objName)!=null){
		document.getElementById(objName).checked=true;
		objName = obj.name.substring(0,pos)+":"+(++index)+":"+selItem;
	}
}	

function checkF5Ip(){
	var ip = document.getElementById("DetailForm:incF5:vip").value;
	var port = document.getElementById("DetailForm:incF5:vipPort").value;
	if((ip=="") || (port=="")){
		//Richfaces.showModalPanel('f5RequestIp');
		alertErrorMsg("กรุณาระบุ ทั้ง IP Pool และ  IP Port");
	} else {
		retriveF5IP();
	}
}

function showF5Error(){
	if(document.getElementById("DetailForm:incF5:retriveFound").value=="true"){
		//Richfaces.showModalPanel("f5RetriveNotfound");
		alertErrorMsg("ไม่พบข้อมูล");		
	}
}

function completePage(){ 
	if(document.getElementById("j_id_jsp_355853539_820:errorFlagComp").value=="true"){
		Richfaces.showModalPanel('AlertComplete');
	}
}
function downloadTemplateFirewall(){
	document.getElementById('DetailForm:incFirewall:downloadTemplate').click();
}
function downloadTemplateAccTpn(){
	document.getElementById('DetailForm:incAccessListTNP:downloadTemplate').click();
}
function downloadTemplateAccCnd(){
	document.getElementById('DetailForm:incAccessList:downloadTemplate').click();
}
function downloadTemplateGateway(){
	document.getElementById('DetailForm:incGateway:downloadTemplate').click();
}
function downloadTemplatePhysical(){
	document.getElementById('DetailForm:incInterface:downloadTemplate').click();
}
function downloadTemplateRouting(){
	document.getElementById('DetailForm:incRouting:downloadTemplate').click();
}
function downloadTemplateF5(){
	document.getElementById('DetailForm:incF5:downloadTemplate').click();

}
</script>	
</head>
<body style="overflow:hidden;" >



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
						<a4j:jsFunction name="confirmCancel" action="#{reqNWConfigAction.cancelUr}" />
				  	<h:inputHidden id="urNo" value="#{networkConfigBean.urNo}"></h:inputHidden>
				  	<h:inputHidden id="userName" value="#{userSession.ipUser.userId}"></h:inputHidden>
					<table width="100%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Request Network Config</span></strong></td>
					  </tr>

					  <tr>
							<td>
							<rich:simpleTogglePanel switchType="client" id="reqProfile" label="Requester Profile">	
								<table width="100%" border="0" class="thtext_detail">
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
									<h:panelGroup style="width:100%">
										<h:panelGroup id="statusName">
											<h:panelGrid rendered="#{networkConfigBean.mode =='EDIT'}"  columns="1" cellpadding="0" cellspacing="0" style="text-align:right; position:absolute; right:5px;">
												<h:outputText value="#{networkConfigBean.networkConfig.urNo}" style="font-weight:bold; color:#0000FF;" />
												<h:outputText value="#{networkConfigBean.networkConfig.urStatusName}" style="font-weight:bold; color:#FF0000;" />
											</h:panelGrid>
										</h:panelGroup>
									<table width="100%" border="0" class="thtext_detail">
								    <tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Subject<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle" width="610" >
									    	<h:inputTextarea id="subject" style="width:360px;" rows="3" value="#{networkConfigBean.subject}" onkeydown="return limitText(this,1000)" onkeyup="return limitText(this,1000)">
									    	</h:inputTextarea>
										</td>
										<td align="right">&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Objective<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="objective" style="width:360px;" rows="3"  value="#{networkConfigBean.objective}" onkeydown="return limitText(this,1000)" onkeyup="return limitText(this,1000)">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Requirement&nbsp;:&nbsp;</strong></td>
									    <td class="valueStyle">
									    	<h:inputTextarea id="requirement" style="width:460px;" rows="3"  value="#{networkConfigBean.requirement}" onkeydown="return limitText(this,1000)" onkeyup="return limitText(this,1000)">
									    	</h:inputTextarea>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Period<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<table border="0" cellspacing="0" cellpadding="0" style="width:400px;">
									    		<tr>
									    			<td width="20" rowspan="2">
									    				<h:selectOneRadio id="permanent" value="#{networkConfigBean.isPeroiod}" layout="pageDirection" >
															<f:selectItem itemValue="N" itemDisabled="true" />
															<f:selectItem itemValue="Y" /> 
														</h:selectOneRadio>
									    			</td>
									    			<td>Permanent <font style="font-weight: bold;color: blue;">(ไม่สามารถเลือกได้ตั้งแต่วันที่  09/10/2018)</font></td>
									    		</tr>
									    		<tr>
									    			<td>
														<h:outputText value="Start :"></h:outputText>&nbsp;	
														<rich:calendar value="#{networkConfigBean.periodStart}"
										                        locale="en/US"
										                        popup="true"
										                        datePattern="dd/MM/yyyy"
										                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
										                        inputStyle="background-color:white"
										                        inputSize="17"
										                        direction="top-right"/>&nbsp;
										               <h:outputText value="To :"></h:outputText>&nbsp;
										               <rich:calendar value="#{networkConfigBean.periodEnd}"
										                        locale="en/US"
										                        popup="true"
										                        datePattern="dd/MM/yyyy"
										                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
										                        inputStyle="background-color:white"
										                        inputSize="17"
										                        direction="top-right"/>
									    			</td>
									    		</tr>
									    	</table>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Request For<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:selectOneRadio id="config" value="#{networkConfigBean.requestFor}" >
										 		<f:selectItem itemValue="C" itemLabel="Config Network"/>
										 		<f:selectItem itemValue="T" itemLabel="Terminate Network"/> 
											</h:selectOneRadio>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Attach File&nbsp;:&nbsp;</strong></td>
									    <td class="valueStyle">
									    	<h:inputHidden id="isAttach" value="#{networkConfigBean.isAttach}"></h:inputHidden>
									    	<jsp:directive.include file="../home/tableAttachFile.jsp"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
									    <td colspan="2">
									    	<h:panelGrid columns="8">
										    	<h:selectBooleanCheckbox id="showFirewall" value="#{networkConfigBean.firewallCheck}" >
										    		<a4j:support actionListener="#{tabControlAction.firewallToggle}" event="onclick"reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>Firewall&nbsp;
										    	<h:selectBooleanCheckbox id="showAccessList" value="#{networkConfigBean.accessListCheck}">
										    		<a4j:support actionListener="#{tabControlAction.accessListToggle}" event="onclick" reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>Access List For CDN&nbsp;
										    	<h:selectBooleanCheckbox id="showAccessListTnp" value="#{networkConfigBean.accessTNPCheck}">
										    		<a4j:support actionListener="#{tabControlAction.accessTNPToggle}" event="onclick" reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>Access List For TNP&nbsp;
										    	<h:selectBooleanCheckbox id="showPhyInterface" value="#{networkConfigBean.physicalCheck}">
										    		<a4j:support actionListener="#{tabControlAction.physicalToggle}" event="onclick" reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>Physical Interface&nbsp;
										    	<h:selectBooleanCheckbox id="showGateway" value="#{networkConfigBean.gatewayCheck}">
										    		<a4j:support actionListener="#{tabControlAction.gatewatToggle}" event="onclick" reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>Interface Gateway&nbsp;
										    	<h:selectBooleanCheckbox id="showRouting" value="#{networkConfigBean.routingCheck}">
										    		<a4j:support actionListener="#{tabControlAction.routingToggle}" event="onclick" reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>Routing&nbsp;
										    	<h:selectBooleanCheckbox id="showF5" value="#{networkConfigBean.f5Check}">
										    		<a4j:support actionListener="#{tabControlAction.f5Toggle}" event="onclick" reRender="networkConfigTab"/>
										    	</h:selectBooleanCheckbox>F5&nbsp;
										    </h:panelGrid>
										</td>
									</tr>

									</table>
								 </h:panelGroup>
								</rich:simpleTogglePanel>
							</td>
						</tr>
 
						<tr>
							<td>
								<a4j:region renderRegionOnly="true" id="regionTab">
								<rich:tabPanel switchType="ajax" id="networkConfigTab" selectedTab="#{networkConfigBean.currentTab}">
									<rich:tab id="tbFirewall" name="FW" label="Firewall" action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.firewallCheck}">
										<a4j:actionparam name="tabName" value="FW"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_FIREWALL.jsp" id="incFirewall"  />
										
									</rich:tab>
									<rich:tab id="tbAccessList" name="AL" label="Access List For CDN" action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.accessListCheck}">
										<a4j:actionparam name="tabName" value="AL"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_ACCESS_LIST.jsp" id="incAccessList"/>
									</rich:tab>
									<rich:tab id="tbFirewallTNP" name="AT" label="Access List For TNP"  action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.accessTNPCheck}">
										<a4j:actionparam name="tabName" value="AT"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_ACCESS_LIST_TNP.jsp" id="incAccessListTNP"/>
									</rich:tab>
									<rich:tab id="tbPhyInterface" name="PI" label="Physical Interface"  action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.physicalCheck}">
										<a4j:actionparam name="tabName" value="PI"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_PHYSICAL_INTERFACE.jsp" id="incInterface"/>
									</rich:tab>
									<rich:tab id="tbGateway" name="IG" label="Interface Gateway"  action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.gatewayCheck}">
										<a4j:actionparam name="tabName" value="IG"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_INTERFACE_GATEWAY.jsp" id="incGateway"/>
									</rich:tab>
									<rich:tab id="tbRouting" name="RT" label="Routing"  action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.routingCheck}">
										<a4j:actionparam name="tabName" value="RT"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_ROUTING.jsp" id="incRouting"/>
									</rich:tab>
									<rich:tab id="tbF5" name="F5" label="F5"  action="#{tabControlAction.setCurrentTab}" disabled="#{not networkConfigBean.f5Check}">
										<a4j:actionparam name="tabName" value="F5"/>
										<a4j:include viewId="DataTable/IPSUR003_ADD_F5.jsp" id="incF5"/>
									</rich:tab>
							    </rich:tabPanel>
							    </a4j:region>
							</td>
						</tr>
				
						<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="mgrApprove" label="Manager Approve" >
									<table width="100%" border="0" class="thtext_detail">
								    <tr class="displayRow">
									    <td width="120">&nbsp;</td>
									    <td width="400" align="left">
											<table border="0" width="300" align="left" cellpadding="0" cellspacing="0" >
													<tr>
													    <td align="center" width="8"><rich:spacer width="0" /></td>
														<td height="22" background="../images/title_bar.png"  align="left" width="142" ><rich:spacer width="3"/><h:outputText value="Manager" styleClass="contentform tableHeaderText"/></td>
													    <td align="center" width="51" ><rich:spacer width="0" /></td>
												        <td height="22" background="../images/title_bar.png"  align="left" width="142" ><rich:spacer width="4"/><h:outputText value="Approve Manager" styleClass="contentform tableHeaderText"/></td>
												    </tr>
													<tr>
														<td colspan="4">
														      <rich:pickList 
													        		value="#{networkConfigBean.selectedManager}"
													        		listsHeight="80"
													        		removeAllVisible="false"
													        		copyAllVisible="false"
													                copyControlLabel=" "
													                removeControlLabel=" ">
													            <f:selectItems value="#{networkConfigBean.listManager}"/> 
													        </rich:pickList>
														</td>
													</tr>
												</table>
												
										</td>
										<td>&nbsp;</td>
									</tr>
									</table>
								</rich:simpleTogglePanel>
							</td>	
						</tr>
					    <!-- submit part  -->
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
								  <tr>
									<td width="170">
									<a4j:commandLink id="urLink" reRender="PopupHistory_NetworkConfig" action="#{historyNwConfigAction.init}"  style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
										oncomplete="#{rich:component('PopupHistory_NetworkConfig')}.show(); return false" >
										<a4j:actionparam name="urNo" value="#{networkConfigBean.urNo}"/>
										<h:outputText value="View History"/>
									</a4j:commandLink>
									</td>
									<td align="right">
										<h:panelGroup id="buttonGroup">
									    	<a4j:commandButton id="btnSaveDraft" rendered="#{(networkConfigBean.networkConfig.urStatusTxt!='REJECT_MRG') and (networkConfigBean.networkConfig.urStatusTxt!='REJECT_UR')}" value="Save Draft" styleClass="rich-button"
												action="#{reqNWConfigAction.saveDraft}"
												reRender="DetailForm,urDetailDesc," oncomplete="reloadTree();">
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnSendApprove" value="Send for Approve" styleClass="rich-button"
												action="#{reqNWConfigAction.sendForApprove}"
												oncomplete="reloadTree();"
												reRender="errorMsg,AlertComplete"/>&nbsp;
											<a4j:commandButton id="btnDeleteUR" value="Delete UR" styleClass="rich-button"
												rendered="#{networkConfigBean.mode =='EDIT'}" 
                                                oncomplete="#{rich:component('delconfirm')}.show();"/>&nbsp;	
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button">
												<rich:componentControl for="confirmCancelModal" operation="show" event="onclick" />
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
		<jsp:include page="../home/progressnoclose.jsp" />
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
	
	
	

<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_FIREWALL_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_ACCESS_LIST_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_ACCESS_LIST_TNP_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_PHYSICAL_INTERFACE_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_INTERFACE_GATEWAY_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_ROUTING_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_F5_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_VIEW_ERROR_POPUP.jsp"/> --%>

<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_FIREWALL_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_ACCESS_LIST_TNP_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_ACCESS_LIST_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_PHYSICAL_INTERFACE_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_INTERFACE_GATEWAY_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_ROUTING_POPUP.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_EDIT_F5_POPUP.jsp"/> --%>
	
<%-- 	<jsp:directive.include file="popup/IPSUR003_ERROR_RESULT.jsp"/> --%>
<%-- 	<jsp:directive.include file="popup/IPSUR003_IMPORT_RESULT.jsp"/> --%>
	<jsp:directive.include file="../manage/popup/ReqNWConfigHistory.jsp"/>
	<jsp:directive.include file="../home/confirmCancel.jsp"/>
	
	
	<rich:modalPanel id="AlertComplete" autosized="true" minWidth="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="IPFM Message"></h:outputText>
			</h:panelGroup>
	   	</f:facet>
	   	<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid   columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;" id="completeMsg">
					<h:inputHidden id="errorFlagComp" value="#{networkConfigBean.errorFlag}"></h:inputHidden>
					<h:outputText value="Save Data Complete !" escape="true" style="font-weight:bold;color: blue"/></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Close" styleClass="rich-button" immediate="true" style="width:50px;" 
							action="homePage">
						    <rich:componentControl for="AlertComplete" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
	</rich:modalPanel>
	

	<rich:modalPanel id="delconfirm" width="350" height="120">			
		
		   <f:facet name="header">
			  <h:panelGroup>
				<h:outputText value="Delete UR"></h:outputText>
			  </h:panelGroup>
		   </f:facet>
		   <a4j:form id="delURConfirmDialog">
			<table width="90%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="200">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this UR?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{reqNWConfigAction.deleteUr}" reRender="errorMsg" >
								<rich:componentControl for="delconfirm" operation="hide" event="onclick"  />
							</a4j:commandButton>												
							<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="delconfirm" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>
	
<%-- <a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" /> --%>

<iframe id="uploadFrameID" name="uploadFrame" height="0" width="0" frameborder="0" scrolling="yes"></iframe>
<form id="uploadFileForm" name="uploadFileForm" enctype="multipart/form-data" target="uploadFrame"
	method="post" action="/IPFMWeb/servlet/FileUploadServlet">
	<input type="hidden" name="urNo" id="urNo" value="DetailForm:urNo">
	<input type="hidden" name="userName" id="userName" value="DetailForm:userName">
	<input type="hidden" name="isAttach" id="isAttach" value="DetailForm:isAttach">
	<input type="hidden" name="catagory" id="catagory" value="NC">
	<input type="hidden" name="description" id="description" value="Request Network Config Attachment">
	<input type="hidden" name="params" id="params" value="">
</form>

</f:view>







</body>
<HEAD>



</HEAD>
</html>
