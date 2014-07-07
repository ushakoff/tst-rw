<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>My codes</h1>
<table class="table1">
	<thead>
	<tr>
		<th style="min-width:40px;">#</th>
		<th style="min-width:150px;">Code</th>
		<th style="min-width:250px;">Discount</th>
		<th style="min-width:100px;">Save</th>
		<th style="min-width:100px;">Action</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="discCode" items="${discCodes}" varStatus="iter">
	<tr>
		<th>${iter.count}</th>
		<td>${discCode.code}		
		<td><p class="lnk" onClick="location.href = '${pageContext.request.contextPath}/discounts/${discCode.discount.id}'">${discCode.discount.name}
		<td>${discCode.discount.percent}%
		<td><a href="${pageContext.request.contextPath}/user/codes/delete/${discCode.id}">Delete</a>
	</tr>
	</c:forEach>
</tbody>
</table>
