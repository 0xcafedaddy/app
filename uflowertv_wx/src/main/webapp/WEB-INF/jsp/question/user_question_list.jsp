<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>未处理</title>
    <style type="text/css">
		.cc {
		 overflow:hidden;
		 text-overflow:ellipsis;
		 cursor: auto;
		 color: #999999;
		 text-decoration: none;
		}
    </style>
   	<jsp:include page="../inc.jsp"></jsp:include>
   	<script type="text/javascript">
   
   	$(function() {
   		initGride('wechat/question/userQuestionList?status=0');
	});
   	
  	//显示详情
	function questionInfo(id,status){
		window.location.href="wechat/question/questionInfo?id="+id+"&status="+status;
	}
	/**
	 * 图片显示
	 */
	function picture_Show(value){
		$('#mydialog').dialog({
			onOpen:function(){
				$.post('wechat/question/getImgNameList' , {id:value},function(result){
					$('#imgName1').attr('src', result[0]);
					$('#imgName2').attr('src', result[1]);
					$('#imgName3').attr('src', result[2]);
					$('#imgName4').attr('src', result[3]);
					$('#imgName5').attr('src', result[4]);
					$("#a1").attr("href",result[0]);
					$("#a2").attr("href",result[1]);
					$("#a3").attr("href",result[2]);
					$("#a4").attr("href",result[3]);
					$("#a5").attr("href",result[4]);
				});
			}
		});
		$('#mydialog').dialog('open');
		$('#imgName1').attr('src', "");
		$('#imgName2').attr('src', "");
		$('#imgName3').attr('src', "");
		$('#imgName4').attr('src', "");
		$('#imgName5').attr('src', "");
		$("#a1").attr("href","");
		$("#a2").attr("href","");
		$("#a3").attr("href","");
		$("#a4").attr("href","");
		$("#a5").attr("href","");
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
			pageList : [ 10, 20, 30 ],
			pagination : true,
			columns : [ [ {
				field : 'wxUserQuestionType',
				title : '问题类型',
				width : 150,
				align : 'center'
			},{
				field : 'wxUserQuestionContent',
				title : '问题描述',
				width : 200,
				align : 'center',
				formatter : function(value, row, index) {
					return "<span class=cc><nobr><a title=\""+value+"\">"+value+"</a></nobr></span>";
				}
			}, {
				field : 'createTime',
				title : '时间',
				width : 150,
				align : 'center'
			}, {
				field : 'status',
				title : '状态',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(value == 0){
						return "未处理";
					}else{
						return "待跟踪";
					}
				}
			}, {
				field : 'wxUserQuestionImg',
				title : '查看图片',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					 if (value=="" || null == value){
					        return "暂无图片";
				        } else {
				     		return "<a href='javascript:void(0)' onclick='picture_Show(\""+row.id+"\")'> 查看详情</a>";
				      }
				}
			},{
				field : 'opt',
				title : '操作',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					return "<a href='javascript:void(0);' onclick='questionInfo(\"" + row.id + "\",\"" + row.status + "\")'>查看</a>";
				}
			} ] ],
			onLoadSuccess:function(){//分页后清空选择项
				 $(this).datagrid('clearChecked');
			}
		});
	}
	
	
   	/**
	 * 查询选项
	 */
	function choose(status){
		var url = "wechat/question/userQuestionList?status="+status;
		initGride(url);
	}
   	</script>
  </head>
  <body class="easyui-layout">
		<div id="mydialog" title="图片列表" modal=true  draggable=false class="easyui-dialog" closed=true style="width:530px;height: 350px;">
			<table align="center" cellpadding="0" cellspacing="8">
				<tr>
					<td>
						<a id="a1" href="" target="_blank"><img id="imgName1" src="" alt="加载失败" style="width: 160px; height: 140px;"></a>
					</td>
					<td>
						<a id="a2" href="" target="_blank"><img id="imgName2" src="" alt="加载失败" style="width: 160px; height: 140px;"></a>
					</td>
					<td>
						<a id="a3" href="" target="_blank"><img id="imgName3" src="" alt="加载失败" style="width: 160px; height: 140px;"></a>
					</td>
				</tr>
				<tr>
					<td>
						<a id="a4" href="" target="_blank"><img id="imgName4" src="" alt="加载失败" style="width: 160px; height: 140px;"></a>
					</td>
					<td>
						<a id="a5" href="" target="_blank"><img id="imgName5" src="" alt="加载失败" style="width: 160px; height: 140px;"></a>
					</td>
				</tr>
			</table>
		</div>
	 <div data-options="region:'center',title:'列表'" style="padding:5px;background:#eee;">
		<div id="tool">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" onclick="choose(0)">待解决</a> 
			&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" onclick="choose(3)">待跟踪</a>
		</div>
		<table id="questionDataGrid" fit="true" toolbar="#tool"></table>
	</div>
  </body>
</html>
