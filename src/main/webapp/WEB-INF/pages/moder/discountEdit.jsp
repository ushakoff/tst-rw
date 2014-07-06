<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>Edit discount</h1>
<p><form:form commandName="discount" action="${pageContext.request.contextPath}/moder/discounts/${discount.id}" method="POST" >
	<form:hidden path="id"/>
	<form:hidden path="category.id"/>
	<form:hidden path="detail.id"/>
	<table class="table1">
		<tr>
			<th scope="row">Discount:</th>
  			<td><p><form:input size="40" maxlength="40" path="name" />
				<p><form:errors style="color: #1c9737;" path="name"/>
		<tr>
			<th scope="row">Save, %:</th>
			<td><p><form:input size="40" maxlength="40" path="percent" />
				<p><form:errors style="color: #1c9737;" path="percent"/>
		<tr>
			<th scope="row">Info</th>
			<td><form:textarea path="detail.info" rows="10" cols="60" />
		<tr>
			<th scope="row">Site:</th>
			<td><form:input size="40" maxlength="40" path="detail.site" />
		<tr>
			<th scope="row">Action</th>
			<td><input class="sbmt" type="submit" value="OK" />
			<input class="sbmt" type="button" value="Cancel"
				onclick="window.location='${pageContext.request.contextPath}/moder/discounts'" />
	</table>
</form:form>