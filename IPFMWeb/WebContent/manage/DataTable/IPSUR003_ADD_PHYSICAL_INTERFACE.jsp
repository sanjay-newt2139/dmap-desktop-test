<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style type="text/css">


</style>
<h:panelGrid columns="1" width="100%">





<rich:simpleTogglePanel switchType="client" id="PhysicalInterfaceRequest" label="Policy Physical Interface" width="100%">
	<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr><td>
			<table width="100%" border="0" class="thtext_detail">
				<tr > 
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>IP</strong></td>
					<td colspan="2" class="tableHeader contentform tableHeaderText" style="text-align:center; "><strong>Interface Detail</strong></td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Type :<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td colspan="4"> 
						<table>
							<tr>
								<td>
									<h:selectOneRadio id="ipType" value="#{networkConfigBean.phyInterface.piType}">
										<f:selectItem itemValue="A" itemLabel="Access" />
									 	<f:selectItem itemValue="T" itemLabel="Trunk" />
									 	<a4j:support event="onclick" reRender="trunkNo"/>
									</h:selectOneRadio>
								</td>
								<td>
									<rich:comboBox id="trunkNo" value="#{networkConfigBean.phyInterface.trunkNo}" 
										itemClass="contentform"  itemSelectedClass="contentform" disabled="#{networkConfigBean.phyInterface.piType != 'T'}">
										<f:selectItems value="#{configPhyInterface.trunkNo}"/>
									</rich:comboBox>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr  class="inputRow">
					<td class="labelStyle">IP Node<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="230">

							<h:inputText id="ipNode" value="#{networkConfigBean.phyInterface.ipNode}" style="text-align:left;width:100px" 
								onkeypress="return checkIPKey(this,event);"
								onblur="#{rich:component('wait')}.show();  if(this.value=='') clearSourceIP(); if(this.value!='') {if (verifyTextBoxIp(this)) findIPNode(); else clearSourceIP();}"/>
							<a4j:jsFunction name="findIPNode" actionListener="#{configPhyInterface.findIPNode}" 
								reRender="errorMsg,ipFound,hostName,macAddress,locationName,floor,vlanId,remark" 
								oncomplete="#{rich:component('wait')}.hide(); checkAlert('DetailForm:incInterface:ipFound','IP ยังไม่ถูก Assign กรุณาตรวจสอบข้อมูล');">
							</a4j:jsFunction>
							<a4j:jsFunction name="clearSourceIP" actionListener="#{configPhyInterface.clearSourceIP}" 
								reRender="ipFound,hostName,macAddress,locationName,floor,vlanId,remark"
								oncomplete="#{rich:component('wait')}.hide();"
								>
							</a4j:jsFunction>

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
					<div>
						<rich:comboBox id="portStatus" value="#{networkConfigBean.phyInterface.portStatus}" itemClass="contentform"  
							style="text-align:left;width:145px" itemSelectedClass="contentform">
							<f:attribute name="selectItems" value="#{configPhyInterface.portStatus}"/>
							<f:selectItems value="#{configPhyInterface.portStatus}"/>
							<a4j:support reRender="errorMsg" event="onblur" action="#{reqNWConfigAction.checkPortStatus}"/>
						</rich:comboBox>
					</div>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">Floor&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="floor" value="#{networkConfigBean.phyInterface.floor}"  onkeypress="return keyRange(this,event,1,99);"  style="text-align:left;width:145px"/>
					</td>
					<td class="labelStyle">Speed Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td>
						<rich:comboBox id="speedPort" itemSelectedClass="contentform" itemClass="contentform"  
							style="text-align:left;width:145px" value="#{networkConfigBean.phyInterface.speedPort}">
							<f:attribute name="selectItems" value="#{configPhyInterface.speedPort}"/>
							<f:selectItems value="#{configPhyInterface.speedPort}"/>
							<a4j:support reRender="errorMsg" event="onblur" action="#{reqNWConfigAction.checkSpeedPort}"/>
						</rich:comboBox>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle">VLAN ID&nbsp;:&nbsp;</td>
					<td>
						<h:outputText id="vlanId" value="#{networkConfigBean.phyInterface.vlanID}" />
					</td>
					<td class="labelStyle">Encloser&nbsp;:&nbsp;</td>
					<td>
						<h:inputText id="enclosure" value="#{networkConfigBean.phyInterface.enclosure}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" valign="top">Remarks of IP&nbsp;:&nbsp;</td>
					<td colspan="3">
						<h:inputTextarea id="remark" style="width:360px;" rows="3"  value="#{networkConfigBean.phyInterface.reqRemark}" readonly="true">
						</h:inputTextarea>
					</td>
					<td>&nbsp;</td>
				</tr>
			<tr>
				<td colspan="2" align="left">
					<h:panelGroup id="btnPopupPI">
						<a4j:commandButton id="btnAddPI" value="Add" styleClass="rich-button"
							onclick="addNetworkConfig('PI')" rendered="#{networkConfigBean.phyInterface.subMode eq 'ADD'}"
							disabled="#{not networkConfigBean.physicalCheck}"
							reRender="PhysicalTable" />							
						<a4j:commandButton id="btnUpdatePI" value="Update" styleClass="rich-button"
								onclick="editNetworkConfig('PI')" 
								rendered="#{networkConfigBean.phyInterface.subMode eq 'EDIT'}"
								disabled="#{not networkConfigBean.physicalCheck}"
								reRender="PhysicalTable" />&nbsp;
						<a4j:commandButton ajaxSingle="true" id="btnDeletePI" value="Delete" styleClass="rich-button"
							disabled="#{not (networkConfigBean.physicalCheck) or (networkConfigBean.phyInterface.subMode eq 'EDIT') or (networkConfigBean.listPhysicalInterface == null or empty (networkConfigBean.listPhysicalInterface))}">
							<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
								oncomplete="Richfaces.showModalPanel('confirmDeleteAllPopup');"  
								reRender="PhysicalTable">
							</a4j:support>
						</a4j:commandButton>&nbsp;&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>
		</td></tr>
		<tr><td>
			<rich:dataTable width="100%" id="PhysicalTable" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listPhysicalInterface}" var="physical">
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.phyInterface.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listPhysicalInterface}" ></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs" value="#{physical.isSelected}"  rendered="#{not((index == networkConfigBean.phyInterface.rowNum) and (networkConfigBean.phyInterface.subMode eq 'EDIT'))}"
							onclick="validateCheckbox('N',document.getElementById('DetailForm:incInterface:PhysicalTable:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
				
				<rich:column width="5%" style="vertical-align:top;"  rendered="true">
						<f:facet name="header"> 
							<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="edit" onclick="editInterface('#{physical.id.urNo}','#{physical.id.subUrNo}','#{index}')">
								<img src="../images/p_edit.gif" border="0">
							</h:outputLink>
						</div>
					</rich:column>
					
					<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteFW" rendered="#{((networkConfigBean.phyInterface.subMode eq 'ADD')or (index == networkConfigBean.phyInterface.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{physical.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{physical.id.subUrNo}"/>
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
						<h:outputText value="#{physical.id.subUrNo}"/>
					</div>
				</rich:column>
				
				<rich:column width="10%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Trunk No" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:outputText value="#{physical.trunkNo}" rendered="#{physical.piType eq 'T'}" />
					</div>
				</rich:column>
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Address/Mask" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Node:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.ipNode}" />
						<h:outputText value="Host Name:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.hostName}" />
						<h:outputText value="Mac Address:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.macAddress}" />
						<h:outputText value="Location/Floor:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{physical.locationName}" />/<h:outputText value="#{physical.floor}" />
						</h:panelGroup>
						<h:outputText value="VLAN ID:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.vlanId}" />
					</h:panelGrid>
				</rich:column>
				
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Interface Detail" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2" >
						<h:outputText value="Node Type:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceNodeDesc}" />
						<h:outputText value="Port Status:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.portStatusDesc}" />
						<h:outputText value="Speed Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.speedPortDesc}" />
						<h:outputText value="Encloser:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.enclosure}" />
						<h:outputText value="Description:" styleClass="label"></h:outputText>
						<h:outputText value="#{physical.interfaceDesc}" />
					</h:panelGrid>
				</rich:column>
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Remarks of IP" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:outputText value="#{physical.reqRemarks}" />
				</rich:column>
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listPhysicalInterface) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="PhysicalTable"
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

<rich:simpleTogglePanel switchType="client" id="piImport" label="Import Physical Interface" width="100%">
		<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%">
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.physicalCheck}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.physicalCheck}" id="dlpi" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestPhysicalInterface}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>

				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configPhyInterface.listener}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			id="impPhysical" 
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