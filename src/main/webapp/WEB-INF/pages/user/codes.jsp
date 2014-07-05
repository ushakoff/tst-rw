<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>My codes</h1>
<table class="table1">
	<thead>
	<tr>
		<th style="min-width:40px;">#</th>
		<th style="min-width:250px;">Discount</th>
		<th style="min-width:100px;">Save</th>
		<th style="min-width:100px;">Code</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="discount" items="${category.discounts}" varStatus="iter">
	<tr>
		<th>${iter.count}</th>
		<td>${1}		
		<td>${1}%
		<td>${1}
	</tr>
	</c:forEach>
</tbody>
</table>
