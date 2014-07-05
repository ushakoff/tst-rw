<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>My profile</h1>
<p class="msg">${message}</p>
<p><form:form commandName="profile" action="${pageContext.request.contextPath}/user/profile" method="POST" >
	<form:hidden path="id"/>
	<table class="table1">
		<tr>
			<th scope="row">Login:</th>
			<td>${pageContext.request.userPrincipal.name}
		<tr>
			<th scope="row">First name:</th>
			<td><form:input size="40" maxlength="40" path="firstName" />
		<tr>
			<th scope="row">Last name:</th>
			<td><form:input size="40" maxlength="40" path="lastName" />
		<tr>
			<th scope="row">E-mail:</th>
			<td><form:input size="40" maxlength="80" path="email" />
		<tr>
			<th scope="row"></th>
			<td><input class="sbmt" type="submit" value="Save" />
	</table>
</form:form>
