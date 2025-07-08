<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<f:subview id="popup07"> 
<rich:modalPanel id="IPURS004_07Popup" autosized="true"styleClass="contentform" height="200" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Assign IP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPURS004_07Popup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
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
					<table width="97%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
						<tr>
						   <td>
						   	 	<rich:panel>
						   	 	   <strong>IP Address<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
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
										<h:panelGroup id="button">
											<a4j:commandButton id="btnSearch" value="Search"  styleClass="rich-button">
											    <rich:componentControl for="IPURS004_07Popup" attachTo="btnSearch" operation="hide" event="onclick"/>
											   <rich:componentControl for="IPURS004_09Popup" attachTo="btnSearch" operation="show" event="onclick"/>
											</a4j:commandButton>&nbsp;
											<a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button"
												action="#{userReqIPAction.clear}"/>
										</h:panelGroup>
								<rich:dataTable width="95%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="ipDetail" value="0" reRender="scrollIPDetailTable" 
									rows="#{ipfmConfigBean.rowPerPage}"
									  
									 
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

										<rich:column width="5%" >
											<f:facet name="header">
												 <h:selectBooleanCheckbox/>
											</f:facet>
											<div align="center">
											</div>
										</rich:column>
							            <rich:column width="20%" >
											<f:facet name="header">
												<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						  
											</div>
										</rich:column>									
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Total" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						    
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Available" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					  
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Assigned" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					   <h:outputText value=""></h:outputText> 
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Reserved" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					   
											</div>
										</rich:column>
										<rich:column width="10%" >
											<f:facet name="header">
												<h:outputText value="Used" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					   
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="0" /> records
												</rich:column>
												<rich:column colspan="8">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable2"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable2" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}" 
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>												
										</f:facet>
									</rich:dataTable>	
								 </rich:panel>											
						   </td>
						</tr>
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="right" colspan="6">
										<h:panelGroup id="buttonGroup">
											<a4j:commandButton id="btnAssign" value="Assign" styleClass="rich-button"
												action="#{userReqIPAction.sendApprove}"/>&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
												 oncomplete="window.close();"/>
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
</rich:modalPanel>	
<jsp:directive.include file="IPURS004_09.jsp"/>
</f:subview>
