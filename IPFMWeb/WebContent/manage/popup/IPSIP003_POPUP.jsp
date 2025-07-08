<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script type="text/javascript">
	function onBlurProjectId(obj){
		if (obj.value.length==0) {
			onChangeProject();
		}
		return false;
	}

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
<style type="text/css">
	.rich-combobox-font-disabled {color:#000000;}
	.rich-sb-int {background-color: #FFFFFF;}
	.richfaces_suggestionEntry  {background-color: #FFFFFF;}
	.rich-sb-int-sel {background-color: #FFFFFF;}
	.richfaces_suggestionSelectValue {color: #FFFFFF;}
</style>
<f:subview id="popupModalSubview">



<rich:modalPanel id="popupUpdateIP" height="400" minWidth="650" styleClass="contentform" autosized="true" >
   <f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Update IP Information</span></strong>
		</h:panelGroup>	
	</f:facet>
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="popupUpdateIP" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <div id="container" style="overflow: auto; width: 100%;height: 350px;">
   		<a4j:form>
   		<a4j:jsFunction name="alertErrorMsgAjx" 
			actionListener="#{ipLevel3Action.alertErrorMsg}"
		 	reRender="errorMsg">
		 	<a4j:actionparam name="errorMessage"/>
		</a4j:jsFunction>
		<rich:panel>
			<table width="100%" border="0" class="thtext_detail">
				<tr>
					<td width="29%"><rich:spacer height="0"/></td>
					<td width="27%"><rich:spacer height="0"/></td>
					<td width="19%"><rich:spacer height="0"/></td>
					<td width="25%"><rich:spacer height="0"/></td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Address :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{ipLevel3Bean.ipInfo.ipAddress}" styleClass="contentform"/>						
					</td>
					<td class="labelStyle"><h:outputText value="Host Name" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipInfo.hostName}" maxlength="1000" size="20" styleClass="contentform"/>
					</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Status" escape="false" ></h:outputText><h:graphicImage rendered="#{ipLevel3Bean.ipStatusEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="ipStatus" rendered="#{ipLevel3Bean.ipStatusEdit}" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel3Bean.ipStatusComboItem}" width="152" listWidth="147" listHeight="150" disabled="#{!ipLevel3Bean.statusEditAble}" >
								<f:attribute name="selectItems" value="#{ipLevel3Bean.ipStatusList}"/>
								<f:selectItems value="#{ipLevel3Bean.ipStatusList}" />
								<a4j:support reRender="errorMsg,ipStatus" event="onchange" action="#{ipLevel3Action.checkIpStatusCombo}" />
							</rich:comboBox>
							<h:outputText rendered="#{!ipLevel3Bean.ipStatusEdit}" value="#{ipLevel3Bean.ipStatusComboItem}" styleClass="contentform" />
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="System Name :&nbsp;" escape="false"  /></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipInfo.systemName}" maxlength="1000" size="20" styleClass="contentform"/>
					</td>
				</tr>
				 <tr class="inputRow">
             		<td class="labelStyle"><h:outputText value="Company" escape="false" ></h:outputText><h:graphicImage rendered="#{ipLevel3Bean.companyEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="company" defaultLabel=""  rendered="#{ipLevel3Bean.companyEdit}"
								enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
							 	width="152" listWidth="147" listHeight="150"
							 	value="#{ipLevel3Bean.companyComboItem}" >
							 	<f:attribute name="selectItems" value="#{ipLevel3Bean.companyList}"/>
							 	<f:selectItems value="#{ipLevel3Bean.companyList}" />
							 	<a4j:support reRender="errorMsg,company" event="onchange" action="#{ipLevel3Action.checkCompanyCombo}" />
						 	</rich:comboBox>
							<h:outputText rendered="#{!ipLevel3Bean.companyEdit}" value="#{ipLevel3Bean.ipInfo.companyName}" styleClass="contentform"></h:outputText>
						</h:panelGrid>
					</td>		
					<td class="labelStyle"><h:outputText value="DNS Name :&nbsp;" escape="false"  /></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipInfo.dnsName}" maxlength="30" size="20" styleClass="contentform"/>
					</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="System Owner<br/>Name" escape="false" /><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:inputHidden id="sysOwnerName" value="#{ipLevel3Bean.sysOwnerComboItem}" >
							<f:attribute name="selectItems" value="#{ipLevel3Bean.sysOwnerList}"/>
						</h:inputHidden>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox rendered="false" id="owner" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel3Bean.sysOwnerComboItem}" width="152"  listWidth="147" listHeight="150" >
								<f:attribute name="selectItems" value="#{ipLevel3Bean.sysOwnerList}"/>
								<f:selectItems value="#{ipLevel3Bean.sysOwnerList}" />
							</rich:comboBox>
							<h:inputText id="sysOwnerName1" size="20" maxlength="50" value="#{ipLevel3Bean.ipInfo.systemOwnerName}" styleClass="contentform"></h:inputText>
							<rich:suggestionbox id="sysOwnerSuggest" binding="#{ipLevel3Bean.suggestSystemOwner}" for="sysOwnerName1" suggestionAction="#{ipLevel3Action.userSuggestion}" requestDelay="0" 
								var="suggest" status="#{rich:component('wait')}.hide();" usingSuggestObjects="true" fetchValue="#{suggest.label}" frequency="0" width="178" limitToList="20">
								<h:column>
									<h:outputText value="#{suggest.label}"/>
								</h:column>
								<a4j:support event="onobjectchange" action="#{ipLevel3Action.suggestSysOwner}" status="#{rich:component('wait')}.hide();" reRender="ownerTeam,ownerTeamId"/>
							</rich:suggestionbox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network Type" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="networkType" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel3Bean.networkTypeComboItem}" width="152"  listWidth="147" listHeight="150">
								<f:attribute name="selectItems" value="#{ipLevel3Bean.nwTypeList}"/>
								<f:selectItems value="#{ipLevel3Bean.nwTypeList}" />
								<a4j:support reRender="errorMsg,networkType" event="onchange" action="#{ipLevel3Action.checkNwTypeCombo}" />
							</rich:comboBox>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="System Owner<br/>Team" escape="false" /><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="ownerTeam" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								rendered="false" value="#{ipLevel3Bean.sysOwnerTeamComboItem}" width="152"  listWidth="147" listHeight="150">
								<f:attribute name="selectItems" value="#{ipLevel3Bean.sysOwnerTeamList}"/>
								<f:selectItems value="#{ipLevel3Bean.sysOwnerTeamList}" />
								<a4j:support reRender="errorMsg,ownerTeam" event="onchange" action="#{ipLevel3Action.checkSystemOwnerTeamCombo}" />
							</rich:comboBox>
							<h:inputText id="ownerTeamId" value="#{ipLevel3Bean.sysOwnerTeamComboItem}" readonly="true"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network Zone :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="networkZone" defaultLabel="" rendered="#{ipLevel3Bean.networkZoneEdit}"
								enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
							 	width="152"  listWidth="147" listHeight="150"
							 	value="#{ipLevel3Bean.networkZoneComboItem}" >
							 	<f:attribute name="selectItems" value="#{ipLevel3Bean.networkZoneList}"/>
							 	<f:selectItems value="#{ipLevel3Bean.networkZoneList}" />
							 	<a4j:support reRender="errorMsg,networkZone" event="onchange" action="#{ipLevel3Action.checkNwZoneCombo}" />
							</rich:comboBox>
							<h:outputText rendered="#{!ipLevel3Bean.networkZoneEdit}" value="#{ipLevel3Bean.ipInfo.networkZoneName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Planning Team :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel3Bean.ipInfo.t2Team.teamName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network IP" escape="false" /><h:graphicImage rendered="#{ipLevel3Bean.networkIpEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText rendered="#{ipLevel3Bean.networkIpEdit}" value="#{ipLevel3Bean.ipInfo.networkIp}" maxlength="15" size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Network IP');"/>
						<h:outputText rendered="#{!ipLevel3Bean.networkIpEdit}" value="#{ipLevel3Bean.ipInfo.networkIp}" styleClass="contentform"/>
					</td>
			  	</tr> 
				<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="UR Refer :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText rendered="#{false && ipLevel3Bean.urReferEdit}" value="#{ipLevel3Bean.ipInfo.urRefer}" maxlength="20" size="20" styleClass="contentform" />
						<h:outputText rendered="#{true || !ipLevel3Bean.urReferEdit}" value="#{ipLevel3Bean.ipInfo.urRefer}" styleClass="contentform"/>
					</td>
					<td class="labelStyle"><h:outputText value="Gateway :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText rendered="#{ipLevel3Bean.gatewayEdit}" value="#{ipLevel3Bean.ipInfo.gateway}" maxlength="15" size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Gateway');"/>
						<h:outputText rendered="#{!ipLevel3Bean.gatewayEdit}" value="#{ipLevel3Bean.ipInfo.gateway}" styleClass="contentform"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Effective Date :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{ipLevel3Bean.ipInfo.effectiveDate}" styleClass="contentform">
							<f:convertDateTime pattern="dd/MM/yyyy"/>
						</h:outputText>
					</td>
					<td class="labelStyle"><h:outputText value="Mask" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipInfo.ipSubmask}" maxlength="15" size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Mask');"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Expire Date" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<rich:calendar value="#{ipLevel3Bean.ipInfo.expiredDate}" 
				                        locale="en/US" popup="true" direction="auto"
				                        datePattern="dd/MM/yyyy" showApplyButton="false" 
				                        cellWidth="24px" cellHeight="22px" style="width:200px"
				                        inputStyle="background-color:white;" inputSize="20" />
					</td>
					<td class="labelStyle"><h:outputText value="Mac Address :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipInfo.macAddress}" maxlength="30" size="20" styleClass="contentform"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Project ID :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="projectId" defaultLabel="" 
				      			 enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
				      			 width="152"  listWidth="147" listHeight="150" 
				      			 onchange="onChangeProject();" onblur="onBlurProjectId(this);"
								 value="#{ipLevel3Bean.projectComboItem}" >
								 <f:attribute name="selectItems" value="#{ipLevel3Bean.projectList}"/>
								 <f:selectItems value="#{ipLevel3Bean.projectList}" />
								 <a4j:jsFunction  name="onChangeProject" action="#{ipLevel3Action.onChangeProject}" oncomplete="#{rich:component('wait')}.hide();"  reRender="errorMsg,projectName,projManager"></a4j:jsFunction>
							</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Project Name :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:inputText id="projectName" size="20" maxlength="1000" styleClass="contentform" value="#{ipLevel3Bean.ipInfo.projectName}"  readonly="#{ipLevel3Bean.projNameDisable}"></h:inputText>
						</h:panelGrid>
					</td>
				 </tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Project Manager :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid id="projManager" columns="2" cellspacing="0" cellpadding="0">
							<rich:spacer width="10"></rich:spacer>						
					       	<rich:comboBox  id="projManagerId" defaultLabel="" enableManualInput="true" inputDisabledStyle="color:black;" 
					       		rendered="#{ false && !ipLevel3Bean.projManagerDisable}"
								 itemClass="contentform" itemSelectedClass="contentform"
								 value="#{ipLevel3Bean.projManagerComboItem}" 
								 width="152"  listWidth="147" listHeight="150" >
								 <f:attribute name="selectItems" value="#{ipLevel3Bean.projManagerList}"/>
								 <f:selectItems value="#{ipLevel3Bean.projManagerList}"/>
							</rich:comboBox>
							<h:inputText size="20" maxlength="50" value="#{ipLevel3Bean.ipInfo.projectManager}" readonly="true" rendered="#{ipLevel3Bean.projManagerDisable}" styleClass="contentform"></h:inputText>
							<h:inputText id="managerName" size="20" maxlength="50" value="#{ipLevel3Bean.ipInfo.projectManager}" rendered="#{!ipLevel3Bean.projManagerDisable}" styleClass="contentform"></h:inputText>
							<rich:suggestionbox id="managerSuggest" for="managerName" usingSuggestObjects="true" suggestionAction="#{ipLevel3Action.userSuggestion}" requestDelay="0" 
								 binding="#{ipLevel3Bean.suggestProjManager}" 
								var="suggest" status="#{rich:component('wait')}.hide();" fetchValue="#{suggest.label}" frequency="0" width="178" >
								<h:column>
									<h:outputText value="#{suggest.label}"/>
								</h:column>
								<a4j:support event="onobjectchange" action="#{ipLevel3Action.suggestManager}" status="#{rich:component('wait')}.hide();" />
							</rich:suggestionbox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="IP Type :&nbsp;" escape="false"/></td>
						<td>
						<h:panelGrid columns="2" cellspacing="0" cellpadding="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="ipType" defaultLabel=""  rendered="#{ipLevel3Bean.ipTypeEdit}"
								enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
							 	width="152"  listWidth="147" listHeight="150"
							 	value="#{ipLevel3Bean.ipTypeComboItem}" >
							 	<f:attribute name="selectItems" value="#{ipLevel3Bean.ipTypeList}"/>
							 	<f:selectItems value="#{ipLevel3Bean.ipTypeList}" />
							 	<a4j:support reRender="errorMsg,ipType" event="onchange" action="#{ipLevel3Action.checkIpTypeCombo}" />
							</rich:comboBox>
							<h:outputText rendered="#{!ipLevel3Bean.ipTypeEdit}" value="#{ipLevel3Bean.ipInfo.ipTypeName}"  styleClass="contentform"/>
						</h:panelGrid>
					</td>
			  	</tr>
			  	
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Site/Location" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="location" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel3Bean.locationComboItem}" width="152" listWidth="147" listHeight="150">
								<f:attribute name="selectItems" value="#{ipLevel3Bean.locationList}"/>
								<f:selectItems value="#{ipLevel3Bean.locationList}"/>
								<a4j:support reRender="errorMsg,location" event="onchange" action="#{ipLevel3Action.checkLocationCombo}" />
							</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="VLAN ID :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText rendered="#{ipLevel3Bean.vlanIdEdit}" value="#{ipLevel3Bean.ipInfo.vlanId}" maxlength="30" size="20" styleClass="contentform"
							onkeypress="return keyRange(this,event,1,4096);"
							onblur="this.value = isNumber(this);" />
						<h:outputText rendered="#{!ipLevel3Bean.vlanIdEdit}" value="#{ipLevel3Bean.ipInfo.vlanId}" styleClass="contentform" ></h:outputText>
					</td>
				 </tr>
				 <tr class="inputRow">
				 	
					<td></td><td></td>
					<td class="labelStyle"><h:outputText value="VIP" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:selectOneRadio value="#{ipLevel3Bean.ipInfo.vip}" layout="line" styleClass="contentform" >
							<f:selectItem itemLabel="Yes" itemValue="Y" /> 
							<f:selectItem itemLabel="No" itemValue="N" /> 
						</h:selectOneRadio>
					</td>
			  	</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Watching You<br/>Node Name :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipInfo.wyNodeName}" maxlength="100" size="20" styleClass="contentform"/>
					</td>
             		<td class="labelStyle" ><strong><h:outputText value="Install Type :&nbsp;" escape="false"></h:outputText></strong></td>
					<td>
						<h:panelGrid rendered="#{!ipLevel3Bean.installTypeEdit}" columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>							
					     	<h:outputText  value="#{ipLevel3Bean.ipInfo.installTypeName}"  styleClass="contentform"/>
						</h:panelGrid>
						<h:selectOneRadio rendered="#{ipLevel3Bean.installTypeEdit}" value="#{ipLevel3Bean.ipInfo.installTypeId}"  styleClass="contentform" >
							<f:selectItem itemLabel="Permanent" itemValue="2" />
							<f:selectItem itemLabel="Temporary" itemValue="1" />														
					  	</h:selectOneRadio>
					</td>	 
                </tr>                 
                <tr class="inputRow">
					<td class="labelStyle" valign="top" ><h:outputText value="Remarks :&nbsp;" escape="false"  /></td>
					<td colspan="3">
						<rich:spacer width="10"></rich:spacer> 
						<h:inputTextarea value="#{ipLevel3Bean.ipInfo.t3Remark}" rows="3" cols="80" style="width:450px;" styleClass="contentform" onkeypress="return chkLength(this,1000);" readonly="#{!ipLevel3Bean.t3RemarksEdit}"/>
					</td>
			   	</tr>
<!-- 			   	//ADD NAT IP -->
			   	<tr class="inputRow">
					<td class="labelStyle" valign="top" ><h:outputText value="NAT IP :&nbsp;" escape="false"  /></td>
					<td colspan="3">
						<rich:spacer width="10"></rich:spacer> 
						<h:inputTextarea value="#{ipLevel3Bean.ipInfo.natIp}" rows="3" cols="80" style="width:450px;" styleClass="contentform" onkeypress="return chkLength(this,500);" readonly="#{!ipLevel3Bean.natIpPermission}"/>
					</td>
			   	</tr>
			   	
				<tr><td colspan="4"><rich:spacer height="5" /></td></tr>
				<tr>
					<td colspan="4">
						<div align="center" > 
							<a4j:commandButton value="Save" action="#{ipLevel3Action.save}" reRender="#{errorMessages?'errorMsg':'errorMsg,IPDataTable1,groupSearchResult'}"  styleClass="rich-button"  >
								<rich:componentControl for="popupUpdateIP" operation="#{errorMessages?'show':'hide'}" event="oncomplete" />
							</a4j:commandButton>
							<rich:spacer width="10"></rich:spacer>
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" ajaxSingle="true" status="#{rich:component('wait')}.hide();">
								<rich:componentControl for="popupUpdateIP" operation="hide" event="onclick"/>
							</a4j:commandButton>
						</div>		
					</td>
				</tr>
			</table>	
		</rich:panel>
		</a4j:form>
	</div>
</rich:modalPanel>
</f:subview>