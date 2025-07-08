<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<a4j:jsFunction name="showAlertMsg" reRender="alertPopup"
	action="#{reqNWConfigAction.setMessageError}" 
	oncomplete="showErrorMessageDialog()">
	<a4j:actionparam name="errNo"/>
</a4j:jsFunction>

<a4j:jsFunction name="showDelegatePM"  reRender="delegatePMPopup,policyTab"
	action="#{reqNWConfigAction.showDelegatePM}" 
	oncomplete="reloadTree(); navigateHomepage();">
	<a4j:actionparam name="subUrType"/>
</a4j:jsFunction>

<rich:modalPanel id="confirmDelegatePopup" autosized="true"
	styleClass="contentform" minWidth="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="IPFM Message"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideErrorIcon" style="cursor:pointer;" />
			<rich:componentControl for="confirmDelegatePopup" attachTo="hideErrorIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupConfirmDlg">	
	<a4j:form id="errorMsgRegionMultiQuery">
	
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
		<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center">
				<h:panelGrid columns="1" styleClass="contentlabelform" >
					<h:outputText id="confirmMessage" styleClass="contentlabelform" 
						value="Do you want to Delegate Sub UR to other PM?"/>						
				</h:panelGrid>
			</td>
		</tr>
		<tr>
			<td align="center">
				<h:panelGrid columns="3" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes" onclick="delegateJob()">
					</a4j:commandButton>
					&nbsp;
					<a4j:commandButton value="No" styleClass="rich-button" id="btnNo">
						<rich:componentControl for="confirmDelegatePopup" attachTo="btnNo" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGrid>
			</td>
		</tr>
		</table>	
	</a4j:outputPanel>
	</a4j:form>
</f:subview>					
	
</rich:modalPanel>



<rich:modalPanel id="delegatePMPopup" autosized="true"
	styleClass="contentform" height="205" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Delegate Job"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="delegatePMPopup" attachTo="hidelink" operation="hide" event="onclick"/>
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
					
						<h:selectOneRadio id="delegateTeam" layout="pageDirection" value="#{networkConfigBean.pmDelegate.assignForTeam}"  styleClass="contentlabelform" >
							<a4j:support actionListener="#{reqNWConfigAction.selectDelegateType}" 
								event="onclick" reRender="formRegionMultiQuery,dglistPerson,delegatePerson,delegateTeam,teamPaneldg1,personPaneldg1">
								<a4j:actionparam name="changeTo" value="T"/>
							</a4j:support>
							<f:selectItem itemValue="T" itemLabel="By Team" />
						</h:selectOneRadio>
						<h:panelGrid columns="8" rendered="#{networkConfigBean.pmDelegate.teamEnable}" id="teamPaneldg1">
							<h:selectBooleanCheckbox  value="#{networkConfigBean.pmDelegate.isTeamTdno}"  rendered="#{networkConfigBean.pmDelegate.showTNP}" />
							<h:outputLabel value="PM - TNP" rendered="#{networkConfigBean.pmDelegate.showTNP}"/>
							
							<h:selectBooleanCheckbox  value="#{networkConfigBean.pmDelegate.isTeamCdn}"  rendered="#{networkConfigBean.pmDelegate.showCDN}" />
							<h:outputLabel value="PM - CDN" rendered="#{networkConfigBean.pmDelegate.showCDN}"/>							
						</h:panelGrid>
						
						

						
						<h:selectOneRadio id="delegatePerson" layout="pageDirection" value="#{networkConfigBean.pmDelegate.assignForPerson}"  styleClass="contentlabelform" >
							<a4j:support actionListener="#{reqNWConfigAction.selectDelegateType}" 
								event="onclick" reRender="formRegionMultiQuery,dglistPerson,delegatePerson,delegateTeam,teamPaneldg1,personPaneldg1">
								<a4j:actionparam name="changeTo" value="P"/>
							</a4j:support>
							<f:selectItem itemValue="P" itemLabel="By Person" />
						</h:selectOneRadio>							
						<h:panelGrid columns="8" rendered="#{networkConfigBean.pmDelegate.personEnable}" id="personPaneldg1">   
							<h:selectBooleanCheckbox  value="#{networkConfigBean.pmDelegate.isTeamTdno}"  rendered="#{networkConfigBean.pmDelegate.showTNP}">
								<a4j:support actionListener="#{reqNWConfigAction.addDelegatePerson}" event="onclick" reRender="dglistPerson" />
							</h:selectBooleanCheckbox>
							<h:outputLabel value="PM - TNP" rendered="#{networkConfigBean.pmDelegate.showTNP}"/>
							
							<h:selectBooleanCheckbox  value="#{networkConfigBean.pmDelegate.isTeamCdn}"  rendered="#{networkConfigBean.pmDelegate.showCDN}">
								<a4j:support actionListener="#{reqNWConfigAction.addDelegatePerson}" event="onclick" reRender="dglistPerson" />
							</h:selectBooleanCheckbox>
							<h:outputLabel value="PM - CDN" rendered="#{networkConfigBean.pmDelegate.showCDN}"/>

						</h:panelGrid>
						
						
						
						
					</td>
				</tr>
				<tr>
					<td style="width:80px" align="right">&nbsp;</td>
					<td align="left">
						<rich:pickList  rendered="#{networkConfigBean.pmDelegate.personEnable}"
							id="dglistPerson"
							value="#{networkConfigBean.pmDelegate.selectedDelegatePerson}"
							listsHeight="120"
							sourceListWidth="150"
							targetListWidth="150"
							removeAllVisible="false"
							copyAllVisible="false"
							copyControlLabel=" "
							removeControlLabel=" ">
							 <f:attribute name="selectItems" value="#{networkConfigBean.listdgp}"/>
							<f:selectItems value="#{networkConfigBean.listdgp}"/> 
						</rich:pickList>
					</td>
				</tr>
				<tr>
					<td style="width:80px" align="right" valign="top"><strong>Remarks<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:</strong></td>
					<td align="left">
						<h:inputTextarea id="objective" style="width:360px;" rows="3"  value="#{networkConfigBean.pmDelegate.mgrRemark}">
						</h:inputTextarea>
					</td>
				</tr>
				
								
			</table>
				<div align="center">
					<h:panelGroup id="buttonGroup">
						<a4j:commandButton  id="btnDelegate" value="Delegate" styleClass="rich-button" action="#{reqNWConfigAction.delegatePMNew}"
							reRender="errorDialogPopup,policyTab"
							oncomplete="reloadTree(); navigateHomepage();" >
							<a4j:jsFunction name="navigateHomepage" action="#{reqNWConfigAction.navigateHomepage}" oncomplete="Richfaces.hideModalPanel('delegatePMPopup');" />
						</a4j:commandButton>&nbsp;
						<a4j:commandButton  id="btnC" value="Close" styleClass="rich-button">
							<rich:componentControl for="delegatePMPopup" attachTo="btnC" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</div>		
		</rich:panel>
	</a4j:form>
	
</rich:modalPanel>














<rich:modalPanel id="delegatePMPopupxxxx" autosized="true"
	styleClass="contentform" minWidth="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Delegate to Other PM"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideDLGIcon" style="cursor:pointer;" />
			<rich:componentControl for="delegatePMPopup" attachTo="hideDLGIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupDelegeteDlg">	
	<a4j:form id="errorMsgRegionMultiQuery">
	
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
		<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<h:panelGrid columns="1" styleClass="contentlabelform" >
					<h:inputHidden id="confFlag" value="#{networkConfigBean.confFlag}"></h:inputHidden>
					<h:outputText id="confirmMessage" styleClass="contentlabelform" 
						value="Please select PM Team that you want to delegate to:"/>	
					<h:selectOneRadio id="selectTeamId" layout="pageDirection"
						value="#{networkConfigBean.delegateTeamID}" 
						styleClass="contentlabelform">
						<f:selectItem itemValue="R06" itemLabel="PM-TNP" />
						<f:selectItem itemValue="R07" itemLabel="PM-CND" />
					</h:selectOneRadio>						
				</h:panelGrid>
			</td>
		</tr>
		<tr>
			<td>
				<h:panelGrid columns="3" styleClass="contentlabelform">
					<a4j:commandButton value="Delegate" styleClass="rich-button" id="btnSave"
						action="#{reqNWConfigAction.delegatePM}" reRender="policyTab" 
						oncomplete="reloadTreeFrame(); navigateHomepage();" >
						<a4j:jsFunction name="navigateHomepage" action="#{reqNWConfigAction.navigateHomepage}" 
							oncomplete="Richfaces.hideModalPanel('delegatePMPopup');" />
					</a4j:commandButton>
					&nbsp;
					<a4j:commandButton value="Cancel" styleClass="rich-button" id="btnCancel">
						<rich:componentControl for="delegatePMPopup" attachTo="btnCancel" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGrid>
			</td>
		</tr>
		</table>	
	</a4j:outputPanel>
	</a4j:form>
</f:subview>					
	
</rich:modalPanel>

<rich:modalPanel id="alertPopup" autosized="true"
	styleClass="contentform" minWidth="400" label="Find Region">	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="IPFM Error Message"  ></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup >
			<h:graphicImage value="../images/ico_close.png" id="hideAlertIcon" style="cursor:pointer;" />
			<rich:componentControl for="alertPopup" attachTo="hideAlertIcon" operation="hide" event="onclick" />
		</h:panelGroup>
    </f:facet>
	<f:subview id="popupAlert">	
	<a4j:form id="errorMsgRegionMultiQuery">
	
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
	
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
		<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<h:panelGrid columns="1" styleClass="contentlabelform" >
					<h:inputHidden id="errorFlag" value="#{networkConfigBean.errorFlag}"></h:inputHidden>
					<h:outputText id="confirmMessage" styleClass="contentlabelform" 
						value="#{networkConfigBean.errorMsg}"/>						
				</h:panelGrid>
			</td>
		</tr>
		<tr>
			<td>
				<h:panelGrid columns="3" styleClass="contentlabelform">
					<a4j:commandButton value="Close" styleClass="rich-button" id="btnClose">
						<rich:componentControl for="alertPopup" attachTo="btnClose" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGrid>
			</td>
		</tr>
		</table>	
	</a4j:outputPanel>
	</a4j:form>
</f:subview>					
	
</rich:modalPanel>