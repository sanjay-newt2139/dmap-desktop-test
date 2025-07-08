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
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>

<style type="text/css">
	.valignTop {vertical-align:top;}
	.textAlignRight {text-align:right;}
	.rich-filter-input {width:80px;}
}
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
					<td width="100%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">WorkFlow Management</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop">
									<h:panelGroup style="width:100%;">
										<rich:tabPanel id="tab1"  >
									        <rich:tab label="Planning Request IP" action="#{wfAction.init}" >		
									        	<h:panelGroup style="100%">	
										      		<h:panelGrid columns="1" width="100%" cellpadding="0" cellspacing="0">
										      			<h:graphicImage value="../images/Pic1-PlanReq.png" width="800px"/>
										      		</h:panelGrid>	
										            <table width="100%" border="0" class="thtext_detail">
					                                  	<tr class="inputRow">
															<td class="labelStyle" valign="top" >
																<h:outputText value="SMS :&nbsp;" escape="false"/>
															</td>	
													        <td>
													            <table>
													             <tr>
													               <td>
														               <h:selectOneRadio value="#{wfBean.ipWfConfig.smsStatus}" layout="pageDirection">
																		<f:selectItem itemValue="0" itemLabel="No"/>
																		<f:selectItem itemValue="1" itemLabel="Yes"/>
																	   </h:selectOneRadio>
													               </td>
													               <td rowspan="2" valign="bottom">
													                  <h:inputText value="#{wfBean.ipWfConfig.smsMobileNoList}" size="30" style="vertical-align:bottom;width : 173px; height : 20px;"></h:inputText>								
													               </td>
													             </tr>
													            </table>
															</td>							
					                                  	</tr>
					                            	</table>
					                            	<h:panelGrid columns="1" width="100%" cellpadding="0" cellspacing="0">
				                                  		<h:panelGroup style="width:100%">
															<rich:dataTable id="tab1DataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
																	var="detail" value="#{wfBean.ipWfConfigPlanningList}"
																	  
																	 
																	rowClasses="odd,even" 
																	styleClass="contentform" rowKeyVar="index" 
																	headerClass="tableHeader">
																
																<rich:column  filterValue="#{wfBean.filter003.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.id.nodeId,wfBean.filter003.filterColumn4)}"   style="width:60px; text-align:center;">
																	<f:facet name="header">
																		    <h:panelGroup>
																				<h:outputText value="Node" styleClass="contentform tableHeaderText"></h:outputText>
																				<h:inputText value="#{wfBean.filter003.filterColumn4}" style="width: 50px;">
																					 <a4j:support event="onblur" reRender="tab1DataTable" />
																				</h:inputText>
																			 </h:panelGroup>
																	</f:facet>
																	<h:outputText value="#{detail.id.nodeId}" style="width:100%"></h:outputText>																	
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.nodeDesc,wfBean.filter003.filterColumn5)}"  >
																	<f:facet name="header">																		
																	 <h:panelGroup>
																				<h:outputText value="Node Description" styleClass="contentform tableHeaderText"></h:outputText>
																				<h:inputText value="#{wfBean.filter003.filterColumn5}" style="width: 50px;">
																			 <a4j:support event="onblur" reRender="tab1DataTable" />
																		 </h:inputText>
																	 </h:panelGroup>
																	</f:facet>
																	<h:outputText value="#{detail.nodeDesc}"  style="width:100%"></h:outputText>			
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.ola,wfBean.filter003.filterColumn6)}"   style="width:60px; text-align:center;">
																	<f:facet name="header">
																	 <h:panelGroup>
																				<h:outputText value="OLA" styleClass="contentform tableHeaderText"></h:outputText>
				 <h:inputText value="#{wfBean.filter003.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab1DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:inputText value="#{detail.ola}" size="5" style="text-align:right;" styleClass="contentform" onchange="calTotalPalning();" 
																	 onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
																     onblur="this.value = isNumber(this);#{rich:component('wait')}.hide()" ></h:inputText>
																	      <a4j:jsFunction name="calTotalPalning" action="#{wfAction.onkeyOlaPalning}" reRender="tab1DataTable"></a4j:jsFunction>
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(detail.emailStatus,wfBean.filter003.filterColumn7)}"   style="width:100px; text-align:center;" >
																	<f:facet name="header">																		
																	 <h:panelGroup>
																	<h:outputText value="Send Mail" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
				 <h:inputText value="#{wfBean.filter003.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab1DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:selectOneRadio value="#{detail.emailStatus}" layout="lineDirection" style="margin:0; padding:0;">
																		<f:selectItem itemValue="N" itemLabel="No"/>
																		<f:selectItem itemValue="Y" itemLabel="Yes"/>
																	</h:selectOneRadio> 
																</rich:column>	
																
																<f:facet name="footer">
																	<rich:columnGroup>
																		<rich:column colspan="2" style="text-align:right;">
																		    <h:outputText value="SLA ="></h:outputText>
																		</rich:column>
																		<rich:column style="text-align:center;" >
                                                                             <h:outputText value="#{wfBean.total}" ></h:outputText>
																		</rich:column>
																		<rich:column >
																		     <h:outputText value="Days"></h:outputText>
																		</rich:column>
																	</rich:columnGroup>										
																</f:facet>	
																					
															</rich:dataTable>
														</h:panelGroup>
														<h:panelGroup>
															<a4j:commandButton value="Save" styleClass="rich-button" action="#{wfAction.save}" reRender="errorMsg,tab1DataTable" />
					                                        <rich:spacer width="10"></rich:spacer>
				                                  			<a4j:commandButton value="Cancel" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
														</h:panelGroup>
				                                  	</h:panelGrid>
										        </h:panelGroup>	
									        </rich:tab>	
									        <rich:tab label="User Request IP" style="width:100%;" action="#{wfAction.tabUserRquest}">
										        <h:panelGroup style="width:100%;">
										        	<h:panelGrid columns="1" width="100%" cellpadding="0" cellspacing="0">
										      			<h:graphicImage value="../images/Pic2-UserReq.png"  width="800px"/>
										      		</h:panelGrid>	
										            <table width="100%" border="0" class="thtext_detail">
					                                  	<tr class="inputRow">
															<td class="labelStyle" valign="top" >
																<h:outputText value="SMS :&nbsp;" escape="false"/>
															</td>	
													        <td>
													            <table>
													             <tr>
													               <td>
														               <h:selectOneRadio value="#{wfBean.ipWfConfig.smsStatus}" layout="pageDirection">
																		<f:selectItem itemValue="0" itemLabel="No"/>
																		<f:selectItem itemValue="1" itemLabel="Yes"/>
																	   </h:selectOneRadio>
													               </td>
													               <td rowspan="2" valign="bottom">
													                  <h:inputText value="#{wfBean.ipWfConfig.smsMobileNoList}" size="30" style="vertical-align:bottom;width : 173px; height : 20px;"></h:inputText>								
													               </td>
													             </tr>
													            </table>									
															</td>							
					                                  	</tr>
					                            	</table>
					                            	<h:panelGrid columns="1" width="100%" cellpadding="0" cellspacing="0">
				                                  		<h:panelGroup style="width:100%">
															<rich:dataTable id="tab2DataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
																	var="detail" value="#{wfBean.ipWfConfigUserRequestList}"
																	  
																	 
																	rowClasses="odd,even" 
																	styleClass="contentform" rowKeyVar="index" 
																	headerClass="tableHeader">
																
																<rich:column  filterValue="#{wfBean.filter003.filterColumn8}"  filterExpression="#{fn:containsIgnoreCase(detail.id.nodeId,wfBean.filter003.filterColumn8)}"  style="width:60px; text-align:center;">
																	<f:facet name="header">
																	  <h:panelGroup>
																		<h:outputText value="Node" styleClass="contentform tableHeaderText"></h:outputText>
																		 <h:inputText value="#{wfBean.filter003.filterColumn8}" style="width: 50px;">
																			 <a4j:support event="onblur" reRender="tab2DataTable" />
																		 </h:inputText>
																	 </h:panelGroup>
																	</f:facet>
																	<h:outputText value="#{detail.id.nodeId}" style="width:100%"></h:outputText>																	</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn9}"  filterExpression="#{fn:containsIgnoreCase(detail.nodeDesc,wfBean.filter003.filterColumn9)}"   >
																	<f:facet name="header">
																		
																		    <h:panelGroup>
		<h:outputText value="Node Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfBean.filter003.filterColumn9}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab2DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:outputText value="#{detail.nodeDesc}"  style="width:100%"></h:outputText>			
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn10}"  filterExpression="#{fn:containsIgnoreCase(detail.ola,wfBean.filter003.filterColumn10)}"   style="width:60px; text-align:center;">
																	<f:facet name="header">
																	  <h:panelGroup>
		<h:outputText value="OLA" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfBean.filter003.filterColumn10}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab2DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:inputText value="#{detail.ola}" size="5" style="text-align:right;" styleClass="contentform" onchange="calTotalUserRequest();" 
																	 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
																     onblur="this.value = isNumber(this);#{rich:component('wait')}.hide()" ></h:inputText>
																	<a4j:jsFunction name="calTotalUserRequest" action="#{wfAction.onkeyOlaUserRequest}" reRender="tab2DataTable"></a4j:jsFunction>
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn11}"  filterExpression="#{fn:containsIgnoreCase(detail.emailStatus,wfBean.filter003.filterColumn11)}"  style="width:100px; text-align:center;" >
																	<f:facet name="header">
																	 <h:panelGroup>
		<h:outputText value="Send Mail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfBean.filter003.filterColumn11}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab2DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:selectOneRadio value="#{detail.emailStatus}" layout="lineDirection" style="margin:0; padding:0;">
																		<f:selectItem itemValue="N" itemLabel="No"/>
																		<f:selectItem itemValue="Y" itemLabel="Yes"/>
																	</h:selectOneRadio>
																</rich:column>
																<f:facet name="footer">
																	<rich:columnGroup>
																		<rich:column colspan="2" style="text-align:right;">
																		    <h:outputText value="SLA ="></h:outputText>
																		</rich:column>
																		<rich:column style="text-align:center;" >
                                                                             <h:outputText value="#{wfBean.total}" ></h:outputText>
																		</rich:column>
																		<rich:column >
																		     <h:outputText value="Days"></h:outputText>
																		</rich:column>
																	</rich:columnGroup>										
																</f:facet>			
															</rich:dataTable>
														</h:panelGroup>
														<h:panelGroup>
															<a4j:commandButton value="Save" styleClass="rich-button" action="#{wfAction.save}" reRender="errorMsg,tab2DataTable"/>
					                                        <rich:spacer width="10"></rich:spacer>
				                                  			<a4j:commandButton value="Cancel" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
														</h:panelGroup>
				                                  	</h:panelGrid>
					                            </h:panelGroup>
									        </rich:tab>
									        <rich:tab label="Request Network Config" action="#{wfAction.tabNwConfig}" >
										        <h:panelGroup style="width:100%;">
										        	<h:panelGrid columns="1" width="100%" cellpadding="0" cellspacing="0">
										      			<h:graphicImage value="../images/Pic3-NCReqFull.png"  width="800px"/>
										      		</h:panelGrid>	
										            <table width="100%" border="0" class="thtext_detail">
					                                  	<tr class="inputRow">
															<td class="labelStyle" valign="top" >
																<h:outputText value="SMS :&nbsp;" escape="false"/>
															</td>	
													        <td>
															   <table>
													             <tr>
													               <td>
														               <h:selectOneRadio value="#{wfBean.ipWfConfig.smsStatus}" layout="pageDirection">
																		<f:selectItem itemValue="0" itemLabel="No"/>
																		<f:selectItem itemValue="1" itemLabel="Yes"/>
																	   </h:selectOneRadio>
													               </td>
													               <td rowspan="2" valign="bottom">
													                  <h:inputText value="#{wfBean.ipWfConfig.smsMobileNoList}" size="30" style="vertical-align:bottom;width : 173px; height : 20px;"></h:inputText>								
													               </td>
													             </tr>
													            </table>										
															</td>							
					                                  	</tr>
					                            	</table>
					                            	<h:panelGrid columns="1" width="100%" cellpadding="0" cellspacing="0">
				                                  		<h:panelGroup style="width:100%">
															<rich:dataTable id="tab3DataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
																	var="detail" value="#{wfBean.ipWfConfigRequestNetworkList}"
																	rowClasses="odd,even" 
																	styleClass="contentform" rowKeyVar="index" 
																	headerClass="tableHeader">
																
																<rich:column  filterValue="#{wfBean.filter003.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.id.nodeId,wfBean.filter003.filterColumn1)}"   style="width:60px; text-align:center;">
																	<f:facet name="header">																	
																		    <h:panelGroup>
			<h:outputText value="Node" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfBean.filter003.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab3DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:outputText value="#{detail.id.nodeId}" style="width:100%"></h:outputText>
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.nodeDesc,wfBean.filter003.filterColumn2)}"  >
																	<f:facet name="header">
																		 <h:panelGroup>
			<h:outputText value="Node Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfBean.filter003.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab3DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:outputText value="#{detail.nodeDesc}"  style="width:100%"></h:outputText>		
																</rich:column>
																<rich:column  filterValue="#{wfBean.filter003.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.ola,wfBean.filter003.filterColumn3)}"  style="width:60px; text-align:center;">
																	<f:facet name="header">
																				<h:panelGroup>
	<h:outputText value="OLA" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfBean.filter003.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tab3DataTable" />
		 </h:inputText>
	 </h:panelGroup>
																	</f:facet>
																	<h:inputText value="#{detail.ola}" size="5" style="text-align:right;" styleClass="contentform" onchange="calTotalNwConfig();" 
																	 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
																     onblur="this.value = isNumber(this);#{rich:component('wait')}.hide()"></h:inputText>
																	   <a4j:jsFunction name="calTotalNwConfig" action="#{wfAction.onkeyOlaNwConfig}" reRender="tab3DataTable,groubSum"></a4j:jsFunction>
																</rich:column> 
																<rich:column style="width:100px; text-align:center;" >
																	<f:facet name="header">
																		<h:outputText value="Send Mail" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
																	</f:facet>
																	<h:selectOneRadio value="#{detail.emailStatus}" layout="lineDirection" style="margin:0; padding:0;">
																		<f:selectItem itemValue="N" itemLabel="No"/>
																		<f:selectItem itemValue="Y" itemLabel="Yes"/>
																	</h:selectOneRadio>
																</rich:column>	
																
															   <f:facet name="footer">
										                        <rich:columnGroup id="groubSum">
										                        	<rich:column colspan="2" style="text-align:right;">
										                        	     <h:outputText value="SLA(TNP without Impact) = " />
										                            </rich:column>
										                            <rich:column style="text-align:center;" >
										                                <h:outputText value="#{wfBean.ipWfConfig.slaTnpWithoutImpact}" />
										                            </rich:column>
										                            <rich:column >
										                                <h:outputText value="Days"></h:outputText>
										                            </rich:column>
										                            <rich:column colspan="2" breakBefore="true" style="text-align:right;">
										                        	     <h:outputText value="SLA(TNP with Impact) = " />
										                            </rich:column>
										                            <rich:column style="text-align:center;">
										                                <h:outputText value="#{wfBean.ipWfConfig.slaTnpWithImpact}" />
										                            </rich:column>
										                            <rich:column>
										                                 <h:outputText value="Days"></h:outputText>
										                            </rich:column>
										                            <rich:column colspan="2" breakBefore="true" style="text-align:right;">
										                               <h:outputText value="SLA(CDN without Impact) = " />
										                            </rich:column>
										                            <rich:column style="text-align:center;">
										                                <h:outputText value="#{wfBean.ipWfConfig.cdnWithoutImpact}" />
										                            </rich:column>
										                            <rich:column >
										                                <h:outputText value="Days"></h:outputText>
										                            </rich:column>
										                            <rich:column colspan="2" breakBefore="true" style="text-align:right;">
										                               <h:outputText value="SLA(CDN with Impact) = " />
										                            </rich:column>
										                            <rich:column style="text-align:center;">
										                                <h:outputText value="#{wfBean.ipWfConfig.cdnWithImpact}" />
										                            </rich:column>
										                            <rich:column >
										                                <h:outputText value="Days"></h:outputText>
										                            </rich:column>
										                        </rich:columnGroup>
										                    </f:facet>	
															</rich:dataTable>
														</h:panelGroup>
														<h:panelGroup>
															<a4j:commandButton value="Save" styleClass="rich-button" action="#{wfAction.save}" reRender="errorMsg,groubSum,tab3DataTable" />
					                                        <rich:spacer width="10"></rich:spacer>
				                                  			<a4j:commandButton value="Cancel" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
														</h:panelGroup>
				                                  	</h:panelGrid>
					                            </h:panelGroup>
									        </rich:tab>
			    						</rich:tabPanel>
									</h:panelGroup>
								</rich:panel>
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
</f:view>
</body>
</html>
