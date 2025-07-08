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
                             <td height="25" background="../images/title_bar.png" align="left"
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
									<tr>
										<td class="labelStyle">IP Address <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>	
								        <td colspan="3" >
								        	<h:panelGroup id="rangeIpGroup" >
								        		<rich:spacer width="10"></rich:spacer>
											
								   				<h:inputText id="stIp1" value="#{rangeIPDataBean.stIp1}"  
													size="1" style="text-align:center" maxlength="3"  
												 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													onchange="numberformat.formatIntegerObject(this)" />
												&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
		                                        <h:inputText id="stIp2" value="#{rangeIPDataBean.stIp2}" 
									 				size="1" style="text-align:center" maxlength="3"  
												 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													onchange="numberformat.formatIntegerObject(this)" />
												&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
                                       			<h:inputText id="stIp3" value="#{rangeIPDataBean.stIp3}"  
									 				size="1" style="text-align:center" maxlength="3"  
												 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													onchange="numberformat.formatIntegerObject(this)" />
												&nbsp;<h:outputText value="." style="font-weight: bolder;" />&nbsp;
												<h:inputText id="stIp4" value="#{rangeIPDataBean.stIp4}"  
									 				size="1" style="text-align:center" maxlength="3"  
												 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													onchange="numberformat.formatIntegerObject(this)" />
												
												&nbsp;<h:outputText value="/" style="font-weight: bolder;" />&nbsp;
												<h:inputText id="edIp1" value="#{rangeIPDataBean.stIp5}" 
												 	size="1" style="text-align:center" maxlength="3"  
												 	onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
													onchange="numberformat.formatIntegerObject(this)" />
												<rich:spacer width="20" />												
												<a4j:commandButton id="btnQuery" value="Search" styleClass="rich-button" action="#{rangeIPDataAction.search}" reRender="panelGrop,groupSearchResult" />&nbsp;
												<a4j:commandButton id="btnClear" value="Reset" styleClass="rich-button" action="#{rangeIPDataAction.init}" reRender="panelGrop,groupSearchResult"/>&nbsp;
											</h:panelGroup>																											
										</td>														
									</tr>                                     
								</table>
							</rich:panel>
							<rich:spacer height="5" />	
							 <rich:panel id="groupSearchResult">				 			
							 	<h:panelGroup style="width:100%">
									<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{rangeIPDataBean.ipRangeList}" reRender="scrollIPDetailTable"
										  
										 
										rowClasses="odd,even" rows="#{rangeIPDataBean.rowPerPage}"
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
									
									<rich:column styleClass="valignTop" style="width:40px;" >
										<f:facet name="header">
											<h:outputText value="Edit" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
		          						    <a4j:commandButton id="btnUpd" value="Update" image="../images/p_edit.gif" style="height: 15; width: 15" action="#{rangeIPDataAction.action_edit}">
												<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
			          						</a4j:commandButton>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPDataBean.filterIpUrs013.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.stIp1,rangeIPDataBean.filterIpUrs013.filterColumn1)}"  styleClass="valignTop"  selfSorted="false" sortOrder="#{rangeIPDataBean.sortIpUrs013.sortColumn1}" sortBy="#{detail.stIp1}">
										<f:facet name="header">										
											   <h:panelGroup>
		 	    <h:commandLink rendered="true" action="#{rangeIPDataAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Range IP</strong></span>
				<f:param name="sortColumn" value="#{rangeIPDataBean.sortIpUrs013.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPDataBean.filterIpUrs013.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
											<a4j:commandLink value="#{detail.stIp1}" styleClass="contentform" >
		          						   		<a4j:actionparam name="rowId" value="#{detail.rowId}"/>
		          						   		<rich:componentControl for="popupUpdateRangeIP" operation="show" event="onclick" />
		          						    </a4j:commandLink>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPDataBean.filterIpUrs013.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.strTotalIP,rangeIPDataBean.filterIpUrs013.filterColumn2)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{rangeIPDataBean.sortIpUrs013.sortColumn2}" sortBy="#{detail.strTotalIP}" >
										<f:facet name="header">											
											 <h:panelGroup>
		 	  <h:commandLink rendered="true" action="#{rangeIPDataAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>TOTAL</strong></span>
				<f:param name="sortColumn" value="#{rangeIPDataBean.sortIpUrs013.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPDataBean.filterIpUrs013.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.strTotalIP}" styleClass="contentform">
			          						</h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPDataBean.filterIpUrs013.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.assignToPlanning,rangeIPDataBean.filterIpUrs013.filterColumn3)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{rangeIPDataBean.sortIpUrs013.sortColumn3}" sortBy="#{detail.assignToPlanning}" >
										<f:facet name="header">											
											 <h:panelGroup>
		 	 <h:commandLink rendered="true" action="#{rangeIPDataAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Available</strong></span>
				<f:param name="sortColumn" value="#{rangeIPDataBean.sortIpUrs013.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPDataBean.filterIpUrs013.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.assignToPlanning}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPDataBean.filterIpUrs013.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.assignToUser,rangeIPDataBean.filterIpUrs013.filterColumn4)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{rangeIPDataBean.sortIpUrs013.sortColumn4}" sortBy="#{detail.assignToUser}" >
										<f:facet name="header">											
											 <h:panelGroup>
		 	 <h:commandLink rendered="true" action="#{rangeIPDataAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Assign</strong></span>
				<f:param name="sortColumn" value="#{rangeIPDataBean.sortIpUrs013.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{rangeIPDataBean.filterIpUrs013.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						<h:outputText value="#{detail.assignToUser}" styleClass="contentform"></h:outputText>
										</div>
									</rich:column>							
									<rich:column  filterValue="#{rangeIPDataBean.filterIpUrs013.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(detail.reserved,rangeIPDataBean.filterIpUrs013.filterColumn5)}"   styleClass="valignTop">
										<f:facet name="header">											
											 <h:panelGroup>
		 	<h:outputText value="Reserved"  escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{rangeIPDataBean.filterIpUrs013.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
		          						    <h:outputText value="#{detail.reserved}" styleClass="contentform"></h:outputText> 
										</div>
									</rich:column>
									<rich:column  filterValue="#{rangeIPDataBean.filterIpUrs013.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(detail.used,rangeIPDataBean.filterIpUrs013.filterColumn6)}"   styleClass="valignTop">
										<f:facet name="header">											
											 <h:panelGroup>
		 	<h:outputText value="Used" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{rangeIPDataBean.filterIpUrs013.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.used}"styleClass="contentform" ></h:outputText>
										</div>
									</rich:column>
									<rich:column styleClass="valignTop">
										<f:facet name="header">
											<h:outputText value="Effective Date" styleClass="contentform tableHeaderText"></h:outputText>
										</f:facet>
										<div align="center">
			          						 <h:outputText value="#{detail.effDate}"styleClass="contentform" ></h:outputText>
										</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="2">
												Total : <h:outputText value="#{fn:length(rangeIPDataBean.ipRangeList)}" /> records
											</rich:column>
											<rich:column colspan="10">
												<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
													maxPages="#{rangeIPDataBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{rangeIPDataBean.fastStepPage}"
													style="background-color: #cccccc;"/>
											</rich:column>
										</rich:columnGroup>					
									</f:facet>
								</rich:dataTable>&nbsp;
								<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td valign="top" width="15%">
												<a4j:commandLink action="#{userReqIPAction.init}">Download Template</a4j:commandLink>
											</td>
											<td>
												 <rich:fileUpload fileUploadListener="#{systemParameterAction.listener}"
								             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
								             			id="impFirewall" 
								             			immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
								             			acceptedTypes="#{systemParameterFileUploadBean.acceptedTypes}" 
								             			allowFlash="#{systemParameterFileUploadBean.useFlash}"
														sizeErrorLabel="File Size Over!" 
								             			sizeErrorLabelClass="contentform"
								             			uploadListClass="contentform"
								             			transferErrorLabelClass="contentform"
								             			styleClass="contentform"
								             			fileEntryClass="contentform"
								             			fileEntryControlClass="contentform"
								             			progressLabelClass="contentform"
								             			addButtonClass="contentform"
								             			uploadButtonClass="contentform"
								             			listHeight="50" autoclear="true"
								             			addControlLabel="Browse"
								             			listWidth="100%" onuploadcomplete="fireClickEvent(document.getElementById('popupModalSubview:formRegionMultiQuery:ImportForm:btnSubmitUpload'));" >
								             			 <a4j:support event="onuploadcomplete"  reRender="groupImportCommand" />
								         			</rich:fileUpload>
											</td>
										</tr>
										<tr><td colspan="2"><rich:spacer height="10"></rich:spacer></td></tr>
									</table>
								<div align="right" > 
									<a4j:commandButton  value="Assign IP" styleClass="rich-button" action="#{rangeIPDataAction.init}" reRender="groupSearchResult"/>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton  value="Cancel" styleClass="rich-button" action="#{rangeIPDataAction.search}" reRender="groupSearchResult" />
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
	<jsp:directive.include file="popup/popupUpdateRangeIP.jsp"/>
</f:view>
</body>
</html>
