<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form class="login" action="<c:url value="j_spring_security_check"/>" method="POST">
	<p style="font-size:35px;margin:0;color:yellow">Please log in:
	<p><input type="text" class="inpt" name="j_username" id="j_username" maxlength="40" placeholder="Login" required>
	<p><input type="password" class="inpt" name="j_password" id="j_password" maxlength="40" placeholder="Password" required>
	<p style="float: left;margin:7px 0 0 5px;color:#ff0;font-weight:bold">
	<c:if test="${error == true}">* Invalid login or password</c:if>	
	<p class="ar" style="margin:16px 5px 0 0;"><input class="sbmt" type="submit" value="OK" />
</form>