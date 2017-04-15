<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE HTML>  
<html>  
  <head>  
  		<base href="<%=basePath%>">
  	    <title>反馈问题</title>
  	    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport">
        <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/0.4.3/weui.css"/>
	    <script type='text/javascript' src="<%=path %>/js/jquery.min.js"></script>  
	  	<script type="text/javascript" charset="utf-8">
	  	$.weui = {};  
		$.weui.alert = function(options){  
		    options = $.extend({title: '警告', text: '警告内容'}, options);  
		    var $alert = $('.weui_dialog_alert');  
		    $alert.find('.weui_dialog_title').text(options.title);  
		    $alert.find('.weui_dialog_bd').text(options.text);  
		    $alert.on('touchend click', '.weui_btn_dialog', function(){  
		        $alert.hide();  
		    });  
		    $alert.show();  
		};  
		
		function isPhoneNo(phone) { 
			 var pattern = /^1[34578]\d{9}$/; 
			 return pattern.test(phone); 
		}
		var openid = '${follower.openid}';
	  	var arr = new Array();
		$(function () {  
		    // 允许上传的图片类型  
		    var allowTypes = ['image/jpg', 'image/jpeg', 'image/png', 'image/gif'];  
		    // 1024KB，也就是 1MB  
		    var maxSize = 1024 * 1024 * 10;  //M
		    // 图片最大宽度  
		    var maxWidth = 300;  
		    // 最大上传图片数量  
		    var maxCount = 5;
		    $('.js_file').on('change', function (event) {  
		        var files = event.target.files;  
		        // 如果没有选中文件，直接返回  
		        if (files.length === 0) {  
		            return;  
		        }  
		        for (var i = 0, len = files.length; i < len; i++) {  
		            var file = files[i];  
		            var reader = new FileReader();  
		  
		            // 如果类型不在允许的类型范围内  
		            if (allowTypes.indexOf(file.type) === -1) {  
		                $.weui.alert({text: '该类型不允许上传'});  
		                continue;  
		            }  
		            if (file.size > maxSize) {  
		                $.weui.alert({text: '图片太大，不允许上传'});  
		                continue;  
		            }  
		            if ($('.weui_uploader_file').length >= maxCount) {  
		                $.weui.alert({text: '最多只能上传' + maxCount + '张图片'});  
		                return;  
		            }  
		            reader.onload = function (e) {  
		                var img = new Image();  
		                img.onload = function () {  
		                    // 不要超出最大宽度  
		                    var w = Math.min(maxWidth, img.width);  
		                    // 高度按比例计算  
		                    var h = img.height * (w / img.width);  
		                    var canvas = document.createElement('canvas');  
		                    var ctx = canvas.getContext('2d');  
		                    // 设置 canvas 的宽度和高度  
		                    canvas.width = w;  
		                    canvas.height = h;  
		                    ctx.drawImage(img, 0, 0, w, h);  
		                    var base64 = canvas.toDataURL(file.type);  
		  
		                    // 插入到预览区  
		                    var $preview = $('<li class="weui_uploader_file weui_uploader_status" style="background-image:url(' + base64 + ')"><div class="weui_uploader_status_content">0%</div></li>');  
		                    $('.weui_uploader_files').append($preview);  
		                    var num = $('.weui_uploader_file').length;  
		                    $('.js_counter').text(num + '/' + maxCount);  
		  
		                    // 然后假装在上传，可以post base64格式，也可以构造blob对象上传，也可以用微信JSSDK上传  
		  					arr.push(base64.split(",")[1]);
		  					
		                    var progress = 0;  
		                    function uploading() {  
		                        $preview.find('.weui_uploader_status_content').text(++progress + '%');  
		                        if (progress < 100) {  
		                            setTimeout(uploading, 30);  
		                        }  
		                        else {  
		                            // 如果是失败，塞一个失败图标  
		                            //$preview.find('.weui_uploader_status_content').html('<i class="weui_icon_warn"></i>');  
		                            $preview.removeClass('weui_uploader_status').find('.weui_uploader_status_content').remove();  
		                        }  
		                    }  
		                    setTimeout(uploading, 30);  
		                };  
		  
		                img.src = e.target.result;  
		            };  
		            reader.readAsDataURL(file);  
		        }
		    });  
		    $('.maxl').bind('input oninput', function() {  
			    $('.maxm span').html($(this).val().length);  
			});
			
			$(".test_num").blur(function(){
				if(!isPhoneNo($(this).val())){
					$.weui.alert({text: '请输入正确的手机号'}); 
				}
			})
			
			$("#cancel").click(function(){
				  //清空表单
				 document.getElementById("addForm").reset();
				   //删除原有图片
				$("#picBox").children().remove();
				arr = [];
			})
			
			$("#submit").click(function(){
				if($("#type").val()!=0&&$("#title").val().length!==0&&$("#question").val().length!==0){
					var json = JSON.stringify(arr);
					$.ajax({
						type:"post",
						url:"<%=path %>/question/saveQuestion.do",
						async:true,
						data:{
							   base64Img:json,
							   wxUserId:openid,
							   wxUserQuestionTitle:$("#title").val(),
							   wxUserQuestionType:$("#type").val(),
							   wxUserPhone:$("#phone").val(),
							   wxUserQuestionContent:$("#question").val()
						},
						success: function(data){
							   //清空表单
							   document.getElementById("addForm").reset();
							   //删除原有图片
							   $("#picBox").children().remove();
							   arr = [];
							   alert(data.message);
						},
					    error:function(data){
							   alert(data.message);
						}
					});
				}else{
					$.weui.alert({text: '请完善信息'}); 
				}
			})
		}); 
	  	
	  	</script>
   </head>  
  <body> 
  	<form id="addForm">
		<!--问题-->
		<div class="weui_cells">
			<div class="weui_cell">
		        <div class="weui_cell_hd">
		        	<label class="weui_label">问题标题</label>
		        </div>
		        <div class="weui_cell_bd weui_cell_primary">
		            <input class="weui_input" type="text" id="title" name="wxUserQuestionTitle" />
		        </div>
	   		</div>
		</div>
		<!--问题类型-->
        <div class="weui_cells">
	        <div class="weui_cell weui_cell_select weui_select_after">
	           <div class="weui_cell_bd"><label class="weui_label">问题类型</label></div> 
	           <div class="weui_cell_hd weui_cell_primary">
			        <select class="weui_select" name="wxUserQuestionType" id="type">
			            <option value="0">--请选择--</option>
			            <option value="物流">物流</option>
			            <option value="书籍">书籍</option>
			            <option value="观看">观看</option>
			            <option value="购买">购买</option>
			            <option value="其他">其他</option>
			        </select>
		        </div>
	        </div>
    	</div>
		<!--手机号码-->
        <div class="weui_cells">
	        <div class="weui_cell weui_cell_select weui_select_before">
	            <div class="weui_cell_hd">
	                <select class="weui_select" name="wxUserPhone">
	                    <option value="1">+86</option>
	                    <option value="2">+80</option>
	                    <option value="3">+84</option>
	                    <option value="4">+87</option>
	                </select>
	            </div>
	            <div class="weui_cell_bd weui_cell_primary">
	                <input class="weui_input test_num" id="phone" type="number" pattern="[0-9]*" placeholder="请输入号码"/>
	            </div>
	        </div>
    	</div>
	    <!--上传图片-->
	    <div class="weui_cells weui_cells_form">
	        <div class="weui_cell">
	            <div class="weui_cell_bd weui_cell_primary">
	                <div class="weui_uploader">
	                    <div class="weui_uploader_hd weui_cell">
	                        <div class="weui_cell_bd weui_cell_primary">图片上传</div>
	                        <div class="weui_cell_ft js_counter">0/5</div>
	                    </div>
	                    <div class="weui_uploader_bd" >
	                        <ul class="weui_uploader_files" id="picBox"></ul>
	                        <div class="weui_uploader_input_wrp">
	                            <input class="weui_uploader_input js_file" type="file"  multiple="multiple" />
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <!--文本域-->
	    <div class="weui_cells weui_cells_form">
	    	<div class="weui_cell">
	    		<div class="weui_cell_bd weui_cell_primary">
	            <div class="weui_cell_primary weui_cell_bd">问题描述</div>
	            <div class="weui_cell_bd weui_cell_primary">
	                <textarea class="weui_textarea" name="wxUserQuestionContent" id="question" placeholder="在这里输入您的意见" rows="3" maxlength="200"></textarea>
	                <div class="weui_textarea_counter maxm"><span>0</span>/200</div>
	            </div>
	            </div>
	        </div>
	    </div>	
	    <!--提交-->
	    <div class="weui_cells weui_cells_form">
	    	<div class="weui_cell">
	    		<div class="weui_cell_hd  weui_cell_primary" >
	    			<a href="javascript:;" id="submit" class="weui_btn weui_btn_primary" id="submit">提交</a>
	    		</div>
		        <div class="weui_cell_bd weui_cell_primary">
		            <a id="cancel" href="javascript:;" class="weui_btn weui_btn_warn">重置</a>
		        </div>
			</div>
	    </div>
	    <!--警告语-->
	    <div class="weui_dialog_alert" style="display: none;">  
		    <div class="weui_mask"></div>  
		    	<div class="weui_dialog">  
		      	<div class="weui_dialog_hd"><strong class="weui_dialog_title">警告</strong></div>  
	      		<div class="weui_dialog_bd">弹窗内容，告知当前页面信息等</div>  
	     		<div class="weui_dialog_ft">  
	        		<a href="javascript:;" class="weui_btn_dialog primary">确定</a>  
	      		</div>  
	   		</div>  
	  	</div>
	  </form>
  </body>  
  <script src="https://cdn.bootcss.com/zepto/1.1.6/zepto.min.js"></script>
</html>  