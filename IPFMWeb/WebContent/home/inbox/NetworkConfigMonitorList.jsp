<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<style type="text/css">
<!--
.alignCenter {
	text-align: center;
}

.rich-filter-input {
	width: 80px;
}
-->
</style>

<h:panelGroup
	rendered="#{fn:length(inboxBean.ipvMntNetworkConfigList)>0}">
	<rich:spacer height="5" />
	<rich:dataTable width="100%" id="networkConfigMNTTable" cellpadding="0"
		cellspacing="0" border="0" style="margin-bottom:0px;" var="detail"
		value="#{inboxBean.ipvMntNetworkConfigList}"
		reRender="scrollNetworkConfigMNT" rows="#{ipfmConfigBean.rowPerPage}"
		rowClasses="odd,even" styleClass="contentform"
		headerClass="tableHeader">
		<rich:column styleClass="valignTop"
			style="width:17px; text-align:center;">
			<h:graphicImage rendered="#{detail.slaSts<0}"
				value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
		</rich:column>
		<rich:column sortBy="#{detail.urNo}" selfSorted="false"
			sortOrder="#{inboxBean.nCMSortColumn.sortColumn1}"
			filterValue="#{inboxBean.nCMURNoFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.nCMURNoFilter)}"
			styleClass="valignTop" style="width:110px; text-align:center;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="curNo" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>UR NO. </strong> </span>
						<f:param name="sortColumn" value="#{inboxBean.nCMSortColumn.sortColumn1}" />
						<f:param name="sortColumnNo" value="1" />
						<f:param name="TablSort" value="monitor" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.nCMURNoFilter}" style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigMNTTable" />
					</h:inputText>
				</h:panelGroup>

			</f:facet>
			<a4j:commandLink value="#{detail.urNo}"
				action="#{inboxAction.navigation}" styleClass="contentform">
				<f:param name="URNo" value="#{detail.urNo}" />
				<f:param name="MODE" value="#{detail.callMode}" />
				<f:param name="FuncID" value="#{detail.callFunctionId}" />
			</a4j:commandLink>
		</rich:column>
		<rich:column sortBy="#{detail.subUrNo}" selfSorted="false"
			sortOrder="#{inboxBean.nCMSortColumn.sortColumn2}"
			filterValue="#{inboxBean.nCMSubURNoFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.nCMSubURNoFilter)}"
			styleClass="valignTop" style="width:80px; text-align:center;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cSubNo" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Sub Ur No.</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.nCMSortColumn.sortColumn2}" />
						<f:param name="sortColumnNo" value="2" />
						<f:param name="TablSort" value="monitor" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.nCMSubURNoFilter}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigMNTTable" />
					</h:inputText>
				</h:panelGroup>
			</f:facet>
			<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.subject}" selfSorted="false"
			sortOrder="#{inboxBean.nCMSortColumn.sortColumn3}"
			filterValue="#{inboxBean.nCMSubjectFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.nCMSubjectFilter)}"
			styleClass="valignTop" style="width:300px;">
			<f:facet name="header">
			<h:panelGroup>
  <h:commandLink  id="cSubject" rendered="true"   action="#{inboxAction.indexSort}" >
    <span class="contentform tableHeaderText"><strong>Subject  </strong></span>
    <f:param name="sortColumn" value="#{inboxBean.nCMSortColumn.sortColumn3}" />
						<f:param name="sortColumnNo" value="3" />
						<f:param name="TablSort" value="monitor" />
  </h:commandLink>
   <h:inputText value="#{inboxBean.nCMSubjectFilter}" style="width: 50px;">
    <a4j:support event="onblur" reRender="networkConfigMNTTable" />
   </h:inputText>      											 	  						 
</h:panelGroup>
			</f:facet>
			<rich:toolTip showEvent="onclick" style="width:350px;"
				direction="bottom-left" mode="client" styleClass="tooltip"
				layout="block">
				<h:outputText value="#{detail.subject01Desc}" escape="false" />
			</rich:toolTip>
			<h:outputText value="#{detail.subject01SubStr}"
				styleClass="contentform"></h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.reqDate}" styleClass="valignTop" sortOrder="#{inboxBean.nCMSortColumn.sortColumn4}"
			style="width:85px; text-align:center;">
			<f:facet name="header">
				<h:outputText value="Request Date" escape="false"
					styleClass="contentform tableHeaderText"></h:outputText>
			</f:facet>
			<h:outputText value="#{detail.reqDate}" styleClass="contentform">
				<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
			</h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.slaDate}" styleClass="valignTop" sortOrder="#{inboxBean.nCMSortColumn.sortColumn5}"
			style="width:85px; text-align:center;">
			<f:facet name="header">
				<h:outputText value="Plan To Finish" escape="false"
					styleClass="contentform tableHeaderText"></h:outputText>
			</f:facet>
			<h:outputText value="#{detail.slaDate}" styleClass="contentform">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.urStatus}"  selfSorted="false" 
		sortOrder="#{inboxBean.nCMSortColumn.sortColumn6}"
		filterValue="#{inboxBean.nCMStatusFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.nCMStatusFilter)}"
			style="width:200px;" styleClass="valignTop">
			<f:facet name="header">
				 <h:panelGroup>
					<h:commandLink id="cMStatus" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Status</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.nCMSortColumn.sortColumn6}" />
						<f:param name="sortColumnNo" value="6" />
						<f:param name="TablSort" value="monitor" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.nCMStatusFilter}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigMNTTable" />
					</h:inputText>
				</h:panelGroup>
			</f:facet>
			<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
		</rich:column>
		<f:facet name="footer">
			<rich:columnGroup>
				<rich:column colspan="7">
					<h:panelGroup style="float:left;">
						Total : <h:outputText
							value="#{fn:length(inboxBean.ipvMntNetworkConfigList)}" /> records
					</h:panelGroup>
					<h:panelGroup style="float:right;">
						<rich:datascroller immediate="true" rendered="true" align="right"
							for="networkConfigMNTTable" maxPages="#{ipfmConfigBean.maxPage}"
							id="scrollNetworkConfigMNT" selectedStyleClass="selectScroll"
							stepControls="hide" fastControls="auto" boundaryControls="auto"
							fastStep="#{ipfmConfigBean.fastStepPage}"
							style="background-color: #cccccc;" />
					</h:panelGroup>
				</rich:column>
			</rich:columnGroup>
		</f:facet>
	</rich:dataTable>
</h:panelGroup>