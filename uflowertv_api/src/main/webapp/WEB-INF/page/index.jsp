<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
  </head>
  <body>
  	 <embed src="static/js/honehone_clock_tr.swf" width="220" height="90" type="application/x-shockwave-flash">
  </body>
</html>
