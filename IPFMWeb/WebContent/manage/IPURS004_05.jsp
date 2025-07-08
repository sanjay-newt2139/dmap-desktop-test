<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<f:subview id="popup"> 
   <rich:modalPanel id="IPURS004_05Popup"  styleClass="contentform" height="400" minWidth="700" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Action History"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPURS004_05Popup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	<table width="100%" style="height: 350px;" border="0" cellspacing="0" cellpadding="0">
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
					<table width="97%" border="0" cellspacing="0" cellpadding="0"  >
						<tr>
							<td>	
							   <rich:panel>
								<rich:dataTable width="95%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
									var="user" value="1" reRender="scrollIPDetailTable" 
									rows="#{ipfmConfigBean.rowPerPage}"
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

										<rich:column width="15%" >
											<f:facet name="header">
												<h:outputText value="Date Time" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          						 <h:outputText value="16/08/2010 09:22"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
							            <rich:column width="15%" >
											<f:facet name="header">
												<h:outputText value="Action" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						   <h:outputText value="Create UR"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>									
										<rich:column width="15%" >
											<f:facet name="header">
												<h:outputText value="Action by" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						     <h:outputText value="Plan A"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
										<rich:column width="15%" >
											<f:facet name="header">
												<h:outputText value="Action Result" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					   <h:outputText value="Completed"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
										<rich:column width="20%" >
											<f:facet name="header">
												<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          					   <h:outputText value="ระบุข้อมูล Contact Point"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="1" /> records
												</rich:column>
												<rich:column colspan="5">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>
											
																						
										</f:facet>
									</rich:dataTable>	
							  <h:panelGrid id="group" width="55%" >		
							    <h:outputText value=""></h:outputText>									
								<h:outputText value="Current Status : Wait for Assign IP" style="COLOR: #0000ff; FONT-WEIGHT: bold;"></h:outputText>
								<h:outputText value=""></h:outputText>
							  </h:panelGrid>	
								<rich:dataTable  width="55%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="userReq" value="" reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

							            <rich:column width="50%" >
											<f:facet name="header">
												<h:outputText value="Action By" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						  <h:outputText value="Sorakit Molasilpin" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>	
										<rich:column width="15%" >
											<f:facet name="header">
												<h:outputText value="Tel" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						     <h:outputText value="0860576195"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>								

										<f:facet name="footer">
											<rich:columnGroup >
												<rich:column colspan="2">
													Total : <h:outputText value="1" /> records
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
								<table width="97%" border="0" cellspacing="0" cellpadding="0" align="center" >
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td align="center" colspan="8" >
									    	<a4j:commandButton id="btnOk" value="Close" styleClass="rich-button"
												action="#{userReqIPAction.save}"
												reRender="DetailForm" />
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
