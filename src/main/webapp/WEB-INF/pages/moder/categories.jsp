<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Categories list</h1>
<table class="table1">
	<thead>
	<tr>
		<th style="min-width:40px;">#</th>
		<th style="min-width:200px;">Category</th>		
		<th style="min-width:200px;">Discounts</th>
		<th style="min-width:100px;">Action</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="category" items="${categories}" varStatus="iter">
	<tr>
		<th>${iter.count}</th>
		<td>${category.name}		
		<td>${category.discounts.size()}		
		<td><p><a href="${pageContext.request.contextPath}/moder/categories/${category.id}">Edit</a>
			<p><a href="${pageContext.request.contextPath}/moder/categories/delete/${category.id}">Delete</a>
	</tr>
	</c:forEach>
</tbody>
</table>