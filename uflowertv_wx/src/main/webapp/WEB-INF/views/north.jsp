<%@page import="com.uflowertv.model.SessionInfo"%>
<%@page import="com.uflowertv.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
%>
<script type="text/javascript" charset="utf-8">
	var showMyInfoFun = function() {
		/* var dialog = parent.sy.modalDialog({
			title : '我的信息',
			url : sy.contextPath + '/securityJsp/userInfo.jsp'
		}); */
		$.messager.alert('提示', '暂未开放', 'info');
	};
	/**
	 * 更换主题
	 * 
	 * @author 孙宇
	 * @requires jQuery,EasyUI
	 * @param themeName
	 */
	var changeTheme = function(themeName) {
		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);

		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for (var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				try {
					$(ifr).contents().find('#easyuiTheme').attr('href', href);
				} catch (e) {
					try {
						ifr.contentWindow.document.getElementById('easyuiTheme').href = href;
					} catch (e) {
					}
				}
			}
		}

		cookie('easyuiTheme', themeName, {
			expires : 7
		});
	};
	
	var cookie = function(key, value, options) {
		if (arguments.length > 1 && (value === null || typeof value !== "object")) {
			options = $.extend({}, options);
			if (value === null) {
				options.expires = -1;
			}
			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setDate(t.getDate() + days);
			}
			return (document.cookie = [ encodeURIComponent(key), '=', options.raw ? String(value) : encodeURIComponent(String(value)), options.expires ? '; expires=' + options.expires.toUTCString() : '', options.path ? '; path=' + options.path : '', options.domain ? '; domain=' + options.domain : '', options.secure ? '; secure' : '' ].join(''));
		}
		options = value || {};
		var result, decode = options.raw ? function(s) {
			return s;
		} : decodeURIComponent;
		return (result = new RegExp('(?:^|; )' + encodeURIComponent(key) + '=([^;]*)').exec(document.cookie)) ? decode(result[1]) : null;
	};
</script>
<div class="top">
	<div class="global-width">
		<img src="images/logo.gif" class="logo" />
	</div>
</div>
<div id="sessionInfoDiv" style="position: absolute; right: 10px; top: 5px;">
	<%
		if (sessionInfo != null) {
			out.print(StringUtil.formateString("欢迎{0}", sessionInfo.getUser().getUname()));
		}
	%>
</div>
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'ext-icon-rainbow'">更换皮肤</a> 
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'ext-icon-cog'">控制面板</a> 
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'ext-icon-disconnect'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');" title="default">默认</div>
	<div onclick="changeTheme('gray');" title="gray">灰色</div>
	<div onclick="changeTheme('black');" title="black">黑色</div>
	<div onclick="changeTheme('metro');" title="metro">metro</div>
	<div onclick="changeTheme('bootstrap');" title="bootstrap">bootstrap</div>
	<div class="menu-sep"></div>
	<div onclick="changeTheme('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="changeTheme('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="changeTheme('metro-green');" title="metro-green">metro-green</div>
	<div onclick="changeTheme('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="changeTheme('metro-red');" title="metro-red">metro-red</div>
	<!-- <div class="themes_reload" style="background-color: #3d3d3d;color: white;">black</div>
	<div class="themes_reload" style="background-color: #F2F2F2">bootstrap</div>
	<div class="themes_reload" style="background-color: #E0ECFF;">default</div>
	<div class="themes_reload" style="background-color: gray;">gray</div>
	<div class="themes_reload" style="background-color: #ffffff">metro</div>
	<div class="themes_reload" style="background-color: gray;">metro-gray</div>
	<div class="themes_reload" style="background-color: green;">metro-green</div>
	<div class="themes_reload" style="background-color: orange;">metro-orange</div>
	<div class="themes_reload" style="background-color: #F6C1BC;">metro-red</div>
	<div class="themes_reload" style="background-color: #AED0EA">ui-cupertino</div>
	<div class="themes_reload" style="background-color: #4C3000">ui-sunny</div> -->
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-user_edit'" onclick="$('#adminDiv').window('open');">修改密码</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-user'" onclick="showMyInfoFun();">我的信息</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-lock'" onclick="lockWindowFun();">锁定窗口</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-door_out'" onclick="logoutFun();">退出系统</div>
</div>