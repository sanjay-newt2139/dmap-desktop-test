<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>User Request IP </title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>
<script type="text/javascript">
	function downloadTemplate(){
		document.getElementById('DetailForm:downloadTemplate').click();
	}
</script>
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>
</head>
<body style="width:100%;overflow:hidden;">

<f:view>
<a4j:region id="aregion">
	<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />
	</f:subview>
	<f:subview id="error">
		<jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br><br>
	<a4j:jsFunction name="alertErrorMsgAjx" 
		actionListener="#{userReqIPAction.alertErrorMsg}"
	 	reRender="errorMsg">
	 	<a4j:actionparam name="errorMessage"/>
	</a4j:jsFunction>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
				  	<h:form id="DetailForm">
				  	<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}"  />
					<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}" />
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
												<td colspan="3" class="valueStyle">
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
												<td valign="top" class="valueStyle">
													<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
														<rich:spacer width="7"></rich:spacer>											
														<rich:dataTable width="223" id="diagramTable" cellpadding="1" cellspacing="0" border="0"
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
											  	<td align="right" class="labelStyle" valign="top" >
													<strong>Application Flow&nbsp;:</strong>&nbsp;
												</td>	
											  	<td valign="top" class="valueStyle">	
											  		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
														<rich:spacer width="7"></rich:spacer>		
											    		<rich:dataTable width="223" id="appFlowTable" cellpadding="1" cellspacing="0" border="0"
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
												<td align="right" valign="top" class="labelStyle"><strong>Remarks :</strong>&nbsp;</td>
												<td align="left" colspan="3" class="valueStyle">
													<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
														<rich:spacer width="7"></rich:spacer>
														<h:inputTextarea  rows="3" cols="109"  value="#{userReqIPBean.ipUrIpDetail.mrgRemark}" readonly="true"/>
													</h:panelGrid>
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
								<rich:panel header="Assignment">
									<h:panelGroup style="width:100%">
										<table width="100%" border="0" class="thtext_detail">
									     	<tr class="inputRow" >
											    <td  align="right" class="labelStyle"><strong>Company<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
		                                        <td  align="left" class="valueStyle">
		                                        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			                                        	&nbsp;
					    	                            <rich:comboBox id="company" defaultLabel="" 
															enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
														 	width="160" listWidth="155" listHeight="150"
														 	value="#{userReqIPBean.companyComboItem}" >
														 	<f:attribute name="selectItems" value="#{userReqIPBean.companyList}"/>
														 	<f:selectItems value="#{userReqIPBean.companyList}" />
														 	<a4j:support reRender="errorMsg,company" event="onchange" action="#{userReqIPAction.checkCompanyCombo}" />
													 	</rich:comboBox>
									     			</h:panelGrid>
				    	                        </td>
				    	                        <td  align="right" class="labelStyle"><strong>Site/Location :</strong>&nbsp;</td>
		                                        <td  align="left" class="valueStyle">
		                                        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			                                        	&nbsp;
					    	                            <rich:comboBox id="location" defaultLabel="" 
															enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
														 	width="160" listWidth="155" listHeight="150"
														 	value="#{userReqIPBean.locationComboItem}" >
														 	<f:attribute name="selectItems" value="#{userReqIPBean.locationList}"/>
														 	<f:selectItems value="#{userReqIPBean.locationList}" />
														 	<a4j:support reRender="errorMsg,location" event="onchange" action="#{userReqIPAction.checkLocationCombo}" />
														</rich:comboBox>
									     			</h:panelGrid>
				    	                        </td>
				    	                        <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
												<td align="right" class="labelStyle"><strong>IP Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
										    	<td align="left" class="valueStyle">
										    		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
											    		&nbsp;
												    	<rich:comboBox id="ipType" defaultLabel="" 
															enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
														 	width="160" listWidth="155" listHeight="150"
														 	value="#{userReqIPBean.ipTypeComboItem}" >
														 	<f:attribute name="selectItems" value="#{userReqIPBean.ipTypeList}"/>
														 	<f:selectItems value="#{userReqIPBean.ipTypeList}" />
														 	<a4j:support reRender="errorMsg,ipType" event="onchange" action="#{userReqIPAction.checkIpTypeCombo}" />
														</rich:comboBox>
									     			</h:panelGrid>
		                                       	</td>
		                                       	<td align="right" class="labelStyle"><strong>Network Type :</strong>&nbsp;</td>
											    <td align="left" class="valueStyle">
											    	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												    	&nbsp;
												    	<rich:comboBox id="networkType" defaultLabel="" 
															enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
														 	width="160" listWidth="155" listHeight="150"
														 	value="#{userReqIPBean.nwTypeComboItem}" >
														 	<f:attribute name="selectItems" value="#{userReqIPBean.nwTypeList}"/>
														 	<f:selectItems value="#{userReqIPBean.nwTypeList}" />
														 	<a4j:support reRender="errorMsg,networkType" event="onchange" action="#{userReqIPAction.checkNwTypeCombo}" />
														</rich:comboBox>
										     		</h:panelGrid>
		                                       	</td>
		                                       	<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>VLAN ID :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	 <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputText value="#{userReqIPBean.ipUrIpResult.vlanId}" size="25" maxlength="30"
												      	 onkeypress="return keyRange(this,event,1,4096);"
											       		 onblur="this.value = isNumber(this);"/>							
												     </h:panelGrid>
		                                         </td>
		                                         <td align="right" class="labelStyle"><strong>Network Zone :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<rich:comboBox id="networkZone" defaultLabel="" 
															enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
														 	width="160" listWidth="155" listHeight="150"
														 	value="#{userReqIPBean.nwZoneComboItem}" >
														 	<f:attribute name="selectItems" value="#{userReqIPBean.nwZoneList}"/>
														 	<f:selectItems value="#{userReqIPBean.nwZoneList}" />
														 	<a4j:support reRender="errorMsg,networkZone" event="onchange" action="#{userReqIPAction.checkNwZoneCombo}" />
														</rich:comboBox>
										     		</h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>DNS Name :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputText value="#{userReqIPBean.ipUrIpResult.dnsName}" size="25"/>							
											     	</h:panelGrid>
		                                         </td>
		                                         <td align="right" class="labelStyle"><strong>Network IP :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputText value="#{userReqIPBean.ipUrIpResult.networkIp}" size="25"  onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Network IP');"/>
												    </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>VIP :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:selectOneRadio id="vip" value="#{userReqIPBean.ipUrIpResult.vip}"  styleClass="contentform" >
														<f:selectItem itemLabel="Yes" itemValue="Y" />
														<f:selectItem itemLabel="No" itemValue="N" />
												  	</h:selectOneRadio>							
												 </td>
		                                         <td align="right" class="labelStyle"><strong>Gateway :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputText value="#{userReqIPBean.ipUrIpResult.gateway}" size="25" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Gateway');"/>
												    </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>Install Type :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:selectOneRadio value="#{userReqIPBean.ipUrIpResult.installTypeId}"  styleClass="contentform" >
														<f:selectItem itemLabel="Permanent" itemValue="2" />
														<f:selectItem itemLabel="Temporary" itemValue="1" />														
												  	</h:selectOneRadio>							
												 </td>
												<td align="right" class="labelStyle">
													<strong>System Name :</strong>&nbsp;
												</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputText value="#{userReqIPBean.ipUrIpResult.systemName}" size="25" maxlength="1000" />
												    </h:panelGrid>
		                                         </td>
												 <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td  align="right" class="labelStyle"><strong>Effective Date<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
												     <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												     	<rich:calendar id="effectiveDate" disabled="#{userReqIPBean.ipUrIpResult.installTypeId=='1'}" value="#{userReqIPBean.ipUrIpResult.effectiveDate}" 
										                        locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
										                        inputStyle="background-color:white" inputSize="25" direction="auto"/>
										             </h:panelGrid>
												 </td>
		                                         <td  align="right" class="labelStyle"><strong>Expire Date<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
												     <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<rich:calendar id="expireDate" disabled="#{userReqIPBean.ipUrIpResult.installTypeId=='1'}" value="#{userReqIPBean.ipUrIpResult.expireDate}"
										                        locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
										                        inputStyle="background-color:white" inputSize="25" direction="auto"/>
										             </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle" style="margin-top:2px;" valign="top"><strong>Remarks :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" colspan="3">
												     <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputTextarea id="remark" value="#{userReqIPBean.ipUrIpResult.remarks}"  rows="3" cols="110" />
												     </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
										</table>
										<rich:spacer height="5"></rich:spacer>
										<rich:panel>	          
							   	 	  		<h:panelGrid id="groupDetail" columns="11"styleClass="contentlabelform" cellpadding="0"  cellspacing="0" border="0">
							   	 	   			<h:outputText value="IP Version :&nbsp;" escape="false" style="font-weight:bold" />
					   	 	   					<rich:comboBox id="ipversion" defaultLabel="" enableManualInput="false" 
														itemClass="contentform" itemSelectedClass="contentform"
														value="#{userReqIPBean.ipUrIpResult.ipVersion}" width="45" listWidth="40">
														<f:selectItem itemValue="4"/>
												</rich:comboBox>
												<rich:spacer width="30" />
												<strong>IP Address :&nbsp;</strong>
											   	<h:panelGroup id="rangIpGroup"> 
										   				<h:inputText id="stIp1" value="#{userReqIPBean.ipUrIpResult.ipDigit1}" size="1" style="text-align:center" maxlength="3"
										   				onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stIp2',this,event,0,255,'190')"
										   				onblur="this.value = isNumber(this);"/>
														<strong>&nbsp;.&nbsp;</strong>
				                                        <h:inputText id="stIp2" value="#{userReqIPBean.ipUrIpResult.ipDigit2}" size="1" style="text-align:center" maxlength="3" 
										   				onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stIp3',this,event,0,255,'190')"
				                                        onblur="this.value = isNumber(this);"/>
														<strong>&nbsp;.&nbsp;</strong>
	                                        			<h:inputText id="stIp3" value="#{userReqIPBean.ipUrIpResult.ipDigit3}" size="1" style="text-align:center" maxlength="3" 
										   				onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stIp4',this,event,0,255,'190')"
	                                        			onblur="this.value = isNumber(this);"/>
														<strong>&nbsp;.&nbsp;</strong>
														<h:inputText id="stIp4" value="#{userReqIPBean.ipUrIpResult.ipDigit4}" size="1" style="text-align:center" maxlength="3"
														onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stSubmask',this,event,0,255,'191')"
														onblur="this.value = isNumber(this);"/>
														<strong>&nbsp;/&nbsp;</strong>
														<h:inputText id="stSubmask" value="#{userReqIPBean.ipUrIpResult.mask}" size="1" style="text-align:center" maxlength="2" 
														onkeypress="return numbersonlyNoDot(event);" 
														onkeyup="enterSubmit('DetailForm:btnAdd',event)" 
														onblur="this.value = isNumber(this);"/>
													</h:panelGroup>
													<rich:spacer width="20" />
												    <a4j:commandButton id="btnAdd" value="Add"action="#{userReqIPAction.addIP}" reRender="errorMsg,groupDataTable"  styleClass="rich-button" 
												   	 	oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),'checkBox','');"></a4j:commandButton>
												    <rich:spacer width="10" />
													<a4j:commandButton id="btnDelete" value="Delete" action="#{userReqIPAction.deleteIP}" reRender="errorMsg,groupDataTable" styleClass="rich-button" 
														oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),'checkBox','');"></a4j:commandButton>
													<rich:spacer width="10" />
													<a4j:commandButton id="btnSearch" value="Search IP" action="#{userReqIPAction.popupSearchIP}" styleClass="rich-button" reRender="errorMsg,IPSUR001_SEARCHIP" rendered="true">
														<rich:componentControl event="oncomplete" operation="#{errorMessages?'hide':'show'}" for="IPSUR001_SEARCHIP"/>
													</a4j:commandButton>
													<rich:hotKey key="return" handler="#{rich:element('btnAdd')}.click()" selector="#stIp1,#stIp2,#stIp3,#stIp4,#stSubmask"/>	
												</h:panelGrid>
												<h:panelGroup id="groupDataTable">
													<rich:dataTable width="100%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
														binding="#{userReqIPBean.ipResultDataTable}" rows="256"
														var="detail" value="#{userReqIPBean.ipUrIpResultList}"  
														styleClass="contentform"  rowClasses="odd,even"
														rowKeyVar="rowIndex"  headerClass="tableHeader">
															<rich:column width="5%" style="vertical-align:top;">
																<f:facet name="header">
																	<h:selectBooleanCheckbox id="checkAll" value="#{userReqIPBean.checkAll}"  onclick="validateCheckbox('ALL',this,this,'checkBox','')"  disabled="#{empty userReqIPBean.ipUrIpResultList}">
																		<a4j:support disabled="true" event="onclick" action="#{userReqIPAction.checkAll}" reRender="errorMsg,groupDataTable"/>
																	</h:selectBooleanCheckbox>
																</f:facet>
																<div align="center">
								          						    <h:selectBooleanCheckbox id="checkBox" value="#{detail.rowCheck}"  onclick="validateCheckbox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),this,'checkBox','')"/>
																</div>
															</rich:column>
												            <rich:column width="5%" style="vertical-align:top;">
																<f:facet name="header">
																	<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
																<div align="center">
								          						   <h:outputText value="#{rowIndex+1}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>			 						
															<rich:column  selfSorted="false"  sortOrder="#{userReqIPBean.sort01.sortColumn1}"  filterValue="#{userReqIPBean.filter01.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.level2Start,userReqIPBean.filter01.filterColumn1)}"   width="65%" style="vertical-align:top;" sortBy="#{detail.level2Start} - #{detail.level2End}">
																<f:facet name="header">
																	<h:panelGroup>
		   <h:commandLink rendered="true" action="#{userReqIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP Address</strong></span>
				<f:param name="sortColumn" value="#{userReqIPBean.sort01.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="ipDetailTable2" />
		  </h:commandLink>
		 <h:inputText value="#{userReqIPBean.filter01.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
																	
																</f:facet>
																<div align="center">
																	<h:panelGrid width="100%" columns="1" cellpadding="0" cellspacing="0" style="text-align:center;">
																		<h:panelGroup>
									          						    	<a4j:commandLink value="#{detail.level2Start} - #{detail.level2End}" action="#{userReqIPAction.showIpInfoDataTable}" styleClass="contentform" reRender="errorMsg,ipDetail">
									          						    		<f:param name="rowIndex" value="#{rowIndex}"></f:param>
									          						    	</a4j:commandLink>
									          						    </h:panelGroup>
									          						    <h:panelGroup id="ipDetail" style="text-align:center; padding-top:10px;">
									          						    	<rich:dataTable rendered="#{detail.rowShowIpInfo}" width="100%" cellpadding="1" cellspacing="0" border="0"
									          						    			var="ipInfo" value="#{detail.ipInfoList}"
																					styleClass="contentform" rowClasses="odd,even"
																					rowKeyVar="index"  headerClass="tableHeader">
																					<rich:column width="5%" style="vertical-align:top;">
																						<f:facet name="header">
																							<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
																						</f:facet>
																						<div align="center">
														          						   <h:outputText value="#{index+1}" styleClass="contentform"></h:outputText>
																						</div>
																					</rich:column>
																					<rich:column  filterValue="#{userReqIPBean.filter012.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(ipInfo.ipAddress,userReqIPBean.filter012.filterColumn1)}"   style="width: 150px;vertical-align:top; text-align:center;">
																						<f:facet name="header">
																							
																								  <h:panelGroup>
		 <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter012.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetail" />
		 </h:inputText>
	 </h:panelGroup>
																						</f:facet>
																						<h:outputText value="#{ipInfo.ipAddress}" styleClass="contentform"></h:outputText>
																					</rich:column>
																					<rich:column  filterValue="#{userReqIPBean.filter012.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(ipInfo.hostName,userReqIPBean.filter012.filterColumn2)}"  style="width: 200px;vertical-align:top; text-align:center;">
																						<f:facet name="header">
																							  <h:panelGroup>
		 <h:outputText value="Host Name" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter012.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetail" />
		 </h:inputText>
	 </h:panelGroup>
																						</f:facet>
																						<h:inputText value="#{ipInfo.hostName}" styleClass="contentform" style="width:100%;"/>
																					</rich:column>
																				 	<rich:column width="85px;" style="vertical-align:top; text-align:center;">
																						<f:facet name="header">
																							<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
																						</f:facet>
																							<rich:calendar value="#{ipInfo.effectiveDate}"
																		                        locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
																		                        inputStyle="background-color:white" inputSize="7" direction="auto"/>
																					</rich:column>
																					<rich:column width="85px;" style="vertical-align:top; text-align:center;">
																						<f:facet name="header">
																							<h:outputText value="Expire Date" styleClass="contentform tableHeaderText"></h:outputText>
																						</f:facet>
																						  	<rich:calendar value="#{ipInfo.expiredDate}"
																		                        locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
																		                        inputStyle="background-color:white" inputSize="7" direction="auto"/>
																					</rich:column>
																			</rich:dataTable>
									          						    </h:panelGroup>
								          						    </h:panelGrid>
																</div>
															</rich:column>
															
															<rich:column width="85px;" style="vertical-align:top;" sortBy="#{detail.effectiveDate}" sortOrder="#{userReqIPBean.sort01.sortColumn2}" >
																<f:facet name="header">
																	<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
																<div align="center">
									          					    <h:outputText value="#{detail.effectiveDate}" styleClass="contentform">
									          					    	<f:convertDateTime pattern="dd/MM/yyyy" />
									          					    </h:outputText>
																</div>
															</rich:column>
															<rich:column width="85px;" style="vertical-align:top;" sortBy="#{detail.expireDate}" sortOrder="#{userReqIPBean.sort01.sortColumn3}" >
																<f:facet name="header">
																	<h:outputText value="Expire Date" styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
																<div align="center">
								          					     	<h:outputText value="#{detail.expireDate}" styleClass="contentform">
									          					    	<f:convertDateTime pattern="dd/MM/yyyy" />
									          					    </h:outputText>
																</div>
															</rich:column>
															<f:facet name="footer">
							                                    <rich:columnGroup>
																	<rich:column colspan="5">
																		<h:panelGroup style="float:left;">
																			Total : <h:outputText value="#{fn:length(userReqIPBean.ipUrIpResultList)}" /> records
																		</h:panelGroup>
																		<h:panelGroup style="float:right;">
																			<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable2"
																				maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" 
																				stepControls="hide" fastControls="auto" boundaryControls="auto" 
																				style="background-color: #cccccc;" fastStep="#{ipfmConfigBean.fastStepPage}">
																			   	  	
																			</rich:datascroller>
																		</h:panelGroup>
																	</rich:column>	
																</rich:columnGroup>										
															</f:facet>
														</rich:dataTable>
													</h:panelGroup>&nbsp;
													
													<a4j:region id="uploadregion">
													
													<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
													<tr>
														<td valign="top" width="15%">
													<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
													     id="dlplanning" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateUR23Assign}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>														

														</td>
														<td>
										         		 	<rich:fileUpload fileUploadListener="#{userReqIPAction.importExcel}"  
									             			maxFilesQuantity="#{fileUploadBean.uploadsAvailable}"
									             			id="fileUpload" transferErrorLabel="เกิดข้อผิดพลาดไม่สามารถอัพโหลดไฟล์นี้ได้"
				             								doneLabel="อัพโหลดเสร็จสมบูรณ์" stopEntryControlLabel=" "
									             			clearControlLabel=" " cancelEntryControlLabel=" "
									             			immediateUpload="#{fileUploadBean.autoUpload}"
									             			acceptedTypes="#{fileUploadBean.acceptedTypes}" 
									             			allowFlash="#{fileUploadBean.useFlash}"
															sizeErrorLabel="File Size Over!"
									             			sizeErrorLabelClass="contentform"
									             			uploadListClass="contentform"
									             			transferErrorLabelClass="contentform"
									             			styleClass="contentform"
									             			fileEntryClass="contentform"
									             			fileEntryControlClass="contentform"
									             			progressLabelClass="contentform"
									             			addButtonClass="contentform"
									             			uploadButtonClass="contentform"
									             			listHeight="50" autoclear="true" 
									             			addControlLabel="Browse" noDuplicate="true"
									             			listWidth="100%" >
									             			<a4j:support event="onuploadcomplete" reRender="IPSUR001_IMPORT_RESULT,ipDetailTable2,fileUpload,DetailForm,errorMsg" >
									             				
									             				<rich:componentControl event="oncomplete" operation="#{errorMessages?'hide':'show'}" for="IPSUR001_IMPORT_RESULT" />
									             			</a4j:support>
									             			<f:facet name="label">
																<h:outputText value="{_KB}KB from {KB}KB uploaded --- {mm}:{ss}" />
															</f:facet>
								         		 	</rich:fileUpload>
														</td>
													</tr>
												</table>	
												
												</a4j:region>
													
								  			</rich:panel>		
										</h:panelGroup>
									</rich:panel>
								</td>
							</tr>
							<tr align="right">
								<td align="right">
									<table width="97%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="230">
	                             		 		<a4j:commandLink rendered="#{userReqIPBean.mode!='NEW'}" reRender="IPSUR001_HISTORY" action="#{userReqIPAction.popupHistory}"  style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
								      	            oncomplete="#{rich:component('IPSUR001_HISTORY')}.show(); return false;" >
								      	            <h:outputText value="View History"/>
									            </a4j:commandLink>
											</td>
											<td align="right" >
												<h:panelGroup id="buttonGroup">												
													<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
														<rich:componentControl for="confirmRejectURModal" operation="show" event="onclick" />
												    </a4j:commandButton>
												    <rich:spacer width="10"></rich:spacer>
													<a4j:commandButton id="btnAssign" value="Assign" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
														<rich:componentControl for="confirmAssignIPModal" operation="show" event="onclick" />
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
	<a4j:include viewId="popup/IPSUR001_IMPORT_RESULT.jsp" />
	<a4j:include viewId="popup/IPSUR001_ASSIGN_RESULT.jsp" />
	<a4j:include viewId="popup/IPSUR001_HISTORY.jsp" />
	<a4j:include id="popupSearchIP" viewId="popup/IPSUR001_SEARCHIP.jsp" />
	<a4j:include viewId="../home/confirmCancel.jsp" />
	<a4j:include viewId="../home/confirmRejectUR.jsp" />
	<a4j:include viewId="../home/confirmAssignIP.jsp" />
	<rich:modalPanel id="confirmAssignIPModal" width="350" minHeight="100" autosized="true">
	    <f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Assign IP"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<h:panelGroup style="width:100%;">
	   		<a4j:form>
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0007}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Yes" action="#{userReqIPAction.assignIP}"  reRender="IPSUR001_ASSIGN_RESULT"  styleClass="rich-button" style="width:50px;">
							<rich:componentControl event="oncomplete" operation="#{errorMessages?'hide':'show'}" for="IPSUR001_ASSIGN_RESULT" />
						</a4j:commandButton>
						<rich:spacer width="10" />
						<a4j:commandButton value="No" styleClass="rich-button" ajaxSingle="true" style="width:50px;" status="#{rich:component('wait')}.hide();">
						    <rich:componentControl for="confirmAssignIPModal" operation="hide" event="onclick" />
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
				<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="100%">
					<h:panelGroup style="font-weight:bold;"><h:outputText value="#{mes.CF0008}" /></h:panelGroup>
					<rich:spacer height="5"/>
					<h:panelGroup>
						<a4j:commandButton value="Yes"  action="#{userReqIPAction.rejectURAssignIP}"  reRender="errorMsg" styleClass="rich-button" style="width:50px;">
							<rich:componentControl for="confirmRejectURModal" operation="hide" event="oncomplete" />
						</a4j:commandButton>
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
		<a4j:include viewId="../home/progressforAssign.jsp" />
	</f:subview>
</a4j:region>	
</f:view>
</body>
</html>