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
<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoPlanningReq01List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoPlanningReq01List[0].title2} (#{fn:length(inboxBean.ipvTodoPlanningReq01List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="planningReqIPTable01" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoPlanningReq01List}"
				reRender="scrollPlanningReqIP01" rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform"
				headerClass="tableHeader">
				<rich:column width="15%" sortBy="#{detail.urNo}" selfSorted="false"
					sortOrder="#{inboxBean.sortTodoPlan01.sortColumn1}" filterValue="#{inboxBean.filterTodoPlan01urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoPlan01urNo)}" styleClass="valignTop"
					style="text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR No.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan01.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoplan01" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan01urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column width="70%" sortBy="#{detail.subject}" selfSorted="false"
					sortOrder="#{inboxBean.sortTodoPlan01.sortColumn2}" filterValue="#{inboxBean.filterTodoPlan01subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject01SubStr,inboxBean.filterTodoPlan01subject)}"
					styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan01.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoplan01" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan01subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column width="15%" sortBy="#{detail.created}" sortOrder="#{inboxBean.sortTodoPlan01.sortColumn3}"
					styleClass="valignTop" style="text-align:center;">
					<f:facet name="header">
						<h:outputText value="Create Date" styleClass="contentform tableHeaderText" />
					</f:facet>
					<t:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</t:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoPlanningReq01List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="planningReqIPTable01"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollPlanningReqIP01" selectedStyleClass="selectScroll"
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

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoPlanningReq02List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoPlanningReq02List[0].title2} (#{fn:length(inboxBean.ipvTodoPlanningReq02List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="planningReqIPTable02" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoPlanningReq02List}"
				reRender="scrollPlanningReqIP02" rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform"
				headerClass="tableHeader">
				<rich:column sortBy="#{detail.urNo}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn1}"  filterValue="#{inboxBean.filterTodoPlan02urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoPlan02urNo)}"   styleClass="valignTop"
					style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR No.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan02.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoplan02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan02urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable02" />
							</h:inputText>
						</h:panelGroup>						
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column sortBy="#{detail.subject}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn2}"  filterValue="#{inboxBean.filterTodoPlan02subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoPlan02subject)}" styleClass="valignTop" style="width:200px;">
					<f:facet name="header">						
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan02.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoplan02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan02subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable02" />
							</h:inputText>
						</h:panelGroup>								
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.reqDate}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn3}"     styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.urStatus}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn4}"  filterValue="#{inboxBean.filterTodoPlan02status}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoPlan02status)}"   styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan02.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todoplan02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan02status}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable02" />
							</h:inputText>
						</h:panelGroup>			
						
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.createUserName}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn5}"  filterValue="#{inboxBean.filterTodoPlan02rejectBy}"
					filterExpression="#{fn:containsIgnoreCase(detail.createUserName,inboxBean.filterTodoPlan02rejectBy)}" styleClass="valignTop"
					style="width:200px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Reject By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan02.sortColumn5}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todoplan02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan02rejectBy}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable02" />
							</h:inputText>
						</h:panelGroup>		
						
					</f:facet>
					<h:outputText value="#{detail.createUserName}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.created}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn6}"     styleClass="valignTop" style="width:75px; text-align:center;">
					<f:facet name="header">
						<h:outputText value="Reject Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.userRemark}"  selfSorted="false" 
						 sortOrder="#{inboxBean.sortTodoPlan02.sortColumn7}"  filterValue="#{inboxBean.filterTodoPlan02remarks}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoPlan02remarks)}"   styleClass="valignTop"
					style="width:150px;">
					<f:facet name="header">						
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan02.sortColumn7}" />
								<f:param name="sortColumnNo" value="7" />
								<f:param name="TablSort" value="todoplan02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan02remarks}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable02" />
							</h:inputText>
						</h:panelGroup>		
						
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="7">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoPlanningReq02List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="planningReqIPTable02"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollPlanningReqIP02" selectedStyleClass="selectScroll"
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

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoPlanningReq04List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoPlanningReq04List[0].title2} (#{fn:length(inboxBean.ipvTodoPlanningReq04List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="planningReqIPTable04" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoPlanningReq04List}"
				reRender="scrollPlanningReqIP02" rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform"
				headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column sortBy="#{detail.urNo}"  selfSorted="false"
					sortOrder="#{inboxBean.sortTodoPlan04.sortColumn1}" filterValue="#{inboxBean.filterTodoPlan04urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoPlan04urNo)}"  styleClass="valignTop" style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR No.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan04.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todoplan04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan04urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable04" />
							</h:inputText>
						</h:panelGroup>			
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column sortBy="#{detail.subject}"  selfSorted="false"
					sortOrder="#{inboxBean.sortTodoPlan04.sortColumn2}" filterValue="#{inboxBean.filterTodoPlan04subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoPlan04subject)}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header"> 
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan04.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todoplan04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan04subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable04" />
							</h:inputText>
						</h:panelGroup>		
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.reqUser}"  selfSorted="false"
					sortOrder="#{inboxBean.sortTodoPlan04.sortColumn3}" filterValue="#{inboxBean.filterTodoPlan04requestBy}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoPlan04requestBy)}" styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan04.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todoplan04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan04requestBy}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable04" />
							</h:inputText>
						</h:panelGroup>							 
					</f:facet>
					<h:outputText value="#{detail.reqUser}" escape="false" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.reqDate}"  
					sortOrder="#{inboxBean.sortTodoPlan04.sortColumn4}"   styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.slaDate}"   
					sortOrder="#{inboxBean.sortTodoPlan04.sortColumn5}"   styleClass="valignTop" style="width:85px; text-align:center;">
					<f:facet name="header">
						<h:outputText value="Plan To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column sortBy="#{detail.actionUserDesc}"  selfSorted="false"
					sortOrder="#{inboxBean.sortTodoPlan04.sortColumn6}" filterValue="#{inboxBean.filterTodoPlan04actionUser}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDesc,inboxBean.filterTodoPlan04actionUser)}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoPlan04.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todoplan04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoPlan04actionUser}" style="width: 50px;">
								<a4j:support event="onblur" reRender="planningReqIPTable04" />
							</h:inputText>
						</h:panelGroup>	
					</f:facet>
					<h:outputText value="#{detail.actionUserDescDisply}" escape="false" styleClass="contentform"></h:outputText>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.actionUserDesc}" escape="false" />
					</rich:toolTip>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="8">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoPlanningReq04List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="planningReqIPTable04"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollPlanningReqIP04" selectedStyleClass="selectScroll"
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