<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<h:panelGrid columns="1" width="100%">
<rich:simpleTogglePanel switchType="client" id="PolicyAccessListTNPRequest" label="Policy Access List For TNP" width="100%">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
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
						<td width="180">
							
								<h:inputText id="sourceIP" value="#{networkConfigBean.accessListTNP.sourceIP}" style="text-align:left;width:100px" 
									onkeypress="return checkIPKey(this,event);"
									onblur="if(this.value=='') clearSourceIP(); if(this.value!='') { #{rich:component('wait')}.show(); if (verifyTextBoxIp(this)) findSourceIPTNP();}"/>
								<a4j:jsFunction name="findSourceIPTNP" actionListener="#{configAccessListTNPAction.findSourceIP}" 
									reRender="errorMsg,outputSourceNameTNP,outputSourceLocationTNP,outputSourceNetworkTNP,sourceInterfaceNode,sourceInterfaceNetwork" 
									oncomplete="#{rich:component('wait')}.hide(); checkAlert('DetailForm:incAccessListTNP:sourceCheck','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
								</a4j:jsFunction>
								<a4j:jsFunction name="clearSourceIP" actionListener="#{configAccessListTNPAction.clearSourceIP}" oncomplete="#{rich:component('wait')}.hide();"
									reRender="errorMsg,sourceIP,outputSourceNameTNP,outputSourceLocationTNP,outputSourceNetworkTNP,sourceInterfaceNode,sourceInterfaceNetwork">
								</a4j:jsFunction>							
						</td>
						<td class="labelStyle">IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td width="180">
							
								<h:inputText id="destIP" value="#{networkConfigBean.accessListTNP.destIP}" style="text-align:left;width:100px" 
									onkeypress="return checkIPKey(this,event);"
									onblur="if(this.value=='') clearDestIP(); if(this.value!='') { #{rich:component('wait')}.show(); if (verifyTextBoxIp(this)) findDestIPTNP()}"/>
								<a4j:jsFunction name="findDestIPTNP" actionListener="#{configAccessListTNPAction.findDestIP}" 
									reRender="outputDestNameTNP,outputDestLocationTNP,outputDestNetworkTNP,destInterfaceNode,destInterfaceNetwork,btnPopupTNP" 
									oncomplete="#{rich:component('wait')}.hide(); checkAlert('DetailForm:incAccessListTNP:destCheck','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
								</a4j:jsFunction>
								<a4j:jsFunction name="clearDestIP" actionListener="#{configAccessListTNPAction.clearDestIP}" oncomplete="#{rich:component('wait')}.hide();"
									reRender="destIP,outputDestNameTNP,outputDestLocationTNP,outputDestNetworkTNP,destInterfaceNode,destInterfaceNetwork,btnPopupTNP">
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
						<td colspan="3" align="center">
							<h:inputText id="description" value="#{networkConfigBean.accessListTNP.description}" style="text-align:left;width:360px"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle" valign="top">Impact<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
						<td colspan="3" align="center">
							<h:inputTextarea id="impact" style="width:360px;" rows="3"  value="#{networkConfigBean.accessListTNP.impact}">
							</h:inputTextarea><br>
							<h:graphicImage value="../images/icon_required.gif" style="border:0" />
							<h:outputText value="If source node cannot connect to destination node." style="color:#0000FF;"></h:outputText>
						</td>
						<td>&nbsp;</td>
					</tr>
				<tr>
					<td align="left" colspan="2">
						<h:panelGroup id="btnPopupTNP">
							<a4j:commandButton id="btnAddTNP" value="Add" styleClass="rich-button"
								onclick="addNetworkConfig('AT')" rendered="#{networkConfigBean.accessListTNP.subMode eq 'ADD'}"
								disabled="#{not networkConfigBean.accessTNPCheck}"
								reRender="networkConfigTab" />
							<a4j:commandButton id="btnUpdateTNP" value="Update" styleClass="rich-button"
								onclick="editNetworkConfig('AT')" 
								rendered="#{networkConfigBean.accessListTNP.subMode eq 'EDIT'}"
								reRender="networkConfigTab" />								
								&nbsp;
						<a4j:commandButton ajaxSingle="true" id="btnDeleteTNP" value="Delete" styleClass="rich-button"
							disabled="#{not (networkConfigBean.accessTNPCheck) or (networkConfigBean.accessListTNP.subMode eq 'EDIT') or (networkConfigBean.listAccessTNP == null or empty (networkConfigBean.listAccessTNP))}" reRender="AccessTNPTable" >
							<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
								oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');" 
								reRender="errorMsg,networkConfigTab">
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
			<rich:dataTable width="100%" id="AccessTNPTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listAccessTNP}" var="tnp">
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.accessListTNP.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listAccessTNP}"  ></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs"  value="#{tnp.isSelected}" rendered="#{not((index == networkConfigBean.accessListTNP.rowNum) and (networkConfigBean.accessListTNP.subMode eq 'EDIT'))}"
							onclick="validateCheckbox('N',document.getElementById('DetailForm:incAccessListTNP:AccessTNPTable:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
				
				<rich:column width="5%" style="vertical-align:top;"  rendered="true">
						<f:facet name="header"> 
							<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="edit" onclick="editTnp('#{tnp.id.urNo}','#{tnp.id.subUrNo}','#{index}')">
								<img src="../images/p_edit.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
					
					<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteTNP" rendered="#{((networkConfigBean.accessListTNP.subMode eq 'ADD')or (index == networkConfigBean.accessListTNP.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{tnp.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{tnp.id.subUrNo}"/>
								</a4j:support>
								<img src="../images/p_delete.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="UR Sub ID" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
				        <h:outputText value="#{tnp.id.subUrNo}" />
					</div>
				</rich:column>
				<rich:column width="20%">
					<f:facet name="header">
						<h:outputText value="Source IP" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceHostName}" />
						<h:outputText value="Location:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceLocationName}" />
						<h:outputText value="Network IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceNetworkIp}" />
						<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceInterNode}" />
						<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.sourceInterNw}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="20%">
					<f:facet name="header">
						<h:outputText value="Destination IP" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destIp}" />
					    <h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destHostName}" />
						<h:outputText value="Location:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destLocationName}" />
						<h:outputText value="Network IP:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destNetworkIp}" />
						<h:outputText value="Interface At Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destInterNode}" />
						<h:outputText value="Interface At Network:" styleClass="label"></h:outputText>
						<h:outputText value="#{tnp.destInterNw}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="15%"  style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="#{tnp.description}"/>
					</h:panelGrid>
				</rich:column>
				<rich:column width="20%"  style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Impact" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="left">
						<h:outputText value="#{tnp.reqImpact}"/>
					</div>
				</rich:column>	
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listAccessTNP) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="AccessTNPTable"
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

<rich:simpleTogglePanel switchType="client" id="tnpImport" label="Import Access List for TNP" width="100%">
		<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%">
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.accessTNPCheck}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.accessTNPCheck}" id="dltnp" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestAccessListTNP}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>
				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configAccessListTNPAction.listener}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			id="impTNP" 
	             			clearControlLabel=""
                            cancelEntryControlLabel=""
                            addControlLabel="Browse"
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