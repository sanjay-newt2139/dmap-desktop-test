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
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>
<script language="javascript">

function showRow(){
   document.getElementById("rowGroupNetwork").style.display = "inline";
}

</script>	

</head>
<body style="width:100%;overflow:hidden;">

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
					<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
				  	<h:form id="DetailForm">
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
											 	<td align="right" valign="top" class="labelStyle"><strong>Network Size :</strong>&nbsp;</td>
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
												<td align="right" style="margin-top:2px;" valign="top" class="labelStyle"><strong>Remarks :</strong>&nbsp;</td>
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
								<rich:simpleTogglePanel label="Assignment" rendered="#{userReqIPBean.ipUrIpDetail.urStatus=='CLOSE'}" >
									<h:panelGroup style="width:100%">
										<table width="100%" border="0" class="thtext_detail">
									     	<tr class="inputRow" >
											    <td  align="right" class="labelStyle"><strong>Company<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
		                                        <td  align="left" class="valueStyle">
		                                        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			                                        	&nbsp;
			                                        	<h:outputText value="#{userReqIPBean.ipUrIpResult.companyName}" styleClass="contentform" />
					    	                        </h:panelGrid>
				    	                        </td>
				    	                        <td  align="right" class="labelStyle"><strong>Site/Location :</strong>&nbsp;</td>
		                                        <td  align="left" class="valueStyle">
		                                        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			                                        	&nbsp;
					    	                            <h:outputText value="#{userReqIPBean.ipUrIpResult.locationName}" styleClass="contentform" />
									     			</h:panelGrid>
				    	                        </td>
				    	                        <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
												<td align="right" class="labelStyle"><strong>IP Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
										    	<td align="left" class="valueStyle">
										    		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
											    		&nbsp;
												    	<h:outputText value="#{userReqIPBean.ipUrIpResult.ipTypeName}" styleClass="contentform" />
									     			</h:panelGrid>
		                                       	</td>
		                                       	<td align="right" class="labelStyle"><strong>Network Type :</strong>&nbsp;</td>
											    <td align="left" class="valueStyle">
											    	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												    	&nbsp;
												    	<h:outputText value="#{userReqIPBean.ipUrIpResult.networkTypeName}" styleClass="contentform" />
										     		</h:panelGrid>
		                                       	</td>
		                                       	<td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>VLAN ID :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	 <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:outputText value="#{userReqIPBean.ipUrIpResult.vlanId}" styleClass="contentform"/>							
												     </h:panelGrid>
		                                         </td>
		                                         <td align="right" class="labelStyle"><strong>Network Zone :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:outputText value="#{userReqIPBean.ipUrIpResult.networkZoneName}" styleClass="contentform"/>	
										     		</h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>DNS Name :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:outputText value="#{userReqIPBean.ipUrIpResult.dnsName}" styleClass="contentform"/>							
											     	</h:panelGrid>
		                                         </td>
		                                         <td align="right" class="labelStyle"><strong>Network IP :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:outputText value="#{userReqIPBean.ipUrIpResult.networkIp}" styleClass="contentform"/>
												    </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>VIP :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											    	 <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												    	<h:outputText value="#{userReqIPBean.ipUrIpResult.vip=='Y'?'Yes':'No'}"  styleClass="contentform" />							
												 	</h:panelGrid>
											     </td>
		                                         <td align="right" class="labelStyle"><strong>Gateway :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:outputText value="#{userReqIPBean.ipUrIpResult.gateway}" styleClass="contentform"/>
												    </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle"><strong>Install Type :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" colspan="3">
											     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:outputText value="#{userReqIPBean.ipUrIpResult.installTypeId=='1'?'Permanent':'Temporary'}" styleClass="contentform"/>
												    </h:panelGrid>					
												 </td>
												 <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td  align="right" class="labelStyle"><strong>Effective Date<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
												     <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												     	<h:outputText value="#{userReqIPBean.ipUrIpResult.effectiveDate}" styleClass="contentform">
												     		<f:convertDateTime pattern="dd/MM/yyyy"/>
												     	</h:outputText>
										             </h:panelGrid>
												 </td>
		                                         <td  align="right" class="labelStyle"><strong>Expire Date<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" >
												     <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												     	<h:outputText value="#{userReqIPBean.ipUrIpResult.expireDate}" styleClass="contentform">
												     		<f:convertDateTime pattern="dd/MM/yyyy"/>
												     	</h:outputText>
										             </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
											<tr class="inputRow" >
											     <td align="right" class="labelStyle" style="margin-top:2px;" valign="top"><strong>Remarks :</strong>&nbsp;</td>
											     <td align="left" class="valueStyle" colspan="3">
												     <h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												     	&nbsp;
												      	<h:inputTextarea id="remark" value="#{userReqIPBean.ipUrIpResult.remarks}"  rows="3" cols="110" readonly="true" />
												     </h:panelGrid>
		                                         </td>
		                                         <td>&nbsp;</td>
											</tr>
										</table>
										<rich:spacer height="5"></rich:spacer>
										<rich:panel>	          
							   	 	  		<h:panelGroup id="groupDataTable">
													<rich:dataTable width="100%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
														binding="#{userReqIPBean.ipResultDataTable}"
														var="detail" value="#{userReqIPBean.ipUrIpResultList}"  
														styleClass="contentform"  rowClasses="odd,even"
														rowKeyVar="rowIndex"  headerClass="tableHeader">
															<rich:column width="5%" style="vertical-align:top;">
																<f:facet name="header">
																	<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
																<div align="center">
								          						   <h:outputText value="#{rowIndex+1}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>			 						
															<rich:column  filterValue="#{userReqIPBean.filterV01.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.level2Start,userReqIPBean.filterV01.filterColumn1)}"  width="70%" style="vertical-align:top;"  selfSorted="false"  sortOrder="#{userReqIPBean.sortV01.sortColumn1}" sortBy="#{detail.level2Start} - #{detail.level2End}">
																<f:facet name="header">
																	<h:panelGroup>
		   <h:commandLink rendered="true" action="#{userReqIPAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP Address</strong></span>
				<f:param name="sortColumn" value="#{userReqIPBean.sortV01.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="ipDetailTable2" />
		  </h:commandLink>
		 <h:inputText value="#{userReqIPBean.filterV01.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
																</f:facet>
																<div align="center">
																	<h:outputText value="#{detail.level2Start} - #{detail.level2End}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>
															
															<rich:column width="85px;" style="vertical-align:top;" sortBy="#{detail.effectiveDate}" sortOrder="#{userReqIPBean.sortV01.sortColumn2}" >
																<f:facet name="header">
																	<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
																<div align="center">
									          					    <h:outputText value="#{detail.effectiveDate}" styleClass="contentform">
									          					    	<f:convertDateTime pattern="dd/MM/yyyy" />
									          					    </h:outputText>
																</div>
															</rich:column>
															<rich:column width="85px;" style="vertical-align:top;" sortBy="#{detail.expireDate}" sortOrder="#{userReqIPBean.sortV01.sortColumn3}"> 
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
																			
																		</h:panelGroup>
																	</rich:column>	
																</rich:columnGroup>										
															</f:facet>
														</rich:dataTable>
													</h:panelGroup>
								  			</rich:panel>		
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
										    	<a4j:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
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
	<jsp:include page="popup/IPSUR001_HISTORY.jsp" />
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>
	<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
</f:view>
</body>
</html>
