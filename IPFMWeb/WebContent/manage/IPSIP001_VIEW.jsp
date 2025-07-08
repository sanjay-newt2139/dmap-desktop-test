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
	.rowHeight {height: 25px;}
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
                             <td height="25" bgcolor="#1f4986" align="left" valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span class="style9">Manage IP Level 1</span></strong></td>
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
														value="#{ipLevel1Bean.ipVersion}" width="40">
														<f:selectItem itemLabel="4" itemValue="4"/>                                        
														<a4j:support event="onselect" reRender="panelGrop"></a4j:support>
			                                        </rich:comboBox>
			                                        <h:outputText value="#{ipLevel1Bean.ipVersion}" rendered="false"></h:outputText>
												</h:panelGrid>																									
											</td>
											<td class="labelStyle" >IP Address <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
									        <td>
												<h:panelGroup id="rangeIpGroup" rendered="true">
													<rich:spacer width="10"></rich:spacer>
									   				<h:inputText id="ipDigit1" value="#{ipLevel1Bean.searchIp1}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit2',this,event,0,255,'190')"
													 	onblur="this.value = isNumber(this);" />
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
			                                        <h:inputText id="ipDigit2" value="#{ipLevel1Bean.searchIp2}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit3',this,event,0,255,'190')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
                                        			<h:inputText id="ipDigit3" value="#{ipLevel1Bean.searchIp3}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:ipDigit4',this,event,0,255,'190')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false"/>
													<h:inputText id="ipDigit4" value="#{ipLevel1Bean.searchIp4}" size="1" style="text-align:center" maxlength="3"  
													 	onkeypress="return numbersonlyNoDot(event);"
													 	onkeyup="return keyRangeNumberWithDot('DetailForm:searchMask',this,event,0,255,'191')"
													 	onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false" rendered="#{ipLevel1Bean.ipVersion=='6'}"/>
                                        			<h:inputText value="#{ipLevel1Bean.searchIp5}" rendered="#{ipLevel1Bean.ipVersion=='6'}"
										 				size="1" style="text-align:center" maxlength="3" 
										 				onkeypress="return checkIPDegitKey(this,event);" onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;.&nbsp;" style="font-weight: bolder;" escape="false" rendered="#{ipLevel1Bean.ipVersion=='6'}"/>
													<h:inputText value="#{ipLevel1Bean.searchIp6}" rendered="#{ipLevel1Bean.ipVersion=='6'}"
										 				size="1" style="text-align:center" maxlength="3" onkeypress="return checkIPDegitKey(this,event);" 
										 				onblur="this.value = isNumber(this);"/>
													<h:outputText value="&nbsp;/&nbsp;" style="font-weight: bolder;" escape="false"/>
													<h:inputText id="searchMask" value="#{ipLevel1Bean.searchMask}" size="1" style="text-align:center" maxlength="2" 
																onkeypress="return numbersonlyNoDot(event);" 
																onkeyup="enterSubmit('DetailForm:btnQuery',event)"
																onblur="this.value = isNumber(this);"/>
													<rich:spacer width="10" />												
													<a4j:commandButton id="btnQuery"  value="Search" styleClass="rich-button" action="#{ipLevel1Action.searchIP}" reRender="errorMsg,btnQuery,groupSearchResult" onclick="this.disabled='disabled';"/>&nbsp;
													<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{ipLevel1Action.reset}" reRender="errorMsg,DetailForm"/>&nbsp;
													<rich:hotKey key="return" handler="#{rich:element('btnQuery')}.click()" selector="#ipDigit1,#ipDigit2,#ipDigit3,#ipDigit4,#searchMask"/>
											</h:panelGroup>	
											<h:panelGroup rendered="false">	
												<h:panelGrid columns="14" border="1" cellpadding="0" cellspacing="0">
													<rich:spacer width="10"></rich:spacer>
									   				<h:outputText value="#{ipLevel1Bean.searchIp1}" />
													<h:outputText value="."/>
			                                        <h:outputText value="#{ipLevel1Bean.searchIp2}" />
													<h:outputText value="."/>
	                                       			<h:outputText value="#{ipLevel1Bean.searchIp3}" />
													<h:outputText value="."/>
													<h:outputText value="#{ipLevel1Bean.searchIp4}" />
													<h:outputText value="." rendered="#{ipLevel1Bean.ipVersion=='6'}"/>
	                                       			<h:outputText value="#{ipLevel1Bean.searchIp5}" rendered="#{ipLevel1Bean.ipVersion=='6'}"/>
													<h:outputText value="." rendered="#{ipLevel1Bean.ipVersion=='6'}"/>
													<h:outputText value="#{ipLevel1Bean.searchIp6}" rendered="#{ipLevel1Bean.ipVersion=='6'}"/>
													<h:outputText value=" / "/>
													<h:outputText value="#{ipLevel1Bean.searchMask}" />
													<rich:spacer width="15" />												
													<a4j:commandButton value="Search" styleClass="rich-button" action="#{ipLevel1Action.searchIP}" reRender="panelGrop,groupSearchResult" disabled="true"/>
													<rich:spacer width="5" />
													<a4j:commandButton value="Reset" styleClass="rich-button" action="#{ipLevel1Action.init}" reRender="panelGrop,groupSearchResult"/>
												</h:panelGrid>	
											</h:panelGroup>																													
										</td>														
                                  	</tr>                                     
								</table>
							</rich:panel>
							<rich:spacer height="5" />	
							<rich:panel id="groupSearchResult" style="width:100%;" >				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable id="IPDataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
										binding="#{ipLevel1Bean.ipLevel1DataTable}"
										var="detail" value="#{ipLevel1Bean.ipLevel1List}" reRender="scrollIPDetailTable" 
										rows="#{ipfmConfigBean.rowPerPage}"
										rowClasses="odd,even" styleClass="contentform" rowKeyVar="rowIndex"  headerClass="tableHeader">
									<f:facet name="header">
										<rich:columnGroup>
											<rich:column colspan="3"></rich:column>
											<rich:column colspan="2">
						                		<h:outputText value="Assign To Planning"></h:outputText>
						                	</rich:column>
						                </rich:columnGroup>
						            </f:facet>
									
									<rich:column styleClass="valignTop" style="width:5%">
										<f:facet name="header">
											<h:outputText value="Edit" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
											<a4j:commandLink rendered="#{detail.totalT2Assign == 0}" id="btnUpd" style="height: 15; width: 15" action="#{ipLevel1Action.popupDetail}" reRender="popupUpdateIP">
												<h:graphicImage value="../images/p_edit.gif" alt="Update" style="border:none;" />
												<a4j:actionparam name="rowIndex" value="#{rowIndex}"/> 
												<rich:componentControl for="popupUpdateIP" operation="show" event="oncomplete" />
			          						</a4j:commandLink>
			          						<a4j:commandLink rendered="#{detail.totalT2Assign > 0}" id="btnUpdLock" style="height: 15; width: 15" action="#{ipLevel1Action.popupDetail}" reRender="popupUpdateIP">
			          							<h:graphicImage value="../images/page_lock.gif" alt="Update" style="border:none;" />
												<a4j:actionparam name="rowIndex" value="#{rowIndex}"/>
												<rich:componentControl for="popupUpdateIP" operation="show" event="oncomplete" />
			          						</a4j:commandLink>
										</div>
									</rich:column>
									<rich:column 
									  selfSorted="false" sortOrder="#{ipLevel1Bean.sortSIP001View.sortColumn6}" 
									  filterValue="#{ipLevel1Bean.filterSIP001View.filterColumn6}"  
									  filterExpression="#{fn:containsIgnoreCase(detail.level1Start,ipLevel1Bean.filterSIP001View.filterColumn6)}" 
									 styleClass="valignTop" style="width:25%" sortBy="#{detail.level1Start} - #{detail.level1End}">
									<f:facet name="header">											
												<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel1Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Range IP</strong></span>
				<f:param name="sortColumn" value="#{ipLevel1Bean.sortSIP001View.sortColumn6}" />
				<f:param name="sortColumnNo" value="6" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel1Bean.filterSIP001View.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
	 
	 
										</f:facet>
										<div align="center">
		          						   <h:outputText value="#{detail.level1Start} - #{detail.level1End}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column   sortOrder="#{ipLevel1Bean.sortSIP001View.sortColumn5}"   styleClass="valignTop" style="width:15%" sortBy="#{detail.expiredDate}">
										<f:facet name="header">
											<h:outputText value="Expire Date" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						   <h:outputText value="#{detail.expiredDate}" styleClass="contentform">
			          							<f:convertDateTime pattern="dd/MM/yyyy"/> 
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel1Bean.sortSIP001View.sortColumn1}" filterValue="#{ipLevel1Bean.filterSIP001View.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.totalIp,ipLevel1Bean.filterSIP001View.filterColumn1)}"   styleClass="valignTop" style="width:15%" sortBy="#{detail.totalIp}" >
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel1Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Total IP</strong></span>
				<f:param name="sortColumn" value="#{ipLevel1Bean.sortSIP001View.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel1Bean.filterSIP001View.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.totalIp}" styleClass="contentform" style="font-weight:bold;">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel1Bean.sortSIP001View.sortColumn2}" filterValue="#{ipLevel1Bean.filterSIP001View.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.totalT2Assign,ipLevel1Bean.filterSIP001View.filterColumn2)}" styleClass="valignTop" style="width:15%" sortBy="#{detail.totalT2Assign}" >
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel1Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Assign To User</strong></span>
				<f:param name="sortColumn" value="#{ipLevel1Bean.sortSIP001View.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel1Bean.filterSIP001View.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.totalT2Assign}" styleClass="contentform">
			          							<f:convertNumber pattern="#,##0"/>
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  selfSorted="false" sortOrder="#{ipLevel1Bean.sortSIP001View.sortColumn3}" filterValue="#{ipLevel1Bean.filterSIP001View.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.t2Team.teamName,ipLevel1Bean.filterSIP001View.filterColumn3)}"   styleClass="valignTop" rendered="false" style="width:25%" sortBy="#{detail.t2Team.teamName}" >
										<f:facet name="header">
											<h:panelGroup>
		   <h:commandLink rendered="true" action="#{ipLevel1Action.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Planning Team</strong></span>
				<f:param name="sortColumn" value="#{ipLevel1Bean.sortSIP001View.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="IPDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{ipLevel1Bean.filterSIP001View.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="IPDataTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.t2Team.teamName}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
										<rich:column colspan="5">
											<h:panelGroup style="float:left;">
												Total : <h:outputText value="#{fn:length(ipLevel1Bean.ipLevel1List)}" /> records
											</h:panelGroup>
											<h:panelGroup style="float:rightt;">
												<rich:datascroller immediate="true" rendered="true" align="right" for="IPDataTable" page="#{ipLevel1Bean.scrollerPage}"
													maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
													style="background-color: #cccccc;"/>
											</h:panelGroup>												
										</rich:column>
										</rich:columnGroup>		
									</f:facet>
								</rich:dataTable>&nbsp;
								<div style="float:right;">
									<a4j:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
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
	<jsp:directive.include file="popup/IPSIP001_POPUP.jsp"/>

</f:view>
</body>
</html>
