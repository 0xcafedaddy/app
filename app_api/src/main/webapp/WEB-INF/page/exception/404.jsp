<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/main.css" media="screen, projection"> <!-- main stylesheet -->
<link rel="stylesheet" type="text/css" href="<%=path %>/css/tipsy.css" media="all"> <!-- Tipsy implementation -->
<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script> <!-- uiToTop implementation -->
<script type="text/javascript" src="<%=path %>/js/custom-scripts.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.tipsy.js"></script> <!-- Tipsy -->
<script type="text/javascript">
$(document).ready(function(){
	universalPreloader();
});
$(window).load(function(){
	//remove Universal Preloader
	universalPreloaderRemove();
	rotate();
    dogRun();
	dogTalk();
	//Tipsy implementation
	$('.with-tooltip').tipsy({gravity: $.fn.tipsy.autoNS});
});
</script>
<title>404 - Not found</title>
</head>
	<body>
		<div id="wrapper">
		<!-- 404 graphic -->
			<div class="graphic"></div>
		<!-- 404 graphic -->
		<!-- Not found text -->
			<div class="not-found-text">
		    	<h1 class="not-found-text">File not found, sorry!</h1>
		    </div>
		<!-- Not found text -->
			<div class="dog-wrapper">
			<!-- dog running -->
				<div class="dog" style="background-position: -80px -2px;"></div>
			<!-- dog running -->
			<!-- dog bubble talking -->
				<div class="dog-bubble" style="opacity: 1; bottom: 10px;"><p>
			        	<br>
			            OK, I'm officially lost now...
			        </p></div>
			    <!-- The dog bubble rotates these -->
			    <div class="bubble-options">
			    	<p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	Are you lost, bud? No worries, I'm an excellent guide!
			        </p>
			    	<p class="dog-bubble" style="opacity: 1; bottom: 10px;">
				        <br>
			        	Arf! Arf!
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	<br>
			        	Don't worry! I'm on it!
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	I wish I had a cookie<br><img style="margin-top:8px" src="<%=path %>/images/cookie.png" alt="cookie">
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	<br>
			        	Geez! This is pretty tiresome!
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	<br>
			        	Am I getting close?
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	Or am I just going in circles? Nah...
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	<br>
			            OK, I'm officially lost now...
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	I think I saw a <br><img style="margin-top:8px" src="<%=path %>/images/cat.png" alt="cat">
			        </p>
			        <p class="dog-bubble" style="opacity: 1; bottom: 10px;">
			        	What are we supposed to be looking for, anyway? @_@
			        </p>
			    </div>
			    <!-- The dog bubble rotates these -->
			<!-- dog bubble talking -->
			</div>
			<!-- planet at the bottom -->
			<div class="planet" style="transform: rotate(-6122.4deg);"></div>
			<!-- planet at the bottom -->
		</div>
	</body>
</html>
