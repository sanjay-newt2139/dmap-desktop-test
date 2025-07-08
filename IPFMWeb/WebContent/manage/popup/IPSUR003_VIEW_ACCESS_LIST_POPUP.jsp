<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<a4j:jsFunction name="viewUrAccessCDN" 
	action="#{configAccessListAction.findSubUr}"
 	reRender="ViewCDN"
 	oncomplete="Richfaces.showModalPanel('ViewCDN');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<f:subview id="popupViewAccessList"> 
<rich:modalPanel id="ViewCDN" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Access List for CDN"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewCDN" attachTo="hidelink" operation="hide" event="onclick"/>
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
					<td align="left"><h:outputText value="#{networkConfigBean.accessList.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	
			<rich:dataTable width="100%" id="AccessListTable" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.accessList.searchResult}" var="cdn">
				
				<rich:column width="50%"  filterValue="#{networkConfigBean.filterReqNWCPopupAL.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(cdn.sourceIp,networkConfigBean.filterReqNWCPopupAL.filterColumn1)}"  >
					<f:facet name="header">
					
						  <h:panelGroup>
		 	<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAL.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="50%"  filterValue="#{networkConfigBean.filterReqNWCPopupAL.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(cdn.destIp,networkConfigBean.filterReqNWCPopupAL.filterColumn2)}"  >
					<f:facet name="header">
				
						  <h:panelGroup>
		 		<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAL.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				</rich:dataTable>
				<rich:dataTable width="100%" id="tableDetailAccessList" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.accessList.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupAL.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupAL.filterColumn3)}"   style="vertical-align:top;">
						<f:facet name="header">
							
							 <h:panelGroup>
		 	<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAL.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailAccessList" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionUser}"/>
					</rich:column>
					<rich:column style="vertical-align:top; text-align:center;">
						<f:facet name="header">
							<h:outputText value="Assign Date" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:outputText value="#{detail.createDate}">
							<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
						</h:outputText>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupAL.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupAL.filterColumn4)}"  style="vertical-align:top;">
						<f:facet name="header">
					
							 <h:panelGroup>
			<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAL.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailAccessList" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupAL.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupAL.filterColumn5)}"    style="vertical-align:top;">
						<f:facet name="header">							
							 <h:panelGroup>
			<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupAL.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailAccessList" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.accessList.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailAccessList" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTableDetailAccessList" selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
										style="background-color: #cccccc;"/>
								</h:panelGroup>												
							</rich:column>
						</rich:columnGroup>	
					</f:facet>
				</rich:dataTable>
				<%/* 
				<table width="100%" border="0" class="thtext_detail">
					<tr class="tableHeader">
						<td align="center"><span class="contentform tableHeaderText"><strong>Assign To</strong></span></td>
						<td align="center"><span class="contentform tableHeaderText"><strong>Assign Date</strong></span></td>
						<td align="center"><span class="contentform tableHeaderText"><strong>Job Status</strong></span></td>
						<td align="center"><span class="contentform tableHeaderText"><strong>Remarks</strong></span></td>
					</tr>
					
					<tr class="odd">
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessList.jobAssign.actionUser}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessList.jobAssign.createDate}">								
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessList.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessList.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.accessList.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewCDN" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
