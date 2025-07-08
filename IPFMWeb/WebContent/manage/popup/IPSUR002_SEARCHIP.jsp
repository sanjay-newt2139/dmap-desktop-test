<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style type="text/css">
	.vTop {vertical-align:top;}
	.aCenter {text-align:center;}
	.rich-filter-input {width:80px;}
</style>

<rich:modalPanel id="IPSUR002_SEARCHIP" autosized="true" styleClass="contentform" height="400" minWidth="700" shadowDepth="false">
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Assign IP</span></strong>
		</h:panelGroup>	
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="searchIPHidelink"/>
            <rich:componentControl for="IPSUR002_SEARCHIP" attachTo="searchIPHidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	<div id="container" style="overflow: auto; width: 100%;height: 380px;">
	<a4j:form id="searchForm">
		<rich:panel>
			<h:panelGroup styleClass="aCenter" >	          
	 	  		<h:panelGrid id="ipSearchPanel" columns="7" styleClass="contentlabelform" cellpadding="0"  cellspacing="0" border="0">
	 	   			<Strong>IP Address :&nbsp;</Strong>
				   	<h:panelGroup  >
		   				<h:inputText id="ip1"  value="#{planningReqIPBean.searchIP.ipv4digit1}" size="1" styleClass="aCenter" maxlength="3"
		   				onkeypress="return numbersonlyNoDot(event);"
						onkeyup="return keyRangeNumberWithDot('popupSearchIP:searchForm:ip2',this,event,0,255,'190')"
		   				onblur="this.value = isNumber(this);"/>
						<strong>&nbsp;.&nbsp;</strong>
	                    <h:inputText id="ip2" value="#{planningReqIPBean.searchIP.ipv4digit2}" size="1" styleClass="aCenter" maxlength="3" 
		   				onkeypress="return numbersonlyNoDot(event);"
						onkeyup="return keyRangeNumberWithDot('popupSearchIP:searchForm:ip3',this,event,0,255,'190')"	                    onblur="this.value = isNumber(this);"/>
						<strong>&nbsp;.&nbsp;</strong>
	                    <h:inputText id="ip3"  value="#{planningReqIPBean.searchIP.ipv4digit3}" size="1" styleClass="aCenter" maxlength="3" 
		   				onkeypress="return numbersonlyNoDot(event);"
						onkeyup="return keyRangeNumberWithDot('popupSearchIP:searchForm:ip4',this,event,0,255,'190')"	                    onblur="this.value = isNumber(this);"/>
						<strong>&nbsp;.&nbsp;</strong>
						<h:inputText id="ip4" value="#{planningReqIPBean.searchIP.ipv4digit4}" size="1" styleClass="aCenter" maxlength="3"
						onkeypress="return numbersonlyNoDot(event);"
						onkeyup="return keyRangeNumberWithDot('popupSearchIP:searchForm:ipSubmask',this,event,0,255,'191')"
						onblur="this.value = isNumber(this);"/>
						<strong>&nbsp;/&nbsp;</strong>
						<h:inputText id="ipSubmask" value="#{planningReqIPBean.searchIP.ipSubmask}" size="1" styleClass="aCenter" maxlength="2" onkeypress="return numbersonlyNoDot(event);" onblur="this.value = isNumber(this);"/>
					</h:panelGroup>
					<rich:spacer width="20" />
				    <a4j:commandButton id="btnSearch"  value="Search" action="#{planningReqIPAction.searchIP}" reRender="errorMsg,groupSearchIPDataTable"  styleClass="rich-button" 
				    	oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('popupSearchIP:searchForm:searchIPDataTable:checkAll'),'checkBox','searchForm');"/>
				    <rich:hotKey key="return" handler="document.getElementById('popupSearchIP:searchForm:btnSearch').click()" selector="#ip1,#ip2,#ip3,#ip4,#ipSubmask"/>	
				    <rich:spacer width="10" />
					<a4j:commandButton  value="Reset" action="#{planningReqIPAction.resetSearchIP}" reRender="errorMsg,ipSearchPanel,groupSearchIPDataTable" styleClass="rich-button"
						oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('popupSearchIP:searchForm:searchIPDataTable:checkAll'),'checkBox','searchForm');"/>
				</h:panelGrid>
				<h:panelGrid width="100%" columns="1" cellpadding="0"  cellspacing="0" border="0">
					<h:panelGroup id="groupSearchIPDataTable" style="margin:top:5px;">
						<rich:dataTable width="100%" id="searchIPDataTable" cellpadding="1" cellspacing="0" border="0"
							binding="#{planningReqIPBean.searchIPDataTable}"
							var="detail" value="#{planningReqIPBean.searchIP.ipInfoList}"
							styleClass="contentform" rowKeyVar="rowIndex"  headerClass="tableHeader">
							<rich:column width="5%" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox id="checkALL" value="#{planningReqIPBean.searchIPCheckAll}" style="margin:0; padding:0;"
										disabled="#{empty planningReqIPBean.searchIP.ipInfoList}" onclick="validateCheckbox('ALL',this,this,'checkBox','searchForm')">
										<a4j:support disabled="true" event="onclick" action="#{planningReqIPAction.searchIPCheckAllAction}"  reRender="errorMsg,groupSearchIPDataTable"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<h:selectBooleanCheckbox id="checkBox" rendered="#{detail.buttonCheck}" value="#{detail.rowCheck}" 
								onclick="validateCheckbox('N',document.getElementById('popupSearchIP:searchForm:searchIPDataTable:checkAll'),this,'checkBox','searchForm')">
									<f:param name="rowCheck" value="true" />
									<f:param name="subNet" value="#{detail.subNet}" />
									<f:param name="rowIndex" value="#{rowIndex}" />
								</h:selectBooleanCheckbox>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.subNet,planningReqIPBean.filterIpsur002SearchIP.filterColumn1)}"  style="width: 50px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}">
								<f:facet name="header">
									
										  <h:panelGroup>
		 <h:outputText value="Subnet" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.subNet}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.ipAddress,planningReqIPBean.filterIpsur002SearchIP.filterColumn2)}"   style="width: 150px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}">
								<f:facet name="header">
									
									 <h:panelGroup>
		 <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<a4j:commandLink  rendered="#{false && planningReqIPBean.searchIP.linkIP}" value="#{detail.ipAddress}" action="#{planningReqIPAction.popupSearchIP1}" styleClass="rich-button" reRender="IPSUR002_SEARCHIP1"
									oncomplete="#{rich:component('IPSUR002_SEARCHIP1')}.show(); return false;">
									<f:param name="ipAddress" value="#{detail.ipAddress}" />
									<f:param name="ipSubmask" value="#{detail.submask}" />
									<f:param name="ipDigit1" value="#{detail.ipv4digit1}" />
									<f:param name="ipDigit2" value="#{detail.ipv4digit2}" />
									<f:param name="ipDigit3" value="#{detail.ipv4digit3}" />
									<f:param name="ipDigit4" value="#{detail.ipv4digit4}" />
								</a4j:commandLink>
								<a4j:commandLink rendered="#{planningReqIPBean.searchIP.linkIP}" action="#{planningReqIPAction.linkSearchIP}" value="#{detail.ipAddress}" styleClass="contentform" reRender="errorMsg,ipSearchPanel,groupSearchIPDataTable">
									<f:param name="ipAddress" value="#{detail.ipAddress}" />
									<f:param name="ipSubmask" value="#{detail.submask}" />
									<f:param name="ipDigit1" value="#{detail.ipv4digit1}" />
									<f:param name="ipDigit2" value="#{detail.ipv4digit2}" />
									<f:param name="ipDigit3" value="#{detail.ipv4digit3}" />
									<f:param name="ipDigit4" value="#{detail.ipv4digit4}" />
								</a4j:commandLink>
								<h:outputText rendered="#{!planningReqIPBean.searchIP.linkIP}" value="#{detail.ipAddress}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.networkIp,planningReqIPBean.filterIpsur002SearchIP.filterColumn3)}"   style="width: 200px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}">
								<f:facet name="header">
									
										 <h:panelGroup>
		 <h:outputText value="Network IP" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.networkIp}" styleClass="contentform"/>
							</rich:column>
						 	<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.submaskDesc,planningReqIPBean.filterIpsur002SearchIP.filterColumn4)}"   width="85px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}">
								<f:facet name="header">
							
									 <h:panelGroup>
		 		<h:outputText value="Mask" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.submaskDesc}" styleClass="contentform"/>
							</rich:column>
						 	<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.systemOwnerName,planningReqIPBean.filterIpsur002SearchIP.filterColumn5)}"   width="85px;" styleClass="#{detail.subnetStyleClass?'odd':'even'}" rendered="#{planningReqIPBean.searchIP.linkIP}">
								<f:facet name="header">
									
									 <h:panelGroup>
		 		<h:outputText value="Owner" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.systemOwnerName}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.totalIP,planningReqIPBean.filterIpsur002SearchIP.filterColumn6)}"   width="85px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}">
								<f:facet name="header">
									
									 <h:panelGroup>
		 		<h:outputText value="Total" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.totalIP}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(detail.availableIP,planningReqIPBean.filterIpsur002SearchIP.filterColumn7)}"   width="85px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}" rendered="false">
								<f:facet name="header">
								
										 <h:panelGroup>
		 			<h:outputText value="Available" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.availableIP}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn8}"  filterExpression="#{fn:containsIgnoreCase(detail.statusName,planningReqIPBean.filterIpsur002SearchIP.filterColumn8)}"   width="120px;" styleClass="aCenter #{detail.subnetStyleClass?'odd':'even'}" rendered="#{planningReqIPBean.searchIP.linkIP}">
								<f:facet name="header">
								
									 <h:panelGroup>
		 				<h:outputText value="Status" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn8}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.statusName}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn9}"  filterExpression="#{fn:containsIgnoreCase(detail.hostName,planningReqIPBean.filterIpsur002SearchIP.filterColumn9)}"   width="120px;" styleClass="#{detail.subnetStyleClass?'odd':'even'}" rendered="#{planningReqIPBean.searchIP.linkIP}">
								<f:facet name="header">
									
									<h:panelGroup>
		 				<h:outputText value="Host Name" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn9}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.hostName}" styleClass="contentform"/>
							</rich:column>
							<rich:column  filterValue="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn10}"  filterExpression="#{fn:containsIgnoreCase(detail.t3Remark,planningReqIPBean.filterIpsur002SearchIP.filterColumn10)}"   width="120px;" styleClass="#{detail.subnetStyleClass?'odd':'even'}" rendered="#{planningReqIPBean.searchIP.linkIP}">
								<f:facet name="header">									
									<h:panelGroup>
		 				<h:outputText value="Remarks" styleClass="contentform tableHeaderText"/>
		 <h:inputText value="#{planningReqIPBean.filterIpsur002SearchIP.filterColumn10}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="searchIPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
								</f:facet>
								<h:outputText value="#{detail.t3Remark}" styleClass="contentform"/>
							</rich:column>
							<f:facet name="footer">
	                           	<rich:columnGroup>
									<rich:column colspan="#{planningReqIPBean.searchIP.linkIP?'7':'11'}">
										<h:panelGroup style="float:left;">
											Total : <h:outputText value="#{fn:length(planningReqIPBean.searchIP.ipInfoList)}" /> records
										</h:panelGroup>
										<h:panelGroup style="float:right;">
											<rich:datascroller immediate="true" rendered="true" align="right" for="searchIPDataTable"
												maxPages="#{ipfmConfigBean.maxPage}" id="scrollSearchIPDataTable" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
												style="background-color: #cccccc;"/>
												
										</h:panelGroup>
									</rich:column>	
								</rich:columnGroup>										
							</f:facet>
						</rich:dataTable>
					</h:panelGroup>
					<h:panelGroup style="float:right;">
						<a4j:commandButton value="Assign" action="#{planningReqIPAction.assignSearchIP}" reRender="errorMsg,ipDetailTable2"  styleClass="rich-button" 
							oncomplete="if (#{errorMessages!=true}) clearCheckBox('N',document.getElementById('DetailForm:ipDetailTable2:checkAll'),'chkboxs','');">
							<rich:componentControl event="onclick" operation="#{errorMessages?'show':'hide'}" for="IPSUR002_SEARCHIP" />
						</a4j:commandButton>
					    <rich:spacer width="10" />
						<a4j:commandButton value="Cancel" styleClass="rich-button" ajaxSingle="true">
							<rich:componentControl event="onclick" operation="hide" for="IPSUR002_SEARCHIP"/>
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</h:panelGroup>
		</rich:panel>
	</a4j:form>
	</div>
</rich:modalPanel>