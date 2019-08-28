<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>明日科技-后台维护</title>
    <!-- Bootstrap -->
    <link href="<%=basePath %>bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>css/ityks.css" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href="<%=basePath %>css/content.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.11.3.min.js"></script>
    <c:if test="${success =='OK'}">
    	<script type="text/javascript">
    		$(function (){
    			alert ("修改成功");
    			parent.window.location.href="<%=basePath%>per/toPer";
    		})
    	</script>
    </c:if>
   <%--  <c:if test="${success == 'NO'}">
    	<script type="text/javascript">
    		$(function (){
    			alert ('${msg}');
    		})
    	</script>
    </c:if> --%>
</head>
<body>
	
	<div class="container">
		<form action="<%=basePath %>per/perEdit" class="form-horizontal">
			<!--以下录入表单-->
			<input type="hidden" name="id" value="${entity.id }">
		    <div class="form-group">
		        <label for="permissionName" class="contro-label">权限名称:</label>
		        <input class="form-control" value="${entity.name }" name="name" type="text"/>
		    </div>
			<p class="text-center"><button type="submit" class="btn btn-primary">提交</button></p>
		</form>
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=basePath %>bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>