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
<rich:modalPanel id="IPSSR002_Popup" autosized="true" binding="#{groupIPBean.popupModal}"
	styleClass="contentform"  height="400" minWidth="650"  label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">IP Information</span></strong>
		</h:panelGroup>	
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPSSR002_Popup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	<body style="overflow: hidden;">
     <div id="container" style="width: 100%">
		<rich:panel>	

			<table width="97%" border="0" class="thtext_detail">
				<tr>
					<td width="28%"><rich:spacer height="0"/></td>
					<td width="28%"><rich:spacer height="0"/></td>
					<td width="19%"><rich:spacer height="0"/></td>
					<td width="25%"><rich:spacer height="0"/></td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Address :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.ipAddress}" styleClass="contentform"/>						
					</td>
					<td class="labelStyle"><h:outputText value="Host Name :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText rendered="false" value="#{searchIPBean.ipInfoPopup.hostName}" size="20" styleClass="contentform"/>
						<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.hostName}" styleClass="contentform"/>
					</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="IP Status :&nbsp;" escape="false"/></td>
					<td  align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<rich:comboBox rendered="false" defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
								value="Used" width="152">
								<f:selectItem itemLabel="Used" itemValue="Used"/>
							</rich:comboBox>
							<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.ipStatusName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="System Name :&nbsp;" escape="false"  /></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:inputText rendered="false" value="#{searchIPBean.ipInfoPopup.systemName}" size="20" styleClass="contentform"/>
						<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.systemName}" styleClass="contentform"/>
					</td>
				</tr>
				 <tr class="inputRow">
             		<td class="labelStyle"><h:outputText value="Company :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText  value="AIS" styleClass="contentform"></h:outputText>
						</h:panelGrid>
					</td>		
					<td class="labelStyle"><h:outputText value="DNS Name :&nbsp;" escape="false"  /></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.dnsName}" styleClass="contentform"/>
					</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="System Owner Name :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.systemOwnerName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network Type :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.networkTypeName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="System Owner  :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.systemOwnerTeamName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network Zone :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.networkZoneName}" styleClass="contentform"/>
						</h:panelGrid>
						</h:panelGrid>
					</td>
				 </tr>
				 <tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Planning Team :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText   value="#{searchIPBean.ipInfoPopup.t2TeamName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Network IP :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText  value="#{searchIPBean.ipInfoPopup.networkIp}"  styleClass="contentform"/>
					</td>
			  	</tr>
				<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="UR Refer :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.urRefer}" styleClass="contentform"/>
					</td>
					<td class="labelStyle"><h:outputText value="Gateway :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.gateway}"  styleClass="contentform"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Effective Date :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.effectiveDate}"  styleClass="contentform">
						   <f:convertDateTime pattern="dd/MM/yyyy"/>
						</h:outputText>
					</td>
					<td class="labelStyle"><h:outputText value="Mask :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.ipSubmask}"  styleClass="contentform"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Expire Date :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.expiredDate}" styleClass="contentform">
						   <f:convertDateTime pattern="dd/MM/yyyy"/>
						</h:outputText>
					</td>
					<td class="labelStyle"><h:outputText value="Mac Address :&nbsp;" escape="false"/></td>
					<td>
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.macAddress}"  styleClass="contentform"/>
					</td>
			  	</tr>
			  	<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Project ID :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{searchIPBean.ipInfoPopup.projectId}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="Project Names :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{searchIPBean.ipInfoPopup.projectName}" styleClass="contentform"/>
						</h:panelGrid>
					</td>
				 </tr>
			  	<tr class="inputRow">				 	
					<td class="labelStyle"><h:outputText value="Project Manager :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.projectManager}" styleClass="contentform"/>
					</td>
					<td class="labelStyle"><h:outputText value="IP Type :&nbsp;" escape="false"/></td>
					<td align="left" >
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.ipTypeName}"  styleClass="contentform"/>
					</td>
			  	</tr>
			  	
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Site/Location :&nbsp;" escape="false"/></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.locationName}"  styleClass="contentform"/>
						</h:panelGrid>
					</td>
					<td class="labelStyle"><h:outputText value="VLAN ID :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.vlanId}" styleClass="contentform"></h:outputText>
					</td>
				 </tr>
				 <tr class="inputRow">
				 	
					<td></td>
					<td></td>
					<td class="labelStyle"><h:outputText value="VIP :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:selectOneRadio rendered="false" layout="line" value="NO" styleClass="contentform" >
							<f:selectItem itemLabel="YES" itemValue="Yes" /> 
							<f:selectItem itemLabel="NO" itemValue="No" /> 
						</h:selectOneRadio>
						<h:outputText rendered="true" value="#{searchIPBean.ipInfoPopup.vip=='Y'?'Yes':'No'}" styleClass="contentform"/>
					</td>
			  	</tr>
				<tr class="inputRow">
					<td class="labelStyle"><h:outputText value="Watching You<BR>Node Name :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.wyNodeName}" styleClass="contentform"/>
					</td>
             		<td class="labelStyle" ><strong><h:outputText value="Install Type :&nbsp;" escape="false"></h:outputText></strong></td>
					<td align="left">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10"></rich:spacer>
							<h:outputText value="#{searchIPBean.ipInfoPopup.installTypeName}"  styleClass="contentform"/>
						</h:panelGrid>
					</td>	 
                </tr>  
                <tr class="inputRow">
					<td class="labelStyle"><h:outputText value="NAT IP :&nbsp;" escape="false"/></td>
					<td align="left">
						<rich:spacer width="10"></rich:spacer>
						<h:outputText value="#{searchIPBean.ipInfoPopup.natIp}" styleClass="contentform"/>
					</td>           		 
                </tr>               
                <tr class="inputRow">
					<td class="labelStyle" valign="top" ><h:outputText value="Remarks :&nbsp;" escape="false"  /></td>
					<td colspan="3">
						<rich:spacer width="10"></rich:spacer> 
						<h:inputTextarea  value="#{searchIPBean.ipInfoPopup.t3Remark}" rows="3" cols="78" readonly="true"/>
					</td>
			   	</tr>
				<tr><td colspan="4"><rich:spacer height="5" /></td></tr>
				<tr>
					<td colspan="4">
						<div align="center" > 							
							<a4j:commandButton value="Close" styleClass="rich-button"  immediate="true" >
								<rich:componentControl for="IPSSR002_Popup" operation="hide" event="onclick" />
							</a4j:commandButton>
						</div>		
					</td>
				</tr>
			</table>	
		</rich:panel>
	</div>
	</body>
</rich:modalPanel>
</f:subview>
