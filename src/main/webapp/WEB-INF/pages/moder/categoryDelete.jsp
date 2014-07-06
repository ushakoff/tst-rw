<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form commandName="category" action="${pageContext.request.contextPath}/moder/categories/delete/${category.id}" method="POST" >
	<h1>Delete category</h1>
		<h3>Are you sure you want to delete category "${category.name}"?</h3>
		<form:hidden path="id"/>
		<p><input class="sbmt" type="submit" value="Yes" />
		<input class="sbmt" type="button" value="Cancel"
			onclick="window.location='${pageContext.request.contextPath}/moder/categories/${category.id}'" />					
</form:form>