<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>

<f:subview id="confirm">
 	<rich:modalPanel id="confirmDlg" width="350" height="100">
	    <f:facet name="header">
			<h:panelGroup>
				<h:outputText value="View Firewall"></h:outputText>
			</h:panelGroup>
		</f:facet>
		
		<f:facet name="controls">
	    	<h:panelGroup>
	        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
	            <rich:componentControl for="confirmDlg" attachTo="hidelink" operation="hide" event="onclick"/>
	        </h:panelGroup>
	    </f:facet>
	     <table width="90%" border="0">
        	<tr><td align="center"><h:outputText value="#{mes.CF0001}" /></td></tr>
        	<tr><td align="center">
        		<input type="button" id="btnYes" value="Yes" class="rich-button" onclick="confirmedDelete()">
        		<input type="button" id="btnNo" value="No" class="rich-button" onclick="Richfaces.hideModalPanel('confirmDlg');">
        	</td></tr>
        </table>
    </rich:modalPanel>
</f:subview>