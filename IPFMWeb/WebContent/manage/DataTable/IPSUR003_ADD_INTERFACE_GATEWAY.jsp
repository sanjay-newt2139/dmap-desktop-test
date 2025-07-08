<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columns="1" width="100%">
<rich:simpleTogglePanel switchType="client" id="GatewayRequest" label="Policy Interface Gateway">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<table width="100%" border="0" class="thtext_detail">
				<tr class="inputRow">
					<td class="labelStyle">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<a4j:region>
							<h:inputText id="ipAddress" value="#{networkConfigBean.gateway.ipAddress}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"
								onblur=" if(this.value=='') clearSourceIP(); if(this.value!='') { #{rich:component('wait')}.show(); if (verifyTextBoxIp(this)) findIPAddress()}"/>
							&nbsp;/&nbsp;
							<h:inputText id="sourcePort" value="#{networkConfigBean.gateway.mask}" style="text-align:left;width:30px" maxlength="2" onkeypress="return keyRange(this,event,0,32);" onblur="isNumber(this)"/>	
							<a4j:jsFunction name="findIPAddress"  actionListener="#{configIntfGateway.findIPNode}" 
								reRender="errorMsg,GatewayRequest" 
								oncomplete="#{rich:component('wait')}.hide(); checkAlert('DetailForm:incGateway:ipFound','กรุณาระบุข้อมูลในช่อง IP Address ก่อน');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configIntfGateway.clearSourceIP}" 
								reRender="errorMsg,GatewayRequest" oncomplete="#{rich:component('wait')}.hide();">
							</a4j:jsFunction>
						</a4j:region>
					</td>
					<td class="labelStyle">Network Type<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<rich:comboBox id="networkEquip" value="#{networkConfigBean.gateway.networkType}" onblur="checkNetworkType()"
							itemClass="contentform"  itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configIntfGateway.networkType}"/>
							<f:selectItems value="#{configIntfGateway.networkType}"/>
							<a4j:jsFunction reRender="errorMsg" name="checkNetworkType" action="#{reqNWConfigAction.checkNetworkTypeCombo}" />
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
						<h:inputText id="vlanID" value="#{networkConfigBean.gateway.vlanID}" style="text-align:left;width:145px" onkeypress="return ((keyDigitRange(this,event,1,4096)));" onblur="this.value = isNumber(this);"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">Description&nbsp;:&nbsp;</td>
					<td colspan="3">
						<h:inputTextarea id="remarks" style="width:360px;" rows="3"  
							value="#{networkConfigBean.gateway.description}">
						</h:inputTextarea>
					</td>
					<td>&nbsp;</td>
				</tr>
			<tr class="inputRow">
				<td colspan="2" align="left">
					<h:panelGroup id="btnPopupIG">
						<a4j:commandButton id="btnAddIG" value="Add" styleClass="rich-button"
							onclick="addNetworkConfig('IG')"  rendered="#{networkConfigBean.gateway.subMode eq 'ADD'}"
							disabled="#{not networkConfigBean.gatewayCheck}"
							reRender="GatewayTable" />
						<a4j:commandButton id="btnUpdateIG" value="Update" styleClass="rich-button"
							onclick="editNetworkConfig('IG')" rendered="#{networkConfigBean.gateway.subMode eq 'EDIT'}"
							disabled="#{not networkConfigBean.gatewayCheck}"
							reRender="GatewayTable" />&nbsp;&nbsp;
						<a4j:commandButton ajaxSingle="true" id="btnDeleteIG" value="Delete" styleClass="rich-button"
							disabled="#{not (networkConfigBean.gatewayCheck) or (networkConfigBean.gateway.subMode eq 'EDIT') or (networkConfigBean.listGateway == null or empty (networkConfigBean.listGateway))}">
							<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
								oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');" 
								reRender="GatewayTable">
							</a4j:support>
						</a4j:commandButton>&nbsp;&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>
		</td></tr>
		<tr><td>
			<rich:dataTable width="100%" id="GatewayTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listGateway}" var="gateway">
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.gateway.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listGateway}" ></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs" value="#{gateway.isSelected}" rendered="#{not((index == networkConfigBean.gateway.rowNum) and (networkConfigBean.gateway.subMode eq 'EDIT'))}"
							onclick="validateCheckbox('N',document.getElementById('DetailForm:incGateway:GatewayTable:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
				
				<rich:column width="5%" style="vertical-align:top;"  rendered="true">
						<f:facet name="header"> 
							<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="edit" onclick="editGateway('#{gateway.id.urNo}','#{gateway.id.subUrNo}', '#{index}')">
								<img src="../images/p_edit.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
					
					<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteIG" rendered="#{((networkConfigBean.gateway.subMode eq 'ADD')or (index == networkConfigBean.gateway.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{gateway.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{gateway.id.subUrNo}"/>
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
					    <h:outputText value="#{gateway.id.subUrNo}" />
					</div>
				</rich:column>
				<rich:column width="20%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Address/Mask" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{gateway.ipAddress}" />
						&nbsp;/&nbsp;
						<h:outputText value="#{gateway.mask}" />
					</div>	
				</rich:column>
				
				<rich:column width="20%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Network Type" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{gateway.networkTypeDesc}" />
					</div>	
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Location" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{gateway.locationName}" />
					</div>	
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="VLAN ID" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{gateway.reqVlanId}" />
					</div>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Description" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:inputTextarea id="remark" style="width:100%;" rows="3" readonly="true"  
							value="#{gateway.reqDesc}">
						</h:inputTextarea>
					</div>	
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listGateway) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="GatewayTable"
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

<rich:simpleTogglePanel switchType="client" id="gatewayImport" label="Import Interface Gateway">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%">
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.gatewayCheck}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.gatewayCheck}" id="dlig" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestInterfaceGateway}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>
				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configIntfGateway.listener}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			id="impGateWay" 
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