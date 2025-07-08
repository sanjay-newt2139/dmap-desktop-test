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
	.rich-filter-input {width:80px;}
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
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Manage IP Level 2</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >
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
			                                        <h:outputText value="#{ipLevel2Bean.ipVersion}" rendered="false"></h:outputText>
												</h:panelGrid>																									
											</td>
											<td class="labelStyle" >IP Address <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
									        <td>
												<h:panelGroup id="rangeIpGroup" rendered="true">
													<rich:spacer width="10"></rich:spacer>
									   				<h:inputText id="ipDigit1" value="#{ipLevel2Bean.searchIp1}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit2',this,event,0,255,'190')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
			                                        <h:inputText id="ipDigit2" value="#{ipLevel2Bean.searchIp2}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit3',this,event,0,255,'190')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
                                        			<h:inputText id="ipDigit3" value="#{ipLevel2Bean.searchIp3}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit4',this,event,0,255,'190')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
													<h:inputText id="ipDigit4" value="#{ipLevel2Bean.searchIp4}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:searchMask',this,event,0,255,'191')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false" rendered="#{ipLevel2Bean.ipVersion=='6'}"/>
                                        			<h:inputText value="#{ipLevel2Bean.searchIp5}" rendered="#{ipLevel2Bean.ipVersion=='6'}"
										 				size="1" style="text-align:center" maxlength="3" onkeypress="return checkIPDegitKey(this,event);" onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false" rendered="#{ipLevel2Bean.ipVersion=='6'}"/>
													<h:inputText value="#{ipLevel2Bean.searchIp6}" rendered="#{ipLevel2Bean.ipVersion=='6'}"
										 				size="1" style="text-align:center" maxlength="3" onkeypress="return checkIPDegitKey(this,event);" onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;/&nbsp;" style="font-weight: bolder;" escape="false"/>
													<h:inputText id="searchMask" value="#{ipLevel2Bean.searchMask}" size="1" style="text-align:center" maxlength="2" 
																onkeypress="return numbersonlyNoDot(event);" onblur="this.value = isNumber(this);"/>
													<rich:spacer width="10" />												
													<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{ipLevel2Action.searchIP}" reRender="#{errorMessages?'errorMsg':'errorMsg,groupSearchResult'}" />&nbsp;
													<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{ipLevel2Action.reset}" reRender="#{errorMessages?'errorMsg':'errorMsg,DetailForm'}"/>&nbsp;
													<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#ipDigit1,#ipDigit2,#ipDigit3,#ipDigit4,#searchMask"/>
											</h:panelGroup>	
											<h:panelGroup rendered="false">	
												<h:panelGrid columns="14" border="1" cellpadding="0" cellspacing="0">
													<rich:spacer width="10"></rich:spacer>
									   				<h:outputText value="#{ipLevel2Bean.searchIp1}" />
													<h:outputText value="."/>
			                                        <h:outputText value="#{ipLevel2Bean.searchIp2}" />
													<h:outputText value="."/>
	                                       			<h:outputText value="#{ipLevel2Bean.searchIp3}" />
													<h:outputText value="."/>
													<h:outputText value="#{ipLevel2Bean.searchIp4}" />
													<h:outputText value="." rendered="#{ipLevel2Bean.ipVersion=='6'}"/>
	                                       			<h:outputText value="#{ipLevel2Bean.searchIp5}" rendered="#{ipLevel2Bean.ipVersion=='6'}"/>
													<h:outputText value="." rendered="#{ipLevel2Bean.ipVersion=='6'}"/>
													<h:outputText value="#{ipLevel2Bean.searchIp6}" rendered="#{ipLevel2Bean.ipVersion=='6'}"/>
													<h:outputText value=" / "/>
													<h:outputText value="#{ipLevel2Bean.searchMask}" />
													<rich:spacer width="15" />												
													<a4j:commandButton value="Search" styleClass="rich-button" action="#{ipLevel2Action.action_search}" reRender="errorMsg,panelGrop,groupSearchResult" disabled="true"/>
													<rich:spacer width="5" />
													<a4j:commandButton value="Reset" styleClass="rich-button" action="#{ipLevel2Action.init}" reRender="errorMsg,panelGrop,groupSearchResult"/>
												</h:panelGrid>	
											</h:panelGroup>																													
										</td>														
                                  	</tr>                                     
								</table>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
										binding="#{ipLevel2Bean.ipLevel2DataTable}"
										var="detail" value="#{ipLevel2Bean.ipLevel2List}" reRender="scrollIPDetailTable"
										rowClasses="odd,even" rows="#{ipfmConfigBean.rowPerPage}"
										styleClass="contentform" rowKeyVar="rowIndex" headerClass="tableHeader">
									
									<rich:column styleClass="valignTop" style="width:40px;">
										<f:facet name="header">
											<h:selectBooleanCheckbox id="checkAll" value="#{ipLevel2Bean.checkAll}" onclick="validateCheckbox('ALL',this,this,'checkBox','');">
												<a4j:support disabled="true" event="onclick" action="#{ipLevel2Action.checkAll}" status="#{rich:component('wait')}.hide();" reRender="errorMsg,groupSearchResult"/>
											</h:selectBooleanCheckbox>
										</f:facet>
										<div align="center">
		          						    <h:selectBooleanCheckbox id="checkBox" onclick="validateCheckbox('N',document.getElementById('DetailForm:ipDetailTable:checkAll'),this,'checkBox','');" value="#{detail.rowCheck}" rendered="#{detail.level2Id!='0'}"/>
										</div>
									</rich:column>
									<rich:column styleClass="valignTop" style="width:40px;">
										<f:facet name="header">
											<h:outputText value="Edit" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						    <a4j:commandLink rendered="#{detail.level2Id!='0' && detail.totalIp == (detail.availableIp+detail.assignIp+detail.terminateIp)}" style="height: 15; width: 15" action="#{ipLevel2Action.popupDetail}" reRender="popupUpdateIP" >
		          						    	<h:graphicImage value="../images/p_edit.gif" alt="Update" style="border:none;" />
		          						    	<a4j:actionparam name="rowIndex" value="#{rowIndex}"/>
												<rich:componentControl for="popupUpdateIP" operation="show" event="oncomplete" />
			          						</a4j:commandLink>
			          						<a4j:commandLink rendered="#{detail.level2Id!='0' && detail.totalIp != (detail.availableIp+detail.assignIp+detail.terminateIp)}" style="height: 15; width: 15" action="#{ipLevel2Action.popupDetail}" reRender="popupUpdateIP">
			          							<h:graphicImage value="../images/page_lock.gif" alt="Update" style="border:none;"/>
												<a4j:actionparam name="rowIndex" value="#{rowIndex}"/>
												<rich:componentControl for="popupUpdateIP" operation="show" event="oncomplete" />
			          						</a4j:commandLink>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn1}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.level2Start,ipLevel2Bean.filterSIP002View.filterColumn1)}"   styleClass="valignTop" sortBy="#{detail.binary2Start} - #{detail.binary2End}">
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Range IP</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.level2Start} - #{detail.level2End}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}"></h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn9}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn9}"  filterExpression="#{fn:containsIgnoreCase(detail.vlanId,ipLevel2Bean.filterSIP002View.filterColumn9)}"   styleClass="valignTop" sortBy="#{detail.vlanId}">
										<f:facet name="header">
											<h:panelGroup>
											   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
												 <span class="contentform tableHeaderText">
													<strong>VLAN</strong></span>
													<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn9}" />
													<f:param name="sortColumnNo" value="9" />
													<f:param name="TablSort" value="ipDetailTable" />
											  </h:commandLink>
											 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn9}" style="width: 50px;">
												 <a4j:support event="onblur" reRender="ipDetailTable" />
											 </h:inputText>
										 </h:panelGroup>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.vlanId}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}"></h:outputText>
										</div>
									</rich:column>
									<rich:column styleClass="valignTop" sortBy="#{detail.expiredDate}" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn8}" >
										<f:facet name="header">
											<h:outputText value="Expire Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
											<h:outputText value="#{detail.expiredDate}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}">
												<f:convertDateTime pattern="dd/MM/yyyy"/>
											</h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn2}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.totalIp,ipLevel2Bean.filterSIP002View.filterColumn2)}"   styleClass="valignTop" sortBy="#{detail.totalIp}" >
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Total</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.totalIp}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}font-weight:bold;">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn3}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.availableIp,ipLevel2Bean.filterSIP002View.filterColumn3)}"   styleClass="valignTop" sortBy="#{detail.availableIp}" >
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Available</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.availableIp}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn4}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.assignIp,ipLevel2Bean.filterSIP002View.filterColumn4)}"   styleClass="valignTop" sortBy="#{detail.assignIp}" >
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Assign To User</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.assignIp}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>	
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn5}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.useIp,ipLevel2Bean.filterSIP002View.filterColumn5)}"   styleClass="valignTop" sortBy="#{detail.useIp}">
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Used</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn5}" />
				<f:param name="sortColumnNo" value="5" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.useIp}"styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>						
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn6}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.reserveIp,ipLevel2Bean.filterSIP002View.filterColumn6)}"   styleClass="valignTop" sortBy="#{detail.reserveIp}">
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Reserved</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn6}" />
				<f:param name="sortColumnNo" value="6" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup> 
	 	</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail.reserveIp}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>									
									<rich:column  selfSorted="false" sortOrder="#{ipLevel2Bean.sortSIP002View.sortColumn7}" filterValue="#{ipLevel2Bean.filterSIP002View.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(detail.terminateIp,ipLevel2Bean.filterSIP002View.filterColumn7)}"   styleClass="valignTop" sortBy="#{detail.terminateIp}">
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel2Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Terminate</strong></span>
				<f:param name="sortColumn" value="#{ipLevel2Bean.sortSIP002View.sortColumn7}" />
				<f:param name="sortColumnNo" value="7" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel2Bean.filterSIP002View.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
	 	</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.terminateIp}" styleClass="contentform" style="#{detail.level2Id=='0'?'color:#0000FF;':''}">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
								           	<rich:column colspan="11">
												<h:panelGroup style="float:left;">
													Total : <h:outputText value="#{fn:length(ipLevel2Bean.ipLevel2List)}" /> records
												</h:panelGroup>
												<h:panelGroup style="float:right;">
												<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable" page="#{ipLevel2Bean.scrollerPage}"
													maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
													style="background-color: #cccccc;"/>
												</h:panelGroup>
											</rich:column>	
										</rich:columnGroup>									
									</f:facet>
								</rich:dataTable>&nbsp;
								<div align="right" > 
									<a4j:commandButton  value="Update Info" styleClass="rich-button" action="#{ipLevel2Action.popupExpireDate}" 
										rendered="#{not empty ipLevel2Bean.ipLevel2List}" reRender="errorMsg, setExpireDateModal" >
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
	<jsp:directive.include file="popup/IPSIP002_POPUP.jsp"/>
	<jsp:directive.include file="popup/IPSIP002_POPUP1.jsp"/>
</f:view>
</body>
</html>
