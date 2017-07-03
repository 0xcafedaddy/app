<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <script type="text/javascript" src="js/nuj5imv.js"></script>
      <script type="text/javascript">try{Typekit.load();}catch(e){}</script>
      <style type="text/css">
          body {
              font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
              background: #eee;
          }
          a:link, a:visited {
              text-decoration: none;
              color: #fff;
              border: none;
          }
          a img {
              border: none;
          }
          div.mod {
              text-align: center;
          }
          /* button styles */
          .btn {
              display: inline-block;
              -webkit-border-radius: 8px;
              -moz-border-radius: 8px;
              border-radius: 8px;
              -webkit-box-shadow:
                      0 8px 0 #1a74a1,
                      0 15px 20px rgba(0,0,0,.35);
              -moz-box-shadow:
                      0 8px 0 #1a74a1,
                      0 15px 20px rgba(0,0,0,.35);
              box-shadow:
                      0 8px 0 #1a74a1,
                      0 15px 20px rgba(0,0,0,.35);
              -webkit-transition: -webkit-box-shadow .2s ease-in-out;
              -moz-transition: -moz-box-shadow .2s ease-in-out;
              -o-transition: -o-box-shadow .2s ease-in-out;
              transition: box-shadow .2s ease-in-out;
          }
          .btn span {
              display: inline-block;
              padding: 10px  20px;
              font-family: "cooper-black-std-1", "cooper-black-std-2", Helvetica, Arial, sans-serif;
              line-height: 1;
              text-shadow: 0 -1px 1px rgba(19,65,88,.8);
              background: #3194c6;
              background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#3194c6), to(#5bacd6));
              background: -moz-linear-gradient(#3194c6, #5bacd6);
              -webkit-border-radius: 8px;
              -moz-border-radius: 8px;
              border-radius: 8px;
              -webkit-box-shadow: inset 0 -1px 1px rgba(255,255,255,.15);
              -moz-box-shadow: inset 0 -1px 1px rgba(255,255,255,.15);
              box-shadow: inset 0 -1px 1px rgba(255,255,255,.15);
              -webkit-transition: -webkit-transform .2s ease-in-out;
              -moz-transition: -moz-transform .2s ease-in-out;
              -o-transition: -o-transform .2s ease-in-out;
              transition: transform .2s ease-in-out;
          }
          .btn:active {
              -webkit-box-shadow:
                      0 8px 0 #1a74a1,
                      0 12px 10px rgba(0,0,0,.3);
              -moz-box-shadow:
                      0 8px 0 #1a74a1,
                      0 12px 10px rgba(0,0,0,.3);
              box-shadow:
                      0 8px 0 #1a74a1,
                      0 12px 10px rgba(0,0,0,.3);
          }
          .btn:active span {
              -webkit-transform: translate(0, 4px);
              -moz-transform: translate(0, 4px);
              -o-transform: translate(0, 4px);
              transform: translate(0, 4px);
          }
      </style>
      <link rel="stylesheet" type="text/css" href="css/common.css">
      <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
      <script type="text/javascript" src="js/jquery-ui-jqLoding.js"></script>
      <script type="text/javascript" src="js/alertPopShow.js"></script>
      <script type="text/javascript">
        $(document).ready(function(){
            $("#demo").on('click', function(){
                var html = "<label>用户名：<input class='confirm_name' id='username' type='text' placeholder='请输入'></label></br></br>" +
                           "<label>密&nbsp&nbsp&nbsp&nbsp码：<input class='confirm_pwd' id='password' type='password' placeholder='请输入'></label>";
                popTipShow.confirm('用户认证',html,['确 定','取 消'],
                    function(e){
                        //callback 处理按钮事件
                        var button = $(e.target).attr('class');
                        if(button == 'ok'){
                            if(null==$(".confirm_name").val() || ""==$(".confirm_name").val()){
                                webToast("用户名不能为空！","bottom", 1000);
                                return;
                            }
                            if(null==$(".confirm_pwd").val() || ""==$(".confirm_pwd").val()){
                                webToast("密码不能为空！","bottom", 1000);
                                return;
                            }
                            this.hide();
                            //按下确定按钮执行的操作
                            //todo ....
                            $.ajax({
                                url: "redirect/login",
                                type:'post',
                                data:{username:$("#username").val(),password:$("#password").val()},
                                success: function(data){
                                    if (data.code==200){
                                        $.fn.jqLoading({ height: 70, width: 320, text: "程序正在预热中，请勿刷新页面。。。" });
                                        $.ajax({
                                            url: "redirect/init235",
                                            success: function(data){
                                                $("#demo").remove();
                                                if(data.code==200){
                                                    $.fn.jqLoading("destroy");
                                                    document.getElementById("text").innerHTML=data.msg+"，耗时:"+data.time+"ms";
                                                }else{
                                                    $.fn.jqLoading("destroy");
                                                    document.getElementById("text").innerHTML="预热程序中断，错误信息为："+data.msg;
                                                }
                                            },
                                            error:function (data) {
                                                $.fn.jqLoading("destroy");
                                                document.getElementById("text").innerHTML=data.responseText;
                                            }
                                        });
                                    }else{
                                        webToast("用户名或密码错误！","top", 1000);
                                        return;
                                    }
                                },
                                error:function (data) {
                                    webToast("服务器异常，请联系管理员吧！","top", 1000);
                                    return;
                                }
                            });
                        }

                        if(button == 'cancel') {
                            //按下取消按钮执行的操作
                            //todo ....
                            this.hide();
                            setTimeout(function() {
                                webToast("您选择[取消]了","top", 1000);
                            }, 300);
                        }
                    }
                );
            });
        });
    </script>
  </head>
  <body>
    <%--  <embed src="js/honehone_clock_tr.swf" width="220" height="90" type="application/x-shockwave-flash">--%>
      <div class="mod" id="text" style="color: indigo;font-size: 28px;padding:150px;">
          <a id="demo" href="javascript:;" class="btn"><span>点击开始预热!</span></a>
      </div>
  </body>
</html>
