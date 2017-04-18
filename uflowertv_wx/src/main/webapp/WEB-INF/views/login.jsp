<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
	  <title>油菜花微信平台管理中心</title>
		<meta charset="UTF-8">
	  <link href="<%=path%>/static/css/style.css" rel="stylesheet" type="text/css" />
    </head>
	<body> 
	  <form method="post" action="<%=path %>/user/login" class="loginform">
	    <div id="bg">
	      <div id="logo"></div>
	      <div id="lay">
	        <div id="con">
	          <dl>
	            <dt id="acc">邮箱：</dt>
	            <dd>
	              <label class="label">
	                <input name="email" type="text" dataType="e" errormsg="请输入正确邮箱" nullmsg="请输入正确邮箱" sucmsg="输入正确" />
	              </label>
	            </dd>
	            <dt>密码：</dt>
	            <dd>
	              <label class="label">
	                <input name="pwd" type="password" datatype="s6-18" nullmsg="请输入密码" errormsg="密码至少6个字符,最多18个字符！" />
	              </label>
	            </dd>
	          </dl>
	          <span class="erorr"></span>
	          <a style="color:indigo;margin-left: 720px;" href="pwd_forward.jsp">忘记密码?</a>
	        </div>
	        <div id="bottom">
	          <input type="submit" class="btn" value="提交登陆" />
	          <a href="reg.jsp" >注册</a>
	        </div>
	      </div>
	    </div>
	  </form>
  	  <script type="text/javascript" src="<%=path %>/static/js/jquery.min.js"></script>
	 <script type="text/javascript" src="<%=path %>/static/js/Validform_min.js"></script>
	  <script type="text/javascript">
	  $(".loginform").Validform({
	    tiptype:3,
	    showAllError:true,
	    ajaxPost:true,
	    callback:function(data){
	      if(data.code==200){
	        window.location.href="<%=path %>/redirect/index";
	      }else{
	        var datas = data.data;
	        if (datas.emialMsg) {
	          $('input[name="email"]').next().removeClass('Validform_right').addClass('Validform_wrong').html(datas.emialMsg);
	        };
	        if (datas.pwdMsg) {
	          $('input[name="pwd"]').next().removeClass('Validform_right').addClass('Validform_wrong').html(datas.pwdMsg);
	        };
	      }
	    }
	  });
	  </script>
	</body>
</html>