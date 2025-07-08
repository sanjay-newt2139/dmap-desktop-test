<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<f:subview id="popup11"> 
<rich:modalPanel id="IPURS004_11Popup" autosized="true"styleClass="contentform" height="200" minWidth="620" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Assign IP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPURS004_11Popup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
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
					<table width="97%" border="0"  class="thtext_detail2">
						<tr><td>
							<rich:panel id="groupSearchCriteria" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail" >
										<tr>
											<td width="25%" height="25" align="right" >
												<strong><h:outputText value="System Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td width="30%" height="22"  align="left" >
                                               <h:inputText id="systemName" value="Sys1" size="30"	 
                                                style="text-align:cente"/>													
											</td>	
											<td width="25%" height="25" align="right" >
												<strong><h:outputText value="Host Name:"></h:outputText></strong>&nbsp;
											</td>	
									        <td  width="40%" height="22"  align="left" >
                                                <h:inputText id="hostName" value="HostName1" size="30"	 
                                                 style="text-align:cente"/>			
											</td>													
	                                  	</tr>
	                                  	<tr> 
											<td  height="25" align="right" >
												<strong><h:outputText value="VLAN_ID :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" >
                                                 <h:inputText id="vlan" value="" size="20"	 
                                                 style="text-align:cente"/>															
											</td>
											<td align="right">
												<strong><h:outputText value="Mask :"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /></strong>&nbsp;
											</td>
											<td>
                                                <h:inputText id="mask" value="255.255.255.0" size="20"	 
                                                 style="text-align:cente"/>		
											</td>														
	                                  	</tr>
	                                  		<tr> 
											<td  height="25" align="right" >
												<strong><h:outputText value="Network :"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" >
                                                <h:inputText id="network" value="Network" size="20"	 
                                                 style="text-align:cente"/>														
											</td>
											<td align="right">
												<strong><h:outputText value="Gateway :"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /></strong>&nbsp;
											</td>
											<td>
                                                <h:inputText id="gateway" value="10.13.33.1" size="20"	 
                                                 style="text-align:cente"/>		
											</td>														
	                                  	</tr>
	                                  		<tr> 
											<td  height="25" align="right" >
												<strong><h:outputText value="Effective Date :"></h:outputText></strong>&nbsp;
											</td>	
									        <td height="22"  align="left" >
		                                     <rich:calendar value="01/01/2010"
									                        locale="en/US"
									                        popup="true"
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
									                        inputStyle="background-color:white"
									                        inputSize="20"
									                        direction="auto"/>												
											</td>
											<td align="right">
												<strong><h:outputText value="Expire Date :"></h:outputText></strong>&nbsp;
											</td>
											<td>
											 <rich:calendar value="01/01/2010"
									                        locale="en/US"
									                        popup="true"
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
									                        inputStyle="background-color:white"
									                        inputSize="20"
									                        direction="auto"/>	
											</td>														
	                                    <td colspan="4" >&nbsp;</td>
	                                  </tr>                                                        
									</table>
								</rich:panel>
						</td>
					</tr>
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0" align="center" >
								<tr>
									<td align="right" colspan="8" >
	
											<a4j:commandButton id="btnAssign2" value="Assign IP" styleClass="rich-button"
												action="#{userReqIPAction.init}" >
												<rich:componentControl for="IPURS004_11Popup" attachTo="btnAssign2" operation="hide" event="onclick"/>
											<a4j:actionparam name="programIDParam" value="IPURS004_08"/>
										    </a4j:commandButton>
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" reRender="DetailForm" >
											   <rich:componentControl for="IPURS004_11Popup" attachTo="btnCancel" operation="hide" event="onclick"/>
											</a4j:commandButton>
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
</rich:modalPanel>
	
</f:subview>
