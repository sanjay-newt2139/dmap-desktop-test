<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<f:subview id="popupAddF5"> 
<rich:modalPanel id="AddF5Popup" autosized="true"
	styleClass="contentform" height="260" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Add F5"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="AddF5Popup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="95%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td width="22%" align="right">VIP<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="27%">
						<h:inputText id="vip" value="" style="text-align:left;width:145px"/>
					</td>
					<td width="23%" align="right">VIP Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td width="30%">
						<h:inputText id="vipPort" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr>
					<td align="right">SNAT IP&nbsp;:&nbsp;</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><h:selectOneRadio id="snatYes"><f:selectItem itemValue="1" itemLabel="Yes"/></h:selectOneRadio></td>
								<td><h:inputText id="snatIP" style="text-align:left;width:75px"/></td>
							</tr>
						</table>
					</td>
					<td align="right" valign="top">Persistance&nbsp;:&nbsp;</td>
					<td>
						<h:selectOneRadio id="persYes"><f:selectItem itemValue="1" itemLabel="Yes"/></h:selectOneRadio>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><h:selectOneRadio id="snatNo"><f:selectItem itemValue="1" itemLabel="No"/></h:selectOneRadio></td>
					<td>&nbsp;</td>
					<td><h:selectOneRadio id="persNo"><f:selectItem itemValue="1" itemLabel="No"/></h:selectOneRadio></td>
				</tr>
				<tr>
					<td align="right">Method&nbsp;:&nbsp;</td>
					<td  align="top" class="borderLT">
						<h:selectOneRadio id="roundRobin"><f:selectItem itemValue="1" itemLabel="Round Robin"/></h:selectOneRadio>
					</td>
					<td align="right" class="borderT">IP Pool<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td class="borderTR">
						<h:inputText id="rrIPPool" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td colspan="2" align="right" class="borderLB">IP Pool Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td class=borderBR>
						<h:inputText id="rrIPPoolPort" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr><td><img src="../images/blank.gif"></td></tr>
				<tr>
					<td align="right" align="top">Method&nbsp;:&nbsp;</td>
					<td  align="top" class="borderLT">
						<h:selectOneRadio id="ratio"><f:selectItem itemValue="1" itemLabel="Ratio"/></h:selectOneRadio>
					</td>
					<td align="right" class="borderT">IP Pool<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td class="borderTR">
						<h:inputText id="ratioIPPool" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td colspan=2 align="right" class="borderL">IP Pool Port<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td class="borderR">
						<h:inputText id="ratioIPPoolPort" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td colspan=2 class="borderLB" align="right">Weigth(%)<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</td>
					<td class="borderBR" >
						<h:inputText id="ratioWeigth" value="" style="text-align:left;width:145px"/>
					</td>
				</tr>
				
				
			<tr>
				<td>&nbsp;</td>
				<td align="left">
					<h:panelGroup id="btnPopupFirewall">
						<a4j:commandButton id="btnAddFirewall" value="Add" styleClass="rich-button"
							action="#{manageDataIPAction.search}"
							reRender="groupSearchResult" />&nbsp;
						<a4j:commandButton id="btnCancelFirewall" value="Cancel" styleClass="rich-button"
							action="#{manageDataIPAction.init}"
							reRender="fierwallPolicyTable">
							<rich:componentControl for="AddFirewallPopup" attachTo="btnCancelFirewall" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
