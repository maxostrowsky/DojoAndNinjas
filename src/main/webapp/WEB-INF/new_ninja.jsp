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
	<h1>New Ninja</h1>
	</div>
	<div class="container mt-5">
		<form:form action="/ninja/add" method="post" modelAttribute="ninja" class="form-control">
		<div>
			<form:label path="dojo">Select a Dojo</form:label>
			<form:select path="dojo" name="dojo">
			<c:forEach var="oneDojo" items="${dojos }">
				<form:option value="${oneDojo.id}">${oneDojo.name}</form:option>
			</c:forEach>			
			</form:select>
		</div>
		<div>
			<form:label path="firstName" class="form-label">First Name:</form:label>
			<form:input path="firstName" type="text" class="form-control"/>
			<form:errors path="firstName" class="text-danger"/>
		</div>
			<div>
			<form:label path="lastName" class="form-label">Last Name:</form:label>
			<form:input path="lastName" type="text" class="form-control"/>
			<form:errors path="lastName" class="text-danger"/>
		</div>
			<div>
			<form:label path="age" class="form-label">Age:</form:label>
			<form:input path="age" type="text" class="form-control"/>
			<form:errors path="age" class="text-danger"/>
		</div>
		<div class="mt-3">
			<button class="btn btn-success">Add</button>
		</div>
		</form:form>	
	</div>
</body>
</html>