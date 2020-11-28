<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>add</title>
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
		<c:set var="cxt" value="${pageContext.request.contextPath}"/>
	</head>
	<body>
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-body">
					<h3 class="alert alert-primary">Add Books: </h3>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4 offset-4">
					<form:form modelAttribute="bk" action="/saveBook" methode="POST" class="form-group">
						<p class="form-group">
						description: <form:input class="form-control" path="descreption" type="text" /> 
						</p>
						<p> <input type="submit" value="save"/> </p>						
					</form:form>
				</div>
								
			</div>
		</div>
	</body>
</html>