<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<f:subview id="popupAddPhysicalInterface"> 
<rich:modalPanel id="AddPhysicalInterfacePopup" autosized="true"
	styleClass="contentform" height="230" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Add Physical Interface"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="AddPhysicalInterfacePopup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td width="22%" align="right">IP Node<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="27%">
						<h:inputText id="ipNode" value="" style="text-align:left;width:145px"/>
					</td>
					<td colspan="2" align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right">Host Name&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value=""/>
					</td>
					<td align="right" width="23%" >Interface Node Type&nbsp;:&nbsp;</td>
					<td width="30%">
						<h:inputText id="nodeType" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr>
					<td align="right" valign="top" rowspan="3">Interface Description&nbsp;:&nbsp;</td>
					<td rowspan="3" valign="top">
						<h:inputTextarea id="interfaceDesc" value="" style="text-align:left;width:145px" rows="4"/>
					</td>
					<td align="right">Mac Address&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value=""/>
					</td>
				</tr>
				<tr>
					<td align="right">Node Location&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value=""/>
					</td>
				</tr>
				<tr>
					<td align="right">Floor&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value=""/>
					</td>
				</tr>
				<tr>
					<td align="right">Port Status&nbsp;:&nbsp;</td>
					<td>
						<rich:comboBox id="portStatus"  style="text-align:left;width:145px">
						</rich:comboBox>
					</td>
					<td align="right">Speed Port&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="speedPort" value="" style="text-align:left;width:145px"/>
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
