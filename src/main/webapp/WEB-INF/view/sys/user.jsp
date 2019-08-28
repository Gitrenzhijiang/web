<%@page import="com.survey.form.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>明日科技-问卷调查后台维护</title>
    <!-- Bootstrap -->
    <link href="<%=basePath %>bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>css/ityks.css" rel="stylesheet">
  </head>
<body style="background-color: #fefefe;">
	<!-- 这是导航条 -->
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container">
		<form id="delCheckForm" method="post">
			<table class="table table-bordered table-hover">
			<tr class="danger">
				<th>
					<h5 >序号:</h5>
				</th>
				<th>
					<h5 >用户名:</h5>
				</th>
				<th>
					<h5 >电子邮件:</h5>
				</th>
				<th>
					<h5 >姓名:</h5>
				</th>
				<th width="256px">
					<h5 >操作:</h5>
				</th>
			</tr>
			<c:choose>
				<c:when test="${not empty users }">
					
					<c:forEach items="${users }" var="item" >
						<tr class="success">	
							<td>
								<span>${item.id }</span>
							</td>
							<td>
								<span>${item.name }</span>
							</td>
							<td>
								<span>${item.email }</span>
							</td>
							<td>
								<span>${item.real_name }</span>
							</td>
							<td class="text-center">
								<div class="input-group-btn" id="ssdiv">
									<input type="hidden" id="temoLoginId" >
										<button class="btn btn-warning" type="button" onclick="delModal('${item.id }')">删除</button>
										 <button type="button" class="btn btn-success dropdown-toggle" style="width: 70px;" data-toggle="dropdown"  id="s_${item.role_id}">
											 <c:choose>
												<c:when test="${not empty roles }">
													<c:forEach items="${roles }" var="temp" varStatus="vs">
														<c:if test="${temp.id eq item.role_id}">
															${temp.name}
														</c:if>
													</c:forEach>
												</c:when>
											</c:choose> 
										</button>
										<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" >
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<c:choose>
												<c:when test="${not empty roles }">
													<c:forEach items="${roles }" var="temp" >
														<c:if test="${temp.id ne 0}">
															<li><a href="javascript:void(0)" onclick="setRole('${temp.id }','${temp.name }','${item.id}','${item.name}')">${temp.name}</a></li>
															<li class="divider"></li>
														</c:if>
													</c:forEach>
												</c:when>
											</c:choose>
										</ul>
								</div>
							</td>
						</tr>	
					</c:forEach>
				</c:when>
			</c:choose>
			
				<tr>
					<td colspan="5">
	 					${currentPage }
	 				</td>
	 			</tr>
			</table>
		</form>
	</div>
	<div class="container">
		<div class="modal fade" id="delModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
							<span class="sr-only">Close</span>
						</button>
					</div>
					<div class="modal-body">
						<p>您确定要删除这个用户吗？</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal">关闭</button>
						<button class="btn btn-primary"  onclick="deleteUser()">确定</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<div class="container">
		<div class="modal fade" id="alertOK">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
							<span class="sr-only">Close</span>
						</button>
					</div>
					<div class="modal-body">
						<p id="alertOKText">s</p>
					</div>
					<div class="modal-footer">			
						<button id="closeBtn" class="btn btn-default" data-dismiss="modal" >关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<footer class="footer navbar-fixed-bottom ">
        <div class="container" style="background-color: white;">
            <div class="row">
                <div class="col-sm-12">
                    <span>JAVA 一班  三组 </span>
                </div>
            </div>
        </div>
    </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript">
		var basePath = '<%=basePath%>';
		var socketPath = '<%=socketPath%>';
	</script>
    <script src="<%=basePath %>bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
    <script src="<%=basePath %>bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>js/user.js"></script>
</body>
</html>