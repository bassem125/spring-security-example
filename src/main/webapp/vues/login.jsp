<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>login</title>
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css">
		<c:set var="cxt" value="${pageContext.request.contextPath}"/>
		<base href="/">
	</head>
	<body>
		<div class="container">
			<br>
			<br>
			<div class="row">
				<c:if test="${not empty alert}">
					<div class="col-md-4 offset-4">
						<div class="alert alert-${alert_style}"> ${alert} </div>
					</div>
				</c:if>
			</div>
			<div class="row">
				<div class="col-md-4 offset-4 shadow-sm p-3 mb-5 bg-white rounded">
					<h3>Login</h3>
					<br>
					<form action="/login" method="POST">
					  <div class="form-group">
					    <label >Username</label>
					    <input type="text" class="form-control" name="username" >
					  </div>
					 <div class="form-group">
					    <label >password</label>
					    <input type="password" class="form-control" name="password" >
					  </div>
					  <button type="submit" class="btn btn-primary">login</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>