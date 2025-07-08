<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="th.co.ais.ipfm.util.PropertiesMessageUtil"%>
<html>
<head>
<title>User Request IP </title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>	
<script type="text/javascript" language="javascript" src="../js/attach_file.js"></script>
<script type="text/javascript">
	function delegateJob(urType){
		Richfaces.hideModalPanel('confirmDelegatePopup');
		//var urType = document.getElementById("DetailForm:selectSubUR").value;
		var chkName = "DetailForm:page"+urType+":tablePM"+urType;
		var index = 0;		 
		var objName = chkName+":"+index+":isSelected";
		var isCheck = false;
		while(document.getElementById(objName)!=null){
			if(document.getElementById(objName).checked){
				isCheck = true;
			}
			objName = chkName+":"+(++index)+":isSelected";
		}

		if(!isCheck){
			showAlertMsg2("ER0054");
		} else {
			showDelegatePM2(urType);
		}
	}

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

	function delegateSubUR(urType){
		document.getElementById("DetailForm:selectSubUR").value=urType;
		Richfaces.showModalPanel('confirmDelegatePopup');
	}

	function showErrorMessageDialog(){
		var isShow = document.getElementById("popupAlert:formRegionMultiQuery:errorFlag").value;
		if(isShow=='true'){
			Richfaces.showModalPanel('alertPopup');
			document.getElementById("popupAlert:formRegionMultiQuery:errorFlag").value=false;
		}
		
	}

	function showDelegatePopup(){
		var isShow = document.getElementById("popupAlert:formRegionMultiQuery:errorFlag").value;
		if(isShow=='true'){
			Richfaces.showModalPanel('alertPopup');
		} else {
			var isConf = document.getElementById("popupDelegeteDlg:formRegionMultiQuery:confFlag").value;
			if(isConf=='true'){
				Richfaces.showModalPanel('delegatePMPopup');
			}
			
		}
		
	}

	function assignJob(urType){
		document.getElementById("DetailForm:selectSubUR").value=urType;
		var chkName = "DetailForm:page"+urType+":tablePM"+urType;
		var index = 0;		 
		var objName = chkName+":"+index+":isSelected";
		var isCheck = false;
		while(document.getElementById(objName)!=null){
			if(document.getElementById(objName).checked){
				isCheck = true;
			}
			objName = chkName+":"+(++index)+":isSelected";
		}
		if(!isCheck){
			//showAlertMsg("ER0058");
			showAlertMsg2("ER0058");	
		} else {
			//pmAssign(urType);
			pmAssign2(urType);
		}
	}


	function rejectJob(urType){
		//document.getElementById("DetailForm:selectSubUR").value=urType;
		//var chkName = "DetailForm:page"+urType+":tablePM"+urType;
		//var index = 0;		 
		//var objName = chkName+":"+index+":isSelected";
		//var isCheck = false;
		//while(document.getElementById(objName)!=null){
		//	if(document.getElementById(objName).checked){
		//		isCheck = true;
		//	}
		//	objName = chkName+":"+(++index)+":isSelected";
		//}
		//if(!isCheck){
		//	showAlertMsg("ER0073");	
		//} else {
			//pmReject(urType);
			pmReject2(urType);
		//}
	}


</script>

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

				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
							
						<a4j:jsFunction name="showAlertMsg2" reRender="alertPopup"
							action="#{reqNWConfigAction.setMessageError}" 
							oncomplete="if( document.getElementById('popupAlert:formRegionMultiQuery:errorFlag').value == 'true'){ Richfaces.showModalPanel('alertPopup');document.getElementById('popupAlert:formRegionMultiQuery:errorFlag').value=false}">
							<a4j:actionparam name="errNo"/>
						</a4j:jsFunction>
						
						<a4j:jsFunction name="pmAssign2" reRender="mdlPMAssign"
							action="#{reqNWConfigAction.showAssignWin}"
						 	oncomplete="Richfaces.showModalPanel('mdlPMAssign');">
						 	<a4j:actionparam name="subUrType"/>
						</a4j:jsFunction>
						
						<a4j:jsFunction name="pmReject2" reRender="mdlPMReject"
							action="#{reqNWConfigAction.showRejectWin}"
						 	oncomplete="Richfaces.showModalPanel('mdlPMReject');">
						 	<a4j:actionparam name="subUrType"/>
						</a4j:jsFunction>
						
						<a4j:jsFunction name="showDelegatePM2"  reRender="delegatePMPopup,policyTab"
							action="#{reqNWConfigAction.showDelegateWin}" 
							oncomplete="Richfaces.showModalPanel('delegatePMPopup');">
							<a4j:actionparam name="subUrType"/>
						</a4j:jsFunction>
						
												
				  	<h:inputHidden id='urNo' value="#{networkConfigBean.urNo}"/>
				  	<h:inputHidden id="urStatus" value="#{networkConfigBean.networkConfig.urStatusTxt}"/>
				  	<h:inputHidden id="userName" value="#{userSession.ipUser.userId}"></h:inputHidden>
				  	<h:inputHidden id='selectSubUR'/>
				  	
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
									    	<h:outputText value="Terminate Network" rendered="#{networkConfigBean.requestFor=='T'}" style="font-weight: bold; color: red;"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Manager&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">
									    	<h:outputText value="#{networkConfigBean.mgrName}"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Attach File&nbsp;:</strong>&nbsp;</td>
									    <td class="valueStyle">											
											<table>
									       <tr>
									       <td class="valueStyle">
									    	<h:inputHidden id="isAttach" value="#{networkConfigBean.isAttach}"></h:inputHidden>
									    		<jsp:directive.include file="../home/tableAttachFile.jsp"/>
											</td>
									       </tr>
									    
									    </table>
										</td>
										<td>&nbsp;</td>
									</tr>
									
									<tr class="displayRow">
									    <td class="labelStyle" valign="top"><strong>Network Type&nbsp;:</strong>&nbsp;</td>
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
								<rich:tabPanel id="policyTab" switchType="ajax">
									<rich:tab id="tbFirewall" label="Firewall"
										rendered="#{networkConfigBean.firewallCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_FIREWALL.jsp" id="pageFW"/>
									</rich:tab>
									<rich:tab id="tbAccessList" label="Access List For CDN" 
										rendered="#{networkConfigBean.accessListCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ACCESS_LIST.jsp" id="pageAL" />
									</rich:tab>
									<rich:tab id="tbAccessListTNP" label="Access List For TNP"  
										rendered="#{networkConfigBean.accessTNPCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ACCESS_LIST_TNP.jsp"  id="pageAT"/>
									</rich:tab>
									<rich:tab id="tbPhysicalInterface" label="Physical Interface"  
										rendered="#{networkConfigBean.physicalCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_PHYSICAL_INTERFACE.jsp" id="pagePI"/>
									</rich:tab>
									<rich:tab id="tbInterfaceGateway" label="Interface Gateway" 
										rendered="#{networkConfigBean.gatewayCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_INTERFACE_GATEWAY.jsp" id="pageIG"/>
									</rich:tab>
									<rich:tab id="tbRouting" label="Routing"  
										rendered="#{networkConfigBean.routingCheck}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_ROUTING.jsp" id="pageRT"/>
									</rich:tab>
									<rich:tab id="tbF5" label="F5"  
										rendered="#{networkConfigBean.f5Check}">
										<a4j:include viewId="DataTable/IPSUR003_VIEW_F5.jsp" id="pageF5"/>
									</rich:tab>
							    </rich:tabPanel>
							    </a4j:region>
							</td>
						</tr>
					    <!-- submit part  -->
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									<td width="170" align="left" valign="top">
									 <a4j:commandLink id="urLink" reRender="PopupHistory_NetworkConfig" action="#{historyNwConfigAction.init}" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
										oncomplete="#{rich:component('PopupHistory_NetworkConfig')}.show(); return false" >
										<a4j:actionparam name="urNo" value="#{networkConfigBean.urNo}"/>
									    <h:outputText value="View History"/>
									</a4j:commandLink>

									
									</td>
									<td align="right">
										<h:panelGroup id="buttonGroup">
									    	<a4j:commandButton id="btnSubmit" value="Submit" styleClass="rich-button"
									    		action="#{reqNWConfigAction.ownerApprove}"  rendered="#{networkConfigBean.visibleButtonSubmit}"
									    		reRender="AlertErrorModal"
									    		oncomplete="if(document.getElementById('showFlag').value=='true') Richfaces.showModalPanel('AlertErrorModal'); ">
									    		
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
												action="#{reqNWConfigAction.cancelImpact}"/>
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
	<jsp:directive.include file="popup/IPSUR003_DELEGATE_JOB.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_ASSIGN_PM_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_VIEW_ASSIGN_DETAIL_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_IS_IMPACT_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSUR003_REJECT_POPUP.jsp"/>
    <jsp:directive.include file="../manage/popup/ReqNWConfigHistory.jsp"/>
  
<iframe id="uploadFrameID" name="uploadFrame" height="0" width="0" frameborder="0" scrolling="yes"></iframe>  
<form id="uploadFileForm" name="uploadFileForm" enctype="multipart/form-data" target="uploadFrame"
	method="post" action="/IPFMWeb/servlet/FileSubUrUploadServlet">
	<input type="hidden" name="urNo" id="urNo" value="DetailForm:urNo">
	<input type="hidden" name="urStatus" id="urStatus" value="DetailForm:urStatus">
	<input type="hidden" name="userName" id="userName" value="DetailForm:userName">
	<input type="hidden" name="isAttach" id="isAttach" value="DetailForm:isAttach">
	<input type="hidden" name="catagory" id="catagory" value="NC">
	<input type="hidden" name="description" id="description" value="Request Network Config Attachment">
	<input type="hidden" name="params" id="params" value="">
</form>

</f:view>
</body>
</html>
