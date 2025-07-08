<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<style type="text/css">
	.rich-combobox-font-disabled {color:#000000;}
	.rich-sb-int {background-color: #FFFFFF;}
	.richfaces_suggestionEntry  {background-color: #FFFFFF;}
	.rich-sb-int-sel {background-color: #FFFFFF;}
	.richfaces_suggestionSelectValue {color: #FFFFFF;}
</style>
<f:subview id="popupModalUpdate">


<rich:modalPanel id="popupUpdateIPS" height="400" minWidth="650" styleClass="contentform" autosized="true">
   <f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Update IP Information</span></strong>
		</h:panelGroup>	
	</f:facet>
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="popupUpdateIPS" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <div id="container" style="overflow: auto; width: 100%;height: 350px;">
   		<a4j:form id="updateIPS">
   		
		<rich:panel id="updatePanel">
			<table width="100%" border="0" class="thtext_detail">
				<tr>
					<td width="29%"><rich:spacer height="0"/></td>
					<td width="27%"><rich:spacer height="0"/></td>
					<td width="19%"><rich:spacer height="0"/></td>
					<td width="25%"><rich:spacer height="0"/></td>
				</tr>
				<tr class="inputRow">
<td class="labelStyle"><h:outputText value="Company" escape="false" ></h:outputText><h:graphicImage rendered="#{ipLevel3Bean.companyEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="company2" defaultLabel="" 
								enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
							 	width="152" listWidth="147" listHeight="150"
							 	value="#{ipLevel3Bean.companyComboItem}" >
							 	<f:attribute name="selectItems" value="#{ipLevel3Bean.companyList}"/>
							 	<f:selectItems value="#{ipLevel3Bean.companyList}" />
							 	<a4j:support reRender="errorMsg,company" event="onchange" action="#{ipLevel3Action.checkCompanyCombo}" />
						 	</rich:comboBox>
						</h:panelGrid>
					</td>				
			
				</tr>
				<tr class="inputRow">

					<td class="labelStyle"><h:outputText value="System Name :&nbsp;" escape="false"  /></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.systemName}" maxlength="1000" size="20" styleClass="contentform"/>
					</td>
				</tr>
				 <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="DNS Name :&nbsp;" escape="false"  /></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.dnsName}" maxlength="30" size="20" styleClass="contentform"/>
					</td>		
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="System Owner<br/>Name" escape="false" /><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:inputHidden id="sysOwnerNameHid" value="#{ipLevel3Bean.sysOwnerComboItem}" >
							<f:attribute name="selectItems" value="#{ipLevel3Bean.sysOwnerList}"/>
						</h:inputHidden>
						<h:panelGrid id="ownerGrid" columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:inputText id="sysOwnerName2" size="20" maxlength="50" value="#{ipLevel3Bean.systemOwnerName}" styleClass="contentform"></h:inputText>
							<rich:suggestionbox id="sysOwnerSuggest2" binding="#{ipLevel3Bean.suggestSystemOwnerUpdate}" for="sysOwnerName2" suggestionAction="#{ipLevel3Action.userSuggestion}" requestDelay="0" 
								var="suggest2" status="#{rich:component('wait')}.hide();" usingSuggestObjects="true" fetchValue="#{suggest2.label}" frequency="0" width="178" limitToList="20">
								<h:column>
									<h:outputText value="#{suggest2.label}"/>
								</h:column>
								<a4j:support event="onobjectchange" action="#{ipLevel3Action.suggestSysOwnerUpdate}" status="#{rich:component('wait')}.hide();" reRender="ownerTeamId2"/>
							</rich:suggestionbox>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="System Owner<br/>Team" escape="false" /><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:inputText id="ownerTeamId2" value="#{ipLevel3Bean.sysOwnerTeamComboItem}" readonly="true"/>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Host Name" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.hostName}" maxlength="1000" size="20" styleClass="contentform"/>
					</td>
			  	</tr> 
				 <tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Network IP" escape="false" /><h:graphicImage rendered="#{ipLevel3Bean.networkIpEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.networkIp}" maxlength="15" size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Network IP');"/>
					</td>
			  	</tr> 			  	
				<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Gateway :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.gateway}" maxlength="15" size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Gateway');"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Mask" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText value="#{ipLevel3Bean.ipSubmask}" maxlength="15" size="20" styleClass="contentform" onkeypress="return checkIPKey(this,event);" onblur="this.value = isNumberIP(this,'Mask');"/>
					</td>
			  	</tr>			  	
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Expire Date" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<rich:calendar value="#{ipLevel3Bean.expiredDate}" 
				                        locale="en/US" popup="true" direction="auto"
				                        datePattern="dd/MM/yyyy" showApplyButton="false" 
				                        cellWidth="24px" cellHeight="22px" style="width:200px"
				                        inputStyle="background-color:white;" inputSize="20" />
					</td>
			  	</tr>
			  	
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Site/Location" escape="false" ></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
					<td>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox id="location2" defaultLabel="" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
								value="#{ipLevel3Bean.locationComboItem}" width="152" listWidth="147" listHeight="150">
								<f:attribute name="selectItems" value="#{ipLevel3Bean.locationList}"/>
								<f:selectItems value="#{ipLevel3Bean.locationList}"/>
								<a4j:support reRender="errorMsg,location2" event="onchange" action="#{ipLevel3Action.checkLocationCombo}" />
							</rich:comboBox>
						</h:panelGrid>
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