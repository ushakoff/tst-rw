<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/icon.png" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css" >
	<title><tiles:insertAttribute name="title" ignore="true" /></title>	
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="authorize" />
	<div id="hc">
		<table id="hct">
			<tr>
        		<td id="hcm">
					<tiles:insertAttribute name="menu" />
        		<td id="hcb">
					<tiles:insertAttribute name="body" />
		</table>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>