<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>

<style type="text/css">
	.valignTop {vertical-align:top;}
	.rich-filter-input {width:80px;}
</style>
</head>
<body style="overflow:hidden;">

<f:view>
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />					
	</f:subview>
	<f:subview id="error">
					<jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">IPFM Performance Report</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
							    <rich:panel id="panelGrop" >
								<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
                                  <tr>
                                   <td class="labelStyle" height="25"><strong>Request Date<rich:spacer width="5"/><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
                                   <td align="left"><rich:spacer width="10"/>    
                                         From :<rich:spacer width="10"/>
                                         <rich:calendar value="#{ipReportListBean.startDate}"
							                        locale="en/US" popup="true" datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white" inputSize="17"
							                        direction="auto"/><rich:spacer width="10"/>
							       		 To :<rich:spacer width="10"/>
                                         <rich:calendar value="#{ipReportListBean.endDate}"
							                        locale="en/US" popup="true" datePattern="dd/MM/yyyy"
							                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
							                        inputStyle="background-color:white" inputSize="17"
							                        direction="auto"/><rich:spacer width="10"/>
										</td>
                                  </tr>  
                                  <tr>
                                  <td align="left" height="25">
										<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"
											action="#{ipReportCriteriaAction.AddReport}" reRender="DetailForm,errorMsg,groupSearchResult"/>
										<rich:spacer width="10"/>
										<a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button" 
											action="#{ipReportCriteriaAction.init}" reRender="panelGrop,groupSearchResult"/>								                                   
                                   </td>
                                  </tr> 
                                  <tr>
                                  <td colspan="2"><rich:spacer height="10"/></td>
                                  </tr>                       
								</table>
							 </rich:panel>
							</td>
						</tr>
						<tr>
						<td>			
							<rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
										<rich:dataTable width="100%" id="ipReportListTable" cellpadding="1" cellspacing="0" border="0"
											var="detail" value="#{ipReportListBean.ipReportList}" reRender="scrollIpReportListTable" 
											  
											 rows="#{ipReportListBean.rowPerPage}"
											rowClasses="odd,even" 
											styleClass="contentform" rowKeyVar="index" 
											headerClass="tableHeader">
		
										<rich:column width="5%" styleClass="valignTop">
											<f:facet name="header">
												<h:outputText value="Delete" escape="false" styleClass="contentform tableHeaderText"/>
											</f:facet>
											<div align="center">
												<a4j:commandButton id="btnDel" value="Delete" 
													image="../images/p_delete.gif" style="height: 15; width: 15"
													action="#{ipReportCriteriaAction.updateValueBeforeDelete}"
													oncomplete="#{rich:component('confirmDialog')}.show();">
													<a4j:actionparam name="reportId" value="#{detail[9]}"/>
				          						</a4j:commandButton>
											</div>
										</rich:column>
										<rich:column width="15%" styleClass="valignTop" >
											<f:facet name="header">
												<h:outputText value="Request Date/Time" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          						<h:outputText value="#{detail[0]}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>	
										<rich:column  filterValue="#{ipReportListBean.filterReport.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail[4],ipReportListBean.filterReport.filterColumn1)}"  width="15%" styleClass="valignTop" >
											<f:facet name="header">												
												    <h:panelGroup>
		<h:outputText value="Status" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{ipReportListBean.filterReport.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipReportListTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
				          						<h:outputText value="#{detail[4]}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column width="15%" styleClass="valignTop" >
											<f:facet name="header">
												<h:outputText value="Request Date From" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          						<h:outputText value="#{detail[2]}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column width="15%" styleClass="valignTop" >
											<f:facet name="header">
												<h:outputText value="Request Date To" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											<div align="center">
				          						<h:outputText value="#{detail[3]}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>		
										<rich:column  filterValue="#{ipReportListBean.filterReport.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail[8],ipReportListBean.filterReport.filterColumn2)}"   width="30%" styleClass="valignTop">
											<f:facet name="header">												
												  <h:panelGroup>
		<h:outputText value="Error Description" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{ipReportListBean.filterReport.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipReportListTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
				          						 <h:outputText value="#{detail[8]}" styleClass="contentform" ></h:outputText>
											</div>
										</rich:column>	
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{fn:length(ipReportListBean.ipReportList)}" /> records
												</rich:column>
												<rich:column colspan="10">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipReportListTable"
														maxPages="" id="scrollIpReportListTable" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep=""
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>			
										</f:facet>
									</rich:dataTable>&nbsp;
									<div style="float:right;">
									<h:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
								    </div>	
								</h:panelGroup>										
							</rich:panel>
						</td>
						</tr>
					</table>					
					</a4j:form>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>	
	
	<rich:modalPanel id="confirmDialog" width="350" height="120">			
		   <f:facet name="header">
			  <h:panelGroup><h:outputText value="Delete Master Table"/></h:panelGroup>
		   </f:facet>
		   <a4j:form id="delConfirmDialog">
			<table width="90%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this Row ?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{ipReportCriteriaAction.delete}" reRender="ipReportListTable" >
								<rich:componentControl for="confirmDialog"  operation="hide" event="onclick"  />
							</a4j:commandButton>												
							<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="confirmDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>

</f:view>
</body>
</html>
