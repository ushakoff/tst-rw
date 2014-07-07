<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>Edit category "${category.name}"</h1>
<p><form:form commandName="category" action="${pageContext.request.contextPath}/moder/categories/${category.id}" method="POST" >
	<form:hidden path="id"/>
	<h3>New name: <form:input size="40" maxlength="40" path="name" /></h3>
	<p><form:errors style="color: #1c9737;" path="name"/>
	<p><input class="sbmt" type="submit" value="OK" />
	<input class="sbmt" type="button" value="Cancel"
			onclick="window.location='${pageContext.request.contextPath}/moder/categories'" />
</form:form>
<p><table class="table1">
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
		<td><p class="lnk" onClick="location.href = '${pageContext.request.contextPath}/moder/discounts/${discount.id}'">${discount.name}
		<td>${discount.percent}%
		<td><p><a href="${pageContext.request.contextPath}/moder/discounts/${discount.id}">Edit</a>
			<p><a href="${pageContext.request.contextPath}/moder/discounts/delete/${discount.id}">Delete</a>
	</tr>
	</c:forEach>
</tbody>
</table>