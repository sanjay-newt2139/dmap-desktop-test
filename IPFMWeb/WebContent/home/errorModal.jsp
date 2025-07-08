<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>


<h:panelGroup id="errorMsg">
	<rich:modalPanel id="errorDialog" autosized="true" showWhenRendered="true" rendered="#{globalMessages}" resizeable="false" width="400">			
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="IPFM Message"  ></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls" >
			<h:panelGroup>
				<h:graphicImage rendered="#{!HOME}" value="../images/ico_close.png" id="hideErrorDialog" style="cursor:pointer;" >
					<rich:componentControl for="errorDialog" attachTo="hideErrorDialog" operation="hide" event="onclick" />
				</h:graphicImage>
				<a4j:commandButton rendered="false" image="../images/ico_close.png" onclick="reloadTree();javascript:gotoHomePage();"/>
			</h:panelGroup>
		</f:facet>
		
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" width="100%" styleClass="contentlabelform" >
						<h:messages styleClass="contentlabelform" errorStyle="color: red" 
									warnStyle="color: green" infoStyle="color: blue" globalOnly="true"  />
					</h:panelGrid>
				</td>
			</tr>
			<tr> 
				<td>
					<h:panelGrid columns="1" width="100%" style="text-align:center;" styleClass="contentlabelform"> 
					
						<a4j:form rendered="#{!HOME}">	
							<a4j:commandButton value="OK" styleClass="rich-button"  ajaxSingle="true" status="#{rich:component('wait')}.hide();">
	    						<rich:componentControl for="errorDialog" operation="hide" event="oncomplete" />
							</a4j:commandButton>	
						</a4j:form>
						<a4j:form rendered="#{HOME}">
							<a4j:commandButton id="btnClose" value="OK" onclick="reloadTree();javascript:gotoHomePage();"  ajaxSingle="true" styleClass="rich-button" />
							<%-- 	
							<a4j:commandButton id="btnClose" value="OK" onclick="reloadTree();javascript:gotoHomePage();" ajaxSingle="true" styleClass="rich-button" >
								<rich:componentControl for="errorDialog" operation="hide" event="oncomplete" />
							</a4j:commandButton> 
							--%>
						</a4j:form>				
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</rich:modalPanel>
</h:panelGroup> 