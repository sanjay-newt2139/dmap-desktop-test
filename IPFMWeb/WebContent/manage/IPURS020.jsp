<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<f:subview id="approvePopup"> 
<rich:modalPanel id="ApprovePopups" autosized="true"styleClass="contentform" height="250" minWidth="450" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Approve Manager"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="ApprovePopups" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0"  class="thtext_detail2">
						<tr><td>
							<table border="0" width="40%" align="center" cellpadding="0" cellspacing="0" >
								<tr>
								    <td width="9"></td>
									<td height="22" background="../images/title_bar.png"  align="left" width="142"><h:outputText value="Manager" styleClass="contentform"/></td>
								    <td align="left" width="53" ></td>
							        <td height="22" background="../images/title_bar.png"  align="left" width="142" ><h:outputText value="Approve Manager" styleClass="contentform"/></td>
							        <td></td>
								</tr>
								<tr>
								<td colspan="5" align="center">
							        <rich:pickList 
							                copyAllControlLabel=" " copyControlLabel=" "
							                removeAllControlLabel=" "
							                removeControlLabel=" ">
							            <f:selectItem itemLabel="Arree Penjun" itemValue="1"/> 
							            <f:selectItem itemLabel="Manee Suhdee" itemValue="2"/>
							            <f:selectItem itemLabel="Praditphong Soipetch" itemValue="2"/>
							        </rich:pickList>
								</td>
								</tr>
							</table>
						</td></tr>
						<tr>
							<td align="right">
								<h:panelGroup id="buttonGroup"  >
							    	<a4j:commandButton id="btnSend" value="Send" styleClass="rich-button"  action="#{userReqIPAction.init}"
							    	style="width:50px">
										<rich:componentControl for="ApprovePopups" attachTo="btnSend" operation="hide" event="onclick"/>
										<a4j:actionparam name="programIDParam" value="IPURS004_02"/>
								    </a4j:commandButton>&nbsp
									<a4j:commandButton id="btnCancel"  value="Cancel" styleClass="rich-button" style="width:55px">
										<rich:componentControl for="ApprovePopups" attachTo="btnCancel" operation="hide" event="onclick"/>
										</a4j:commandButton>&nbsp;
									<a4j:commandLink id="sendLink" action="#{userReqIPAction.init}">
					                    <strong>Send</strong>
					                    <rich:componentControl for="ApprovePopups" attachTo="sendLink" operation="hide" event="onclick"/>
										<a4j:actionparam name="programIDParam" value="IPURS004_04"/>
					               </a4j:commandLink>
								</h:panelGroup>

							</td>
						</tr>
					</table>
					</a4j:form>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</rich:modalPanel>	
</f:subview>

