<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='script'>
	history.forward();
</script>

<a4j:jsFunction name="editFirewallOld"
	action="#{configFirewallAction.editFirewallInit}" 
	reRender="EditFirewall"
	oncomplete="Richfaces.showModalPanel('EditFirewall');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="editFirewall"
	action="#{configFirewallAction.editFirewallInit}" 
	reRender="networkConfigTab"
>
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<f:subview id="popupEditFirewall"> 
<rich:modalPanel id="EditFirewall" autosized="true" rendered="false"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit Firewall"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditFirewall" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="editFirewallPanel">	
			<a4j:region>
						<table border="0" width="100%">	
							<tr > 
								<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
								<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
								<td colspan="3" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Service</strong></td>
								<td>&nbsp;</td>
							</tr>
							<tr style="height:25px">
								<td class="labelStyle" style="width:76px;">
									IP<h:graphicImage value="../images/icon_required.gif" style="border:0" /> :
								</td>
								<td class="valuelStyle" style="width:134px;">
									
										<h:inputText id="sourceIP" value="#{networkConfigBean.firewall.sourceIPStart}" style="text-align:left;width:70px"
											onblur="if(this.value=='') clearSourceIP(); 
													if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditFirewall:formRegionMultiQuery:sourceIP','popupEditFirewall:formRegionMultiQuery:sourceTo'); findSourceIPCheckEdit();}}" 
											onkeypress="return checkIPKey(this,event);" disabled="#{not networkConfigBean.firewallCheck}"/>
										&nbsp;-&nbsp;
										<h:inputHidden id="sameFlag" value="Y"/>
										<h:inputText id="sourceTo" value="#{networkConfigBean.firewall.sourceIPEnd}" style="text-align:left;width:30px"
											onfocus="if (checkEqValue('popupEditFirewall:formRegionMultiQuery:sourceIP','popupEditFirewall:formRegionMultiQuery:sourceTo')) 
													 {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'Y';}
													 else {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'N';}"
											onkeypress="return keyRange(this,event,0,255);" 
											onblur="if(this.value=='') clearSourceIP(); 
													if(this.value!='' && isNumber(this)!=''){
														if (!((document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value=='Y') 
															&& checkEqValue('popupEditFirewall:formRegionMultiQuery:sourceIP','popupEditFirewall:formRegionMultiQuery:sourceTo'))) 
															isIPLowerNoFocus(this,'popupEditFirewall:formRegionMultiQuery:sourceIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findSourceIPCheckEdit()')
													}"
											disabled="#{not networkConfigBean.firewallCheck}"/>
										<a4j:jsFunction name="findSourceIP" actionListener="#{configFirewallAction.findSourceIP}" 
											reRender="errorMsg,outputSourceName,outputSourceEmail,outputSourceVip,sourceNat" >
										</a4j:jsFunction>
										<a4j:jsFunction name="clearSourceIP" actionListener="#{configFirewallAction.clearSourceIP}" 
											reRender="errorMsg,sourceTo,outputSourceName,outputSourceEmail,outputSourceVip,sourceNat">
										</a4j:jsFunction>
									
								</td>
								<td class="labelStyle" style="width:76px;">
									IP<h:graphicImage value="../images/icon_required.gif" style="border:0" /> :
								</td>
								<td class="valuelStyle" style="width:134px;">									
										<h:inputText id="destIP" value="#{networkConfigBean.firewall.destIPStart}" style="text-align:left;width:70px"
											onblur="if(this.value=='') clearDestIP(); 
													if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('popupEditFirewall:formRegionMultiQuery:destIP','popupEditFirewall:formRegionMultiQuery:destTo'); findDestIPCheckEdit();}}"
											onkeypress="return checkIPKey(this,event);" disabled="#{not networkConfigBean.firewallCheck}"/>
										&nbsp;-&nbsp;
										<h:inputText id="destTo" value="#{networkConfigBean.firewall.destIPEnd}" style="text-align:left;width:30px"
											onfocus="if (checkEqValue('popupEditFirewall:formRegionMultiQuery:destIP','popupEditFirewall:formRegionMultiQuery:destTo')) 
													 {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'Y';}
													 else {document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value = 'N';}"
											onkeypress="return keyRange(this,event,0,255);"
											onblur="if(this.value=='') clearDestIP(); 
													if(this.value!='' && isNumber(this)!=''){
														if (!((document.getElementById('popupEditFirewall:formRegionMultiQuery:sameFlag').value=='Y') 
															&& checkEqValue('popupEditFirewall:formRegionMultiQuery:destIP','popupEditFirewall:formRegionMultiQuery:destTo'))) 
															isIPLowerNoFocus(this,'popupEditFirewall:formRegionMultiQuery:destIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findDestIPCheckEdit()')
													}"
											disabled="#{not networkConfigBean.firewallCheck}"/>
										<a4j:jsFunction name="findDestIP" actionListener="#{configFirewallAction.findDestIP}" 
											reRender="errorMsg,outputDestName,outputDestEmail,outputDestVip,destNat" 
											oncomplete="checkAlert('popupEditFirewall:formRegionMultiQuery:destCheck','IP ยังไม่ได้ถูก Assigned กรุณาตรวจสอบข้อมูล');">
										</a4j:jsFunction>
										<a4j:jsFunction name="clearDestIP" actionListener="#{configFirewallAction.clearDestIP}" 
											reRender="errorMsg,destTo,outputDestName,outputDestEmail,outputDestVip,destNat">
										</a4j:jsFunction>	
									
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="tcpCheck" 
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.tcpCheck}"
										onclick="textboxToggle(this,'popupEditFirewall:formRegionMultiQuery:tcpPort');toggleTCPField();"/>
								</td>
								<td class="valuelStyle" style="width:70px;">
									TCP&nbsp;&nbsp;<h:inputText id="tcpPort" value="#{networkConfigBean.firewall.tcpPort}" 
										style="text-align:left;width:40px"
										disabled="#{not networkConfigBean.firewall.tcpCheck}"/> 
								</td>
								<td rowspan="5" style="width:266px;">
									<rich:pickList id="serviceSelect"
										disabled="#{not networkConfigBean.firewallCheck}"
										copyAllVisible="false" 
										copyControlLabel=" "
										removeAllVisible="false"
										removeControlLabel=" "
										listsHeight="110"
										sourceListWidth="80"
										targetListWidth="80"
										value="#{networkConfigBean.firewall.selectList}">
										 <f:selectItems value="#{networkConfigBean.firewall.serviveList}"/>
									</rich:pickList>
								</td>
								<td>&nbsp;</td>
							</tr>
							
							<tr class="inputRow">
								<td class="labelStyle" style="width:85px;">
									Host Name :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceName">
										<h:inputHidden id="sourceCheck" value="#{networkConfigBean.firewall.sourceFound}"/>
                    					<h:outputText id="sourceNameTxt" value="#{networkConfigBean.firewall.sourceName}" />
                    					<h:inputHidden id="sourceName" value="#{networkConfigBean.firewall.sourceName}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									Host Name :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestName">
										<h:inputHidden id="destCheck" value="#{networkConfigBean.firewall.destFound}"/>
                    					<h:outputText id="destNameTxt" value="#{networkConfigBean.firewall.destName}" />
                    					<h:inputHidden id="destName" value="#{networkConfigBean.firewall.destName}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="udpCheck"
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.udpCheck}"
										onclick="textboxToggle(this,'popupEditFirewall:formRegionMultiQuery:udpPort');toggleUDPField();"/>
								</td>
								<td class="valuelStyle" style="width:70px;">
									UDP&nbsp;&nbsp;<h:inputText id="udpPort" value="#{networkConfigBean.firewall.udpPort}" style="text-align:left;width:40px"
									onblur="validatePort(this);"
										disabled="#{not networkConfigBean.firewall.udpCheck}"/> 
								</td>
								<td>&nbsp;</td>
							</tr>
							
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									Email :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceEmail">
                    					<h:inputText id="sourceEmail" value="#{networkConfigBean.firewall.sourceEmail}"
                    						disabled="#{not networkConfigBean.firewallCheck}" 
                    						style="text-align:left;width:120px"/>
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									Email :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestEmail">
										<h:outputText id="destEmail" value="#{networkConfigBean.firewall.destEmail}"
											style="text-align:left;width:120px"/>
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="otherCheck"
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.otherCheck}"
										onclick="textboxToggle(this,'popupEditFirewall:formRegionMultiQuery:otherPort');toggleOtherField();"/>
								</td>
								<td class="valuelStyle" style="width:70px;">
									Other&nbsp; 
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									VIP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceVip">
                    					<h:outputText id="sourceVipTxt" value="#{networkConfigBean.firewall.sourceVip}" />
                    					<h:inputHidden id="sourceVip" value="#{networkConfigBean.firewall.sourceVip}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									VIP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestVip">
                    					<h:outputText id="destVipTxt" value="#{networkConfigBean.firewall.destVip}" />
                    					<h:inputHidden id="destVip" value="#{networkConfigBean.firewall.destVip}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">
									&nbsp;
								</td>
								<td class="valuelStyle" style="width:70px;">
									<h:inputText id="otherPort" value="#{networkConfigBean.firewall.otherPort}" style="text-align:left;width:60px"
										disabled="#{not networkConfigBean.firewall.otherCheck}"/>  
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									Nat IP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<h:inputText id="sourceNat" value="#{networkConfigBean.firewall.sourceNatIP}" 
										style="text-align:left;width:120px"
										disabled="#{not networkConfigBean.firewallCheck}"
										/>
								</td>
								<td class="labelStyle" style="width:76px;">
									Nat IP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<h:inputText id="destNat" value="#{networkConfigBean.firewall.destNatIP}" 
										style="text-align:left;width:120px"
										disabled="#{not networkConfigBean.firewallCheck}"
										/>
								</td>
								<td class="labelStyle" style="width:18px;">
									&nbsp;
								</td>
								<td class="valuelStyle" style="width:70px;">
									&nbsp; 
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
														action="#{configFirewallAction.editFirewall}"
														reRender="networkConfigTab"
														oncomplete="Richfaces.hideModalPanel('EditFirewall');">
													</a4j:commandButton>
													<a4j:commandButton ajaxSingle="true" id="btnClose" value="Close" styleClass="rich-button">
														<rich:componentControl for="EditFirewall" attachTo="btnClose" operation="hide" event="onclick"/>
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
