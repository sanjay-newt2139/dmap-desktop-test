<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<rich:modalPanel id="setExpireDateModal" width="350" minHeight="100" autosized="true">
    <f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Update Info"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="../images/close.png" styleClass="hidelink" id="setExpireDateHidelink"/>
			<rich:componentControl for="setExpireDateModal" attachTo="setExpireDateHidelink" operation="hide" event="onclick"/>
		</h:panelGroup>
	</f:facet> 
	<h:panelGroup style="width:100%;">
   		<a4j:form>
			<h:panelGrid columns="3" styleClass="contentlabelform" style="text-align:left;" width="100%">
				<h:selectBooleanCheckbox id="checkBoxIPStatus"  value="#{ipLevel2Bean.checkBoxIPStatus}">
					<a4j:support event="onclick" action="#{ipLevel2Action.validateCheckBoxIPStatus}" 
						reRender="errorMsg,checkBoxIPStatus,comboBoxIPStatusUpdateInfo,outputTextIPStatusUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="IP Status" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;"/>
				</h:panelGroup>
				<h:panelGroup>
					<rich:comboBox id="comboBoxIPStatusUpdateInfo"  
						defaultLabel="" enableManualInput="false" itemClass="contentform" 
						itemSelectedClass="contentform" value="#{ipLevel2Bean.ipStatusComboItem}" width="159" listWidth="154" 
						listHeight="150" disabled="#{!ipLevel2Bean.checkBoxIPStatus}" >
						<f:attribute name="selectItems" value="#{ipLevel2Bean.ipStatusList}"/>
						<f:selectItems value="#{ipLevel2Bean.ipStatusList}"/>
					</rich:comboBox>					
				</h:panelGroup>
				
				<h:selectBooleanCheckbox id="checkBoxSystemName"  value="#{ipLevel2Bean.checkBoxSystemName}">
					<a4j:support event="onclick" reRender="inputTextSystemNameUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:outputText value="System Name :&nbsp;" escape="false" style="font-weight:bold;" />
				<h:inputText id="inputTextSystemNameUpdateInfo" value="#{ipLevel2Bean.systemNameUpdateInfo}" maxlength="1000" size="21" styleClass="contentform" 
					disabled="#{!ipLevel2Bean.checkBoxSystemName}" />
				
				<h:selectBooleanCheckbox id="checkBoxExpiredDate"  value="#{ipLevel2Bean.checkBoxExpiredDate}">
					<a4j:support event="onclick" reRender="calendarExpiredDateUpdateInfo"/>
				</h:selectBooleanCheckbox>
				<h:panelGroup>
					<h:outputText value="Extend Expire Date to" escape="false" style="font-weight:bold;" />
					<h:outputText value=" :&nbsp;" escape="false" style="font-weight:bold;"/>
				</h:panelGroup>
				<rich:calendar id="calendarExpiredDateUpdateInfo" value="#{ipLevel2Bean.expiredDate}" 
					disabled="#{!ipLevel2Bean.checkBoxExpiredDate}"
			    	locale="en/US" popup="true" datePattern="dd/MM/yyyy" showApplyButton="false" 
			        cellWidth="24px" cellHeight="22px" style="width:200px"
			        inputStyle="background-color:white;" inputSize="20" direction="auto"/>

			</h:panelGrid>
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:right;" width="100%">
				<h:panelGroup>
					<a4j:commandButton value="SAVE" action="#{ipLevel2Action.updateExpireDate}" 
						reRender="#{errorMessages?'errorMsg':'errorMsg,ipDetailTable,groupSearchResult'}"
						styleClass="rich-button" style="width:70px;">
						<rich:componentControl for="setExpireDateModal" operation="#{errorMessages?'show':'hide'}"  event="oncomplete" />
					</a4j:commandButton>
					<rich:spacer width="10" />
					<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" style="width:70px;" ajaxSingle="true" status="#{rich:component('wait')}.hide();">
					    <rich:componentControl for="setExpireDateModal" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</h:panelGroup>
</rich:modalPanel>