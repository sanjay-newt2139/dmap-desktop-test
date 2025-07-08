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

<f:subview id="popupHistory"> 
   <rich:modalPanel id="PopupHistory_NetworkConfig" rendered="true"  styleClass="contentform" height="400" minWidth="750" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Action History"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="PopupHistory_NetworkConfig" attachTo="hidelink" operation="hide" event="onclick"/>
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
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0"  >
						<tr>
							<td>	
							   <rich:panel>
							   <rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
									var="networkList" value="#{historyNwConfigBean.ipUrActionHistoryList}" reRender="scrollIPDetailTable"  rows="#{ipfmConfigBean.rowPerPage}"
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">
									    <rich:column width="5%">
									    	<f:facet name="header">
												<h:outputText value="" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center" style="vertical-align: top;">
											<h:graphicImage rendered="#{networkList.overOla=='Y'}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
											<h:graphicImage rendered="#{networkList.overSla=='Y'}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
											</div>
										</rich:column>
										<rich:column width="17%" sortBy="#{networkList.lastUpd}" sortOrder="#{historyNwConfigBean.sortHis.sortColumn6}" >
											<f:facet name="header">
												<h:outputText value="Date Time" styleClass="contentform tableHeaderText">
												</h:outputText>
											</f:facet>
											<div align="center">
				          						 <h:outputText value="#{networkList.lastUpd}" styleClass="contentform" >
				          						     <f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
				          						 </h:outputText>
											</div>
										</rich:column>
										<rich:column width="15%" sortBy="#{networkList.subUrNo}"  selfSorted="false" sortOrder="#{historyNwConfigBean.sortHis.sortColumn1}" filterValue="#{historyNwConfigBean.filterHis.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(networkList.subUrNo,historyNwConfigBean.filterHis.filterColumn1)}"  >
											<f:facet name="header">											 
													  <h:panelGroup>
											<a4j:commandLink  reRender="ipDetailTable" action="#{historyNwConfigAction.indexSort}" >	
												    <span class="contentform tableHeaderText"><strong>Sub UR No</strong></span>									 
													<f:param name="sortColumn" value="#{historyNwConfigBean.sortHis.sortColumn1}" />
													<f:param name="sortColumnNo" value="1" />
													<f:param name="TablSort" value="ipDetailTable" /> 
											</a4j:commandLink>  													  
		    <br/>
		 <h:inputText value="#{historyNwConfigBean.filterHis.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						   <h:outputText value="#{networkList.subUrNo}" styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>	
							            <rich:column width="20%" sortBy="#{networkList.actionName}"   selfSorted="false" sortOrder="#{historyNwConfigBean.sortHis.sortColumn2}" filterValue="#{historyNwConfigBean.filterHis.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(networkList.actionName,historyNwConfigBean.filterHis.filterColumn2)}"  >
											<f:facet name="header">
												  <h:panelGroup>
		   <a4j:commandLink   reRender="ipDetailTable" action="#{historyNwConfigAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Action</strong></span>
				<f:param name="sortColumn" value="#{historyNwConfigBean.sortHis.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </a4j:commandLink><br/>
		 <h:inputText value="#{historyNwConfigBean.filterHis.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
			          						   <h:outputText value="#{networkList.actionName}" styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>									
										<rich:column width="20%" sortBy="#{networkList.actionUser}"  selfSorted="false" sortOrder="#{historyNwConfigBean.sortHis.sortColumn3}" filterValue="#{historyNwConfigBean.filterHis.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(networkList.actionUser,historyNwConfigBean.filterHis.filterColumn3)}"  >
											<f:facet name="header">
												  <h:panelGroup>
		   <a4j:commandLink  reRender="ipDetailTable" action="#{historyNwConfigAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Action by</strong></span>
				<f:param name="sortColumn" value="#{historyNwConfigBean.sortHis.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </a4j:commandLink><br/>
		 <h:inputText value="#{historyNwConfigBean.filterHis.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
			          						     <h:outputText value="#{networkList.actionUser}"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>
										<rich:column width="15%" sortBy="#{networkList.actionRemark}"  selfSorted="false" sortOrder="#{historyNwConfigBean.sortHis.sortColumn4}" filterValue="#{historyNwConfigBean.filterHis.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(networkList.actionRemark,historyNwConfigBean.filterHis.filterColumn4)}"  >
											<f:facet name="header">
												  <h:panelGroup>
		   <a4j:commandLink  reRender="ipDetailTable" action="#{historyNwConfigAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Action Result</strong></span>
				<f:param name="sortColumn" value="#{historyNwConfigBean.sortHis.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </a4j:commandLink><br/>
		 <h:inputText value="#{historyNwConfigBean.filterHis.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
				          					   <h:outputText value="#{networkList.actionRemark}"styleClass="contentform" rendered="#{networkList.actionRemark!='' or networkList.actionRemark!=null}" ></h:outputText>
											</div>
										</rich:column>
										<rich:column width="20%" sortBy="#{networkList.userRemark}"  selfSorted="false" sortOrder="#{historyNwConfigBean.sortHis.sortColumn5}" filterValue="#{historyNwConfigBean.filterHis.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(networkList.userRemark,historyNwConfigBean.filterHis.filterColumn5)}"  >
											<f:facet name="header">
												 <h:panelGroup>
		   <a4j:commandLink  reRender="ipDetailTable" action="#{historyNwConfigAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Remarks</strong></span>
				<f:param name="sortColumn" value="#{historyNwConfigBean.sortHis.sortColumn5}" />
				<f:param name="sortColumnNo" value="5" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </a4j:commandLink><br/>
		 <h:inputText value="#{historyNwConfigBean.filterHis.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="left">
				          					   <h:outputText value="#{networkList.userRemark}"styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="3">
													Total : <h:outputText value="#{fn:length(historyNwConfigBean.ipUrActionHistoryList)}"  /> records
												</rich:column>
												<rich:column colspan="5">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
														maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
														fastStep="#{ipfmConfigBean.fastStepPage}" fastControls="auto" boundaryControls="auto"
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>	
							  <h:panelGrid id="group" width="100%" columns="2" style="align:left" >
							  	<h:panelGroup>		
								    <h:outputText value="Current Status : "></h:outputText>									
									<h:outputText value="#{historyNwConfigBean.ipUrNwConfig.urStatusName}" style="COLOR: #0000ff; FONT-WEIGHT: bold;"></h:outputText>
								</h:panelGroup>
							  </h:panelGrid>	
								<rich:dataTable  width="95%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="urAction" value="#{historyNwConfigBean.ipUrActionList}" reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

							            <rich:column   width="15%" >
											<f:facet name="header">												
		 <h:outputText value="UR Sub No" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
			          						  <h:outputText value="#{urAction.subUrNo}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>	
										<rich:column    width="25%" >
											<f:facet name="header">										
				<h:outputText value="Current Status" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="left">
			          						  <h:outputText value="#{urAction.actionName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>	
										<rich:column   width="25%" >
											<f:facet name="header">												
		<h:outputText value="Next Action" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="left">
			          						  <h:outputText value="#{urAction.actionUser}" escape="false" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>								

										<f:facet name="footer">
											<rich:columnGroup >
												<rich:column colspan="3">
													Total : <h:outputText value="#{fn:length(historyNwConfigBean.ipUrActionList)}" /> records
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
							<td><rich:spacer height="10" /></td>
						</tr>
						<tr>
							<td style="COLOR: #0000ff;"><h:graphicImage value="../images/icon_required.gif" style="border:0" /> กรณีที่ PM มีการเลือก Impact ระบบจะรอ ACTM Analyst ก่อนดำเนินการต่อ</td>
						</tr>
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0" align="center" >
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td align="center" colspan="8" >
						 	                <a4j:commandButton value="Close" styleClass="rich-button" >
									    		<rich:componentControl for="PopupHistory_NetworkConfig" operation="hide" event="onclick" />
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
