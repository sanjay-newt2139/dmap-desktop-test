<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="javax.faces.context.FacesContext"%>
<%@ page import="th.co.ais.ipfm.web.bean.LoginBean"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page import="RSA.*" %>
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
<title>IP Flow Management : Log in Build 0.3-dev </title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="js/common.js"></script>
<script type="text/javascript" language="javascript" src="crypto/JSP_RSA_AIS.js"></script>
<script type="text/javascript">
history.forward();
	function fncSubmit(){	
		var password = document.getElementById("loginForm:password");
		if (password.value!=null && password.value.length > 0) {
			setMaxDigits(35);
			key = new RSAKeyPair(
				"4bd2e028c89933c19abdfe8a3e034208e0ef41438f15bc75e12dfcca41195825",
				"",
				"4c23fdcb11ce9b236b5e86426dd4024950ddd4911a3eb72159aff522d468ac89"
			);
			password.value = encryptedString(key,password.value);
		}
	}
</script>
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<!-- <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('images/sms_blog2.jpg')"> -->
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
    		<td height="168" background="images/bg_login_1.jpg">&nbsp;</td>
  		</tr>
  		<tr>
    		<td height="206" align="center" valign="top" background="images/sms_bglog-bg.jpg">
    			<table border="0" align="center" cellpadding="0" cellspacing="0">
      				<tr>
        				<td colspan="3"><img src="images/sms_bglog1.png" width="588" height="19"></td>
      				</tr>
      				<tr>
        				<td width="222"><img src="images/logo2.png" width="222" height="128"></td>
        				<td width="331" height="128" align="center" background="images/sms_bglog2-2.gif">
        					<h:form id="loginForm">
	        					<h:panelGrid width="331" border="0" columns="2" cellpadding="1" cellspacing="1" styleClass="ms8w" columnClasses="col1,col2">
	        						<h:panelGroup></h:panelGroup>
	        						<h:panelGroup>
	        							<h:messages layout="table" styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green"
												infoStyle="color: blue" globalOnly="true"/>
									</h:panelGroup>
	        						
	        						<h:panelGroup>
	        							<h:outputText value="UserName " />
	        							<h:graphicImage value="images/icon_required.gif" style="border:0" />
	        							<h:outputText value=" :" />
	        						</h:panelGroup>
	        						<h:panelGroup>
	        							<h:inputText id="username" value="#{loginBean.username}" maxlength="20" size="20" />
									</h:panelGroup>
									<h:panelGroup></h:panelGroup>
	        						<h:panelGroup>
	        							<h:message for="username" style="color:red"/>
									</h:panelGroup>
									
									<h:panelGroup>
	        							<h:outputText value="Password " />
	        							<h:graphicImage value="images/icon_required.gif" style="border:0" />
	        							<h:outputText value=" :" />
	        						</h:panelGroup>
	        						<h:panelGroup>
	        							<h:inputSecret id="password" value="#{loginBean.password}" maxlength="20" size="20" />
									</h:panelGroup>
									<h:panelGroup></h:panelGroup>
	        						<h:panelGroup>
	        							<h:message for="password" style="color:red"/>
									</h:panelGroup>
									
									<h:panelGroup></h:panelGroup>
									<h:panelGroup>
										<a4j:commandButton id="login" value="Login" action="#{loginAction.login}" image="images/sms_blog1.jpg" 
	              						onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('loginForm:login','','images/sms_blog2.jpg',1)" 
	              						onclick="#{rich:component('wait')}.show(); fncSubmit();" oncomplete="#{rich:component('wait')}.hide();"/>    
									</h:panelGroup>
	        					</h:panelGrid>
        					</h:form>
        				</td>
        				<td width="35" align="right"><img src="images/sms_bglog2.png" width="35" height="128"></td>
      				</tr>
      				<tr>
        				<td colspan="3"><img src="images/sms_bglog3.png" width="588" height="29"></td>
      				</tr>
    			</table>
    		</td>
  		</tr>
	</table>
</body>

<rich:modalPanel id="wait" autosized="true" width="180" height="70" moveable="false" resizeable="false" >
	<f:facet name="header">
		<h:outputText value="Processing" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="images/ico_close.png" id="hidePopUpProgress" style="cursor:pointer" />
			<rich:componentControl for="wait" attachTo="hidePopUpProgress" operation="hide" event="onclick" />
		</h:panelGroup>
	</f:facet>
 
	<h:panelGrid columns="1" width="100%" style="text-align:center;">
		<h:graphicImage value="images/loading45.gif"></h:graphicImage>
	</h:panelGrid>
</rich:modalPanel>
</f:view>
</html>
