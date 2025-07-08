<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<title>IP Flow Management</title>
</head>
<frameset rows="145,*,28" border=0 framespacing=0 >
  <frame id="header" name="header" src="home/header.jsf" frameborder=0 noresize scrolling=no />
  <frameset cols="145,*" border=0 framespacing=0 >
    <frame id="treeFrame" name="tree" src="home/tree.jsf" noresize frameborder=0 scrolling=auto/>
    <frame name="body" src="manage/IPSUR003_MANAGER_APPROVE.jsf" frameborder=1 scrolling=auto/>
  </frameset>
<frame id="footer" name="footer" src="home/footer.jsf" frameborder=0 noresize scrolling=no/>
</frameset>
</html>
