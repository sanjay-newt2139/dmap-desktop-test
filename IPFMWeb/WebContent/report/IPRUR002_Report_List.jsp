
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

<f:view>
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />					
	</f:subview>
	<f:subview id="error">
		 <jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br><br>

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
								class="style9">IPFM Performance Report List</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
							<tr>
							<td align="center" >		 			
							<rich:panel id="groupSearchResult" style="height: 500;overflow: scroll;">				 			
							 	<h:panelGroup style="width:100%;">
									<rich:spacer/>
									<rich:dataTable width="45%" id="reportListTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{ipReportListBean.ipReportList}" reRender="scrollreportListTable" 
										  
										 rows="#{ipReportListBean.rowPerPage}"
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">	
									<rich:column width="10%" styleClass="valignTop" colspan="2">
										<f:facet name="header" >
											<h:outputText value="Report Name" styleClass="contentform tableHeaderText"/>
										</f:facet>
										<div>
										 <a4j:commandLink id="reportLink" reRender="IPRUR003_Report_Layout" action="#{ipReportLayoutAction.popupLayoutInfo}"  
							      	            oncomplete="window.open('#{ipfmConfigBean.homeUrl}/report/IPUR005_Report_Layout_popup.jsf','report','status=1,toolbar=0,location=0,menubar=1,resizable=1,scrollbars=1');" >
							      	           <h:outputText value="#{detail[1]}" styleClass="contentform" ></h:outputText>
							      	           <a4j:actionparam name="reportId" value="#{detail[0]}"/>
							             </a4j:commandLink>
										</div>
									</rich:column>	
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column>
												Total : <h:outputText value="#{fn:length(ipReportListBean.ipReportList)}"/> records
											</rich:column>
											<rich:column>
												<rich:datascroller immediate="true" rendered="true" align="right" for="reportListTable"
													maxPages="#{ipReportListBean.maxPage}" id="scrollreportListTable" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipReportListBean.fastStepPage}"
													style="background-color: #cccccc;"/>
											</rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>&nbsp;
									<div style="float:right;">
									<h:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
								    </div>		
								</h:panelGroup>	
								<rich:spacer/>										
							</rich:panel>
						</td>
						</tr>
					</table>		
					</td>
				</tr>
			</table>			
			</a4j:form>
			</td>
		</tr>
	</table>

	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>	
	<jsp:directive.include file="IPRUR003_Report_Layout.jsp"/>

</table>
</f:view>

</html>
