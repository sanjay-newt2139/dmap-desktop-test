<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

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
