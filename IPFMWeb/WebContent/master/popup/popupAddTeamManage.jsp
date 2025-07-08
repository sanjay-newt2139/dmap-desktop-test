<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>
  
<f:subview id="popupModalSubview"> 
<rich:modalPanel id="popupAddTeamManage" autosized="true"
	styleClass="contentform" height="130" minWidth="380" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<strong class="ms10w"> <span class="style9">Add New Team</span></strong>
		</h:panelGroup>	
	</f:facet>    
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="popupAddTeamManage" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td><rich:spacer height="10"/></td>
					<td><rich:spacer height="10"/></td>
				</tr>
				<tr><td colspan="2"><rich:spacer height="10" /></td></tr>
				<tr>
					<td align="right"><strong>Team ID :&nbsp;</strong></td>
					<td align="left"><h:outputText value="#{teamManageBean.ipTeam.teamId}"  styleClass="contentform"/></td>
				</tr>
				<tr>
					<td align="right"><strong>Team Name :&nbsp;</strong></td>
					<td align="left"><h:inputText value="#{teamManageBean.ipTeam.teamName}"  /></td>
				</tr>
				<tr>
					<td align="right"><strong>Description :&nbsp;</strong></td>
					<td align="left"><h:inputText value="#{teamManageBean.ipTeam.teamDesc}"    style="text-align:left;width:200px;"/></td>
				</tr>
				<tr><td colspan="2"><rich:spacer height="10" /></td></tr>
				<tr>
					<td colspan="2" align="center">
						<a4j:commandButton value="OK" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupAddTeamManage" operation="hide" event="onclick" />
						</a4j:commandButton>
						<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupAddTeamManage" operation="hide" event="onclick" />
						</a4j:commandButton>
					</td>
				</tr>		
				<tr><td colspan="2"><rich:spacer height="10" /></td></tr>
			</table>	
		</rich:panel>
	</a4j:form>
</rich:modalPanel>
</f:subview>
