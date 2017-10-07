<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML><!-- 强调当前文档为html5-->
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Java邮件群发系统 -- 吴其顺</title>
	<meta http-equiv="keywords" content="邮件转发">
	<meta http-equiv="description" content="本网站为吴其顺个人邮件转发系统">
	<style type="text/css">
		*{margin: 0;}
		body{background: url("images/background1.jpg");background-size: cover;}
		/*start header*/
		.header{width: 100%;}
		.header .h-con{width: 1000px;margin: 0 auto;margin-top: 20px;}
		.header .h-con span{font-size: 20px;font-family: "微软雅黑";font-weight: 700;float: right;margin-top: 20px;}
		/*end header*/
		/*start con*/
		.con{width: 770px;height:  365px;margin: 60px 0 0 150px;line-height: 60px;}
		.con input{width: 400px;height: 30px;}
		.con textarea{width: 400px;height: 100px;}
		.con .c-btn{margin-left: 60px; border: none;width: 400px; height: 40px;background: #129be4;font-size: 17px;border-radius: 6px;}
		.c-btn:hover{background: #2cc5e4;}
		/*end con*/
	</style>
  </head>
  
  <body>
  <!-- start header-->
  <div class="header">
  	<div class="h-con">
  		<img src="images/logo.png" width="" height="" alt="吴其顺个人网站logo">
  		<span>个人网站邮件转发系统-吴其顺</span>
  	</div>
  </div>
  <!-- end header-->
  
  <!--start con-->
 <form action="mail" method="post">
 	<div class="con">
  	<p>
  		<span>收件人：</span>
  		<input type="text" name="m-name">
  	</p>
  	<p>
  		<span>主&emsp;题：</span>
  		<input type="text" name="m-topci">
  	</p>
  	<p>
  		<span>正&emsp;文：</span>
  		<textarea class="c-con" name="m-con"></textarea>
  	</p>
  	<input type="submit" value="发送邮件" class="c-btn">
  </div>
 </form>
    <!-- end header-->
  </body>
</html>
