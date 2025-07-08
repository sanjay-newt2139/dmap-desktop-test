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

<f:subview id="popupModalSubview"> 


<rich:modalPanel id="popupUpdateIP" autosized="true" 
	styleClass="contentform" height="300" minWidth="650" label="Find Region">
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
					
	<a4j:form>
	<a4j:jsFunction name="alertErrorMsgAjx" 
			actionListener="#{ipLevel2Action.alertErrorMsg}"
		 	reRender="errorMsgx">
		 	<a4j:actionparam name="errorMessage"/>
	</a4j:jsFunction>
		<rich:panel>	
			<table width="97%" border="0" class="thtext_detail">
				<tr>
					<td width="20%"><rich:spacer height="0"/></td>
					<td width="30%"><rich:spacer height="0"/></td>
					<td width="20%"><rich:spacer height="0"/></td>
					<td width="30%"><rich:spacer height="0"/></td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Address :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{ipLevel2Bean.ipLevel2.level2Start} - #{ipLevel2Bean.ipLevel2.level2End}" styleClass="contentform"/>
					</td>
					<td class="labelStyle"><h:outputText value="IP Status" escape="false" ></h:outputText><h:graphicImage rendered="#{ipLevel2Bean.ipStatusEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox rendered="#{ipLevel2Bean.ipStatusEdit}" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel2Bean.ipStatusComboItem}" width="159" listWidth="154" listHeight="150">
								<f:attribute name="selectItems" value="#{ipLevel2Bean.ipStatusList}"/>
								<f:selectItems value="#{ipLevel2Bean.ipStatusList}"/>
							</rich:comboBox>
							<h:outputText rendered="#{!ipLevel2Bean.ipStatusEdit}" value="#{ipLevel2Bean.ipStatusName}" styleClass="contentform"></h:outputText>
						</h:panelGrid>
					</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Type :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="ipType"  defaultLabel="" rendered="#{ipLevel2Bean.ipTypeEdit}"
								enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
							 	width="159" listWidth="154" listHeight="150"
							 	value="#{ipLevel2Bean.ipTypeComboItem}" >
							 	<f:attribute name="selectItems" value="#{ipLevel2Bean.ipTypeList}"/>
							 	<f:selectItems value="#{ipLevel2Bean.ipTypeList}" />
							</rich:comboBox>
							<h:outputText rendered="#{!ipLevel2Bean.ipTypeEdit}" value="#{ipLevel2Bean.ipLevel2.ipTypeName}" styleClass="contentform"></h:outputText>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network Type :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="networkType" defaultLabel="" rendered="#{ipLevel2Bean.networkTypeEdit}"
								enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
							 	width="159" listWidth="154" listHeight="150"
							 	value="#{ipLevel2Bean.networkTypeComboItem}" >
							 	<f:attribute name="selectItems" value="#{ipLevel2Bean.nwTypeList}"/>
							 	<f:selectItems value="#{ipLevel2Bean.nwTypeList}" />
							</rich:comboBox>
							<h:outputText  rendered="#{!ipLevel2Bean.networkTypeEdit}" value="#{ipLevel2Bean.ipLevel2.networkTypeName}" styleClass="contentform"></h:outputText>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">
				 	
					<td class="labelStyle"><h:outputText value="VLAN ID :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel2Bean.ipLevel2.vlanId}" maxlength="30" size="21" styleClass="contentform"
							onkeypress="return keyRange(this,event,1,4096);"
						 	onblur="this.value = isNumber(this);"/>
					</td>
					<td class="labelStyle"><h:outputText value="Network Zone :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox defaultLabel="" enableManualInput="true" 
								itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel2Bean.networkZoneComboItem}" width="159" listWidth="154" listHeight="150" >
								<f:attribute name="selectItems" value="#{ipLevel2Bean.zoneList}"/>
								<f:selectItems value="#{ipLevel2Bean.zoneList}"/>
							</rich:comboBox>
						</h:panelGrid>
					</td>
			  	</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="DNS Name :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel2Bean.ipLevel2.dnsName}" maxlength="30" size="21" styleClass="contentform"/>
					</td>
             		<td class="labelStyle" ><strong><h:outputText value="Network IP :&nbsp;" escape="false"></h:outputText></strong></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel2Bean.ipLevel2.networkIp}" maxlength="15" size="21" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Network IP');"></h:inputText>
					</td>	 
                </tr> 
                <tr class="inputRow">
                	<td class="labelStyle"><h:outputText value="System Name :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel2Bean.ipLevel2.systemName}" maxlength="1000" size="21" styleClass="contentform"/>
					</td>					
					<td class="labelStyle"><h:outputText value="Gateway :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel2Bean.ipLevel2.gateway}" maxlength="15" size="21" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Gateway');"/>
					</td>
				 </tr>
				 <tr class="inputRow">					
					<td class="labelStyle"><h:outputText value="Site/Location :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel2Bean.locationComboItem}" width="159" listWidth="154" listHeight="150" >
								<f:attribute name="selectItems" value="#{ipLevel2Bean.locationList}"/>
								<f:selectItems value="#{ipLevel2Bean.locationList}"/>
							</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Mask :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel2Bean.ipLevel2.ipSubmask}" maxlength="30" size="21" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP2(this,'Mask');"/>
					</td>
			  	</tr>
			  	
			  	<tr class="inputRow">
					<td ><h:outputText value="" escape="false"></h:outputText></td>
					<td>
						<rich:spacer width="10"></rich:spacer>               
					</td>
                 	<td class="labelStyle" ><h:outputText value="Install Type :&nbsp;" escape="false"></h:outputText></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel2Bean.installTypeComboItem}" width="159" listWidth="154" listHeight="150">
								<f:attribute name="selectItems" value="#{ipLevel2Bean.installTypeList}"/>
								<f:selectItems value="#{ipLevel2Bean.installTypeList}"/>
							</rich:comboBox>
						</h:panelGrid>
					</td>	
					
			  	</tr>
			  	
                <tr class="inputRow">
                 	<td class="labelStyle" ><h:outputText value="Effective Date :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{ipLevel2Bean.ipLevel2.effectiveDate}" styleClass="contentform">
							<f:convertDateTime pattern="dd/MM/yyyy"/> 
						</h:outputText>                                        
					</td>	
             		<td class="labelStyle" ><h:outputText value="Expire Date" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value="&nbsp;:&nbsp;" escape="false"/></td>
             		<td>
						<rich:spacer width="10"></rich:spacer>
						<rich:calendar value="#{ipLevel2Bean.ipLevel2.expiredDate}"
				                        locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" 
				                        cellWidth="24px" cellHeight="22px" style="width:200px" styleClass="contentform"
				                        inputStyle="background-color:white;" inputSize="22" direction="auto"/>
				    </td>	 
                </tr> 
                <tr class="inputRow">
					<td class="labelStyle" valign="top" ><h:outputText value="Remarks :&nbsp;" escape="false" styleClass="label"/></td>
					<td colspan="3">
						<rich:spacer width="10"></rich:spacer> 
						<h:inputTextarea value="#{ipLevel2Bean.ipLevel2.t2Remark}" style="width:450px;" rows="3" cols="82" styleClass="contentform" onkeypress="return chkLength(this,1000);" readonly="#{ipLevel2Bean.t2RemarksEdit}"/>
					</td>
			   	</tr>
				<tr><td colspan="4"><rich:spacer height="5" /></td></tr>
				<tr>
					<td colspan="4">
						<div align="center" > 
							<a4j:commandButton value="Save" action="#{ipLevel2Action.save}" reRender="#{errorMessages?'errorMsg':'errorMsg,ipDetailTable,groupSearchResult'}" styleClass="rich-button"   >
									<rich:componentControl for="popupUpdateIP" operation="#{errorMessages?'show':'hide'}" event="oncomplete" />
							</a4j:commandButton>
							<rich:spacer width="10"></rich:spacer>
							<a4j:commandButton value="Cancel" styleClass="rich-button"  immediate="true" ajaxSingle="true" status="#{rich:component('wait')}.hide();">
								<rich:componentControl for="popupUpdateIP" operation="hide" event="onclick" />
							</a4j:commandButton>
						</div>		
					</td>
				</tr>
			</table>	
		</rich:panel>
	</a4j:form>
	
	
	<h:panelGroup id="errorMsgx">
	<rich:modalPanel id="errorDialog" autosized="true" showWhenRendered="true" rendered="#{globalMessages}" resizeable="false" width="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="IPFM Message"  ></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls" >
			<h:panelGroup>
				<h:graphicImage value="../images/ico_close.png" id="hideErrorDialog" style="cursor:pointer;" >
					<rich:componentControl for="errorDialog" attachTo="hideErrorDialog" operation="hide" event="onclick" />
				</h:graphicImage>
			</h:panelGroup>
		</f:facet>
		
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" width="100%" styleClass="contentlabelform" >
						<h:messages styleClass="contentlabelform" errorStyle="color: red" 
									warnStyle="color: green" infoStyle="color: blue" globalOnly="true"  />
					</h:panelGrid>
				</td>
			</tr>
			<tr> 
				<td>
					<h:panelGrid columns="1" width="100%" style="text-align:center;" styleClass="contentlabelform"> 
					
						<a4j:form>	
							<a4j:commandButton value="OK" styleClass="rich-button"  ajaxSingle="true" status="#{rich:component('wait')}.hide();">
	    						<rich:componentControl for="errorDialog" operation="hide" event="oncomplete" />
							</a4j:commandButton>	
						</a4j:form>			
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</rich:modalPanel>
</h:panelGroup> 
	
</rich:modalPanel>
</f:subview>
