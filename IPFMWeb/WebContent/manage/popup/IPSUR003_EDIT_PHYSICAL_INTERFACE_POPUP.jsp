<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='javascript'>
	history.forward();
</script>
<a4j:jsFunction name="editInterfaceOld"
	action="#{configPhyInterface.editPhyInterfaceInit}" 
	reRender="EditInterface"
	oncomplete="Richfaces.showModalPanel('EditInterface');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="editInterface"
	action="#{configPhyInterface.editPhyInterfaceInit}" 
	reRender="networkConfigTab" >
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditInterface"> 
<rich:modalPanel id="EditInterface" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Physical Interface"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditInterface" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
				<tr > 
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>IP</strong></td>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Interface Detail</strong></td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">IP Node<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="ipNode" value="#{networkConfigBean.phyInterface.ipNode}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"
								onblur="if(this.value=='') clearSourceIPEdit(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPNodeEdit();}"/>
							<a4j:jsFunction name="findIPNodeEdit" actionListener="#{configPhyInterface.findIPNode}" 
								reRender="popupEditInterface:formRegionMultiQuery" 
								oncomplete="checkAlert('popupEditInterface:formRegionMultiQuery:ipFound','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIPEdit" actionListener="#{configPhyInterface.clearSourceIP}" 
								reRender="popupEditInterface:formRegionMultiQuery">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">Interface Node Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<rich:comboBox id="interfaceNodeType" value="#{networkConfigBean.phyInterface.intfNodeType}" 
							itemClass="contentform"  itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configPhyInterface.nodeType}"/>
							<f:selectItems value="#{configPhyInterface.nodeType}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<h:inputHidden id="ipFound" value="#{networkConfigBean.phyInterface.ipFound}"/>
	                    <h:outputText id="hostName" value="#{networkConfigBean.phyInterface.hostName}" />
					</td>
					<td class="labelStyle" rowspan="2"  valign="top">Description&nbsp;:&nbsp;</td>
					<td rowspan="2">
						<h:inputTextarea id="interfaceDesc" value="#{networkConfigBean.phyInterface.interfaceDesc}" style="text-align:left;width:145px" rows="4"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">MAC Address&nbsp;:&nbsp;</td>
					<td valign="top">
						<h:outputText id="macAddress" value="#{networkConfigBean.phyInterface.macAddress}" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Location&nbsp;:&nbsp;</td>
					<td>
						<h:outputText id="locationName" value="#{networkConfigBean.phyInterface.location}" />
					</td>
					<td class="labelStyle">Status<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td>
						<rich:comboBox id="portStatus" value="#{networkConfigBean.phyInterface.portStatus}" itemClass="contentform"  
							style="text-align:left;width:145px" itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configPhyInterface.portStatus}"/>
							<f:selectItems value="#{configPhyInterface.portStatus}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Floor&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="floor" value="#{networkConfigBean.phyInterface.floor}" style="text-align:left;width:145px"/>
					</td>
					<td class="labelStyle">Speed Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td>
						<rich:comboBox id="speedPort" itemSelectedClass="contentform" itemClass="contentform"  
							style="text-align:left;width:145px" value="#{networkConfigBean.phyInterface.speedPort}">
							<f:attribute name="selectItems" value="#{configPhyInterface.speedPort}"/>
							<f:selectItems value="#{configPhyInterface.speedPort}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">VLAN ID&nbsp;:&nbsp;</td>
					<td>
						<h:outputText id="vlanId" value="#{networkConfigBean.phyInterface.vlanID}" />
					</td>
					<td class="labelStyle">Enclosure&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="enclosure" value="#{networkConfigBean.phyInterface.enclosure}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">Remarks&nbsp;:&nbsp;</td>
					<td colspan="3">
						<h:inputTextarea id="remark" style="width:360px;" rows="3"  value="#{networkConfigBean.phyInterface.reqRemark}" readonly="true">
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
														action="#{configPhyInterface.editPhyInterface}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditInterface');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditInterface" attachTo="btnClose" operation="hide" event="onclick"/>
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
