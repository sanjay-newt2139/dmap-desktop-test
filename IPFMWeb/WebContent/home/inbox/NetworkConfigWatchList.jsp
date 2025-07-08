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
-->
</style>
<h:panelGroup
	rendered="#{fn:length(inboxBean.ipvWlNetworkConfigList)>0}">
	<rich:spacer height="5" />
	
	<rich:dataTable width="100%" id="networkConfigWlTable" cellpadding="0"
		cellspacing="0" border="0" style="margin-bottom:0px;" var="detail"
		value="#{inboxBean.ipvWlNetworkConfigList}"
		reRender="scrollNetworkConfigWl" rows="#{ipfmConfigBean.rowPerPage}"
		rowClasses="odd,even" styleClass="contentform"
		headerClass="tableHeader">		
	
		<rich:column styleClass="valignTop"
			style="width:17px; text-align:center;">
			<h:graphicImage rendered="#{detail.slaSts<0}"
				value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
		</rich:column>
		<rich:column sortBy="#{detail.urNo}" selfSorted="false"
			sortOrder="#{inboxBean.watchNCSortColumn.sortColumn1}"
			filterValue="#{inboxBean.urNoFilter}" 
			filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.urNoFilter)}"
			styleClass="valignTop" style="width:110px; text-align:center;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="curNo" rendered="true" action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>UR NO. </strong> </span>						
						<f:param name="sortColumn" value="#{inboxBean.watchNCSortColumn.sortColumn1}" />
						<f:param name="sortColumnNo" value="1" />
						<f:param name="TablSort" value="watchNC" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.urNoFilter}" style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigWlTable" />
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
			sortOrder="#{inboxBean.watchNCSortColumn.sortColumn2}"
			filterValue="#{inboxBean.subUrNoFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.subUrNoFilter)}"
			styleClass="valignTop" style="width:80px; text-align:center;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cSubNo" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Sub
								UR No.</strong> </span>
								<f:param name="sortColumn" value="#{inboxBean.watchNCSortColumn.sortColumn2}" />
						<f:param name="sortColumnNo" value="2" />
						<f:param name="TablSort" value="watchNC" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.subUrNoFilter}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigWlTable" />
					</h:inputText>
				</h:panelGroup>
			</f:facet>
			<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.subject}" selfSorted="false"
			sortOrder="#{inboxBean.watchNCSortColumn.sortColumn3}"
			filterValue="#{inboxBean.subjectFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.subjectFilter)}"
			styleClass="valignTop">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cSubject" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Subject</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.watchNCSortColumn.sortColumn3}" />
						<f:param name="sortColumnNo" value="3" />
						<f:param name="TablSort" value="watchNC" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.subjectFilter}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigWlTable" />
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
		<rich:column sortBy="#{detail.reqDate}" styleClass="valignTop"
			sortOrder="#{inboxBean.watchNCSortColumn.sortColumn4}"
			style="width:85px; text-align:center;">
			<f:facet name="header">
				<h:outputText value="Request Date" escape="false"
					styleClass="contentform tableHeaderText"></h:outputText>
			</f:facet>
			<h:outputText value="#{detail.reqDate}" styleClass="contentform">
				<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
			</h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.slaDate}" styleClass="valignTop"
		sortOrder="#{inboxBean.watchNCSortColumn.sortColumn5}"
			style="width:85px; text-align:center;">
			<f:facet name="header">
				<h:outputText value="Plan To Finish" escape="false"
					styleClass="contentform tableHeaderText"></h:outputText>
			</f:facet>
			<h:outputText value="#{detail.slaDate}" styleClass="contentform">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.urStatus}" selfSorted="false"
			sortOrder="#{inboxBean.watchNCSortColumn.sortColumn6}"
			filterValue="#{inboxBean.statusFilter}"
			filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.statusFilter)}"
			styleClass="valignTop" style="width:200px;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cSta" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Status</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.watchNCSortColumn.sortColumn6}" />
						<f:param name="sortColumnNo" value="6" />
						<f:param name="TablSort" value="watchNC" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.statusFilter}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="networkConfigWlTable" />
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
							value="#{fn:length(inboxBean.ipvWlNetworkConfigList)}" /> records
					</h:panelGroup>
					<h:panelGroup style="float:right;">
						<rich:datascroller immediate="true" rendered="true" align="right"
							for="networkConfigWlTable" maxPages="#{ipfmConfigBean.maxPage}"
							id="scrollNetworkConfigWl" selectedStyleClass="selectScroll"
							stepControls="hide" fastControls="auto" boundaryControls="auto"
							fastStep="#{ipfmConfigBean.fastStepPage}"
							style="background-color: #cccccc;" />
					</h:panelGroup>
				</rich:column>
			</rich:columnGroup>
		</f:facet>
	</rich:dataTable>
</h:panelGroup>