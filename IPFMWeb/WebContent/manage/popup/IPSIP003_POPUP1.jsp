<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
		function isNumberIP2(obj,message){
			var keyChar = "";
			if (!validateNumberIP2(obj.value)) {
				alertErrorMsgx(message+" รูปแบบไม่ถูกต้อง โดยค่าต้องประกอบไปด้วยตัวเลข 0-255 จำนวน 4 ชุด EX : 255.255.255.255, 255.10.0.20");		
				obj.focus();
				return "";
			}
			for (var i=0; i<obj.value.length;i++) {
				keyChar = obj.value.substring(i, i+1);
				if (("0123456789.").indexOf(keyChar) == -1) {
					alertErrorMsgx("กรุณาป้อนข้อมูลเป็นตัวเลข");
					obj.focus();
					return "";
				}
			}
			return obj.value;
		}
		
		function validateNumberIP2(value){
			if (value.length>0) { 
				var ip = value.split(".");
				if (ip.length != 4) {
					return false;
				}else{
					for (var i=0; i<4;i++) {
						if (ip[i]=="" || ip[i]>255 || ip[i]<0) {
							return false;
						}
					}
				}
			}
			return true;
		}
		
		function alertErrorMsgx(errorString) {
			alertErrorMsgAjx(errorString);

		}
</script>

<rich:modalPanel id="setExpireDateModal" width="650" minHeight="200" autosized="true">
    <f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Update Info"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="../images/close.png" styleClass="hidelink" id="setExpireDateHidelink"/>
			<rich:componentControl for="setExpireDateModal" attachTo="setExpireDateHidelink" operation="hide" event="onclick"/>
		</h:panelGroup>
	</f:facet> 
	<h:panelGroup style="width:100%;">
   		<a4j:form>
	   		<a4j:jsFunction name="alertErrorMsgAjx" 
				actionListener="#{ipLevel2Action.alertErrorMsg}"
			 	reRender="errorMsgx">
			 	<a4j:actionparam name="errorMessage"/>
		</a4j:jsFunction>
			<h:panelGrid id="updateInfoPanelGrid" columns="7" styleClass="contentlabelform" style="text-align:left;" width="100%">
				<h:selectBooleanCheckbox id="checkBoxIPStatus"  value="#{ipLevel3Bean.checkBoxIPStatus}" 
					disabled="#{!ipLevel3Bean.statusEditAble}">
					<a4j:support event="onclick" reRender="comboBoxIPStatusUpdateInfo,outputTextIPStatusUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="IP Status" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<rich:comboBox id="comboBoxIPStatusUpdateInfo" defaultLabel="" enableManualInput="false" 
						itemClass="contentform" itemSelectedClass="contentform" 
						value="#{ipLevel3Bean.ipStatusComboItem}" width="152" listWidth="147" listHeight="150"
						disabled="#{!ipLevel3Bean.checkBoxIPStatus}" >
						<f:attribute name="selectItems" value="#{ipLevel3Bean.ipStatusList}"/>
						<f:selectItems value="#{ipLevel3Bean.ipStatusList}" />	
						<a4j:support reRender="errorMsg,comboBoxIPStatusUpdateInfo" event="onchange" 
							action="#{ipLevel3Action.checkIpStatusCombo}" />				
					</rich:comboBox>
				</h:panelGroup>
				<rich:spacer width="10" />
				<h:selectBooleanCheckbox id="checkBoxHostName"  value="#{ipLevel3Bean.checkBoxHostName}" >
					<a4j:support event="onclick" reRender="inputTextHostNameUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Host Name" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:inputText id="inputTextHostNameUpdateInfo" value="#{ipLevel3Bean.ipInfo.hostName}" 
					maxlength="1000" size="20" styleClass="contentform" disabled="#{!ipLevel3Bean.checkBoxHostName}" />
				
				
				<h:selectBooleanCheckbox id="checkBoxCompany"  value="#{ipLevel3Bean.checkBoxCompany}" 
					disabled="#{!ipLevel3Bean.companyEdit}">
					<a4j:support event="onclick" reRender="comboBoxCompanyUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Company" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<rich:comboBox id="comboBoxCompanyUpdateInfo" defaultLabel="" rendered="#{ipLevel3Bean.companyEdit}"
						enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
						width="152" listWidth="147" listHeight="150"
						value="#{ipLevel3Bean.companyComboItem}" disabled="#{!ipLevel3Bean.checkBoxCompany}" >
						<f:attribute name="selectItems" value="#{ipLevel3Bean.companyList}"/>
						<f:selectItems value="#{ipLevel3Bean.companyList}" />
						<a4j:support reRender="errorMsg,comboBoxCompanyUpdateInfo" event="onchange" action="#{ipLevel3Action.checkCompanyCombo}" />
					</rich:comboBox>
					<h:outputText rendered="#{!ipLevel3Bean.companyEdit}" value="#{ipLevel3Bean.ipInfo.companyName}" 
						styleClass="contentform"/>				
				</h:panelGroup>
				<rich:spacer width="10" />
				<h:selectBooleanCheckbox id="checkBoxSystemName"  value="#{ipLevel3Bean.checkBoxSystemName}" >
					<a4j:support event="onclick" reRender="inputTextSystemNameUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:outputText value="System Name :&nbsp;" escape="false" style="font-weight:bold;" />
				<h:inputText id="inputTextSystemNameUpdateInfo" value="#{ipLevel3Bean.ipInfo.systemName}" 
					maxlength="1000" size="20" styleClass="contentform" disabled="#{!ipLevel3Bean.checkBoxSystemName}"/>
				
				
				<h:selectBooleanCheckbox id="checkBoxSystemOwnerName"  value="#{ipLevel3Bean.checkBoxSystemOwnerName}" >
					<a4j:support event="onclick" reRender="inputTextSystemOwnerNameUpdateInfo,suggestionBoxSystemOwnerNameUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="System Owner Name" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<h:inputText id="inputTextSystemOwnerNameUpdateInfo" size="20" maxlength="50" 
						value="#{ipLevel3Bean.ipInfo.systemOwnerName}" 
						styleClass="contentform" disabled="#{!ipLevel3Bean.checkBoxSystemOwnerName}" />
					<rich:suggestionbox id="suggestionBoxSystemOwnerNameUpdateInfo" binding="#{ipLevel3Bean.suggestSystemOwnerUpdateInfo}" 
						for="inputTextSystemOwnerNameUpdateInfo" suggestionAction="#{ipLevel3Action.userSuggestion}" requestDelay="0" 
						var="suggest2" status="#{rich:component('wait')}.hide();" usingSuggestObjects="true" 
						fetchValue="#{suggest2.label}" frequency="0" width="178" limitToList="20" >
						<h:column>
							<h:outputText value="#{suggest2.label}"/>
						</h:column>
						<a4j:support event="onobjectchange" action="#{ipLevel3Action.suggestSysOwnerUpdateInfo}" 
							status="#{rich:component('wait')}.hide();" reRender="ownerTeamIdUpdateInfo"/>
					</rich:suggestionbox>					
				</h:panelGroup>
				<rich:spacer width="10" />
				<h:selectBooleanCheckbox id="checkBoxDNSName"  value="#{ipLevel3Bean.checkBoxDNSName}" >
					<a4j:support event="onclick" reRender="inputTextDNSNameUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:outputText value="DNS Name :&nbsp;" escape="false" style="font-weight:bold;" />
				<h:inputText id="inputTextDNSNameUpdateInfo" value="#{ipLevel3Bean.ipInfo.dnsName}" maxlength="30" 
					size="20" styleClass="contentform" disabled="#{!ipLevel3Bean.checkBoxDNSName}"/>				
				

				<rich:spacer width="10" />
				<h:panelGroup>
					<h:outputText value="System Owner Team" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:inputText id="ownerTeamIdUpdateInfo" value="#{ipLevel3Bean.sysOwnerTeamComboItem}" readonly="true"/>
				<rich:spacer width="10" />
				<h:selectBooleanCheckbox id="checkBoxNetworkIP"  value="#{ipLevel3Bean.checkBoxNetworkIP}" 
					disabled="#{!ipLevel3Bean.networkIpEdit}">
					<a4j:support event="onclick" reRender="inputTextNetworkIPUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Network IP" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<h:inputText id="inputTextNetworkIPUpdateInfo" value="#{ipLevel3Bean.ipInfo.networkIp}" 
						maxlength="15" size="20" styleClass="contentform" rendered="#{ipLevel3Bean.networkIpEdit}"
						onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Network IP');"
						disabled="#{!ipLevel3Bean.checkBoxNetworkIP}"/>			                        
						<h:outputText rendered="#{!ipLevel3Bean.networkIpEdit}" value="#{ipLevel3Bean.ipInfo.networkIp}" 
						styleClass="contentform"/>
				</h:panelGroup>


				<h:selectBooleanCheckbox id="checkBoxSiteLocation"  value="#{ipLevel3Bean.checkBoxSiteLocation}" >
					<a4j:support event="onclick" reRender="comboBoxSiteLocationUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Site/Location" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<rich:comboBox id="comboBoxSiteLocationUpdateInfo" defaultLabel="" enableManualInput="false" itemClass="contentform" 
					itemSelectedClass="contentform" value="#{ipLevel3Bean.locationComboItem}" 
					width="152" listWidth="147" listHeight="150" disabled="#{!ipLevel3Bean.checkBoxSiteLocation}">
					<f:attribute name="selectItems" value="#{ipLevel3Bean.locationList}"/>
					<f:selectItems value="#{ipLevel3Bean.locationList}"/>
					<a4j:support reRender="errorMsg,comboBoxSiteLocationUpdateInfo" event="onchange" 
						action="#{ipLevel3Action.checkLocationCombo}" />
				</rich:comboBox>
				<rich:spacer width="10" />
				<h:selectBooleanCheckbox id="checkBoxGateway"  value="#{ipLevel3Bean.checkBoxGateway}" 
					disabled="#{!ipLevel3Bean.gatewayEdit}">
					<a4j:support event="onclick" reRender="inputTextGatewayUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Gateway" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<h:inputText id="inputTextGatewayUpdateInfo" value="#{ipLevel3Bean.ipInfo.gateway}" maxlength="15" 
						size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" 
						rendered="#{ipLevel3Bean.gatewayEdit}" onblur="this.value = isNumberIP2(this,'Gateway');" 
						disabled="#{!ipLevel3Bean.checkBoxGateway}"/>			                        
					<h:outputText rendered="#{!ipLevel3Bean.gatewayEdit}" value="#{ipLevel3Bean.ipInfo.gateway}" styleClass="contentform"/>				
				</h:panelGroup>

				
				<h:selectBooleanCheckbox id="checkBoxExpiredDate"  value="#{ipLevel3Bean.checkBoxExpiredDate}" >
					<a4j:support event="onclick" reRender="calendarExpiredDateUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Extend Expire Date to" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<rich:calendar id="calendarExpiredDateUpdateInfo" value="#{ipLevel3Bean.ipInfo.expiredDate}"
	                locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" 
	                cellWidth="24px" cellHeight="22px" style="width:200px" 
	                inputStyle="background-color:white;" inputSize="20" direction="auto"
	                disabled="#{!ipLevel3Bean.checkBoxExpiredDate}"/>
				<rich:spacer width="10" />
				<h:selectBooleanCheckbox id="checkBoxMask"  value="#{ipLevel3Bean.checkBoxMask}" >
					<a4j:support event="onclick" reRender="inputTextMaskUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Mask" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:inputText id="inputTextMaskUpdateInfo" value="#{ipLevel3Bean.ipInfo.ipSubmask}" 
					maxlength="15" size="20" styleClass="contentform" 
					onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Mask');"
					disabled="#{!ipLevel3Bean.checkBoxMask}"/>	
					
					
				<!-- VLAN -->	
				<h:selectBooleanCheckbox id="checkBoxVLAN"  value="#{ipLevel3Bean.checkBoxVlan}" >
					<a4j:support event="onclick" reRender="inputTextVlanUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="VLAN" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<h:inputText id="inputTextVlanUpdateInfo" value="#{ipLevel3Bean.ipInfo.vlanId}" maxlength="30" size="20" styleClass="contentform"
							onkeypress="return keyRange(this,event,1,4096);"
							disabled="#{!ipLevel3Bean.checkBoxVlan}">
						<a4j:support event="onblur" action="#{ipLevel3Action.checkDupVlan}" reRender="updateInfoPanelGrid,errorMsg"/>							
					</h:inputText>
					
					<br>
				</h:panelGroup>
					
<!--					<h:outputLabel id="warningVlan" value="* #{ipLevel3Bean.msgWarnDup}" style="color:red;" rendered="#{ipLevel3Bean.showWarnDup}"/>-->
				<h:outputLabel value=" &nbsp;" escape="false" style="font-weight:bold;" />
				<h:outputLabel value=" &nbsp;" escape="false" style="font-weight:bold;" />
				
				
				
				
				
				
				
				
				<!-- 				//ADD NAT IP	 -->
				<h:selectBooleanCheckbox id="checkBoxNAT" value="#{ipLevel3Bean.checkBoxNat}" disabled="#{!ipLevel3Bean.openCheckBoxNatIP}" >
					<a4j:support event="onclick" reRender="inputTextNatUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="NAT IP" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;" />
				</h:panelGroup>
				<h:panelGroup>
					<h:inputTextarea value="#{ipLevel3Bean.ipInfo.natIp}" rows="3" cols="40" id="inputTextNatUpdateInfo"
					disabled="#{!ipLevel3Bean.checkBoxNat}"
					style="width:220px;" styleClass="contentform" onkeypress="return chkLength(this,500);"/>								
					<br>
				</h:panelGroup>		
				
				
				
				
				
				
				
				
				                    
			</h:panelGrid>
			
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:right;" width="100%">
				<h:panelGroup>
					<a4j:commandButton value="SAVE"  action="#{ipLevel3Action.updateExpireDate}" reRender="#{errorMessages?'errorMsg':'errorMsg,DetailForm'}" styleClass="rich-button" style="width:70px;">
						<rich:componentControl for="setExpireDateModal" operation="#{errorMessages?'show':'hide'}" event="oncomplete" />
					</a4j:commandButton>
					<rich:spacer width="10" />
					<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" style="width:70px;" ajaxSingle="true" status="#{rich:component('wait')}.hide();"> 
					    <rich:componentControl for="setExpireDateModal" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>	
		</a4j:form>
	</h:panelGroup>
	
	
<%-- 	<h:panelGroup id="errorMsgx"> --%>
<%-- 	<rich:modalPanel id="errorDialog" autosized="true" showWhenRendered="true" rendered="#{globalMessages}" resizeable="false" width="400">			 --%>
<%-- 		<f:facet name="header"> --%>
<%-- 			<h:panelGroup> --%>
<%-- 				<h:outputText value="IPFM Message"  ></h:outputText> --%>
<%-- 			</h:panelGroup> --%>
<%-- 		</f:facet> --%>
<%-- 		<f:facet name="controls" > --%>
<%-- 			<h:panelGroup> --%>
<%-- 				<h:graphicImage value="../images/ico_close.png" id="hideErrorDialog" style="cursor:pointer;" > --%>
<%-- 					<rich:componentControl for="errorDialog" attachTo="hideErrorDialog" operation="hide" event="onclick" /> --%>
<%-- 				</h:graphicImage> --%>
<%-- 			</h:panelGroup> --%>
<%-- 		</f:facet> --%>
		
<!-- 		<table border="0" width="100%" cellspacing="0" cellpadding="0"> -->
<!-- 			<tr> -->
<!-- 				<td> -->
<%-- 					<h:panelGrid columns="1" width="100%" styleClass="contentlabelform" > --%>
<%-- 						<h:messages styleClass="contentlabelform" errorStyle="color: red"  --%>
<%-- 									warnStyle="color: green" infoStyle="color: blue" globalOnly="true"  /> --%>
<%-- 					</h:panelGrid> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr>  -->
<!-- 				<td> -->
<%-- 					<h:panelGrid columns="1" width="100%" style="text-align:center;" styleClass="contentlabelform">  --%>
					
<%-- 						<a4j:form>	 --%>
<%-- 							<a4j:commandButton value="OK" styleClass="rich-button"  ajaxSingle="true" status="#{rich:component('wait')}.hide();"> --%>
<%-- 	    						<rich:componentControl for="errorDialog" operation="hide" event="oncomplete" /> --%>
<%-- 							</a4j:commandButton>	 --%>
<%-- 						</a4j:form>			 --%>
<%-- 					</h:panelGrid> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table>	 -->
<%-- 	</rich:modalPanel> --%>
<%-- </h:panelGroup> --%>
</rich:modalPanel>