<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<h:panelGrid columns="1" width="100%">
<rich:simpleTogglePanel switchType="client" id="RoutingRequest" label="Policy Routing"  width="100%">
	<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<table width="100%" border="0" class="thtext_detail">
				<tr  class="inputRow">
					<td class="labelStyle" align="right">IP Address/Mask<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">
						<h:inputHidden id="ipFound" value="#{networkConfigBean.routing.isFound}"/>
						<a4j:region>
							<h:inputText id="ipAddress" value="#{networkConfigBean.routing.ipAddress}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"  
								onblur="if(this.value=='') clearSourceIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPRouting()}"/>
							&nbsp;/&nbsp;
							<h:inputText id="sourcePort" value="#{networkConfigBean.routing.mask}" style="text-align:left;width:30px" maxlength="2"  onblur="isNumber(this)"/>	
							<a4j:jsFunction name="findIPRouting" actionListener="#{configRouting.findIPNode}" 
								reRender="errorMsg,RoutingRequest" 
								oncomplete="checkAlert('DetailForm:incRouting:ipFound','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
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
						<h:inputText id="nextHop" value="#{networkConfigBean.routing.nextHop}" style="text-align:left;width:145px" onkeypress="return checkIPKey(this,event);" onblur="if (this.value!='') verifyTextBoxIp(this)"/>
					</td>
					<td>&nbsp;</td>
				</tr>
	
			<tr>
				<td align="left" colspan="3">
					<h:panelGroup id="btnPopupFirewall">
						<a4j:commandButton id="btnAddRT" value="Add" styleClass="rich-button"
							onclick="addNetworkConfig('RT')" rendered="#{networkConfigBean.routing.subMode eq 'ADD'}"
							disabled="#{not networkConfigBean.routingCheck}" 
							reRender="networkConfigTab" />
						<a4j:commandButton id="btnUpdateRT" value="Update" styleClass="rich-button"
							onclick="editNetworkConfig('RT')"  rendered="#{networkConfigBean.routing.subMode eq 'EDIT'}"
							disabled="#{not networkConfigBean.routingCheck}"
							reRender="networkConfigTab" />&nbsp;
						<a4j:commandButton ajaxSingle="true" id="btnDeleteRT" value="Delete" styleClass="rich-button"
							disabled="#{not (networkConfigBean.routingCheck) or (networkConfigBean.routing.subMode eq 'EDIT')or (networkConfigBean.listRouting == null or empty (networkConfigBean.listRouting))}">
							<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
								oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');" 
								reRender="networkConfigTab">
							</a4j:support>
						</a4j:commandButton>&nbsp;&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>
		</td></tr>
		<tr><td>
			<rich:dataTable width="100%" id="RoutingTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listRouting}" var="routing">
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.routing.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listRouting}"></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs" value="#{routing.isSelected}" rendered="#{not((index == networkConfigBean.routing.rowNum) and (networkConfigBean.routing.subMode eq 'EDIT'))}"
							onclick="validateCheckbox('N',document.getElementById('DetailForm:incRouting:RoutingTable:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
				
					<rich:column width="5%" style="vertical-align:top;"  rendered="true">
						<f:facet name="header"> 
							<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center" >
							<h:outputLink value="#" id="edit" onclick="editRouting('#{routing.id.urNo}','#{routing.id.subUrNo}','#{index}')">
								<img src="../images/p_edit.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
					
					<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteRT" rendered="#{((networkConfigBean.routing.subMode eq 'ADD')or (index == networkConfigBean.routing.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{routing.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{routing.id.subUrNo}"/>
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
						<h:outputLink value="#" id="link">
							<h:outputText value="#{routing.id.subUrNo}" />
						    <rich:componentControl for="ViewRouting" attachTo="link" operation="show" event="onclick"/>
						</h:outputLink>
					</div>
				</rich:column>
				<rich:column width="20%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Address/Mask" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{routing.ipAddress}" />
						&nbsp;/&nbsp;
						<h:outputText value="#{routing.mask}" />
					</div>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Interface" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">						
						<h:outputText value="#{routing.interface}" />
					</div>	
				</rich:column>
				
				<rich:column width="15%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Next Hop" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{routing.nextHop}" />
					</div>	
				</rich:column>
				
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Description" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="left">
						<h:inputTextarea id="remark" style="width:100%;" rows="3" readonly="true"  
							value="#{routing.reqDesc}">
						</h:inputTextarea>
					</div>
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listRouting) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="RoutingTable"
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

<rich:simpleTogglePanel switchType="client" id="RoutingImport" label="Import Routing"  width="100%">
		<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%">
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.routingCheck}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.routingCheck}" id="dlrt" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestRouting}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>
				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configRouting.listener}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			id="impRouting" 
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