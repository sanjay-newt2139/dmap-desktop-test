<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columns="1" width="100%">

<rich:simpleTogglePanel switchType="client" id="PolicyAccessListRequest" label="Policy Access List For CDN" width="100%">
	<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr>
			<td>
				<table width="100%" border="0" class="thtext_detail">
				<tr>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Source</strong></td>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Destination</strong></td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="sourceIP" value="#{networkConfigBean.accessList.sourceIPStart}" style="text-align:left;width:100px" 
								onblur="if(this.value=='') clearSourceIP(); 
										if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('DetailForm:incAccessList:sourceIP','DetailForm:incAccessList:sourceTo'); findSourceIPCDNCheck();}}" 
								onkeypress="return checkIPKey(this,event);" />
							&nbsp;-&nbsp;
							<h:inputHidden id="sameFlag" value="Y"/>
							<h:inputText id="sourceTo" value="#{networkConfigBean.accessList.sourceIPEnd}" style="text-align:left;width:30px"
								onfocus="if (checkEqValue('DetailForm:incAccessList:sourceIP','DetailForm:incAccessList:sourceTo')) 
										 {document.getElementById('DetailForm:incAccessList:sameFlag').value = 'Y';}
										 else {document.getElementById('DetailForm:incAccessList:sameFlag').value = 'N';}"
								onkeypress="return keyRange(this,event,0,255);" 
								onblur="if(this.value=='') clearSourceIP(); 
										if(this.value!='' && isNumber(this)!=''){
											if (!((document.getElementById('DetailForm:incAccessList:sameFlag').value=='Y') 
												&& checkEqValue('DetailForm:incAccessList:sourceIP','DetailForm:incAccessList:sourceTo'))) 
												isIPLower(this,'DetailForm:incAccessList:sourceIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findSourceIPCDNCheck()')
										}"
							/>	
							<a4j:jsFunction name="findSourceIPCDN" actionListener="#{configAccessListAction.findSourceIP}" 
								reRender="errorMsg,outputSourceNameCDN,outputSourceEmailCDN" 
								oncomplete="checkAlert('DetailForm:incAccessList:sourceCheck','ไม่มีข้อมูล IP Address ที่ระบุ');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configAccessListAction.clearSourceIP}" 
								reRender="errorMsg,sourceTo,outputSourceNameCDN,outputSourceEmailCDN">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="destIP" value="#{networkConfigBean.accessList.destIPStart}" style="text-align:left;width:100px" 
								onblur="if(this.value=='') clearDestIP(); 
										if(this.value!='') {if (verifyTextBoxIp(this)) {defaultIP('DetailForm:incAccessList:destIP','DetailForm:incAccessList:destTo'); findDestIPCDNCheck();}}"
								onkeypress="return checkIPKey(this,event);"/>
							&nbsp;-&nbsp;
							<h:inputText id="destTo" value="#{networkConfigBean.accessList.destIPEnd}" style="text-align:left;width:30px"
								onfocus="if (checkEqValue('DetailForm:incAccessList:destIP','DetailForm:incAccessList:destTo')) 
										 {document.getElementById('DetailForm:incAccessList:sameFlag').value = 'Y';}
										 else {document.getElementById('DetailForm:incAccessList:sameFlag').value = 'N';}"
								onkeypress="return keyRange(this,event,0,255);"
								onblur="if(this.value=='') clearDestIP(); 
										if(this.value!='' && isNumber(this)!=''){
											if (!((document.getElementById('DetailForm:incAccessList:sameFlag').value=='Y') 
												&& checkEqValue('DetailForm:incAccessList:destIP','DetailForm:incAccessList:destTo'))) 
												isIPLower(this,'DetailForm:incAccessList:destIP','ค่าที่ระบุไม่ถูกต้อง (ต้องมากกว่าหรือเท่ากับ IP Address ตั้งต้น)','findDestIPCDNCheck()')
										}"
							/>
							<a4j:jsFunction name="findDestIPCDN" actionListener="#{configAccessListAction.findDestIP}" 
								reRender="errorMsg,outputDestNameCDN,outputDestEmailCDN" 
								oncomplete="checkAlert('DetailForm:incAccessList:destCheck','ไม่มีข้อมูล IP Address ที่ระบุ');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearDestIP" actionListener="#{configAccessListAction.clearDestIP}" 
								reRender="errorMsg,destTo,outputDestNameCDN,outputDestEmailCDN">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="displayRow">
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputSourceNameCDN">
							<h:inputHidden id="sourceCheck" value="#{networkConfigBean.accessList.sourceFound}"/>
                    		<h:outputText id="sourceNameTxt" value="#{networkConfigBean.accessList.sourceName}" />
                    		<h:inputHidden id="sourceName" value="#{networkConfigBean.accessList.sourceName}" />
                		</a4j:outputPanel>
					</td>
					<td class="labelStyle">Host Name&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputDestNameCDN">
							<h:inputHidden id="destCheck" value="#{networkConfigBean.accessList.destFound}"/>
                    		<h:outputText id="destNameTxt" value="#{networkConfigBean.accessList.destName}" />
                    		<h:inputHidden id="destName" value="#{networkConfigBean.accessList.destName}" />
                		</a4j:outputPanel>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="displayRow">
					<td class="labelStyle">Email&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputSourceEmailCDN">
                    		<h:outputText id="sourceEmailTxt" value="#{networkConfigBean.accessList.sourceEmail}" />
                    		<h:inputHidden id="sourceEmail" value="#{networkConfigBean.accessList.sourceEmail}" />
                		</a4j:outputPanel>
					</td>
					<td class="labelStyle">Email&nbsp;:&nbsp;</td>
					<td>
						<a4j:outputPanel id="outputDestEmailCDN">
                    		<h:outputText id="destEmailTxt" value="#{networkConfigBean.accessList.destEmail}" />
                    		<h:inputHidden id="destEmail" value="#{networkConfigBean.accessList.destEmail}" />
                		</a4j:outputPanel>
					</td>
					<td>&nbsp;</td>
				</tr>
			<tr>
				<td colspan="2" align="left">
					<h:panelGroup id="btnPopupAccessList">
						<a4j:commandButton id="btnAddAccessList" value="Add" styleClass="rich-button"
							onclick="addNetworkConfig('AL')" rendered="#{networkConfigBean.accessList.subMode eq 'ADD'}"
							disabled="#{not networkConfigBean.accessListCheck}"
							reRender="AccessListTable">
						</a4j:commandButton>
						<a4j:commandButton id="btnUpdateAccessList" value="Update" styleClass="rich-button"
							onclick="editNetworkConfig('AL')" rendered="#{networkConfigBean.accessList.subMode eq 'EDIT'}"
							disabled="#{not networkConfigBean.accessListCheck}"
							reRender="AccessListTable">
						</a4j:commandButton>						
						&nbsp;&nbsp;
						<a4j:commandButton  id="btnDeleteAL" value="Delete" styleClass="rich-button"
							disabled="#{not (networkConfigBean.accessListCheck) or (networkConfigBean.accessList.subMode eq 'EDIT') or (networkConfigBean.listAccessList == null or empty (networkConfigBean.listAccessList))}" >
							<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick" 
							    reRender="networkConfigTab"
								oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');" 								
								 >
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
			<rich:dataTable width="100%" id="AccessListTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listAccessList}" var="cdn">
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.accessList.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listAccessList}"  ></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs" value="#{cdn.isSelected}"  rendered="#{not((index == networkConfigBean.accessList.rowNum) and (networkConfigBean.accessList.subMode eq 'EDIT'))}"
							onclick="validateCheckbox('N',document.getElementById('DetailForm:incAccessList:AccessListTable:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
					
				<rich:column width="5%" style="vertical-align:top;"  rendered="true">
						<f:facet name="header"> 
							<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="edit" onclick="editCdn('#{cdn.id.urNo}','#{cdn.id.subUrNo}', '#{index}');" >
								<img src="../images/p_edit.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>					
				
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteFW" rendered="#{((networkConfigBean.accessList.subMode eq 'ADD')or (index == networkConfigBean.accessList.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{cdn.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{cdn.id.subUrNo}"/>
								</a4j:support>
								<img src="../images/p_delete.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
				
				<rich:column width="20%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
				        <h:outputText value="#{cdn.id.subUrNo}" />
					</div>
				</rich:column>
				
				
					
				<rich:column width="35%">
					<f:facet name="header">
						<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceHostName}" />
						<h:outputText value="email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.sourceEmail}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="35%">
					<f:facet name="header">
						<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destIp}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destHostName}" />
						<h:outputText value="email:" styleClass="label"></h:outputText>
						<h:outputText value="#{cdn.destEmail}" />
					</h:panelGrid>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessList) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="AccessListTable"
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

<rich:simpleTogglePanel switchType="client" id="accessListImport" label="Import Access List for CDN">
		<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%">
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.accessListCheck}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.accessListCheck}" id="dlcdn" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestAcessListCDN}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>

				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configAccessListAction.listener}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			clearControlLabel=""
                            cancelEntryControlLabel=""
                            addControlLabel="Browse"
	             			id="impAccess" 
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
	             			listHeight="70" autoclear="true"
	             			listWidth="100%" onuploadcomplete="showresult();">
	         			</rich:fileUpload>
				</td>
			</tr>
		</table>
	</rich:simpleTogglePanel>
</h:panelGrid>
<jsp:directive.include file="../IPSUR_ALL_JS.jsp"/>