<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<script language='javascript'>
	history.forward();
</script>
<a4j:jsFunction name="editF5DetailOld" actionListener="#{configf5.initEdit}"
 	reRender="EditF5" oncomplete="javascript:Richfaces.showModalPanel('EditF5')">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo" />
</a4j:jsFunction>

<a4j:jsFunction name="editF5Detail" actionListener="#{configf5.initEdit}"
 	reRender="networkConfigTab" >
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo" />
 	<a4j:actionparam name="rowNumber"/>
</a4j:jsFunction>

<rich:modalPanel id="EditF5" autosized="true" rendered="false"
	styleClass="contentform" height="165" minWidth="600" 
	label="Find Region" onshow="reloadPage();">
	
	
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Edit F5"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="EditF5" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<f:subview id="popupEditF5">	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<a4j:outputPanel id="panelEditF5">
			<h:outputText value="#{networkConfigBean.errorMsg}"/>
			<table width="100%" border="0" class="thtext_detail">
				<tr class="inputRow">
					<td class="labelStyle" style="width:20%">IP Pool<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="80%">
						<h:outputText value="#{networkConfigBean.editUrF5.poolIpAddress}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" style="width:20%">IP Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="80%">
						<h:inputText id="IPPort" value="#{networkConfigBean.editUrF5.poolIpPort}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="inputRow">
					<td class="labelStyle" style="width:20%">Weight(%)&nbsp;:&nbsp;</td>
					<td width="80%">
						<h:inputText id="weight" value="#{networkConfigBean.editUrF5.poolWeight}" style="text-align:left;width:145px"/>
					</td>
					<td>&nbsp;</td>
				</tr>
			<tr>
				<td colspan="5" align="center">
					<h:panelGroup id="buttonGroup">
							<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"
								action="#{configf5.updateF5Detail}"
								reRender="F5Request" oncomplete="javascript:Richfaces.hideModalPanel('EditF5')">
								<a4j:actionparam name="urNo" value="#{networkConfigBean.editUrF5.id.urNo}"/>
 								<a4j:actionparam name="subUrNo" value="#{networkConfigBean.editUrF5.id.subUrNo}"/>
							</a4j:commandButton>&nbsp;
							<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button"
								reRender="groupSearchResult">
								<rich:componentControl for="EditF5" attachTo="btnCancel" operation="hide" event="onclick"/>
							</a4j:commandButton>&nbsp;
					</h:panelGroup>	
				</td>
			</tr>
			</table>	
		</a4j:outputPanel>
	</a4j:form>
	<a4j:jsFunction name="reloadPage" reRender="EditF5" ajaxSingle="true">
	</a4j:jsFunction>		
</f:subview>	
</rich:modalPanel>

