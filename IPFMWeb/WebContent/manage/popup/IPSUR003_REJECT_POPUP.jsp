<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language='javascript'>
function submitRejectJob(){
	var remark = document.getElementById("mdlPMReject:formRegionMultiQuery:objective").value;
	//var chkName = "DetailForm:page"+urType+":tablePM"+urType;
	//var index = 0;		 
	//var objName = chkName+":"+index+":isSelected";
	//var isCheck = false;
	//while(document.getElementById(objName)!=null){
	//	if(document.getElementById(objName).checked){
	//		isCheck = true;
	//	}
	//	objName = chkName+":"+(++index)+":isSelected";
	//}
			
	if(remark == ""){

		showAlertMsgReject("ER0107");	
	}
}

</script>

<a4j:jsFunction name="showAlertMsgReject" reRender="alertPopup"
	action="#{reqNWConfigAction.setMessageError}" 
	oncomplete="showErrorMessageDialog()">
	<a4j:actionparam name="errNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="pmReject" reRender="mdlPMReject"
	action="#{reqNWConfigAction.showRejectWin}"
 	oncomplete="Richfaces.showModalPanel('mdlPMReject');">
 	<a4j:actionparam name="subUrType"/>
</a4j:jsFunction>


<f:subview id="popupPMReject"> 
<rich:modalPanel id="mdlPMReject" autosized="true"
	styleClass="contentform" minWidth="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="กรุณาเลือกระบุเหตุผลที่ต้องการ Reject"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideDLGIcon" style="cursor:pointer;" />
			<rich:componentControl for="mdlPMReject" attachTo="hideDLGIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupRejectDlg">	
	<a4j:form id="errorMsgRegionMultiQuery">	
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	
	<a4j:form id="formRegionMultiQuery">
			<a4j:jsFunction name="showAlertMsgReject2" reRender="alertPopup"
				action="#{reqNWConfigAction.setMessageError}" 
				oncomplete="showErrorMessageDialog()">
				<a4j:actionparam name="errNo"/>
			</a4j:jsFunction>
	
		<a4j:outputPanel id="panelReject">
		<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<h:panelGrid columns="1" styleClass="contentlabelform" >
					<h:outputText id="confirmMessage" styleClass="contentlabelform" 
						value="กรุณาระบุเหตุผลในการ Reject :"/>	
				</h:panelGrid>
			</td>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>
		
		<tr>
			<td align="left">
				<h:inputTextarea id="objective" style="width:360px;" rows="3"  value="#{networkConfigBean.rejectRemark}">
				</h:inputTextarea>
			</td>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				<h:panelGrid columns="1" styleClass="contentlabelform">
					<h:panelGroup>
					<a4j:commandButton value="Reject" styleClass="rich-button" id="btnSave" onclick="var remark = document.getElementById('popupPMReject:popupRejectDlg:formRegionMultiQuery:objective').value; if(remark=='') {showAlertMsgReject2('ER0107');} "
						action="#{reqNWConfigAction.rejectPM}" reRender="policyTab" 
						oncomplete="reloadTree(); navigateHomepage();" >
						<a4j:jsFunction name="navigateHomepage" action="#{reqNWConfigAction.navigateHomepage}" oncomplete="Richfaces.hideModalPanel('mdlPMReject');" />
					</a4j:commandButton>
					<rich:spacer width="10"/>
					<a4j:commandButton value="Cancel" styleClass="rich-button" id="btnCancel">
						<rich:componentControl for="mdlPMReject" attachTo="btnCancel" operation="hide" event="onclick" />
					</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
			</td>
		</tr>
		</table>	
	</a4j:outputPanel>
	</a4j:form>
</f:subview>					
	
</rich:modalPanel>
</f:subview>
