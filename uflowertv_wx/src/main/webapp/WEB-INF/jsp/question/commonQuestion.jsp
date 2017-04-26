<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>常见问题</title>
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
		  /*  var editor = UE.getEditor('question',{
			   toolbars:[[]],
			   autoClearinitialContent:true,
			   initialFrameHeight:140,
			   initialFrameWidth:650,
			   enableContextMenu:false,
			   elementPathEnabled:false,
			   maximumWords:500
		   }); */
		   
		 //触发函数
			/* $('#questionType').combobox({
				url:'question/getQuestionType',    
			    valueField:'id',    
			    textField:'questionType',
			    editable:false,
			    panelHeight:'auto',
			    onLoadSuccess:function(){
			    	
			    }
			});   */
		$(function() {
			//初始化
			initGride('wechat/question/getCommonQuestionList');
	   		/**
			 * 提交表单
			 */
			 $('#save').click(function(){
					if($('#myform').form('validate')){
						$.ajax({
							type: 'post' ,
							url: flag=='add'?'wechat/question/saveCommonQuestion':'wechat/question/updateCommonQuestion',
							data: $('#myform').serialize(),
							dataType:'json' ,
							success:function(result){
								//1 关闭窗口
								$('#mydialog').dialog('close');
								//2刷新datagrid 
								$('#CommoQuestionData').datagrid('reload');
								$('#CommoQuestionData').datagrid('unselectAll');
								//3 提示信息
								$.messager.alert('你的消息',result.message,'info');
							} ,
							error:function(){
								$.messager.alert('你的消息',result.message,'error');
							}
						});
					}
				});
			/**
			 * 新增根节点
			 */
			 $('#rootSave').click(function(){
					if($('#rootForm').form('validate')){
						$.ajax({
							type: 'post' ,
							url: 'wechat/question/saveCommonQuestion',
							data: $('#rootForm').serialize(),
							dataType:'json' ,
							success:function(result){
								//1 关闭窗口
								$('#rootDialog').dialog('close');
								//2刷新datagrid 
								$('#CommoQuestionData').datagrid('reload');
								$('#CommoQuestionData').datagrid('unselectAll');
								//3 提示信息
								$.messager.alert('你的消息',result.message,'info');
							} ,
							error:function(){
								$.messager.alert('你的消息',result.message,'error');
							}
						});
					}
				});
			 
				/**
				 * 关闭窗口方法
				 */
				$('#cancel').click(function(){
					$('#mydialog').dialog('close');
				});
				$('#rootCancel').click(function(){
					$('#rootDialog').dialog('close');
				});
					
				$('#searchbtn').click(function(){
					$('#CommoQuestionData').datagrid('load' ,serializeForm($('#mysearch')));
				});
				
				$('#clearbtn').click(function(){
					$('#mysearch').form('clear');
					$('#CommoQuestionData').datagrid('load' ,{});
				});
	   		
		});
			
			
		var flag;
		var toolbar = 
			[{
				text : '新增根节点',
				iconCls:'icon-add' , 
				handler : function(){
					$('#rootDialog').dialog({
						title:'新增问题'
					});
					$('#rootDialog').dialog('open'); //打开窗口
					//清空表单
					$(':input','#rootForm')  
					 .not(':button, :submit, :reset, :hidden')  
					 .val('')  
					 .removeAttr('checked')  
					 .removeAttr('selected');  
				}
			},'-',{
				text : '新增子节点',
				iconCls:'icon-add' , 
				handler : function(){
					flag = 'add';
					var row = $('#CommoQuestionData').datagrid('getSelected');  // 获得选中所有列集合	
					if(row == null){
						$.messager.alert('新增','请选择问题类型！');
						return ;
					}else{
						$('#mydialog').dialog({
							title:'新增问题'
						});
						$('#mydialog').dialog('open'); //打开窗口
						//清空表单
						$(':input','#myform')  
						 .not(':button, :submit, :reset, :hidden')  
						 .val('')  
						 .removeAttr('checked')  
						 .removeAttr('selected');  
						
						$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
							pid:row.id,
							questionType:row.questionType,
							p_question:row.question
						});
					}
				}
			},'-',{
				text : '编辑',
				iconCls:'icon-edit' , 
				handler : function(){
					flag = 'edit';
					var row = $('#CommoQuestionData').datagrid('getSelected');  // 获得选中所有列集合	
					if(row == null){
						$.messager.alert('编辑','请选择问题类型！');
						return ;
					}else{
						$('#mydialog').dialog({
							title:'编辑问题'
						});
						$('#mydialog').dialog('open'); //打开窗口
						//清空表单
						$(':input','#myform')  
						 .not(':button, :submit, :reset, :hidden')  
						 .val('')  
						 .removeAttr('checked')  
						 .removeAttr('selected');  
						
						$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
							id:row.id,
							pid:row.pid,
                            p_question:row.p_question,
							questionType:row.questionType,
							question:row.question,
							createTime:row.createTime,
							code:row.code
						});
					}
				}
			},'-',{
				text : '删除',	//删除功能假删除
				iconCls:'icon-remove' , 
				handler : function(){
					var row = $('#CommoQuestionData').datagrid('getSelected');  // 
					if(row==null){
						$.messager.alert('删除','请选择问题类型！');
						return ;
					}
					$.messager.confirm('提示信息' , '确认删除?' , function(r){
						if(r){
							$.ajax({
								type: 'post' ,
								url: 'wechat/question/delCommonQuestion',
								data:{id:row.id} ,
								dataType:'json' ,
								success:function(result){
									//2刷新datagrid 
									$('#CommoQuestionData').datagrid('reload');
									$('#CommoQuestionData').datagrid('unselectAll');
									//3 提示信息
									$.messager.alert('你的消息',result.message,'info');
								} ,
								error:function(result){
									$.messager.alert('你的消息',result.message,'error');
								  }
							  });
						}
					});
				}
			},'-',{
				text:'查询' , 
				iconCls:'icon-search' , 
				handler:function(){
					$('#lay').layout('expand' , 'north');
				}
			}];
      function initGride(url){
			$('#CommoQuestionData').datagrid({
				idField:'id' ,		//只要创建数据表格 就必须要加 ifField
				title:'常见问题' ,
				fit:true ,
				url: url,
				loadMsg: '数据正在加载,请耐心的等待...' ,
				rownumbers:true ,
				singleSelect:true ,				//单选模式 
				pagination: true , 
				pageSize: 10,
				pageList:[5,10,20] ,
				columns:[[
					{
						field:'questionType' ,
						title:'问题类型' ,
						width:100,
						align:'center'
					},{
						field:'question' ,
						title:'问题描述' ,
						width:250,
						align:'center',
						formatter : function(value, row, index) {
							if(value != null){
								return "<span class=cc><nobr><a title=\""+value+"\">"+value+"</a></nobr></span>";
							}else{
								return "";
							}
						}
					},{
						field:'p_question' ,
						title:'上级问题描述' ,
						width:250,
						align:'center',
						formatter : function(value, row, index) {
							if(value != null){
								return "<span class=cc><nobr><a title=\""+value+"\">"+value+"</a></nobr></span>";
							}else{
								return "";
							}
						}
					}
				]], 
				toolbar:toolbar,
				onLoadSuccess:function(){//分页后清空选择项
					 $(this).datagrid('clearChecked');
				}
		});
	}
		 
		 
	//js方法：序列化表单 			
	function serializeForm(form){
		var obj = {};
		$.each(form.serializeArray(),function(index){
			if(obj[this['name']]){
				obj[this['name']] = obj[this['name']] + ','+this['value'];
			} else {
				obj[this['name']] =this['value'];
			}
		});
		return obj;
	}
</script>
 </head>
  <body class="easyui-layout">
  		<div id="lay" class="easyui-layout" style="width: 100%;height:100%" >
	  		<div region="north" title="用户查询" collapsed=true style="height:90px;" >
				<form id="mysearch" method="post">
					<div style="margin-top: 20px;">
						<center>
							问题类型:<input name="questionType" type="text" />
							&nbsp;&nbsp;&nbsp;<a id="searchbtn" data-options="iconCls:'icon-search'" class="easyui-linkbutton">查询</a> 
							&nbsp;&nbsp;&nbsp;<a id="clearbtn" data-options="iconCls:'icon-clear'" class="easyui-linkbutton">清空</a>
				 		</center>
					</div>
				</form>
			</div>
			<div region="center" >
				<table id="CommoQuestionData"></table>
			</div>
		</div>
		<div id="mydialog" title="新增" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" class="easyui-dialog" style="width:620px;height: 220px;">
	  		<form id="myform" action="" method="post">
	  			<input type="hidden" name="id">
	  			<input type="hidden" name="pid">
	  			<input type="hidden" name="p_question">
	  			<input type="hidden" name="questionType">
	  			<input type="hidden" name="createTime">
	  			<input type="hidden" name="code">
  				<table>
					<tr>
						<td>问题描述:</td>
						<td>
							<textarea rows="5" cols="80" name="question" id="question" class="easyui-validatebox" required="true"></textarea>
						</td>
					</tr>
  				</table>
	  		</form> 	
	  		<div style="margin-top: 15px;margin-left: 230px;">
				<a id="save" data-options="iconCls:'icon-ok'" class="easyui-linkbutton">确定</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="cancel" data-options="iconCls:'icon-cancel'" class="easyui-linkbutton">关闭</a>
			</div>		
		</div>
		<div id="rootDialog" title="新增" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" class="easyui-dialog" style="width:620px;height: 220px;">
	  		<form id="rootForm" action="" method="post">
	  			<input type="hidden" name="pid" value="0">
  				<table>
					<tr>
						<td>问题类型:</td>
						<td>
							<input type="text" name="questionType" class="easyui-validatebox" required="true">
						</td>
					</tr>
					<tr>
						<td>问题描述:</td>
						<td>
							<textarea rows="5" cols="80" name="question" class="easyui-validatebox" required="true"></textarea>
						</td>
					</tr>
  				</table>
	  		</form> 	
	  		<div style="margin-top: 15px;margin-left: 230px;">
				<a id="rootSave" data-options="iconCls:'icon-ok'" class="easyui-linkbutton">确定</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="rootCancel" data-options="iconCls:'icon-cancel'" class="easyui-linkbutton">关闭</a>
			</div>		
		</div>
  </body>
</html>
