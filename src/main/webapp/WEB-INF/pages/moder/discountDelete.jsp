<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form commandName="discount" action="${pageContext.request.contextPath}/moder/discounts/delete/${discount.id}" method="POST" >
	<h1>Delete discount "${discount.name}"</h1>
		<h3>Are you sure you want to delete this discount?</h3>
		<form:hidden path="id"/>
		<p><input class="sbmt" type="submit" value="Yes" />
		<input class="sbmt" type="button" value="Cancel"
			onclick="window.location='${pageContext.request.contextPath}/moder/discounts'" />					
</form:form>