<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>		

</head>
<body style="overflow:hidden;">
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
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
							<td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Manage IP-Level 3</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
					    <tr bgcolor="#BFBFBF">
					         <td>
								  <table border="0" cellpadding="0" cellspacing="0" align="left" >
									<tr>
										   <h:panelGroup id="tabGroup">  
										     <td>
										   		<a4j:commandButton id="btnOwnerList" value="Owner List IP" 
													image="../images/tab_owner_ip_list_notactive.png" style="height: 25; width: 87" 
													action="#{manageDataIPAction.init}">
													<a4j:actionparam name="programIDParam" value="IPURS003_01"/>
				          						</a4j:commandButton>
				          						<a4j:commandButton id="btnIPDetail" value="IP Detail" 
													image="../images/tab_ip_detail_active.png" style="height: 25; width: 61" 
													action="#{manageDataIPAction.initIPDetailAdd}">
				          						</a4j:commandButton>
				          					  </td>
										   </h:panelGroup>
									</tr>
									<tr>
										<td height="2" colspan="8" align="center" valign="bottom"></td>
									</tr>
							  	</table>
							</td>  
					    </tr>
						<tr>
							<td>
							   <rich:panel id="panelGrop">
								   	<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right" ><strong><h:outputText value="IP"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										  	 <td height="22" colspan="3" align="left" >
												<h:panelGroup id="rangIpGroup">
									   				<h:inputText id="stIp1" value="#{manageDataIPBean.stIp1}"  
														size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" 
														disabled="#{manageDataIPBean.disabledTextIpBox}"/>
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
			                                        <h:inputText id="stIp2" value="#{manageDataIPBean.stIp2}" 
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" 
														disabled="#{manageDataIPBean.disabledTextIpBox}"/>
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
                                        			<h:inputText id="stIp3" value="#{manageDataIPBean.stIp3}"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" 
														disabled="#{manageDataIPBean.disabledTextIpBox}"/>
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
													<h:inputText id="stIp4" value="#{manageDataIPBean.stIp4}"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" 
														disabled="#{manageDataIPBean.disabledTextIpBox}"/>
													<h:outputText style="font-weight: bolder;" rendered="#{manageDataIPBean.ipVersion == '6'}">
														&nbsp;.&nbsp;
													</h:outputText>
													<h:inputText id="stIp5" value="#{manageDataIPBean.stIp5}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													 	size="1" style="text-align:center" maxlength="3" 
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" 
														disabled="#{manageDataIPBean.disabledTextIpBox}"/>
													<h:outputText style="font-weight: bolder;" rendered="#{manageDataIPBean.ipVersion == '6'}" >
														&nbsp;.&nbsp;
													</h:outputText>
													<h:inputText id="stIp6" value="#{manageDataIPBean.stIp6}" rendered="#{manageDataIPBean.ipVersion == '6'}"
													   size="1" style="text-align:center" maxlength="3" 
													   onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													   onchange="numberformat.formatIntegerObject(this)"
													   disabled="#{manageDataIPBean.disabledTextIpBox}"/>						   
												</h:panelGroup>	
												    &nbsp;
												   <a4j:commandButton id="btnQuery" value="Query" styleClass="rich-button"
													action="#{manageDataIPAction.searchIPDetail}"
													rendered="#{manageDataIPBean.displayForQueryButton}"
													reRender="DetailForm,errorMsg" />																
										   </td>		
									 </tr>
									 <tr>
									    <td width="15%"></td>
									    <td colspan="4">
									        <h:message for="stIp1" style="color:red"/>
									    </td>
									</tr>
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="IP Status"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
	                                  	 <td width="37%">
                                           <rich:comboBox id="ipStatus" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.ipStatusComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.ipStatusList}"/>
												<f:selectItems value="#{manageDataIPBean.ipStatusList}"/>
											</rich:comboBox>								
                                  	   </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="Company :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td width="38%">
                                            <rich:comboBox id="company" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.companyComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.companyList}"/>
												<f:selectItems value="#{manageDataIPBean.companyList}"/>
											</rich:comboBox>	
                                  	   </td>	                        
                                     </tr>
                                     <tr>
									    <td width="15%"></td>
									    <td colspan="4">
									        <h:message for="ipStatus" style="color:red"/>
									    </td>
									</tr>	
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Site/Location :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
											<rich:comboBox id="locationName" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.locationComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
												<f:selectItems value="#{manageDataIPBean.locatList}"/>
											</rich:comboBox>	                                  	 
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="Priority :"></h:outputText></strong>&nbsp;</td>
                                        <td>
											<rich:comboBox id="priority" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.piorityComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.priorityList}"/>
												<f:selectItems value="#{manageDataIPBean.priorityList}"/>
											</rich:comboBox>	                                  	 
	                                  	 </td>	                        
                                     </tr>	
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Install Type :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
											<rich:comboBox id="installType" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.installComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.installTypeList}"/>
												<f:selectItems value="#{manageDataIPBean.installTypeList}"/>
											</rich:comboBox>											                               	 
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="MASK :"></h:outputText></strong>&nbsp;</td>
                                         <td>
		                                        <h:inputText id="mask" value="#{manageDataIPBean.ipDetail.submask}"  
												 size="40"	 style="text-align:cente" disabled="#{manageDataIPBean.disabledTextMask}">
												</h:inputText>
	                                  	 </td>	                        
                                     </tr>	                                                                           								 
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
										    <rich:comboBox id="networkZone" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.networkZoneComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.zoneList}"/>
												<f:selectItems value="#{manageDataIPBean.zoneList}"/>
											</rich:comboBox>											                                    	 
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="Network :"></h:outputText></strong>&nbsp;</td>
                                         <td>
		                                        <h:inputText id="network" value="#{manageDataIPBean.ipDetail.network}" 
		                                          size="40" style="text-align:cente"  disabled="#{manageDataIPBean.disabledTextNetwork}">
		                                        </h:inputText>
	                                  	 </td>	                        
                                     </tr>
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Gateway :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
		                                        <h:inputText id="gateway" value="#{manageDataIPBean.ipDetail.gateway}" 
		                                           size="40"	 style="text-align:cente"  disabled="#{manageDataIPBean.disabledTextGateway}">
												</h:inputText>
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="MAC Address :"></h:outputText></strong>&nbsp;</td>
                                         <td>
		                                           <h:inputText id="macAddress" value="#{manageDataIPBean.ipDetail.macAddress}" size="40"	 style="text-align:cente" 
		                                             disabled="#{manageDataIPBean.disabledTextMacAdress}" >
							               </h:inputText>
	                                  	 </td>	                        
                                     </tr>     
                                                                     
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Host Name"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
	                                  	 <td>
		                                        <h:inputText id="hostName" value="#{manageDataIPBean.ipDetail.hostName}" size="40"	 style="text-align:cente"
		                                         disabled="#{manageDataIPBean.disabledTextHostName}">
												</h:inputText>
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="System Name"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
                                         <td>
		                                        <h:inputText id="systemName" value="#{manageDataIPBean.ipDetail.systemName}" size="40"	 style="text-align:cente"
		                                         disabled="#{manageDataIPBean.disabledTextSystemName}">
												</h:inputText>
	                                  	 </td>	                        
                                     </tr>
                                     <tr>
									    <td width="15%"></td>
									    <td colspan="2">
									       <h:message for="hostName" style="color:red"/>
									    </td>
									    <td>
									       <h:message for="systemName" style="color:red"/>
									    </td>
									 </tr>	                                     
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
										    <rich:comboBox id="networkType" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.networkTypeComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.nwTypeList}"/>
												<f:selectItems value="#{manageDataIPBean.nwTypeList}"/>
											</rich:comboBox>												                                  	 
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="Request From Team :"></h:outputText></strong>&nbsp;</td>
                                         <td>
										    <rich:comboBox id="requestFromTeam" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.requestFromTeamComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.t2TeamList}"/>
												<f:selectItems value="#{manageDataIPBean.t2TeamList}"/>
											</rich:comboBox>												                                  	 
	                                  	 </td>	                        
                                     </tr>                                           
	                                 <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="UR Refer :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
		                                        <h:inputText id="urRefer" value="#{manageDataIPBean.ipDetail.urRefer}" 
		                                        size="40" style="text-align:cente" disabled="#{manageDataIPBean.disabledTextUrRefer}">
												</h:inputText>
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	   <h:outputText value="VIP IP :"></h:outputText></strong>&nbsp;</td>
                                         <td>
												<rich:comboBox id="vipIp" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.ipDetail.vip}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.t2TeamList}"/>
												<f:selectItems value="#{manageDataIPBean.t2TeamList}"/>
											</rich:comboBox>
	                                  	 </td>	                        
                                     </tr> 
		                              <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="VLAN ID :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
		                                        <h:inputText id="vlanID" value="#{manageDataIPBean.ipDetail.vlanId}" 
		                                         size="40"	 style="text-align:cente"  disabled="#{manageDataIPBean.disabledTextVlanId}">
												</h:inputText>
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right"><strong>
                                  	    <h:outputText value="DNS NAME :"></h:outputText></strong>&nbsp;</td>
                                         <td>
		                                        <h:inputText id="dnsName" value="#{manageDataIPBean.ipDetail.dnsName}" 
		                                          size="40"	 style="text-align:cente"  disabled="#{manageDataIPBean.disabledTextDnsName}">
												</h:inputText>
	                                  	 </td>	                        
                                     </tr>
                                     <tr>
	                                     <td width="15%" height="25" align="right" valign="top" ><strong><h:outputText value="Tier1 Remark :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
		                                        <h:inputTextarea id="tier1Remark" value="#{manageDataIPBean.ipDetail.t1Remark}" 
		                                        rows="5" cols="41"	 style="text-align:cente;" disabled="#{manageDataIPBean.disabledTextTire1Remark}">
												</h:inputTextarea>
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right" valign="top" ><strong>
                                  	   <h:outputText value="Tier2 Remark :"></h:outputText></strong>&nbsp;</td>
                                         <td>
		                                        <h:inputTextarea id="tier2Remark" value="#{manageDataIPBean.ipDetail.t2Remark}" 
		                                        rows="5" cols="41"	 style="text-align:cente;" disabled="#{manageDataIPBean.disabledTextTire2Remark}" >
												</h:inputTextarea>
	                                  	 </td>	                        
                                     </tr>  
                                     <tr><td height="5" colspan="4"></td></tr>
                                     <tr>
	                                     <td width="15%" height="25" align="right" valign="top"><strong><h:outputText value="Tier3 Remark :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td>
		                                        <h:inputTextarea id="tier3Remark" value="#{manageDataIPBean.ipDetail.t3Remark}" 
		                                        rows="5"  cols="41"	 style="text-align:cente;" disabled="#{manageDataIPBean.disabledTextTire3Remark}">
												</h:inputTextarea>
	                                  	 </td>	      
	                                  	 <td width="15%" height="25" align="right" valign="top"><strong>
                                  	   <h:outputText value="IP Type :"></h:outputText></strong>&nbsp;</td>
                                        <td valign="top" >	
										       <rich:comboBox id="ipType" defaultLabel="Please select value" 
												 enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												 value="#{manageDataIPBean.ipTypeComboItem}" width="250">
												 <f:attribute name="selectItems" value="#{manageDataIPBean.ipTypeList}"/>
												 <f:selectItems value="#{manageDataIPBean.ipTypeList}"/>
											  </rich:comboBox>													                                  	 
	                                  	 </td>	                        
                                     </tr> 
                                     <tr><td height="5" colspan="4"></td></tr>
                                     <tr>
	                                     <td width="15%" height="25" align="right"><strong><h:outputText value="Floor :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td colspan="3">
	                                          <h:inputText id="floor" value="#{manageDataIPBean.ipDetail.floor}" size="40"	 style="text-align:cente"
	                                           disabled="#{manageDataIPBean.disabledTextFloor}">
											  </h:inputText>
	                                  	 </td>	                              
                                     </tr>
                                     <tr>      
	                                  	 <td width="15%" height="25" align="right"><strong><h:outputText value="Project ID :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td colspan="3">
			                                 <h:inputText id="projectID" value="#{manageDataIPBean.ipDetail.projectId}" size="15"	 style="text-align:cente"
			                                  disabled="#{manageDataIPBean.disabledTextProjectID}">
											 </h:inputText>
											 &nbsp;
											 <img src="../images/p_zoom.gif" style=" width : 16px; height : 16px;">&nbsp;
											 <h:inputText id="projectName" value="#{manageDataIPBean.ipDetail.projectName}" 
													 size="40"	 style="text-align:cente" disabled="#{manageDataIPBean.disabledTextProjectName}" >
											 </h:inputText>
	                                  	 </td>	                       
                                     </tr>                                                                                
                                                                           
                                     <tr>      
	                                  	 <td width="15%" height="25" align="right"><strong><h:outputText value="Effective Date From :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td colspan="3">
   							                 <rich:calendar value="#{manageDataIPBean.ipDetail.effDate}"
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px" 
							                        inputStyle="background-color:white" disabled="#{manageDataIPBean.disabledTextEffectiveDate}" 
							                        inputSize="15"/>&nbsp;
							                &nbsp;<strong><h:outputText value="Expire Date"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
							                 <rich:calendar id="expire" value="#{manageDataIPBean.ipDetail.expDate}"
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
							                        inputStyle="background-color:white"
							                        direction="auto"
							                        disabled="#{manageDataIPBean.disabledTextExpireDate}" 
							                        inputSize="15"/>
	                                  	 </td>
	  	                                  	 
                                     </tr> 
                                     <tr>
									    <td width="15%"></td>
									    <td colspan="4">
									        <h:message for="expire" style="color:red"/>
									    </td>
									 </tr>
                                     <tr>      	 
	                                  	 <td width="15%" height="25" align="right"><strong><h:outputText value="System Owner Team"></h:outputText>&nbsp;:&nbsp;</strong></td>
	                                  	 <td colspan="3">
		                                        <h:inputText id="systemOwnerTeamId" value="#{manageDataIPBean.ipDetail.systemOwnerId}" size="15"	 style="text-align:cente"
		                                         disabled="#{manageDataIPBean.disabledTextSystemOwnerID}">
												</h:inputText>&nbsp;
												<img src="../images/p_zoom.gif" style=" width : 16px; height : 16px;">&nbsp;
												<h:inputText id="systemOwnerTeamName" value="#{manageDataIPBean.ipDetail.systemOwnerName}" 
                                                  disabled="#{manageDataIPBean.disabledTextSystemOwnerName}" size="40"	 style="text-align:cente">
										        </h:inputText>
	                                  	 </td>	  	                                  	 
                                     </tr> 
                                     <tr>      
	                                  	 <td width="15%" height="25" align="right"><strong><h:outputText value="System Owner ID"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
	                                  	 <td colspan="3">
		                                        <h:inputText id="systemOwnerID" value="#{manageDataIPBean.ipDetail.systemOwnerId}" size="15"	 style="text-align:cente"
		                                         disabled="#{manageDataIPBean.disabledTextSystemOwnerID}">
												</h:inputText>&nbsp;
												<img src="../images/p_zoom.gif" style=" width : 16px; height : 16px;">&nbsp;
												<h:inputText id="systemOwnerName" value="#{manageDataIPBean.ipDetail.systemOwnerName}" 
                                                  disabled="#{manageDataIPBean.disabledTextSystemOwnerName}" size="40"	 style="text-align:cente">
										        </h:inputText>
												 &nbsp;
												<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" action="#{manageDataIPAction.search}" style=" width : 50px; height : 25px;"
												 disabled="#{manageDataIPBean.disabledTextSystemOwnerID}" reRender="groupSearchResult" />
	                                  	 </td>	 
                                     </tr>
                                     <tr><td height="5" colspan="4"></td></tr>
                                     <tr>
                                      <td></td>
                                      <td>	
                                      		 <h:inputTextarea id="xxx" value="#{manageDataIPBean.ipDetail.serviceId}"  
		                                        rows="5" cols="68"  style="text-align:cente;">
											</h:inputTextarea>&nbsp;	
											<a4j:commandButton id="btnDelete" value="Delete" styleClass="rich-button" action="#{manageDataIPAction.search}" style=" width : 50px;"
												 disabled="#{manageDataIPBean.disabledTextSystemOwnerID}" reRender="groupSearchResult" />			
                                      </td>
                                     </tr>
                                      <tr><td height="5" colspan="4"></td></tr>
                                     <tr>
									    <td width="15%"></td>
									    <td colspan="4">
									        <h:message for="systemOwnerID" style="color:red"/>
									    </td>
									 </tr>   
                                     <tr>      
	                                  	 <td width="12%" height="25" align="right" valign="top"><strong><h:outputText value="Service Detail :"></h:outputText></strong>&nbsp;</td>
	                                  	 <td colspan="3">
		                                        <h:inputTextarea id="serviceDetail" value="#{manageDataIPBean.ipDetail.serviceId}"  
		                                        rows="5" cols="68"  style="text-align:cente;" disabled="#{manageDataIPBean.disabledTextServiceDetail}">
												</h:inputTextarea>
	                                  	 </td>	  	                                  	 
                                     </tr>                                      
                              </table>
									<br/>	
						   </rich:panel>
					
								<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td width="7%" height="25" align="right" >								    
													<h:panelGrid id="groupActionButton" columns="2" styleClass="contentlabelform">
														<a4j:commandButton id="btnSubmit" value="Submit" styleClass="rich-button"
															action="#{manageDataIPAction.updateIPDetail}"
															rendered="#{manageDataIPBean.displayForCreate}" 
															reRender="DetailForm,errorMsg"/>			
														<a4j:commandButton id="btnEdit" value="Update" styleClass="rich-button"
															action="#{manageDataIPAction.updateIPDetail}"
															rendered="#{manageDataIPBean.displayForEdit}"
															reRender="DetailForm,errorMsg" />																								
														<a4j:commandButton id="btnClose" value="Close" styleClass="rich-button"
															action="#{manageDataIPAction.init}"
															reRender="groupSearchResult">
															<a4j:actionparam name="programIDParam" value="IPURS003_01"/>	
														</a4j:commandButton>
														 												
													</h:panelGrid>	
									          </td>
								         </tr>
								</table>			
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
						<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
							<h:outputText value="Are you sure you want to delete this parameter?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true"
								action="#{manageDataIPAction.delete}" reRender="groupSearchResult" >
								<rich:componentControl for="confirmDialog" operation="hide" event="onclick"  />
							</a4j:commandButton>												
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="confirmDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
		</a4j:form>
	</rich:modalPanel>
	
</f:view>
</body>
</html>
