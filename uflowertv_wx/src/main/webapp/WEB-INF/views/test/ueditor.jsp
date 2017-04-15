<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>百毒在线编辑器</title>
    <link rel="stylesheet" type="text/css" href="css/common_header.css" />
    <link rel="stylesheet" type="text/css" href="css/h_themes.css" />
    <link rel="stylesheet" type="text/css" href="css/yui3-min.css" />
    <link rel="stylesheet" type="text/css" href="css/reply.css" />
    <link rel="stylesheet" type="text/css" href="css/reply1.css" />
    <link rel="stylesheet" type="text/css" href="js/ueditor/themes/default/css/ueditor.min.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.min.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
  	  var editor = new baidu.editor.ui.Editor({UEDITOR_HOME_URL : 'js/ueditor/',toolbars:[["bold","italic","underline","insertcode","simpleupload","unlink","link","undo","redo","preview"]],
			wordCount:false,
			elementPathEnabled:false,
			initialFrameHeight:100
			}); 
		editor.render('ask_content');
		var onSubmit = false;
		$(function(){
			$("#reply").click(function(){
				if(onSubmit == true){
					return false;
				}
				editor.sync();
				if(editor.getContent().length == 0){
					$("#editor-tip").html('请输入回复的内容');
					return false;
				}
				if(editor.getContent().length > 2000){
					$("#editor-tip").html('输入的内容过长，超过2000个字符');
					return false;
				}
				$("#form").attr("action","notice/reply.do");
				$("#reply").text('提交中...');
				onSubmit = true;
				var frm = $('#form');//frm.serialize()
				var content = UE.getEditor('ask_content').getContentTxt();
				var question_id = $("#question_id").val();
				$.post(frm.attr('action'), {content:content,question_id:question_id} , function(data){
					if(data.code && data.code==1) {
						window.location.href = 'notice/view/id.do?' + data.question_id;
					} else {
						$("#reply").text('提交');
						$("#editor-tip").html(data.msg);
						onSubmit = false;
					}
				}, 'json');
			});
		});
    </script>
  </head>
  <body>
 	 <div class="question-box">
		 <form id="form" method="post" enctype="multipart/form-data">
			<div class="hd-textarea">
				<img src="http://ask.bdqn.cn/img/jt.jpg" class="area-img"/>
				<textarea id="ask_content" name="content"></textarea>
				<p class="erro-p"><span id="editor-tip" class="errMessage"></span></p>
			</div>
			<input type="hidden" value="16434" name="question_id" id="question_id"/>
			<p class="tr"><a href="javascript:void(0);" id="reply" class="yui3-u submit-btn">提交</a></p>
		</form>	
	 </div>
  </body>
</html>
