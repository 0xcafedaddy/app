<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   	<jsp:include page="../inc.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/echarts.js"></script>
	<script type="text/javascript">
		$(function(){
		    initData("start/charts");
		    /**
			 * 查询
			 */
			$('#searchbtn').click(function(){
				initData('start/charts');
			});
			/**
			 * 清空
			 */
			$('#clearbtn').click(function(){
				$('#from').form('clear');
				initData('start/charts');
			});
			
			$('#back').click(function(){
				window.location.href="redirect/statistics/day_activity_user";
			});
		});
		
		function initData(url){
			// 基于准备好的dom，初始化echarts实例
		    var myChart = echarts.init(document.getElementById('main'));
		    var start = $('#start').datebox('getValue');  
			var end = $('#end').datebox('getValue');  
			//延迟动画
		    myChart.showLoading();
		    $.ajax({
		    	   type: "POST",
		    	   url: url,
		    	   dataType:"json",
		    	   data: {start:start,end:end},
		    	   success: function(data){
		    		   myChart.hideLoading();
				  	     // 指定图表的配置项和数据
					     myChart.setOption({
						    title : {
						        text: '日活跃用户量',
						        subtext: '每天用户的访问数量',
						        left:30,
						        top:20,
						        x:'left'
						    },
						    tooltip : {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    legend: {
						        orient: 'vertical',
						        right: 'right',
						        data: data.categories  
						    },
						    series : [
						        {
						            name: '每天用户量',
						            type: 'pie',
						            selectedMode :true,
						            radius : '70%',
						            center: ['40%', '45%'],
						            data: data.data  
						        }
						    ]
						});
				  	     
					   /*  var count = 0;
						setInterval(function () {
						    myChart.dispatchAction({
						        type: 'downplay',
						        seriesIndex: 0
						    });
						    myChart.dispatchAction({
						        type: 'highlight',
						        seriesIndex: 0,
						        dataIndex: (count++) % 10
						    });
						}, 1000); */
		    	   }
		    });
		}
    </script>
  </head>
  <body class="easyui-layout">
  	<form action="" id="from">
	  	<div style="margin-top: 10px; margin-left: 220px;">
			时间段:<input style="width:155px"  class= "easyui-datebox" name="start" id="start" editable="false" type="text"/>至
				 <input style="width:155px"  class= "easyui-datebox" name="end" id="end" editable="false" type="text"/>
				 &nbsp;&nbsp;&nbsp;&nbsp;
				 <a id="searchbtn" data-options="iconCls:'icon-search'" class="easyui-linkbutton">查询</a>&nbsp;&nbsp;
				 <a id="clearbtn" data-options="iconCls:'icon-clear'" class="easyui-linkbutton">清空</a>&nbsp;&nbsp;&nbsp;&nbsp;
				 <a id="back" data-options="iconCls:'icon-back'" class="easyui-linkbutton">返回</a>
		</div>
	</form>
    <div id="main" style="width: 100%;height:100%;"></div>
  </body>
</html>
