<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script language='javascript'>
	function clearSourceIpClient() {
		document.getElementById('DetailForm:incFirewall:sourceIP').value='';
		document.getElementById('DetailForm:incFirewall:sourceTo').value='';
		document.getElementById('DetailForm:incFirewall:outputSourceName').value='';
		document.getElementById('DetailForm:incFirewall:outputSourceEmail').value='';
		document.getElementById('DetailForm:incFirewall:outputSourceVip').value='';
		document.getElementById('DetailForm:incFirewall:sourceNat').value='';
	}

	function clearDesctIpClient() {
		document.getElementById('DetailForm:incFirewall:destIP').value='';
		document.getElementById('DetailForm:incFirewall:destTo').value='';
		document.getElementById('DetailForm:incFirewall:outputDestName').value='';
		document.getElementById('DetailForm:incFirewall:outputDestEmail').value='';
		document.getElementById('DetailForm:incFirewall:outputDestVip').value='';
		document.getElementById('DetailForm:incFirewall:destNat').value='';
	}
	function vaildateAdd() {
		var rt = true;
		if (document.getElementById('DetailForm:incFirewall:tcpPort').value !='') {
			return validatePort(document.getElementById('DetailForm:incFirewall:tcpPort'));
		} 
		if(document.getElementById('DetailForm:incFirewall:udpPort').value !='') {
			return validatePort(document.getElementById('DetailForm:incFirewall:udpPort'));
		}
		if(document.getElementById('DetailForm:incFirewall:otherPort').value !='') {
			return validatePort(document.getElementById('DetailForm:incFirewall:otherPort'));
		}

		return rt;
	}
</script>
<h:panelGrid columns="1" width="100%" id="fwPanel">
	<rich:simpleTogglePanel switchType="client" id="firewallRequest" label="Policy Firewall Request List" width="100%">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td>
					<table border="0" width="100%">	
										
							<tr > 
								<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
								<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
								<td colspan="3" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Service</strong></td>
							
							</tr>
			
							<tr style="height:25px">
								<td class="labelStyle" style="width:76px;">
									IP<h:graphicImage value="../images/icon_required.gif" style="border:0" /> :
								</td>
								<td class="valuelStyle" style="width:134px;">

										<h:inputText id="sourceIP" value="#{networkConfigBean.firewall.sourceIPStart}" style="text-align:left;width:70px"
											onblur="if(this.value=='')  {clearSourceIpClient(); clearSourceIP();}  
													if(this.value!='') { if (verifyTextBoxIp(this)) {  defaultIP('DetailForm:incFirewall:sourceIP','DetailForm:incFirewall:sourceTo'); findSourceIPCheck(); } else {clearSourceIpClient(); clearSourceIP();} }" 
											onkeypress="return checkIPKey(this,event);" disabled="#{not networkConfigBean.firewallCheck}"/>
											
										&nbsp;-&nbsp;
										<h:inputHidden id="sameFlag" value="Y"/>
										<h:inputText id="sourceTo" value="#{networkConfigBean.firewall.sourceIpEndDisp}" style="text-align:left;width:30px"
											onfocus="if (checkEqValue('DetailForm:incFirewall:sourceIP','DetailForm:incFirewall:sourceTo')) 
													 {document.getElementById('DetailForm:incFirewall:sameFlag').value = 'Y';}
													 else {document.getElementById('DetailForm:incFirewall:sameFlag').value = 'N';}"
											onkeypress="return keyRange(this,event,0,255);" 
											onblur=" if(this.value=='')  {clearSourceIpClient(); clearSourceIP();} 
													if(this.value!='' && document.getElementById('DetailForm:incFirewall:sourceIP').value != '' && isNumber(this)!=''){
														if (!((document.getElementById('DetailForm:incFirewall:sameFlag').value=='Y') 
															&& checkEqValue('DetailForm:incFirewall:sourceIP','DetailForm:incFirewall:sourceTo'))) 
															isIPLower(this,'DetailForm:incFirewall:sourceIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findSourceIPCheck()')
													}"
											disabled="#{not networkConfigBean.firewallCheck}"/>
										<a4j:jsFunction name="findSourceIP" actionListener="#{configFirewallAction.findSourceIP}" 
											reRender="outputSourceName,outputSourceEmail,outputSourceVip,sourceNat" >
										</a4j:jsFunction>
									
										<a4j:jsFunction name="clearSourceIP" actionListener="#{configFirewallAction.clearSourceIP}" 
											reRender="sourceIP,sourceTo,outputSourceName,outputSourceEmail,outputSourceVip,sourceNat">
										</a4j:jsFunction>
								</td>
								<td class="labelStyle" style="width:76px;">
									IP<h:graphicImage value="../images/icon_required.gif" style="border:0" /> :
								</td>
								<td class="valuelStyle" style="width:134px;">									
										<h:inputText id="destIP" value="#{networkConfigBean.firewall.destIPStart}" style="text-align:left;width:70px" 
											onblur="if(this.value=='') { clearDesctIpClient(); clearDestIP(); } 
													if(this.value!='') {if (verifyTextBoxIp(this)) {  defaultIP('DetailForm:incFirewall:destIP','DetailForm:incFirewall:destTo'); findDestIPCheck();} else { clearDesctIpClient(); clearDestIP(); } }"
											onkeypress="return checkIPKey(this,event);" disabled="#{not networkConfigBean.firewallCheck}"/>
										&nbsp;-&nbsp;
										<h:inputText id="destTo" value="#{networkConfigBean.firewall.destIpEndDisp}" style="text-align:left;width:30px"
											onfocus="if (checkEqValue('DetailForm:incFirewall:destIP','DetailForm:incFirewall:destTo')) 
													 {document.getElementById('DetailForm:incFirewall:sameFlag').value = 'Y';}
													 else {document.getElementById('DetailForm:incFirewall:sameFlag').value = 'N';}"
											onkeypress="return keyRange(this,event,0,255);"
											onblur="if(this.value=='') { clearDesctIpClient(); clearDestIP(); }
													if(this.value!='' && document.getElementById('DetailForm:incFirewall:destIP').value != ''  && isNumber(this)!=''){
														if (!((document.getElementById('DetailForm:incFirewall:sameFlag').value=='Y') 
															&& checkEqValue('DetailForm:incFirewall:destIP','DetailForm:incFirewall:destTo'))) {
															isIPLower(this,'DetailForm:incFirewall:destIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findDestIPCheck()');}
													}"
											disabled="#{not networkConfigBean.firewallCheck}"/>
											
										<a4j:jsFunction name="findDestIP" actionListener="#{configFirewallAction.findDestIP}" 
											reRender="outputDestName,outputDestEmail,outputDestVip,destNat" 
											oncomplete="checkAlert('DetailForm:incFirewall:destCheck','IP ยังไม่ได้ถูก Assigned กรุณาตรวจสอบข้อมูล');">
										</a4j:jsFunction>
										<a4j:jsFunction name="clearDestIP" actionListener="#{configFirewallAction.clearDestIP}" 
											reRender="destIP,destTo,outputDestName,outputDestEmail,outputDestVip,destNat">
										</a4j:jsFunction>	
									
								</td>
								<td class="labelStyle" style="width:18px;">
									<h:selectBooleanCheckbox id="tcpCheck" 
										disabled="#{not networkConfigBean.firewallCheck}"
										value="#{networkConfigBean.firewall.tcpCheck}"
										onclick="textboxToggle(this,'DetailForm:incFirewall:tcpPort'); toggleTCPField();"/>
								</td>
								<td class="valuelStyle" style="width:130px;">
									TCP<rich:spacer width="15"/>
										<h:inputText id="tcpPort" value="#{networkConfigBean.firewall.tcpPort}" style="text-align:left;width:80px"
										onblur="if (this.value!='') validatePort(this);"
										disabled="#{not networkConfigBean.firewall.tcpCheck}"/> 
								</td>
								<td rowspan="5" style="width:230px;">
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
									<a href="https://nokhook.ais.co.th/sites/OPD/URS/ขอ_FireWall_Module_STA1_STA2.xls" target="_blank" style="font-weight:bold; text-decoration: underline; color:#0000FF; width:100%; text-align:center;" >View Service</a>
								</td>
								
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
								<td class="labelStyle" style="width:85px;">
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
										onclick="textboxToggle(this,'DetailForm:incFirewall:udpPort'); toggleUDPField();"/>
								</td>
								<td class="valuelStyle" style="width:130px;">
									UDP<rich:spacer width="14"/><h:inputText id="udpPort" value="#{networkConfigBean.firewall.udpPort}" style="text-align:left;width:80px"
										onblur="if (this.value!='') validatePort(this);"
										disabled="#{not networkConfigBean.firewall.udpCheck}"/> 
								</td>
							
							</tr>
							
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									Email :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceEmail">
                    					<h:inputText id="sourceEmail" value="#{networkConfigBean.firewall.sourceEmail}"
                    						disabled="#{not networkConfigBean.firewallCheck}" maxlength="100"
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
										disabled="true"
										value="#{networkConfigBean.firewall.otherCheck}"
										onclick="textboxToggle(this,'DetailForm:incFirewall:otherPort'); toggleOtherField();"/>
								</td>
								<td class="valuelStyle" style="width:130px;">
									Other<rich:spacer width="7"/>
										<h:inputText id="otherPort" value="#{networkConfigBean.firewall.otherPort}" style="text-align:left;width:80px"
										disabled="true"/>  
								</td>
							
							</tr>
							<tr class="inputRow">
								<td class="labelStyle" style="width:76px;">
									VIP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputSourceVip">
                    					<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{networkConfigBean.firewall.sourceVip eq 'Y'}" />
                    					<h:outputText id="sourceVipTxtNo" value="No" rendered="#{networkConfigBean.firewall.sourceVip eq 'N'}" />
                    					<h:inputHidden id="sourceVip" value="#{networkConfigBean.firewall.sourceVip}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:76px;">
									VIP :
								</td>
								<td class="valuelStyle" style="width:134px;">
									<a4j:outputPanel id="outputDestVip">
                    					<h:outputText id="destVipTxtYes" value="Yes" rendered="#{networkConfigBean.firewall.destVip eq 'Y'}" />
                    					<h:outputText id="destVipTxtNo" value="No" rendered="#{networkConfigBean.firewall.destVip eq 'N'}" />
                    					<h:inputHidden id="destVip" value="#{networkConfigBean.firewall.destVip}" />
                					</a4j:outputPanel>
								</td>
								<td class="labelStyle" style="width:18px;">&nbsp;
									
								</td>
								<td class="valuelStyle" style="width:70px;">
									
								</td>
							
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
								<td class="labelStyle" style="width:18px;">&nbsp;
									
								</td>
								<td class="valuelStyle" style="width:140px;">&nbsp;
									 
								</td>
					
							</tr>
						</table>

				</td>
			</tr>
			<tr><td><img src="../images/blank.gif"></td></tr>	

							<tr>
								<td align="right">
									<table border="0" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<td align="left">
												<h:panelGroup id="btnPopupFirewall">
													<a4j:commandButton id="btnAddFW" value="Add" styleClass="rich-button"
														onclick="if(vaildateAdd()){addNetworkConfig('FW')}" 
														rendered="#{networkConfigBean.firewall.subMode eq 'ADD'}"
														disabled="#{not networkConfigBean.firewallCheck}">
													</a4j:commandButton> 
													<a4j:commandButton id="btnUpdateFW" value="Update" styleClass="rich-button"
														rendered="#{networkConfigBean.firewall.subMode eq 'EDIT'}"
														onclick="if(vaildateAdd()){editNetworkConfig('FW')}" 
														disabled="#{not networkConfigBean.firewallCheck}">
													</a4j:commandButton>&nbsp;		
													<a4j:commandButton  id="btnDeleteFW" value="Delete" styleClass="rich-button"
														disabled="#{not (networkConfigBean.firewallCheck) or (networkConfigBean.firewall.subMode eq 'EDIT')or (networkConfigBean.listFirewall == null or empty (networkConfigBean.listFirewall))}">
														<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
															oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');" 
															reRender="networkConfigTab">
														</a4j:support>
													</a4j:commandButton>&nbsp;&nbsp;	
												</h:panelGroup>	
											</td>
										</tr>
									</table>
								</td>
							</tr>

			<tr><td><img src="../images/blank.gif"></td></tr>
			<tr><td>
				<rich:dataTable width="100%" id="tableAddFirewall" cellpadding="1" cellspacing="0" border="0"
					reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
					rowClasses="odd,even" 
					styleClass="contentform" rowKeyVar="index" 
					headerClass="tableHeader"
					value="#{networkConfigBean.listFirewall}" var="firewall">
					<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.firewall.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listFirewall}" ></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs" value="#{firewall.isSelected}" rendered="#{not((index == networkConfigBean.firewall.rowNum) and (networkConfigBean.firewall.subMode eq 'EDIT'))}" 
							 onclick="validateCheckbox('N',document.getElementById('DetailForm:incFirewall:tableAddFirewall:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
 					
					<rich:column width="5%" style="vertical-align:top;" rendered="true">
						<f:facet name="header"> 
							<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="edit" onclick="editFirewall('#{firewall.id.urNo}','#{firewall.id.subUrNo}' ,'#{index}')">
								<img src="../images/p_edit.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
					
					<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteFW" rendered="#{((networkConfigBean.firewall.subMode eq 'ADD')or (index == networkConfigBean.firewall.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{firewall.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{firewall.id.subUrNo}"/>
								</a4j:support>	
								<img src="../images/p_delete.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
					
					<rich:column width="10%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
						        <h:outputText value="#{firewall.id.subUrNo}" />
						</div>
					</rich:column>
					<rich:column width="25%">
						<f:facet name="header">
							<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="2">
							<h:outputText value="IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceIp}" />
						    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceHostName}" />
							<h:outputText value="Email:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceEmail}" />
							<h:outputText value="VIP:" styleClass="label"></h:outputText>
							<h:panelGroup>
								<h:outputText id="sourceVipTxtYes" value="Yes" rendered="#{firewall.sourceVip eq 'Y'}" />
	                    		<h:outputText id="sourceVipTxtNo" value="No" rendered="#{firewall.sourceVip eq 'N'}" />
							</h:panelGroup>
							<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.sourceNatIp}" />
						</h:panelGrid>
					</rich:column>
					<rich:column width="25%">
						<f:facet name="header">
							<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="2">
							<h:outputText value="IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destIp}" />
							<h:outputText value="Host Name:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destHostName}" />
							<h:outputText value="Email:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destEmail}" />
							<h:outputText value="VIP:" styleClass="label"></h:outputText>
							<h:panelGroup>
								<h:outputText id="destVipTxtYes" value="Yes" rendered="#{firewall.destVip eq 'Y'}" />
	                    		<h:outputText id="destVipTxtNo" value="No" rendered="#{firewall.destVip eq 'N'}" />
							</h:panelGroup>
							<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.destNatIp}" />
						</h:panelGrid>
					</rich:column>
					<rich:column width="25%" style="vertical-align:top;">
						<f:facet name="header">
							<h:outputText value="Service" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<h:panelGrid columns="2">
							<h:outputText value="TCP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceTcpPort}" />
							<h:outputText value="UDP:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceUdpPort}" />
							<h:outputText value="Other:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceOtherPort}" />
							<h:outputText value="Service:" styleClass="label"></h:outputText>
							<h:outputText value="#{firewall.serviceName}" />
						</h:panelGrid>
					</rich:column>
					
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="4">
								Total : <h:outputText value="#{ fn:length(networkConfigBean.listFirewall) }" /> records
							</rich:column>
							<rich:column colspan="10">
								<rich:datascroller immediate="true" rendered="true" align="right" for="tableAddFirewall"
									maxPages="#{ipfmConfigBean.maxPage}" id="scrollFirewallTable" selectedStyleClass="selectScroll"
									stepControls="hide" fastControls="auto" boundaryControls="auto" fastStep="#{ipfmConfigBean.fastStepPage}"
									style="background-color: #cccccc;"/>
							</rich:column>
						</rich:columnGroup>
					</f:facet>
				</rich:dataTable>
			</td>
			<td>&nbsp;</td></tr>
			<tr><td height="5"><img src="../images/blank.gif" width="10" height="5"></td></tr>
		</table>
	</rich:simpleTogglePanel>

	<rich:simpleTogglePanel switchType="client" id="firewallImport" label="Import Firewall">
		<h:panelGroup >
		<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%" >
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.firewallCheck}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.firewallCheck}" id="dlfw" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestFirewall}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>
				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configFirewallAction.listener}" disabled="#{not networkConfigBean.firewallCheck}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			id="impFirewall" 
	             			clearControlLabel=""
                            cancelEntryControlLabel=""
	             			immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
	             			acceptedTypes="#{systemParameterFileUploadBean.acceptedTypes}" 
	             			allowFlash="#{systemParameterFileUploadBean.useFlash}"
							sizeErrorLabel="File Size Over!" 
	             			sizeErrorLabelClass="contentform"
	             			uploadListClass="contentform"
	             			transferErrorLabelClass="contentform"
	             			styleClass="contentform"
	             			fileEntryClass="contentform"
	             			fileEntryControlClass="contentform"
	             			progressLabelClass="contentform"
	             			addButtonClass="contentform"
	             			uploadButtonClass="contentform"
	             			addControlLabel="Browse"
	             			listHeight="70" autoclear="true"
	             			listWidth="100%" onuploadcomplete="showresult();">
	         			</rich:fileUpload>
				</td>
			</tr>
		</table>
		</h:panelGroup>
	</rich:simpleTogglePanel>
</h:panelGrid>
<jsp:directive.include file="../IPSUR_ALL_JS.jsp"/>

	