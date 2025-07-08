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
	<f:subview id="menus">
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
					<table width="100%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w">
								<span class="style9">User Request IP</span></strong>
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
								    	<td  align="left" class="valueStyle">&nbsp;
									    	<h:outputText id="userName" value="#{userSession.ipUser.userName}">
											</h:outputText>
										</td>
										<td  align="right" class="labelStyle"><strong>Department :</strong>&nbsp;</td>
									    <td  align="left" class="valueStyle">&nbsp;
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
										<td  align="right" class="labelStyle"><strong>Section :</strong>&nbsp;</td>
									    <td  align="left" class="valueStyle">&nbsp;
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
								<rich:simpleTogglePanel switchType="client" id="urInformation" label="UR Information" >
									<table width="100%" border="0" class="thtext_detail">
								     <tr class="displayRow">   
								    	<td width="230" align="right" class="labelStyle"><strong>Subject :</strong>&nbsp;</td>
								    	<td width="114" align="left" colspan="3" class="valueStyle">&nbsp;
									    	<h:outputText id="subject" value="Request IP "></h:outputText>
									   	</td>
									   	<td>&nbsp;</td>
									  </tr>
								      <tr class="displayRow">   
									    <td align="right" class="labelStyle"><strong>Request from Planning Team :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;
								    	   <h:outputText id="reqPlanning" value="IP-WSP"></h:outputText></td>
								    	<td>&nbsp;</td>
									  </tr>									  
									  <tr class="displayRow">										
										<td align="right" class="labelStyle"><strong>Project ID :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle">&nbsp;
									       <h:outputText  value="PRJ001"></h:outputText>
									    </td>
									    <td  align="right" class="labelStyle"><strong>Project Name:</strong></td>
									    <td  align="left" class="valueStyle">&nbsp;
									       <h:outputText value="Project One"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Project Manager :</strong>&nbsp;</td>
									    <td align="left"  colspan="3" class="valueStyle">&nbsp;										
											<h:outputText id="projectManagerName" value="Boonyakiat Ngouriathul"></h:outputText></td>
										<td>&nbsp;</td>
									  </tr>
							          <tr class="displayRow">
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
							          <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Contact Point :</strong>&nbsp; </td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;
									    	<h:outputText id="contactPoint" value="#{userReqIPBean.ipUrIP.contactPoint}"></h:outputText>
									    </td>
									   	<td>&nbsp;</td>
							          </tr>
									  <tr class="displayRow">
									     <td align="right" valign="top" class="labelStyle" ><strong>Network System Requirement :</strong>&nbsp;</td>
									     <td align="left" colspan="3" class="valueStyle">
									     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										     	&nbsp;
										   		<h:inputTextarea id="networkSystem"  rows="3" cols="120"  value="Request new IP" style="COLOR: #adadad;" disabled="true"> </h:inputTextarea>	
									   		</h:panelGrid>
									     </td>
									     <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Network Type :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="networkType" value="Client/User"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Request Type :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="requestType" value="Expansion Network"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle" ><strong>Existing Network Zone Name :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="networkZone" value="Network CCARE"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>IP Network Ref :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;<h:outputText id="ipNetworkRef" value="10.0.0.0"></h:outputText></td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong>Site/Location :</strong>&nbsp;</td>
									    <td align="left" colspan="3" class="valueStyle">&nbsp;
									         <h:outputText id="location" value="Office User - ST1"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
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
									     <td align="left" colspan="3" class="valueStyle" valign="top">
									     	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										     	&nbsp;
									    	    <h:inputTextarea id="comment"  rows="3" cols="120"  value="ระบุข้อมูล  Contact Point" ></h:inputTextarea>
									    	</h:panelGrid>
									    </td>
									  </tr>										  								  
								    </table>
							  </rich:simpleTogglePanel>	
							</td>
						</tr>
						
						<tr>
						   <td>
						   	 <rich:simpleTogglePanel switchType="client" id="acitonHistory" label="Assignment" opened="true" >
						   	 	<table width="97%" border="0"  class="thtext_detail">
						   	 		<tr> 
	                                  		<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Company"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
											<td  height="25" align="right" class="valueStyle">
									                    <rich:comboBox id="company"
															defaultLabel="" enableManualInput="false"
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{userReqIPBean.companyComboItem}" width="150">
															<f:attribute name="selectItems" value="#{userReqIPBean.companyList}"/>
															<f:selectItems value="#{userReqIPBean.companyList}"/>
														</rich:comboBox>		
											</td>	
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Site/Location :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
							                                <rich:comboBox id="locations" defaultLabel=""
																enableManualInput="false" itemClass="contentform" 
																itemSelectedClass="contentform" value="ST1" width="150">
																<f:selectItem itemLabel="ST1" itemValue="ST1"/>
															</rich:comboBox>													
											</td>
											<td>&nbsp;</td>
														
	                                  </tr> 
										<tr>
											<td height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="IP Type"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                               <rich:comboBox id="ipType"
															defaultLabel="" enableManualInput="false"
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{userReqIPBean.ipTypeComboItem}" width="150">
															<f:attribute name="selectItems" value="#{userReqIPBean.ipTypeList}"/>
															<f:selectItems value="#{userReqIPBean.ipTypeList}"/>
														</rich:comboBox>													
											</td>	
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
											   <rich:comboBox
												id="networkTypes" defaultLabel="" enableManualInput="false"
												itemClass="contentform" itemSelectedClass="contentform"
												value="#{userReqIPBean.nwTypeComboItem}" width="150">
													<f:attribute name="selectItems" value="#{userReqIPBean.nwTypeList}"/>
													<f:selectItems value="#{userReqIPBean.nwTypeList}"/>
											  </rich:comboBox>	
											</td>
											<td>&nbsp;</td>													
	                                  	</tr>
	                                  		<tr> 
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="VLAN ID :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
                                                <h:inputText id="vlan" value="" size="20"	 
                                                 style="text-align:cente"/>														
											</td>
											<td align="right" class="labelStyle">
												<strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;
											</td>
											<td class="valueStyle">
                                          	 <rich:comboBox
												id="zone" defaultLabel="" enableManualInput="false"
												itemClass="contentform" itemSelectedClass="contentform"
												value="#{userReqIPBean.nwZoneComboItem}" width="150">
													<f:attribute name="selectItems" value="#{userReqIPBean.nwZoneList}"/>
													<f:selectItems value="#{userReqIPBean.nwZoneList}"/>
											  </rich:comboBox>
											</td>
											<td>&nbsp;</td>														
	                                  	</tr>
	                             
	                                  		<tr> 
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="DNS Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
                                                <h:inputText id="dns" value="" size="20"	 
                                                 style="text-align:cente"/>														
											</td>
											<td align="right" class="labelStyle">
												<strong><h:outputText value="Network IP :"></h:outputText></strong>&nbsp;
											</td>
											<td class="valueStyle">
                                                <h:inputText id="networkIp" value="" size="20"	 
                                                 style="text-align:cente"/>		
											</td>
											<td>&nbsp;</td>														
	                                  	</tr>
	                                  	
	                                  	<tr> 
	                                  		<td  height="25" align="right"  class="labelStyle">
												<strong><h:outputText value="VIP :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                          <h:selectOneRadio id="vip"
															styleClass="contentform"
															value="">
															<f:selectItem itemLabel="Yes" itemValue="Y" />
															<f:selectItem itemLabel="No" itemValue="N" />
												  </h:selectOneRadio>											
											</td>
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Gateway :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                           <h:inputText id="gateway" value="" size="20"	 
		                                                 style="text-align:cente"/>												
											</td>
											<td>&nbsp;</td>															
	                                  </tr>   
	                                  <tr> 
	                                  		<td  height="25" align="right"  class="labelStyle">
												<strong><h:outputText value="Install Type :"></h:outputText></strong>&nbsp;
											</td>	
									        <td colspan="3" height="22"  align="left" class="valueStyle" >
		                                          <h:selectOneRadio id="install"
															styleClass="contentform"
															value="">
															<f:selectItem itemLabel="Permanent " itemValue="Y" />
															<f:selectItem itemLabel="Temporary" itemValue="N" />
												  </h:selectOneRadio>											
											</td>
											<td>&nbsp;</td>		
	                                  </tr>  
	                                  <tr> 
	                                  		<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Effective Date"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                     <rich:calendar value=""
									                        locale="en/US"
									                        popup="true"
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
									                        inputStyle="background-color:white"
									                        inputSize="20"
									                        direction="auto"/>												
											</td>
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Expire Date"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                     <rich:calendar value=""
									                        locale="en/US"
									                        popup="true"
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
									                        inputStyle="background-color:white"
									                        inputSize="20"
									                        direction="auto"/>												
											</td>
											<td>&nbsp;</td>														
	                                  </tr> 
	                                  <tr> 
	                                  		<td  height="25" align="right"  class="labelStyle" valign="top" >
												<strong><h:outputText value="Remarks :"></h:outputText>&nbsp;</strong>
											</td>	
									        <td height="22"  align="left" valign="top" colspan="3" class="valueStyle" >
												<h:inputTextarea id="remark" value=""  rows="3" cols="99" style="text-align:cente"/>	
											</td>
											<td>&nbsp;</td>														
	                                  </tr>  
	                                  <tr>
	                                    <td><img src="../images/blank.gif" width="10" height="5"></td>
	                                  </tr>                                                      
									</table>	
								  <rich:panel >	   
								         
						   	 	  <h:panelGrid id="groupDetail" columns="19" styleClass="contentlabelform" cellpadding="0"  cellspacing="0" border="0">
						   	 	   <strong>IP Version :&nbsp;</strong>
				   	 	   				<rich:comboBox
											id="ipversion" defaultLabel="" enableManualInput="false"
											itemClass="contentform" itemSelectedClass="contentform"
											value="" width="50">
											<f:selectItem itemValue="4"/>
											<f:selectItem itemValue="6"/>
										 </rich:comboBox>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   	 	   <strong>IP Address:&nbsp;</strong>
								   <h:panelGroup id="rangIpGroup">
									   				<h:inputText id="stIp1" value=""  
														size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
			                                        <h:inputText id="stIp2" value="" 
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
                                        			<h:inputText id="stIp3" value=""  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
													<h:inputText id="stIp4" value=""  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText style="font-weight: bolder;">
														&nbsp;/&nbsp;
													</h:outputText>
													<h:inputText id="stIp5" value=""
													 	size="1" style="text-align:center" maxlength="3" 
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
												</h:panelGroup>	&nbsp;&nbsp;&nbsp;&nbsp;
										    <a4j:commandButton id="btnAssign" value="Add" styleClass="rich-button"
												action="#{userReqIPAction.add}" reRender="ipDetailTable2" >
												<a4j:actionparam name="programIDParam" value="IPURS015_03"/>
											</a4j:commandButton>&nbsp;&nbsp;
										    <a4j:commandButton id="btnDelete" value="Delete" styleClass="rich-button"
									           action="#{userReqIPAction.upload}" reRender="ipDetailTable2"/>&nbsp;&nbsp;
											<a4j:commandButton id="btnSelect" value="Search IP" styleClass="rich-button"
												action="#{userReqIPAction.init}">
												 <rich:componentControl for="IPURS004_07Popup" attachTo="btnSelect" operation="show" event="onclick"/>
											</a4j:commandButton>
										</h:panelGrid>
									  
								<rich:dataTable width="100%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="ipDetail" value="#{userReqIPBean.userReques_AddList}" reRender="scrollIPDetailTable" rows=""  
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
										<rich:column width="5%" >
											<f:facet name="header">
												<h:selectBooleanCheckbox></h:selectBooleanCheckbox>
											</f:facet>
											<div align="center">
                                                <h:selectBooleanCheckbox></h:selectBooleanCheckbox>
											</div>
										</rich:column>
							            <rich:column  filterValue="#{userReqIPBean.filter00406.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.NETWORK_TYPE,userReqIPBean.filter00406.filterColumn1)}"   width="10%" >
											<f:facet name="header">												
													  <h:panelGroup>
		 <h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00406.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						   <h:outputText value="#{ipDetail.NETWORK_TYPE}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>									
										<rich:column  filterValue="#{userReqIPBean.filter00406.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.NETWORK_TYPE_ID,userReqIPBean.filter00406.filterColumn2)}"   width="20%" >
											<f:facet name="header">												
												 <h:panelGroup>
		 <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00406.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						    <h:outputText value="#{ipDetail.NETWORK_TYPE_ID}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column  filterValue="#{userReqIPBean.filter00406.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(ipDetail.NETWORK_TYPE_NAME,userReqIPBean.filter00406.filterColumn3)}"   width="10%" >
											<f:facet name="header">
												
												 <h:panelGroup>
		 <h:outputText value="Host Name" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00406.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						    <h:outputText value="#{ipDetail.NETWORK_TYPE_NAME}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					    <h:outputText value="#{ipDetail.NEW_DATA_CENTER_ID}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Expire Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					     <h:outputText value="#{ipDetail.NEW_DATA_CENTER_NAME}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
		                                    <rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="0" /> records
												</rich:column>
												<rich:column colspan="8">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable2"
														maxPages="#{manageDataIPBean.maxPage}" id="scrollIPDetailTable2" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="hide" boundaryControls="hide" 
														style="background-color: #cccccc;"/>
												</rich:column>	
											</rich:columnGroup>										
										</f:facet>
									</rich:dataTable>&nbsp;
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td valign="top" width="15%">
												<a4j:commandLink action="#{userReqIPAction.init}">Download Template</a4j:commandLink>
											</td>
											<td>
												 <rich:fileUpload fileUploadListener="#{systemParameterAction.listener}"
								             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
								             			id="impFirewall" 
								             			clearControlLabel=""
                                                        cancelEntryControlLabel=""
								             			immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
								             			acceptedTypes="#{systemParameterFileUploadBean.acceptedTypes}" 
								             			allowFlash="#{systemParameterFileUploadBean.useFlash}"
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
								             			addControlLabel="Browse"
								             			listWidth="100%" onuploadcomplete="fireClickEvent(document.getElementById('popupModalSubview:formRegionMultiQuery:ImportForm:btnSubmitUpload'));" >
								             			 <a4j:support event="onuploadcomplete"  reRender="groupImportCommand" />
								         			</rich:fileUpload>
											</td>
										</tr>
									</table>		
								  </rich:panel>								
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
											<a4j:commandLink id="urLink" action="#{userReqIPAction.init}" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" >View History
                             		        <rich:componentControl for="IPURS004_05_UR" attachTo="urLink" operation="show" event="onclick"/>
                             		  </a4j:commandLink>
									</td>
									<td colspan="5" align="right" >
										<h:panelGroup id="buttonGroup">
											<a4j:commandButton id="btnSendApprove" value="Assign" styleClass="rich-button"
												action="#{userReqIPAction.sendApprove}"/>&nbsp;
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
	<jsp:directive.include file="IPURS004_07.jsp"/>
</f:view>
</body>
</html>
