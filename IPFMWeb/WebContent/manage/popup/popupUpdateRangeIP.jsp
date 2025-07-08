<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>
<style>
	.label {font-weight: bold;}
	.displayLabel {}
</style>

<f:subview id="popupModalSubview"> 
<rich:modalPanel id="popupUpdateRangeIP" autosized="true"
	styleClass="contentform" height="300" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Update Range IP Information</span></strong>
		</h:panelGroup>	
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="popupAddUser" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="97%" border="0" class="thtext_detail">
				<tr>
					<td width="20%"><rich:spacer height="0"/></td>
					<td width="30%"><rich:spacer height="0"/></td>
					<td width="20%"><rich:spacer height="0"/></td>
					<td width="30%"><rich:spacer height="0"/></td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Address :&nbsp;" escape="false" /></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="172.2.7.0 - 172.2.7.63" />
					</td>
					<td class="labelStyle"><h:outputText value="IP Status :&nbsp;" escape="false" /></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
							value="1" width="150">
							<f:selectItem itemLabel="Reserve for Planning" itemValue="1"/>
						</rich:comboBox>
						</h:panelGrid>
					</td>
				</tr>
				<tr class="inputRow">
                 	<td class="labelStyle" ><strong><h:outputText value="Effective Date :&nbsp;" escape="false"></h:outputText></strong></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="10/02/2010" styleClass="displayLabel"/>                                        
					</td>	
             		<td class="labelStyle" ><strong><h:outputText value="Expire Date :&nbsp;" escape="false"></h:outputText></strong></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<rich:calendar value="10/09/2010"
				                        locale="en/US"
				                        popup="true" 
				                        datePattern="dd/MM/yyyy"
				                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
				                        inputStyle="background-color:white;"
				                        inputSize="20"
				                        direction="auto"/>
					</td>	 
                </tr> 
                <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Type :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
							value="LAN" width="150">
							<f:selectItem itemLabel="LAN" itemValue="LAN"/>
						</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network IP :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="10.13.33.0" size="20"/>
					</td>
				 </tr>
				 <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Network Type :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
							value="LAN/WAN" width="150">
							<f:selectItem itemLabel="LAN/WAN" itemValue="LAN/WAN"/>
						</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Gateway :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="10.13.33.1" size="20"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Install Type :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
							value="Permanent" width="150">
							<f:selectItem itemLabel="Permanent" itemValue="Permanent"/>
						</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="MASK :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="255.255.0.0" size="20"/>
					</td>
			  	</tr>
                <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="VIP :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
							value="No" width="150">
							<f:selectItem itemLabel="No" itemValue="No"/>
						</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="VLAN ID :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="" size="20"/>
					</td>
			   	</tr>
                <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Site/Location :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
							value="อาคารอีเอสอี ชั้น 11" width="150">
							<f:selectItem itemLabel="อาคารอีเอสอี ชั้น 11" itemValue="อาคารอีเอสอี ชั้น 11"/>
						</rich:comboBox>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="DNS Name :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="dmzfe10320" size="20"/>
					</td>
			   	</tr>
                <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Network Zone :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="IPTN" size="20"/>
					</td>
					<td class="labelStyle"><h:outputText value="Company :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="" size="20"/>
					</td>
			   	</tr>
                <tr class="inputRow">
					<td class="labelStyle" valign="top"><h:outputText value="Floor :&nbsp;" escape="false" styleClass="label"/></td>
					<td valign="top">
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="11" size="20"/>
					</td>
					<td class="labelStyle" valign="top"><h:outputText value="Comment :&nbsp;" escape="false" styleClass="label"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<rich:spacer width="10"></rich:spacer>
						<h:inputTextarea value="" rows="5" cols="30" >
						</h:inputTextarea>
						</h:panelGrid>
					</td>
			   	</tr>
			   	
			   	
				<tr><td colspan="4"><rich:spacer height="10" /></td></tr>
				<tr>
					<td colspan="4">
						<div align="center" > 
							<a4j:commandButton value="Save" styleClass="rich-button"  immediate="true" >
								<rich:componentControl for="popupUpdateRangeIP" operation="hide" event="onclick" />
							</a4j:commandButton>
							<rich:spacer width="10"></rich:spacer>
							<a4j:commandButton value="Cancel" styleClass="rich-button"  immediate="true" >
								<rich:componentControl for="popupUpdateRangeIP" operation="hide" event="onclick" />
							</a4j:commandButton>
						</div>		
					</td>
				</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
