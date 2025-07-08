<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function viewFile(){
		document.getElementById('DetailForm:viewFile').click();
	}
	function initFile(path,fileName){
		document.getElementById('DetailForm:pathParam').value=path;
		document.getElementById('DetailForm:fileNameParam').value=fileName;
	}
</script>
<a4j:jsFunction name="renderAttachTable1" ajaxSingle="true"
	action="#{attachFileNWAction.refreshByCategory}"
 	reRender="tblAttachFile1">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="category"/>
</a4j:jsFunction>

<a4j:jsFunction name="deleteAttachFile1" ajaxSingle="true"
	action="#{attachFileNWAction.deleteByCategory}"
 	reRender="tblAttachFile1" oncomplete="Richfaces.hideModalPanel('confirmDlg1')">
 	<a4j:actionparam name="urNo"/> 	
 	<a4j:actionparam name="category"/>
 	<a4j:actionparam name="seqNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="showErrorDlg1" ajaxSingle="true"
	action="#{attachFileNWAction.setMessageError}"
 	reRender="errorFileAttach1" oncomplete="Richfaces.showModalPanel('errorFileAttach1')">
 	<a4j:actionparam name="errNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="showDuplicateFile" ajaxSingle="true"
	action="#{attachFileNWAction.setMessageError}"
 	reRender="errorFileAttach1" oncomplete="Richfaces.showModalPanel('errorFileAttach1')">
 	<a4j:actionparam name="errNo"/>
</a4j:jsFunction>
<div id="testid-get"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="100%">
			<input type="hidden" id="deleteURNo1" name="deleteURNo" value="">
			<input type="hidden" id="deleteSeq1" name="deleteSeq" value="">
			<a4j:region>
					
			<rich:dataTable id="tblAttachFile1" width="100%" cellpadding="1" cellspacing="0" border="0"
				rowClasses="odd,even" columnsWidth="30,100%"
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{attachFileNWAction.listAttach}" var="attach">
				
				<rich:column style="vertical-align:top;">
					<f:facet name="header"> 
						<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputLink value="#" onclick="deleteFileIndex('#{attach.id.urNo}','#{attach.id.seq}','1')">
							<img src="../images/p_delete.gif" border="0">
						</h:outputLink>
					</div>
				</rich:column>
				
				<rich:column style="vertical-align:top;">
					<f:facet name="header"> 
						<h:outputText value="File Name" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="left">
						<h:outputText rendered="true" value="#{attach.fileName}" styleClass="contentform" />
						<a4j:commandLink rendered="false" value="#{attach.fileName}" action="#{userReqIPAction.checkViewFile}" onclick="initFile('#{attach.fileLocation}','#{attach.fileName}')" styleClass="contentform" reRender="errorMsg" oncomplete="alert('check complete');#{errorMessages?'':'viewFile();'}">
							<a4j:actionparam name="path" value="#{attach.fileLocation}" />
							<a4j:actionparam name="fileName" value="#{attach.fileName}" />
						</a4j:commandLink>
					</div>
				</rich:column>
			</rich:dataTable>
			<h:inputHidden id="pathParam" value=""/>
            <h:inputHidden id="fileNameParam" value=""/>
			<h:commandLink id="viewFile" style="display:none;" action="#{userReqIPAction.viewFile}">
			 	<f:param name="path" value="#{pathParam}"/>
			 	<f:param name="fileName" value="#{fileNameParam}"/>
			</h:commandLink>
			</a4j:region>
		</td>
		<td align="left" valign="top" style="padding:0;">
			<div class="fileinputs" >
				<span id="fileInput1" style="height:24px;width:62px;">
					<input id="attachFileIndex1" type="file" class="hiddenInputFile" name="upfile" onchange="attachFileIndex(this,1)" style="width:62px; height:24px;"/>
				</span>
				<div class="fakefile">
					<input type="button" id="btnAttach1" value="Browse" class="rich-button" style="width:62px;">
				</div>
			</div>	
		</td>
	</tr>
</table>

<rich:modalPanel id="errorFileAttach1" autosized="true"
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
	<f:subview id="popupErrorDlg1">	
	
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" >
					<h:outputText id="errorMessage1" styleClass="contentlabelform" escape="false" 
					style="color:red" value="#{attachFileNWAction.errorMsg}"></h:outputText>						
				</h:panelGrid>
			</td>
		</tr>
		<tr>
			<td>
				<h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="OK" styleClass="rich-button" id="btnOK">
						<rich:componentControl for="errorFileAttach1" attachTo="btnOK" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGrid>
			</td>
		</tr>
	</table>	
</f:subview>					
	
</rich:modalPanel>

<rich:modalPanel id="confirmDlg1" width="350" height="100">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink1"/>
	        <rich:componentControl for="confirmDlg1" attachTo="hidelink1" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="ต้องการลบ Attach File นี้ ใช่หรือไม่" styleClass="contentform" style="font-weight:bold;"></h:outputText></td></tr>
        <tr><td align="center">
        	<input type="button" id="btnYes1" value="Yes" class="rich-button" onclick="deleteConfirmIndex('NW','1')">
        	<input type="button" id="btnNo1" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDlg1');">
        </td></tr>
    </table>
</rich:modalPanel>



	