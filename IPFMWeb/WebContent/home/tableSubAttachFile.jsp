<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a4j:jsFunction name="renderAttachTable" ajaxSingle="true"
	action="#{fileAttachAction.refreshSub}"
 	reRender="tblAttachFile">
 	<a4j:actionparam name="urNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="deleteAttachFile" ajaxSingle="true"
	action="#{fileAttachAction.deleteSub}"
 	reRender="tblAttachFile" oncomplete="Richfaces.hideModalPanel('confirmDlg')">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="seqNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="showErrorDlg" ajaxSingle="true"
	action="#{fileAttachAction.setMessageError}"
 	reRender="errorFileAttach" oncomplete="Richfaces.showModalPanel('errorFileAttach')">
 	<a4j:actionparam name="errNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="showDuplicateFile" ajaxSingle="true"
	action="#{fileAttachAction.setMessageError}"
 	reRender="errorFileAttach" oncomplete="Richfaces.showModalPanel('errorFileAttach')">
 	<a4j:actionparam name="errNo"/>
</a4j:jsFunction>

<table width="400" border="0">
	<tr>
		<td width="300">
			<input type="hidden" id="deleteURNo" name="deleteURNo" value="">
			<input type="hidden" id="deleteSubURNo" name="deleteSubURNo" value="">
			<input type="hidden" id="deleteSeq" name="deleteSeq" value="">
			<a4j:region>
			<rich:dataTable width="100%" id="tblAttachFile" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{fileAttachAction.listSubAttach}" var="attach">
				
				<rich:column width="50" style="vertical-align:top;">
					<f:facet name="header"> 
						<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputLink value="#" onclick="deleteFile('#{attach.urNo}','#{attach.id.subUrNo}','#{attach.id.seq}')">
							<img src="../images/p_delete.gif" border="0">
						</h:outputLink>
					</div>
				</rich:column>
				
				<rich:column width="250" style="vertical-align:top;">
					<f:facet name="header"> 
						<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="left">
						<h:outputText value="#{attach.id.fileName}"/>
					</div>
				</rich:column>
			</rich:dataTable>
			
			</a4j:region>
		</td>
		<td width="100" align="left" valign="top">
			<div class="fileinputs">
				<span id="fileInput"><input id="attachFileIndex" type="file" class="hiddenInputFile" name="upfile" onchange="attachFile(this)" style="width:2px"/></span>
				<div class="fakefile">
					<input type="button" id="btnAttach" value="Browse" class="rich-button">
				</div>
			</div>	
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<h:graphicImage value="../images/icon_required.gif" style="border:0" />
			<h:outputText escape="false" value="กรุณาเลือกไฟล์ใหม่ โดยไฟล์ที่เลือกต้องมีขนาดไม่เกิน 8MB <br>และมีนามสกุล .doc, .docx, .xls, .xlsx, .vsd, .jpg, .gif, .svg, .zip, .rar, .7z เท่านั้น" style="color:#0000FF;"></h:outputText>
		</td>
	</tr>
</table>

<rich:modalPanel id="errorFileAttach" autosized="true"
	styleClass="contentform" width="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="IPFM Message"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideErrorIcon" style="cursor:pointer;" />
			<rich:componentControl for="errorFileAttach" attachTo="hideErrorIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupErrorDlg">	
	
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" >
					<h:inputHidden id="errorFlag" value="#{fileAttachAction.errorFlag}"></h:inputHidden>
					<h:outputText id="errorMessage" styleClass="contentlabelform" escape="false" 
					style="color:red" value="#{fileAttachAction.errorMsg}"></h:outputText>						
				</h:panelGrid>
			</td>
		</tr>
		<tr>
			<td>
				<h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="OK" styleClass="rich-button" id="btnOK">
						<rich:componentControl for="errorFileAttach" attachTo="btnOK" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGrid>
			</td>
		</tr>
	</table>	
</f:subview>					
	
</rich:modalPanel>

<rich:modalPanel id="confirmDlg" width="350" height="100">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
	        <rich:componentControl for="confirmDlg" attachTo="hidelink" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="ต้องการลบ Attach File นี้ ใช่หรือไม่" styleClass="contentform" style="font-weight:bold;"></h:outputText></td></tr>
        <tr><td align="center">
        	<input type="button" id="btnYes" value="Yes" class="rich-button" onclick="deleteConfirm()">
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDlg');">
        </td></tr>
    </table>
</rich:modalPanel>





	