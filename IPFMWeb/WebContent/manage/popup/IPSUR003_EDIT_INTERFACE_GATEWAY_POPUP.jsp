<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='javascript'>
	history.forward();
</script>
<a4j:jsFunction name="editGatewayOld"
	action="#{configIntfGateway.editGatewayInit}" 
	reRender="EditGateway"
	oncomplete="Richfaces.showModalPanel('EditGateway');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>
<a4j:jsFunction name="editGateway"
	action="#{configIntfGateway.editGatewayInit}" 
	reRender="networkConfigTab"
	>
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>
<f:subview id="popupEditGateway"> 
<rich:modalPanel id="EditGateway" autosized="true"  rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Firewall"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditGateway" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
				<tr class="inputRow">
					<td class="labelStyle">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="ipAddress" value="#{networkConfigBean.gateway.ipAddress}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"
								onblur="if(this.value=='') clearSourceIPEdit(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPAddressEdit()}"/>
							&nbsp;/&nbsp;
							<h:inputText id="sourcePort" value="#{networkConfigBean.gateway.mask}" style="text-align:left;width:30px" maxlength="2" onkeypress="return keyRange(this,event,0,32);" onblur="isNumber(this)"/>	
							<a4j:jsFunction name="findIPAddressEdit" actionListener="#{configIntfGateway.findIPNode}" 
								reRender="errorMsg,popupEditGateway:formRegionMultiQuery" 
								oncomplete="checkAlert('popupEditGateway:formRegionMultiQuery:ipFound','กรุณาระบุข้อมูลในช่อง IP Address ก่อน');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIPEdit" actionListener="#{configIntfGateway.clearSourceIP}" 
								reRender="errorMsg,popupEditGateway:formRegionMultiQuery">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<rich:comboBox id="networkEquip" value="#{networkConfigBean.gateway.networkType}" 
							itemClass="contentform"  itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configIntfGateway.networkType}"/>
							<f:selectItems value="#{configIntfGateway.networkType}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Location&nbsp;:&nbsp;</td>
					<td >
						<h:inputHidden id="ipFound" value="#{networkConfigBean.gateway.ipFound}"/>
                    	<h:outputText id="locationName" value="#{networkConfigBean.gateway.location}" />
					</td>
					<td class="labelStyle">VLAN ID&nbsp;:&nbsp;</td>
					<td >
						<h:inputText id="vlanID" value="#{networkConfigBean.gateway.vlanID}" style="text-align:left;width:145px"
						onkeypress="return keyRange(this,event,1,4096);"
						onblur="this.value = isNumber(this);"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">Description&nbsp;:&nbsp;</td>
					<td colspan="3">
						<h:inputTextarea id="remark" style="width:360px;" rows="3"  value="#{networkConfigBean.gateway.description}">
						</h:inputTextarea>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td><img src="../images/blank.gif"></td></tr>	
							<tr>
								<td align="right">
									<table border="0" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<td align="left">
												<h:panelGrid columns="2" id="btnPopupFirewall">
													<a4j:commandButton id="btnUpdate" value="Update" styleClass="rich-button"
														action="#{configIntfGateway.editGateway}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditGateway');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditGateway" attachTo="btnClose" operation="hide" event="onclick"/>
													</a4j:commandButton>&nbsp;&nbsp;	
												</h:panelGrid>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</a4j:region>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
