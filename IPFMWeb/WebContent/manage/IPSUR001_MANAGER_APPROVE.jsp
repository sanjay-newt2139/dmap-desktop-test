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

<script language="javascript">

function showRow(){
   document.getElementById("rowGroupNetwork").style.display = "inline";
}

</script>	

</head>
<body style="width:100%;overflow:hidden;">

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
					<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
				  	<h:form id="DetailForm">
			  		<h:inputHidden id="urNo" value="#{userReqIPBean.ipUrIpDetail.urNo}"></h:inputHidden>
					<table width="97%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
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
						<tr style="width:100%;">
							<td style="width:100%;">
								<rich:simpleTogglePanel switchType="client" width="100%" id="profile" label="UR Information" > 
									<h:panelGroup style="width:100%">
										<h:panelGrid rendered="#{userReqIPBean.mode != 'NEW'}" columns="1" cellpadding="0" cellspacing="0" style="text-align:right; position:absolute; right:5px;">
											<h:outputText value="#{userReqIPBean.ipUrIpDetail.urNo}" style="font-weight:bold; color:#0000FF;" />
											<h:outputText value="#{userReqIPBean.ipUrIpDetail.urStatusName}" style="font-weight:bold; color:#FF0000;" />
										</h:panelGrid>
										<table width="100%" border="0" class="thtext_detail">
											<tr class="inputRow" >
											    <td  align="right" class="labelStyle"><strong>Subject :</strong>&nbsp;</td>
		                                        <td  align="left" colspan="3" class="valueStyle">&nbsp;
				    	                            <h:outputText id="subject" value="#{userReqIPBean.ipUrIpDetail.subject}" />
				    	                        </td>
				    	                        <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
										    	<td align="right" valign="top" class="labelStyle"><strong>Request from<br/>Planning Team :</strong>&nbsp;</td>
											    <td colspan="3"  align="left" class="valueStyle">&nbsp;
											    	<h:outputText id="planningTeam" value="#{userReqIPBean.ipUrIpDetail.t2TeamName}" />
		                                       	</td>
		                                       	<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>Project ID :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >&nbsp;
											      	<h:outputText value="#{userReqIPBean.ipUrIpDetail.projId}" />							
		                                         </td>
		                                         <td align="right" class="labelStyle"><strong>Project Name :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >&nbsp;
											      	<h:outputText value="#{userReqIPBean.ipUrIpDetail.projName}" />
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											    <td align="right" class="labelStyle"><strong>Project Manager :</strong>&nbsp;</td>
											    <td align="left" class="valueStyle" colspan="3">&nbsp;
											      	<h:outputText value="#{userReqIPBean.ipUrIpDetail.projManagerName}" />								    
									    	  	</td>
									    	  	<td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
												<td align="right" class="labelStyle"><strong>System Owner :</strong>&nbsp;</td>
												<td align="left" class="valueStyle">&nbsp;
													<h:outputText value="#{userReqIPBean.ipUrIpDetail.sysOwnerName}" />
		                                        </td>
												<td align="right" class="labelStyle"><strong>System Owner Team :</strong>&nbsp;</td>
												<td align="left" class="valueStyle">&nbsp;
													<h:outputText value="#{userReqIPBean.ipUrIpDetail.sysOwnerTeamName}" />
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
										      	<td  align="right" class="labelStyle"><strong>Contact Point :</strong>&nbsp;</td>
						                      	<td  align="left" class="valueStyle" colspan="3" >&nbsp;
		                                      		<h:outputText value="#{userReqIPBean.ipUrIpDetail.contactPoint}" />
	                                      		</td>
	                                      		<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											    <td  align="right" valign="top" class="labelStyle">
											    	<strong>Network System Requirement :&nbsp;</strong><br>
											    	<strong>(System Detail)</strong>									    
											    </td>
											    <td align="left"  class="valueStyle" colspan="3">
											    	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
														<rich:spacer width="7"></rich:spacer>
		                                          		<h:inputTextarea id="networkSystem"  rows="3" cols="109"  value="#{userReqIPBean.ipUrIpDetail.nwSysDetail}" readonly="true"/>
		                                          	</h:panelGrid>
		                                       </td>
		                                       <td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
											    <td align="right" class="labelStyle">
													<strong>Network Type :</strong>&nbsp;
		                                        </td>
											    <td align="left" class="valueStyle" colspan="3">&nbsp;
													<h:outputText value="#{userReqIPBean.ipUrIpDetail.networkTypeName}" />
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
												<td align="right" class="labelStyle">
													<strong>Request Type :</strong>&nbsp;
												</td>
												<td align="left" colspan="3" class="valueStyle">&nbsp;
													<h:outputText value="#{userReqIPBean.ipUrIpDetail.reqType=='N'?'New Network':'Expansion Network'}" />
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow">
												<td align="right" class="labelStyle">
													<strong><h:outputText value="#{userReqIPBean.ipUrIpDetail.reqType=='N'?'Network Zone Name':'Existing Network Zone'}" /> :</strong>&nbsp;
												</td>
												<td align="left" colspan="3" class="valueStyle">&nbsp;
													<h:outputText value="#{userReqIPBean.ipUrIpDetail.zoneName}" />
												</td>
												<td>&nbsp;</td>
											</tr>
											<h:panelGroup rendered="#{userReqIPBean.ipUrIpDetail.reqType =='E'}">
											<tr class="inputRow">
												<td align="right" class="labelStyle"><strong>Existing IP Network Ref :</strong>&nbsp;</td>
												<td colspan="3" class="valueStyle">&nbsp;
                                                	<h:outputText value="#{userReqIPBean.ipUrIpDetail.ipRef}" />
                                                </td>
                                                <td>&nbsp;</td>
											</tr>
											</h:panelGroup>
											<tr class="inputRow">
												<td align="right" class="labelStyle"><strong>Site/Location :</strong>&nbsp;</td>
												<td colspan="3" class="valueStyle">&nbsp;
													<h:outputText rendered="#{userReqIPBean.ipUrIpDetail.locationType=='D'}" value="Data Center - #{userReqIPBean.ipUrIpDetail.locationName}"  />
													<h:outputText rendered="#{userReqIPBean.ipUrIpDetail.locationType=='O'}" value="Office User - #{userReqIPBean.ipUrIpDetail.locationName}"  />
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											 	<td align="right" valign="top" class="labelStyle" ><strong>Network Size :</strong>&nbsp;</td>
												<td colspan="3" >
													<h:panelGrid columns="5" cellspacing="0" cellpadding="0" style="margin-left:7px;">
														<h:outputText value="Total Node" escape="false" />
														<rich:spacer width="20" />
											 			<h:outputText value="#{userReqIPBean.ipUrIpDetail.totalNodeStr}" style="width:100%;text-align:right;" escape="false" />
											 			<rich:spacer width="10" />
											 			<h:outputText value="Hosts" escape="false" />
											 			
											 			<h:outputText value="Class B" escape="false" />
														<rich:spacer width="20" />
											 			<h:outputText value="#{userReqIPBean.ipUrIpDetail.classBStr}" style="width:100%;text-align:right;" escape="false" />
											 			<rich:spacer width="10" />
											 			<h:outputText value="Network" escape="false" />
											 			
											 			<h:outputText value="Class C" escape="false" />
														<rich:spacer width="20" />
											 			<h:outputText value="#{userReqIPBean.ipUrIpDetail.classCStr}" style="width:100%;text-align:right;" escape="false" />
											 			<rich:spacer width="10" />
											 			<h:outputText value="Network" escape="false" />
											 		</h:panelGrid>
									  			</td>
									  			<td>&nbsp;</td>
									  		</tr>
	
											<tr class="inputRow">
												<td align="right" class="labelStyle"  valign="top"><strong>Network Diagram :</strong>&nbsp;</td>	
												<td align="left" valign="top" class="valueStyle" >
												<h:panelGrid columns="2" cellpadding="0" cellspacing="0">												
													<rich:spacer width="7"></rich:spacer>
													<rich:dataTable width="222" id="diagramTable" cellpadding="1" cellspacing="0" border="0"
															var="detail" value="#{userReqIPBean.diagramList}"  
															rowClasses="odd,even" styleClass="contentform" 
															rowKeyVar="index"  headerClass="tableHeader">
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
		                                                        <h:commandLink value="#{detail.fileName}" action="#{userReqIPAction.download}" styleClass="contentform" >
		                                                        	<f:param name="path" value="#{detail.fileLocation}"/>
		                                                        	<f:param name="fileName" value="#{detail.fileName}"/>
		                                                        </h:commandLink>
															</rich:column>														
														</rich:dataTable>
													</h:panelGrid>
									   			</td>										  
											  	<td align="right" class="labelStyle"  valign="top" >
													<strong>Application Flow&nbsp;:</strong>&nbsp;
												</td>	
											  	<td valign="top" class="valueStyle">
													<h:panelGrid columns="2" cellpadding="0" cellspacing="0">												
														<rich:spacer width="7"></rich:spacer>
											    		<rich:dataTable width="222" id="appFlowTable" cellpadding="1" cellspacing="0" border="0"
															var="detail" value="#{userReqIPBean.appFlowList}"
															rowClasses="odd,even" styleClass="contentform" 
															rowKeyVar="index"  headerClass="tableHeader">
															<rich:column>
																<f:facet name="header">
																	<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
		                                                        <h:commandLink value="#{detail.fileName}" action="#{userReqIPAction.download}" styleClass="contentform" >
		                                                        	<f:param name="path" value="#{detail.fileLocation}"/>
		                                                        	<f:param name="fileName" value="#{detail.fileName}"/>
		                                                        </h:commandLink>
															</rich:column>														
														</rich:dataTable>			 
													</h:panelGrid>
										  		</td>	
										  		<td>&nbsp;</td>
									  		</tr>
									  		<tr class="inputRow">
												<td align="right" style="margin-top:2px;" valign="top" class="labelStyle"><strong>Remarks :</strong>&nbsp;</td>
												<td align="left" colspan="3" class="valueStyle">
													<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
														<rich:spacer width="7"></rich:spacer>
														<h:inputTextarea  rows="3" cols="109"  value="#{userReqIPBean.ipUrIpDetail.mrgRemark}" />
													</h:panelGrid>
												</td>
												<td>&nbsp;</td>
											</tr>
									    </table>
									</h:panelGroup>
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
										<td align="right" >
											<h:panelGroup id="buttonGroup">
										    	<a4j:commandButton id="btnApprove" value="Approve" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
													<rich:componentControl for="confirmApproveURModal" operation="show" event="onclick" />
											    </a4j:commandButton>
											    <rich:spacer width="10"></rich:spacer>
												<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
													<rich:componentControl for="confirmRejectURModal" operation="show" event="onclick" />
												</a4j:commandButton>
												<rich:spacer width="10"></rich:spacer>
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
				</h:form>
				</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	<a4j:include viewId="popup/IPSUR001_HISTORY.jsp" />
	<a4j:include viewId="../home/confirmCancel.jsp" />
	<a4j:include viewId="../home/confirmRejectUR.jsp" />
	
	
	
	
	<rich:modalPanel id="confirmApproveURModal" width="350" minHeight="100" autosized="true">
	    <f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Approve UR"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<h:panelGroup style="width:100%;">
	   		<a4j:form>
	   			<a4j:jsFunction name="reqIPApproveUR" action="#{userReqIPAction.approveUR}" />
	   			<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}"  />
				<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"  />
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0005}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Yes"  action="#{userReqIPAction.approveUR}"  reRender="errorMsg" style="width:50px;" styleClass="rich-button">
							<rich:componentControl for="confirmApproveURModal" operation="hide" event="oncomplete" />
						</a4j:commandButton> 
<%-- 						<a4j:commandButton id="btnApproveYes" value="Yes" onclick="reloadTree();javascript:reqIPApproveUR();javascript:gotoHomePage()"  ajaxSingle="true" reRender="DetailForm,errorMsg" style="width:50px;" styleClass="rich-button" > --%>
<%-- 							<rich:componentControl for="confirmApproveURModal" operation="hide" event="oncomplete" /> --%>
<%-- 						</a4j:commandButton>						 --%>
						
						<rich:spacer width="10" />
						<a4j:commandButton value="No" styleClass="rich-button" ajaxSingle="true" style="width:50px;" status="#{rich:component('wait')}.hide();">
						    <rich:componentControl for="confirmApproveURModal" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
    </rich:modalPanel>
    
    
    <rich:modalPanel id="confirmRejectURModal" width="350" minHeight="100" autosized="true">
	    <f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Reject UR"></h:outputText>
			</h:panelGroup>
		</f:facet>		
		<h:panelGroup style="width:100%;">
	   		<a4j:form>
	   			<a4j:jsFunction name="reqIPRejectUR" action="#{userReqIPAction.rejectUR}" />
	   			<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}"  />
				<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"  />
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0008}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
					
						 <a4j:commandButton value="Yes" action="#{userReqIPAction.rejectUR}" reRender="errorMsg" styleClass="rich-button" style="width:50px;">
							<rich:componentControl for="confirmRejectURModal" operation="hide" event="oncomplete" />
						</a4j:commandButton> 
<%-- 						<a4j:commandButton id="btnApproveYes" value="Yes" onclick="reloadTree();javascript:reqIPRejectUR();javascript:gotoHomePage()" reRender="errorMsg" styleClass="rich-button" style="width:50px;" > --%>
<%-- 							<rich:componentControl for="confirmRejectURModal" operation="hide" event="oncomplete" /> --%>
<%-- 						</a4j:commandButton>				 --%>
						
						
						<rich:spacer width="10" />
						<a4j:commandButton value="No" styleClass="rich-button" ajaxSingle="true" style="width:50px;" status="#{rich:component('wait')}.hide();">
						    <rich:componentControl for="confirmRejectURModal" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</a4j:form>
		</h:panelGroup>
	</rich:modalPanel>
	
	
	
	<f:subview id="footer">
		<a4j:include viewId="../home/progress.jsp" />
	</f:subview>
	
</f:view>
</body>
</html>
