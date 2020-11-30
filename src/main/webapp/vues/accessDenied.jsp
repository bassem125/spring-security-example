<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>access-denied</title>
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css">
		<c:set var="cxt" value="${pageContext.request.contextPath}"/>
	</head>
<body>
	<div class="alert alert-danger">
		<h1>You are not permitted to visit this page!!</h1>
	</div>	
</body>
</html>