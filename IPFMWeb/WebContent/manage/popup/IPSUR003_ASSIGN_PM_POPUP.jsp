<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<a4j:jsFunction name="pmAssign" reRender="mdlPMAssign"
	action="#{reqNWConfigAction.showAssignWin}"
 	oncomplete="Richfaces.showModalPanel('mdlPMAssign');">
 	<a4j:actionparam name="subUrType"/>
</a4j:jsFunction>

<a4j:jsFunction name="pmDelegate" reRender="delegatePMPopup"
	action="#{reqNWConfigAction.showDelegatePM}"
 	oncomplete="Richfaces.showModalPanel('delegatePMPopup');">
</a4j:jsFunction>

<f:subview id="popupPMAssign"> 
<rich:modalPanel id="mdlPMAssign" autosized="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="PM Assign"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="mdlPMAssign" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>
			<table border="0" width="100%">
				<tr>
					<td style="width:80px" align="right">&nbsp;</td>
					<td align="left">
						<h:selectOneRadio id="assignTeam" layout="pageDirection" 
							value="#{networkConfigBean.pmAssign.assignForTeam}" 
							styleClass="contentlabelform" >
							<a4j:support actionListener="#{reqNWConfigAction.selectAssignType}" 
								event="onclick" reRender="listPerson, assignPerson, assignTeam, teamPanel1,teamPanel2,personPanel1,personPanel2">
								<a4j:actionparam name="changeTo" value="T"/>
							</a4j:support>
							<f:selectItem itemValue="T" itemLabel="By Team" />
						</h:selectOneRadio>
						<h:panelGrid columns="8" rendered="#{(networkConfigBean.selectSubUR eq 'FW')}" id="teamPanel1">
							<h:selectBooleanCheckbox  value="#{networkConfigBean.pmAssign.isTeamCdno}" disabled="#{networkConfigBean.pmAssign.teamEnable}" >
							</h:selectBooleanCheckbox>Firewall-1
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isTeamSta1}" disabled="#{networkConfigBean.pmAssign.teamEnable}">
								</h:selectBooleanCheckbox>Firewall-2
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isTeamSta2}" disabled="#{networkConfigBean.pmAssign.teamEnable}">
							</h:selectBooleanCheckbox>Firewall-3
							<h:selectBooleanCheckbox rendered="#{(not networkConfigBean.isTnp) and (networkConfigBean.selectSubUR eq 'FW')}"  value="#{networkConfigBean.pmAssign.isTeamTdno}" disabled="#{networkConfigBean.pmAssign.teamEnable}">
							</h:selectBooleanCheckbox><h:outputLabel value="TDNO Config" rendered="#{(not networkConfigBean.isTnp) and (networkConfigBean.selectSubUR eq 'FW')}"/>
						</h:panelGrid>
						
						<h:panelGrid columns="8" rendered="#{(not networkConfigBean.isTnp) and not(networkConfigBean.selectSubUR eq 'FW')}" id="teamPanel2">
							<h:selectBooleanCheckbox  value="#{networkConfigBean.pmAssign.isTeamCdn}" disabled="#{networkConfigBean.pmAssign.teamEnable}" >
							</h:selectBooleanCheckbox><h:outputLabel value="CND Config" rendered="#{(not networkConfigBean.isTnp) and not(networkConfigBean.selectSubUR eq 'FW')}"/>
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isTeamTdno}"disabled="#{networkConfigBean.pmAssign.teamEnable}" >
							</h:selectBooleanCheckbox><h:outputLabel value="TDNO Config" rendered="#{(not networkConfigBean.isTnp) and not(networkConfigBean.selectSubUR eq 'FW')}"/>
						</h:panelGrid>
						
						<h:selectOneRadio id="assignPerson" layout="pageDirection"
							value="#{networkConfigBean.pmAssign.assignForPerson}" 
							styleClass="contentlabelform" >
							<a4j:support actionListener="#{reqNWConfigAction.selectAssignType}" 
								event="onclick" reRender="listPerson, assignPerson, assignTeam, teamPanel1,teamPanel2,personPanel1,personPanel2">
								<a4j:actionparam name="changeTo" value="P"/>
							</a4j:support>
							<f:selectItem itemValue="P" itemLabel="By Person" />
						</h:selectOneRadio>	
						<h:panelGrid columns="8" rendered="#{(networkConfigBean.selectSubUR eq 'FW')}" id="personPanel1">
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isPersonCdno}" disabled="#{networkConfigBean.pmAssign.personEnable}">
								<a4j:support actionListener="#{reqNWConfigAction.addAssignPerson}" event="onclick" reRender="listPerson"/>
							</h:selectBooleanCheckbox>Firewall-1
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isPersonSta1}" disabled="#{networkConfigBean.pmAssign.personEnable}">
								<a4j:support actionListener="#{reqNWConfigAction.addAssignPerson}" event="onclick" reRender="listPerson"/>
							</h:selectBooleanCheckbox>Firewall-2
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isPersonSta2}" disabled="#{networkConfigBean.pmAssign.personEnable}">
								<a4j:support actionListener="#{reqNWConfigAction.addAssignPerson}" event="onclick" reRender="listPerson"/>
							</h:selectBooleanCheckbox>Firewall-3
							<h:selectBooleanCheckbox rendered="#{(not networkConfigBean.isTnp) and (networkConfigBean.selectSubUR eq 'FW')}"  value="#{networkConfigBean.pmAssign.isPersonTdno}" disabled="#{networkConfigBean.pmAssign.personEnable}" >
								<a4j:support actionListener="#{reqNWConfigAction.addAssignPerson}" event="onclick" reRender="listPerson"/>
							</h:selectBooleanCheckbox><h:outputLabel value="TDNO Config" rendered="#{(not networkConfigBean.isTnp) and (networkConfigBean.selectSubUR eq 'FW')}"></h:outputLabel>
						</h:panelGrid>
						
						<h:panelGrid columns="8" rendered="#{(not networkConfigBean.isTnp) and not(networkConfigBean.selectSubUR eq 'FW')}" id="personPanel2">
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isPersonCdn}" disabled="#{networkConfigBean.pmAssign.personEnable}">
								<a4j:support actionListener="#{reqNWConfigAction.addAssignPerson}" event="onclick" reRender="listPerson"/>
							</h:selectBooleanCheckbox>CND Config
							<h:selectBooleanCheckbox value="#{networkConfigBean.pmAssign.isPersonTdno}" disabled="#{networkConfigBean.pmAssign.personEnable}">
								<a4j:support actionListener="#{reqNWConfigAction.addAssignPerson}" event="onclick" reRender="listPerson"/>
							</h:selectBooleanCheckbox>TDNO Config
						</h:panelGrid>
					</td>
				</tr>
				
				<tr>
					<td style="width:80px" align="right">&nbsp;</td>
					<td align="left">
						<rich:pickList  
							id="listPerson"
							value="#{networkConfigBean.pmAssign.selectedPerson}"
							listsHeight="120"
							sourceListWidth="150"
							targetListWidth="150"
							removeAllVisible="false"
							copyAllVisible="false"
							copyControlLabel=" "
							removeControlLabel=" ">
							 <f:attribute name="selectItems" value="#{networkConfigBean.listPerson}"/>
							<f:selectItems value="#{networkConfigBean.listPerson}"/> 
						</rich:pickList>
					</td>
				</tr>
				
				<tr>
					<td style="width:80px" align="right" valign="top"><strong>Remarks&nbsp;:&nbsp;</strong></td>
					<td align="left">
						<h:inputTextarea id="objective" style="width:360px;" rows="3"  value="#{networkConfigBean.pmAssign.mgrRemark}">
						</h:inputTextarea>
					</td>
				</tr>
				
			</table>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton  id="btnAssign" value="Assign" styleClass="rich-button"
							action="#{reqNWConfigAction.pmAssignment}"
							reRender="errorDialogPopup,policyTab"
							oncomplete="reloadTree(); navigateHomepage();" >
							<a4j:jsFunction name="navigateHomepage" action="#{reqNWConfigAction.navigateHomepage}" oncomplete="Richfaces.hideModalPanel('mdlPMAssign');" />
						</a4j:commandButton>&nbsp;
						<a4j:commandButton  id="btnOK" value="Close" styleClass="rich-button"
							reRender="tableAddFirewall">
							<rich:componentControl for="mdlPMAssign" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
	
</rich:modalPanel>
</f:subview>
