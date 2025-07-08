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
								class="style9">User Profile Management</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
						<tr>
							<td>
							<rich:simpleTogglePanel switchType="client" id="groupSearchResult"  label="User Information" opened="true" >
								<rich:panel id="groupSearchCriteria" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail" style="" >
										
	                                  	<tr>
											<td  height="25" align="right" >
												<strong><h:outputText value="User Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td  height="22" align="left" colspan="3">
												<h:inputText id="uname" value=""   size="30" style="text-align:center"  />
												&nbsp;
												<!--<a4j:commandButton id="btnSearch"  image="../images/p_zoom.gif"  styleClass="rich-button"
												action="#{groupIPAction.init}"
												 style="width:20px"/>-->
												 <h:graphicImage value="../images/p_zoom.gif" style="border:0" />
												 &nbsp;
												
											</td>
											<td>
												<a4j:commandButton id="btnload" value="Load Data From e-HR" styleClass="rich-button"
												action="#{groupIPAction.init}"  style="width:150px"
												/>
											</td>
	                                  	</tr>
	                                  	<tr>
											<td  height="25" align="right" >
												<strong><h:outputText value="Name :"></h:outputText></strong>&nbsp;
											</td>	
									        <td  height="22" align="left"  colspan="2">
												<h:inputText id="name" value=""   size="45"	 	 style="text-align:center"  />
											</td>
											<td   height="25" align="right" >
												<strong><h:outputText value="Department :"></h:outputText></strong>&nbsp;
											</td>	
									        <td  height="22"  align="left" >
												<h:inputText id="department" value=""   size="45"	 	 style="text-align:center"  />											
											</td>	
	                                  	</tr>
	                                  	<tr>
											<td  height="25" align="right" >
												<strong><h:outputText value="Section :"></h:outputText></strong>&nbsp;
											</td>	
									        <td  height="22" align="left"  colspan="2">
												<h:inputText id="section" value=""   size="45"	 	 style="text-align:center"  />
											</td>
											<td   height="25" align="right" >
												<strong><h:outputText value="Position :"></h:outputText></strong>&nbsp;
											</td>	
									        <td  height="22"  align="left" >
												<h:inputText id="position" value=""   size="45"	 	 style="text-align:center"  />											
											</td>	
	                                  	</tr>
	                                  	<tr>
											<td  height="25" align="right" >
												<strong><h:outputText value="Email :"></h:outputText></strong>&nbsp;
											</td>	
									        <td  height="22" align="left" colspan="2">
												<h:inputText id="email" value=""   size="45"	 	 style="text-align:center"  />
											</td>
											<td   height="25" align="right" >
												<strong><h:outputText value="Telephone">
												</h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
									        <td  height="22"  align="left" >
												<h:inputText id="telephone" value=""   size="45"	 	 style="text-align:center"  />											
											</td>	
	                                  	</tr>
	                                  	<tr>
											<td  height="25" align="right" >
												<strong><h:outputText value="Mobile">
												</h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
									        <td height="22" align="left" colspan="4">
												<h:inputText id="mobile" value=""   size="45"	 	 style="text-align:center"  />
											</td>
	                                  	</tr>
	                                  	<tr>
											<td width="15%" height="25" align="right" >
												<strong><h:outputText value="User Team">
												</h:outputText><h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>	
									        <td width="5%" height="22" align="left">
													<rich:comboBox  id="status" defaultLabel="Please select value"  styleClass="contentform" enableManualInput="false"  
														itemClass="contentform" itemSelectedClass="contentform" value="#{groupIPBean.ipVersion}" 
														width="50" >
													</rich:comboBox>													
											</td>
											<td width="20%" align="left"  >
												&nbsp;<h:inputText id="userteam" value=""   size="27"	 	 style="text-align:center"  />
												&nbsp;
												<h:graphicImage value="../images/p_zoom.gif" style="border:0" />
											</td>
											<td width="17%" align="left"  >&nbsp;</td>
											<td width="47%" align="left"  >&nbsp;</td>
	                                  	</tr>
									</table>
								</rich:panel>
								</rich:simpleTogglePanel>
							</td>
							</tr>
							<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="toggle2"  label="Manager Information" opened="true" >
								<rich:panel id="panel2" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail" style="" >
										<tr>
											<td width="12%" height="25" align="right" >
												 <strong><h:outputText value="Manager ID"/>
												 <h:graphicImage value="../images/icon_required.gif" style="border:0" />&nbsp;:&nbsp;</strong>
											</td>
									        <td  height="22" align="left" colspan="2">
										        <h:inputText id="mid" value=""   size="15"	 	 style="text-align:center"  />
										        &nbsp;
										        <h:graphicImage value="../images/p_zoom.gif" style="border:0" />
										        &nbsp;
										        <h:inputText id="mid2" value=""   size="30"	 	 style="text-align:center"  disabled="true"/>
										        &nbsp;
												<a4j:commandButton id="btnSearch2"  value="Add"  styleClass="rich-button"
												action="#{groupIPAction.init}"
												/>&nbsp;
												<a4j:commandButton id="btnload2" value="Load Data From e-HR" styleClass="rich-button"
												action="#{groupIPAction.init}" style="width:150px"
												/>&nbsp;
											</td>
										</tr>
										<tr>
											<td width="12%" height="25" align="right" >&nbsp;</td>
									        <td width="5%" height="22" align="left" >
									        <h:graphicImage value="../images/p_delete.gif" style="border:0" />
											</td>
											<td  height="22" align="left" >
									         <h:outputText value="Manager A"></h:outputText>
											</td>
										</tr>
										<tr>
											<td width="12%" height="25" align="right" >&nbsp;</td>
									        <td width="5%" height="22" align="left" >
									        <h:graphicImage value="../images/p_delete.gif" style="border:0" />
											</td>
											<td  height="22" align="left" >
									         <h:outputText value="Manager B"></h:outputText>
											</td>
										</tr>
									</table>
								</rich:panel>
								</rich:simpleTogglePanel>
								
							</td>
						</tr>
						<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="toggle3"  label="Group User Information" opened="true" >
								<rich:panel id="panel3" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail" style="" >
										<tr>
											<td width="12%" height="25" align="right" >
												 <strong> <h:outputText value="Group User :"/></strong>&nbsp;
											</td>
									        <td  height="22" align="left" colspan="2">
										        <h:inputText id="guser" value=""   size="15"	 	 style="text-align:center"  />
										        &nbsp;
										        <h:graphicImage value="../images/p_zoom.gif" style="border:0" />
										        &nbsp;
										        <h:inputText id="guser2" value=""   size="30"	 	 style="text-align:center"  disabled="true"/>
										        &nbsp;
												<a4j:commandButton id="btnSearch3"  value="Add"  styleClass="rich-button"
												action="#{groupIPAction.init}"
												/>&nbsp;
											</td>
										</tr>
										<tr>
											<td width="12%" height="25" align="right" >&nbsp;</td>
									        <td width="5%" height="22" align="left" >
									        <h:graphicImage value="../images/p_delete.gif" style="border:0" />
											</td>
											<td  height="22" align="left" >
									         <h:outputText value="Group AAA"></h:outputText>
											</td>
										</tr>
									</table>
								</rich:panel>
								</rich:simpleTogglePanel>
								
							</td>
						</tr>
						<tr>
							<td>
								<rich:simpleTogglePanel switchType="client" id="toggle4"  label="Privilage Information" opened="true" >
								<rich:panel id="panel4" >
									<table width="97%" border="0" cellpadding="0" cellspacing="0" class="thtext_detail" style="" >
										<tr>
											<td width="12%" height="25" align="right" >
												 <strong> <h:outputText value="IPFM Role :"/></strong>&nbsp;
											</td>
									        <td  height="22" align="left" colspan="2">
										        <h:inputText id="groupuser" value=""   size="15"	 	 style="text-align:center"  />
										        &nbsp;
										        <h:graphicImage value="../images/p_zoom.gif" style="border:0" />
										        &nbsp;
										        <h:inputText id="groupuser2" value=""   size="30"	 	 style="text-align:center"  disabled="true"/>
										        &nbsp;
												<a4j:commandButton id="btnSearch4"  value="Add"  styleClass="rich-button"
												action="#{groupIPAction.init}"
												/>&nbsp;
											</td>
										</tr>
										<tr>
											<td width="12%" height="25" align="right" >&nbsp;</td>
									        <td width="5%" height="22" align="left" >
									        <h:graphicImage value="../images/p_delete.gif" style="border:0" />
											</td>
											<td  height="22" align="left" >
									         <h:outputText value="Tier 3"></h:outputText>
											</td>
										</tr>
									</table>
								</rich:panel>
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
