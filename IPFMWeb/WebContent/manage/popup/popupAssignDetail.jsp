<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script language="javascript">
</script>

<f:subview id="popupAssignDetail"> 
<rich:modalPanel id="IPURS008" autosized="true" rendered="true"
	styleClass="contentform" height="385" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Assign Detail"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPURS008" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="95%" border="0" class="thtext_detail">
				<tr>
					<td colspan="3" width="33%" align="left">
						&nbsp;&nbsp;UR Sub ID&nbsp;:&nbsp;
						<h:outputText value="#{networkConfigBean.viewResult.subid}" style="text-align:left;width:100px"/>
					</td>
				</tr>
				<tr class='tableHeader'>
					<td width="33%" align="center" >
						<span class="contentform tableHeaderText"><strong>Source IP</strong></span>
					</td>
					<td width="33%"  align="center">
						<span class="contentform tableHeaderText"><strong>Destination IP</strong></span>
					</td>
					<td width="33%"  align="center">
						<span class="contentform tableHeaderText"><strong>Service</strong></span>
					</td>
				</tr>
				<tr>
					<td width="33%">
						<table width="100%" border="0">
							<tr>
								<td style="width:35%" class="labelStyle" align="right">		
									<h:outputText value="IP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.sourceip}" styleClass="label"></h:outputText>
								</td>
							</tr>		
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="Host:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.shost}" />
								</td>
							</tr>	
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="email:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.smail}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="VIP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.svip}" />
								</td>
							</tr>	
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.snat}" />
								</td>
							</tr>
							</table>	

					</td>
					<td width="33%">
						<table width="100%" border="0">
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="IP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.destip}" styleClass="label"></h:outputText>
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="Host:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.dhost}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">	
									<h:outputText value="email:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.dmail}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="VIP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.dvip}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="Nat IP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.dnat}" />
								</td>
							</tr>	
						</table>	
					</td>
					<td width="33%">
						<table width="100%" border="0">
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="TCP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.tcp}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">	
									<h:outputText value="UDP:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.udp}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">
									<h:outputText value="Other:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">		
									<h:outputText value="Service:" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="#{networkConfigBean.viewResult.service}" />
								</td>
							</tr>
							<tr>
								<td style="width:35%" class="labelStyle" align="right">		
									<h:outputText value="" styleClass="label"></h:outputText>
								</td>
								<td style="width:65%" class="valueStyle" align="left">	
									<h:outputText value="" />
								</td>
							</tr>
						</table>		

					</td>
				</tr>
				
				<tr>
					<td colspan="3">
						<table border="0" width="100%">
							<tr class="tableHeader">
								<td class="contentform tableHeaderText" width="5%" style="text-align:center;"><strong>Delete</strong></td>
								<td class="contentform tableHeaderText" width="30%" style="text-align:center;"><strong>Assign To</strong></td>
								<td class="contentform tableHeaderText" width="30%" style="text-align:center;"><strong>Assign Date</strong></td>
								<td class="contentform tableHeaderText" width="35%" style="text-align:center;"><strong>Job Status</strong></td>
							</tr>
							<tr class="odd">
								<td width="5%" style="text-align:center;">
									<img src="../images/p_delete.gif" border="0">
								</td>
								<td width="30%" style="text-align:center;">
									Mr.C
								</td>
								<td width="30%" style="text-align:center;">
									1/9/2010
								</td>
								<td width="35%" style="text-align:center;">
									Wait For Impact Analysis
								</td>
							</tr>
							<tr class="even">
								<td width="5%" style="text-align:center;">
									<img src="../images/p_delete.gif" border="0">
								</td>
								<td width="30%" style="text-align:center;">
									Mr.D
								</td>
								<td width="30%" style="text-align:center;">
									1/9/2010
								</td>
								<td width="35%" style="text-align:center;">
									Wait For Impact Analysis
								</td>
							</tr>
						</table>
					
						<rich:dataTable width="100%" id="AssignTable" cellpadding="1" cellspacing="0" border="0"
							reRender="AssignTable" rows="5" rendered="false" 
							rowClasses="odd,even" 
							styleClass="contentform" rowKeyVar="index" 
							headerClass="tableHeader">
							
								<rich:column width="5%" style="vertical-align:top;">
									<f:facet name="header"  >
										<h:outputText value="Delete"  styleClass="contentform tableHeaderText"/>
									</f:facet>
									<div align="center">
										<c:choose>
											<c:when test="${networkConfigBean.detailViewName == 'IPURS006_12'}">
												<a4j:commandLink  actionListener="#{reqNWConfigAction.deleteRow}" reRender="waitAssignTable" oncomplete="deleteCell(this)">
													<img src="../images/p_delete.gif" border="0">
												</a4j:commandLink>
											</c:when>
											<c:otherwise>
												<img src="../images/p_delete.gif" border="0">
											</c:otherwise>
										</c:choose>
										
									</div>
								</rich:column>
								<rich:column width="30%" style="vertical-align:top;">
									<f:facet name="header"  >
										<h:outputText value="Assign To"  styleClass="contentform tableHeaderText"/>
									</f:facet>
									<div align="center">
										<h:outputText value="Mr.C" />
									</div>
								</rich:column>
								<rich:column width="30%" style="vertical-align:top;">
									<f:facet name="header"  >
										<h:outputText value="Assign Date"  styleClass="contentform tableHeaderText"/>
									</f:facet>
									<div align="center">
										<h:outputText value="3/9/2010" />
									</div>
								</rich:column>
								<rich:column width="35%" style="vertical-align:top;">
									<f:facet name="header"  >
										<h:outputText value="Job Status"  styleClass="contentform tableHeaderText"/>
									</f:facet>
									<div align="center">
										<h:outputText value="Wait For Impact Analysis" />
									</div>
								</rich:column>
						</rich:dataTable>
					</td>
				</tr>
				
				<tr>
					<td  colspan="3">
						<table width="100%" border="0">
							<tr>
								<td class="labelStyle" align="right" valign="top">
									Impact Detail&nbsp;:
								</td>
								<td class="valueStyle" >
									<h:inputTextarea id="impactDetail" style="width:360px;" rows="3"
									  value="">
									</h:inputTextarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td  colspan="3">
						<table width="100%" border="0">
							<tr>
								<td class="labelStyle" align="right" valign="top">
									Force Job Status&nbsp;:
								</td>
								<td class="valueStyle" >
									<rich:comboBox id="forceJobStatus" defaultLabel=""
										itemClass="contentform" 
										itemSelectedClass="contentform" width="360">
									 <f:selectItem itemValue="Complete"/>
									 <f:selectItem itemValue="Reject"/>
									</rich:comboBox>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
			<tr><td>&nbsp;</td></tr>	
			<tr>
				<td>&nbsp;</td>
				<td align="left">
					<h:panelGroup id="btnPopupAssignDetail">
						<a4j:commandButton id="btnOK" value="OK" styleClass="rich-button">
							<rich:componentControl for="IPURS008" attachTo="btnOK" operation="hide" event="onclick"/>
						</a4j:commandButton>&nbsp;
					</h:panelGroup>
				</td>
			</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
