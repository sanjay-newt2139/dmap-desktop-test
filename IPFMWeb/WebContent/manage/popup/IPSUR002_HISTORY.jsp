<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<f:subview id="popup"> 
   <rich:modalPanel id="IPURS004_05Popup"  styleClass="contentform" height="400" minWidth="730" label="Find Region">
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
    <body style="overflow: hidden;">
    
    
    <div id="container" style="width: 100%;height: 350px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" style="height: 350px;"  border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0"  >
						<tr>
							<td>	
							   <rich:panel>
								<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
									var="historyList" value="#{planningReqIPBean.historyList}" reRender="scrollIPDetailTable" 
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
									    <rich:column width="5%">
									    	<f:facet name="header">
												<h:outputText value="" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center" style="vertical-align: top;">
											<h:graphicImage rendered="#{historyList.overOla=='Y'}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
											<h:graphicImage rendered="#{historyList.overSla=='Y'}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
											</div>
										</rich:column> 
										<rich:column width="16%" sortBy="#{historyList.lastUpd}" sortOrder="#{planningReqIPBean.sortIpsur002History.sortColumn5 }" >
											<f:facet name="header">
												<h:outputText value="Date Time" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center" style="vertical-align: top;">
				          						 <h:outputText value="#{historyList.lastUpd}"styleClass="contentform" >
				          						   <f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
				          						 </h:outputText>
											</div>
										</rich:column>
							            <rich:column width="21%"   selfSorted="false" sortOrder="#{planningReqIPBean.sortIpsur002History.sortColumn1}" sortBy="#{historyList.actionName}"    filterValue="#{planningReqIPBean.filterIpsur002History.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(historyList.actionName,planningReqIPBean.filterIpsur002History.filterColumn1)}"  >
											<f:facet name="header">											
												  <h:panelGroup>
		 			<a4j:commandLink  reRender="ipDetailTable" action="#{planningReqIPAction.indexSort}" >	
												    <span class="contentform tableHeaderText"><strong>Action</strong></span>									 
													<f:param name="sortColumn" value="#{planningReqIPBean.sortIpsur002History.sortColumn1}" />
													<f:param name="sortColumnNo" value="1" />
													<f:param name="TablSort" value="ipDetailTable" /> 
											</a4j:commandLink>  													  
		    <br/>		 
		 <h:inputText value="#{planningReqIPBean.filterIpsur002History.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left" style="vertical-align: top;">
			          						   <h:outputText value="#{historyList.actionName}"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>									
										<rich:column width="28%"   selfSorted="false" sortOrder="#{planningReqIPBean.sortIpsur002History.sortColumn2}" sortBy="#{historyList.actionUserSubstr}"  filterValue="#{planningReqIPBean.filterIpsur002History.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(historyList.actionUserSubstr,planningReqIPBean.filterIpsur002History.filterColumn2)}"  >
											<f:facet name="header">												
												 <h:panelGroup>
		 			<a4j:commandLink  reRender="ipDetailTable" action="#{planningReqIPAction.indexSort}" >	
												    <span class="contentform tableHeaderText"><strong>Action by</strong></span>									 
													<f:param name="sortColumn" value="#{planningReqIPBean.sortIpsur002History.sortColumn2}" />
													<f:param name="sortColumnNo" value="2" />
													<f:param name="TablSort" value="ipDetailTable" /> 
											</a4j:commandLink>  													  
		    <br/>	
		 <h:inputText value="#{planningReqIPBean.filterIpsur002History.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left" style="vertical-align: top;">
     						                    <h:outputText value="#{historyList.actionUserSubstr}" escape="false" styleClass="contentform" ></h:outputText>
			          						     <rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip" layout="block">
			          						      	<h:outputText  value="#{historyList.actionUserDesc}" />
			          						     </rich:toolTip>
											</div>
										</rich:column>
										<rich:column width="15%"   selfSorted="false" sortOrder="#{planningReqIPBean.sortIpsur002History.sortColumn3}" sortBy="#{historyList.actionRemarkDesc}"  filterValue="#{planningReqIPBean.filterIpsur002History.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(historyList.actionRemarkDesc,planningReqIPBean.filterIpsur002History.filterColumn3)}"  >
											<f:facet name="header">												
												 <h:panelGroup>
		 		<a4j:commandLink  reRender="ipDetailTable" action="#{planningReqIPAction.indexSort}" >	
												    <span class="contentform tableHeaderText"><strong>Action Result</strong></span>									 
													<f:param name="sortColumn" value="#{planningReqIPBean.sortIpsur002History.sortColumn3}" />
													<f:param name="sortColumnNo" value="3" />
													<f:param name="TablSort" value="ipDetailTable" /> 
											</a4j:commandLink>  													  
		    <br/>	
		 <h:inputText value="#{planningReqIPBean.filterIpsur002History.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left" style="vertical-align: top;">
				          					   <h:outputText value="#{historyList.actionRemarkDesc}"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
										<rich:column width="25%"  selfSorted="false" sortOrder="#{planningReqIPBean.sortIpsur002History.sortColumn4}" sortBy="#{historyList.userRemark}"  filterValue="#{planningReqIPBean.filterIpsur002History.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(historyList.userRemark,planningReqIPBean.filterIpsur002History.filterColumn4)}"  >
											<f:facet name="header">												
												 <h:panelGroup>
		 		<a4j:commandLink  reRender="ipDetailTable" action="#{planningReqIPAction.indexSort}" >	
												    <span class="contentform tableHeaderText"><strong>Remarks</strong></span>									 
													<f:param name="sortColumn" value="#{planningReqIPBean.sortIpsur002History.sortColumn4}" />
													<f:param name="sortColumnNo" value="4" />
													<f:param name="TablSort" value="ipDetailTable" /> 
											</a4j:commandLink>  													  
		    <br/>	
		 <h:inputText value="#{planningReqIPBean.filterIpsur002History.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left" style="vertical-align: top;">
				          					   <h:outputText value="#{historyList.userRemark}"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{fn:length(planningReqIPBean.historyList)}" /> records
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
							  <h:panelGrid id="group" columns="2">									
							    <h:outputText value="Current Status :&nbsp;" escape="false" style="COLOR: #0000ff; FONT-WEIGHT: bold;"/>
								<h:outputText value="#{planningReqIPBean.ipUrAction.actionName}" style="COLOR: #0000ff;"></h:outputText>
								<h:outputText rendered="false" value="#{planningReqIPBean.renderApproval}" style="COLOR: #0000ff;"></h:outputText>
							  </h:panelGrid>	
							  
								<rich:dataTable rendered="#{planningReqIPBean.renderApproval != ''}" width="55%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="urActionList" value="#{planningReqIPBean.urActionList}" reRender="scrollIPDetailTable" rows="5"
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

							            <rich:column width="50%"     >
											<f:facet name="header">											
		 	<h:outputText value="Action By" styleClass="contentform tableHeaderText"></h:outputText>  											
											</f:facet>
											<div align="left">
											  <h:outputText value="#{urActionList.actionUserDesc}" escape="false" styleClass="contentform"/>
			          						  <h:inputHidden id="currentStatus" value="#{urActionList.actionName}"/>
											</div>
										</rich:column>							

										<f:facet name="footer">
											<rich:columnGroup >
												<rich:column colspan="2">
													Total : <h:outputText value="#{fn:length(planningReqIPBean.urActionList)}" /> records
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
									    	<a4j:commandButton value="Close" styleClass="rich-button" >
									    		<rich:componentControl for="IPURS004_05Popup" operation="hide" event="onclick" />
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
	</div>
	</body>
 </rich:modalPanel>
</f:subview>
