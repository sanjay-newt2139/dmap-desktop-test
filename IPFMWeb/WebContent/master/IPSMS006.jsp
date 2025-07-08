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
	.rich-filter-input {width:80px;}
</style>
</head>
<body style="overflow:hidden;">
<f:view>
	<f:loadBundle basename="th.co.ais.ipfm.resource.confirm_message" var="mes"/>
	<f:subview id="menu">
		<jsp:include page="../home/menu.jsp" />					
	</f:subview>
	<f:subview id="error">
		<jsp:include page="../home/errorModal.jsp" />
	</f:subview>
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">
				<tr>
					<td width="80%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<table width="97%" border="0" cellpadding="1" cellspacing="1"
						bgcolor="#CCCCCC" class="thtext_detail2">
						<tr>
							<td height="25" background="../images/title_bar.png" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Firewall Service Port Management</span></strong></td>
						</tr>
						<tr>
							<td>
								<a4j:form id="CriteriaForm">
								 <rich:panel id="groupSearchCriteria" >	
									<table width="97%" border="0" class="thtext_detail">
										
										<h:panelGroup rendered="#{masterTableBean.displayOther}">
											<tr class="inputRow">
												<td class="labelStyle" height="25" ><strong>Display Name<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="displayName" value="#{masterTableBean.masterTBL.shortDesc}" style="width:300px" readonly="#{masterTableBean.disabledForEdit}"></h:inputText>&nbsp;
	                                                 <h:graphicImage value="../images/icon_required.gif" style="border:0" />
														<h:outputText value="แสดงค่าบนหน้าจอ" style="color:#0000FF;">
													 </h:outputText>
												</td>
											</tr>											
										</h:panelGroup>
										<h:panelGroup rendered="#{masterTableBean.displayService}">
											<tr class="inputRow">
												<td class="labelStyle" height="25" ><strong>Service Name<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="serviceName" value="#{masterTableBean.masterTBL.shortDesc}" style="width:300px" readonly="#{masterTableBean.disabledForEdit}"></h:inputText>&nbsp;
	                                                 <h:graphicImage value="../images/icon_required.gif" style="border:0" />
														<h:outputText value="แสดงค่าบนหน้าจอ" style="color:#0000FF;">
													 </h:outputText>
												</td>
											</tr>											
										</h:panelGroup>
										<h:panelGroup rendered="#{masterTableBean.displayOther && !masterTableBean.displayNews && !masterTableBean.displayLogo && !masterTableBean.displayHolidays && !masterTableBean.displayService }">
										
											<tr class="inputRow">
												<td class="labelStyle" height="25"><strong>Description&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="desc" value="#{masterTableBean.masterTBL.refDesc}" style="width:300px"></h:inputText>
												</td>
											</tr>
										</h:panelGroup>
										<h:panelGroup rendered="#{masterTableBean.displayHolidays}">
											<tr class="inputRow">
												<td class="labelStyle" height="25" ><strong>Date<h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong></td>
												<td align="center" >
	                                                 <rich:calendar value="#{masterTableBean.masterTBL.holidayDate}" 
										                        locale="en/US"
										                        popup="true"
										                        datePattern="dd/MM/yyyy"
										                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
										                        inputStyle="background-color:white"
										                        inputSize="17"
										                        direction="auto"/>&nbsp;
												</td>
											</tr>
											<tr class="inputRow">
												<td class="labelStyle" height="25"><strong>Description&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="descHoliday" value="#{masterTableBean.masterTBL.refDesc}" style="width:300px"></h:inputText>
												</td>
											</tr>
										</h:panelGroup>
										<h:panelGroup rendered="#{masterTableBean.displayService}">											
											<tr class="inputRow">
												<td class="labelStyle" height="25"><strong>TCP&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="tcp" value="#{masterTableBean.masterTBL.tcp}" style="width:300px"></h:inputText>
												</td>
											</tr>
											<tr class="inputRow">
												<td class="labelStyle" height="25"><strong>UDP&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="udp" value="#{masterTableBean.masterTBL.udp}" style="width:300px"></h:inputText>
												</td>
											</tr>
											<tr class="inputRow">
												<td class="labelStyle" height="25"><strong>Other&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputText id="other" value="#{masterTableBean.masterTBL.other}" style="width:300px"></h:inputText>
												</td>
											</tr>
										</h:panelGroup>
										<h:panelGroup rendered="#{masterTableBean.displayNews}">
											<tr class="inputRow">
												<td class="labelStyle" height="25" valign="top"><strong>News&nbsp;:&nbsp;</strong></td>
												<td align="left" >
	                                                 <h:inputTextarea id="newsDesc" value="#{masterTableBean.masterTBL.refDesc}" 
	                                                 	style="width:300px" rows="3">
	                                                 </h:inputTextarea>&nbsp;
	                                                 <h:graphicImage value="../images/icon_required.gif" style="border:0" />
														<h:outputText value="ไม่เกิน 1000 ตัวอักษร" style="color:#0000FF;">
													 </h:outputText>
												</td>
											</tr>
										</h:panelGroup>
										<h:panelGroup rendered="#{masterTableBean.displayLogo}">
											<tr class="inputRow" >
												<td class="labelStyle" height="25" valign="top" >
													<strong>File Name&nbsp;:&nbsp;</strong><br/><br/><br/><br/><br/>
													<p>
													<h:outputText value="*.jpg, *.gif, *.png" style="color:#0000FF;" styleClass="valignBottum"/><br/>
													<h:outputText value="140*140 pixel ไม่เกิน 10k" style="color:#0000FF;" styleClass="valignBottum"/></p>
												</td>		
												<td align="left" >
													 <rich:fileUpload fileUploadListener="#{firewallServiceAction.listener}"
									             			maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
									             			id="impRouting" 
									             			clearControlLabel=""
								                            cancelEntryControlLabel=""
								                            addControlLabel="Browse"
									             			immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
									             			acceptedTypes="#{systemParameterFileUploadBean.acceptedTypesImg}" 
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
									             			listHeight="70" autoclear="true"
									             			listWidth="100%" onuploadcomplete="showresult();">
									         			</rich:fileUpload>
												</td>
											</tr>
										</h:panelGroup>
										<h:panelGroup rendered="#{!masterTableBean.displayLogo}">
										<tr>
										   <td align="left" colspan="3">
										   		<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" 
										   			action="#{firewallServiceAction.createMasterTBL}" 
										   			reRender="CriteriaForm,errorMsg"
										   			rendered="#{masterTableBean.displayForCreate}" />
													<rich:spacer width="10" rendered="#{masterTableBean.displayForCreate}"/>
										      	<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
										      		action="#{firewallServiceAction.updateMasterTBL}" 
										      		reRender="CriteriaForm,errorMsg"
										      		rendered="#{masterTableBean.displayForEdit}">
													</a4j:commandButton>
													<rich:spacer width="10"/>
										      	<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" 
										      		actionListener="#{firewallServiceAction.cancel}" reRender="CriteriaForm"
										      		rendered="#{masterTableBean.displayForEdit}" />
										  </td>
										</tr>
										</h:panelGroup>
									</table>
                                  </rich:panel>	
									<rich:spacer height="10" />
									<h:panelGroup  id="resultPanel">
									<rich:panel rendered="#{!masterTableBean.displayNews && !masterTableBean.displayLogo}">	
										<rich:dataTable width="100%" id="masterTable" cellpadding="1" cellspacing="0" border="0"
											var="masterTbl" value="#{masterTableBean.masterTBLList}" reRender="scrollMasterTable" rows="20"
											  
											 
											rowClasses="odd,even" 
											styleClass="contentform" rowKeyVar="index" 
											headerClass="tableHeader">
												<rich:column width="5%">
													<f:facet name="header">
														<h:outputText value="Edit" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
                                                          <a4j:commandButton id="btnUpd" value="Update" 
															image="../images/p_edit.gif" style="height: 15; width: 15" 
															reRender="groupSearchCriteria"
															actionListener="#{firewallServiceAction.editProperty}">
															<a4j:actionparam name="rowId" value="#{masterTbl.rowId}"/>
						          						  </a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column width="5%">
													<f:facet name="header">
														<h:outputText value="Delete" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
														<a4j:commandButton id="btnDel" value="Delete" 
															image="../images/p_delete.gif" style="height: 15; width: 15"
															action="#{firewallServiceAction.updateValueBeforeDelete}"
															oncomplete="#{rich:component('confirmDialog')}.show();">
															<a4j:actionparam name="rowId" value="#{masterTbl.rowId}"/>
															<a4j:actionparam name="refTable" value="#{masterTbl.id.refTable}"/>
															<a4j:actionparam name="shortDesc" value="#{masterTbl.shortDesc}"/>
						          						</a4j:commandButton>
				          							</div>
												</rich:column>
												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.id.refTable,masterTableBean.filter006.filterColumn1)}"   width="15%">
													<f:facet name="header">													
														   <h:panelGroup>
		 	<h:outputText value="Master Setup Table" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="center">
	                                                      <h:outputText value="#{masterTbl.id.refTable}" styleClass="contentform" />
				          							</div>
												</rich:column>

												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.shortDesc,masterTableBean.filter006.filterColumn2)}"   width="15%"  rendered="#{masterTableBean.displayOther}">
													<f:facet name="header">														
														 <h:panelGroup>
		 	<h:outputText value="Display Name" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="left">
	                                                    <h:outputText value="#{masterTbl.shortDesc}" styleClass="contentform" />
				          							</div>
												</rich:column>
												<rich:column width="15%"  rendered="#{masterTableBean.displayHolidays}">
													<f:facet name="header">
														<h:outputText value="Date" styleClass="contentform tableHeaderText" />
													</f:facet>
													<div align="center">
	                                                    <h:outputText value="#{masterTbl.holidayDate}" styleClass="contentform">
															<f:convertDateTime pattern="dd/MM/yyyy"/>
														</h:outputText>
				          							</div>
												</rich:column>													
												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.shortDesc,masterTableBean.filter006.filterColumn3)}"   width="20%" rendered="#{masterTableBean.displayService}">
													<f:facet name="header">														
														 <h:panelGroup>
		 	<h:outputText value="Service Name" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="left">
	                                                    <h:outputText value="#{masterTbl.shortDesc}" styleClass="contentform" />
				          							</div>
												</rich:column>														
												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.tcp,masterTableBean.filter006.filterColumn4)}"   width="20%" rendered="#{masterTableBean.displayService}">
													<f:facet name="header">													
														 <h:panelGroup>
		<h:outputText value="TCP" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="left">
	                                                    <h:outputText value="#{masterTbl.tcp}" styleClass="contentform" />
				          							</div>
												</rich:column>														
												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn5}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.udp,masterTableBean.filter006.filterColumn5)}"   width="20%" rendered="#{masterTableBean.displayService}">
													<f:facet name="header">
														 <h:panelGroup>
		<h:outputText value="UDP" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn5}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="left">
	                                                    <h:outputText value="#{masterTbl.udp}" styleClass="contentform" />
				          							</div>
												</rich:column>															
												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn6}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.other,masterTableBean.filter006.filterColumn6)}"   width="20%" rendered="#{masterTableBean.displayService}">
													<f:facet name="header">
														 <h:panelGroup>
		<h:outputText value="Other" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn6}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="left">
	                                                    <h:outputText value="#{masterTbl.other}" styleClass="contentform" />
				          							</div>
												</rich:column>												
												<rich:column  filterValue="#{masterTableBean.filter006.filterColumn7}"  filterExpression="#{fn:containsIgnoreCase(masterTbl.refDesc,masterTableBean.filter006.filterColumn7)}"   width="50%" rendered="#{!masterTableBean.displayService}">
													<f:facet name="header">
														 <h:panelGroup>
		<h:outputText value="Description" styleClass="contentform tableHeaderText" />
		 <h:inputText value="#{masterTableBean.filter006.filterColumn7}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="masterTable" />
		 </h:inputText>
	 </h:panelGroup>
													</f:facet>
													<div align="left">
	                                                    <h:outputText value="#{masterTbl.refDesc}" styleClass="contentform" />
				          							</div>
												</rich:column>	
											<f:facet name="footer">
												<rich:columnGroup>
													<rich:column colspan="3">
														Total : <h:outputText value="#{ fn:length(masterTableBean.masterTBLList) }" /> records
													</rich:column>
													<rich:column colspan="8">
														<rich:datascroller immediate="true" rendered="true" align="right" for="masterTable"
															maxPages="#{masterTableBean.maxPage}" id="scrollMasterTable" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="hide" boundaryControls="hide" 
															style="background-color: #cccccc;"/>
													</rich:column>
												</rich:columnGroup>
										  </f:facet>
											</rich:dataTable>	
										</rich:panel>	
										</h:panelGroup>										
									</a4j:form>
								</td>
							</tr>
						</table>
						<br>
						<br>
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
	
	<rich:modalPanel id="confirmDialog" width="350" height="110">			
		   <f:facet name="header">
			  <h:panelGroup><h:outputText value="Delete Master Table"/></h:panelGroup>
		   </f:facet>
		   <a4j:form id="delConfirmDialog">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:outputText style="font-weight:bold;" value="#{mes.CF0013}" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:panelGroup>
								<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" 
									action="#{masterTableAction.delete}" reRender="CriteriaForm,errorMsg" >
									<rich:componentControl for="confirmDialog"  operation="hide" event="onclick"  />
								</a4j:commandButton>&nbsp;					
								<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
								    <rich:componentControl for="confirmDialog" operation="hide" event="onclick" />
								</a4j:commandButton>
							</h:panelGroup>
						</h:panelGrid>
					</td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>
		
</f:view>
</body>
</html>
