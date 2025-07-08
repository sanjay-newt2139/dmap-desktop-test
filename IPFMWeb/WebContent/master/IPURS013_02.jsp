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
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<table width="97%" border="0" cellpadding="1" cellspacing="1"
						bgcolor="#CCCCCC" class="thtext_detail2">
						<tr>
							<td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Master Table Management</span></strong></td>
						</tr>
						<tr>
							<td>
								<a4j:form id="CriteriaForm">
								 <rich:panel>	
									<table width="97%" border="0" cellpadding="0" cellspacing="0"
										class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right"><strong>Referance Table<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
											<td align="left" >
                                                 <h:inputText id="referTable" value="#{masterTableBean.masterTBL.refKey}"  rendered="#{masterTableBean.disabledForEdit==false}" size="20" style="text-align:cente"></h:inputText>&nbsp;
												 <h:outputText value="#{masterTableBean.masterTBL.refTable}" rendered="#{masterTableBean.disabledForEdit==true}"></h:outputText>
											</td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="referTable" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Referance Key<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="referKey" value="#{masterTableBean.masterTBL.refKey}"  rendered="#{masterTableBean.disabledForEdit==false}" size="20" style="text-align:cente"></h:inputText>&nbsp;
                                                 <h:outputText value="#{masterTableBean.masterTBL.refKey}" rendered="#{masterTableBean.disabledForEdit==true}"></h:outputText>
										   </td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="referKey" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Description<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="description" value="#{masterTableBean.masterTBL.refDesc}" size="50" style="text-align:cente"></h:inputText>&nbsp;  	
										   </td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Short Description&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="shortDesc" value="#{masterTableBean.masterTBL.shortDesc}" size="50" style="text-align:cente"></h:inputText>&nbsp;	
										   </td>
										</tr>
										<tr><td height="10"></td></tr>
										<tr>
										   <td></td>
										   <td align="left">
										      <a4j:commandButton id="btnAdd" value="Add Data" styleClass="rich-button" action="#{masterTableAction.createMasterTBL}" rendered="#{masterTableBean.displayForCreate}" reRender="CriteriaForm,errorMsg"/>&nbsp;
										      <a4j:commandButton id="btnUpdate" value="Update Data" styleClass="rich-button" action="#{masterTableAction.createMasterTBL}"  rendered="#{masterTableBean.displayForEdit}" reRender="CriteriaForm,errorMsg"/>&nbsp;
										      <a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" action="#{masterTableAction.init}"  reRender="CriteriaForm,errorMsg,systemParameterTable"> 
										           <a4j:actionparam name="programIDParam" value="IPURS013"/>
										      </a4j:commandButton>
										  </td>
										</tr>
									</table>
                                  </rich:panel>	
																		
									</a4j:form>
								</td>
							</tr>
						</table>
						<br>
						<br>
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
	
	<rich:modalPanel id="confirmDialog" autosized="true">			
		<a4j:form id="delConfirmDialog">
			<table width="150px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">
							<h:outputText value="Do you want to delete this Range IP?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="2" styleClass="contentlabelform">
							<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
								action="#{rangeIPAction.delete}" reRender="groupSearchResult" >
								<rich:componentControl for="confirmDialog" operation="hide" event="onclick"  />
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
