<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>
<script type="text/javascript" language="javascript" src="../js/validateConfig.js"></script>

<style type="text/css">
	.valignTop {vertical-align:top;}
	.aCenter {text-align:center;}
	.label {font-size:20px; font-weight: bold;}
	.displayLabel {}
	.rowHeight {height:25px;}
	.colWidth {width:200px;}
	.rich-filter-input {width:80px;}
}
</style>
</head>
<body style="overflow:hidden;">

<f:view> 
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />					
	</f:subview>
	<f:subview id="error">
		<jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
				  <a4j:form id="DetailForm">
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Manage IP Level 3</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" style="width:100%">
									<h:panelGroup style="width:100%">
										<table width="100%" border="0" class="thtext_detail">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail">
														<tr class="inputRow">
															<td class="labelStyle" >IP Version <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
													        <td>
																<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										                              	  		<rich:spacer width="10"></rich:spacer>
																  	<rich:comboBox id="ipVersion" defaultLabel="" rendered="true"
																		enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
																		value="#{ipLevel2Bean.ipVersion}" width="40">
																		<f:selectItem itemLabel="4" itemValue="4"/>
																		<a4j:support event="onselect" reRender="panelGrop"></a4j:support>
										                                     </rich:comboBox>
										                                     <h:outputText value="#{ipLevel3Bean.ipVersion}" rendered="false"></h:outputText>
																</h:panelGrid>																									
															</td>
															<td class="labelStyle" >IP Address <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
													        <td>
																<h:panelGroup id="rangeIpGroup" rendered="true">
																	<rich:spacer width="10"></rich:spacer>
													   				<h:inputText id="ipDigit1" value="#{ipLevel3Bean.searchIp1}" size="1" style="text-align:center" maxlength="3"  
																	 	onkeypress="return numbersonlyNoDot(event);"
													 					onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit2',this,event,0,255,'190')"
																	 	onblur="this.value = isNumber(this);"/>
																	<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
										                                     <h:inputText id="ipDigit2" value="#{ipLevel3Bean.searchIp2}" size="1" style="text-align:center" maxlength="3"  
													 					onkeypress="return numbersonlyNoDot(event);"
													 					onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit3',this,event,0,255,'190')"
																	 	onblur="this.value = isNumber(this);"/>
																	<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
										                                  			<h:inputText id="ipDigit3" value="#{ipLevel3Bean.searchIp3}" size="1" style="text-align:center" maxlength="3"  
																	 	onkeypress="return numbersonlyNoDot(event);"
													 					onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit4',this,event,0,255,'190')"
																	 	onblur="this.value = isNumber(this);"/>
																	<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
																	<h:inputText id="ipDigit4" value="#{ipLevel3Bean.searchIp4}" size="1" style="text-align:center" maxlength="3"  
																	 	onkeypress="return numbersonlyNoDot(event);"
													 					onkeyup="return keyRangeNumberWithDot('DetailForm:searchMask',this,event,0,255,'191')"
																	 	onblur="this.value = isNumber(this);"/>
																	<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false" rendered="#{ipLevel3Bean.ipVersion=='6'}"/>
										                                  			<h:inputText value="#{ipLevel3Bean.searchIp5}" rendered="#{ipLevel3Bean.ipVersion=='6'}"
														 				size="1" style="text-align:center" maxlength="3" onkeypress="return checkIPDegitKey(this,event);" onblur="this.value = isNumber(this);"/>
																	<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false" rendered="#{ipLevel3Bean.ipVersion=='6'}"/>
																	<h:inputText value="#{ipLevel3Bean.searchIp6}" rendered="#{ipLevel3Bean.ipVersion=='6'}"
														 				size="1" style="text-align:center" maxlength="3" onkeypress="return checkIPDegitKey(this,event);" onblur="this.value = isNumber(this);"/>
																	<h:outputText value="&nbsp;/&nbsp;" style="font-weight: bolder;" escape="false"/>
																	<h:inputText id="searchMask" value="#{ipLevel3Bean.searchMask}" size="1" style="text-align:center" maxlength="2" 
																				onkeypress="return numbersonlyNoDot(event);" onblur="this.value = isNumber(this);"/>
																	<rich:spacer width="10" />												
																	<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{ipLevel3Action.searchNetworkIP}" reRender="#{errorMessages?'errorMsg':'errorMsg,IPDataTable1,groupSearchResult'}" />&nbsp;
																	<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{ipLevel3Action.reset}" reRender="#{errorMessages?'errorMsg':'errorMsg,DetailForm'}"/>&nbsp;
																	<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#ipDigit1,#ipDigit2,#ipDigit3,#ipDigit4,#searchMask"/>
															</h:panelGroup>																												
														</td>														
										             </tr>                                     
												</table>
													<rich:panel style="width:220px;  height:120px;">
														<f:facet name="header">
															<h:outputText value="Network IP" />
														</f:facet>
														
														<h:panelGroup style="width:100%;">
															<a4j:commandLink id="rowOnClickButton" action="#{ipLevel3Action.searchIP}" reRender="#{errorMessages?'errorMsg':'errorMsg,groupSearchResult'}" />
										                    <h:inputHidden id="selectedCurrentRowIndex" value="#{ipLevel3Bean.selectRowIndex}"/>
															
															<rich:dataTable style="border: solid 1px;" binding="#{ipLevel3Bean.dataTable}"
																width="100%" id="IPDataTable1" cellpadding="0" cellspacing="0" border="1"
																var="detail" value="#{ipLevel3Bean.networkIpList}" reRender="scrollIPDetailTable1" 
																rowClasses="odd" rows="4" 
																styleClass="contentform" rowKeyVar="rowIndex"  
																onRowClick="document.getElementById('DetailForm:selectedCurrentRowIndex').value='#{rowIndex}'; document.getElementById('DetailForm:rowOnClickButton').click();">
												
																<rich:column styleClass="valignTop" style="margin:0px; border:1px;">
																	<h:outputText value="#{detail.networkIp}" styleClass="contentform" style="cursor: pointer;" />
																</rich:column>
																<f:facet name="footer"> 
																	<rich:columnGroup rendered="#{not empty ipLevel3Bean.networkIpList}">
																		<rich:column style="height:20px;">
																			<rich:datascroller immediate="true" rendered="true" align="right" for="IPDataTable1"
																				maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable1"  
																				stepControls="hide" fastControls="auto" boundaryControls="auto" 
																				style="background-color: #cccccc;" fastStep="#{ipfmConfigBean.fastStepPage}">
																			   	  	
																			</rich:datascroller>
																		</rich:column>	
																	</rich:columnGroup>		
																</f:facet>
															</rich:dataTable>
														</h:panelGroup>
													</rich:panel>
												</td>
											</tr>
											<tr>
												<td align="right">
													<h:commandLink action="#{ipLevel3Action.exportIpLevel3}">
														<img src="../images/excel-icon-export.png" width="30" height="30" border="0">&nbsp;
													</h:commandLink>
												</td>
											</tr>
											<tr>
												<td>
													<rich:panel id="groupSearchResult">				 			
												 		<h:panelGroup style="width:100%">
															<rich:dataTable binding="#{ipLevel3Bean.ipInfoDataTable}"
																width="100%" id="IPDataTable" cellpadding="1" cellspacing="0" border="0"
																var="detail" value="#{ipLevel3Bean.ipInfoList}" reRender="scrollIPDetailTable" 
																rowClasses="odd,even" rows="256"
																styleClass="contentform" rowKeyVar="rowIndex" 
																headerClass="tableHeader">
															<rich:column styleClass="valignTop" style="width:25px;">
																<f:facet name="header">
																	<h:selectBooleanCheckbox id="checkAll" value="#{ipLevel3Bean.checkAll}" onclick="validateCheckbox('ALL',this,this,'checkBox','')">
																		<a4j:support disabled="true" event="onclick" action="#{ipLevel3Action.checkAll}" reRender="errorMsg,groupSearchResult"/>
																	</h:selectBooleanCheckbox>
																</f:facet>
																<div align="center">
								          						    <h:selectBooleanCheckbox id="checkBox" value="#{detail.rowCheck}" onclick="validateCheckbox('N',document.getElementById('DetailForm:IPDataTable:checkAll'),this,'checkBox','')"/>
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn1}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.ipAddress,ipLevel3Bean.filterSIP003View.filterColumn1)}"  styleClass="valignTop" sortBy="#{detail.ipAddress}">
																<f:facet name="header">
																	<h:panelGroup>
																	   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
																		 <span class="contentform tableHeaderText">
																			<strong>IP Address</strong></span>
																			<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn1}" />
																			<f:param name="sortColumnNo" value="1" />
																			<f:param name="TablSort" value="IPDataTable1" />
																	  </h:commandLink><br/>
																	 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn1}" style="width: 50px;">
																		 <a4j:support event="onblur" reRender="IPDataTable" />
																	 </h:inputText>
																 </h:panelGroup>
																</f:facet>
																<div align="center">
								          						   <a4j:commandLink action="#{ipLevel3Action.popupDetail}" value="#{detail.ipAddress}" styleClass="contentform" reRender="errorMsg,popupUpdateIP">
								          						   		<f:param name="rowIndex" value="#{rowIndex}"/>
								          						   		<rich:componentControl for="popupUpdateIP" operation="#{!errorMessages?'show':'hide'}" event="oncomplete" />
								          						   </a4j:commandLink>
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn10}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn10}"  filterExpression="#{fn:containsIgnoreCase(detail.vlanId,ipLevel3Bean.filterSIP003View.filterColumn10)}"  styleClass="valignTop" sortBy="#{detail.vlanId}">
																<f:facet name="header">
																	<h:panelGroup>
																	   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
																		 <span class="contentform tableHeaderText">
																			<strong>VLAN</strong></span>
																			<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn10}" />
																			<f:param name="sortColumnNo" value="10" />
																			<f:param name="TablSort" value="IPDataTable1" />
																	  </h:commandLink><br/>
																	 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn10}" style="width: 50px;">
																		 <a4j:support event="onblur" reRender="IPDataTable" />
																	 </h:inputText>
																 </h:panelGroup>
																</f:facet>
																<div align="center">
								          						   <h:outputText value="#{detail.vlanId}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>
															
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn2}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.statusName,ipLevel3Bean.filterSIP003View.filterColumn2)}"  styleClass="valignTop" sortBy="#{detail.statusName}">
																<f:facet name="header">
																<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>IP Status</strong></span>
				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="IPDataTable1" />
		  </h:commandLink><br/>
		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																
																</f:facet>
																<div align="center">
									          						<h:outputText value="#{detail.statusName}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>															
															<rich:column styleClass="valignTop" sortBy="#{detail.expiredDate}">
																<f:facet name="header">
																	<h:outputText value="Expire Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
																</f:facet>
																<div align="center">
									          						 <h:outputText value="#{detail.expiredDate}" styleClass="contentform">
									          						 	<f:convertDateTime pattern="dd/MM/yyyy"/>
									          						 </h:outputText> 
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn3}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.hostName,ipLevel3Bean.filterSIP003View.filterColumn3)}" styleClass="valignTop" sortBy="#{detail.hostName}" >
																<f:facet name="header">
																<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Host Name</strong></span>
				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="IPDataTable1" />
		  </h:commandLink><br/>
		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																
																
																</f:facet>
																<div>
									          						<h:outputText value="#{detail.hostName}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn4}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.systemName,ipLevel3Bean.filterSIP003View.filterColumn4)}"  styleClass="valignTop" sortBy="#{detail.systemName}" >
																<f:facet name="header">
															<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>System Name</strong></span>
				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="IPDataTable1" />
		  </h:commandLink><br/>
		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																</f:facet>
																<div align="left">
									          						<h:outputText value="#{detail.systemName}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn5}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.ipSubmask,ipLevel3Bean.filterSIP003View.filterColumn5)}"   styleClass="valignTop" sortBy="#{detail.ipSubmask}" >
																<f:facet name="header">
																	<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Mask</strong></span>
				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn5}" />
				<f:param name="sortColumnNo" value="5" />
				<f:param name="TablSort" value="IPDataTable1" />
		  </h:commandLink><br/>
		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																</f:facet>
																<div>
									          						<h:outputText value="#{detail.ipSubmask}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn6}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.gateway,ipLevel3Bean.filterSIP003View.filterColumn6)}"   styleClass="valignTop" sortBy="#{detail.gateway}" >
																<f:facet name="header">
																	<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Gateway</strong></span>
				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn6}" />
				<f:param name="sortColumnNo" value="6" />
				<f:param name="TablSort" value="IPDataTable1" />
		  </h:commandLink><br/>
		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																
																</f:facet>
																<div align="center">
									          						<h:outputText value="#{detail.gateway}" styleClass="contentform"></h:outputText>
																</div>
															</rich:column>
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn7}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(detail.systemOwnerName,ipLevel3Bean.filterSIP003View.filterColumn7)}"   styleClass="valignTop" sortBy="#{detail.systemOwnerName}" >
																<f:facet name="header">
																<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>System Owner Name</strong></span>
				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn7}" />
				<f:param name="sortColumnNo" value="7" />
				<f:param name="TablSort" value="IPDataTable1" />
		  </h:commandLink><br/>
		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
																
																</f:facet>
																<div align="left">
									          						<h:outputText value="#{detail.systemOwnerName}" styleClass="contentform"></h:outputText>
																</div>											
															</rich:column>
															//ADD NAT IP
															<rich:column  selfSorted="false" sortOrder="#{ipLevel3Bean.sortSIP003View.sortColumn11}" filterValue="#{ipLevel3Bean.filterSIP003View.filterColumn11}"  filterExpression="#{fn:containsIgnoreCase(detail.natIp,ipLevel3Bean.filterSIP003View.filterColumn11)}"   styleClass="valignTop" sortBy="#{detail.natIp}" >
																<f:facet name="header">
																<h:panelGroup>
																		   <h:commandLink rendered="true" action="#{ipLevel3Action.indexSort}">
																			 <span class="contentform tableHeaderText">
																				<strong>NAT IP</strong></span>
																				<f:param name="sortColumn" value="#{ipLevel3Bean.sortSIP003View.sortColumn11}" />
																				<f:param name="sortColumnNo" value="7" />
																				<f:param name="TablSort" value="IPDataTable1" />
																		  </h:commandLink><br/>
																		 <h:inputText value="#{ipLevel3Bean.filterSIP003View.filterColumn11}" style="width: 50px;">
																			 <a4j:support event="onblur" reRender="IPDataTable" />
																		 </h:inputText>
																 </h:panelGroup>
																
																</f:facet>
																<div align="left">
									          						<h:outputText value="#{detail.natIp}" styleClass="contentform"></h:outputText>
																</div>											
															</rich:column>
															<f:facet name="footer"> 
																<rich:columnGroup>
																	<rich:column colspan="11">
																		<h:panelGroup style="float:left;">
																			Total : <h:outputText value="#{fn:length(ipLevel3Bean.ipInfoList)}" /> records
																		</h:panelGroup>
																		<h:panelGroup style="float:right;">
																			<rich:datascroller immediate="true" rendered="true" align="right" for="IPDataTable"
																				maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" 
																				stepControls="hide" fastControls="auto" boundaryControls="auto" 
																				style="background-color: #cccccc;" fastStep="#{ipfmConfigBean.fastStepPage}">
																			   	  	
																			</rich:datascroller>
																		</h:panelGroup>
																	</rich:column>
																</rich:columnGroup>					
															</f:facet>
														</rich:dataTable>&nbsp;
														<div align="right" > 
															<rich:spacer width="10" />	
															<a4j:commandButton  value="Import Update" styleClass="rich-button" action="#{ipLevel3Action.gotoImportUpdte}" />
															<rich:spacer width="10" />
															<a4j:commandButton  value="Update Info" styleClass="rich-button" action="#{ipLevel3Action.popupExpireDate}" 
																rendered="#{not empty ipLevel3Bean.ipInfoList}" reRender="errorMsg, setExpireDateModal" >
																<rich:componentControl for="setExpireDateModal" operation="#{errorMessages ? '' : 'show'}" event="oncomplete" />
															</a4j:commandButton>
															<rich:spacer width="10" />
															<a4j:commandButton  value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}"  />
														</div>	
													</h:panelGroup>
												</rich:panel>
											</td>
										</tr>
										</table>				
									</h:panelGroup>
								</rich:panel>
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
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>	
	<jsp:directive.include file="popup/IPSIP003_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSIP003_UPDATE_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSIP003_POPUP1.jsp"/>
	
</f:view>
</body>
</html>
