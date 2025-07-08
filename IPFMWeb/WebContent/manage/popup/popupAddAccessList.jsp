<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<f:subview id="popupAddAccessList"> 
<rich:modalPanel id="AddAccessListPopup" autosized="true"
	styleClass="contentform" height="160" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Add Access List"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="AddAccessListPopup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td width="22%" align="right">Source IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="27%">
						<h:inputText id="sourceIP" value="10.128.2.1" style="text-align:left;width:100px"/>
						&nbsp;-&nbsp;
						<h:inputText id="sourcePort" value="" style="text-align:left;width:30px"/>
					</td>
					<td width="23%" align="right">Destination IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="30%">
						<h:inputText id="destIP" value="10.12.1.0" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr>
					<td align="right">Source Host Name&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value="Computer A"/>
					</td>
					<td align="right">Destination Host Name&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value="Network A"/>
					</td>
				</tr>
				<tr>
					<td align="right">Source Email&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value="coma@ais.co.th"/>
					</td>
					<td align="right">Destination Email&nbsp;:&nbsp;</td>
					<td>
						<h:outputText value="networka@ais.co.th"/>
					</td>
				</tr>
			<tr><td>&nbsp;</td></tr>	
				
			<tr>
				<td>&nbsp;</td>
				<td align="left">
					<h:panelGroup id="btnPopupAccessList">
						<a4j:commandButton id="btnAddAccessList" value="Add" styleClass="rich-button"
							actionListener="#{reqNWConfigAction.addAccessList}"
							reRender="AccessListTable">
							<rich:componentControl for="AddAccessListPopup" attachTo="btnAddAccessList" operation="hide" event="onclick"/>
						</a4j:commandButton>	&nbsp;
						<a4j:commandButton id="btnCancelFirewall" value="Cancel" styleClass="rich-button" reRender="fierwallPolicyTable">
							<rich:componentControl for="AddAccessListPopup" attachTo="btnCancelFirewall" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
