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
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>
<script language="javascript">
	function selectAllBox(chk) {
		form = document.forms["DetailForm"];
		var count = form["DetailForm:ipDetailTable2:countId"].value; 
			for(i=0; i < count; i++){
			  form["DetailForm:ipDetailTable2:" +i+ ":chkboxs"].checked = chk;
			}
	}
	function setCountId(count){
		document.getElementById("DetailForm:ipDetailTable2:countId").value = count;
	}
	function downloadTemplate(){
		document.getElementById('DetailForm:downloadTemplate').click();
	}
</script>	
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>
</head>
<body style="overflow:hidden;">
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
		actionListener="#{planningReqIPAction.alertErrorMsg}"
	 	reRender="errorMsg">
	 	<a4j:actionparam name="errorMessage"/>
	</a4j:jsFunction>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
								<rich:simpleTogglePanel switchType="client"  width="100%" id="urInformation" label="UR Information" >
								   <h:panelGroup style="width:100%">
									<h:panelGrid  columns="1" cellpadding="0" cellspacing="0" style="text-align:right; position:absolute; right:5px;">
									   	   <h:outputText value="#{planningReqIPBean.ipUrIpdetail.urNo}" style="font-weight:bold; color:#0000FF;"/>
									   	   <h:outputText value="#{planningReqIPBean.ipUrIpdetail.urStatusName}" style="font-weight:bold; color:#FF0000;"/>
									</h:panelGrid>
									<table width="100%" border="0" class="thtext_detail">
								    <tr class="displayRow" >   
								    	<td width="200" align="right" class="labelStyle"><strong>Subject :</strong>&nbsp;</td>
								    	<td align="left" colspan="3" class="valueStyle">
									    	<h:outputText id="subject" value="#{planningReqIPBean.ipUrIpdetail.subject}">	</h:outputText>
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
									       <h:outputText id="systemOwnerTeam" value="#{planningReqIPBean.ipUrIpdetail.sysOwnerTeamName}"></h:outputText>
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
									    	    <h:inputTextarea id="networkSystem"  rows="3" cols="109"  value="#{planningReqIPBean.ipUrIpdetail.nwSysDetail}" readonly="true"> </h:inputTextarea>	
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
									    <td  align="left" class="valueStyle" colspan="3">
									         <h:outputText  value="New Network" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='N'}"></h:outputText>
									         <h:outputText  value="Expansion Network" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  <tr class="displayRow">
									    <td align="right" class="labelStyle" ><strong ><h:outputLabel value="Network Zone Name" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='N'}" /><h:outputLabel value="Existing Network Zone" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}" />  :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle" colspan="3">
									           <h:outputText id="networkZones" value="#{planningReqIPBean.ipUrIpdetail.zoneName}"></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>					
									  <h:panelGroup rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}">		
									  <tr class="displayRow">
									    <td align="right" class="labelStyle"><strong><h:outputLabel value="Existing IP Network Ref" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}" /> :</strong>&nbsp;</td>
									    <td align="left" class="valueStyle" colspan="3">
									         <h:outputText id="ipNetworkRef" value="#{planningReqIPBean.ipUrIpdetail.ipRef}" rendered="#{planningReqIPBean.ipUrIpdetail.reqType=='E'}" ></h:outputText>
									    </td>
									    <td>&nbsp;</td>
									  </tr>
									  </h:panelGroup>
									  <tr class="inputRow">
											<td align="right" valign="top" class="labelStyle" ><strong>Connected Existing AIS :</strong>&nbsp;</td>
										    <td align="left" colspan="3">
													<strong>Network System Plane :</strong>&nbsp;
													   <h:outputText  value="#{planningReqIPBean.ipUrIpdetail.systemPlane}"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<strong>User Plane :</strong>&nbsp;
													   <h:outputText  value="#{planningReqIPBean.ipUrIpdetail.userPlane}"></h:outputText>
										    </td>
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
													<td colspan="3">
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
						   	 <rich:simpleTogglePanel switchType="client" id="acitonHistory" label="Assignment" opened="true" >
						   	 		<table width="97%" border="0"  class="thtext_detail">
						   	 		<tr> 
	                                  		<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Company"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
											<td  height="25" colspan="3" align="right" class="valueStyle">
									                    <rich:comboBox id="company"
															defaultLabel="" enableManualInput="true" 
															itemClass="contentform" itemSelectedClass="contentform"
															value="#{planningReqIPBean.companyComboItem}" width="150">
															<f:attribute name="selectItems" value="#{planningReqIPBean.companyList}"/>
															<f:selectItems value="#{planningReqIPBean.companyList}"/>
															<a4j:support reRender="errorMsg,company" event="onchange" action="#{planningReqIPAction.checkCompanyCombo}" />
														</rich:comboBox>		
											</td>	
											<td>&nbsp;</td>		
	                                  </tr> 
										<tr >
											<td height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="IP Type"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
												 <rich:comboBox
													id="ipType" defaultLabel="" enableManualInput="true" 
													itemClass="contentform" itemSelectedClass="contentform"
													value="#{planningReqIPBean.ipTypeComboItem}" width="150">
														<f:attribute name="selectItems" value="#{planningReqIPBean.ipTypeList}"/>
														<f:selectItems value="#{planningReqIPBean.ipTypeList}"/>
														<a4j:support reRender="errorMsg,ipType" event="onchange" action="#{planningReqIPAction.checkipTypeCombo}" />
												  </rich:comboBox>													
											</td>	
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
											   <rich:comboBox
												id="networkTypes" defaultLabel="" enableManualInput="true" 
												itemClass="contentform" itemSelectedClass="contentform"
												value="#{planningReqIPBean.nwTypeComboItem}" width="150">
													<f:attribute name="selectItems" value="#{planningReqIPBean.nwTypeList}"/>
													<f:selectItems value="#{planningReqIPBean.nwTypeList}"/>
													<a4j:support reRender="errorMsg,networkTypes" event="onchange" action="#{planningReqIPAction.checkNetworkTypeCombo}" />
											  </rich:comboBox>	
											</td>
											<td>&nbsp;</td>													
	                                  	</tr>
	                                  		<tr> 
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="VLAN ID :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
                                                <h:inputText id="vlan" value="#{planningReqIPBean.ipUrIpResult.vlanId}" size="20"
                                                	onkeypress="return keyRange(this,event,1,4096);"
											        onblur="this.value = isNumber(this);"	 
                                                 	style="text-align:cente"/>														
											</td>
											<td align="right" class="labelStyle">
												<strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;
											</td>
											<td class="valueStyle">
                                          	 <rich:comboBox
												id="zone" defaultLabel="" enableManualInput="true" 
												itemClass="contentform" itemSelectedClass="contentform"
												value="#{planningReqIPBean.nwZoneComboItem}" width="150">
													<f:attribute name="selectItems" value="#{planningReqIPBean.nwZoneList}"/>
													<f:selectItems value="#{planningReqIPBean.nwZoneList}"/>
													<a4j:support reRender="errorMsg,zone" event="onchange" action="#{planningReqIPAction.checkNetworkZoneCombo}" />
											  </rich:comboBox>
											</td>
											<td>&nbsp;</td>														
	                                  	</tr>
	                             
	                                  		<tr> 
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="DNS Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle">
                                                <h:inputText id="dns" value="#{planningReqIPBean.ipUrIpResult.dnsName}" size="20"	 
                                                 style="text-align:cente"/>														
											</td>
											<td align="right" class="labelStyle">
												<strong><h:outputText value="Network IP :"></h:outputText></strong>&nbsp;
											</td>
											<td class="valueStyle">
                                                <h:inputText id="networkIp" value="#{planningReqIPBean.ipUrIpResult.networkIp}" size="20" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Network IP');"/>		
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
															value="#{planningReqIPBean.ipUrIpResult.vip}">
															<f:selectItem itemLabel="Yes" itemValue="Y" />
															<f:selectItem itemLabel="No" itemValue="N" />
												  </h:selectOneRadio>											
											</td>
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Gateway :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                           <h:inputText id="gateway" value="#{planningReqIPBean.ipUrIpResult.gateway}" size="20"  onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Gateway');"/>												
											</td>
											<td>&nbsp;</td>															
	                                  </tr>   
	                                  <tr> 
	                                  		<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Effective Date"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                     <rich:calendar value="#{planningReqIPBean.ipUrIpResult.effectiveDate}"
									                        locale="en/US"
									                        popup="true"
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
									                        inputStyle="background-color:white"
									                        inputSize="20"
									                        direction="auto"/>												
											</td>
											<td  height="25" align="right" class="labelStyle" >
												<strong><h:outputText value="Expire Date :"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>&nbsp;
											</td>	
									        <td height="22"  align="left" class="valueStyle" >
		                                     <rich:calendar value="#{planningReqIPBean.ipUrIpResult.expireDate}"
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
									        <td height="22"  align="left" colspan="3" class="valueStyle" >
												<h:inputTextarea id="remark" value="#{planningReqIPBean.ipUrIpResult.remarks}"  rows="3" cols="99" style="text-align:cente"/>	
											</td>
											<td>&nbsp;</td>														
	                                  </tr>  
	                                  <tr>
	                                    <td><img src="../images/blank.gif" width="10" height="5"></td>
	                                  </tr>                                                      
									</table>	
								  <rich:panel >	          
						   	 	  <h:panelGrid id="groupDetail" columns="20" styleClass="contentlabelform" cellpadding="0"  cellspacing="0" border="0">
									   	 	   <strong>IP Version :&nbsp;</strong>
							   	 	   				<rich:comboBox
														id="ipversion"  enableManualInput="false" 
														itemClass="contentform" itemSelectedClass="contentform"
														value="#{planningReqIPBean.ipUrIpResult.ipVersion}" width="50">
														<f:selectItem itemValue="4" />
													 </rich:comboBox>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									   	 	   <strong>IP Address :&nbsp;</strong>
											   <h:panelGroup id="rangIpGroup">
									   				<h:inputText id="stIp1" value="#{planningReqIPBean.ipUrIpResult.ipDigit1}"  
														size="1" style="text-align:center" maxlength="3" 
										   				onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stIp2',this,event,0,255,'190')"
											            onblur="this.value = isNumber(this);" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
			                                        <h:inputText id="stIp2" value="#{planningReqIPBean.ipUrIpResult.ipDigit2}" 
										 				size="1" style="text-align:center" maxlength="3"
										   				onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stIp3',this,event,0,255,'190')"
											            onblur="this.value = isNumber(this);" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
                                        			<h:inputText id="stIp3" value="#{planningReqIPBean.ipUrIpResult.ipDigit3}"  
										 				size="1" style="text-align:center" maxlength="3" 
										   				onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stIp4',this,event,0,255,'190')"
											            onblur="this.value = isNumber(this);" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
													<h:inputText id="stIp4" value="#{planningReqIPBean.ipUrIpResult.ipDigit4}"  
										 				size="1" style="text-align:center" maxlength="3" 
														onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:stSubmask',this,event,0,255,'191')"
											            onblur="this.value = isNumber(this);"/>
													<h:outputText style="font-weight: bolder;">
														&nbsp;/&nbsp;
													</h:outputText>
													<h:inputText id="stSubmask" value="#{planningReqIPBean.ipUrIpResult.mask}"
													 	size="1" style="text-align:center" maxlength="2"
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="enterSubmit('DetailForm:btnSearch',event)"
											            onblur="this.value = isNumber(this);"/>
												</h:panelGroup>	&nbsp;&nbsp;&nbsp;&nbsp;
										    <a4j:commandButton id="btnAssign" value="Add" styleClass="rich-button"
												action="#{planningReqIPAction.addIP}" reRender="errorMsg,ipDetailTable2" 
												oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),'chkboxs','');">
											</a4j:commandButton>&nbsp;&nbsp;
											<a4j:commandButton id="btnDelete" value="Delete" styleClass="rich-button"
									            action="#{planningReqIPAction.deleteIP}" reRender="errorMsg,ipDetailTable2"
									            oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),'chkboxs','');">
									        </a4j:commandButton>&nbsp;&nbsp;
											<a4j:commandButton id="btnSearch" value="Search IP" action="#{planningReqIPAction.popupSearchIP}" styleClass="rich-button" reRender="errorMsg,IPSUR002_SEARCHIP" rendered="true" >
														<rich:componentControl event="oncomplete" operation="#{errorMessages?'hide':'show'}" for="IPSUR002_SEARCHIP"/>
											</a4j:commandButton>
											<rich:hotKey key="return" handler="#{rich:element('btnAssign')}.click()" selector="#stIp1,#stIp2,#stIp3,#stIp4,#stIp5"/>	
										</h:panelGrid>
								<rich:dataTable width="100%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="assignmenIPtList" value="#{planningReqIPBean.assignmentIPList}" reRender="scrollIPDetailTable"  
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="rowIndex" 
									headerClass="tableHeader">
										<rich:column width="5%" >
											<f:facet name="header">
												<h:selectBooleanCheckbox id="checkAll" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty planningReqIPBean.assignmentIPList}"></h:selectBooleanCheckbox>
											</f:facet>
											<div align="center">
                                                <h:selectBooleanCheckbox id="chkboxs" value="#{planningReqIPBean.checked[rowIndex]}"  onclick="validateCheckbox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
											</div>
										</rich:column>
										
							            <rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						   <h:outputText value="#{rowIndex+1}" styleClass="contentform"/>
											</div>
										</rich:column>									
										<rich:column  filterValue="#{planningReqIPBean.filterIpsur002AddAssign.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(assignmenIPtList.level1Start,planningReqIPBean.filterIpsur002AddAssign.filterColumn1)}"   width="26%" >
											<f:facet name="header">											
													  <h:panelGroup>
		 	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002AddAssign.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						    <h:outputText value="#{assignmenIPtList.level1Start}" styleClass="contentform"/> - <h:outputText value="#{assignmenIPtList.level1End}" styleClass="contentform"/>
											</div>
										</rich:column>
										<rich:column width="12%" >
											<f:facet name="header">
												<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					    <h:outputText value="#{assignmenIPtList.effectiveDate}"  styleClass="contentform">
				          					       <f:convertDateTime pattern="dd/MM/yyyy"/>
				          					    </h:outputText>
											</div>
										</rich:column>
										<rich:column width="12%" >
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
		                                    <rich:columnGroup id="footerGroup" >
												<rich:column colspan="2">
													Total : <h:outputText  value="#{fn:length(planningReqIPBean.assignmentIPList)}" /> records
													<h:inputHidden id="SELECT_LIST_ID"></h:inputHidden>
													<h:inputHidden id="countId" value="#{planningReqIPBean.count}" />
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
									
									<a4j:region id="uploadregion">
													
									<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td valign="top" width="15%">
													<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
													     id="dlplanning" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateUR12Assign}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>											
											</td>
											<td>
							         		 	
					         		 		    <rich:fileUpload fileUploadListener="#{planningReqIPAction.importExcel}"  
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
									             			addControlLabel="Browse"
									             			listWidth="100%" >
									             			<a4j:support event="onfileuploadcomplete" 
									             			oncomplete="setCountId(#{fn:length(planningReqIPBean.assignmentIPList)}); #{rich:component('IPSUR001_IMPORT_RESULT')}.show();" reRender="IPSUR001_IMPORT_RESULT,ipDetailTable2,fileUpload,errorMsg" >
									             			
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
											<a4j:commandButton id="btnReject" value="Reject" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
											    <rich:componentControl for="confirmRejectURModal" operation="show" event="onclick" />
										    </a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnAssigns" value="Assign" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
												<rich:componentControl for="confirmAssignIPModal" operation="show" event="onclick"  />
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" status="#{rich:component('wait')}.hide();">
											    <rich:componentControl for="confirmCancelModal" operation="show" event="onclick"  />
											</a4j:commandButton>
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
		<jsp:include page="../home/progressforAssign.jsp" />
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
	<a4j:include viewId="../home/confirmCancel.jsp" />
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
						<a4j:commandButton value="Yes" action="#{planningReqIPAction.assignIP}" reRender="DetailForm,errorMsg"  styleClass="rich-button" style="width:50px;">
							<rich:componentControl for="confirmAssignIPModal" operation="hide" event="oncomplete" />
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
						<a4j:commandButton value="Yes"  action="#{planningReqIPAction.reject}" reRender="DetailForm,errorMsg" styleClass="rich-button" style="width:50px;">
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
<%-- 	<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/> --%>
	
	<jsp:include page="popup/IPSUR002_IMPORT_RESULT.jsp" />
	<a4j:include id="popupSearchIP" viewId="popup/IPSUR002_SEARCHIP.jsp" />
	<jsp:directive.include file="popup/IPSUR002_HISTORY.jsp"/>
	<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
</a4j:region>	
</f:view>
</body>
</html>
