<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Player</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<fieldset>
		<legend>Create a Player for team <c:out value="${thisTeam.getName()}"/></legend>
		<c:set var="err" value="${err}"/>
		<c:if test="${err != null}">
			<p class="err"><c:out value="${err}"/></p>
		</c:if>
		<c:set var="id" value="${id}"/>
		<form action="/TeamRoster/AddPlayer?id=${id}" method="post">
			<label>First Name: 
				<input type="text" name="first" />
			</label>
			<label>Last Name: 
				<input type="text" name="last" />
			</label>
			<label>Age: 
				<input type="number" name="age" />
			</label>
			<button type="submit">Create</button>
		</form>
	</fieldset>
</body>
</html>