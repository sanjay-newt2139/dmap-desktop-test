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

<script language="javascript">

function showRow(){
   document.getElementById("rowGroupNetwork").style.display = "inline";
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
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w">
								<span class="style9">User Request IP</span></strong>
							</td>
					  </tr>
					  <tr bgcolor="#f3f2f2" style="display: none" >
                             <td height="25" align="left" valign="middle">
                             <table border="0" width="100%">
                             	<tr>
                             		<td width="160" align="right"><span class="HeaderLabel"><strong>UR No&nbsp;:&nbsp;</strong></span></td>
                             		<td width="140"><span class="HeaderLabel">IP2010000001</span></td>
                             		<td width="380"  align="right"><span class="statusID">Draft UR</span></td>
                             		<td>&nbsp;</td>
                             	</tr>
                             </table>
                             </td>
					  </tr>
					   <tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="reqProfile" label="Requester Profile" >
									<table width="97%" border="0" class="thtext_detail">
								    <tr class="displayRow">   
								    	<td  align="right" class="labelStyle"><strong>Name :</strong>&nbsp;</td>
								    	<td  align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="userName" value="#{userSession.ipUser.userName}">
											</h:outputText>
										</td>
                                        <td align="right" class="labelStyle"><strong>Department :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="dept" value="#{userSession.ipUser.dept}">
											</h:outputText>
										</td>
										<td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									  	<td align="right" class="labelStyle"><strong>Email :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="email" value="#{userSession.ipUser.email}">
											</h:outputText>									    
										</td>
										<td align="right" class="labelStyle"><strong>Section :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="section" value="#{userSession.ipUser.section}">
											</h:outputText>
										</td>
										<td>&nbsp;</td>
									  </tr>
									   <tr class="displayRow">
									   	<td align="right" class="labelStyle"><strong>Mobile :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="mobile" value="#{userSession.ipUser.mobile}">
											</h:outputText>										    
										</td>
									    <td align="right" class="labelStyle"><strong>Position :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="position" value="#{userSession.ipUser.position}">
											</h:outputText>										    
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Tel :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="telephone" value="#{userSession.ipUser.tel}">
											</h:outputText>											    
									    </td>
									    <td align="right" class="labelStyle"><strong>Team :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="userTeamId" value="#{userSession.ipUser.userTeamId}">
											</h:outputText>										    
									    </td>
									    <td>&nbsp;</td>
									  </tr>
								    </table>
								</rich:simpleTogglePanel>
							</td>
						</tr>
						<tr>
							<td>
							<rich:simpleTogglePanel switchType="client" id="profile" label="UR Information" > 
									<table width="97%" border="0" class="thtext_detail">
								     <tr class="inputRow" >
									    <td  align="right" class="labelStyle"><strong>Subject<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
                                        <td  align="left" colspan="3" class="valueStyle">
		    	                            <h:inputText id="subject" value="Request from Planning Team" style="width:525px;">									    	</h:inputText></td>
									</tr>
									<tr class="inputRow" >
									    <td align="right" valign="top" class="labelStyle"><strong>Request from Planning Team<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;	</td>
									    <td colspan="3"  align="left" class="valueStyle">
                                        	  <rich:comboBox id="planningTeam" defaultLabel="IP-WSP" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												 value="#{userReqIPBean.REQ_TEAM}" width="150">
											 <f:selectItem itemValue="IP-WSP"/>
										     </rich:comboBox>
                                        </td>
									</tr>
									<tr class="inputRow" >
									    <td align="right" class="labelStyle"><strong>Project ID :</strong></td>
									    <td align="left" colspan="3" class="valueStyle" >
									      <h:panelGrid id="groupProject" columns="3" border="0" cellpadding="0" cellspacing="0" >
									    	<rich:comboBox id="projectId" defaultLabel="" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												 value="PRJ001" width="150">
												  <f:selectItem itemValue="PRJ001"/>
											</rich:comboBox>&nbsp;
                                        	<h:inputText id="projectName"  size="30" style="width:376px;"  value="Project One"></h:inputText>
                                         </h:panelGrid>										</td>
									</tr>
									<tr class="inputRow" >
									    <td align="right" class="labelStyle"><strong>Project Manager :</strong></td>
									    <td align="left" class="valueStyle" colspan="3">
									      	<rich:comboBox id="projManagerId" defaultLabel="" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												 value="Boonyakiat Ngouriathul" width="150">
										    </rich:comboBox>									    
							    	  </td>
									</tr>
									<tr class="inputRow" >
									    <td align="right" class="labelStyle"><strong>System Owner :</strong></td>
									    <td align="left" class="valueStyle">
									      <h:panelGrid id="groupSystemOwner" columns="2" border="0" cellpadding="0" cellspacing="0">
									    	<rich:comboBox id="ownerTeamId" defaultLabel="" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												 value="Boonyakiat Ngouriathul " width="150">
										    </rich:comboBox>
                                         </h:panelGrid>										
                                        </td>
										<td align="right" class="labelStyle"><strong>System Owner Team :</strong>&nbsp;</td>
									    <td align="left"  class="valueStyle">
									    	<rich:comboBox id="systemOwnerTeam" defaultLabel="" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												 value="IP-CDN" width="162">											
											</rich:comboBox>										
									    </td>
									</tr>
									<tr class="inputRow">
									    <td align="right" class="labelStyle">
											<strong>Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;
                                       </td>
									   <td align="left" class="valueStyle" >
									         <rich:comboBox
												id="networkType" defaultLabel="" enableManualInput="false"
												itemClass="contentform" itemSelectedClass="contentform"
												value="#{userReqIPBean.nwTypeComboItem}" width="150">
													<f:attribute name="selectItems" value="#{userReqIPBean.nwTypeList}"/>
													<f:selectItems value="#{userReqIPBean.nwTypeList}"/>
											  </rich:comboBox>									
										</td>

									</tr>
									<tr class="inputRow">
											<td align="right" class="labelStyle"><strong>Request Type<h:graphicImage
												value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											<td align="left" colspan="3" class="valueStyle">
											<h:selectOneRadio
												id="booleanValue" styleClass="contentform" 
												value="#{userReqIPBean.REQ_TYPE}">
												<f:selectItem itemLabel="New Network" itemValue="N" />
												<f:selectItem itemLabel="Expansion Network" itemValue="E" />
												<a4j:support reRender="DetailForm" event="onclick" oncomplete="showRow()"/>
											</h:selectOneRadio></td>
									</tr>	

										<tr id="rowGroupNetwork" style="display:none;">
											<td class="labelStyle"></td>
											<td align="left" colspan="3">
											<rich:panel id="groupNetwork" rendered="#{userReqIPBean.REQ_TYPE =='N'}">
												<table border="0" width="67%" cellpadding="0" cellspacing="0">
													<tr>
														<td width="145" align="right"><strong>Network Zone Name  :</strong>&nbsp;</td>
														<td width="239">
														<rich:comboBox id="networkZoneName"
															defaultLabel="" enableManualInput="false"
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{userReqIPBean.nwZoneComboItem}" width="228">
															<f:attribute name="selectItems" value="#{userReqIPBean.nwZoneList}"/>
															<f:selectItems value="#{userReqIPBean.nwZoneList}"/>
														</rich:comboBox>
													    </td>
													</tr>
													<tr>
														<td width="145" align="right"><strong>Site/Location :</strong>&nbsp;</td>
														<td width="239">
															<h:panelGrid columns="2">
															  <h:selectOneRadio id="xx" style="width:93px;"
																styleClass="contentform"
																value="#{userReqIPBean.LOCATION}">
																<f:selectItem itemLabel="Data Center" itemValue="T" />
															   </h:selectOneRadio>
															   	<rich:comboBox id="yyy" defaultLabel=""
																	enableManualInput="false" itemClass="contentform" 
																	itemSelectedClass="contentform" value="#{userReqIPBean.locationComboItem}" width="127">
																	<f:attribute name="selectItems" value="#{userReqIPBean.dataList}"/>
																	<f:selectItems value="#{userReqIPBean.dataList}"/>
																</rich:comboBox>
															 </h:panelGrid>				
													    </td>
													</tr>
													<tr>
														<td width="145" align="right">&nbsp;</td>
														<td width="239">
															<h:panelGrid columns="2">
															  <h:selectOneRadio id="aa" style="width:93px;"
																styleClass="contentform"
																value="#{userReqIPBean.LOCATION}">
																<f:selectItem itemLabel="Office User" itemValue="T" />
															   </h:selectOneRadio>
															   	<rich:comboBox id="tt" defaultLabel=""
																	enableManualInput="false" itemClass="contentform" 
																	itemSelectedClass="contentform" value="#{userReqIPBean.locationComboItem}" width="127">
																	<f:attribute name="selectItems" value="#{userReqIPBean.dataList}"/>
																	<f:selectItems value="#{userReqIPBean.dataList}"/>
																</rich:comboBox>
															 </h:panelGrid>				
													    </td>
													</tr>
													
												</table>
											</rich:panel>
											
											<rich:panel id="groupNetwork2" rendered="#{userReqIPBean.REQ_TYPE =='E'}">
												<table width="67%">
													<tr>
														<td width="145" align="right"><strong>Existing Network Zone :</strong>&nbsp;</td>
														<td width="239">
														<rich:comboBox id="exNetworkZone"
														   	buttonDisabledStyle="background-color:Red;" 
															buttonInactiveStyle="background-color:Red;" 
															buttonStyle="background-color:Red;"
															defaultLabel="" enableManualInput="false"
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{userReqIPBean.nwZoneComboItem}" width="228">
															<f:attribute name="selectItems" value="#{userReqIPBean.nwZoneList}"/>
															<f:selectItems value="#{userReqIPBean.nwZoneList}"/>
														</rich:comboBox>
													    </td>
													</tr>
													<tr>
														<td width="145" align="right"><strong>Existing IP Network Ref :</strong>&nbsp;</td>
														<td width="239">
                                                            <h:inputText value="10.0.0.0" style="width:225" ></h:inputText>
													    </td>
													</tr>
													<tr>
														<td width="145" align="right"><strong>Site/Location :</strong>&nbsp;</td>
														<td width="239">
															<h:panelGrid columns="2">
															  <h:selectOneRadio id="ooo" style="width:93px;"
																styleClass="contentform"
																value="#{userReqIPBean.LOCATION}">
																<f:selectItem itemLabel="Data Center" itemValue="T" />
															   </h:selectOneRadio>
															   	<rich:comboBox id="ppp" defaultLabel=""
																	enableManualInput="false" itemClass="contentform" 
																	itemSelectedClass="contentform" value="#{userReqIPBean.locationComboItem}" width="127">
																	<f:attribute name="selectItems" value="#{userReqIPBean.dataList}"/>
																	<f:selectItems value="#{userReqIPBean.dataList}"/>
																</rich:comboBox>
															 </h:panelGrid>				
													    </td>
													</tr>
													<tr>
														<td width="145" align="right">&nbsp;</td>
														<td width="239">
															<h:panelGrid columns="2">
															  <h:selectOneRadio id="bb" style="width:93px;"
																styleClass="contentform"
																value="#{userReqIPBean.LOCATION}">
																<f:selectItem itemLabel="Office User" itemValue="T" />
															   </h:selectOneRadio>
															   	<rich:comboBox id="nn" defaultLabel=""
																	enableManualInput="false" itemClass="contentform" 
																	itemSelectedClass="contentform" value="#{userReqIPBean.locationComboItem}" width="127">
																	<f:attribute name="selectItems" value="#{userReqIPBean.dataList}"/>
																	<f:selectItems value="#{userReqIPBean.dataList}"/>
																</rich:comboBox>
															 </h:panelGrid>				
													    </td>
													</tr>													
												</table>
											</rich:panel>
											</td>
											<td>&nbsp;</td>
										</tr>
										<tr class="inputRow" >
									      <td  align="right" class="labelStyle"><strong>Contact Point :</strong>&nbsp;</td>
					                      <td  align="left" class="valueStyle" colspan="3" >
	                                      <h:inputText id="contactPoint"  size="15" style="width:525px;"  value="Call#4546,4545"></h:inputText>&nbsp;										</td>
										</tr>
										<tr class="inputRow" >
										    <td  align="right" valign="top" class="labelStyle"><strong>Network System Requirement<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong><br>
										    <strong>(System Detail)</strong>									    </td>
										    <td align="left"  class="valueStyle" colspan="3">
	                                          <h:inputTextarea id="networkSystem"  rows="3" cols="60"  style="width:525px;" value="Request new IP">
	                                          </h:inputTextarea>
	                                       </td>
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
															<td  align="left" style=" width : 60px;"><h:inputText
																id="totalNode" size="5" style="text-align:right"
																value="10"></h:inputText></td>
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
															<td align="left" style=" width : 60px;"><h:inputText
																id="classB" size="5" style="text-align:right"
																value=""></h:inputText></td>
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
															  <h:inputText id="classC" size="5" style="text-align:right" value=""></h:inputText>
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
									  <td align="right" class="labelStyle"  valign="top"><strong>Network Diagram<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>	
									  <td valign="top" style=" width : 189px;">
									   <table border="0" cellpadding="0" cellspacing="0">
									    <tr>
									     <td>
									   <rich:dataTable width="80%" id="networkDiagramTable" cellpadding="1" cellspacing="0" border="0"
										var="userReqo1" value="#{userReqIPBean.userReques_01tList}" reRender="scrollNetworkDiagramTable" rows="5"
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader" style=" width : 175px;">
	
											<rich:column width="5%">
												<f:facet name="header">
													<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
												</f:facet>
												 <div align="center">
												  <a4j:commandButton id="btnDelete" value="Delete" 
														image="../images/p_delete.gif" style="height: 15; width: 15" 
														action="#{manageDataIPAction.initUpdate}">
														<a4j:actionparam name="rowId" value=""/>
					          						</a4j:commandButton>
					          					</div>
											</rich:column>
											<rich:column width="60%" >
												<f:facet name="header">
													<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
												</f:facet>
												<div align="left">
				          						    <h:outputText value="#{userReqo1.REQ_NAME}" />
												</div>
											</rich:column>								
										</rich:dataTable>
										 </td>	
									 	 <td align="left" valign="top">
											  <a4j:commandButton id="btnBrows" value="Browse" style="width:60"
												styleClass="rich-button" action="#{userReqIPAction.init}">
											  </a4j:commandButton>
										 </td>
									   </tr>
                                     </table>
									   </td>	
									  
									  <td align="right"  valign="top" >
									      <table border="0" cellpadding="0" cellspacing="0" >
									        <tr class="inputRow">
									         <td class="labelStyle"><strong>Application Flow&nbsp;:</strong>&nbsp;</td>
									        </tr>
									      </table>		 
									  </td>	
									  <td valign="top">	
									    <table border="0" cellpadding="0" cellspacing="0">
									     <tr>
									      <td>
									   <rich:dataTable width="80%" id="applicationTable" cellpadding="1" cellspacing="0" border="0"
										var="userRequest" value="2" reRender="scrollIPApplicationTable" rows="5"
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader" style=" width : 175px;">
	
											<rich:column width="5%">
												<f:facet name="header">
													<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
												</f:facet>
												 <div align="center">
												  <a4j:commandButton id="btnDelete" value="Delete" 
														image="../images/p_delete.gif" style="height: 15; width: 15" 
														action="#{manageDataIPAction.initUpdate}">
														<a4j:actionparam name="rowId" value=""/>
					          						</a4j:commandButton>
					          					</div>
											</rich:column>
											<rich:column width="60%" >
												<f:facet name="header">
													<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
												</f:facet>
												<div align="left">
				          						   <h:outputText value="AppFlowA.jpg" />
												</div>
											</rich:column>								
										</rich:dataTable>	
										</td>
										<td align="left" valign="top">
											  <a4j:commandButton id="btnBrowss" value="Browse" style="width:60"
												styleClass="rich-button" action="#{userReqIPAction.init}">
											  </a4j:commandButton>
										</td>
										</tr>
									   </table>						 
									  </td>	
								  </tr>						  						
									<tr>
										<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
									</tr>
								    </table>
								</rich:simpleTogglePanel>
								<rich:simpleTogglePanel switchType="client" id="approv" label="Approve Manager" >
								  <table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
								     <tr class="inputRow">
								        <td width="150"></td>
								        <td colspan="3" align="left" >
								  		 <table border="0" width="40%" align="left" cellpadding="0" cellspacing="0" >
												<tr>
												    <td width="9"></td>
													<td height="22" background="../images/title_bar.png"  align="left" width="142"><h:outputText value="Manager" styleClass="contentform"/></td>
												    <td align="left" width="53" ></td>
											        <td height="22" background="../images/title_bar.png"  align="left" width="142" ><h:outputText value="Approve Manager" styleClass="contentform"/></td>
											        <td></td>
												</tr>
												<tr>
												<td colspan="5" align="center">
											        <rich:pickList 
											                copyAllControlLabel=" " copyControlLabel=" "
											                removeAllControlLabel=" "
											                removeControlLabel=" "
											                copyAllVisible="false"
											                removeAllVisible="false"
											                listsHeight="70" >
											            <f:selectItem itemLabel="Arree Penjun" itemValue="1"/> 
											            <f:selectItem itemLabel="Manee Suhdee" itemValue="2"/>
											            <f:selectItem itemLabel="Praditphong Soipetch" itemValue="2"/>
											        </rich:pickList>
												</td>
												<td>
												     <a4j:commandLink id="sendLink1" action="#{userReqIPAction.init}">
										                    <strong>Send1</strong>
															<a4j:actionparam name="programIDParam" value="IPURS004_02"/>
										               </a4j:commandLink>
													  <a4j:commandLink id="sendLink2" action="#{userReqIPAction.init}">
										                    <strong>Send2</strong>
															<a4j:actionparam name="programIDParam" value="IPURS004_04"/>
										               </a4j:commandLink>
												</td>
												</tr>
											</table>
										 </td>
									  </tr>
									 </table>
								</rich:simpleTogglePanel>
							</td>
						</tr>
						<tr align="right">
							<td align="right">
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="230">&nbsp;</td>
									<td colspan="5" align="right" >
										<h:panelGroup id="buttonGroup">
									    	<a4j:commandButton id="btnSaveDraft" value="Save Draft" styleClass="rich-button"
												action="#{userReqIPAction.save}"
												reRender="DetailForm" />&nbsp;
											<a4j:commandButton id="btnSendApprove" value="Send for Approve" styleClass="rich-button"
												action="#{userReqIPAction.sendApprove}"  style="width:150px">
												 <rich:componentControl for="ApprovePopups" attachTo="btnSendApprove" operation="show" event="onclick"/>
										    </a4j:commandButton>&nbsp;
												<a4j:commandButton id="btnreject" value="Delete UR" styleClass="rich-button"
												action="#{manageDataIPAction.init}"
												reRender="groupSearchResult" />&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
												action="#{userReqIPAction.clear}"/>
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
		<jsp:directive.include file="IPURS020.jsp"/>
</f:view>
</body>
</html>
