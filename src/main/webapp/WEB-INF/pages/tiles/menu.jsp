<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<H1>MENU</H1>
<p onClick="location.href = '${pageContext.request.contextPath}/'">Discounts</p>
<p onClick="location.href = '${pageContext.request.contextPath}/categories'">Categories</p>
<sec:authorize access="isAnonymous()">
	<p onClick="location.href = '${pageContext.request.contextPath}/login'">Log In</p>
	<p onClick="location.href = '${pageContext.request.contextPath}/registration'">Registration</p>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
	<H1>USER MENU</H1>
	<p onClick="location.href = '${pageContext.request.contextPath}/user'">User page</p>
	<p onClick="location.href = '${pageContext.request.contextPath}/user/codes'" >My codes</p>
	<p onClick="location.href = '${pageContext.request.contextPath}/user/profile'" >My profile</p>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_MODERATOR')">
	<H1>MODERATOR</H1>
	<p onClick="location.href = '${pageContext.request.contextPath}/moder'">Moderator page</p>
	<p onClick="location.href = '${pageContext.request.contextPath}/moder/discounts'">Discounts list</p>
	<p onClick="location.href = '${pageContext.request.contextPath}/moder/categories'">Categories list</p>	
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<H1>ADMINISTRATOR</H1>
	<p onClick="location.href = '${pageContext.request.contextPath}/admin'">Admin page</p>
	<p onClick="location.href = '${pageContext.request.contextPath}/admin/users'">Users list</p>
</sec:authorize>