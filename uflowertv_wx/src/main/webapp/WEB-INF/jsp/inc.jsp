<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	Cookie[] cookies = request.getCookies();
	if (null != cookies) {
		for (Cookie cookie : cookies) {
			cookieMap.put(cookie.getName(), cookie);
		}
	}
	String easyuiTheme = "default";//指定如果用户未选择样式，那么初始化一个默认样式
	if (cookieMap.containsKey("easyuiTheme")) {
		Cookie cookie = (Cookie) cookieMap.get("easyuiTheme");
		easyuiTheme = cookie.getValue();
	}
%> 
<!DOCTYPE html>
<html>
<head>
<title></title>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="static/resources/jquery-easyui-1.4.3/themes/<%=easyuiTheme%>/easyui.css">
<link rel="stylesheet" type="text/css" href="static/resources/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="static/resources/jquery-easyui-1.4.3/themes/easyui_icons.css">
<link rel="stylesheet" type="text/css" href="static/resources/jquery-easyui-1.4.3/themes/demo.css">
<link rel="stylesheet" type="text/css" href="static/resources/ueditor/themes/default/css/ueditor.min.css" />
<%-- 引入jQuery --%>
<%
String User_Agent = request.getHeader("User-Agent");

if (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE") > -1 && (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 6") > -1 || StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 7") > -1 || StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 8") > -1)) {
	out.println("<script src='static/js/jquery-1.9.1.js' type='text/javascript' charset='utf-8'></script>");
} else {
	out.println("<script src='static/js/jquery-2.0.3.js' type='text/javascript' charset='utf-8'></script>");
}
%>
<script type="text/javascript" src="static/resources/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/resources/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="static/resources/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="static/resources/ueditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="static/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="static/js/my_js.js"></script>
</head>
<body>
</body>
</html>