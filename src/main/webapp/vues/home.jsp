<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>home</title>
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
		<c:set var="cxt" value="${pageContext.request.contextPath}"/>
	</head>
	<body>
		<div class="container">
			<div class="alert alert-primary">
<!-- 				<div class="panel-body"> -->
					List of Books:
<!-- 				</div> -->
			</div>
			<br>
			<div class="row"> 
				<div class="col-md-3">
					<sec:authorize access="isAuthenticated()"> 
						<p> Welcome <sec:authentication property="principal.username"/></p>
 					</sec:authorize>					 
				</div>
				<div class="col-md-1">
					<a href="<c:url value='/logout' />" class="btn btn-info">logout</a>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4 " >
					<table class="table table-dark">
						<thead>
							<tr>
								<th>ID</th>
								<th>DESCRIPTION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${books}" var="bk" varStatus="nbr">
								<tr>
									<th>${nbr.count}</th>
									<th>${bk.descreption}</th>
									<sec:authorize access="hasRole('ADMIN')">
										<th><a class="btn btn-danger" href="${cxt}/del/${bk.id}">delete</a></th>
									</sec:authorize>
									
								</tr>
							</c:forEach> 
							
						</tbody>
					</table>
					<br>
					<sec:authorize access="hasRole('ADMIN')">
						<a href="/addBook"> add books</a>
					</sec:authorize>
					
				
				</div>
								
			</div>
		</div>
		
	</body>
</html>