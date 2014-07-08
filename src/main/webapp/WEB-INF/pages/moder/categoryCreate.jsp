<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>Create category</h1>
<p><form:form commandName="category" action="${pageContext.request.contextPath}/moder/categories/create" method="POST" >
	<h3>Name: <form:input size="40" maxlength="40" path="name" /></h3>
	<p><form:errors style="color: #1c9737;" path="name"/>
	<p><input class="sbmt" type="submit" value="OK" />
	<input class="sbmt" type="button" value="Cancel"
			onclick="window.location='${pageContext.request.contextPath}/moder/categories'" />
</form:form>