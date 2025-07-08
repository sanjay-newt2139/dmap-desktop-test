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
</script>	
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>
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
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w">
								<span class="style9">Planning Request IP</span></strong>
							</td>	
					  </tr>
					  <tr bgcolor="#f3f2f2" style="display: none">
                             <td height="25" align="left" valign="middle">
                             <table border="0" width="100%">
                             	<tr  >
                             		<td width="160" align="right"><span class="HeaderLabel"><strong>UR No&nbsp;:&nbsp;</strong></span></td>
                             		<td width="140"><span class="HeaderLabel">IP2010000002</span></td>
                             		<td width="380"  align="right"><span class="statusID">Wait for Assign IP</span></td>
                             		<td>&nbsp;</td>
                             	</tr>
                             </table>
                             </td>
					  </tr>
					    <tr bgcolor="#BFBFBF">
					         <td>
								  <table border="0" cellpadding="0" cellspacing="0" align="left" >
									<tr>
										<td height="2" colspan="8" align="center" valign="bottom"></td>
									</tr>
							  	</table>
							</td>  
					    </tr>
						<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="reqProfile" label="Requester Profile" >
									<table width="97%" border="0" class="thtext_detail">
								    <tr class="displayRow">   
								    	<td  align="right" class="labelStyle" ><strong>Name :</strong>&nbsp;</td>
								    	<td  align="left" class="valueStyle">
									    	<h:outputText id="userName" value="#{planningReqIPBean.ipUrIpdetail.reqName}">
											</h:outputText>
										</td>
										<td  align="right" class="labelStyle"><strong>Department :</strong>&nbsp;</td>
									    <td  align="left" class="valueStyle">
									    	<h:outputText id="dept" value="#{planningReqIPBean.ipUrIpdetail.reqDept}">
											</h:outputText>
										</td>
										<td>&nbsp;</td>

									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Email :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">
									    	<h:outputText id="email" value="#{planningReqIPBean.ipUrIpdetail.reqEmail}">
											</h:outputText>									    
										</td>
										<td  align="right" class="labelStyle"><strong>Section :</strong>&nbsp;</td>
									    <td  align="left" class="valueStyle">
									    	<h:outputText id="section" value="#{planningReqIPBean.ipUrIpdetail.reqSection}">
											</h:outputText>
										</td>
										<td>&nbsp;</td>
									  </tr>
									   <tr class="displayRow">
									   	<td align="right" class="labelStyle"><strong>Mobile :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">
									    	<h:outputText id="mobile" value="#{planningReqIPBean.ipUrIpdetail.reqMobile}">
											</h:outputText>										    
										</td>
									    <td align="right" class="labelStyle"><strong>Position :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">
									    	<h:outputText id="position" value="#{planningReqIPBean.ipUrIpdetail.reqPosition}">
											</h:outputText>										    
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Tel :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">
									    	<h:outputText id="telephone" value="#{planningReqIPBean.ipUrIpdetail.reqTel}">
											</h:outputText>											    
									    </td>
									    <td align="right" class="labelStyle"><strong>Team :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">
									    	<h:outputText id="userTeamId" value="#{planningReqIPBean.ipUrIpdetail.reqIpTeam.teamName}">
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
								<rich:simpleTogglePanel switchType="client" id="urInformation" label="UR Information" >
									<h:panelGroup style="width:100%">
										<h:panelGrid  columns="1" cellpadding="0" cellspacing="0" style="text-align:right; position:absolute; right:5px;">
											<h:outputText value="#{planningReqIPBean.ipUrIpdetail.urNo}" style="font-weight:bold; color:#0000FF;" />
											<h:outputText value="#{planningReqIPBean.v_urStatusDesc}" style="font-weight:bold; color:#FF0000;" />
										</h:panelGrid>
									<table width="97%" border="0" class="thtext_detail">
								    <tr class="displayRow" >   
								    	<td width="200" align="right" class="labelStyle"><strong>Subject :</strong>&nbsp;</td>
								    	<td align="left" colspan="3" class="valueStyle">
									    	<h:outputText id="subject" value="#{planningReqIPBean.ipUrIpdetail.subject}"></h:outputText>
									   	</td>
									   	<td>&nbsp;</td>
									  </tr>
							          <tr class="displayRow">
							            <td align="right" class="labelStyle"><strong>System Owner :</strong>&nbsp;	</td>
									    <td align="left"  class="valueStyle">
									        <h:outputText id="systemOwner" value="#{planningReqIPBean.ipUrIpdetail.sysOwnerName}"></h:outputText>
									    </td>
									    <td align="right" class="labelStyle"><strong>System Owner Team :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle" >
									       <h:outputText id="systemOwnerTeam" value="#{planningReqIPBean.ipUrIpdetail.sysOwnerTeamName}" style=""></h:outputText>
									    </td>
									    <td>&nbsp;</td>
							          </tr>
							          <tr class="displayRow">
									    <td align="right" class="labelStyle" ><strong>Contact Point :</strong>&nbsp; </td>
									    <td align="left" colspan="3" class="valueStyle">
									    	<h:outputText id="contactPoint" value="#{planningReqIPBean.ipUrIpdetail.contactPoint}"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
							          </tr>
									  <tr class="displayRow">
									     <td align="right" valign="top" class="labelStyle" ><strong>Network System Requirement :</strong>&nbsp;</td>
									     <td align="left" class="valueStyle" colspan="3" valign="top" >
									    	    <h:inputTextarea id="networkSystem"  rows="3" cols="38"  value="#{planningReqIPBean.ipUrIpdetail.nwSysDetail}" readonly="true" style="width:525px;"> </h:inputTextarea>	
									     </td>
									     <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right"  class="labelStyle">
										        <strong>Network Type :</strong>&nbsp;
										</td>
									    <td  align="left" class="valueStyle" colspan="3">
									        <h:outputText id="networkType" value="#{planningReqIPBean.ipUrIpdetail.networkTypeName}"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="inputRow">
									    <td  align="right" class="labelStyle"><strong>Request Type :</strong>&nbsp;</td>
									    <td  align="left" class="valueStyle">
									         <h:outputText  value="Network Zone" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='N'}"></h:outputText>
									         <h:outputText  value="Existing Network Zone" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle" ><strong ><h:outputLabel value="Network Zone Name" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='N'}" /><h:outputLabel value="Existing Network Zone" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}" />  :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle" colspan="3">
									           <h:outputText id="networkZones" value="#{planningReqIPBean.ipUrIpdetail.zoneName}"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr id="rowGroupNetwork" style="display: none;">
											<td class="labelStyle"><strong><h:outputLabel value="Existing IP Network Ref"></h:outputLabel>  :</strong>&nbsp;</td>
											<td align="left" colspan="3">
                                                  <h:inputText value="#{planningReqIPBean.ipUrIpdetail.ipRef}" style="width:156" ></h:inputText>
									    	</td>
									    	<td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>IP Network Ref :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle" colspan="3">
									         <h:outputText id="ipNetworkRef" value="#{planningReqIPBean.ipUrIpdetail.ipRef}"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="inputRow" >
											 	<td align="right" valign="top" class="labelStyle" ><strong>Network Size :</strong>&nbsp;</td>
												<td colspan="3" class="valueStyle">
											 		<h:panelGrid columns="5" cellspacing="0" cellpadding="0" style="margin-left:0px;">
														<h:outputText value="Total Node" escape="false"  />
														<rich:spacer width="20" />
											 			<h:outputText value="#{planningReqIPBean.ipUrIpdetail.totalNodeStr}" style="width:100%;text-align:right;" escape="false" />
											 			<rich:spacer width="10" />
											 			<h:outputText value="Hosts" escape="false"/>	
	
											 			<h:outputText value="Class B" escape="false"/>
														<rich:spacer width="20" />
											 			<h:outputText value="#{planningReqIPBean.ipUrIpdetail.classBStr}" style="width:100%;text-align:right;" escape="false" />
											 			<rich:spacer width="10" />
											 			<h:outputText value="Network" escape="false" />

											 			<h:outputText value="Class C" escape="false" />
														<rich:spacer width="20" />
											 			<h:outputText value="#{planningReqIPBean.ipUrIpdetail.classCStr}" style="width:100%;text-align:right;" escape="false" />
											 			<rich:spacer width="10" />
											 			<h:outputText value="Network" escape="false"/>

											 		</h:panelGrid>
									  			</td>
									  			<td>&nbsp;</td>
									  		</tr>
									  <tr class="displayRow">
													<td align="right" valign="top" class="labelStyle" ><strong>Network Diagram :</strong>&nbsp;</td>
													<td>
													  <rich:dataTable width="80%" 
														id="networkDiagramTable" cellpadding="1" cellspacing="0"
														border="0" var="attachmentList" value="#{planningReqIPBean.ipUrAttachmentList}"
														reRender="scrollNetworkDiagramTable" rows="5"
														rowClasses="odd,even" styleClass="contentform"
														rowKeyVar="index" headerClass="tableHeader"
														style=" width : 200px;">

														<rich:column width="70%">
															<f:facet name="header">
																<h:outputText value="File Name"
																	styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
															<div align="left">
															   <h:commandLink action="#{planningReqIPAction.downloadFile}">
															       <h:outputText value="#{attachmentList.fileName}" style="TEXT-DECORATION: underline;"/>
															       <a4j:actionparam name="fileName" value="#{attachmentList.fileName}"/>
															        <a4j:actionparam name="path" value="#{attachmentList.fileLocation}"/>
                                                               </h:commandLink>
															</div>
															
														</rich:column>
													</rich:dataTable>
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
						     <rich:simpleTogglePanel switchType="client" id="acitonHistory" label="Assignment" opened="true"  rendered="#{planningReqIPBean.ipUrIpdetail.urStatus=='CLOSE'}" >
						   	 		<table width="97%" border="0"  class="thtext_detail">
						   	 		<tr> 
	                                  		<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Company"></h:outputText>&nbsp;:&nbsp;</strong>
											</td>	
											<td  height="25" colspan="3" align="right" class="valueStyle">
	                                               <h:outputText value="#{planningReqIPBean.ipUrIpResult.companyName}"/>
											</td>	
											<td>&nbsp;</td>		
	                                  </tr> 
										<tr >
											<td height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="IP Type"></h:outputText>&nbsp;:&nbsp;</strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
												<h:outputText value="#{planningReqIPBean.ipUrIpResult.ipTypeName}"/>
											</td>	
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
                                                <h:outputText value="#{planningReqIPBean.ipUrIpResult.networkTypeName}"/>
											</td>
											<td>&nbsp;</td>													
	                                  	</tr>
	                                  		<tr> 
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="VLAN ID :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
											    <h:outputText value="#{planningReqIPBean.ipUrIpResult.vlanId}" />
											</td>
											<td align="right" class="labelStyle">
												<strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;
											</td>
											<td class="valueStyle">
                                                <h:outputText value="#{planningReqIPBean.ipUrIpResult.networkZoneName}"/>
											</td>
											<td>&nbsp;</td>														
	                                  	</tr>
	                             
	                                  		<tr> 
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="DNS Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
											    <h:outputText value="#{planningReqIPBean.ipUrIpResult.dnsName}" />
											</td>
											<td align="right" class="labelStyle">
												<strong><h:outputText value="Network IP :"></h:outputText></strong>&nbsp;
											</td>
											<td class="valueStyle">
                                                <h:outputText value="#{planningReqIPBean.ipUrIpResult.networkIp}"/>
											</td>	
											<td>&nbsp;</td>													
	                                  	</tr>
	                                  	
	                                  	<tr> 
	                                  		<td  height="25" align="right"  class="labelStyle">
												<strong><h:outputText value="VIP :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
										        <h:outputText value="#{planningReqIPBean.ipUrIpResult.vip}" />
											</td>
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Gateway :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
										        <h:outputText value="#{planningReqIPBean.ipUrIpResult.gateway}" />
											</td>
											<td>&nbsp;</td>															
	                                  </tr>   
	                                  <tr> 
	                                  		<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Effective Date"></h:outputText>&nbsp;:&nbsp;</strong>
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
									              <h:outputText value="#{planningReqIPBean.ipUrIpResult.effectiveDate}">
									                 <f:convertDateTime pattern="dd/MM/yyyy"/>
									              </h:outputText>
											</td>
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Expire Date :"></h:outputText>&nbsp;:&nbsp;</strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
											     <h:outputText value="#{planningReqIPBean.ipUrIpResult.expireDate}">
											        <f:convertDateTime pattern="dd/MM/yyyy"/>
											     </h:outputText>
											</td>
											<td>&nbsp;</td>														
	                                  </tr> 
	                                  <tr> 
	                                  		<td  height="25" align="right"  class="labelStyle" valign="top" >
												<strong><h:outputText value="Remarks :"></h:outputText>&nbsp;</strong>
											</td>	
									        <td height="22"  align="left" colspan="3" class="valueStyle" >
												<h:outputText value="#{planningReqIPBean.ipUrIpResult.remarks}"/>
											</td>
											<td>&nbsp;</td>														
	                                  </tr>  
	                                  <tr>
	                                    <td><img src="../images/blank.gif" width="10" height="5"></td>
	                                  </tr>                                                      
									</table>	       
								<rich:dataTable width="95%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="assignmenIPtList" value="#{planningReqIPBean.assignmentIPList}" reRender="scrollIPDetailTable"  
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
							            <rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						   <h:outputText value="#{index+1}" styleClass="contentform"/>
											</div>
										</rich:column>									
										<rich:column  filterValue="#{planningReqIPBean.filterIpsur002V.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(assignmenIPtList.level1Start,planningReqIPBean.filterIpsur002V.filterColumn1)}"  width="25%" >
											<f:facet name="header">												
													  <h:panelGroup>
		 <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002V.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						    <h:outputText value="#{assignmenIPtList.level1Start}" styleClass="contentform"/> - <h:outputText value="#{assignmenIPtList.level1End}" styleClass="contentform"/>
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					    <h:outputText value="#{assignmenIPtList.effectiveDate}"  styleClass="contentform">
				          					       <f:convertDateTime pattern="dd/MM/yyyy"/>
				          					    </h:outputText>
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Expire Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					     <h:outputText value="#{assignmenIPtList.expireDate}" styleClass="contentform">
				          					       <f:convertDateTime pattern="dd/MM/yyyy"/>
				          					     </h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
		                                    <rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{fn:length(planningReqIPBean.assignmentIPList)}" /> records
												</rich:column>
												<rich:column colspan="8" >
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable2"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable2" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
														style="background-color: #cccccc;"/>
												</rich:column>	
											</rich:columnGroup>										
										</f:facet>
									</rich:dataTable>&nbsp;					
								</rich:simpleTogglePanel>
						  </td>
						</tr>						
						<tr>
							<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
						</tr>
						<tr align="right">
							<td align="right" >
								<table width="97%" border="0" cellspacing="0" cellpadding="0" align="right" >
								<tr>
									<td width="230">
		                             		 <a4j:commandLink id="urLink" reRender="IPURS004_05Popup" action="#{planningReqIPAction.popupHistory}"  style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
								      	            oncomplete="#{rich:component('IPURS004_05Popup')}.show(); return false" >
								      	            <h:outputText value="View History"/>
								             </a4j:commandLink>
									</td>
									<td colspan="5" align="right" >
										<h:panelGroup id="buttonGroup">
											<a4j:commandButton id="btnCancel" value="Close" styleClass="rich-button"
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

	<jsp:directive.include file="popup/IPSUR002_HISTORY.jsp"/>
</f:view>
</body>
</html>
