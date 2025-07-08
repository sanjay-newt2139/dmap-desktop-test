<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>
<f:loadBundle basename="resources.application" var="msg" />
<a4j:jsFunction name="alertErrorMsg" 
	action="#{homepageAction.alertErrorMsg}"
 	reRender="errorMsg">
 	<a4j:actionparam name="errorMessage"/>
</a4j:jsFunction>

<a4j:jsFunction name="viewUrFirewall" 
	action="#{configFirewallAction.findSubUr}"
 	reRender="ViewFirewall"
 	oncomplete="Richfaces.showModalPanel('ViewFirewall');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>
<f:subview id="popupViewFirewall"> 
<rich:modalPanel id="ViewFirewall" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Firewall"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewFirewall" attachTo="hidelink" operation="hide" event="onclick"/>
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
			<rich:dataTable width="100%" id="tableAddFirewall" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" 
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.firewall.searchResult}" var="firewall">
					
					<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupFW.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(firewall.sourceIp,networkConfigBean.filterReqNWCPopupFW.filterColumn1)}"  >
						<f:facet name="header">
						
								  <h:panelGroup>
		 	<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupFW.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableAddFirewall" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="2">
							<h:outputText value="IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceIp}" />
						    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceHostName}" />
							<h:outputText value="email:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceEmail}" />
							<h:outputText value="VIP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceVip}" />
							<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceNatIp}" />
						</h:panelGrid>
					</rich:column>
					<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupFW.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(firewall.destIp,networkConfigBean.filterReqNWCPopupFW.filterColumn2)}"  >
						<f:facet name="header">
							
							 <h:panelGroup>
	<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupFW.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableAddFirewall" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="2">
							<h:outputText value="IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destIp}" />
							<h:outputText value="Host Name:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destHostName}" />
							<h:outputText value="email:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destEmail}" />
							<h:outputText value="VIP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destVip}" />
							<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destNatIp}" />
						</h:panelGrid>
					</rich:column>
					<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupFW.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(firewall.serviceName,networkConfigBean.filterReqNWCPopupFW.filterColumn3)}"   style="vertical-align:top;">
						<f:facet name="header">
							
							 <h:panelGroup>
<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupFW.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableAddFirewall" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:panelGrid columns="2">
							<h:outputText value="TCP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceTcpPort}" />
							<h:outputText value="UDP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceUdpPort}" />
							<h:outputText value="Service:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceName}" />
						</h:panelGrid>
					</rich:column>
				</rich:dataTable>
				
				
				<rich:dataTable width="100%" id="tableDetailFirewall" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.firewall.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupFW.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupFW.filterColumn4)}"   style="vertical-align:top;">
						<f:facet name="header">
							
							 <h:panelGroup>
<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupFW.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailFirewall" />
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
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupFW.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupFW.filterColumn5)}"   style="vertical-align:top;">
						<f:facet name="header">
						
								
							 <h:panelGroup>
	<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupFW.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailFirewall" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupFW.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupFW.filterColumn6)}"   style="vertical-align:top;">
						<f:facet name="header"> 
							 <h:panelGroup>
		<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupFW.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailFirewall" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.firewall.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailFirewall" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
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
							<h:outputText value="#{networkConfigBean.firewall.jobAssign.actionUser}"/>
						</td>
						<td align="center">&nbsp;
							<h:outputText value="#{networkConfigBean.firewall.jobAssign.createDate}">
								<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.firewall.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.firewall.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.firewall.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewFirewall" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>

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




















<a4j:jsFunction name="viewUrPhyInterface" 
	action="#{configPhyInterface.findSubUr}"
 	reRender="ViewPhyInterface"
 	oncomplete="Richfaces.showModalPanel('ViewPhyInterface');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<f:subview id="popupPhyInterface"> 
<rich:modalPanel id="ViewPhyInterface" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Physical Interface"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewPhyInterface" attachTo="hidelink" operation="hide" event="onclick"/>
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
					<td align="left"><h:outputText value="#{networkConfigBean.phyInterface.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	
			<rich:dataTable width="100%" id="PhysicalTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.phyInterface.searchResult}" var="physical">
					
				<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupPI.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(physical.ipNode,networkConfigBean.filterReqNWCPopupPI.filterColumn1)}"   style="vertical-align:top;">
					<f:facet name="header">
						
							  <h:panelGroup>
		 <h:outputText value="IP Address/Mask" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupPI.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupPI.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(physical.interfaceNodeDesc,networkConfigBean.filterReqNWCPopupPI.filterColumn2)}"   style="vertical-align:top;">
					<f:facet name="header">
				
						  <h:panelGroup>
		 		<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupPI.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						 <h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						 <h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						 <h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						 <h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						 <h:outputText value="#{fn:substring(physical.interfaceDesc,0,150)}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupPI.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(physical.reqRemarks,networkConfigBean.filterReqNWCPopupPI.filterColumn3)}"   style="vertical-align:top;">
					<f:facet name="header">
					
						  <h:panelGroup>
		 		<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupPI.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="PhysicalTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:outputText value="#{physical.reqRemarks}" />
				</rich:column>
				
			</rich:dataTable>
			
			<rich:dataTable width="100%" id="tableDetailphyInterface" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.phyInterface.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupPI.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupPI.filterColumn4)}"  style="vertical-align:top;">
						<f:facet name="header">
					
							  <h:panelGroup>
			<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupPI.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailphyInterface" />
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
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupPI.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupPI.filterColumn5)}"  style="vertical-align:top;">
						<f:facet name="header">							
							  <h:panelGroup>
<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupPI.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailphyInterface" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupPI.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupPI.filterColumn6)}"  style="vertical-align:top;">
						<f:facet name="header">
					
							  <h:panelGroup>
		<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupPI.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailphyInterface" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.phyInterface.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailphyInterface" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTablephyInterface" selectedStyleClass="selectScroll"
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
							<h:outputText value="#{networkConfigBean.phyInterface.jobAssign.actionUser}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.phyInterface.jobAssign.createDate}">
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.phyInterface.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.phyInterface.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.phyInterface.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewPhyInterface" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>













<a4j:jsFunction name="viewUrGateway" 
	action="#{configIntfGateway.findSubUr}"
 	reRender="ViewGateway"
 	oncomplete="Richfaces.showModalPanel('ViewGateway');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<f:subview id="popupViewGateway"> 
<rich:modalPanel id="ViewGateway" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Interface Gateway"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewGateway" attachTo="hidelink" operation="hide" event="onclick"/>
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
					<td align="left"><h:outputText value="#{networkConfigBean.gateway.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	
			<rich:dataTable width="100%" id="GatewayTable" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.gateway.searchResult}" var="gateway">
				<rich:column width="20%"  filterValue="#{networkConfigBean.filterReqNWCPopupGW.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(gateway.ipAddress,networkConfigBean.filterReqNWCPopupGW.filterColumn1)}"   style="vertical-align:top;">
					<f:facet name="header">
						
							  <h:panelGroup>
		 <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupGW.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="GatewayTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:outputText value="IP Address/Mask" />&nbsp;:&nbsp;<h:outputText value="#{gateway.ipAddress}" />&nbsp;/&nbsp;<h:outputText value="#{gateway.mask}" />
					</div>
					<div align="left">
						<h:outputText value="Network Type" />&nbsp;:&nbsp;<h:outputText value="#{gateway.networkTypeDesc}" />
					</div>
					<div align="left">
						<h:outputText value="Location" />&nbsp;:&nbsp;<h:outputText value="#{gateway.locationName}" />
					</div>
					<div align="left">
						<h:outputText value="VLAN ID" />&nbsp;:&nbsp;<h:outputText value="#{gateway.reqVlanId}" />
					</div>
				</rich:column>
					
				<rich:column width="10%"  filterValue="#{networkConfigBean.filterReqNWCPopupGW.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(gateway.reqDesc,networkConfigBean.filterReqNWCPopupGW.filterColumn2)}"   style="vertical-align:top;">
					<f:facet name="header">
				
							  <h:panelGroup>
				<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupGW.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="GatewayTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:inputTextarea value="#{gateway.reqDesc}" style="width:150px" readonly="true">
						</h:inputTextarea>
					</div>	
				</rich:column>
				
			</rich:dataTable>
			
			<rich:dataTable width="100%" id="tableDetailgateway" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.gateway.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupGW.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupGW.filterColumn3)}"   style="vertical-align:top;">
						<f:facet name="header">
							
							  <h:panelGroup>
<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupGW.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailgateway" />
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
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupGW.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupGW.filterColumn4)}"   style="vertical-align:top;">
						<f:facet name="header">							
							  <h:panelGroup>
<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupGW.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailgateway" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupGW.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupGW.filterColumn5)}"   style="vertical-align:top;">
						<f:facet name="header">						
							 <h:panelGroup>
	<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupGW.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailgateway" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.gateway.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailgateway" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTablegateway" selectedStyleClass="selectScroll"
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
							<h:outputText value="#{networkConfigBean.gateway.jobAssign.actionUser}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.gateway.jobAssign.createDate}">
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.gateway.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.gateway.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.gateway.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewGateway" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>




















<a4j:jsFunction name="viewUrRouting" 
	action="#{configRouting.findSubUr}"
 	reRender="ViewRouting"
 	oncomplete="Richfaces.showModalPanel('ViewRouting');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<f:subview id="popupViewRouting"> 
<rich:modalPanel id="ViewRouting" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View Routing"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewRouting" attachTo="hidelink" operation="hide" event="onclick"/>
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
					<td align="left"><h:outputText value="#{networkConfigBean.routing.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	
			<rich:dataTable width="100%" id="RoutingTable" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.routing.searchResult}" var="routing">
				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupRO.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(routing.ipAddress,networkConfigBean.filterReqNWCPopupRO.filterColumn1)}"   width="25%" style="vertical-align:top;">
					<f:facet name="header">
							  <h:panelGroup>
		 	<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupRO.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
						
					</f:facet>
					<div align="left">
						<h:outputText value="IP Address/Mask" />&nbsp;:&nbsp;<h:outputText value="#{routing.ipAddress}" />&nbsp;/&nbsp;<h:outputText value="#{routing.mask}" />
					</div>
					<div align="left">
						<h:outputText value="Interface" />&nbsp;:&nbsp;<h:outputText value="#{routing.interface}" />
					</div>
					<div align="left">
						<h:outputText value="Next Hop" />&nbsp;:&nbsp;<h:outputText value="#{routing.nextHop}" />
					</div>
				</rich:column>

				
				<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupRO.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(routing.reqDesc,networkConfigBean.filterReqNWCPopupRO.filterColumn2)}"   width="25%" style="vertical-align:top;">
					<f:facet name="header">
						
						 <h:panelGroup>
		 	<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupRO.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="RoutingTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="left">
						<h:inputTextarea value="#{routing.reqDesc}" style="width:200px;" rows="3" readonly="true">
						</h:inputTextarea>
					</div>
				</rich:column>
			</rich:dataTable>
			
			<rich:dataTable width="100%" id="tableDetailrouting" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.routing.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupRO.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupRO.filterColumn3)}"  style="vertical-align:top;">
						<f:facet name="header">
					
							 <h:panelGroup>
				<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupRO.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailrouting" />
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
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupRO.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupRO.filterColumn4)}"   style="vertical-align:top;">
						<f:facet name="header">
							
							 <h:panelGroup>
		<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupRO.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailrouting" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupRO.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupRO.filterColumn5)}"   style="vertical-align:top;">
						<f:facet name="header">
						
								 <h:panelGroup>
	<h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupRO.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailrouting" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.routing.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailrouting" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTablerouting" selectedStyleClass="selectScroll"
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
							<h:outputText value="#{networkConfigBean.routing.jobAssign.actionUser}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.routing.jobAssign.createDate}">
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.routing.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.routing.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.routing.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewRouting" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
























<a4j:jsFunction name="viewUrF5" 
	action="#{configf5.findSubUr}"
 	reRender="ViewF5"
 	oncomplete="Richfaces.showModalPanel('ViewF5');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<f:subview id="popupViewF5"> 
<rich:modalPanel id="ViewF5" autosized="true" rendered="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="View F5"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ViewF5" attachTo="hidelink" operation="hide" event="onclick"/>
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
					<td align="left"><h:outputText value="#{networkConfigBean.f5.searchResult.id.subUrNo}"/></td>
				</tr>
			</table>	
			<rich:dataTable width="100%" id="f5Table" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.f5.searchResult}" var="f5">
				<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupF5.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(f5.vipAddress,networkConfigBean.filterReqNWCPopupF5.filterColumn1)}"  style="vertical-align:top;">
					<f:facet name="header">						
						 <h:panelGroup>
						<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupF5.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="f5Table" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText><h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="IP Port:" styleClass="label"></h:outputText><h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						   <h:outputText value="Yes,#{f5.snapIp}" rendered="#{f5.isSnapIp=='Y'}" />
						   <h:outputText value="No" rendered="#{f5.isSnapIp=='N'}" />
						<h:outputText value="Persistance:" styleClass="label"></h:outputText>
						   <h:outputText value="Yes" rendered="#{f5.isPersistence=='Y'}" />
						   <h:outputText value="No" rendered="#{f5.isPersistence=='N'}" />
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="33%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="RoundRobin" rendered="#{f5.method=='RR'}" />
						<h:outputText value="Ratio" rendered="#{f5.method=='RT'}" />
					</div>	
				</rich:column>
				
				<rich:column width="33%"  filterValue="#{networkConfigBean.filterReqNWCPopupF5.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(f5.poolIpAddress,networkConfigBean.filterReqNWCPopupF5.filterColumn2)}"   style="vertical-align:top;">
					<f:facet name="header">
						 <h:panelGroup>
						 <h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupF5.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="f5Table" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
			</rich:dataTable>
			<rich:dataTable width="100%" id="tableDetailf5" cellpadding="1" cellspacing="0" border="0"
					rowClasses="odd,even" rows="5"
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.f5.jobAssignList}" var="detail">
					
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupF5.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.actionUser,networkConfigBean.filterReqNWCPopupF5.filterColumn3)}"  style="vertical-align:top;">
						<f:facet name="header">
								  <h:panelGroup>
		 	<h:outputText value="Assign To" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupF5.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailf5" />
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
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupF5.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.actionName,networkConfigBean.filterReqNWCPopupF5.filterColumn4)}" style="vertical-align:top;">
						<f:facet name="header">
								  <h:panelGroup>
		 	<h:outputText value="Job Status" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupF5.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailf5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionName}"/>
					</rich:column>
					<rich:column  filterValue="#{networkConfigBean.filterReqNWCPopupF5.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.actionRemark,networkConfigBean.filterReqNWCPopupF5.filterColumn5)}"   style="vertical-align:top;">
						<f:facet name="header">
								  <h:panelGroup>
		 <h:outputText value="Remarks" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{networkConfigBean.filterReqNWCPopupF5.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="tableDetailf5" />
		 </h:inputText>
	 </h:panelGroup>
						</f:facet>
						<h:outputText value="#{detail.actionRemark}"/>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="5">
								<h:panelGroup style="float:left;">
									Total : <h:outputText value="#{fn:length(networkConfigBean.f5.jobAssignList)}" /> records
								</h:panelGroup>
								<h:panelGroup style="float:rightt;">
									<rich:datascroller immediate="true" rendered="true" align="right" for="tableDetailf5" 
										maxPages="#{ipfmConfigBean.maxPage}" id="scrollTablef5" selectedStyleClass="selectScroll"
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
							<h:outputText value="#{networkConfigBean.f5.jobAssign.actionUser}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.f5.jobAssign.createDate}">
								
							</h:outputText>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.f5.jobAssign.actionName}"/>
						</td>
						<td>&nbsp;
							<h:outputText value="#{networkConfigBean.f5.jobAssign.actionRemark}"/>
						</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle" style="vertical-align:top;"><strong>Impact Detail&nbsp;:&nbsp;</strong>&nbsp;</td>
						<td class="valueStyle" colspan="3">
							<h:inputTextarea style="width:360px;" rows="3" readonly="true" 
								value="#{networkConfigBean.f5.searchResult.actmRemark}">
							</h:inputTextarea>
						</td>
					</tr>
				</table>
				*/%>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton ajaxSingle="true" id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="ViewF5" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>













<a4j:jsFunction name="findSourceIPCDNCheck"
	actionListener="#{configAccessListAction.findSourceIP}"
 	reRender="errorMsg,PolicyAccessListRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findSourceIPCDNCheckEdit" 
	actionListener="#{configAccessListAction.findSourceIP}"
 	reRender="errorMsg,popupEditCDN:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCDNCheck" 
	actionListener="#{configAccessListAction.findDestIP}"
 	reRender="errorMsg,PolicyAccessListRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCDNCheckEdit" 
	actionListener="#{configAccessListAction.findDestIP}"
 	reRender="errorMsg,popupEditCDN:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="alertErrorMsgAjx"
	actionListener="#{reqNWConfigAction.alertErrorMsg}"
 	reRender="errorMsg,networkConfigTab">
 	<a4j:actionparam name="errorMessage"/>
</a4j:jsFunction>
<a4j:jsFunction name="findSourceIPCheck"
	actionListener="#{configFirewallAction.findSourceIP}"
 	reRender="errorMsg,firewallRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findSourceIPCheckEdit" 
	actionListener="#{configFirewallAction.findSourceIP}"
 	reRender="errorMsg,popupEditFirewall:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCheck"
	actionListener="#{configFirewallAction.findDestIP}"
 	reRender="errorMsg,firewallRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCheckEdit" 
	actionListener="#{configFirewallAction.findDestIP}"
 	reRender="errorMsg,popupEditFirewall:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>
<a4j:jsFunction name="retrieveData" 
	actionListener="#{configf5.retrieveData}"
 	reRender="errorMsg,networkConfigTab,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="addNetworkConfig" 
	actionListener="#{reqNWConfigAction.addConfigNetwork}"
 	reRender="errorMsg,DetailForm,networkConfigTab,errorDialogPopup" 
 	oncomplete="javascript:showErrorFlag();">
 	<a4j:actionparam name="reqType"/>
</a4j:jsFunction>
<a4j:jsFunction name="addNetworkConfigF5" 
	actionListener="#{reqNWConfigAction.addConfigNetwork}"
 	reRender="errorMsg,DetailForm,networkConfigTab,errorDialogPopup" 
 	oncomplete="if('#{networkConfigBean.f5.retriveFound}' == 'true') {Richfaces.showModalPanel('confirmRetriveDataF5')} javascript:showErrorFlag();">
 	<a4j:actionparam name="reqType"/>
</a4j:jsFunction>
<a4j:jsFunction name="editNetworkConfig" 
	actionListener="#{reqNWConfigAction.editConfigNetwork}"
 	reRender="errorMsg,networkConfigTab,errorDialogPopup" 
 	oncomplete="javascript:showErrorFlag();">
 	<a4j:actionparam name="reqType"/>
</a4j:jsFunction>
<a4j:jsFunction name="findIPF5" actionListener="#{configf5.findIPNode}" 
	reRender="errorMsg,F5Request">
</a4j:jsFunction>

<a4j:jsFunction name="toggleTCPField" actionListener="#{configFirewallAction.toggleTCPField}" reRender="tcpPort" >
</a4j:jsFunction>
<a4j:jsFunction name="toggleUDPField"  actionListener="#{configFirewallAction.toggleUDPField}" reRender="udpPort" >
</a4j:jsFunction>
<a4j:jsFunction name="toggleOtherField" actionListener="#{configFirewallAction.toggleOtherField}" reRender="otherPort">
</a4j:jsFunction>
<a4j:jsFunction name="errorAlert" 
	actionListener="#{reqNWConfigAction.setErrorMsg}"
 	reRender="errorMsg,errorDialogPopup" 
 	oncomplete="Richfaces.showModalPanel('errorDialogPopup');">
</a4j:jsFunction>

<a4j:jsFunction name="confirmDelete" 
	action="#{reqNWConfigAction.confirmDeleteSubUr}"
 	reRender="confirmDeletePopup" 
 	oncomplete="Richfaces.showModalPanel('confirmDeletePopup');">
 	<a4j:actionparam name="reqType"/>
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="confirmSelectedDelete"
	rendered="confirmDeleteAllPopup"
	oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');">
</a4j:jsFunction>

<rich:modalPanel id="errorDialogPopup" autosized="true" rendered="true"
	styleClass="contentform" minWidth="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="IPFM Message"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideErrorIcon" style="cursor:pointer;" />
			<rich:componentControl for="errorDialogPopup" attachTo="hideErrorIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupErrorDlg">	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
			<ul>
				<h:inputHidden id="errorFlag" value="#{networkConfigBean.errorFlag}"></h:inputHidden>
			</ul>			
			<table border="0" cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td align="left">
						<h:outputText id="errorMessageAlert" styleClass="contentlabelform" escape="false" 
							style="color:red" value="#{networkConfigBean.errorMsg}"></h:outputText>						
					</td>
				</tr>
				<tr>
					<td align="center">
						<h:panelGrid columns="1" styleClass="contentlabelform">
							<a4j:commandButton value="OK" styleClass="rich-button" id="btnOK">
								<rich:componentControl for="errorDialogPopup" attachTo="btnOK" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
		</a4j:outputPanel>
	</a4j:form>
</f:subview>					
	
</rich:modalPanel>

<rich:modalPanel id="confirmDeletePopup" width="350" height="100" rendered="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfDelete"/>
	        <rich:componentControl for="confirmDeletePopup" attachTo="hideConfDelete" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<a4j:form id="formRegionMultiQuery">
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="#{mes.CF0009}" /></td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes">
        		<a4j:support action="#{reqNWConfigAction.deleteSubUr}" 
        			event="onclick"
					oncomplete="Richfaces.hideModalPanel('confirmDeletePopup');" 
					reRender="networkConfigTab">
				</a4j:support>	 
			</a4j:commandButton>
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDeletePopup');">
        </td></tr>
    </table>
    </a4j:form>
</rich:modalPanel>

<rich:modalPanel id="confirmDeleteAllPopup" width="350" height="100" rendered="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfDeleteAll"/>
	        <rich:componentControl for="confirmDeleteAllPopup" attachTo="hideConfDeleteAll" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>

	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="#{mes.CF0010}" /></td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes"
        		action="#{reqNWConfigAction.deleteSelectedSubUr}"
        		reRender="networkConfigTab" 
 				oncomplete="Richfaces.hideModalPanel('confirmDeleteAllPopup');">
			</a4j:commandButton>
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDeleteAllPopup');">
        </td></tr>
    </table>

</rich:modalPanel>

<rich:modalPanel id="confirmRetriveDataF5" width="350" height="100" rendered="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfRetriveData"/>
	        <rich:componentControl for="confirmRetriveDataF5" attachTo="hideConfRetriveData" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<a4j:form id="formRetriveDataF5">
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="VIP and Port มีอยู่แล้วในระบบ ต้องการ Retrive Data เพิ่มเด้วยหรือไม่" /></td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes" onclick="retrieveData()"
 				oncomplete="Richfaces.hideModalPanel('confirmRetriveDataF5');">
			</a4j:commandButton>
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmRetriveDataF5');addNetworkConfig('F5');">
        </td></tr>
    </table>
    </a4j:form>
</rich:modalPanel>



<a4j:jsFunction name="editFirewallOld"
	action="#{configFirewallAction.editFirewallInit}" 
	reRender="EditFirewall"
	oncomplete="Richfaces.showModalPanel('EditFirewall');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="editFirewall"
	action="#{configFirewallAction.editFirewallInit}" 
	reRender="networkConfigTab"
>
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditFirewall"> 
<rich:modalPanel id="EditFirewall" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Firewall"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditFirewall" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table border="0" width="100%">	
							<tr > 
								<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
								<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
								<td colspan="3" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Service</strong></td>
								<td>&nbsp;</td>
							</tr>
							<tr style="height:25px">
								<td class="labelStyle" style="width:76px;">
									IP<h:graphicImage value="../images/icon_required.gif" style="border:0" /> :
								</td>
								<td class="valuelStyle" style="width:134px;">
									
										<h:inputText id="sourceIP" value="#{networkConfigBean.firewall.sourceIPStart}" style="text-align:left;width:70px"
											onblur="if(this.value=='') clearSourceIP(); 
													if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditFirewall:formRegionMultiQuery:sourceIP','popupEditFirewall:formRegionMultiQuery:sourceTo'); findSourceIPCheckEdit();}}" 
											onkeypress="return checkIPKey(this,event);" disabled="#{not networkConfigBean.firewallCheck}"/>
										&nbsp;-&nbsp;
										<h:inputHidden id="sameFlag" value="Y"/>
										<h:inputText id="sourceTo" value="#{networkConfigBean.firewall.sourceIPEnd}" style="text-align:left;width:30px"
											onfocus="if (checkEqValue('popupEditFirewall:formRegionMultiQuery:sourceIP','popupEditFirewall:formRegionMultiQuery:sourceTo')) 
													 {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'Y';}
													 else {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'N';}"
											onkeypress="return keyRange(this,event,0,255);" 
											onblur="if(this.value=='') clearSourceIP(); 
													if(this.value!='' && isNumber(this)!=''){
														if (!((document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value=='Y') 
															&& checkEqValue('popupEditFirewall:formRegionMultiQuery:sourceIP','popupEditFirewall:formRegionMultiQuery:sourceTo'))) 
															isIPLowerNoFocus(this,'popupEditFirewall:formRegionMultiQuery:sourceIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findSourceIPCheckEdit()')
													}"
											disabled="#{not networkConfigBean.firewallCheck}"/>
										<a4j:jsFunction name="findSourceIP" actionListener="#{configFirewallAction.findSourceIP}" 
											reRender="errorMsg,outputSourceName,outputSourceEmail,outputSourceVip,sourceNat" >
										</a4j:jsFunction>
										<a4j:jsFunction name="clearSourceIP" actionListener="#{configFirewallAction.clearSourceIP}" 
											reRender="errorMsg,sourceTo,outputSourceName,outputSourceEmail,outputSourceVip,sourceNat">
										</a4j:jsFunction>
									
								</td>
								<td class="labelStyle" style="width:76px;">
									IP<h:graphicImage value="../images/icon_required.gif" style="border:0" /> :
								</td>
								<td class="valuelStyle" style="width:134px;">									
										<h:inputText id="destIP" value="#{networkConfigBean.firewall.destIPStart}" style="text-align:left;width:70px"
											onblur="if(this.value=='') clearDestIP(); 
													if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditFirewall:formRegionMultiQuery:destIP','popupEditFirewall:formRegionMultiQuery:destTo'); findDestIPCheckEdit();}}"
											onkeypress="return checkIPKey(this,event);" disabled="#{not networkConfigBean.firewallCheck}"/>
										&nbsp;-&nbsp;
										<h:inputText id="destTo" value="#{networkConfigBean.firewall.destIPEnd}" style="text-align:left;width:30px"
											onfocus="if (checkEqValue('popupEditFirewall:formRegionMultiQuery:destIP','popupEditFirewall:formRegionMultiQuery:destTo')) 
													 {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'Y';}
													 else {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'N';}"
											onkeypress="return keyRange(this,event,0,255);"
											onblur="if(this.value=='') clearDestIP(); 
													if(this.value!='' && isNumber(this)!=''){
														if (!((document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value=='Y') 
															&& checkEqValue('popupEditFirewall:formRegionMultiQuery:destIP','popupEditFirewall:formRegionMultiQuery:destTo'))) 
															isIPLowerNoFocus(this,'popupEditFirewall:formRegionMultiQuery:destIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findDestIPCheckEdit()')
													}"
											disabled="#{not networkConfigBean.firewallCheck}"/>
										<a4j:jsFunction name="findDestIP" actionListener="#{configFirewallAction.findDestIP}" 
											reRender="errorMsg,outputDestName,outputDestEmail,outputDestVip,destNat" 
											oncomplete="checkAlert('popupEditFirewall:formRegionMultiQuery:destCheck','IP ยังไม่ได้ถูก Assigned กรุณาตรวจสอบข้อมูล');">
										</a4j:jsFunction>
										<a4j:jsFunction name="clearDestIP" actionListener="#{configFirewallAction.clearDestIP}" 
											reRender="errorMsg,destTo,outputDestName,outputDestEmail,outputDestVip,destNat">
										</a4j:jsFunction>	
									
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="tcpCheck" 
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.tcpCheck}"
										onclick="textboxToggle(this,'popupEditFirewall:formRegionMultiQuery:tcpPort');toggleTCPField();"/>
								</td>
								<td class="valuelStyle" style="width:70px;">
									TCP&nbsp;&nbsp;<h:inputText id="tcpPort" value="#{networkConfigBean.firewall.tcpPort}" 
										style="text-align:left;width:40px"
										disabled="#{not networkConfigBean.firewall.tcpCheck}"/> 
								</td>
								<td rowspan="5" style="width:266px;">
									<rich:pickList id="serviceSelect"
										disabled="#{not networkConfigBean.firewallCheck}"
										copyAllVisible="false" 
										copyControlLabel=" "
										removeAllVisible="false"
										removeControlLabel=" "
										listsHeight="110"
										sourceListWidth="80"
										targetListWidth="80"
										value="#{networkConfigBean.firewall.selectList}">
										 <f:selectItems value="#{networkConfigBean.firewall.serviveList}"/>
									</rich:pickList>
								</td>
								<td>&nbsp;</td>
							</tr>
							
							<tr class="inputRow">
								<td class="labelStyle" style="width:85px;">
									Host Name :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceName">
										<h:inputHidden id="sourceCheck" value="#{networkConfigBean.firewall.sourceFound}"/>
                    					<h:outputText id="sourceNameTxt" value="#{networkConfigBean.firewall.sourceName}" />
                    					<h:inputHidden id="sourceName" value="#{networkConfigBean.firewall.sourceName}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									Host Name :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestName">
										<h:inputHidden id="destCheck" value="#{networkConfigBean.firewall.destFound}"/>
                    					<h:outputText id="destNameTxt" value="#{networkConfigBean.firewall.destName}" />
                    					<h:inputHidden id="destName" value="#{networkConfigBean.firewall.destName}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="udpCheck"
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.udpCheck}"
										onclick="textboxToggle(this,'popupEditFirewall:formRegionMultiQuery:udpPort');toggleUDPField();"/>
								</td>
								<td class="valuelStyle" style="width:70px;">
									UDP&nbsp;&nbsp;<h:inputText id="udpPort" value="#{networkConfigBean.firewall.udpPort}" style="text-align:left;width:40px"
									onblur="validatePort(this);"
										disabled="#{not networkConfigBean.firewall.udpCheck}"/> 
								</td>
								<td>&nbsp;</td>
							</tr>
							
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									Email :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceEmail">
                    					<h:inputText id="sourceEmail" value="#{networkConfigBean.firewall.sourceEmail}"
                    						disabled="#{not networkConfigBean.firewallCheck}" 
                    						style="text-align:left;width:120px"/>
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									Email :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestEmail">
										<h:outputText id="destEmail" value="#{networkConfigBean.firewall.destEmail}"
											style="text-align:left;width:120px"/>
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="otherCheck"
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.otherCheck}"
										onclick="textboxToggle(this,'popupEditFirewall:formRegionMultiQuery:otherPort');toggleOtherField();"/>
								</td>
								<td class="valuelStyle" style="width:70px;">
									Other&nbsp; 
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									VIP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceVip">
                    					<h:outputText id="sourceVipTxt" value="#{networkConfigBean.firewall.sourceVip}" />
                    					<h:inputHidden id="sourceVip" value="#{networkConfigBean.firewall.sourceVip}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									VIP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestVip">
                    					<h:outputText id="destVipTxt" value="#{networkConfigBean.firewall.destVip}" />
                    					<h:inputHidden id="destVip" value="#{networkConfigBean.firewall.destVip}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">
									&nbsp;
								</td>
								<td class="valuelStyle" style="width:70px;">
									<h:inputText id="otherPort" value="#{networkConfigBean.firewall.otherPort}" style="text-align:left;width:60px"
										disabled="#{not networkConfigBean.firewall.otherCheck}"/>  
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									Nat IP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<h:inputText id="sourceNat" value="#{networkConfigBean.firewall.sourceNatIP}" 
										style="text-align:left;width:120px"
										disabled="#{not networkConfigBean.firewallCheck}"
										/>
								</td>
								<td class="labelStyle" style="width:76px;">
									Nat IP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<h:inputText id="destNat" value="#{networkConfigBean.firewall.destNatIP}" 
										style="text-align:left;width:120px"
										disabled="#{not networkConfigBean.firewallCheck}"
										/>
								</td>
								<td class="labelStyle" style="width:18px;">
									&nbsp;
								</td>
								<td class="valuelStyle" style="width:70px;">
									&nbsp; 
								</td>
								<td>&nbsp;</td>
							</tr>
							
							<tr><td><img src="../images/blank.gif"></td></tr>	
							<tr>
								<td align="right">
									<table border="0" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<td align="left">
												<h:panelGrid columns="2" id="btnPopupFirewall">
													<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
														action="#{configFirewallAction.editFirewall}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditFirewall');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditFirewall" attachTo="btnClose" operation="hide" event="onclick"/>
													</a4j:commandButton>&nbsp;&nbsp;	
												</h:panelGrid>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>

















<a4j:jsFunction name="editTnpOld"
	action="#{configAccessListTNPAction.editTnpInit}" 
	reRender="EditTNP"
	oncomplete="Richfaces.showModalPanel('EditTNP');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="editTnp"
	action="#{configAccessListTNPAction.editTnpInit}" 
	reRender="networkConfigTab">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditTNP"> 
<rich:modalPanel id="EditTNP" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Access List for TNP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditTNP" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
					<tr>
						<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
						<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td width="180">
								<h:inputText id="sourceIP" value="#{networkConfigBean.accessListTNP.sourceIP}" style="text-align:left;width:100px" 
									onkeypress="return checkIPKey(this,event);"
									onblur="if(this.value=='') clearSourceIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findSourceIPTNPEdit();}"/>
								<a4j:jsFunction name="findSourceIPTNPEdit" actionListener="#{configAccessListTNPAction.findSourceIP}" 
									reRender="popupEditTNP:formRegionMultiQuery" 
									oncomplete="checkAlert('popupEditTNP:formRegionMultiQuery:sourceCheck','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
								</a4j:jsFunction>
								<a4j:jsFunction name="clearSourceIP" actionListener="#{configAccessListTNPAction.clearSourceIP}" 
									reRender="errorMsg,popupEditTNP:formRegionMultiQuery">
								</a4j:jsFunction>
						</td>
						<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td width="180">
								<h:inputText id="destIP" value="#{networkConfigBean.accessListTNP.destIP}" style="text-align:left;width:100px" 
									onkeypress="return checkIPKey(this,event);"
									onblur="if(this.value=='') clearDestIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findDestIPTNPEdit()}"/>
								<a4j:jsFunction name="findDestIPTNPEdit" actionListener="#{configAccessListTNPAction.findDestIP}" 
									reRender="errorMsg,popupEditTNP:formRegionMultiQuery" 
									oncomplete="checkAlert('v:destCheck','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
								</a4j:jsFunction>
								<a4j:jsFunction name="clearDestIP" actionListener="#{configAccessListTNPAction.clearDestIP}" 
									reRender="popupEditTNP:formRegionMultiQuery">
								</a4j:jsFunction>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputSourceNameTNP">
								<h:inputHidden id="sourceCheck" value="#{networkConfigBean.accessListTNP.sourceFound}"/>
	                    		<h:outputText id="sourceNameTxt" value="#{networkConfigBean.accessListTNP.sourceHostName}" />
	                    		<h:inputHidden id="sourceName" value="#{networkConfigBean.accessListTNP.sourceHostName}" />
	                		</a4j:outputPanel>
						</td>
						<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputDestNameTNP">
								<h:inputHidden id="destCheck" value="#{networkConfigBean.accessListTNP.destFound}"/>
	                    		<h:outputText id="destNameTxt" value="#{networkConfigBean.accessListTNP.destHostName}" />
	                    		<h:inputHidden id="destName" value="#{networkConfigBean.accessListTNP.destHostName}" />
	                		</a4j:outputPanel>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Location&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputSourceLocationTNP">
								<h:outputText id="sourceLocatTxt" value="#{networkConfigBean.accessListTNP.sourceLocation}" />
	                    		<h:inputHidden id="sourceLocat" value="#{networkConfigBean.accessListTNP.sourceLocation}" />
	                		</a4j:outputPanel>
						</td>
						<td class="labelStyle">Location&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputDestLocationTNP">
								<h:outputText id="destLocatTxt" value="#{networkConfigBean.accessListTNP.destLocation}" />
	                    		<h:inputHidden id="destLocat" value="#{networkConfigBean.accessListTNP.destLocation}" />
	                		</a4j:outputPanel>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Network&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputSourceNetworkTNP">
								<h:outputText id="sourceNetworkTxt" value="#{networkConfigBean.accessListTNP.sourceNetwork}" />
	                    		<h:inputHidden id="sourceNetwork" value="#{networkConfigBean.accessListTNP.sourceNetwork}" />
	                		</a4j:outputPanel>
						</td>
						<td class="labelStyle">Network&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputDestNetworkTNP">
								<h:outputText id="destNetworkTxt" value="#{networkConfigBean.accessListTNP.destNetwork}" />
	                    		<h:inputHidden id="destNetwork" value="#{networkConfigBean.accessListTNP.destNetwork}" />
	                		</a4j:outputPanel>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Interface At Node&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="sourceInterfaceNode" value="#{networkConfigBean.accessListTNP.sourceInterfaceNode}" style="text-align:left;width:120px"/>
						</td>
						<td class="labelStyle">Interface At Node&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="destInterfaceNode" value="#{networkConfigBean.accessListTNP.destInterfaceNode}" style="text-align:left;width:120px"/>
						</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle">Interface At Network&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="sourceInterfaceNetwork" value="#{networkConfigBean.accessListTNP.sourceInterfaceNetwork}" style="text-align:left;width:120px"/>
						</td>
						<td class="labelStyle">Interface At Network&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="destInterfaceNetwork" value="#{networkConfigBean.accessListTNP.destInterfaceNetwork}" style="text-align:left;width:120px"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle">Description&nbsp;:&nbsp;</td>
						<td colspan="3">
							<h:inputText id="description" value="#{networkConfigBean.accessListTNP.description}" style="text-align:left;width:360px"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle" valign="top">Impact<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td colspan="3">
							<h:inputTextarea id="impact" style="width:360px;" rows="3"  value="#{networkConfigBean.accessListTNP.impact}">
							</h:inputTextarea><br>
							<h:graphicImage value="../images/icon_required.gif" style="border:0" />
							<h:outputText value="If source node cannot connect to destination node." style="color:#0000FF;"></h:outputText>
						</td>
						<td>&nbsp;</td>
					</tr>
				<tr>
					<td align="left" colspan="2">
						<h:panelGrid columns="2" id="btnPopupFirewall">
						<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
							action="#{configAccessListTNPAction.editTnp}"
							reRender="networkConfigTab"
							oncomplete="Richfaces.hideModalPanel('EditTNP');">
						</a4j:commandButton>
						<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
							<rich:componentControl for="EditTNP" attachTo="btnClose" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;&nbsp;	
						</h:panelGrid>
					</td>
				</tr>
				</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>












<a4j:jsFunction name="editCdnOld"
	action="#{configAccessListAction.editCdnInit}" 
	reRender="EditCDN"
	oncomplete="Richfaces.showModalPanel('EditCDN');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<a4j:jsFunction name="editCdn"
	action="#{configAccessListAction.editCdnInit}" 
	reRender="networkConfigTab" >
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditCDN"> 
<rich:modalPanel id="EditCDN" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Access List for CDN"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditCDN" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editCDNPanel">	
			<a4j:region>
				<table width="100%" border="0" class="thtext_detail">
				<tr>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="sourceIP" value="#{networkConfigBean.accessList.sourceIPStart}" style="text-align:left;width:100px" 
								onblur="if(this.value=='') clearSourceIP(); 
										if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditCDN:formRegionMultiQuery:sourceIP','popupEditCDN:formRegionMultiQuery:sourceTo'); findSourceIPCDNCheckEdit();}}" 
								onkeypress="return checkIPKey(this,event);" />
							&nbsp;-&nbsp;
							<h:inputHidden id="sameFlag" value="Y"/>
							<h:inputText id="sourceTo" value="#{networkConfigBean.accessList.sourceIPEnd}" style="text-align:left;width:30px"
								onfocus="if (checkEqValue('popupEditCDN:formRegionMultiQuery:sourceIP','popupEditCDN:formRegionMultiQuery:sourceTo')) 
										 {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'Y';}
										 else {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'N';}"
								onkeypress="return keyRange(this,event,0,255);" 
								onblur="if(this.value=='') clearSourceIP(); 
										if(this.value!='' && isNumber(this)!=''){
											if (!((document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value=='Y') 
												&& checkEqValue('popupEditCDN:formRegionMultiQuery:sourceIP','popupEditCDN:formRegionMultiQuery:sourceTo'))) 
												isIPLowerNoFocus(this,'popupEditCDN:formRegionMultiQuery:sourceIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findSourceIPCDNCheckEdit()')
										}"
							/>	
							<a4j:jsFunction name="findSourceIPCDN" actionListener="#{configAccessListAction.findSourceIP}" 
								reRender="errorMsg,outputSourceNameCDN,outputSourceEmailCDN" 
								oncomplete="checkAlert('popupEditCDN:formRegionMultiQuery:sourceCheck','ไม่มีข้อมูล IP Address ที่ระบุ');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configAccessListAction.clearSourceIP}" 
								reRender="errorMsg,sourceTo,outputSourceNameCDN,outputSourceEmailCDN">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="destIP" value="#{networkConfigBean.accessList.destIPStart}" style="text-align:left;width:100px" 
								onblur="if(this.value=='') clearDestIP(); 
										if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditCDN:formRegionMultiQuery:destIP','popupEditCDN:formRegionMultiQuery:destTo'); findDestIPCDNCheckEdit();}}"
								onkeypress="return checkIPKey(this,event);"/>
							&nbsp;-&nbsp;
							<h:inputText id="destTo" value="#{networkConfigBean.accessList.destIPEnd}" style="text-align:left;width:30px"
								onfocus="if (checkEqValue('popupEditCDN:formRegionMultiQuery:destIP','popupEditCDN:formRegionMultiQuery:destTo')) 
										 {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'Y';}
										 else {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'N';}"
								onkeypress="return keyRange(this,event,0,255);"
								onblur="if(this.value=='') clearDestIP(); 
										if(this.value!='' && isNumber(this)!=''){
											if (!((document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value=='Y') 
												&& checkEqValue('popupEditCDN:formRegionMultiQuery:destIP','popupEditCDN:formRegionMultiQuery:destTo'))) 
												isIPLowerNoFocus(this,'popupEditCDN:formRegionMultiQuery:destIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findDestIPCDNCheckEdit()')
										}"
							/>
							<a4j:jsFunction name="findDestIPCDN" actionListener="#{configAccessListAction.findDestIP}" 
								reRender="errorMsg,outputDestNameCDN,outputDestEmailCDN" 
								oncomplete="checkAlert('popupEditCDN:formRegionMultiQuery:destCheck','ไม่มีข้อมูล IP Address ที่ระบุ');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearDestIP" actionListener="#{configAccessListAction.clearDestIP}" 
								reRender="errorMsg,destTo,outputDestNameCDN,outputDestEmailCDN">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="displayRow">
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputSourceNameCDN">
							<h:inputHidden id="sourceCheck" value="#{networkConfigBean.accessList.sourceFound}"/>
                    		<h:outputText id="sourceNameTxt" value="#{networkConfigBean.accessList.sourceName}" />
                    		<h:inputHidden id="sourceName" value="#{networkConfigBean.accessList.sourceName}" />
                		</a4j:outputPanel>
					</td>
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputDestNameCDN">
							<h:inputHidden id="destCheck" value="#{networkConfigBean.accessList.destFound}"/>
                    		<h:outputText id="destNameTxt" value="#{networkConfigBean.accessList.destName}" />
                    		<h:inputHidden id="destName" value="#{networkConfigBean.accessList.destName}" />
                		</a4j:outputPanel>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="displayRow">
					<td class="labelStyle">Email&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputSourceEmailCDN">
                    		<h:outputText id="sourceEmailTxt" value="#{networkConfigBean.accessList.sourceEmail}" />
                    		<h:inputHidden id="sourceEmail" value="#{networkConfigBean.accessList.sourceEmail}" />
                		</a4j:outputPanel>
					</td>
					<td class="labelStyle">Email&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputDestEmailCDN">
                    		<h:outputText id="destEmailTxt" value="#{networkConfigBean.accessList.destEmail}" />
                    		<h:inputHidden id="destEmail" value="#{networkConfigBean.accessList.destEmail}" />
                		</a4j:outputPanel>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" colspan="2">
						<h:panelGrid columns="2" id="btnPopupCDN">
						<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
							action="#{configAccessListAction.editCdn}"
							reRender="networkConfigTab"
							oncomplete="Richfaces.hideModalPanel('EditCDN');">
						</a4j:commandButton>
						<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
							<rich:componentControl for="EditCDN" attachTo="btnClose" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;&nbsp;	
						</h:panelGrid>
					</td>
				</tr>
				</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>







<a4j:jsFunction name="editInterfaceOld"
	action="#{configPhyInterface.editPhyInterfaceInit}" 
	reRender="EditInterface"
	oncomplete="Richfaces.showModalPanel('EditInterface');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="editInterface"
	action="#{configPhyInterface.editPhyInterfaceInit}" 
	reRender="networkConfigTab" >
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditInterface"> 
<rich:modalPanel id="EditInterface" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Physical Interface"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditInterface" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
				<tr > 
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>IP</strong></td>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Interface Detail</strong></td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">IP Node<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="ipNode" value="#{networkConfigBean.phyInterface.ipNode}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"
								onblur="if(this.value=='') clearSourceIPEdit(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPNodeEdit();}"/>
							<a4j:jsFunction name="findIPNodeEdit" actionListener="#{configPhyInterface.findIPNode}" 
								reRender="popupEditInterface:formRegionMultiQuery" 
								oncomplete="checkAlert('popupEditInterface:formRegionMultiQuery:ipFound','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIPEdit" actionListener="#{configPhyInterface.clearSourceIP}" 
								reRender="popupEditInterface:formRegionMultiQuery">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">Interface Node Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<rich:comboBox id="interfaceNodeType" value="#{networkConfigBean.phyInterface.intfNodeType}" 
							itemClass="contentform"  itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configPhyInterface.nodeType}"/>
							<f:selectItems value="#{configPhyInterface.nodeType}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<h:inputHidden id="ipFound" value="#{networkConfigBean.phyInterface.ipFound}"/>
	                    <h:outputText id="hostName" value="#{networkConfigBean.phyInterface.hostName}" />
					</td>
					<td class="labelStyle" rowspan="2"  valign="top">Description&nbsp;:&nbsp;</td>
					<td rowspan="2">
						<h:inputTextarea id="interfaceDesc" value="#{networkConfigBean.phyInterface.interfaceDesc}" style="text-align:left;width:145px" rows="4"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">MAC Address&nbsp;:&nbsp;</td>
					<td valign="top">
						<h:outputText id="macAddress" value="#{networkConfigBean.phyInterface.macAddress}" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Location&nbsp;:&nbsp;</td>
					<td>
						<h:outputText id="locationName" value="#{networkConfigBean.phyInterface.location}" />
					</td>
					<td class="labelStyle">Status<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td>
						<rich:comboBox id="portStatus" value="#{networkConfigBean.phyInterface.portStatus}" itemClass="contentform"  
							style="text-align:left;width:145px" itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configPhyInterface.portStatus}"/>
							<f:selectItems value="#{configPhyInterface.portStatus}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Floor&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="floor" value="#{networkConfigBean.phyInterface.floor}" style="text-align:left;width:145px"/>
					</td>
					<td class="labelStyle">Speed Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td>
						<rich:comboBox id="speedPort" itemSelectedClass="contentform" itemClass="contentform"  
							style="text-align:left;width:145px" value="#{networkConfigBean.phyInterface.speedPort}">
							<f:attribute name="selectItems" value="#{configPhyInterface.speedPort}"/>
							<f:selectItems value="#{configPhyInterface.speedPort}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">VLAN ID&nbsp;:&nbsp;</td>
					<td>
						<h:outputText id="vlanId" value="#{networkConfigBean.phyInterface.vlanID}" />
					</td>
					<td class="labelStyle">Enclosure&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="enclosure" value="#{networkConfigBean.phyInterface.enclosure}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">Remarks&nbsp;:&nbsp;</td>
					<td colspan="3">
						<h:inputTextarea id="remark" style="width:360px;" rows="3"  value="#{networkConfigBean.phyInterface.reqRemark}" readonly="true">
						</h:inputTextarea>
					</td>
					<td>&nbsp;</td>
				</tr>

							
							<tr><td><img src="../images/blank.gif"></td></tr>	
							<tr>
								<td align="right">
									<table border="0" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<td align="left">
												<h:panelGrid columns="2" id="btnPopupFirewall">
													<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
														action="#{configPhyInterface.editPhyInterface}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditInterface');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditInterface" attachTo="btnClose" operation="hide" event="onclick"/>
													</a4j:commandButton>&nbsp;&nbsp;	
												</h:panelGrid>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
















<a4j:jsFunction name="editGatewayOld"
	action="#{configIntfGateway.editGatewayInit}" 
	reRender="EditGateway"
	oncomplete="Richfaces.showModalPanel('EditGateway');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>
<a4j:jsFunction name="editGateway"
	action="#{configIntfGateway.editGatewayInit}" 
	reRender="networkConfigTab"
	>
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>
<f:subview id="popupEditGateway"> 
<rich:modalPanel id="EditGateway" autosized="true"  rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Firewall"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditGateway" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
				<tr class="inputRow">
					<td class="labelStyle">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="ipAddress" value="#{networkConfigBean.gateway.ipAddress}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"
								onblur="if(this.value=='') clearSourceIPEdit(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPAddressEdit()}"/>
							&nbsp;/&nbsp;
							<h:inputText id="sourcePort" value="#{networkConfigBean.gateway.mask}" style="text-align:left;width:30px" maxlength="2" onkeypress="return keyRange(this,event,0,32);" onblur="isNumber(this)"/>	
							<a4j:jsFunction name="findIPAddressEdit" actionListener="#{configIntfGateway.findIPNode}" 
								reRender="errorMsg,popupEditGateway:formRegionMultiQuery" 
								oncomplete="checkAlert('popupEditGateway:formRegionMultiQuery:ipFound','กรุณาระบุข้อมูลในช่อง IP Address ก่อน');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIPEdit" actionListener="#{configIntfGateway.clearSourceIP}" 
								reRender="errorMsg,popupEditGateway:formRegionMultiQuery">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<rich:comboBox id="networkEquip" value="#{networkConfigBean.gateway.networkType}" 
							itemClass="contentform"  itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configIntfGateway.networkType}"/>
							<f:selectItems value="#{configIntfGateway.networkType}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Location&nbsp;:&nbsp;</td>
					<td >
						<h:inputHidden id="ipFound" value="#{networkConfigBean.gateway.ipFound}"/>
                    	<h:outputText id="locationName" value="#{networkConfigBean.gateway.location}" />
					</td>
					<td class="labelStyle">VLAN ID&nbsp;:&nbsp;</td>
					<td >
						<h:inputText id="vlanID" value="#{networkConfigBean.gateway.vlanID}" style="text-align:left;width:145px"
						onkeypress="return keyRange(this,event,1,4096);"
						onblur="this.value = isNumber(this);"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">Description&nbsp;:&nbsp;</td>
					<td colspan="3">
						<h:inputTextarea id="remark" style="width:360px;" rows="3"  value="#{networkConfigBean.gateway.description}">
						</h:inputTextarea>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td><img src="../images/blank.gif"></td></tr>	
							<tr>
								<td align="right">
									<table border="0" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<td align="left">
												<h:panelGrid columns="2" id="btnPopupFirewall">
													<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
														action="#{configIntfGateway.editGateway}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditGateway');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditGateway" attachTo="btnClose" operation="hide" event="onclick"/>
													</a4j:commandButton>&nbsp;&nbsp;	
												</h:panelGrid>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>















<a4j:jsFunction name="editRoutingOld"
	action="#{configRouting.editRoutingInit}" 
	reRender="EditRouting"
	oncomplete="Richfaces.showModalPanel('EditRouting');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>
<a4j:jsFunction name="editRouting"
	action="#{configRouting.editRoutingInit}" 
	reRender="networkConfigTab">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditRouting"> 
<rich:modalPanel id="EditRouting" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Routing"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditRouting" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
				<tr  class="inputRow">
					<td class="labelStyle" align="right">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<h:inputHidden id="ipFound" value="#{networkConfigBean.routing.isFound}"/>
						<a4j:region>
							<h:inputText id="ipAddress" value="#{networkConfigBean.routing.ipAddress}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"  
								onblur="if(this.value=='') clearSourceIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPRoutingEdit()}"/>
							&nbsp;/&nbsp;
							<h:inputText id="sourcePort" value="#{networkConfigBean.routing.mask}" style="text-align:left;width:30px" maxlength="2" onkeypress="return keyRange(this,event,0,32);" onblur="isNumber(this)"/>	
							<a4j:jsFunction name="findIPRoutingEdit" actionListener="#{configRouting.findIPNode}" 
								reRender="errorMsg,popupEditRouting:formRegionMultiQuery" 
								oncomplete="checkAlert('popupEditRouting:formRegionMultiQuery:ipFound','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configRouting.clearSourceIP}" 
								reRender="errorMsg,popupEditRouting:formRegionMultiQuery">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle" align="right" rowspan="3" valign="top">Description&nbsp;:&nbsp;</td>
					<td width="230" rowspan="3" valign="top">
						<h:inputTextarea id="description" value="#{networkConfigBean.routing.description}" rows="5" style="text-align:left;width:145px;"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">Interface&nbsp;:&nbsp;</td>
					<td width="230">
						<h:inputText id="interface" value="#{networkConfigBean.routing.intf}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">Next Hop&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="nextHop" value="#{networkConfigBean.routing.nextHop}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
							<tr><td><img src="../images/blank.gif"></td></tr>	
							<tr>
								<td align="right">
									<table border="0" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<td align="left">
												<h:panelGrid columns="2" id="btnPopupFirewall">
													<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
														action="#{configRouting.editRouting}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditRouting');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditRouting" attachTo="btnClose" operation="hide" event="onclick"/>
													</a4j:commandButton>&nbsp;&nbsp;	
												</h:panelGrid>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>






















<a4j:jsFunction name="editF5DetailOld" actionListener="#{configf5.initEdit}"
 	reRender="EditF5" oncomplete="javascript:Richfaces.showModalPanel('EditF5')">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo" />
</a4j:jsFunction>

<a4j:jsFunction name="editF5Detail" actionListener="#{configf5.initEdit}"
 	reRender="networkConfigTab" >
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo" />
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<rich:modalPanel id="EditF5" autosized="true" rendered="false"
	styleClass="contentform" height="165" minWidth="600" 
	label="Find Region" onshow="reloadPage();">
	
	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit F5"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditF5" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<f:subview id="popupEditF5">	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
			<h:outputText value="#{networkConfigBean.errorMsg}"/>
			<table width="100%" border="0" class="thtext_detail">
				<tr class="inputRow">
					<td class="labelStyle" style="width:20%">IP Pool<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="80%">
						<h:outputText value="#{networkConfigBean.editUrF5.poolIpAddress}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" style="width:20%">IP Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="80%">
						<h:inputText id="IPPort" value="#{networkConfigBean.editUrF5.poolIpPort}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" style="width:20%">Weight(%)&nbsp;:&nbsp;</td>
					<td width="80%">
						<h:inputText id="weight" value="#{networkConfigBean.editUrF5.poolWeight}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
			<tr>
				<td colspan="5" align="center">
					<h:panelGroup id="buttonGroup">
							<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"
								action="#{configf5.updateF5Detail}"
								reRender="F5Request" oncomplete="javascript:Richfaces.hideModalPanel('EditF5')">
								<a4j:actionparam name="urNo" value="#{networkConfigBean.editUrF5.id.urNo}"/>
 								<a4j:actionparam name="subUrNo" value="#{networkConfigBean.editUrF5.id.subUrNo}"/>
							</a4j:commandButton>&nbsp;
							<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
								reRender="groupSearchResult">
								<rich:componentControl for="EditF5" attachTo="btnCancel" operation="hide" event="onclick"/>
							</a4j:commandButton>&nbsp;
					</h:panelGroup>	
				</td>
			</tr>
			</table>	
		</a4j:outputPanel>
	</a4j:form>
	<a4j:jsFunction name="reloadPage" reRender="EditF5" ajaxSingle="true">
	</a4j:jsFunction>		
</f:subview>	
</rich:modalPanel>










<f:subview id="IPSUR003_ERROR_RESULT_POPUP"> 
<rich:modalPanel id="IPSUR003_ERROR_RESULT" rendered="true" autosized="true" styleClass="contentform" minWidth="550" height="#{not empty networkConfigBean.validateResult?'300':'200'}" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Error Data"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPSUR003_ERROR_RESULT" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <div id="container" style="overflow: auto; width: 100%;">
    <h:form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="80%" align="center" valign="top">
						  	<table width="97%" border="0" cellspacing="0" cellpadding="0"  >
						  		<tr>
						  			<td align="center">
						  				<h:outputText value="#{networkConfigBean.errorMsg}" style="font-size: 14px; color: red; font-weight:bolder;"></h:outputText>
						  			</td>
						  		</tr>
						  		<tr>
									<td>
										<rich:spacer height="10"></rich:spacer>
									</td>
								</tr>
								<tr>
									<td>	
									   <rich:panel>
									   		<h:panelGrid columns="1" style="text-align:center;" cellpadding="0" cellspacing="0" width="100%">
									   	  		<rich:dataTable width="100%" id="errorResultTable" cellpadding="1" cellspacing="0" border="0"
													var="detail" value="#{networkConfigBean.validateResult}" reRender="scrollErrorTable" 
													rows="#{ipfmConfigBean.rowPerPage}"
													rowClasses="odd,even" styleClass="contentform" rowKeyVar="index" 
													headerClass="tableHeader">
													    <rich:column width="20%" style="vertical-align:top; text-align:center;">
													    	<f:facet name="header">
																<h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
															<h:outputText value="#{detail.errorMsg[0]}" escape="false" styleClass="contentform" />
														</rich:column>
														<rich:column width="30%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="System Owner" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.errorMsg[1]}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<rich:column width="30%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="System Owner Team" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.errorMsg[2]}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<rich:column width="20%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="IP Status" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.errorMsg[3]}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<f:facet name="footer">
															<rich:columnGroup >
																<rich:column colspan="4">
																	<h:panelGroup style="float:left;">
																		Total : <h:outputText value="#{fn:length(networkConfigBean.validateResult)}" /> records
																	</h:panelGroup>
																	<h:panelGroup style="float:right;">
																		<rich:datascroller immediate="true" rendered="true" align="right" for="errorResultTable"
																			maxPages="#{ipfmConfigBean.maxPage}" id="scrollErrorTable" selectedStyleClass="selectScroll"
																			stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
																			style="background-color: #cccccc;"/>
																	</h:panelGroup>
																</rich:column>
															</rich:columnGroup>												
														</f:facet>
												</rich:dataTable>	
												<rich:spacer height="10"></rich:spacer>
											</h:panelGrid>
										</rich:panel>
									</td>
								</tr>
								<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td align="center">
											<a4j:commandButton value="Close" styleClass="rich-button" >
									    		<rich:componentControl for="IPSUR003_ERROR_RESULT" operation="hide" event="onclick" />
									    	</a4j:commandButton>
										</td>
									</tr>
								</table>
							</td>
						</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</h:form>
	</div>
</rich:modalPanel>
</f:subview>









<a4j:jsFunction name="showresult" 
	reRender="IPSUR003_IMPORT_RESULT, networkConfigTab"
 	oncomplete="Richfaces.showModalPanel('IPSUR003_IMPORT_RESULT');">
</a4j:jsFunction>

<f:subview id="IPSUR003_IMPORT_RESULT_POPUP"> 
<rich:modalPanel id="IPSUR003_IMPORT_RESULT" rendered="true" autosized="true" styleClass="contentform" minWidth="500" height="#{not empty networkConfigBean.validateResult?'350':'150'}" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Import Data"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPSUR003_IMPORT_RESULT" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <div id="container" style="overflow: auto; width: 100%;">
    <h:form>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
						  	<table width="97%" border="0" cellspacing="0" cellpadding="0"  >
								<tr>
									<td>	
									   <rich:panel>
									   		<h:panelGrid rendered="#{(empty networkConfigBean.validateResult)}" columns="1" style="text-align:center;" cellpadding="0" cellspacing="0" width="100%">
									   			<rich:spacer height="10"></rich:spacer>
									   			<h:outputText value="Import Data Success." style="font-size: 16px; color: blue; font-weight:bolder;"></h:outputText>
									   			<rich:spacer height="10"></rich:spacer>
									   		</h:panelGrid>
									   	  	<h:panelGrid rendered="#{not empty networkConfigBean.validateResult}" columns="1" style="text-align:center;" cellpadding="0" cellspacing="0" width="100%">
									   	  		<rich:spacer height="10"></rich:spacer>
									   			<h:outputText value="Import Data Fail." style="font-size: 16px; color: red; font-weight:bolder;"></h:outputText>
									   			<rich:spacer height="10"></rich:spacer>
												<rich:dataTable width="100%" id="resultTable" cellpadding="1" cellspacing="0" border="0"
													var="detail" value="#{networkConfigBean.validateResult}" reRender="scrollIPDetailTable" 
													rows="#{ipfmConfigBean.rowPerPage}"
													rowClasses="odd,even" styleClass="contentform" rowKeyVar="index" 
													headerClass="tableHeader">
													    <rich:column width="15%" style="vertical-align:top; text-align:center;">
													    	<f:facet name="header">
																<h:outputText value="Row No." styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
															<h:outputText value="#{detail.rowNumber}" escape="false" styleClass="contentform" />
														</rich:column>
														<rich:column width="85%" style="vertical-align:top;">
															<f:facet name="header">
																<h:outputText value="Error" styleClass="contentform tableHeaderText"></h:outputText>
															</f:facet>
							          						<h:outputText value="#{detail.description}" escape="false" styleClass="contentform" ></h:outputText>
														</rich:column>
														<f:facet name="footer">
															<rich:columnGroup >
																<rich:column colspan="2">
																	<h:panelGroup style="float:left;">
																		Total : <h:outputText value="#{fn:length(networkConfigBean.validateResult)}" /> records
																	</h:panelGroup>
																	<h:panelGroup style="float:right;">
																		<rich:datascroller immediate="true" rendered="true" align="right" for="resultTable"
																			maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
																			stepControls="hide" fastControls="hide" boundaryControls="hide"  fastStep="#{ipfmConfigBean.fastStepPage}"
																			style="background-color: #cccccc;"/>
																	</h:panelGroup>
																</rich:column>
															</rich:columnGroup>												
														</f:facet>
												</rich:dataTable>	
												<rich:spacer height="10"></rich:spacer>
											</h:panelGrid>
										</rich:panel>
									</td>
								</tr>
								<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td align="center">
											<a4j:commandButton value="Close" styleClass="rich-button" >
									    		<rich:componentControl for="IPSUR003_IMPORT_RESULT" operation="hide" event="onclick" />
									    	</a4j:commandButton>
										</td>
									</tr>
								</table>
							</td>
						</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</h:form>
	</div>
</rich:modalPanel>
</f:subview>

<h:panelGroup id="errorMsg">
	<rich:modalPanel id="errorDialog" autosized="true" showWhenRendered="true" rendered="#{globalMessages}" resizeable="false" width="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="IPFM Message"  ></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls" >
			<h:panelGroup>
				<h:graphicImage rendered="#{!HOME}" value="../images/ico_close.png" id="hideErrorDialog" style="cursor:pointer;" >
					<rich:componentControl for="errorDialog" attachTo="hideErrorDialog" operation="hide" event="onclick" />
				</h:graphicImage>
				<a4j:commandButton rendered="false" image="../images/ico_close.png" onclick="reloadTree();javascript:gotoHomePage();"/>
			</h:panelGroup>
		</f:facet>
		
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" width="100%" styleClass="contentlabelform" >
						<h:messages styleClass="contentlabelform" errorStyle="color: red" 
									warnStyle="color: green" infoStyle="color: blue" globalOnly="true"  />
					</h:panelGrid>
				</td>
			</tr>
			<tr> 
				<td>
					<h:panelGrid columns="1" width="100%" style="text-align:center;" styleClass="contentlabelform"> 
					
						<a4j:form rendered="#{!HOME}">	
							<a4j:commandButton value="OK" styleClass="rich-button"  ajaxSingle="true" status="#{rich:component('wait')}.hide();">
	    						<rich:componentControl for="errorDialog" operation="hide" event="oncomplete" />
							</a4j:commandButton>	
						</a4j:form>
						<a4j:form rendered="#{HOME}">
							<a4j:commandButton id="btnClose" value="OK" onclick="reloadTree();javascript:gotoHomePage();"  ajaxSingle="true" styleClass="rich-button" />
						</a4j:form>				
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</rich:modalPanel>
</h:panelGroup> 



