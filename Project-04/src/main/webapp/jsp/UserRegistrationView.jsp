<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
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
	<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
			scope="request"></jsp:useBean>

		<div align="center">
			<h1>User Registration</h1>
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
				</tr>
				<tr>
					<th>Login ID:</th>
					<td><input type="text" name="login" value="hello"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>
				<tr>
					<th>Confirm:</th>
					<td><input type="text" name="confirmPassword"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob" style="width: 98%"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td>
						<%
							HashMap map = new HashMap();
							map.put("male", "male");
							map.put("female", "female");
						%> <%=HTMLUtility.getList("gender", "", map)%>
					</td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("gender", request)%></font></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><input type="text" name="mobileNo"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation"
						value="<%=UserRegistrationCtl.OP_SIGN_UP%>"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>