<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Info</title>
</head>
<body>
	<fieldset>
		<c:set var="team" value="${thisTeam}"/>
		<c:set var="id" value="${id}"/>
		<legend><c:out value="${team.getName()}"/></legend>
		<div class="tags">
			<a href="/TeamRoster/Home">Return</a>
			<a href="/TeamRoster/Players?id=${id}">Add ${team.getName()}</a>
		</div>
		<table class="dashTable">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</tr>
			<c:set var="players" value="${team.getPlayers()}"/>
			<c:forEach items="${players}" var="player" varStatus="loop">
				<tr>
   					<td>${player.getFirst()}</td>
   					<td>${player.getLast()}</td>
   					<td>${player.getAge()}</td>
   					<td> 
   						<a onclick="getCategoryIndex(${loop.index})" href="/TeamRoster/DeletePlayer?id=${loop.index}&teamId=${id}">Delete</a>
   					</td>
   				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>