<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>Discount details</h1>
<p><form:form commandName="discount" action="${pageContext.request.contextPath}/user/codes" method="POST" >
	<form:hidden path="id"/>
	<table class="table1">		
		<tr>
			<th scope="row">Discount:</th>
  			<td>${discount.name}
		<tr>
			<th scope="row">Save:</th>
			<td>${discount.percent}%		
		<tr>
			<th scope="row">Info</th>
			<td>${discount.detail.info}
		<tr>
			<th scope="row">Category:</th>
  			<td><a href="${pageContext.request.contextPath}/categories/${discount.category.id}">${discount.category.name}</a>
		<tr>
			<th scope="row">Site:</th>
			<td><a href="http://${discount.detail.site}" target="_blank">${discount.detail.site}</a>
		<tr>
			<th scope="row">Action</th>
			<td><input class="sbmt" type="submit" value="Get Code" />
			<input class="sbmt" type="button" value="Cancel"
				onclick="window.location='${pageContext.request.contextPath}/'" />
	</table>
</form:form>