<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Users list</h1>
<table class="table1">
	<thead>
	<tr>
		<th>User ID</th>
		<th>Login</th>
		<th>Password</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>E-mail</th>
		<th>Role</th>
		<th>Actions</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="user" items="${users}">
	<tr>
		<th scope="row">${user.id}</th>
		<td>${user.login}
		<td>${user.password}
		<td>${user.profile.firstName}
		<td>${user.profile.lastName}
		<td><a href="mailto:${user.profile.email}">${user.profile.email}</a>
		<td>${user.role.role}
		<td>
		<p><a href="${pageContext.request.contextPath}/admin/users/${user.id}">Edit</a>
		<p><a href="${pageContext.request.contextPath}/admin/users/delete/${user.id}">Delete</a>
	</tr>
	</c:forEach>
</tbody>
</table>