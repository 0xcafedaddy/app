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
   	 <style type="text/css">
		.cc {
		 overflow:hidden;
		 text-overflow:ellipsis;
		 cursor: auto;
		 color: #999999;
		 text-decoration: none;
		}
    </style>
   	<script type="text/javascript">
   	$(function() {
   		initGride('question/userQuestionList?status=1');
		
		/**
		 * 查询
		 */
		$('#searchbtn').click(function(){
			$.messager.progress({
				title:"查询进度条",
				text:"正在查询。。。",
				interval:1000
			}); 
			$('#questionDataGrid').datagrid('load' ,formToObject($('#questionDataGrid_form')));
		});
		/**
		 * 清空
		 */
		$('#clearbtn').click(function(){
			$('#questionDataGrid_form').form('clear');
			$.messager.progress({
				title:"清空进度条",
				text:"正在清空。。。",
				interval:1000
			}); 
			$('#questionDataGrid').datagrid('load' ,{});
		});
	});
   	
  	//显示详情
	function questionInfo(id,status){
		window.location.href="question/questionInfo?id="+id+"&status="+status;
	}
	/**
	 * 初始化列表
	 */
   	function initGride(url) {
		$("#questionDataGrid").datagrid({
			idField : 'id',
			url : url,
			rownumbers : true,
			singleSelect : true,
			fit:true,
			pageSize:5,
			pageList : [ 5, 10, 20 ],
			pagination : true,
			columns : [ [ {
				field : 'wxUserQuestionType',
				title : '问题类型',
				width : 80,
				align : 'center'
			},{
				field : 'wxUserQuestionContent',
				title : '问题描述',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return "<span class=cc><nobr><a title=\""+value+"\">"+value+"</a></nobr></span>";
				}
			}, {
				field : 'createTime',
				title : '提问时间',
				width : 150,
				align : 'center'
			}, {
				field : 'status',
				title : '状态',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					if(value == 1){
						return "待确认";
					}else if(value == 4){
						return "已解决";
					}else{
						return "未解决";
					}
				}
			}, {
				field : 'completeTime',
				title : '回复时间',
				width : 150,
				align : 'center',
			}, {
				field : 'replyQuestionHuman',
				title : '处理人',
				width : 80,
				align : 'center'
			}, {
				field : 'replyQuestionContent',
				title : '回复摘要',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return "<span class=cc><nobr><a title=\""+value+"\">"+value+"</a></nobr></span>";
				}
			},{
				field : 'opt',
				title : '操作',
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					return "<a href='javascript:;' onclick='questionInfo(\"" + row.id + "\",\"" + row.status + "\")'>查看</a>";
				}
			} ] ],onLoadSuccess:function(){
		    	$.messager.progress('close');
		    }
		});
	}
	
	/**
	 * 查询选项
	 */
	function choose(status){
		var url = "question/userQuestionList?status="+status;
		initGride(url);
	}
   	</script>
  </head>
  <body class="easyui-layout">
  	 <div data-options="region:'north',title:'查询',split:true" style="height:180px;">
		<div align="left">
			<form method="post" id="questionDataGrid_form">
				<div style="margin-top: 10px; margin-left: 92px;">
					问题类型:<input name="wxUserQuestionType" type="text" />
					回复人:<input name="replyQuestionHuman" type="text" />
					回复时间:<input style="width:155px"  class= "easyui-datetimebox" name="completetime" editable="false" type="text"/>至
						 <input style="width:155px"  class= "easyui-datetimebox" name="createtime" editable="false" type="text"/>
				</div>
				<div style="margin-top: 10px; margin-left: 80px;">
					提问关键字:<input name="wxUserQuestionContent" type="text" size="120px;"/>
				</div>
				<div style="margin-top: 10px; margin-left: 80px;">
					回复关键字:<input name="replyQuestionContent" type="text" size="120px;"/>
				</div>
			</form>
			<center>
	 			<span>
	 				<a id="searchbtn" data-options="iconCls:'icon-search'" class="easyui-linkbutton">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="clearbtn" data-options="iconCls:'icon-clear'" class="easyui-linkbutton">清空</a>
	    		</span>
	 		</center>
		</div>
	</div>
  	 <div data-options="region:'center',title:'列表'" style="padding:5px;background:#eee;">
		<div id="tool">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" onclick="choose(1)">待确认</a> 
			&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" onclick="choose(4)">已解决</a>
			&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" onclick="choose(5)">未解决</a>
		</div>
		<table id="questionDataGrid" fit="true" toolbar="#tool"></table>
	</div>
  </body>
</html>
