<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>已处理</title>
   	<jsp:include page="../inc.jsp"></jsp:include>
   	<script type="text/javascript">
   	$(function() {
   		initGride('start/list');
		/**
		 * 查询
		 */
		$('#searchbtn').click(function(){
			$.messager.progress({
				title:"查询进度条",
				text:"正在查询。。。",
				interval:1000
			}); 
			var start = $('#start').datebox('getValue');  
			var end = $('#end').datebox('getValue');  
			initGride('start/list?start='+start+'&end='+end);
		});
		
		/**
		 * 清空
		 */
		$('#clearbtn').click(function(){
			$('#startDataGrid_form').form('clear');
			$.messager.progress({
				title:"清空进度条",
				text:"正在清空。。。",
				interval:1000
			}); 
			initGride('start/list');
		});
		
		/**
		 * 饼状图
		 */
		$('#charts').click(function(){
			window.location.href="redirect/statistics/day_activity_charts";
		});
	});
   	
	/**
	 * 初始化列表
	 */
   	function initGride(url) {
		$("#startDataGrid").datagrid({
			idField : 'id',
			url : url,
			rownumbers : true,
			fitColumns:true, 
			singleSelect : true,
			pageSize:10,
			pageList : [10],
			pagination : true,
			columns : [ [ {
				field : 'platformID',
				width:150,
				title : '平台',
				align : 'center',
				formatter : function(value, row, index) {
					if(value==2){
						return "联通";
					}
					return "大麦";
				} 
			},{
				field : 'dateTime',
				title : '时间段',
				width:250,
				align : 'center',
				formatter:formatMethod2
			}, {
				field : 'total',
				title : '访问量',
				width:150,
				align : 'center'
			} ] ],onLoadSuccess:function(){
		    	$.messager.progress('close');
		    }
		});
	}
	
   	/**
	 * 格式化时间
	 */
	function formatMethod(val,row) {
		var date = new Date(val);
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		var h = date.getHours();
		var mm = date.getMinutes();
		var s = date.getSeconds();
		var dateTime = y + "-" + (m < 10 ? ("0" + m) : m) + "-"
				+ (d < 10 ? ("0" + d) : d) + " " + (h < 10 ? ("0" + h) : h)
				+ ":" + (mm < 10 ? ("0" + mm) : mm) + ":"
				+ (s < 10 ? ("0" + s) : s);
		return dateTime;
	}
   	
	function formatMethod2(val,row) {
		var date = new Date(val);
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		var dateTime = y + "-" + (m < 10 ? ("0" + m) : m) + "-"
				+ (d < 10 ? ("0" + d) : d);
		return dateTime;
	}
   	</script>
  </head>
  <body class="easyui-layout">
  	 <div data-options="region:'north',title:'查询',split:true" style="height:90px;">
		<center>
			<form id="startDataGrid_form">
				<div style="margin-top: 10px;">
					时间段:<input style="width:155px"  class="easyui-datetimebox" name="start" id="start" editable="false" type="text"/>至
						 <input style="width:155px"  class="easyui-datetimebox" name="end" id="end" editable="false" type="text"/>
						 <a id="searchbtn" data-options="iconCls:'icon-search'" class="easyui-linkbutton">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="clearbtn" data-options="iconCls:'icon-clear'" class="easyui-linkbutton">清空</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="charts" data-options="iconCls:'icon-large-chart'" class="easyui-linkbutton">统计图</a>
				</div>
			</form>
 		</center>
	 </div>
	 <div data-options="region:'center',title:'列表'">
		<table id="startDataGrid"></table>
	</div>
  </body>
</html>
