<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

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
