<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<a4j:jsFunction name="viewUrAccessTNP" 
	action="#{configAccessListTNPAction.findSubUr}"
 	reRender="ViewTNP"
 	oncomplete="Richfaces.showModalPanel('ViewTNP');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<f:subview id="popupViewAccessListTNP"> 
<rich:modalPanel id="ViewTNP" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Access List for TNP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewTNP" attachTo="hidelink" operation="hide" event="onclick"/>
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
					<td align="left"><h:outputText value="#{networkConfigBean.accessListTNP.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	
			<rich:dataTable width="100%" id="AccessTNPTable" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.accessListTNP.searchResult}" var="tnp">

				<rich:column width="25%"  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(tnp.sourceIp,networkConfigBean.filterReqNWCPopupTNP.filterColumn1)}"  style="vertical-align:top;">
					<f:facet name="header">
						
						 	  <h:panelGroup>
		 <h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessTNPTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceHostName}" />
						<h:outputText value="Location:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceLocationName}" />
						<h:outputText value="Network IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceNetworkIp}" />
						<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceInterNode}" />
						<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceInterNw}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="25%"  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(tnp.destIp,networkConfigBean.filterReqNWCPopupTNP.filterColumn2)}"   style="vertical-align:top;">
					<f:facet name="header">						
						  <h:panelGroup>
	<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessTNPTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destHostName}" />
						<h:outputText value="Location:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destLocationName}" />
						<h:outputText value="Network IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destNetworkIp}" />
						<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destInterNode}" />
						<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destInterNw}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="25%"  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(tnp.description,networkConfigBean.filterReqNWCPopupTNP.filterColumn3)}"  >
					<f:facet name="header">					
						  <h:panelGroup>
	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessTNPTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.description}"/>
					</div>
				</rich:column>
				<rich:column width="25%"  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(tnp.reqImpact,networkConfigBean.filterReqNWCPopupTNP.filterColumn4)}"  >
					<f:facet name="header">					
						  <h:panelGroup>
	<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="AccessTNPTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea style="width:100%;height:100%;" rows="7" readonly="true" value="#{tnp.reqImpact}"/>
					</div>
				</rich:column>
			</rich:dataTable>
			<rich:dataTable width="100%" id="tableDetailAccessListTNP" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.accessListTNP.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupTNP.filterColumn5)}"   style="vertical-align:top;">
						<f:facet name="header">
						
							 <h:panelGroup>
	<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailAccessListTNP" />
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
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupTNP.filterColumn6)}"  style="vertical-align:top;">
						<f:facet name="header"> 
						
							 <h:panelGroup>
<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailAccessListTNP" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupTNP.filterColumn7)}"   style="vertical-align:top;">
						<f:facet name="header"> 
											
							 <h:panelGroup>
	<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupTNP.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailAccessListTNP" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.accessListTNP.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailAccessListTNP" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTableDetailAccessListTNP" selectedStyleClass="selectScroll"
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
							<h:outputText value="#{networkConfigBean.accessListTNP.jobAssign.actionUser}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessListTNP.jobAssign.createDate}">
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessListTNP.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.accessListTNP.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.accessListTNP.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewTNP" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
