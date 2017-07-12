<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/18
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#sub").on("click",function(){
                var pet = {"id":$("#id").val(),"name":$("#name").val()};
                $.ajax({
                    url: "redirect/json",
                    type:"post",
                    contentType:"application/json;utf-8",
                    dataType:"json",
                    data:JSON.stringify(pet),
                    success: function(result){
                        $('#text').append("<h3>"+result.id+"</br>"+result.name+"</h3>");
                    }
                });
            })
        });
    </script>
</head>
<body>
    <form id="form">
        <table>
            <tr>
                <td>ID:</td>
                <td><input name="id" id="id"></td>
            </tr>
            <tr>
                <td>NAME:</td>
                <td><input name="name" id="name"></td>
            </tr>
        </table>
    </form>
    <div style="margin-left: 190px">
        <input type="button" value="提交" id="sub">
    </div>
    <h1>result:</h1>
    <div id="text" style="font-size: 25px;color: indigo;"></div>
</body>
</html>
