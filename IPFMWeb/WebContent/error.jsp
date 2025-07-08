<%@ page isErrorPage="true" %>
<html>
<head>
   <title>Error Page</title>
</head>
<body>
<h2>
<%
	Object code = request.getAttribute("errorCode");
	Object mesg = request.getAttribute("errorMessage");
	Object head = request.getAttribute("errorHeader");
%>
<% if(code!=null) { %>
<h1><%=code%></h1>
<% } %>

<% if(head!=null) { %>
<%=head%>
<% } else { %>
Your application has generated an error
<% } %>
</h2>

<h3>
<% if(mesg!=null) { %>
<%=mesg%>
<% } else { %>
Please notify your help desk.
<% } %>
</h3>

<% if(exception!=null) { %>
<b>Exception:</b><br> 
<% 
	String str = "";
	java.io.StringWriter sw = new java.io.StringWriter();
	exception.printStackTrace(new java.io.PrintWriter(sw)); 
	str = sw.toString();
	str = str.replaceAll("\\n", "<br>\n");
	str = str.replaceAll("\\t", "<img width=40 height=1>");
	out.print(str);
}

%>
</body>
</html>