<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<H1>MENU</H1>
<p onClick="location.href = '${pageContext.request.contextPath}/'">Main page</p>
<p onClick="location.href = '${pageContext.request.contextPath}/login'">Log in</p>
<p onClick="location.href = '${pageContext.request.contextPath}/registration'">Registration</p>
<H1>USER</H1>
<p onClick="location.href = '${pageContext.request.contextPath}/user'">User page</p>
<p onClick="location.href = '${pageContext.request.contextPath}/user/codes'" >My codes</p>
<p onClick="location.href = '${pageContext.request.contextPath}/user/profile'" >My profile</p>
<H1>MODERATOR</H1>
<p onClick="location.href = '${pageContext.request.contextPath}/moder'">Moderator page</p>
<H1>ADMINISTRATOR</H1>
<p onClick="location.href = '${pageContext.request.contextPath}/admin'">Admin page</p>
<p onClick="location.href = '${pageContext.request.contextPath}/admin/users'">Users list</p>