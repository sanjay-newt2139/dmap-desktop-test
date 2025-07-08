<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='javascript'>
	history.forward();
</script>
<a4j:jsFunction name="editTnpOld"
	action="#{configAccessListTNPAction.editTnpInit}" 
	reRender="EditTNP"
	oncomplete="Richfaces.showModalPanel('EditTNP');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="editTnp"
	action="#{configAccessListTNPAction.editTnpInit}" 
	reRender="networkConfigTab">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditTNP"> 
<rich:modalPanel id="EditTNP" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Access List for TNP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditTNP" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
					<tr>
						<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
						<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td width="180">
								<h:inputText id="sourceIP" value="#{networkConfigBean.accessListTNP.sourceIP}" style="text-align:left;width:100px" 
									onkeypress="return checkIPKey(this,event);"
									onblur="if(this.value=='') clearSourceIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findSourceIPTNPEdit();}"/>
								<a4j:jsFunction name="findSourceIPTNPEdit" actionListener="#{configAccessListTNPAction.findSourceIP}" 
									reRender="popupEditTNP:formRegionMultiQuery" 
									oncomplete="checkAlert('popupEditTNP:formRegionMultiQuery:sourceCheck','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
								</a4j:jsFunction>
								<a4j:jsFunction name="clearSourceIP" actionListener="#{configAccessListTNPAction.clearSourceIP}" 
									reRender="errorMsg,popupEditTNP:formRegionMultiQuery">
								</a4j:jsFunction>
						</td>
						<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td width="180">
								<h:inputText id="destIP" value="#{networkConfigBean.accessListTNP.destIP}" style="text-align:left;width:100px" 
									onkeypress="return checkIPKey(this,event);"
									onblur="if(this.value=='') clearDestIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findDestIPTNPEdit()}"/>
								<a4j:jsFunction name="findDestIPTNPEdit" actionListener="#{configAccessListTNPAction.findDestIP}" 
									reRender="errorMsg,popupEditTNP:formRegionMultiQuery" 
									oncomplete="checkAlert('v:destCheck','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
								</a4j:jsFunction>
								<a4j:jsFunction name="clearDestIP" actionListener="#{configAccessListTNPAction.clearDestIP}" 
									reRender="popupEditTNP:formRegionMultiQuery">
								</a4j:jsFunction>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputSourceNameTNP">
								<h:inputHidden id="sourceCheck" value="#{networkConfigBean.accessListTNP.sourceFound}"/>
	                    		<h:outputText id="sourceNameTxt" value="#{networkConfigBean.accessListTNP.sourceHostName}" />
	                    		<h:inputHidden id="sourceName" value="#{networkConfigBean.accessListTNP.sourceHostName}" />
	                		</a4j:outputPanel>
						</td>
						<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputDestNameTNP">
								<h:inputHidden id="destCheck" value="#{networkConfigBean.accessListTNP.destFound}"/>
	                    		<h:outputText id="destNameTxt" value="#{networkConfigBean.accessListTNP.destHostName}" />
	                    		<h:inputHidden id="destName" value="#{networkConfigBean.accessListTNP.destHostName}" />
	                		</a4j:outputPanel>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Location&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputSourceLocationTNP">
								<h:outputText id="sourceLocatTxt" value="#{networkConfigBean.accessListTNP.sourceLocation}" />
	                    		<h:inputHidden id="sourceLocat" value="#{networkConfigBean.accessListTNP.sourceLocation}" />
	                		</a4j:outputPanel>
						</td>
						<td class="labelStyle">Location&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputDestLocationTNP">
								<h:outputText id="destLocatTxt" value="#{networkConfigBean.accessListTNP.destLocation}" />
	                    		<h:inputHidden id="destLocat" value="#{networkConfigBean.accessListTNP.destLocation}" />
	                		</a4j:outputPanel>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Network&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputSourceNetworkTNP">
								<h:outputText id="sourceNetworkTxt" value="#{networkConfigBean.accessListTNP.sourceNetwork}" />
	                    		<h:inputHidden id="sourceNetwork" value="#{networkConfigBean.accessListTNP.sourceNetwork}" />
	                		</a4j:outputPanel>
						</td>
						<td class="labelStyle">Network&nbsp;:&nbsp;</td>
						<td>
							<a4j:outputPanel id="outputDestNetworkTNP">
								<h:outputText id="destNetworkTxt" value="#{networkConfigBean.accessListTNP.destNetwork}" />
	                    		<h:inputHidden id="destNetwork" value="#{networkConfigBean.accessListTNP.destNetwork}" />
	                		</a4j:outputPanel>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="displayRow">
						<td class="labelStyle">Interface At Node&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="sourceInterfaceNode" value="#{networkConfigBean.accessListTNP.sourceInterfaceNode}" style="text-align:left;width:120px"/>
						</td>
						<td class="labelStyle">Interface At Node&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="destInterfaceNode" value="#{networkConfigBean.accessListTNP.destInterfaceNode}" style="text-align:left;width:120px"/>
						</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle">Interface At Network&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="sourceInterfaceNetwork" value="#{networkConfigBean.accessListTNP.sourceInterfaceNetwork}" style="text-align:left;width:120px"/>
						</td>
						<td class="labelStyle">Interface At Network&nbsp;:&nbsp;</td>
						<td>
							<h:inputText id="destInterfaceNetwork" value="#{networkConfigBean.accessListTNP.destInterfaceNetwork}" style="text-align:left;width:120px"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle">Description&nbsp;:&nbsp;</td>
						<td colspan="3">
							<h:inputText id="description" value="#{networkConfigBean.accessListTNP.description}" style="text-align:left;width:360px"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle" valign="top">Impact<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td colspan="3">
							<h:inputTextarea id="impact" style="width:360px;" rows="3"  value="#{networkConfigBean.accessListTNP.impact}">
							</h:inputTextarea><br>
							<h:graphicImage value="../images/icon_required.gif" style="border:0" />
							<h:outputText value="If source node cannot connect to destination node." style="color:#0000FF;"></h:outputText>
						</td>
						<td>&nbsp;</td>
					</tr>
				<tr>
					<td align="left" colspan="2">
						<h:panelGrid columns="2" id="btnPopupFirewall">
						<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
							action="#{configAccessListTNPAction.editTnp}"
							reRender="networkConfigTab"
							oncomplete="Richfaces.hideModalPanel('EditTNP');">
						</a4j:commandButton>
						<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
							<rich:componentControl for="EditTNP" attachTo="btnClose" operation="hide" event="onclick"/>
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
