<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<script type="text/javascript" src="<%=javax.faces.context.FacesContext.getCurrentInstance()
					.getExternalContext().getRequestContextPath()%>/js/js_clock.js">
			
</script>

<SCRIPT type="text/javascript">

</script>

<a4j:status id="uploadprogress" onstart="#{rich:component('wait')}.show();"
	onstop="" for="uploadregion" />

<a4j:status id="allprogress" onstart="#{rich:component('wait')}.show();"
	onstop="#{rich:component('wait')}.hide()" />	
	
<rich:modalPanel id="wait" autosized="true" width="180" height="70" 
	moveable="false" resizeable="false" >
	<f:facet name="header">
		<h:outputText value="Processing" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
		</h:panelGroup>
	</f:facet>
 
	<h:panelGrid columns="1" width="100%" style="text-align:center;">
		<h:graphicImage value="../images/loading45.gif"></h:graphicImage>
<!--		<h:outputText id="countWaiting" styleClass="contentlabelform" value="0" />-->
	</h:panelGrid>
</rich:modalPanel>
