<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@page import="th.co.ais.ipfm.web.util.IPFMWebUtil"%><link href="../css/ipflow.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/topmenu.js" ></script>
   <script>
        history.forward();
    </script>
<f:loadBundle basename="resources.application" var="msg" />	
<a4j:jsFunction name="alertErrorMsg" 
	action="#{homepageAction.alertErrorMsg}"
 	reRender="errorMsg">
 	<a4j:actionparam name="errorMessage"/>
</a4j:jsFunction>

<h:form id="menuForm">
<div id="alwayTopMenu">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<div id="ipflow_menu">
			<ul>
				<%=IPFMWebUtil.getHeadMenu()%>
			</ul>
			</div>
			</td>
		</tr>
	</table>
</div>	
	<a4j:jsFunction name="goToPage" action="#{headMenuAction.perform}" >
    	<a4j:actionparam name="param1" assignTo="#{headMenuAction.actionName}"  />
    	<a4j:actionparam name="param2" assignTo="#{headMenuAction.programID}"  />                  
    </a4j:jsFunction>	
</h:form>

