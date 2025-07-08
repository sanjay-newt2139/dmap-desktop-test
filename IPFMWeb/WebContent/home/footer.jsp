<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="../js/common.js"></script>
</head>
<body style="margin:0 0">
<f:view>
<h:form>
<a4j:poll reRender="onlineUser,webCounter" interval="#{ipfmConfigBean.userOnlineMsTime}"></a4j:poll>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="27" valign="middle" bgcolor="#666666"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="70" height="27" valign="top"><img src="../images/logo-ais-s.png" width="67" height="25"></td>
        <td height="27" valign="middle" class="copy">&copy; 2010 Created by Advance Info Service PLC. &nbsp;All right reserved. </td>
      	<td align="right" class="copy">
      		<img src="../images/green_dot.gif">
      		On Line User : 
      		<h:outputText id="onlineUser" value="#{footerBean.onlineUser}">
      			<f:convertNumber pattern="#,##0"/>
      		</h:outputText>
      		Users / Web Counter : 
      		<h:outputText id="webCounter" value="#{footerBean.webCounter}">
      			<f:convertNumber pattern="#,##0"/>
			</h:outputText>
			Times&nbsp;
      	</td>      	
      </tr>
    </table></td>
  </tr>
</table>
</h:form>
</f:view>
</body>
</html>