<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>




<a4j:jsFunction name="findSourceIPCDNCheck" 
	actionListener="#{configAccessListAction.findSourceIP}"
 	reRender="errorMsg,PolicyAccessListRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findSourceIPCDNCheckEdit" 
	actionListener="#{configAccessListAction.findSourceIP}"
 	reRender="errorMsg,popupEditCDN:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCDNCheck" 
	actionListener="#{configAccessListAction.findDestIP}"
 	reRender="errorMsg,PolicyAccessListRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCDNCheckEdit" 
	actionListener="#{configAccessListAction.findDestIP}"
 	reRender="errorMsg,popupEditCDN:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="alertErrorMsgAjx" 
	actionListener="#{reqNWConfigAction.alertErrorMsg}"
 	reRender="errorMsg,networkConfigTab">
 	<a4j:actionparam name="errorMessage"/>
</a4j:jsFunction>
<a4j:jsFunction name="findSourceIPCheck" 
	actionListener="#{configFirewallAction.findSourceIP}"
 	reRender="errorMsg,firewallRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findSourceIPCheckEdit" 
	actionListener="#{configFirewallAction.findSourceIP}"
 	reRender="errorMsg,popupEditFirewall:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCheck" 
	actionListener="#{configFirewallAction.findDestIP}"
 	reRender="errorMsg,firewallRequest,networkConfigTab,errorDialogPopup,IPSUR003_ERROR_RESULT"
 	oncomplete="if (#{not empty networkConfigBean.validateResult}) {showModalMessage('IPSUR003_ERROR_RESULT');} javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="findDestIPCheckEdit" 
	actionListener="#{configFirewallAction.findDestIP}"
 	reRender="errorMsg,popupEditFirewall:formRegionMultiQuery,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>
<a4j:jsFunction name="retrieveData" 
	actionListener="#{configf5.retrieveData}"
 	reRender="errorMsg,networkConfigTab,errorDialogPopup"
 	oncomplete="javascript:showErrorFlag();" >
</a4j:jsFunction>

<a4j:jsFunction name="addNetworkConfig" 
	actionListener="#{reqNWConfigAction.addConfigNetwork}"
 	reRender="errorMsg,DetailForm,networkConfigTab,errorDialogPopup" 
 	oncomplete="javascript:showErrorFlag();">
 	<a4j:actionparam name="reqType"/>
</a4j:jsFunction>
<a4j:jsFunction name="addNetworkConfigF5" 
	actionListener="#{reqNWConfigAction.addConfigNetwork}"
 	reRender="errorMsg,DetailForm,networkConfigTab,errorDialogPopup" 
 	oncomplete="if('#{networkConfigBean.f5.retriveFound}' == 'true') {Richfaces.showModalPanel('confirmRetriveDataF5')} javascript:showErrorFlag();">
 	<a4j:actionparam name="reqType"/>
</a4j:jsFunction>
<a4j:jsFunction name="editNetworkConfig" 
	actionListener="#{reqNWConfigAction.editConfigNetwork}"
 	reRender="errorMsg,networkConfigTab,errorDialogPopup" 
 	oncomplete="javascript:showErrorFlag();">
 	<a4j:actionparam name="reqType"/>
</a4j:jsFunction>
<a4j:jsFunction name="findIPF5" actionListener="#{configf5.findIPNode}" 
	reRender="errorMsg,F5Request">
</a4j:jsFunction>

<a4j:jsFunction name="toggleTCPField" actionListener="#{configFirewallAction.toggleTCPField}" reRender="tcpPort" >
</a4j:jsFunction>
<a4j:jsFunction name="toggleUDPField"  actionListener="#{configFirewallAction.toggleUDPField}" reRender="udpPort" >
</a4j:jsFunction>
<a4j:jsFunction name="toggleOtherField" actionListener="#{configFirewallAction.toggleOtherField}" reRender="otherPort">
</a4j:jsFunction>
<a4j:jsFunction name="errorAlert" 
	actionListener="#{reqNWConfigAction.setErrorMsg}"
 	reRender="errorMsg,errorDialogPopup" 
 	oncomplete="Richfaces.showModalPanel('errorDialogPopup');">
</a4j:jsFunction>

<a4j:jsFunction name="confirmDelete" 
	action="#{reqNWConfigAction.confirmDeleteSubUr}"
 	reRender="confirmDeletePopup" 
 	oncomplete="Richfaces.showModalPanel('confirmDeletePopup');">
 	<a4j:actionparam name="reqType"/>
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="confirmSelectedDelete"
	rendered="confirmDeleteAllPopup"
	oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');">
</a4j:jsFunction>

<rich:modalPanel id="errorDialogPopup" autosized="true" rendered="true"
	styleClass="contentform" minWidth="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="IPFM Message"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideErrorIcon" style="cursor:pointer;" />
			<rich:componentControl for="errorDialogPopup" attachTo="hideErrorIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupErrorDlg">	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
			<ul>
				<h:inputHidden id="errorFlag" value="#{networkConfigBean.errorFlag}"></h:inputHidden>
			</ul>			
			<table border="0" cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td align="left">
						<h:outputText id="errorMessageAlert" styleClass="contentlabelform" escape="false" 
							style="color:red" value="#{networkConfigBean.errorMsg}"></h:outputText>						
					</td>
				</tr>
				<tr>
					<td align="center">
						<h:panelGrid columns="1" styleClass="contentlabelform">
							<a4j:commandButton value="OK" styleClass="rich-button" id="btnOK">
								<rich:componentControl for="errorDialogPopup" attachTo="btnOK" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
		</a4j:outputPanel>
	</a4j:form>
</f:subview>					
	
</rich:modalPanel>

<rich:modalPanel id="confirmDeletePopup" width="350" height="100" rendered="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfDelete"/>
	        <rich:componentControl for="confirmDeletePopup" attachTo="hideConfDelete" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<a4j:form id="formRegionMultiQuery">
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="#{mes.CF0009}" /></td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes">
        		<a4j:support action="#{reqNWConfigAction.deleteSubUr}" 
        			event="onclick"
					oncomplete="Richfaces.hideModalPanel('confirmDeletePopup');" 
					reRender="networkConfigTab">
				</a4j:support>	 
			</a4j:commandButton>
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDeletePopup');">
        </td></tr>
    </table>
    </a4j:form>
</rich:modalPanel>

<rich:modalPanel id="confirmDeleteAllPopup" width="350" height="100" rendered="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfDeleteAll"/>
	        <rich:componentControl for="confirmDeleteAllPopup" attachTo="hideConfDeleteAll" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<a4j:form id="formDeleteAllQuery">
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="#{mes.CF0010}" /></td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes"
        		action="#{reqNWConfigAction.deleteSelectedSubUr}"
        		reRender="networkConfigTab" 
 				oncomplete="Richfaces.hideModalPanel('confirmDeleteAllPopup');">
			</a4j:commandButton>
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDeleteAllPopup');">
        </td></tr>
    </table>
    </a4j:form>
</rich:modalPanel>

<rich:modalPanel id="confirmRetriveDataF5" width="350" height="100" rendered="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfRetriveData"/>
	        <rich:componentControl for="confirmRetriveDataF5" attachTo="hideConfRetriveData" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<a4j:form id="formRetriveDataF5">
	<table width="100%" border="0">
    	<tr><td align="center"><h:outputText value="VIP and Port มีอยู่แล้วในระบบ ต้องการ Retrive Data เพิ่มเด้วยหรือไม่" /></td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes" onclick="retrieveData()"
 				oncomplete="Richfaces.hideModalPanel('confirmRetriveDataF5');">
			</a4j:commandButton>
        	<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmRetriveDataF5');addNetworkConfig('F5');">
        </td></tr>
    </table>
    </a4j:form>
</rich:modalPanel>


