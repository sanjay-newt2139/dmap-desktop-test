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

<script language="javascript">
</script>

<f:subview id="popupViewRequest"> 
<rich:modalPanel id="WFUserRequestPopup" autosized="true"
	styleClass="contentform" height="270" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			Req : <h:outputText value="#{wfUserBean.roleName}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	    
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="WFUserRequestPopup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
				<rich:dataTable width="95%" id="userListTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="5"
				  
				 
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{wfUserBean.tempTable}" var="tmp">
				
				
				<rich:column  filterValue="#{wfUserBean.filterPopupView.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(tmp.str1,wfUserBean.filterPopupView.filterColumn1)}"   width="5%" style="vertical-align:top;">
					<f:facet name="header">
					
						   <h:panelGroup>
		 	<h:outputText value="No." styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfUserBean.filterPopupView.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputText value="#{tmp.str1}" />
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{wfUserBean.filterPopupView.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(tmp.str2,wfUserBean.filterPopupView.filterColumn2)}"   width="30%" style="vertical-align:top;">
					<f:facet name="header">
						  <h:panelGroup>
		 	<h:outputText value="User Name" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfUserBean.filterPopupView.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputText value="#{tmp.str2}" />
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{wfUserBean.filterPopupView.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(tmp.str3,wfUserBean.filterPopupView.filterColumn3)}"   width="15%" style="vertical-align:top;">
					<f:facet name="header">
						 <h:panelGroup>
		 	<h:outputText value="Department" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfUserBean.filterPopupView.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputText value="#{tmp.str3}" />
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{wfUserBean.filterPopupView.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(tmp.str4,wfUserBean.filterPopupView.filterColumn4)}"   width="25%" style="vertical-align:top;">
					<f:facet name="header">
						 <h:panelGroup>
		 	<h:outputText value="Section" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfUserBean.filterPopupView.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputText value="#{tmp.str4}" />
					</div>
				</rich:column>
				
				<rich:column  filterValue="#{wfUserBean.filterPopupView.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(tmp.str5,wfUserBean.filterPopupView.filterColumn5)}"   width="25%" style="vertical-align:top;">
					<f:facet name="header">
						 <h:panelGroup>
		 	<h:outputText value="Position" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{wfUserBean.filterPopupView.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="userListTable" />
		 </h:inputText>
	 </h:panelGroup>
					</f:facet>
					<div align="center">
						<h:outputText value="#{tmp.str5}" />
					</div>
				</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="3">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="userListTable"
								maxPages="5" id="scrollFirewallTable" selectedStyleClass="selectScroll"
								stepControls="hide" fastControls="hide" boundaryControls="hide" 
								style="background-color: #cccccc;"/>
						</rich:column>
					</rich:columnGroup>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
