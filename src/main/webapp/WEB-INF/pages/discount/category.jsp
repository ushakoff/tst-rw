<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>Category: ${category.name}</h1>
<h3 style="margin: 0 10px 10px;">
	<a href="${pageContext.request.contextPath}/">All discounts</a>
	<a href="${pageContext.request.contextPath}/categories">All categories</a>
</h3>
<p>
<table class="table1">
	<thead>
	<tr>
		<th style="min-width:40px;">#</th>
		<th style="min-width:300px;">Discount</th>
		<th style="min-width:100px;">Save</th>
		<th style="min-width:100px;">Action</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="discount" items="${category.discounts}" varStatus="iter">
	<tr>
		<th>${iter.count}</th>
		<td><p class="lnk" onClick="location.href = '${pageContext.request.contextPath}/discounts/${discount.id}'">${discount.name}		
		<td>${discount.percent}%
		<td><a href="${pageContext.request.contextPath}/discounts/${discount.id}">More info</a>
	</tr>
	</c:forEach>
</tbody>
</table>