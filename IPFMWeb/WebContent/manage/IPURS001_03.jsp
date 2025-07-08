<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>Manage IP-Level 3 : IP Information</title>
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
									class="style9">IP Information</span></strong></td>
						  </tr>
						  <tr>
						  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
						  </tr>
							<tr>
								<td>
								   <rich:panel id="panelGrop">
									   	<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
											<tr>
												<td width="210" align="right" ><rich:spacer height="0"/></td>
												<td width="230" ><rich:spacer height="0"/></td>
												<td width="178" align="right" ><rich:spacer height="0"/></td>
												<td ><rich:spacer height="0"/></td>
											</tr>									
											<tr>
												<td align="right" height="25" >
													<strong><h:outputText value="IP Address :"></h:outputText></strong>&nbsp;
												</td>	
										        <td>
													<h:outputText id="ipAddress" value="#{manageDataIPBean.ipAddress}" />
												</td>
												<td align="right" height="25" ><strong><h:outputText value="IP Status :"></h:outputText></strong>&nbsp;</td>
		                                  	 	<td>
		                                  	 		<h:outputText value="#{manageDataIPBean.ipStatusName}" />
		                                  	 	</td>												
		                                  </tr>
		                                  <tr>
		                                  	  <td align="right" height="25" ><strong><h:outputText value="Effective Date :"></h:outputText></strong>&nbsp;</td>
											  <td>
											  	<h:outputText value="#{manageDataIPBean.effDate}" />                                        
											  </td>	
		                                  	  <td align="right" height="25" ><strong><h:outputText value="Expire Date :"></h:outputText></strong>&nbsp;</td>
											  <td>
											  	<h:outputText value="#{manageDataIPBean.expDate}" />
											  </td>	 
		                                </tr> 
									 	<tr>
	                                     	<td align="right" height="25" ><strong><h:outputText value="Host Name :"></h:outputText></strong>&nbsp;</td>
											<td ><h:inputText id="hostName" value="#{manageDataIPBean.hostName}" size="40"	 
	                                            style="text-align:center" > </h:inputText>
	                                        </td>           
	                                		<td align="right" height="25" ><strong><h:outputText value="System Name :"></h:outputText></strong>&nbsp;</td>
	                                      	<td ><h:inputText id="systemName" value="#{manageDataIPBean.systemName}" size="30"	 
	                                            style="text-align:center" > </h:inputText>
	                                        </td> 	                                  		
	                                  </tr>
	                                  <tr>
	                                      <td align="right"><strong><h:outputText value="SystemOwner Id :"></h:outputText></strong>&nbsp;</td>
										  <td>
											 <rich:comboBox id="sysOwnerName" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.locationComboItem}" width="200">
												<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
												<f:selectItems value="#{manageDataIPBean.locatList}"/>
											</rich:comboBox>
										  </td>	
										  <td align="right"><strong><h:outputText value="System Owner Team :"></h:outputText></strong>&nbsp;</td>
										  <td>
											 <rich:comboBox id="sysOwnerTeamName" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.locationComboItem}" width="200">
												<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
												<f:selectItems value="#{manageDataIPBean.locatList}"/>
											</rich:comboBox>
										  </td>	
	                                  </tr>
	                                  <tr>
	                                 	      
	                                  	  <td align="right"><strong><h:outputText value="Planning Team :"></h:outputText></strong>&nbsp;</td>
										  <td>
											 <rich:comboBox id="planningTeamName" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.locationComboItem}" width="200">
												<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
												<f:selectItems value="#{manageDataIPBean.locatList}"/>
											</rich:comboBox>
										  </td>
	                                  	  <td align="right"><strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;</td>
										  <td>
										  	<h:inputText id="networkIP" value="#{manageDataIPBean.network}" size="30" style="text-align:center"> </h:inputText>
										  </td>
	                                  </tr>
	                                  
	                                  <tr>
	                                  	  <td align="right" height="25" ><strong><h:outputText value="UR Refer :"></h:outputText></strong>&nbsp;</td>
										  <td>
	                                        <h:outputText id="urRefer" value="#{manageDataIPBean.urRefer}" />
										   </td>
	                                  	  <td align="right"><strong><h:outputText value="Gateway :"></h:outputText></strong>&nbsp;</td>
										  <td>
											<h:inputText id="networkIP" value="#{manageDataIPBean.gateway}" size="30" style="text-align:center"> </h:inputText>
										   </td>	
	                                  </tr>
	                                  <tr>
	                                  	  <td align="right" height="25" ><strong><h:outputText value="IP Type :"></h:outputText></strong>&nbsp;</td>
										  <td>
										    <rich:comboBox id="ipType" defaultLabel="Please select value"  enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.ipTypeComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.ipTypeList}"/>
												<f:selectItems value="#{manageDataIPBean.ipTypeList}"/>                                        
	                                        </rich:comboBox>
										  </td>	
										  <td align="right"><strong><h:outputText value="Mac Address :"></h:outputText></strong>&nbsp;</td>
										  <td>
											<h:inputText id="MacAddress" value="#{manageDataIPBean.macAddress}" size="30" > </h:inputText>
									   	  </td>
	                                  </tr> 
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<rich:comboBox id="networkType" defaultLabel="Please select value"  enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.networkTypeComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.nwTypeList}"/>
												<f:selectItems value="#{manageDataIPBean.nwTypeList}"/>                                        
	                                        </rich:comboBox>
										 </td>
										 <td align="right" height="25" ><strong><h:outputText value="Network Type :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:inputText id="mask" value="#{manageDataIPBean.submask}" size="30" > </h:inputText>
										 </td>
	                                  </tr>                        
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="Install Type :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<rich:comboBox id="installType" defaultLabel="Please select value"  enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.installComboItem}" width="250">
												<f:attribute name="selectItems" value="#{manageDataIPBean.installTypeList}"/>
												<f:selectItems value="#{manageDataIPBean.installTypeList}"/>                                        
	                                        </rich:comboBox>
										 </td>
										 <td align="right" height="25" ><strong><h:outputText value="VLAN ID :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:inputText id="vlanId" value="#{manageDataIPBean.vlanId}" size="30" > </h:inputText>
										 </td>
	                                  </tr> 
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="VIP IP :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:outputText id="vip" value="#{manageDataIPBean.vip}" />
										 </td>
										 <td align="right" height="25" ><strong><h:outputText value="DNS Name :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:inputText id="dnsName" value="#{manageDataIPBean.dnsName}" size="30" ></h:inputText>
										 </td>
	                                  </tr> 
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="Site/Location :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<rich:comboBox id="locationName" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.locationComboItem}" width="150">
												<f:attribute name="selectItems" value="#{manageDataIPBean.locatList}"/>
												<f:selectItems value="#{manageDataIPBean.locatList}"/>
											</rich:comboBox>
										 </td>
										 <td align="right" height="25" ><strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<rich:comboBox id="networkZone" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.networkZoneComboItem}" width="150">
												<f:attribute name="selectItems" value="#{manageDataIPBean.zoneList}"/>
												<f:selectItems value="#{manageDataIPBean.zoneList}"/>
											</rich:comboBox>
										 </td>
	                                  </tr> 
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="Floor :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:inputText id="floor" value="#{manageDataIPBean.floor}" size="15" style="text-align:center"> </h:inputText>
										 </td>
										 <td align="right" height="25" ><strong><h:outputText value="Network Zone :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:inputText id="company" value="#{manageDataIPBean.companyName}" />
										 </td>
	                                  </tr> 
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="Project Ip :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
										  	<rich:comboBox id="projectIp" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.projectIdComboItem}" width="150">
												<f:attribute name="selectItems" value="#{manageDataIPBean.projectIdList}"/>
												<f:selectItems value="#{manageDataIPBean.projectIdList}"/>                                        
	                                        </rich:comboBox>
											<rich:spacer width="20"></rich:spacer>
	                                        <h:inputText id="projectManages1" value="#{manageDataIPBean.projectName}" size="30" ></h:inputText>
	                                        </h:panelGrid>
										 </td>
										 <td align="right" height="25" rowspan="2"><strong><h:outputText value="Comment :"></h:outputText></strong>&nbsp;</td>
										 <td rowspan="2">
										  	<h:inputText id="comment" value="#{manageDataIPBean.companyName}" />
										 </td>
	                                  </tr>
	                                  <tr>
	                                     <td align="right" height="25" ><strong><h:outputText value="Project Ip :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
										  	<rich:comboBox id="projectManages" defaultLabel="Please select value" 
												enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
												value="#{manageDataIPBean.projectManagerComboItem}" width="150">
												<f:attribute name="selectItems" value="#{manageDataIPBean.projectManagerList}"/>
												<f:selectItems value="#{manageDataIPBean.projectManagerList}"/>                                        
	                                        </rich:comboBox>
											<rich:spacer width="20"></rich:spacer>
	                                        <h:inputText id="projectManages1" value="#{manageDataIPBean.projectManager}" size="30" ></h:inputText>
	                                        </h:panelGrid>
										 </td>
	                                  </tr>
	                                  <tr>
	                                     <td align="right" height="25" valign="top"><strong><h:outputText value="Service Detail :"></h:outputText></strong>&nbsp;</td>
										 <td>
										  	 <h:inputTextarea id="tier1Remark" value="#{manageDataIPBean.ipDetail.t1Remark}" 
			                                        rows="5" cols="41" disabled="#{manageDataIPBean.disabledTextTire1Remark}">
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
												<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"
													action="#{manageDataIPAction.updateIPDetail}"
													rendered="#{manageDataIPBean.displayForCreate}" 
													reRender="DetailForm,errorMsg"/>			
	
												<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
													action="#{manageDataIPAction.init}"
													reRender="groupSearchResult">
													<a4j:actionparam name="programIDParam" value="IPURS001_01"/>	
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
