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
</head>
<body style="margin: 0 0">
<f:view>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td>
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
								class="ms8red">Parameter Setup Import</font></span></td>
						</tr>
					</table>
					<table width="99%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="7"><img src="../images/bg-blue-l.png"></td>
							<td height="32" background="../images/bg-blue-m.png" class="ms10w"><strong>
							IPFMMS003:Parameter Setup Import</strong></td>
							<td width="7" align="right"><img src="../images/bg-blue-r.png"></td>
						</tr>
					</table>
					<table width="97%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
							<jsp:include page="../home/errorModal.jsp" /> 
							<a4j:form id="ImportForm">
								<rich:simpleTogglePanel switchType="client"
									label="Import Parameter File">
									<h:panelGrid id="groupImportFile" columns="2" styleClass="contentlabelform" >
										<h:outputText value="Import File (Excel) :" style="font-weight: bolder;" >
											<h:graphicImage value="../images/icon_required.gif" style="border:0" />
										</h:outputText>
										<rich:fileUpload fileUploadListener="#{systemParameterAction.listener}"
                							maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
                							id="upload"
                							immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
                							acceptedTypes="#{systemParameterFileUploadBean.acceptedTypes}" 
                							allowFlash="#{systemParameterFileUploadBean.useFlash}"
											sizeErrorLabel="File Size Over!" 
                							sizeErrorLabelClass="contentform"
                							uploadListClass="contentform"
                							transferErrorLabelClass="contentform"
                							styleClass="contentform"
                							fileEntryClass="contentform"
                							fileEntryControlClass="contentform"
                							progressLabelClass="contentform"
                							addButtonClass="contentform"
                							uploadButtonClass="contentform"
                							listHeight="50" autoclear="true"
                							listWidth="500" >
                							<a4j:support event="onuploadcomplete"  reRender="groupImportCommand" />
            							</rich:fileUpload>
									</h:panelGrid>
									<h:panelGrid id="groupImportCommand" columns="2" styleClass="contentlabelform" >
										<h:commandButton id="btnCancelUpload" styleClass="rich-button" value="Cancel" 
				          					action="#{systemParameterAction.cancel}" />
				          				<a4j:commandButton id="btnImport" styleClass="rich-button" value="Re-Upload" action="#{systemParameterAction.clickReImport}" 
				          					rendered="#{systemParameterFileUploadBean.size>0}" reRender="groupImportFile" />
									</h:panelGrid>
								</rich:simpleTogglePanel>
								<rich:spacer height="5" />
								<rich:simpleTogglePanel switchType="client" id="groupResult"
									label="Import Parameter Data">
								</rich:simpleTogglePanel>
								<rich:spacer height="10" />
							</a4j:form></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>
	
	
</f:view>
</body>
</html>
