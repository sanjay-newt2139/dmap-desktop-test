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
<h:panelGroup rendered="#{fn:length(inboxBean.ipvWlPlanningReqList)>0}">
	<rich:spacer height="5" />
	<rich:dataTable width="100%" id="planningReqIPWlTable" cellpadding="0"
		cellspacing="0" border="0" style="margin-bottom:0px;" var="detail"
		value="#{inboxBean.ipvWlPlanningReqList}"
		reRender="scrollPlanningReqIPWl" rows="#{ipfmConfigBean.rowPerPage}"
		rowClasses="odd,even" styleClass="contentform"
		headerClass="tableHeader">
		<rich:column styleClass="valignTop"
			style="width:17px; text-align:center;">
			<h:graphicImage rendered="#{detail.slaSts<0}"
				value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
		</rich:column>
		<rich:column sortBy="#{detail.urNo}" selfSorted="false"
			sortOrder="#{inboxBean.watchPlanSortColumn.sortColumn1}"
			filterValue="#{inboxBean.urNoFilterP}"
			filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.urNoFilterP)}"
			styleClass="valignTop" style="width:80px; text-align:center;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cPurNo" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>UR
								NO. </strong> </span>
								<f:param name="sortColumn" value="#{inboxBean.watchPlanSortColumn.sortColumn1}" />
						<f:param name="sortColumnNo" value="1" />
						<f:param name="TablSort" value="watchPlan" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.urNoFilterP}" style="width: 50px;">
						<a4j:support event="onblur" reRender="planningReqIPWlTable" />
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
		<rich:column sortBy="#{detail.subject}" selfSorted="false"
					sortOrder="#{inboxBean.watchPlanSortColumn.sortColumn2}"
			filterValue="#{inboxBean.subjectFilterP}"
			filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.subjectFilterP)}"
			styleClass="valignTop" style="width:150px;">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cSubject" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Subject</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.watchPlanSortColumn.sortColumn2}" />
						<f:param name="sortColumnNo" value="2" />
						<f:param name="TablSort" value="watchPlan" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.subjectFilterP}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="planningReqIPWlTable" />
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
					sortOrder="#{inboxBean.watchPlanSortColumn.sortColumn3}"
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
					sortOrder="#{inboxBean.watchPlanSortColumn.sortColumn4}"
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
					sortOrder="#{inboxBean.watchPlanSortColumn.sortColumn5}"
			filterValue="#{inboxBean.statusFilterP}"
			filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.statusFilterP)}"
			styleClass="valignTop">
			<f:facet name="header">
				<h:panelGroup>
					<h:commandLink id="cSta" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Status</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.watchPlanSortColumn.sortColumn5}" />
						<f:param name="sortColumnNo" value="5" />
						<f:param name="TablSort" value="watchPlan" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.statusFilterP}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="planningReqIPWlTable" />
					</h:inputText>
				</h:panelGroup>
			</f:facet>
			<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
		</rich:column>
		<rich:column sortBy="#{detail.actionUserDesc}" selfSorted="false"
						sortOrder="#{inboxBean.watchPlanSortColumn.sortColumn6}"
			filterValue="#{inboxBean.actionUserFilterP}"
			filterExpression="#{fn:containsIgnoreCase(detail.actionUserDesc,inboxBean.actionUserFilterP)}"
			styleClass="valignTop">
			<f:facet name="header">			
				 <h:panelGroup>
					<h:commandLink id="cStaa" rendered="true"
						action="#{inboxAction.indexSort}">
						<span class="contentform tableHeaderText"><strong>Action User</strong>
						</span>
						<f:param name="sortColumn" value="#{inboxBean.watchPlanSortColumn.sortColumn6}" />
						<f:param name="sortColumnNo" value="6" />
						<f:param name="TablSort" value="watchPlan" />
					</h:commandLink>
					<h:inputText value="#{inboxBean.actionUserFilterP}"
						style="width: 50px;">
						<a4j:support event="onblur" reRender="planningReqIPWlTable" />
					</h:inputText>
				</h:panelGroup>
			</f:facet>
			<h:outputText value="#{detail.actionUserDescDisply}" escape="false"
				styleClass="contentform"></h:outputText>
			<rich:toolTip showEvent="onclick" style="width:350px;"
				direction="bottom-left" mode="client" styleClass="tooltip"
				layout="block">
				<h:outputText value="#{detail.actionUserDesc}" escape="false" />
			</rich:toolTip>
		</rich:column>
		<f:facet name="footer">
			<rich:columnGroup>
				<rich:column colspan="7">
					<h:panelGroup style="float:left;">
						Total : <h:outputText
							value="#{fn:length(inboxBean.ipvWlPlanningReqList)}" /> records
					</h:panelGroup>
					<h:panelGroup style="float:right;">
						<rich:datascroller immediate="true" rendered="true" align="right"
							for="planningReqIPWlTable" maxPages="#{ipfmConfigBean.maxPage}"
							id="scrollPlanningReqIPWl" selectedStyleClass="selectScroll"
							stepControls="hide" fastControls="auto" boundaryControls="auto"
							fastStep="#{ipfmConfigBean.fastStepPage}"
							style="background-color: #cccccc;" />
					</h:panelGroup>
				</rich:column>
			</rich:columnGroup>
		</f:facet>
	</rich:dataTable>
</h:panelGroup>