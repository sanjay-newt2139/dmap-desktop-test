<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='javascript'>
	history.forward();
</script>
<a4j:jsFunction name="editRoutingOld"
	action="#{configRouting.editRoutingInit}" 
	reRender="EditRouting"
	oncomplete="Richfaces.showModalPanel('EditRouting');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>
<a4j:jsFunction name="editRouting"
	action="#{configRouting.editRoutingInit}" 
	reRender="networkConfigTab">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditRouting"> 
<rich:modalPanel id="EditRouting" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Routing"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditRouting" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table width="100%" border="0" class="thtext_detail">
				<tr  class="inputRow">
					<td class="labelStyle" align="right">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<h:inputHidden id="ipFound" value="#{networkConfigBean.routing.isFound}"/>
						<a4j:region>
							<h:inputText id="ipAddress" value="#{networkConfigBean.routing.ipAddress}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"  
								onblur="if(this.value=='') clearSourceIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPRoutingEdit()}"/>
							&nbsp;/&nbsp;
							<h:inputText id="sourcePort" value="#{networkConfigBean.routing.mask}" style="text-align:left;width:30px" maxlength="2" onkeypress="return keyRange(this,event,0,32);" onblur="isNumber(this)"/>	
							<a4j:jsFunction name="findIPRoutingEdit" actionListener="#{configRouting.findIPNode}" 
								reRender="errorMsg,popupEditRouting:formRegionMultiQuery" 
								oncomplete="checkAlert('popupEditRouting:formRegionMultiQuery:ipFound','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configRouting.clearSourceIP}" 
								reRender="errorMsg,popupEditRouting:formRegionMultiQuery">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle" align="right" rowspan="3" valign="top">Description&nbsp;:&nbsp;</td>
					<td width="230" rowspan="3" valign="top">
						<h:inputTextarea id="description" value="#{networkConfigBean.routing.description}" rows="5" style="text-align:left;width:145px;"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">Interface&nbsp;:&nbsp;</td>
					<td width="230">
						<h:inputText id="interface" value="#{networkConfigBean.routing.intf}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">Next Hop&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="nextHop" value="#{networkConfigBean.routing.nextHop}" style="text-align:left;width:145px"/>
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
														action="#{configRouting.editRouting}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditRouting');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditRouting" attachTo="btnClose" operation="hide" event="onclick"/>
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
