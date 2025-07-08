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

.rich-panel-body1 {
	padding: 0px;
	background-color: #fafafa;
	background-image: url('');
	width: 100%;
}
-->
</style>
<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoUserReq01List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoUserReq01List[0].title2} (#{fn:length(inboxBean.ipvTodoUserReq01List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable id="userReqIPTable01" cellpadding="0" cellspacing="0" border="0" style="margin-bottom:0px;"
				var="detail" width="100%" value="#{inboxBean.ipvTodoUserReq01List}" reRender="scrollUserReqIP01"
				rows="#{ipfmConfigBean.rowPerPage}" columnClasses="" rowClasses="odd,even" styleClass="contentform"
				headerClass="tableHeader">
				<rich:column width="15%" selfSorted="false" sortOrder="#{inboxBean.sortTodoUser01.sortColumn1}"
					filterValue="#{inboxBean.filterTodoUser01urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoUser01urNo)}" sortBy="#{detail.urNo}"
					styleClass="valignTop" style="text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser01.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todouser01" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser01urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable01" />
							</h:inputText>
						</h:panelGroup>						
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column width="70%" selfSorted="false" sortOrder="#{inboxBean.sortTodoUser01.sortColumn2}"
					filterValue="#{inboxBean.filterTodoUser01subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoUser01subject)}"
					sortBy="#{detail.subject}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser01.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todouser01" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser01subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable01" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject01Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject01SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column width="15%" sortOrder="#{inboxBean.sortTodoUser01.sortColumn3}" sortBy="#{detail.created}"
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
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoUserReq01List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="userReqIPTable04"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollUserReqIP01" selectedStyleClass="selectScroll"
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

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoUserReq02List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoUserReq02List[0].title2} (#{fn:length(inboxBean.ipvTodoUserReq02List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="userReqIPTable02" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoUserReq02List}" reRender="scrollUserReqIP02"
				rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser02.sortColumn1}"
					filterValue="#{inboxBean.filterTodoUser02urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoUser02urNo)}" sortBy="#{detail.urNo}"
					styleClass="valignTop" style="width:95px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser02.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todouser02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser02urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser02.sortColumn2}"
					filterValue="#{inboxBean.filterTodoUser02subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoUser02subject)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser02.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todouser02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser02subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject02Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject02SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoUser02.sortColumn3}" sortBy="#{detail.reqDate}" styleClass="valignTop"
					style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser02.sortColumn4}"
					filterValue="#{inboxBean.filterTodoUser02status}"
					filterExpression="#{fn:containsIgnoreCase(detail.urStatus,inboxBean.filterTodoUser02status)}"
					sortBy="#{detail.urStatus}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Status</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser02.sortColumn4}" />
								<f:param name="sortColumnNo" value="4" />
								<f:param name="TablSort" value="todouser02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser02status}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.urStatus}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser02.sortColumn5}"
					filterValue="#{inboxBean.filterTodoUser02rejectBy}"
					filterExpression="#{fn:containsIgnoreCase(detail.createUserName,inboxBean.filterTodoUser02rejectBy)}"
					sortBy="#{detail.createUserName}"  styleClass="valignTop" style="width:200px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Reject By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser02.sortColumn5}" />
								<f:param name="sortColumnNo" value="5" />
								<f:param name="TablSort" value="todouser02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser02rejectBy}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.createUserName}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoUser02.sortColumn6}" sortBy="#{detail.created}" styleClass="valignTop"
					style="width:75px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Reject Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.created}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser02.sortColumn7}"
					filterValue="#{inboxBean.filterTodoUser02remarks}"
					filterExpression="#{fn:containsIgnoreCase(detail.userRemark,inboxBean.filterTodoUser02remarks)}"
					sortBy="#{detail.userRemark}"   styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Remarks</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser02.sortColumn7}" />
								<f:param name="sortColumnNo" value="7" />
								<f:param name="TablSort" value="todouser02" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser02remarks}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable02" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.userRemark}" styleClass="contentform"></h:outputText>
				</rich:column>
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="7">
							<h:panelGroup style="float:left;">
								Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoUserReq02List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="userReqIPTable02"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollUserReqIP02" selectedStyleClass="selectScroll"
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

<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoUserReq03List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoUserReq03List[0].title2} (#{fn:length(inboxBean.ipvTodoUserReq03List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="userReqIPTable03" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoUserReq03List}" reRender="scrollUserReqIP03"
				rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser03.sortColumn1}"
					filterValue="#{inboxBean.filterTodoUser03urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoUser03urNo)}" sortBy="#{detail.urNo}"
					styleClass="valignTop" style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser03.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="todouser03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser03urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable03" />
							</h:inputText>
						</h:panelGroup>						
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser03.sortColumn2}"
					filterValue="#{inboxBean.filterTodoUser03subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoUser03subject)}"
					sortBy="#{detail.subject}" styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser03.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="todouser03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser03subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject02Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject03SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser03.sortColumn3}"
					filterValue="#{inboxBean.filterTodoUser03requestBy}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoUser03requestBy)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser03.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="todouser03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser03requestBy}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable03" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoUser03.sortColumn4}" sortBy="#{detail.reqDate}" styleClass="valignTop"
					style="width:85px; text-align:center;">
					<f:facet name="header">						 
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoUser03.sortColumn5}" sortBy="#{detail.slaDate}" styleClass="valignTop"
					style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser03.sortColumn6}"
					filterValue="#{inboxBean.filterTodoUser03actionUser}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDesc,inboxBean.filterTodoUser03actionUser)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser03.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="todouser03" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser03actionUser}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable03" />
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
						<rich:column colspan="8">
							<h:panelGroup style="float:left;">
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoUserReq03List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="userReqIPTable03"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollUserReqIP03" selectedStyleClass="selectScroll"
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



<h:panelGroup rendered="#{fn:length(inboxBean.ipvTodoUserReq04List)>0}">
	<rich:spacer height="5" />
	<rich:panel style="margin:0px;" bodyClass="rich-panel-body1"
		header="#{inboxBean.ipvTodoUserReq04List[0].title2} (#{fn:length(inboxBean.ipvTodoUserReq04List)})">
		<h:panelGroup style="width:100%;">
			<rich:dataTable width="100%" id="userReqIPTable04" cellpadding="0" cellspacing="0" border="0"
				style="margin-bottom:0px;" var="detail" value="#{inboxBean.ipvTodoUserReq04List}" reRender="scrollUserReqIP02"
				rows="#{ipfmConfigBean.rowPerPage}" rowClasses="odd,even" styleClass="contentform" headerClass="tableHeader">
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.slaSts<0}" value="../images/ico_sla.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column styleClass="valignTop" style="width:17px; text-align:center;">
					<h:graphicImage rendered="#{detail.olaSts<0}" value="../images/ico_ola.gif" width="15" height="15"></h:graphicImage>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser04.sortColumn1}"
					filterValue="#{inboxBean.filterTodoUser04urNo}"
					filterExpression="#{fn:containsIgnoreCase(detail.urNo,inboxBean.filterTodoUser04urNo)}" sortBy="#{detail.urNo}"
					  styleClass="valignTop" style="width:80px; text-align:center;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>UR NO.</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser04.sortColumn1}" />
								<f:param name="sortColumnNo" value="1" />
								<f:param name="TablSort" value="TodoUser04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser04urNo}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable04" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<a4j:commandLink value="#{detail.urNo}" action="#{inboxAction.navigation}" styleClass="contentform">
						<f:param name="URNo" value="#{detail.urNo}" />
						<f:param name="MODE" value="#{detail.callMode}" />
						<f:param name="FuncID" value="#{detail.callFunctionId}" />
					</a4j:commandLink>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser04.sortColumn2}"
					filterValue="#{inboxBean.filterTodoUser04subject}"
					filterExpression="#{fn:containsIgnoreCase(detail.subject,inboxBean.filterTodoUser04subject)}"
					sortBy="#{detail.subject}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Subject</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser04.sortColumn2}" />
								<f:param name="sortColumnNo" value="2" />
								<f:param name="TablSort" value="TodoUser04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser04subject}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable04" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<rich:toolTip showEvent="onclick" style="width:350px;" direction="bottom-left" mode="client" styleClass="tooltip"
						layout="block">
						<h:outputText value="#{detail.subject02Desc}" escape="false" />
					</rich:toolTip>
					<h:outputText value="#{detail.subject04SubStr}" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser04.sortColumn3}"
					filterValue="#{inboxBean.filterTodoUser04requestBy}"
					filterExpression="#{fn:containsIgnoreCase(detail.reqUser,inboxBean.filterTodoUser04requestBy)}"
					sortBy="#{detail.reqUser}"  styleClass="valignTop" style="width:150px;">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Request By</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser04.sortColumn3}" />
								<f:param name="sortColumnNo" value="3" />
								<f:param name="TablSort" value="TodoUser04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser04requestBy}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable04" />
							</h:inputText>
						</h:panelGroup>
					</f:facet>
					<h:outputText value="#{detail.reqUser}" escape="false" styleClass="contentform"></h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoUser04.sortColumn4}" sortBy="#{detail.reqDate}" styleClass="valignTop"
					style="width:85px; text-align:center;">
					<f:facet name="header">						 
						<h:outputText value="Request Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.reqDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
					</h:outputText>
				</rich:column>
				<rich:column sortOrder="#{inboxBean.sortTodoUser04.sortColumn5}" sortBy="#{detail.slaDate}" styleClass="valignTop"
					style="width:85px; text-align:center;">
					<f:facet name="header">						
						<h:outputText value="Plan To Finish" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{detail.slaDate}" styleClass="contentform">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>
				<rich:column selfSorted="false" sortOrder="#{inboxBean.sortTodoUser04.sortColumn6}"
					filterValue="#{inboxBean.filterTodoUser04actionUser}"
					filterExpression="#{fn:containsIgnoreCase(detail.actionUserDesc,inboxBean.filterTodoUser04actionUser)}"
					sortBy="#{detail.actionUserDesc}"  styleClass="valignTop">
					<f:facet name="header">
						<h:panelGroup>
							<h:commandLink rendered="true" action="#{inboxAction.indexSort}">
								<span class="contentform tableHeaderText"><strong>Action User</strong>
								</span>
								<f:param name="sortColumn" value="#{inboxBean.sortTodoUser04.sortColumn6}" />
								<f:param name="sortColumnNo" value="6" />
								<f:param name="TablSort" value="TodoUser04" />
							</h:commandLink>
							<h:inputText value="#{inboxBean.filterTodoUser04actionUser}" style="width: 50px;">
								<a4j:support event="onblur" reRender="userReqIPTable04" />
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
							Total : <h:outputText value="#{fn:length(inboxBean.ipvTodoUserReq04List)}" /> records
							</h:panelGroup>
							<h:panelGroup style="float:right;">
								<rich:datascroller immediate="true" rendered="true" align="right" for="userReqIPTable04"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollUserReqIP04" selectedStyleClass="selectScroll"
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
