<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Admin page</h1>
<p><a href="${pageContext.request.contextPath}/admin/users">Users list</a>
<p><a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
<p><a href="${pageContext.request.contextPath}/">Main page</a>