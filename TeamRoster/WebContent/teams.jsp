<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add a Team</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<fieldset>
		<legend>Create a Team</legend>
		<c:set var="err" value="${err}"/>
		<c:if test="${err != null}">
			<p class="err"><c:out value="${err}"/></p>
		</c:if>
		<form action="/TeamRoster/Teams" method="post">
			<label>Team Name: 
				<input type="text" name="name" />
			</label>
			<button type="submit">Create</button>
		</form>
	</fieldset>
</body>
</html>