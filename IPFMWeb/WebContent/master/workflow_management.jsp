<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<title>WorkFlow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>
</head>
<body style="margin: 0 0">
<f:loadBundle basename="resources.application" var="msg" />
<f:view>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" background="../images/b_bg.jpg">
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<f:subview id="menu">
					<jsp:include page="../home/menu.jsp" />
				</f:subview>
				<tr>
					<td width="100%" align="center" valign="top"><img
						src="../images/blank.gif" width="10" height="5"><br>
					<table width="99%" border="0" cellspacing="0" cellpadding="0">

						<tr>
							<td height="35"><span class="ms8"><img
								src="../images/ic-pencil.png" hspace="9" align="middle"><font
								class="ms8blue">WorkFlow Management</font></span></td>
						</tr>
					</table>
					<br>
					<br>
					<br>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<f:subview id="footer">
		<jsp:include page="../home/progress.jsp" />
	</f:subview>
</f:view>
</body>
</html>
