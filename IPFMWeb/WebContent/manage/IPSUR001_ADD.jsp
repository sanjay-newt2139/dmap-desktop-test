<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>User Request IP </title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>
<script type="text/javascript" language="javascript" src="../js/attach_file.js"></script>
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>
<script type="text/javascript">
	
	function onBlurProjectId(obj){
		if (obj.value.length==0) onChangeProject();
		return false;
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
					<td align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
				  	<a4j:form id="DetailForm">
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
				  	<table width="98%" style="padding: 0 10px 0 10px;" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   	<tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w">
								<span class="style9">User Request IP</span></strong>
							</td>
					  	</tr>
					   	<tr>
							<td>
								<rich:simpleTogglePanel width="100%" switchType="client" id="reqProfile" label="Requester Profile" >
									<h:panelGroup style="width:100%;">
									<table width="100%" border="0" class="thtext_detail">
									    <tr class="displayRow">   
									    	<td  align="right" class="labelStyle"><strong>Name :</strong>&nbsp;</td>
									    	<td  align="left" class="valueStyle">&nbsp;
									    		<h:outputText value="#{userReqIPBean.ipUrIpDetail.reqName}" />
											</td>
	                                        <td align="right" class="labelStyle"><strong>Department :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle">&nbsp;
										    	<h:outputText id="dept" value="#{userReqIPBean.ipUrIpDetail.reqDept}" />
											</td>
											<td>&nbsp;</td>
										  </tr>
										  <tr class="displayRow">
										  	<td align="right" class="labelStyle"><strong>Email :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle">&nbsp;
										    	<h:outputText id="email" value="#{userReqIPBean.ipUrIpDetail.reqEmail}" />									    
											</td>
											<td align="right" class="labelStyle"><strong>Section :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle" >&nbsp;
										    	<h:outputText id="section" value="#{userReqIPBean.ipUrIpDetail.reqSection}" />
											</td>
											<td>&nbsp;</td>
										  </tr>
										   <tr class="displayRow">
										   	<td align="right" class="labelStyle"><strong>Mobile :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle">&nbsp;
										    	<h:outputText id="mobile" value="#{userReqIPBean.ipUrIpDetail.reqMobile}" />										    
											</td>
										    <td align="right" class="labelStyle"><strong>Position :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle" >&nbsp;
										    	<h:outputText id="position" value="#{userReqIPBean.ipUrIpDetail.reqPosition}" />										    
										    </td>
										    <td>&nbsp;</td>
										  </tr>
										  <tr class="displayRow">
										    <td align="right" class="labelStyle"><strong>Tel :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle">&nbsp;
										    	<h:outputText id="telephone" value="#{userReqIPBean.ipUrIpDetail.reqTel}" />											    
										    </td>
										    <td align="right" class="labelStyle"><strong>Team :</strong>&nbsp;</td>
										    <td align="left" class="valueStyle" >&nbsp;
										    	<h:outputText id="userTeamId" value="#{userReqIPBean.ipUrIpDetail.reqIpTeam.teamName}" />										    
										    </td>
										    <td>&nbsp;</td>
									  	</tr>
								    </table>
								   	</h:panelGroup>
								</rich:simpleTogglePanel>
							</td>
						</tr>
						<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" width="100%" id="profile" label="UR Information" > 
									<h:panelGroup style="width:100%">
										<h:panelGroup id="statusName">
											<h:panelGrid rendered="#{userReqIPBean.mode != 'NEW'}" columns="1" cellpadding="0" cellspacing="0" style="text-align:right; position:absolute; right:5px;">
												<h:outputText value="#{userReqIPBean.ipUrIpDetail.urNo}" style="font-weight:bold; color:#0000FF;" />
												<h:outputText value="#{userReqIPBean.ipUrIpDetail.urStatusName}" style="font-weight:bold; color:#FF0000;" />
											</h:panelGrid>
										</h:panelGroup>
										<table width="100%" border="0" class="thtext_detail">
									     	<tr class="inputRow" >
											    <td  align="right" class="labelStyle"><strong>Subject<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
		                                        <td  align="left" colspan="3" class="valueStyle">
				    	                            <h:inputText id="subject" value="#{userReqIPBean.ipUrIpDetail.subject}" maxlength="1000" size="107"></h:inputText>
				    	                        </td>
				    	                        <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
										    	<td align="right" valign="top" class="labelStyle"><strong>Request from<br/>Planning Team<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											    <td colspan="3"  align="left" class="valueStyle" >
		                                     		<rich:comboBox id="planningTeam" defaultLabel="" 
														enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
													 	width="200" listWidth="195" listHeight="150"
													 	value="#{userReqIPBean.reqTeamComboItem}" >
													 	<f:attribute name="selectItems" value="#{userReqIPBean.reqTeamList}"/>
													 	<f:selectItems value="#{userReqIPBean.reqTeamList}" />
													 	<a4j:support reRender="errorMsg,planningTeam" event="onchange" action="#{userReqIPAction.checkReqTeamCombo}" />
													</rich:comboBox>
		                                       	</td>
		                                       	<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" style="width:100%" >
											    <td align="right" class="labelStyle"><strong>Project ID :</strong>&nbsp;</td>
											    <td align="left" >
											      	<rich:comboBox id="projectId" defaultLabel="" 
										      			 enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
										      			 width="200" listWidth="195" listHeight="150" 
										      			 onchange="onChangeProject();" onblur="onBlurProjectId(this);"
														 value="#{userReqIPBean.projComboItem}" >
														 <f:attribute name="selectItems" value="#{userReqIPBean.projList}"/>
														 <f:selectItems value="#{userReqIPBean.projList}" />
														 <a4j:support reRender="errorMsg" event="onblur" action="#{userReqIPAction.checkProjCombo}"/>
														 <a4j:jsFunction name="onChangeProject" action="#{userReqIPAction.onChangeProject}" oncomplete="#{rich:component('wait')}.hide();" reRender="errorMsg,projectName,projManager" ></a4j:jsFunction>
													</rich:comboBox>							
		                                         </td>
		                                         <td align="right" class="labelStyle"><strong>Project Name :</strong>&nbsp;</td>
											     <td align="left">
											      	<h:inputText id="projectName" size="30" maxlength="1000" value="#{userReqIPBean.ipUrIpDetail.projName}" readonly="#{userReqIPBean.projNameDisable}"></h:inputText>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											    <td align="right" class="labelStyle"><strong>Project Manager :</strong>&nbsp;</td>
											    <td align="left" class="valueStyle" colspan="3">
											    	<h:panelGroup id="projManager" >
												       	<rich:comboBox id="projManagerId" defaultLabel="" enableManualInput="true" inputDisabledStyle="color:black;" rendered="#{false && !userReqIPBean.projManagerDisable}" 
															 itemClass="contentform" itemSelectedClass="contentform" 
															 value="#{userReqIPBean.projManagerComboItem}" 
															 width="200" listWidth="195" listHeight="150" >
															 <f:attribute name="selectItems" value="#{userReqIPBean.projManagerList}"/>
															 <f:selectItems value="#{userReqIPBean.projManagerList}"/>
															 <a4j:support reRender="errorMsg,projManagerId" event="onchange" action="#{userReqIPAction.checkProjManagerCombo}" />
														</rich:comboBox>
														<h:inputText size="33" maxlength="50" value="#{userReqIPBean.ipUrIpDetail.projManagerName}" readonly="true" rendered="#{userReqIPBean.projManagerDisable}"></h:inputText>
														<h:inputText id="managerName" size="33" maxlength="50" value="#{userReqIPBean.ipUrIpDetail.projManagerName}" rendered="#{!userReqIPBean.projManagerDisable}"></h:inputText>
														<rich:suggestionbox rendered="#{!userReqIPBean.projManagerDisable}" id="managerSuggest" for="managerName" usingSuggestObjects="true" suggestionAction="#{userReqIPAction.userSuggestion}" requestDelay="0" 
															 binding="#{userReqIPBean.suggestProjManager}" 
															var="suggest" status="#{rich:component('wait')}.hide();" fetchValue="#{suggest.label}" frequency="0" width="178" >
															<h:column>
																<h:outputText value="#{suggest.label}"/>
															</h:column>
															<a4j:support event="onobjectchange" action="#{userReqIPAction.suggestManager}" status="#{rich:component('wait')}.hide();" />
														</rich:suggestionbox>
													</h:panelGroup>
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
												<td align="right" class="labelStyle"><strong>System Owner :</strong>&nbsp;</td>
												<td align="left">
													<rich:comboBox id="sysOwner" rendered="false" defaultLabel="" enableManualInput="true"  
														itemClass="contentform" itemSelectedClass="contentform" 
														value="#{userReqIPBean.systemOwnerComboItem}"
														width="200" listWidth="195" listHeight="150">
														<f:attribute name="selectItems" value="#{userReqIPBean.systemOwnerList}"/>
														<f:selectItems value="#{userReqIPBean.systemOwnerList}"/>
														<a4j:support reRender="errorMsg,sysOwner" event="onchange" action="#{userReqIPAction.checkSystemOwnerCombo}" />
													</rich:comboBox>
													<h:inputText id="sysOwnerName" size="33" maxlength="50" value="#{userReqIPBean.ipUrIpDetail.sysOwnerName}" ></h:inputText>
													<rich:suggestionbox id="sysOwnerSuggest" binding="#{userReqIPBean.suggestSystemOwner}" for="sysOwnerName" suggestionAction="#{userReqIPAction.userSuggestion}" requestDelay="0" 
														var="suggest" status="#{rich:component('wait')}.hide();" usingSuggestObjects="true" fetchValue="#{suggest.label}" frequency="0" width="178" limitToList="20">
														<h:column>
															<h:outputText value="#{suggest.label}"/>
														</h:column>
														<a4j:support event="onobjectchange" action="#{userReqIPAction.suggestSysOwner}" status="#{rich:component('wait')}.hide();" reRender="errorMsg,systemOwnerTeam,systemOwnerTeamDisp"/>
													</rich:suggestionbox>
		                                        </td>
												<td align="right" class="labelStyle"><strong>System Owner Team :</strong>&nbsp;</td>
												<td align="left">
													<rich:comboBox id="systemOwnerTeam" defaultLabel="" enableManualInput="true" rendered="false"
														itemClass="contentform" itemSelectedClass="contentform" 
														width="185" listWidth="180" listHeight="150"
														value="#{userReqIPBean.systemOwnerTeamComboItem}">
															<f:attribute name="selectItems" value="#{userReqIPBean.systemOwnerTeamList}"/>
															<f:selectItems value="#{userReqIPBean.systemOwnerTeamList}"/>
															<a4j:support reRender="errorMsg,systemOwnerTeam" event="onchange" action="#{userReqIPAction.checkSystemOwnerTeamCombo}" />
													</rich:comboBox>
													<h:inputText id="systemOwnerTeamDisp" size="30" value="#{userReqIPBean.systemOwnerTeamComboItem}"  readonly="true"/>
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
										      <td  align="right" class="labelStyle"><strong>Contact Point :</strong>&nbsp;</td>
						                      <td  align="left" class="valueStyle" colspan="3" >
		                                      	<h:inputText id="contactPoint" maxlength="1000" size="107"  value="#{userReqIPBean.ipUrIpDetail.contactPoint}" />
		                                      </td>
		                                      <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											    <td  align="right" valign="top" class="labelStyle">
											    	<strong>Network System Requirement<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong><br>
											    	<strong>(System Detail)</strong>									    
											    </td>
											    <td align="left"  class="valueStyle" colspan="3">
		                                          	<h:inputTextarea id="networkSystem" rows="3" cols="109"  value="#{userReqIPBean.ipUrIpDetail.nwSysDetail}" />
		                                       </td>
		                                       <td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
											    <td align="right" class="labelStyle">
													<strong>Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;
		                                       </td>
											   <td align="left" class="valueStyle" colspan="3">
													<rich:comboBox id="networkType" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform"
														width="200" listWidth="195" listHeight="150"
														value="#{userReqIPBean.nwTypeComboItem}" >
														<f:attribute name="selectItems" value="#{userReqIPBean.nwTypeList}"/>
														<f:selectItems value="#{userReqIPBean.nwTypeList}"/>
														<a4j:support reRender="errorMsg,networkType" event="onchange" action="#{userReqIPAction.checkNwTypeCombo}" />
													</rich:comboBox>
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
												<td align="right" class="labelStyle"><strong>Request Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
												<td align="left" colspan="3" class="valueStyle">
													<h:selectOneRadio id="booleanValue" styleClass="contentform"
														value="#{userReqIPBean.ipUrIpDetail.reqType}">
														<f:selectItem itemLabel="New Network" itemValue="N" />
														<f:selectItem itemLabel="Expansion Network" itemValue="E" />
														<a4j:support reRender="errorMsg,networkSize" event="onclick" ajaxSingle="true" status="#{rich:component('wait')}.hide();"/>
													</h:selectOneRadio>
												</td>
												<td>&nbsp;</td>
											</tr>	
											<tr id="rowGroupNetwork" style="width:100%;">
												<td class="labelStyle">&nbsp;</td>
												<td align="left" colspan="3">
													<rich:panel id="networkSize" style="width:100%;">
														<h:panelGroup style="width:100%;">
															<table border="0" width="100%" cellpadding="0" cellspacing="0">
																<tr class="inputRow">
																	<td width="145" align="right"><strong><h:outputText value="#{userReqIPBean.ipUrIpDetail.reqType =='N'?'Network Zone Name':'Existing Network Zone'}" /> :</strong>&nbsp;</td>
																	<td colspan="2" >	
																		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
																			<rich:spacer width="5" />	
																			<rich:comboBox id="nwZoneComboItem" defaultLabel="" enableManualInput="true" 
																				itemClass="contentform" itemSelectedClass="contentform" 
																				width="232" listWidth="227" listHeight="150"
																				value="#{userReqIPBean.nwZoneComboItem}">
																				<f:attribute name="selectItems" value="#{userReqIPBean.nwZoneList}"/>
																				<f:selectItems value="#{userReqIPBean.nwZoneList}" />
																				<a4j:support reRender="errorMsg,nwZoneComboItem" event="onchange" action="#{userReqIPAction.checkNwZoneCombo}" />
																			</rich:comboBox>
																		</h:panelGrid>
																    </td>																   
																</tr>
																<h:panelGroup rendered="#{userReqIPBean.ipUrIpDetail.reqType =='E'}">
																<tr class="inputRow">
																	<td width="145" align="right" valign="top" style="padding-top:5px;"><strong>Existing IP Network Ref :</strong>&nbsp;</td>
																	<td colspan="2">
																		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
																			<rich:spacer width="5" />	
			                                                            	<h:inputText value="#{userReqIPBean.ipUrIpDetail.ipRef}" maxlength="1000" style="width:230" ></h:inputText>
			                                                            </h:panelGrid>
																    </td>			    
																</tr>
																</h:panelGroup>
																<tr class="inputRow">
																	<td width="145" align="right" valign="top" style="padding-top:5px;"><strong>Site/Location :</strong>&nbsp;</td>
																	<td rowspan="2" width="105" valign="top">
																		<h:selectOneRadio style="width:93px;" styleClass="contentform" 
																			value="#{userReqIPBean.ipUrIpDetail.locationType}" layout="pageDirection">
																			<f:selectItem itemLabel="Data Center" itemValue="D" />
																			<f:selectItem itemLabel="Office User" itemValue="O" />
																			<a4j:support event="onclick" action="#{userReqIPAction.onChangeLocationType}" status="#{rich:component('wait')}.hide();" reRender="dataComboItem,officeUserComboItem" />
																	    </h:selectOneRadio>	
																    </td>
																    <td rowspan="2">
																    	<h:panelGrid columns="1" cellpadding="0" cellspacing="5">
																		   	<rich:comboBox id="dataComboItem" defaultLabel="" enableManualInput="true" 
																				itemClass="contentform" itemSelectedClass="contentform" 
																				width="127" listWidth="122" listHeight="150" disabled="#{userReqIPBean.ipUrIpDetail.locationType=='O'}"
																				value="#{userReqIPBean.dataComboItem}" >
																				<f:attribute name="selectItems" value="#{userReqIPBean.dataList}"/>
																				<f:selectItems value="#{userReqIPBean.dataList}"/>
																				<a4j:support reRender="errorMsg,dataComboItem" event="onchange" action="#{userReqIPAction.checkDataCombo}" />
																			</rich:comboBox>
																			
																			<rich:comboBox id="officeUserComboItem" defaultLabel="" enableManualInput="true" 
																				itemClass="contentform" itemSelectedClass="contentform" 
																				width="127" listWidth="122" listHeight="150" disabled="#{userReqIPBean.ipUrIpDetail.locationType=='D'}"
																				value="#{userReqIPBean.officeUserComboItem}" >
																				<f:attribute name="selectItems" value="#{userReqIPBean.officeUserList}"/>
																				<f:selectItems value="#{userReqIPBean.officeUserList}"/>
																				<a4j:support reRender="errorMsg,officeUserComboItem" event="onchange" action="#{userReqIPAction.checkOfficeUserCombo}" />
																			</rich:comboBox>
																		</h:panelGrid>
																    </td> 
																</tr>
															</table>
														</h:panelGroup>
													</rich:panel>
												</td>
												<td>&nbsp;</td>
											</tr>	
											<tr>
											 	<td align="right" valign="top" class="labelStyle" ><strong>Network Size<h:graphicImage  value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											 	<td colspan="3">
											  		<rich:panel>
		                                       			<table border="0" width="67%" >
														    <tr>
															    <td align="left" style=" width : 497px;">
																	<table width="67%" border="0" cellspacing="0"
																		cellpadding="0">
																		<tr>
																			<td  align="right" style=" width : 145px;"><strong>Total Node</strong>&nbsp;</td>
																			<td  align="left" style=" width : 60px;">
																				<h:inputText id="totalNode" value="#{userReqIPBean.ipUrIpDetail.totalNodeStr}" maxlength="8" size="5" style="text-align:right" 
																					onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											                     					onblur="this.value = isNumber(this);"/>
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
																				<h:inputText id="classB" value="#{userReqIPBean.ipUrIpDetail.classBStr}" maxlength="8" size="5" style="text-align:right" 
																					onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											                     					onblur="this.value = isNumber(this);"/>
																			</td>
																			<td width="49" align="left"><strong>Network</strong></td>
																		</tr>
																	</table>
																</td>
															</tr>
															<tr>
															    <td  align="left" style=" width : 497px;">
																	<table width="67%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																			<td  align="right" style=" width : 145px;"><strong>Class C</strong>&nbsp;</td>
																			<td  align="left" style=" width : 60px;">
																			  <h:inputText id="classC" maxlength="8" size="5" style="text-align:right" value="#{userReqIPBean.ipUrIpDetail.classCStr}" 
																			   		onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											                     					onblur="this.value = isNumber(this);"/>
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
											<tr class="inputRow">
												<td align="right" rowspan="3" class="labelStyle"  valign="top"><strong>Network Diagram :</strong>&nbsp;</td>	
												<td valign="top" width="230" style="padding:0px;">
													<h:panelGroup id="attachFileNW">
														<jsp:directive.include file="../home/tableAttachFile1.jsp"/>
													</h:panelGroup>
										   		</td>										  
											  	<td align="right" valign="top" >
													<table border="0" cellpadding="0" cellspacing="0" >
												  		<tr class="inputRow">
													   		<td class="labelStyle"><strong>Application Flow&nbsp;:</strong>&nbsp;</td>
													  	</tr>
													</table>		 
											  	</td>	 
											  	<td valign="top" width="230" style="padding:0px;">	
											  		<h:panelGroup id="attachFileAF">
											  			<jsp:directive.include file="../home/tableAttachFile2.jsp"/>
											  		</h:panelGroup>
										   		</td>
										   		<td>&nbsp;</td>
									  		</tr>			
											<tr>
												<td  colspan="4" style="COLOR: #0000ff;"><h:graphicImage value="../images/icon_required.gif" style="border:0" /> File Size ไม่เกิน  8 MB</td>
											</tr>
											<tr>
												<td  colspan="4" style="COLOR: #0000ff;"><h:graphicImage value="../images/icon_required.gif" style="border:0" /> File Type ที่สามารถรองรับได้  .doc, .docx, .xls, .xlsx, .vsd, .jpg, .gif, .svg, .zip, .rar, .7z</td>
											</tr>
									    </table>
									</h:panelGroup>
								</rich:simpleTogglePanel>
								<rich:simpleTogglePanel width="100%" switchType="client" id="approv" label="Approve Manager" >
							  		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
								     	<tr class="inputRow">
									        <td width="150"></td>
									        <td colspan="3" align="left" >
								  		 		<table border="0" width="300" align="left" cellpadding="0" cellspacing="0" >
													<tr>
													    <td align="center" width="8"><rich:spacer width="0" /></td>
														<td height="22" background="../images/title_bar.png"  align="left" width="142" ><rich:spacer width="3"/><h:outputText value="Manager" styleClass="contentform tableHeaderText"/></td>
													    <td align="center" width="51" ><rich:spacer width="0" /></td>
												        <td height="22" background="../images/title_bar.png"  align="left" width="142" ><rich:spacer width="4"/><h:outputText value="Approve Manager" styleClass="contentform tableHeaderText"/></td>
												    </tr>
													<tr>
														<td colspan="4">
													        <rich:pickList listsHeight="80" removeAllVisible="false" copyAllVisible="false"
												        		copyControlLabel=" " removeControlLabel=" " styleClass="" 
												        		value="#{userReqIPBean.selectManagerApproveList}" >
												        		<f:attribute name="selectItems" value="#{userReqIPBean.managerApproveList}"/>
													 			<f:selectItems value="#{userReqIPBean.managerApproveList}" />
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
						<tr align="right">
							<td align="right">
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="230">
											<a4j:commandLink rendered="#{userReqIPBean.mode!='NEW'}" reRender="IPSUR001_HISTORY" action="#{userReqIPAction.popupHistory}"  style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
								      	            oncomplete="#{rich:component('IPSUR001_HISTORY')}.show(); return false" >
								      	            <h:outputText value="View History"/>
								            </a4j:commandLink>
										</td>
										<td colspan="5" align="right" >
											<h:panelGroup id="buttonGroup">
										    	<a4j:commandButton id="btnSaveDraft" value="Save Draft" styleClass="rich-button" action="#{userReqIPAction.saveDraft}" reRender="errorMsg,attachForm,buttonGroup,function,statusName,attachFileNW,attachFileAF" oncomplete="reloadTree();">
											    </a4j:commandButton>
												<rich:spacer width="10"></rich:spacer>
												<a4j:commandButton id="btnSendApprove" value="Send for Approve" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
													<rich:componentControl for="confirmSendForApproveURModal" operation="show" event="onclick" />
											    </a4j:commandButton>
											    <rich:spacer width="10"></rich:spacer>
												<a4j:commandButton id="btnDelete" rendered="#{userReqIPBean.mode=='EDIT'}" value="Delete UR" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
													<rich:componentControl for="confirmDeleteURModal" operation="show" event="onclick" />
												</a4j:commandButton>
												<rich:spacer rendered="#{userReqIPBean.mode=='EDIT'}" width="10"></rich:spacer>
												<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
													<rich:componentControl for="confirmCancelModal" operation="show" event="onclick" />
												</a4j:commandButton>
											</h:panelGroup>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<h:panelGroup id="attachForm">
					<h:inputHidden id="isAttach1" value="#{userReqIPBean.isAttach1}" />									    			
					<h:inputHidden id="isAttach2" value="#{userReqIPBean.isAttach2}" />									    			
					<h:inputHidden id="urNo1" value="#{userReqIPBean.ipUrIpDetail.urNo}" />
					<h:inputHidden id="userName1" value="#{userSession.ipUser.userId}" />
					<h:inputHidden id="urNo2" value="#{userReqIPBean.ipUrIpDetail.urNo}" />
					<h:inputHidden id="userName2" value="#{userSession.ipUser.userId}" />
					<h:inputHidden id="urNo" value="#{userReqIPBean.ipUrIpDetail.urNo}" />
					<h:inputHidden id="userName" value="#{userSession.ipUser.userId}" />
					<h:inputHidden id="mode" value="#{userReqIPBean.mode}" />					
					</h:panelGroup>
				</a4j:form>
				</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	<f:subview id="footer">
		<a4j:include viewId="../home/progress.jsp" />
	</f:subview>
	<a4j:include viewId="popup/IPSUR001_HISTORY.jsp" />
	<a4j:include viewId="popup/IPSUR001_AttachFile.jsp" />
	<a4j:include viewId="../home/confirmCancel.jsp" />
	<a4j:include viewId="../home/confirmDeleteUR.jsp" />
	
	<h:panelGroup id="function">
		<rich:modalPanel id="confirmSendForApproveURModal" width="350" minHeight="100" autosized="true">			
			<f:facet name="header">
				<h:panelGroup>
					<h:outputText value="Confirm Send For Approve UR"></h:outputText>
				</h:panelGroup>
		   	</f:facet>
		   	<h:panelGroup style="width:100%;">
		   		<a4j:form>
					<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
						<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0004}" /></h:panelGroup>
						<rich:spacer height="5"/>
						<h:panelGroup>
							<a4j:commandButton value="Yes" action="#{userReqIPAction.sendForApprove}" reRender="errorMsg" styleClass="rich-button" style="width:50px;">
								<rich:componentControl for="confirmSendForApproveURModal" operation="hide" event="oncomplete" />
							</a4j:commandButton>
							<rich:spacer width="10" />
							<a4j:commandButton value="No" styleClass="rich-button" ajaxSingle="true" style="width:50px;" status="#{rich:component('wait')}.hide();">
							    <rich:componentControl for="confirmSendForApproveURModal" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGroup>
					</h:panelGrid>
				</a4j:form>
			</h:panelGroup>
		</rich:modalPanel>
		<rich:modalPanel id="confirmDeleteURModal" width="350" minHeight="100" autosized="true">
		    <f:facet name="header">
				<h:panelGroup>
					<h:outputText value="Confirm Delete UR"></h:outputText>
				</h:panelGroup>
			</f:facet>	
			<h:panelGroup style="width:100%;">
		   		<a4j:form>
					<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
						<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0003}" /></h:panelGroup>
						<rich:spacer height="5"/>
						<h:panelGroup>
							<a4j:commandButton value="Yes" action="#{userReqIPAction.deleteUR}" reRender="errorMsg" styleClass="rich-button" style="width:50px;">
								<rich:componentControl for="confirmDeleteURModal" operation="hide" event="oncomplete" />
							</a4j:commandButton>
							<rich:spacer width="10" />
							<a4j:commandButton value="No" styleClass="rich-button"  ajaxSingle="true" style="width:50px;" status="#{rich:component('wait')}.hide();">
							    <rich:componentControl for="confirmDeleteURModal" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGroup>
					</h:panelGrid>
				</a4j:form>
			</h:panelGroup>	
	    </rich:modalPanel>
	</h:panelGroup>
	<iframe id="uploadFrameID" name="uploadFrame" height="0" width="0" frameborder="0" scrolling="yes"></iframe>
	<form id="uploadFileForm1" name="uploadFileForm1" enctype="multipart/form-data" target="uploadFrame"
		method="post" action="/IPFMWeb/servlet/FileUploadServlet">
		<input type="hidden" name="urNo1" id="urNo1" value="DetailForm:urNo1">
		<input type="hidden" name="userName1" id="userName1" value="DetailForm:userName1">
		<input type="hidden" name="isAttach1" id="isAttach1" value="DetailForm:isAttach1">
		<input type="hidden" name="catagory" id="catagory" value="NW">
		<input type="hidden" name="description" id="description" value="User Request IP Attachment">
		<input type="hidden" name="index" id="index" value="1">
		<input type="hidden" name="params" id="params" value="">
	</form>
	<form id="uploadFileForm2" name="uploadFileForm2" enctype="multipart/form-data" target="uploadFrame"
		method="post" action="/IPFMWeb/servlet/FileUploadServlet">
		<input type="hidden" name="urNo2" id="urNo2" value="DetailForm:urNo2">
		<input type="hidden" name="userName2" id="userName2" value="DetailForm:userName2">
		<input type="hidden" name="isAttach2" id="isAttach2" value="DetailForm:isAttach2">
		<input type="hidden" name="catagory" id="catagory" value="AF">
		<input type="hidden" name="description" id="description" value="User Request IP Attachment">
		<input type="hidden" name="index" id="index" value="2">
		<input type="hidden" name="params" id="params" value="">
	</form>
</f:view>
</body>
</html>