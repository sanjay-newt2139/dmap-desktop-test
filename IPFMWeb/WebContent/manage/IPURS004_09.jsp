<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<f:subview id="popup09"> 
<rich:modalPanel id="IPURS004_09Popup" autosized="true"styleClass="contentform" height="400" minWidth="620" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="Assign IP"></h:outputText>
		</h:panelGroup>
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="IPURS004_09Popup" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
     <body style="overflow: hidden;">
     <div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<f:subview id="error">
					<jsp:include page="../home/errorModal.jsp" />
				</f:subview>
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" bgcolor="#CCCCCC" class="thtext_detail2">
						<tr>
						   <td>
						   	 	<rich:panel>
						   	 	   <strong>IP Address<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
								   <h:panelGroup id="rangIpGroup">
									   				<h:inputText id="stIp1" value="172"  
														size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
			                                        <h:inputText id="stIp2" value="16" 
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
                                        			<h:inputText id="stIp3" value="0"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
													<h:inputText id="stIp4" value="0"  
										 				size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
													<h:outputText style="font-weight: bolder;">
														&nbsp;/&nbsp;
													</h:outputText>
													<h:inputText id="stIp5" value="19"
													 	size="1" style="text-align:center" maxlength="3" 
													 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
														onchange="numberformat.formatIntegerObject(this)" />
												</h:panelGroup>	&nbsp;&nbsp;&nbsp;&nbsp;
										<h:panelGroup id="button">
											<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button"
												action="#{userReqIPAction.init}"/>&nbsp;
											<a4j:commandButton id="btnReset" value="Reset" styleClass="rich-button"
												action="#{userReqIPAction.clear}"/>
										</h:panelGroup>
								<rich:dataTable width="95%" id="ipDetailTable2" cellpadding="1" cellspacing="0" border="0"
									var="userReLists" value="#{userReqIPBean.userReques_09tList}" reRender="scrollIPDetailTable" 
									  
									 
									rowClasses="odd,even" 
									styleClass="contentform" rowKeyVar="index" 
									headerClass="tableHeader">

										<rich:column width="5%" >
											<f:facet name="header">
												 <h:selectBooleanCheckbox/>
											</f:facet>
											<div align="center">
		                                        <h:selectBooleanCheckbox/>
											</div>
										</rich:column>
							            <rich:column  filterValue="#{userReqIPBean.filter00409.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(userReLists.IS_APPDIAGRAM,userReqIPBean.filter00409.filterColumn1)}"   width="22%" >
											<f:facet name="header">												
													  <h:panelGroup>
		 <h:outputText value="IP Address" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00409.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
											  <a4j:commandLink rendered="#{userReLists.IS_NWDIAGRAM=='100'}" id="urLink" action="#{userReqIPAction.init}"><h:outputText value="#{userReLists.IS_APPDIAGRAM}" styleClass="contentform"></h:outputText>
											         <rich:componentControl for="IPURS004_09Popup" attachTo="urLink" operation="hide" event="onclick"/>
                             		                 <rich:componentControl for="IPURS004_10Popup" attachTo="urLink" operation="show" event="onclick"/>
                             		          </a4j:commandLink>
											     <h:outputText rendered="#{userReLists.IS_NWDIAGRAM!='100'}" value="#{userReLists.IS_APPDIAGRAM}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>									
										<rich:column  filterValue="#{userReqIPBean.filter00409.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(userReLists.IS_EXPAN_NETWORK,userReqIPBean.filter00409.filterColumn2)}"  width="7%" >
											<f:facet name="header">
												 <h:panelGroup>
		 <h:outputText value="Total IP" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00409.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
			          						    <h:outputText value="#{userReLists.IS_EXPAN_NETWORK}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column  filterValue="#{userReqIPBean.filter00409.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(userReLists.IS_NWDIAGRAM,userReqIPBean.filter00409.filterColumn3)}"   width="10%" >
											<f:facet name="header">
												<h:panelGroup>
		 <h:outputText value="Available" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00409.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          					   <h:outputText value="#{userReLists.IS_NWDIAGRAM}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column  filterValue="#{userReqIPBean.filter00409.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(userReLists.IS_NEW_NETWORK,userReqIPBean.filter00409.filterColumn4)}"   width="10%" >
											<f:facet name="header">
													<h:panelGroup>
		 <h:outputText value="Assigned" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00409.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          					   <h:outputText value="#{userReLists.IS_NEW_NETWORK}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column  filterValue="#{userReqIPBean.filter00409.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(userReLists.MRG_REMARK,userReqIPBean.filter00409.filterColumn5)}"   width="10%" >
											<f:facet name="header">
												<h:panelGroup>
		 <h:outputText value="Reserved" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00409.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          					    <h:outputText value="#{userReLists.MRG_REMARK}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>
										<rich:column  filterValue="#{userReqIPBean.filter00409.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(userReLists.MRG_REMARK,userReqIPBean.filter00409.filterColumn6)}"   width="7%" >
											<f:facet name="header">
												<h:panelGroup>
		 <h:outputText value="Used" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userReqIPBean.filter00409.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable2" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div align="center">
				          					    <h:outputText value="#{userReLists.MRG_REMARK}" styleClass="contentform"></h:outputText> 
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{ fn:length(userReqIPBean.userReques_09tList) }" /> records
												</rich:column>
												<rich:column colspan="8">
													<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable2"
														maxPages="#{ipfmConfigBean.maxPage}"" id="scrollIPDetailTable2" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
														style="background-color: #cccccc;"/>
												</rich:column>
											</rich:columnGroup>												
										</f:facet>
									</rich:dataTable>	
								 </rich:panel>											
						   </td>
						</tr>
												
						<tr>
							<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
						</tr>
						<tr>
							<td>
								<table width="97%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="right" colspan="6">
										<h:panelGroup id="buttonGroup">
											<a4j:commandButton id="btnAssign" value="Assign" styleClass="rich-button"
												action="#{userReqIPAction.sendApprove}"/>&nbsp;
											<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button">
											  <rich:componentControl for="IPURS004_09Popup" attachTo="btnCancel" operation="hide" event="onclick"/>
											</a4j:commandButton>
										</h:panelGroup>
									</td>
									</tr>
								</table>
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
 </div>
 </body>
</rich:modalPanel>
<jsp:directive.include file="IPURS004_10.jsp"/>	
</f:subview>
