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
								<span class="style9">User Request IP</span></strong>
							</td>	
					  </tr>
					  <tr bgcolor="#f3f2f2" style="display: none" >
                             <td height="25" align="left" valign="middle">
                             <table border="0" width="100%">
                             	<tr>
                             		<td width="160" align="right"><span class="HeaderLabel"><strong>UR No&nbsp;:&nbsp;</strong></span></td>
                             		<td width="140"><span class="HeaderLabel">IP2010000001</span></td>
                             		<td width="380"  align="right"><span class="statusID">Wait for Manager Approve</span></td>
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
								    <tr>   
								    	<td width="150" align="right" class="labelStyle"><strong>Name :</strong>&nbsp;</td>
								    	<td width="230" align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="userName" value="#{userSession.ipUser.userName}">
											</h:outputText>
										</td>
										<td width="150" align="right" class="labelStyle" ><strong>Department :</strong>&nbsp;</td>
									    <td width="230" align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="dept" value="#{userSession.ipUser.dept}">
											</h:outputText>
										</td>
										<td>&nbsp;</td>

									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>Email :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="email" value="#{userSession.ipUser.email}">
											</h:outputText>									    
										</td>
										<td  align="right" class="labelStyle"><strong>Section :</strong>&nbsp;</td>
									    <td  align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="section" value="#{userSession.ipUser.section}">
											</h:outputText>
										</td>
										<td>&nbsp;</td>
									  </tr>
									   <tr>
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
									  <tr>
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
								<rich:simpleTogglePanel switchType="client" id="urInformation" label="UR Information" >
									<table width="97%" border="0" class="thtext_detail">
								     <tr>   
								    	<td width="230" align="right" class="labelStyle"><strong>Subject :</strong>&nbsp;</td>
								    	<td width="114" align="left" colspan="3" class="valueStyle">&nbsp;
									    	<h:outputText id="subject" value="Request IP ">	</h:outputText>
									   	</td>
									   	<td>&nbsp;</td>
									  </tr>
								      <tr>   
									    <td align="right" class="labelStyle"><strong>Request from Planning Team :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;
								    	   <h:outputText id="reqPlanning" value="IP-WSP"></h:outputText></td>
									  </tr>									  
									  <tr>
									    <td align="right" class="labelStyle"><strong>Project ID :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;
									    	<h:outputText id="projectID" value="PRJ001 "></h:outputText>&nbsp;
											<h:outputText id="projectName" value="Project One"></h:outputText>
										</td>
										<td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>Project Manager :</strong>&nbsp;</td>
									    <td align="left"  colspan="3" class="valueStyle">&nbsp;										
											<h:outputText id="projectManagerName" value="Boonyakiat Ngouriathul"></h:outputText></td>
										<td>&nbsp;</td>
									  </tr>
							          <tr>
									    <td align="right" class="labelStyle"><strong>System Owner :</strong>&nbsp;	</td>
									    <td align="left" class="valueStyle">&nbsp;
									          <h:outputText id="systemOwner" value="Boonyakiat Ngouriathul"></h:outputText>
									    </td>
									    <td  align="right" class="labelStyle"><strong>System Owner Team :</strong></td>
									    <td  align="left" class="valueStyle">&nbsp;
									       <h:outputText value="IP-CDN"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
							          </tr>
							          <tr>
									    <td align="right" class="labelStyle"><strong>Contact Point :</strong>&nbsp; </td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;
									    	<h:outputText id="contactPoint" value="Call#4546,4545">	</h:outputText>
									    </td>
									    <td>&nbsp;</td>
							          </tr>
									  <tr>
									     <td align="right" valign="top" class="labelStyle" ><strong>Network System Requirement :</strong>&nbsp;</td>
									     <td align="left" colspan="3" class="valueStyle">&nbsp;
									    	    <h:inputTextarea id="networkSystem"  rows="3" cols="120"  value="Request new IP" style="COLOR: #adadad;"> </h:inputTextarea>	</td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>Network Type :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="networkType" value="Client/User"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>Request Type :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="requestType" value="Expansion Network"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle" ><strong>Existing Network Zone Name :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="networkZone" value="Network CCARE"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>IP Network Ref :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="ipNetworkRef" value="10.0.0.0"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>Site/Location :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle" >&nbsp;
									         <h:outputText id="location" value="Office User - ST1"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr>
									    <td align="right" class="labelStyle"><strong>Network Size :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle" >&nbsp;
									           <h:outputText id="networkSize" value="Total Node 10 Host"></h:outputText>
									   </td>
									   <td>&nbsp;</td>
									  </tr>
								<tr class="inputRow">
									  <td align="right" class="labelStyle"  valign="top"><strong>Network Diagram<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong>&nbsp;</td>	
									  <td valign="top" style=" width : 189px;">
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
				          						    <h:outputText value="#{userReqo1.REQ_NAME}" style="TEXT-DECORATION: underline;" />
												</div>
											</rich:column>								
										</rich:dataTable>
									   </td>	
									  
									  <td align="right"  valign="top" >
									      <table border="0" cellpadding="0" cellspacing="0" >
									        <tr class="inputRow">
									         <td class="labelStyle"><strong>Application Flow&nbsp;:</strong>&nbsp;</td>
									        </tr>
									      </table>		 
									  </td>	
									  <td valign="top">	
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
				          						   <h:outputText value="AppFlowA.jpg" style="TEXT-DECORATION: underline;" />
												</div>
											</rich:column>								
										</rich:dataTable>							 
									  </td>	
									  <td>&nbsp;</td>
								  </tr>	
									  <tr>
									     <td align="right" valign="top" class="labelStyle"><strong>Remarks :</strong>&nbsp;</td>
									     <td align="left" valign="top" colspan="3"  class="valueStyle">&nbsp;
									    	    <h:inputTextarea id="comment"  rows="3" cols="120"  value="ระบุข้อมูล  Contact Point" ></h:inputTextarea></td>
									    <td>&nbsp;</td>
									  </tr>										  								  
								    </table>
							  </rich:simpleTogglePanel>
							</td>
						</tr>
												
						<tr>
							<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
						</tr>
						<tr align="right" >
							<td align="right">
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
								<tr>
								    <td width="230">
								       <a4j:commandLink id="urLink" action="#{userReqIPAction.init}" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;">View History
                             		        <rich:componentControl for="IPURS004_05_UR" attachTo="urLink" operation="show" event="onclick"/>
                             		   </a4j:commandLink>
								    </td>
									<td colspan="5" align="right" >
										<h:panelGroup id="buttonGroup">
											<a4j:commandButton id="btnSendApprove" value="Approve" styleClass="rich-button"
												action="#{userReqIPAction.init}">
												 <a4j:actionparam name="programIDParam" value="IPURS004_06"/>
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button"
												action="#{userReqIPAction.init}">
												
										    </a4j:commandButton>&nbsp;
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
	<jsp:directive.include file="IPURS004_05_UR.jsp"/>
</f:view>
</body>
</html>
