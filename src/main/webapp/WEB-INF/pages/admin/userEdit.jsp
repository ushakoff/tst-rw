<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>Edit user "${user.login}"</h1>
<p><form:form commandName="user" action="${pageContext.request.contextPath}/admin/users/${user.id}" method="POST" >
	<form:hidden path="id"/>
	<form:hidden path="profile.id"/>
	<table class="table1">
		<tr>
			<th scope="row">Login:</th>
			<td><c:choose>
  				<c:when test="${pageContext.request.userPrincipal.name == user.login}"> 					
  					<p class="al">${user.login}
  					<form:hidden path="login"/>
				</c:when>
				<c:otherwise>
					<form:input size="40" maxlength="40" path="login" />
					<p><form:errors style="color: #1c9737;" path="login"/>					
  				</c:otherwise>
			</c:choose>
		<tr>
			<th scope="row">Password:</th>
			<td><form:input size="40" maxlength="40" path="password" />
			<p><form:errors style="color: #1c9737;" path="password"/>
		<tr>
			<th scope="row">First name:</th>
			<td><form:input size="40" maxlength="40" path="profile.firstName" />
		<tr>
			<th scope="row">Last name:</th>
			<td><form:input size="40" maxlength="40" path="profile.lastName" />
		<tr>
			<th scope="row">E-mail:</th>
			<td><form:input size="40" maxlength="80" path="profile.email" />
		<tr>
			<th scope="row">Role</th>
			<td><c:choose>
  				<c:when test="${pageContext.request.userPrincipal.name == user.login}">  					
  					<p class="al">${user.role.role}
  					<form:hidden path="role.id"/>
				</c:when>
				<c:otherwise>
					<c:forEach var="role" items="${roles}">
						<p class="al"><form:radiobutton path="role.id" value="${role.id}"/>${role.role}
					</c:forEach>					
  				</c:otherwise>
			</c:choose>
		<tr>
			<th scope="row"></th>
			<td><input class="sbmt" type="submit" value="OK" />
			<input class="sbmt" type="button" value="Cancel"
				onclick="window.location='${pageContext.request.contextPath}/admin/users'" />
	</table>
</form:form>