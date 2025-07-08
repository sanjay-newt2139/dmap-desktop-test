<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>User Request IP</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>
<script type="text/javascript" language="javascript" src="../js/attach_file.js"></script>
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>
<script language="javascript">

function showRow(chk){
         if(chk=='N'){
		   document.getElementById("rowGroupNetwork").style.display = "none";
         }else{
           document.getElementById("rowGroupNetwork").style.display = "inline";
         }
}
</script>	
<style type="text/css">
	.rich-combobox-font-disabled {color:#000000;}
	.rich-sb-int {background-color: #FFFFFF;}
	.richfaces_suggestionEntry  {background-color: #FFFFFF;}
	.rich-sb-int-sel {background-color: #FFFFFF;}
	.richfaces_suggestionSelectValue {color: #FFFFFF;}
</style>

</head>
<body style="overflow: hidden;">

<f:view>
	<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />
	</f:subview>
	<f:subview id="error">
		<jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br>
	<br>
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
						  <h:inputHidden id="urNo" value="#{planningReqIPBean.ipUrIpdetail.urNo}"></h:inputHidden>
						   <h:inputHidden id="userName" value="#{userSession.ipUser.userId}"></h:inputHidden>
						<table width="98%" border="0" bgcolor="#CCCCCC"
							class="thtext_detail2">
							<tr>
								<td height="25" bgcolor="#1f4986"
									align="left" valign="middle"><img
									src="../images/ico_member.gif" alt="" width="23" height="15">
								<strong class="ms10w"> <span class="style9">Planning Request IP</span></strong></td>
							</tr>
							
							<tr>
								<td><rich:simpleTogglePanel switchType="client"  width="100%"  id="reqProfile" label="Requester Profile">
								    <h:panelGroup style="width:100%;">
									<table width="100%" border="0" class="thtext_detail">
										<tr class="displayRow">
											<td width="150" align="right" class="labelStyle" ><strong>Name :</strong>&nbsp;</td>
											<td width="230" align="left" class="valueStyle">
											   <h:outputText  value="#{userSession.ipUser.userName}">
											</h:outputText></td>
											<td align="right" class="labelStyle"><strong>Department :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
											   <h:outputText id="dept" value="#{userSession.ipUser.dept}">
											</h:outputText></td>
											<td>&nbsp;</td>
										</tr>
										<tr class="displayRow">
											<td align="right" class="labelStyle"><strong>Email :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
											    <h:outputText id="email"  value="#{userSession.ipUser.email}">
											</h:outputText></td>
											<td width="150" align="right" class="labelStyle"><strong>Section :</strong>&nbsp;</td>
											<td width="230" align="left" class="valueStyle">
											     <h:outputText id="section" value="#{userSession.ipUser.section}">
											</h:outputText></td>
											<td>&nbsp;</td>
										</tr>
										<tr class="displayRow">
											<td align="right" class="labelStyle"><strong>Mobile :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
											   <h:outputText id="mobile" value="#{userSession.ipUser.mobile}">
											</h:outputText></td>
											<td align="right" class="labelStyle"><strong>Position :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
											   <h:outputText id="position"
												value="#{userSession.ipUser.position}">
											</h:outputText></td>
											<td>&nbsp;</td>
										</tr>
										<tr class="displayRow">
											<td align="right" class="labelStyle"><strong>Tel :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
											   <h:outputText id="telephone" value="#{userSession.ipUser.tel}">
											</h:outputText></td>
											<td align="right" class="labelStyle"><strong>Team :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
											  <h:outputText id="userTeamId" value="#{userSession.ipUser.teamName}">
											</h:outputText></td>
											<td>&nbsp;</td>
										</tr>
									</table>
								 </h:panelGroup>
								</rich:simpleTogglePanel></td>
							</tr>
							<tr>
								<td><rich:simpleTogglePanel switchType="client"  width="100%"  id="profile" label="UR Information">
									   <h:panelGroup style="width:100%">
										<h:panelGroup id="statusName">
											<h:panelGrid  columns="1" cellpadding="0" cellspacing="0" style="text-align:right; position:absolute; right:5px;">
												<h:outputText value="#{planningReqIPBean.v_urNo}" style="font-weight:bold; color:#0000FF;" />
												<h:outputText value="#{planningReqIPBean.v_urStatusDesc}" style="font-weight:bold; color:#FF0000;" />
											</h:panelGrid>
										</h:panelGroup>
									<table width="100%" border="0" class="thtext_detail">
										<tr class="inputRow">
											<td align="right" class="labelStyle">
											   <strong>Subject<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											<td align="left" colspan="3">
											   <h:inputText id="subject" value="#{planningReqIPBean.ipUrIpdetail.subject}" style="width:525px;">
											  </h:inputText>
										   </td>
										   <td>&nbsp;</td>
										</tr>
										<tr class="inputRow">
											<td align="right" class="labelStyle"><strong>System Owner :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
												<rich:comboBox id="ownerTeamId" defaultLabel="" rendered="false"
													enableManualInput="true"  itemClass="contentform"
													itemSelectedClass="contentform" value="#{planningReqIPBean.systemOwnerComboItem}" width="160">
													<f:attribute name="selectItems" value="#{planningReqIPBean.systemOwnerList}"/>
													<f:selectItems value="#{planningReqIPBean.systemOwnerList}"/>
												</rich:comboBox>
												<h:inputText id="sysOwnerName" size="30" maxlength="50" value="#{planningReqIPBean.ipUrIpdetail.sysOwnerName}" ></h:inputText>
												<rich:suggestionbox id="sysOwnerSuggest" binding="#{planningReqIPBean.suggestSystemOwner}" for="sysOwnerName"
													suggestionAction="#{planningReqIPAction.userSuggestion}" requestDelay="0" 
													var="suggest" status="#{rich:component('wait')}.hide();" usingSuggestObjects="true" fetchValue="#{suggest.label}" frequency="0" width="178">
													<h:column>
														<h:outputText value="#{suggest.label}"/>
													</h:column>
													<a4j:support event="onobjectchange" action="#{planningReqIPAction.suggestSysOwner}" status="#{rich:component('wait')}.hide();" reRender="errorMsg,systemOwnerTeam,systemOwnerTeamDisp"/>
												</rich:suggestionbox>
                                            </td>
											<td align="right" class="labelStyle"><strong>System Owner Team :</strong>&nbsp;</td>
											<td align="left" class="valueStyle">
												<rich:comboBox id="systemOwnerTeam" rendered="false"
													defaultLabel="" enableManualInput="true" 
													itemClass="contentform" itemSelectedClass="contentform"
													value="#{planningReqIPBean.systemOwnerTeamComboItem}" width="160">
														<f:attribute name="selectItems" value="#{planningReqIPBean.systemOwnerTeamList}"/>
														<f:selectItems value="#{planningReqIPBean.systemOwnerTeamList}"/>
														<a4j:support reRender="errorMsg,systemOwnerTeam" event="onchange" action="#{planningReqIPAction.checkSystemTeamOwenCombo}" />
												</rich:comboBox>
												<h:inputText id="systemOwnerTeamDisp" size="22" value="#{planningReqIPBean.systemOwnerTeamComboItem}"  readonly="true"/>
											</td>
											<td>&nbsp;</td>
										</tr>
										<tr class="inputRow">
											<td align="right" class="labelStyle"><strong>Contact Point :</strong>&nbsp;</td>
											<td align="left" colspan="3" class="valueStyle"><h:inputText
												id="contactPoint" size="15" style="width:525px;"
												value="#{planningReqIPBean.ipUrIpdetail.contactPoint}"></h:inputText>&nbsp;
											</td>
											<td>&nbsp;</td>
										</tr>
										<tr class="inputRow">
											<td align="right" valign="top" class="labelStyle"><strong><h:outputText title="Network System Requirement" value="Network System Requirement" ></h:outputText><h:graphicImage
												value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong><br>
											<strong>(System Detail)</strong></td>
											<td align="left" class="valueStyle" colspan="3" ><h:inputTextarea id="networkSystem" 
												rows="3" cols="65" value="#{planningReqIPBean.ipUrIpdetail.nwSysDetail}" style="width:525px;">
											</h:inputTextarea></td>
											<td>&nbsp;</td>
										</tr>
										<tr class="inputRow">
											<td align="right" class="labelStyle">
												  <strong>Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;
											</td>
											<td align="left"  class="valueStyle" colspan="3">
											   <rich:comboBox
												id="networkType" defaultLabel="" enableManualInput="true" 
												itemClass="contentform" itemSelectedClass="contentform"
												value="#{planningReqIPBean.nwTypeComboItem}" width="160">
													<f:attribute name="selectItems" value="#{planningReqIPBean.nwTypeList}"/>
													<f:selectItems value="#{planningReqIPBean.nwTypeList}"/>
													<a4j:support reRender="errorMsg,networkType" event="onchange" action="#{planningReqIPAction.checkNetworkTypeCombo}" />
											  </rich:comboBox></td>
											<td>&nbsp;</td>
										</tr>
										<tr class="inputRow">
											<td align="right" class="labelStyle"><strong>Request Type<h:graphicImage
												value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											<td align="left" colspan="3" class="valueStyle">
											<h:selectOneRadio
												id="booleanValue" styleClass="contentform" 
												value="#{planningReqIPBean.ipUrIpdetail.reqType}">
												<f:selectItem itemLabel="New Network" itemValue="N"  />
												<f:selectItem itemLabel="Expansion Network" itemValue="E" />
												<a4j:support reRender="DetailForm" event="onclick" oncomplete="showRow('#{planningReqIPBean.ipUrIpdetail.reqType}')"/>
											</h:selectOneRadio></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td class="labelStyle"><strong><h:outputLabel value="Network Zone Name" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='N'}" /><h:outputLabel value="Existing Network Zone" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}" />  :</strong>&nbsp;</td>
											<td align="left" colspan="3">
														<rich:comboBox id="networkZoneName"  
															defaultLabel="" enableManualInput="true" 
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{planningReqIPBean.nwZoneComboItem}" width="160">
															<f:attribute name="selectItems" value="#{planningReqIPBean.nwZoneList}"/>
															<f:selectItems value="#{planningReqIPBean.nwZoneList}"/>
															<a4j:support reRender="errorMsg,networkZoneName" event="onchange" action="#{planningReqIPAction.checkNetworkZoneCombo}" />
														</rich:comboBox>
									    	</td>
									    	<td>&nbsp;</td>
									    </tr>
									    <tr id="inputRow" style="display: none;">
											<td class="labelStyle"><strong><h:outputLabel value="Existing IP Network Ref"></h:outputLabel>  :</strong>&nbsp;</td>
											<td align="left" colspan="3">
                                                  <h:inputText value="#{planningReqIPBean.ipUrIpdetail.ipRef}" style="width:140" ></h:inputText>
									    	</td>
									    	<td>&nbsp;</td>
									    </tr>

										<tr class="inputRow">
											<td align="right" valign="top" class="labelStyle" ><strong>Connected Existing AIS :</strong>&nbsp;</td>
										    <td  align="left" colspan="3">
											 <rich:panel>
											  <table border="0" width="67%" cellpadding="0" cellspacing="0">
												<tr>
													<td width="145" align="right"><strong>Network System Plane :</strong>&nbsp;</td>
													<td width="239" align="left">
													   <h:inputText id="networkPlane" size="25" value="#{planningReqIPBean.ipUrIpdetail.systemPlane}"></h:inputText>
													</td>
												</tr>
												<tr>
													<td width="145" align="right"><strong>User Plane :</strong>&nbsp;</td>
													<td width="239" align="left">
													   <h:inputText id="userPlane" size="25" value="#{planningReqIPBean.ipUrIpdetail.userPlane}"></h:inputText>
													</td>
												</tr>
										      </table>
										     </rich:panel>
										    </td>
										    <td>&nbsp;</td>
										</tr>
										 <tr>
										 <td align="right" valign="top" class="labelStyle" ><strong>Network Size<h:graphicImage  value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
										 <td colspan="3">
										  <rich:panel >
                                          <table  width="67%" >
										    <tr>
											    <td  align="left" style=" width : 497px;">
													<table width="67%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td  align="right" style=" width : 145px;"><strong>Total Node</strong>&nbsp;</td>
															<td  align="left" style=" width : 60px;">
															    <h:inputText id="totalNode" size="5" style="text-align:right" value="#{planningReqIPBean.ipUrIpdetail.totalNodeStr}"
															     onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											                     onblur="this.value = isNumber(this);">
											                    </h:inputText>
											               </td>
															<td width="49" align="left"><strong>Hosts</strong></td>
														</tr>
													</table>
													</td>
												</tr>
												<tr>
											    <td  align="left" style=" width : 497px;">
													<table width="67%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td align="right" style=" width : 145px;"><strong>Class B</strong>&nbsp;</td>
															<td align="left" style=" width : 60px;">
															   <h:inputText id="classB" size="5" style="text-align:right" value="#{planningReqIPBean.ipUrIpdetail.classBStr}"
															     onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											                     onblur="this.value = isNumber(this);">
															   </h:inputText>
														    </td>
															<td width="49" align="left"><strong>Network</strong></td>
														</tr>
													</table>
													</td>
												</tr>
												<tr>
											    <td  align="left" style=" width : 497px;">
													<table width="67%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td  align="right" style=" width : 145px;"><strong>Class C</strong>&nbsp;</td>
															<td  align="left" style=" width : 60px;">
															   <h:inputText id="classC" size="5" style="text-align:right" value="#{planningReqIPBean.ipUrIpdetail.classCStr}"
															      onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											                      onblur="this.value = isNumber(this);">
															   </h:inputText>
															</td>
															<td width="49" align="left"><strong>Network</strong></td>
														</tr>
													</table>
													</td>
												</tr>
											</table>
										  </rich:panel>
										  </td>
										  <td>&nbsp;</td>
										 </tr>
										  <tr class="displayRow">
										    <td class="labelStyle" valign="top"><strong>Attach File&nbsp;:&nbsp;</strong></td>
										    <td class="valueStyle" colspan="3">
										    	<h:inputHidden id="isAttach" value="#{networkConfigBean.isAttach}"></h:inputHidden>
										    	<jsp:directive.include file="../home/tableAttachFile.jsp"/>
											</td>
											<td>&nbsp;</td>
										 </tr>
										</table>
										</h:panelGroup>
							            </rich:simpleTogglePanel>				
							           </td>
										</tr>
										 <tr>
												<td align="right">
												<table width="95%" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td align="left"  width="230 ">
						                             		 <a4j:commandLink id="urLink" reRender="IPURS004_05Popup" action="#{planningReqIPAction.popupHistory}" rendered="#{planningReqIPBean.buttonDeleteVisible}"  style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
												      	            oncomplete="#{rich:component('IPURS004_05Popup')}.show(); return false" >
												      	            <h:outputText value="View History"/>
												             </a4j:commandLink>
														</td>
														<td align="right" colspan="5">
														 <h:panelGroup id="buttonGroup">
															<a4j:commandButton id="btnSaveDraft" value="Save Draft"
																 styleClass="rich-button" action="#{planningReqIPAction.saveDraft}"
																reRender="DetailForm,errorMsg" oncomplete="reloadTree();">
															</a4j:commandButton>&nbsp;
															<a4j:commandButton id="btnSend" value="Send for Assign" styleClass="rich-button">
															    <rich:componentControl for="confirmSendForAssignURModal" operation="show" event="onclick" />
															</a4j:commandButton>&nbsp;
															<a4j:commandButton id="btnreject" value="Delete UR"
																styleClass="rich-button" action="#{planningReqIPAction.updateValueBeforeDeleteUR}" rendered="#{planningReqIPBean.buttonDeleteVisible}" oncomplete="#{rich:component('delconfirm')}.show();">
																<a4j:actionparam name="urNoParam" value="#{planningReqIPBean.ipUrIpdetail.urNo}"/>
															</a4j:commandButton>&nbsp;
															<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" >	
															    <rich:componentControl for="confirmCancelModal" operation="show" event="onclick" />
															</a4j:commandButton>
														</h:panelGroup></td>
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
					<td></td>
				</tr>
				<tr>
					<td><h:panelGrid columns="1" styleClass="contentlabelform">
						<a4j:commandButton value="Cancel" styleClass="rich-button"
							immediate="true">
							<rich:componentControl for="confirmDialog" operation="hide"
								event="onclick" />
						</a4j:commandButton>
					</h:panelGrid></td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>
	
    
	<rich:modalPanel id="delconfirm" width="350" height="120">			
		
		   <f:facet name="header">
			  <h:panelGroup>
				<h:outputText value="Delete UR"></h:outputText>
			  </h:panelGroup>
		   </f:facet>
		   <a4j:form id="delURConfirmDialog">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this UR?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;">
							<h:panelGroup>
								<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
									action="#{planningReqIPAction.deleteUR}" reRender="DetailForm,errorMsg" >
									<rich:componentControl for="delconfirm" operation="hide" event="onclick"  />
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
	
<iframe id="uploadFrameID" name="uploadFrame" height="0" width="0" frameborder="0" scrolling="yes"></iframe>
<form id="uploadFileForm" name="uploadFileForm" enctype="multipart/form-data" target="uploadFrame"
	method="post" action="/IPFMWeb/servlet/FileUploadServlet">
	<input type="hidden" name="urNo" id="urNo" value="DetailForm:urNo">
	<input type="hidden" name="userName" id="userName" value="DetailForm:userName">
	<input type="hidden" name="isAttach" id="isAttach" value="DetailForm:isAttach">
	<input type="hidden" name="catagory" id="catagory" value="NW">
	<input type="hidden" name="description" id="description" value="Planning User Request Attachment">
	<input type="hidden" name="params" id="params" value="">
</form>
<rich:modalPanel id="confirmSendForAssignURModal" width="350" minHeight="100" autosized="true">			
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Confirm Send For Assign UR"></h:outputText>
		</h:panelGroup>
   	</f:facet>
   	<h:panelGroup style="width:100%;">
   		<a4j:form>
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
				<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0012}" /></h:panelGroup>
				<rich:spacer height="5"/>
				<h:panelGroup>
					<a4j:commandButton value="Yes" action="#{planningReqIPAction.sendForAssign}" reRender="errorMsg" styleClass="rich-button" style="width:50px;">
						<rich:componentControl for="confirmSendForAssignURModal" operation="hide" event="oncomplete" />
					</a4j:commandButton>
					<rich:spacer width="10" />
					<a4j:commandButton value="No" styleClass="rich-button" ajaxSingle="true" style="width:50px;" status="#{rich:component('wait')}.hide();">
					    <rich:componentControl for="confirmSendForAssignURModal" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</h:panelGroup>
</rich:modalPanel>
	<jsp:directive.include file="popup/IPSUR002_HISTORY.jsp"/>
	<jsp:include page="popup/IPSUR002_AttachFile.jsp" />
	<a4j:include viewId="../home/confirmCancel.jsp" />
	
<%-- 	<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/> --%>
	
<%--     <a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" /> --%>
</f:view>
</body>
</html>
