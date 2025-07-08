<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>

<a4j:jsFunction name="setImpact"
	action="#{reqNWConfigAction.getSelectedSubUR}"
	rendered="confirmImpact"
	oncomplete="Richfaces.showModalPanel('confirmImpact');">
 	<a4j:actionparam name="urNo"/>
 	<a4j:actionparam name="subUrNo"/>
</a4j:jsFunction>

<rich:modalPanel id="confirmImpact" width="350" height="100">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Comfirm Message"></h:outputText>
		</h:panelGroup>
	</f:facet>
		
	<f:facet name="controls">
		<h:panelGroup>
	    	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hideConfDeleteAll"/>
	        <rich:componentControl for="confirmDeleteAllPopup" attachTo="hideConfDeleteAll" operation="hide" event="onclick"/>
	    </h:panelGroup>
	</f:facet>
	<a4j:form id="formDeleteAllQuery">
	<table width="100%" border="0">
    	<tr><td align="center">
    		<h:inputHidden id="errorFlag" value="#{networkConfigBean.errorFlag}"></h:inputHidden>
    		<h:outputText value="#{mes.CF0011}" />
    	</td></tr>
        <tr><td align="center">
        	<a4j:commandButton value="Yes" styleClass="rich-button" id="btnYes"
        		action="#{reqNWConfigAction.setImpactUR}" reRender="policyTab,tbPhysicalInterface"
				oncomplete="Richfaces.hideModalPanel('confirmImpact');">
				<a4j:actionparam name="selectImpact" value="Y" />
			</a4j:commandButton>
			<a4j:commandButton value="No" styleClass="rich-button" id="btnNo"  
				action="#{reqNWConfigAction.setImpactUR}" reRender="policyTab,tbPhysicalInterface"
				oncomplete="Richfaces.hideModalPanel('confirmImpact');">
				<a4j:actionparam name="selectImpact" value="N" />
			</a4j:commandButton>
        </td></tr>
    </table>
    </a4j:form>
</rich:modalPanel>


