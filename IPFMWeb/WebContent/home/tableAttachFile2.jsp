<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a4j:jsFunction name="renderAttachTable2" ajaxSingle="true"
	action="#{attachFileAFAction.refreshByCategory}"
 	reRender="tblAttachFile2">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="category"/>
</a4j:jsFunction>

<a4j:jsFunction name="deleteAttachFile2" ajaxSingle="true"
	action="#{attachFileAFAction.deleteByCategory}"
 	reRender="tblAttachFile2" oncomplete="Richfaces.hideModalPanel('confirmDlg2')">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="category"/>
 	<a4j:actionparam name="seqNo"/>
</a4j:jsFunction>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="100%">
			<input type="hidden" id="deleteURNo2" name="deleteURNo" value="">
			<input type="hidden" id="deleteSeq2" name="deleteSeq" value="">
			<a4j:region>
			<rich:dataTable id="tblAttachFile2" width="100%" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" columnsWidth="30,100%"
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{attachFileAFAction.listAttach}" var="attach">
				
				<rich:column style="vertical-align:top;">
					<f:facet name="header"> 
						<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputLink value="#" onclick="deleteFileIndex('#{attach.id.urNo}','#{attach.id.seq}','2')">
							<img src="../images/p_delete.gif" border="0">
						</h:outputLink>
					</div>
				</rich:column>
				
				<rich:column style="vertical-align:top;">
					<f:facet name="header"> 
						<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="left">
						<h:outputText value="#{attach.fileName}" styleClass="contentform"/>
					</div>
				</rich:column>
			</rich:dataTable>
			
			</a4j:region>
		</td>
		<td align="left" valign="top" style="padding:0;">
			<div class="fileinputs">
				<span id="fileInput2" style="height:24px;width:62px;"><input id="attachFileIndex2" type="file" class="hiddenInputFile" name="upfile" onchange="attachFileIndex(this,2)" style="width:62px; height:24px;"/></span>
				<div class="fakefile">
					<input type="button" id="btnAttach2" value="Browse" class="rich-button" style="width:62px;">
				</div>
			</div>	
		</td>
	</tr>
</table>

<rich:modalPanel id="confirmDlg2" width="350" height="100">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink2"/>
	        <rich:componentControl for="confirmDlg2" attachTo="hidelink2" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="ต้องการลบ Attach File นี้ ใช่หรือไม่" styleClass="contentform" style="font-weight:bold;"></h:outputText></td></tr>
        <tr><td align="center">
        	<input type="button" id="btnYes1" value="Yes" class="rich-button" onclick="deleteConfirmIndex('AF','2')">
        	<input type="button" id="btnNo1" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDlg2');">
        </td></tr>
    </table>
</rich:modalPanel>

	