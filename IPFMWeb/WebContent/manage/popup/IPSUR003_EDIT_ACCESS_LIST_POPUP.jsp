<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='javascript'>
	history.forward();
</script>
<a4j:jsFunction name="editCdnOld"
	action="#{configAccessListAction.editCdnInit}" 
	reRender="EditCDN"
	oncomplete="Richfaces.showModalPanel('EditCDN');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<a4j:jsFunction name="editCdn"
	action="#{configAccessListAction.editCdnInit}" 
	reRender="networkConfigTab" >
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditCDN"> 
<rich:modalPanel id="EditCDN" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Access List for CDN"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditCDN" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editCDNPanel">	
			<a4j:region>
				<table width="100%" border="0" class="thtext_detail">
				<tr>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="sourceIP" value="#{networkConfigBean.accessList.sourceIPStart}" style="text-align:left;width:100px" 
								onblur="if(this.value=='') clearSourceIP(); 
										if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditCDN:formRegionMultiQuery:sourceIP','popupEditCDN:formRegionMultiQuery:sourceTo'); findSourceIPCDNCheckEdit();}}" 
								onkeypress="return checkIPKey(this,event);" />
							&nbsp;-&nbsp;
							<h:inputHidden id="sameFlag" value="Y"/>
							<h:inputText id="sourceTo" value="#{networkConfigBean.accessList.sourceIPEnd}" style="text-align:left;width:30px"
								onfocus="if (checkEqValue('popupEditCDN:formRegionMultiQuery:sourceIP','popupEditCDN:formRegionMultiQuery:sourceTo')) 
										 {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'Y';}
										 else {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'N';}"
								onkeypress="return keyRange(this,event,0,255);" 
								onblur="if(this.value=='') clearSourceIP(); 
										if(this.value!='' && isNumber(this)!=''){
											if (!((document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value=='Y') 
												&& checkEqValue('popupEditCDN:formRegionMultiQuery:sourceIP','popupEditCDN:formRegionMultiQuery:sourceTo'))) 
												isIPLowerNoFocus(this,'popupEditCDN:formRegionMultiQuery:sourceIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findSourceIPCDNCheckEdit()')
										}"
							/>	
							<a4j:jsFunction name="findSourceIPCDN" actionListener="#{configAccessListAction.findSourceIP}" 
								reRender="errorMsg,outputSourceNameCDN,outputSourceEmailCDN" 
								oncomplete="checkAlert('popupEditCDN:formRegionMultiQuery:sourceCheck','ไม่มีข้อมูล IP Address ที่ระบุ');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configAccessListAction.clearSourceIP}" 
								reRender="errorMsg,sourceTo,outputSourceNameCDN,outputSourceEmailCDN">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="destIP" value="#{networkConfigBean.accessList.destIPStart}" style="text-align:left;width:100px" 
								onblur="if(this.value=='') clearDestIP(); 
										if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditCDN:formRegionMultiQuery:destIP','popupEditCDN:formRegionMultiQuery:destTo'); findDestIPCDNCheckEdit();}}"
								onkeypress="return checkIPKey(this,event);"/>
							&nbsp;-&nbsp;
							<h:inputText id="destTo" value="#{networkConfigBean.accessList.destIPEnd}" style="text-align:left;width:30px"
								onfocus="if (checkEqValue('popupEditCDN:formRegionMultiQuery:destIP','popupEditCDN:formRegionMultiQuery:destTo')) 
										 {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'Y';}
										 else {document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value = 'N';}"
								onkeypress="return keyRange(this,event,0,255);"
								onblur="if(this.value=='') clearDestIP(); 
										if(this.value!='' && isNumber(this)!=''){
											if (!((document.getElementById('popupEditCDN:formRegionMultiQuery:sameFlag').value=='Y') 
												&& checkEqValue('popupEditCDN:formRegionMultiQuery:destIP','popupEditCDN:formRegionMultiQuery:destTo'))) 
												isIPLowerNoFocus(this,'popupEditCDN:formRegionMultiQuery:destIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findDestIPCDNCheckEdit()')
										}"
							/>
							<a4j:jsFunction name="findDestIPCDN" actionListener="#{configAccessListAction.findDestIP}" 
								reRender="errorMsg,outputDestNameCDN,outputDestEmailCDN" 
								oncomplete="checkAlert('popupEditCDN:formRegionMultiQuery:destCheck','ไม่มีข้อมูล IP Address ที่ระบุ');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearDestIP" actionListener="#{configAccessListAction.clearDestIP}" 
								reRender="errorMsg,destTo,outputDestNameCDN,outputDestEmailCDN">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="displayRow">
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputSourceNameCDN">
							<h:inputHidden id="sourceCheck" value="#{networkConfigBean.accessList.sourceFound}"/>
                    		<h:outputText id="sourceNameTxt" value="#{networkConfigBean.accessList.sourceName}" />
                    		<h:inputHidden id="sourceName" value="#{networkConfigBean.accessList.sourceName}" />
                		</a4j:outputPanel>
					</td>
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputDestNameCDN">
							<h:inputHidden id="destCheck" value="#{networkConfigBean.accessList.destFound}"/>
                    		<h:outputText id="destNameTxt" value="#{networkConfigBean.accessList.destName}" />
                    		<h:inputHidden id="destName" value="#{networkConfigBean.accessList.destName}" />
                		</a4j:outputPanel>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="displayRow">
					<td class="labelStyle">Email&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputSourceEmailCDN">
                    		<h:outputText id="sourceEmailTxt" value="#{networkConfigBean.accessList.sourceEmail}" />
                    		<h:inputHidden id="sourceEmail" value="#{networkConfigBean.accessList.sourceEmail}" />
                		</a4j:outputPanel>
					</td>
					<td class="labelStyle">Email&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputDestEmailCDN">
                    		<h:outputText id="destEmailTxt" value="#{networkConfigBean.accessList.destEmail}" />
                    		<h:inputHidden id="destEmail" value="#{networkConfigBean.accessList.destEmail}" />
                		</a4j:outputPanel>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" colspan="2">
						<h:panelGrid columns="2" id="btnPopupCDN">
						<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
							action="#{configAccessListAction.editCdn}"
							reRender="networkConfigTab"
							oncomplete="Richfaces.hideModalPanel('EditCDN');">
						</a4j:commandButton>
						<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
							<rich:componentControl for="EditCDN" attachTo="btnClose" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;&nbsp;	
						</h:panelGrid>
					</td>
				</tr>
				</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
