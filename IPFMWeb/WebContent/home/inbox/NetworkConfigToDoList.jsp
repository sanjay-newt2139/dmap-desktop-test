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
.rich-panel-body1 {
	padding: 0px;
	background-color: #fafafa;
	background-image: url('');
	width: 100%;
}

.rich-filter-input {
	width: 80px;
}
-->
</style>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC01List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC01List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC01List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable01" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC01List}" reRender="scrollReqNc01" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column width="15%" selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC01.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC01.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC01.filterColumn1)}"
					sortBy="#{detail.urNo}"   styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC01.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC01" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC01.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column width="70%" selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC01.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC01.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC01.filterColumn2)}"
					sortBy="#{detail.subject}"   styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC01.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC01" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC01.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column width="15%"   sortOrder="#{inboxBean.sortTodoReqNC01.sortColumn3}"					
					sortBy="#{detail.created}" styleClass="valignTop" style="text-align:center;">
					<f:facet name="header">						 
						<h:outputText value="Create Date" styleClass="contentform tableHeaderText" />
					</f:facet>
					<t:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</t:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC01List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable01"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc01" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC02MrgList)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC02MrgList[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC02MrgList)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable02" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC02MrgList}" reRender="scrollReqNc02" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC02Mrg.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC02Mrg.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Mrg.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC02Mrg" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Mrg.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC02Mrg.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC02Mrg.filterColumn2)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:200px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Mrg.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC02Mrg" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Mrg.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn3}"					
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC02Mrg.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoReqNC02Mrg.filterColumn4)}"
					sortBy="#{detail.urStatus}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Mrg.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC02Mrg" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Mrg.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn5}"
					filterValue="#{inboxBean.filterTodoReqNC02Mrg.filterColumn5}"
					filterExpression="#{fn:containsIgnoreCase(detail.createUserName,inboxBean.filterTodoReqNC02Mrg.filterColumn5)}"
					sortBy="#{detail.createUserName}"  styleClass="valignTop" style="width:200px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Reject By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Mrg.sortColumn4}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todoReqNC02Mrg" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Mrg.filterColumn5}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.createUserName}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn6}"					
					sortBy="#{detail.created}" styleClass="valignTop" style="width:75px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Reject Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Mrg.sortColumn7}"
					filterValue="#{inboxBean.filterTodoReqNC02Mrg.filterColumn7}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC02Mrg.filterColumn7)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Mrg.sortColumn7}" />
								<f:param name="sortColumnNo" value="7" />
								<f:param name="TablSort" value="todoReqNC02Mrg" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Mrg.filterColumn7}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="9">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC02MrgList)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable02"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc02" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC02OwnerList)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC02OwnerList[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC02OwnerList)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable02Owner" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoReqNC02OwnerList}" reRender="scrollReqNc02Owner"
				rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC02Owner.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC02Owner.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Owner.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC02Owner" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Owner.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02Owner" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC02Owner.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC02Owner.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Owner.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC02Owner" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Owner.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02Owner" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC02Owner.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC02Owner.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:200px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Owner.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC02Owner" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Owner.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02Owner" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn4}"					
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn5}"
					filterValue="#{inboxBean.filterTodoReqNC02Owner.filterColumn5}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoReqNC02Owner.filterColumn5)}"
					sortBy="#{detail.urStatus}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Owner.sortColumn5}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todoReqNC02Owner" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Owner.filterColumn5}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02Owner" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn6}"
					filterValue="#{inboxBean.filterTodoReqNC02Owner.filterColumn6}"
					filterExpression="#{fn:containsIgnoreCase(detail.createUserName,inboxBean.filterTodoReqNC02Owner.filterColumn6)}"
					sortBy="#{detail.createUserName}"  styleClass="valignTop" style="width:200px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Reject By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Owner.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoReqNC02Owner" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Owner.filterColumn6}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable02Owner" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.createUserName}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn7}"
					sortBy="#{detail.created}" styleClass="valignTop" style="width:75px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Reject Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC02Owner.sortColumn8}"
					filterValue="#{inboxBean.filterTodoReqNC02Owner.filterColumn8}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC02Owner.filterColumn8)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC02Owner.sortColumn8}" />
								<f:param name="sortColumnNo" value="8" />
								<f:param name="TablSort" value="todoReqNC02Owner" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC02Owner.filterColumn8}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="9">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC02OwnerList)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable02Owner"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc02Owner" selectedStyleClass="selectScroll"
									stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC03List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC03List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC03List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable03" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC03List}" reRender="scrollReqNc03" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC03.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC03.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC03.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC03.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC03.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC03.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC03.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC03.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC03.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC03.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC03.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC03.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC03.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoReqNC03.filterColumn4)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC03.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC03.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn5}"
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn6}"
					sortBy="#{detail.slaDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC03.sortColumn7}"
					filterValue="#{inboxBean.filterTodoReqNC03.filterColumn7}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDesc,inboxBean.filterTodoReqNC03.filterColumn7)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC03.sortColumn7}" />
								<f:param name="sortColumnNo" value="7" />
								<f:param name="TablSort" value="todoReqNC03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC03.filterColumn7}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="10">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC03List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable03"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc03" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC05List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC05List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC05List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable05" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC05List}" reRender="scrollReqNc05" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC05.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC05.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC05.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC05.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC05" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC05.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable05" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC05.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC05.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC05.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC05.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC05" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC05.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable05" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC05.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC05.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC05.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC05.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC05" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC05.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable05" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC05.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC05.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoReqNC05.filterColumn4)}"
					sortBy="#{detail.urStatus}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC05.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC05" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC05.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable05" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC05.sortColumn5}"
					sortBy="#{detail.created}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Finish Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC05.sortColumn5}"
					filterValue="#{inboxBean.filterTodoReqNC05.filterColumn5}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC05.filterColumn5)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC05.sortColumn5}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todoReqNC05" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC05.filterColumn5}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="7">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC05List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable05"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc05" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC11List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC11List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC11List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable11" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC11List}" reRender="scrollReqNc05" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC11.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC11.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC11.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC11.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC11" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC11.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable05" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC11.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC11.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC11.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC11.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC11" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC11.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable11" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC11.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC11.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC11.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC11.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC11" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC11.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable11" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC11.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC11.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoReqNC11.filterColumn4)}"
					sortBy="#{detail.urStatus}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC11.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC11" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC11.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable11" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC11.sortColumn5}"
					sortBy="#{detail.created}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Finish Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC11.sortColumn6}"
					filterValue="#{inboxBean.filterTodoReqNC11.filterColumn6}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC11.filterColumn6)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC11.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoReqNC11" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC11.filterColumn6}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable11" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="7">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC11List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable05"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc11" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>


<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC12List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC12List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC12List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable12" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC12List}" reRender="scrollReqNc05" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC12.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC12.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC12.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC12.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC12" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC12.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable12" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC12.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC12.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC12.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC12.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC12" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC12.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable12" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC12.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC12.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoReqNC12.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC12.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC12" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC12.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable12" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC12.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC12.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoReqNC12.filterColumn4)}"
					sortBy="#{detail.urStatus}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC12.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC12" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC12.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable12" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC12.sortColumn5}"
					sortBy="#{detail.created}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Finish Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC12.sortColumn6}"
					filterValue="#{inboxBean.filterTodoReqNC12.filterColumn6}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC12.filterColumn6)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC12.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoReqNC12" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC12.filterColumn6}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable12" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="7">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC12List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable05"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc12" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>


<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC06List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC06List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC06List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable06" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC06List}" reRender="scrollReqNc06" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC06.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC06.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC06.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC06" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC06.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable06" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC06.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC06.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC06.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC06" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC06.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable06" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC06.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC06.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC06.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC06" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC06.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable06" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC06.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoReqNC06.filterColumn4)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC06.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC06" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC06.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable06" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn5}"
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						 
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn6}"
					sortBy="#{detail.slaDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">					
						<h:outputText value="Plan To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC06.sortColumn7}"
					filterValue="#{inboxBean.filterTodoReqNC06.filterColumn7}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDescDisply,inboxBean.filterTodoReqNC06.filterColumn7)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC06.sortColumn7}" />
								<f:param name="sortColumnNo" value="7" />
								<f:param name="TablSort" value="todoReqNC06" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC06.filterColumn7}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable06" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="10">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC06List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable06"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc06" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC07List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC07List[0].title2Ur} (#{fn:length(inboxBean.ipvTodoReqNC07List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable07" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC07List}" reRender="scrollReqNc07" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC07.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC07.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC07.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC07" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC07.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable07" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC07.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC07.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC07.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC07" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC07.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable07" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC07.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoReqNC07.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC07.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC07" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC07.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable07" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC07.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoReqNC07.filterColumn4)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC07.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC07" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC07.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable07" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn5}"
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn6}"
					sortBy="#{detail.slaDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column 
					sortBy="#{detail.waitingPm}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Waiting for PM Assign" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.waitingPm}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC07.sortColumn7}"
					filterValue="#{inboxBean.filterTodoReqNC07.filterColumn6}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDescDisply,inboxBean.filterTodoReqNC07.filterColumn6)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC07.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoReqNC07" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC07.filterColumn6}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable07" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="10">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC07List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable07"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc07" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC08List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC08List[0].title2SubUr} (#{fn:length(inboxBean.ipvTodoReqNC08List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable08" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC08List}" reRender="scrollReqNc08" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC08.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="SUBURNo" value="#{detail.subUrNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC08.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC08.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.createUserName,inboxBean.filterTodoReqNC08.filterColumn4)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Reject By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.createUserName}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn5}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn5}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqDate,inboxBean.filterTodoReqNC08.filterColumn5)}"
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Reject Date</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn5}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn5}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.createdBy}" styleClass="contentform">
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn6}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn6}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC08.filterColumn6)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn6}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn7}"
					sortBy="#{detail.slaDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan<br>To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC08.sortColumn8}"
					filterValue="#{inboxBean.filterTodoReqNC08.filterColumn8}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDescDisply,inboxBean.filterTodoReqNC08.filterColumn8)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC08.sortColumn8}" />
								<f:param name="sortColumnNo" value="8" />
								<f:param name="TablSort" value="todoReqNC08" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC08.filterColumn8}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable08" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="10">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC08List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable08"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc08" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC09List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC09List[0].title2SubUr} (#{fn:length(inboxBean.ipvTodoReqNC09List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable09" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC09List}" reRender="scrollReqNc09" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC09.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC09.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC09.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC09" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC09.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable09" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="SUBURNo" value="#{detail.subUrNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC09.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC09.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Sub<br>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC09.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC09" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC09.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable09" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC09.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC09.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC09.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC09" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC09.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable09" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC09.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoReqNC09.filterColumn4)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC09.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC09" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC09.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable09" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn5}"
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column  sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn6}"
					sortBy="#{detail.created}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="PM Raise<br>Impact Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn7}"
					sortBy="#{detail.slaDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan<br>To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC09.sortColumn8}"
					filterValue="#{inboxBean.filterTodoReqNC09.filterColumn8}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDescDisply,inboxBean.filterTodoReqNC09.filterColumn8)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC09.sortColumn8}" />
								<f:param name="sortColumnNo" value="8" />
								<f:param name="TablSort" value="todoReqNC09" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC09.filterColumn8}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable09" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="10">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC09List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable09"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollReqNc09" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoReqNC10List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoReqNC10List[0].title2SubUr} (#{fn:length(inboxBean.ipvTodoReqNC10List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="reqNcTable10" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" value="#{inboxBean.ipvTodoReqNC10List}" reRender="scrollReqNc10" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn1}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn1}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoReqNC10.filterColumn1)}"
					sortBy="#{detail.urNo}"  styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn1}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="SUBURNo" value="#{detail.subUrNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn2}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn2}"
					filterExpression="#{fn:containsIgnoreCase(detail.subUrNo,inboxBean.filterTodoReqNC10.filterColumn2)}"
					sortBy="#{detail.subUrNo}"  styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>SubUR<br>NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn2}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.subUrNo}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn3}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn3}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoReqNC10.filterColumn3)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn3}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn4}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn4}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoReqNC10.filterColumn4)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request<br>By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn4}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn5}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn5}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqDateStr,inboxBean.filterTodoReqNC10.filterColumn5)}"
					sortBy="#{detail.reqDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request<br>Date</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn5}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn5}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqDateStr}" styleClass="contentform">
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn6}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn6}"
					filterExpression="#{fn:containsIgnoreCase(detail.createdStr,inboxBean.filterTodoReqNC10.filterColumn6)}"
					sortBy="#{detail.created}" styleClass="valignTop" style="width:110px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>PM Assign Date<br>ACTM Finish Date</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn6}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.createdStr}" styleClass="contentform">

					</h:outputText>
				</rich:column>
				<rich:column   sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn7}"
					sortBy="#{detail.slaDate}" styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan To<br>Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn8}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn8}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoReqNC10.filterColumn8)}"
					sortBy="#{detail.userRemark}"  styleClass="valignTop"
					style="width:85px; text-align:left;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn8}" />
								<f:param name="sortColumnNo" value="8" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn8}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform" />
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoReqNC10.sortColumn9}"
					filterValue="#{inboxBean.filterTodoReqNC10.filterColumn9}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDescDisply,inboxBean.filterTodoReqNC10.filterColumn9)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action<br>User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoReqNC10.sortColumn9}" />
								<f:param name="sortColumnNo" value="9" />
								<f:param name="TablSort" value="todoReqNC10" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoReqNC10.filterColumn9}" style="width: 50px;">
								<a4j:support event="onblur" reRender="reqNcTable10" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="11">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoReqNC10List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="reqNcTable10"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollreqNc10" selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;" />
							</h:panelGroup>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</h:panelGroup>
	</rich:panel>
</h:panelGroup>