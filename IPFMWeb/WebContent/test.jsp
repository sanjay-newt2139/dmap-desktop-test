<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="th.co.ais.ipfm.web.bean.LoginBean"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<% 
if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("timeout")!=null){
	LoginBean loginBean = new LoginBean();
	loginBean.setDisplayErrorMsg(true);
	loginBean.setErrorMsg("Session TimeOut!");
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
}else if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nologin")!=null){
	LoginBean loginBean = new LoginBean();
	loginBean.setDisplayErrorMsg(true);
	loginBean.setErrorMsg("User Not Login!");
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
}

%>
<html>
<head>
<title>IP Flow Management : Log in</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="js/common.js"></script>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	background-image: url(images/bg_login_2.jpg);
}
.col1{width:130px; text-align:right;}
.col2{width:201px; }
-->
</style></head>
<f:view>
<body>

<a4j:form>
  <a4j:jsFunction name="updateFilename" reRender="apanel">
   <a4j:actionparam name="filename" assignTo="#{tmhFileUploadBean.uploadedFilename}" />
  </a4j:jsFunction>
</a4j:form>

<h:form enctype="multipart/form-data">
 <t:inputFileUpload id="fileupload"
                    size="40"
                    value="#{tmhFileUploadBean.uploadedFile}"
                    storage="file"
                    required="true"
                    />

 <h:panelGroup id="apanel">
       <h:commandLink value="Upload enabled ..."
                      actionListener="#{tmhFileUploadBean.uploadFile}"/>
       <h:outputText value="Upload disabled"/>
 </h:panelGroup>
</h:form>

</body>
</f:view>
</html>
