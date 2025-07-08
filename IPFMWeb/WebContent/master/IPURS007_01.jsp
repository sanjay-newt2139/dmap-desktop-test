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
	<br><br>
	<div id="container" style="width: 100%">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
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
										<td></td>
										<td class="labelStyle">&nbsp;</td>
								        <td>											
								        	<div style="float:right;">
												<a4j:commandLink  value="Update from e-HR" style="text-decoration:underline;" />
			          						</div>
										</td>												
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="User Name :" ></h:outputText>&nbsp;
										</td>	
								        <td>
								        	<rich:spacer width="10"></rich:spacer>
											<h:outputText value="Boonyakiat Ngourisitkul" ></h:outputText>																								
										</td>
										<td class="labelStyle"  >
											<h:outputText value="Email :"></h:outputText>&nbsp;
										</td>	
								        <td>	
								        	<rich:spacer width="10"></rich:spacer>
											<h:outputText value="boonyakn@ais.co.th" ></h:outputText>																								
										</td>											
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="Department :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="DP-CSS" ></h:outputText>																								
										</td>
										<td class="labelStyle"  >
											<h:outputText value="Section :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value=""></h:outputText>																								
										</td>											
                                  	</tr>
                                  	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="Position :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="Engineer Specialist" ></h:outputText>																								
										</td>
										<td class="labelStyle" >
											<h:outputText value="Team :" ></h:outputText>&nbsp;
										</td>	
								        <td>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText value="IP-CDN" ></h:outputText>																								
										</td>											
                                  	</tr>
                                  	<tr class="inputRow">
										<td class="labelStyle">Telephone <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp; </td>	
								        <td>
								        	<rich:spacer width="10"></rich:spacer>
											<h:inputText value="4546" />																								
										</td>
										<td class="labelStyle">Mobile <h:graphicImage value="../images/icon_required.gif" style="border:0" /> :&nbsp; </td>											
								        <td>
								        	<rich:spacer width="10"></rich:spacer>
											<h:inputText value="0818543335" ></h:inputText>																								
										</td>											
                                 	</tr>
                                 	<tr class="displayRow">
										<td class="labelStyle"  >
											<h:outputText value="Delegate to :" ></h:outputText>&nbsp;
										</td>	
								        <td colspan="3">
											<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
												<rich:spacer width="10"></rich:spacer>
												<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													value="LAN" width="150">
													<f:selectItem itemLabel="LAN" itemValue="LAN"/>
													<f:selectItem itemLabel="LAN" itemValue="LAN"/>
													<f:selectItem itemLabel="LAN" itemValue="LAN"/>
													<f:selectItem itemLabel="LAN" itemValue="LAN"/>
													<f:selectItem itemLabel="LAN" itemValue="LAN"/>
												</rich:comboBox>
											</h:panelGrid>																							
										</td>									
                                  	</tr>
                                  	<tr class="inputRow">
					                 	<td class="labelStyle" ><h:outputText value="Effective Date" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
										<td>
											<rich:spacer width="10"></rich:spacer>
											<rich:calendar value="01/01/2010" 
									                        locale="en/US"
									                        popup="true" 
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
									                        inputStyle="background-color:white;"
									                        inputSize="20"
									                        direction="auto"/>                                       
										</td>	
					             		<td class="labelStyle" ><h:outputText value="Expire Date" escape="false"></h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" /><h:outputText value=" : " escape="false"/></td>
										<td>
											<rich:spacer width="10"></rich:spacer>
											<rich:calendar value="01/01/2011" 
									                        locale="en/US"
									                        popup="true" 
									                        datePattern="dd/MM/yyyy"
									                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"
									                        inputStyle="background-color:white;"
									                        inputSize="20"
									                        direction="auto"/>
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
								</table>
								</h:panelGroup>
							</rich:panel>
													
							<rich:simpleTogglePanel id="panelGrop1" label="Manager">
								<h:panelGroup style="width:100%;">
								<table width="100%" border="0" class="thtext_detail">
									<tr class="inputRow">
										<td class="labelStyle">
											<h:outputText value="Manager ID :"></h:outputText>&nbsp;
										</td>	
								        <td colspan="3">
								        	<div style="float:left;">
								        		<h:panelGrid columns="7" cellpadding="0" cellspacing="0">
								        			<rich:spacer width="10"></rich:spacer>								
								        		
			                                        <rich:comboBox defaultLabel="Please select value" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
														value="vinai sukjai" width="200">
														                     
			                                        </rich:comboBox>
			                                        <rich:spacer width="10"></rich:spacer>
			                                        <a4j:commandButton value="Add" image="../images/add1.png" action="#{userProfileAction.init}" >
			                                        	
			                                        </a4j:commandButton>
			                                    </h:panelGrid>	
			          						</div>																			
		                                    <div style="float:right;">
												<a4j:commandLink  value="Update from e-HR" style="text-decoration:underline;" />
			          						</div>
										</td>												
                                  </tr>
                                  
                                  <tr>
                                  	<td colspan="4">
									<h:panelGroup style="width:100%">
										<rich:dataTable id="managerDataTable" width="100%" cellpadding="1" cellspacing="0" border="0"
												var="detail" value="#{userProfileBean.managerList}"
												  
												 
												rowClasses="odd,even" rows="#{userProfileBean.rowPerPage}"
												styleClass="contentform" rowKeyVar="index" 
												headerClass="tableHeader">
			
											<rich:column styleClass="valignTop" style="width:40px;">
												<f:facet name="header">
													<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
												</f:facet>
												 <div align="center">
												  	<a4j:commandButton id="btnUpd" value="Delete" image="../images/contact_blue_remove.png" style="height: 15; width: 15" action="#{groupIPAction.initUpdate}">
														<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
					          						</a4j:commandButton>
					          					</div>
											</rich:column>
											<rich:column  filterValue="#{userProfileBean.filter0071.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.userName,userProfileBean.filter0071.filterColumn1)}"   styleClass="valignTop">
												<f:facet name="header">													
													    <h:panelGroup>
		 <h:outputText value="Name" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userProfileBean.filter0071.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="managerDataTable" />
		 </h:inputText>
	 </h:panelGroup>
												</f:facet>
												<div>
				          						   <h:outputText value="#{detail.userName}" styleClass="contentform"></h:outputText>
												</div>
											</rich:column>
											<rich:column  filterValue="#{userProfileBean.filter0071.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.position,userProfileBean.filter0071.filterColumn2)}"   styleClass="valignTop">
												<f:facet name="header">
												<h:panelGroup>
		 <h:outputText value="Position" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userProfileBean.filter0071.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="managerDataTable" />
		 </h:inputText>
	 </h:panelGroup>
												</f:facet>
												<div>
					          						<h:outputText value="#{detail.position}" styleClass="contentform"></h:outputText>
												</div>
											</rich:column>
											<rich:column  filterValue="#{userProfileBean.filter0071.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.dept,userProfileBean.filter0071.filterColumn3)}"   styleClass="valignTop">
												<f:facet name="header">
												<h:panelGroup>
		 <h:outputText value="Department" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userProfileBean.filter0071.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="managerDataTable" />
		 </h:inputText>
	 </h:panelGroup>
												</f:facet>
												<div>
					          						<h:outputText value="#{detail.dept}" styleClass="contentform"></h:outputText>
												</div>
											</rich:column>
											<rich:column  filterValue="#{userProfileBean.filter0071.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.section,userProfileBean.filter0071.filterColumn4)}"   styleClass="valignTop">
												<f:facet name="header">
													<h:panelGroup>
		 <h:outputText value="Section" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
		 <h:inputText value="#{userProfileBean.filter0071.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="managerDataTable" />
		 </h:inputText>
	 </h:panelGroup>
												</f:facet>
												<div>
					          						<h:outputText value="#{detail.section}" styleClass="contentform"></h:outputText>
												</div>
											</rich:column>
											<f:facet name="footer">
												<rich:columnGroup>
													<rich:column colspan="2">
														Total : <h:outputText value="#{fn:length(userProfileBean.managerList)}" /> records
													</rich:column>
													<rich:column colspan="10">
														<rich:datascroller immediate="true" rendered="true" align="right" for="managerDataTable"
															maxPages="#{userProfileBean.maxPage}" selectedStyleClass="selectScroll"
															fastStep="5"  boundaryControls="auto" fastControls="auto" stepControls="hide"
															style="background-color: #cccccc;"
															
														/>
													</rich:column>
												</rich:columnGroup>					
											</f:facet>										
										</rich:dataTable>
									</h:panelGroup>
									</td>
                                  </tr>                                                       
								</table>
								</h:panelGroup>
							</rich:simpleTogglePanel>
							
							<rich:spacer height="5" />
							
							<rich:simpleTogglePanel id="panelGrop2" label="Role">
								<h:panelGroup style="width:100%;">
								<table width="100%" border="0" class="thtext_detail">
									<tr class="inputRow">
										<td class="labelStyle"  >
											<h:outputText value="Role Name :"></h:outputText>&nbsp;
										</td>	
								        <td colspan="3">
								        	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
									        	<rich:spacer width="10"></rich:spacer>
								        		<rich:comboBox defaultLabel="Please select value" enableManualInput="false" itemClass="contentform" itemSelectedClass="contentform" 
													value="#{userProfileBean.roleName}" width="200">
													<f:selectItem itemLabel="Requester" itemValue="Requester"/>     
													<f:selectItem itemLabel="Planning" itemValue="Planning"/>    
													<f:selectItem itemLabel="CDN" itemValue="CDN"/>    
													<f:selectItem itemLabel="PM-CDN" itemValue="PM-CDN"/>   
		                                        </rich:comboBox>																
	                                        </h:panelGrid>
										</td>												
                               		 </tr>
                               		 <tr class="inputRow">
                               		 	<td class="labelStyle"  >
											<h:outputText value="User :" ></h:outputText>&nbsp;
										</td>	
								        <td colspan="3">
								        	<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
								        		<rich:spacer width="10"></rich:spacer>
		                                        <rich:comboBox defaultLabel="Please select value" enableManualInput="true" itemClass="contentform" itemSelectedClass="contentform" 
													value="vinai sukjai" width="200">
													                     
		                                        </rich:comboBox>
		                                        <rich:spacer width="10"></rich:spacer>
		                                        <a4j:commandButton value="Add" image="../images/add1.png"   action="#{groupIPAction.initUpdate}"/>
		                                    </h:panelGrid>	
										</td>
									</tr>		
                               		 <tr class="displayRow">
                                 		<td colspan="4">
											<h:panelGroup id="tableRole" style="width:100%">
												<rich:dataTable width="100%" id="roleDataTable" cellpadding="1" cellspacing="0" border="0"
													var="detail" value="#{userProfileBean.roleList}" reRender="scrollIPDetailTable"
													  
													 
													rowClasses="odd,even" rows="#{userProfileBean.rowPerPage}"
													styleClass="contentform" rowKeyVar="index" 
													headerClass="tableHeader">
				
													<rich:column styleClass="valignTop" style="width:40px;">
														<f:facet name="header">
															<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
														</f:facet>
														 <div align="center" >
														  	<a4j:commandButton value="Delete" image="../images/contact_blue_remove.png" style="height: 15px; width: 15px;" action="#{groupIPAction.initUpdate}">
																<a4j:actionparam name="rowId" value="#{detail.rowId}"/> 
							          						</a4j:commandButton>
							          					</div>
													</rich:column>
													<rich:column  filterValue="#{userProfileBean.filter007.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.userName,userProfileBean.filter007.filterColumn1)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort007.sortColumn1}" sortBy="#{detail.userName}">
														<f:facet name="header">
															    <h:panelGroup>
		   <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>User Name</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort007.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter007.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="roleDataTable" />
		 </h:inputText>
	 </h:panelGroup>
	 
														</f:facet>
														<div>
						          						   <h:outputText value="#{detail.userName}" styleClass="contentform"></h:outputText>
														</div>
													</rich:column>
													<rich:column  filterValue="#{userProfileBean.filter007.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.position,userProfileBean.filter007.filterColumn2)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort007.sortColumn2}" sortBy="#{detail.position}">
														<f:facet name="header">
														    <h:panelGroup>
		   <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Position</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort007.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter007.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="roleDataTable" />
		 </h:inputText>
	 </h:panelGroup>
														</f:facet>
														<div>
							          						<h:outputText value="#{detail.position}" styleClass="contentform"></h:outputText>
														</div>
													</rich:column>
													<rich:column  filterValue="#{userProfileBean.filter007.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.dept,userProfileBean.filter007.filterColumn3)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sort007.sortColumn3}" sortBy="#{detail.dept}">
														<f:facet name="header">
														 <h:panelGroup>
		   <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Department</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sort007.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="roleDataTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filter007.filterColumn3}" style="width: 50px;">
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
																Total : <h:outputText value="#{fn:length(userProfileBean.roleList)}" /> records
															</rich:column>
															<rich:column colspan="10">
																<rich:datascroller immediate="true" rendered="true" align="right" for="roleDataTable"
																	maxPages="#{userProfileBean.maxPage}" selectedStyleClass="selectScroll"
																	fastStep="5"  boundaryControls="auto" fastControls="auto" stepControls="hide"
																	style="background-color: #cccccc;" />
															</rich:column>
														</rich:columnGroup>					
													</f:facet>
												</rich:dataTable>
										 	</h:panelGroup>	
										</td>
	                                 </tr>                                                       
								</table>
								</h:panelGroup>
							</rich:simpleTogglePanel>
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
</f:view>
</body>
</html>
