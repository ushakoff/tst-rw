<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="ha">
	<table>
		<tr>
			<td>
				<c:choose>
  					<c:when test="${pageContext.request.userPrincipal.name == null}">
  						<form action="<c:url value="/j_spring_security_check"/>" method="POST" >
							Login:<input type="text" name="j_username" id="j_username" size="15" maxlength="40" required/>
							Password:<input type="password" name="j_password" id="j_password" size="15" maxlength="40" required/>
							<input type="submit" value="Login" />
						</form>	
					</c:when>
					<c:otherwise>
						<p>Welcome, ${pageContext.request.userPrincipal.name}.
							(<a href="${pageContext.request.contextPath}/user/profile" >Profile</a>
							<a href="<c:url value="/j_spring_security_logout" />" >Logout</a>)
  					</c:otherwise>
				</c:choose>
	</table>
</div>