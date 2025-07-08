<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
	/*
	.rich-fileupload-list-decor{padding:0; margin:0; border:none; background-color:transparent;}
	.rich-fileupload-toolbar-decor{padding:0; margin:0; border:none;}
	.rich-fileupload-button-border{padding:0; margin:0; border:none;}
	.rich-fileupload-button-content{font-weight:bold; color:#FFFFFF;}
	.rich-fileupload-ico{background:url(''); padding: 1px 2px 1px 2px; margin: 0;}
	.rich-fileupload-ico-start{display:none;}
	.rich-fileupload-ico-stop{display:none;}
	.rich-fileupload-ico-clear{display:none;}
	*/
	.rich-fileupload-table-td {padding:0 0 0 10px; margin:0; height:15px;}
</style>
<rich:modalPanel id="IPSUR002_AttachFile" autosized="true" styleClass="contentform" height="100" minWidth="400" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Attach File"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPSUR002_AttachFile" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <h:form id="formUploadFile">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="80%" align="center" valign="top"><img src="../images/blank.gif" width="10" height="5"><br>
						  	<table width="100%" border="0" cellspacing="0" cellpadding="0"  >
								<tr>
									<td>	
								   		<rich:fileUpload id="uploadAttachFile"
						             			fileUploadListener="#{planningReqIPAction.uploadAttachFile}" 
						             			noDuplicate="true" maxFilesQuantity="99"
						             			transferErrorLabel="เกิดข้อผิดพลาดไม่สามารถอัพโหลดไฟล์นี้ได้" 
						             			addControlLabel="Browse" 
						             			sizeErrorLabel="ไฟล์มีขนาดเกิน 8MB" stopEntryControlLabel=" "
						             			cancelEntryControlLabel=" " clearControlLabel=" " 
						             			doneLabel="อัพโหลดเสร็จสมบูรณ์" allowFlash="#{fileUploadBean.useFlash}"
						             			acceptedTypes="doc, docx, xls, xlsx, vsd, jpg, gif, svg, zip, rar , 7z" 
						             			uploadListClass="contentform" styleClass="contentform"
						             			addButtonClass="contentform" autoclear="false" 
						             			listHeight="130" listWidth="100%"  >
						             			<a4j:support event="onuploadcomplete" action="#{planningReqIPAction.uploadComplete}" reRender="errorMsg,diagramTable" />
						             			<f:param name="urNo" value="#{planningReqIPBean.ipUrIpdetail.urNo}" />
						             			<f:param name="category" value="#{planningReqIPBean.attachType}" />
						             			<f:param name="description" value="Planning Request IP Attachment" />
						             			<f:param name="userId" value="#{userSession.ipUser.userId}" />
						             			<f:facet name="label">
													<h:outputText value="{_KB}KB from {KB}KB uploaded | {mm}:{ss}" />
												</f:facet>
					         		 	</rich:fileUpload>
									</td>
								</tr>
								<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" >
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td align="center">
											<a4j:commandButton value="Close" styleClass="rich-button" >
									    		<rich:componentControl for="IPSUR002_AttachFile" operation="hide" event="onclick" />
									    	</a4j:commandButton>
										</td>
									</tr>
								</table>
							</td>
						</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</h:form>
</rich:modalPanel>
