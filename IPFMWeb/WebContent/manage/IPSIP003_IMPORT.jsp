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
				  <a4j:form id="DetailForm" >
				  		<!-- FIX  -->
				  		<a4j:jsFunction name="gotoHomePage" action="#{homepageAction.gotoHomepage}" />
						<a4j:jsFunction name="confirmCancel" action="#{homepageAction.gotoHomepage}"/>
					<table width="97%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2">
					   <tr>
                             <td height="25" bgcolor="#1f4986" align="left" colspan="2"
								valign="middle"><img src="../images/ico_member.gif" alt=""
								width="23" height="15"> <strong class="ms10w"> <span
								class="style9">Import Update</span></strong></td>
					  </tr>
					  <tr>
					  	<td height="5" colspan="2"><img src="../images/blank.gif" width="10" height="5"></td>
					  </tr>
					  <tr>
					  	<td align="right">
						  		<h:selectOneRadio id="templateType" value="#{ipLevel3Bean.templateType}" layout="pageDirection" >
									<f:selectItem itemValue="IPFM" itemLabel="IPFM Template" />
								 	<f:selectItem itemValue="ICTAP" itemLabel="ICTAP Template" /> 
								 	<a4j:support event="onclick" reRender="DetailForm" />
								</h:selectOneRadio>
					  	</td>
					  	<td valign="top" align="left" style="margin-top: 5px;">
					  		<table>
					  			<tr>
					  				<td style="vertical-align: bottom;height: 20px;">
								  		<h:outputLink value="#" style="FONT-WEIGHT: bold; COLOR: #0000ff;TEXT-DECORATION: underline;"
										id="dlplanning" onclick="var w=window.open('#{ipfmConfigBean.homeUrl}/TemplateDownload?fileName=#{ipfmConfigBean.ipfmTemplate}','','status=0,toolbar=0,menubar=0,resizable=0,height=0,width=0'); w.moveTo(1300,1300);" >Download Template</h:outputLink>
									</td>
								</tr>
							</table>
					  	</td>
					  </tr>
						<tr>
							<td colspan="2">
								<a4j:region id="uploadregion">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
									<tr>
										<td>
						         		 	<rich:fileUpload fileUploadListener="#{ipLevel3Action.importExcelUpdate}"  
					             			maxFilesQuantity="1"
					             			id="fileUpload" transferErrorLabel="เกิดข้อผิดพลาดไม่สามารถอัพโหลดไฟล์นี้ได้"
             								doneLabel="อัพโหลดเสร็จสมบูรณ์" stopEntryControlLabel=" "
					             			clearControlLabel=" " cancelEntryControlLabel=" "
					             			immediateUpload="false"
					             			acceptedTypes="xls,xlsx" 
					             			allowFlash="false"
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
					             			listHeight="60" autoclear="true" 
					             			addControlLabel="Browse"
					             			uploadControlLabel="Verify"  
					             			listWidth="100%" >
						             			<a4j:support event="onuploadcomplete" reRender="errorDialog,fileUpload,DetailForm,errorMsg" >
						             			</a4j:support>
						             			<f:facet name="label">
													<h:outputText value="{_KB}KB from {KB}KB uploaded --- {mm}:{ss}" />
												</f:facet>
					         		 	</rich:fileUpload>
											</td>
										</tr>
									</table>	
								
								</a4j:region>
							
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC" class="thtext_detail2" >
								   <tr>
			                            <td height="25" bgcolor="#1f4986" align="left" colspan="2"
											valign="middle"> <rich:spacer width="10" /><strong class="ms10w"> <span
											class="style9"> Result</span></strong>
										</td>
									</tr>
									<tr>
										<td>
											<h:outputLabel value="#{ipLevel3Bean.resultImportMsg}" ></h:outputLabel>
											<rich:spacer width="10" />
											<h:commandLink value="<< Download ERROR File >>" style="color:blue;" action="#{ipLevel3Action.downloadVerifyImportFile}" rendered="#{ipLevel3Bean.showDownloadError}"/>
											
											<h:commandLink value="<< Download WARN File >>" style="color:blue;" action="#{ipLevel3Action.downloadVerifyImportFile}" rendered="#{ipLevel3Bean.showDownloadWarn}"/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						
					</table>
					
					<br/>
						<div align="right" > 
							<rich:spacer width="10" />	
							<a4j:commandButton  value="Save" styleClass="rich-button" action="#{ipLevel3Action.doSaveImportLv3}" rendered="#{ipLevel3Bean.showSaveBtn}"/>
							<rich:spacer width="10" />
							<a4j:commandButton  value="Cancel" styleClass="rich-button" action="#{ipLevel3Action.backToIpLevel3}"  />
							<rich:spacer width="20" />
						</div>	
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
