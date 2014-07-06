<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Discounts list</h1>
<table class="table1">
	<thead>
	<tr>
		<th style="min-width:40px;">#</th>		
		<th style="min-width:300px;">Discount</th>
		<th style="min-width:100px;">Save</th>
		<th style="min-width:100px;">Category</th>
		<th style="min-width:100px;">Action</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="discount" items="${discounts}" varStatus="iter">
	<tr>
		<th>${iter.count}</th>		
		<td>${discount.name}
		<td>${discount.percent}%
		<td><a href="${pageContext.request.contextPath}/moder/categories/${discount.category.id}">${discount.category.name}</a>
		<td><p><a href="${pageContext.request.contextPath}/moder/discounts/${discount.id}">Edit</a>
			<p><a href="${pageContext.request.contextPath}/moder/discounts/delete/${discount.id}">Delete</a>
	</tr>
	</c:forEach>
</tbody>
</table>