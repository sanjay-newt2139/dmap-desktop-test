<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>


<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>

<style type="text/css">
<!--
	.rich-panel-body-userreqip{padding:0px 15px 0px 15px; background-color: #F5F5F5; background-image: url(''); width:100%;}
	.rich-panel-body-planningreqip{padding:0px 15px 0px 15px; background-color: #F5F5F5; background-image: url(''); width:100%;}
	.rich-panel-body-networknc{padding:0px 15px 0px 15px; background-color: #F5F5F5; background-image: url(''); width:100%;}
	.rich-panel-body {padding:0px 15px 0px 15px; background-image: url(''); width:100%;}
	.rich-stglpanel-body{padding:0px; margin-bottom:0px; background-color: #fafafa; background-image: url(''); width:100%;}
	.rich-stglpanel{padding:0px; margin-bottom:0px; background-color: #fafafa;}
-->
</style>
</head>
<body style="width:100%;overflow:hidden;">

<f:view>
	<f:subview id="menu">
		<jsp:include page="menu.jsp" />
	</f:subview>
	<f:subview id="error">
		<jsp:include page="errorModal.jsp" />
	</f:subview>
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
				  	<h:form id="DetailForm">
			  		<table width="97%" border="0" cellpadding="0" cellspacing="0">
					   	<tr>
							<td>
								<h:panelGrid rendered="#{inboxBean.treeType=='TODOLIST'}" width="100%" columns="1" cellspacing="0" cellpadding="0">
									<h:panelGroup rendered="#{(empty inboxBean.urType || inboxBean.urType==inboxBean.urTypeUserReq) && inboxBean.userReqIPSize>0}" >
										<rich:panel style="padding:0px;"  bodyClass="rich-panel-body-userreqip">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.urTypeUserReqDesc} (#{inboxBean.userReqIPSize})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%;" >
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/UserRequestIPToDoList.jsp"/>
													<rich:spacer height="5" />
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>
									<h:panelGroup rendered="#{(empty inboxBean.urType || inboxBean.urType==inboxBean.urTypePlanning) && inboxBean.planningReqIPSize>0}" >
										<rich:panel style="padding:0px;" bodyClass="rich-panel-body-planningreqip">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.urTypePlanningDesc} (#{inboxBean.planningReqIPSize})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%">
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/PlanningRequestIPToDoList.jsp"/>
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>
									<h:panelGroup rendered="#{(empty inboxBean.urType || inboxBean.urType==inboxBean.urTypeNetwork) && inboxBean.networkConfigSize>0}">
										<rich:panel style="padding:0px;"  bodyClass="rich-panel-body-networknc">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.urTypeNetworkDesc} (#{inboxBean.networkConfigSize})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%">
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/NetworkConfigToDoList.jsp"/>
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>
								</h:panelGrid>
								<h:panelGrid rendered="#{inboxBean.treeType=='WATCHLIST'}" width="100%" columns="1" cellspacing="0" cellpadding="0">
									<h:panelGroup rendered="#{(empty inboxBean.urType || inboxBean.urType==inboxBean.urTypeUserReq) && fn:length(inboxBean.ipvWlUserReqList)>0}" >
										<rich:panel style="padding:0px;" bodyClass="rich-panel-body-userreqip">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.ipvWlUserReqList[0].title1} (#{fn:length(inboxBean.ipvWlUserReqList)})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%">
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/UserRequestIPWatchList.jsp"/>
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>
									<h:panelGroup rendered="#{(empty inboxBean.urType || inboxBean.urType==inboxBean.urTypePlanning) && fn:length(inboxBean.ipvWlPlanningReqList)>0}" >
										<rich:panel style="padding:0px;" bodyClass="rich-panel-body-planningreqip">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.ipvWlPlanningReqList[0].title1} (#{fn:length(inboxBean.ipvWlPlanningReqList)})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%">
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/PlanningRequestIPWatchList.jsp"/>
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>	
									<h:panelGroup rendered="#{(empty inboxBean.urType || inboxBean.urType==inboxBean.urTypeNetwork) && fn:length(inboxBean.ipvWlNetworkConfigList)>0}" >
										<rich:panel style="padding:0px;" bodyClass="rich-panel-body-networknc">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.ipvWlNetworkConfigList[0].title1} (#{fn:length(inboxBean.ipvWlNetworkConfigList)})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%">
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/NetworkConfigWatchList.jsp"/>
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>		
								</h:panelGrid>
								
								<h:panelGrid rendered="#{inboxBean.treeType=='MONITOR'}" width="100%" columns="1" cellspacing="0" cellpadding="0">
									<h:panelGroup rendered="#{fn:length(inboxBean.ipvMntNetworkConfigList)>0}">
										<rich:panel style="padding:0px;" bodyClass="rich-panel-body-networknc">
											<f:facet name="header"> 
												<h:panelGroup style="height:25px; padding-top:2px;">
													<img src="../images/ico_member.gif" alt="" width="23" height="15">
													<h:outputText value="#{inboxBean.ipvMntNetworkConfigList[0].title1} (#{fn:length(inboxBean.ipvMntNetworkConfigList)})" styleClass="ms10w"/>
												</h:panelGroup>
											</f:facet>
											<h:panelGroup style="width:100%">
												<h:panelGrid width="100%" columns="1" cellspacing="0" cellpadding="0">
													<jsp:directive.include file="inbox/NetworkConfigMonitorList.jsp"/>
												</h:panelGrid>
											</h:panelGroup>
										</rich:panel>
										<rich:spacer height="10" />
									</h:panelGroup>		
								</h:panelGrid>								
							</td>
						</tr>
					</table>
					</h:form>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	
	<f:subview id="footer">
		<jsp:include page="progress.jsp" />
	</f:subview>
</f:view>
</body>
</html>