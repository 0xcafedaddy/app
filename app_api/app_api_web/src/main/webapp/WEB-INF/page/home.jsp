<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>省市县区四级联动</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jQuery.options.js"></script>
	<script type="text/javascript" src="js/jquery.jbind-1.5.7.js"></script>
	<script type="text/javascript">
		function getArea(selid, id) {
		    var selectNameObject = {c:'市', cy:'区县', t:'镇'};
		    var pid = $("#"+selid+" option:selected").val();
		    if (pid > 0) {
		        $("#"+id).FillOptions("area/subNode?pid="+pid,{datatype:"json",textfield:"name",valuefiled:"id"});
		        $("#"+id).AddOption("请选择"+selectNameObject[id], "", true, 0);
		        if (selid == "p") {
		            resetArea(selectNameObject, 'cy');
		            resetArea(selectNameObject, 't');
		        }
		        if (selid == "c") resetArea(selectNameObject, 't');
		    } else {
		        resetArea(selectNameObject, 0);
		    }
		}
		 
		function resetArea(selectNameObject, id) {
		    if (id == 0 || id == '') {
		        $.each(selectNameObject, function(name, value) {
		            $("#"+name).empty();
		            $("#"+name).AddOption("请选择"+value, "", true, 0);
		        });
		    } else {
		        $("#"+id).empty();
		        $("#"+id).AddOption("请选择"+selectNameObject[id], "", true, 0);
		    }
		}
		 
		function setArea() {
		    var province = $("#p").get(0).options[$("#p").get(0).selectedIndex].text;
		    var city = $("#c").get(0).options[$("#c").get(0).selectedIndex].text;
		    var county = $("#cy").get(0).options[$("#cy").get(0).selectedIndex].text;
		    var town = $("#t").get(0).options[$("#t").get(0).selectedIndex].text;
		    $("#province").val(province);
		    $("#city").val(city);
		    $("#county").val(county);
		    $("#town").val(town);
		     
		    //if ($("#p").val() == "") {alert("请选择省"); $("#p").focus(); return false;}
		    //if ($("#c").val() == "") {alert("请选择市"); $("#c").focus(); return false;}
		    //if ($("#cy").val() == "") {alert("请选择区县"); $("#cy").focus(); return false;}
		    //if ($("#t").val() == "") {alert("请选择镇"); $("#t").focus(); return false;}
		    return true;
		}
		
		$(document).ready(function(){
			$.ajax({
			   url: "area/province",
			   type:"post",
			   dataType:"json",
			   success: function(result){
				   $.each(result,function(){ 
					   $('#p').append("<option value='"+ this.id+"'>"+ this.name +"</option>"); 
					}); 
			   }
			});
		});
	</script>
  </head>
  
  <body>
    <form method="POST" onsubmit="return setArea();" target="_blank">
	     <input name="type" id="type" value="form" type="hidden">
	     <input name="province" id="province" value="" type="hidden">
	     <input name="city" id="city" value="" type="hidden">
	     <input name="county" id="county" value="" type="hidden">
	     <input name="town" id="town" value="" type="hidden">
	     <tbody>
	      	<tr>
			   <td style="padding: 3px 0px 4px 10px;" height="30" valign="middle">
			 	   <span class="red bold">查找节点：</span>
			 	   <select name="p" id="p" onchange="getArea('p', 'c');">
		       		  <option value="">请选择省份</option>
					</select>
					<select name="c" id="c" onchange="getArea('c', 'cy');">
		            	<option value="">选择市</option>
		            </select>
		  			<select name="cy" id="cy" onchange="getArea('cy', 't');">
		            	<option value="">选择区县</option>
		            </select>
		 		    <select name="t" id="t">
		          	    <option value="">选择镇</option>
		            </select> 
		       </td>
	     	 </tr>
	    </tbody>
    </form>
  </body>
</html>
