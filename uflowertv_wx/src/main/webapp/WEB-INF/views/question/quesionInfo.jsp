<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>问题详情</title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var editor = new baidu.editor.ui.Editor({UEDITOR_HOME_URL : 'resources/ueditor/',toolbars:
		[["fullscreen"]],
// 		[["fullscreen","undo","redo","bold","italic","underline","fontfamily","fontsize","backcolor","forecolor", 
// 		  "insertorderedlist", "insertunorderedlist", "selectall", "cleardoc","unlink","link", "emotion",
// 		  "insertimage","preview"]],
// 		[["bold","italic","underline","insertcode","insertimage","unlink","link","undo","redo","preview"]],
	    maximumWords:2000,
		elementPathEnabled:false,
		initialFrameHeight:100,
		initialFrameWidth:640
		}); 
	editor.render('ask_content');
	$(function(){
		//验证规则
		$.extend($.fn.validatebox.defaults.rules, {    
			length:{
		    	validator:function(value,param){ 
		            return value.length >= param[0] && value.length <= param[1]; 
		        },     
		        message: '字数限制{0}-{1}'   
		    }
		});  
		var onSubmit = false;
		$("#reply").click(function(){
			if(onSubmit == true){
				return false;
			}
			editor.sync();
			if(editor.getContent().length == 0){
				$("#editor-tip").html('请输入回复的内容');
				return false;
			}
			if(editor.getContent().length > 3000){
				$("#editor-tip").html('输入的内容过长，超过2000个字符');
				return false;
			}
			var frm = $('#addForm');
			frm.attr("action","<%=path %>/question/replyQuestion.do");
			$("#reply").text('提交中...');
			onSubmit = true;
			$.post(frm.attr('action'),{
				id:'${question.id }',
				wxUserQuestionType:'${question.wxUserQuestionType}',
				wxUserId:'${question.wxUserId}',
				replyQuestionHuman:'${sessionScope.user.id }',
				status:1,
				wxUserQuestionContent:'${question.wxUserQuestionContent}',
				wxUserQuestionTitle:'${question.wxUserQuestionTitle}',
				replyQuestionContent:editor.getContentTxt()
			} ,
			function(data){
				if(data.code && data.code==1) {
					 $.messager.alert("提示信息",data.message,"info");
					   setTimeout(function(){
						   window.location.href = "<%=path %>/jsp/question/user_question_list.jsp";
					   }, 1000);
				} else {
					$("#reply").text('提交');
					$("#editor-tip").html(data.message);
					onSubmit = false;
				}
			}, 'json');
		});
		
		//返回
		$("#back").click(function(){
			window.location.href = "<%=path %>/jsp/question/user_question_list.jsp";
		});
		
		//转交其它部门
		$("#changeOther").click( function () {
			$.ajax({
			   type: "POST",
			   url: "<%=path %>/question/changeOther.do",
			   data: {
				   questionId:'${question.id }',
				   stauts:'3'
			   },
			   success: function(data){
				   $.messager.alert("提示信息",data.message,"info");
				   setTimeout(function(){
					   window.location.href = "<%=path %>/jsp/question/user_question_list.jsp";
				   }, 1000);
			   },
			   error:function(){
				   $.messager.alert("警告",data.message,"warning");
			   }
			});
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center',title:'问题详情',split:true" style="height:150px;">
		<div style="margin-top: 15px;margin-left: 190px;">
			提出时间:<input type="text" disabled="disabled" value="${question.createtime}" />
			&nbsp;&nbsp;&nbsp;&nbsp;
			问题类型:<input type="text" disabled="disabled" name="wxUserQuestionType"  value="${question.wxUserQuestionType}"/>
		</div>
		<div style="margin-top: 15px;">
			<table align="center" cellpadding="0" cellspacing="5">
				<tr>
					<td >问题描述</td>
				</tr>
				<tr>
					<td>
						<textarea rows="7" cols="100" disabled="disabled" name="wxUserQuestionContent">${question.wxUserQuestionContent}</textarea>
					</td>
				</tr>
			</table>
		</div>
		<form id="addForm">
			<table align="center" cellpadding="0" cellspacing="5">
				<tr>
					<td >问题回复</td>
				</tr>
				<tr>
					<td>
						<textarea name="replyQuestionContent" id="ask_content"></textarea>
						<p><span id="editor-tip" style="color: red;"></span></p>
					</td>
				</tr>
			</table>
		</form>
		<div style="margin-left:400px;">
			<a id="reply" href="javascript:;" class="easyui-linkbutton" size="small">提交</a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="changeOther" href="javascript:;" class="easyui-linkbutton" size="small">转给其它部门</a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="back" href="javascript:;" class="easyui-linkbutton" size="small">返回</a> 
		</div>
	</div>
</body>
</html>