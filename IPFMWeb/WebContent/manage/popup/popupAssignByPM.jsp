<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<f:subview id="popupAssignPM"> 
<rich:modalPanel id="AssignPMpopup" autosized="true"
	styleClass="contentform" height="380" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Assign By PM"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="AssignPMpopup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td width="22%" align="right">
						<h:selectOneRadio id="byTeam" value="">
							<f:selectItem itemValue="1"/>
						</h:selectOneRadio>
					</td>
					<td>
						By Team
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						<h:selectManyCheckbox layout="lineDirection" id='listByTeam'>
							<f:selectItem id="team1" itemLabel="Firewall_CDND" itemValue="1" />
							<f:selectItem id="team2" itemLabel="Firewall_STA1" itemValue="2" />
							<f:selectItem id="team3" itemLabel="Firewall_STA2" itemValue="3" />
						</h:selectManyCheckbox>
					</td>
				</tr>
				
				<tr>
					<td width="22%" align="right">
						<h:selectOneRadio id="byPersom" value="1">
							<f:selectItem itemValue="1"/>
						</h:selectOneRadio>
					</td>
					<td>
						By Person
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						<h:selectManyCheckbox layout="lineDirection" id='listByPerson'>
							<f:selectItem id="teamP1" itemLabel="Firewall_CND" itemValue="1"   />
							<f:selectItem id="teamP2" itemLabel="Firewall_STA1" itemValue="2"  />
							<f:selectItem id="teamP3" itemLabel="Firewall_STA2" itemValue="3"  />
							
						</h:selectManyCheckbox>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						<rich:pickList 
							copyAllControlLabel=" " 
							copyControlLabel=" "
							removeAllControlLabel=" "
							removeControlLabel=" ">
							
							<f:selectItem itemLabel="Mr. A" itemValue="1"/>
							<f:selectItem itemLabel="Mr. B" itemValue="2"/>
							<f:selectItem itemLabel="Mr. C" itemValue="3"/>
							<f:selectItem itemLabel="Mr. D" itemValue="4"/>
							<f:selectItem itemLabel="Mr. E" itemValue="5"/> 
							
							            
						</rich:pickList>
					</td>
				</tr>
				<tr>
					<td>Remarks&nbsp;:&nbsp;</td>
					<td>
						<h:inputTextarea id="Comment" style="width:360px;" rows="3">
						</h:inputTextarea>
					</td>
				</tr>
				
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left">
					<h:panelGroup id="btnPopupAssign">
						<a4j:commandButton ajaxSingle="true" id="btnAssignJob" value="Assign" styleClass="rich-button"
							actionListener="#{reqNWConfigAction.AssignJob}"
							reRender="waitAssignTable">
							<rich:componentControl for="AssignPMpopup" attachTo="btnAssignJob" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
						<a4j:commandButton id="btnCancelFirewall" value="Cancel" styleClass="rich-button"
							action="#{manageDataIPAction.init}"
							reRender="fierwallPolicyTable">
							<rich:componentControl for="AssignPMpopup" attachTo="btnCancelFirewall" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
