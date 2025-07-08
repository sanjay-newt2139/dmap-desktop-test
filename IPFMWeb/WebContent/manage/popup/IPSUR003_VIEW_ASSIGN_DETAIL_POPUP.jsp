<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<a4j:jsFunction name="viewAssignDetail" 
	action="#{reqNWConfigAction.findAssignDateil}"
 	reRender="mdlAssignDetail"
 	oncomplete="Richfaces.showModalPanel('mdlAssignDetail');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>
<f:subview id="popupViewDetail"> 
<rich:modalPanel id="mdlAssignDetail" autosized="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Detail"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="mdlAssignDetail" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>
			<table border="0" width="100%">
				<tr>
					<td style="width:80px" align="right"><strong>UR Sub ID&nbsp;:&nbsp;</strong></td>
					<td align="left"><h:outputText value="#{networkConfigBean.firewall.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	

				
				<!-- Assign Table -->
				<rich:dataTable width="100%" id="tableAssignDetail" cellpadding="1" cellspacing="0" border="0"
					rows="5"
					rowClasses="odd,even" 
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.jobAssign}" var="assign">
					
					<rich:column width="35%"  filterValue="#{networkConfigBean.filterReqNWCPopupAS.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(assign.actionUser,networkConfigBean.filterReqNWCPopupAS.filterColumn1)}" style="vertical-align:top;">
						<f:facet name="header"> 
						
								  <h:panelGroup>
		 	<h:outputText value="Action By" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAS.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableAssignDetail" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<div align="left">
							<h:panelGrid columns="1">
								<h:outputText value="#{assign.actionUser}" />
							</h:panelGrid>	
						</div>
					</rich:column>
					
					<rich:column width="15%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Action Date" styleClass="contentform tableHeaderText"/>
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText value="#{assign.createDate}">						
								</h:outputText>
							</h:panelGrid>	
						</div>
					</rich:column>
					
					<rich:column width="25%"  filterValue="#{networkConfigBean.filterReqNWCPopupAS.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(assign.actionName,networkConfigBean.filterReqNWCPopupAS.filterColumn2)}"   style="vertical-align:top;">
						<f:facet name="header"> 
							
							  <h:panelGroup>
		 <h:outputText value="Job Status" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAS.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableAssignDetail" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<div align="center">
							<h:panelGrid columns="1">
								<h:outputText value="#{assign.actionName}" />
							</h:panelGrid>	
						</div>
					</rich:column>
					
					<rich:column width="25%"  filterValue="#{networkConfigBean.filterReqNWCPopupAS.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(assign.actionRemark,networkConfigBean.filterReqNWCPopupAS.filterColumn3)}"   style="vertical-align:top;">
						<f:facet name="header"> 							
								  <h:panelGroup>
	<h:outputText value="Remarks" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAS.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableAssignDetail" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<div align="left">
							<h:panelGrid columns="1">
								<h:outputText value="#{assign.actionRemark}" />
							</h:panelGrid>	
						</div>
					</rich:column>
					
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="2">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.jobAssign) }" /> records
							</rich:column>
							<rich:column colspan="10">
								<rich:datascroller immediate="true" rendered="true" align="right" for="tableAssignDetail"
									maxPages="5" id="assignDetailTable" selectedStyleClass="selectScroll"
									stepControls="hide" fastControls="hide" boundaryControls="hide" 
									style="background-color: #cccccc;"/>
							</rich:column>
						</rich:columnGroup>
					</f:facet>
				</rich:dataTable>
				
				<table width="100%" border="0" class="thtext_detail">
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.firewall.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Remarks&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" onkeydown="return limitText(this,1000)" onkeyup="return limitText(this,1000)"
								value="#{networkConfigBean.rejectRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				
				<h:panelGroup rendered="#{not networkConfigBean.isCompleteJob}">
						<tr class="displayRow">
							<td class="labelStyle" style="vertical-align:top;"><strong>Force Job Status&nbsp;:&nbsp;</strong>&nbsp;</td>
							<td class="valueStyle" colspan="3">
								<rich:comboBox id="portStatus" value="#{networkConfigBean.forceJobStatus}" itemClass="contentform"  
									style="text-align:left;width:145px" itemSelectedClass="contentform">
									<f:selectItem itemValue="Completed" />
								</rich:comboBox>
							</td>
						</tr>
				</h:panelGroup>
				</table>
				<div align="center">
					<h:panelGroup id="buttonGroup" >
						<a4j:commandButton id="btnOK_1" value="Ok" styleClass="rich-button" rendered="#{not networkConfigBean.isCompleteJob}"
							action="#{reqNWConfigAction.forceComplete}" reRender="policyTab,errorMsg" oncomplete="reloadTree(); navigateHomepage();" >
							 	<a4j:actionparam name="urNo" value="#{networkConfigBean.firewall.searchResult.id.urNo}"/>
 								<a4j:actionparam name="subUrNo" value="#{networkConfigBean.firewall.searchResult.id.subUrNo}"/>
 								<a4j:jsFunction name="navigateHomepage" action="#{reqNWConfigAction.navigateHomepage}" oncomplete="Richfaces.hideModalPanel('mdlAssignDetail');" />
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnOK_2" value="Ok" styleClass="rich-button" rendered="#{networkConfigBean.isCompleteJob}"  reRender="policyTab" >
							<rich:componentControl for="mdlAssignDetail" attachTo="btnOK_2" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
	
</rich:modalPanel>
</f:subview>
