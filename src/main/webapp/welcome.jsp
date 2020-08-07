<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>SSMBlog</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery/2.0.0/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resource/js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/welcome.css">
	<link rel="shortcut icon" href="/SSMBlog/resource/img/logo.png">
</head>
<body>
	<div class="jumbotron">
  		<div class="container" align="center">
    	<h2 class="text-info" style="font-family:宋体;font-weight:bold;font-size:49px">SSMBlog</h2>
    	<br>
    	<div class="text-muted">
			<a href="https://liuyanzhao.com/6347.html"  target="_blank" id="How2J">参考教程：github开源项目【言曌博客】</a>
    	</div>
    	<br>
    	<br>
    	<p>
    		<a role="button" href="${pageContext.request.contextPath}/home/index" class="btn btn-success">进入前台展示页面</a>
    		<a role="button" href="${pageContext.request.contextPath}/admin/login" class="btn btn-success">进入后台管理数据</a>
    	</p>
		</div>
	</div>
</body>
</html>