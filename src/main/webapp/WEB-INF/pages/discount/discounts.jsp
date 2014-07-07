<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Discounts</h1>
<p style="font-size:18px;margin: 0 10px 10px;">By categories:
<c:forEach var="category" items="${categories}">
	<a style="margin: 0 3px;" href="${pageContext.request.contextPath}/categories/${category.id}">${category.name} (${category.discounts.size()})</a>
</c:forEach>
<p>
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
		<td><p class="lnk" onClick="location.href = '${pageContext.request.contextPath}/discounts/${discount.id}'">${discount.name}		
		<td>${discount.percent}%
		<td><a href="${pageContext.request.contextPath}/categories/${discount.category.id}">${discount.category.name}</a>
		<td><a href="${pageContext.request.contextPath}/discounts/${discount.id}">More info</a>
	</tr>
	</c:forEach>
</tbody>
</table>