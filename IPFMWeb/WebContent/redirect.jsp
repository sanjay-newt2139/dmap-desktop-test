<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="th.co.ais.ipfm.web.bean.LoginBean"%>
<%
if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("timeout")!=null){
//	LoginBean loginBean = new LoginBean();
//	loginBean.setDisplayErrorMsg(true);
//	loginBean.setErrorMsg("Session TimeOut!");
//	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
%>
<script type="text/javascript" language="javascript">
top.location.href="<%=FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()%>/login.jsf?timeout=true";
</script>
<%
}else if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nologin")!=null){
//	LoginBean loginBean = new LoginBean();
//	loginBean.setDisplayErrorMsg(true);
//	loginBean.setErrorMsg("User Not Login!");
//	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
%>
<script type="text/javascript" language="javascript">
top.location.href="<%=FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()%>/login.jsf?nologin=true";
</script>
<%
}else{
%>
<script type="text/javascript" language="javascript">
top.location.href="<%=FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()%>/login.jsf";
</script>
<%	
}
%>

