<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form commandName="user" action="${pageContext.request.contextPath}/admin/users/delete/${user.id}" method="POST" >
	<h1>Delete user "${user.login}"</h1>
	<c:choose>
		<c:when test="${pageContext.request.userPrincipal.name == user.login}">
			<h3>You can't delete yourself.</h3>				
			<p><input class="sbmt" type="button" value="Back"
				onclick="window.location='${pageContext.request.contextPath}/admin/users'" />
		</c:when>
		<c:otherwise>
			<h3>Are you sure you want to delete this user?</h3>
			<form:hidden path="id"/>
			<p><input class="sbmt" type="submit" value="Yes" />
			<input class="sbmt" type="button" value="Cancel"
				onclick="window.location='${pageContext.request.contextPath}/admin/users'" />					
		</c:otherwise>
	</c:choose>
</form:form>