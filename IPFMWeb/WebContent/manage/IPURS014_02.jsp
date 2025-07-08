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
								class="style9">Parameter Management</span></strong></td>
						</tr>
						<tr>
							<td>
								<a4j:form id="CriteriaForm">
								 <rich:panel id="groupParameter">	
									<table width="97%" border="0" cellpadding="0" cellspacing="0"
										class="thtext_detail">
										<tr>
											<td width="15%" height="25" align="right"><strong>Parameter Group<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
											<td align="left" >	
													<rich:comboBox id="group" defaultLabel="Select some value" enableManualInput="false"  
													styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform"
													value="#{parameterManageBean.ipParameter.parameterGroup}" rendered="#{parameterManageBean.disabledForEdit==false}">
													<f:selectItems value="#{parameterManageBean.groupList}" />
												</rich:comboBox>
												<h:outputText value="#{parameterManageBean.ipParameter.parameterGroup}" rendered="#{parameterManageBean.disabledForEdit==true}"></h:outputText>
											</td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="group" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Parameter Subgroup<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
												<h:inputText id="subGroup" value="#{parameterManageBean.ipParameter.parameterSubGroup}"
											      maxlength="10" rendered="#{parameterManageBean.disabledForEdit==false}">
										       </h:inputText>
										       <h:outputText value="#{parameterManageBean.ipParameter.parameterSubGroup}" rendered="#{parameterManageBean.disabledForEdit==true}"></h:outputText>
										   </td>
										</tr>
										<tr>
											<td></td>
											<td align="left" >	
                                                 <h:message for="subGroup" style="color:red"/>
											</td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>String Value&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="stringValue" value="#{parameterManageBean.ipParameter.stringValue}" maxlength="100" ></h:inputText>  	
										   </td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Numeric Value&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
                                                 <h:inputText id="numericValue" value="#{parameterManageBean.ipParameter.numericValue}" maxlength="6" style="text-align:right" onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                                  onchange="numberformat.formatDecimalObject(this)">
										</h:inputText>	
										   </td>
										</tr>
										<tr>
										   <td width="15%" height="25" align="right"><strong>Boolean Value&nbsp;:&nbsp;</strong></td>
										   <td align="left" >
												<h:selectOneRadio id="booleanValue" styleClass="contentform" value="#{parameterManageBean.ipParameter.booleanValue}">
													<f:selectItem itemLabel="True" itemValue="T"  />
													<f:selectItem itemLabel="False" itemValue="F" />
												</h:selectOneRadio>
										   </td>
										</tr>										
										<tr><td height="10"></td></tr>
										<tr>
										   <td></td>
										   <td align="left">
										      <a4j:commandButton id="btnAdd" value="Add Data" styleClass="rich-button" action="#{parameterManageAction.createSystemParameter}" rendered="#{parameterManageBean.displayForCreate}"  reRender="CriteriaForm,errorMsg"/>&nbsp;
										      <a4j:commandButton id="btnUpdate" value="Update Data" styleClass="rich-button" action="#{parameterManageAction.updateIPParameter}" rendered="#{parameterManageBean.displayForEdit}" reRender="CriteriaForm,errorMsg"/>&nbsp;
										      <a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" action="#{parameterManageAction.init}"  reRender="CriteriaForm,errorMsg,systemParameterTable"> 
										           <a4j:actionparam name="programIDParam" value="IPURS014"/>
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
							<h:outputText value="Do you want to delete this Row ?" />
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
