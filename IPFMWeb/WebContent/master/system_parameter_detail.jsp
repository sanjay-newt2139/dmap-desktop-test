<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<title>IP Flow Management</title>
<link
	href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>	
</head>
<body>
<f:view>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td >
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<f:subview id="menu">
					<jsp:include page="../home/menu.jsp" />
				</f:subview>
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<table width="99%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="35"><span class="ms8"><img
								src="../images/ic-pencil.png" hspace="9" ><font
								class="ms8blue">Master Setup &gt;&gt;</font>&nbsp;&nbsp;<font
								class="ms8red">Parameter Setup Detail</font></span></td>
						</tr>
					</table>
					<table width="99%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="7"><img src="../images/bg-blue-l.png"></td>
							<td height="32" background="../images/bg-blue-m.png" class="ms10w"><strong>
							IPFMMS002:Parameter Setup Detail</strong></td>
							<td width="7" align="right"><img src="../images/bg-blue-r.png"></td>
						</tr>
					</table>
					<table width="97%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
							<jsp:include page="../home/errorModal.jsp" />
							<a4j:form id="DetailForm">
								<rich:simpleTogglePanel switchType="client"
									label="Detail">
									<h:panelGrid id="groupDetail" columns="2" styleClass="contentlabelform" >
										<h:outputText value="Group :" style="font-weight: bolder;">
											<h:graphicImage value="../images/icon_required.gif" style="border:0" />
										</h:outputText>
										<h:panelGroup>
										<rich:comboBox id="group" defaultLabel="Enter some value" enableManualInput="true" 
											styleClass="contentform" itemClass="contentform" itemSelectedClass="contentform" 
											value="#{systemParameterBean.ipParameter.parameterGroup}" disabled="#{systemParameterBean.disabledForEdit}" >
											<f:selectItems value="#{systemParameterBean.groupList}"/>
										</rich:comboBox>										
										<h:message for="group" style="color:red"/>
										</h:panelGroup>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="Sub Group :" style="font-weight: bolder;">
										</h:outputText>
										<h:inputText id="subGroup" value="#{systemParameterBean.ipParameter.parameterSubGroup}"
											maxlength="10" disabled="#{systemParameterBean.disabledForEdit}">
										</h:inputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="String Value :" style="font-weight: bolder;">
										</h:outputText>
										<h:inputText id="stringValue" value="#{systemParameterBean.ipParameter.stringValue}"
											maxlength="100" >
										</h:inputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="Numeric Value :" style="font-weight: bolder;">
										</h:outputText>
										<h:inputText id="numericValue" value="#{systemParameterBean.ipParameter.numericValue}" 
											maxlength="6" style="text-align:right" onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											onchange="numberformat.formatDecimalObject(this)">
										</h:inputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="" style="font-weight: bolder;">
										</h:outputText>
										<h:outputText value="Boolean Value :" style="font-weight: bolder;">
										</h:outputText>
										<h:selectOneRadio id="booleanValue" styleClass="contentform" value="#{systemParameterBean.ipParameter.booleanValue}">
											<f:selectItem itemLabel="True" itemValue="T" />
											<f:selectItem itemLabel="False" itemValue="F" />
										</h:selectOneRadio>
									</h:panelGrid>
									<br/>
									<h:panelGrid id="groupActionButton" columns="3" styleClass="contentlabelform" >
										<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"
											action="#{systemParameterAction.createSystemParameter}" rendered="#{systemParameterBean.displayForCreate}"
											reRender="DetailForm, errorMsg"  />
										<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
											action="#{systemParameterAction.updateSystemParameter}" rendered="#{systemParameterBean.displayForEdit}"
											reRender="DetailForm, errorMsg" />													
				          				<h:commandButton id="btnCancel" styleClass="rich-button" value="Cancel" 
				          					action="#{systemParameterAction.cancel}" />
									</h:panelGrid>
								</rich:simpleTogglePanel>
								<rich:spacer height="5" />
							</a4j:form></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<f:subview id="footer" >
		<jsp:include page="../home/progress.jsp" />
	</f:subview>
	
</f:view>
</body>
</html>
