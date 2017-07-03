//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
var localhostPaht = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/uimcardprj
var projectName = pathName.substring(0,pathName.substr(1).indexOf('/') + 1);

var url =  projectName+"/wechat/auto_reply";
		$(function(){
			//设置默认时间
			$(".detime").html(new Date().Format("yyyy-MM-dd hh:mm:ss"));
		 	 /*$.getJSON(url,function(data) {
		 		$.each(data, function(i,n){
		 			console.log(data);
//		 			console.log(i);
		 			$("#question").append('<div class="answer-item">'
		 		            +'<a class="j-answer-title answer-title hop"'
		 		            +'id="j-answer-title-'+n.id+'" relationId="'+n.id+'"'
		 		            +'onclick="getAnswer('+n.id+');">'+n.question+'</a>'
		 		       +'</div>');
		 		});*/
				$.ajax({
				   type: "POST",
				   url:url,
				   dataType:'json',
				   success: function(data){
					   $.each(data, function(i,n){
				 			//console.log(data);
				 			$("#question").append('<div class="answer-item">'
				 		            +'<a class="j-answer-title answer-title hop"'
				 		            +'id="j-answer-title-'+n.id+'" relationId="'+n.id+'"'
				 		            +'onclick="getAnswer('+n.id+');">'+n.question+'</a>'
				 		       +'</div>');
				 	  });
				   }
				});
		 	//代理问题的点击显示在右侧
		});
		
		function getAnswer(id){
				
				//将聊天内容下拉到最底部
				$('#wrapper').animate({scrollTop:99999},1000);
				$.ajax({
					   type: "POST",
					   url: url,
					   dataType:'json',
					   data:{id:id},
					   success: function(data){
							var str = "";
							var flag = false;
							$.each(data, function(i,n){
								if(n.code == '0'){
									flag = true;
									str+='<div class="answer-item">'
					 		            +'<a class="j-answer-title answer-title hop" style="color: black;"'
					 		            +'id="j-answer-title-'+n.id+'" relationId="'+n.id+'"'
					 		            +'>'+n.question+'</a>'
					 		      		 +'</div>';
								}else{
									str+='<div class="answer-item">'
					 		            +'<a class="j-answer-title answer-title hop"'
					 		            +'id="j-answer-title-'+n.id+'" relationId="'+n.id+'"'
					 		            +'onclick="getAnswer('+n.id+');">'+n.question+'</a>'
					 		      		 +'</div>';
								}
									
								
				 		    	
				 			})
				 			
						console.log(new Date().Format("yyyy-MM-dd hh:mm:ss"))	
							
//							console.log(str)
						var standard = $(	'<div class="chat-message-item clearfix">'+
												'<div class="chat-message-item-time">'+new Date().Format("yyyy-MM-dd hh:mm:ss")+'</div>'+
												'<div class="chat-message-item-kefu clearfix">'+
													'<div class="chat-message-item-face pull-left robot-icon" style="background-image: url(img/robot-default.png);"></div>'+
													'<div class="chat-message-item-content pull-left">'+
														'<div class="answer-list">您想咨询的是否为以下问题，点击就可以查看答案哦'+
														str+
														'</div>'+
													'</div>'+
												'</div>'+
											'</div>'
											);
											
						if(flag){
//				 		   var  standard	=  $('<div class="chat-message-item clearfix">'+
//												'<div class="chat-message-item-time">'+new Date().Format("yyyy-MM-dd hh:mm:ss")+'</div>'+
//												'<div class="chat-message-item-kefu clearfix">'+
//													'<div class="chat-message-item-face pull-left robot-icon" style="background-image: url(img/robot-default.png);"></div>'+
//													'<div class="chat-message-item-content pull-left">'+
//														'<div class="answer-list">详情请拔打客服电话'+
//														str+
//														'</div>'+
//													'</div>'+
//												'</div>'+
//											'</div>');
							var  standard =$(	'<div class="chat-message-item clearfix">'+
										'<div class="chat-message-item-time">'+new Date().Format("yyyy-MM-dd hh:mm:ss")+'</div>'+
										'<div class="chat-message-item-kefu clearfix">'+
											'<div class="chat-message-item-face pull-left robot-icon" style="background-image: url(img/robot-default.png);"></div>'+
											'<div class="chat-message-item-content pull-left">'+
												'<div class="answer-list">'+
												str+
												'</div>'+
												'<div>如果没有解决您的问题，请联系人工客服</div>'+
											'</div>'+
										'</div>'+
									'</div>'
									);
							
							
				 		      	}
						
						
						var user = $('<div id="j-user-message-1" class="chat-message-item clearfix">'+
										'<div class="chat-message-item-time">'+new Date().Format("yyyy-MM-dd hh:mm:ss")+'</div>'+
										'<div class="chat-message-item-user clearfix">'+
											'<div class="chat-message-item-face pull-right cust-icon" style="background-image: url(img/cust-default.jpg);"></div>'+
											'<div class="chat-message-item-main pull-right">'+
												'<div class="chat-message-item-content pull-right">'+$("#j-answer-title-"+id).html()+'</div>'+
												'<div class="chat-message-item-status pull-right">'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</div>');
							
							$("#j-main-chat-container").append(user);
							
				 			$("#j-main-chat-container").append(standard);
							
						   
					   }
					});
		 	
	 	}
		
		//发送消息  按钮  返回默认消息模板  
		touch.on("#j-bottom-icons-robot","hold tap",function(){
			$('#wrapper').animate({scrollTop:99999},1000);
			var echo = $('<div id="j-user-message-1" class="chat-message-item clearfix">'+
								'<div class="chat-message-item-time">'+new Date().Format("yyyy-MM-dd hh:mm:ss")+'</div>'+
								'<div class="chat-message-item-user clearfix">'+
									'<div class="chat-message-item-face pull-right cust-icon" style="background-image: url(img/cust-default.jpg);"></div>'+
									'<div class="chat-message-item-main pull-right">'+
										'<div class="chat-message-item-content pull-right">'+$("#j-chat-edit-area-robot").text()+'</div>'+
										'<div class="chat-message-item-status pull-right">'+
										'</div>'+
									'</div>'+
								'</div>'+
							'</div>');
//							console.log($("#j-chat-edit-area-robot").text()=null)
			if($.trim($("#j-chat-edit-area-robot").text()).length>0){
				$("#j-main-chat-container").append(echo);
				$(".clone").first().clone().appendTo($("#j-main-chat-container")).find(".detime").html(new Date().Format("yyyy-MM-dd hh:mm:ss"));
			}
			
			//点击后输入框置空
			$("#j-chat-edit-area-robot").text("").focus();
			
		})
		
