<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.codingdojo.web.models.Team"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Dashboard</title>
</head>
<body>
	<fieldset>
		<legend>Prototpye Rosters</legend>
		<a href="/TeamRoster/teams.jsp">New Team</a>
		<table class="dashTable">
			<tr>
				<th>Team</th>
				<th>Player Count</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${teams}" var="team" varStatus="loop">
				<tr>
   					<td>${team.getName()}</td>
   					<td>${team.getPlayers().size()}</td>
   					<td>
   						<a onclick="getCategoryIndex(${loop.index})" href="/TeamRoster/TeamDetails?id=${loop.index}">Details</a> 
   						<a onclick="getCategoryIndex(${loop.index})" href="/TeamRoster/DeleteTeam?id=${loop.index}">Delete</a>
   					</td>
   				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>