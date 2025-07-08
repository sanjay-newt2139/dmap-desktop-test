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
	.textAlignRight {text-align:right;}
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
	
	<rich:spacer height="27" rendered="#{userSession.newUser=='N'}"></rich:spacer>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" align="center" valign="top">
				  <a4j:form id="DetailForm">
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">User Profile</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop">
									<h:panelGroup style="width:100%;">
									<table width="100%" border="0" class="thtext_detail">
									
									<tr class="displayRow">
										<td class="labelStyle">User ID :&nbsp;</td>
										<td>
											<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												<rich:spacer width="10"></rich:spacer>
	                                     	   <rich:comboBox id="userId" enableManualInput="true" onblur="if (this.value.length==0) onChangeUserId();"
													itemClass="contentform" itemSelectedClass="contentform" listHeight="150"
													value="#{userProfileBean.userIdComboItem}" width="150"> 
													<f:attribute name="selectItems" value="#{userProfileBean.userIdComboList}"/>
													<f:selectItems value="#{userProfileBean.userIdComboList}"/> 
													<a4j:support reRender="errorMsg,DetailForm, managerDataTable" event="onchange" action="#{userProfileAction.onchngeUsreIdCobo}" />
													<a4j:jsFunction name="onChangeUserId" reRender="errorMsg,DetailForm, managerDataTable" action="#{userProfileAction.onchngeUsreIdCobo}" />
											   </rich:comboBox>		
										   </h:panelGrid>
										 </td>
										<td>&nbsp;</td>
								        <td>											
								        	<div style="float:right;">
												<a4j:commandLink action="#{userProfileAction.updateFromEhr}"  value="Update from e-HR" style="text-decoration:underline;" reRender="panelGrop" >
													<a4j:actionparam name="userId" value="#{userProfileBean.userInfo.userId}"></a4j:actionparam>
												</a4j:commandLink>
			          						</div>
										</td>												
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="User Name :" ></h:outputText>&nbsp;
										</td>	
								        <td>
								        	<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.userName}" ></h:outputText>																								
										</td>
										<td class="labelStyle"  >
											<h:outputText value="Email :"></h:outputText>&nbsp;
										</td>	
								        <td>	
								        	<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.email}" ></h:outputText>																								
										</td>											
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="Department :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.dept}" ></h:outputText>																								
										</td>
										<td class="labelStyle"  >
											<h:outputText value="Section :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.section}"></h:outputText>																								
										</td>											
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="Position :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.position}" ></h:outputText>																								
										</td>
										<td class="labelStyle" >
											<h:outputText value="Team :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.teamName}" ></h:outputText>																								
										</td>											
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="Approve Manager :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="#{userProfileBean.userInfo.managerName}" ></h:outputText>																								
										</td>
										<td colspan="2"></td>											
                                  	</tr>
                                  	<tr class="inputRow">
										<td class="labelStyle">Telephone <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp; </td>	
								        <td>
								        	<rich:spacer width="10"></rich:spacer>
											<h:inputText value="#{userProfileBean.userInfo.tel}" 
											 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											 onblur="this.value = isNumber(this)" />																								
										</td>
										<td class="labelStyle">Mobile <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp; </td>											
								        <td>
								        	<rich:spacer width="10"></rich:spacer>
											<h:inputText value="#{userProfileBean.userInfo.mobile}" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											onblur="this.value = isNumber(this)" >
											</h:inputText>																							
										</td>											
                                 	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"><rich:spacer width="1"/></td>	
								        <td colspan="3">
								        	<rich:spacer width="10"></rich:spacer>
								        	<h:graphicImage value="../images/icon_required.gif" style="border:0" />
											<h:outputText value=" กรอกข้อมูลหมายเลขโทรศัพท์ติดต่อกลับทั้งสองอย่าง หรืออย่างใดอย่างหนึ่ง" style="color:#0000FF;"></h:outputText>																							
										</td>										
                                  	</tr> 
                                  	<tr>
                                  	  <td colspan="4" align="right" >
                                  	      <a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"   action="#{userProfileAction.saveUserProfileByAdmin}" reRender="errorMsg" oncomplete="reloadTree();" />
                                  	  </td>
                                  	</tr>                                              
								</table>
								</h:panelGroup>
							</rich:panel>
							<rich:panel id="panelGrop1"  header="Delegate" rendered="#{userProfileBean.delegateRender}">
								<h:panelGroup style="width:100%;">
								<table width="100%" border="0" class="thtext_detail">
									<tr class="inputRow">
										<td class="labelStyle">
											<h:outputText value="Delegate To :"></h:outputText>&nbsp;
										</td>	
								        <td colspan="3">
								        	<div style="float:left;">
								        		<h:panelGrid columns="7" cellpadding="0" cellspacing="0">
								        			<rich:spacer width="10"></rich:spacer>								
										           <rich:comboBox id="delegate" enableManualInput="true"
														itemClass="contentform" itemSelectedClass="contentform"   listHeight="150"
														value="#{userProfileBean.delegateComboItem}" width="150">
														<f:attribute name="selectItems" value="#{userProfileBean.delegateToList}"/>
														<f:selectItems value="#{userProfileBean.delegateToList}"/>
												   </rich:comboBox>	
			                                        <rich:spacer width="10"></rich:spacer>
			                                        <a4j:commandButton value="Add" image="../images/add1.png" action="#{userProfileAction.addDelegateAdmin}" reRender="errorMsg,managerDataTable" >
			                                        	
			                                        </a4j:commandButton>
			                                    </h:panelGrid>	
			          						</div>																			
										</td>												
                                  </tr>
                                  <tr class="inputRow">
					                 	<td class="labelStyle" ><h:outputText value="Start Date" escape="false"/><h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>
										<td>
											<rich:spacer width="10"></rich:spacer>
											<rich:calendar value="#{userProfileBean.ipDelegateUser.startDate}" 
									                        locale="en/US"
									                        popup="true" 
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
									                        inputStyle="background-color:white;"
									                        inputSize="20"
									                        direction="auto"/>                                       
										</td>	
					             		<td class="labelStyle" ><h:outputText value="End Date" escape="false"/><h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp;</td>
										<td>
											<rich:spacer width="10"></rich:spacer>
											<rich:calendar value="#{userProfileBean.ipDelegateUser.endDate}" 
									                        locale="en/US"
									                        popup="true" 
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
									                        inputStyle="background-color:white;"
									                        inputSize="20"
									                        direction="auto"/>
										</td>	 
					                </tr>                                                      
								</table>
									<rich:dataTable id="managerDataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
											var="detail" value="#{userProfileBean.delegateDataList}"
											  
											 
											rowClasses="odd,even" rows="#{ipfmConfigBean.rowPerPage}"
											styleClass="contentform" rowKeyVar="index" 
											headerClass="tableHeader">
		
										<rich:column styleClass="valignTop" style="width:40px;">
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											 <div align="center">
											  	<a4j:commandButton id="btnUpd" value="Delete" image="../images/contact_blue_remove.png" style="height: 15; width: 15" 
											  	     action="#{userProfileAction.updateValueBeforeDeleteDelegate}"
											  	     oncomplete="#{rich:component('delconfirmDelegate')}.show();">
													<a4j:actionparam name="delegateUserId" value="#{detail.id.delegateUserId}"/> 
				          						</a4j:commandButton>
				          					</div>
										</rich:column>
										<rich:column  filterValue="#{userProfileBean.filter001.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.delegateUser.userName,userProfileBean.filter001.filterColumn1)}"   styleClass="valignTop">
											<f:facet name="header">
												   <h:panelGroup>
		 <h:outputText value="Delegate To" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userProfileBean.filter001.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="managerDataTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
			          						   <h:outputText value="#{detail.delegateUser.userName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column styleClass="valignTop">
											<f:facet name="header">
												<h:outputText value="Start Date" escape="false" styleClass="contentform tableHeaderText">
												</h:outputText>
											</f:facet>
											<div align="center" >
				          						<h:outputText value="#{detail.startDate}" styleClass="contentform">
				          						  <f:convertDateTime pattern="dd/MM/yyyy" />
				          						</h:outputText>
											</div>
										</rich:column>
										<rich:column styleClass="valignTop">
											<f:facet name="header">
												<h:outputText value="End Date" escape="false" styleClass="contentform tableHeaderText">
												</h:outputText>
											</f:facet>
											<div align="center">
				          						<h:outputText value="#{detail.endDate}" styleClass="contentform">
				          						  <f:convertDateTime pattern="dd/MM/yyyy" />
				          						</h:outputText>
											</div>
										</rich:column>
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{fn:length(userProfileBean.delegateDataList)}" /> records
												</rich:column>
												<rich:column colspan="10">
													<rich:datascroller immediate="true" rendered="true" align="right" for="managerDataTable"
														maxPages="#{ipfmConfigBean.maxPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
														style="background-color: #cccccc;"
														
													/>
												</rich:column>
											</rich:columnGroup>					
										</f:facet>										
									</rich:dataTable>
								</h:panelGroup>
							</rich:panel>
							<rich:spacer height="5" />
							
							<rich:panel id="panelGrop2" header="Role"  >
								<h:panelGroup style="width:100%;">
								<table width="100%" border="0" class="thtext_detail">
									<tr class="inputRow">
										<td style="height:0px;"></td>
										<td style="width:10px; height:0px;"></td>
										<td style="height:0px;"></td>
									</tr>
									
									<tr class="inputRow">
										<td class="labelStyle"  >
											<h:outputText value="Role Name :"></h:outputText>&nbsp;
										</td>
										<td style="width:10px;"><rich:spacer width="10"></rich:spacer></td>
								        <td colspan="3">
								        	<rich:comboBox id="roleAll" enableManualInput="true"  rendered="#{userProfileBean.roleAllVisible}"
												itemClass="contentform" itemSelectedClass="contentform" listHeight="150"
												value="#{userProfileBean.roleAllComboItem}" width="150">
												<f:attribute name="selectItems" value="#{userProfileBean.roleAllComboList}"/>
												<f:selectItems value="#{userProfileBean.roleAllComboList}"/>
												<a4j:support reRender="roleDataTable" event="onchange" action="#{userProfileAction.changeComboRole}">
												  <a4j:actionparam name="chk" value="All"></a4j:actionparam>
												</a4j:support>
										   </rich:comboBox>			
										   <rich:comboBox id="role" enableManualInput="true"  rendered="#{userProfileBean.roleVisible}"
												itemClass="contentform" itemSelectedClass="contentform" listHeight="150"
												value="#{userProfileBean.roleComboItem}" width="150">
												<f:attribute name="selectItems" value="#{userProfileBean.roleComboList}"/>
												<f:selectItems value="#{userProfileBean.roleComboList}"/>
												<a4j:support reRender="roleDataTable" event="onchange" action="#{userProfileAction.changeComboRole}" />
										   </rich:comboBox>	
										</td>												
                               		 </tr>
                               		 <tr class="inputRow">
                               		 	<td class="labelStyle"  >
											<h:outputText value="User :" ></h:outputText>&nbsp;
										</td>
										<td style="width:10px;">
											<rich:spacer width="10"></rich:spacer>
										 </td>
								        <td colspan="3">
								        	<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
								        		<rich:comboBox id="user" enableManualInput="true"
														itemClass="contentform" itemSelectedClass="contentform" listHeight="150"
														value="#{userProfileBean.userComboItem}" width="150">
														<f:attribute name="selectItems" value="#{userProfileBean.userComboList}"/>
														<f:selectItems value="#{userProfileBean.userComboList}"/>
												   </rich:comboBox>
		                                        <rich:spacer width="10"></rich:spacer>
		                                        <a4j:commandButton value="Add" image="../images/add1.png"   action="#{userProfileAction.addRoleAdmin}" reRender="errorMsg,panelGrop2,roleDataTable"/>
		                                    </h:panelGrid>	
										</td>
									</tr>		                                                 
								</table>
								
								<table width="100%" border="0" class="thtext_detail">
						<tr><td align="left" valign="top" class="warning-red" >
						<b>หมายเหตุ :</b> ตารางนี้แสดงรายชื่อบุคคลที่มีสิทธิ์ทำงานในแต่ละ Role หากท่านต้องการลบรายชื่อบุคคลใดออกจาก Role ควรพิจารณาและตรวจสอบเสียก่อนว่า บุคคลเหล่านี้  ไม่มีสิทธิ์ทำงานใน Role นั้นแล้วจริง ๆ <u>เท่านั้น</u>
						</td></tr>
						</table>
						
									<rich:dataTable width="100%" id="roleDataTable" cellpadding="1" cellspacing="0" border="0"
										var="detail" value="#{userProfileBean.roleDataList}" reRender="scrollIPDetailTable"
										  
										 
										rowClasses="odd,even" rows="#{ipfmConfigBean.rowPerPage}"
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
	
										<rich:column styleClass="valignTop" width="40" >
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
											</f:facet>
											 <div align="center" >
											  	<a4j:commandButton value="Delete" image="../images/contact_blue_remove.png" style="height: 15px; width: 15px;" 
											  	     action="#{userProfileAction.updateValueBeforeDeleteRole}"
											  	     oncomplete="#{rich:component('delconfirmRole')}.show();">
													<a4j:actionparam name="roleId" value="#{detail.roleId}"/>
													<a4j:actionparam name="userId" value="#{detail.userId}"/>  
													<a4j:actionparam name="userName" value="#{detail.userName}"/>  
				          						</a4j:commandButton>
				          						
				          					</div>
										</rich:column>
										<rich:column  filterValue="#{userProfileBean.filter002.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.userName,userProfileBean.filter002.filterColumn1)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort002.sortColumn1}" sortBy="#{detail.userName}">
											<f:facet name="header">
												   <h:panelGroup>
		  <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>User Name</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort002.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter002.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="roleDataTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
			          						   <h:outputText value="#{detail.userName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column  filterValue="#{userProfileBean.filter002.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.position,userProfileBean.filter002.filterColumn2)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort002.sortColumn2}" sortBy="#{detail.position}">
											<f:facet name="header">
												 <h:panelGroup>
		  <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Position</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort002.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter002.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="roleDataTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
				          						<h:outputText value="#{detail.position}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column  filterValue="#{userProfileBean.filter002.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.ipUser.teamName,userProfileBean.filter002.filterColumn3)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort002.sortColumn3}" sortBy="#{detail.ipUser.teamName}">
											<f:facet name="header">
												 <h:panelGroup>
		  <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Team</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort002.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter002.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="roleDataTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
				          						<h:outputText value="#{detail.ipUser.teamName}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<rich:column  filterValue="#{userProfileBean.filter002.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.dept,userProfileBean.filter002.filterColumn4)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort002.sortColumn4}" sortBy="#{detail.dept}">
											<f:facet name="header">
											<h:panelGroup>
		  <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Department</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort002.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter002.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="roleDataTable" />
		 </h:inputText>
	 </h:panelGroup>
											</f:facet>
											<div>
				          						<h:outputText value="#{detail.dept}" styleClass="contentform"></h:outputText>
											</div>
										</rich:column>
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="2">
													Total : <h:outputText value="#{fn:length(userProfileBean.roleDataList)}" /> records
												</rich:column>
												<rich:column colspan="10">
													<rich:datascroller immediate="true" rendered="true" align="right" for="roleDataTable"
														maxPages="#{ipfmConfigBean.maxPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto"  fastStep="#{ipfmConfigBean.fastStepPage}"
														style="background-color: #cccccc;" />
												</rich:column>
											</rich:columnGroup>					
										</f:facet>
									</rich:dataTable>&nbsp;
									<div style="float:right;">
									<h:commandButton value="Close" styleClass="rich-button" action="#{homepageAction.gotoHomepage}" />
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
	<rich:modalPanel id="delconfirmDelegate" width="350" height="110">			
		   <f:facet name="header">
			  <h:panelGroup>
				<h:outputText value="Delete Delegate"></h:outputText>
			  </h:panelGroup>
		   </f:facet>
		   <a4j:form id="ConfirmDelegateDialog">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="margin:bottom:10px;text-align:center;">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this Delegate To ?" />
						</h:panelGrid>
					</td>
				</tr>
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="margin-bottom:5px;text-align:center;">
							<h:panelGroup>
								<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
									action="#{userProfileAction.deleteDelegate}" reRender="managerDataTable" >
									<rich:componentControl for="delconfirmDelegate"  operation="hide" event="onclick"  />
								</a4j:commandButton>												
								<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
								    <rich:componentControl for="delconfirmDelegate" operation="hide" event="onclick" />
								</a4j:commandButton>
							</h:panelGroup>
						</h:panelGrid>
					</td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>
	
	<rich:modalPanel id="delconfirmRole" width="350" height="110">			
		   <f:facet name="header">
			  <h:panelGroup>
				<h:outputText value="Delete Role"></h:outputText>
			  </h:panelGroup>
		   </f:facet>
		   <a4j:form id="ConfirmRoleDialog">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="margin-bottom:5px;text-align:center;">
							<h:outputText style="font-weight:bold;" value="Do you want to delete this Role ?" />
						</h:panelGrid></td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform" width="100%" style="text-align:center;">
							<h:panelGroup>
								<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true"
									action="#{userProfileAction.deleteRole}" reRender="roleDataTable" >
									<rich:componentControl for="delconfirmRole"  operation="hide" event="onclick"  />
								</a4j:commandButton>												
								<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
								    <rich:componentControl for="delconfirmRole" operation="hide" event="onclick" />
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
