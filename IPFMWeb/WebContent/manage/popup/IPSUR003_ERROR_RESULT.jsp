<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:subview id="IPSUR003_ERROR_RESULT_POPUP"> 
<rich:modalPanel id="IPSUR003_ERROR_RESULT" rendered="true" autosized="true" styleClass="contentform" minWidth="550" height="#{not empty networkConfigBean.validateResult?'300':'200'}" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Error Data"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPSUR003_ERROR_RESULT" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <div id="container" style="overflow: auto; width: 100%;">
    <h:form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="80%" align="center" valign="top">
						  	<table width="97%" border="0" cellspacing="0" cellpadding="0"  >
						  		<tr>
						  			<td align="center">
						  				<h:outputText value="#{networkConfigBean.errorMsg}" style="font-size: 14px; color: red; font-weight:bolder;"></h:outputText>
						  			</td>
						  		</tr>
						  		<tr>
									<td>
										<rich:spacer height="10"></rich:spacer>
									</td>
								</tr>
								<tr>
									<td>	
									   <rich:panel>
									   		<h:panelGrid columns="1" style="text-align:center;" cellpadding="0" cellspacing="0" width="100%">
									   	  		<rich:dataTable width="100%" id="errorResultTable" cellpadding="1" cellspacing="0" border="0"
													var="detail" value="#{networkConfigBean.validateResult}" reRender="scrollErrorTable" 
													rows="#{ipfmConfigBean.rowPerPage}"
													rowClasses="odd,even" styleClass="contentform" rowKeyVar="index" 
													headerClass="tableHeader">
													    <rich:column width="20%" style="vertical-align:top; text-align:center;">
													    	<f:facet name="header">
																<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
															<h:outputText value="#{detail.errorMsg[0]}" escape="false" styleClass="contentform" />
														</rich:column>
														<rich:column width="30%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="System Owner" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.errorMsg[1]}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<rich:column width="30%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="System Owner Team" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.errorMsg[2]}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<rich:column width="20%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="IP Status" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.errorMsg[3]}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<f:facet name="footer">
															<rich:columnGroup >
																<rich:column colspan="4">
																	<h:panelGroup style="float:left;">
																		Total : <h:outputText value="#{fn:length(networkConfigBean.validateResult)}" /> records
																	</h:panelGroup>
																	<h:panelGroup style="float:right;">
																		<rich:datascroller immediate="true" rendered="true" align="right" for="errorResultTable"
																			maxPages="#{ipfmConfigBean.maxPage}" id="scrollErrorTable" selectedStyleClass="selectScroll"
																			stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
																			style="background-color: #cccccc;"/>
																	</h:panelGroup>
																</rich:column>
															</rich:columnGroup>												
														</f:facet>
												</rich:dataTable>	
												<rich:spacer height="10"></rich:spacer>
											</h:panelGrid>
										</rich:panel>
									</td>
								</tr>
								<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td align="center">
											<a4j:commandButton value="Close" styleClass="rich-button" >
									    		<rich:componentControl for="IPSUR003_ERROR_RESULT" operation="hide" event="onclick" />
									    	</a4j:commandButton>
										</td>
									</tr>
								</table>
							</td>
						</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</h:form>
	</div>
</rich:modalPanel>
</f:subview>
