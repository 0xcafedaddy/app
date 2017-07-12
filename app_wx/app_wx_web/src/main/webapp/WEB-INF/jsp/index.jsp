<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.uflowertv.model.dto.SessionInfo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <%
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		if (sessionInfo != null) {
			request.getRequestDispatcher("/redirect/main").forward(request, response);
		} else {
			request.getRequestDispatcher("/redirect/login").forward(request, response);
		}
	%>
  </head>
  <body>
  </body>
</html>
