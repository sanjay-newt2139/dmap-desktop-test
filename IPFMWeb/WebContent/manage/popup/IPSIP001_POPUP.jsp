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
<h:panelGroup style="width:100%;">
<rich:modalPanel id="popupUpdateIP" autosized="true" styleClass="contentform" height="300" minWidth="650">
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
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>
			<h:panelGroup style="width:100%;">	
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
							<h:outputText value="#{ipLevel1Bean.ipLevel1.level1Start} - #{ipLevel1Bean.ipLevel1.level1End}" styleClass="contentform"/>
						</td>
						<td class="labelStyle"><h:outputText value="IP Status" escape="false" ></h:outputText><h:graphicImage rendered="#{ipLevel1Bean.ipStatusEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
								<rich:spacer width="10"></rich:spacer>
								<rich:comboBox rendered="#{ipLevel1Bean.ipStatusEdit}" defaultLabel="Please select value" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
									value="#{ipLevel1Bean.ipStatusComboItem}" width="150" listWidth="145" listHeight="150">
									<f:attribute name="selectItems" value="#{ipLevel1Bean.ipStatusList}"/>
									<f:selectItems value="#{ipLevel1Bean.ipStatusList}"/>
								</rich:comboBox>
								<h:outputText rendered="#{!ipLevel1Bean.ipStatusEdit}" value="#{ipLevel1Bean.ipStatusName}"></h:outputText>
							</h:panelGrid>
						</td>
					</tr>
					<tr class="inputRow">
						<td class="labelStyle"><h:outputText value="Company" escape="false" ></h:outputText><h:graphicImage rendered="false" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.companyName}" styleClass="contentform"/>
						</td>
						<td class="labelStyle" ><h:outputText value="Network IP" escape="false"></h:outputText><h:graphicImage rendered="false" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.networkIp}" styleClass="contentform"/>
						</td>	
				  	</tr>
				  	<tr class="inputRow">					
						<td class="labelStyle"><h:outputText value="IP Type" escape="false"></h:outputText><h:graphicImage rendered="false" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.ipTypeName}" styleClass="contentform"/> 
						</td>
						<td class="labelStyle"><h:outputText value="Gateway :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.gateway}" styleClass="contentform"/>
						</td>
					</tr>
					<tr class="inputRow">
	                 	<td class="labelStyle" ><h:outputText value="Planning Team" escape="false"></h:outputText><h:graphicImage rendered="false" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.t2Team.teamName}" styleClass="contentform"/> 
						</td>	
	             		 
						<td class="labelStyle"><h:outputText value="DNS Name :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.dnsName}" styleClass="contentform"/> 
						</td>
	                </tr> 
					<tr class="inputRow">					
						<td class="labelStyle"><h:outputText value="VIP" escape="false"></h:outputText><h:graphicImage rendered="false" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.vip=='Y'?'Yes':'No'}" styleClass="contentform"></h:outputText>
						</td>
						<td class="labelStyle"><h:outputText value="VLAN ID :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{ipLevel1Bean.ipLevel1.vlanId}" styleClass="contentform"/> 
						</td>
				  	</tr>
	                <tr class="inputRow">
	                 	<td class="labelStyle" ><h:outputText value="Effective Date" escape="false"></h:outputText><h:graphicImage rendered="false" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>							
							<h:outputText value="#{ipLevel1Bean.ipLevel1.effectiveDate}" styleClass="contentform">
								<f:convertDateTime pattern="dd/MM/yyyy"/>
							</h:outputText>
						</td>	
	             		<td class="labelStyle" ><h:outputText value="Expire Date" escape="false"></h:outputText><h:graphicImage rendered="#{ipLevel1Bean.expiredDateEdit}" value="../images/icon_required.gif" style="border:0" /><h:outputText value=" :&nbsp;" escape="false"/></td>
						<td>
							<rich:spacer width="10"></rich:spacer>
							<h:outputText rendered="#{!ipLevel1Bean.expiredDateEdit}" value="#{ipLevel1Bean.ipLevel1.expiredDate}" styleClass="contentform">
								<f:convertDateTime pattern="dd/MM/yyyy"/>
							</h:outputText>
							<rich:calendar id="expireDate" rendered="#{ipLevel1Bean.expiredDateEdit}" value="#{ipLevel1Bean.ipLevel1.expiredDate}"
			                        locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:20px"
			                        inputStyle="background-color:white" inputSize="20" direction="auto"/>
						</td>	 
	                </tr> 
	                <tr class="inputRow">
						<td class="labelStyle" valign="top" ><h:outputText value="Remarks :&nbsp;" escape="false" /></td>
						<td colspan="3">
							<rich:spacer width="10"></rich:spacer> 
							<h:inputTextarea value="#{ipLevel1Bean.ipLevel1.t1Remarks}" rows="3" cols="80" style="width:450px;" styleClass="contentform" onkeypress="return chkLength(this,1000);"/>
						</td>
				   	</tr>
				   	
					<tr><td colspan="4"><rich:spacer height="10" /></td></tr>
					<tr>
						<td colspan="4">
							<div align="center" > 
								<a4j:commandButton value="Save"  action="#{ipLevel1Action.save}" reRender="#{errorMessages?'errorMsg':'errorMsg,groupSearchResult'}" styleClass="rich-button"  >
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
			</h:panelGroup>	
		</rich:panel>
	</a4j:form>
</rich:modalPanel>
</h:panelGroup>
</f:subview>
