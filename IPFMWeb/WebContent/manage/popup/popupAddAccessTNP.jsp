<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<f:subview id="popupAddAccessTNP"> 
<rich:modalPanel id="AddAccessTNPPopup" autosized="true"
	styleClass="contentform" height="210" minWidth="650" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Add Access List For TNP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="AddAccessTNPPopup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
			<rich:panel>
				
			</rich:panel>		
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
