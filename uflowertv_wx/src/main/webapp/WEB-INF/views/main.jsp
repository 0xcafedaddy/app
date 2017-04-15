<%@page import="com.uflowertv.model.SessionInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
%>
<html>
<head>
 <title>油菜花微信平台管理中心</title>
<base href="<%=basePath%>">
<style type="text/css">
.global-width{ width:960px; margin:0 auto;}
.top{ width:100%; height:88px; background:url(images/Top_bg.gif) repeat-x;}
.top .logo{ margin:17px 0 0 0;}
.copyright{ text-align:center; font:12px Arial; margin:5px 0; color:#000;}
</style>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/index.css">
<jsp:include page="inc.jsp"></jsp:include>

<script type="text/javascript" src="<%=path %>/js/index.js"></script>
<script type="text/javascript">

	/* var themes = '${themesName}';
	if(themes==""){
		if(localStorage.themesName!=undefined){
			themes = localStorage.themesName;
		}else{
			themes = "default";
		}
		window.location.href = "tree/reloadthemes.do?themes="+themes;
	} */
	
	$(function(){
		//验证规则
		$.extend($.fn.validatebox.defaults.rules, {    
		    length:{
		    	validator:function(value,param){ 
		            return value.length >= param[0] && value.length <= param[1]; 
		        }, 
		        message:"输入内容长度必须介于{0}和{1}之间." 
		    },
		    equals: {    
		        validator: function(value,param){    
		            return value == $(param[0]).val();    
		        },    
		        message: '两次输入的密码不一致'   
		    }    
		});  
		
		//更换主题
		/* $(".themes_reload:contains('"+themes+"')").css("border","2px solid red");
		$(".themes_reload").click(function(){
			var th = $(this).html();
			$.messager.confirm('确认对话框', '更换主题会刷新所有页面，确定继续么？', function(r){
				if (r){
					localStorage.themesName = th;
					location.href = "tree/reloadthemes.do?themes="+th;
				}
			});
		}); */
		//加载菜单树
		$("#tt").tree({
			url:'<%=path%>/tree/getTreeList.do',
			onLoadSuccess:function(node,data){
				if(data==-1){
					$.messager.alert('警告','登陆已过期，请重新登陆','warning');
					setTimeout(function(){
						window.location.href='login.jsp';
					}, 1000);
				}
			},
			onSelect:function(node){
				if(node.attributes.url!=""&&node.attributes.url!=undefined){
					addTab(node.text,node.attributes.url);
				}
			}
		});
	
		//修改用户密码
		$("#adminDiv").window({
			title:'管理员设置',
		    width:350,
		    height:250,
		    modal:true,
		    onOpen : function() {
		    	//清空表单
		    	document.getElementById("adminForm").reset();
				$('#adminDiv form :input').keyup(function(event) {
					if (event.keyCode == 13) {
						editPwd();
					}
				});
			}
		});
		//默认关闭
		$("#adminDiv").window('close');
		
		//解锁登录
		$("#loginDiv").window({
			title:'解锁登录',
		    width:350,
		    height:250,
		    modal:true,
		    onOpen : function() {
		    	$("#loginDiv form :input:eq(1)").val("");
				$('#loginDiv form :input').keyup(function(event) {
					if (event.keyCode == 13) {
						login();
					}
				});
			}
		});
		//默认关闭
		$("#loginDiv").window('close');
	});
	
	//修改密码
	var editPwd = function(){
		var check = $("#adminDiv form").form("validate");
		if(!check){
			$('#adminDiv form :input:eq(0)').focus();
		}else{
			$.ajax({
				url:'<%=path%>/user/aftUpdatePwd.do',
				type:'post',
				data:$("#adminDiv form").serialize(),
				success:function(result){
					if(result.code == 200){
						$.messager.alert('我的消息',result.message,'info');
						$.post('<%=path %>/user/logout.do', function(result) {
							if(result.flag){
								setTimeout(function(){
									location.replace('login.jsp');
								}, 1000);
							}
						}, 'json');
						
					}else{
						$.messager.alert('我的消息',result.message,'info');
						return false;
					}
				}
			});
		}
	}
	
	//解锁登录
	var login = function(){
		var check = $("#loginDiv form").form("validate");
		if(!check){
			$('#loginDiv form :input:eq(1)').focus();
		}else{
			$.ajax({
				url:'<%=path%>/user/login.do',
				type:'post',
				data:$('#loginDiv form').serialize(),
				success:function(result){
					if(result.code == 200){
						$("#loginDiv").window('close');
					}else{
						$.messager.alert('提示', result.data.pwdMsg, 'error');
					}
				}
			});
		}
	}

	//锁定密码
	var lockWindowFun = function() {
		$.post('<%=path%>/user/logout.do', function(result) {
			if(result.flag){
				$('#loginDiv').window('open');
			}
		}, 'json');
	};
	
	/**
	 * 注销
	 */
	function logoutFun(){
		$.messager.confirm('确认对话框', '确定退出?', function(r){
			if (r){
				$.post('<%=path%>/user/logout.do', function(result) {
					if(result.flag){
						/* setTimeout(function(){
							location.replace('login.jsp');
						}, 1000); */
						window.location.href='login.jsp';
					}
				}, 'json');
			}
		});
	}
	
</script>
</head>
<body class="easyui-layout">
    <!-- 页眉 -->
    <div data-options="region:'north',href:'jsp/north.jsp'" style="height: 90px;"></div>
    <!-- 页脚 -->
 	<div data-options="region:'south'" style="height:30px;">
	   	<div class="copyright">Copyright&nbsp; 2016 &nbsp; &copy; &nbsp; <a href="http://www.uflowertv.com" target="_blank">北京油菜花文化传播有限公司</a></div>
	</div> 
    <!-- 菜单栏 -->
    <div data-options="region:'west',title:'菜单'" style="width:150px;">
    	<ul id="tt"></ul>  	 
    </div>  
    <!-- 模块显示核心 --> 
    <div data-options="region:'center'" style="background:#eee;">
    	<div id="tabs" class="easyui-tabs" fit="true" border="false" >
           <div title="首页">
           		<div class="easyui-panel index_panel" title="公告信息" style="height:100%; width:100%; padding: 15px;">
					v20161218
					<ul>
						<li>将首页模块做出相应调整</li>
						<li>增加统计功能模块</li>
						<li>增加统计功能模块下日活跃用户量统计</li>
					<hr />
		    </div>
       	</div>
    </div> 
    <div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div>
	<div id="adminDiv">
		<div fit="true" class="easyui-tabs" style="width:400px;height:270px;">
		    <div title="修改密码" style="overflow:auto;padding:20px;">
	        	<form id="adminForm" method="post">
	        		<input type="hidden" name="uId" value="<%=sessionInfo.getUser().getId()%>">
		        	<table align="center" cellpadding="0" cellspacing="10">
		        		<tr>
		        			<td align="right">新密码：</td>
		        			<td><input name="uPwd" id="pwd" type="password" class="easyui-validatebox" required="required" validType="length[6,18]"></td>
		        		</tr>
		        		<tr>
		        			<td align="right">再次输入：</td>
		        			<td><input id="enterPwd" type="password" class="easyui-validatebox" required="required" validType="equals['#pwd']" ></td>
		        		</tr>
		        	</table>
		        	<div style="margin-left: 130px; margin-top: 10px;">
		        		<a class="easyui-linkbutton" href="javascript:;" onclick="editPwd();">
		        		<span style="font-size: 20px; color: red;">修&nbsp;改</span></a>
		        	</div>
	        	</form>
		    </div>
		</div>
	</div>
	<div id="loginDiv">
		<div fit="true" class="easyui-tabs" style="width:400px;height:270px;">
			<div title="解锁" style="overflow:auto;padding:20px;">
				<form method="post">
					<table align="center" cellpadding="0" cellspacing="10">
						<tr>
							<td align="right">邮箱:</td>
							<td><input name="email" type="text" readonly="readonly" value="<%=sessionInfo.getUser().getEmail() %>" /></td>
						</tr>
						<tr>
							<td align="right">密码:</td>
							<td><input name="pwd" type="password" class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
					</table>
				</form>
				<div style="margin-left: 130px; margin-top: 10px;">
		        		<a class="easyui-linkbutton" href="javascript:;" onclick="login();">
		        		<span style="font-size: 20px; color: red;">登&nbsp;录</span></a>
		        </div>
			</div>
		</div>
	</div>
</body>
</html>
