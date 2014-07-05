<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/pass.js"></script>
<form:form class="login" commandName="user"	action="${pageContext.request.contextPath}/registration" method="POST">
	<p style="font-size:35px;margin:0;color:yellow">Registration:
	<p><form:input type="text" class="inpt" path="login" maxlength="40" placeholder="Login" id="log1"/>
	<p class="acb">${message}</p>
	<p class="acb"><form:errors path='login'/>
	<p><form:input type="password" class="inpt" path="password" maxlength="40" placeholder="Password"
			id="pass1" onKeyUp="isEqual('pass1','pass2','checkpass', 'regist')" />
	<p class="acb"><form:errors path='password'/>
	<p><input type="password" class="inpt" maxlength="40" placeholder="Confirm password"
			id="pass2" onKeyUp="isEqual('pass1','pass2','checkpass', 'regist')" />	
	<p style="float: left;margin:0 0 0 10px;color:#ff0;font-weight:bold"><span id="checkpass">* Fill all the fields.</span>
	<p class="ar" style="margin:16px 8px 0 0;color:#bbb;"><input class="sbmt" id="regist" type="submit" value="OK" />	
</form:form>
