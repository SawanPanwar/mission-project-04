<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@page import="in.co.rays.proj4.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<div align="center">
			<h1>Login</h1>
			<table>
				<tr>
					<th>Login ID:</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>