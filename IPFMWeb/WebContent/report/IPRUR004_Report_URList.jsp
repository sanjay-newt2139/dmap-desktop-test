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
<f:subview id="popupModalSubview_list"> 
<rich:modalPanel id="IPRUR004_Report_URList" binding="#{ipReportURDetailBean.popupModal}"
	styleClass="contentform"  height="550" width="800" label="Report URList" style="height: 520px;" >
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Report URList</span></strong>
		</h:panelGroup>	
	</f:facet>
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPRUR004_Report_URList" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	<body style="overflow: scroll;">
    <div id="container" style="height: 530px;">
	<rich:panel style="height: 530px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">IPFM Performance Report : UR List</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								 <rich:panel id="groupSearchCriteria" >	
									<table width="50%" align="center" border="0" class="thtext_detail">
										<tr class="inputRow">
											<td class="labelStyle" height="25"><strong>UR Type&nbsp;:&nbsp;</strong></td>
											<td align="left" ><h:outputText value="#{ipReportURDetailBean.urTypeName}"/>-<h:outputText value="#{ipReportURDetailBean.urTypeTab}"/></td>
										</tr>	
										<tr class="inputRow">
											<td class="labelStyle" height="25"><strong>UR Status&nbsp;:&nbsp;</strong></td>
											<td align="left" ><h:outputText value="#{ipReportURDetailBean.action}"/>-<h:outputText value="#{ipReportURDetailBean.status}"/></td>
										</tr>
										<tr class="inputRow">
											<td class="labelStyle" height="25"><strong>Team/User&nbsp;:&nbsp;</strong></td>
											<td align="left" ><h:outputText value="#{ipReportURDetailBean.teamUser}"/>-<h:outputText value="#{ipReportURDetailBean.userName}"/></td>
										</tr>		
										<tr>
											<td colspan="2">
											<rich:dataTable width="100%" id="urListTable" cellpadding="1" cellspacing="0" border="0" align="center"
												var="detail" value="#{ipReportURDetailBean.urList}" reRender="scrollurListTable" 
												  
												 rows="#{ipReportURDetailBean.rowPerPage}"
												rowClasses="odd,even" styleClass="DetailForm" rowKeyVar="index" headerClass="tableHeader">
												<f:facet name="header">
													<rich:columnGroup>
											            <rich:column styleClass="tableHeader">UR No.</rich:column>						        
											        </rich:columnGroup>
										        </f:facet>
												<rich:columnGroup>
												    <rich:column style="text-align:left;"><h:outputText value="#{detail}"/></rich:column>
											    </rich:columnGroup>
												<f:facet name="footer">
													<rich:columnGroup>
													<rich:column>Total : <h:outputText value="#{fn:length(ipReportURDetailBean.urList)}"/> records
														<rich:datascroller immediate="true" rendered="true" align="right" for="urListTable"
															maxPages="#{ipReportURDetailBean.maxPage}" id="scrollurListTable" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipReportURDetailBean.fastStepPage}"
															style="background-color: #cccccc;"/>
													</rich:column>
													</rich:columnGroup>				
												</f:facet>
											</rich:dataTable> 
											</td>
										</tr>	
									</table>
                                  </rich:panel>	
							</td>
						</tr>
					</table>&nbsp;
					<div style="float:right;">
						<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
							<rich:componentControl for="IPRUR004_Report_URList" operation="hide" event="onclick" />
						</a4j:commandButton>
					</div>
					</a4j:form>
					</td>
				</tr>
			</table>
	</rich:panel>
	</div>
	</body>
	</rich:modalPanel>
	</f:subview>
</html>