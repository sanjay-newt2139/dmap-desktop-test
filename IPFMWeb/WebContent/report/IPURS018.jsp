<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>

<style type="text/css">
	.valignTop {vertical-align:top;}
	
</style>
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
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Total Summary IP By Planning Team Report</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
							    <rich:panel id="panelGrop" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
									<tr>
										<td width="150" align="right" ><rich:spacer height="0"/></td>
										<td width="230" ><rich:spacer height="0"/></td>
										<td width="130" align="right" ><rich:spacer height="0"/></td>
										<td ><rich:spacer height="0"/></td>
									</tr>									
									<tr>
											<td align="right" height="25" >
												<strong>
												<h:outputText value="IP Address" styleClass="label"></h:outputText>
												<h:outputText value=" :" styleClass="label"></h:outputText></strong>
												<rich:spacer width="5"></rich:spacer>
											</td>	
									        <td colspan="3">
												<h:panelGroup id="rangeIpGroup">
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
													
													&nbsp;<h:outputText value="/" style="font-weight: bolder;" />&nbsp;
													<h:inputText id="edIp1" value="" 
													 	size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<rich:spacer width="20" />												
											</h:panelGroup>																											
										</td>
										<td></td>	
										<td></td>													
                                  </tr>
                                  <tr>
                                   <td align="right" ><strong>Planning Team :</strong>&nbsp;</td>
                                   <td align="left" colspan="2">
                                       <rich:comboBox id="planningTeam" defaultLabel="" 
											enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
											 value="" width="150">
										</rich:comboBox>
                                   </td>
                                  </tr> 
                                  <tr>
                                   <td align="right"><strong>Effective Date :</strong>&nbsp;</td>
                                   <td align="left">    
                                         <rich:calendar value=""
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>
							       </td>
                                   <td align="right"><strong>Expire Date :</strong>&nbsp;</td>
                                   <td align="left" >
                                         <rich:calendar value=""
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>
                                   </td>
                                  </tr>    
                                  <tr>
                                   <td align="right"><strong>Assign Date from :</strong>&nbsp;</td>
                                   <td align="left">                                        
                                          <rich:calendar value=""
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>
							        </td>
                                   <td align="right"><strong>To :</strong>&nbsp;</td>
                                   <td align="left" >
                                            <rich:calendar value=""
							                        locale="en/US"
							                        popup="true"
							                        datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white"
							                        inputSize="15"
							                        direction="auto"/>
                                   </td>
                                  </tr>   
                                  <tr>
                                   <td align="right" valign="top" ><strong>Run As :</strong>&nbsp;</td>
                                   <td align="left" colspan="3" valign="top">
                                            <h:selectOneRadio id="onlinex" styleClass="contentform" >
                                   		       <f:selectItem itemLabel="Online" itemValue="O" />
                                   		       <f:selectItem itemLabel="Bath" itemValue="B" />
											</h:selectOneRadio>
								   </td>
								   </tr>
								   <tr>
                                    <td></td>
                                   	<td align="center" colspan="3">
										<rich:panel id="onnline" style="width:65%">
										         <table width="90%">
										          <tr>
										             <td align="left">									    	
											             <h:selectOneRadio id="immediatelyx"  value="">
														   <f:selectItem itemLabel="Immediately" itemValue="I" />
													     </h:selectOneRadio>										    
													</td>
										          </tr>
										          <tr>
										             <td align="left" >		
										               <h:panelGrid columns="7" id="groupRun">							    	
											             <h:selectOneRadio id="runx" styleClass="contentform" value="">
														   <f:selectItem itemLabel="Run at" itemValue="R" />
													     </h:selectOneRadio>&nbsp;
			                                            <rich:calendar value=""
									                        locale="en/US"
									                        popup="true"
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
									                        inputStyle="background-color:white"
									                        inputSize="15"
									                        direction="auto"/>&nbsp;
													     <strong>time :</strong>&nbsp;
													     <h:selectManyMenu id="smm" value="">
														  <f:selectItem id="si1" itemLabel="HH:MM" itemValue="11" />
														  <f:selectItem id="si2" itemLabel="YY:MM" itemValue="22" />
														</h:selectManyMenu>	
													    </h:panelGrid>									    
													</td>
										          </tr>
										        </table>
									      </rich:panel>
                                   </td>
                                  </tr>                          
								</table>
							 </rich:panel>
							</td>
						</tr>
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="205">&nbsp;</td>
									<td width="550" align="right" >
										<h:panelGroup id="buttonGroup">
									    	<a4j:commandButton id="btnSaveDraft" value="Run Report" styleClass="rich-button"
												action="#{userReqIPAction.save}"
												reRender="DetailForm" />&nbsp;
											<a4j:commandButton id="btnSendApprove" value="Reset" styleClass="rich-button"
												action="#{userReqIPAction.sendApprove}" >
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
	
</f:view>
</body>
</html>
