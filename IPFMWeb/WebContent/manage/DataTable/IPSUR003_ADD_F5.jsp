<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<h:panelGrid columns="1" width="100%" id="f5PanelGrid">
<rich:simpleTogglePanel switchType="client" id="F5Request" label="Policy F5"  width="100%">
	<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
		<tr>
		  <td>
			<table width="100%" border="0" class="thtext_detail">
				<tr>
					<td width="760" class="border4">
						<h:panelGroup rendered="#{networkConfigBean.insertF5Mode and networkConfigBean.f5.subMode == 'ADD'}">
							<table width="100%" border="0" class="thtext_detail">
								<tr class="inputRow">
									<td class="labelStyle">
										VIP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
									</td>
									<td class="valuelStyle" style="width:220px;">
										<h:inputText id="vip" value="#{networkConfigBean.f5.vip}" style="text-align:left;width:100px" 
											onkeypress="return checkIPKey(this,event);"  onblur="if (this.value!='') verifyTextBoxIp(this);"/>
									</td>
									<td class="labelStyle">
										IP Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
									</td>
									<td class="valuelStyle" >
										<h:inputText id="vipPort" value="#{networkConfigBean.f5.ipPort}" style="text-align:left;width:120px" onkeypress="return numberformat.keyPressIntegerOnly(this, event);" onblur="this.value = isNumber(this);"/>
									</td>	
								</tr>
							</table>
						</h:panelGroup>
						<h:panelGroup rendered="#{not networkConfigBean.insertF5Mode or networkConfigBean.f5.subMode == 'EDIT'}">
							<table width="100%" border="0" class="thtext_detail">
								<tr class="inputRow">
									<td class="labelStyle">
										VIP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
									</td>
									<td class="valuelStyle"  style="width:220px;" >
										<h:outputText value="#{networkConfigBean.f5.vip}" />
									</td>
									<td class="labelStyle">
										IP Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
									</td>
									<td class="valuelStyle" >
										<h:outputText value="#{networkConfigBean.f5.ipPort}" />
									</td>	
								</tr>
							</table>
						</h:panelGroup>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="760" class="border4">
						<table width="100%" border="0" class="thtext_detail">
							<tr class="inputRow">
								<td class="labelStyle">
									SNAT IP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
								</td>
								<td class="valuelStyle" style="width:220px">
									<h:panelGrid columns="2"  rendered="true">
										<h:selectOneRadio id="snat" value="#{networkConfigBean.f5.isSnatIP}">
											<f:selectItem itemValue="N" itemLabel="No"/>
										 	<f:selectItem itemValue="Y" itemLabel="Yes"/> 
										 	<a4j:support event="onclick" action="#{configf5.clearSnatIP}" reRender="snatPort" status="#{rich:component('wait')}.hide();"/>
										</h:selectOneRadio>
										<h:inputText id="snatPort" value="#{networkConfigBean.f5.snatIp}" style="text-align:left;width:100px" readonly="#{networkConfigBean.f5.isSnatIP!='Y'}" onkeypress="return checkIPKey(this,event);" onblur="if (this.value!='') verifyTextBoxIp(this)" /> 
									</h:panelGrid>
									<h:panelGrid columns="2"  rendered="false">
										<h:outputText value="No" rendered="#{networkConfigBean.f5.isSnatIP eq 'N'}" />
										<h:outputText value="Yes" rendered="#{networkConfigBean.f5.isSnatIP eq 'Y'}" />
										<h:outputText value="#{networkConfigBean.f5.snatIp}" />
									</h:panelGrid>
								</td>
								<td class="labelStyle">
									IP Pool<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
								</td>
								<td class="valuelStyle" >
									<h:inputHidden id="ipFound" value="#{networkConfigBean.f5.isFound}"/>
									<h:inputText id="ipAddress" value="#{networkConfigBean.f5.ipPool}" style="text-align:left;width:120px" 
										onkeypress="return checkIPKey(this,event);"
										onblur="if (this.value!='') { if(verifyTextBoxIp(this)) { findIPF5(this);} }"/>
								</td>	
							</tr>
							<tr class="inputRow">
								<td class="labelStyle">
									Persistence<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
								</td>
								<td class="valuelStyle" style="width:220px">
									<h:panelGrid columns="2"  rendered="true">	
										<h:selectOneRadio id="persistence" value="#{networkConfigBean.f5.persistence}">
											<f:selectItem itemValue="N" itemLabel="No"/>
										 	<f:selectItem itemValue="Y" itemLabel="Yes"/> 
										</h:selectOneRadio>
									</h:panelGrid>
									<h:panelGrid columns="2"  rendered="false">
										<h:outputText value="No" rendered="#{networkConfigBean.f5.persistence eq 'N'}" />
										<h:outputText value="Yes" rendered="#{networkConfigBean.f5.persistence eq 'Y'}" />
									</h:panelGrid>

								</td>
								<td class="labelStyle">
									IP Pool Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
								</td>
								<td class="valuelStyle" >
									<h:inputText id="ipPoolPort" value="#{networkConfigBean.f5.ipPoolPort}" style="text-align:left;width:120px" onkeypress="return numberformat.keyPressIntegerOnly(this, event);" onblur="isNumber(this);"/>
								</td>	
							</tr>
							<tr class="inputRow">
								<td class="labelStyle">
									Method<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
								</td>
								<td class="valuelStyle" style="width:220px">
									<h:panelGrid columns="2" rendered="true">
										<h:selectOneRadio id="method" value="#{networkConfigBean.f5.method}">
											<f:selectItem itemValue="RR" itemLabel="Round Robin"/>
										 	<f:selectItem itemValue="RT" itemLabel="Ratio"/> 
										 	<a4j:support reRender="errorMsg,weight" ajaxSingle="true" event="onclick"/>
										</h:selectOneRadio>
									</h:panelGrid>	
									<h:panelGrid columns="2"  rendered="false">
										<h:outputText value="Round Robin"   rendered="#{networkConfigBean.f5.method eq 'RR'}"/>
										<h:outputText value="Ratio"   rendered="#{networkConfigBean.f5.method eq 'RT'}"/>
									</h:panelGrid>
								</td>
								<td class="labelStyle">
									Weight<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;
								</td>
								<td class="valuelStyle" >
									<h:inputText id="weight" value="#{networkConfigBean.f5.ipWeight}" readonly="#{networkConfigBean.f5.method eq 'RR'}" style="text-align:left;width:120px" maxlength="3"  onkeypress="return ((keyDigitRange(this,event,1,100)));" onblur="this.value = isNumber(this);"/>
								</td>	
							</tr>
						</table>
					</td>
					<td>&nbsp;</td>
				</tr>

			 <tr>
				<td colspan="2" align="left">
					<h:panelGroup id="btnPopupF5">
						<a4j:commandButton id="btnRetrieveData" value="Retrieve Data" styleClass="rich-button"
							rendered="#{networkConfigBean.insertF5Mode}" 
							onclick="retrieveData()" disabled="#{not (networkConfigBean.f5Check) or (networkConfigBean.f5.subMode eq 'EDIT')}"
							reRender="networkConfigTab">
						</a4j:commandButton>	
						<a4j:commandButton id="btnOtherVip" value="Other VIP" styleClass="rich-button"
							action="#{configf5.otherIp}"
							rendered="#{not networkConfigBean.insertF5Mode}"
							reRender="networkConfigTab" />&nbsp;	
						<a4j:commandButton id="btnAddF5" value="Add" styleClass="rich-button" onclick="addNetworkConfigF5('F5');" 
							rendered="#{networkConfigBean.f5.subMode eq 'ADD'}" 
							disabled="#{not networkConfigBean.f5Check}" 
							reRender="networkConfigTab">
						</a4j:commandButton>
						<a4j:commandButton id="btnUpdateF5" value="Update" styleClass="rich-button"
							onclick="editNetworkConfig('F5')" rendered="#{networkConfigBean.f5.subMode eq 'EDIT'}"
							reRender="networkConfigTab" />&nbsp;
						<a4j:commandButton ajaxSingle="true" id="btnDeleteF5" value="Delete" styleClass="rich-button"
							disabled="#{not (networkConfigBean.f5Check) or (networkConfigBean.f5.subMode eq 'EDIT')or (networkConfigBean.listF5 == null or empty (networkConfigBean.listF5))}">
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
			<rich:dataTable width="100%" id="f5Table" cellpadding="1" cellspacing="0" border="0"
				reRender="scrollIPDetailTable" rows="#{ipfmConfigBean.rowPerPage}"
				rowClasses="odd,even" 
				styleClass="contentform" rowKeyVar="index" 
				headerClass="tableHeader"
				value="#{networkConfigBean.listF5}" var="f5">
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:selectBooleanCheckbox id="checkAll" value="#{networkConfigBean.f5.checkAll}" onclick="validateCheckbox('ALL',this,this,'chkboxs','')" disabled="#{empty networkConfigBean.listF5}"  ></h:selectBooleanCheckbox>
						</f:facet>
						<div align="center">
							<h:selectBooleanCheckbox id="chkboxs" value="#{f5.isSelected}" rendered="#{not((index == networkConfigBean.f5.rowNum) and (networkConfigBean.f5.subMode eq 'EDIT'))}"
							onclick="validateCheckbox('N',document.getElementById('DetailForm:incF5:f5Table:checkAll'),this,'chkboxs','')"></h:selectBooleanCheckbox>
						</div>
					</rich:column>
				
				<rich:column width="5%" style="vertical-align:top;"  rendered="true">
					<f:facet name="header"> 
						<h:outputText value="Edit" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<a4j:commandButton id="editUrF5" image="../images/p_edit.gif" 
							onclick="editF5Detail('#{f5.id.urNo}','#{f5.id.subUrNo}','#{index}');">
						</a4j:commandButton>

					</div>
				</rich:column>
				<rich:column width="5%" style="vertical-align:top;">
						<f:facet name="header"> 
							<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
						</f:facet>
						<div align="center">
							<h:outputLink value="#" id="deleteF5" rendered="#{((networkConfigBean.f5.subMode eq 'ADD')or (index == networkConfigBean.f5.rowNum))}">
								<a4j:support action="#{reqNWConfigAction.confirmDeleteSubUr}" event="onclick"
									oncomplete="Richfaces.showModalPanel('confirmDeletePopup');" 
									reRender="networkConfigTab">
									<a4j:actionparam name="urNo" value="#{f5.id.urNo}"/>
 									<a4j:actionparam name="subUrNo" value="#{f5.id.subUrNo}"/>
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
						<h:panelGroup>
							<h:outputText value="#{f5.id.subUrNo}" />
						</h:panelGroup>
					</div>
				</rich:column>
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="VIP" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="VIP:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipAddress}" />
						<h:outputText value="VIP Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.vipPort}" />
						<h:outputText value="SNAT IP:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isSnapIp eq 'Y' ? 'Yes' : 'No'} #{f5.isSnapIp eq 'Y' ? f5.snapIp : ''}" />
						</h:panelGroup>
						<h:outputText value="Persistence:" styleClass="label"></h:outputText>
						<h:panelGroup>
							<h:outputText value="#{f5.isPersistence eq 'Y' ? 'Yes' : 'No'}" />
						</h:panelGroup>
					</h:panelGrid>	
				</rich:column>
				
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="Method" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<div align="center">
						<h:panelGroup>
							<h:outputText value="Round Robin" rendered="#{f5.method eq 'RR'}" />
							<h:outputText value="Ratio" rendered="#{f5.method eq 'RT'}" />
						</h:panelGroup>
					</div>	
				</rich:column>
				
				<rich:column width="25%" style="vertical-align:top;">
					<f:facet name="header">
						<h:outputText value="IP Pool" styleClass="contentform tableHeaderText"></h:outputText>
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputText value="IP Pool:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpAddress}" />
						<h:outputText value="IP Pool Port:" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolIpPort}" />
						<h:outputText value="Weight(%):" styleClass="label"></h:outputText>
						<h:outputText value="#{f5.poolWeight}" />
					</h:panelGrid>
					<h:inputHidden id="ipPort" value="#{f5.poolIpPort}"></h:inputHidden>
					<h:inputHidden id="ipWeight" value="#{f5.poolWeight}"></h:inputHidden>
				</rich:column>
				
				
				<f:facet name="footer">
					<rich:columnGroup>
						<rich:column colspan="4">
							Total : <h:outputText value="#{ fn:length(networkConfigBean.listF5) }" /> records
						</rich:column>
						<rich:column colspan="10">
							<rich:datascroller immediate="true" rendered="true" align="right" for="f5Table"
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

	<rich:simpleTogglePanel switchType="client" id="f5Import" label="Import F5">
		<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
			<tr>
				<td valign="top" width="30%">
				<h:outputText value="Download Template" style="FONT-WEIGHT: bold;" rendered="#{not networkConfigBean.f5Check}"/>
					<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;" 
					     rendered="#{networkConfigBean.f5Check}" id="dlf5" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.templateRequestF5}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>

				</td>
				<td>
					 <rich:fileUpload fileUploadListener="#{configf5.listener}"
	             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             			id="impF5" 
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


