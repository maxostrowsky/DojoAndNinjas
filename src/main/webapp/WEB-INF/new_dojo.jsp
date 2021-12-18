<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-3">
	<h1>New Dojo</h1>
	</div>
	<div class="container mt-5">
		<form:form action="/dojo/add" method="post" modelAttribute="dojo" class="form-control">
		<div>
			<form:label path="name" class="form-label">Name:</form:label>
			<form:input path="name" type="text" class="form-control"/>
			<form:errors path="name" class="text-danger"/>
		</div>
		<div class="mt-3">
			<button class="btn btn-success">Create</button>
		</div>
		</form:form>	
	</div>
	<div class="container col-1 mt-5">
		<div><h1>List of Dojos</h1></div>
		<div class="mt-5 d-flex flex-column">
			<c:forEach var="dojo" items="${dojos }"><a href="/dojo/${dojo.id}">${dojo.name }</a></c:forEach>
		</div>
	</div>
</body>
</html>