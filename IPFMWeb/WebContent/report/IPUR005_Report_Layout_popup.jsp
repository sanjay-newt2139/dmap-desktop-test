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
</style>
</head>
<f:subview id="testBob"> 
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Report Layout</span></strong>
		</h:panelGroup>	
	</f:facet>
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPRUR003_Report_Layout" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	<body style="overflow:scroll;">

	<rich:page >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9"><h:outputText id="reportName" value="#{ipReportDetailBean.ipReportList.reportName}"/></span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
							    <rich:panel id="panelGrop" >
								<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
                                  <tr>
                                   <td align="center">&nbsp;</td>
                                  </tr> 
                                  <tr>
                                   <td align="right"><strong>Run At : <h:outputText value="#{ipReportDetailBean.ipReportList.runAt}"><f:convertDateTime pattern="dd/MM/yyyy"/></h:outputText></strong></td>
                                  </tr>
                                  <tr>
                                   <td align="center"><strong>Advance Info Service PLC.</strong></td>
                                  </tr>
                                  <tr>
                                   <td align="center"><strong>IPFM Performance Report</strong></td>
                                  </tr>    
                                  <tr>
                                   <td align="center">
                                   	<strong>Request Date : <h:outputText id="dateFrom" value="#{ipReportDetailBean.ipReportList.startDate}"><f:convertDateTime pattern="dd/MM/yyyy"/></h:outputText>
														 - <h:outputText id="dateTo" value="#{ipReportDetailBean.ipReportList.endDate}"><f:convertDateTime pattern="dd/MM/yyyy"/></h:outputText></strong></td>
                                  </tr> 
                                  <tr>
                                   <td align="center">&nbsp;</td>
                                  </tr> 
                                  <tr>
                                   <td align="left"><strong>UR : Request Network Config</strong></td>
                                  </tr> 
                                  <tr>
                                   <td align="center">&nbsp;</td>
                                  </tr> 
								</table>
							 </rich:panel>
							</td>
						</tr>
						<tr>
							<td>							
							<rich:dataTable width="100%" id="result1ListTable" cellpadding="1" cellspacing="0" border="0"
								var="detail1" value="#{ipReportDetailBean.result1List}" reRender="scrollresult1ListTable" 
								  
								 rows="#{ipReportDetailBean.rowPerPage1}"
								styleClass="DetailForm" rowKeyVar="index" headerClass="tableHeader">
								<f:facet name="header" >
									<rich:columnGroup  styleClass="tableHeader">
						            <rich:column rowspan="3" styleClass="tableHeader">User</rich:column>									
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="All Tab" styleClass="contentform tableHeaderText"/></rich:column>								
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="Firewall" styleClass="contentform tableHeaderText"/></rich:column>								
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="AccessList CDND" styleClass="contentform tableHeaderText"/></rich:column>								
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="AccessList TNP" styleClass="contentform tableHeaderText"/></rich:column>							
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="Physical Interface" styleClass="contentform tableHeaderText"/></rich:column>							
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="Interface Gateway" styleClass="contentform tableHeaderText"/></rich:column>							
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="Routing" styleClass="contentform tableHeaderText"/></rich:column>							
						            <rich:column colspan="6" styleClass="tableHeader"><h:outputText value="F5" styleClass="contentform tableHeaderText"/></rich:column>	
						            <rich:column breakBefore="true" colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>	
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>											
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>											
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>	
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>		
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Wait" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Reject" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column colspan="2" styleClass="tableHeader"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>	
						            <rich:column breakBefore="true" styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>	
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>	
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
						            <rich:column styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
						            <rich:column styleClass="tableHeader"><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>							
						        </rich:columnGroup>
								</f:facet>	
								<rich:columnGroup  style="#{detail1[3]==1 ? 'background-color: #b8ccea;':''}">
								    <rich:column rendered="#{detail1[3]==1}"><h:outputText style="font:Bold; width: 200px;" value="#{detail1[2]}"/></rich:column>
								    <rich:column rendered="#{detail1[3]>1}"><rich:spacer width="15"/><h:outputText style="font:normal; width: 200px;" value="#{detail1[59]}"/></rich:column>								    
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink5" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[5]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="All"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
									</rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink6" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[6]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="All"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink7" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[7]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="All"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink8" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[8]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="All"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink9" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[9]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="All"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink10" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[10]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="All"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink11" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[11]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="FW"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink12" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[12]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="FW"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink13" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[13]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="FW"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink14" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[14]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="FW"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink15" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[15]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="FW"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink16" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[16]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="FW"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink17" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[17]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AL"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink18" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[18]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AL"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink19" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[19]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AL"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink20" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[20]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AL"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink21" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[21]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AL"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink22" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[22]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AL"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink23" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[23]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AT"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink24" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[24]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AT"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink25" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[25]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AT"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink26" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[26]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AT"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink27" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[27]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AT"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink28" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[28]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="AT"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink29" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[29]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="PI"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink30" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[30]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="PI"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink31" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[31]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="PI"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink32" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[32]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="PI"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink33" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[33]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="PI"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink34" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[34]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="PI"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink35" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[35]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="IG"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink36" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[36]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="IG"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink37" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[37]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="IG"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink38" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[38]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="IG"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink39" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[39]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="IG"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink40" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[40]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="IG"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink41" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[41]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="RT"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink42" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[42]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="RT"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink43" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[43]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="RT"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink44" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[44]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="RT"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink45" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[45]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="RT"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink46" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[46]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="RT"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink47" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[47]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="F5"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink48" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[48]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="F5"/>
											<a4j:actionparam name="action" value="Wait"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink49" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[49]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="F5"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink50" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[50]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="F5"/>
											<a4j:actionparam name="action" value="Reject"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>	
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink51" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[51]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="F5"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urLink52" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail1[52]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail1[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail1[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail1[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail1[3]}"/>
											<a4j:actionparam name="userId" value="#{detail1[4]}"/>
											<a4j:actionparam name="urType" value="NC"/>
											<a4j:actionparam name="urTab" value="F5"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
							    </rich:columnGroup>
							</rich:dataTable>	
							</td>
						</tr>
						<tr>
							<td><br/></td>
						</tr>
						<tr>
							<td>
								<rich:dataTable width="20%" id="result2ListTable" cellpadding="1" cellspacing="0" border="0" align="left"
									var="detail2" value="#{ipReportDetailBean.result2List}" reRender="scrollresult2ListTable" 
									  
									 rows="#{ipReportDetailBean.rowPerPage2}"
									rowClasses="odd,even" styleClass="DetailForm" rowKeyVar="index" headerClass="tableHeader">
									<f:facet name="header">
										<rich:columnGroup>
								            <rich:column styleClass="tableHeader">Total UR Request Network config</rich:column>		
								            <rich:column styleClass="tableHeader">Indue</rich:column>	
								            <rich:column styleClass="tableHeader">Overdue</rich:column>						        
								        </rich:columnGroup>
							        </f:facet>
									<rich:columnGroup>
									    <rich:column style="text-align:left;"><h:outputText value="#{detail2[4]}"/></rich:column>
									    <rich:column style="text-align:center;"><h:outputText value="#{detail2[1]}"/></rich:column>
									    <rich:column style="text-align:center;"><h:outputText value="#{detail2[2]}"/></rich:column>
								    </rich:columnGroup>

								</rich:dataTable>							
							</td>
						</tr>
						<tr>
							<td><br/></td>
						</tr>
						<tr>
							<td>
							<rich:dataTable width="45%" id="result4ListTable" cellpadding="1" cellspacing="0" border="0" align="left"
								var="detail4" value="#{ipReportDetailBean.result4List}" reRender="scrollresult4ListTable" 
								  
								 rows="#{ipReportDetailBean.rowPerPage4}"
								styleClass="DetailForm" rowKeyVar="index" headerClass="tableHeader">
								<f:facet name="header">
									<rich:columnGroup  styleClass="tableHeader">
							            <rich:column rowspan="2"><h:outputText value="Action User" styleClass="contentform tableHeaderText"/></rich:column>									
							            <rich:column colspan="2"><h:outputText value="Complete" styleClass="contentform tableHeaderText"/></rich:column>								
							            <rich:column colspan="2"><h:outputText value="Wait for Manager Approve" styleClass="contentform tableHeaderText"/></rich:column>								
							            <rich:column colspan="2"><h:outputText value="Wait for Assign" styleClass="contentform tableHeaderText"/></rich:column>								
							            <rich:column breakBefore="true" styleClass="tableHeader"><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
							            <rich:column><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
							            <rich:column><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
							            <rich:column><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>
							            <rich:column><h:outputText value="Indue" styleClass="contentform tableHeaderText"/></rich:column>									
							            <rich:column><h:outputText value="Overdue" styleClass="contentform tableHeaderText"/></rich:column>						        
							        </rich:columnGroup>
						        </f:facet>
								<rich:columnGroup  style="#{detail4[3]==1 ? 'background-color: #b8ccea;':''}">							
								    <rich:column rendered="#{detail4[3]==1}"><h:outputText style="font:Bold; width: 200px;" value="#{detail4[2]}"/></rich:column>
								    <rich:column rendered="#{detail4[3]>1}"><rich:spacer width="15"/><h:outputText style="font:normal; width: 200px;" value="#{detail4[17]}"/></rich:column>								    
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urIPLink5" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail4[5]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail4[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail4[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail4[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail4[3]}"/>
											<a4j:actionparam name="userId" value="#{detail4[4]}"/>
											<a4j:actionparam name="urType" value="IP"/>
											<a4j:actionparam name="urTab" value="Complete"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urIPLink6" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail4[6]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail4[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail4[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail4[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail4[3]}"/>
											<a4j:actionparam name="userId" value="#{detail4[4]}"/>
											<a4j:actionparam name="urType" value="IP"/>
											<a4j:actionparam name="urTab" value="Complete"/>
											<a4j:actionparam name="action" value="Complete"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urIPLink7" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail4[7]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail4[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail4[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail4[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail4[3]}"/>
											<a4j:actionparam name="userId" value="#{detail4[4]}"/>
											<a4j:actionparam name="urType" value="IP"/>
											<a4j:actionparam name="urTab" value="WaitManager"/>
											<a4j:actionparam name="action" value="WaitManager"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>	
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urIPLink8" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail4[8]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail4[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail4[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail4[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail4[3]}"/>
											<a4j:actionparam name="userId" value="#{detail4[4]}"/>
											<a4j:actionparam name="urType" value="IP"/>
											<a4j:actionparam name="urTab" value="WaitManager"/>
											<a4j:actionparam name="action" value="WaitManager"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urIPLink9" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail4[9]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail4[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail4[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail4[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail4[3]}"/>
											<a4j:actionparam name="userId" value="#{detail4[4]}"/>
											<a4j:actionparam name="urType" value="IP"/>
											<a4j:actionparam name="urTab" value="WaitAssign"/>
											<a4j:actionparam name="action" value="WaitAssign"/>
											<a4j:actionparam name="status" value="Indue"/>
							             </a4j:commandLink>
							        </rich:column>
								    <rich:column style="text-align:center;">
										 <a4j:commandLink id="urIPLink10" reRender="IPRUR004_Report_URList" action="#{ipReportURAction.popupURList}"  
											oncomplete="#{rich:component('IPRUR004_Report_URList')}.show(); return false" >
											<h:outputText value="#{detail4[10]}" styleClass="contentform" ></h:outputText>
											<a4j:actionparam name="reportId" value="#{detail4[0]}"/>
											<a4j:actionparam name="groupSeq" value="#{detail4[1]}"/>
											<a4j:actionparam name="groupName" value="#{detail4[2]}"/>
											<a4j:actionparam name="dataLevel" value="#{detail4[3]}"/>
											<a4j:actionparam name="userId" value="#{detail4[4]}"/>
											<a4j:actionparam name="urType" value="IP"/>
											<a4j:actionparam name="urTab" value="WaitAssign"/>
											<a4j:actionparam name="action" value="WaitAssign"/>
											<a4j:actionparam name="status" value="Overdue"/>
							             </a4j:commandLink>
							        </rich:column>
							    </rich:columnGroup>
						</rich:dataTable>
							</td>
						</tr>
						<tr>
							<td><br/></td>
						</tr>
						<tr>
							<td>
								<rich:dataTable width="20%" id="result5ListTable" cellpadding="1" cellspacing="0" border="0" align="left"
									var="detail5" value="#{ipReportDetailBean.result5List}" reRender="scrollresult5ListTable" 
									  
									 rows="#{ipReportDetailBean.rowPerPage5}"
									rowClasses="odd,even" styleClass="DetailForm" rowKeyVar="index" headerClass="tableHeader">
									<f:facet name="header">
										<rich:columnGroup>
								            <rich:column styleClass="tableHeader">Total UR Request IP</rich:column>		
								            <rich:column styleClass="tableHeader">Indue</rich:column>	
								            <rich:column styleClass="tableHeader">Overdue</rich:column>						        
								        </rich:columnGroup>
							        </f:facet>
									<rich:columnGroup>
									    <rich:column style="text-align:left;"><h:outputText value="#{detail5[4]}"/></rich:column>
									    <rich:column style="text-align:center;"><h:outputText value="#{detail5[1]}"/></rich:column>
									    <rich:column style="text-align:center;"><h:outputText value="#{detail5[2]}"/></rich:column>
								    </rich:columnGroup>

								</rich:dataTable>							
							</td>
						</tr>
						<tr>
							<td><br/></td>
						</tr>
					</table>
					</a4j:form>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td><br/></td>
		</tr>
		<tr>
		<td>
			<h:graphicImage value="../images/icon_required.gif" style="border:0" />
			<h:outputText value="กรณีที่ UR Request IP ถูก Reject จะไม่ถูกนับในรายงานฉบับนี้" style="color:#0000FF;"/>
		</td>
		</tr>
		<tr>
		<td>
			<h:graphicImage value="../images/icon_required.gif" style="border:0" />
			<h:outputText value="N/A หมายถึง ไม่มี Action ดังกล่าวอยู่ใน IPFM Flow ที่ออกแบบไว้" style="color:#0000FF;"/>
			&nbsp;
			<div style="float:right;">	
				<a4j:commandButton value="Close" styleClass="rich-button" immediate="true" onclick="self.close();">
				</a4j:commandButton>			
			</div>
		</td>
		</tr>
	</table>
	</rich:page>

	</body>
	<jsp:directive.include file="IPRUR004_Report_URList.jsp"/>
	</f:subview>
</html>