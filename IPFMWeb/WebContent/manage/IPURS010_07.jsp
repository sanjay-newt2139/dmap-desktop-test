<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>Role Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
<script type="text/javascript" language="javascript" src="../js/commonfunction.js"></script>
<script type="text/javascript" language="javascript" src="../js/numberformat.js"></script>

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
								class="style9">Role Management</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
					    <tr bgcolor="#BFBFBF">
					         <td>
								  <table border="0" cellpadding="0" cellspacing="0" align="left" >
									<tr>
										   <h:panelGroup id="tabGroup">
										   <td>
										  		<a4j:commandButton id="btnOwnerList" value="Authorize List " 
													image="../images/tab_req_nw_active.png" style="height: 25; width: 87" 
													action="#{roleManageAction.init}">
													<a4j:actionparam name="programIDParam" value="IPURS010_07"/>
				          						</a4j:commandButton>
			                      			 </td>
										   </h:panelGroup>
									</tr>
									<tr>
										<td height="2" colspan="8" align="center" valign="bottom"></td>
									</tr>
							  	</table>
							</td>  
					    </tr>
						<tr>
							<td>
								<rich:panel id="panelGrop" >
									<!-- ImageReady Slices (network_req_3.jpg) -->
									<table id="Table_01" width="1050" height="424" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td colspan="3">
												<img src="../images/IPURS0010_07_01.jpg" width="1050" height="91" alt=""></td>
										</tr>
										<tr>
											<td rowspan="2">
												<img src="../images/IPURS0010_07_02.jpg" width="178" height="333" alt=""></td>
											<td width="38" height="38" align="right" background="../images/IPURS0010_07_03.jpg"><label>
											  <input type="checkbox" name="checkbox" id="checkbox">
											</label></td>
									<td rowspan="2">
												<img src="../images/IPURS0010_07_04.jpg" width="834" height="333" alt=""></td>
										</tr>
										<tr>
											<td>
												<img src="../images/IPURS0010_07_05.jpg" width="38" height="295" alt=""></td>
										</tr>
									</table>
									<!-- End ImageReady Slices -->
									
								</rich:panel>
								<rich:spacer height="5" />	
								
							<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
										<tr>
											<td width="7%" height="25" align="center" >								    
													<h:panelGrid id="groupActionButton" columns="4" styleClass="contentlabelform">
														<a4j:commandButton id="btnPrev" value="Prev" styleClass="rich-button"
															action="#{roleManageAction.reqNetworkPage}" >
															<a4j:actionparam name="page" value="7"/>
															<a4j:actionparam name="action" value="P"/>
														</a4j:commandButton>
														<a4j:commandButton id="btnNext" value="Next" styleClass="rich-button"
															action="#{roleManageAction.reqNetworkPage}" disabled="true">
														</a4j:commandButton>
														<a4j:commandButton id="btnAdd" value="Submit" styleClass="rich-button"
															action="#{roleManageAction.init}">
															<a4j:actionparam name="programIDParam" value="IPURS010_01"/>
															</a4j:commandButton>
														<a4j:commandButton id="btnClose" value="Cancel" styleClass="rich-button"
															action="#{roleManageAction.init}">
															<a4j:actionparam name="programIDParam" value="IPURS010_01"/>
														</a4j:commandButton>
													</h:panelGrid>	
									          </td>
								         </tr>
								</table>	
								<rich:spacer height="5" />
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
	
		<rich:modalPanel id="confirmDialog" autosized="true">			
		<a4j:form id="delConfirmDialog">
			<table width="150px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
                        </td></tr><tr><td>
						<h:panelGrid columns="1" styleClass="contentlabelform">												
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="confirmDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
		</a4j:form>
	</rich:modalPanel>
	
</f:view>
</body>
</html>
