<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<f:subview id="popupAddGateway"> 
<rich:modalPanel id="AddGatewayPopup" autosized="true"
	styleClass="contentform" height="150" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Add Interface Gateway"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="AddGatewayPopup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td width="22%" align="right">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="27%">
						<h:inputText id="sourceIP" value="" style="text-align:left;width:100px"/>
						&nbsp;/&nbsp;
						<h:inputText id="sourcePort" value="" style="text-align:left;width:30px"/>
					</td>
					
				</tr>
				<tr>
					<td align="right">Network Equipment<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="networkEquip" value="" style="text-align:left;width:145px"/>
					</td>
					<td align="right" width="13%">Location&nbsp;:&nbsp;</td>
					<td width="40%">
						<h:outputText value=""/>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left">
					<h:panelGroup id="btnPopupFirewall">
						<a4j:commandButton id="btnAddFirewall" value="Add" styleClass="rich-button"
							action="#{manageDataIPAction.search}"
							reRender="groupSearchResult" />&nbsp;
						<a4j:commandButton id="btnCancelFirewall" value="Cancel" styleClass="rich-button"
							action="#{manageDataIPAction.init}"
							reRender="fierwallPolicyTable">
							<rich:componentControl for="AddFirewallPopup" attachTo="btnCancelFirewall" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
